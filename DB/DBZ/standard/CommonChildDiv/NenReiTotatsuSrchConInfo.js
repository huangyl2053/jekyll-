var DBZ;
(function (DBZ) {
    (function (NenReiTotatsuSrchConInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.controls = new NenReiTotatsuSrchConInfo.Controls(fieldName);
            }
            ModeController.prototype.DisplayMode = function () {
                return new Modes.DisplayMode(this.controls);
            };
            return ModeController;
        })();
        NenReiTotatsuSrchConInfo.ModeController = ModeController;

        (function (Modes) {
            var DisplayMode = (function () {
                function DisplayMode(controls) {
                    this.controls = controls;
                }
                DisplayMode.prototype.KensakuInput = function () {
                    this.controls.btnKensaku().displayNone = false;
                };

                DisplayMode.prototype.ChushutsuInput = function () {
                    this.controls.btnKensaku().displayNone = true;
                };
                return DisplayMode;
            })();
            Modes.DisplayMode = DisplayMode;
        })(NenReiTotatsuSrchConInfo.Modes || (NenReiTotatsuSrchConInfo.Modes = {}));
        var Modes = NenReiTotatsuSrchConInfo.Modes;
    })(DBZ.NenReiTotatsuSrchConInfo || (DBZ.NenReiTotatsuSrchConInfo = {}));
    var NenReiTotatsuSrchConInfo = DBZ.NenReiTotatsuSrchConInfo;
})(DBZ || (DBZ = {}));
