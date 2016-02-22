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
                    this.controls.radJigyosha().displayNone = false;
                    this.controls.radOther().displayNone = false;
                    this.controls.radJyogai().displayNone = false;
                };

                施設種類.prototype.施設種類を非表示する = function () {
                    this.controls.radJigyosha().displayNone = true;
                    this.controls.radOther().displayNone = true;
                    this.controls.radJyogai().displayNone = true;
                };

                施設種類.prototype.介護保険特例者表示 = function () {
                    this.controls.radJigyosha().displayNone = false;
                    this.controls.radOther().displayNone = false;
                    this.controls.radJyogai().displayNone = true;
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

                入力補助.prototype.除外施設を非表示する = function () {
                    this.controls.btnJigyoshaInputGuide().displayNone = false;
                    this.controls.btnOtherTokureiShisetsuInputGuide().displayNone = false;
                    this.controls.btnJogaiShisetsuInputGuide().displayNone = true;
                };

                入力補助.prototype.全て表示する = function () {
                    this.controls.btnJigyoshaInputGuide().displayNone = false;
                    this.controls.btnOtherTokureiShisetsuInputGuide().displayNone = false;
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
