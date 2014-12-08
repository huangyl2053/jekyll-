var DBZ;
(function (DBZ) {
    (function (TainoInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TainoInfo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        TainoInfo.ModeController = ModeController;
    })(DBZ.TainoInfo || (DBZ.TainoInfo = {}));
    var TainoInfo = DBZ.TainoInfo;
})(DBZ || (DBZ = {}));
