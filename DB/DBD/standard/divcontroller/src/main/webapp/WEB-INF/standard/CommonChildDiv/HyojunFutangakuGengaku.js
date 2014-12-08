var DBD;
(function (DBD) {
    (function (HyojunFutangakuGengaku) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HyojunFutangakuGengaku.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        HyojunFutangakuGengaku.ModeController = ModeController;
    })(DBD.HyojunFutangakuGengaku || (DBD.HyojunFutangakuGengaku = {}));
    var HyojunFutangakuGengaku = DBD.HyojunFutangakuGengaku;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (HyojunFutangakuGengaku) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new HyojunFutangakuGengaku.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        HyojunFutangakuGengaku.PublicProperties = PublicProperties;
    })(DBD.HyojunFutangakuGengaku || (DBD.HyojunFutangakuGengaku = {}));
    var HyojunFutangakuGengaku = DBD.HyojunFutangakuGengaku;
})(DBD || (DBD = {}));
