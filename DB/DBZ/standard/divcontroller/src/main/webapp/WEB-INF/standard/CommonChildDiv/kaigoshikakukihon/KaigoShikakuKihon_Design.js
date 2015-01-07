var DBZ;
(function (DBZ) {
    (function (KaigoShikakuKihon) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoShikakuKihon.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoShikakuKihon";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoShikakuKihon.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoShikakuKihon.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoShikakuKihon = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtHihokenshaNo = function () {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaNo"));
            };

            Controls.prototype.txtShutokuYmd = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShutokuYmd"));
            };

            Controls.prototype.txtShutokuJiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtShutokuJiyu"));
            };

            Controls.prototype.txtSoshitsuYmd = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtSoshitsuYmd"));
            };

            Controls.prototype.txtSoshitsuJiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtSoshitsuJiyu"));
            };

            Controls.prototype.txtJutokuKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtJutokuKubun"));
            };

            Controls.prototype.txtYokaigoJotaiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtYokaigoJotaiKubun"));
            };

            Controls.prototype.txtNinteiKaishiYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiKaishiYmd"));
            };

            Controls.prototype.txtNinteiShuryoYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNinteiShuryoYmd"));
            };

            Controls.prototype.btnNinteiRireki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnNinteiRireki"));
            };

            Controls.prototype.btnHihoRireki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHihoRireki"));
            };

            Controls.prototype.btnRenrakusaki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnRenrakusaki"));
            };
            return Controls;
        })();
        KaigoShikakuKihon.Controls = Controls;
    })(DBZ.KaigoShikakuKihon || (DBZ.KaigoShikakuKihon = {}));
    var KaigoShikakuKihon = DBZ.KaigoShikakuKihon;
})(DBZ || (DBZ = {}));
