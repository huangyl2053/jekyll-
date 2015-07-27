var DBZ;
(function (DBZ) {
    (function (KaigoTuchishoTeikeiBunMaintenance) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoTuchishoTeikeiBunMaintenance.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoTuchishoTeikeiBunMaintenance.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoTuchishoTeikeiBunMaintenance.ModeController = ModeController;
    })(DBZ.KaigoTuchishoTeikeiBunMaintenance || (DBZ.KaigoTuchishoTeikeiBunMaintenance = {}));
    var KaigoTuchishoTeikeiBunMaintenance = DBZ.KaigoTuchishoTeikeiBunMaintenance;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoTuchishoTeikeiBunMaintenance) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoTuchishoTeikeiBunMaintenance.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoTuchishoTeikeiBunMaintenance.PublicProperties = PublicProperties;
    })(DBZ.KaigoTuchishoTeikeiBunMaintenance || (DBZ.KaigoTuchishoTeikeiBunMaintenance = {}));
    var KaigoTuchishoTeikeiBunMaintenance = DBZ.KaigoTuchishoTeikeiBunMaintenance;
})(DBZ || (DBZ = {}));
