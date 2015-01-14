var DBZ;
(function (DBZ) {
    (function (ShisetsuJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_radShisetsuShurui = function () {
                return "onChange_radShisetsuShurui";
            };
            return Events;
        })();
        ShisetsuJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShisetsuJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShisetsuJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShisetsuJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShisetsuJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlDaichoShubetsu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlDaichoShubetsu"));
            };

            Controls.prototype.radShisetsuShurui = function () {
                return new UZA.RadioButton(this.convFiledName("radShisetsuShurui"));
            };

            Controls.prototype.txtShisetsuCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShisetsuCode"));
            };

            Controls.prototype.btnJigyoshaInputGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnJigyoshaInputGuide"));
            };

            Controls.prototype.btnOtherTokureiShisetsuInputGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnOtherTokureiShisetsuInputGuide"));
            };

            Controls.prototype.btnJogaiShisetsuInputGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnJogaiShisetsuInputGuide"));
            };

            Controls.prototype.txtShisetsuMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtShisetsuMeisho"));
            };
            return Controls;
        })();
        ShisetsuJoho.Controls = Controls;
    })(DBZ.ShisetsuJoho || (DBZ.ShisetsuJoho = {}));
    var ShisetsuJoho = DBZ.ShisetsuJoho;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShisetsuJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShisetsuJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShisetsuJoho.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "台帳種別",
                    "施設種類",
                    "入力補助",
                    "表示モード"
                ];
            };

            ModeController.prototype.台帳種別 = function () {
                return new Modes.台帳種別(this.controls);
            };

            ModeController.prototype.施設種類 = function () {
                return new Modes.施設種類(this.controls);
            };

            ModeController.prototype.入力補助 = function () {
                return new Modes.入力補助(this.controls);
            };

            ModeController.prototype.表示モード = function () {
                return new Modes.表示モード(this.controls);
            };
            return ModeController;
        })();
        ShisetsuJoho.ModeController = ModeController;

        (function (Modes) {
            var 台帳種別 = (function () {
                function 台帳種別(controls) {
                    this.controls = controls;
                }
                台帳種別.prototype.台帳種別表示する = function () {
                    this.controls.ddlDaichoShubetsu().displayNone = false;
                };

                台帳種別.prototype.台帳種別非表示する = function () {
                    this.controls.ddlDaichoShubetsu().displayNone = true;
                };
                return 台帳種別;
            })();
            Modes.台帳種別 = 台帳種別;

            var 施設種類 = (function () {
                function 施設種類(controls) {
                    this.controls = controls;
                }
                施設種類.prototype.施設種類を表示する = function () {
                    this.controls.radShisetsuShurui().displayNone = false;
                };

                施設種類.prototype.施設種類を表示しない = function () {
                    this.controls.radShisetsuShurui().displayNone = true;
                };
                return 施設種類;
            })();
            Modes.施設種類 = 施設種類;

            var 入力補助 = (function () {
                function 入力補助(controls) {
                    this.controls = controls;
                }
                入力補助.prototype.事業者を表示する = function () {
                    this.controls.btnJigyoshaInputGuide().displayNone = false;
                    this.controls.btnOtherTokureiShisetsuInputGuide().displayNone = true;
                    this.controls.btnJogaiShisetsuInputGuide().displayNone = true;
                };

                入力補助.prototype.他特例施設を表示する = function () {
                    this.controls.btnJigyoshaInputGuide().displayNone = true;
                    this.controls.btnOtherTokureiShisetsuInputGuide().displayNone = false;
                    this.controls.btnJogaiShisetsuInputGuide().displayNone = true;
                };

                入力補助.prototype.除外施設を表示する = function () {
                    this.controls.btnJigyoshaInputGuide().displayNone = true;
                    this.controls.btnOtherTokureiShisetsuInputGuide().displayNone = true;
                    this.controls.btnJogaiShisetsuInputGuide().displayNone = false;
                };
                return 入力補助;
            })();
            Modes.入力補助 = 入力補助;

            var 表示モード = (function () {
                function 表示モード(controls) {
                    this.controls = controls;
                }
                表示モード.prototype.defaultView = function () {
                    this.controls.ShisetsuJoho().readOnly = false;
                    this.controls.ShisetsuJoho().displayNone = false;
                };

                表示モード.prototype.readOnly = function () {
                    this.controls.ShisetsuJoho().readOnly = true;
                    this.controls.ShisetsuJoho().displayNone = false;
                };

                表示モード.prototype.displayNone = function () {
                    this.controls.ShisetsuJoho().readOnly = true;
                    this.controls.ShisetsuJoho().displayNone = true;
                };
                return 表示モード;
            })();
            Modes.表示モード = 表示モード;
        })(ShisetsuJoho.Modes || (ShisetsuJoho.Modes = {}));
        var Modes = ShisetsuJoho.Modes;
    })(DBZ.ShisetsuJoho || (DBZ.ShisetsuJoho = {}));
    var ShisetsuJoho = DBZ.ShisetsuJoho;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShisetsuJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShisetsuJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShisetsuJoho.PublicProperties = PublicProperties;
    })(DBZ.ShisetsuJoho || (DBZ.ShisetsuJoho = {}));
    var ShisetsuJoho = DBZ.ShisetsuJoho;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShikakuHenkoRireki) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAdd = function () {
                return "onClick_btnAdd";
            };

            Events.onSelect_dgHenko = function () {
                return "onSelect_dgHenko";
            };

            Events.onSelectByDblClick_dgHenko = function () {
                return "onSelectByDblClick_dgHenko";
            };

            Events.onSelectByModifyButton_dgHenko = function () {
                return "onSelectByModifyButton_dgHenko";
            };

            Events.onSelectByDeleteButton_dgHenko = function () {
                return "onSelectByDeleteButton_dgHenko";
            };

            Events.onClick_btnHenkoKakutei = function () {
                return "onClick_btnHenkoKakutei";
            };

            Events.onClick_btnHenkoTorikeshi = function () {
                return "onClick_btnHenkoTorikeshi";
            };
            return Events;
        })();
        ShikakuHenkoRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShikakuHenkoRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShikakuHenkoRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShikakuHenkoRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShikakuHenkoRireki = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgHenko = function () {
                return new UZA.DataGrid(this.convFiledName("dgHenko"));
            };

            Controls.prototype.HenkoInput = function () {
                return new UZA.Panel(this.convFiledName("HenkoInput"));
            };

            Controls.prototype.txtHenkoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtHenkoDate"));
            };

            Controls.prototype.txtHenkoTodokedeDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtHenkoTodokedeDate"));
            };

            Controls.prototype.ddlHenkoJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHenkoJiyu"));
            };

            Controls.prototype.HenkoHokenshaJoho = function () {
                return new UZA.Panel(this.convFiledName("HenkoInput_HenkoHokenshaJoho"));
            };

            Controls.prototype.ddlHenkoShozaiHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHenkoShozaiHokensha"));
            };

            Controls.prototype.ddlHenkoSochimotoHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHenkoSochimotoHokensha"));
            };

            Controls.prototype.ddlHenkoKyuHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHenkoKyuHokensha"));
            };

            Controls.prototype.ddlJuminJoho = function () {
                return new UZA.DropDownList(this.convFiledName("ddlJuminJoho"));
            };

            Controls.prototype.btnHenkoKakutei = function () {
                return new UZA.Button(this.convFiledName("btnHenkoKakutei"));
            };

            Controls.prototype.btnHenkoTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnHenkoTorikeshi"));
            };
            return Controls;
        })();
        ShikakuHenkoRireki.Controls = Controls;
    })(DBZ.ShikakuHenkoRireki || (DBZ.ShikakuHenkoRireki = {}));
    var ShikakuHenkoRireki = DBZ.ShikakuHenkoRireki;
})(DBZ || (DBZ = {}));
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
                    this.controls.dgHenko().readOnly = false;

                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[0].visible = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DisplayType.prototype.toroku = function () {
                    this.controls.dgHenko().readOnly = false;

                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgHenko().gridSetting = gridSetting;

                    this.controls.dgHenko()._control.afterPropertiesSet();
                };

                DisplayType.prototype.teiseitoroku = function () {
                    this.controls.dgHenko().readOnly = false;

                    var gridSetting = this.controls.dgHenko().gridSetting;

                    gridSetting.columns[0].visible = true;
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
                    this.controls.ddlHenkoShozaiHokensha().displayNone = true;
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
                    this.controls.ddlHenkoShozaiHokensha().displayNone = true;
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
                    this.controls.ddlHenkoShozaiHokensha().displayNone = false;
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
                    this.controls.ddlHenkoShozaiHokensha().displayNone = false;
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
                    this.controls.ddlHenkoShozaiHokensha().readOnly = true;
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
                    this.controls.ddlHenkoShozaiHokensha().readOnly = false;
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
                    this.controls.ddlHenkoShozaiHokensha().readOnly = true;
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
var DBZ;
(function (DBZ) {
    (function (IryoHokenRireki) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAddIryoHoken = function () {
                return "onClick_btnAddIryoHoken";
            };

            Events.onSelect_dgIryoHokenRireki = function () {
                return "onSelect_dgIryoHokenRireki";
            };

            Events.onSelectByDbClick_dgIryoHokenRireki = function () {
                return "onSelectByDbClick_dgIryoHokenRireki";
            };

            Events.onSelectByModifyButton_dgIryoHokenRireki = function () {
                return "onSelectByModifyButton_dgIryoHokenRireki";
            };

            Events.onSelectByDeleteButton_dgIryoHokenRireki = function () {
                return "onSelectByDeleteButton_dgIryoHokenRireki";
            };

            Events.onBlur_txtIryoHokenHokenshaNo = function () {
                return "onBlur_txtIryoHokenHokenshaNo";
            };

            Events.onClick_btnIryoHokenKakutei = function () {
                return "onClick_btnIryoHokenKakutei";
            };

            Events.onClick_btnIryoHokenTorikeshi = function () {
                return "onClick_btnIryoHokenTorikeshi";
            };
            return Events;
        })();
        IryoHokenRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "IryoHokenRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.IryoHokenRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.IryoHokenRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.IryoHokenRireki = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAddIryoHoken = function () {
                return new UZA.Button(this.convFiledName("btnAddIryoHoken"));
            };

            Controls.prototype.dgIryoHokenRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgIryoHokenRireki"));
            };

            Controls.prototype.IryoHokenInput = function () {
                return new UZA.Panel(this.convFiledName("IryoHokenInput"));
            };

            Controls.prototype.txtIryoHokenKanyuDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIryoHokenKanyuDate"));
            };

            Controls.prototype.txtIryoHokenDattaiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIryoHokenDattaiDate"));
            };

            Controls.prototype.ddlIryoHokenShubetsu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlIryoHokenShubetsu"));
            };

            Controls.prototype.txtIryoHokenHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtIryoHokenHokenshaNo"));
            };

            Controls.prototype.txtIryoHokenHokenshaMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtIryoHokenHokenshaMeisho"));
            };

            Controls.prototype.txtIryoHokenKigoNo = function () {
                return new UZA.TextBox(this.convFiledName("txtIryoHokenKigoNo"));
            };

            Controls.prototype.btnIryoHokenKakutei = function () {
                return new UZA.Button(this.convFiledName("btnIryoHokenKakutei"));
            };

            Controls.prototype.btnIryoHokenTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnIryoHokenTorikeshi"));
            };
            return Controls;
        })();
        IryoHokenRireki.Controls = Controls;
    })(DBZ.IryoHokenRireki || (DBZ.IryoHokenRireki = {}));
    var IryoHokenRireki = DBZ.IryoHokenRireki;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (IryoHokenRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IryoHokenRireki.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new IryoHokenRireki.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "DisplayMode",
                    "WidthMode",
                    "MeisaiMode"
                ];
            };

            ModeController.prototype.DisplayMode = function () {
                return new Modes.DisplayMode(this.controls);
            };

            ModeController.prototype.WidthMode = function () {
                return new Modes.WidthMode(this.controls);
            };

            ModeController.prototype.MeisaiMode = function () {
                return new Modes.MeisaiMode(this.controls);
            };
            return ModeController;
        })();
        IryoHokenRireki.ModeController = ModeController;

        (function (Modes) {
            var DisplayMode = (function () {
                function DisplayMode(controls) {
                    this.controls = controls;
                }
                DisplayMode.prototype.Toroku = function () {
                    this.controls.dgIryoHokenRireki().readOnly = false;
                    this.controls.btnAddIryoHoken().displayNone = false;

                    var gridSetting = this.controls.dgIryoHokenRireki().gridSetting;
                    gridSetting.isShowDeleteButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.columns[0].visible = false;

                    this.controls.dgIryoHokenRireki().gridSetting = gridSetting;

                    this.controls.dgIryoHokenRireki().width = 980;

                    this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();
                };

                DisplayMode.prototype.Shokai = function () {
                    this.controls.dgIryoHokenRireki().readOnly = true;
                    this.controls.btnAddIryoHoken().displayNone = true;

                    var gridSetting = this.controls.dgIryoHokenRireki().gridSetting;
                    gridSetting.isShowDeleteButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.columns[0].visible = false;

                    this.controls.dgIryoHokenRireki().gridSetting = gridSetting;

                    this.controls.dgIryoHokenRireki().width = 940;

                    this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();
                };

                DisplayMode.prototype.ShikakuIdo = function () {
                    this.controls.dgIryoHokenRireki().readOnly = false;
                    this.controls.btnAddIryoHoken().displayNone = false;

                    var gridSetting = this.controls.dgIryoHokenRireki().gridSetting;
                    gridSetting.isShowDeleteButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.columns[0].visible = true;

                    this.controls.dgIryoHokenRireki().gridSetting = gridSetting;

                    this.controls.dgIryoHokenRireki().width = 980;

                    this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();
                };
                return DisplayMode;
            })();
            Modes.DisplayMode = DisplayMode;

            var WidthMode = (function () {
                function WidthMode(controls) {
                    this.controls = controls;
                }
                WidthMode.prototype.Width1 = function () {
                    this.controls.dgIryoHokenRireki().width = 800;
                    this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();
                };

                WidthMode.prototype.Width2 = function () {
                    this.controls.dgIryoHokenRireki().width = 700;
                    this.controls.dgIryoHokenRireki()._control.afterPropertiesSet();
                };
                return WidthMode;
            })();
            Modes.WidthMode = WidthMode;

            var MeisaiMode = (function () {
                function MeisaiMode(controls) {
                    this.controls = controls;
                }
                MeisaiMode.prototype.toroku = function () {
                    this.controls.IryoHokenInput().readOnly = false;
                    this.controls.IryoHokenInput().displayNone = false;

                    this.controls.txtIryoHokenKanyuDate().readOnly = false;
                    this.controls.txtIryoHokenKanyuDate().displayNone = false;
                    this.controls.txtIryoHokenDattaiDate().readOnly = false;
                    this.controls.txtIryoHokenDattaiDate().displayNone = false;
                    this.controls.ddlIryoHokenShubetsu().readOnly = false;
                    this.controls.ddlIryoHokenShubetsu().displayNone = false;
                    this.controls.txtIryoHokenHokenshaNo().readOnly = false;
                    this.controls.txtIryoHokenHokenshaNo().displayNone = false;
                    this.controls.txtIryoHokenHokenshaMeisho().readOnly = false;
                    this.controls.txtIryoHokenHokenshaMeisho().displayNone = false;
                    this.controls.txtIryoHokenKigoNo().readOnly = false;
                    this.controls.txtIryoHokenKigoNo().displayNone = false;

                    this.controls.btnIryoHokenKakutei().disabled = false;
                    this.controls.btnIryoHokenKakutei().displayNone = false;
                    this.controls.btnIryoHokenTorikeshi().disabled = false;
                    this.controls.btnIryoHokenTorikeshi().displayNone = false;
                };

                MeisaiMode.prototype.sakujo = function () {
                    this.controls.IryoHokenInput().readOnly = false;
                    this.controls.IryoHokenInput().displayNone = false;

                    this.controls.txtIryoHokenKanyuDate().readOnly = true;
                    this.controls.txtIryoHokenKanyuDate().displayNone = false;
                    this.controls.txtIryoHokenDattaiDate().readOnly = true;
                    this.controls.txtIryoHokenDattaiDate().displayNone = false;
                    this.controls.ddlIryoHokenShubetsu().readOnly = true;
                    this.controls.ddlIryoHokenShubetsu().displayNone = false;
                    this.controls.txtIryoHokenHokenshaNo().readOnly = true;
                    this.controls.txtIryoHokenHokenshaNo().displayNone = false;
                    this.controls.txtIryoHokenHokenshaMeisho().readOnly = true;
                    this.controls.txtIryoHokenHokenshaMeisho().displayNone = false;
                    this.controls.txtIryoHokenKigoNo().readOnly = true;
                    this.controls.txtIryoHokenKigoNo().displayNone = false;

                    this.controls.btnIryoHokenKakutei().disabled = false;
                    this.controls.btnIryoHokenKakutei().displayNone = false;
                    this.controls.btnIryoHokenTorikeshi().disabled = false;
                    this.controls.btnIryoHokenTorikeshi().displayNone = false;
                };

                MeisaiMode.prototype.setReadOnly = function () {
                    this.controls.IryoHokenInput().readOnly = true;
                    this.controls.IryoHokenInput().displayNone = false;

                    this.controls.txtIryoHokenKanyuDate().displayNone = false;
                    this.controls.txtIryoHokenDattaiDate().displayNone = false;
                    this.controls.ddlIryoHokenShubetsu().displayNone = false;
                    this.controls.txtIryoHokenHokenshaNo().displayNone = false;
                    this.controls.txtIryoHokenHokenshaMeisho().displayNone = false;
                    this.controls.txtIryoHokenKigoNo().displayNone = false;

                    this.controls.btnIryoHokenKakutei().displayNone = true;
                    this.controls.btnIryoHokenTorikeshi().displayNone = true;
                };

                MeisaiMode.prototype.setDisplayNone = function () {
                    this.controls.IryoHokenInput().readOnly = true;
                    this.controls.IryoHokenInput().displayNone = true;
                };
                return MeisaiMode;
            })();
            Modes.MeisaiMode = MeisaiMode;
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
var DBZ;
(function (DBZ) {
    (function (JushochiTokureiRireki) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAdd = function () {
                return "onClick_btnAdd";
            };

            Events.onSelect_dgJushochiTokureiRireki = function () {
                return "onSelect_dgJushochiTokureiRireki";
            };

            Events.onSelectByDblClick_dgJushochiTokureiRireki = function () {
                return "onSelectByDblClick_dgJushochiTokureiRireki";
            };

            Events.onSelectBySelectButton_dgJushochiTokureiRireki = function () {
                return "onSelectBySelectButton_dgJushochiTokureiRireki";
            };

            Events.onSelectByModifyButton_dgJushochiTokureiRireki = function () {
                return "onSelectByModifyButton_dgJushochiTokureiRireki";
            };

            Events.onSelectByDeleteButton_dgJushochiTokureiRireki = function () {
                return "onSelectByDeleteButton_dgJushochiTokureiRireki";
            };
            return Events;
        })();
        JushochiTokureiRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JushochiTokureiRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.JushochiTokureiRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.JushochiTokureiRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JushochiTokureiRireki = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgJushochiTokureiRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgJushochiTokureiRireki"));
            };
            return Controls;
        })();
        JushochiTokureiRireki.Controls = Controls;
    })(DBZ.JushochiTokureiRireki || (DBZ.JushochiTokureiRireki = {}));
    var JushochiTokureiRireki = DBZ.JushochiTokureiRireki;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (JushochiTokureiRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.controls = new JushochiTokureiRireki.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new JushochiTokureiRireki.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "TashichosonDisplayMode",
                    "TashichosonTeiseiDisplayMode",
                    "TekiyoJogaiDisplayMode",
                    "TekiyoJogaiTeiseiDisplayMode"
                ];
            };

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
                    var columns = gridSetting.columns;

                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    columns[6].visible = true;

                    columns[7].visible = true;

                    columns[10].visible = true;

                    columns[11].width = 250;

                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;
                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                };

                TashichosonTeiseiDisplayMode.prototype.IdoToroku = function () {
                    this.controls.btnAdd().displayNone = false;
                    this.controls.dgJushochiTokureiRireki().readOnly = false;

                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;
                    var columns = gridSetting.columns;

                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    columns[6].visible = true;

                    columns[7].visible = true;

                    columns[10].visible = true;

                    columns[11].width = 250;

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

                    columns[11].width = 370;

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

                    columns[11].width = 370;

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

                    columns[11].width = 370;

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

                    columns[11].width = 370;

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

                    columns[11].width = 370;

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
var DBZ;
(function (DBZ) {
    (function (JushochiTokureiRirekiList) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAdd = function () {
                return "onClick_btnAdd";
            };

            Events.onSelect_dgJutoku = function () {
                return "onSelect_dgJutoku";
            };

            Events.onSelectByDblClick_dgJutoku = function () {
                return "onSelectByDblClick_dgJutoku";
            };

            Events.onSelectByModifyButton_dgJutoku = function () {
                return "onSelectByModifyButton_dgJutoku";
            };

            Events.onSelectByDeleteButton_dgJutoku = function () {
                return "onSelectByDeleteButton_dgJutoku";
            };

            Events.onClick_btnJutokuKakutei = function () {
                return "onClick_btnJutokuKakutei";
            };

            Events.onClick_btnJutokuTorikeshi = function () {
                return "onClick_btnJutokuTorikeshi";
            };
            return Events;
        })();
        JushochiTokureiRirekiList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JushochiTokureiRirekiList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.JushochiTokureiRirekiList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.JushochiTokureiRirekiList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JushochiTokureiRirekiList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgJutoku = function () {
                return new UZA.DataGrid(this.convFiledName("dgJutoku"));
            };

            Controls.prototype.JutokuInput = function () {
                return new UZA.Panel(this.convFiledName("JutokuInput"));
            };

            Controls.prototype.JutokuTekiyoInput = function () {
                return new UZA.Panel(this.convFiledName("JutokuInput_JutokuTekiyoInput"));
            };

            Controls.prototype.txtTekiyoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoDate"));
            };

            Controls.prototype.txtTekiyoTodokedeDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoTodokedeDate"));
            };

            Controls.prototype.ddlTekiyoJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyoJiyu"));
            };

            Controls.prototype.tekiyojiHokenshaJoho = function () {
                return new UZA.Panel(this.convFiledName("JutokuInput_JutokuTekiyoInput_tekiyojiHokenshaJoho"));
            };

            Controls.prototype.ddlTekiyojiShozaiHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyojiShozaiHokensha"));
            };

            Controls.prototype.ddlTekiyojiSochimotoHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyojiSochimotoHokensha"));
            };

            Controls.prototype.ddlTekiyojiKyuHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyojiKyuHokensha"));
            };

            Controls.prototype.ddlTekiyojiJuminJoho = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTekiyojiJuminJoho"));
            };

            Controls.prototype.JutokuKaijoInput = function () {
                return new UZA.Panel(this.convFiledName("JutokuInput_JutokuKaijoInput"));
            };

            Controls.prototype.txtKaijoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKaijoDate"));
            };

            Controls.prototype.txtKaijoTodokedeDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKaijoTodokedeDate"));
            };

            Controls.prototype.ddlKaijoJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaijoJiyu"));
            };

            Controls.prototype.kaijojiHokenshaJoho = function () {
                return new UZA.Panel(this.convFiledName("JutokuInput_JutokuKaijoInput_kaijojiHokenshaJoho"));
            };

            Controls.prototype.ddlKaijojiShozaiHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaijojiShozaiHokensha"));
            };

            Controls.prototype.ddlKaijojiSochimotoHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaijojiSochimotoHokensha"));
            };

            Controls.prototype.ddlKaijojiKyuHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaijojiKyuHokensha"));
            };

            Controls.prototype.ddlKaijojiJuminJono = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaijojiJuminJono"));
            };

            Controls.prototype.btnJutokuKakutei = function () {
                return new UZA.Button(this.convFiledName("btnJutokuKakutei"));
            };

            Controls.prototype.btnJutokuTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnJutokuTorikeshi"));
            };
            return Controls;
        })();
        JushochiTokureiRirekiList.Controls = Controls;
    })(DBZ.JushochiTokureiRirekiList || (DBZ.JushochiTokureiRirekiList = {}));
    var JushochiTokureiRirekiList = DBZ.JushochiTokureiRirekiList;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (JushochiTokureiRirekiList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JushochiTokureiRirekiList.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new JushochiTokureiRirekiList.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "DisplayType",
                    "ShoriNichijiDisplayMode",
                    "MeisaiDisplayMode",
                    "HokenshaJohoDisplayMode",
                    "BtnDisplayMode",
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

            ModeController.prototype.MeisaiDisplayMode = function () {
                return new Modes.MeisaiDisplayMode(this.controls);
            };

            ModeController.prototype.DataGridWidth = function () {
                return new Modes.DataGridWidth(this.controls);
            };

            ModeController.prototype.DataGridHeight = function () {
                return new Modes.DataGridHeight(this.controls);
            };
            return ModeController;
        })();
        JushochiTokureiRirekiList.ModeController = ModeController;

        (function (Modes) {
            var DisplayType = (function () {
                function DisplayType(controls) {
                    this.controls = controls;
                }
                DisplayType.prototype.shokai = function () {
                    this.controls.dgJutoku().readOnly = false;

                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[0].visible = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DisplayType.prototype.toroku = function () {
                    this.controls.dgJutoku().readOnly = false;

                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DisplayType.prototype.teiseitoroku = function () {
                    this.controls.dgJutoku().readOnly = false;

                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };
                return DisplayType;
            })();
            Modes.DisplayType = DisplayType;

            var MeisaiDisplayMode = (function () {
                function MeisaiDisplayMode(controls) {
                    this.controls = controls;
                }
                MeisaiDisplayMode.prototype.tekiyoShokai = function () {
                    this.controls.JutokuInput().readOnly = true;
                    this.controls.JutokuInput().displayNone = false;

                    this.controls.JutokuTekiyoInput().readOnly = true;
                    this.controls.JutokuTekiyoInput().displayNone = false;
                    this.controls.txtTekiyoDate().readOnly = true;
                    this.controls.txtTekiyoTodokedeDate().readOnly = true;

                    this.controls.tekiyojiHokenshaJoho().readOnly = true;
                    this.controls.tekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyoJiyu().readOnly = true;
                    this.controls.ddlTekiyojiShozaiHokensha().readOnly = true;
                    this.controls.ddlTekiyojiSochimotoHokensha().readOnly = true;
                    this.controls.ddlTekiyojiKyuHokensha().readOnly = true;
                    this.controls.ddlTekiyojiJuminJoho().readOnly = true;

                    this.controls.JutokuKaijoInput().displayNone = true;

                    this.controls.btnJutokuKakutei().displayNone = true;
                    this.controls.btnJutokuTorikeshi().displayNone = true;
                };

                MeisaiDisplayMode.prototype.kaijoShokai = function () {
                    this.controls.JutokuInput().readOnly = true;
                    this.controls.JutokuInput().displayNone = false;

                    this.controls.JutokuTekiyoInput().displayNone = true;

                    this.controls.JutokuKaijoInput().readOnly = true;
                    this.controls.JutokuKaijoInput().displayNone = false;
                    this.controls.txtKaijoDate().readOnly = true;
                    this.controls.txtKaijoTodokedeDate().readOnly = true;

                    this.controls.kaijojiHokenshaJoho().readOnly = true;
                    this.controls.kaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijoJiyu().readOnly = true;
                    this.controls.ddlKaijojiShozaiHokensha().readOnly = true;
                    this.controls.ddlKaijojiSochimotoHokensha().readOnly = true;
                    this.controls.ddlKaijojiKyuHokensha().readOnly = true;
                    this.controls.ddlKaijojiJuminJono().readOnly = true;

                    this.controls.btnJutokuKakutei().displayNone = true;
                    this.controls.btnJutokuTorikeshi().displayNone = true;
                };

                MeisaiDisplayMode.prototype.tekiyoInput = function () {
                    this.controls.JutokuInput().readOnly = false;
                    this.controls.JutokuInput().displayNone = false;

                    this.controls.JutokuTekiyoInput().readOnly = false;
                    this.controls.JutokuTekiyoInput().displayNone = false;
                    this.controls.txtTekiyoDate().readOnly = false;
                    this.controls.txtTekiyoTodokedeDate().readOnly = false;

                    this.controls.tekiyojiHokenshaJoho().readOnly = false;
                    this.controls.tekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyoJiyu().readOnly = false;
                    this.controls.ddlTekiyojiShozaiHokensha().readOnly = false;
                    this.controls.ddlTekiyojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlTekiyojiKyuHokensha().readOnly = false;
                    this.controls.ddlTekiyojiJuminJoho().readOnly = false;

                    this.controls.JutokuKaijoInput().displayNone = true;

                    this.controls.btnJutokuKakutei().displayNone = false;
                    this.controls.btnJutokuTorikeshi().displayNone = false;
                };

                MeisaiDisplayMode.prototype.kaijoInput = function () {
                    this.controls.JutokuInput().readOnly = false;
                    this.controls.JutokuInput().displayNone = false;

                    this.controls.JutokuTekiyoInput().displayNone = true;

                    this.controls.JutokuKaijoInput().readOnly = false;
                    this.controls.JutokuKaijoInput().displayNone = false;
                    this.controls.txtKaijoDate().readOnly = false;
                    this.controls.txtKaijoTodokedeDate().readOnly = false;

                    this.controls.kaijojiHokenshaJoho().readOnly = false;
                    this.controls.kaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijoJiyu().readOnly = false;
                    this.controls.ddlKaijojiShozaiHokensha().readOnly = false;
                    this.controls.ddlKaijojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlKaijojiKyuHokensha().readOnly = false;
                    this.controls.ddlKaijojiJuminJono().readOnly = false;

                    this.controls.btnJutokuKakutei().displayNone = false;
                    this.controls.btnJutokuTorikeshi().displayNone = false;
                };

                MeisaiDisplayMode.prototype.TeiseiInput = function () {
                    this.controls.JutokuInput().readOnly = false;
                    this.controls.JutokuInput().displayNone = false;

                    this.controls.JutokuTekiyoInput().readOnly = false;
                    this.controls.JutokuTekiyoInput().displayNone = false;
                    this.controls.txtTekiyoDate().readOnly = false;
                    this.controls.txtTekiyoTodokedeDate().readOnly = false;

                    this.controls.tekiyojiHokenshaJoho().readOnly = false;
                    this.controls.tekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyoJiyu().readOnly = false;
                    this.controls.ddlTekiyojiShozaiHokensha().readOnly = false;
                    this.controls.ddlTekiyojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlTekiyojiKyuHokensha().readOnly = false;
                    this.controls.ddlTekiyojiJuminJoho().readOnly = false;

                    this.controls.JutokuKaijoInput().readOnly = false;
                    this.controls.JutokuKaijoInput().displayNone = false;
                    this.controls.txtKaijoDate().readOnly = false;
                    this.controls.txtKaijoTodokedeDate().readOnly = false;

                    this.controls.kaijojiHokenshaJoho().readOnly = false;
                    this.controls.kaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijoJiyu().readOnly = false;
                    this.controls.ddlKaijojiShozaiHokensha().readOnly = false;
                    this.controls.ddlKaijojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlKaijojiKyuHokensha().readOnly = false;
                    this.controls.ddlKaijojiJuminJono().readOnly = false;

                    this.controls.btnJutokuKakutei().displayNone = false;
                    this.controls.btnJutokuTorikeshi().displayNone = false;
                };

                MeisaiDisplayMode.prototype.displayNone = function () {
                    this.controls.JutokuInput().displayNone = true;
                };
                return MeisaiDisplayMode;
            })();
            Modes.MeisaiDisplayMode = MeisaiDisplayMode;

            var HokenshaJohoDisplayMode = (function () {
                function HokenshaJohoDisplayMode(controls) {
                    this.controls = controls;
                }
                HokenshaJohoDisplayMode.prototype.TanitsuGappeiNashi = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[9].visible = false;
                    gridSetting.columns[10].visible = false;
                    gridSetting.columns[11].visible = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.tekiyojiHokenshaJoho().displayNone = true;
                    this.controls.kaijojiHokenshaJoho().displayNone = true;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.TanitsuGappeiAri = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[9].visible = false;
                    gridSetting.columns[10].visible = false;
                    gridSetting.columns[11].visible = true;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.tekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyojiShozaiHokensha().displayNone = true;
                    this.controls.ddlTekiyojiSochimotoHokensha().displayNone = true;
                    this.controls.ddlTekiyojiKyuHokensha().displayNone = false;
                    this.controls.ddlTekiyojiKyuHokensha().readOnly = false;
                    this.controls.ddlTekiyojiJuminJoho().displayNone = true;

                    this.controls.kaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijojiShozaiHokensha().displayNone = true;
                    this.controls.ddlKaijojiSochimotoHokensha().displayNone = true;
                    this.controls.ddlKaijojiKyuHokensha().displayNone = false;
                    this.controls.ddlKaijojiKyuHokensha().readOnly = false;
                    this.controls.ddlKaijojiJuminJono().displayNone = true;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.KoikiGappeiNashi = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[9].visible = true;
                    gridSetting.columns[10].visible = true;
                    gridSetting.columns[11].visible = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.tekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyojiShozaiHokensha().readOnly = false;
                    this.controls.ddlTekiyojiShozaiHokensha().displayNone = false;
                    this.controls.ddlTekiyojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlTekiyojiSochimotoHokensha().displayNone = false;
                    this.controls.ddlTekiyojiKyuHokensha().displayNone = true;
                    this.controls.ddlTekiyojiJuminJoho().readOnly = false;
                    this.controls.ddlTekiyojiJuminJoho().displayNone = false;

                    this.controls.kaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijojiShozaiHokensha().readOnly = false;
                    this.controls.ddlKaijojiShozaiHokensha().displayNone = false;
                    this.controls.ddlKaijojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlKaijojiSochimotoHokensha().displayNone = false;
                    this.controls.ddlKaijojiKyuHokensha().displayNone = true;
                    this.controls.ddlKaijojiJuminJono().readOnly = false;
                    this.controls.ddlKaijojiJuminJono().displayNone = false;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.KoikiGappeiAri = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[9].visible = true;
                    gridSetting.columns[10].visible = true;
                    gridSetting.columns[11].visible = true;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.tekiyojiHokenshaJoho().displayNone = false;
                    this.controls.ddlTekiyojiShozaiHokensha().readOnly = false;
                    this.controls.ddlTekiyojiShozaiHokensha().displayNone = false;
                    this.controls.ddlTekiyojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlTekiyojiSochimotoHokensha().displayNone = false;
                    this.controls.ddlTekiyojiKyuHokensha().readOnly = false;
                    this.controls.ddlTekiyojiKyuHokensha().displayNone = false;
                    this.controls.ddlTekiyojiJuminJoho().readOnly = false;
                    this.controls.ddlTekiyojiJuminJoho().displayNone = false;

                    this.controls.kaijojiHokenshaJoho().displayNone = false;
                    this.controls.ddlKaijojiShozaiHokensha().readOnly = false;
                    this.controls.ddlKaijojiShozaiHokensha().displayNone = false;
                    this.controls.ddlKaijojiSochimotoHokensha().readOnly = false;
                    this.controls.ddlKaijojiSochimotoHokensha().displayNone = false;
                    this.controls.ddlKaijojiKyuHokensha().readOnly = false;
                    this.controls.ddlKaijojiKyuHokensha().displayNone = false;
                    this.controls.ddlKaijojiJuminJono().readOnly = false;
                    this.controls.ddlKaijojiJuminJono().displayNone = false;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };
                return HokenshaJohoDisplayMode;
            })();
            Modes.HokenshaJohoDisplayMode = HokenshaJohoDisplayMode;

            var ShoriNichijiDisplayMode = (function () {
                function ShoriNichijiDisplayMode(controls) {
                    this.controls = controls;
                }
                ShoriNichijiDisplayMode.prototype.VisibleTrue = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[12].visible = true;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                ShoriNichijiDisplayMode.prototype.VisibleFalse = function () {
                    var gridSetting = this.controls.dgJutoku().gridSetting;

                    gridSetting.columns[12].visible = false;

                    this.controls.dgJutoku().gridSetting = gridSetting;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };
                return ShoriNichijiDisplayMode;
            })();
            Modes.ShoriNichijiDisplayMode = ShoriNichijiDisplayMode;

            var BtnDisplayMode = (function () {
                function BtnDisplayMode(controls) {
                    this.controls = controls;
                }
                BtnDisplayMode.prototype.SetDisplay = function () {
                    this.controls.btnAdd().displayNone = false;
                    this.controls.btnAdd().disabled = false;
                };

                BtnDisplayMode.prototype.SetDisplayNone = function () {
                    this.controls.btnAdd().displayNone = true;
                    this.controls.btnAdd().disabled = true;
                };
                return BtnDisplayMode;
            })();
            Modes.BtnDisplayMode = BtnDisplayMode;

            var DataGridWidth = (function () {
                function DataGridWidth(controls) {
                    this.controls = controls;
                }
                DataGridWidth.prototype.Size1 = function () {
                    this.controls.dgJutoku().width = 1070;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size2 = function () {
                    this.controls.dgJutoku().width = 1030;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size3 = function () {
                    this.controls.dgJutoku().width = 1020;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size4 = function () {
                    this.controls.dgJutoku().width = 950;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size5 = function () {
                    this.controls.dgJutoku().width = 910;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size6 = function () {
                    this.controls.dgJutoku().width = 900;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size7 = function () {
                    this.controls.dgJutoku().width = 830;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size8 = function () {
                    this.controls.dgJutoku().width = 790;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size9 = function () {
                    this.controls.dgJutoku().width = 780;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size10 = function () {
                    this.controls.dgJutoku().width = 710;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size11 = function () {
                    this.controls.dgJutoku().width = 660;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };
                return DataGridWidth;
            })();
            Modes.DataGridWidth = DataGridWidth;

            var DataGridHeight = (function () {
                function DataGridHeight(controls) {
                    this.controls = controls;
                }
                DataGridHeight.prototype.Size1 = function () {
                    this.controls.dgJutoku().height = 450;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size2 = function () {
                    this.controls.dgJutoku().height = 400;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size3 = function () {
                    this.controls.dgJutoku().height = 350;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size4 = function () {
                    this.controls.dgJutoku().height = 300;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size5 = function () {
                    this.controls.dgJutoku().height = 250;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size6 = function () {
                    this.controls.dgJutoku().height = 200;

                    this.controls.dgJutoku()._control.afterPropertiesSet();
                };
                return DataGridHeight;
            })();
            Modes.DataGridHeight = DataGridHeight;
        })(JushochiTokureiRirekiList.Modes || (JushochiTokureiRirekiList.Modes = {}));
        var Modes = JushochiTokureiRirekiList.Modes;
    })(DBZ.JushochiTokureiRirekiList || (DBZ.JushochiTokureiRirekiList = {}));
    var JushochiTokureiRirekiList = DBZ.JushochiTokureiRirekiList;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (JushochiTokureiRirekiList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new JushochiTokureiRirekiList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JushochiTokureiRirekiList.PublicProperties = PublicProperties;
    })(DBZ.JushochiTokureiRirekiList || (DBZ.JushochiTokureiRirekiList = {}));
    var JushochiTokureiRirekiList = DBZ.JushochiTokureiRirekiList;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShikakuTokusoRireki) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAddShikakuShutoku = function () {
                return "onClick_btnAddShikakuShutoku";
            };

            Events.onSelect_dgShikakuShutokuRireki = function () {
                return "onSelect_dgShikakuShutokuRireki";
            };

            Events.onSelectByDblClick_dgShikakuShutokuRireki = function () {
                return "onSelectByDblClick_dgShikakuShutokuRireki";
            };

            Events.onSelectByModifyButton_dgShikakuShutokuRireki = function () {
                return "onSelectByModifyButton_dgShikakuShutokuRireki";
            };

            Events.onSelectByDeleteButton_dgShikakuShutokuRireki = function () {
                return "onSelectByDeleteButton_dgShikakuShutokuRireki";
            };
            return Events;
        })();
        ShikakuTokusoRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShikakuTokusoRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShikakuTokusoRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShikakuTokusoRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShikakuTokusoRireki = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAddShikakuShutoku = function () {
                return new UZA.Button(this.convFiledName("btnAddShikakuShutoku"));
            };

            Controls.prototype.dgShikakuShutokuRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgShikakuShutokuRireki"));
            };
            return Controls;
        })();
        ShikakuTokusoRireki.Controls = Controls;
    })(DBZ.ShikakuTokusoRireki || (DBZ.ShikakuTokusoRireki = {}));
    var ShikakuTokusoRireki = DBZ.ShikakuTokusoRireki;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShikakuTokusoRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShikakuTokusoRireki.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShikakuTokusoRireki.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "DisplayType",
                    "BtnDisplayMode",
                    "HokenshaJohoDisplayMode",
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

            ModeController.prototype.DataGridWidth = function () {
                return new Modes.DataGridWidth(this.controls);
            };

            ModeController.prototype.DataGridHeight = function () {
                return new Modes.DataGridHeight(this.controls);
            };
            return ModeController;
        })();
        ShikakuTokusoRireki.ModeController = ModeController;

        (function (Modes) {
            var DisplayType = (function () {
                function DisplayType(controls) {
                    this.controls = controls;
                }
                DisplayType.prototype.shokai = function () {
                    this.controls.dgShikakuShutokuRireki().readOnly = false;

                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;
                    gridSetting.columns[0].visible = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgShikakuShutokuRireki().width;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DisplayType.prototype.toroku = function () {
                    this.controls.dgShikakuShutokuRireki().readOnly = false;

                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgShikakuShutokuRireki().width;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DisplayType.prototype.teiseitoroku = function () {
                    this.controls.dgShikakuShutokuRireki().readOnly = false;

                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgShikakuShutokuRireki().width;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };
                return DisplayType;
            })();
            Modes.DisplayType = DisplayType;

            var BtnDisplayMode = (function () {
                function BtnDisplayMode(controls) {
                    this.controls = controls;
                }
                BtnDisplayMode.prototype.SetDisplay = function () {
                    this.controls.btnAddShikakuShutoku().displayNone = false;
                };

                BtnDisplayMode.prototype.SetDisplayNone = function () {
                    this.controls.btnAddShikakuShutoku().displayNone = true;
                };
                return BtnDisplayMode;
            })();
            Modes.BtnDisplayMode = BtnDisplayMode;

            var HokenshaJohoDisplayMode = (function () {
                function HokenshaJohoDisplayMode(controls) {
                    this.controls = controls;
                }
                HokenshaJohoDisplayMode.prototype.TanitsuGappeiNashi = function () {
                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[14].visible = false;
                    gridSetting.columns[15].visible = false;
                    gridSetting.columns[16].visible = false;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.TanitsuGappeiAri = function () {
                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[14].visible = false;
                    gridSetting.columns[15].visible = false;
                    gridSetting.columns[16].visible = true;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.KoikiGappeiNashi = function () {
                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[14].visible = true;
                    gridSetting.columns[15].visible = true;
                    gridSetting.columns[16].visible = false;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                HokenshaJohoDisplayMode.prototype.KoikiGappeiAri = function () {
                    var gridSetting = this.controls.dgShikakuShutokuRireki().gridSetting;

                    gridSetting.columns[14].visible = true;
                    gridSetting.columns[15].visible = true;
                    gridSetting.columns[16].visible = true;

                    this.controls.dgShikakuShutokuRireki().gridSetting = gridSetting;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };
                return HokenshaJohoDisplayMode;
            })();
            Modes.HokenshaJohoDisplayMode = HokenshaJohoDisplayMode;

            var DataGridWidth = (function () {
                function DataGridWidth(controls) {
                    this.controls = controls;
                }
                DataGridWidth.prototype.Size1 = function () {
                    this.controls.dgShikakuShutokuRireki().width = 1090;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size2 = function () {
                    this.controls.dgShikakuShutokuRireki().width = 1050;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size3 = function () {
                    this.controls.dgShikakuShutokuRireki().width = 1020;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size4 = function () {
                    this.controls.dgShikakuShutokuRireki().width = 970;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size5 = function () {
                    this.controls.dgShikakuShutokuRireki().width = 920;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DataGridWidth.prototype.Size6 = function () {
                    this.controls.dgShikakuShutokuRireki().width = 870;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };
                return DataGridWidth;
            })();
            Modes.DataGridWidth = DataGridWidth;

            var DataGridHeight = (function () {
                function DataGridHeight(controls) {
                    this.controls = controls;
                }
                DataGridHeight.prototype.SizeDefault = function () {
                    this.controls.dgShikakuShutokuRireki().height = 217;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };

                DataGridHeight.prototype.Size300 = function () {
                    this.controls.dgShikakuShutokuRireki().height = 300;

                    this.controls.dgShikakuShutokuRireki()._control.afterPropertiesSet();
                };
                return DataGridHeight;
            })();
            Modes.DataGridHeight = DataGridHeight;
        })(ShikakuTokusoRireki.Modes || (ShikakuTokusoRireki.Modes = {}));
        var Modes = ShikakuTokusoRireki.Modes;
    })(DBZ.ShikakuTokusoRireki || (DBZ.ShikakuTokusoRireki = {}));
    var ShikakuTokusoRireki = DBZ.ShikakuTokusoRireki;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShikakuTokusoRireki) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShikakuTokusoRireki.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShikakuTokusoRireki.PublicProperties = PublicProperties;
    })(DBZ.ShikakuTokusoRireki || (DBZ.ShikakuTokusoRireki = {}));
    var ShikakuTokusoRireki = DBZ.ShikakuTokusoRireki;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShisetsuNyutaishoRirekiKanri) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAddShisetsuNyutaisho = function () {
                return "onClick_btnAddShisetsuNyutaisho";
            };

            Events.onSelect_dgShisetsuNyutaishoRireki = function () {
                return "onSelect_dgShisetsuNyutaishoRireki";
            };

            Events.onSelectByDblClick_dgShisetsuNyutaishoRireki = function () {
                return "onSelectByDblClick_dgShisetsuNyutaishoRireki";
            };

            Events.onSelectBySelectButton_dgShisetsuNyutaishoRireki = function () {
                return "onSelectBySelectButton_dgShisetsuNyutaishoRireki";
            };

            Events.onSelectByModifyButton_dgShisetsuNyutaishoRireki = function () {
                return "onSelectByModifyButton_dgShisetsuNyutaishoRireki";
            };

            Events.onSelectByDeleteButton_dgShisetsuNyutaishoRireki = function () {
                return "onSelectByDeleteButton_dgShisetsuNyutaishoRireki";
            };

            Events.onClick_btnShisetsuNyutaishoKakutei = function () {
                return "onClick_btnShisetsuNyutaishoKakutei";
            };

            Events.onClick_btnShisetsuNyutaishoTorikeshi = function () {
                return "onClick_btnShisetsuNyutaishoTorikeshi";
            };
            return Events;
        })();
        ShisetsuNyutaishoRirekiKanri.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShisetsuNyutaishoRirekiKanri";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShisetsuNyutaishoRirekiKanri.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShisetsuNyutaishoRirekiKanri.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShisetsuNyutaishoRirekiKanri = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAddShisetsuNyutaisho = function () {
                return new UZA.Button(this.convFiledName("btnAddShisetsuNyutaisho"));
            };

            Controls.prototype.dgShisetsuNyutaishoRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgShisetsuNyutaishoRireki"));
            };

            Controls.prototype.ShisetsuNyutaishoInput = function () {
                return new UZA.Panel(this.convFiledName("ShisetsuNyutaishoInput"));
            };

            Controls.prototype.txtNyushoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNyushoDate"));
            };

            Controls.prototype.txtTaishoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTaishoDate"));
            };

            Controls.prototype.ccdShisetsuJoho = function () {
                return new DBZ.ShisetsuJoho.ModeController(this.convFiledName("ccdShisetsuJoho"));
            };

            Controls.prototype.btnShisetsuNyutaishoKakutei = function () {
                return new UZA.Button(this.convFiledName("btnShisetsuNyutaishoKakutei"));
            };

            Controls.prototype.btnShisetsuNyutaishoTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnShisetsuNyutaishoTorikeshi"));
            };
            return Controls;
        })();
        ShisetsuNyutaishoRirekiKanri.Controls = Controls;
    })(DBZ.ShisetsuNyutaishoRirekiKanri || (DBZ.ShisetsuNyutaishoRirekiKanri = {}));
    var ShisetsuNyutaishoRirekiKanri = DBZ.ShisetsuNyutaishoRirekiKanri;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShisetsuNyutaishoRirekiKanri) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShisetsuNyutaishoRirekiKanri.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "表示モード",
                    "表示Heightサイズ",
                    "表示widthサイズ",
                    "台帳種別の列を",
                    "明細表示モード"
                ];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShisetsuNyutaishoRirekiKanri.PublicProperties(this.fieldName);
            };

            ModeController.prototype.表示モード = function () {
                return new Modes.表示モード(this.controls);
            };

            ModeController.prototype.表示Heightサイズ = function () {
                return new Modes.表示heightサイズ(this.controls);
            };

            ModeController.prototype.表示widthサイズ = function () {
                return new Modes.表示widthサイズ(this.controls);
            };

            ModeController.prototype.台帳種別の列を = function () {
                return new Modes.台帳種別の列を(this.controls);
            };

            ModeController.prototype.明細表示モード = function () {
                return new Modes.明細表示モード(this.controls);
            };
            return ModeController;
        })();
        ShisetsuNyutaishoRirekiKanri.ModeController = ModeController;

        (function (Modes) {
            var 表示モード = (function () {
                function 表示モード(controls) {
                    this.controls = controls;
                }
                表示モード.prototype.登録 = function () {
                    this.controls.btnAddShisetsuNyutaisho().displayNone = false;

                    var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;
                    gridSetting.isShowDeleteButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'state') {
                            columns[i].visible = false;
                        }
                    }
                    gridSetting.columns = columns;

                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();
                };

                表示モード.prototype.照会 = function () {
                    this.controls.btnAddShisetsuNyutaisho().displayNone = true;

                    var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;
                    gridSetting.isShowDeleteButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'state') {
                            columns[i].visible = false;
                        }
                    }
                    gridSetting.columns = columns;

                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();
                };

                表示モード.prototype.資格異動 = function () {
                    this.controls.btnAddShisetsuNyutaisho().displayNone = false;

                    var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;
                    gridSetting.isShowDeleteButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = true;
                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'state') {
                            columns[i].visible = true;
                        }
                    }

                    gridSetting.columns = columns;

                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();
                };
                return 表示モード;
            })();
            Modes.表示モード = 表示モード;

            var 表示heightサイズ = (function () {
                function 表示heightサイズ(controls) {
                    this.controls = controls;
                }
                表示heightサイズ.prototype.サイズ200 = function () {
                    this.controls.dgShisetsuNyutaishoRireki().height = "200";
                };

                表示heightサイズ.prototype.サイズ250 = function () {
                    this.controls.dgShisetsuNyutaishoRireki().height = "250";
                };

                表示heightサイズ.prototype.サイズ300 = function () {
                    this.controls.dgShisetsuNyutaishoRireki().height = "300";
                };

                表示heightサイズ.prototype.サイズ350 = function () {
                    this.controls.dgShisetsuNyutaishoRireki().height = "350";
                };

                表示heightサイズ.prototype.サイズ400 = function () {
                    this.controls.dgShisetsuNyutaishoRireki().height = "400";
                };

                表示heightサイズ.prototype.サイズ450 = function () {
                    this.controls.dgShisetsuNyutaishoRireki().height = "450";
                };

                表示heightサイズ.prototype.サイズ500 = function () {
                    this.controls.dgShisetsuNyutaishoRireki().height = "500";
                };
                return 表示heightサイズ;
            })();
            Modes.表示heightサイズ = 表示heightサイズ;

            var 表示widthサイズ = (function () {
                function 表示widthサイズ(controls) {
                    this.controls = controls;
                }
                表示widthサイズ.prototype.モード1 = function () {
                    this.controls.dgShisetsuNyutaishoRireki().width = "1030";
                };

                表示widthサイズ.prototype.モード2 = function () {
                    this.controls.dgShisetsuNyutaishoRireki().width = "980";
                };

                表示widthサイズ.prototype.モード3 = function () {
                    this.controls.dgShisetsuNyutaishoRireki().width = "900";
                };

                表示widthサイズ.prototype.モード4 = function () {
                    this.controls.dgShisetsuNyutaishoRireki().width = "800";
                };

                表示widthサイズ.prototype.モード5 = function () {
                    this.controls.dgShisetsuNyutaishoRireki().width = "720";
                };
                return 表示widthサイズ;
            })();
            Modes.表示widthサイズ = 表示widthサイズ;

            var 台帳種別の列を = (function () {
                function 台帳種別の列を(controls) {
                    this.controls = controls;
                }
                台帳種別の列を.prototype.表示しない = function () {
                    var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;

                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'daichoShubetsu') {
                            columns[i].visible = false;
                        }
                    }
                    gridSetting.columns = columns;

                    this.controls.ccdShisetsuJoho().台帳種別().台帳種別非表示する();

                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();
                };

                台帳種別の列を.prototype.表示する = function () {
                    var gridSetting = this.controls.dgShisetsuNyutaishoRireki().gridSetting;

                    var columns = gridSetting.columns;
                    for (var i = 0; i < columns.length; i++) {
                        if (columns[i].dataName === 'daichoShubetsu') {
                            columns[i].visible = true;
                        }
                    }
                    gridSetting.columns = columns;

                    this.controls.ccdShisetsuJoho().台帳種別().台帳種別表示する();

                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();
                };
                return 台帳種別の列を;
            })();
            Modes.台帳種別の列を = 台帳種別の列を;

            var 明細表示モード = (function () {
                function 明細表示モード(controls) {
                    this.controls = controls;
                }
                明細表示モード.prototype.追加_修正 = function () {
                    this.controls.ShisetsuNyutaishoInput().displayNone = false;
                    this.controls.ShisetsuNyutaishoInput().readOnly = false;

                    this.controls.txtNyushoDate().displayNone = false;
                    this.controls.txtNyushoDate().readOnly = false;
                    this.controls.txtTaishoDate().displayNone = false;
                    this.controls.txtTaishoDate().readOnly = false;
                    this.controls.ccdShisetsuJoho().表示モード().defaultView();
                    this.controls.btnShisetsuNyutaishoKakutei().displayNone = false;
                    this.controls.btnShisetsuNyutaishoKakutei().disabled = false;
                    this.controls.btnShisetsuNyutaishoTorikeshi().displayNone = false;
                    this.controls.btnShisetsuNyutaishoTorikeshi().disabled = false;
                };

                明細表示モード.prototype.削除 = function () {
                    this.controls.ShisetsuNyutaishoInput().displayNone = false;
                    this.controls.ShisetsuNyutaishoInput().readOnly = false;

                    this.controls.txtNyushoDate().displayNone = false;
                    this.controls.txtNyushoDate().readOnly = true;
                    this.controls.txtTaishoDate().displayNone = false;
                    this.controls.txtTaishoDate().readOnly = true;
                    this.controls.ccdShisetsuJoho().表示モード().readOnly();
                    this.controls.btnShisetsuNyutaishoKakutei().displayNone = false;
                    this.controls.btnShisetsuNyutaishoKakutei().disabled = false;
                    this.controls.btnShisetsuNyutaishoTorikeshi().displayNone = false;
                    this.controls.btnShisetsuNyutaishoTorikeshi().disabled = false;
                };

                明細表示モード.prototype.選択不可 = function () {
                    this.controls.ShisetsuNyutaishoInput().displayNone = false;
                    this.controls.ShisetsuNyutaishoInput().readOnly = true;

                    this.controls.txtNyushoDate().displayNone = false;
                    this.controls.txtNyushoDate().readOnly = true;
                    this.controls.txtTaishoDate().displayNone = false;
                    this.controls.txtTaishoDate().readOnly = true;
                    this.controls.ccdShisetsuJoho().表示モード().readOnly();
                    this.controls.btnShisetsuNyutaishoKakutei().displayNone = false;
                    this.controls.btnShisetsuNyutaishoKakutei().disabled = true;
                    this.controls.btnShisetsuNyutaishoTorikeshi().displayNone = false;
                    this.controls.btnShisetsuNyutaishoTorikeshi().disabled = true;
                };

                明細表示モード.prototype.非表示 = function () {
                    this.controls.ShisetsuNyutaishoInput().displayNone = true;
                    this.controls.ShisetsuNyutaishoInput().readOnly = true;
                };
                return 明細表示モード;
            })();
            Modes.明細表示モード = 明細表示モード;
        })(ShisetsuNyutaishoRirekiKanri.Modes || (ShisetsuNyutaishoRirekiKanri.Modes = {}));
        var Modes = ShisetsuNyutaishoRirekiKanri.Modes;
    })(DBZ.ShisetsuNyutaishoRirekiKanri || (DBZ.ShisetsuNyutaishoRirekiKanri = {}));
    var ShisetsuNyutaishoRirekiKanri = DBZ.ShisetsuNyutaishoRirekiKanri;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShisetsuNyutaishoRirekiKanri) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShisetsuNyutaishoRirekiKanri.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShisetsuNyutaishoRirekiKanri.PublicProperties = PublicProperties;
    })(DBZ.ShisetsuNyutaishoRirekiKanri || (DBZ.ShisetsuNyutaishoRirekiKanri = {}));
    var ShisetsuNyutaishoRirekiKanri = DBZ.ShisetsuNyutaishoRirekiKanri;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShoKaishuJokyoList) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelect_dgShoKaishuJokyo = function () {
                return "onSelect_dgShoKaishuJokyo";
            };

            Events.onSelectBySelectButton_dgShoKaishuJokyo = function () {
                return "onSelectBySelectButton_dgShoKaishuJokyo";
            };
            return Events;
        })();
        ShoKaishuJokyoList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShoKaishuJokyoList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShoKaishuJokyoList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShoKaishuJokyoList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShoKaishuJokyoList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgShoKaishuJokyo = function () {
                return new UZA.DataGrid(this.convFiledName("dgShoKaishuJokyo"));
            };
            return Controls;
        })();
        ShoKaishuJokyoList.Controls = Controls;
    })(DBZ.ShoKaishuJokyoList || (DBZ.ShoKaishuJokyoList = {}));
    var ShoKaishuJokyoList = DBZ.ShoKaishuJokyoList;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShoKaishuJokyoList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShoKaishuJokyoList.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "グリッド表示モード",
                    "一覧パネル高さ"
                ];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShoKaishuJokyoList.PublicProperties(this.fieldName);
            };

            ModeController.prototype.グリッド表示モード = function () {
                return new Modes.グリッド表示モード(this.controls);
            };

            ModeController.prototype.一覧パネル高さ = function () {
                return new Modes.一覧パネル高さ(this.controls);
            };
            return ModeController;
        })();
        ShoKaishuJokyoList.ModeController = ModeController;

        (function (Modes) {
            var グリッド表示モード = (function () {
                function グリッド表示モード(controls) {
                    this.controls = controls;
                }
                グリッド表示モード.prototype.shokai = function () {
                    var gridSetting = this.controls.dgShoKaishuJokyo().gridSetting;

                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.columns[0].visible = false;

                    this.controls.dgShoKaishuJokyo().gridSetting = gridSetting;

                    this.controls.dgShoKaishuJokyo()._control.afterPropertiesSet();
                };

                グリッド表示モード.prototype.toroku = function () {
                    var gridSetting = this.controls.dgShoKaishuJokyo().gridSetting;

                    gridSetting.isShowSelectButtonColumn = true;
                    gridSetting.columns[0].visible = true;

                    this.controls.dgShoKaishuJokyo().gridSetting = gridSetting;

                    this.controls.dgShoKaishuJokyo()._control.afterPropertiesSet();
                };

                グリッド表示モード.prototype.select = function () {
                    var gridSetting = this.controls.dgShoKaishuJokyo().gridSetting;

                    gridSetting.isShowSelectButtonColumn = true;
                    gridSetting.columns[0].visible = false;

                    this.controls.dgShoKaishuJokyo().gridSetting = gridSetting;

                    this.controls.dgShoKaishuJokyo()._control.afterPropertiesSet();
                };
                return グリッド表示モード;
            })();
            Modes.グリッド表示モード = グリッド表示モード;

            var 一覧パネル高さ = (function () {
                function 一覧パネル高さ(controls) {
                    this.controls = controls;
                }
                一覧パネル高さ.prototype.サイズ200 = function () {
                    this.controls.dgShoKaishuJokyo().height = "200";
                };

                一覧パネル高さ.prototype.サイズ250 = function () {
                    this.controls.dgShoKaishuJokyo().height = "250";
                };

                一覧パネル高さ.prototype.サイズ300 = function () {
                    this.controls.dgShoKaishuJokyo().height = "300";
                };

                一覧パネル高さ.prototype.サイズ350 = function () {
                    this.controls.dgShoKaishuJokyo().height = "350";
                };

                一覧パネル高さ.prototype.サイズ400 = function () {
                    this.controls.dgShoKaishuJokyo().height = "400";
                };

                一覧パネル高さ.prototype.サイズ450 = function () {
                    this.controls.dgShoKaishuJokyo().height = "450";
                };

                一覧パネル高さ.prototype.サイズ500 = function () {
                    this.controls.dgShoKaishuJokyo().height = "500";
                };
                return 一覧パネル高さ;
            })();
            Modes.一覧パネル高さ = 一覧パネル高さ;
        })(ShoKaishuJokyoList.Modes || (ShoKaishuJokyoList.Modes = {}));
        var Modes = ShoKaishuJokyoList.Modes;
    })(DBZ.ShoKaishuJokyoList || (DBZ.ShoKaishuJokyoList = {}));
    var ShoKaishuJokyoList = DBZ.ShoKaishuJokyoList;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShoKaishuJokyoList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShoKaishuJokyoList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShoKaishuJokyoList.PublicProperties = PublicProperties;
    })(DBZ.ShoKaishuJokyoList || (DBZ.ShoKaishuJokyoList = {}));
    var ShoKaishuJokyoList = DBZ.ShoKaishuJokyoList;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShoKaishuJokyoShosai) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ShoKaishuJokyoShosai.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShoKaishuJokyoShosai";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShoKaishuJokyoShosai.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShoKaishuJokyoShosai.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShoKaishuJokyoShosai = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtShoKofuShurui = function () {
                return new UZA.TextBox(this.convFiledName("txtShoKofuShurui"));
            };

            Controls.prototype.txtKofuDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKofuDate"));
            };

            Controls.prototype.txtYukoKigen = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYukoKigen"));
            };

            Controls.prototype.txtKofuJiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtKofuJiyu"));
            };

            Controls.prototype.txtKofuRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKofuRiyu"));
            };

            Controls.prototype.txtKaishuDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKaishuDate"));
            };

            Controls.prototype.ddlKaishuJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKaishuJiyu"));
            };

            Controls.prototype.txtKaishuRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKaishuRiyu"));
            };
            return Controls;
        })();
        ShoKaishuJokyoShosai.Controls = Controls;
    })(DBZ.ShoKaishuJokyoShosai || (DBZ.ShoKaishuJokyoShosai = {}));
    var ShoKaishuJokyoShosai = DBZ.ShoKaishuJokyoShosai;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShoKaishuJokyoShosai) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShoKaishuJokyoShosai.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "表示方法"
                ];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShoKaishuJokyoShosai.PublicProperties(this.fieldName);
            };

            ModeController.prototype.表示方法 = function () {
                return new Modes.表示方法(this.controls);
            };
            return ModeController;
        })();
        ShoKaishuJokyoShosai.ModeController = ModeController;

        (function (Modes) {
            var 表示方法 = (function () {
                function 表示方法(controls) {
                    this.controls = controls;
                }
                表示方法.prototype.照会 = function () {
                    this.controls.ShoKaishuJokyoShosai().readOnly = true;
                    this.controls.ShoKaishuJokyoShosai().displayNone = false;
                };

                表示方法.prototype.入力 = function () {
                    this.controls.ShoKaishuJokyoShosai().readOnly = false;
                    this.controls.ShoKaishuJokyoShosai().displayNone = false;
                };

                表示方法.prototype.非表示 = function () {
                    this.controls.ShoKaishuJokyoShosai().readOnly = true;
                    this.controls.ShoKaishuJokyoShosai().displayNone = true;
                };
                return 表示方法;
            })();
            Modes.表示方法 = 表示方法;
        })(ShoKaishuJokyoShosai.Modes || (ShoKaishuJokyoShosai.Modes = {}));
        var Modes = ShoKaishuJokyoShosai.Modes;
    })(DBZ.ShoKaishuJokyoShosai || (DBZ.ShoKaishuJokyoShosai = {}));
    var ShoKaishuJokyoShosai = DBZ.ShoKaishuJokyoShosai;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShoKaishuJokyoShosai) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShoKaishuJokyoShosai.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("ShoKaishuJokyoShosai_panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ShoKaishuJokyoShosai_canOpenAndClose", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getShoKaishuJokyoShosai_panelDisplay = function () {
                return this.controls.ShoKaishuJokyoShosai().panelDisplay;
            };

            PublicProperties.prototype.setShoKaishuJokyoShosai_panelDisplay = function (value) {
                this.controls.ShoKaishuJokyoShosai().panelDisplay = value;
            };

            PublicProperties.prototype.getShoKaishuJokyoShosai_canOpenAndClose = function () {
                return this.controls.ShoKaishuJokyoShosai().canOpenAndClose;
            };

            PublicProperties.prototype.setShoKaishuJokyoShosai_canOpenAndClose = function (value) {
                this.controls.ShoKaishuJokyoShosai().canOpenAndClose = value;
            };
            return PublicProperties;
        })();
        ShoKaishuJokyoShosai.PublicProperties = PublicProperties;
    })(DBZ.ShoKaishuJokyoShosai || (DBZ.ShoKaishuJokyoShosai = {}));
    var ShoKaishuJokyoShosai = DBZ.ShoKaishuJokyoShosai;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShoKaishuKirokuKanri) {
        var Events = (function () {
            function Events() {
            }
            Events.onBeforeClick_btnShoKaishuKakutei = function () {
                return "onBeforeClick_btnShoKaishuKakutei";
            };

            Events.onClick_btnShoKaishuKakutei = function () {
                return "onClick_btnShoKaishuKakutei";
            };

            Events.onClick_btnShoKaishuTorikeshi = function () {
                return "onClick_btnShoKaishuTorikeshi";
            };
            return Events;
        })();
        ShoKaishuKirokuKanri.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShoKaishuKirokuKanri";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShoKaishuKirokuKanri.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShoKaishuKirokuKanri.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShoKaishuKirokuKanri = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdShoKaishuJokyoList = function () {
                return new DBZ.ShoKaishuJokyoList.ModeController(this.convFiledName("ccdShoKaishuJokyoList"));
            };

            Controls.prototype.ccdShoKaishuJokyoShosai = function () {
                return new DBZ.ShoKaishuJokyoShosai.ModeController(this.convFiledName("ccdShoKaishuJokyoShosai"));
            };

            Controls.prototype.btnShoKaishuKakutei = function () {
                return new UZA.Button(this.convFiledName("btnShoKaishuKakutei"));
            };

            Controls.prototype.btnShoKaishuTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnShoKaishuTorikeshi"));
            };
            return Controls;
        })();
        ShoKaishuKirokuKanri.Controls = Controls;
    })(DBZ.ShoKaishuKirokuKanri || (DBZ.ShoKaishuKirokuKanri = {}));
    var ShoKaishuKirokuKanri = DBZ.ShoKaishuKirokuKanri;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShoKaishuKirokuKanri) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShoKaishuKirokuKanri.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "表示方法",
                    "グリッド表示モード",
                    "一覧パネル高さ"
                ];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShoKaishuKirokuKanri.PublicProperties(this.fieldName);
            };

            ModeController.prototype.表示方法 = function () {
                return new Modes.表示方法(this.controls);
            };

            ModeController.prototype.グリッド表示モード = function () {
                return new Modes.グリッド表示モード(this.controls);
            };

            ModeController.prototype.一覧パネル高さ = function () {
                return new Modes.一覧パネル高さ(this.controls);
            };
            return ModeController;
        })();
        ShoKaishuKirokuKanri.ModeController = ModeController;

        (function (Modes) {
            var 表示方法 = (function () {
                function 表示方法(controls) {
                    this.controls = controls;
                }
                表示方法.prototype.照会 = function () {
                    this.controls.ccdShoKaishuJokyoShosai().表示方法().照会();
                    this.controls.btnShoKaishuKakutei().disabled = true;
                    this.controls.btnShoKaishuTorikeshi().disabled = true;
                    this.controls.btnShoKaishuKakutei().displayNone = false;
                    this.controls.btnShoKaishuTorikeshi().displayNone = false;
                };

                表示方法.prototype.入力 = function () {
                    this.controls.ccdShoKaishuJokyoShosai().表示方法().入力();
                    this.controls.btnShoKaishuKakutei().disabled = false;
                    this.controls.btnShoKaishuTorikeshi().disabled = false;
                    this.controls.btnShoKaishuKakutei().displayNone = false;
                    this.controls.btnShoKaishuTorikeshi().displayNone = false;
                };

                表示方法.prototype.非表示 = function () {
                    this.controls.ccdShoKaishuJokyoShosai().表示方法().非表示();
                    this.controls.btnShoKaishuKakutei().displayNone = true;
                    this.controls.btnShoKaishuTorikeshi().displayNone = true;
                };
                return 表示方法;
            })();
            Modes.表示方法 = 表示方法;

            var グリッド表示モード = (function () {
                function グリッド表示モード(controls) {
                    this.controls = controls;
                }
                グリッド表示モード.prototype.shokai = function () {
                    this.controls.ccdShoKaishuJokyoList().グリッド表示モード().shokai();
                };

                グリッド表示モード.prototype.toroku = function () {
                    this.controls.ccdShoKaishuJokyoList().グリッド表示モード().toroku();
                };

                グリッド表示モード.prototype.select = function () {
                    this.controls.ccdShoKaishuJokyoList().グリッド表示モード().select();
                };
                return グリッド表示モード;
            })();
            Modes.グリッド表示モード = グリッド表示モード;

            var 一覧パネル高さ = (function () {
                function 一覧パネル高さ(controls) {
                    this.controls = controls;
                }
                一覧パネル高さ.prototype.サイズ200 = function () {
                    this.controls.ccdShoKaishuJokyoList().一覧パネル高さ().サイズ200();
                };

                一覧パネル高さ.prototype.サイズ250 = function () {
                    this.controls.ccdShoKaishuJokyoList().一覧パネル高さ().サイズ250();
                };

                一覧パネル高さ.prototype.サイズ300 = function () {
                    this.controls.ccdShoKaishuJokyoList().一覧パネル高さ().サイズ300();
                };

                一覧パネル高さ.prototype.サイズ350 = function () {
                    this.controls.ccdShoKaishuJokyoList().一覧パネル高さ().サイズ350();
                };

                一覧パネル高さ.prototype.サイズ400 = function () {
                    this.controls.ccdShoKaishuJokyoList().一覧パネル高さ().サイズ400();
                };

                一覧パネル高さ.prototype.サイズ450 = function () {
                    this.controls.ccdShoKaishuJokyoList().一覧パネル高さ().サイズ450();
                };

                一覧パネル高さ.prototype.サイズ500 = function () {
                    this.controls.ccdShoKaishuJokyoList().一覧パネル高さ().サイズ500();
                };
                return 一覧パネル高さ;
            })();
            Modes.一覧パネル高さ = 一覧パネル高さ;
        })(ShoKaishuKirokuKanri.Modes || (ShoKaishuKirokuKanri.Modes = {}));
        var Modes = ShoKaishuKirokuKanri.Modes;
    })(DBZ.ShoKaishuKirokuKanri || (DBZ.ShoKaishuKirokuKanri = {}));
    var ShoKaishuKirokuKanri = DBZ.ShoKaishuKirokuKanri;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShoKaishuKirokuKanri) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShoKaishuKirokuKanri.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("ShoKaishuJokyoShosai_panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ShoKaishuJokyoShosai_canOpenAndClose", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getShoKaishuJokyoShosai_panelDisplay = function () {
                return this.controls.ccdShoKaishuJokyoShosai().PublicProperties().getShoKaishuJokyoShosai_panelDisplay;
            };

            PublicProperties.prototype.setShoKaishuJokyoShosai_panelDisplay = function (value) {
                this.controls.ccdShoKaishuJokyoShosai().PublicProperties().setShoKaishuJokyoShosai_panelDisplay = value;
            };

            PublicProperties.prototype.getShoKaishuJokyoShosai_canOpenAndClose = function () {
                return this.controls.ccdShoKaishuJokyoShosai().PublicProperties().getShoKaishuJokyoShosai_canOpenAndClose;
            };

            PublicProperties.prototype.setShoKaishuJokyoShosai_canOpenAndClose = function (value) {
                this.controls.ccdShoKaishuJokyoShosai().PublicProperties().setShoKaishuJokyoShosai_canOpenAndClose = value;
            };
            return PublicProperties;
        })();
        ShoKaishuKirokuKanri.PublicProperties = PublicProperties;
    })(DBZ.ShoKaishuKirokuKanri || (DBZ.ShoKaishuKirokuKanri = {}));
    var ShoKaishuKirokuKanri = DBZ.ShoKaishuKirokuKanri;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShinseishaInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_ddlShinseishaKubun = function () {
                return "onChange_ddlShinseishaKubun";
            };
            return Events;
        })();
        ShinseishaInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShinseishaInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShinseishaInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShinseishaInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShinseishaInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtShinseiDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiDate"));
            };

            Controls.prototype.ddlShinseishaKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShinseishaKubun"));
            };

            Controls.prototype.txtUketsukeDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtUketsukeDate"));
            };

            Controls.prototype.txtShinseiRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinseiRiyu"));
            };

            Controls.prototype.txtJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));
            };

            Controls.prototype.btnJigyoshaInputGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnJigyoshaInputGuide"));
            };

            Controls.prototype.btnHonninJohoCopy = function () {
                return new UZA.Button(this.convFiledName("btnHonninJohoCopy"));
            };

            Controls.prototype.ddlHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHokensha"));
            };

            Controls.prototype.txtShinseishaNameKana = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseishaNameKana"));
            };

            Controls.prototype.txtShinseishaName = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseishaName"));
            };

            Controls.prototype.txtTelNo = function () {
                return new UZA.TextBox(this.convFiledName("txtTelNo"));
            };

            Controls.prototype.txtYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            };

            Controls.prototype.txtAddress = function () {
                return new UZA.TextBox(this.convFiledName("txtAddress"));
            };
            return Controls;
        })();
        ShinseishaInfo.Controls = Controls;
    })(DBZ.ShinseishaInfo || (DBZ.ShinseishaInfo = {}));
    var ShinseishaInfo = DBZ.ShinseishaInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShinseishaInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShinseishaInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShinseishaInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShinseishaInfo.ModeController = ModeController;
    })(DBZ.ShinseishaInfo || (DBZ.ShinseishaInfo = {}));
    var ShinseishaInfo = DBZ.ShinseishaInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShinseishaInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShinseishaInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("btnJigyoshaInputGuide_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtUkestukeDate_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtJigyoshaNo_disabled", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtShinseishaName_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtYubinNo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtAddress_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnJigyoshaInputGuide_disabled", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("shinseishaInfo_eraseBorder", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getbtnJigyoshaInputGuide_displayNone = function () {
                return this.controls.btnJigyoshaInputGuide().displayNone;
            };

            PublicProperties.prototype.setbtnJigyoshaInputGuide_displayNone = function (value) {
                this.controls.btnJigyoshaInputGuide().displayNone = value;
            };

            PublicProperties.prototype.gettxtUkestukeDate_displayNone = function () {
                return this.controls.txtUketsukeDate().displayNone;
            };

            PublicProperties.prototype.settxtUkestukeDate_displayNone = function (value) {
                this.controls.txtUketsukeDate().displayNone = value;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.ShinseishaInfo().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.ShinseishaInfo().title = value;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.ShinseishaInfo().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.ShinseishaInfo().panelDisplay = value;
            };

            PublicProperties.prototype.gettxtJigyoshaNo_disabled = function () {
                return this.controls.txtJigyoshaNo().disabled;
            };

            PublicProperties.prototype.settxtJigyoshaNo_disabled = function (value) {
                this.controls.txtJigyoshaNo().disabled = value;
            };

            PublicProperties.prototype.gettxtShinseishaName_labelLText = function () {
                return this.controls.txtShinseishaNameKana().labelLText;
            };

            PublicProperties.prototype.settxtShinseishaName_labelLText = function (value) {
                this.controls.txtShinseishaNameKana().labelLText = value;
            };

            PublicProperties.prototype.gettxtYubinNo_displayNone = function () {
                return this.controls.txtYubinNo().displayNone;
            };

            PublicProperties.prototype.settxtYubinNo_displayNone = function (value) {
                this.controls.txtYubinNo().displayNone = value;
            };

            PublicProperties.prototype.gettxtAddress_displayNone = function () {
                return this.controls.txtAddress().displayNone;
            };

            PublicProperties.prototype.settxtAddress_displayNone = function (value) {
                this.controls.txtAddress().displayNone = value;
            };

            PublicProperties.prototype.getbtnJigyoshaInputGuide_disabled = function () {
                return this.controls.btnJigyoshaInputGuide().disabled;
            };

            PublicProperties.prototype.setbtnJigyoshaInputGuide_disabled = function (value) {
                this.controls.btnJigyoshaInputGuide().disabled = value;
            };

            PublicProperties.prototype.getshinseishaInfo_eraseBorder = function () {
                return this.controls.ShinseishaInfo().eraseBorder;
            };

            PublicProperties.prototype.setshinseishaInfo_eraseBorder = function (value) {
                this.controls.ShinseishaInfo().eraseBorder = value;
            };
            return PublicProperties;
        })();
        ShinseishaInfo.PublicProperties = PublicProperties;
    })(DBZ.ShinseishaInfo || (DBZ.ShinseishaInfo = {}));
    var ShinseishaInfo = DBZ.ShinseishaInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KozaPayment) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KozaPayment.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KozaPayment";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KozaPayment.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KozaPayment.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KozaPayment = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtKinyuKikanCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKinyuKikanCode"));
            };

            Controls.prototype.txtKinyuKikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtKinyuKikanName"));
            };

            Controls.prototype.radKozaShubetsu = function () {
                return new UZA.RadioButton(this.convFiledName("radKozaShubetsu"));
            };

            Controls.prototype.txtKozaMeigininKana = function () {
                return new UZA.TextBox(this.convFiledName("txtKozaMeigininKana"));
            };

            Controls.prototype.txtKinyuKikanBrunchCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKinyuKikanBrunchCode"));
            };

            Controls.prototype.txtKinyuKikanBrunchName = function () {
                return new UZA.TextBox(this.convFiledName("txtKinyuKikanBrunchName"));
            };

            Controls.prototype.txtKozaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKozaNo"));
            };

            Controls.prototype.txtKozaMeiginin = function () {
                return new UZA.TextBox(this.convFiledName("txtKozaMeiginin"));
            };
            return Controls;
        })();
        KozaPayment.Controls = Controls;
    })(DBZ.KozaPayment || (DBZ.KozaPayment = {}));
    var KozaPayment = DBZ.KozaPayment;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KozaPayment) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KozaPayment.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KozaPayment.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KozaPayment.ModeController = ModeController;
    })(DBZ.KozaPayment || (DBZ.KozaPayment = {}));
    var KozaPayment = DBZ.KozaPayment;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KozaPayment) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KozaPayment.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.KozaPayment().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.KozaPayment().title = value;
            };

            PublicProperties.prototype.geteraseBorder = function () {
                return this.controls.KozaPayment().eraseBorder;
            };

            PublicProperties.prototype.seteraseBorder = function (value) {
                this.controls.KozaPayment().eraseBorder = value;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.KozaPayment().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.KozaPayment().panelDisplay = value;
            };
            return PublicProperties;
        })();
        KozaPayment.PublicProperties = PublicProperties;
    })(DBZ.KozaPayment || (DBZ.KozaPayment = {}));
    var KozaPayment = DBZ.KozaPayment;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (PaymentMethod) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        PaymentMethod.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "PaymentMethod";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.PaymentMethod.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.PaymentMethod.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.PaymentMethod = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.radPayMethod1 = function () {
                return new UZA.RadioButton(this.convFiledName("radPayMethod1"));
            };

            Controls.prototype.JuryoininJoho = function () {
                return new UZA.Panel(this.convFiledName("JuryoininJoho"));
            };

            Controls.prototype.txtJuryoininKeiyakuNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJuryoininKeiyakuNo"));
            };

            Controls.prototype.txtJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));
            };

            Controls.prototype.txtJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaName"));
            };

            Controls.prototype.txtJigyoshaNameKana = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaNameKana"));
            };

            Controls.prototype.radPayMethod2 = function () {
                return new UZA.RadioButton(this.convFiledName("radPayMethod2"));
            };

            Controls.prototype.KozaPayment = function () {
                return new DBZ.KozaPayment.ModeController(this.convFiledName("KozaPayment"));
            };

            Controls.prototype.radPayMethod3 = function () {
                return new UZA.RadioButton(this.convFiledName("radPayMethod3"));
            };

            Controls.prototype.MadoguchiPayment = function () {
                return new UZA.Panel(this.convFiledName("MadoguchiPayment"));
            };

            Controls.prototype.txtShiharaiBasho = function () {
                return new UZA.TextBox(this.convFiledName("txtShiharaiBasho"));
            };

            Controls.prototype.txtShiharaiKaishiDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShiharaiKaishiDate"));
            };

            Controls.prototype.txtShiharaiKaishiDay = function () {
                return new UZA.TextBox(this.convFiledName("txtShiharaiKaishiDay"));
            };

            Controls.prototype.txtShiharaiKaishiTime = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtShiharaiKaishiTime"));
            };

            Controls.prototype.txtShiharaiShuryoDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShiharaiShuryoDate"));
            };

            Controls.prototype.txtShiharaiShuryoDay = function () {
                return new UZA.TextBox(this.convFiledName("txtShiharaiShuryoDay"));
            };

            Controls.prototype.txtShiharaiShuryoTime = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtShiharaiShuryoTime"));
            };
            return Controls;
        })();
        PaymentMethod.Controls = Controls;
    })(DBZ.PaymentMethod || (DBZ.PaymentMethod = {}));
    var PaymentMethod = DBZ.PaymentMethod;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (PaymentMethod) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new PaymentMethod.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new PaymentMethod.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        PaymentMethod.ModeController = ModeController;
    })(DBZ.PaymentMethod || (DBZ.PaymentMethod = {}));
    var PaymentMethod = DBZ.PaymentMethod;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (PaymentMethod) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new PaymentMethod.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("KozaPayment_title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClick_radPayMethod", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("Juryoinin_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("Madoguchi_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("Koza_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.PaymentMethod().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.PaymentMethod().title = value;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.PaymentMethod().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.PaymentMethod().panelDisplay = value;
            };

            PublicProperties.prototype.getonClick_radPayMethod = function () {
                return this.controls.radPayMethod1().onClick;
            };

            PublicProperties.prototype.setonClick_radPayMethod = function (value) {
                this.controls.radPayMethod1().onClick = value;
            };

            PublicProperties.prototype.getJuryoinin_displayNone = function () {
                return this.controls.JuryoininJoho().displayNone;
            };

            PublicProperties.prototype.setJuryoinin_displayNone = function (value) {
                this.controls.JuryoininJoho().displayNone = value;
            };

            PublicProperties.prototype.getMadoguchi_displayNone = function () {
                return this.controls.MadoguchiPayment().displayNone;
            };

            PublicProperties.prototype.setMadoguchi_displayNone = function (value) {
                this.controls.MadoguchiPayment().displayNone = value;
            };

            PublicProperties.prototype.getKoza_displayNone = function () {
                return this.controls.KozaPayment().Properties().displayNone;
            };

            PublicProperties.prototype.setKoza_displayNone = function (value) {
                this.controls.KozaPayment().Properties().displayNone = value;
            };

            PublicProperties.prototype.geteraseBorder = function () {
                return this.controls.PaymentMethod().eraseBorder;
            };

            PublicProperties.prototype.seteraseBorder = function (value) {
                this.controls.PaymentMethod().eraseBorder = value;
            };
            return PublicProperties;
        })();
        PaymentMethod.PublicProperties = PublicProperties;
    })(DBZ.PaymentMethod || (DBZ.PaymentMethod = {}));
    var PaymentMethod = DBZ.PaymentMethod;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KogakuServicehiJudgementResult) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KogakuServicehiJudgementResult.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KogakuServicehiJudgementResult";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KogakuServicehiJudgementResult.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KogakuServicehiJudgementResult.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KogakuServicehiJudgementResult = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgJudgementResult = function () {
                return new UZA.DataGrid(this.convFiledName("dgJudgementResult"));
            };

            Controls.prototype.KogakuServicehiJudgementResultDetail1 = function () {
                return new UZA.Panel(this.convFiledName("KogakuServicehiJudgementResultDetail1"));
            };

            Controls.prototype.txtUketsukeDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtUketsukeDate"));
            };

            Controls.prototype.txtHonninPaymentAmount = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHonninPaymentAmount"));
            };

            Controls.prototype.txtKetteiDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKetteiDate"));
            };

            Controls.prototype.radShikyuKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radShikyuKubun"));
            };

            Controls.prototype.txtsetaiShuyakuNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtsetaiShuyakuNo"));
            };

            Controls.prototype.txtShikyuAmount = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShikyuAmount"));
            };

            Controls.prototype.radIsKogakuAutoShokan = function () {
                return new UZA.RadioButton(this.convFiledName("radIsKogakuAutoShokan"));
            };

            Controls.prototype.KogakuServicehiJudgementResultDetail2 = function () {
                return new UZA.Panel(this.convFiledName("KogakuServicehiJudgementResultDetail2"));
            };

            Controls.prototype.txtBiko = function () {
                return new UZA.TextBox(this.convFiledName("txtBiko"));
            };

            Controls.prototype.radJudgementMethod = function () {
                return new UZA.RadioButton(this.convFiledName("radJudgementMethod"));
            };

            Controls.prototype.txtFushikyuRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtFushikyuRiyu"));
            };
            return Controls;
        })();
        KogakuServicehiJudgementResult.Controls = Controls;
    })(DBZ.KogakuServicehiJudgementResult || (DBZ.KogakuServicehiJudgementResult = {}));
    var KogakuServicehiJudgementResult = DBZ.KogakuServicehiJudgementResult;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KogakuServicehiJudgementResult) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KogakuServicehiJudgementResult.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KogakuServicehiJudgementResult.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KogakuServicehiJudgementResult.ModeController = ModeController;
    })(DBZ.KogakuServicehiJudgementResult || (DBZ.KogakuServicehiJudgementResult = {}));
    var KogakuServicehiJudgementResult = DBZ.KogakuServicehiJudgementResult;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KogakuServicehiJudgementResult) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KogakuServicehiJudgementResult.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.KogakuServicehiJudgementResult().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.KogakuServicehiJudgementResult().title = value;
            };

            PublicProperties.prototype.geteraseBorder = function () {
                return this.controls.KogakuServicehiJudgementResult().eraseBorder;
            };

            PublicProperties.prototype.seteraseBorder = function (value) {
                this.controls.KogakuServicehiJudgementResult().eraseBorder = value;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.KogakuServicehiJudgementResult().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.KogakuServicehiJudgementResult().panelDisplay = value;
            };
            return PublicProperties;
        })();
        KogakuServicehiJudgementResult.PublicProperties = PublicProperties;
    })(DBZ.KogakuServicehiJudgementResult || (DBZ.KogakuServicehiJudgementResult = {}));
    var KogakuServicehiJudgementResult = DBZ.KogakuServicehiJudgementResult;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (CompleteProcess) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        CompleteProcess.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "CompleteProcess";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.CompleteProcess.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.CompleteProcess.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.CompleteProcess = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.CompleteProssessPadding = function () {
                return new UZA.Panel(this.convFiledName("CompleteProssessPadding"));
            };

            Controls.prototype.lblCompleteMessage = function () {
                return new UZA.Label(this.convFiledName("lblCompleteMessage"));
            };
            return Controls;
        })();
        CompleteProcess.Controls = Controls;
    })(DBZ.CompleteProcess || (DBZ.CompleteProcess = {}));
    var CompleteProcess = DBZ.CompleteProcess;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (CompleteProcess) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new CompleteProcess.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new CompleteProcess.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        CompleteProcess.ModeController = ModeController;
    })(DBZ.CompleteProcess || (DBZ.CompleteProcess = {}));
    var CompleteProcess = DBZ.CompleteProcess;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (CompleteProcess) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new CompleteProcess.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("lblCompleteMessage_text", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("CompleteProcess_width", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getlblCompleteMessage_text = function () {
                return this.controls.lblCompleteMessage().text;
            };

            PublicProperties.prototype.setlblCompleteMessage_text = function (value) {
                this.controls.lblCompleteMessage().text = value;
            };

            PublicProperties.prototype.getCompleteProcess_width = function () {
                return this.controls.CompleteProcess().width;
            };

            PublicProperties.prototype.setCompleteProcess_width = function (value) {
                this.controls.CompleteProcess().width = value;
            };
            return PublicProperties;
        })();
        CompleteProcess.PublicProperties = PublicProperties;
    })(DBZ.CompleteProcess || (DBZ.CompleteProcess = {}));
    var CompleteProcess = DBZ.CompleteProcess;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KaigoSaikinShorishaRireki) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoSaikinShorishaRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoSaikinShorishaRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoSaikinShorishaRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoSaikinShorishaRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoSaikinShorishaRireki = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };
            return Controls;
        })();
        KaigoSaikinShorishaRireki.Controls = Controls;
    })(DBZ.KaigoSaikinShorishaRireki || (DBZ.KaigoSaikinShorishaRireki = {}));
    var KaigoSaikinShorishaRireki = DBZ.KaigoSaikinShorishaRireki;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KaigoSaikinShorishaRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoSaikinShorishaRireki.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoSaikinShorishaRireki.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoSaikinShorishaRireki.ModeController = ModeController;
    })(DBZ.KaigoSaikinShorishaRireki || (DBZ.KaigoSaikinShorishaRireki = {}));
    var KaigoSaikinShorishaRireki = DBZ.KaigoSaikinShorishaRireki;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoSaikinShorishaRireki) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KaigoSaikinShorishaRireki.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoSaikinShorishaRireki.PublicProperties = PublicProperties;
    })(DBZ.KaigoSaikinShorishaRireki || (DBZ.KaigoSaikinShorishaRireki = {}));
    var KaigoSaikinShorishaRireki = DBZ.KaigoSaikinShorishaRireki;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (HihokenshaFinder) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnToClear = function () {
                return "onClick_btnToClear";
            };
            return Events;
        })();
        HihokenshaFinder.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "HihokenshaFinder";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.HihokenshaFinder.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.HihokenshaFinder.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.HihokenshaFinder = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.SearchCriteriaOfHihokensha = function () {
                return new UZA.Panel(this.convFiledName("SearchCriteriaOfHihokensha"));
            };

            Controls.prototype.ddlHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHokensha"));
            };

            Controls.prototype.txtHihokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtHihokenshaNo"));
            };

            Controls.prototype.txtTuchishoNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtTuchishoNo"));
            };

            Controls.prototype.ddlFukaNendo = function () {
                return new UZA.DropDownList(this.convFiledName("ddlFukaNendo"));
            };

            Controls.prototype.SearchCriteriaDetail = function () {
                return new UZA.Panel(this.convFiledName("SearchCriteriaOfHihokensha_SearchCriteriaDetail"));
            };

            Controls.prototype.chkHihokensha = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkHihokensha"));
            };

            Controls.prototype.radMinashiNigo = function () {
                return new UZA.RadioButton(this.convFiledName("radMinashiNigo"));
            };

            Controls.prototype.chkMinashiNigo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkMinashiNigo"));
            };

            Controls.prototype.KaigoAtenaFinder = function () {
                return new URA.AtenaFinder.ModeController(this.convFiledName("KaigoAtenaFinder"));
            };

            Controls.prototype.ButtonsForHihokenshaFinder = function () {
                return new UZA.Panel(this.convFiledName("ButtonsForHihokenshaFinder"));
            };

            Controls.prototype.btnToClear = function () {
                return new UZA.Button(this.convFiledName("btnToClear"));
            };

            Controls.prototype.btnToSearch = function () {
                return new UZA.Button(this.convFiledName("btnToSearch"));
            };

            Controls.prototype.txtMaxNumber = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtMaxNumber"));
            };

            Controls.prototype.saikinShorisha = function () {
                return new DBZ.KaigoSaikinShorishaRireki.ModeController(this.convFiledName("saikinShorisha"));
            };
            return Controls;
        })();
        HihokenshaFinder.Controls = Controls;
    })(DBZ.HihokenshaFinder || (DBZ.HihokenshaFinder = {}));
    var HihokenshaFinder = DBZ.HihokenshaFinder;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (HihokenshaFinder) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HihokenshaFinder.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        HihokenshaFinder.ModeController = ModeController;
    })(DBZ.HihokenshaFinder || (DBZ.HihokenshaFinder = {}));
    var HihokenshaFinder = DBZ.HihokenshaFinder;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (HihokenshaFinder) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new HihokenshaFinder.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("onClick_BtnToSearch", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("displayNone_txtTsuchishoNo", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("displayNone_ddlFukaNendo", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("displayNone_SearchCriteriaDetail", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("canOpenAndClose_HihokenshaFinder", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("displayNone_saikinShorisha", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("displayNone_ddlHokensha", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("displayNone_chkMinashiNigo", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getonClick_BtnToSearch = function () {
                return this.controls.btnToSearch().onClick;
            };

            PublicProperties.prototype.setonClick_BtnToSearch = function (value) {
                this.controls.btnToSearch().onClick = value;
            };

            PublicProperties.prototype.getdisplayNone_txtTsuchishoNo = function () {
                return this.controls.txtTuchishoNo().displayNone;
            };

            PublicProperties.prototype.setdisplayNone_txtTsuchishoNo = function (value) {
                this.controls.txtTuchishoNo().displayNone = value;
            };

            PublicProperties.prototype.getdisplayNone_ddlFukaNendo = function () {
                return this.controls.ddlFukaNendo().displayNone;
            };

            PublicProperties.prototype.setdisplayNone_ddlFukaNendo = function (value) {
                this.controls.ddlFukaNendo().displayNone = value;
            };

            PublicProperties.prototype.getdisplayNone_SearchCriteriaDetail = function () {
                return this.controls.SearchCriteriaDetail().displayNone;
            };

            PublicProperties.prototype.setdisplayNone_SearchCriteriaDetail = function (value) {
                this.controls.SearchCriteriaDetail().displayNone = value;
            };

            PublicProperties.prototype.getcanOpenAndClose_HihokenshaFinder = function () {
                return this.controls.HihokenshaFinder().canOpenAndClose;
            };

            PublicProperties.prototype.setcanOpenAndClose_HihokenshaFinder = function (value) {
                this.controls.HihokenshaFinder().canOpenAndClose = value;
            };

            PublicProperties.prototype.getdisplayNone_saikinShorisha = function () {
                return this.controls.saikinShorisha().Properties().displayNone;
            };

            PublicProperties.prototype.setdisplayNone_saikinShorisha = function (value) {
                this.controls.saikinShorisha().Properties().displayNone = value;
            };

            PublicProperties.prototype.getdisplayNone_ddlHokensha = function () {
                return this.controls.ddlHokensha().displayNone;
            };

            PublicProperties.prototype.setdisplayNone_ddlHokensha = function (value) {
                this.controls.ddlHokensha().displayNone = value;
            };

            PublicProperties.prototype.getdisplayNone_chkMinashiNigo = function () {
                return this.controls.chkMinashiNigo().displayNone;
            };

            PublicProperties.prototype.setdisplayNone_chkMinashiNigo = function (value) {
                this.controls.chkMinashiNigo().displayNone = value;
            };
            return PublicProperties;
        })();
        HihokenshaFinder.PublicProperties = PublicProperties;
    })(DBZ.HihokenshaFinder || (DBZ.HihokenshaFinder = {}));
    var HihokenshaFinder = DBZ.HihokenshaFinder;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (HihokenshaInputGuide) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnReturn = function () {
                return "onClick_btnReturn";
            };
            return Events;
        })();
        HihokenshaInputGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "HihokenshaInputGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.HihokenshaInputGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.HihokenshaInputGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.HihokenshaInputGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.lblSearchResultOfHihokensha = function () {
                return new UZA.Label(this.convFiledName("lblSearchResultOfHihokensha"));
            };

            Controls.prototype.dgSearchResultOfHihokensha = function () {
                return new UZA.DataGrid(this.convFiledName("dgSearchResultOfHihokensha"));
            };

            Controls.prototype.btnReturn = function () {
                return new UZA.Button(this.convFiledName("btnReturn"));
            };
            return Controls;
        })();
        HihokenshaInputGuide.Controls = Controls;
    })(DBZ.HihokenshaInputGuide || (DBZ.HihokenshaInputGuide = {}));
    var HihokenshaInputGuide = DBZ.HihokenshaInputGuide;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (HihokenshaInputGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HihokenshaInputGuide.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new HihokenshaInputGuide.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        HihokenshaInputGuide.ModeController = ModeController;
    })(DBZ.HihokenshaInputGuide || (DBZ.HihokenshaInputGuide = {}));
    var HihokenshaInputGuide = DBZ.HihokenshaInputGuide;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (HihokenshaInputGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new HihokenshaInputGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        HihokenshaInputGuide.PublicProperties = PublicProperties;
    })(DBZ.HihokenshaInputGuide || (DBZ.HihokenshaInputGuide = {}));
    var HihokenshaInputGuide = DBZ.HihokenshaInputGuide;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (HihokenshaShikakuHakko) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        HihokenshaShikakuHakko.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "HihokenshaShikakuHakko";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.HihokenshaShikakuHakko.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.HihokenshaShikakuHakko.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.HihokenshaShikakuHakko = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.radInjiIchi = function () {
                return new UZA.RadioButton(this.convFiledName("radInjiIchi"));
            };

            Controls.prototype.txtKofuDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKofuDate"));
            };

            Controls.prototype.ddlKofuJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKofuJiyu"));
            };

            Controls.prototype.txtYukoKigen = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYukoKigen"));
            };

            Controls.prototype.txtHokensha = function () {
                return new UZA.TextBox(this.convFiledName("txtHokensha"));
            };

            Controls.prototype.txtYokaigodo = function () {
                return new UZA.TextBox(this.convFiledName("txtYokaigodo"));
            };

            Controls.prototype.txtNinteiYukoKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNinteiYukoKikan"));
            };

            Controls.prototype.txtShinseiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiDate"));
            };

            Controls.prototype.tabHihokenshaShikakuShosai = function () {
                return new UZA.TabContainer(this.convFiledName("tabHihokenshaShikakuShosai"));
            };

            Controls.prototype.tplGendoGaku = function () {
                return new UZA.TabPanel(this.convFiledName("tplGendoGaku"));
            };

            Controls.prototype.lblKubunShikyuGendoGaku = function () {
                return new UZA.Label(this.convFiledName("lblKubunShikyuGendoGaku"));
            };

            Controls.prototype.txtKubunShikyuGendoKijunGaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKubunShikyuGendoKijunGaku"));
            };

            Controls.prototype.txtKyuhuYukoKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyuhuYukoKikan"));
            };

            Controls.prototype.ShuruiShikyuGendoKijungaku = function () {
                return new UZA.Panel(this.convFiledName("ShuruiShikyuGendoKijungaku"));
            };

            Controls.prototype.dgShuruiShikyuGendoKijunGaku = function () {
                return new UZA.DataGrid(this.convFiledName("dgShuruiShikyuGendoKijunGaku"));
            };

            Controls.prototype.tplShinsakaiIken = function () {
                return new UZA.TabPanel(this.convFiledName("tplShinsakaiIken"));
            };

            Controls.prototype.lblShinsakaiIken = function () {
                return new UZA.Label(this.convFiledName("lblShinsakaiIken"));
            };

            Controls.prototype.txtShinsakaiIken = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinsakaiIken"));
            };

            Controls.prototype.tplKyufuSeigen = function () {
                return new UZA.TabPanel(this.convFiledName("tplKyufuSeigen"));
            };

            Controls.prototype.lblKyufuSeigen = function () {
                return new UZA.Label(this.convFiledName("lblKyufuSeigen"));
            };

            Controls.prototype.tblKyuhuSeigen = function () {
                return new UZA.TablePanel(this.convFiledName("tblKyuhuSeigen"));
            };

            Controls.prototype.celKyufuSeigenNaiyoTitle = function () {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenNaiyoTitle"));
            };

            Controls.prototype.lblKyufuSeigenNaiyo = function () {
                return new UZA.Label(this.convFiledName("lblKyufuSeigenNaiyo"));
            };

            Controls.prototype.celKyufuSeigenKikanTitle = function () {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenKikanTitle"));
            };

            Controls.prototype.lblKyufuSeigenKikan = function () {
                return new UZA.Label(this.convFiledName("lblKyufuSeigenKikan"));
            };

            Controls.prototype.celKyufuSeigenNaiyo1 = function () {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenNaiyo1"));
            };

            Controls.prototype.txtKyufuSeigenNaiyo1 = function () {
                return new UZA.TextBox(this.convFiledName("txtKyufuSeigenNaiyo1"));
            };

            Controls.prototype.celKyufuSeigenKikan1 = function () {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenKikan1"));
            };

            Controls.prototype.txtKyufuSeigenKikan1 = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyufuSeigenKikan1"));
            };

            Controls.prototype.celKyufuSeigenNaiyo2 = function () {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenNaiyo2"));
            };

            Controls.prototype.txtKyufuSeigenNaiyo2 = function () {
                return new UZA.TextBox(this.convFiledName("txtKyufuSeigenNaiyo2"));
            };

            Controls.prototype.celKyufuSeigenKikan2 = function () {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenKikan2"));
            };

            Controls.prototype.txtKyufuSeigenKikan2 = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyufuSeigenKikan2"));
            };

            Controls.prototype.celKyufuSeigenNaiyo3 = function () {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenNaiyo3"));
            };

            Controls.prototype.txtKyufuSeigenNaiyo3 = function () {
                return new UZA.TextBox(this.convFiledName("txtKyufuSeigenNaiyo3"));
            };

            Controls.prototype.celKyufuSeigenKikan3 = function () {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenKikan3"));
            };

            Controls.prototype.txtKyufuSeigenKikan3 = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyufuSeigenKikan3"));
            };

            Controls.prototype.tplShienJigyosha = function () {
                return new UZA.TabPanel(this.convFiledName("tplShienJigyosha"));
            };

            Controls.prototype.lblShienJigyosha = function () {
                return new UZA.Label(this.convFiledName("lblShienJigyosha"));
            };

            Controls.prototype.tblJigyosha = function () {
                return new UZA.TablePanel(this.convFiledName("tblJigyosha"));
            };

            Controls.prototype.celJigyoshaTitle = function () {
                return new UZA.TableCell(this.convFiledName("celJigyoshaTitle"));
            };

            Controls.prototype.lblJigyosha = function () {
                return new UZA.Label(this.convFiledName("lblJigyosha"));
            };

            Controls.prototype.celTodokedeDateTitle = function () {
                return new UZA.TableCell(this.convFiledName("celTodokedeDateTitle"));
            };

            Controls.prototype.lblTodokedeDate = function () {
                return new UZA.Label(this.convFiledName("lblTodokedeDate"));
            };

            Controls.prototype.celJigyosha1 = function () {
                return new UZA.TableCell(this.convFiledName("celJigyosha1"));
            };

            Controls.prototype.txtJigyosha1 = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyosha1"));
            };

            Controls.prototype.celTodokedeDate1 = function () {
                return new UZA.TableCell(this.convFiledName("celTodokedeDate1"));
            };

            Controls.prototype.txtTodokedeDate1 = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTodokedeDate1"));
            };

            Controls.prototype.celJigyosha2 = function () {
                return new UZA.TableCell(this.convFiledName("celJigyosha2"));
            };

            Controls.prototype.txtJigyosha2 = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyosha2"));
            };

            Controls.prototype.celTodokedeDate2 = function () {
                return new UZA.TableCell(this.convFiledName("celTodokedeDate2"));
            };

            Controls.prototype.txtTodokedeDate2 = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTodokedeDate2"));
            };

            Controls.prototype.celJigyosha3 = function () {
                return new UZA.TableCell(this.convFiledName("celJigyosha3"));
            };

            Controls.prototype.txtJigyosha3 = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyosha3"));
            };

            Controls.prototype.celTodokedeDate3 = function () {
                return new UZA.TableCell(this.convFiledName("celTodokedeDate3"));
            };

            Controls.prototype.txtTodokedeDate3 = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTodokedeDate3"));
            };

            Controls.prototype.tplShisetsuNyutaisho = function () {
                return new UZA.TabPanel(this.convFiledName("tplShisetsuNyutaisho"));
            };

            Controls.prototype.lblKaigoHokensha = function () {
                return new UZA.Label(this.convFiledName("lblKaigoHokensha"));
            };

            Controls.prototype.tblShisetsuNyutaisho = function () {
                return new UZA.TablePanel(this.convFiledName("tblShisetsuNyutaisho"));
            };

            Controls.prototype.celShisetsuShuruiTitle = function () {
                return new UZA.TableCell(this.convFiledName("celShisetsuShuruiTitle"));
            };

            Controls.prototype.lblShisetsuShurui = function () {
                return new UZA.Label(this.convFiledName("lblShisetsuShurui"));
            };

            Controls.prototype.celNyushoShisetsuTitle = function () {
                return new UZA.TableCell(this.convFiledName("celNyushoShisetsuTitle"));
            };

            Controls.prototype.lblNyushoShisetsu = function () {
                return new UZA.Label(this.convFiledName("lblNyushoShisetsu"));
            };

            Controls.prototype.celShisetsuNyushoDateTitle = function () {
                return new UZA.TableCell(this.convFiledName("celShisetsuNyushoDateTitle"));
            };

            Controls.prototype.lblShisetsuNyushoDate = function () {
                return new UZA.Label(this.convFiledName("lblShisetsuNyushoDate"));
            };

            Controls.prototype.celShisetsuTaishoDateTitle = function () {
                return new UZA.TableCell(this.convFiledName("celShisetsuTaishoDateTitle"));
            };

            Controls.prototype.lblShisetsuTaishoDate = function () {
                return new UZA.Label(this.convFiledName("lblShisetsuTaishoDate"));
            };

            Controls.prototype.celShisetsuShurui1 = function () {
                return new UZA.TableCell(this.convFiledName("celShisetsuShurui1"));
            };

            Controls.prototype.txtShisetsuShurui1 = function () {
                return new UZA.TextBox(this.convFiledName("txtShisetsuShurui1"));
            };

            Controls.prototype.celNyushoShisetsu1 = function () {
                return new UZA.TableCell(this.convFiledName("celNyushoShisetsu1"));
            };

            Controls.prototype.txtNyushoShisetsu1 = function () {
                return new UZA.TextBox(this.convFiledName("txtNyushoShisetsu1"));
            };

            Controls.prototype.celShisetsuNyushoDate1 = function () {
                return new UZA.TableCell(this.convFiledName("celShisetsuNyushoDate1"));
            };

            Controls.prototype.txtShisetsuNyushoDate1 = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuNyushoDate1"));
            };

            Controls.prototype.celShisetsuTaishoDate1 = function () {
                return new UZA.TableCell(this.convFiledName("celShisetsuTaishoDate1"));
            };

            Controls.prototype.txtShisetsuTaishoDate1 = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuTaishoDate1"));
            };

            Controls.prototype.celShisetsuShurui2 = function () {
                return new UZA.TableCell(this.convFiledName("celShisetsuShurui2"));
            };

            Controls.prototype.txtShisetsuShurui2 = function () {
                return new UZA.TextBox(this.convFiledName("txtShisetsuShurui2"));
            };

            Controls.prototype.celNyushoShisetsu2 = function () {
                return new UZA.TableCell(this.convFiledName("celNyushoShisetsu2"));
            };

            Controls.prototype.txtNyushoShisetsu2 = function () {
                return new UZA.TextBox(this.convFiledName("txtNyushoShisetsu2"));
            };

            Controls.prototype.celShisetsuNyushoDate2 = function () {
                return new UZA.TableCell(this.convFiledName("celShisetsuNyushoDate2"));
            };

            Controls.prototype.txtShisetsuNyushoDate2 = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuNyushoDate2"));
            };

            Controls.prototype.celShisetsuTaishoDate2 = function () {
                return new UZA.TableCell(this.convFiledName("celShisetsuTaishoDate2"));
            };

            Controls.prototype.txtShisetsuTaishoDate2 = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuTaishoDate2"));
            };

            Controls.prototype.celShisetsuShurui3 = function () {
                return new UZA.TableCell(this.convFiledName("celShisetsuShurui3"));
            };

            Controls.prototype.txtShisetsuShurui3 = function () {
                return new UZA.TextBox(this.convFiledName("txtShisetsuShurui3"));
            };

            Controls.prototype.celNyushoShisetsu3 = function () {
                return new UZA.TableCell(this.convFiledName("celNyushoShisetsu3"));
            };

            Controls.prototype.txtNyushoShisetsu3 = function () {
                return new UZA.TextBox(this.convFiledName("txtNyushoShisetsu3"));
            };

            Controls.prototype.celShisetsuNyushoDate3 = function () {
                return new UZA.TableCell(this.convFiledName("celShisetsuNyushoDate3"));
            };

            Controls.prototype.txtShisetsuNyushoDate3 = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuNyushoDate3"));
            };

            Controls.prototype.celShisetsuTaishoDate3 = function () {
                return new UZA.TableCell(this.convFiledName("celShisetsuTaishoDate3"));
            };

            Controls.prototype.txtShisetsuTaishoDate3 = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuTaishoDate3"));
            };
            return Controls;
        })();
        HihokenshaShikakuHakko.Controls = Controls;
    })(DBZ.HihokenshaShikakuHakko || (DBZ.HihokenshaShikakuHakko = {}));
    var HihokenshaShikakuHakko = DBZ.HihokenshaShikakuHakko;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (HihokenshaShikakuHakko) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HihokenshaShikakuHakko.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new HihokenshaShikakuHakko.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        HihokenshaShikakuHakko.ModeController = ModeController;
    })(DBZ.HihokenshaShikakuHakko || (DBZ.HihokenshaShikakuHakko = {}));
    var HihokenshaShikakuHakko = DBZ.HihokenshaShikakuHakko;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (HihokenshaShikakuHakko) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new HihokenshaShikakuHakko.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtYukoKigen_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("radInjiIchi_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("onBlur_txtKofuDate", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onChange_ddlKofuJiyu", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettxtYukoKigen_displayNone = function () {
                return this.controls.txtYukoKigen().displayNone;
            };

            PublicProperties.prototype.settxtYukoKigen_displayNone = function (value) {
                this.controls.txtYukoKigen().displayNone = value;
            };

            PublicProperties.prototype.getradInjiIchi_displayNone = function () {
                return this.controls.radInjiIchi().displayNone;
            };

            PublicProperties.prototype.setradInjiIchi_displayNone = function (value) {
                this.controls.radInjiIchi().displayNone = value;
            };

            PublicProperties.prototype.getonBlur_txtKofuDate = function () {
                return this.controls.txtKofuDate().onBlur;
            };

            PublicProperties.prototype.setonBlur_txtKofuDate = function (value) {
                this.controls.txtKofuDate().onBlur = value;
            };

            PublicProperties.prototype.getonChange_ddlKofuJiyu = function () {
                return this.controls.ddlKofuJiyu().onChange;
            };

            PublicProperties.prototype.setonChange_ddlKofuJiyu = function (value) {
                this.controls.ddlKofuJiyu().onChange = value;
            };
            return PublicProperties;
        })();
        HihokenshaShikakuHakko.PublicProperties = PublicProperties;
    })(DBZ.HihokenshaShikakuHakko || (DBZ.HihokenshaShikakuHakko = {}));
    var HihokenshaShikakuHakko = DBZ.HihokenshaShikakuHakko;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (HokenshaInputGuide) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnSearchGaitoHokensha = function () {
                return "onClick_btnSearchGaitoHokensha";
            };

            Events.onSelectBySelectButton_dgSearchResultHokensha = function () {
                return "onSelectBySelectButton_dgSearchResultHokensha";
            };

            Events.onClick_btnHokenshaReturn = function () {
                return "onClick_btnHokenshaReturn";
            };
            return Events;
        })();
        HokenshaInputGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "HokenshaInputGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.HokenshaInputGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.HokenshaInputGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.HokenshaInputGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlHokenshaKenCode = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHokenshaKenCode"));
            };

            Controls.prototype.btnSearchGaitoHokensha = function () {
                return new UZA.Button(this.convFiledName("btnSearchGaitoHokensha"));
            };

            Controls.prototype.SearchResultHokensha = function () {
                return new UZA.Panel(this.convFiledName("SearchResultHokensha"));
            };

            Controls.prototype.dgSearchResultHokensha = function () {
                return new UZA.DataGrid(this.convFiledName("dgSearchResultHokensha"));
            };

            Controls.prototype.btnHokenshaReturn = function () {
                return new UZA.Button(this.convFiledName("btnHokenshaReturn"));
            };
            return Controls;
        })();
        HokenshaInputGuide.Controls = Controls;
    })(DBZ.HokenshaInputGuide || (DBZ.HokenshaInputGuide = {}));
    var HokenshaInputGuide = DBZ.HokenshaInputGuide;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (HokenshaInputGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HokenshaInputGuide.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new HokenshaInputGuide.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        HokenshaInputGuide.ModeController = ModeController;
    })(DBZ.HokenshaInputGuide || (DBZ.HokenshaInputGuide = {}));
    var HokenshaInputGuide = DBZ.HokenshaInputGuide;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (HokenshaInputGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new HokenshaInputGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        HokenshaInputGuide.PublicProperties = PublicProperties;
    })(DBZ.HokenshaInputGuide || (DBZ.HokenshaInputGuide = {}));
    var HokenshaInputGuide = DBZ.HokenshaInputGuide;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (HokenshaJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.onBlur_txtHokenshaNo = function () {
                return "onBlur_txtHokenshaNo";
            };
            return Events;
        })();
        HokenshaJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "HokenshaJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.HokenshaJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.HokenshaJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.HokenshaJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtHokenshaNo"));
            };

            Controls.prototype.btnHokenshaSelect = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHokenshaSelect"));
            };

            Controls.prototype.txtHokenshaMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtHokenshaMeisho"));
            };
            return Controls;
        })();
        HokenshaJoho.Controls = Controls;
    })(DBZ.HokenshaJoho || (DBZ.HokenshaJoho = {}));
    var HokenshaJoho = DBZ.HokenshaJoho;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (HokenshaJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HokenshaJoho.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new HokenshaJoho.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        HokenshaJoho.ModeController = ModeController;
    })(DBZ.HokenshaJoho || (DBZ.HokenshaJoho = {}));
    var HokenshaJoho = DBZ.HokenshaJoho;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (HokenshaJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new HokenshaJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        HokenshaJoho.PublicProperties = PublicProperties;
    })(DBZ.HokenshaJoho || (DBZ.HokenshaJoho = {}));
    var HokenshaJoho = DBZ.HokenshaJoho;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (JigyoshaInputGuide) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnSearchJigyosha = function () {
                return "onClick_btnSearchJigyosha";
            };

            Events.onSelectBySelectButton_dgSearchResultJigyosha = function () {
                return "onSelectBySelectButton_dgSearchResultJigyosha";
            };

            Events.onClick_btnKaigoHokenShisetsuReturn = function () {
                return "onClick_btnKaigoHokenShisetsuReturn";
            };
            return Events;
        })();
        JigyoshaInputGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JigyoshaInputGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.JigyoshaInputGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.JigyoshaInputGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JigyoshaInputGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.radJigyoshaSearchType = function () {
                return new UZA.RadioButton(this.convFiledName("radJigyoshaSearchType"));
            };

            Controls.prototype.txtJigyoshaCode = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaCode"));
            };

            Controls.prototype.btnSearchJigyosha = function () {
                return new UZA.Button(this.convFiledName("btnSearchJigyosha"));
            };

            Controls.prototype.SearchResultJigyosha = function () {
                return new UZA.Panel(this.convFiledName("SearchResultJigyosha"));
            };

            Controls.prototype.dgSearchResultJigyosha = function () {
                return new UZA.DataGrid(this.convFiledName("dgSearchResultJigyosha"));
            };

            Controls.prototype.btnKaigoHokenShisetsuReturn = function () {
                return new UZA.Button(this.convFiledName("btnKaigoHokenShisetsuReturn"));
            };
            return Controls;
        })();
        JigyoshaInputGuide.Controls = Controls;
    })(DBZ.JigyoshaInputGuide || (DBZ.JigyoshaInputGuide = {}));
    var JigyoshaInputGuide = DBZ.JigyoshaInputGuide;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (JigyoshaInputGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JigyoshaInputGuide.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new JigyoshaInputGuide.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        JigyoshaInputGuide.ModeController = ModeController;
    })(DBZ.JigyoshaInputGuide || (DBZ.JigyoshaInputGuide = {}));
    var JigyoshaInputGuide = DBZ.JigyoshaInputGuide;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (JigyoshaInputGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new JigyoshaInputGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JigyoshaInputGuide.PublicProperties = PublicProperties;
    })(DBZ.JigyoshaInputGuide || (DBZ.JigyoshaInputGuide = {}));
    var JigyoshaInputGuide = DBZ.JigyoshaInputGuide;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (JukyuShikakuShomeishoHakko) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        JukyuShikakuShomeishoHakko.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JukyuShikakuShomeishoHakko";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.JukyuShikakuShomeishoHakko.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.JukyuShikakuShomeishoHakko.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JukyuShikakuShomeishoHakko = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtKofuDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKofuDate"));
            };

            Controls.prototype.txtIdoYoteiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIdoYoteiDate"));
            };

            Controls.prototype.txtYokaigoJotai = function () {
                return new UZA.TextBox(this.convFiledName("txtYokaigoJotai"));
            };

            Controls.prototype.txtNinteiYukoKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNinteiYukoKikan"));
            };

            Controls.prototype.txtShinseiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiDate"));
            };

            Controls.prototype.lblNinteiShinsakaiIken = function () {
                return new UZA.Label(this.convFiledName("lblNinteiShinsakaiIken"));
            };

            Controls.prototype.txtNinteiShinsakaiIken = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtNinteiShinsakaiIken"));
            };

            Controls.prototype.lblBiko = function () {
                return new UZA.Label(this.convFiledName("lblBiko"));
            };

            Controls.prototype.txtBiko = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtBiko"));
            };

            Controls.prototype.chkJushoHihyoji = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkJushoHihyoji"));
            };
            return Controls;
        })();
        JukyuShikakuShomeishoHakko.Controls = Controls;
    })(DBZ.JukyuShikakuShomeishoHakko || (DBZ.JukyuShikakuShomeishoHakko = {}));
    var JukyuShikakuShomeishoHakko = DBZ.JukyuShikakuShomeishoHakko;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (JukyuShikakuShomeishoHakko) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JukyuShikakuShomeishoHakko.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new JukyuShikakuShomeishoHakko.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        JukyuShikakuShomeishoHakko.ModeController = ModeController;
    })(DBZ.JukyuShikakuShomeishoHakko || (DBZ.JukyuShikakuShomeishoHakko = {}));
    var JukyuShikakuShomeishoHakko = DBZ.JukyuShikakuShomeishoHakko;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (JukyuShikakuShomeishoHakko) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new JukyuShikakuShomeishoHakko.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JukyuShikakuShomeishoHakko.PublicProperties = PublicProperties;
    })(DBZ.JukyuShikakuShomeishoHakko || (DBZ.JukyuShikakuShomeishoHakko = {}));
    var JukyuShikakuShomeishoHakko = DBZ.JukyuShikakuShomeishoHakko;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KagoMoshitate) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KagoMoshitate.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KagoMoshitate";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KagoMoshitate.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KagoMoshitate.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KagoMoshitate = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));
            };

            Controls.prototype.txtJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaName"));
            };

            Controls.prototype.txtSendYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSendYM"));
            };

            Controls.prototype.txtMoshitateshaKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtMoshitateshaKubun"));
            };

            Controls.prototype.txtShokisaiHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShokisaiHokenshaNo"));
            };

            Controls.prototype.txtShokisaiHokenshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtShokisaiHokenshaName"));
            };

            Controls.prototype.txtTeikyoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTeikyoYM"));
            };

            Controls.prototype.txtKagoForm = function () {
                return new UZA.TextBox(this.convFiledName("txtKagoForm"));
            };

            Controls.prototype.txtMoshitateDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtMoshitateDate"));
            };

            Controls.prototype.ddlKagoMoshitateRiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKagoMoshitateRiyu"));
            };

            Controls.prototype.chkForDogetsuShinsa = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkForDogetsuShinsa"));
            };
            return Controls;
        })();
        KagoMoshitate.Controls = Controls;
    })(DBZ.KagoMoshitate || (DBZ.KagoMoshitate = {}));
    var KagoMoshitate = DBZ.KagoMoshitate;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KagoMoshitate) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KagoMoshitate.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KagoMoshitate.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KagoMoshitate.ModeController = ModeController;
    })(DBZ.KagoMoshitate || (DBZ.KagoMoshitate = {}));
    var KagoMoshitate = DBZ.KagoMoshitate;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KagoMoshitate) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KagoMoshitate.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.KagoMoshitate().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.KagoMoshitate().title = value;
            };

            PublicProperties.prototype.geteraseBorder = function () {
                return this.controls.KagoMoshitate().eraseBorder;
            };

            PublicProperties.prototype.seteraseBorder = function (value) {
                this.controls.KagoMoshitate().eraseBorder = value;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.KagoMoshitate().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.KagoMoshitate().panelDisplay = value;
            };
            return PublicProperties;
        })();
        KagoMoshitate.PublicProperties = PublicProperties;
    })(DBZ.KagoMoshitate || (DBZ.KagoMoshitate = {}));
    var KagoMoshitate = DBZ.KagoMoshitate;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KaigoAtenaInfo) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoAtenaInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoAtenaInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoAtenaInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoAtenaInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoAtenaInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.atenaInfo = function () {
                return new URA.AtenaShokaiSimple.ModeController(this.convFiledName("atenaInfo"));
            };
            return Controls;
        })();
        KaigoAtenaInfo.Controls = Controls;
    })(DBZ.KaigoAtenaInfo || (DBZ.KaigoAtenaInfo = {}));
    var KaigoAtenaInfo = DBZ.KaigoAtenaInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KaigoAtenaInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoAtenaInfo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoAtenaInfo.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "DisplayType",
                    "BtnDainoninDisplay",
                    "BtnSofusakiDisplay",
                    "BtnKozaDisplay",
                    "BtnSetaiDisplay",
                    "BtnEltaxDisplay",
                    "BtnAtesakiDisplay"
                ];
            };

            ModeController.prototype.DisplayType = function () {
                return new Modes.DisplayType(this.controls);
            };

            ModeController.prototype.BtnDainoninDisplay = function () {
                return new Modes.BtnDainoninDisplay(this.controls);
            };

            ModeController.prototype.BtnSofusakiDisplay = function () {
                return new Modes.BtnSofusakiDisplay(this.controls);
            };

            ModeController.prototype.BtnKozaDisplay = function () {
                return new Modes.BtnKozaDisplay(this.controls);
            };

            ModeController.prototype.BtnSetaiDisplay = function () {
                return new Modes.BtnSetaiDisplay(this.controls);
            };

            ModeController.prototype.BtnEltaxDisplay = function () {
                return new Modes.BtnEltaxDisplay(this.controls);
            };

            ModeController.prototype.BtnAtesakiDisplay = function () {
                return new Modes.BtnAtesakiDisplay(this.controls);
            };
            return ModeController;
        })();
        KaigoAtenaInfo.ModeController = ModeController;

        (function (Modes) {
            var DisplayType = (function () {
                function DisplayType(controls) {
                    this.controls = controls;
                }
                DisplayType.prototype.一行タイプ = function () {
                    this.controls.atenaInfo().DisplayType().一行タイプ();
                };

                DisplayType.prototype.三行タイプ = function () {
                    this.controls.atenaInfo().DisplayType().三行タイプ();
                };

                DisplayType.prototype.指定無し = function () {
                    this.controls.atenaInfo().DisplayType().指定無し();
                };
                return DisplayType;
            })();
            Modes.DisplayType = DisplayType;

            var BtnDainoninDisplay = (function () {
                function BtnDainoninDisplay(controls) {
                    this.controls = controls;
                }
                BtnDainoninDisplay.prototype.指定無し = function () {
                    this.controls.atenaInfo().BtnDainoninDisplay().指定無し();
                };
                BtnDainoninDisplay.prototype.表示しない = function () {
                    this.controls.atenaInfo().BtnDainoninDisplay().表示しない();
                };
                return BtnDainoninDisplay;
            })();
            Modes.BtnDainoninDisplay = BtnDainoninDisplay;

            var BtnSofusakiDisplay = (function () {
                function BtnSofusakiDisplay(controls) {
                    this.controls = controls;
                }
                BtnSofusakiDisplay.prototype.指定無し = function () {
                    this.controls.atenaInfo().BtnSofusakiDisplay().指定無し();
                };
                BtnSofusakiDisplay.prototype.表示しない = function () {
                    this.controls.atenaInfo().BtnSofusakiDisplay().表示しない();
                };
                return BtnSofusakiDisplay;
            })();
            Modes.BtnSofusakiDisplay = BtnSofusakiDisplay;

            var BtnKozaDisplay = (function () {
                function BtnKozaDisplay(controls) {
                    this.controls = controls;
                }
                BtnKozaDisplay.prototype.指定無し = function () {
                    this.controls.atenaInfo().BtnKozaDisplay().指定無し();
                };
                BtnKozaDisplay.prototype.表示しない = function () {
                    this.controls.atenaInfo().BtnKozaDisplay().表示しない();
                };
                return BtnKozaDisplay;
            })();
            Modes.BtnKozaDisplay = BtnKozaDisplay;

            var BtnSetaiDisplay = (function () {
                function BtnSetaiDisplay(controls) {
                    this.controls = controls;
                }
                BtnSetaiDisplay.prototype.指定無し = function () {
                    this.controls.atenaInfo().BtnSetaiDisplay().指定無し();
                };
                BtnSetaiDisplay.prototype.表示しない = function () {
                    this.controls.atenaInfo().BtnSetaiDisplay().表示しない();
                };
                return BtnSetaiDisplay;
            })();
            Modes.BtnSetaiDisplay = BtnSetaiDisplay;

            var BtnEltaxDisplay = (function () {
                function BtnEltaxDisplay(controls) {
                    this.controls = controls;
                }
                BtnEltaxDisplay.prototype.指定無し = function () {
                    this.controls.atenaInfo().BtnEltaxDisplay().指定無し();
                };
                BtnEltaxDisplay.prototype.表示しない = function () {
                    this.controls.atenaInfo().BtnEltaxDisplay().表示しない();
                };
                return BtnEltaxDisplay;
            })();
            Modes.BtnEltaxDisplay = BtnEltaxDisplay;

            var BtnAtesakiDisplay = (function () {
                function BtnAtesakiDisplay(controls) {
                    this.controls = controls;
                }
                BtnAtesakiDisplay.prototype.指定無し = function () {
                    this.controls.atenaInfo().BtnAtesakiDisplay().指定無し();
                };
                BtnAtesakiDisplay.prototype.表示しない = function () {
                    this.controls.atenaInfo().BtnAtesakiDisplay().表示しない();
                };
                return BtnAtesakiDisplay;
            })();
            Modes.BtnAtesakiDisplay = BtnAtesakiDisplay;
        })(KaigoAtenaInfo.Modes || (KaigoAtenaInfo.Modes = {}));
        var Modes = KaigoAtenaInfo.Modes;
    })(DBZ.KaigoAtenaInfo || (DBZ.KaigoAtenaInfo = {}));
    var KaigoAtenaInfo = DBZ.KaigoAtenaInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoAtenaInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoAtenaInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoAtenaInfo.PublicProperties = PublicProperties;
    })(DBZ.KaigoAtenaInfo || (DBZ.KaigoAtenaInfo = {}));
    var KaigoAtenaInfo = DBZ.KaigoAtenaInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KaigoChohyoShutsuryokujun) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoChohyoShutsuryokujun.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoChohyoShutsuryokujun";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoChohyoShutsuryokujun.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoChohyoShutsuryokujun.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoChohyoShutsuryokujun = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.kaigoChohyoShutsuryokujun = function () {
                return new URZ.ChohyoShutsuryokujun.ModeController(this.convFiledName("kaigoChohyoShutsuryokujun"));
            };
            return Controls;
        })();
        KaigoChohyoShutsuryokujun.Controls = Controls;
    })(DBZ.KaigoChohyoShutsuryokujun || (DBZ.KaigoChohyoShutsuryokujun = {}));
    var KaigoChohyoShutsuryokujun = DBZ.KaigoChohyoShutsuryokujun;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KaigoChohyoShutsuryokujun) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoChohyoShutsuryokujun.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoChohyoShutsuryokujun.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoChohyoShutsuryokujun.ModeController = ModeController;
    })(DBZ.KaigoChohyoShutsuryokujun || (DBZ.KaigoChohyoShutsuryokujun = {}));
    var KaigoChohyoShutsuryokujun = DBZ.KaigoChohyoShutsuryokujun;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoChohyoShutsuryokujun) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoChohyoShutsuryokujun.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("ChohyoShutsuryokujun_width", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getChohyoShutsuryokujun_width = function () {
                return this.controls.convFiledName;
            };

            PublicProperties.prototype.setChohyoShutsuryokujun_width = function (value) {
                return this.controls.convFiledName = value;
            };
            return PublicProperties;
        })();
        KaigoChohyoShutsuryokujun.PublicProperties = PublicProperties;
    })(DBZ.KaigoChohyoShutsuryokujun || (DBZ.KaigoChohyoShutsuryokujun = {}));
    var KaigoChohyoShutsuryokujun = DBZ.KaigoChohyoShutsuryokujun;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KaigoFukaKihon) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoFukaKihon.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoFukaKihon";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoFukaKihon.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoFukaKihon.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoFukaKihon = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtTsuchishoNo = function () {
                return new UZA.TextBox(this.convFiledName("txtTsuchishoNo"));
            };

            Controls.prototype.txtHihokenshaNo = function () {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaNo"));
            };

            Controls.prototype.txtHokenryoDankai = function () {
                return new UZA.TextBox(this.convFiledName("txtHokenryoDankai"));
            };

            Controls.prototype.txtShutokuYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShutokuYmd"));
            };

            Controls.prototype.txtShutokuJiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtShutokuJiyu"));
            };

            Controls.prototype.txtSoshitsuYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSoshitsuYmd"));
            };

            Controls.prototype.txtSoshitsuJiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtSoshitsuJiyu"));
            };

            Controls.prototype.btnHihoRireki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHihoRireki"));
            };
            return Controls;
        })();
        KaigoFukaKihon.Controls = Controls;
    })(DBZ.KaigoFukaKihon || (DBZ.KaigoFukaKihon = {}));
    var KaigoFukaKihon = DBZ.KaigoFukaKihon;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KaigoFukaKihon) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoFukaKihon.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoFukaKihon.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoFukaKihon.ModeController = ModeController;
    })(DBZ.KaigoFukaKihon || (DBZ.KaigoFukaKihon = {}));
    var KaigoFukaKihon = DBZ.KaigoFukaKihon;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoFukaKihon) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KaigoFukaKihon.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("canOpenAndClose", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("backGroundColor", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("btnHihoRireki_visible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.KaigoFukaKihon().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.KaigoFukaKihon().title = value;
            };

            PublicProperties.prototype.getcanOpenAndClose = function () {
                return this.controls.KaigoFukaKihon().canOpenAndClose;
            };

            PublicProperties.prototype.setcanOpenAndClose = function (value) {
                this.controls.KaigoFukaKihon().canOpenAndClose = value;
            };

            PublicProperties.prototype.geteraseBorderTop = function () {
                return this.controls.KaigoFukaKihon().eraseBorder;
            };

            PublicProperties.prototype.seteraseBorderTop = function (value) {
                this.controls.KaigoFukaKihon().eraseBorder = value;
            };

            PublicProperties.prototype.getbackGroundColor = function () {
                return this.controls.KaigoFukaKihon().backgroundColor;
            };

            PublicProperties.prototype.setbackGroundColor = function (value) {
                this.controls.KaigoFukaKihon().backgroundColor = value;
            };

            PublicProperties.prototype.getbtnHihoRireki_visible = function () {
                return this.controls.btnHihoRireki().visible;
            };

            PublicProperties.prototype.setbtnHihoRireki_visible = function (value) {
                this.controls.btnHihoRireki().visible = value;
            };
            return PublicProperties;
        })();
        KaigoFukaKihon.PublicProperties = PublicProperties;
    })(DBZ.KaigoFukaKihon || (DBZ.KaigoFukaKihon = {}));
    var KaigoFukaKihon = DBZ.KaigoFukaKihon;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KaigoKanryoMessage) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoKanryoMessage.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoKanryoMessage";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoKanryoMessage.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoKanryoMessage.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoKanryoMessage = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdKanryoMessage = function () {
                return new URZ.KanryoMessage.ModeController(this.convFiledName("ccdKanryoMessage"));
            };
            return Controls;
        })();
        KaigoKanryoMessage.Controls = Controls;
    })(DBZ.KaigoKanryoMessage || (DBZ.KaigoKanryoMessage = {}));
    var KaigoKanryoMessage = DBZ.KaigoKanryoMessage;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KaigoKanryoMessage) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoKanryoMessage.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoKanryoMessage.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoKanryoMessage.ModeController = ModeController;
    })(DBZ.KaigoKanryoMessage || (DBZ.KaigoKanryoMessage = {}));
    var KaigoKanryoMessage = DBZ.KaigoKanryoMessage;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoKanryoMessage) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoKanryoMessage.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("KanryoMessage_width", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getKanryoMessage_width = function () {
                return this.controls.ccdKanryoMessage().Properties().width;
            };

            PublicProperties.prototype.setKanryoMessage_width = function (value) {
                this.controls.ccdKanryoMessage().Properties().width = value;
            };
            return PublicProperties;
        })();
        KaigoKanryoMessage.PublicProperties = PublicProperties;
    })(DBZ.KaigoKanryoMessage || (DBZ.KaigoKanryoMessage = {}));
    var KaigoKanryoMessage = DBZ.KaigoKanryoMessage;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KaigoRenrakusakiInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAdd = function () {
                return "onClick_btnAdd";
            };

            Events.onClick_btnDelete = function () {
                return "onClick_btnDelete";
            };

            Events.onSelectByDC_Renrakusaki = function () {
                return "onSelectByDC_Renrakusaki";
            };

            Events.onSelectBySB_Renrakusaki = function () {
                return "onSelectBySB_Renrakusaki";
            };

            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };

            Events.onClick_btnKoshin = function () {
                return "onClick_btnKoshin";
            };

            Events.onClick_btnCancel = function () {
                return "onClick_btnCancel";
            };
            return Events;
        })();
        KaigoRenrakusakiInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoRenrakusakiInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoRenrakusakiInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoRenrakusakiInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoRenrakusakiInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.btnDelete = function () {
                return new UZA.Button(this.convFiledName("btnDelete"));
            };

            Controls.prototype.dgRenrakusaki = function () {
                return new UZA.DataGrid(this.convFiledName("dgRenrakusaki"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };

            Controls.prototype.SelectedContents = function () {
                return new UZA.Panel(this.convFiledName("SelectedContents"));
            };

            Controls.prototype.txtRenrakusakiKbnNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtRenrakusakiKbnNo"));
            };

            Controls.prototype.txtShimei = function () {
                return new UZA.TextBox(this.convFiledName("txtShimei"));
            };

            Controls.prototype.txtShimeiKana = function () {
                return new UZA.TextBox(this.convFiledName("txtShimeiKana"));
            };

            Controls.prototype.txtTsuzukigara = function () {
                return new UZA.TextBox(this.convFiledName("txtTsuzukigara"));
            };

            Controls.prototype.txtTel = function () {
                return new UZA.TextBox(this.convFiledName("txtTel"));
            };

            Controls.prototype.txtKeitaiNo = function () {
                return new UZA.TextBox(this.convFiledName("txtKeitaiNo"));
            };

            Controls.prototype.txtYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            };

            Controls.prototype.txtJusho = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtJusho"));
            };

            Controls.prototype.btnUpdate = function () {
                return new UZA.Button(this.convFiledName("btnUpdate"));
            };

            Controls.prototype.btnReturn = function () {
                return new UZA.Button(this.convFiledName("btnReturn"));
            };
            return Controls;
        })();
        KaigoRenrakusakiInfo.Controls = Controls;
    })(DBZ.KaigoRenrakusakiInfo || (DBZ.KaigoRenrakusakiInfo = {}));
    var KaigoRenrakusakiInfo = DBZ.KaigoRenrakusakiInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KaigoRenrakusakiInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoRenrakusakiInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoRenrakusakiInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoRenrakusakiInfo.ModeController = ModeController;
    })(DBZ.KaigoRenrakusakiInfo || (DBZ.KaigoRenrakusakiInfo = {}));
    var KaigoRenrakusakiInfo = DBZ.KaigoRenrakusakiInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoRenrakusakiInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KaigoRenrakusakiInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoRenrakusakiInfo.PublicProperties = PublicProperties;
    })(DBZ.KaigoRenrakusakiInfo || (DBZ.KaigoRenrakusakiInfo = {}));
    var KaigoRenrakusakiInfo = DBZ.KaigoRenrakusakiInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KaigoShikakuKihon) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoShikakuKihon.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoShikakuKihon";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoShikakuKihon.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoShikakuKihon.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoShikakuKihon = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtHihokenshaNo = function () {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaNo"));
            };

            Controls.prototype.txtShutokuYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShutokuYmd"));
            };

            Controls.prototype.txtShutokuJiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtShutokuJiyu"));
            };

            Controls.prototype.txtSoshitsuYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSoshitsuYmd"));
            };

            Controls.prototype.txtSoshitsuJiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtSoshitsuJiyu"));
            };

            Controls.prototype.txtJutokuKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtJutokuKubun"));
            };

            Controls.prototype.txtYokaigoJotaiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtYokaigoJotaiKubun"));
            };

            Controls.prototype.txtNinteiKaishiYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiKaishiYmd"));
            };

            Controls.prototype.txtNinteiShuryoYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiShuryoYmd"));
            };

            Controls.prototype.btnNinteiRireki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnNinteiRireki"));
            };

            Controls.prototype.btnHihoRireki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHihoRireki"));
            };

            Controls.prototype.btnRenrakusaki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnRenrakusaki"));
            };
            return Controls;
        })();
        KaigoShikakuKihon.Controls = Controls;
    })(DBZ.KaigoShikakuKihon || (DBZ.KaigoShikakuKihon = {}));
    var KaigoShikakuKihon = DBZ.KaigoShikakuKihon;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KaigoShikakuKihon) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoShikakuKihon.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoShikakuKihon.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "RenrakusakiAriMode",
                    "HihokenrirekiNashiMode",
                    "NinteirirekiNashiMode"
                ];
            };

            ModeController.prototype.RenrakusakiAriMode = function () {
                return new Modes.RenrakusakiAriMode(this.controls);
            };

            ModeController.prototype.HihokenrirekiNashiMode = function () {
                return new Modes.HihokenrirekiNashiMode(this.controls);
            };

            ModeController.prototype.NinteirirekiNashiMode = function () {
                return new Modes.NinteirirekiNashiMode(this.controls);
            };
            return ModeController;
        })();
        KaigoShikakuKihon.ModeController = ModeController;

        (function (Modes) {
            var RenrakusakiAriMode = (function () {
                function RenrakusakiAriMode(controls) {
                    this.controls = controls;
                }
                RenrakusakiAriMode.prototype.RenrakusakiAri = function () {
                    this.controls.btnRenrakusaki().displayNone = false;
                };
                return RenrakusakiAriMode;
            })();
            Modes.RenrakusakiAriMode = RenrakusakiAriMode;

            var HihokenrirekiNashiMode = (function () {
                function HihokenrirekiNashiMode(controls) {
                    this.controls = controls;
                }
                HihokenrirekiNashiMode.prototype.HihokenrirekiNashi = function () {
                    this.controls.btnHihoRireki().displayNone = true;
                };
                return HihokenrirekiNashiMode;
            })();
            Modes.HihokenrirekiNashiMode = HihokenrirekiNashiMode;

            var NinteirirekiNashiMode = (function () {
                function NinteirirekiNashiMode(controls) {
                    this.controls = controls;
                }
                NinteirirekiNashiMode.prototype.NinteirirekiAri = function () {
                    this.controls.btnNinteiRireki().displayNone = true;
                };
                return NinteirirekiNashiMode;
            })();
            Modes.NinteirirekiNashiMode = NinteirirekiNashiMode;
        })(KaigoShikakuKihon.Modes || (KaigoShikakuKihon.Modes = {}));
        var Modes = KaigoShikakuKihon.Modes;
    })(DBZ.KaigoShikakuKihon || (DBZ.KaigoShikakuKihon = {}));
    var KaigoShikakuKihon = DBZ.KaigoShikakuKihon;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoShikakuKihon) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KaigoShikakuKihon.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoShikakuKihon.PublicProperties = PublicProperties;
    })(DBZ.KaigoShikakuKihon || (DBZ.KaigoShikakuKihon = {}));
    var KaigoShikakuKihon = DBZ.KaigoShikakuKihon;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KaigoTeikeibun) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_ddlTeikenbunShubetsu = function () {
                return "onChange_ddlTeikenbunShubetsu";
            };

            Events.onSelectBySB_Teikeibun = function () {
                return "onSelectBySB_Teikeibun";
            };

            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        KaigoTeikeibun.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoTeikeibun";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoTeikeibun.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoTeikeibun.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoTeikeibun = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlTeikenbunShubetsu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTeikenbunShubetsu"));
            };

            Controls.prototype.dgTeikeibun = function () {
                return new UZA.DataGrid(this.convFiledName("dgTeikeibun"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        KaigoTeikeibun.Controls = Controls;
    })(DBZ.KaigoTeikeibun || (DBZ.KaigoTeikeibun = {}));
    var KaigoTeikeibun = DBZ.KaigoTeikeibun;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KaigoTeikeibun) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoTeikeibun.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoTeikeibun.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoTeikeibun.ModeController = ModeController;
    })(DBZ.KaigoTeikeibun || (DBZ.KaigoTeikeibun = {}));
    var KaigoTeikeibun = DBZ.KaigoTeikeibun;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoTeikeibun) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KaigoTeikeibun.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoTeikeibun.PublicProperties = PublicProperties;
    })(DBZ.KaigoTeikeibun || (DBZ.KaigoTeikeibun = {}));
    var KaigoTeikeibun = DBZ.KaigoTeikeibun;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KogakuServicehiDetail) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KogakuServicehiDetail.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KogakuServicehiDetail";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KogakuServicehiDetail.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KogakuServicehiDetail.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KogakuServicehiDetail = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtTeikyoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTeikyoYM"));
            };

            Controls.prototype.tabKogakuServicehiDetail = function () {
                return new UZA.TabContainer(this.convFiledName("tabKogakuServicehiDetail"));
            };

            Controls.prototype.tplShinseisha = function () {
                return new UZA.TabPanel(this.convFiledName("tplShinseisha"));
            };

            Controls.prototype.Shinseisha = function () {
                return new DBZ.ShinseishaInfo.ModeController(this.convFiledName("Shinseisha"));
            };

            Controls.prototype.txtShiharaiTotalAmount = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShiharaiTotalAmount"));
            };

            Controls.prototype.txtShinseiRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinseiRiyu"));
            };

            Controls.prototype.tplKoza = function () {
                return new UZA.TabPanel(this.convFiledName("tplKoza"));
            };

            Controls.prototype.PaymentMethod = function () {
                return new DBZ.PaymentMethod.ModeController(this.convFiledName("PaymentMethod"));
            };

            Controls.prototype.tplJudgementResult = function () {
                return new UZA.TabPanel(this.convFiledName("tplJudgementResult"));
            };

            Controls.prototype.JudgementResult = function () {
                return new DBZ.KogakuServicehiJudgementResult.ModeController(this.convFiledName("JudgementResult"));
            };

            Controls.prototype.tplKetteiJoho = function () {
                return new UZA.TabPanel(this.convFiledName("tplKetteiJoho"));
            };
            return Controls;
        })();
        KogakuServicehiDetail.Controls = Controls;
    })(DBZ.KogakuServicehiDetail || (DBZ.KogakuServicehiDetail = {}));
    var KogakuServicehiDetail = DBZ.KogakuServicehiDetail;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KogakuServicehiDetail) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KogakuServicehiDetail.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KogakuServicehiDetail.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KogakuServicehiDetail.ModeController = ModeController;
    })(DBZ.KogakuServicehiDetail || (DBZ.KogakuServicehiDetail = {}));
    var KogakuServicehiDetail = DBZ.KogakuServicehiDetail;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KogakuServicehiDetail) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KogakuServicehiDetail.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("tplJudgementResult_title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("tplKetteiJoho_visible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.KogakuServicehiDetail().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.KogakuServicehiDetail().title = value;
            };

            PublicProperties.prototype.geteraseBorder = function () {
                return this.controls.KogakuServicehiDetail().eraseBorder;
            };

            PublicProperties.prototype.seteraseBorder = function (value) {
                this.controls.KogakuServicehiDetail().eraseBorder = value;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.KogakuServicehiDetail().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.KogakuServicehiDetail().panelDisplay = value;
            };

            PublicProperties.prototype.gettplJudgementResult_title = function () {
                return this.controls.tplJudgementResult().title;
            };

            PublicProperties.prototype.settplJudgementResult_title = function (value) {
                this.controls.tplJudgementResult().title = value;
            };

            PublicProperties.prototype.gettplKetteiJoho_visible = function () {
                return this.controls.tplKetteiJoho().visible;
            };

            PublicProperties.prototype.settplKetteiJoho_visible = function (value) {
                this.controls.tplKetteiJoho().visible = value;
            };
            return PublicProperties;
        })();
        KogakuServicehiDetail.PublicProperties = PublicProperties;
    })(DBZ.KogakuServicehiDetail || (DBZ.KogakuServicehiDetail = {}));
    var KogakuServicehiDetail = DBZ.KogakuServicehiDetail;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KoshinKakuninDialog) {
        var Events = (function () {
            function Events() {
            }
            Events.CloseOK = function () {
                return "CloseOK";
            };

            Events.CloseCancel = function () {
                return "CloseCancel";
            };
            return Events;
        })();
        KoshinKakuninDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KoshinKakuninDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KoshinKakuninDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KoshinKakuninDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KoshinKakuninDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.lblKoshinMassage = function () {
                return new UZA.Label(this.convFiledName("lblKoshinMassage"));
            };

            Controls.prototype.btnYes = function () {
                return new UZA.Button(this.convFiledName("btnYes"));
            };

            Controls.prototype.btnNo = function () {
                return new UZA.Button(this.convFiledName("btnNo"));
            };
            return Controls;
        })();
        KoshinKakuninDialog.Controls = Controls;
    })(DBZ.KoshinKakuninDialog || (DBZ.KoshinKakuninDialog = {}));
    var KoshinKakuninDialog = DBZ.KoshinKakuninDialog;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KoshinKakuninDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KoshinKakuninDialog.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KoshinKakuninDialog.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KoshinKakuninDialog.ModeController = ModeController;
    })(DBZ.KoshinKakuninDialog || (DBZ.KoshinKakuninDialog = {}));
    var KoshinKakuninDialog = DBZ.KoshinKakuninDialog;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KoshinKakuninDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KoshinKakuninDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KoshinKakuninDialog.PublicProperties = PublicProperties;
    })(DBZ.KoshinKakuninDialog || (DBZ.KoshinKakuninDialog = {}));
    var KoshinKakuninDialog = DBZ.KoshinKakuninDialog;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (NenReiTotatsuSrchConInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnKensaku = function () {
                return "onClick_btnKensaku";
            };
            return Events;
        })();
        NenReiTotatsuSrchConInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "NenReiTotatsuSrchConInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.NenReiTotatsuSrchConInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.NenReiTotatsuSrchConInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.NenReiTotatsuSrchConInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtZenkaiFrom = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtZenkaiFrom"));
            };

            Controls.prototype.txtZenkaiTo = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtZenkaiTo"));
            };

            Controls.prototype.btnKensaku = function () {
                return new UZA.Button(this.convFiledName("btnKensaku"));
            };

            Controls.prototype.txtNenreiTotatsuKikanFrom = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNenreiTotatsuKikanFrom"));
            };

            Controls.prototype.txtNenreiTotatsuKikanTo = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNenreiTotatsuKikanTo"));
            };
            return Controls;
        })();
        NenReiTotatsuSrchConInfo.Controls = Controls;
    })(DBZ.NenReiTotatsuSrchConInfo || (DBZ.NenReiTotatsuSrchConInfo = {}));
    var NenReiTotatsuSrchConInfo = DBZ.NenReiTotatsuSrchConInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (NenReiTotatsuSrchConInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NenReiTotatsuSrchConInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "DisplayMode"
                ];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new NenReiTotatsuSrchConInfo.PublicProperties(this.fieldName);
            };

            ModeController.prototype.DisplayMode = function () {
                return new Modes.DisplayMode(this.controls);
            };
            return ModeController;
        })();
        NenReiTotatsuSrchConInfo.ModeController = ModeController;

        (function (Modes) {
            var DisplayMode = (function () {
                function DisplayMode(controls) {
                    this.controls = controls;
                }
                DisplayMode.prototype.KensakuInput = function () {
                    this.controls.btnKensaku().displayNone = false;
                };

                DisplayMode.prototype.ChushutsuInput = function () {
                    this.controls.btnKensaku().displayNone = true;
                };
                return DisplayMode;
            })();
            Modes.DisplayMode = DisplayMode;
        })(NenReiTotatsuSrchConInfo.Modes || (NenReiTotatsuSrchConInfo.Modes = {}));
        var Modes = NenReiTotatsuSrchConInfo.Modes;
    })(DBZ.NenReiTotatsuSrchConInfo || (DBZ.NenReiTotatsuSrchConInfo = {}));
    var NenReiTotatsuSrchConInfo = DBZ.NenReiTotatsuSrchConInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (NenReiTotatsuSrchConInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new NenReiTotatsuSrchConInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        NenReiTotatsuSrchConInfo.PublicProperties = PublicProperties;
    })(DBZ.NenReiTotatsuSrchConInfo || (DBZ.NenReiTotatsuSrchConInfo = {}));
    var NenReiTotatsuSrchConInfo = DBZ.NenReiTotatsuSrchConInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (OtherTokureiShisetsuInputGuide) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnSearchOtherShisetsu = function () {
                return "onClick_btnSearchOtherShisetsu";
            };

            Events.onSelectBySelectButton_dgSearchResultOtherTokureiShisetsu = function () {
                return "onSelectBySelectButton_dgSearchResultOtherTokureiShisetsu";
            };

            Events.onClick_btnOtherShisetsuReturn = function () {
                return "onClick_btnOtherShisetsuReturn";
            };
            return Events;
        })();
        OtherTokureiShisetsuInputGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "OtherTokureiShisetsuInputGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.OtherTokureiShisetsuInputGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.OtherTokureiShisetsuInputGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.OtherTokureiShisetsuInputGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.radKannaiKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radKannaiKubun"));
            };

            Controls.prototype.btnSearchOtherShisetsu = function () {
                return new UZA.Button(this.convFiledName("btnSearchOtherShisetsu"));
            };

            Controls.prototype.lblOtherShisetsuShurui = function () {
                return new UZA.Label(this.convFiledName("lblOtherShisetsuShurui"));
            };

            Controls.prototype.SearchResultOtherShisetsu = function () {
                return new UZA.Panel(this.convFiledName("SearchResultOtherShisetsu"));
            };

            Controls.prototype.dgSearchResultOtherTokureiShisetsu = function () {
                return new UZA.DataGrid(this.convFiledName("dgSearchResultOtherTokureiShisetsu"));
            };

            Controls.prototype.btnOtherShisetsuReturn = function () {
                return new UZA.Button(this.convFiledName("btnOtherShisetsuReturn"));
            };
            return Controls;
        })();
        OtherTokureiShisetsuInputGuide.Controls = Controls;
    })(DBZ.OtherTokureiShisetsuInputGuide || (DBZ.OtherTokureiShisetsuInputGuide = {}));
    var OtherTokureiShisetsuInputGuide = DBZ.OtherTokureiShisetsuInputGuide;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (OtherTokureiShisetsuInputGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new OtherTokureiShisetsuInputGuide.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new OtherTokureiShisetsuInputGuide.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        OtherTokureiShisetsuInputGuide.ModeController = ModeController;
    })(DBZ.OtherTokureiShisetsuInputGuide || (DBZ.OtherTokureiShisetsuInputGuide = {}));
    var OtherTokureiShisetsuInputGuide = DBZ.OtherTokureiShisetsuInputGuide;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (OtherTokureiShisetsuInputGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new OtherTokureiShisetsuInputGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        OtherTokureiShisetsuInputGuide.PublicProperties = PublicProperties;
    })(DBZ.OtherTokureiShisetsuInputGuide || (DBZ.OtherTokureiShisetsuInputGuide = {}));
    var OtherTokureiShisetsuInputGuide = DBZ.OtherTokureiShisetsuInputGuide;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (PrintContentsSetting) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        PrintContentsSetting.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "PrintContentsSetting";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.PrintContentsSetting.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.PrintContentsSetting.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.PrintContentsSetting = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtIssueDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtIssueDate"));
            };

            Controls.prototype.txtSendDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSendDate"));
            };
            return Controls;
        })();
        PrintContentsSetting.Controls = Controls;
    })(DBZ.PrintContentsSetting || (DBZ.PrintContentsSetting = {}));
    var PrintContentsSetting = DBZ.PrintContentsSetting;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (PrintContentsSetting) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new PrintContentsSetting.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new PrintContentsSetting.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        PrintContentsSetting.ModeController = ModeController;
    })(DBZ.PrintContentsSetting || (DBZ.PrintContentsSetting = {}));
    var PrintContentsSetting = DBZ.PrintContentsSetting;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (PrintContentsSetting) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new PrintContentsSetting.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtSendData_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("PrintContentsSetting_title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("PrintContentsSetting_eraseBorder", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettxtSendData_displayNone = function () {
                return this.controls.txtSendDate().displayNone;
            };

            PublicProperties.prototype.settxtSendData_displayNone = function (value) {
                this.controls.txtSendDate().displayNone = value;
            };

            PublicProperties.prototype.getPrintContentsSetting_title = function () {
                return this.controls.PrintContentsSetting().title;
            };

            PublicProperties.prototype.setPrintContentsSetting_title = function (value) {
                this.controls.PrintContentsSetting().title = value;
            };

            PublicProperties.prototype.getPrintContentsSetting_eraseBorder = function () {
                return this.controls.PrintContentsSetting().eraseBorder;
            };

            PublicProperties.prototype.setPrintContentsSetting_eraseBorder = function (value) {
                this.controls.PrintContentsSetting().eraseBorder = value;
            };
            return PublicProperties;
        })();
        PrintContentsSetting.PublicProperties = PublicProperties;
    })(DBZ.PrintContentsSetting || (DBZ.PrintContentsSetting = {}));
    var PrintContentsSetting = DBZ.PrintContentsSetting;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SearchResultOfHihokensha) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        SearchResultOfHihokensha.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SearchResultOfHihokensha";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SearchResultOfHihokensha.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SearchResultOfHihokensha.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SearchResultOfHihokensha = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgSearchResult = function () {
                return new UZA.DataGrid(this.convFiledName("dgSearchResult"));
            };

            Controls.prototype.ButtonsForSearchResultOfHihokensha = function () {
                return new UZA.Panel(this.convFiledName("ButtonsForSearchResultOfHihokensha"));
            };

            Controls.prototype.btnToResearch = function () {
                return new UZA.Button(this.convFiledName("btnToResearch"));
            };
            return Controls;
        })();
        SearchResultOfHihokensha.Controls = Controls;
    })(DBZ.SearchResultOfHihokensha || (DBZ.SearchResultOfHihokensha = {}));
    var SearchResultOfHihokensha = DBZ.SearchResultOfHihokensha;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SearchResultOfHihokensha) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SearchResultOfHihokensha.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SearchResultOfHihokensha.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SearchResultOfHihokensha.ModeController = ModeController;
    })(DBZ.SearchResultOfHihokensha || (DBZ.SearchResultOfHihokensha = {}));
    var SearchResultOfHihokensha = DBZ.SearchResultOfHihokensha;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SearchResultOfHihokensha) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SearchResultOfHihokensha.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("onClick_btnToResearch", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("height_dgSearchResult", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getonClick_btnToResearch = function () {
                return this.controls.btnToResearch().onClick;
            };

            PublicProperties.prototype.setonClick_btnToResearch = function (value) {
                this.controls.btnToResearch().onClick = value;
            };

            PublicProperties.prototype.getheight_dgSearchResult = function () {
                return this.controls.dgSearchResult().height;
            };

            PublicProperties.prototype.setheight_dgSearchResult = function (value) {
                this.controls.dgSearchResult().height = value;
            };
            return PublicProperties;
        })();
        SearchResultOfHihokensha.PublicProperties = PublicProperties;
    })(DBZ.SearchResultOfHihokensha || (DBZ.SearchResultOfHihokensha = {}));
    var SearchResultOfHihokensha = DBZ.SearchResultOfHihokensha;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SeikatsuhogoDetail) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        SeikatsuhogoDetail.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SeikatsuhogoDetail";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SeikatsuhogoDetail.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SeikatsuhogoDetail.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SeikatsuhogoDetail = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.SeikatsuhogoDetailSub = function () {
                return new UZA.Panel(this.convFiledName("SeikatsuhogoDetailSub"));
            };

            Controls.prototype.txtJukyushaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJukyushaNo"));
            };

            Controls.prototype.txtKaishiYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKaishiYM"));
            };

            Controls.prototype.txtHaishiYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtHaishiYM"));
            };

            Controls.prototype.txtHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtHokenshaNo"));
            };

            Controls.prototype.btnHokenshaGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHokenshaGuide"));
            };

            Controls.prototype.txtHokenshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtHokenshaName"));
            };

            Controls.prototype.HokenryoDairinofu = function () {
                return new UZA.Panel(this.convFiledName("SeikatsuhogoDetailSub_HokenryoDairinofu"));
            };

            Controls.prototype.radDairinofuKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radDairinofuKubun"));
            };

            Controls.prototype.txtNofuYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNofuYM"));
            };

            Controls.prototype.KyugoShisetsu = function () {
                return new UZA.Panel(this.convFiledName("SeikatsuhogoDetailSub_KyugoShisetsu"));
            };

            Controls.prototype.radNyutaishoKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radNyutaishoKubun"));
            };

            Controls.prototype.txtNyushoDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNyushoDate"));
            };

            Controls.prototype.txtTaishoDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTaishoDate"));
            };

            Controls.prototype.FujoShurui = function () {
                return new UZA.Panel(this.convFiledName("FujoShurui"));
            };

            Controls.prototype.chkFujyoShurui = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkFujyoShurui"));
            };
            return Controls;
        })();
        SeikatsuhogoDetail.Controls = Controls;
    })(DBZ.SeikatsuhogoDetail || (DBZ.SeikatsuhogoDetail = {}));
    var SeikatsuhogoDetail = DBZ.SeikatsuhogoDetail;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SeikatsuhogoDetail) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SeikatsuhogoDetail.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SeikatsuhogoDetail.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SeikatsuhogoDetail.ModeController = ModeController;
    })(DBZ.SeikatsuhogoDetail || (DBZ.SeikatsuhogoDetail = {}));
    var SeikatsuhogoDetail = DBZ.SeikatsuhogoDetail;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SeikatsuhogoDetail) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SeikatsuhogoDetail.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("btnHokenshaGuide_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getbtnHokenshaGuide_displayNone = function () {
                return this.controls.btnHokenshaGuide().displayNone;
            };

            PublicProperties.prototype.setbtnHokenshaGuide_displayNone = function (value) {
                this.controls.btnHokenshaGuide().displayNone = value;
            };
            return PublicProperties;
        })();
        SeikatsuhogoDetail.PublicProperties = PublicProperties;
    })(DBZ.SeikatsuhogoDetail || (DBZ.SeikatsuhogoDetail = {}));
    var SeikatsuhogoDetail = DBZ.SeikatsuhogoDetail;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SeikatsuhogoRireki) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        SeikatsuhogoRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SeikatsuhogoRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SeikatsuhogoRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SeikatsuhogoRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SeikatsuhogoRireki = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAddRow = function () {
                return new UZA.Button(this.convFiledName("btnAddRow"));
            };

            Controls.prototype.dgSeikatsuhogoRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgSeikatsuhogoRireki"));
            };
            return Controls;
        })();
        SeikatsuhogoRireki.Controls = Controls;
    })(DBZ.SeikatsuhogoRireki || (DBZ.SeikatsuhogoRireki = {}));
    var SeikatsuhogoRireki = DBZ.SeikatsuhogoRireki;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SeikatsuhogoRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SeikatsuhogoRireki.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SeikatsuhogoRireki.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SeikatsuhogoRireki.ModeController = ModeController;
    })(DBZ.SeikatsuhogoRireki || (DBZ.SeikatsuhogoRireki = {}));
    var SeikatsuhogoRireki = DBZ.SeikatsuhogoRireki;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SeikatsuhogoRireki) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SeikatsuhogoRireki.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SeikatsuhogoRireki.PublicProperties = PublicProperties;
    })(DBZ.SeikatsuhogoRireki || (DBZ.SeikatsuhogoRireki = {}));
    var SeikatsuhogoRireki = DBZ.SeikatsuhogoRireki;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ServiceInputGuide) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnSearchJigyosha = function () {
                return "onClick_btnSearchJigyosha";
            };

            Events.onSelectBySelectButton_SearchResultService = function () {
                return "onSelectBySelectButton_SearchResultService";
            };

            Events.onClick_btnServiceInputGuideReturn = function () {
                return "onClick_btnServiceInputGuideReturn";
            };
            return Events;
        })();
        ServiceInputGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ServiceInputGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ServiceInputGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ServiceInputGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ServiceInputGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtServiceShuruiCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceShuruiCode"));
            };

            Controls.prototype.txtServiceCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceCode"));
            };

            Controls.prototype.txtKijyunYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKijyunYM"));
            };

            Controls.prototype.btnSearchJService = function () {
                return new UZA.Button(this.convFiledName("btnSearchJService"));
            };

            Controls.prototype.SearchResultService = function () {
                return new UZA.Panel(this.convFiledName("SearchResultService"));
            };

            Controls.prototype.dgSearchResultService = function () {
                return new UZA.DataGrid(this.convFiledName("dgSearchResultService"));
            };

            Controls.prototype.btnServiceInputGuideReturn = function () {
                return new UZA.Button(this.convFiledName("btnServiceInputGuideReturn"));
            };
            return Controls;
        })();
        ServiceInputGuide.Controls = Controls;
    })(DBZ.ServiceInputGuide || (DBZ.ServiceInputGuide = {}));
    var ServiceInputGuide = DBZ.ServiceInputGuide;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ServiceInputGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceInputGuide.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ServiceInputGuide.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ServiceInputGuide.ModeController = ModeController;
    })(DBZ.ServiceInputGuide || (DBZ.ServiceInputGuide = {}));
    var ServiceInputGuide = DBZ.ServiceInputGuide;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ServiceInputGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ServiceInputGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ServiceInputGuide.PublicProperties = PublicProperties;
    })(DBZ.ServiceInputGuide || (DBZ.ServiceInputGuide = {}));
    var ServiceInputGuide = DBZ.ServiceInputGuide;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SetaiShotokuIchiran) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_Saihyoji = function () {
                return "onClick_Saihyoji";
            };

            Events.onClick_Hikaku = function () {
                return "onClick_Hikaku";
            };

            Events.onClick_SetaiKakunin = function () {
                return "onClick_SetaiKakunin";
            };
            return Events;
        })();
        SetaiShotokuIchiran.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SetaiShotokuIchiran";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SetaiShotokuIchiran.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SetaiShotokuIchiran.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SetaiShotokuIchiran = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtSetaiIchiranKijunYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSetaiIchiranKijunYMD"));
            };

            Controls.prototype.txtSetaiIchiranKazeiNendo = function () {
                return new UZA.TextBox(this.convFiledName("txtSetaiIchiranKazeiNendo"));
            };

            Controls.prototype.ddlSetaiIchiranKazeiNendo = function () {
                return new UZA.DropDownList(this.convFiledName("ddlSetaiIchiranKazeiNendo"));
            };

            Controls.prototype.btnSaiHyoji = function () {
                return new UZA.Button(this.convFiledName("btnSaiHyoji"));
            };

            Controls.prototype.txtSetaiIchiranSetaiCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtSetaiIchiranSetaiCode"));
            };

            Controls.prototype.chkSetaiIchiranAll = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSetaiIchiranAll"));
            };

            Controls.prototype.lblSetaiIchiranMsg = function () {
                return new UZA.Label(this.convFiledName("lblSetaiIchiranMsg"));
            };

            Controls.prototype.btnNarabeteHyoji = function () {
                return new UZA.Button(this.convFiledName("btnNarabeteHyoji"));
            };

            Controls.prototype.dgSetaiShotoku = function () {
                return new UZA.DataGrid(this.convFiledName("dgSetaiShotoku"));
            };
            return Controls;
        })();
        SetaiShotokuIchiran.Controls = Controls;
    })(DBZ.SetaiShotokuIchiran || (DBZ.SetaiShotokuIchiran = {}));
    var SetaiShotokuIchiran = DBZ.SetaiShotokuIchiran;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SetaiShotokuIchiran) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SetaiShotokuIchiran.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SetaiShotokuIchiran.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SetaiShotokuIchiran.ModeController = ModeController;
    })(DBZ.SetaiShotokuIchiran || (DBZ.SetaiShotokuIchiran = {}));
    var SetaiShotokuIchiran = DBZ.SetaiShotokuIchiran;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SetaiShotokuIchiran) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SetaiShotokuIchiran.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtKijunYmdVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtKijunYmdReadOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtKazeiNendoVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtKazeiNendoReadOnly", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ddlKazeiNendoVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("ddlKazeiNendoDataSource", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("btnSaihyojiVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnSaihyojiOnClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("chkIchiranAllOnClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("btnNarabeteHyojuVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnNarabeteHyojuOnClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgSetaishotokuGridSetting", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgSetaishotokuWidth", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgSetaishotokuOnSelect", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgSetaishotokuDbClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dgSetaishotokuBySelectButton", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("ddlKazeiNendoDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnNarabeteHyoJiDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtSetaiCodeDisyplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnSaihyojiDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("lblKijunYMDMsgVisible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("lblKijunYMDMsgDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtSetaiIchiranKazeiNendoDisplayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.gettxtKijunYmdVisible = function () {
                return this.controls.txtSetaiIchiranKijunYMD().visible;
            };

            PublicProperties.prototype.settxtKijunYmdVisible = function (value) {
                this.controls.txtSetaiIchiranKijunYMD().visible = value;
            };

            PublicProperties.prototype.gettxtKijunYmdReadOnly = function () {
                return this.controls.txtSetaiIchiranKijunYMD().readOnly;
            };

            PublicProperties.prototype.settxtKijunYmdReadOnly = function (value) {
                this.controls.txtSetaiIchiranKijunYMD().readOnly = value;
            };

            PublicProperties.prototype.gettxtKazeiNendoVisible = function () {
                return this.controls.txtSetaiIchiranKazeiNendo().visible;
            };

            PublicProperties.prototype.settxtKazeiNendoVisible = function (value) {
                this.controls.txtSetaiIchiranKazeiNendo().visible = value;
            };

            PublicProperties.prototype.gettxtKazeiNendoReadOnly = function () {
                return this.controls.txtSetaiIchiranKazeiNendo().readOnly;
            };

            PublicProperties.prototype.settxtKazeiNendoReadOnly = function (value) {
                this.controls.txtSetaiIchiranKazeiNendo().readOnly = value;
            };

            PublicProperties.prototype.getddlKazeiNendoVisible = function () {
                return this.controls.ddlSetaiIchiranKazeiNendo().visible;
            };

            PublicProperties.prototype.setddlKazeiNendoVisible = function (value) {
                this.controls.ddlSetaiIchiranKazeiNendo().visible = value;
            };

            PublicProperties.prototype.getbtnSaihyojiVisible = function () {
                return this.controls.btnSaiHyoji().visible;
            };

            PublicProperties.prototype.setbtnSaihyojiVisible = function (value) {
                this.controls.btnSaiHyoji().visible = value;
            };

            PublicProperties.prototype.getbtnSaihyojiOnClick = function () {
                return this.controls.btnSaiHyoji().onClick;
            };

            PublicProperties.prototype.setbtnSaihyojiOnClick = function (value) {
                this.controls.btnSaiHyoji().onClick = value;
            };

            PublicProperties.prototype.getchkIchiranAllOnClick = function () {
                return this.controls.chkSetaiIchiranAll().onClick;
            };

            PublicProperties.prototype.setchkIchiranAllOnClick = function (value) {
                this.controls.chkSetaiIchiranAll().onClick = value;
            };

            PublicProperties.prototype.getbtnNarabeteHyojuVisible = function () {
                return this.controls.btnNarabeteHyoji().visible;
            };

            PublicProperties.prototype.setbtnNarabeteHyojuVisible = function (value) {
                this.controls.btnNarabeteHyoji().visible = value;
            };

            PublicProperties.prototype.getbtnNarabeteHyojuOnClick = function () {
                return this.controls.btnNarabeteHyoji().onClick;
            };

            PublicProperties.prototype.setbtnNarabeteHyojuOnClick = function (value) {
                this.controls.btnNarabeteHyoji().onClick = value;
            };

            PublicProperties.prototype.getdgSetaishotokuWidth = function () {
                return this.controls.dgSetaiShotoku().width;
            };

            PublicProperties.prototype.setdgSetaishotokuWidth = function (value) {
                this.controls.dgSetaiShotoku().width = value;
            };

            PublicProperties.prototype.getdgSetaishotokuOnSelect = function () {
                return this.controls.dgSetaiShotoku().onSelect;
            };

            PublicProperties.prototype.setdgSetaishotokuOnSelect = function (value) {
                this.controls.dgSetaiShotoku().onSelect = value;
            };

            PublicProperties.prototype.getdgSetaishotokuDbClick = function () {
                return this.controls.dgSetaiShotoku().onSelectByDblClick;
            };

            PublicProperties.prototype.setdgSetaishotokuDbClick = function (value) {
                this.controls.dgSetaiShotoku().onSelectByDblClick = value;
            };

            PublicProperties.prototype.getdgSetaishotokuBySelectButton = function () {
                return this.controls.dgSetaiShotoku().onSelectBySelectButton;
            };

            PublicProperties.prototype.setdgSetaishotokuBySelectButton = function (value) {
                this.controls.dgSetaiShotoku().onSelectBySelectButton = value;
            };

            PublicProperties.prototype.getddlKazeiNendoDisplayNone = function () {
                return this.controls.ddlSetaiIchiranKazeiNendo().displayNone;
            };

            PublicProperties.prototype.setddlKazeiNendoDisplayNone = function (value) {
                this.controls.ddlSetaiIchiranKazeiNendo().displayNone = value;
            };

            PublicProperties.prototype.getbtnNarabeteHyoJiDisplayNone = function () {
                return this.controls.btnNarabeteHyoji().displayNone;
            };

            PublicProperties.prototype.setbtnNarabeteHyoJiDisplayNone = function (value) {
                this.controls.btnNarabeteHyoji().displayNone = value;
            };

            PublicProperties.prototype.gettxtSetaiCodeDisyplayNone = function () {
                return this.controls.txtSetaiIchiranSetaiCode().displayNone;
            };

            PublicProperties.prototype.settxtSetaiCodeDisyplayNone = function (value) {
                this.controls.txtSetaiIchiranSetaiCode().displayNone = value;
            };

            PublicProperties.prototype.getbtnSaihyojiDisplayNone = function () {
                return this.controls.btnSaiHyoji().displayNone;
            };

            PublicProperties.prototype.setbtnSaihyojiDisplayNone = function (value) {
                this.controls.btnSaiHyoji().displayNone = value;
            };

            PublicProperties.prototype.getlblKijunYMDMsgVisible = function () {
                return this.controls.lblSetaiIchiranMsg().visible;
            };

            PublicProperties.prototype.setlblKijunYMDMsgVisible = function (value) {
                this.controls.lblSetaiIchiranMsg().visible = value;
            };

            PublicProperties.prototype.getlblKijunYMDMsgDisplayNone = function () {
                return this.controls.lblSetaiIchiranMsg().displayNone;
            };

            PublicProperties.prototype.setlblKijunYMDMsgDisplayNone = function (value) {
                this.controls.lblSetaiIchiranMsg().displayNone = value;
            };

            PublicProperties.prototype.gettxtSetaiIchiranKazeiNendoDisplayNone = function () {
                return this.controls.txtSetaiIchiranKazeiNendo().displayNone;
            };

            PublicProperties.prototype.settxtSetaiIchiranKazeiNendoDisplayNone = function (value) {
                this.controls.txtSetaiIchiranKazeiNendo().displayNone = value;
            };
            return PublicProperties;
        })();
        SetaiShotokuIchiran.PublicProperties = PublicProperties;
    })(DBZ.SetaiShotokuIchiran || (DBZ.SetaiShotokuIchiran = {}));
    var SetaiShotokuIchiran = DBZ.SetaiShotokuIchiran;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShichosonSelector) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnReturn = function () {
                return "onClick_btnReturn";
            };

            Events.onClick_btnDecision = function () {
                return "onClick_btnDecision";
            };
            return Events;
        })();
        ShichosonSelector.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShichosonSelector";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShichosonSelector.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShichosonSelector.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShichosonSelector = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgShichoson = function () {
                return new UZA.DataGrid(this.convFiledName("dgShichoson"));
            };

            Controls.prototype.btnReturn = function () {
                return new UZA.Button(this.convFiledName("btnReturn"));
            };

            Controls.prototype.btnDecision = function () {
                return new UZA.Button(this.convFiledName("btnDecision"));
            };
            return Controls;
        })();
        ShichosonSelector.Controls = Controls;
    })(DBZ.ShichosonSelector || (DBZ.ShichosonSelector = {}));
    var ShichosonSelector = DBZ.ShichosonSelector;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShichosonSelector) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShichosonSelector.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShichosonSelector.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShichosonSelector.ModeController = ModeController;
    })(DBZ.ShichosonSelector || (DBZ.ShichosonSelector = {}));
    var ShichosonSelector = DBZ.ShichosonSelector;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShichosonSelector) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShichosonSelector.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShichosonSelector.PublicProperties = PublicProperties;
    })(DBZ.ShichosonSelector || (DBZ.ShichosonSelector = {}));
    var ShichosonSelector = DBZ.ShichosonSelector;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiFukaInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        SogoShokaiFukaInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SogoShokaiFukaInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SogoShokaiFukaInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SogoShokaiFukaInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SogoShokaiFukaInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtFukaChoteiNendo = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtFukaChoteiNendo"));
            };

            Controls.prototype.txtFukaChoteiJiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtFukaChoteiJiyu"));
            };

            Controls.prototype.txtFukaKoseiTsuki = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFukaKoseiTsuki"));
            };

            Controls.prototype.txtFukaFukaNendo = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtFukaFukaNendo"));
            };

            Controls.prototype.txtFukaKazeiKubunHonnin = function () {
                return new UZA.TextBox(this.convFiledName("txtFukaKazeiKubunHonnin"));
            };

            Controls.prototype.txtFukaKazeiKubunSetai = function () {
                return new UZA.TextBox(this.convFiledName("txtFukaKazeiKubunSetai"));
            };

            Controls.prototype.tblFuka = function () {
                return new UZA.TablePanel(this.convFiledName("tblFuka"));
            };

            Controls.prototype.celFuka11 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka11"));
            };

            Controls.prototype.celFuka12 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka12"));
            };

            Controls.prototype.lblFukaKijun = function () {
                return new UZA.Label(this.convFiledName("lblFukaKijun"));
            };

            Controls.prototype.celFuka21 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka21"));
            };

            Controls.prototype.lblFukaKijunYMD = function () {
                return new UZA.Label(this.convFiledName("lblFukaKijunYMD"));
            };

            Controls.prototype.celFuka22 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka22"));
            };

            Controls.prototype.txtFukaKijunYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtFukaKijunYMD"));
            };

            Controls.prototype.celFuka31 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka31"));
            };

            Controls.prototype.celFuka32 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka32"));
            };

            Controls.prototype.lblZennendo = function () {
                return new UZA.Label(this.convFiledName("lblZennendo"));
            };

            Controls.prototype.celFuka41 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka41"));
            };

            Controls.prototype.lblShotokuDankai = function () {
                return new UZA.Label(this.convFiledName("lblShotokuDankai"));
            };

            Controls.prototype.celFuka42 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka42"));
            };

            Controls.prototype.txtShotokuDankai = function () {
                return new UZA.TextBox(this.convFiledName("txtShotokuDankai"));
            };

            Controls.prototype.celFuka51 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka51"));
            };

            Controls.prototype.lblHokenryoRitsu = function () {
                return new UZA.Label(this.convFiledName("lblHokenryoRitsu"));
            };

            Controls.prototype.celFuka52 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka52"));
            };

            Controls.prototype.txtHokenryoRitsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenryoRitsu"));
            };

            Controls.prototype.celFuka61 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka61"));
            };

            Controls.prototype.lblNenHokenryo = function () {
                return new UZA.Label(this.convFiledName("lblNenHokenryo"));
            };

            Controls.prototype.celFuka62 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka62"));
            };

            Controls.prototype.txtNenHokenryo = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtNenHokenryo"));
            };

            Controls.prototype.celFuka71 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka71"));
            };

            Controls.prototype.lblTokubetsuSaishugaku = function () {
                return new UZA.Label(this.convFiledName("lblTokubetsuSaishugaku"));
            };

            Controls.prototype.celFuka72 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka72"));
            };

            Controls.prototype.txtTokubetsuSaishugaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsuSaishugaku"));
            };

            Controls.prototype.celFuka81 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka81"));
            };

            Controls.prototype.lblFutsuSaishugaku = function () {
                return new UZA.Label(this.convFiledName("lblFutsuSaishugaku"));
            };

            Controls.prototype.celFuka82 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka82"));
            };

            Controls.prototype.txtFutsuSaishugaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsuSaishugaku"));
            };

            Controls.prototype.celFuka91 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka91"));
            };

            Controls.prototype.celFuka92 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka92"));
            };

            Controls.prototype.lblGenmen = function () {
                return new UZA.Label(this.convFiledName("lblGenmen"));
            };

            Controls.prototype.celFuka101 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka101"));
            };

            Controls.prototype.lblGenmengaku = function () {
                return new UZA.Label(this.convFiledName("lblGenmengaku"));
            };

            Controls.prototype.celFuka102 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka102"));
            };

            Controls.prototype.txtGenmengaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmengaku"));
            };

            Controls.prototype.celFuka111 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka111"));
            };

            Controls.prototype.celFuka112 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka112"));
            };

            Controls.prototype.lblEtc = function () {
                return new UZA.Label(this.convFiledName("lblEtc"));
            };

            Controls.prototype.celFuka121 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka121"));
            };

            Controls.prototype.lblZanteiGokei = function () {
                return new UZA.Label(this.convFiledName("lblZanteiGokei"));
            };

            Controls.prototype.celFuka122 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka122"));
            };

            Controls.prototype.txtZanteiGokei = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtZanteiGokei"));
            };

            Controls.prototype.celFuka131 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka131"));
            };

            Controls.prototype.lblSudeniNofugaku = function () {
                return new UZA.Label(this.convFiledName("lblSudeniNofugaku"));
            };

            Controls.prototype.celFuka132 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka132"));
            };

            Controls.prototype.txtSudeniNofugaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSudeniNofugaku"));
            };

            Controls.prototype.celFuka141 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka141"));
            };

            Controls.prototype.lblKongoNofugaku = function () {
                return new UZA.Label(this.convFiledName("lblKongoNofugaku"));
            };

            Controls.prototype.celFuka142 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka142"));
            };

            Controls.prototype.txtKongoNofugaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKongoNofugaku"));
            };

            Controls.prototype.celFuka151 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka151"));
            };

            Controls.prototype.lblNofuzumigaku = function () {
                return new UZA.Label(this.convFiledName("lblNofuzumigaku"));
            };

            Controls.prototype.celFuka152 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka152"));
            };

            Controls.prototype.txtNofuzumigaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtNofuzumigaku"));
            };

            Controls.prototype.tblFutsuChoshu = function () {
                return new UZA.TablePanel(this.convFiledName("tblFutsuChoshu"));
            };

            Controls.prototype.celFutsuChoshu11 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu11"));
            };

            Controls.prototype.celFutsuChoshu12 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu12"));
            };

            Controls.prototype.lblFutsu = function () {
                return new UZA.Label(this.convFiledName("lblFutsu"));
            };

            Controls.prototype.celFutsuChoshu21 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu21"));
            };

            Controls.prototype.lblFutsu1 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu1"));
            };

            Controls.prototype.celFutsuChoshu22 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu22"));
            };

            Controls.prototype.txtFutsu1 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu1"));
            };

            Controls.prototype.celFutsuChoshu31 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu31"));
            };

            Controls.prototype.lblFutsu2 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu2"));
            };

            Controls.prototype.celFutsuChoshu32 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu32"));
            };

            Controls.prototype.txtFutsu2 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu2"));
            };

            Controls.prototype.celFutsuChoshu41 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu41"));
            };

            Controls.prototype.lblFutsu3 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu3"));
            };

            Controls.prototype.celFutsuChoshu42 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu42"));
            };

            Controls.prototype.txtFutsu3 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu3"));
            };

            Controls.prototype.celFutsuChoshu51 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu51"));
            };

            Controls.prototype.lblFutsu4 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu4"));
            };

            Controls.prototype.celFutsuChoshu52 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu52"));
            };

            Controls.prototype.txtFutsu4 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu4"));
            };

            Controls.prototype.celFutsuChoshu61 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu61"));
            };

            Controls.prototype.lblFutsu5 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu5"));
            };

            Controls.prototype.celFutsuChoshu62 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu62"));
            };

            Controls.prototype.txtFutsu5 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu5"));
            };

            Controls.prototype.celFutsuChoshu71 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu71"));
            };

            Controls.prototype.lblFutsu6 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu6"));
            };

            Controls.prototype.celFutsuChoshu72 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu72"));
            };

            Controls.prototype.txtFutsu6 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu6"));
            };

            Controls.prototype.celFutsuChoshu81 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu81"));
            };

            Controls.prototype.lblFutsu7 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu7"));
            };

            Controls.prototype.celFutsuChoshu82 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu82"));
            };

            Controls.prototype.txtFutsu7 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu7"));
            };

            Controls.prototype.celFutsuChoshu91 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu91"));
            };

            Controls.prototype.lblFutsu8 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu8"));
            };

            Controls.prototype.celFutsuChoshu92 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu92"));
            };

            Controls.prototype.txtFutsu8 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu8"));
            };

            Controls.prototype.celFutsuChoshu101 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu101"));
            };

            Controls.prototype.lblFutsu9 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu9"));
            };

            Controls.prototype.celFutsuChoshu102 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu102"));
            };

            Controls.prototype.txtFutsu9 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu9"));
            };

            Controls.prototype.celFutsuChoshu111 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu111"));
            };

            Controls.prototype.lblFutsu10 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu10"));
            };

            Controls.prototype.celFutsuChoshu112 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu112"));
            };

            Controls.prototype.txtFutsu10 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu10"));
            };

            Controls.prototype.celFutsuChoshu121 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu121"));
            };

            Controls.prototype.lblFutsu11 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu11"));
            };

            Controls.prototype.celFutsuChoshu122 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu122"));
            };

            Controls.prototype.txtFutsu11 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu11"));
            };

            Controls.prototype.celFutsuChoshu131 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu131"));
            };

            Controls.prototype.lblFutsu12 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu12"));
            };

            Controls.prototype.celFutsuChoshu132 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu132"));
            };

            Controls.prototype.txtFutsu12 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu12"));
            };

            Controls.prototype.celFutsuChoshu141 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu141"));
            };

            Controls.prototype.lblFutsu13 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu13"));
            };

            Controls.prototype.celFutsuChoshu142 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu142"));
            };

            Controls.prototype.txtFutsu13 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu13"));
            };

            Controls.prototype.celFutsuChoshu151 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu151"));
            };

            Controls.prototype.lblFutsu14 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu14"));
            };

            Controls.prototype.celFutsuChoshu152 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu152"));
            };

            Controls.prototype.txtFutsu14 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu14"));
            };

            Controls.prototype.tblTokubetsuChoshu = function () {
                return new UZA.TablePanel(this.convFiledName("tblTokubetsuChoshu"));
            };

            Controls.prototype.celTokubetsuChoshu11 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu11"));
            };

            Controls.prototype.celTokubetsuChoshu12 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu12"));
            };

            Controls.prototype.lblTokubetsu = function () {
                return new UZA.Label(this.convFiledName("lblTokubetsu"));
            };

            Controls.prototype.celTokubetsuChoshu21 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu21"));
            };

            Controls.prototype.lblTokubetsu1 = function () {
                return new UZA.Label(this.convFiledName("lblTokubetsu1"));
            };

            Controls.prototype.celTokubetsuChoshu22 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu22"));
            };

            Controls.prototype.txtTokubetsu1 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsu1"));
            };

            Controls.prototype.celTokubetsuChoshu31 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu31"));
            };

            Controls.prototype.lblTokubetsu2 = function () {
                return new UZA.Label(this.convFiledName("lblTokubetsu2"));
            };

            Controls.prototype.celTokubetsuChoshu32 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu32"));
            };

            Controls.prototype.txtTokubetsu2 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsu2"));
            };

            Controls.prototype.celTokubetsuChoshu41 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu41"));
            };

            Controls.prototype.lblTokubetsu3 = function () {
                return new UZA.Label(this.convFiledName("lblTokubetsu3"));
            };

            Controls.prototype.celTokubetsuChoshu42 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu42"));
            };

            Controls.prototype.txtTokubetsu3 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsu3"));
            };

            Controls.prototype.celTokubetsuChoshu51 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu51"));
            };

            Controls.prototype.lblTokubetsu4 = function () {
                return new UZA.Label(this.convFiledName("lblTokubetsu4"));
            };

            Controls.prototype.celTokubetsuChoshu52 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu52"));
            };

            Controls.prototype.txtTokubetsu4 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsu4"));
            };

            Controls.prototype.celTokubetsuChoshu61 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu61"));
            };

            Controls.prototype.lblTokubetsu5 = function () {
                return new UZA.Label(this.convFiledName("lblTokubetsu5"));
            };

            Controls.prototype.celTokubetsuChoshu62 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu62"));
            };

            Controls.prototype.txtTokubetsu5 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsu5"));
            };

            Controls.prototype.celTokubetsuChoshu71 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu71"));
            };

            Controls.prototype.lblTokubetsu6 = function () {
                return new UZA.Label(this.convFiledName("lblTokubetsu6"));
            };

            Controls.prototype.celTokubetsuChoshu72 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu72"));
            };

            Controls.prototype.txtTokubetsu6 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsu6"));
            };

            Controls.prototype.SogoShokaiFukaTokubetsuChoshu = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiFukaTokubetsuChoshu"));
            };

            Controls.prototype.txtFukaTokubetsuChoshuNenkin = function () {
                return new UZA.TextBox(this.convFiledName("txtFukaTokubetsuChoshuNenkin"));
            };

            Controls.prototype.txtFukaTokubetsuChoshuGimusha = function () {
                return new UZA.TextBox(this.convFiledName("txtFukaTokubetsuChoshuGimusha"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        SogoShokaiFukaInfo.Controls = Controls;
    })(DBZ.SogoShokaiFukaInfo || (DBZ.SogoShokaiFukaInfo = {}));
    var SogoShokaiFukaInfo = DBZ.SogoShokaiFukaInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiFukaInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiFukaInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SogoShokaiFukaInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiFukaInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiFukaInfo || (DBZ.SogoShokaiFukaInfo = {}));
    var SogoShokaiFukaInfo = DBZ.SogoShokaiFukaInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiFukaInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiFukaInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiFukaInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiFukaInfo || (DBZ.SogoShokaiFukaInfo = {}));
    var SogoShokaiFukaInfo = DBZ.SogoShokaiFukaInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiFukushiYoguKonyuhiInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        SogoShokaiFukushiYoguKonyuhiInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SogoShokaiFukushiYoguKonyuhiInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SogoShokaiFukushiYoguKonyuhiInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SogoShokaiFukushiYoguKonyuhiInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SogoShokaiFukushiYoguKonyuhiInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtTeikyoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTeikyoYM"));
            };

            Controls.prototype.txtSeiriNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtSeiriNo"));
            };

            Controls.prototype.txtKyufuritsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKyufuritsu"));
            };

            Controls.prototype.dgYoguSeikyuDetail = function () {
                return new UZA.DataGrid(this.convFiledName("dgYoguSeikyuDetail"));
            };

            Controls.prototype.YoguKonyuhiShikyuShinseiSeikyuDetail = function () {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiSeikyuDetail"));
            };

            Controls.prototype.txtBuyYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtBuyYMD"));
            };

            Controls.prototype.txtShumoku = function () {
                return new UZA.TextBox(this.convFiledName("txtShumoku"));
            };

            Controls.prototype.txtShohinName = function () {
                return new UZA.TextBox(this.convFiledName("txtShohinName"));
            };

            Controls.prototype.txtSeizoJigyosha = function () {
                return new UZA.TextBox(this.convFiledName("txtSeizoJigyosha"));
            };

            Controls.prototype.txtHanbaiJigyosha = function () {
                return new UZA.TextBox(this.convFiledName("txtHanbaiJigyosha"));
            };

            Controls.prototype.txtBuyAmount = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtBuyAmount"));
            };

            Controls.prototype.txtHinmokuCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtHinmokuCode"));
            };

            Controls.prototype.txtShinsaMethod = function () {
                return new UZA.TextBox(this.convFiledName("txtShinsaMethod"));
            };

            Controls.prototype.tblYoguSeikyuSummary = function () {
                return new UZA.TablePanel(this.convFiledName("tblYoguSeikyuSummary"));
            };

            Controls.prototype.celYogu11 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu11"));
            };

            Controls.prototype.lblYoguSummary = function () {
                return new UZA.Label(this.convFiledName("lblYoguSummary"));
            };

            Controls.prototype.celYogu12 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu12"));
            };

            Controls.prototype.lblYoguPayTotal = function () {
                return new UZA.Label(this.convFiledName("lblYoguPayTotal"));
            };

            Controls.prototype.celYogu13 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu13"));
            };

            Controls.prototype.lblYoguHokenSeikyuAmount = function () {
                return new UZA.Label(this.convFiledName("lblYoguHokenSeikyuAmount"));
            };

            Controls.prototype.celYogu14 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu14"));
            };

            Controls.prototype.lblYoguRiyoshaFutanAmount = function () {
                return new UZA.Label(this.convFiledName("lblYoguRiyoshaFutanAmount"));
            };

            Controls.prototype.celYogu15 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu15"));
            };

            Controls.prototype.lblYoguLimitOverAmount = function () {
                return new UZA.Label(this.convFiledName("lblYoguLimitOverAmount"));
            };

            Controls.prototype.celYogu21 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu21"));
            };

            Controls.prototype.lblYoguSummaryMae = function () {
                return new UZA.Label(this.convFiledName("lblYoguSummaryMae"));
            };

            Controls.prototype.celYogu22 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu22"));
            };

            Controls.prototype.txtYoguPayTotalMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguPayTotalMae"));
            };

            Controls.prototype.celYogu23 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu23"));
            };

            Controls.prototype.txtYoguHokenSeikyuAmountMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguHokenSeikyuAmountMae"));
            };

            Controls.prototype.celYogu24 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu24"));
            };

            Controls.prototype.txtYoguRiyoshaFutanAmountMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguRiyoshaFutanAmountMae"));
            };

            Controls.prototype.celYogu25 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu25"));
            };

            Controls.prototype.txtYoguLimitOverAmountMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguLimitOverAmountMae"));
            };

            Controls.prototype.celYogu31 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu31"));
            };

            Controls.prototype.lblYoguSummaryNow = function () {
                return new UZA.Label(this.convFiledName("lblYoguSummaryNow"));
            };

            Controls.prototype.celYogu32 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu32"));
            };

            Controls.prototype.txtYoguPayTotalNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguPayTotalNow"));
            };

            Controls.prototype.celYogu33 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu33"));
            };

            Controls.prototype.txtYoguHokenSeikyuAmountNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguHokenSeikyuAmountNow"));
            };

            Controls.prototype.celYogu34 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu34"));
            };

            Controls.prototype.txtYoguRiyoshaFutanAmountNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguRiyoshaFutanAmountNow"));
            };

            Controls.prototype.celYogu35 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu35"));
            };

            Controls.prototype.txtYoguLimitOverAmountNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguLimitOverAmountNow"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        SogoShokaiFukushiYoguKonyuhiInfo.Controls = Controls;
    })(DBZ.SogoShokaiFukushiYoguKonyuhiInfo || (DBZ.SogoShokaiFukushiYoguKonyuhiInfo = {}));
    var SogoShokaiFukushiYoguKonyuhiInfo = DBZ.SogoShokaiFukushiYoguKonyuhiInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiFukushiYoguKonyuhiInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiFukushiYoguKonyuhiInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SogoShokaiFukushiYoguKonyuhiInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiFukushiYoguKonyuhiInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiFukushiYoguKonyuhiInfo || (DBZ.SogoShokaiFukushiYoguKonyuhiInfo = {}));
    var SogoShokaiFukushiYoguKonyuhiInfo = DBZ.SogoShokaiFukushiYoguKonyuhiInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiFukushiYoguKonyuhiInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiFukushiYoguKonyuhiInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiFukushiYoguKonyuhiInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiFukushiYoguKonyuhiInfo || (DBZ.SogoShokaiFukushiYoguKonyuhiInfo = {}));
    var SogoShokaiFukushiYoguKonyuhiInfo = DBZ.SogoShokaiFukushiYoguKonyuhiInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiNinteiInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        SogoShokaiNinteiInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SogoShokaiNinteiInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SogoShokaiNinteiInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SogoShokaiNinteiInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SogoShokaiNinteiInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtNinteiShinseiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiShinseiYMD"));
            };

            Controls.prototype.txtNinteiShinseiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiShinseiKubun"));
            };

            Controls.prototype.txtNinteiYukoKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiYukoKubun"));
            };

            Controls.prototype.txtNinteiChosaJissiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiChosaJissiYMD"));
            };

            Controls.prototype.txtNinteiChosaJuryoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiChosaJuryoYMD"));
            };

            Controls.prototype.txtNinteiChosaKanryoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiChosaKanryoYMD"));
            };

            Controls.prototype.txtNinteiChosaItakusaki = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosaItakusaki"));
            };

            Controls.prototype.txtNinteiChosain = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosain"));
            };

            Controls.prototype.txtNinteiShujiiIryoKikan = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiShujiiIryoKikan"));
            };

            Controls.prototype.txtNinteiShujii = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiShujii"));
            };

            Controls.prototype.txtNinteiIkenshoJuryoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiIkenshoJuryoYMD"));
            };

            Controls.prototype.txtNinteiIkenshoKanryoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiIkenshoKanryoYMD"));
            };

            Controls.prototype.txtNinteiIchijiHantei = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiIchijiHantei"));
            };

            Controls.prototype.txtNinteiIchijiHanteiNinchi = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiIchijiHanteiNinchi"));
            };

            Controls.prototype.txtNinteiIchijiHanteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiIchijiHanteiYMD"));
            };

            Controls.prototype.txtNinteiIchijiKanryoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiIchijiKanryoYMD"));
            };

            Controls.prototype.txtNinteiNinteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiNinteiYMD"));
            };

            Controls.prototype.txtNinteiJotaiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiJotaiKubun"));
            };

            Controls.prototype.txtNinteiYukoKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNinteiYukoKikan"));
            };

            Controls.prototype.txtNinteiIdoJiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiIdoJiyu"));
            };

            Controls.prototype.txtNinteiIdoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiIdoYMD"));
            };

            Controls.prototype.txtNinteiSoshitsuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiSoshitsuYMD"));
            };

            Controls.prototype.txtNinteiTorikeshiRiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiTorikeshiRiyu"));
            };

            Controls.prototype.txtNinteiTorikeshiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiTorikeshiYMD"));
            };

            Controls.prototype.txtNinteiTokuteiShippei = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiTokuteiShippei"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        SogoShokaiNinteiInfo.Controls = Controls;
    })(DBZ.SogoShokaiNinteiInfo || (DBZ.SogoShokaiNinteiInfo = {}));
    var SogoShokaiNinteiInfo = DBZ.SogoShokaiNinteiInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiNinteiInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiNinteiInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SogoShokaiNinteiInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiNinteiInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiNinteiInfo || (DBZ.SogoShokaiNinteiInfo = {}));
    var SogoShokaiNinteiInfo = DBZ.SogoShokaiNinteiInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiNinteiInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiNinteiInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiNinteiInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiNinteiInfo || (DBZ.SogoShokaiNinteiInfo = {}));
    var SogoShokaiNinteiInfo = DBZ.SogoShokaiNinteiInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiSaishinsaMoushitateInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        SogoShokaiSaishinsaMoushitateInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SogoShokaiSaishinsaMoushitateInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SogoShokaiSaishinsaMoushitateInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SogoShokaiSaishinsaMoushitateInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SogoShokaiSaishinsaMoushitateInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtSaishinsaTaishoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSaishinsaTaishoYM"));
            };

            Controls.prototype.txtSaishinsaMoshitateYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSaishinsaMoshitateYMD"));
            };

            Controls.prototype.txtSaishinsaTeikyoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSaishinsaTeikyoYM"));
            };

            Controls.prototype.txtSaishinsaJigyoshaCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtSaishinsaJigyoshaCode"));
            };

            Controls.prototype.txtSaishinsaJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtSaishinsaJigyoshaName"));
            };

            Controls.prototype.txtSaishinsaServiceShuruiCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtSaishinsaServiceShuruiCode"));
            };

            Controls.prototype.txtSaishinsaServiceCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtSaishinsaServiceCode"));
            };

            Controls.prototype.txtSaishinsaServiceName = function () {
                return new UZA.TextBox(this.convFiledName("txtSaishinsaServiceName"));
            };

            Controls.prototype.txtSaishinsaMoshitateTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaMoshitateTanisu"));
            };

            Controls.prototype.SogoShokaiSaishinsaJiyu = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiSaishinsaJiyu"));
            };

            Controls.prototype.txtSaishinsaMoshitateKomoku = function () {
                return new UZA.TextBox(this.convFiledName("txtSaishinsaMoshitateKomoku"));
            };

            Controls.prototype.txtSaishinsaMoshitateRiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtSaishinsaMoshitateRiyu"));
            };

            Controls.prototype.SogoShokaiSaishinsaKekka = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiSaishinsaKekka"));
            };

            Controls.prototype.SogoShokaiSaishinsaHokensha = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiSaishinsaKekka_SogoShokaiSaishinsaHokensha"));
            };

            Controls.prototype.txtSaishinsaHokenshaKekka = function () {
                return new UZA.TextBox(this.convFiledName("txtSaishinsaHokenshaKekka"));
            };

            Controls.prototype.txtSaishinsaHokenshaToshoTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaHokenshaToshoTanisu"));
            };

            Controls.prototype.txtSaishinsaHokenshaGenshinTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaHokenshaGenshinTanisu"));
            };

            Controls.prototype.txtSaishinsaHokenshaMoshitateTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaHokenshaMoshitateTanisu"));
            };

            Controls.prototype.txtSaishinsaHokenshaKetteiTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaHokenshaKetteiTanisu"));
            };

            Controls.prototype.txtSaishinsaHokenshaChoseiTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaHokenshaChoseiTanisu"));
            };

            Controls.prototype.txtSaishinsaHokenshaFutangaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaHokenshaFutangaku"));
            };

            Controls.prototype.SogoShokaiSaishinsaKohi = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiSaishinsaKekka_SogoShokaiSaishinsaKohi"));
            };

            Controls.prototype.txtSaishinsaKohiJukyushaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtSaishinsaKohiJukyushaNo"));
            };

            Controls.prototype.txtSaishinsaKohiJukyushaName = function () {
                return new UZA.TextBox(this.convFiledName("txtSaishinsaKohiJukyushaName"));
            };

            Controls.prototype.txtSaishinsaKohiHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtSaishinsaKohiHokenshaNo"));
            };

            Controls.prototype.txtSaishinsaKohiKekka = function () {
                return new UZA.TextBox(this.convFiledName("txtSaishinsaKohiKekka"));
            };

            Controls.prototype.txtSaishinsaKohiToshoTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaKohiToshoTanisu"));
            };

            Controls.prototype.txtSaishinsaKohiGenshinTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaKohiGenshinTanisu"));
            };

            Controls.prototype.txtSaishinsaKohiMoshitateTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaKohiMoshitateTanisu"));
            };

            Controls.prototype.txtSaishinsaKohiKetteiTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaKohiKetteiTanisu"));
            };

            Controls.prototype.txtSaishinsaKohiChoseiTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaKohiChoseiTanisu"));
            };

            Controls.prototype.txtSaishinsaKohiFutangaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaKohiFutangaku"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        SogoShokaiSaishinsaMoushitateInfo.Controls = Controls;
    })(DBZ.SogoShokaiSaishinsaMoushitateInfo || (DBZ.SogoShokaiSaishinsaMoushitateInfo = {}));
    var SogoShokaiSaishinsaMoushitateInfo = DBZ.SogoShokaiSaishinsaMoushitateInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiSaishinsaMoushitateInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiSaishinsaMoushitateInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SogoShokaiSaishinsaMoushitateInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiSaishinsaMoushitateInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiSaishinsaMoushitateInfo || (DBZ.SogoShokaiSaishinsaMoushitateInfo = {}));
    var SogoShokaiSaishinsaMoushitateInfo = DBZ.SogoShokaiSaishinsaMoushitateInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiSaishinsaMoushitateInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiSaishinsaMoushitateInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiSaishinsaMoushitateInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiSaishinsaMoushitateInfo || (DBZ.SogoShokaiSaishinsaMoushitateInfo = {}));
    var SogoShokaiSaishinsaMoushitateInfo = DBZ.SogoShokaiSaishinsaMoushitateInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiGenmenGengakuInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        SogoShokaiGenmenGengakuInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SogoShokaiGenmenGengakuInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SogoShokaiGenmenGengakuInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SogoShokaiGenmenGengakuInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SogoShokaiGenmenGengakuInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtGenmenShinseiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtGenmenShinseiYMD"));
            };

            Controls.prototype.txtGenmenKyuSochiUmu = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenKyuSochiUmu"));
            };

            Controls.prototype.SogoShokaiGenmenGengakuTecho = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiGenmenGengakuTecho"));
            };

            Controls.prototype.txtGenmenTechoUmu = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenTechoUmu"));
            };

            Controls.prototype.txtGenmenTechoTokyu = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenTechoTokyu"));
            };

            Controls.prototype.txtGenmenTechoNo = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenTechoNo"));
            };

            Controls.prototype.txtGenmenTechoKofuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtGenmenTechoKofuYMD"));
            };

            Controls.prototype.txtGenmenSeihoUmu = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenSeihoUmu"));
            };

            Controls.prototype.txtGenmenSeihoTokureiUmu = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenSeihoTokureiUmu"));
            };

            Controls.prototype.txtGenmenRofukuUmu = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenRofukuUmu"));
            };

            Controls.prototype.txtGenmenFutanDankai = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenFutanDankai"));
            };

            Controls.prototype.txtGenmenKyokaiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenKyokaiKubun"));
            };

            Controls.prototype.txtGenmenGekihenDanwaKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenGekihenDanwaKubun"));
            };

            Controls.prototype.SogoShokaiGenmenGengakuFutan = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiGenmenGengakuFutan"));
            };

            Controls.prototype.txtGenmenFutanKetteiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenFutanKetteiKubun"));
            };

            Controls.prototype.txtGenmenFutanKetteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtGenmenFutanKetteiYMD"));
            };

            Controls.prototype.txtGenmenFutanTekiyoKaishiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtGenmenFutanTekiyoKaishiYMD"));
            };

            Controls.prototype.txtGenmenFutanYukoKigen = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtGenmenFutanYukoKigen"));
            };

            Controls.prototype.txtGenmenFutanKyufuritsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmenFutanKyufuritsu"));
            };

            Controls.prototype.txtGenmenFutanFutanshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtGenmenFutanFutanshaNo"));
            };

            Controls.prototype.txtGenmenFutanJukyushaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtGenmenFutanJukyushaNo"));
            };

            Controls.prototype.txtGenmenFutanKyoshitsuShubetsu = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenFutanKyoshitsuShubetsu"));
            };

            Controls.prototype.txtGenmenFutanShokuji = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmenFutanShokuji"));
            };

            Controls.prototype.txtGenmenFutanUnit = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmenFutanUnit"));
            };

            Controls.prototype.txtGenmenFutanUnitJun = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmenFutanUnitJun"));
            };

            Controls.prototype.txtGenmenFutanTokuyo = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmenFutanTokuyo"));
            };

            Controls.prototype.txtGenmenFutanRoken = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmenFutanRoken"));
            };

            Controls.prototype.txtGenmenFutanTasho = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmenFutanTasho"));
            };

            Controls.prototype.txtGenmenFutanSeigen = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenFutanSeigen"));
            };

            Controls.prototype.txtGenmenFutanGengakuKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenFutanGengakuKubun"));
            };

            Controls.prototype.txtGenmenFutanFutangaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmenFutanFutangaku"));
            };

            Controls.prototype.txtGenmenFutanHyojunKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenFutanHyojunKubun"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        SogoShokaiGenmenGengakuInfo.Controls = Controls;
    })(DBZ.SogoShokaiGenmenGengakuInfo || (DBZ.SogoShokaiGenmenGengakuInfo = {}));
    var SogoShokaiGenmenGengakuInfo = DBZ.SogoShokaiGenmenGengakuInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiGenmenGengakuInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiGenmenGengakuInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SogoShokaiGenmenGengakuInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiGenmenGengakuInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiGenmenGengakuInfo || (DBZ.SogoShokaiGenmenGengakuInfo = {}));
    var SogoShokaiGenmenGengakuInfo = DBZ.SogoShokaiGenmenGengakuInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiGenmenGengakuInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiGenmenGengakuInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiGenmenGengakuInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiGenmenGengakuInfo || (DBZ.SogoShokaiGenmenGengakuInfo = {}));
    var SogoShokaiGenmenGengakuInfo = DBZ.SogoShokaiGenmenGengakuInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiIryoHokenKanyuInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        SogoShokaiIryoHokenKanyuInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SogoShokaiIryoHokenKanyuInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SogoShokaiIryoHokenKanyuInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SogoShokaiIryoHokenKanyuInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SogoShokaiIryoHokenKanyuInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgSogoShokaiHokenKanyuList = function () {
                return new UZA.DataGrid(this.convFiledName("dgSogoShokaiHokenKanyuList"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        SogoShokaiIryoHokenKanyuInfo.Controls = Controls;
    })(DBZ.SogoShokaiIryoHokenKanyuInfo || (DBZ.SogoShokaiIryoHokenKanyuInfo = {}));
    var SogoShokaiIryoHokenKanyuInfo = DBZ.SogoShokaiIryoHokenKanyuInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiIryoHokenKanyuInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiIryoHokenKanyuInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SogoShokaiIryoHokenKanyuInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiIryoHokenKanyuInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiIryoHokenKanyuInfo || (DBZ.SogoShokaiIryoHokenKanyuInfo = {}));
    var SogoShokaiIryoHokenKanyuInfo = DBZ.SogoShokaiIryoHokenKanyuInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiIryoHokenKanyuInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiIryoHokenKanyuInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiIryoHokenKanyuInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiIryoHokenKanyuInfo || (DBZ.SogoShokaiIryoHokenKanyuInfo = {}));
    var SogoShokaiIryoHokenKanyuInfo = DBZ.SogoShokaiIryoHokenKanyuInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiJutakuKaishuhiInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnModify = function () {
                return "onClick_btnModify";
            };

            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        SogoShokaiJutakuKaishuhiInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SogoShokaiJutakuKaishuhiInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SogoShokaiJutakuKaishuhiInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SogoShokaiJutakuKaishuhiInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SogoShokaiJutakuKaishuhiInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtJutakuOwner = function () {
                return new UZA.TextBox(this.convFiledName("txtJutakuOwner"));
            };

            Controls.prototype.txtRelationWithHihokensha = function () {
                return new UZA.TextBox(this.convFiledName("txtRelationWithHihokensha"));
            };

            Controls.prototype.dgJutakuKaishuDetail = function () {
                return new UZA.DataGrid(this.convFiledName("dgJutakuKaishuDetail"));
            };

            Controls.prototype.JutakuKaishuDetail = function () {
                return new UZA.Panel(this.convFiledName("JutakuKaishuDetail"));
            };

            Controls.prototype.txtKaishuContents = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKaishuContents"));
            };

            Controls.prototype.txtKaishuJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtKaishuJigyoshaName"));
            };

            Controls.prototype.txtKaishuTaishoAddress1 = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKaishuTaishoAddress1"));
            };

            Controls.prototype.txtChakkoDueDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtChakkoDueDate"));
            };

            Controls.prototype.txtKanseiDueDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKanseiDueDate"));
            };

            Controls.prototype.txtEstimatedAmount = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtEstimatedAmount"));
            };

            Controls.prototype.tblSeikyuSummary = function () {
                return new UZA.TablePanel(this.convFiledName("tblSeikyuSummary"));
            };

            Controls.prototype.cel11 = function () {
                return new UZA.TableCell(this.convFiledName("cel11"));
            };

            Controls.prototype.lblSummary = function () {
                return new UZA.Label(this.convFiledName("lblSummary"));
            };

            Controls.prototype.cel12 = function () {
                return new UZA.TableCell(this.convFiledName("cel12"));
            };

            Controls.prototype.lblHiyoTotal = function () {
                return new UZA.Label(this.convFiledName("lblHiyoTotal"));
            };

            Controls.prototype.cel13 = function () {
                return new UZA.TableCell(this.convFiledName("cel13"));
            };

            Controls.prototype.lblHokenTaishoHiyo = function () {
                return new UZA.Label(this.convFiledName("lblHokenTaishoHiyo"));
            };

            Controls.prototype.cel14 = function () {
                return new UZA.TableCell(this.convFiledName("cel14"));
            };

            Controls.prototype.lblHokenKyufuAmount = function () {
                return new UZA.Label(this.convFiledName("lblHokenKyufuAmount"));
            };

            Controls.prototype.cel15 = function () {
                return new UZA.TableCell(this.convFiledName("cel15"));
            };

            Controls.prototype.lblRiyoshaFutanAmount = function () {
                return new UZA.Label(this.convFiledName("lblRiyoshaFutanAmount"));
            };

            Controls.prototype.cel21 = function () {
                return new UZA.TableCell(this.convFiledName("cel21"));
            };

            Controls.prototype.lblSummaryMae = function () {
                return new UZA.Label(this.convFiledName("lblSummaryMae"));
            };

            Controls.prototype.cel22 = function () {
                return new UZA.TableCell(this.convFiledName("cel22"));
            };

            Controls.prototype.txtPayTotalMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtPayTotalMae"));
            };

            Controls.prototype.cel23 = function () {
                return new UZA.TableCell(this.convFiledName("cel23"));
            };

            Controls.prototype.txtHokenSeikyuAmountMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenSeikyuAmountMae"));
            };

            Controls.prototype.cel24 = function () {
                return new UZA.TableCell(this.convFiledName("cel24"));
            };

            Controls.prototype.txtRiyoshaFutanAmountMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutanAmountMae"));
            };

            Controls.prototype.cel25 = function () {
                return new UZA.TableCell(this.convFiledName("cel25"));
            };

            Controls.prototype.txtLimitOverAmountMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtLimitOverAmountMae"));
            };

            Controls.prototype.cel31 = function () {
                return new UZA.TableCell(this.convFiledName("cel31"));
            };

            Controls.prototype.lblSummaryNow = function () {
                return new UZA.Label(this.convFiledName("lblSummaryNow"));
            };

            Controls.prototype.cel32 = function () {
                return new UZA.TableCell(this.convFiledName("cel32"));
            };

            Controls.prototype.txtPayTotalNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtPayTotalNow"));
            };

            Controls.prototype.cel33 = function () {
                return new UZA.TableCell(this.convFiledName("cel33"));
            };

            Controls.prototype.txtHokenSeikyuAmountNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenSeikyuAmountNow"));
            };

            Controls.prototype.cel34 = function () {
                return new UZA.TableCell(this.convFiledName("cel34"));
            };

            Controls.prototype.txtRiyoshaFutanAmountNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutanAmountNow"));
            };

            Controls.prototype.cel35 = function () {
                return new UZA.TableCell(this.convFiledName("cel35"));
            };

            Controls.prototype.txtLimitOverAmountNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtLimitOverAmountNow"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        SogoShokaiJutakuKaishuhiInfo.Controls = Controls;
    })(DBZ.SogoShokaiJutakuKaishuhiInfo || (DBZ.SogoShokaiJutakuKaishuhiInfo = {}));
    var SogoShokaiJutakuKaishuhiInfo = DBZ.SogoShokaiJutakuKaishuhiInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiJutakuKaishuhiInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiJutakuKaishuhiInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SogoShokaiJutakuKaishuhiInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiJutakuKaishuhiInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiJutakuKaishuhiInfo || (DBZ.SogoShokaiJutakuKaishuhiInfo = {}));
    var SogoShokaiJutakuKaishuhiInfo = DBZ.SogoShokaiJutakuKaishuhiInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiJutakuKaishuhiInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiJutakuKaishuhiInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiJutakuKaishuhiInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiJutakuKaishuhiInfo || (DBZ.SogoShokaiJutakuKaishuhiInfo = {}));
    var SogoShokaiJutakuKaishuhiInfo = DBZ.SogoShokaiJutakuKaishuhiInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiKagoMoushitateInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        SogoShokaiKagoMoushitateInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SogoShokaiKagoMoushitateInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SogoShokaiKagoMoushitateInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SogoShokaiKagoMoushitateInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SogoShokaiKagoMoushitateInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtKagoTaishoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKagoTaishoYM"));
            };

            Controls.prototype.txtKagoMoshitateYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKagoMoshitateYMD"));
            };

            Controls.prototype.txtKagoTeikyoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKagoTeikyoYM"));
            };

            Controls.prototype.txtKagoDogetsuKago = function () {
                return new UZA.TextBox(this.convFiledName("txtKagoDogetsuKago"));
            };

            Controls.prototype.txtKagoJigyoshaCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKagoJigyoshaCode"));
            };

            Controls.prototype.txtKagoJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtKagoJigyoshaName"));
            };

            Controls.prototype.SogoShokaiKagoMoshitateJiyu = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiKagoMoshitateJiyu"));
            };

            Controls.prototype.txtKagoMoshitateYoshiki = function () {
                return new UZA.TextBox(this.convFiledName("txtKagoMoshitateYoshiki"));
            };

            Controls.prototype.txtKagoMoshitateRiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtKagoMoshitateRiyu"));
            };

            Controls.prototype.SogoShokaiKagoMoshitateKekka = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiKagoMoshitateKekka"));
            };

            Controls.prototype.SogoShokaiKagoMoshitateHokensha = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiKagoMoshitateKekka_SogoShokaiKagoMoshitateHokensha"));
            };

            Controls.prototype.txtKagoHokenshaTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKagoHokenshaTanisu"));
            };

            Controls.prototype.txtKagoHokenshaFutangaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKagoHokenshaFutangaku"));
            };

            Controls.prototype.SogoShokaiKagoMoshitateKohi = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiKagoMoshitateKekka_SogoShokaiKagoMoshitateKohi"));
            };

            Controls.prototype.txtKagoKohiJukyushaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKagoKohiJukyushaNo"));
            };

            Controls.prototype.txtKagoKohiJukyushaName = function () {
                return new UZA.TextBox(this.convFiledName("txtKagoKohiJukyushaName"));
            };

            Controls.prototype.txtKagoKohiHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKagoKohiHokenshaNo"));
            };

            Controls.prototype.txtKagoKohiTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKagoKohiTanisu"));
            };

            Controls.prototype.txtKagoKohiFutangaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKagoKohiFutangaku"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        SogoShokaiKagoMoushitateInfo.Controls = Controls;
    })(DBZ.SogoShokaiKagoMoushitateInfo || (DBZ.SogoShokaiKagoMoushitateInfo = {}));
    var SogoShokaiKagoMoushitateInfo = DBZ.SogoShokaiKagoMoushitateInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiKagoMoushitateInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiKagoMoushitateInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SogoShokaiKagoMoushitateInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiKagoMoushitateInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiKagoMoushitateInfo || (DBZ.SogoShokaiKagoMoushitateInfo = {}));
    var SogoShokaiKagoMoushitateInfo = DBZ.SogoShokaiKagoMoushitateInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiKagoMoushitateInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiKagoMoushitateInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiKagoMoushitateInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiKagoMoushitateInfo || (DBZ.SogoShokaiKagoMoushitateInfo = {}));
    var SogoShokaiKagoMoushitateInfo = DBZ.SogoShokaiKagoMoushitateInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiKogakuKaigoServicehiInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        SogoShokaiKogakuKaigoServicehiInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SogoShokaiKogakuKaigoServicehiInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SogoShokaiKogakuKaigoServicehiInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SogoShokaiKogakuKaigoServicehiInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SogoShokaiKogakuKaigoServicehiInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtKogakuTeikyoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuTeikyoYM"));
            };

            Controls.prototype.txtKogakuShinseiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuShinseiYMD"));
            };

            Controls.prototype.txtKogakuShiharaigaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKogakuShiharaigaku"));
            };

            Controls.prototype.txtKogakuShiharaiHoho = function () {
                return new UZA.TextBox(this.convFiledName("txtKogakuShiharaiHoho"));
            };

            Controls.prototype.txtKogakuKinyuKikanCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKogakuKinyuKikanCode"));
            };

            Controls.prototype.txtKogakuKinyuKikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtKogakuKinyuKikanName"));
            };

            Controls.prototype.txtKogakuKozaShubetsu = function () {
                return new UZA.TextBox(this.convFiledName("txtKogakuKozaShubetsu"));
            };

            Controls.prototype.txtKogakuKozaMeiginin = function () {
                return new UZA.TextBox(this.convFiledName("txtKogakuKozaMeiginin"));
            };

            Controls.prototype.txtKogakuShitenCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKogakuShitenCode"));
            };

            Controls.prototype.txtKogakuShitenName = function () {
                return new UZA.TextBox(this.convFiledName("txtKogakuShitenName"));
            };

            Controls.prototype.txtKogakuKozaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKogakuKozaNo"));
            };

            Controls.prototype.txtKogakuKozaMeigininKana = function () {
                return new UZA.TextBoxKana(this.convFiledName("txtKogakuKozaMeigininKana"));
            };

            Controls.prototype.txtKogakuKetteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuKetteiYMD"));
            };

            Controls.prototype.txtKogakuShikyuKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtKogakuShikyuKubun"));
            };

            Controls.prototype.txtKogakuShikyugaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKogakuShikyugaku"));
            };

            Controls.prototype.txtKogakuFushikyuRiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtKogakuFushikyuRiyu"));
            };

            Controls.prototype.txtKogakuSetaiShuyakuNo = function () {
                return new UZA.TextBox(this.convFiledName("txtKogakuSetaiShuyakuNo"));
            };

            Controls.prototype.SogoShokaiKogakuKokuhorenKettei = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiKogakuKokuhorenKettei"));
            };

            Controls.prototype.txtKogakuKokuhorenTsuchishoNo = function () {
                return new UZA.TextBox(this.convFiledName("txtKogakuKokuhorenTsuchishoNo"));
            };

            Controls.prototype.txtKogakuKokuhorenShikyuKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtKogakuKokuhorenShikyuKubun"));
            };

            Controls.prototype.txtKogakuKokuhorenKetteiYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuKokuhorenKetteiYM"));
            };

            Controls.prototype.txtKogakuKokuhorenFutangaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKogakuKokuhorenFutangaku"));
            };

            Controls.prototype.txtKogakuKokuhorenShikyugaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKogakuKokuhorenShikyugaku"));
            };

            Controls.prototype.txtKogakuTsuchishoSakuseiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuTsuchishoSakuseiYMD"));
            };

            Controls.prototype.SogoShokaiKogakuFurikomi = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiKogakuFurikomi"));
            };

            Controls.prototype.txtKogakuFurikomiMeisaiSakuseiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuFurikomiMeisaiSakuseiYMD"));
            };

            Controls.prototype.txtKogakuFurikomiShiharaiYoteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuFurikomiShiharaiYoteiYMD"));
            };

            Controls.prototype.SogoShokaiKogakuKokuhorenSofu = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiKogakuKokuhorenSofu"));
            };

            Controls.prototype.txtKogakuKokuhorenSofuYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuKokuhorenSofuYM"));
            };

            Controls.prototype.txtKogakuKokuhorenUketoriYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKogakuKokuhorenUketoriYM"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        SogoShokaiKogakuKaigoServicehiInfo.Controls = Controls;
    })(DBZ.SogoShokaiKogakuKaigoServicehiInfo || (DBZ.SogoShokaiKogakuKaigoServicehiInfo = {}));
    var SogoShokaiKogakuKaigoServicehiInfo = DBZ.SogoShokaiKogakuKaigoServicehiInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiKogakuKaigoServicehiInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiKogakuKaigoServicehiInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SogoShokaiKogakuKaigoServicehiInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiKogakuKaigoServicehiInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiKogakuKaigoServicehiInfo || (DBZ.SogoShokaiKogakuKaigoServicehiInfo = {}));
    var SogoShokaiKogakuKaigoServicehiInfo = DBZ.SogoShokaiKogakuKaigoServicehiInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiKogakuKaigoServicehiInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiKogakuKaigoServicehiInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiKogakuKaigoServicehiInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiKogakuKaigoServicehiInfo || (DBZ.SogoShokaiKogakuKaigoServicehiInfo = {}));
    var SogoShokaiKogakuKaigoServicehiInfo = DBZ.SogoShokaiKogakuKaigoServicehiInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiKyotakuServiceKeikakuInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        SogoShokaiKyotakuServiceKeikakuInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SogoShokaiKyotakuServiceKeikakuInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SogoShokaiKyotakuServiceKeikakuInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SogoShokaiKyotakuServiceKeikakuInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SogoShokaiKyotakuServiceKeikakuInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtKeikakuTodokedeYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKeikakuTodokedeYMD"));
            };

            Controls.prototype.txtKeikakuHenkoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKeikakuHenkoYMD"));
            };

            Controls.prototype.txtKeikakuJigyoshaShurui = function () {
                return new UZA.TextBox(this.convFiledName("txtKeikakuJigyoshaShurui"));
            };

            Controls.prototype.txtKeikakuJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKeikakuJigyoshaNo"));
            };

            Controls.prototype.txtKeikakuJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtKeikakuJigyoshaName"));
            };

            Controls.prototype.txtKeikakuServiceShurui = function () {
                return new UZA.TextBox(this.convFiledName("txtKeikakuServiceShurui"));
            };

            Controls.prototype.txtKeikakuSakuseiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtKeikakuSakuseiKubun"));
            };

            Controls.prototype.txtKeikakuYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKeikakuYM"));
            };

            Controls.prototype.txtKeikakuKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKeikakuKikan"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        SogoShokaiKyotakuServiceKeikakuInfo.Controls = Controls;
    })(DBZ.SogoShokaiKyotakuServiceKeikakuInfo || (DBZ.SogoShokaiKyotakuServiceKeikakuInfo = {}));
    var SogoShokaiKyotakuServiceKeikakuInfo = DBZ.SogoShokaiKyotakuServiceKeikakuInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiKyotakuServiceKeikakuInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiKyotakuServiceKeikakuInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SogoShokaiKyotakuServiceKeikakuInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiKyotakuServiceKeikakuInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiKyotakuServiceKeikakuInfo || (DBZ.SogoShokaiKyotakuServiceKeikakuInfo = {}));
    var SogoShokaiKyotakuServiceKeikakuInfo = DBZ.SogoShokaiKyotakuServiceKeikakuInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiKyotakuServiceKeikakuInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiKyotakuServiceKeikakuInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiKyotakuServiceKeikakuInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiKyotakuServiceKeikakuInfo || (DBZ.SogoShokaiKyotakuServiceKeikakuInfo = {}));
    var SogoShokaiKyotakuServiceKeikakuInfo = DBZ.SogoShokaiKyotakuServiceKeikakuInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiKyufuSeigenInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        SogoShokaiKyufuSeigenInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SogoShokaiKyufuSeigenInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SogoShokaiKyufuSeigenInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SogoShokaiKyufuSeigenInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SogoShokaiKyufuSeigenInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtSeigenTorokuJokyo = function () {
                return new UZA.TextBox(this.convFiledName("txtSeigenTorokuJokyo"));
            };

            Controls.prototype.txtSeigenShuryoJokyo = function () {
                return new UZA.TextBox(this.convFiledName("txtSeigenShuryoJokyo"));
            };

            Controls.prototype.SogoShokaiKyufuSeigenHenko = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiKyufuSeigenHenko"));
            };

            Controls.prototype.txtSeigenHenkoYokokuTorokuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSeigenHenkoYokokuTorokuYMD"));
            };

            Controls.prototype.txtSeigenHenkoKetteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSeigenHenkoKetteiYMD"));
            };

            Controls.prototype.txtSeigenHenkoSashitomeSyuryoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSeigenHenkoSashitomeSyuryoYMD"));
            };

            Controls.prototype.txtSeigenHenkoTekiyoShuryoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSeigenHenkoTekiyoShuryoYMD"));
            };

            Controls.prototype.txtSeigenTainoKojoKetteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSeigenTainoKojoKetteiYMD"));
            };

            Controls.prototype.txtSeigenChoshuShometsuKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSeigenChoshuShometsuKikan"));
            };

            Controls.prototype.txtSeigenNofuzumiKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSeigenNofuzumiKikan"));
            };

            Controls.prototype.SogoShokaiKyufuSeigenGengaku = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiKyufuSeigenGengaku"));
            };

            Controls.prototype.txtSeigenGengakuKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSeigenGengakuKikan"));
            };

            Controls.prototype.txtSeigenGengakuKetteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSeigenGengakuKetteiYMD"));
            };

            Controls.prototype.txtSeigenGengakuTekiyoKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSeigenGengakuTekiyoKikan"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        SogoShokaiKyufuSeigenInfo.Controls = Controls;
    })(DBZ.SogoShokaiKyufuSeigenInfo || (DBZ.SogoShokaiKyufuSeigenInfo = {}));
    var SogoShokaiKyufuSeigenInfo = DBZ.SogoShokaiKyufuSeigenInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiKyufuSeigenInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiKyufuSeigenInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SogoShokaiKyufuSeigenInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiKyufuSeigenInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiKyufuSeigenInfo || (DBZ.SogoShokaiKyufuSeigenInfo = {}));
    var SogoShokaiKyufuSeigenInfo = DBZ.SogoShokaiKyufuSeigenInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiKyufuSeigenInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiKyufuSeigenInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiKyufuSeigenInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiKyufuSeigenInfo || (DBZ.SogoShokaiKyufuSeigenInfo = {}));
    var SogoShokaiKyufuSeigenInfo = DBZ.SogoShokaiKyufuSeigenInfo;
})(DBZ || (DBZ = {}));
