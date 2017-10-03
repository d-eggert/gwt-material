/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package gwt.material.design.client.ui;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.constants.CssName;
import gwt.material.design.client.ui.base.MaterialWidgetTest;
import gwt.material.design.client.ui.html.ListItem;

/**
 * Test case for Sidenav.
 *
 * @author kevzlou7979
 * @author Ben Dol
 */
public class MaterialSideNavTest extends MaterialWidgetTest<MaterialSideNav> {

    final static String ACTIVATES = "sideNav";

    private MaterialNavBar navBar;

    @Override
    protected MaterialSideNav createWidget() {
        MaterialSideNav sideNav = new MaterialSideNav();
        navBar = new MaterialNavBar();
        navBar.setActivates(ACTIVATES);
        sideNav.setId(ACTIVATES);
        sideNav.setWidth("300");
        assertNotNull(navBar.getNavMenu());
        assertEquals(ACTIVATES, navBar.getNavMenu().getElement().getAttribute("data-activates"));
        assertEquals(sideNav.getId(), navBar.getNavMenu().getElement().getAttribute("data-activates"));
        assertEquals(sideNav.getId(), navBar.getActivates());
        assertEquals(ACTIVATES, navBar.getActivates());
        assertEquals(300, sideNav.getWidth());
        // Attach the nav bar
        RootPanel.get().add(navBar);
        assertTrue(navBar.isAttached());
        return sideNav;
    }

    @Override
    protected void gwtTearDown() throws Exception {
        super.gwtTearDown();

        navBar = null;
    }

    @Override
    public void testInitialClasses() {
        checkInitialClasses(CssName.SIDE_NAV);
    }

    public void testContent() {
        // given
        MaterialSideNav sideNav = getWidget();

        // when / then
        assertEquals(0, sideNav.getChildren().size());
        MaterialSideNavContent content = new MaterialSideNavContent();
        sideNav.add(content);
        assertEquals(1, sideNav.getChildren().size());
        assertEquals(content, sideNav.getWidget(0));
    }

    public void testDuration() {
        // given
        MaterialSideNav sideNav = getWidget(false);

        final int IN_DURATION = 500;
        final int OUT_DURATION = 800;

        // when / then
        // Check the default in duration (Expected 300ms)
        assertEquals(400, sideNav.getInDuration());
        // Check the default out duration (Expected 200ms)
        assertEquals(200, sideNav.getOutDuration());

        sideNav.setInDuration(IN_DURATION);
        assertEquals(IN_DURATION, sideNav.getInDuration());
        sideNav.setOutDuration(OUT_DURATION);
        assertEquals(OUT_DURATION, sideNav.getOutDuration());
    }

    public void testActivator() {
        // given
        MaterialSideNav sideNav = getWidget();

        // when / then
        assertEquals(ACTIVATES, sideNav.getId());

        // Check Nav Menu
        assertNotNull(navBar.getNavMenu());
        final Element navMenuElement = navBar.getNavMenu().getElement();

        // isAlwaysShowActivator() must be true by default
        assertTrue(sideNav.isAlwaysShowActivator());
    }

    // TODO: Add our own tests for these other types
    public void testOtherTypes() {
        /*MaterialSideNavCard sideNavCard = new MaterialSideNavCard();
        checkSideNav(sideNavCard);
        assertTrue(sideNavCard.getStyleName().contains(SideNavType.CARD.getCssName()));

        MaterialSideNavDrawer sideNavDrawer = new MaterialSideNavDrawer();
        checkSideNav(sideNavDrawer);
        assertTrue(sideNavDrawer.getStyleName().contains(SideNavType.DRAWER.getCssName()));
        sideNavDrawer.setWithHeader(true);
        assertTrue(sideNavDrawer.isWithHeader());

        MaterialSideNavMini sideNavMini = new MaterialSideNavMini();
        checkSideNav(sideNavMini);
        assertTrue(sideNavMini.getStyleName().contains(SideNavType.MINI.getCssName()));
        sideNavMini.setExpandable(true);
        assertTrue(sideNavMini.isExpandable());
        sideNavMini.setExpandOnClick(true);
        assertTrue(sideNavMini.isExpandOnClick());

        MaterialSideNavPush sideNavPush = new MaterialSideNavPush();
        checkSideNav(sideNavPush);
        assertTrue(sideNavPush.getStyleName().contains(SideNavType.PUSH.getCssName()));
        sideNavPush.setWithHeader(true);
        assertTrue(sideNavPush.isWithHeader());*/
    }

    public void testBoolean() {
        // given
        MaterialSideNav sideNav = getWidget();

        // when / then
        sideNav.setCloseOnClick(true);
        assertTrue(sideNav.isCloseOnClick());
        sideNav.setCloseOnClick(false);
        assertFalse(sideNav.isCloseOnClick());
        sideNav.setAlwaysShowActivator(true);
        assertFalse(navBar.getNavMenu().getElement().hasClassName(CssName.NAVMENU_PERMANENT));
        assertTrue(sideNav.isAlwaysShowActivator());
        sideNav.setAlwaysShowActivator(false);
        assertFalse(sideNav.isAlwaysShowActivator());
        sideNav.setAllowBodyScroll(true);
        assertTrue(sideNav.isAllowBodyScroll());
        sideNav.setAllowBodyScroll(false);
        assertFalse(sideNav.isAllowBodyScroll());
        sideNav.setShowOnAttach(true);
        assertTrue(sideNav.isShowOnAttach());
        sideNav.setShowOnAttach(false);
        assertFalse(sideNav.isShowOnAttach());
    }

    public void testSideNavItems() {
        // given
        MaterialSideNav sideNav = getWidget();

        // when / then
        for (int i = 1; i <= 5; i++) {
            sideNav.add(new MaterialLink("Item " + i));
        }
        assertTrue(sideNav.getChildren().size() == 5);

        // Check if sidenav adds ListItem as parent widget of it's items
        for (Widget w : sideNav.getChildren()) {
            assertNotNull(w);
            assertTrue(w instanceof ListItem);
            ListItem item = (ListItem) w;
            assertTrue(item.getWidget(0) instanceof MaterialLink);
        }

        // Check active links
        ListItem link = (ListItem) sideNav.getWidget(0);
        link.addStyleName(CssName.ACTIVE);
        assertTrue(link.getElement().hasClassName(CssName.ACTIVE));

        // Clear all active side nav items
        sideNav.clearActive();
        assertFalse(link.getElement().hasClassName(CssName.ACTIVE));

        // Check Nested Sidenav items using Collapsible Component
        MaterialCollapsible collapsible = new MaterialCollapsible();
        MaterialCollapsibleItem item = new MaterialCollapsibleItem();
        MaterialCollapsibleHeader header = new MaterialCollapsibleHeader();
        MaterialLink parentLink = new MaterialLink("Parent");
        header.add(parentLink);

        MaterialCollapsibleBody body = new MaterialCollapsibleBody();
        for (int i = 1; i <= 5; i++) {
            body.add(new MaterialLink("SubItem " + i));
        }

        item.add(header);
        item.add(body);
        collapsible.add(item);
        sideNav.add(collapsible);

        assertNotNull(item);
        assertNotNull(collapsible);
        assertNotNull(header);
        assertNotNull(parentLink);
        assertNotNull(body);
        assertEquals(5, body.getChildren().size());
        assertTrue(sideNav.getChildren().get(5) instanceof MaterialCollapsible);
    }
}
