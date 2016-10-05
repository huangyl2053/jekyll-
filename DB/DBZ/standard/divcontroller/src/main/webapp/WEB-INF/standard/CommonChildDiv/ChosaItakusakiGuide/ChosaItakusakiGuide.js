var DBZ;
(function (DBZ) {
    (function (ChosaItakusakiGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaItakusakiGuide.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ChosaItakusakiGuide.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ChosaItakusakiGuide.ModeController = ModeController;
    })(DBZ.ChosaItakusakiGuide || (DBZ.ChosaItakusakiGuide = {}));
    var ChosaItakusakiGuide = DBZ.ChosaItakusakiGuide;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ChosaItakusakiGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaItakusakiGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ChosaItakusakiGuide.PublicProperties = PublicProperties;
    })(DBZ.ChosaItakusakiGuide || (DBZ.ChosaItakusakiGuide = {}));
    var ChosaItakusakiGuide = DBZ.ChosaItakusakiGuide;
})(DBZ || (DBZ = {}));
