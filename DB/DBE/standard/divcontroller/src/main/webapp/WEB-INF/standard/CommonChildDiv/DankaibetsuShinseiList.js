var DBE;
(function (DBE) {
    (function (DankaibetsuShinseiList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new DankaibetsuShinseiList.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        DankaibetsuShinseiList.ModeController = ModeController;
    })(DBE.DankaibetsuShinseiList || (DBE.DankaibetsuShinseiList = {}));
    var DankaibetsuShinseiList = DBE.DankaibetsuShinseiList;
})(DBE || (DBE = {}));
