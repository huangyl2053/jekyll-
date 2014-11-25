var DBZ;
(function (DBZ) {
    (function (SogoShokaiSaishinsaMoushitateInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiSaishinsaMoushitateInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiSaishinsaMoushitateInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiSaishinsaMoushitateInfo || (DBZ.SogoShokaiSaishinsaMoushitateInfo = {}));
    var SogoShokaiSaishinsaMoushitateInfo = DBZ.SogoShokaiSaishinsaMoushitateInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiSaishinsaMoushitateInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiSaishinsaMoushitateInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiSaishinsaMoushitateInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiSaishinsaMoushitateInfo || (DBZ.SogoShokaiSaishinsaMoushitateInfo = {}));
    var SogoShokaiSaishinsaMoushitateInfo = DBZ.SogoShokaiSaishinsaMoushitateInfo;
})(DBZ || (DBZ = {}));
