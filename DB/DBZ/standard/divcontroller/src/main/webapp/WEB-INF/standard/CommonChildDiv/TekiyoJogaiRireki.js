var DBZ;
(function (DBZ) {
    (function (TekiyoJogaiRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TekiyoJogaiRireki.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new TekiyoJogaiRireki.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "DisplayMode"
                ];
            };

            ModeController.prototype.DisplayMode = function () {
                return new Modes.DisplayMode(this.controls);
            };
            return ModeController;
        })();
        TekiyoJogaiRireki.ModeController = ModeController;

        (function (Modes) {
            var DisplayMode = (function () {
                function DisplayMode(controls) {
                    this.controls = controls;
                }
                DisplayMode.prototype.適用登録モード = function () {
                    this.controls.btnAdd().displayNone = false;
                    this.controls.panelTekiyoRireki().displayNone = false;
                    this.controls.panelTekiyoInput().displayNone = true;
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = false;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                    this.controls.btnInputClear().displayNone = false;
                    this.controls.btnKakutei().displayNone = false;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowModifyButtonColumn = true;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowDeleteButtonColumn = true;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowRowState = true;
                    this.controls.datagridTekiyoJogai()._control.afterPropertiesSet();
                    this.controls.panelTekiyoInput().disabled = false;
                };

                DisplayMode.prototype.解除モード = function () {
                    this.controls.btnAdd().displayNone = true;
                    this.controls.panelTekiyoRireki().displayNone = false;
                    this.controls.panelTekiyoInput().displayNone = true;
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = false;
                    this.controls.btnInputClear().displayNone = false;
                    this.controls.btnKakutei().displayNone = false;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowModifyButtonColumn = true;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowDeleteButtonColumn = true;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowRowState = true;
                    this.controls.datagridTekiyoJogai()._control.afterPropertiesSet();
                    this.controls.panelTekiyoInput().disabled = false;
                };

                DisplayMode.prototype.施設変更モード = function () {
                    this.controls.btnAdd().displayNone = true;
                    this.controls.panelTekiyoRireki().displayNone = true;
                    this.controls.panelTekiyoInput().displayNone = false;
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                    this.controls.btnInputClear().displayNone = false;
                    this.controls.btnKakutei().displayNone = false;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowDeleteButtonColumn = false;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowRowState = false;
                    this.controls.datagridTekiyoJogai()._control.afterPropertiesSet();
                    this.controls.panelTekiyoInput().disabled = true;
                };

                DisplayMode.prototype.訂正履歴モード = function () {
                    this.controls.btnAdd().displayNone = false;
                    this.controls.panelTekiyoRireki().displayNone = false;
                    this.controls.panelTekiyoInput().displayNone = false;
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                    this.controls.btnInputClear().displayNone = true;
                    this.controls.btnKakutei().displayNone = true;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowModifyButtonColumn = true;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowDeleteButtonColumn = true;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowRowState = true;
                    this.controls.datagridTekiyoJogai()._control.afterPropertiesSet();
                    this.controls.panelTekiyoInput().disabled = false;
                };

                DisplayMode.prototype.照会モード = function () {
                    this.controls.btnAdd().displayNone = true;
                    this.controls.panelTekiyoRireki().displayNone = false;
                    this.controls.panelTekiyoInput().displayNone = false;
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                    this.controls.btnInputClear().displayNone = true;
                    this.controls.btnKakutei().displayNone = true;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowSelectButtonColumn = true;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowDeleteButtonColumn = false;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowRowState = false;
                    this.controls.datagridTekiyoJogai()._control.afterPropertiesSet();
                    this.controls.panelTekiyoInput().disabled = true;
                };
                return DisplayMode;
            })();
            Modes.DisplayMode = DisplayMode;
        })(TekiyoJogaiRireki.Modes || (TekiyoJogaiRireki.Modes = {}));
        var Modes = TekiyoJogaiRireki.Modes;
    })(DBZ.TekiyoJogaiRireki || (DBZ.TekiyoJogaiRireki = {}));
    var TekiyoJogaiRireki = DBZ.TekiyoJogaiRireki;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (TekiyoJogaiRireki) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TekiyoJogaiRireki.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TekiyoJogaiRireki.PublicProperties = PublicProperties;
    })(DBZ.TekiyoJogaiRireki || (DBZ.TekiyoJogaiRireki = {}));
    var TekiyoJogaiRireki = DBZ.TekiyoJogaiRireki;
})(DBZ || (DBZ = {}));
