var DBZ;
(function (DBZ) {
    (function (KekkaShosaiJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KekkaShosaiJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KekkaShosaiJoho.PublicProperties(this.fieldName);
            };
            ModeController.prototype.ShoriType = function () {
                return new Modes.ShoriType(this.controls);
            };
            return ModeController;
        })();
        KekkaShosaiJoho.ModeController = ModeController;

        (function (Modes) {
            var ShoriType = (function () {
                function ShoriType(controls) {
                    this.controls = controls;
                }
                ShoriType.prototype.SoshitsuMode = function () {
                    this.controls.ccdNinteiInput().shoriType().InputMode();
                    this.controls.ccdShinseiSonotaJohoInput().ShoriType().SoshitsuMode();
                    this.controls.btnToroku().displayNone = false;
                };
                ShoriType.prototype.ShokkenTorikeshiInputMode = function () {
                    this.controls.ccdNinteiInput().shoriType().IchibuSoshitsuMode();
                    this.controls.ccdShinseiSonotaJohoInput().ShoriType().TokushuTsuikaMode();
                    this.controls.btnToroku().displayNone = false;
                };

                ShoriType.prototype.ShokaiMode = function () {
                    this.controls.ccdNinteiInput().shoriType().ShokaiMode();
                    this.controls.ccdShinseiSonotaJohoInput().ShoriType().ShokaiMode();
                    this.controls.btnToroku().displayNone = true;
                };
                return ShoriType;
            })();
            Modes.ShoriType = ShoriType;
        })(KekkaShosaiJoho.Modes || (KekkaShosaiJoho.Modes = {}));
        var Modes = KekkaShosaiJoho.Modes;
    })(DBZ.KekkaShosaiJoho || (DBZ.KekkaShosaiJoho = {}));
    var KekkaShosaiJoho = DBZ.KekkaShosaiJoho;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KekkaShosaiJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KekkaShosaiJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KekkaShosaiJoho.PublicProperties = PublicProperties;
    })(DBZ.KekkaShosaiJoho || (DBZ.KekkaShosaiJoho = {}));
    var KekkaShosaiJoho = DBZ.KekkaShosaiJoho;
})(DBZ || (DBZ = {}));
