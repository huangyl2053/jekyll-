var DBZ;
(function (DBZ) {
    (function (SogoShokaiKagoMoushitateInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        SogoShokaiKagoMoushitateInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SogoShokaiKagoMoushitateInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SogoShokaiKagoMoushitateInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SogoShokaiKagoMoushitateInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SogoShokaiKagoMoushitateInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtKagoTaishoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKagoTaishoYM"));
            };

            Controls.prototype.txtKagoMoshitateYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKagoMoshitateYMD"));
            };

            Controls.prototype.txtKagoTeikyoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKagoTeikyoYM"));
            };

            Controls.prototype.txtKagoDogetsuKago = function () {
                return new UZA.TextBox(this.convFiledName("txtKagoDogetsuKago"));
            };

            Controls.prototype.txtKagoJigyoshaCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKagoJigyoshaCode"));
            };

            Controls.prototype.txtKagoJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtKagoJigyoshaName"));
            };

            Controls.prototype.SogoShokaiKagoMoshitateJiyu = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiKagoMoshitateJiyu"));
            };

            Controls.prototype.txtKagoMoshitateYoshiki = function () {
                return new UZA.TextBox(this.convFiledName("txtKagoMoshitateYoshiki"));
            };

            Controls.prototype.txtKagoMoshitateRiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtKagoMoshitateRiyu"));
            };

            Controls.prototype.SogoShokaiKagoMoshitateKekka = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiKagoMoshitateKekka"));
            };

            Controls.prototype.SogoShokaiKagoMoshitateHokensha = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiKagoMoshitateKekka_SogoShokaiKagoMoshitateHokensha"));
            };

            Controls.prototype.txtKagoHokenshaTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKagoHokenshaTanisu"));
            };

            Controls.prototype.txtKagoHokenshaFutangaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKagoHokenshaFutangaku"));
            };

            Controls.prototype.SogoShokaiKagoMoshitateKohi = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiKagoMoshitateKekka_SogoShokaiKagoMoshitateKohi"));
            };

            Controls.prototype.txtKagoKohiJukyushaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKagoKohiJukyushaNo"));
            };

            Controls.prototype.txtKagoKohiJukyushaName = function () {
                return new UZA.TextBox(this.convFiledName("txtKagoKohiJukyushaName"));
            };

            Controls.prototype.txtKagoKohiHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKagoKohiHokenshaNo"));
            };

            Controls.prototype.txtKagoKohiTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKagoKohiTanisu"));
            };

            Controls.prototype.txtKagoKohiFutangaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKagoKohiFutangaku"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        SogoShokaiKagoMoushitateInfo.Controls = Controls;
    })(DBZ.SogoShokaiKagoMoushitateInfo || (DBZ.SogoShokaiKagoMoushitateInfo = {}));
    var SogoShokaiKagoMoushitateInfo = DBZ.SogoShokaiKagoMoushitateInfo;
})(DBZ || (DBZ = {}));
