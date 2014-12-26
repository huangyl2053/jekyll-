var DBD;
(function (DBD) {
    (function (HomonkaigoRiyoshaFutangakuGengaku) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HomonkaigoRiyoshaFutangakuGengaku.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        HomonkaigoRiyoshaFutangakuGengaku.ModeController = ModeController;
    })(DBD.HomonkaigoRiyoshaFutangakuGengaku || (DBD.HomonkaigoRiyoshaFutangakuGengaku = {}));
    var HomonkaigoRiyoshaFutangakuGengaku = DBD.HomonkaigoRiyoshaFutangakuGengaku;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (HomonkaigoRiyoshaFutangakuGengaku) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new HomonkaigoRiyoshaFutangakuGengaku.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        HomonkaigoRiyoshaFutangakuGengaku.PublicProperties = PublicProperties;
    })(DBD.HomonkaigoRiyoshaFutangakuGengaku || (DBD.HomonkaigoRiyoshaFutangakuGengaku = {}));
    var HomonkaigoRiyoshaFutangakuGengaku = DBD.HomonkaigoRiyoshaFutangakuGengaku;
})(DBD || (DBD = {}));
