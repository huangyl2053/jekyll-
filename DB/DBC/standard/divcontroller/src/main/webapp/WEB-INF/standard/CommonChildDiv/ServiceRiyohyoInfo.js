var DBC;
(function (DBC) {
    (function (ServiceRiyohyoInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceRiyohyoInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return ["GamenMode", "KaigoType"];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ServiceRiyohyoInfo.PublicProperties(this.fieldName);
            };

            ModeController.prototype.GamenMode = function () {
                return new Modes.GamenMode(this.controls);
            };

            ModeController.prototype.KaigoType = function () {
                return new Modes.KaigoType(this.controls);
            };
            return ModeController;
        })();
        ServiceRiyohyoInfo.ModeController = ModeController;

        (function (Modes) {
            var GamenMode = (function () {
                function GamenMode(controls) {
                    this.controls = controls;
                }
                GamenMode.prototype.TsuikaMode = function () {
                    this.controls.btnZengetsuCopy().displayNone = false;
                    this.controls.btnZengetsuCopy().disabled = false;

                    this.controls.btnBeppyoMeisaiNew().displayNone = false;
                    this.controls.btnBeppyoGokeiNew().displayNone = false;
                    this.controls.btnBeppyoMeisaiNew().disabled = false;
                    this.controls.btnBeppyoGokeiNew().disabled = false;

                    this.controls.ServiceRiyohyoBeppyoFooter().displayNone = false;
                    this.controls.btnUpdate().displayNone = false;
                    this.controls.btnUpdate().disabled = true;
                    this.controls.btnBackRiyoNengetsuIchiran().displayNone = false;
                    this.controls.ServiceRiyohyoBeppyoJigyoshaServiceInput().displayNone = true;
                    this.controls.ServiceRiyohyoBeppyoMeisai().displayNone = true;
                    this.controls.ServiceRiyohyoBeppyoGokei().displayNone = true;
                };
                GamenMode.prototype.ShuseiMode = function () {
                    this.controls.btnZengetsuCopy().displayNone = false;
                    this.controls.btnZengetsuCopy().disabled = true;

                    this.controls.btnBeppyoMeisaiNew().displayNone = false;
                    this.controls.btnBeppyoGokeiNew().displayNone = false;
                    this.controls.btnBeppyoMeisaiNew().disabled = false;
                    this.controls.btnBeppyoGokeiNew().disabled = false;

                    this.controls.ServiceRiyohyoBeppyoFooter().displayNone = false;
                    this.controls.btnUpdate().displayNone = false;
                    this.controls.btnUpdate().disabled = true;
                    this.controls.btnBackRiyoNengetsuIchiran().displayNone = false;
                    this.controls.ServiceRiyohyoBeppyoJigyoshaServiceInput().displayNone = true;
                    this.controls.ServiceRiyohyoBeppyoMeisai().displayNone = true;
                    this.controls.ServiceRiyohyoBeppyoGokei().displayNone = true;
                };
                GamenMode.prototype.SakujoMode = function () {
                    this.controls.btnZengetsuCopy().displayNone = false;
                    this.controls.btnZengetsuCopy().disabled = true;

                    this.controls.btnBeppyoMeisaiNew().displayNone = false;
                    this.controls.btnBeppyoGokeiNew().displayNone = false;
                    this.controls.btnBeppyoMeisaiNew().disabled = true;
                    this.controls.btnBeppyoGokeiNew().disabled = true;

                    this.controls.ServiceRiyohyoBeppyoFooter().displayNone = false;
                    this.controls.btnUpdate().displayNone = false;
                    this.controls.btnUpdate().disabled = true;
                    this.controls.btnBackRiyoNengetsuIchiran().displayNone = false;
                    this.controls.ServiceRiyohyoBeppyoJigyoshaServiceInput().displayNone = true;
                    this.controls.ServiceRiyohyoBeppyoMeisai().displayNone = true;
                    this.controls.ServiceRiyohyoBeppyoGokei().displayNone = true;
                };
                GamenMode.prototype.ShokaiMode = function () {
                    this.controls.btnZengetsuCopy().displayNone = true;

                    this.controls.btnBeppyoMeisaiNew().displayNone = true;
                    this.controls.btnBeppyoGokeiNew().displayNone = true;

                    this.controls.ServiceRiyohyoBeppyoFooter().displayNone = false;
                    this.controls.btnUpdate().displayNone = true;
                    this.controls.btnBackRiyoNengetsuIchiran().displayNone = false;
                    this.controls.ServiceRiyohyoBeppyoJigyoshaServiceInput().displayNone = false;
                    this.controls.ServiceRiyohyoBeppyoJigyoshaServiceInput().disabled = true;
                    this.controls.ServiceRiyohyoBeppyoMeisai().displayNone = false;
                    this.controls.ServiceRiyohyoBeppyoMeisai().disabled = true;
                    this.controls.ServiceRiyohyoBeppyoGokei().displayNone = false;
                    this.controls.ServiceRiyohyoBeppyoGokei().disabled = true;
                };
                return GamenMode;
            })();
            Modes.GamenMode = GamenMode;

            var KaigoType = (function () {
                function KaigoType(controls) {
                    this.controls = controls;
                }
                KaigoType.prototype.kyotakuService = function () {
                    this.controls.txtRiyoushaFutangaku().displayNone = true;
                    this.controls.txtTeigakuRiyoushaFutangaku().displayNone = true;
                    this.controls.chkZanteiKubun().disabled = false;
                };
                KaigoType.prototype.Sogojigyohi = function () {
                    this.controls.txtRiyoushaFutangaku().displayNone = false;
                    this.controls.txtTeigakuRiyoushaFutangaku().displayNone = false;
                    this.controls.chkZanteiKubun().disabled = true;
                };
                return KaigoType;
            })();
            Modes.KaigoType = KaigoType;
        })(ServiceRiyohyoInfo.Modes || (ServiceRiyohyoInfo.Modes = {}));
        var Modes = ServiceRiyohyoInfo.Modes;
    })(DBC.ServiceRiyohyoInfo || (DBC.ServiceRiyohyoInfo = {}));
    var ServiceRiyohyoInfo = DBC.ServiceRiyohyoInfo;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (ServiceRiyohyoInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceRiyohyoInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ServiceRiyohyoInfo.PublicProperties = PublicProperties;
    })(DBC.ServiceRiyohyoInfo || (DBC.ServiceRiyohyoInfo = {}));
    var ServiceRiyohyoInfo = DBC.ServiceRiyohyoInfo;
})(DBC || (DBC = {}));
