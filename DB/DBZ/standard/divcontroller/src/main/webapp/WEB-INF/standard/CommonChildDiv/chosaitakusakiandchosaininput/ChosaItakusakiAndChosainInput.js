var DBZ;
(function (DBZ) {
    (function (ChosaItakusakiAndChosainInput) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaItakusakiAndChosainInput.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ChosaItakusakiAndChosainInput.PublicProperties(this.fieldName);
            };

            ModeController.prototype.ShoriType = function () {
                return new Modes.ShoriType(this.controls);
            };
            return ModeController;
        })();
        ChosaItakusakiAndChosainInput.ModeController = ModeController;
        (function (Modes) {
            var ShoriType = (function () {
                function ShoriType(controls) {
                    this.controls = controls;
                }
                ShoriType.prototype.InputMode = function () {
                    this.controls.txtChosainCode().readOnly = false;
                    this.controls.btnChosainGuide().disabled = false;

                    this.controls.txtChosaItakusakiCode().readOnly = false;
                    this.controls.btnChosaItakusakiGuide().disabled = false;

                    this.controls.btnZenkaiFukusha().disabled = false;
                    this.controls.btnClear().disabled = false;
                    this.controls.btnChosainRenrakuJiko().disabled = false;

                    this.controls.btnChosainRenrakuJiko().displayNone = false;
                    this.controls.btnZenkaiFukusha().displayNone = false;
                    this.controls.btnClear().displayNone = false;
                    this.controls.btnChosaItakusakiGuide().displayNone = false;
                    this.controls.btnChosainGuide().displayNone = false;
                };

                ShoriType.prototype.ShokaiMode = function () {
                    this.controls.txtChosainCode().readOnly = true;
                    this.controls.btnChosainGuide().disabled = true;

                    this.controls.txtChosaItakusakiCode().readOnly = true;
                    this.controls.btnChosaItakusakiGuide().disabled = true;

                    this.controls.btnZenkaiFukusha().displayNone = false;
                    this.controls.btnClear().displayNone = false;

                    this.controls.btnZenkaiFukusha().disabled = true;
                    this.controls.btnClear().disabled = true;
                    this.controls.btnChosainRenrakuJiko().disabled = true;

                    this.controls.btnChosainRenrakuJiko().displayNone = false;
                    this.controls.btnZenkaiFukusha().displayNone = false;
                    this.controls.btnClear().displayNone = false;
                    this.controls.btnChosaItakusakiGuide().displayNone = false;
                    this.controls.btnChosainGuide().displayNone = false;
                };

                ShoriType.prototype.SimpleInputMode = function () {
                    this.controls.txtChosainCode().readOnly = false;
                    this.controls.txtChosaItakusakiCode().readOnly = false;

                    this.controls.btnChosainGuide().disabled = false;
                    this.controls.btnChosaItakusakiGuide().disabled = false;

                    this.controls.btnZenkaiFukusha().displayNone = true;
                    this.controls.btnClear().displayNone = true;
                    this.controls.btnChosainRenrakuJiko().displayNone = true;
                    this.controls.btnChosaItakusakiGuide().displayNone = false;
                    this.controls.btnChosainGuide().displayNone = false;
                };

                ShoriType.prototype.SimpleShokaiMode = function () {
                    this.controls.txtChosainCode().readOnly = true;
                    this.controls.btnChosainGuide().disabled = true;

                    this.controls.txtChosaItakusakiCode().readOnly = true;
                    this.controls.btnChosaItakusakiGuide().disabled = true;

                    this.controls.btnZenkaiFukusha().disabled = true;
                    this.controls.btnClear().disabled = true;
                    this.controls.btnChosainRenrakuJiko().disabled = true;

                    this.controls.btnZenkaiFukusha().displayNone = true;
                    this.controls.btnClear().displayNone = true;
                    this.controls.btnChosainRenrakuJiko().displayNone = true;
                    this.controls.btnChosaItakusakiGuide().displayNone = true;
                    this.controls.btnChosainGuide().displayNone = true;
                };
                return ShoriType;
            })();
            Modes.ShoriType = ShoriType;
        })(ChosaItakusakiAndChosainInput.Modes || (ChosaItakusakiAndChosainInput.Modes = {}));
        var Modes = ChosaItakusakiAndChosainInput.Modes;
    })(DBZ.ChosaItakusakiAndChosainInput || (DBZ.ChosaItakusakiAndChosainInput = {}));
    var ChosaItakusakiAndChosainInput = DBZ.ChosaItakusakiAndChosainInput;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ChosaItakusakiAndChosainInput) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaItakusakiAndChosainInput.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ChosaItakusakiAndChosainInput.PublicProperties = PublicProperties;
    })(DBZ.ChosaItakusakiAndChosainInput || (DBZ.ChosaItakusakiAndChosainInput = {}));
    var ChosaItakusakiAndChosainInput = DBZ.ChosaItakusakiAndChosainInput;
})(DBZ || (DBZ = {}));
