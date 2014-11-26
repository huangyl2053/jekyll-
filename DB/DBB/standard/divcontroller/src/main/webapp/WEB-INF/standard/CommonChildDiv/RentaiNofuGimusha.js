var DBB;
(function (DBB) {
    (function (RentaiNofuGimusha) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new RentaiNofuGimusha.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        RentaiNofuGimusha.ModeController = ModeController;
    })(DBB.RentaiNofuGimusha || (DBB.RentaiNofuGimusha = {}));
    var RentaiNofuGimusha = DBB.RentaiNofuGimusha;
})(DBB || (DBB = {}));

var DBB;
(function (DBB) {
    (function (RentaiNofuGimusha) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new RentaiNofuGimusha.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        RentaiNofuGimusha.PublicProperties = PublicProperties;
    })(DBB.RentaiNofuGimusha || (DBB.RentaiNofuGimusha = {}));
    var RentaiNofuGimusha = DBB.RentaiNofuGimusha;
})(DBB || (DBB = {}));
