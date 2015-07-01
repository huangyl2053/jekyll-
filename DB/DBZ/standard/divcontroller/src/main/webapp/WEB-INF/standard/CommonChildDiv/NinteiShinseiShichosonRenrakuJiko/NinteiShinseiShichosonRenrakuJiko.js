var DBZ;
(function (DBZ) {
    (function (NinteiShinseiShichosonRenrakuJiko) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiShinseiShichosonRenrakuJiko.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new NinteiShinseiShichosonRenrakuJiko.PublicProperties(this.fieldName);
            };
            ModeController.prototype.ShoriType = function () {
                return new Modes.ShoriType(this.controls);
            };
            return ModeController;
        })();
        NinteiShinseiShichosonRenrakuJiko.ModeController = ModeController;

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
        })(NinteiShinseiShichosonRenrakuJiko.Modes || (NinteiShinseiShichosonRenrakuJiko.Modes = {}));
        var Modes = NinteiShinseiShichosonRenrakuJiko.Modes;
    })(DBZ.NinteiShinseiShichosonRenrakuJiko || (DBZ.NinteiShinseiShichosonRenrakuJiko = {}));
    var NinteiShinseiShichosonRenrakuJiko = DBZ.NinteiShinseiShichosonRenrakuJiko;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (NinteiShinseiShichosonRenrakuJiko) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiShinseiShichosonRenrakuJiko.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        NinteiShinseiShichosonRenrakuJiko.PublicProperties = PublicProperties;
    })(DBZ.NinteiShinseiShichosonRenrakuJiko || (DBZ.NinteiShinseiShichosonRenrakuJiko = {}));
    var NinteiShinseiShichosonRenrakuJiko = DBZ.NinteiShinseiShichosonRenrakuJiko;
})(DBZ || (DBZ = {}));
