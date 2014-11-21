var DBE;
(function (DBE) {
    (function (TokkijikoCom2) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TokkijikoCom2.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        TokkijikoCom2.ModeController = ModeController;
    })(DBE.TokkijikoCom2 || (DBE.TokkijikoCom2 = {}));
    var TokkijikoCom2 = DBE.TokkijikoCom2;
})(DBE || (DBE = {}));
