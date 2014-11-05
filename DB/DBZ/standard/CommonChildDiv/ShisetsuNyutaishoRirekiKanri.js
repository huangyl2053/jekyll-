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
                    "台帳種別の列を"
                ];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
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
                    gridSetting.colums = columns;
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
                    gridSetting.colums = columns;
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
                    gridSetting.colums = columns;
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
                    this.controls.dgShisetsuNyutaishoRireki().gridSetting = gridSetting;
                    this.controls.dgShisetsuNyutaishoRireki()._control.afterPropertiesSet();
                };
                return 台帳種別の列を;
            })();
            Modes.台帳種別の列を = 台帳種別の列を;
        })(ShisetsuNyutaishoRirekiKanri.Modes || (ShisetsuNyutaishoRirekiKanri.Modes = {}));
        var Modes = ShisetsuNyutaishoRirekiKanri.Modes;
    })(DBZ.ShisetsuNyutaishoRirekiKanri || (DBZ.ShisetsuNyutaishoRirekiKanri = {}));
    var ShisetsuNyutaishoRirekiKanri = DBZ.ShisetsuNyutaishoRirekiKanri;
})(DBZ || (DBZ = {}));
