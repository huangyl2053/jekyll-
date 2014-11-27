var DBZ;
(function (DBZ) {
    (function (JushochiTokureiRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.controls = new JushochiTokureiRireki.Controls(fieldName);
            }
            ModeController.prototype.TashichosonDisplayMode = function () {
                return new Modes.TashichosonDisplayMode(this.controls);
            };

            ModeController.prototype.TashichosonTeiseiDisplayMode = function () {
                return new Modes.TashichosonTeiseiDisplayMode(this.controls);
            };

            ModeController.prototype.TekiyoJogaiDisplayMode = function () {
                return new Modes.TekiyoJogaiDisplayMode(this.controls);
            };

            ModeController.prototype.TekiyoJogaiTeiseiDisplayMode = function () {
                return new Modes.TekiyoJogaiTeiseiDisplayMode(this.controls);
            };
            return ModeController;
        })();
        JushochiTokureiRireki.ModeController = ModeController;
        (function (Modes) {
            var TashichosonDisplayMode = (function () {
                function TashichosonDisplayMode(controls) {
                    this.controls = controls;
                }
                TashichosonDisplayMode.prototype.Shokai = function () {
                    this.controls.btnAdd().visible = false;
                    this.controls.btnAdd().displayNone = true;
                    this.controls.dgJushochiTokureiRireki().readOnly = true;

                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowDeleteButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                };

                TashichosonDisplayMode.prototype.IdoToroku = function () {
                    this.controls.btnAdd().visible = true;
                    this.controls.btnAdd().displayNone = false;
                    this.controls.dgJushochiTokureiRireki().readOnly = false;

                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowDeleteButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                };
                return TashichosonDisplayMode;
            })();
            Modes.TashichosonDisplayMode = TashichosonDisplayMode;

            var TashichosonTeiseiDisplayMode = (function () {
                function TashichosonTeiseiDisplayMode(controls) {
                    this.controls = controls;
                }
                TashichosonTeiseiDisplayMode.prototype.Shokai = function () {
                    this.controls.btnAdd().displayNone = true;
                    this.controls.dgJushochiTokureiRireki().readOnly = true;

                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;

                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;
                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                };

                TashichosonTeiseiDisplayMode.prototype.IdoToroku = function () {
                    this.controls.btnAdd().displayNone = false;
                    this.controls.dgJushochiTokureiRireki().readOnly = false;

                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;

                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;
                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                };

                TashichosonTeiseiDisplayMode.prototype.IdoToroku_SelectButton = function () {
                    this.controls.btnAdd().displayNone = true;
                    this.controls.dgJushochiTokureiRireki().readOnly = false;

                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;

                    gridSetting.isShowSelectButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;
                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                };
                return TashichosonTeiseiDisplayMode;
            })();
            Modes.TashichosonTeiseiDisplayMode = TashichosonTeiseiDisplayMode;

            var TekiyoJogaiDisplayMode = (function () {
                function TekiyoJogaiDisplayMode(controls) {
                    this.controls = controls;
                }
                TekiyoJogaiDisplayMode.prototype.Shokai = function () {
                    this.controls.btnAdd().visible = false;
                    this.controls.btnAdd().displayNone = true;
                    this.controls.dgJushochiTokureiRireki().readOnly = true;

                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowDeleteButtonColumn = false;

                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;
                    var columns = gridSetting.columns;

                    columns[6].visible = false;

                    columns[7].visible = false;

                    columns[10].visible = false;

                    columns[11].width = 560;

                    gridSetting.columns = columns;

                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;

                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                };

                TekiyoJogaiDisplayMode.prototype.IdoToroku = function () {
                    this.controls.btnAdd().visible = true;
                    this.controls.btnAdd().displayNone = false;
                    this.controls.dgJushochiTokureiRireki().readOnly = false;

                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowDeleteButtonColumn = false;

                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;
                    var columns = gridSetting.columns;

                    columns[6].visible = false;

                    columns[7].visible = false;

                    columns[10].visible = false;

                    columns[11].width = 560;

                    gridSetting.columns = columns;

                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;

                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                };
                return TekiyoJogaiDisplayMode;
            })();
            Modes.TekiyoJogaiDisplayMode = TekiyoJogaiDisplayMode;

            var TekiyoJogaiTeiseiDisplayMode = (function () {
                function TekiyoJogaiTeiseiDisplayMode(controls) {
                    this.controls = controls;
                }
                TekiyoJogaiTeiseiDisplayMode.prototype.Shokai = function () {
                    this.controls.btnAdd().displayNone = true;

                    this.controls.dgJushochiTokureiRireki().readOnly = true;

                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;

                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    var columns = gridSetting.columns;

                    columns[6].visible = false;

                    columns[7].visible = false;

                    columns[10].visible = false;

                    columns[11].width = 560;

                    gridSetting.columns = columns;

                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;

                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                };

                TekiyoJogaiTeiseiDisplayMode.prototype.IdoToroku = function () {
                    this.controls.btnAdd().displayNone = false;

                    this.controls.dgJushochiTokureiRireki().readOnly = false;

                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;

                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    var columns = gridSetting.columns;

                    columns[6].visible = false;

                    columns[7].visible = false;

                    columns[10].visible = false;

                    columns[11].width = 560;

                    gridSetting.columns = columns;

                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;

                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                };

                TekiyoJogaiTeiseiDisplayMode.prototype.IdoToroku_SelectButton = function () {
                    this.controls.btnAdd().displayNone = true;

                    this.controls.dgJushochiTokureiRireki().readOnly = false;

                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;

                    gridSetting.isShowSelectButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    var columns = gridSetting.columns;

                    columns[6].visible = false;

                    columns[7].visible = false;

                    columns[10].visible = false;

                    columns[11].width = 560;

                    gridSetting.columns = columns;

                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;

                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                };
                return TekiyoJogaiTeiseiDisplayMode;
            })();
            Modes.TekiyoJogaiTeiseiDisplayMode = TekiyoJogaiTeiseiDisplayMode;
        })(JushochiTokureiRireki.Modes || (JushochiTokureiRireki.Modes = {}));
        var Modes = JushochiTokureiRireki.Modes;
    })(DBZ.JushochiTokureiRireki || (DBZ.JushochiTokureiRireki = {}));
    var JushochiTokureiRireki = DBZ.JushochiTokureiRireki;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (JushochiTokureiRireki) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new JushochiTokureiRireki.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JushochiTokureiRireki.PublicProperties = PublicProperties;
    })(DBZ.JushochiTokureiRireki || (DBZ.JushochiTokureiRireki = {}));
    var JushochiTokureiRireki = DBZ.JushochiTokureiRireki;
})(DBZ || (DBZ = {}));
