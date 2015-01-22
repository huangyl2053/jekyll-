var DBZ;
(function (DBZ) {
    (function (SogoShokaiKagoMoushitateInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiKagoMoushitateInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SogoShokaiKagoMoushitateInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiKagoMoushitateInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiKagoMoushitateInfo || (DBZ.SogoShokaiKagoMoushitateInfo = {}));
    var SogoShokaiKagoMoushitateInfo = DBZ.SogoShokaiKagoMoushitateInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiKagoMoushitateInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiKagoMoushitateInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiKagoMoushitateInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiKagoMoushitateInfo || (DBZ.SogoShokaiKagoMoushitateInfo = {}));
    var SogoShokaiKagoMoushitateInfo = DBZ.SogoShokaiKagoMoushitateInfo;
})(DBZ || (DBZ = {}));
