var DBE;
(function (DBE) {
    (function (NinteichosaIraiListForByHandCom) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteichosaIraiListForByHandCom.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        NinteichosaIraiListForByHandCom.ModeController = ModeController;
    })(DBE.NinteichosaIraiListForByHandCom || (DBE.NinteichosaIraiListForByHandCom = {}));
    var NinteichosaIraiListForByHandCom = DBE.NinteichosaIraiListForByHandCom;
})(DBE || (DBE = {}));
