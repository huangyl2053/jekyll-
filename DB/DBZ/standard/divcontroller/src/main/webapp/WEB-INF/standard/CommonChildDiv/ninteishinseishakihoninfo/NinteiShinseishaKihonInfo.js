var DBZ;
(function (DBZ) {
    (function (NinteiShinseishaKihonInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiShinseishaKihonInfo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new NinteiShinseishaKihonInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        NinteiShinseishaKihonInfo.ModeController = ModeController;
    })(DBZ.NinteiShinseishaKihonInfo || (DBZ.NinteiShinseishaKihonInfo = {}));
    var NinteiShinseishaKihonInfo = DBZ.NinteiShinseishaKihonInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (NinteiShinseishaKihonInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiShinseishaKihonInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        NinteiShinseishaKihonInfo.PublicProperties = PublicProperties;
    })(DBZ.NinteiShinseishaKihonInfo || (DBZ.NinteiShinseishaKihonInfo = {}));
    var NinteiShinseishaKihonInfo = DBZ.NinteiShinseishaKihonInfo;
})(DBZ || (DBZ = {}));
