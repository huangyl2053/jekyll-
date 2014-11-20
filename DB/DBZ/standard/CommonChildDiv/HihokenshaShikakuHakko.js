var DBZ;
(function (DBZ) {
    (function (HihokenshaShikakuHakko) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HihokenshaShikakuHakko.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        HihokenshaShikakuHakko.ModeController = ModeController;
    })(DBZ.HihokenshaShikakuHakko || (DBZ.HihokenshaShikakuHakko = {}));
    var HihokenshaShikakuHakko = DBZ.HihokenshaShikakuHakko;
})(DBZ || (DBZ = {}));
