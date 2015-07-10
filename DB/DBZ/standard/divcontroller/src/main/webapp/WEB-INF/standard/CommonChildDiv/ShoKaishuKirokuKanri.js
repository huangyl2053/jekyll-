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
                return new DBZ.ShoKaishuKirokuKanri.PublicProperties(this.fieldName);
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
                return this.controls.ccdShoKaishuJokyoShosai().PublicProperties().getShoKaishuJokyoShosai_panelDisplay();
            };

            PublicProperties.prototype.setShoKaishuJokyoShosai_panelDisplay = function (value) {
                this.controls.ccdShoKaishuJokyoShosai().PublicProperties().setShoKaishuJokyoShosai_panelDisplay(value);
            };

            PublicProperties.prototype.getShoKaishuJokyoShosai_canOpenAndClose = function () {
                return this.controls.ccdShoKaishuJokyoShosai().PublicProperties().getShoKaishuJokyoShosai_canOpenAndClose();
            };

            PublicProperties.prototype.setShoKaishuJokyoShosai_canOpenAndClose = function (value) {
                this.controls.ccdShoKaishuJokyoShosai().PublicProperties().setShoKaishuJokyoShosai_canOpenAndClose(value);
            };
            return PublicProperties;
        })();
        ShoKaishuKirokuKanri.PublicProperties = PublicProperties;
    })(DBZ.ShoKaishuKirokuKanri || (DBZ.ShoKaishuKirokuKanri = {}));
    var ShoKaishuKirokuKanri = DBZ.ShoKaishuKirokuKanri;
})(DBZ || (DBZ = {}));
