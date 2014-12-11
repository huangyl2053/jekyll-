var DBZ;
(function (DBZ) {
    (function (SogoShokaiShisetsuNyushoInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiShisetsuNyushoInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SogoShokaiShisetsuNyushoInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiShisetsuNyushoInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiShisetsuNyushoInfo || (DBZ.SogoShokaiShisetsuNyushoInfo = {}));
    var SogoShokaiShisetsuNyushoInfo = DBZ.SogoShokaiShisetsuNyushoInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiShisetsuNyushoInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiShisetsuNyushoInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiShisetsuNyushoInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiShisetsuNyushoInfo || (DBZ.SogoShokaiShisetsuNyushoInfo = {}));
    var SogoShokaiShisetsuNyushoInfo = DBZ.SogoShokaiShisetsuNyushoInfo;
})(DBZ || (DBZ = {}));
