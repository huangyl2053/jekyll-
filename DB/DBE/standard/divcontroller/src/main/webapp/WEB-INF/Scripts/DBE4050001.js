/// <reference path="../../../../NetBeansProjects/DB/DB/DBE/standard/d.ts/jquery.d.ts" />
/// <reference path="../../../../NetBeansProjects/DB/DB/DBE/standard/d.ts/UzViewControls.d.ts" />
/// <reference path="imageDisp.d.ts" />
var Dbe;
(function (Dbe) {
    var DBE4050001 = (function () {
        function DBE4050001() {
        }
        DBE4050001.setImageViewers = function () {
            DBE4050001.setImageViewer("ImageFrontOfIkensho", "/db/dbe/Scripts/E0001.png");
        };

        DBE4050001.setImageViewer = function (controlId, imageUrl) {
            var imageDispJSON = {};

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
        };

        DBE4050001.getPanelBodyAreaDiv = function (panel) {
            return panel.getJQueryElement().attr("id") + DBE4050001.BODY_AREA_PREFIX;
        };
        DBE4050001.BODY_AREA_PREFIX = "_panel_body_area";
        return DBE4050001;
    })();
    Dbe.DBE4050001 = DBE4050001;
})(Dbe || (Dbe = {}));

// グローバル領域ではstaticメソッドを1度呼ぶだけにする
Dbe.DBE4050001.setImageViewers();
//@ sourceMappingURL=DBE4050001.js.map
