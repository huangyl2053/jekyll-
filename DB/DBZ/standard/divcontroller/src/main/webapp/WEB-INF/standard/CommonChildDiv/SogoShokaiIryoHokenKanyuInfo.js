var DBZ;
(function (DBZ) {
    (function (SogoShokaiIryoHokenKanyuInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiIryoHokenKanyuInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiIryoHokenKanyuInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiIryoHokenKanyuInfo || (DBZ.SogoShokaiIryoHokenKanyuInfo = {}));
    var SogoShokaiIryoHokenKanyuInfo = DBZ.SogoShokaiIryoHokenKanyuInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiIryoHokenKanyuInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiIryoHokenKanyuInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiIryoHokenKanyuInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiIryoHokenKanyuInfo || (DBZ.SogoShokaiIryoHokenKanyuInfo = {}));
    var SogoShokaiIryoHokenKanyuInfo = DBZ.SogoShokaiIryoHokenKanyuInfo;
})(DBZ || (DBZ = {}));
