var DBZ;
(function (DBZ) {
    (function (KaigoBunshoNoMaintenance) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoBunshoNoMaintenance.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoBunshoNoMaintenance.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoBunshoNoMaintenance.ModeController = ModeController;
    })(DBZ.KaigoBunshoNoMaintenance || (DBZ.KaigoBunshoNoMaintenance = {}));
    var KaigoBunshoNoMaintenance = DBZ.KaigoBunshoNoMaintenance;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoBunshoNoMaintenance) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoBunshoNoMaintenance.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoBunshoNoMaintenance.PublicProperties = PublicProperties;
    })(DBZ.KaigoBunshoNoMaintenance || (DBZ.KaigoBunshoNoMaintenance = {}));
    var KaigoBunshoNoMaintenance = DBZ.KaigoBunshoNoMaintenance;
})(DBZ || (DBZ = {}));
