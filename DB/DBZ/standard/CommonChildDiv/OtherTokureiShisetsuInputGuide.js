var DBZ;
(function (DBZ) {
    (function (OtherTokureiShisetsuInputGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new OtherTokureiShisetsuInputGuide.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        OtherTokureiShisetsuInputGuide.ModeController = ModeController;
    })(DBZ.OtherTokureiShisetsuInputGuide || (DBZ.OtherTokureiShisetsuInputGuide = {}));
    var OtherTokureiShisetsuInputGuide = DBZ.OtherTokureiShisetsuInputGuide;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (OtherTokureiShisetsuInputGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new OtherTokureiShisetsuInputGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        OtherTokureiShisetsuInputGuide.PublicProperties = PublicProperties;
    })(DBZ.OtherTokureiShisetsuInputGuide || (DBZ.OtherTokureiShisetsuInputGuide = {}));
    var OtherTokureiShisetsuInputGuide = DBZ.OtherTokureiShisetsuInputGuide;
})(DBZ || (DBZ = {}));
