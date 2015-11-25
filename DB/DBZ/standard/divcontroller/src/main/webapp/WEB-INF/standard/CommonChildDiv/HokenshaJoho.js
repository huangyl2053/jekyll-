var DBZ;
(function (DBZ) {
    (function (HokenshaJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HokenshaJoho.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "State"
                ];
            };

            ModeController.prototype.State = function () {
                return new Modes.State(this.controls);
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

        (function (Modes) {
            var State = (function () {
                function State(controls) {
                    this.controls = controls;
                }
                State.prototype.reference = function () {
                    this.controls.btnHokenshaSelect().visible = false;
                };

                State.prototype.modify = function () {
                    this.controls.btnHokenshaSelect().visible = true;
                };
                return State;
            })();
            Modes.State = State;
        })(HokenshaJoho.Modes || (HokenshaJoho.Modes = {}));
        var Modes = HokenshaJoho.Modes;
    })(DBZ.HokenshaJoho || (DBZ.HokenshaJoho = {}));
    var HokenshaJoho = DBZ.HokenshaJoho;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (HokenshaJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.getHokenshaNo_labelLText = function () {
                    return this.controls.txtHokenshaNo().labelLText;
                };
                this.setHokenshaNo_labelLText = function (value) {
                    this.controls.txtHokenshaNo().labelLText = value;
                };
                this.getHokenshaNo_labelLWidth = function () {
                    return this.controls.txtHokenshaNo().labelLWidth;
                };
                this.setHokenshaNo_labelLWidth = function (value) {
                    this.controls.txtHokenshaNo().labelLWidth = value;
                };
                this.getHokenshaNo_required = function () {
                    return this.controls.txtHokenshaNo().required;
                };
                this.setHokenshaNo_required = function (value) {
                    this.controls.txtHokenshaNo().required = value;
                };
                this.controls = new HokenshaJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("HokenshaNo_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("HokenshaNo_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("HokenshaNo_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };
            return PublicProperties;
        })();
        HokenshaJoho.PublicProperties = PublicProperties;
    })(DBZ.HokenshaJoho || (DBZ.HokenshaJoho = {}));
    var HokenshaJoho = DBZ.HokenshaJoho;
})(DBZ || (DBZ = {}));
