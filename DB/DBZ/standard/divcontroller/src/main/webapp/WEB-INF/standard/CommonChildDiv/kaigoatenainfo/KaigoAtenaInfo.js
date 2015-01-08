var DBZ;
(function (DBZ) {
    (function (KaigoAtenaInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoAtenaInfo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoAtenaInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoAtenaInfo.ModeController = ModeController;
    })(DBZ.KaigoAtenaInfo || (DBZ.KaigoAtenaInfo = {}));
    var KaigoAtenaInfo = DBZ.KaigoAtenaInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoAtenaInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoAtenaInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoAtenaInfo.PublicProperties = PublicProperties;
    })(DBZ.KaigoAtenaInfo || (DBZ.KaigoAtenaInfo = {}));
    var KaigoAtenaInfo = DBZ.KaigoAtenaInfo;
})(DBZ || (DBZ = {}));
