var DBZ;
(function (DBZ) {
    (function (TekiyoJogaiRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TekiyoJogaiRireki.Controls(fieldName);
            }
            ModeController.prototype.ModeA = function () {
                return new Modes.ModeA(this.controls);
            };

            ModeController.prototype.ModeB = function () {
                return new Modes.ModeB(this.controls);
            };

            ModeController.prototype.ModeC = function () {
                return new Modes.ModeC(this.controls);
            };

            ModeController.prototype.ModeD = function () {
                return new Modes.ModeD(this.controls);
            };

            ModeController.prototype.ModeShokai = function () {
                return new Modes.ModeShokai(this.controls);
            };

            ModeController.prototype.除外施設入所適用 = function () {
                return new Modes.除外施設入所適用(this.controls);
            };

            ModeController.prototype.除外施設退所解除 = function () {
                return new Modes.除外施設退所解除(this.controls);
            };

            ModeController.prototype.除外施設変更変更 = function () {
                return new Modes.除外施設変更変更(this.controls);
            };

            ModeController.prototype.除外異動訂正 = function () {
                return new Modes.除外異動訂正(this.controls);
            };
            ModeController.prototype.履歴訂正 = function () {
                return new Modes.履歴訂正(this.controls);
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new TekiyoJogaiRireki.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "ModeA",
                    "ModeB",
                    "ModeC",
                    "ModeD",
                    "ModeShokai",
                    "除外施設入所適用",
                    "除外施設退所解除",
                    "除外施設変更変更",
                    "除外異動訂正",
                    "履歴訂正"
                ];
            };
            return ModeController;
        })();
        TekiyoJogaiRireki.ModeController = ModeController;

        (function (Modes) {
            var ModeA = (function () {
                function ModeA(controls) {
                    this.controls = controls;
                }
                ModeA.prototype.Shinki = function () {
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = false;

                    this.controls.panelTekiyoInput().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                    this.controls.btnKakutei().displayNone = false;
                    this.controls.btnInputClear().displayNone = false;
                };
                return ModeA;
            })();
            Modes.ModeA = ModeA;

            var ModeB = (function () {
                function ModeB(controls) {
                    this.controls = controls;
                }
                ModeB.prototype.Kaijo = function () {
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;

                    this.controls.panelTekiyoInput().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = false;

                    this.controls.btnKakutei().displayNone = false;
                    this.controls.btnKakutei().disabled = false;
                    this.controls.btnInputClear().displayNone = false;
                    this.controls.btnInputClear().disabled = false;
                };
                return ModeB;
            })();
            Modes.ModeB = ModeB;

            var ModeC = (function () {
                function ModeC(controls) {
                    this.controls = controls;
                }
                ModeC.prototype.HenKo = function () {
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;

                    this.controls.panelTekiyoInput().displayNone = false;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;

                    this.controls.btnKakutei().displayNone = false;
                    this.controls.btnKakutei().disabled = true;
                    this.controls.btnInputClear().displayNone = false;
                    this.controls.btnInputClear().disabled = true;
                };
                return ModeC;
            })();
            Modes.ModeC = ModeC;

            var ModeD = (function () {
                function ModeD(controls) {
                    this.controls = controls;
                }
                ModeD.prototype.Hyoji = function () {
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                    this.controls.panelTekiyoInput().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;

                    this.controls.btnKakutei().displayNone = true;
                    this.controls.btnInputClear().displayNone = true;
                };
                return ModeD;
            })();
            Modes.ModeD = ModeD;

            var 除外施設入所適用 = (function () {
                function 除外施設入所適用(controls) {
                    this.controls = controls;
                }
                除外施設入所適用.prototype.適用 = function () {
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = false;
                    this.controls.panelTekiyoInput().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                    this.controls.btnKakutei().displayNone = false;
                    this.controls.btnKakutei().disabled = false;
                    this.controls.btnInputClear().displayNone = false;
                    this.controls.btnInputClear().disabled = false;
                    this.controls.btnAdd().displayNone = false;

                    this.controls.datagridTekiyoJogai().gridSetting.isShowSelectButtonColumn = false;

                    this.controls.ccdShisetsuJoho().入力補助().除外施設を表示する();
                };
                return 除外施設入所適用;
            })();
            Modes.除外施設入所適用 = 除外施設入所適用;

            var 除外施設退所解除 = (function () {
                function 除外施設退所解除(controls) {
                    this.controls = controls;
                }
                除外施設退所解除.prototype.解除 = function () {
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                    this.controls.panelTekiyoInput().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = false;
                    this.controls.btnKakutei().displayNone = false;
                    this.controls.btnKakutei().disabled = false;
                    this.controls.btnInputClear().displayNone = false;
                    this.controls.btnInputClear().disabled = false;
                    this.controls.btnAdd().displayNone = true;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.ccdShisetsuJoho().入力補助().除外施設を表示する();
                };
                return 除外施設退所解除;
            })();
            Modes.除外施設退所解除 = 除外施設退所解除;

            var 除外施設変更変更 = (function () {
                function 除外施設変更変更(controls) {
                    this.controls = controls;
                }
                除外施設変更変更.prototype.変更 = function () {
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                    this.controls.panelTekiyoInput().displayNone = false;
                    this.controls.panelTekiyoInput().disabled = true;
                    this.controls.panelTekiyoInput().title = '';
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                    this.controls.btnKakutei().displayNone = false;
                    this.controls.btnKakutei().disabled = false;
                    this.controls.btnInputClear().displayNone = false;
                    this.controls.btnInputClear().disabled = false;
                    this.controls.panelTekiyoRireki().displayNone = true;
                    this.controls.txtNyusyoDate().displayNone = true;
                    this.controls.txtTaisyoDate().displayNone = true;
                };
                return 除外施設変更変更;
            })();
            Modes.除外施設変更変更 = 除外施設変更変更;

            var 除外異動訂正 = (function () {
                function 除外異動訂正(controls) {
                    this.controls = controls;
                }
                除外異動訂正.prototype.訂正 = function () {
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                    this.controls.panelTekiyoInput().displayNone = false;
                    this.controls.txtNyusyoDate().displayNone = true;
                    this.controls.txtTaisyoDate().displayNone = true;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                    this.controls.btnKakutei().displayNone = false;
                    this.controls.btnKakutei().disabled = false;
                    this.controls.btnAdd().displayNone = false;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowSelectButtonColumn = false;
                };
                return 除外異動訂正;
            })();
            Modes.除外異動訂正 = 除外異動訂正;
            var 履歴訂正 = (function () {
                function 履歴訂正(controls) {
                    this.controls = controls;
                }
                履歴訂正.prototype.teisei = function () {
                    this.controls.btnAdd().text = '過去の履歴を追加する';
                    this.controls.btnAdd().width = "200";
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                    this.controls.panelTekiyoInput().displayNone = false;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                    this.controls.btnKakutei().displayNone = true;
                    this.controls.btnInputClear().displayNone = true;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowModifyButtonColumn = true;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowDeleteButtonColumn = true;
                    this.controls.panelTekiyoInput().title = '明細';
                    this.controls.txtNyusyoDate().displayNone = true;
                    this.controls.txtTaisyoDate().displayNone = true;
                };
                return 履歴訂正;
            })();
            Modes.履歴訂正 = 履歴訂正;

            var ModeShokai = (function () {
                function ModeShokai(controls) {
                    this.controls = controls;
                }
                ModeShokai.prototype.shokai = function () {
                    this.controls.btnAdd().displayNone = true;
                    this.controls.panelTekiyoJokaiTekiInput().displayNone = true;
                    this.controls.panelTekiyoInput().displayNone = false;
                    this.controls.panelTekiyoJokaiKaiJyoInput().displayNone = true;
                    this.controls.btnKakutei().displayNone = true;
                    this.controls.btnInputClear().displayNone = true;

                    this.controls.datagridTekiyoJogai().gridSetting.isShowSelectButtonColumn = true;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.datagridTekiyoJogai().gridSetting.isShowDeleteButtonColumn = false;
                    this.controls.panelTekiyoInput().title = '明細';
                    this.controls.panelTekiyoInput().disabled = true;
                    this.controls.txtNyusyoDate().displayNone = true;
                    this.controls.txtTaisyoDate().displayNone = true;
                };
                return ModeShokai;
            })();
            Modes.ModeShokai = ModeShokai;
        })(TekiyoJogaiRireki.Modes || (TekiyoJogaiRireki.Modes = {}));
        var Modes = TekiyoJogaiRireki.Modes;
    })(DBZ.TekiyoJogaiRireki || (DBZ.TekiyoJogaiRireki = {}));
    var TekiyoJogaiRireki = DBZ.TekiyoJogaiRireki;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (TekiyoJogaiRireki) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TekiyoJogaiRireki.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TekiyoJogaiRireki.PublicProperties = PublicProperties;
    })(DBZ.TekiyoJogaiRireki || (DBZ.TekiyoJogaiRireki = {}));
    var TekiyoJogaiRireki = DBZ.TekiyoJogaiRireki;
})(DBZ || (DBZ = {}));
