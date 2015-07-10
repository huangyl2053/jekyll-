var DBZ;
(function (DBZ) {
    (function (HokenshaJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HokenshaJoho.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new HokenshaJoho.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        HokenshaJoho.ModeController = ModeController;
    })(DBZ.HokenshaJoho || (DBZ.HokenshaJoho = {}));
    var HokenshaJoho = DBZ.HokenshaJoho;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (HokenshaJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new HokenshaJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        HokenshaJoho.PublicProperties = PublicProperties;
    })(DBZ.HokenshaJoho || (DBZ.HokenshaJoho = {}));
    var HokenshaJoho = DBZ.HokenshaJoho;
})(DBZ || (DBZ = {}));
