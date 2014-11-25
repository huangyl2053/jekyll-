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

var DBE;
(function (DBE) {
    (function (TokkijikoCom2) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new TokkijikoCom2.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TokkijikoCom2.PublicProperties = PublicProperties;
    })(DBE.TokkijikoCom2 || (DBE.TokkijikoCom2 = {}));
    var TokkijikoCom2 = DBE.TokkijikoCom2;
})(DBE || (DBE = {}));
