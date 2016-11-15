var DBZ;
(function (DBZ) {
    (function (ZenkaiNinteiKekkaJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ZenkaiNinteiKekkaJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ZenkaiNinteiKekkaJoho.PublicProperties(this.fieldName);
            };

            ModeController.prototype.ShokaiButtonType = function () {
                return new Modes.ShokaiButtonType(this.controls);
            };
            ModeController.prototype.DivSize = function () {
                return new Modes.DivSize(this.controls);
            };
            return ModeController;
        })();
        ZenkaiNinteiKekkaJoho.ModeController = ModeController;

        (function (Modes) {
            var ShokaiButtonType = (function () {
                function ShokaiButtonType(controls) {
                    this.controls = controls;
                }
                ShokaiButtonType.prototype.ShokaiButtonMode = function () {
                    this.controls.btnZenkaiShosai().displayNone = false;
                    this.controls.btnZenkaiShosai().disabled = false;
                };

                ShokaiButtonType.prototype.ShokaiButtonNoneMode = function () {
                    this.controls.btnZenkaiShosai().displayNone = true;
                    this.controls.btnZenkaiShosai().disabled = false;
                };

                ShokaiButtonType.prototype.ShokaiButtonDisabledMode = function () {
                    this.controls.btnZenkaiShosai().displayNone = false;
                    this.controls.btnZenkaiShosai().disabled = true;
                };
                return ShokaiButtonType;
            })();
            Modes.ShokaiButtonType = ShokaiButtonType;

            var DivSize = (function () {
                function DivSize(controls) {
                    this.controls = controls;
                }
                DivSize.prototype.ShinseiUketsuke = function () {
                    this.controls.ZenkaiNinteiKekkaJoho().width = 1050;
                };

                DivSize.prototype.ChosaKekkaToroku = function () {
                    this.controls.ZenkaiNinteiKekkaJoho().width = 1110;
                };
                return DivSize;
            })();
            Modes.DivSize = DivSize;
        })(ZenkaiNinteiKekkaJoho.Modes || (ZenkaiNinteiKekkaJoho.Modes = {}));
        var Modes = ZenkaiNinteiKekkaJoho.Modes;
    })(DBZ.ZenkaiNinteiKekkaJoho || (DBZ.ZenkaiNinteiKekkaJoho = {}));
    var ZenkaiNinteiKekkaJoho = DBZ.ZenkaiNinteiKekkaJoho;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ZenkaiNinteiKekkaJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ZenkaiNinteiKekkaJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ZenkaiNinteiKekkaJoho.PublicProperties = PublicProperties;
    })(DBZ.ZenkaiNinteiKekkaJoho || (DBZ.ZenkaiNinteiKekkaJoho = {}));
    var ZenkaiNinteiKekkaJoho = DBZ.ZenkaiNinteiKekkaJoho;
})(DBZ || (DBZ = {}));
