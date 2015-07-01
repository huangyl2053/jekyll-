var DBD;
(function (DBD) {
    (function (NinteiInput) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_radNinteiKubun = function () {
                return "onChange_radNinteiKubun";
            };

            Events.onBeforeClick_btnValidate = function () {
                return "onBeforeClick_btnValidate";
            };

            Events.onClick_btnSixMonthLater = function () {
                return "onClick_btnSixMonthLater";
            };

            Events.onClick_btnTwelveMonthLater = function () {
                return "onClick_btnTwelveMonthLater";
            };

            Events.onClick_btnEigtheenMonthLater = function () {
                return "onClick_btnEigtheenMonthLater";
            };

            Events.onClick_btnTwentyfourMonthLater = function () {
                return "onClick_btnTwentyfourMonthLater";
            };
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
                return this._myName + "_" + DBD.NinteiInput.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.NinteiInput.Controls.myType() + "_" + fieldName;
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
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiYMD"));
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
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYukoKaishiYMD"));
            };

            Controls.prototype.txtYukoShuryoYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYukoShuryoYMD"));
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
    })(DBD.NinteiInput || (DBD.NinteiInput = {}));
    var NinteiInput = DBD.NinteiInput;
})(DBD || (DBD = {}));
