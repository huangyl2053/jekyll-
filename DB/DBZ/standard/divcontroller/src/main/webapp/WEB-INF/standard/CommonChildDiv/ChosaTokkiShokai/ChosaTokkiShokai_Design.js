var DBZ;
(function (DBZ) {
    (function (ChosaTokkiShokai) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnReturn = function () {
                return "onClick_btnReturn";
            };
            return Events;
        })();
        ChosaTokkiShokai.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ChosaTokkiShokai";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ChosaTokkiShokai.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ChosaTokkiShokai.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ChosaTokkiShokai = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtTokkiJikouNo = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkiJikouNo"));
            };

            Controls.prototype.txtTokkiJikouName = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkiJikouName"));
            };

            Controls.prototype.lblTextGenpon = function () {
                return new UZA.Label(this.convFiledName("lblTextGenpon"));
            };

            Controls.prototype.lblTextMask = function () {
                return new UZA.Label(this.convFiledName("lblTextMask"));
            };

            Controls.prototype.txtTokkijikoNo1 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo1"));
            };

            Controls.prototype.lbl1 = function () {
                return new UZA.Label(this.convFiledName("lbl1"));
            };

            Controls.prototype.txtRemban1 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban1"));
            };

            Controls.prototype.txtTextGenpo1 = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextGenpo1"));
            };

            Controls.prototype.txtTextMask1 = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextMask1"));
            };

            Controls.prototype.txtTokkijikoNo2 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo2"));
            };

            Controls.prototype.lbl2 = function () {
                return new UZA.Label(this.convFiledName("lbl2"));
            };

            Controls.prototype.txtRemban2 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban2"));
            };

            Controls.prototype.txtTextGenpo2 = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextGenpo2"));
            };

            Controls.prototype.txtTextMask2 = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextMask2"));
            };

            Controls.prototype.txtTokkijikoNo3 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo3"));
            };

            Controls.prototype.lbl3 = function () {
                return new UZA.Label(this.convFiledName("lbl3"));
            };

            Controls.prototype.txtRemban3 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban3"));
            };

            Controls.prototype.txtTextGenpo3 = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextGenpo3"));
            };

            Controls.prototype.txtTextMask3 = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextMask3"));
            };

            Controls.prototype.txtTokkijikoNo4 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo4"));
            };

            Controls.prototype.lbl4 = function () {
                return new UZA.Label(this.convFiledName("lbl4"));
            };

            Controls.prototype.txtRemban4 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban4"));
            };

            Controls.prototype.txtTextGenpo4 = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextGenpo4"));
            };

            Controls.prototype.txtTextMask4 = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextMask4"));
            };

            Controls.prototype.txtTokkijikoNo5 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo5"));
            };

            Controls.prototype.lbl5 = function () {
                return new UZA.Label(this.convFiledName("lbl5"));
            };

            Controls.prototype.txtRemban5 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban5"));
            };

            Controls.prototype.txtTextGenpo5 = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextGenpo5"));
            };

            Controls.prototype.txtTextMask5 = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextMask5"));
            };

            Controls.prototype.txtTokkijikoNo6 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo6"));
            };

            Controls.prototype.lbl6 = function () {
                return new UZA.Label(this.convFiledName("lbl6"));
            };

            Controls.prototype.txtRemban6 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban6"));
            };

            Controls.prototype.txtTextGenpo6 = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextGenpo6"));
            };

            Controls.prototype.txtTextMask6 = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextMask6"));
            };

            Controls.prototype.txtTokkijikoNo7 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo7"));
            };

            Controls.prototype.lbl7 = function () {
                return new UZA.Label(this.convFiledName("lbl7"));
            };

            Controls.prototype.txtRemban7 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban7"));
            };

            Controls.prototype.txtTextGenpo7 = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextGenpo7"));
            };

            Controls.prototype.txtTextMask7 = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextMask7"));
            };

            Controls.prototype.txtTokkijikoNo8 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo8"));
            };

            Controls.prototype.lbl8 = function () {
                return new UZA.Label(this.convFiledName("lbl8"));
            };

            Controls.prototype.txtRemban8 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban8"));
            };

            Controls.prototype.txtTextGenpo8 = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextGenpo8"));
            };

            Controls.prototype.txtTextMask8 = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextMask8"));
            };

            Controls.prototype.txtTokkijikoNo9 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo9"));
            };

            Controls.prototype.lbl9 = function () {
                return new UZA.Label(this.convFiledName("lbl9"));
            };

            Controls.prototype.txtRemban9 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban9"));
            };

            Controls.prototype.txtTextGenpo9 = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextGenpo9"));
            };

            Controls.prototype.txtTextMask9 = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextMask9"));
            };

            Controls.prototype.txtTokkijikoNo10 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo10"));
            };

            Controls.prototype.lbl10 = function () {
                return new UZA.Label(this.convFiledName("lbl10"));
            };

            Controls.prototype.txtRemban10 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban10"));
            };

            Controls.prototype.txtTextGenpo10 = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextGenpo10"));
            };

            Controls.prototype.txtTextMask10 = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTextMask10"));
            };

            Controls.prototype.txtTokkijikoNo11 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo11"));
            };

            Controls.prototype.lbl11 = function () {
                return new UZA.Label(this.convFiledName("lbl11"));
            };

            Controls.prototype.txtRemban11 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban11"));
            };

            Controls.prototype.imgGenpo1 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo1"));
            };

            Controls.prototype.imgMasking1 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking1"));
            };

            Controls.prototype.txtTokkijikoNo12 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo12"));
            };

            Controls.prototype.lbl12 = function () {
                return new UZA.Label(this.convFiledName("lbl12"));
            };

            Controls.prototype.txtRemban12 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban12"));
            };

            Controls.prototype.imgGenpo2 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo2"));
            };

            Controls.prototype.imgMasking2 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking2"));
            };

            Controls.prototype.txtTokkijikoNo13 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo13"));
            };

            Controls.prototype.lbl13 = function () {
                return new UZA.Label(this.convFiledName("lbl13"));
            };

            Controls.prototype.txtRemban13 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban13"));
            };

            Controls.prototype.imgGenpo3 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo3"));
            };

            Controls.prototype.imgMasking3 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking3"));
            };

            Controls.prototype.txtTokkijikoNo14 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo14"));
            };

            Controls.prototype.lbl14 = function () {
                return new UZA.Label(this.convFiledName("lbl14"));
            };

            Controls.prototype.txtRemban14 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban14"));
            };

            Controls.prototype.imgGenpo4 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo4"));
            };

            Controls.prototype.imgMasking4 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking4"));
            };

            Controls.prototype.txtTokkijikoNo15 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo15"));
            };

            Controls.prototype.lbl15 = function () {
                return new UZA.Label(this.convFiledName("lbl15"));
            };

            Controls.prototype.txtRemban15 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban15"));
            };

            Controls.prototype.imgGenpo5 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo5"));
            };

            Controls.prototype.imgMasking5 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking5"));
            };

            Controls.prototype.txtTokkijikoNo16 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo16"));
            };

            Controls.prototype.lbl16 = function () {
                return new UZA.Label(this.convFiledName("lbl16"));
            };

            Controls.prototype.txtRemban16 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban16"));
            };

            Controls.prototype.imgGenpo6 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo6"));
            };

            Controls.prototype.imgMasking6 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking6"));
            };

            Controls.prototype.txtTokkijikoNo17 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo17"));
            };

            Controls.prototype.lbl17 = function () {
                return new UZA.Label(this.convFiledName("lbl17"));
            };

            Controls.prototype.txtRemban17 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban17"));
            };

            Controls.prototype.imgGenpo7 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo7"));
            };

            Controls.prototype.imgMasking7 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking7"));
            };

            Controls.prototype.txtTokkijikoNo18 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo18"));
            };

            Controls.prototype.lbl18 = function () {
                return new UZA.Label(this.convFiledName("lbl18"));
            };

            Controls.prototype.txtRemban18 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban18"));
            };

            Controls.prototype.imgGenpo8 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo8"));
            };

            Controls.prototype.imgMasking8 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking8"));
            };

            Controls.prototype.txtTokkijikoNo19 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo19"));
            };

            Controls.prototype.lbl19 = function () {
                return new UZA.Label(this.convFiledName("lbl19"));
            };

            Controls.prototype.txtRemban19 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban19"));
            };

            Controls.prototype.imgGenpo9 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo9"));
            };

            Controls.prototype.imgMasking9 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking9"));
            };

            Controls.prototype.txtTokkijikoNo20 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo20"));
            };

            Controls.prototype.lbl20 = function () {
                return new UZA.Label(this.convFiledName("lbl20"));
            };

            Controls.prototype.txtRemban20 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban20"));
            };

            Controls.prototype.imgGenpo10 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo10"));
            };

            Controls.prototype.imgMasking10 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking10"));
            };

            Controls.prototype.btnReturn = function () {
                return new UZA.Button(this.convFiledName("btnReturn"));
            };
            return Controls;
        })();
        ChosaTokkiShokai.Controls = Controls;
    })(DBZ.ChosaTokkiShokai || (DBZ.ChosaTokkiShokai = {}));
    var ChosaTokkiShokai = DBZ.ChosaTokkiShokai;
})(DBZ || (DBZ = {}));
