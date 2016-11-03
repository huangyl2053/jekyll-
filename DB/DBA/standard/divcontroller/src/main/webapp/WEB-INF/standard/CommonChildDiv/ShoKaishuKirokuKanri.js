var DBA;
(function (DBA) {
    (function (ShoKaishuKirokuKanri) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShoKaishuKirokuKanri.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "DisplayMode"
                ];
            };

            ModeController.prototype.DisplayMode = function () {
                return new Modes.DisplayMode(this.controls);
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShoKaishuKirokuKanri.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShoKaishuKirokuKanri.ModeController = ModeController;

        (function (Modes) {
            var DisplayMode = (function () {
                function DisplayMode(controls) {
                    this.controls = controls;
                }
                DisplayMode.prototype.shokai = function () {
                    this.controls.panelKoufuList().displayNone = false;
                    this.controls.dgKoufuKaishu().gridSetting.isShowSelectButtonColumn = true;
                    this.controls.dgKoufuKaishu().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgKoufuKaishu().gridSetting.isShowDeleteButtonColumn = false;
                    this.controls.dgKoufuKaishu()._control.afterPropertiesSet();
                    this.controls.panelInput().displayNone = true;
                };

                DisplayMode.prototype.shokai_selected = function () {
                    this.controls.panelKoufuList().displayNone = false;
                    this.controls.dgKoufuKaishu().gridSetting.isShowSelectButtonColumn = true;
                    this.controls.dgKoufuKaishu().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgKoufuKaishu().gridSetting.isShowDeleteButtonColumn = false;
                    this.controls.dgKoufuKaishu()._control.afterPropertiesSet();
                    this.controls.panelInput().displayNone = false;
                    this.controls.txtKoufuType().disabled = true;
                    this.controls.txtKoufuDate().disabled = true;
                    this.controls.txtYukouKigen().disabled = true;
                    this.controls.ddlKoufuJiyu().disabled = true;
                    this.controls.txaKoufuRiyu().disabled = true;
                    this.controls.txtKaisyuDate().disabled = true;
                    this.controls.ddlKaisyuJiyu().disabled = true;
                    this.controls.txaKaishuRiyu().disabled = true;
                    this.controls.btnCancel().displayNone = true;
                    this.controls.btnConfirm().displayNone = true;
                };

                DisplayMode.prototype.koshin = function () {
                    this.controls.panelKoufuList().displayNone = false;
                    this.controls.dgKoufuKaishu().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgKoufuKaishu().gridSetting.isShowModifyButtonColumn = true;
                    this.controls.dgKoufuKaishu().gridSetting.isShowDeleteButtonColumn = true;
                    this.controls.dgKoufuKaishu()._control.afterPropertiesSet();
                    this.controls.panelInput().displayNone = false;
                    this.controls.txtKoufuType().disabled = true;
                    this.controls.txtKoufuDate().disabled = false;
                    this.controls.txtYukouKigen().disabled = false;
                    this.controls.ddlKoufuJiyu().disabled = false;
                    this.controls.txaKoufuRiyu().disabled = false;
                    this.controls.txtKaisyuDate().disabled = false;
                    this.controls.ddlKaisyuJiyu().disabled = false;
                    this.controls.txaKaishuRiyu().disabled = false;
                    this.controls.btnCancel().disabled = false;
                    this.controls.btnConfirm().disabled = false;
                };

                DisplayMode.prototype.sakujyo = function () {
                    this.controls.panelKoufuList().displayNone = false;
                    this.controls.dgKoufuKaishu().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgKoufuKaishu().gridSetting.isShowModifyButtonColumn = true;
                    this.controls.dgKoufuKaishu().gridSetting.isShowDeleteButtonColumn = true;
                    this.controls.dgKoufuKaishu()._control.afterPropertiesSet();
                    this.controls.panelInput().displayNone = false;
                    this.controls.txtKoufuType().disabled = true;
                    this.controls.txtKoufuDate().disabled = true;
                    this.controls.txtYukouKigen().disabled = true;
                    this.controls.ddlKoufuJiyu().disabled = true;
                    this.controls.txaKoufuRiyu().disabled = true;
                    this.controls.txtKaisyuDate().disabled = true;
                    this.controls.ddlKaisyuJiyu().disabled = true;
                    this.controls.txaKaishuRiyu().disabled = true;
                    this.controls.btnCancel().disabled = false;
                    this.controls.btnConfirm().disabled = false;
                };
                return DisplayMode;
            })();
            Modes.DisplayMode = DisplayMode;
        })(ShoKaishuKirokuKanri.Modes || (ShoKaishuKirokuKanri.Modes = {}));
        var Modes = ShoKaishuKirokuKanri.Modes;
    })(DBA.ShoKaishuKirokuKanri || (DBA.ShoKaishuKirokuKanri = {}));
    var ShoKaishuKirokuKanri = DBA.ShoKaishuKirokuKanri;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (ShoKaishuKirokuKanri) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShoKaishuKirokuKanri.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShoKaishuKirokuKanri.PublicProperties = PublicProperties;
    })(DBA.ShoKaishuKirokuKanri || (DBA.ShoKaishuKirokuKanri = {}));
    var ShoKaishuKirokuKanri = DBA.ShoKaishuKirokuKanri;
})(DBA || (DBA = {}));
