var DBE;
(function (DBE) {
    (function (ChosaItakusakiSelector) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaItakusakiSelector.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ChosaItakusakiSelector.ModeController = ModeController;
    })(DBE.ChosaItakusakiSelector || (DBE.ChosaItakusakiSelector = {}));
    var ChosaItakusakiSelector = DBE.ChosaItakusakiSelector;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (ChosaItakusakiSelector) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ChosaItakusakiSelector.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ChosaItakusakiSelector.PublicProperties = PublicProperties;
    })(DBE.ChosaItakusakiSelector || (DBE.ChosaItakusakiSelector = {}));
    var ChosaItakusakiSelector = DBE.ChosaItakusakiSelector;
})(DBE || (DBE = {}));
