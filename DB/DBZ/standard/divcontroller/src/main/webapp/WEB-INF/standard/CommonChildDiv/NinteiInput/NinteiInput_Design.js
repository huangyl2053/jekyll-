var DBZ;
(function (DBZ) {
    (function (NinteiInput) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        NinteiInput.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "NinteiInput";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.NinteiInput.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.NinteiInput.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.NinteiInput = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.NinteiJoho = function () {
                return new UZA.Panel(this.convFiledName("NinteiJoho"));
            };

            Controls.prototype.radNinteiKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radNinteiKubun"));
            };

            Controls.prototype.chkMinashiKoshinNintei = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkMinashiKoshinNintei"));
            };

            Controls.prototype.txtNinteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiYMD"));
            };

            Controls.prototype.txtYokaigodoCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtYokaigodoCode"));
            };

            Controls.prototype.btnYokaigodoGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnYokaigodoGuide"));
            };

            Controls.prototype.txtYokaigodoName = function () {
                return new UZA.TextBox(this.convFiledName("txtYokaigodoName"));
            };

            Controls.prototype.txtYukoKaishiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtYukoKaishiYMD"));
            };

            Controls.prototype.txtYukoShuryoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtYukoShuryoYMD"));
            };

            Controls.prototype.btnAfter6Month = function () {
                return new UZA.Button(this.convFiledName("btnAfter6Month"));
            };

            Controls.prototype.btnAfter12Month = function () {
                return new UZA.Button(this.convFiledName("btnAfter12Month"));
            };

            Controls.prototype.btnAfter18Month = function () {
                return new UZA.Button(this.convFiledName("btnAfter18Month"));
            };

            Controls.prototype.btnAfter24Month = function () {
                return new UZA.Button(this.convFiledName("btnAfter24Month"));
            };

            Controls.prototype.ServiceShitei = function () {
                return new UZA.Panel(this.convFiledName("ServiceShitei"));
            };

            Controls.prototype.lblServiceIken = function () {
                return new UZA.Label(this.convFiledName("lblServiceIken"));
            };

            Controls.prototype.dgServiceIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgServiceIchiran"));
            };

            Controls.prototype.txtShinsakaiIken = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinsakaiIken"));
            };
            return Controls;
        })();
        NinteiInput.Controls = Controls;
    })(DBZ.NinteiInput || (DBZ.NinteiInput = {}));
    var NinteiInput = DBZ.NinteiInput;
})(DBZ || (DBZ = {}));
