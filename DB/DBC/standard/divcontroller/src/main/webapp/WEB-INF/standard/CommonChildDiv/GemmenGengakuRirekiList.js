var DBC;
(function (DBC) {
    (function (GemmenGengakuRirekiList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new GemmenGengakuRirekiList.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new GemmenGengakuRirekiList.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        GemmenGengakuRirekiList.ModeController = ModeController;
    })(DBC.GemmenGengakuRirekiList || (DBC.GemmenGengakuRirekiList = {}));
    var GemmenGengakuRirekiList = DBC.GemmenGengakuRirekiList;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (GemmenGengakuRirekiList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new GemmenGengakuRirekiList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        GemmenGengakuRirekiList.PublicProperties = PublicProperties;
    })(DBC.GemmenGengakuRirekiList || (DBC.GemmenGengakuRirekiList = {}));
    var GemmenGengakuRirekiList = DBC.GemmenGengakuRirekiList;
})(DBC || (DBC = {}));
