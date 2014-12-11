var DBZ;
(function (DBZ) {
    (function (SogoShokaiSaishinsaMoushitateInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        SogoShokaiSaishinsaMoushitateInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SogoShokaiSaishinsaMoushitateInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SogoShokaiSaishinsaMoushitateInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SogoShokaiSaishinsaMoushitateInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SogoShokaiSaishinsaMoushitateInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtSaishinsaTaishoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSaishinsaTaishoYM"));
            };

            Controls.prototype.txtSaishinsaMoshitateYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSaishinsaMoshitateYMD"));
            };

            Controls.prototype.txtSaishinsaTeikyoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSaishinsaTeikyoYM"));
            };

            Controls.prototype.txtSaishinsaJigyoshaCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtSaishinsaJigyoshaCode"));
            };

            Controls.prototype.txtSaishinsaJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtSaishinsaJigyoshaName"));
            };

            Controls.prototype.txtSaishinsaServiceShuruiCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtSaishinsaServiceShuruiCode"));
            };

            Controls.prototype.txtSaishinsaServiceCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtSaishinsaServiceCode"));
            };

            Controls.prototype.txtSaishinsaServiceName = function () {
                return new UZA.TextBox(this.convFiledName("txtSaishinsaServiceName"));
            };

            Controls.prototype.txtSaishinsaMoshitateTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaMoshitateTanisu"));
            };

            Controls.prototype.SogoShokaiSaishinsaJiyu = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiSaishinsaJiyu"));
            };

            Controls.prototype.txtSaishinsaMoshitateKomoku = function () {
                return new UZA.TextBox(this.convFiledName("txtSaishinsaMoshitateKomoku"));
            };

            Controls.prototype.txtSaishinsaMoshitateRiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtSaishinsaMoshitateRiyu"));
            };

            Controls.prototype.SogoShokaiSaishinsaKekka = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiSaishinsaKekka"));
            };

            Controls.prototype.SogoShokaiSaishinsaHokensha = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiSaishinsaKekka_SogoShokaiSaishinsaHokensha"));
            };

            Controls.prototype.txtSaishinsaHokenshaKekka = function () {
                return new UZA.TextBox(this.convFiledName("txtSaishinsaHokenshaKekka"));
            };

            Controls.prototype.txtSaishinsaHokenshaToshoTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaHokenshaToshoTanisu"));
            };

            Controls.prototype.txtSaishinsaHokenshaGenshinTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaHokenshaGenshinTanisu"));
            };

            Controls.prototype.txtSaishinsaHokenshaMoshitateTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaHokenshaMoshitateTanisu"));
            };

            Controls.prototype.txtSaishinsaHokenshaKetteiTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaHokenshaKetteiTanisu"));
            };

            Controls.prototype.txtSaishinsaHokenshaChoseiTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaHokenshaChoseiTanisu"));
            };

            Controls.prototype.txtSaishinsaHokenshaFutangaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaHokenshaFutangaku"));
            };

            Controls.prototype.SogoShokaiSaishinsaKohi = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiSaishinsaKekka_SogoShokaiSaishinsaKohi"));
            };

            Controls.prototype.txtSaishinsaKohiJukyushaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtSaishinsaKohiJukyushaNo"));
            };

            Controls.prototype.txtSaishinsaKohiJukyushaName = function () {
                return new UZA.TextBox(this.convFiledName("txtSaishinsaKohiJukyushaName"));
            };

            Controls.prototype.txtSaishinsaKohiHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtSaishinsaKohiHokenshaNo"));
            };

            Controls.prototype.txtSaishinsaKohiKekka = function () {
                return new UZA.TextBox(this.convFiledName("txtSaishinsaKohiKekka"));
            };

            Controls.prototype.txtSaishinsaKohiToshoTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaKohiToshoTanisu"));
            };

            Controls.prototype.txtSaishinsaKohiGenshinTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaKohiGenshinTanisu"));
            };

            Controls.prototype.txtSaishinsaKohiMoshitateTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaKohiMoshitateTanisu"));
            };

            Controls.prototype.txtSaishinsaKohiKetteiTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaKohiKetteiTanisu"));
            };

            Controls.prototype.txtSaishinsaKohiChoseiTanisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaKohiChoseiTanisu"));
            };

            Controls.prototype.txtSaishinsaKohiFutangaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaishinsaKohiFutangaku"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        SogoShokaiSaishinsaMoushitateInfo.Controls = Controls;
    })(DBZ.SogoShokaiSaishinsaMoushitateInfo || (DBZ.SogoShokaiSaishinsaMoushitateInfo = {}));
    var SogoShokaiSaishinsaMoushitateInfo = DBZ.SogoShokaiSaishinsaMoushitateInfo;
})(DBZ || (DBZ = {}));
