var DBD;
(function (DBD) {
    (function (ShinseiSonotaJohoInput) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShinseiSonotaJohoInput.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShinseiSonotaJohoInput.PublicProperties(this.fieldName);
            };

            ModeController.prototype.ShoriType = function () {
                return new Modes.ShoriType(this.controls);
            };
            return ModeController;
        })();
        ShinseiSonotaJohoInput.ModeController = ModeController;

        (function (Modes) {
            var ShoriType = (function () {
                function ShoriType(controls) {
                    this.controls = controls;
                }
                ShoriType.prototype.TokushuTsuikaMode = function () {
                    this.controls.ddlIdoJiyu().readOnly = false;
                    this.controls.ddlSakujoJiyu().readOnly = true;
                    this.controls.txtRiyu().readOnly = false;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorikeshiDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = true;
                    this.controls.txtToshoNinteiKikanTo().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = true;
                };

                ShoriType.prototype.TokushuShuseiMode = function () {
                    this.controls.ddlIdoJiyu().readOnly = false;
                    this.controls.ddlSakujoJiyu().readOnly = true;
                    this.controls.txtRiyu().readOnly = false;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorikeshiDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = false;
                    this.controls.txtToshoNinteiKikanTo().readOnly = false;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = false;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = false;
                };
                ShoriType.prototype.TokushuSakujoMode = function () {
                    this.controls.ddlIdoJiyu().readOnly = true;
                    this.controls.ddlSakujoJiyu().readOnly = false;
                    this.controls.txtRiyu().readOnly = true;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorikeshiDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = true;
                    this.controls.txtToshoNinteiKikanTo().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = true;
                };

                ShoriType.prototype.TokushuRirekiShuseiMode = function () {
                    this.controls.ddlIdoJiyu().readOnly = true;
                    this.controls.ddlSakujoJiyu().readOnly = true;
                    this.controls.txtRiyu().readOnly = false;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorikeshiDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = false;
                    this.controls.txtToshoNinteiKikanTo().readOnly = false;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = false;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = false;
                };

                ShoriType.prototype.NinteiMode = function () {
                    this.controls.ddlIdoJiyu().readOnly = true;
                    this.controls.ddlSakujoJiyu().readOnly = true;
                    this.controls.txtRiyu().readOnly = false;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorikeshiDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = true;
                    this.controls.txtToshoNinteiKikanTo().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = true;
                };
                ShoriType.prototype.KyakkaMode = function () {
                    this.controls.ddlIdoJiyu().readOnly = false;
                    this.controls.ddlSakujoJiyu().readOnly = true;
                    this.controls.txtRiyu().readOnly = false;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorikeshiDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = true;
                    this.controls.txtToshoNinteiKikanTo().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = true;
                };

                ShoriType.prototype.ShokkenKisaiMode = function () {
                    this.controls.ddlIdoJiyu().readOnly = true;
                    this.controls.ddlSakujoJiyu().readOnly = true;
                    this.controls.txtRiyu().readOnly = false;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorikeshiDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = true;
                    this.controls.txtToshoNinteiKikanTo().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = true;
                };
                ShoriType.prototype.TorikeshiMode = function () {
                    this.controls.ddlIdoJiyu().readOnly = false;
                    this.controls.ddlSakujoJiyu().readOnly = true;
                    this.controls.txtRiyu().readOnly = false;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorikeshiDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = false;
                    this.controls.txtToshoNinteiKikanTo().readOnly = false;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = true;
                };
                ShoriType.prototype.ShokkenTorikeshiMode = function () {
                    this.controls.ddlIdoJiyu().readOnly = false;
                    this.controls.ddlSakujoJiyu().readOnly = true;
                    this.controls.txtRiyu().readOnly = false;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorikeshiDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = false;
                    this.controls.txtToshoNinteiKikanTo().readOnly = false;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = true;
                };

                ShoriType.prototype.SoshitsuMode = function () {
                    this.controls.ddlIdoJiyu().readOnly = false;
                    this.controls.ddlSakujoJiyu().readOnly = true;
                    this.controls.txtRiyu().readOnly = false;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorikeshiDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = true;
                    this.controls.txtToshoNinteiKikanTo().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = true;
                };

                ShoriType.prototype.JukyuShikakushashoMode = function () {
                    this.controls.ddlIdoJiyu().readOnly = true;
                    this.controls.ddlSakujoJiyu().readOnly = true;
                    this.controls.txtRiyu().readOnly = false;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorikeshiDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = true;
                    this.controls.txtToshoNinteiKikanTo().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = false;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = false;
                };

                ShoriType.prototype.ShokaiMode = function () {
                    this.controls.ddlIdoJiyu().readOnly = true;
                    this.controls.ddlSakujoJiyu().readOnly = true;
                    this.controls.txtRiyu().readOnly = true;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorikeshiDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = true;
                    this.controls.txtToshoNinteiKikanTo().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = true;
                };
                return ShoriType;
            })();
            Modes.ShoriType = ShoriType;
        })(ShinseiSonotaJohoInput.Modes || (ShinseiSonotaJohoInput.Modes = {}));
        var Modes = ShinseiSonotaJohoInput.Modes;
    })(DBD.ShinseiSonotaJohoInput || (DBD.ShinseiSonotaJohoInput = {}));
    var ShinseiSonotaJohoInput = DBD.ShinseiSonotaJohoInput;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (ShinseiSonotaJohoInput) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShinseiSonotaJohoInput.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShinseiSonotaJohoInput.PublicProperties = PublicProperties;
    })(DBD.ShinseiSonotaJohoInput || (DBD.ShinseiSonotaJohoInput = {}));
    var ShinseiSonotaJohoInput = DBD.ShinseiSonotaJohoInput;
})(DBD || (DBD = {}));
