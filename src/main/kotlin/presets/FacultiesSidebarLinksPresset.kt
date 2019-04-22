package presets

import core.actions.Click
import core.actions.GetUrl
import core.test.TestPreset
import test.creators.FacultiesDropdownLink
import test.creators.FacultiesSidebarLink

class FacultiesSidebarLinksPresset(dropdownLink: FacultiesDropdownLink, facultiesSidebarLink: FacultiesSidebarLink) : TestPreset() {
    init {
        this.addAction(GetUrl(dropdownLink.url))
        this.addAction(Click(facultiesSidebarLink.linkQuery))
    }
}
