var DBZ;
(function (DBZ) {
    (function (ServiceTypeInputCommonChildDiv) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceTypeInputCommonChildDiv.Controls(fieldName);
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
                return new ServiceTypeInputCommonChildDiv.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ServiceTypeInputCommonChildDiv.ModeController = ModeController;

        (function (Modes) {
            var State = (function () {
                function State(controls) {
                    this.controls = controls;
                }
                State.prototype.入力 = function () {
                    this.controls.txtServiceType().readOnly = false;
                    this.controls.btnKensaku().disabled = false;
                };

                State.prototype.照会 = function () {
                    this.controls.txtServiceType().readOnly = true;
                    this.controls.btnKensaku().disabled = true;
                };
                return State;
            })();
            Modes.State = State;
        })(ServiceTypeInputCommonChildDiv.Modes || (ServiceTypeInputCommonChildDiv.Modes = {}));
        var Modes = ServiceTypeInputCommonChildDiv.Modes;
    })(DBZ.ServiceTypeInputCommonChildDiv || (DBZ.ServiceTypeInputCommonChildDiv = {}));
    var ServiceTypeInputCommonChildDiv = DBZ.ServiceTypeInputCommonChildDiv;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ServiceTypeInputCommonChildDiv) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceTypeInputCommonChildDiv.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ServiceTypeInputCommonChildDiv.PublicProperties = PublicProperties;
    })(DBZ.ServiceTypeInputCommonChildDiv || (DBZ.ServiceTypeInputCommonChildDiv = {}));
    var ServiceTypeInputCommonChildDiv = DBZ.ServiceTypeInputCommonChildDiv;
})(DBZ || (DBZ = {}));
