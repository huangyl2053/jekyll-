var DBZ;
(function (DBZ) {
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
    })(DBZ.HokenshaJoho || (DBZ.HokenshaJoho = {}));
    var HokenshaJoho = DBZ.HokenshaJoho;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (HokenshaJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.getTxtHokenshaNo_labelLWidth = function () {
                    return this.controls.txtHokenshaNo().labelLWidth;
                };
                this.setTxtHokenshaNo_labelLWidth = function (value) {
                    this.controls.txtHokenshaNo().labelLWidth = value;
                };
                this.getTxtHokenshaNo_required = function () {
                    return this.controls.txtHokenshaNo().required;
                };
                this.setTxtHokenshaNo_required = function (value) {
                    this.controls.txtHokenshaNo().required = value;
                };
                this.getTxtHokenshaNo_labelLText = function () {
                    return this.controls.txtHokenshaNo().labelLText;
                };
                this.setTxtHokenshaNo_labelLText = function (value) {
                    this.controls.txtHokenshaNo().labelLText = value;
                };
                this.fieldName = fieldName;
                this.controls = new HokenshaJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();
                editTypes.addEditType("TxtHokenshaNo_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("TxtHokenshaNo_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TxtHokenshaNo_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };
            return PublicProperties;
        })();
        HokenshaJoho.PublicProperties = PublicProperties;
    })(DBZ.HokenshaJoho || (DBZ.HokenshaJoho = {}));
    var HokenshaJoho = DBZ.HokenshaJoho;
})(DBZ || (DBZ = {}));
