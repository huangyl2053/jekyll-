var DBZ;
(function (DBZ) {
    (function (JigyoshaNyuryokuGudieCommonChildDiv) {
        var Events = (function () {
            function Events() {
            }
            Events.onBlur_JigyoshaNo = function () {
                return "onBlur_JigyoshaNo";
            };

            Events.onChange_BtnKenCode = function () {
                return "onChange_BtnKenCode";
            };

            Events.search_Jigyosya = function () {
                return "search_Jigyosya";
            };

            Events.onclick_BtnClear = function () {
                return "onclick_BtnClear";
            };

            Events.close_Dialog = function () {
                return "close_Dialog";
            };

            Events.select_BtnSenTaKu = function () {
                return "select_BtnSenTaKu";
            };

            Events.select_BtnSilyuuseyi = function () {
                return "select_BtnSilyuuseyi";
            };

            Events.select_BtnSakujo = function () {
                return "select_BtnSakujo";
            };
            return Events;
        })();
        JigyoshaNyuryokuGudieCommonChildDiv.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JigyoshaNyuryokuGudieCommonChildDiv";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.JigyoshaNyuryokuGudieCommonChildDiv.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.JigyoshaNyuryokuGudieCommonChildDiv.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JigyoshaNyuryokuGudieCommonChildDiv = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.TaishoJigyoshaKensaku = function () {
                return new UZA.Panel(this.convFiledName("TaishoJigyoshaKensaku"));
            };

            Controls.prototype.KennsakuJyokenn = function () {
                return new UZA.Panel(this.convFiledName("KennsakuJyokenn"));
            };

            Controls.prototype.txtJIgyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJIgyoshaNo"));
            };

            Controls.prototype.txtYukouKaishibi = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtYukouKaishibi"));
            };

            Controls.prototype.txtJigyoshamei = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyoshamei"));
            };

            Controls.prototype.ddlKennsakuKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKennsakuKubun"));
            };

            Controls.prototype.txtYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            };

            Controls.prototype.txtJusho = function () {
                return new UZA.TextBoxJusho(this.convFiledName("txtJusho"));
            };

            Controls.prototype.ServiceJigyosha = function () {
                return new UZA.Panel(this.convFiledName("ServiceJigyosha"));
            };

            Controls.prototype.ddlKennCode = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKennCode"));
            };

            Controls.prototype.ddlJigyoshaKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlJigyoshaKubun"));
            };

            Controls.prototype.ddlGunshiCode = function () {
                return new UZA.DropDownList(this.convFiledName("ddlGunshiCode"));
            };

            Controls.prototype.ddlServiceShurui = function () {
                return new UZA.DropDownList(this.convFiledName("ddlServiceShurui"));
            };

            Controls.prototype.OtherTokureiShisetsu = function () {
                return new UZA.Panel(this.convFiledName("OtherTokureiShisetsu"));
            };

            Controls.prototype.radKannaiKanngaiKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radKannaiKanngaiKubun"));
            };

            Controls.prototype.txtMaxHyojiKensu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtMaxHyojiKensu"));
            };

            Controls.prototype.btnTaishoJigyoshaKensaku = function () {
                return new UZA.Button(this.convFiledName("btnTaishoJigyoshaKensaku"));
            };

            Controls.prototype.btnClear = function () {
                return new UZA.Button(this.convFiledName("btnClear"));
            };

            Controls.prototype.btnYameru = function () {
                return new UZA.Button(this.convFiledName("btnYameru"));
            };

            Controls.prototype.JigyoshaItirann = function () {
                return new UZA.Panel(this.convFiledName("JigyoshaItirann"));
            };

            Controls.prototype.dgJigyoshaItiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgJigyoshaItiran"));
            };
            return Controls;
        })();
        JigyoshaNyuryokuGudieCommonChildDiv.Controls = Controls;
    })(DBZ.JigyoshaNyuryokuGudieCommonChildDiv || (DBZ.JigyoshaNyuryokuGudieCommonChildDiv = {}));
    var JigyoshaNyuryokuGudieCommonChildDiv = DBZ.JigyoshaNyuryokuGudieCommonChildDiv;
})(DBZ || (DBZ = {}));
