var DBZ;
(function (DBZ) {
    (function (ServiceInputGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceInputGuide.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ServiceInputGuide.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ServiceInputGuide.ModeController = ModeController;
    })(DBZ.ServiceInputGuide || (DBZ.ServiceInputGuide = {}));
    var ServiceInputGuide = DBZ.ServiceInputGuide;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ServiceInputGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ServiceInputGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ServiceInputGuide.PublicProperties = PublicProperties;
    })(DBZ.ServiceInputGuide || (DBZ.ServiceInputGuide = {}));
    var ServiceInputGuide = DBZ.ServiceInputGuide;
})(DBZ || (DBZ = {}));
