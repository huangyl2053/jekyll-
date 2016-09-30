var DBC;
(function (DBC) {
    (function (KokuhorenJohoSofu) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KokuhorenJohoSofu.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KokuhorenJohoSofu.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KokuhorenJohoSofu.ModeController = ModeController;
    })(DBC.KokuhorenJohoSofu || (DBC.KokuhorenJohoSofu = {}));
    var KokuhorenJohoSofu = DBC.KokuhorenJohoSofu;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (KokuhorenJohoSofu) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KokuhorenJohoSofu.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KokuhorenJohoSofu.PublicProperties = PublicProperties;
    })(DBC.KokuhorenJohoSofu || (DBC.KokuhorenJohoSofu = {}));
    var KokuhorenJohoSofu = DBC.KokuhorenJohoSofu;
})(DBC || (DBC = {}));
