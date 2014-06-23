/// <reference path="../../../../NetBeansProjects/DB/DB/DBE/standard/d.ts/jquery.d.ts" />
/// <reference path="../../../../NetBeansProjects/DB/DB/DBE/standard/d.ts/UzViewControls.d.ts" />
/// <reference path="imageDisp.d.ts" />

module Dbe {
    export class DBE2070001 {

        private static BODY_AREA_PREFIX: string = "_panel_body_area";

        public static setImageViewers() {
            DBE2070001.setImageViewer("ImageIkensho1", "/db/dbe/Scripts/E0001.png");
            DBE2070001.setImageViewer("ImageIkensho2", "/db/dbe/Scripts/E0001.png");
        }

        public static setImageViewer(controlId: string, imageUrl: string) {

            var imageDispJSON = {
                //"txtFocus1": {
                //    "columnname": "意見書(表)",
                //    "start": {
                //        "x": 230,
                //        "y": 187
                //    },
                //    "end": {
                //        "x": 930,
                //        "y": 307
                //    },
                //    "stroke": "red"
                //}
            }

            if (!Uz.GyomuJSHelper.isDesignMode()) {
                var viewerPanel = Uz.GyomuJSHelper.getJSControl(controlId);
                var panelId = DBE2070001.getPanelBodyAreaDiv(viewerPanel);
                imageDisp.INIT = new imageDispCommon.init();
                imageDisp.RESIZE = new imageDispCommon.draw();
                imageDisp.MARKER = new imageDispCommon.marker();
                imageDisp.STICKY = new imageDispCommon.sticky();
                imageDisp.ONLY = new imageDispCommon.only();
                imageDisp.JSON = new imageDispCommon.rectJson();
                imageDisp.INIT.initImageDisp(panelId, imageUrl, imageDispJSON);
            }
        }

        private static getPanelBodyAreaDiv(panel: Uz._JSControl): string {
            return panel.getJQueryElement().attr("id") + DBE2070001.BODY_AREA_PREFIX;
        }
    }
}

// グローバル領域ではstaticメソッドを1度呼ぶだけにする
Dbe.DBE2070001.setImageViewers();
