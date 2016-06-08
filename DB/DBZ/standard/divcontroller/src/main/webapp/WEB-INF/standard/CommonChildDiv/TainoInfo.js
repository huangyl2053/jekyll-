var DBZ;
(function (DBZ) {
    (function (TainoInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TainoInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new TainoInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        TainoInfo.ModeController = ModeController;
    })(DBZ.TainoInfo || (DBZ.TainoInfo = {}));
    var TainoInfo = DBZ.TainoInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (TainoInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new TainoInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TainoInfo.PublicProperties = PublicProperties;
    })(DBZ.TainoInfo || (DBZ.TainoInfo = {}));
    var TainoInfo = DBZ.TainoInfo;
})(DBZ || (DBZ = {}));
