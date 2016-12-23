var DBZ;
(function (DBZ) {
    (function (NinteiChosaJokyo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiChosaJokyo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new NinteiChosaJokyo.PublicProperties(this.fieldName);
            };
            ModeController.prototype.DisplayType = function () {
                return new Modes.DisplayType(this.controls);
            };
            return ModeController;
        })();
        NinteiChosaJokyo.ModeController = ModeController;

        (function (Modes) {
            var DisplayType = (function () {
                function DisplayType(controls) {
                    this.controls = controls;
                }
                DisplayType.prototype.input = function () {
                    this.controls.NinteiChosa().readOnly = false;
                    this.controls.HomonChosasaki().readOnly = false;
                    this.controls.ShujiiAndShujiIryoKikan().readOnly = false;
                    this.controls.IchijiHantei().readOnly = false;
                    this.controls.KaigoNinteiShinsakai().readOnly = false;
                    this.controls.EnkiTsuchi().readOnly = false;
                    this.controls.btnAllClear().displayNone = false;
                    this.controls.btnKakutei().displayNone = false;
                };

                DisplayType.prototype.shokai = function () {
                    this.controls.NinteiChosa().readOnly = true;
                    this.controls.HomonChosasaki().readOnly = true;
                    this.controls.ShujiiAndShujiIryoKikan().readOnly = true;
                    this.controls.IchijiHantei().readOnly = true;
                    this.controls.KaigoNinteiShinsakai().readOnly = true;
                    this.controls.EnkiTsuchi().readOnly = true;
                    this.controls.btnAllClear().displayNone = true;
                    this.controls.btnKakutei().displayNone = true;
                };
                return DisplayType;
            })();
            Modes.DisplayType = DisplayType;
        })(NinteiChosaJokyo.Modes || (NinteiChosaJokyo.Modes = {}));
        var Modes = NinteiChosaJokyo.Modes;
    })(DBZ.NinteiChosaJokyo || (DBZ.NinteiChosaJokyo = {}));
    var NinteiChosaJokyo = DBZ.NinteiChosaJokyo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (NinteiChosaJokyo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiChosaJokyo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        NinteiChosaJokyo.PublicProperties = PublicProperties;
    })(DBZ.NinteiChosaJokyo || (DBZ.NinteiChosaJokyo = {}));
    var NinteiChosaJokyo = DBZ.NinteiChosaJokyo;
})(DBZ || (DBZ = {}));
