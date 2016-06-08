var DBZ;
(function (DBZ) {
    (function (KaigoRenrakusakiInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoRenrakusakiInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoRenrakusakiInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoRenrakusakiInfo.ModeController = ModeController;
    })(DBZ.KaigoRenrakusakiInfo || (DBZ.KaigoRenrakusakiInfo = {}));
    var KaigoRenrakusakiInfo = DBZ.KaigoRenrakusakiInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoRenrakusakiInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KaigoRenrakusakiInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoRenrakusakiInfo.PublicProperties = PublicProperties;
    })(DBZ.KaigoRenrakusakiInfo || (DBZ.KaigoRenrakusakiInfo = {}));
    var KaigoRenrakusakiInfo = DBZ.KaigoRenrakusakiInfo;
})(DBZ || (DBZ = {}));
