var DBE;
(function (DBE) {
    (function (ChosaIraishoAndChosahyoAndIkenshoPrint) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ChosaIraishoAndChosahyoAndIkenshoPrint.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ChosaIraishoAndChosahyoAndIkenshoPrint";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.ChosaIraishoAndChosahyoAndIkenshoPrint.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.ChosaIraishoAndChosahyoAndIkenshoPrint.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ChosaIraishoAndChosahyoAndIkenshoPrint = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.InsatsuTaishoShitei = function () {
                return new UZA.Panel(this.convFiledName("InsatsuTaishoShitei"));
            };

            Controls.prototype.NinteiChosa = function () {
                return new UZA.Panel(this.convFiledName("NinteiChosa"));
            };

            Controls.prototype.chk = function () {
                return new UZA.CheckBoxList(this.convFiledName("chk"));
            };

            Controls.prototype.chkOcrChosahyo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkOcrChosahyo"));
            };

            Controls.prototype.spSpace1 = function () {
                return new UZA.Space(this.convFiledName("spSpace1"));
            };

            Controls.prototype.txtInsatsuSu = function () {
                return new UZA.TextBox(this.convFiledName("txtInsatsuSu"));
            };

            Controls.prototype.ShujiiIkensho = function () {
                return new UZA.Panel(this.convFiledName("ShujiiIkensho"));
            };

            Controls.prototype.dgShujiiIkensho = function () {
                return new UZA.DataGrid(this.convFiledName("dgShujiiIkensho"));
            };

            Controls.prototype.chkInsatsuIkensho = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkInsatsuIkensho"));
            };

            Controls.prototype.chkIkenshoSakuseiryoSeikyusho = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkIkenshoSakuseiryoSeikyusho"));
            };

            Controls.prototype.chkIkenshoSakuseiIchiran = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkIkenshoSakuseiIchiran"));
            };

            Controls.prototype.TeishutsuKigen = function () {
                return new UZA.Panel(this.convFiledName("TeishutsuKigen"));
            };

            Controls.prototype.radTeishutsuKigen = function () {
                return new UZA.RadioButton(this.convFiledName("radTeishutsuKigen"));
            };

            Controls.prototype.spSpace2 = function () {
                return new UZA.Space(this.convFiledName("spSpace2"));
            };

            Controls.prototype.txtShiteiDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShiteiDay"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };

            Controls.prototype.btnPrint = function () {
                return new UZA.ButtonPrint(this.convFiledName("btnPrint"));
            };
            return Controls;
        })();
        ChosaIraishoAndChosahyoAndIkenshoPrint.Controls = Controls;
    })(DBE.ChosaIraishoAndChosahyoAndIkenshoPrint || (DBE.ChosaIraishoAndChosahyoAndIkenshoPrint = {}));
    var ChosaIraishoAndChosahyoAndIkenshoPrint = DBE.ChosaIraishoAndChosahyoAndIkenshoPrint;
})(DBE || (DBE = {}));
