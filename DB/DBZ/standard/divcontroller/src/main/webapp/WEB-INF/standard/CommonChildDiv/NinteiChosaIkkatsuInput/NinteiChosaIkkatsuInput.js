var DBZ;
(function (DBZ) {
    (function (NinteiChosaIkkatsuInput) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiChosaIkkatsuInput.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new NinteiChosaIkkatsuInput.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        NinteiChosaIkkatsuInput.ModeController = ModeController;
    })(DBZ.NinteiChosaIkkatsuInput || (DBZ.NinteiChosaIkkatsuInput = {}));
    var NinteiChosaIkkatsuInput = DBZ.NinteiChosaIkkatsuInput;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (NinteiChosaIkkatsuInput) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiChosaIkkatsuInput.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        NinteiChosaIkkatsuInput.PublicProperties = PublicProperties;
    })(DBZ.NinteiChosaIkkatsuInput || (DBZ.NinteiChosaIkkatsuInput = {}));
    var NinteiChosaIkkatsuInput = DBZ.NinteiChosaIkkatsuInput;
})(DBZ || (DBZ = {}));
