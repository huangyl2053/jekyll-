var DBZ;
(function (DBZ) {
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
    })(DBZ.TokkiJiko || (DBZ.TokkiJiko = {}));
    var TokkiJiko = DBZ.TokkiJiko;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
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
    })(DBZ.TokkiJiko || (DBZ.TokkiJiko = {}));
    var TokkiJiko = DBZ.TokkiJiko;
})(DBZ || (DBZ = {}));
