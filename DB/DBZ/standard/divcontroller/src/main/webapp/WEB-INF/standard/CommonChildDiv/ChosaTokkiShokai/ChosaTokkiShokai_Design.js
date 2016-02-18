var DBZ;
(function (DBZ) {
    (function (ChosaTokkiShokai) {
        var Events = (function () {
            function Events() {
            }
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

            Controls.prototype.TokkiJiko = function () {
                return new UZA.Panel(this.convFiledName("TokkiJiko"));
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

            Controls.prototype.txtTokkiJikouNo = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkiJikouNo"));
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

            Controls.prototype.txtTokkiJikouName = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkiJikouName"));
            };

            Controls.prototype.celTokkijikoInput = function () {
                return new UZA.TableCell(this.convFiledName("celTokkijikoInput"));
            };

            Controls.prototype.txtTokkijikoInputGenpo = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTokkijikoInputGenpo"));
            };

            Controls.prototype.txtTokkijikoInputMasking = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTokkijikoInputMasking"));
            };

            Controls.prototype.btnBeforeTextTokkiJiko = function () {
                return new UZA.Button(this.convFiledName("btnBeforeTextTokkiJiko"));
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

            Controls.prototype.txtTokkiJikouNoImage = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkiJikouNoImage"));
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

            Controls.prototype.txtTokkiJikouNameImage = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkiJikouNameImage"));
            };

            Controls.prototype.celimgMaskingImage = function () {
                return new UZA.TableCell(this.convFiledName("celimgMaskingImage"));
            };

            Controls.prototype.imgGenpoImage = function () {
                return new UZA.StaticImage(this.convFiledName("imgGenpoImage"));
            };

            Controls.prototype.imgMaskingImage = function () {
                return new UZA.StaticImage(this.convFiledName("imgMaskingImage"));
            };

            Controls.prototype.btnBeforeImageTokkiJiko = function () {
                return new UZA.Button(this.convFiledName("btnBeforeImageTokkiJiko"));
            };

            Controls.prototype.btnAfterImageTokkiJiko = function () {
                return new UZA.Button(this.convFiledName("btnAfterImageTokkiJiko"));
            };

            Controls.prototype.btnSakujo = function () {
                return new UZA.Button(this.convFiledName("btnSakujo"));
            };
            return Controls;
        })();
        ChosaTokkiShokai.Controls = Controls;
    })(DBZ.ChosaTokkiShokai || (DBZ.ChosaTokkiShokai = {}));
    var ChosaTokkiShokai = DBZ.ChosaTokkiShokai;
})(DBZ || (DBZ = {}));
