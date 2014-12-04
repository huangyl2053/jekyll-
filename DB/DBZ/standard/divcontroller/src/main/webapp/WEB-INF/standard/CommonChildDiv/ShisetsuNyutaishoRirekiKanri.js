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
