var DBZ;
(function (DBZ) {
    (function (NinteiShinseiRenrakusakiJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiShinseiRenrakusakiJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new NinteiShinseiRenrakusakiJoho.PublicProperties(this.fieldName);
            };

            ModeController.prototype.ShoriType = function () {
                return new Modes.ShoriType(this.controls);
            };
            return ModeController;
        })();
        NinteiShinseiRenrakusakiJoho.ModeController = ModeController;

        (function (Modes) {
            var ShoriType = (function () {
                function ShoriType(controls) {
                    this.controls = controls;
                }
                ShoriType.prototype.InputMode = function () {
                    this.controls.txtRenban().readOnly = false;
                    this.controls.ddlRenrakusakiKubun().readOnly = false;
                    this.controls.txtShimei().readOnly = false;
                    this.controls.txtKanaShimei().readOnly = false;
                    this.controls.txtYubinNo().readOnly = false;
                    this.controls.ddlTsuzukigara().readOnly = false;
                    this.controls.txtTelNo().readOnly = false;
                    this.controls.txtMobileNo().readOnly = false;
                    this.controls.txtJusho().readOnly = false;
                    this.controls.txtYusenJuni().readOnly = false;
                    this.controls.btnToroku().disabled = false;
                    this.controls.ddlShisho().readOnly = false;
                };

                ShoriType.prototype.ShokaiMode = function () {
                    this.controls.txtRenban().readOnly = true;
                    this.controls.ddlRenrakusakiKubun().readOnly = true;
                    this.controls.txtShimei().readOnly = true;
                    this.controls.txtKanaShimei().readOnly = true;
                    this.controls.txtYubinNo().readOnly = true;
                    this.controls.ddlTsuzukigara().readOnly = true;
                    this.controls.txtTelNo().readOnly = true;
                    this.controls.txtMobileNo().readOnly = true;
                    this.controls.txtJusho().readOnly = true;
                    this.controls.txtYusenJuni().readOnly = true;
                    this.controls.btnToroku().disabled = true;
                    this.controls.ddlShisho().readOnly = true;
                };

                ShoriType.prototype.KoshinMode = function () {
                    this.controls.txtRenban().readOnly = true;
                    this.controls.ddlRenrakusakiKubun().readOnly = false;
                    this.controls.txtShimei().readOnly = false;
                    this.controls.txtKanaShimei().readOnly = false;
                    this.controls.txtYubinNo().readOnly = false;
                    this.controls.ddlTsuzukigara().readOnly = false;
                    this.controls.txtTelNo().readOnly = false;
                    this.controls.txtMobileNo().readOnly = false;
                    this.controls.txtJusho().readOnly = false;
                    this.controls.txtYusenJuni().readOnly = false;
                    this.controls.btnToroku().disabled = false;
                    this.controls.ddlShisho().readOnly = false;
                };
                return ShoriType;
            })();
            Modes.ShoriType = ShoriType;
        })(NinteiShinseiRenrakusakiJoho.Modes || (NinteiShinseiRenrakusakiJoho.Modes = {}));
        var Modes = NinteiShinseiRenrakusakiJoho.Modes;
    })(DBZ.NinteiShinseiRenrakusakiJoho || (DBZ.NinteiShinseiRenrakusakiJoho = {}));
    var NinteiShinseiRenrakusakiJoho = DBZ.NinteiShinseiRenrakusakiJoho;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (NinteiShinseiRenrakusakiJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiShinseiRenrakusakiJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        NinteiShinseiRenrakusakiJoho.PublicProperties = PublicProperties;
    })(DBZ.NinteiShinseiRenrakusakiJoho || (DBZ.NinteiShinseiRenrakusakiJoho = {}));
    var NinteiShinseiRenrakusakiJoho = DBZ.NinteiShinseiRenrakusakiJoho;
})(DBZ || (DBZ = {}));
