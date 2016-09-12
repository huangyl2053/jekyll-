var DBC;
(function (DBC) {
    (function (KogakuKyufuTaishoList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KogakuKyufuTaishoList.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KogakuKyufuTaishoList.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "DisplayMode",
                    "MeisaiGokeiKubunMode"
                ];
            };

            ModeController.prototype.DisplayMode = function () {
                return new Modes.DisplayMode(this.controls);
            };
            ModeController.prototype.MeisaiGokeiKubunMode = function () {
                return new Modes.MeisaiGokeiKubunMode(this.controls);
            };
            return ModeController;
        })();
        KogakuKyufuTaishoList.ModeController = ModeController;

        (function (Modes) {
            var DisplayMode = (function () {
                function DisplayMode(controls) {
                    this.controls = controls;
                }
                DisplayMode.prototype.shokai = function () {
                    this.controls.btnTsuika().visible = false;
                    this.controls.MeisaiGokeiHenshuPanel().visible = false;

                    var gridSetting = this.controls.dgTaishoshaIchiran().gridSetting;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;
                    gridSetting.columns[0].visible = false;

                    this.controls.dgTaishoshaIchiran().gridSetting = gridSetting;
                    this.controls.dgTaishoshaIchiran()._control.afterPropertiesSet();
                };

                DisplayMode.prototype.toroku = function () {
                    this.controls.btnTsuika().visible = true;
                    this.controls.MeisaiGokeiHenshuPanel().visible = true;

                    var gridSetting = this.controls.dgTaishoshaIchiran().gridSetting;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;
                    gridSetting.columns[0].visible = true;

                    this.controls.dgTaishoshaIchiran().gridSetting = gridSetting;
                    this.controls.dgTaishoshaIchiran()._control.afterPropertiesSet();
                };
                return DisplayMode;
            })();
            Modes.DisplayMode = DisplayMode;

            var MeisaiGokeiKubunMode = (function () {
                function MeisaiGokeiKubunMode(controls) {
                    this.controls = controls;
                }
                MeisaiGokeiKubunMode.prototype.Meisai = function () {
                    this.controls.GokeiPanel().displayNone = true;
                    this.controls.KogakuKyufuKonkyoPanel().displayNone = false;
                };

                MeisaiGokeiKubunMode.prototype.Gokei = function () {
                    this.controls.GokeiPanel().displayNone = false;
                    this.controls.KogakuKyufuKonkyoPanel().displayNone = true;
                };
                return MeisaiGokeiKubunMode;
            })();
            Modes.MeisaiGokeiKubunMode = MeisaiGokeiKubunMode;
        })(KogakuKyufuTaishoList.Modes || (KogakuKyufuTaishoList.Modes = {}));
        var Modes = KogakuKyufuTaishoList.Modes;
    })(DBC.KogakuKyufuTaishoList || (DBC.KogakuKyufuTaishoList = {}));
    var KogakuKyufuTaishoList = DBC.KogakuKyufuTaishoList;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (KogakuKyufuTaishoList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KogakuKyufuTaishoList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KogakuKyufuTaishoList.PublicProperties = PublicProperties;
    })(DBC.KogakuKyufuTaishoList || (DBC.KogakuKyufuTaishoList = {}));
    var KogakuKyufuTaishoList = DBC.KogakuKyufuTaishoList;
})(DBC || (DBC = {}));
