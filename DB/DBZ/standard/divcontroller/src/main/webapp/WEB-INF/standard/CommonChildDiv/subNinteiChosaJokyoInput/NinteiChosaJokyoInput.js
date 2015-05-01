var DBZ;
(function (DBZ) {
    (function (NinteiChosaJokyoInput) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiChosaJokyoInput.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new NinteiChosaJokyoInput.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        NinteiChosaJokyoInput.ModeController = ModeController;
    })(DBZ.NinteiChosaJokyoInput || (DBZ.NinteiChosaJokyoInput = {}));
    var NinteiChosaJokyoInput = DBZ.NinteiChosaJokyoInput;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (NinteiChosaJokyoInput) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiChosaJokyoInput.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        NinteiChosaJokyoInput.PublicProperties = PublicProperties;
    })(DBZ.NinteiChosaJokyoInput || (DBZ.NinteiChosaJokyoInput = {}));
    var NinteiChosaJokyoInput = DBZ.NinteiChosaJokyoInput;
})(DBZ || (DBZ = {}));
