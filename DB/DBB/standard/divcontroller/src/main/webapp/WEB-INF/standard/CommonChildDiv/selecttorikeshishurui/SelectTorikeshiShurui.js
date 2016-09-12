var DBB;
(function (DBB) {
    (function (SelectTorikeshiShurui) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SelectTorikeshiShurui.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SelectTorikeshiShurui.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SelectTorikeshiShurui.ModeController = ModeController;
    })(DBB.SelectTorikeshiShurui || (DBB.SelectTorikeshiShurui = {}));
    var SelectTorikeshiShurui = DBB.SelectTorikeshiShurui;
})(DBB || (DBB = {}));

var DBB;
(function (DBB) {
    (function (SelectTorikeshiShurui) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SelectTorikeshiShurui.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SelectTorikeshiShurui.PublicProperties = PublicProperties;
    })(DBB.SelectTorikeshiShurui || (DBB.SelectTorikeshiShurui = {}));
    var SelectTorikeshiShurui = DBB.SelectTorikeshiShurui;
})(DBB || (DBB = {}));
