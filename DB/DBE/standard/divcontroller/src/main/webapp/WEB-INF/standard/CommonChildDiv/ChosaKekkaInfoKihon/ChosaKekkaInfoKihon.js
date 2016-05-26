var DBE;
(function (DBE) {
    (function (ChosaKekkaInfoKihon) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaKekkaInfoKihon.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ChosaKekkaInfoKihon.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ChosaKekkaInfoKihon.ModeController = ModeController;
    })(DBE.ChosaKekkaInfoKihon || (DBE.ChosaKekkaInfoKihon = {}));
    var ChosaKekkaInfoKihon = DBE.ChosaKekkaInfoKihon;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (ChosaKekkaInfoKihon) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaKekkaInfoKihon.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ChosaKekkaInfoKihon.PublicProperties = PublicProperties;
    })(DBE.ChosaKekkaInfoKihon || (DBE.ChosaKekkaInfoKihon = {}));
    var ChosaKekkaInfoKihon = DBE.ChosaKekkaInfoKihon;
})(DBE || (DBE = {}));
