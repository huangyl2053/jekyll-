var DBZ;
(function (DBZ) {
    (function (KaigoChohyoSeigyoMaintenance) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoChohyoSeigyoMaintenance.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoChohyoSeigyoMaintenance.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoChohyoSeigyoMaintenance.ModeController = ModeController;
    })(DBZ.KaigoChohyoSeigyoMaintenance || (DBZ.KaigoChohyoSeigyoMaintenance = {}));
    var KaigoChohyoSeigyoMaintenance = DBZ.KaigoChohyoSeigyoMaintenance;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoChohyoSeigyoMaintenance) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoChohyoSeigyoMaintenance.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoChohyoSeigyoMaintenance.PublicProperties = PublicProperties;
    })(DBZ.KaigoChohyoSeigyoMaintenance || (DBZ.KaigoChohyoSeigyoMaintenance = {}));
    var KaigoChohyoSeigyoMaintenance = DBZ.KaigoChohyoSeigyoMaintenance;
})(DBZ || (DBZ = {}));
