var DBZ;
(function (DBZ) {
    (function (ChosaIraishoAndChosahyoAndIkenshoPrint) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_chkIkenshoSakuseiryoSeikyusho = function () {
                return "onChange_chkIkenshoSakuseiryoSeikyusho";
            };

            Events.onChange_radJyushinKikan = function () {
                return "onChange_radJyushinKikan";
            };

            Events.onChange_radTeishutsuKigen = function () {
                return "onChange_radTeishutsuKigen";
            };

            Events.onClick_btnModoru = function () {
                return "onClick_btnModoru";
            };
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
                return this._myName + "_" + DBZ.ChosaIraishoAndChosahyoAndIkenshoPrint.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ChosaIraishoAndChosahyoAndIkenshoPrint.Controls.myType() + "_" + fieldName;
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

            Controls.prototype.dgNinteiChosa = function () {
                return new UZA.DataGrid(this.convFiledName("dgNinteiChosa"));
            };

            Controls.prototype.NinteiChosaPrint = function () {
                return new UZA.Panel(this.convFiledName("NinteiChosaPrint"));
            };

            Controls.prototype.chk = function () {
                return new UZA.CheckBoxList(this.convFiledName("chk"));
            };

            Controls.prototype.chkChosahyo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkChosahyo"));
            };

            Controls.prototype.chkOcrChosahyo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkOcrChosahyo"));
            };

            Controls.prototype.chkChosahyo2 = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkChosahyo2"));
            };

            Controls.prototype.ShujiiIkensho = function () {
                return new UZA.Panel(this.convFiledName("ShujiiIkensho"));
            };

            Controls.prototype.dgShujiiIkensho = function () {
                return new UZA.DataGrid(this.convFiledName("dgShujiiIkensho"));
            };

            Controls.prototype.ShujiiIkenshoPrint = function () {
                return new UZA.Panel(this.convFiledName("ShujiiIkenshoPrint"));
            };

            Controls.prototype.chkInsatsuIkensho = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkInsatsuIkensho"));
            };

            Controls.prototype.chkIkenshoSakuseiIchiran = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkIkenshoSakuseiIchiran"));
            };

            Controls.prototype.chkIkenshoSakuseiryoSeikyusho = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkIkenshoSakuseiryoSeikyusho"));
            };

            Controls.prototype.ShindanMeirei = function () {
                return new UZA.Panel(this.convFiledName("ShindanMeirei"));
            };

            Controls.prototype.radJyushinKikan = function () {
                return new UZA.RadioButton(this.convFiledName("radJyushinKikan"));
            };

            Controls.prototype.txtJyushinymd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtJyushinymd"));
            };

            Controls.prototype.txtJushinTime = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtJushinTime"));
            };

            Controls.prototype.spSpace1 = function () {
                return new UZA.Space(this.convFiledName("spSpace1"));
            };

            Controls.prototype.txtJushinKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtJushinKikan"));
            };

            Controls.prototype.spSpace3 = function () {
                return new UZA.Space(this.convFiledName("spSpace3"));
            };

            Controls.prototype.txtJushinBasho = function () {
                return new UZA.TextBox(this.convFiledName("txtJushinBasho"));
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

            Controls.prototype.txtKyotsuDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKyotsuDay"));
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
    })(DBZ.ChosaIraishoAndChosahyoAndIkenshoPrint || (DBZ.ChosaIraishoAndChosahyoAndIkenshoPrint = {}));
    var ChosaIraishoAndChosahyoAndIkenshoPrint = DBZ.ChosaIraishoAndChosahyoAndIkenshoPrint;
})(DBZ || (DBZ = {}));
