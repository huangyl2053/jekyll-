var DBZ;
(function (DBZ) {
    (function (ShisetsuJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShisetsuJoho.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "施設選択表示",
                    "事業者選択",
                    "他特例施設選択",
                    "除外施設選択"
                ];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.施設選択表示 = function () {
                return new Modes.施設選択表示(this.controls);
            };

            ModeController.prototype.事業者選択 = function () {
                return new Modes.事業者選択(this.controls);
            };

            ModeController.prototype.他特例施設選択 = function () {
                return new Modes.他特例施設選択(this.controls);
            };

            ModeController.prototype.除外施設選択 = function () {
                return new Modes.除外施設選択(this.controls);
            };
            return ModeController;
        })();
        ShisetsuJoho.ModeController = ModeController;

        (function (Modes) {
            var 施設選択表示 = (function () {
                function 施設選択表示(controls) {
                    this.controls = controls;
                }
                施設選択表示.prototype.表示する = function () {
                    this.controls.radShisetsuShurui().displayNone = false;
                };

                施設選択表示.prototype.表示しない = function () {
                    this.controls.radShisetsuShurui().displayNone = true;
                };
                return 施設選択表示;
            })();
            Modes.施設選択表示 = 施設選択表示;

            var 事業者選択 = (function () {
                function 事業者選択(controls) {
                    this.controls = controls;
                }
                事業者選択.prototype.表示する = function () {
                    this.controls.btnJigyoshaInputGuide().displayNone = false;
                };

                事業者選択.prototype.表示しない = function () {
                    this.controls.btnJigyoshaInputGuide().displayNone = true;
                };
                return 事業者選択;
            })();
            Modes.事業者選択 = 事業者選択;

            var 他特例施設選択 = (function () {
                function 他特例施設選択(controls) {
                    this.controls = controls;
                }
                他特例施設選択.prototype.表示する = function () {
                    this.controls.btnOtherTokureiShisetsuInputGuide().displayNone = false;
                };

                他特例施設選択.prototype.表示しない = function () {
                    this.controls.btnOtherTokureiShisetsuInputGuide().displayNone = true;
                };
                return 他特例施設選択;
            })();
            Modes.他特例施設選択 = 他特例施設選択;

            var 除外施設選択 = (function () {
                function 除外施設選択(controls) {
                    this.controls = controls;
                }
                除外施設選択.prototype.表示する = function () {
                    this.controls.btnJogaiShisetsuInputGuide().displayNone = false;
                };

                除外施設選択.prototype.表示しない = function () {
                    this.controls.btnJogaiShisetsuInputGuide().displayNone = true;
                };
                return 除外施設選択;
            })();
            Modes.除外施設選択 = 除外施設選択;
        })(ShisetsuJoho.Modes || (ShisetsuJoho.Modes = {}));
        var Modes = ShisetsuJoho.Modes;
    })(DBZ.ShisetsuJoho || (DBZ.ShisetsuJoho = {}));
    var ShisetsuJoho = DBZ.ShisetsuJoho;
})(DBZ || (DBZ = {}));
