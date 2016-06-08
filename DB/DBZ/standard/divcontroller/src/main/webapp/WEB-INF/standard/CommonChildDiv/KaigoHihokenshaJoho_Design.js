var DBE;
(function (DBE) {
    (function (KaigoHihokenshaJoho) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoHihokenshaJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoHihokenshaJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.KaigoHihokenshaJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.KaigoHihokenshaJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoHihokenshaJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtHokenshaNo = function () {
                return new UZA.TextBox(this.convFiledName("txtHokenshaNo"));
            };

            Controls.prototype.txtHokenshaMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtHokenshaMeisho"));
            };

            Controls.prototype.txtHihokenshaNo = function () {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaNo"));
            };

            Controls.prototype.txtHihokenshaShimei = function () {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaShimei"));
            };

            Controls.prototype.txtHihokenshaKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaKubun"));
            };

            Controls.prototype.txtBirthDay = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtBirthDay"));
            };

            Controls.prototype.txtNenrei = function () {
                return new UZA.TextBox(this.convFiledName("txtNenrei"));
            };

            Controls.prototype.btnShichosonRenraku = function () {
                return new UZA.Button(this.convFiledName("btnShichosonRenraku"));
            };

            Controls.prototype.txtNinteiShinseiYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNinteiShinseiYMD"));
            };

            Controls.prototype.txtShinseiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseiKubun"));
            };

            Controls.prototype.txtZenkaiYokaigodo = function () {
                return new UZA.TextBox(this.convFiledName("txtZenkaiYokaigodo"));
            };

            Controls.prototype.txtZenYukokikanStart = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtZenYukokikanStart"));
            };

            Controls.prototype.lblKara2 = function () {
                return new UZA.Label(this.convFiledName("lblKara2"));
            };

            Controls.prototype.txtZenYukokikanEnd = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtZenYukokikanEnd"));
            };

            Controls.prototype.btnRenrakusaki = function () {
                return new UZA.Button(this.convFiledName("btnRenrakusaki"));
            };
            return Controls;
        })();
        KaigoHihokenshaJoho.Controls = Controls;
    })(DBE.KaigoHihokenshaJoho || (DBE.KaigoHihokenshaJoho = {}));
    var KaigoHihokenshaJoho = DBE.KaigoHihokenshaJoho;
})(DBE || (DBE = {}));
