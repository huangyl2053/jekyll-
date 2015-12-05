var DBA;
(function (DBA) {
    (function (ShichosonSelector) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShichosonSelector.Controls(fieldName);
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
                return new ShichosonSelector.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShichosonSelector.ModeController = ModeController;

        (function (Modes) {
            var State = (function () {
                function State(controls) {
                    this.controls = controls;
                }
                State.prototype.RadioBtnNoKyuShichosonMode = function () {
                    this.controls.radShichosonKubun().displayNone = true;
                };

                State.prototype.RadioBtnNoKoseiShichosonMode = function () {
                    this.controls.radShichosonKubun().displayNone = true;
                };
                State.prototype.RadioBtnYesShichosonMode = function () {
                };
                return State;
            })();
            Modes.State = State;
        })(ShichosonSelector.Modes || (ShichosonSelector.Modes = {}));
        var Modes = ShichosonSelector.Modes;
    })(DBA.ShichosonSelector || (DBA.ShichosonSelector = {}));
    var ShichosonSelector = DBA.ShichosonSelector;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (ShichosonSelector) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShichosonSelector.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShichosonSelector.PublicProperties = PublicProperties;
    })(DBA.ShichosonSelector || (DBA.ShichosonSelector = {}));
    var ShichosonSelector = DBA.ShichosonSelector;
})(DBA || (DBA = {}));
