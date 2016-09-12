var DBC;
(function (DBC) {
    (function (KogakuShinseiList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KogakuShinseiList.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KogakuShinseiList.PublicProperties(this.fieldName);
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
        KogakuShinseiList.ModeController = ModeController;

        (function (Modes) {
            var DisplayMode = (function () {
                function DisplayMode(controls) {
                    this.controls = controls;
                }
                DisplayMode.prototype.shokai = function () {
                    this.controls.txtServiceYM().disabled = true;
                    this.controls.txtShokisai().disabled = true;
                    this.controls.btnShinseiJohoTsuika().disabled = true;
                    this.controls.btnTaishosyaJoho().disabled = true;
                    this.controls.lin1().disabled = true;

                    this.controls.txtServiceYMFrom().disabled = true;
                    this.controls.txtServiceYMTo().disabled = true;
                    this.controls.btnKensaku().disabled = true;

                    var gridSetting = this.controls.dgShinseiJoho().gridSetting;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgShinseiJoho().gridSetting = gridSetting;
                    this.controls.dgShinseiJoho()._control.afterPropertiesSet();
                };

                DisplayMode.prototype.toroku = function () {
                    this.controls.txtServiceYM().disabled = false;
                    this.controls.txtShokisai().disabled = true;
                    this.controls.btnShinseiJohoTsuika().disabled = false;
                    this.controls.btnTaishosyaJoho().disabled = false;
                    this.controls.lin1().disabled = false;

                    this.controls.txtServiceYMFrom().disabled = false;
                    this.controls.txtServiceYMTo().disabled = false;
                    this.controls.btnKensaku().disabled = false;

                    var gridSetting = this.controls.dgShinseiJoho().gridSetting;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgShinseiJoho().gridSetting = gridSetting;
                    this.controls.dgShinseiJoho()._control.afterPropertiesSet();
                };
                return DisplayMode;
            })();
            Modes.DisplayMode = DisplayMode;
        })(KogakuShinseiList.Modes || (KogakuShinseiList.Modes = {}));
        var Modes = KogakuShinseiList.Modes;
    })(DBC.KogakuShinseiList || (DBC.KogakuShinseiList = {}));
    var KogakuShinseiList = DBC.KogakuShinseiList;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (KogakuShinseiList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KogakuShinseiList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KogakuShinseiList.PublicProperties = PublicProperties;
    })(DBC.KogakuShinseiList || (DBC.KogakuShinseiList = {}));
    var KogakuShinseiList = DBC.KogakuShinseiList;
})(DBC || (DBC = {}));
