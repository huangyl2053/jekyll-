var DBE;
(function (DBE) {
    (function (ShozokuChosainListCom) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShozokuChosainListCom.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ShozokuChosainListCom.ModeController = ModeController;
    })(DBE.ShozokuChosainListCom || (DBE.ShozokuChosainListCom = {}));
    var ShozokuChosainListCom = DBE.ShozokuChosainListCom;
})(DBE || (DBE = {}));
