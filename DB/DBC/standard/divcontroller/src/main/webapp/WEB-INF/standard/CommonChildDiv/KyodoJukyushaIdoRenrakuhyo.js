var DBC;
(function (DBC) {
    (function (KyodoJukyushaIdoRenrakuhyo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KyodoJukyushaIdoRenrakuhyo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return ["DisplayMode"];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.DisplayMode = function () {
                return new Modes.DisplayMode(this.controls);
            };
            return ModeController;
        })();
        KyodoJukyushaIdoRenrakuhyo.ModeController = ModeController;

        (function (Modes) {
            var DisplayMode = (function () {
                function DisplayMode(controls) {
                    this.controls = controls;
                }
                DisplayMode.prototype.shinki = function () {
                    this.controls.KyodoJukyushaIdoRenrakuhyo().disabled = false;
                    this.controls.txtHiHokenshaNo().readOnly = true;
                    this.controls.txtTaisyoYM().readOnly = true;
                    this.controls.txtIdoYMD().readOnly = true;
                    this.controls.txtShoKisaiHokenshaNo().readOnly = false;
                    this.controls.radIdoKubunCode().readOnly = false;
                    this.controls.ddlJukyushaIdoJiyu().readOnly = false;
                    this.controls.KyodoJukyushaIdoRenrakuhyoTeisei().visible = false;

                    this.controls.chkKihonSofu().visible = true;
                    this.controls.chkKihonSofu().readOnly = false;

                    this.controls.KyodoJukyushaIdoRenrakuhyoShokanPanel().readOnly = false;
                    this.controls.txtKihonIdoYMD().readOnly = false;
                    this.controls.txtRirekiNo().readOnly = true;

                    this.controls.chkShokanSofu().visible = true;
                    this.controls.chkShokanSofu().readOnly = false;

                    this.controls.KyodoJukyushaIdoRenrakuhyoShokanPanel().readOnly = false;
                    this.controls.txtShokanIdoYMD().readOnly = false;
                    this.controls.txtShokanRirekiNo().readOnly = true;

                    this.controls.chkKogakuSofu().visible = true;
                    this.controls.chkKogakuSofu().readOnly = false;

                    this.controls.KyodoJukyushaIdoRenrakuhyoKogakuPanel().readOnly = false;
                    this.controls.txtKogakuIdoYMD().readOnly = false;
                    this.controls.txtKogakuRirekiNo().readOnly = true;
                };

                DisplayMode.prototype.teisei = function () {
                    this.controls.KyodoJukyushaIdoRenrakuhyo().disabled = false;
                    this.controls.txtHiHokenshaNo().readOnly = true;
                    this.controls.txtTaisyoYM().readOnly = true;
                    this.controls.txtIdoYMD().readOnly = true;
                    this.controls.txtShoKisaiHokenshaNo().readOnly = false;
                    this.controls.radIdoKubunCode().readOnly = false;
                    this.controls.ddlJukyushaIdoJiyu().readOnly = false;
                    this.controls.KyodoJukyushaIdoRenrakuhyoTeisei().visible = true;

                    this.controls.chkKihonSofu().visible = true;
                    this.controls.chkKihonSofu().readOnly = false;

                    this.controls.KyodoJukyushaIdoRenrakuhyoShokanPanel().readOnly = false;
                    this.controls.txtKihonIdoYMD().readOnly = true;
                    this.controls.txtRirekiNo().readOnly = true;

                    this.controls.chkShokanSofu().visible = true;
                    this.controls.chkShokanSofu().readOnly = false;

                    this.controls.KyodoJukyushaIdoRenrakuhyoShokanPanel().readOnly = false;
                    this.controls.txtShokanIdoYMD().readOnly = true;
                    this.controls.txtShokanRirekiNo().readOnly = true;

                    this.controls.chkKogakuSofu().visible = true;
                    this.controls.chkKogakuSofu().readOnly = false;

                    this.controls.KyodoJukyushaIdoRenrakuhyoKogakuPanel().readOnly = false;
                    this.controls.txtKogakuIdoYMD().readOnly = true;
                    this.controls.txtKogakuRirekiNo().readOnly = true;
                };

                DisplayMode.prototype.sakujyo = function () {
                    this.controls.KyodoJukyushaIdoRenrakuhyo().disabled = true;

                    this.controls.chkKihonSofu().visible = false;

                    this.controls.chkShokanSofu().visible = false;

                    this.controls.chkKogakuSofu().visible = false;
                };

                DisplayMode.prototype.shokai = function () {
                    this.controls.KyodoJukyushaIdoRenrakuhyo().disabled = true;

                    this.controls.chkKihonSofu().visible = false;

                    this.controls.chkShokanSofu().visible = false;

                    this.controls.chkKogakuSofu().visible = false;
                };
                return DisplayMode;
            })();
            Modes.DisplayMode = DisplayMode;
        })(KyodoJukyushaIdoRenrakuhyo.Modes || (KyodoJukyushaIdoRenrakuhyo.Modes = {}));
        var Modes = KyodoJukyushaIdoRenrakuhyo.Modes;
    })(DBC.KyodoJukyushaIdoRenrakuhyo || (DBC.KyodoJukyushaIdoRenrakuhyo = {}));
    var KyodoJukyushaIdoRenrakuhyo = DBC.KyodoJukyushaIdoRenrakuhyo;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (KyodoJukyushaIdoRenrakuhyo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KyodoJukyushaIdoRenrakuhyo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("TeiseiInfoVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("TeiseiInfoDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getTeiseiInfoVisible = function () {
                return this.controls.KyodoJukyushaIdoRenrakuhyoTeisei().visible;
            };

            PublicProperties.prototype.setTeiseiInfoVisible = function (value) {
                this.controls.KyodoJukyushaIdoRenrakuhyoTeisei().visible = value;
            };

            PublicProperties.prototype.getTeiseiInfoDisplayNone = function () {
                return this.controls.KyodoJukyushaIdoRenrakuhyoTeisei().displayNone;
            };

            PublicProperties.prototype.setTeiseiInfoDisplayNone = function (value) {
                this.controls.KyodoJukyushaIdoRenrakuhyoTeisei().displayNone = value;
            };
            return PublicProperties;
        })();
        KyodoJukyushaIdoRenrakuhyo.PublicProperties = PublicProperties;
    })(DBC.KyodoJukyushaIdoRenrakuhyo || (DBC.KyodoJukyushaIdoRenrakuhyo = {}));
    var KyodoJukyushaIdoRenrakuhyo = DBC.KyodoJukyushaIdoRenrakuhyo;
})(DBC || (DBC = {}));
