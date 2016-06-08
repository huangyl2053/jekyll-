var DBZ;
(function (DBZ) {
    (function (KaigoAtesakiJushoHenshu) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoAtesakiJushoHenshu.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoAtesakiJushoHenshu.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoAtesakiJushoHenshu.ModeController = ModeController;
    })(DBZ.KaigoAtesakiJushoHenshu || (DBZ.KaigoAtesakiJushoHenshu = {}));
    var KaigoAtesakiJushoHenshu = DBZ.KaigoAtesakiJushoHenshu;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoAtesakiJushoHenshu) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoAtesakiJushoHenshu.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoAtesakiJushoHenshu.PublicProperties = PublicProperties;
    })(DBZ.KaigoAtesakiJushoHenshu || (DBZ.KaigoAtesakiJushoHenshu = {}));
    var KaigoAtesakiJushoHenshu = DBZ.KaigoAtesakiJushoHenshu;
})(DBZ || (DBZ = {}));
