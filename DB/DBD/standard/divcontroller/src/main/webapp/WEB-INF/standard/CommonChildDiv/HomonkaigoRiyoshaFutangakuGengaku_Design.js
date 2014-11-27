var DBD;
(function (DBD) {
    (function (HomonkaigoRiyoshaFutangakuGengaku) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelect_dgHomonkaigoRiyoshaFutangakuGengakuList = function () {
                return "onSelect_dgHomonkaigoRiyoshaFutangakuGengakuList";
            };

            Events.CloseOK = function () {
                return "CloseOK";
            };
            return Events;
        })();
        HomonkaigoRiyoshaFutangakuGengaku.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "HomonkaigoRiyoshaFutangakuGengaku";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.HomonkaigoRiyoshaFutangakuGengaku.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.HomonkaigoRiyoshaFutangakuGengaku.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.HomonkaigoRiyoshaFutangakuGengaku = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtHiddenHihokenshaNo = function () {
                return new UZA.TextBox(this.convFiledName("txtHiddenHihokenshaNo"));
            };

            Controls.prototype.dgHomonkaigoRiyoshaFutangakuGengakuList = function () {
                return new UZA.DataGrid(this.convFiledName("dgHomonkaigoRiyoshaFutangakuGengakuList"));
            };

            Controls.prototype.HomonkaigoRiyoshaFutangakuGengakuDetail = function () {
                return new UZA.Panel(this.convFiledName("HomonkaigoRiyoshaFutangakuGengakuDetail"));
            };

            Controls.prototype.HomonkaigoRiyoshaFutangakuGengakuShinsei = function () {
                return new UZA.Panel(this.convFiledName("HomonkaigoRiyoshaFutangakuGengakuDetail_HomonkaigoRiyoshaFutangakuGengakuShinsei"));
            };

            Controls.prototype.txtShinseiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiDate"));
            };

            Controls.prototype.txtHobetsuKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtHobetsuKubun"));
            };

            Controls.prototype.txtShinseiRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinseiRiyu"));
            };

            Controls.prototype.ShogaishaTecho = function () {
                return new UZA.Panel(this.convFiledName("HomonkaigoRiyoshaFutangakuGengakuDetail_ShogaishaTecho"));
            };

            Controls.prototype.txtHasShogaishaTecho = function () {
                return new UZA.TextBox(this.convFiledName("txtHasShogaishaTecho"));
            };

            Controls.prototype.txtShogaishaTechoTokyu = function () {
                return new UZA.TextBox(this.convFiledName("txtShogaishaTechoTokyu"));
            };

            Controls.prototype.txtShogaishaTechoNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShogaishaTechoNo"));
            };

            Controls.prototype.HomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan = function () {
                return new UZA.Panel(this.convFiledName("HomonkaigoRiyoshaFutangakuGengakuDetail_HomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan"));
            };

            Controls.prototype.txtKetteiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKetteiDate"));
            };

            Controls.prototype.txtKetteiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtKetteiKubun"));
            };

            Controls.prototype.txtTekiyoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTekiyoDate"));
            };

            Controls.prototype.txtYukokigenDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYukokigenDate"));
            };

            Controls.prototype.txtKyufuRitsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKyufuRitsu"));
            };

            Controls.prototype.txtFushoninRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtFushoninRiyu"));
            };

            Controls.prototype.txtKohiFutanshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKohiFutanshaNo"));
            };

            Controls.prototype.txtKohiJukyushaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKohiJukyushaNo"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        HomonkaigoRiyoshaFutangakuGengaku.Controls = Controls;
    })(DBD.HomonkaigoRiyoshaFutangakuGengaku || (DBD.HomonkaigoRiyoshaFutangakuGengaku = {}));
    var HomonkaigoRiyoshaFutangakuGengaku = DBD.HomonkaigoRiyoshaFutangakuGengaku;
})(DBD || (DBD = {}));
