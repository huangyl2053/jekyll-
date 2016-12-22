var DBZ;
(function (DBZ) {
    (function (BunshoBangoInput) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new BunshoBangoInput.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new BunshoBangoInput.PublicProperties(this.fieldName);
            };

            ModeController.prototype.DisplayType = function () {
                return new Modes.DisplayType(this.controls);
            };
            return ModeController;
        })();
        BunshoBangoInput.ModeController = ModeController;

        (function (Modes) {
            var DisplayType = (function () {
                function DisplayType(controls) {
                    this.controls = controls;
                }
                DisplayType.prototype.ShudoNyuryoku = function () {
                    this.controls.txtBunshoNo().readOnly = false;
                    this.controls.btnGetBunshoNo().visible = false;
                };

                DisplayType.prototype.JidoSaiban = function () {
                    this.controls.txtBunshoNo().readOnly = true;
                    this.controls.btnGetBunshoNo().visible = true;
                };

                DisplayType.prototype.Kotei = function () {
                    this.controls.txtBunshoNo().readOnly = true;
                    this.controls.btnGetBunshoNo().visible = false;
                };
                return DisplayType;
            })();
            Modes.DisplayType = DisplayType;
        })(BunshoBangoInput.Modes || (BunshoBangoInput.Modes = {}));
        var Modes = BunshoBangoInput.Modes;
    })(DBZ.BunshoBangoInput || (DBZ.BunshoBangoInput = {}));
    var BunshoBangoInput = DBZ.BunshoBangoInput;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (BunshoBangoInput) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new BunshoBangoInput.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        BunshoBangoInput.PublicProperties = PublicProperties;
    })(DBZ.BunshoBangoInput || (DBZ.BunshoBangoInput = {}));
    var BunshoBangoInput = DBZ.BunshoBangoInput;
})(DBZ || (DBZ = {}));
