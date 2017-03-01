var DBE;
(function (DBE) {
    (function (TokkiImagesPerChosa) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TokkiImagesPerChosa.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new TokkiImagesPerChosa.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        TokkiImagesPerChosa.ModeController = ModeController;
    })(DBE.TokkiImagesPerChosa || (DBE.TokkiImagesPerChosa = {}));
    var TokkiImagesPerChosa = DBE.TokkiImagesPerChosa;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (TokkiImagesPerChosa) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TokkiImagesPerChosa.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TokkiImagesPerChosa.PublicProperties = PublicProperties;
    })(DBE.TokkiImagesPerChosa || (DBE.TokkiImagesPerChosa = {}));
    var TokkiImagesPerChosa = DBE.TokkiImagesPerChosa;
})(DBE || (DBE = {}));
