var DBD;
(function (DBD) {
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
            ModeController.prototype.ShoriType = function () {
                return new Modes.ShoriType(this.controls);
            };
            return ModeController;
        })();
        NinteiInput.ModeController = ModeController;

        (function (Modes) {
            var ShoriType = (function () {
                function ShoriType(controls) {
                    this.controls = controls;
                }
                ShoriType.prototype.TemnyuMode = function () {
                    this.controls.txtNinteiYMD().readOnly = false;
                    this.controls.txtShinsakaiIken().readOnly = false;
                    this.controls.txtYokaigodoCode().readOnly = false;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = false;
                    this.controls.txtYukoShuryoYMD().readOnly = false;

                    this.controls.radNinteiKubun().selectedItem = "0";
                    this.controls.radNinteiKubun().readOnly = true;
                    this.controls.radNinteiKubun().displayNone = false;

                    this.controls.dgServiceIchiran().readOnly = false;

                    this.controls.chkMinashiKoshinNintei().readOnly = true;

                    this.controls.btnYokaigodoGuide().disabled = false;

                    this.controls.btnAfter6Month().disabled = false;
                    this.controls.btnAfter12Month().disabled = false;
                    this.controls.btnAfter18Month().disabled = false;
                    this.controls.btnAfter24Month().disabled = false;
                };

                ShoriType.prototype.InputMode = function () {
                    this.controls.txtNinteiYMD().readOnly = false;
                    this.controls.txtShinsakaiIken().readOnly = false;
                    this.controls.txtYokaigodoCode().readOnly = false;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = false;
                    this.controls.txtYukoShuryoYMD().readOnly = false;

                    this.controls.radNinteiKubun().selectedItem = "0";
                    this.controls.radNinteiKubun().readOnly = true;
                    this.controls.radNinteiKubun().displayNone = false;

                    this.controls.dgServiceIchiran().readOnly = false;

                    this.controls.chkMinashiKoshinNintei().readOnly = true;

                    this.controls.btnYokaigodoGuide().disabled = false;
                    this.controls.btnAfter6Month().disabled = false;
                    this.controls.btnAfter12Month().disabled = false;
                    this.controls.btnAfter18Month().disabled = false;
                    this.controls.btnAfter24Month().disabled = false;
                };
                ShoriType.prototype.TokushuTsuikaMode = function () {
                    this.controls.txtNinteiYMD().readOnly = false;
                    this.controls.txtShinsakaiIken().readOnly = false;
                    this.controls.txtYokaigodoCode().readOnly = false;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = false;
                    this.controls.txtYukoShuryoYMD().readOnly = false;

                    this.controls.radNinteiKubun().selectedItem = "0";
                    this.controls.radNinteiKubun().readOnly = true;
                    this.controls.radNinteiKubun().displayNone = false;

                    this.controls.dgServiceIchiran().readOnly = false;

                    this.controls.chkMinashiKoshinNintei().readOnly = true;

                    this.controls.btnYokaigodoGuide().disabled = false;
                    this.controls.btnAfter6Month().disabled = false;
                    this.controls.btnAfter12Month().disabled = false;
                    this.controls.btnAfter18Month().disabled = false;
                    this.controls.btnAfter24Month().disabled = false;
                };
                ShoriType.prototype.TokushuShuseiMode = function () {
                    this.controls.txtNinteiYMD().readOnly = false;
                    this.controls.txtShinsakaiIken().readOnly = false;
                    this.controls.txtYokaigodoCode().readOnly = false;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = false;
                    this.controls.txtYukoShuryoYMD().readOnly = false;

                    this.controls.radNinteiKubun().selectedItem = "0";
                    this.controls.radNinteiKubun().readOnly = true;
                    this.controls.radNinteiKubun().displayNone = false;

                    this.controls.dgServiceIchiran().readOnly = false;

                    this.controls.chkMinashiKoshinNintei().readOnly = false;

                    this.controls.btnYokaigodoGuide().disabled = false;
                    this.controls.btnAfter6Month().disabled = false;
                    this.controls.btnAfter12Month().disabled = false;
                    this.controls.btnAfter18Month().disabled = false;
                    this.controls.btnAfter24Month().disabled = false;
                };
                ShoriType.prototype.ShokaiMode = function () {
                    this.controls.txtNinteiYMD().readOnly = true;
                    this.controls.txtShinsakaiIken().readOnly = true;
                    this.controls.txtYokaigodoCode().readOnly = true;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = true;
                    this.controls.txtYukoShuryoYMD().readOnly = true;

                    this.controls.radNinteiKubun().selectedItem = "0";
                    this.controls.radNinteiKubun().readOnly = true;
                    this.controls.radNinteiKubun().displayNone = false;

                    this.controls.dgServiceIchiran().readOnly = true;

                    this.controls.chkMinashiKoshinNintei().readOnly = true;

                    this.controls.btnYokaigodoGuide().disabled = true;
                    this.controls.btnAfter6Month().disabled = true;
                    this.controls.btnAfter12Month().disabled = true;
                    this.controls.btnAfter18Month().disabled = true;
                    this.controls.btnAfter24Month().disabled = true;
                };
                ShoriType.prototype.NinteiMode = function () {
                    this.controls.txtNinteiYMD().readOnly = false;
                    this.controls.txtShinsakaiIken().readOnly = false;
                    this.controls.txtYokaigodoCode().readOnly = false;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = false;
                    this.controls.txtYukoShuryoYMD().readOnly = false;

                    this.controls.radNinteiKubun().readOnly = false;
                    this.controls.radNinteiKubun().displayNone = false;

                    this.controls.dgServiceIchiran().readOnly = true;

                    this.controls.chkMinashiKoshinNintei().readOnly = true;

                    this.controls.btnYokaigodoGuide().disabled = false;
                    this.controls.btnAfter6Month().disabled = false;
                    this.controls.btnAfter12Month().disabled = false;
                    this.controls.btnAfter18Month().disabled = false;
                    this.controls.btnAfter24Month().disabled = false;
                };
                ShoriType.prototype.ShokkenTsuikaMode = function () {
                    this.controls.txtNinteiYMD().readOnly = false;
                    this.controls.txtShinsakaiIken().readOnly = false;
                    this.controls.txtYokaigodoCode().readOnly = false;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = false;
                    this.controls.txtYukoShuryoYMD().readOnly = false;

                    this.controls.radNinteiKubun().readOnly = true;
                    this.controls.radNinteiKubun().displayNone = false;

                    this.controls.dgServiceIchiran().readOnly = false;

                    this.controls.chkMinashiKoshinNintei().readOnly = true;

                    this.controls.btnYokaigodoGuide().disabled = false;
                    this.controls.btnAfter6Month().disabled = false;
                    this.controls.btnAfter12Month().disabled = false;
                    this.controls.btnAfter18Month().disabled = false;
                    this.controls.btnAfter24Month().disabled = false;
                };
                ShoriType.prototype.ShokkenShuseiMode = function () {
                    this.controls.txtNinteiYMD().readOnly = false;
                    this.controls.txtShinsakaiIken().readOnly = false;
                    this.controls.txtYokaigodoCode().readOnly = false;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = false;
                    this.controls.txtYukoShuryoYMD().readOnly = false;

                    this.controls.radNinteiKubun().readOnly = true;
                    this.controls.radNinteiKubun().displayNone = true;

                    this.controls.dgServiceIchiran().readOnly = false;

                    this.controls.chkMinashiKoshinNintei().readOnly = true;

                    this.controls.btnYokaigodoGuide().disabled = false;
                    this.controls.btnAfter6Month().disabled = false;
                    this.controls.btnAfter12Month().disabled = false;
                    this.controls.btnAfter18Month().disabled = false;
                    this.controls.btnAfter24Month().disabled = false;
                };
                ShoriType.prototype.IchibuSoshitsuMode = function () {
                    this.controls.txtNinteiYMD().readOnly = false;
                    this.controls.txtShinsakaiIken().readOnly = true;
                    this.controls.txtYokaigodoCode().readOnly = true;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = false;
                    this.controls.txtYukoShuryoYMD().readOnly = true;

                    this.controls.radNinteiKubun().selectedItem = "0";
                    this.controls.radNinteiKubun().readOnly = true;
                    this.controls.radNinteiKubun().displayNone = true;

                    this.controls.dgServiceIchiran().readOnly = true;

                    this.controls.chkMinashiKoshinNintei().readOnly = true;

                    this.controls.btnYokaigodoGuide().disabled = true;
                    this.controls.btnAfter6Month().disabled = true;
                    this.controls.btnAfter12Month().disabled = true;
                    this.controls.btnAfter18Month().disabled = true;
                    this.controls.btnAfter24Month().disabled = true;
                };
                return ShoriType;
            })();
            Modes.ShoriType = ShoriType;
        })(NinteiInput.Modes || (NinteiInput.Modes = {}));
        var Modes = NinteiInput.Modes;
    })(DBD.NinteiInput || (DBD.NinteiInput = {}));
    var NinteiInput = DBD.NinteiInput;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
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
    })(DBD.NinteiInput || (DBD.NinteiInput = {}));
    var NinteiInput = DBD.NinteiInput;
})(DBD || (DBD = {}));
