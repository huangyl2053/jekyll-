var DBE;
(function (DBE) {
    (function (TokkiJikoInput) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TokkiJikoInput.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new TokkiJikoInput.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        TokkiJikoInput.ModeController = ModeController;
    })(DBE.TokkiJikoInput || (DBE.TokkiJikoInput = {}));
    var TokkiJikoInput = DBE.TokkiJikoInput;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (TokkiJikoInput) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TokkiJikoInput.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TokkiJikoInput.PublicProperties = PublicProperties;
    })(DBE.TokkiJikoInput || (DBE.TokkiJikoInput = {}));
    var TokkiJikoInput = DBE.TokkiJikoInput;
})(DBE || (DBE = {}));
