var DBE;
(function (DBE) {
    (function (ChosaKekkaInfoGaikyo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaKekkaInfoGaikyo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ChosaKekkaInfoGaikyo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ChosaKekkaInfoGaikyo.ModeController = ModeController;
    })(DBE.ChosaKekkaInfoGaikyo || (DBE.ChosaKekkaInfoGaikyo = {}));
    var ChosaKekkaInfoGaikyo = DBE.ChosaKekkaInfoGaikyo;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (ChosaKekkaInfoGaikyo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaKekkaInfoGaikyo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ChosaKekkaInfoGaikyo.PublicProperties = PublicProperties;
    })(DBE.ChosaKekkaInfoGaikyo || (DBE.ChosaKekkaInfoGaikyo = {}));
    var ChosaKekkaInfoGaikyo = DBE.ChosaKekkaInfoGaikyo;
})(DBE || (DBE = {}));
