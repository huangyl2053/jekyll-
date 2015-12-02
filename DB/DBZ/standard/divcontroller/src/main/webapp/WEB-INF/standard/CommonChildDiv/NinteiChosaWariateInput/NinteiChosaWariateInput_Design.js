var DBZ;
(function (DBZ) {
    (function (NinteiChosaWariateInput) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnSearchTaishosha = function () {
                return "onClick_btnSearchTaishosha";
            };
            return Events;
        })();
        NinteiChosaWariateInput.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "NinteiChosaWariateInput";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.NinteiChosaWariateInput.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.NinteiChosaWariateInput.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.NinteiChosaWariateInput = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.WariateJokyo = function () {
                return new UZA.Panel(this.convFiledName("WariateJokyo"));
            };

            Controls.prototype.txtNinteiChosainCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtNinteiChosainCode"));
            };

            Controls.prototype.txtNinteiChosainName = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosainName"));
            };

            Controls.prototype.txtNinteiChosaItakusakiCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtNinteiChosaItakusakiCode"));
            };

            Controls.prototype.txtNinteiChosaItakusakiName = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosaItakusakiName"));
            };

            Controls.prototype.txtNinteiChosaDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiChosaDate"));
            };

            Controls.prototype.txtNinteiChosaTime = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosaTime"));
            };

            Controls.prototype.txtNinteiChosaTimeFrame = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosaTimeFrame"));
            };

            Controls.prototype.radYoyakuKahi = function () {
                return new UZA.RadioButton(this.convFiledName("radYoyakuKahi"));
            };

            Controls.prototype.txtNinteiChosaBiko = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiChosaBiko"));
            };

            Controls.prototype.radYoyakuJokyo = function () {
                return new UZA.RadioButton(this.convFiledName("radYoyakuJokyo"));
            };

            Controls.prototype.btnSearchTaishosha = function () {
                return new UZA.Button(this.convFiledName("btnSearchTaishosha"));
            };

            Controls.prototype.btnDisplayLatestInformation = function () {
                return new UZA.Button(this.convFiledName("btnDisplayLatestInformation"));
            };

            Controls.prototype.TaishoshaShosai = function () {
                return new UZA.Panel(this.convFiledName("TaishoshaShosai"));
            };

            Controls.prototype.txtHihoBangoNumber = function () {
                return new UZA.TextBox(this.convFiledName("txtHihoBangoNumber"));
            };

            Controls.prototype.txtHihoBangoGosu = function () {
                return new UZA.TextBox(this.convFiledName("txtHihoBangoGosu"));
            };

            Controls.prototype.txtHokenshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtHokenshaName"));
            };

            Controls.prototype.txtNinteiShinseiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiShinseiDate"));
            };

            Controls.prototype.txtNinteiShinseiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtNinteiShinseiKubun"));
            };

            Controls.prototype.txtTaishoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtTaishoshaName"));
            };

            Controls.prototype.txtTaishoshaNameKana = function () {
                return new UZA.TextBox(this.convFiledName("txtTaishoshaNameKana"));
            };

            Controls.prototype.txtBasho = function () {
                return new UZA.TextBox(this.convFiledName("txtBasho"));
            };

            Controls.prototype.txtChushajo = function () {
                return new UZA.TextBox(this.convFiledName("txtChushajo"));
            };

            Controls.prototype.txtTachiainin1 = function () {
                return new UZA.TextBox(this.convFiledName("txtTachiainin1"));
            };

            Controls.prototype.txtRenrakusaki1 = function () {
                return new UZA.TextBox(this.convFiledName("txtRenrakusaki1"));
            };

            Controls.prototype.txtTachiainin2 = function () {
                return new UZA.TextBox(this.convFiledName("txtTachiainin2"));
            };

            Controls.prototype.txtRenrakusaki2 = function () {
                return new UZA.TextBox(this.convFiledName("txtRenrakusaki2"));
            };

            Controls.prototype.txtTaishoshaShosaiMemo = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTaishoshaShosaiMemo"));
            };

            Controls.prototype.btnClear = function () {
                return new UZA.Button(this.convFiledName("btnClear"));
            };
            return Controls;
        })();
        NinteiChosaWariateInput.Controls = Controls;
    })(DBZ.NinteiChosaWariateInput || (DBZ.NinteiChosaWariateInput = {}));
    var NinteiChosaWariateInput = DBZ.NinteiChosaWariateInput;
})(DBZ || (DBZ = {}));
