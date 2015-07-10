var DBZ;
(function (DBZ) {
    (function (KaigoSaikinShorishaRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                var _this = this;
                this.fieldName = fieldName;
                this.controls = new KaigoSaikinShorishaRireki.Controls(fieldName);

                Uz.GyomuJSHelper.registOriginalEvent("onClick_btnSaikinShorishaHyoji", function () {
                    (_this.controls.btnKaigoSaikinShorishaHyoji()._control).fireEvent("onClick_btnKaigoSaikinShorishaHyoji");
                });
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "DummyMode1"
                ];
            };

            ModeController.prototype.DummyMode1 = function () {
                return new Modes.DummyMode1(this.controls);
            };
            return ModeController;
        })();
        KaigoSaikinShorishaRireki.ModeController = ModeController;

        (function (Modes) {
            var DummyMode1 = (function () {
                function DummyMode1(controls) {
                    this.controls = controls;
                }
                DummyMode1.prototype.val1 = function () {
                };
                return DummyMode1;
            })();
            Modes.DummyMode1 = DummyMode1;
        })(KaigoSaikinShorishaRireki.Modes || (KaigoSaikinShorishaRireki.Modes = {}));
        var Modes = KaigoSaikinShorishaRireki.Modes;
    })(DBZ.KaigoSaikinShorishaRireki || (DBZ.KaigoSaikinShorishaRireki = {}));
    var KaigoSaikinShorishaRireki = DBZ.KaigoSaikinShorishaRireki;
})(DBZ || (DBZ = {}));
