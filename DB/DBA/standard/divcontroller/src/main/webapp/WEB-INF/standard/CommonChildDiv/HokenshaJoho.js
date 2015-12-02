var DBA;
(function (DBA) {
    (function (HokenshaJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HokenshaJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new HokenshaJoho.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        HokenshaJoho.ModeController = ModeController;
    })(DBA.HokenshaJoho || (DBA.HokenshaJoho = {}));
    var HokenshaJoho = DBA.HokenshaJoho;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (HokenshaJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HokenshaJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        HokenshaJoho.PublicProperties = PublicProperties;
    })(DBA.HokenshaJoho || (DBA.HokenshaJoho = {}));
    var HokenshaJoho = DBA.HokenshaJoho;
})(DBA || (DBA = {}));
