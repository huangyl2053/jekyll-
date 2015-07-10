var DBZ;
(function (DBZ) {
    (function (SogoShokaiGenmenGengakuInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiGenmenGengakuInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SogoShokaiGenmenGengakuInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiGenmenGengakuInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiGenmenGengakuInfo || (DBZ.SogoShokaiGenmenGengakuInfo = {}));
    var SogoShokaiGenmenGengakuInfo = DBZ.SogoShokaiGenmenGengakuInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiGenmenGengakuInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiGenmenGengakuInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiGenmenGengakuInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiGenmenGengakuInfo || (DBZ.SogoShokaiGenmenGengakuInfo = {}));
    var SogoShokaiGenmenGengakuInfo = DBZ.SogoShokaiGenmenGengakuInfo;
})(DBZ || (DBZ = {}));
