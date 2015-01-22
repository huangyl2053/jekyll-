var DBZ;
(function (DBZ) {
    (function (SogoShokaiJutakuKaishuhiInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiJutakuKaishuhiInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SogoShokaiJutakuKaishuhiInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiJutakuKaishuhiInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiJutakuKaishuhiInfo || (DBZ.SogoShokaiJutakuKaishuhiInfo = {}));
    var SogoShokaiJutakuKaishuhiInfo = DBZ.SogoShokaiJutakuKaishuhiInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiJutakuKaishuhiInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiJutakuKaishuhiInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiJutakuKaishuhiInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiJutakuKaishuhiInfo || (DBZ.SogoShokaiJutakuKaishuhiInfo = {}));
    var SogoShokaiJutakuKaishuhiInfo = DBZ.SogoShokaiJutakuKaishuhiInfo;
})(DBZ || (DBZ = {}));
