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

            Controls.prototype.textPanel = function () {
                return new UZA.Panel(this.convFiledName("textPanel"));
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

            Controls.prototype.imgPanel1 = function () {
                return new UZA.Panel(this.convFiledName("imgPanel1"));
            };

            Controls.prototype.lblImgGenpon = function () {
                return new UZA.Label(this.convFiledName("lblImgGenpon"));
            };

            Controls.prototype.lblImgMask = function () {
                return new UZA.Label(this.convFiledName("lblImgMask"));
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

            Controls.prototype.genpoPanel1 = function () {
                return new UZA.Panel(this.convFiledName("genpoPanel1"));
            };

            Controls.prototype.imgGenpo1 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo1"));
            };

            Controls.prototype.maskPanel1 = function () {
                return new UZA.Panel(this.convFiledName("maskPanel1"));
            };

            Controls.prototype.imgMasking1 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking1"));
            };

            Controls.prototype.LabelNoImage1 = function () {
                return new UZA.Label(this.convFiledName("LabelNoImage1"));
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

            Controls.prototype.genpoPanel2 = function () {
                return new UZA.Panel(this.convFiledName("genpoPanel2"));
            };

            Controls.prototype.imgGenpo2 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo2"));
            };

            Controls.prototype.maskPanel2 = function () {
                return new UZA.Panel(this.convFiledName("maskPanel2"));
            };

            Controls.prototype.imgMasking2 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking2"));
            };

            Controls.prototype.LabelNoImage2 = function () {
                return new UZA.Label(this.convFiledName("LabelNoImage2"));
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

            Controls.prototype.genpoPanel3 = function () {
                return new UZA.Panel(this.convFiledName("genpoPanel3"));
            };

            Controls.prototype.imgGenpo3 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo3"));
            };

            Controls.prototype.maskPanel3 = function () {
                return new UZA.Panel(this.convFiledName("maskPanel3"));
            };

            Controls.prototype.imgMasking3 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking3"));
            };

            Controls.prototype.LabelNoImage3 = function () {
                return new UZA.Label(this.convFiledName("LabelNoImage3"));
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

            Controls.prototype.genpoPanel4 = function () {
                return new UZA.Panel(this.convFiledName("genpoPanel4"));
            };

            Controls.prototype.imgGenpo4 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo4"));
            };

            Controls.prototype.maskPanel4 = function () {
                return new UZA.Panel(this.convFiledName("maskPanel4"));
            };

            Controls.prototype.imgMasking4 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking4"));
            };

            Controls.prototype.LabelNoImage4 = function () {
                return new UZA.Label(this.convFiledName("LabelNoImage4"));
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

            Controls.prototype.genpoPanel5 = function () {
                return new UZA.Panel(this.convFiledName("genpoPanel5"));
            };

            Controls.prototype.imgGenpo5 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo5"));
            };

            Controls.prototype.maskPanel5 = function () {
                return new UZA.Panel(this.convFiledName("maskPanel5"));
            };

            Controls.prototype.imgMasking5 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking5"));
            };

            Controls.prototype.LabelNoImage5 = function () {
                return new UZA.Label(this.convFiledName("LabelNoImage5"));
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

            Controls.prototype.genpoPanel6 = function () {
                return new UZA.Panel(this.convFiledName("genpoPanel6"));
            };

            Controls.prototype.imgGenpo6 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo6"));
            };

            Controls.prototype.maskPanel6 = function () {
                return new UZA.Panel(this.convFiledName("maskPanel6"));
            };

            Controls.prototype.imgMasking6 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking6"));
            };

            Controls.prototype.LabelNoImage6 = function () {
                return new UZA.Label(this.convFiledName("LabelNoImage6"));
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

            Controls.prototype.genpoPanel7 = function () {
                return new UZA.Panel(this.convFiledName("genpoPanel7"));
            };

            Controls.prototype.imgGenpo7 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo7"));
            };

            Controls.prototype.maskPanel7 = function () {
                return new UZA.Panel(this.convFiledName("maskPanel7"));
            };

            Controls.prototype.imgMasking7 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking7"));
            };

            Controls.prototype.LabelNoImage7 = function () {
                return new UZA.Label(this.convFiledName("LabelNoImage7"));
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

            Controls.prototype.genpoPanel8 = function () {
                return new UZA.Panel(this.convFiledName("genpoPanel8"));
            };

            Controls.prototype.imgGenpo8 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo8"));
            };

            Controls.prototype.maskPanel8 = function () {
                return new UZA.Panel(this.convFiledName("maskPanel8"));
            };

            Controls.prototype.imgMasking8 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking8"));
            };

            Controls.prototype.LabelNoImage8 = function () {
                return new UZA.Label(this.convFiledName("LabelNoImage8"));
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

            Controls.prototype.genpoPanel9 = function () {
                return new UZA.Panel(this.convFiledName("genpoPanel9"));
            };

            Controls.prototype.imgGenpo9 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo9"));
            };

            Controls.prototype.maskPanel9 = function () {
                return new UZA.Panel(this.convFiledName("maskPanel9"));
            };

            Controls.prototype.imgMasking9 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking9"));
            };

            Controls.prototype.LabelNoImage9 = function () {
                return new UZA.Label(this.convFiledName("LabelNoImage9"));
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

            Controls.prototype.genpoPanel10 = function () {
                return new UZA.Panel(this.convFiledName("genpoPanel10"));
            };

            Controls.prototype.imgGenpo10 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo10"));
            };

            Controls.prototype.maskPanel10 = function () {
                return new UZA.Panel(this.convFiledName("maskPanel10"));
            };

            Controls.prototype.imgMasking10 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking10"));
            };

            Controls.prototype.LabelNoImage10 = function () {
                return new UZA.Label(this.convFiledName("LabelNoImage10"));
            };

            Controls.prototype.imgPanel2 = function () {
                return new UZA.Panel(this.convFiledName("imgPanel2"));
            };

            Controls.prototype.lblImg = function () {
                return new UZA.Label(this.convFiledName("lblImg"));
            };

            Controls.prototype.txtTokkijikoNo21 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo21"));
            };

            Controls.prototype.lbl21 = function () {
                return new UZA.Label(this.convFiledName("lbl21"));
            };

            Controls.prototype.txtRemban21 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban21"));
            };

            Controls.prototype.genpoPanel11 = function () {
                return new UZA.Panel(this.convFiledName("genpoPanel11"));
            };

            Controls.prototype.imgGenpo11 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo11"));
            };

            Controls.prototype.maskPanel11 = function () {
                return new UZA.Panel(this.convFiledName("maskPanel11"));
            };

            Controls.prototype.imgMasking11 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking11"));
            };

            Controls.prototype.LabelNoImage11 = function () {
                return new UZA.Label(this.convFiledName("LabelNoImage11"));
            };

            Controls.prototype.txtTokkijikoNo22 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo22"));
            };

            Controls.prototype.lbl22 = function () {
                return new UZA.Label(this.convFiledName("lbl22"));
            };

            Controls.prototype.txtRemban22 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban22"));
            };

            Controls.prototype.genpoPanel12 = function () {
                return new UZA.Panel(this.convFiledName("genpoPanel12"));
            };

            Controls.prototype.imgGenpo12 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo12"));
            };

            Controls.prototype.maskPanel12 = function () {
                return new UZA.Panel(this.convFiledName("maskPanel12"));
            };

            Controls.prototype.imgMasking12 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking12"));
            };

            Controls.prototype.LabelNoImage12 = function () {
                return new UZA.Label(this.convFiledName("LabelNoImage12"));
            };

            Controls.prototype.txtTokkijikoNo23 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo23"));
            };

            Controls.prototype.lbl23 = function () {
                return new UZA.Label(this.convFiledName("lbl23"));
            };

            Controls.prototype.txtRemban23 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban23"));
            };

            Controls.prototype.genpoPanel13 = function () {
                return new UZA.Panel(this.convFiledName("genpoPanel13"));
            };

            Controls.prototype.imgGenpo13 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo13"));
            };

            Controls.prototype.maskPanel13 = function () {
                return new UZA.Panel(this.convFiledName("maskPanel13"));
            };

            Controls.prototype.imgMasking13 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking13"));
            };

            Controls.prototype.LabelNoImage13 = function () {
                return new UZA.Label(this.convFiledName("LabelNoImage13"));
            };

            Controls.prototype.txtTokkijikoNo24 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo24"));
            };

            Controls.prototype.lbl24 = function () {
                return new UZA.Label(this.convFiledName("lbl24"));
            };

            Controls.prototype.txtRemban24 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban24"));
            };

            Controls.prototype.genpoPanel14 = function () {
                return new UZA.Panel(this.convFiledName("genpoPanel14"));
            };

            Controls.prototype.imgGenpo14 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo14"));
            };

            Controls.prototype.maskPanel14 = function () {
                return new UZA.Panel(this.convFiledName("maskPanel14"));
            };

            Controls.prototype.imgMasking14 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking14"));
            };

            Controls.prototype.LabelNoImage14 = function () {
                return new UZA.Label(this.convFiledName("LabelNoImage14"));
            };

            Controls.prototype.txtTokkijikoNo25 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo25"));
            };

            Controls.prototype.lbl25 = function () {
                return new UZA.Label(this.convFiledName("lbl25"));
            };

            Controls.prototype.txtRemban25 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban25"));
            };

            Controls.prototype.genpoPanel15 = function () {
                return new UZA.Panel(this.convFiledName("genpoPanel15"));
            };

            Controls.prototype.imgGenpo15 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo15"));
            };

            Controls.prototype.maskPanel15 = function () {
                return new UZA.Panel(this.convFiledName("maskPanel15"));
            };

            Controls.prototype.imgMasking15 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking15"));
            };

            Controls.prototype.LabelNoImage15 = function () {
                return new UZA.Label(this.convFiledName("LabelNoImage15"));
            };

            Controls.prototype.txtTokkijikoNo26 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo26"));
            };

            Controls.prototype.lbl26 = function () {
                return new UZA.Label(this.convFiledName("lbl26"));
            };

            Controls.prototype.txtRemban26 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban26"));
            };

            Controls.prototype.genpoPanel16 = function () {
                return new UZA.Panel(this.convFiledName("genpoPanel16"));
            };

            Controls.prototype.imgGenpo16 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo16"));
            };

            Controls.prototype.maskPanel16 = function () {
                return new UZA.Panel(this.convFiledName("maskPanel16"));
            };

            Controls.prototype.imgMasking16 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking16"));
            };

            Controls.prototype.LabelNoImage16 = function () {
                return new UZA.Label(this.convFiledName("LabelNoImage16"));
            };

            Controls.prototype.txtTokkijikoNo27 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo27"));
            };

            Controls.prototype.lbl27 = function () {
                return new UZA.Label(this.convFiledName("lbl27"));
            };

            Controls.prototype.txtRemban27 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban27"));
            };

            Controls.prototype.genpoPanel17 = function () {
                return new UZA.Panel(this.convFiledName("genpoPanel17"));
            };

            Controls.prototype.imgGenpo17 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo17"));
            };

            Controls.prototype.maskPanel17 = function () {
                return new UZA.Panel(this.convFiledName("maskPanel17"));
            };

            Controls.prototype.imgMasking17 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking17"));
            };

            Controls.prototype.LabelNoImage17 = function () {
                return new UZA.Label(this.convFiledName("LabelNoImage17"));
            };

            Controls.prototype.txtTokkijikoNo28 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo28"));
            };

            Controls.prototype.lbl28 = function () {
                return new UZA.Label(this.convFiledName("lbl28"));
            };

            Controls.prototype.txtRemban28 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban28"));
            };

            Controls.prototype.genpoPanel18 = function () {
                return new UZA.Panel(this.convFiledName("genpoPanel18"));
            };

            Controls.prototype.imgGenpo18 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo18"));
            };

            Controls.prototype.maskPanel18 = function () {
                return new UZA.Panel(this.convFiledName("maskPanel18"));
            };

            Controls.prototype.imgMasking18 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking18"));
            };

            Controls.prototype.LabelNoImage18 = function () {
                return new UZA.Label(this.convFiledName("LabelNoImage18"));
            };

            Controls.prototype.txtTokkijikoNo29 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo29"));
            };

            Controls.prototype.lbl29 = function () {
                return new UZA.Label(this.convFiledName("lbl29"));
            };

            Controls.prototype.txtRemban29 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban29"));
            };

            Controls.prototype.genpoPanel19 = function () {
                return new UZA.Panel(this.convFiledName("genpoPanel19"));
            };

            Controls.prototype.imgGenpo19 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo19"));
            };

            Controls.prototype.maskPanel19 = function () {
                return new UZA.Panel(this.convFiledName("maskPanel19"));
            };

            Controls.prototype.imgMasking19 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking19"));
            };

            Controls.prototype.LabelNoImage19 = function () {
                return new UZA.Label(this.convFiledName("LabelNoImage19"));
            };

            Controls.prototype.txtTokkijikoNo30 = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkijikoNo30"));
            };

            Controls.prototype.lbl30 = function () {
                return new UZA.Label(this.convFiledName("lbl30"));
            };

            Controls.prototype.txtRemban30 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRemban30"));
            };

            Controls.prototype.genpoPanel20 = function () {
                return new UZA.Panel(this.convFiledName("genpoPanel20"));
            };

            Controls.prototype.imgGenpo20 = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpo20"));
            };

            Controls.prototype.maskPanel20 = function () {
                return new UZA.Panel(this.convFiledName("maskPanel20"));
            };

            Controls.prototype.imgMasking20 = function () {
                return new UZA.StaticImage(this.convFiledName("imgMasking20"));
            };

            Controls.prototype.LabelNoImage20 = function () {
                return new UZA.Label(this.convFiledName("LabelNoImage20"));
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
