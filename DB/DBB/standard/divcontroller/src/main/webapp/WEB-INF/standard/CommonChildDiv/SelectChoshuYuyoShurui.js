var DBB;
(function (DBB) {
    (function (SelectChoshuYuyoShurui) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SelectChoshuYuyoShurui.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SelectChoshuYuyoShurui.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SelectChoshuYuyoShurui.ModeController = ModeController;
    })(DBB.SelectChoshuYuyoShurui || (DBB.SelectChoshuYuyoShurui = {}));
    var SelectChoshuYuyoShurui = DBB.SelectChoshuYuyoShurui;
})(DBB || (DBB = {}));

var DBB;
(function (DBB) {
    (function (SelectChoshuYuyoShurui) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SelectChoshuYuyoShurui.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SelectChoshuYuyoShurui.PublicProperties = PublicProperties;
    })(DBB.SelectChoshuYuyoShurui || (DBB.SelectChoshuYuyoShurui = {}));
    var SelectChoshuYuyoShurui = DBB.SelectChoshuYuyoShurui;
})(DBB || (DBB = {}));
