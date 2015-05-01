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
            ModeController.prototype.ShoriType = function () {
                return new Modes.ShoriType(this.controls);
            };
            return ModeController;
        })();
        NinteiChosaJokyoInput.ModeController = ModeController;

        (function (Modes) {
            var ShoriType = (function () {
                function ShoriType(controls) {
                    this.controls = controls;
                }
                ShoriType.prototype.InputMode = function () {
                    this.controls.txtNinteiChosainCode().readOnly = false;
                    this.controls.txtNinteiChosaItakusakiCode().readOnly = false;
                    this.controls.txtNinteiChosaIraiDay().readOnly = false;
                    this.controls.txtNinteiChosaJisshiYoteiDay().readOnly = false;
                    this.controls.txtNinteiChosaJisshiDay().readOnly = false;
                    this.controls.ddlNinteiChosaItakusakiKubun().readOnly = false;

                    this.controls.btnChosainGuide().disabled = false;
                    this.controls.btnItakusakiGuide().disabled = false;

                    this.controls.txtShujiiCode().readOnly = false;
                    this.controls.txtShujiiIryoKikanCode().readOnly = false;
                    this.controls.txtShujiiIryoKikanIraiDay().readOnly = false;
                    this.controls.txtShujiiIryoKikanNyushuYoteiDay().readOnly = false;
                    this.controls.txtShujiiIryoKikanNyushuDay().readOnly = false;
                    this.controls.chkShujiiKubun().readOnly = false;

                    this.controls.btnShujiiGuide().disabled = false;
                    this.controls.btnIryoKikanGuide().disabled = false;

                    this.controls.HomonChosasaki().readOnly = false;
                    this.controls.IchijiHantei().readOnly = false;
                    this.controls.KaigoNinteiShinsakai().readOnly = false;
                    this.controls.EnkiTsuchi().readOnly = false;
                };

                ShoriType.prototype.ShokaiMode = function () {
                    this.controls.txtNinteiChosainCode().readOnly = true;
                    this.controls.txtNinteiChosaItakusakiCode().readOnly = true;
                    this.controls.txtNinteiChosaIraiDay().readOnly = true;
                    this.controls.txtNinteiChosaJisshiYoteiDay().readOnly = true;
                    this.controls.txtNinteiChosaJisshiDay().readOnly = true;
                    this.controls.ddlNinteiChosaItakusakiKubun().readOnly = true;

                    this.controls.btnChosainGuide().disabled = true;
                    this.controls.btnItakusakiGuide().disabled = true;

                    this.controls.txtShujiiCode().readOnly = true;
                    this.controls.txtShujiiIryoKikanCode().readOnly = true;
                    this.controls.txtShujiiIryoKikanIraiDay().readOnly = true;
                    this.controls.txtShujiiIryoKikanNyushuYoteiDay().readOnly = true;
                    this.controls.txtShujiiIryoKikanNyushuDay().readOnly = true;
                    this.controls.chkShujiiKubun().readOnly = true;

                    this.controls.btnShujiiGuide().disabled = true;
                    this.controls.btnIryoKikanGuide().disabled = true;

                    this.controls.HomonChosasaki().readOnly = true;
                    this.controls.IchijiHantei().readOnly = true;
                    this.controls.KaigoNinteiShinsakai().readOnly = true;
                    this.controls.EnkiTsuchi().readOnly = true;
                };
                return ShoriType;
            })();
            Modes.ShoriType = ShoriType;
        })(NinteiChosaJokyoInput.Modes || (NinteiChosaJokyoInput.Modes = {}));
        var Modes = NinteiChosaJokyoInput.Modes;
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
