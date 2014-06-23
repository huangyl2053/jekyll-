/// <reference path='ImageMasking_Design.ts' />
/// <reference path='../d.ts/UzViewControls.d.ts' />
/// <reference path='../d.ts/jquery.d.ts' />
module DBE {
    export class ImageMasking extends ImageMasking_Design {
        public renderCompleted() {
            if (!Uz.GyomuJSHelper.isDesignMode()) {
                var viewerPanel = this.getJQueryElement();
                window["initMasking"](viewerPanel.attr("id") + "_ImageMasking_panel_body_area", "/db/dbe/Scripts/E0001.png");
            }
        }
    }
}

