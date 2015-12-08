var DBZ;
(function (DBZ) {
    (function (ShoKaishuKirokuKanri) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShoKaishuKirokuKanri.Controls(fieldName);
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
                return new ShoKaishuKirokuKanri.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "ModeA",
                    "ModeB"
                ];
            };
            return ModeController;
        })();
        ShoKaishuKirokuKanri.ModeController = ModeController;

        (function (Modes) {
            var ModeA = (function () {
                function ModeA(controls) {
                    this.controls = controls;
                }
                ModeA.prototype.SyoKai = function () {
                    this.controls.panelInput().displayNone = true;
                };
                return ModeA;
            })();
            Modes.ModeA = ModeA;

            var ModeB = (function () {
                function ModeB(controls) {
                    this.controls = controls;
                }
                ModeB.prototype.Update = function () {
                    this.controls.panelInput().displayNone = false;

                    this.controls.btnCancel().disabled = true;
                    this.controls.btnConfirm().disabled = true;
                };
                return ModeB;
            })();
            Modes.ModeB = ModeB;
        })(ShoKaishuKirokuKanri.Modes || (ShoKaishuKirokuKanri.Modes = {}));
        var Modes = ShoKaishuKirokuKanri.Modes;
    })(DBZ.ShoKaishuKirokuKanri || (DBZ.ShoKaishuKirokuKanri = {}));
    var ShoKaishuKirokuKanri = DBZ.ShoKaishuKirokuKanri;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShoKaishuKirokuKanri) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShoKaishuKirokuKanri.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShoKaishuKirokuKanri.PublicProperties = PublicProperties;
    })(DBZ.ShoKaishuKirokuKanri || (DBZ.ShoKaishuKirokuKanri = {}));
    var ShoKaishuKirokuKanri = DBZ.ShoKaishuKirokuKanri;
})(DBZ || (DBZ = {}));
