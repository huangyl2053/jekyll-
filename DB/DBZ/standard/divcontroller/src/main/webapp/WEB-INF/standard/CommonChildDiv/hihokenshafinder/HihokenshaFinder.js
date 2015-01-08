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
                    "表示モード",
                    "保険者"
                ];
            };

            ModeController.prototype.表示モード = function () {
                return new Modes.表示モード(this.controls);
            };

            ModeController.prototype.保険者 = function () {
                return new Modes.保険者(this.controls);
            };
            return ModeController;
        })();
        HihokenshaFinder.ModeController = ModeController;

        (function (Modes) {
            var 表示モード = (function () {
                function 表示モード(controls) {
                    this.controls = controls;
                }
                表示モード.prototype.資格系 = function () {
                    this.controls.txtTuchishoNo().visible = false;
                    this.controls.txtTuchishoNo().displayNone = true;
                    this.controls.ddlFukaNendo().visible = false;
                    this.controls.ddlFukaNendo().displayNone = true;
                    this.controls.chkJukyushaDaicho().visible = true;
                    this.controls.chkJukyushaDaicho().displayNone = false;
                    this.controls.chkJushochiTokureisha().visible = true;
                    this.controls.chkJushochiTokureisha().displayNone = false;
                    this.controls.radMinashiNigo().visible = true;
                    this.controls.radMinashiNigo().displayNone = false;
                };

                表示モード.prototype.賦課系 = function () {
                    this.controls.txtTuchishoNo().visible = true;
                    this.controls.txtTuchishoNo().displayNone = false;
                    this.controls.ddlFukaNendo().visible = true;
                    this.controls.ddlFukaNendo().displayNone = false;
                    this.controls.chkJukyushaDaicho().visible = false;
                    this.controls.chkJukyushaDaicho().displayNone = true;
                    this.controls.chkJushochiTokureisha().visible = false;
                    this.controls.chkJushochiTokureisha().displayNone = true;
                    this.controls.radMinashiNigo().visible = false;
                    this.controls.radMinashiNigo().displayNone = true;
                };
                return 表示モード;
            })();
            Modes.表示モード = 表示モード;

            var 保険者 = (function () {
                function 保険者(controls) {
                    this.controls = controls;
                }
                保険者.prototype.表示する = function () {
                    this.controls.ddlHokensha().visible = true;
                    this.controls.ddlHokensha().displayNone = false;
                };

                保険者.prototype.表示しない = function () {
                    this.controls.ddlHokensha().visible = false;
                    this.controls.ddlHokensha().displayNone = true;
                };
                return 保険者;
            })();
            Modes.保険者 = 保険者;
        })(HihokenshaFinder.Modes || (HihokenshaFinder.Modes = {}));
        var Modes = HihokenshaFinder.Modes;
    })(DBZ.HihokenshaFinder || (DBZ.HihokenshaFinder = {}));
    var HihokenshaFinder = DBZ.HihokenshaFinder;
})(DBZ || (DBZ = {}));
