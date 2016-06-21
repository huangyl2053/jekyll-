var DBZ;
(function (DBZ) {
    (function (HihokenshaFinder) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                var _this = this;
                this.fieldName = fieldName;
                this.controls = new HihokenshaFinder.Controls(fieldName);

                Uz.GyomuJSHelper.registOriginalEvent("onClick_btnKaigoSaikinShorishaHyoji", function () {
                    (_this.controls.btnHihokenshaFinderHyoji()._control).fireEvent("onClick_btnHihokenshaFinderHyoji");
                });
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "HyojiMode",
                    "Hokensha"
                ];
            };

            ModeController.prototype.HyojiMode = function () {
                return new Modes.HyojiMode(this.controls);
            };

            ModeController.prototype.Hokensha = function () {
                return new Modes.Hokensha(this.controls);
            };
            return ModeController;
        })();
        HihokenshaFinder.ModeController = ModeController;

        (function (Modes) {
            var HyojiMode = (function () {
                function HyojiMode(controls) {
                    this.controls = controls;
                }
                HyojiMode.prototype.Shikakukei = function () {
                    this.controls.txtTuchishoNo().visible = false;
                    this.controls.txtTuchishoNo().displayNone = true;
                    this.controls.ddlFukaNendo().visible = false;
                    this.controls.ddlFukaNendo().displayNone = true;
                    this.controls.chkJukyushaDaicho().visible = true;
                    this.controls.chkJukyushaDaicho().displayNone = false;
                    this.controls.chkJushochiTokureisha().visible = true;
                    this.controls.chkJushochiTokureisha().displayNone = false;
                };

                HyojiMode.prototype.Fukakei = function () {
                    this.controls.txtTuchishoNo().visible = true;
                    this.controls.txtTuchishoNo().displayNone = false;
                    this.controls.ddlFukaNendo().visible = true;
                    this.controls.ddlFukaNendo().displayNone = false;
                    this.controls.chkJukyushaDaicho().visible = false;
                    this.controls.chkJukyushaDaicho().displayNone = true;
                    this.controls.chkJushochiTokureisha().visible = false;
                    this.controls.chkJushochiTokureisha().displayNone = true;
                };
                return HyojiMode;
            })();
            Modes.HyojiMode = HyojiMode;

            var Hokensha = (function () {
                function Hokensha(controls) {
                    this.controls = controls;
                }
                Hokensha.prototype.HyojiSuru = function () {
                    this.controls.ddlHokensha().visible = true;
                    this.controls.ddlHokensha().displayNone = false;
                };

                Hokensha.prototype.HyojiShinai = function () {
                    this.controls.ddlHokensha().visible = false;
                    this.controls.ddlHokensha().displayNone = true;
                };
                return Hokensha;
            })();
            Modes.Hokensha = Hokensha;
        })(HihokenshaFinder.Modes || (HihokenshaFinder.Modes = {}));
        var Modes = HihokenshaFinder.Modes;
    })(DBZ.HihokenshaFinder || (DBZ.HihokenshaFinder = {}));
    var HihokenshaFinder = DBZ.HihokenshaFinder;
})(DBZ || (DBZ = {}));
