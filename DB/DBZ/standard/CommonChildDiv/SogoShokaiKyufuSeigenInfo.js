var DBZ;
(function (DBZ) {
    (function (SogoShokaiKyufuSeigenInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiKyufuSeigenInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiKyufuSeigenInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiKyufuSeigenInfo || (DBZ.SogoShokaiKyufuSeigenInfo = {}));
    var SogoShokaiKyufuSeigenInfo = DBZ.SogoShokaiKyufuSeigenInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiKyufuSeigenInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiKyufuSeigenInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiKyufuSeigenInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiKyufuSeigenInfo || (DBZ.SogoShokaiKyufuSeigenInfo = {}));
    var SogoShokaiKyufuSeigenInfo = DBZ.SogoShokaiKyufuSeigenInfo;
})(DBZ || (DBZ = {}));
