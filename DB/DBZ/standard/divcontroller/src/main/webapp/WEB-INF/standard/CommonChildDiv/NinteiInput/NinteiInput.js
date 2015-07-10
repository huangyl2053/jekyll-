var DBZ;
(function (DBZ) {
    (function (NinteiInput) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiInput.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new NinteiInput.PublicProperties(this.fieldName);
            };
            ModeController.prototype.shoriType = function () {
                return new Modes.shoriType(this.controls);
            };
            return ModeController;
        })();
        NinteiInput.ModeController = ModeController;

        (function (Modes) {
            var shoriType = (function () {
                function shoriType(controls) {
                    this.controls = controls;
                }
                shoriType.prototype.TemnyuMode = function () {
                    this.controls.txtNinteiYMD().readOnly = false;
                    this.controls.txtShinsakaiIken().readOnly = false;
                    this.controls.txtYokaigodoCode().readOnly = false;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = false;
                    this.controls.txtYukoShuryoYMD().readOnly = false;

                    this.controls.radNinteiKubun().readOnly = true;

                    this.controls.dgServiceIchiran().readOnly = false;

                    this.controls.chkMinashiKoshinNintei().readOnly = true;

                    this.controls.btnYokaigodoGuide().disabled = false;

                    this.controls.btnAfter6Month().disabled = false;
                    this.controls.btnAfter12Month().disabled = false;
                    this.controls.btnAfter18Month().disabled = false;
                    this.controls.btnAfter24Month().disabled = false;
                };

                shoriType.prototype.InputMode = function () {
                    this.controls.txtNinteiYMD().readOnly = false;
                    this.controls.txtShinsakaiIken().readOnly = false;
                    this.controls.txtYokaigodoCode().readOnly = false;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = false;
                    this.controls.txtYukoShuryoYMD().readOnly = false;

                    this.controls.radNinteiKubun().readOnly = false;
                    this.controls.radNinteiKubun().selectedItem = "key0";

                    this.controls.dgServiceIchiran().readOnly = false;

                    this.controls.chkMinashiKoshinNintei().readOnly = true;

                    this.controls.btnYokaigodoGuide().disabled = false;
                    this.controls.btnAfter6Month().disabled = false;
                    this.controls.btnAfter12Month().disabled = false;
                    this.controls.btnAfter18Month().disabled = false;
                    this.controls.btnAfter24Month().disabled = false;
                };
                shoriType.prototype.TokushuTsuikaMode = function () {
                    this.controls.txtNinteiYMD().readOnly = false;
                    this.controls.txtShinsakaiIken().readOnly = false;
                    this.controls.txtYokaigodoCode().readOnly = false;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = false;
                    this.controls.txtYukoShuryoYMD().readOnly = false;

                    this.controls.radNinteiKubun().readOnly = false;
                    this.controls.radNinteiKubun().selectedItem = "key0";

                    this.controls.dgServiceIchiran().readOnly = false;

                    this.controls.chkMinashiKoshinNintei().readOnly = true;

                    this.controls.btnYokaigodoGuide().disabled = false;
                    this.controls.btnAfter6Month().disabled = false;
                    this.controls.btnAfter12Month().disabled = false;
                    this.controls.btnAfter18Month().disabled = false;
                    this.controls.btnAfter24Month().disabled = false;
                };
                shoriType.prototype.TokushuShuseiMode = function () {
                    this.controls.txtNinteiYMD().readOnly = false;
                    this.controls.txtShinsakaiIken().readOnly = false;
                    this.controls.txtYokaigodoCode().readOnly = false;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = false;
                    this.controls.txtYukoShuryoYMD().readOnly = false;

                    this.controls.radNinteiKubun().readOnly = false;
                    this.controls.radNinteiKubun().selectedItem = "key0";

                    this.controls.dgServiceIchiran().readOnly = false;

                    this.controls.chkMinashiKoshinNintei().readOnly = false;

                    this.controls.btnYokaigodoGuide().disabled = false;
                    this.controls.btnAfter6Month().disabled = false;
                    this.controls.btnAfter12Month().disabled = false;
                    this.controls.btnAfter18Month().disabled = false;
                    this.controls.btnAfter24Month().disabled = false;
                };
                shoriType.prototype.ShokaiMode = function () {
                    this.controls.txtNinteiYMD().readOnly = true;
                    this.controls.txtShinsakaiIken().readOnly = true;
                    this.controls.txtYokaigodoCode().readOnly = true;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = true;
                    this.controls.txtYukoShuryoYMD().readOnly = true;

                    this.controls.radNinteiKubun().readOnly = true;
                    this.controls.radNinteiKubun().selectedItem = "key0";

                    this.controls.dgServiceIchiran().readOnly = true;

                    this.controls.chkMinashiKoshinNintei().readOnly = true;

                    this.controls.btnYokaigodoGuide().disabled = true;
                    this.controls.btnAfter6Month().disabled = true;
                    this.controls.btnAfter12Month().disabled = true;
                    this.controls.btnAfter18Month().disabled = true;
                    this.controls.btnAfter24Month().disabled = true;
                };
                shoriType.prototype.NinteiMode = function () {
                    this.controls.txtNinteiYMD().readOnly = false;
                    this.controls.txtShinsakaiIken().readOnly = false;
                    this.controls.txtYokaigodoCode().readOnly = false;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = false;
                    this.controls.txtYukoShuryoYMD().readOnly = false;

                    this.controls.radNinteiKubun().readOnly = false;

                    this.controls.dgServiceIchiran().readOnly = true;

                    this.controls.chkMinashiKoshinNintei().readOnly = true;

                    this.controls.btnYokaigodoGuide().disabled = false;
                    this.controls.btnAfter6Month().disabled = false;
                    this.controls.btnAfter12Month().disabled = false;
                    this.controls.btnAfter18Month().disabled = false;
                    this.controls.btnAfter24Month().disabled = false;
                };
                shoriType.prototype.ShokkenMode = function () {
                    this.controls.txtNinteiYMD().readOnly = false;
                    this.controls.txtShinsakaiIken().readOnly = false;
                    this.controls.txtYokaigodoCode().readOnly = false;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = false;
                    this.controls.txtYukoShuryoYMD().readOnly = false;

                    this.controls.radNinteiKubun().readOnly = true;

                    this.controls.dgServiceIchiran().readOnly = false;

                    this.controls.chkMinashiKoshinNintei().readOnly = true;

                    this.controls.btnYokaigodoGuide().disabled = false;
                    this.controls.btnAfter6Month().disabled = false;
                    this.controls.btnAfter12Month().disabled = false;
                    this.controls.btnAfter18Month().disabled = false;
                    this.controls.btnAfter24Month().disabled = false;
                };
                shoriType.prototype.IchibuSoshitsuMode = function () {
                    this.controls.txtNinteiYMD().readOnly = false;
                    this.controls.txtShinsakaiIken().readOnly = true;
                    this.controls.txtYokaigodoCode().readOnly = true;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = false;
                    this.controls.txtYukoShuryoYMD().readOnly = true;

                    this.controls.radNinteiKubun().readOnly = true;

                    this.controls.dgServiceIchiran().readOnly = true;

                    this.controls.chkMinashiKoshinNintei().readOnly = true;

                    this.controls.btnYokaigodoGuide().disabled = true;
                    this.controls.btnAfter6Month().disabled = true;
                    this.controls.btnAfter12Month().disabled = true;
                    this.controls.btnAfter18Month().disabled = true;
                    this.controls.btnAfter24Month().disabled = true;
                };
                return shoriType;
            })();
            Modes.shoriType = shoriType;
        })(NinteiInput.Modes || (NinteiInput.Modes = {}));
        var Modes = NinteiInput.Modes;
    })(DBZ.NinteiInput || (DBZ.NinteiInput = {}));
    var NinteiInput = DBZ.NinteiInput;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (NinteiInput) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiInput.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        NinteiInput.PublicProperties = PublicProperties;
    })(DBZ.NinteiInput || (DBZ.NinteiInput = {}));
    var NinteiInput = DBZ.NinteiInput;
})(DBZ || (DBZ = {}));
