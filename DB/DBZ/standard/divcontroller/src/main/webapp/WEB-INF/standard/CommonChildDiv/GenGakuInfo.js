var DBZ;
(function (DBZ) {
    (function (GenGakuInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new GenGakuInfo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        GenGakuInfo.ModeController = ModeController;
    })(DBZ.GenGakuInfo || (DBZ.GenGakuInfo = {}));
    var GenGakuInfo = DBZ.GenGakuInfo;
})(DBZ || (DBZ = {}));
