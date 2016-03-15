var DBZ;
(function (DBZ) {
    (function (KaigoNinteiAtenaInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onOkClose_btnSearchShiki = function () {
                return "onOkClose_btnSearchShiki";
            };

            Events.onBeforeOpenDialog_btnSearchShiki = function () {
                return "onBeforeOpenDialog_btnSearchShiki";
            };

            Events.onOkClose_btnSearchSetai = function () {
                return "onOkClose_btnSearchSetai";
            };

            Events.onBeforeOpenDialog_btnSearchSetai = function () {
                return "onBeforeOpenDialog_btnSearchSetai";
            };
            return Events;
        })();
        KaigoNinteiAtenaInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoNinteiAtenaInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoNinteiAtenaInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoNinteiAtenaInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoNinteiAtenaInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtShimei = function () {
                return new UZA.TextBox(this.convFiledName("txtShimei"));
            };

            Controls.prototype.txtBirthYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtBirthYMD"));
            };

            Controls.prototype.txtNenrei = function () {
                return new UZA.TextBox(this.convFiledName("txtNenrei"));
            };

            Controls.prototype.txtSeibetsu = function () {
                return new UZA.TextBox(this.convFiledName("txtSeibetsu"));
            };

            Controls.prototype.imgJuminShubetsu = function () {
                return new UZA.StaticImage(this.convFiledName("imgJuminShubetsu"));
            };

            Controls.prototype.txtJuminShubetsu = function () {
                return new UZA.TextBox(this.convFiledName("txtJuminShubetsu"));
            };

            Controls.prototype.txtShikiBetsuCode = function () {
                return new UZA.TextBox(this.convFiledName("txtShikiBetsuCode"));
            };

            Controls.prototype.btnKojinMemo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKojinMemo"));
            };

            Controls.prototype.txtSetaiCode = function () {
                return new UZA.TextBoxSetaiCode(this.convFiledName("txtSetaiCode"));
            };

            Controls.prototype.btnSetaiMemo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnSetaiMemo"));
            };

            Controls.prototype.txtKojinNo = function () {
                return new UZA.TextBox(this.convFiledName("txtKojinNo"));
            };

            Controls.prototype.imgYubinNo = function () {
                return new UZA.StaticImage(this.convFiledName("imgYubinNo"));
            };

            Controls.prototype.txtYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            };

            Controls.prototype.txtJusho = function () {
                return new UZA.TextBoxJusho(this.convFiledName("txtJusho"));
            };

            Controls.prototype.txtTelNo = function () {
                return new UZA.TextBoxTelNo(this.convFiledName("txtTelNo"));
            };

            Controls.prototype.txtGyoseiku = function () {
                return new UZA.TextBox(this.convFiledName("txtGyoseiku"));
            };
            return Controls;
        })();
        KaigoNinteiAtenaInfo.Controls = Controls;
    })(DBZ.KaigoNinteiAtenaInfo || (DBZ.KaigoNinteiAtenaInfo = {}));
    var KaigoNinteiAtenaInfo = DBZ.KaigoNinteiAtenaInfo;
})(DBZ || (DBZ = {}));
