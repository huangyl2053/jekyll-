/// <reference path="../../../../NetBeansProjects/DB/DB/DBE/standard/d.ts/jquery.d.ts" />
/// <reference path="../../../../NetBeansProjects/DB/DB/DBE/standard/d.ts/UzViewControls.d.ts" />
/// <reference path="imageDisp.d.ts" />

module Dbe {
    export class DBE4050001 {

        private static BODY_AREA_PREFIX: string = "_panel_body_area";

        public static setImageViewers() {
            DBE4050001.setImageViewer("ImageFrontOfIkensho", "/db/dbe/Scripts/E0001.png");
        }

        public static setImageViewer(controlId: string, imageUrl: string) {

            var imageDispJSON = {}

            if (!Uz.GyomuJSHelper.isDesignMode()) {
                    var viewerPanel = Uz.GyomuJSHelper.getJSControl(controlId);
                    var panelId = DBE4050001.getPanelBodyAreaDiv(viewerPanel);
                    imageDisp.INIT = new imageDispCommon.init();
                    imageDisp.RESIZE = new imageDispCommon.draw();
                    imageDisp.MARKER = new imageDispCommon.marker();
                    imageDisp.STICKY = new imageDispCommon.sticky();
                    imageDisp.ONLY = new imageDispCommon.only();
                    imageDisp.JSON = new imageDispCommon.rectJson();
                    imageDisp.INIT.initImageDisp(panelId, imageUrl, imageDispJSON, 100, 1020, 500, 0, 0);
            }
        }

        private static getPanelBodyAreaDiv(panel: Uz._JSControl): string {
            return panel.getJQueryElement().attr("id") + DBE4050001.BODY_AREA_PREFIX;
        }
    }
}

// グローバル領域ではstaticメソッドを1度呼ぶだけにする
Dbe.DBE4050001.setImageViewers();
