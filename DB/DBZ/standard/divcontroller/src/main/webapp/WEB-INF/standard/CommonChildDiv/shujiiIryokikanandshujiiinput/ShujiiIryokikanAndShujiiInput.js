var DBZ;
(function (DBZ) {
    (function (ShujiiIryokikanAndShujiiInput) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShujiiIryokikanAndShujiiInput.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShujiiIryokikanAndShujiiInput.PublicProperties(this.fieldName);
            };

            ModeController.prototype.ShoriType = function () {
                return new Modes.ShoriType(this.controls);
            };
            return ModeController;
        })();
        ShujiiIryokikanAndShujiiInput.ModeController = ModeController;

        (function (Modes) {
            var ShoriType = (function () {
                function ShoriType(controls) {
                    this.controls = controls;
                }
                ShoriType.prototype.InputMode = function () {
                    this.controls.txtIryoKikanCode().readOnly = false;
                    this.controls.txtShujiiCode().readOnly = false;

                    this.controls.chkShiteii().readOnly = false;

                    this.controls.btnZenkaiIrokikanJoho().disabled = false;
                    this.controls.btnClear().disabled = false;

                    this.controls.btnIryokikanGuide().disabled = false;
                    this.controls.btnShujiiGuide().disabled = false;
                    this.controls.btnShujiiRenrakuJiko().disabled = false;

                    this.controls.btnZenkaiIrokikanJoho().displayNone = false;
                    this.controls.btnClear().displayNone = false;
                    this.controls.btnShujiiRenrakuJiko().displayNone = false;
                };
                ShoriType.prototype.NinteiMode = function () {
                    this.controls.txtIryoKikanCode().readOnly = true;
                    this.controls.txtShujiiCode().readOnly = true;

                    this.controls.chkShiteii().readOnly = false;

                    this.controls.btnZenkaiIrokikanJoho().disabled = true;
                    this.controls.btnClear().disabled = true;
                    this.controls.btnShujiiRenrakuJiko().disabled = true;

                    this.controls.btnIryokikanGuide().disabled = true;
                    this.controls.btnShujiiGuide().disabled = true;
                    this.controls.btnShujiiRenrakuJiko().disabled = true;

                    this.controls.btnZenkaiIrokikanJoho().displayNone = false;
                    this.controls.btnClear().displayNone = false;
                    this.controls.btnShujiiRenrakuJiko().displayNone = false;
                };

                ShoriType.prototype.ShokaiMode = function () {
                    this.controls.txtIryoKikanCode().readOnly = true;
                    this.controls.txtShujiiCode().readOnly = true;
                    this.controls.chkShiteii().readOnly = true;

                    this.controls.btnZenkaiIrokikanJoho().disabled = true;
                    this.controls.btnClear().disabled = true;

                    this.controls.btnIryokikanGuide().disabled = true;
                    this.controls.btnShujiiGuide().disabled = true;
                    this.controls.btnShujiiRenrakuJiko().disabled = true;

                    this.controls.btnZenkaiIrokikanJoho().displayNone = false;
                    this.controls.btnClear().displayNone = false;
                    this.controls.btnShujiiRenrakuJiko().displayNone = false;
                };

                ShoriType.prototype.SimpleInputMode = function () {
                    this.controls.txtIryoKikanCode().readOnly = false;
                    this.controls.txtShujiiCode().readOnly = false;
                    this.controls.chkShiteii().readOnly = false;

                    this.controls.btnIryokikanGuide().disabled = false;
                    this.controls.btnShujiiGuide().disabled = false;
                    this.controls.btnShujiiRenrakuJiko().disabled = false;

                    this.controls.btnZenkaiIrokikanJoho().displayNone = true;
                    this.controls.btnClear().displayNone = true;
                    this.controls.btnShujiiRenrakuJiko().displayNone = true;
                };

                ShoriType.prototype.SimpleShokaiMode = function () {
                    this.controls.txtShujiiCode().readOnly = true;
                    this.controls.btnShujiiGuide().disabled = true;

                    this.controls.txtIryoKikanCode().readOnly = true;
                    this.controls.btnIryokikanGuide().disabled = true;

                    this.controls.btnZenkaiIrokikanJoho().disabled = true;
                    this.controls.btnClear().disabled = true;
                    this.controls.btnShujiiRenrakuJiko().disabled = true;

                    this.controls.chkShiteii().readOnly = true;

                    this.controls.btnZenkaiIrokikanJoho().displayNone = true;
                    this.controls.btnClear().displayNone = true;
                    this.controls.btnShujiiRenrakuJiko().displayNone = true;
                    this.controls.btnShujiiGuide().displayNone = true;
                    this.controls.btnIryokikanGuide().displayNone = true;
                };

                ShoriType.prototype.OnlyShujiiGuideInputMode = function () {
                    this.controls.txtIryoKikanCode().readOnly = true;
                    this.controls.txtShujiiCode().readOnly = true;
                    this.controls.chkShiteii().readOnly = false;

                    this.controls.btnIryokikanGuide().disabled = true;
                    this.controls.btnShujiiGuide().disabled = false;
                    this.controls.btnShujiiRenrakuJiko().disabled = false;

                    this.controls.btnZenkaiIrokikanJoho().displayNone = true;
                    this.controls.btnClear().displayNone = true;
                    this.controls.btnShujiiRenrakuJiko().displayNone = true;
                };
                return ShoriType;
            })();
            Modes.ShoriType = ShoriType;
        })(ShujiiIryokikanAndShujiiInput.Modes || (ShujiiIryokikanAndShujiiInput.Modes = {}));
        var Modes = ShujiiIryokikanAndShujiiInput.Modes;
    })(DBZ.ShujiiIryokikanAndShujiiInput || (DBZ.ShujiiIryokikanAndShujiiInput = {}));
    var ShujiiIryokikanAndShujiiInput = DBZ.ShujiiIryokikanAndShujiiInput;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShujiiIryokikanAndShujiiInput) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShujiiIryokikanAndShujiiInput.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShujiiIryokikanAndShujiiInput.PublicProperties = PublicProperties;
    })(DBZ.ShujiiIryokikanAndShujiiInput || (DBZ.ShujiiIryokikanAndShujiiInput = {}));
    var ShujiiIryokikanAndShujiiInput = DBZ.ShujiiIryokikanAndShujiiInput;
})(DBZ || (DBZ = {}));
