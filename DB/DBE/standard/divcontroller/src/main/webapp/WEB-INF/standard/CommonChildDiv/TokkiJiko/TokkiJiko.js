var DBE;
(function (DBE) {
    (function (TokkiJiko) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TokkiJiko.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new TokkiJiko.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        TokkiJiko.ModeController = ModeController;
    })(DBE.TokkiJiko || (DBE.TokkiJiko = {}));
    var TokkiJiko = DBE.TokkiJiko;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (TokkiJiko) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TokkiJiko.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TokkiJiko.PublicProperties = PublicProperties;
    })(DBE.TokkiJiko || (DBE.TokkiJiko = {}));
    var TokkiJiko = DBE.TokkiJiko;
})(DBE || (DBE = {}));
