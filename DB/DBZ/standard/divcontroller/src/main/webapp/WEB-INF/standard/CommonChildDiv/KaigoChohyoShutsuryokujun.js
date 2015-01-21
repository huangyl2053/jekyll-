var DBZ;
(function (DBZ) {
    (function (KaigoChohyoShutsuryokujun) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoChohyoShutsuryokujun.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoChohyoShutsuryokujun.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoChohyoShutsuryokujun.ModeController = ModeController;
    })(DBZ.KaigoChohyoShutsuryokujun || (DBZ.KaigoChohyoShutsuryokujun = {}));
    var KaigoChohyoShutsuryokujun = DBZ.KaigoChohyoShutsuryokujun;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoChohyoShutsuryokujun) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoChohyoShutsuryokujun.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("ChohyoShutsuryokujun_width", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getChohyoShutsuryokujun_width = function () {
                return this.controls.convFiledName;
            };

            PublicProperties.prototype.setChohyoShutsuryokujun_width = function (value) {
                return this.controls.convFiledName = value;
            };
            return PublicProperties;
        })();
        KaigoChohyoShutsuryokujun.PublicProperties = PublicProperties;
    })(DBZ.KaigoChohyoShutsuryokujun || (DBZ.KaigoChohyoShutsuryokujun = {}));
    var KaigoChohyoShutsuryokujun = DBZ.KaigoChohyoShutsuryokujun;
})(DBZ || (DBZ = {}));
