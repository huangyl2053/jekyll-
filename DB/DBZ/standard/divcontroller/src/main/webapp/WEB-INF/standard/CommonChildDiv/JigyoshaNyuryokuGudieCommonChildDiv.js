var DBZ;
(function (DBZ) {
    (function (JigyoshaNyuryokuGudieCommonChildDiv) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JigyoshaNyuryokuGudieCommonChildDiv.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new JigyoshaNyuryokuGudieCommonChildDiv.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        JigyoshaNyuryokuGudieCommonChildDiv.ModeController = ModeController;
    })(DBZ.JigyoshaNyuryokuGudieCommonChildDiv || (DBZ.JigyoshaNyuryokuGudieCommonChildDiv = {}));
    var JigyoshaNyuryokuGudieCommonChildDiv = DBZ.JigyoshaNyuryokuGudieCommonChildDiv;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (JigyoshaNyuryokuGudieCommonChildDiv) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JigyoshaNyuryokuGudieCommonChildDiv.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JigyoshaNyuryokuGudieCommonChildDiv.PublicProperties = PublicProperties;
    })(DBZ.JigyoshaNyuryokuGudieCommonChildDiv || (DBZ.JigyoshaNyuryokuGudieCommonChildDiv = {}));
    var JigyoshaNyuryokuGudieCommonChildDiv = DBZ.JigyoshaNyuryokuGudieCommonChildDiv;
})(DBZ || (DBZ = {}));
