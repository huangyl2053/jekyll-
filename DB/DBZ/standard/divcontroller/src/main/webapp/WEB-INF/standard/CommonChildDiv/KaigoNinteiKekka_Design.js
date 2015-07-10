var DBE;
(function (DBE) {
    (function (KaigoNinteiKekka) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoNinteiKekka.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoNinteiKekka";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.KaigoNinteiKekka.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.KaigoNinteiKekka.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoNinteiKekka = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtShinseibi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseibi"));
            };

            Controls.prototype.txtShinseiKubunShinsei = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseiKubunShinsei"));
            };

            Controls.prototype.txtShinseiKubunHorei = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseiKubunHorei"));
            };

            Controls.prototype.txtShinsaJun = function () {
                return new UZA.TextBox(this.convFiledName("txtShinsaJun"));
            };

            Controls.prototype.ddlNinteiKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlNinteiKubun"));
            };

            Controls.prototype.txtIchijiHanteiKekka = function () {
                return new UZA.TextBox(this.convFiledName("txtIchijiHanteiKekka"));
            };

            Controls.prototype.ddlTokuteiShippei = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTokuteiShippei"));
            };

            Controls.prototype.txtNinteibi = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteibi"));
            };

            Controls.prototype.ddlNijiHanteiKekka = function () {
                return new UZA.DropDownList(this.convFiledName("ddlNijiHanteiKekka"));
            };

            Controls.prototype.ddlJotaiZo = function () {
                return new UZA.DropDownList(this.convFiledName("ddlJotaiZo"));
            };

            Controls.prototype.txtNinteiYukoKikanStart = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiYukoKikanStart"));
            };

            Controls.prototype.lblKara3 = function () {
                return new UZA.Label(this.convFiledName("lblKara3"));
            };

            Controls.prototype.txtNinteiYukoKikanEnd = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiYukoKikanEnd"));
            };

            Controls.prototype.ddlNinteiYukoTsukisu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlNinteiYukoTsukisu"));
            };

            Controls.prototype.lblShinsakaiIken = function () {
                return new UZA.Label(this.convFiledName("lblShinsakaiIken"));
            };

            Controls.prototype.btnShinsaIkenTeikei = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShinsaIkenTeikei"));
            };

            Controls.prototype.lblShinsakaiMemo = function () {
                return new UZA.Label(this.convFiledName("lblShinsakaiMemo"));
            };

            Controls.prototype.txtShinsakaiIken = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinsakaiIken"));
            };

            Controls.prototype.txtShinsakaiMemo = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinsakaiMemo"));
            };
            return Controls;
        })();
        KaigoNinteiKekka.Controls = Controls;
    })(DBE.KaigoNinteiKekka || (DBE.KaigoNinteiKekka = {}));
    var KaigoNinteiKekka = DBE.KaigoNinteiKekka;
})(DBE || (DBE = {}));
