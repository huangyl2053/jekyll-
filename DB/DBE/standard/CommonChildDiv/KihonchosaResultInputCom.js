var DBE;
(function (DBE) {
    (function (KihonchosaResultInputCom) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KihonchosaResultInputCom.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        KihonchosaResultInputCom.ModeController = ModeController;
    })(DBE.KihonchosaResultInputCom || (DBE.KihonchosaResultInputCom = {}));
    var KihonchosaResultInputCom = DBE.KihonchosaResultInputCom;
})(DBE || (DBE = {}));
