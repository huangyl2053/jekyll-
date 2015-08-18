var DBB;
(function (DBB) {
    (function (FukaRirekiAll) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new FukaRirekiAll.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new FukaRirekiAll.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        FukaRirekiAll.ModeController = ModeController;
    })(DBB.FukaRirekiAll || (DBB.FukaRirekiAll = {}));
    var FukaRirekiAll = DBB.FukaRirekiAll;
})(DBB || (DBB = {}));

var DBB;
(function (DBB) {
    (function (FukaRirekiAll) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new FukaRirekiAll.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        FukaRirekiAll.PublicProperties = PublicProperties;
    })(DBB.FukaRirekiAll || (DBB.FukaRirekiAll = {}));
    var FukaRirekiAll = DBB.FukaRirekiAll;
})(DBB || (DBB = {}));
