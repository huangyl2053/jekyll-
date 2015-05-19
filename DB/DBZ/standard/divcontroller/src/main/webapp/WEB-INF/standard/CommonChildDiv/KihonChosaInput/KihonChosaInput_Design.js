var DBZ;
(function (DBZ) {
    (function (KihonChosaInput) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KihonChosaInput.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KihonChosaInput";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KihonChosaInput.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KihonChosaInput.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KihonChosaInput = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.KihonChosaIchiran = function () {
                return new UZA.Panel(this.convFiledName("KihonChosaIchiran"));
            };

            Controls.prototype.dgKihonChosaKomokuIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgKihonChosaKomokuIchiran"));
            };

            Controls.prototype.btnNextGun = function () {
                return new UZA.Button(this.convFiledName("btnNextGun"));
            };

            Controls.prototype.TokkiJiko = function () {
                return new UZA.Panel(this.convFiledName("TokkiJiko"));
            };

            Controls.prototype.dgHanrei = function () {
                return new UZA.DataGrid(this.convFiledName("dgHanrei"));
            };

            Controls.prototype.tblTextTokkiJiko = function () {
                return new UZA.TablePanel(this.convFiledName("tblTextTokkiJiko"));
            };

            Controls.prototype.celTextTokkiJikoTitle = function () {
                return new UZA.TableCell(this.convFiledName("celTextTokkiJikoTitle"));
            };

            Controls.prototype.lblTextTokkiJikoTitle = function () {
                return new UZA.Label(this.convFiledName("lblTextTokkiJikoTitle"));
            };

            Controls.prototype.celTextTokkiJikoGun = function () {
                return new UZA.TableCell(this.convFiledName("celTextTokkiJikoGun"));
            };

            Controls.prototype.lblTextTokkiJikoGun = function () {
                return new UZA.Label(this.convFiledName("lblTextTokkiJikoGun"));
            };

            Controls.prototype.celTextTokkiJikoHyphen = function () {
                return new UZA.TableCell(this.convFiledName("celTextTokkiJikoHyphen"));
            };

            Controls.prototype.lblTextTokkiJikoHyphen = function () {
                return new UZA.Label(this.convFiledName("lblTextTokkiJikoHyphen"));
            };

            Controls.prototype.celTokkiJikoNoText = function () {
                return new UZA.TableCell(this.convFiledName("celTokkiJikoNoText"));
            };

            Controls.prototype.txtTokkiJikoNoText = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTokkiJikoNoText"));
            };

            Controls.prototype.celTextTokkiJikoNaiyo = function () {
                return new UZA.TableCell(this.convFiledName("celTextTokkiJikoNaiyo"));
            };

            Controls.prototype.lblTextTokkiJikoNaiyo = function () {
                return new UZA.Label(this.convFiledName("lblTextTokkiJikoNaiyo"));
            };

            Controls.prototype.btnTeikeiBunGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnTeikeiBunGuide"));
            };

            Controls.prototype.celTokkijikoInput = function () {
                return new UZA.TableCell(this.convFiledName("celTokkijikoInput"));
            };

            Controls.prototype.txtTokkijikoInput = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTokkijikoInput"));
            };

            Controls.prototype.btnTextMasking = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnTextMasking"));
            };

            Controls.prototype.btnBeforeTextTokkiJiko = function () {
                return new UZA.Button(this.convFiledName("btnBeforeTextTokkiJiko"));
            };

            Controls.prototype.lblTextCurrentHyojiNo = function () {
                return new UZA.Label(this.convFiledName("lblTextCurrentHyojiNo"));
            };

            Controls.prototype.lblTextMaxPerCurrent = function () {
                return new UZA.Label(this.convFiledName("lblTextMaxPerCurrent"));
            };

            Controls.prototype.lblTextMaxHyojino = function () {
                return new UZA.Label(this.convFiledName("lblTextMaxHyojino"));
            };

            Controls.prototype.btnAfterTextTokkiJiko = function () {
                return new UZA.Button(this.convFiledName("btnAfterTextTokkiJiko"));
            };

            Controls.prototype.linHolizontal = function () {
                return new UZA.HorizontalLine(this.convFiledName("linHolizontal"));
            };

            Controls.prototype.tblTokkiJiko = function () {
                return new UZA.TablePanel(this.convFiledName("tblTokkiJiko"));
            };

            Controls.prototype.celImageTokkiJikoTitle = function () {
                return new UZA.TableCell(this.convFiledName("celImageTokkiJikoTitle"));
            };

            Controls.prototype.lblImageTokkiJikoTitle = function () {
                return new UZA.Label(this.convFiledName("lblImageTokkiJikoTitle"));
            };

            Controls.prototype.celImageTokkiJikkoGun = function () {
                return new UZA.TableCell(this.convFiledName("celImageTokkiJikkoGun"));
            };

            Controls.prototype.lblImageTokkiJikkoGun = function () {
                return new UZA.Label(this.convFiledName("lblImageTokkiJikkoGun"));
            };

            Controls.prototype.celImageTokkiJikkoHyphen = function () {
                return new UZA.TableCell(this.convFiledName("celImageTokkiJikkoHyphen"));
            };

            Controls.prototype.lblImageTokkiJikkoHyphen = function () {
                return new UZA.Label(this.convFiledName("lblImageTokkiJikkoHyphen"));
            };

            Controls.prototype.celImageTokkiJikkoNo = function () {
                return new UZA.TableCell(this.convFiledName("celImageTokkiJikkoNo"));
            };

            Controls.prototype.lblImageTokkiJikkoNo = function () {
                return new UZA.TextBoxNum(this.convFiledName("lblImageTokkiJikkoNo"));
            };

            Controls.prototype.celTokkiJikoNaiyomage = function () {
                return new UZA.TableCell(this.convFiledName("celTokkiJikoNaiyomage"));
            };

            Controls.prototype.lblTokkiJikoNaiyomage = function () {
                return new UZA.Label(this.convFiledName("lblTokkiJikoNaiyomage"));
            };

            Controls.prototype.celimgMaskingImage = function () {
                return new UZA.TableCell(this.convFiledName("celimgMaskingImage"));
            };

            Controls.prototype.imgMaskingImage = function () {
                return new UZA.StaticImage(this.convFiledName("imgMaskingImage"));
            };

            Controls.prototype.btnBeforeImageTokkiJiko = function () {
                return new UZA.Button(this.convFiledName("btnBeforeImageTokkiJiko"));
            };

            Controls.prototype.lblImageCurrentHyojiNo = function () {
                return new UZA.Label(this.convFiledName("lblImageCurrentHyojiNo"));
            };

            Controls.prototype.lblImageMaxPerCurrent = function () {
                return new UZA.Label(this.convFiledName("lblImageMaxPerCurrent"));
            };

            Controls.prototype.lblImageTokkiNo = function () {
                return new UZA.Label(this.convFiledName("lblImageTokkiNo"));
            };

            Controls.prototype.btnImageMasking = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnImageMasking"));
            };

            Controls.prototype.btnAfterImageTokkiJiko = function () {
                return new UZA.Button(this.convFiledName("btnAfterImageTokkiJiko"));
            };

            Controls.prototype.btnSakujo = function () {
                return new UZA.Button(this.convFiledName("btnSakujo"));
            };

            Controls.prototype.btnHozon = function () {
                return new UZA.Button(this.convFiledName("btnHozon"));
            };
            return Controls;
        })();
        KihonChosaInput.Controls = Controls;
    })(DBZ.KihonChosaInput || (DBZ.KihonChosaInput = {}));
    var KihonChosaInput = DBZ.KihonChosaInput;
})(DBZ || (DBZ = {}));
