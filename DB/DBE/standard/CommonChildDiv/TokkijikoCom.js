var DBE;
(function (DBE) {
    (function (TokkijikoCom) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TokkijikoCom.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        TokkijikoCom.ModeController = ModeController;
    })(DBE.TokkijikoCom || (DBE.TokkijikoCom = {}));
    var TokkijikoCom = DBE.TokkijikoCom;
})(DBE || (DBE = {}));
