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
