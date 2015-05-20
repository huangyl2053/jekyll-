var DBD;
(function (DBD) {
    (function (ChosaItakusakiAndChosainInput) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaItakusakiAndChosainInput.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ChosaItakusakiAndChosainInput.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ChosaItakusakiAndChosainInput.ModeController = ModeController;
    })(DBD.ChosaItakusakiAndChosainInput || (DBD.ChosaItakusakiAndChosainInput = {}));
    var ChosaItakusakiAndChosainInput = DBD.ChosaItakusakiAndChosainInput;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (ChosaItakusakiAndChosainInput) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaItakusakiAndChosainInput.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ChosaItakusakiAndChosainInput.PublicProperties = PublicProperties;
    })(DBD.ChosaItakusakiAndChosainInput || (DBD.ChosaItakusakiAndChosainInput = {}));
    var ChosaItakusakiAndChosainInput = DBD.ChosaItakusakiAndChosainInput;
})(DBD || (DBD = {}));
