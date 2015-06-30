var DBZ;
(function (DBZ) {
    (function (KaigoninteiShikakuInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoninteiShikakuInfo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoninteiShikakuInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoninteiShikakuInfo.ModeController = ModeController;
    })(DBZ.KaigoninteiShikakuInfo || (DBZ.KaigoninteiShikakuInfo = {}));
    var KaigoninteiShikakuInfo = DBZ.KaigoninteiShikakuInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoninteiShikakuInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoninteiShikakuInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoninteiShikakuInfo.PublicProperties = PublicProperties;
    })(DBZ.KaigoninteiShikakuInfo || (DBZ.KaigoninteiShikakuInfo = {}));
    var KaigoninteiShikakuInfo = DBZ.KaigoninteiShikakuInfo;
})(DBZ || (DBZ = {}));
