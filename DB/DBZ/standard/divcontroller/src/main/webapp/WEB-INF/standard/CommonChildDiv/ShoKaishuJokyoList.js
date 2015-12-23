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
                    "一覧パネル高さ",
                    "明細表示モード"
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
            ModeController.prototype.明細表示モード = function () {
                return new Modes.明細表示モード(this.controls);
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
                    this.controls.ShoKaishuJokyoShosai().readOnly = true;
                    this.controls.ShoKaishuJokyoShosai().displayNone = false;
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
            var 明細表示モード = (function () {
                function 明細表示モード(controls) {
                    this.controls = controls;
                }
                明細表示モード.prototype.照会 = function () {
                    this.controls.ShoKaishuJokyoShosai().readOnly = true;
                    this.controls.ShoKaishuJokyoShosai().displayNone = false;
                };

                明細表示モード.prototype.入力 = function () {
                    this.controls.ShoKaishuJokyoShosai().readOnly = false;
                    this.controls.ShoKaishuJokyoShosai().displayNone = false;
                };

                明細表示モード.prototype.非表示 = function () {
                    this.controls.ShoKaishuJokyoShosai().readOnly = true;
                    this.controls.ShoKaishuJokyoShosai().displayNone = true;
                };
                return 明細表示モード;
            })();
            Modes.明細表示モード = 明細表示モード;
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
