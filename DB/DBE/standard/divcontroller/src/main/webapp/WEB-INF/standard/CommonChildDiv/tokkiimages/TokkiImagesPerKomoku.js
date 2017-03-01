var DBE;
(function (DBE) {
    (function (TokkiImagesPerKomoku) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TokkiImagesPerKomoku.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new TokkiImagesPerKomoku.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        TokkiImagesPerKomoku.ModeController = ModeController;
    })(DBE.TokkiImagesPerKomoku || (DBE.TokkiImagesPerKomoku = {}));
    var TokkiImagesPerKomoku = DBE.TokkiImagesPerKomoku;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (TokkiImagesPerKomoku) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TokkiImagesPerKomoku.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TokkiImagesPerKomoku.PublicProperties = PublicProperties;
    })(DBE.TokkiImagesPerKomoku || (DBE.TokkiImagesPerKomoku = {}));
    var TokkiImagesPerKomoku = DBE.TokkiImagesPerKomoku;
})(DBE || (DBE = {}));
