var DBZ;
(function (DBZ) {
    (function (NinteiShinseiShichosonRenrakuJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiShinseiShichosonRenrakuJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new NinteiShinseiShichosonRenrakuJoho.PublicProperties(this.fieldName);
            };

            ModeController.prototype.ShoriType = function () {
                return new Modes.ShoriType(this.controls);
            };
            return ModeController;
        })();
        NinteiShinseiShichosonRenrakuJoho.ModeController = ModeController;

        (function (Modes) {
            var ShoriType = (function () {
                function ShoriType(controls) {
                    this.controls = controls;
                }
                ShoriType.prototype.InputMode = function () {
                    this.controls.txtRenrakujiko().readOnly = false;
                    this.controls.btnToroku().disabled = false;
                };

                ShoriType.prototype.ShokaiMode = function () {
                    this.controls.txtRenrakujiko().readOnly = true;
                    this.controls.btnToroku().disabled = true;
                };
                return ShoriType;
            })();
            Modes.ShoriType = ShoriType;
        })(NinteiShinseiShichosonRenrakuJoho.Modes || (NinteiShinseiShichosonRenrakuJoho.Modes = {}));
        var Modes = NinteiShinseiShichosonRenrakuJoho.Modes;
    })(DBZ.NinteiShinseiShichosonRenrakuJoho || (DBZ.NinteiShinseiShichosonRenrakuJoho = {}));
    var NinteiShinseiShichosonRenrakuJoho = DBZ.NinteiShinseiShichosonRenrakuJoho;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (NinteiShinseiShichosonRenrakuJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiShinseiShichosonRenrakuJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        NinteiShinseiShichosonRenrakuJoho.PublicProperties = PublicProperties;
    })(DBZ.NinteiShinseiShichosonRenrakuJoho || (DBZ.NinteiShinseiShichosonRenrakuJoho = {}));
    var NinteiShinseiShichosonRenrakuJoho = DBZ.NinteiShinseiShichosonRenrakuJoho;
})(DBZ || (DBZ = {}));
