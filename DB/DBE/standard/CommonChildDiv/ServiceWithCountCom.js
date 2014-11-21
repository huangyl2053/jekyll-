var DBE;
(function (DBE) {
    (function (ServiceWithCountCom) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceWithCountCom.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ServiceWithCountCom.ModeController = ModeController;
    })(DBE.ServiceWithCountCom || (DBE.ServiceWithCountCom = {}));
    var ServiceWithCountCom = DBE.ServiceWithCountCom;
})(DBE || (DBE = {}));
