var DBZ;
(function (DBZ) {
    (function (IryoHokenRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IryoHokenRireki.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "DisplayMode",
                    "MeisaiMode",
                    "WidthMode"
                ];
            };

            ModeController.prototype.DisplayMode = function () {
                return new Modes.DisplayMode(this.controls);
            };

            ModeController.prototype.MeisaiMode = function () {
                return new Modes.MeisaiMode(this.controls);
            };

            ModeController.prototype.WidthMode = function () {
                return new Modes.WidthMode(this.controls);
            };
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new IryoHokenRireki.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        IryoHokenRireki.ModeController = ModeController;

        (function (Modes) {
            var DisplayMode = (function () {
                function DisplayMode(controls) {
                    this.controls = controls;
                }
                DisplayMode.prototype.reference = function () {
                    this.controls.tbdKanyubi().readOnly = true;
                    this.controls.tbdDattabi().readOnly = true;
                    this.controls.ddlSyubetsu().disabled = true;
                    this.controls.txtHokensyaKodo().readOnly = true;
                    this.controls.txtHokensyaMeisho().readOnly = true;
                    this.controls.txtKigoBango().readOnly = true;
                    this.controls.btnIryohokenTsuika().visible = false;
                    this.controls.btnKakutei().visible = false;
                    this.controls.btnCancel().visible = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowSelectButtonColumn = true;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowDeleteButtonColumn = false;
                };
                DisplayMode.prototype.referenceNoSelect = function () {
                    this.controls.tbdKanyubi().readOnly = true;
                    this.controls.tbdDattabi().readOnly = true;
                    this.controls.ddlSyubetsu().disabled = true;
                    this.controls.txtHokensyaKodo().readOnly = true;
                    this.controls.txtHokensyaMeisho().readOnly = true;
                    this.controls.txtKigoBango().readOnly = true;
                    this.controls.btnIryohokenTsuika().visible = false;
                    this.controls.btnKakutei().visible = false;
                    this.controls.btnCancel().visible = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowDeleteButtonColumn = false;
                };

                DisplayMode.prototype.registration = function () {
                    this.controls.tbdKanyubi().readOnly = true;
                    this.controls.tbdDattabi().readOnly = true;
                    this.controls.ddlSyubetsu().disabled = true;
                    this.controls.txtHokensyaKodo().readOnly = true;
                    this.controls.txtHokensyaMeisho().readOnly = true;
                    this.controls.txtKigoBango().readOnly = true;
                    this.controls.btnKakutei().disabled = true;
                    this.controls.btnCancel().disabled = true;
                    this.controls.btnIryohokenTsuika().visible = true;
                    this.controls.btnKakutei().visible = true;
                    this.controls.btnCancel().visible = true;
                    this.controls.btnIryohokenTsuika().disabled = false;
                    this.controls.btnKakutei().disabled = false;
                    this.controls.btnCancel().disabled = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowModifyButtonColumn = true;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowDeleteButtonColumn = true;
                };
                return DisplayMode;
            })();
            Modes.DisplayMode = DisplayMode;
            var MeisaiMode = (function () {
                function MeisaiMode(controls) {
                    this.controls = controls;
                }
                MeisaiMode.prototype.meisai1 = function () {
                    this.controls.pnlIryohokenJoho().displayNone = true;
                };
                return MeisaiMode;
            })();
            Modes.MeisaiMode = MeisaiMode;
            var WidthMode = (function () {
                function WidthMode(controls) {
                    this.controls = controls;
                }
                WidthMode.prototype.Size1 = function () {
                    this.controls.dgIryohokenIchiran().width = 700;

                    this.controls.dgIryohokenIchiran()._control.afterPropertiesSet();
                };
                WidthMode.prototype.Size2 = function () {
                    this.controls.dgIryohokenIchiran().width = 770;

                    this.controls.dgIryohokenIchiran()._control.afterPropertiesSet();
                };
                WidthMode.prototype.Size3 = function () {
                    this.controls.dgIryohokenIchiran().width = 870;

                    this.controls.dgIryohokenIchiran()._control.afterPropertiesSet();
                };
                return WidthMode;
            })();
            Modes.WidthMode = WidthMode;
        })(IryoHokenRireki.Modes || (IryoHokenRireki.Modes = {}));
        var Modes = IryoHokenRireki.Modes;
    })(DBZ.IryoHokenRireki || (DBZ.IryoHokenRireki = {}));
    var IryoHokenRireki = DBZ.IryoHokenRireki;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (IryoHokenRireki) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IryoHokenRireki.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        IryoHokenRireki.PublicProperties = PublicProperties;
    })(DBZ.IryoHokenRireki || (DBZ.IryoHokenRireki = {}));
    var IryoHokenRireki = DBZ.IryoHokenRireki;
})(DBZ || (DBZ = {}));
