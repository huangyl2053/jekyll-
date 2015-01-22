var DBZ;
(function (DBZ) {
    (function (SogoShokaiNinteiInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiNinteiInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SogoShokaiNinteiInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiNinteiInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiNinteiInfo || (DBZ.SogoShokaiNinteiInfo = {}));
    var SogoShokaiNinteiInfo = DBZ.SogoShokaiNinteiInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiNinteiInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiNinteiInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiNinteiInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiNinteiInfo || (DBZ.SogoShokaiNinteiInfo = {}));
    var SogoShokaiNinteiInfo = DBZ.SogoShokaiNinteiInfo;
})(DBZ || (DBZ = {}));
