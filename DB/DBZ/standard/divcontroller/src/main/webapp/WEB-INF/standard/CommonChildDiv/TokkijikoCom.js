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

var DBE;
(function (DBE) {
    (function (TokkijikoCom) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new TokkijikoCom.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TokkijikoCom.PublicProperties = PublicProperties;
    })(DBE.TokkijikoCom || (DBE.TokkijikoCom = {}));
    var TokkijikoCom = DBE.TokkijikoCom;
})(DBE || (DBE = {}));
