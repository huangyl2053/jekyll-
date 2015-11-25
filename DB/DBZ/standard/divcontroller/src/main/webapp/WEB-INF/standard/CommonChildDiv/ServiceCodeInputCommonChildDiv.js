var DBZ;
(function (DBZ) {
    (function (ServiceCodeInputCommonChildDiv) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceCodeInputCommonChildDiv.Controls(fieldName);
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
                return new ServiceCodeInputCommonChildDiv.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ServiceCodeInputCommonChildDiv.ModeController = ModeController;

        (function (Modes) {
            var State = (function () {
                function State(controls) {
                    this.controls = controls;
                }
                State.prototype.入力 = function () {
                    this.controls.txtServiceCode1().readOnly = false;
                    this.controls.txtServiceCode2().readOnly = false;
                    this.controls.btnKensaku().disabled = false;
                };
                State.prototype.入力2 = function () {
                    this.controls.txtServiceCode1().readOnly = true;
                    this.controls.txtServiceCode2().readOnly = false;
                    this.controls.btnKensaku().disabled = true;
                };

                State.prototype.照会 = function () {
                    this.controls.txtServiceCode1().readOnly = true;
                    this.controls.txtServiceCode2().readOnly = true;
                    this.controls.btnKensaku().disabled = true;
                };
                return State;
            })();
            Modes.State = State;
        })(ServiceCodeInputCommonChildDiv.Modes || (ServiceCodeInputCommonChildDiv.Modes = {}));
        var Modes = ServiceCodeInputCommonChildDiv.Modes;
    })(DBZ.ServiceCodeInputCommonChildDiv || (DBZ.ServiceCodeInputCommonChildDiv = {}));
    var ServiceCodeInputCommonChildDiv = DBZ.ServiceCodeInputCommonChildDiv;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ServiceCodeInputCommonChildDiv) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceCodeInputCommonChildDiv.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ServiceCodeInputCommonChildDiv.PublicProperties = PublicProperties;
    })(DBZ.ServiceCodeInputCommonChildDiv || (DBZ.ServiceCodeInputCommonChildDiv = {}));
    var ServiceCodeInputCommonChildDiv = DBZ.ServiceCodeInputCommonChildDiv;
})(DBZ || (DBZ = {}));
