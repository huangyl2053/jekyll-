var DBZ;
(function (DBZ) {
    (function (NinteiChosaWariateInput) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiChosaWariateInput.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new NinteiChosaWariateInput.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        NinteiChosaWariateInput.ModeController = ModeController;
    })(DBZ.NinteiChosaWariateInput || (DBZ.NinteiChosaWariateInput = {}));
    var NinteiChosaWariateInput = DBZ.NinteiChosaWariateInput;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (NinteiChosaWariateInput) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiChosaWariateInput.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        NinteiChosaWariateInput.PublicProperties = PublicProperties;
    })(DBZ.NinteiChosaWariateInput || (DBZ.NinteiChosaWariateInput = {}));
    var NinteiChosaWariateInput = DBZ.NinteiChosaWariateInput;
})(DBZ || (DBZ = {}));
