var DBD;
(function (DBD) {
    (function (GemmenGengakuShinsei) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new GemmenGengakuShinsei.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new GemmenGengakuShinsei.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        GemmenGengakuShinsei.ModeController = ModeController;
    })(DBD.GemmenGengakuShinsei || (DBD.GemmenGengakuShinsei = {}));
    var GemmenGengakuShinsei = DBD.GemmenGengakuShinsei;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (GemmenGengakuShinsei) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new GemmenGengakuShinsei.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        GemmenGengakuShinsei.PublicProperties = PublicProperties;
    })(DBD.GemmenGengakuShinsei || (DBD.GemmenGengakuShinsei = {}));
    var GemmenGengakuShinsei = DBD.GemmenGengakuShinsei;
})(DBD || (DBD = {}));
