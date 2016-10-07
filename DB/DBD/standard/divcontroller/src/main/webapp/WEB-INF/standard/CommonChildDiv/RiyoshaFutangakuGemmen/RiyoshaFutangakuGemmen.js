var DBD;
(function (DBD) {
    (function (RiyoshaFutangakuGemmen) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new RiyoshaFutangakuGemmen.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new RiyoshaFutangakuGemmen.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        RiyoshaFutangakuGemmen.ModeController = ModeController;
    })(DBD.RiyoshaFutangakuGemmen || (DBD.RiyoshaFutangakuGemmen = {}));
    var RiyoshaFutangakuGemmen = DBD.RiyoshaFutangakuGemmen;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (RiyoshaFutangakuGemmen) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new RiyoshaFutangakuGemmen.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        RiyoshaFutangakuGemmen.PublicProperties = PublicProperties;
    })(DBD.RiyoshaFutangakuGemmen || (DBD.RiyoshaFutangakuGemmen = {}));
    var RiyoshaFutangakuGemmen = DBD.RiyoshaFutangakuGemmen;
})(DBD || (DBD = {}));
