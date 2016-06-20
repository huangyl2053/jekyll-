var DBC;
(function (DBC) {
    (function (KaigoKyufuKokuhorenJohoTorikomi) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoKyufuKokuhorenJohoTorikomi.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoKyufuKokuhorenJohoTorikomi.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "HyojiMode"
                ];
            };

            ModeController.prototype.HyojiMode = function () {
                return new Modes.HyojiMode(this.controls);
            };
            return ModeController;
        })();
        KaigoKyufuKokuhorenJohoTorikomi.ModeController = ModeController;

        (function (Modes) {
            var HyojiMode = (function () {
                function HyojiMode(controls) {
                    this.controls = controls;
                }
                HyojiMode.prototype.Mode1 = function () {
                    this.controls.ShoriTaishoJoho().displayNone = true;
                    this.controls.KakuninJikoMsg().displayNone = true;
                    this.controls.ShutsuRyokujun().displayNone = true;
                };

                HyojiMode.prototype.ModeShutsuryokujunJoken2 = function () {
                    this.controls.ShoriTaishoJoho().displayNone = true;
                    this.controls.KakuninJikoMsg().displayNone = true;
                    this.controls.ShutsuRyokujun().displayNone = false;
                };

                HyojiMode.prototype.ModeKakuninMsgJoken3 = function () {
                    this.controls.ShoriTaishoJoho().displayNone = false;
                    this.controls.KakuninJikoMsg().displayNone = false;
                    this.controls.ShutsuRyokujun().displayNone = false;
                };
                return HyojiMode;
            })();
            Modes.HyojiMode = HyojiMode;
        })(KaigoKyufuKokuhorenJohoTorikomi.Modes || (KaigoKyufuKokuhorenJohoTorikomi.Modes = {}));
        var Modes = KaigoKyufuKokuhorenJohoTorikomi.Modes;
    })(DBC.KaigoKyufuKokuhorenJohoTorikomi || (DBC.KaigoKyufuKokuhorenJohoTorikomi = {}));
    var KaigoKyufuKokuhorenJohoTorikomi = DBC.KaigoKyufuKokuhorenJohoTorikomi;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (KaigoKyufuKokuhorenJohoTorikomi) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoKyufuKokuhorenJohoTorikomi.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoKyufuKokuhorenJohoTorikomi.PublicProperties = PublicProperties;
    })(DBC.KaigoKyufuKokuhorenJohoTorikomi || (DBC.KaigoKyufuKokuhorenJohoTorikomi = {}));
    var KaigoKyufuKokuhorenJohoTorikomi = DBC.KaigoKyufuKokuhorenJohoTorikomi;
})(DBC || (DBC = {}));
