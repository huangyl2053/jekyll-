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

            Controls.prototype.TestTokki = function () {
                return new UZA.Panel(this.convFiledName("TestTokki"));
            };

            Controls.prototype.lblTextTokkiJikoTitle = function () {
                return new UZA.Label(this.convFiledName("lblTextTokkiJikoTitle"));
            };

            Controls.prototype.txtTokkiJikouNo = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkiJikouNo"));
            };

            Controls.prototype.lblTextTokkiJikoHyphen = function () {
                return new UZA.Label(this.convFiledName("lblTextTokkiJikoHyphen"));
            };

            Controls.prototype.txtTokkiJikoNoText = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTokkiJikoNoText"));
            };

            Controls.prototype.txtTokkiJikouName = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkiJikouName"));
            };

            Controls.prototype.txtTokkijikoInputGenpo = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTokkijikoInputGenpo"));
            };

            Controls.prototype.txtTokkijikoInputMask = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTokkijikoInputMask"));
            };

            Controls.prototype.btnBeforeTextTokkiJiko = function () {
                return new UZA.Button(this.convFiledName("btnBeforeTextTokkiJiko"));
            };

            Controls.prototype.btnAfterTextTokkiJiko = function () {
                return new UZA.Button(this.convFiledName("btnAfterTextTokkiJiko"));
            };

            Controls.prototype.lblImageTokkiJikoTitle = function () {
                return new UZA.Label(this.convFiledName("lblImageTokkiJikoTitle"));
            };

            Controls.prototype.ImageTokki = function () {
                return new UZA.Panel(this.convFiledName("ImageTokki"));
            };

            Controls.prototype.txtTokkiJikouNoImage = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkiJikouNoImage"));
            };

            Controls.prototype.lblTokkiJikoHyphenImage = function () {
                return new UZA.Label(this.convFiledName("lblTokkiJikoHyphenImage"));
            };

            Controls.prototype.txtTokkiJikoNoImage = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTokkiJikoNoImage"));
            };

            Controls.prototype.txtTokkiJikouNameImage = function () {
                return new UZA.TextBox(this.convFiledName("txtTokkiJikouNameImage"));
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

            Controls.prototype.btnReturn = function () {
                return new UZA.Button(this.convFiledName("btnReturn"));
            };
            return Controls;
        })();
        ChosaTokkiShokai.Controls = Controls;
    })(DBZ.ChosaTokkiShokai || (DBZ.ChosaTokkiShokai = {}));
    var ChosaTokkiShokai = DBZ.ChosaTokkiShokai;
})(DBZ || (DBZ = {}));
