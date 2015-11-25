var DBZ;
(function (DBZ) {
    (function (RoreiFukushiNenkinShokai) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new RoreiFukushiNenkinShokai.Controls(fieldName);
            }
            ModeController.prototype.ModeA = function () {
                return new Modes.ModeA(this.controls);
            };

            ModeController.prototype.ModeB = function () {
                return new Modes.ModeB(this.controls);
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new RoreiFukushiNenkinShokai.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "ModeA",
                    "ModeB"
                ];
            };
            return ModeController;
        })();
        RoreiFukushiNenkinShokai.ModeController = ModeController;

        (function (Modes) {
            var ModeA = (function () {
                function ModeA(controls) {
                    this.controls = controls;
                }
                ModeA.prototype.init = function () {
                    this.controls.panelInput().displayNone = true;
                };
                return ModeA;
            })();
            Modes.ModeA = ModeA;

            var ModeB = (function () {
                function ModeB(controls) {
                    this.controls = controls;
                }
                ModeB.prototype.update = function () {
                    this.controls.panelRireki().displayNone = true;
                    this.controls.panelInput().displayNone = false;

                    this.controls.txtStartDate().readOnly = false;
                    this.controls.txtEndDate().readOnly = false;
                };
                return ModeB;
            })();
            Modes.ModeB = ModeB;
        })(RoreiFukushiNenkinShokai.Modes || (RoreiFukushiNenkinShokai.Modes = {}));
        var Modes = RoreiFukushiNenkinShokai.Modes;
    })(DBZ.RoreiFukushiNenkinShokai || (DBZ.RoreiFukushiNenkinShokai = {}));
    var RoreiFukushiNenkinShokai = DBZ.RoreiFukushiNenkinShokai;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (RoreiFukushiNenkinShokai) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new RoreiFukushiNenkinShokai.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        RoreiFukushiNenkinShokai.PublicProperties = PublicProperties;
    })(DBZ.RoreiFukushiNenkinShokai || (DBZ.RoreiFukushiNenkinShokai = {}));
    var RoreiFukushiNenkinShokai = DBZ.RoreiFukushiNenkinShokai;
})(DBZ || (DBZ = {}));
