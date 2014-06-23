/// <reference path="../../../../NetBeansProjects/DB/DB/DBE/standard/d.ts/jquery.d.ts" />
/// <reference path="../../../../NetBeansProjects/DB/DB/DBE/standard/d.ts/UzViewControls.d.ts" />
/// <reference path="imageDisp.d.ts" />
var Dbe;
(function (Dbe) {
    var DBE2070001 = (function () {
        function DBE2070001() {
        }
        DBE2070001.setImageViewers = function () {
            DBE2070001.setImageViewer("ImageIkensho1", "/db/dbe/Scripts/E0001.png");
            DBE2070001.setImageViewer("ImageIkensho2", "/db/dbe/Scripts/E0001.png");
        };

        DBE2070001.setImageViewer = function (controlId, imageUrl) {
            var imageDispJSON = {};

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
        };

        DBE2070001.getPanelBodyAreaDiv = function (panel) {
            return panel.getJQueryElement().attr("id") + DBE2070001.BODY_AREA_PREFIX;
        };
        DBE2070001.BODY_AREA_PREFIX = "_panel_body_area";
        return DBE2070001;
    })();
    Dbe.DBE2070001 = DBE2070001;
})(Dbe || (Dbe = {}));

// �O���[�o���̈�ł�static���\�b�h��1�x�ĂԂ����ɂ���
Dbe.DBE2070001.setImageViewers();
//@ sourceMappingURL=DBE2070001.js.map
