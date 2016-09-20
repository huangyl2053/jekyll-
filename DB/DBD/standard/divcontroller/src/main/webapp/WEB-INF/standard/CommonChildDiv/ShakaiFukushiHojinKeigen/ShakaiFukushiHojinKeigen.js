var DBD;
(function (DBD) {
    (function (ShakaiFukushiHojinKeigen) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShakaiFukushiHojinKeigen.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShakaiFukushiHojinKeigen.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShakaiFukushiHojinKeigen.ModeController = ModeController;
    })(DBD.ShakaiFukushiHojinKeigen || (DBD.ShakaiFukushiHojinKeigen = {}));
    var ShakaiFukushiHojinKeigen = DBD.ShakaiFukushiHojinKeigen;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (ShakaiFukushiHojinKeigen) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShakaiFukushiHojinKeigen.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShakaiFukushiHojinKeigen.PublicProperties = PublicProperties;
    })(DBD.ShakaiFukushiHojinKeigen || (DBD.ShakaiFukushiHojinKeigen = {}));
    var ShakaiFukushiHojinKeigen = DBD.ShakaiFukushiHojinKeigen;
})(DBD || (DBD = {}));
