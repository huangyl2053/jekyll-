var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBE;
(function (DBE) {
    (function (ImageMasking) {
        var ImageMasking = (function (_super) {
            __extends(ImageMasking, _super);
            function ImageMasking() {
                _super.apply(this, arguments);
            }
            ImageMasking.prototype.renderCompleted = function () {
                if (!Uz.GyomuJSHelper.isDesignMode()) {
                    var viewerPanel = this.getJQueryElement();
                    window["initMasking"](viewerPanel.attr("id") + "_ImageMasking_panel_body_area", "/db/dbe/Scripts/E0001.png");
                }
            };
            return ImageMasking;
        })(DBE.ImageMasking_Design);
        ImageMasking.ImageMasking = ImageMasking;
    })(DBE.ImageMasking || (DBE.ImageMasking = {}));
    var ImageMasking = DBE.ImageMasking;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (ImageMasking) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ImageMasking.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ImageMasking.PublicProperties = PublicProperties;
    })(DBE.ImageMasking || (DBE.ImageMasking = {}));
    var ImageMasking = DBE.ImageMasking;
})(DBE || (DBE = {}));
