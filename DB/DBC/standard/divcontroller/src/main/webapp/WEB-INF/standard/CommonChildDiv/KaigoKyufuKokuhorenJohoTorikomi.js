var DBC;
(function (DBC) {
    (function (KaigoKyufuKokuhorenJohoTorikomi) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoKyufuKokuhorenJohoTorikomi.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoKyufuKokuhorenJohoTorikomi.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoKyufuKokuhorenJohoTorikomi.ModeController = ModeController;
    })(DBC.KaigoKyufuKokuhorenJohoTorikomi || (DBC.KaigoKyufuKokuhorenJohoTorikomi = {}));
    var KaigoKyufuKokuhorenJohoTorikomi = DBC.KaigoKyufuKokuhorenJohoTorikomi;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (KaigoKyufuKokuhorenJohoTorikomi) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoKyufuKokuhorenJohoTorikomi.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoKyufuKokuhorenJohoTorikomi.PublicProperties = PublicProperties;
    })(DBC.KaigoKyufuKokuhorenJohoTorikomi || (DBC.KaigoKyufuKokuhorenJohoTorikomi = {}));
    var KaigoKyufuKokuhorenJohoTorikomi = DBC.KaigoKyufuKokuhorenJohoTorikomi;
})(DBC || (DBC = {}));
