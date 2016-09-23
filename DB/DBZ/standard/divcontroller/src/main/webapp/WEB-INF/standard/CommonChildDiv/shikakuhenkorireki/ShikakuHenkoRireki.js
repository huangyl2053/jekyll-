var DBZ;
(function (DBZ) {
    (function (ShikakuHenkoRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShikakuHenkoRireki.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShikakuHenkoRireki.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "DisplayType",
                    "BtnDisplayMode",
                    "HokenshaJohoDisplayMode",
                    "ShoriNichijiDisplayMode",
                    "MeisaiMode",
                    "DataGridWidth",
                    "DataGridHeight"
                ];
            };

            ModeController.prototype.DisplayType = function () {
                return new Modes.DisplayType(this.controls);
            };

            ModeController.prototype.BtnDisplayMode = function () {
                return new Modes.BtnDisplayMode(this.controls);
            };

            ModeController.prototype.HokenshaJohoDisplayMode = function () {
                return new Modes.HokenshaJohoDisplayMode(this.controls);
            };

            ModeController.prototype.ShoriNichijiDisplayMode = function () {
                return new Modes.ShoriNichijiDisplayMode(this.controls);
            };

            ModeController.prototype.MeisaiMode = function () {
                return new Modes.MeisaiMode(this.controls);
            };

            ModeController.prototype.DataGridWidth = function () {
                return new Modes.DataGridWidth(this.controls);
            };

            ModeController.prototype.DataGridHeight = function () {
                return new Modes.DataGridHeight(this.controls);
            };
            return ModeController;
        })();
        ShikakuHenkoRireki.ModeController = ModeController;

        (function (Modes) {
            var DisplayType = (function () {
                function DisplayType(controls) {
                    this.controls = controls;
                }
                DisplayType.prototype.shokai = function () {
                    this.controls.btnAdd().visible = false;
                    this.controls.HenkoInput().visible = false;
                    this.controls.dgHenko().readOnly = false;

                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[0].visible = false;
                    gridSetting.columns[8].visible = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DisplayType.prototype.toroku = function () {
                    this.controls.dgHenko().readOnly = false;

                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[8].visible = false;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DisplayType.prototype.teiseitoroku = function () {
                    this.controls.dgHenko().readOnly = false;

                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[8].visible = false;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };
                return DisplayType;
            })();
            Modes.DisplayType = DisplayType;

            var BtnDisplayMode = (function () {
                function BtnDisplayMode(controls) {
                    this.controls = controls;
                }
                BtnDisplayMode.prototype.SetDisplay = function () {
                    this.controls.btnAdd().displayNone = false;
                };

                BtnDisplayMode.prototype.SetDisplayNone = function () {
                    this.controls.btnAdd().displayNone = true;
                };
                return BtnDisplayMode;
            })();
            Modes.BtnDisplayMode = BtnDisplayMode;

            var HokenshaJohoDisplayMode = (function () {
                function HokenshaJohoDisplayMode(controls) {
                    this.controls = controls;
                }
                HokenshaJohoDisplayMode.prototype.TanitsuGappeiNashi = function () {
                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[5].visible = false;
                    gridSetting.columns[6].visible = false;
                    gridSetting.columns[7].visible = false;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.HenkoHokenshaJoho().displayNone = true;
                    this.controls.ddlHenkoSochimotoHokensha().displayNone = true;
                    this.controls.ddlHenkoKyuHokensha().displayNone = true;
                    this.controls.ddlJuminJoho().displayNone = true;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.TanitsuGappeiAri = function () {
                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[5].visible = false;
                    gridSetting.columns[6].visible = false;
                    gridSetting.columns[7].visible = true;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.HenkoHokenshaJoho().displayNone = false;
                    this.controls.ddlHenkoSochimotoHokensha().displayNone = true;
                    this.controls.ddlHenkoKyuHokensha().displayNone = false;
                    this.controls.ddlJuminJoho().displayNone = true;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.KoikiGappeiNashi = function () {
                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[5].visible = true;
                    gridSetting.columns[6].visible = true;
                    gridSetting.columns[7].visible = false;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.HenkoHokenshaJoho().displayNone = false;
                    this.controls.ddlHenkoSochimotoHokensha().displayNone = false;
                    this.controls.ddlHenkoKyuHokensha().displayNone = true;
                    this.controls.ddlJuminJoho().displayNone = false;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.KoikiGappeiAri = function () {
                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[5].visible = true;
                    gridSetting.columns[6].visible = true;
                    gridSetting.columns[7].visible = true;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.HenkoHokenshaJoho().displayNone = false;
                    this.controls.ddlHenkoSochimotoHokensha().displayNone = false;
                    this.controls.ddlHenkoKyuHokensha().displayNone = false;
                    this.controls.ddlJuminJoho().displayNone = false;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };
                return HokenshaJohoDisplayMode;
            })();
            Modes.HokenshaJohoDisplayMode = HokenshaJohoDisplayMode;

            var ShoriNichijiDisplayMode = (function () {
                function ShoriNichijiDisplayMode(controls) {
                    this.controls = controls;
                }
                ShoriNichijiDisplayMode.prototype.VisibleTrue = function () {
                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[8].visible = true;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                ShoriNichijiDisplayMode.prototype.VisibleFalse = function () {
                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[8].visible = false;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };
                return ShoriNichijiDisplayMode;
            })();
            Modes.ShoriNichijiDisplayMode = ShoriNichijiDisplayMode;

            var MeisaiMode = (function () {
                function MeisaiMode(controls) {
                    this.controls = controls;
                }
                MeisaiMode.prototype.shokai = function () {
                    this.controls.HenkoInput().readOnly = true;
                    this.controls.HenkoInput().displayNone = false;

                    this.controls.txtHenkoDate().readOnly = true;
                    this.controls.txtHenkoTodokedeDate().readOnly = true;
                    this.controls.ddlHenkoJiyu().readOnly = true;
                    this.controls.ddlHenkoSochimotoHokensha().readOnly = true;
                    this.controls.ddlHenkoKyuHokensha().readOnly = true;
                    this.controls.ddlJuminJoho().readOnly = true;

                    this.controls.btnHenkoKakutei().displayNone = true;
                    this.controls.btnHenkoTorikeshi().displayNone = true;
                };

                MeisaiMode.prototype.toroku = function () {
                    this.controls.HenkoInput().readOnly = false;
                    this.controls.HenkoInput().displayNone = false;

                    this.controls.txtHenkoDate().readOnly = false;
                    this.controls.txtHenkoTodokedeDate().readOnly = false;
                    this.controls.ddlHenkoJiyu().readOnly = false;
                    this.controls.ddlHenkoSochimotoHokensha().readOnly = false;
                    this.controls.ddlHenkoKyuHokensha().readOnly = false;
                    this.controls.ddlJuminJoho().readOnly = false;

                    this.controls.btnHenkoKakutei().displayNone = false;
                    this.controls.btnHenkoTorikeshi().displayNone = false;
                };

                MeisaiMode.prototype.sakujo = function () {
                    this.controls.HenkoInput().readOnly = false;
                    this.controls.HenkoInput().displayNone = false;

                    this.controls.txtHenkoDate().readOnly = true;
                    this.controls.txtHenkoTodokedeDate().readOnly = true;
                    this.controls.ddlHenkoJiyu().readOnly = true;
                    this.controls.ddlHenkoSochimotoHokensha().readOnly = true;
                    this.controls.ddlHenkoKyuHokensha().readOnly = true;
                    this.controls.ddlJuminJoho().readOnly = true;

                    this.controls.btnHenkoKakutei().displayNone = false;
                    this.controls.btnHenkoTorikeshi().displayNone = false;
                };

                MeisaiMode.prototype.setDisplayNone = function () {
                    this.controls.HenkoInput().readOnly = true;
                    this.controls.HenkoInput().displayNone = true;
                };
                return MeisaiMode;
            })();
            Modes.MeisaiMode = MeisaiMode;

            var DataGridWidth = (function () {
                function DataGridWidth(controls) {
                    this.controls = controls;
                }
                DataGridWidth.prototype.Size1 = function () {
                    this.controls.dgHenko().width = 870;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size2 = function () {
                    this.controls.dgHenko().width = 790;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size3 = function () {
                    this.controls.dgHenko().width = 750;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size4 = function () {
                    this.controls.dgHenko().width = 740;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size5 = function () {
                    this.controls.dgHenko().width = 670;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size6 = function () {
                    this.controls.dgHenko().width = 630;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size7 = function () {
                    this.controls.dgHenko().width = 620;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size8 = function () {
                    this.controls.dgHenko().width = 550;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size9 = function () {
                    this.controls.dgHenko().width = 510;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size10 = function () {
                    this.controls.dgHenko().width = 500;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size11 = function () {
                    this.controls.dgHenko().width = 430;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size12 = function () {
                    this.controls.dgHenko().width = 380;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };
                return DataGridWidth;
            })();
            Modes.DataGridWidth = DataGridWidth;

            var DataGridHeight = (function () {
                function DataGridHeight(controls) {
                    this.controls = controls;
                }
                DataGridHeight.prototype.Size1 = function () {
                    this.controls.dgHenko().height = 450;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size2 = function () {
                    this.controls.dgHenko().height = 400;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size3 = function () {
                    this.controls.dgHenko().height = 350;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size4 = function () {
                    this.controls.dgHenko().height = 300;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size5 = function () {
                    this.controls.dgHenko().height = 250;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size6 = function () {
                    this.controls.dgHenko().height = 200;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };
                return DataGridHeight;
            })();
            Modes.DataGridHeight = DataGridHeight;
        })(ShikakuHenkoRireki.Modes || (ShikakuHenkoRireki.Modes = {}));
        var Modes = ShikakuHenkoRireki.Modes;
    })(DBZ.ShikakuHenkoRireki || (DBZ.ShikakuHenkoRireki = {}));
    var ShikakuHenkoRireki = DBZ.ShikakuHenkoRireki;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShikakuHenkoRireki) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShikakuHenkoRireki.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShikakuHenkoRireki.PublicProperties = PublicProperties;
    })(DBZ.ShikakuHenkoRireki || (DBZ.ShikakuHenkoRireki = {}));
    var ShikakuHenkoRireki = DBZ.ShikakuHenkoRireki;
})(DBZ || (DBZ = {}));
