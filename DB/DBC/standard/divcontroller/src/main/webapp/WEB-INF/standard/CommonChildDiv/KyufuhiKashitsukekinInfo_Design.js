var DBC;
(function (DBC) {
    (function (KyufuhiKashitsukekinInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        KyufuhiKashitsukekinInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KyufuhiKashitsukekinInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.KyufuhiKashitsukekinInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.KyufuhiKashitsukekinInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KyufuhiKashitsukekinInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.tabKashitsukekinInfo = function () {
                return new UZA.TabContainer(this.convFiledName("tabKashitsukekinInfo"));
            };

            Controls.prototype.tplKashitsukekinShinsei = function () {
                return new UZA.TabPanel(this.convFiledName("tplKashitsukekinShinsei"));
            };

            Controls.prototype.txtShinseiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiYMD"));
            };

            Controls.prototype.txtRiyoKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtRiyoKikan"));
            };

            Controls.prototype.txtSeikyugaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSeikyugaku"));
            };

            Controls.prototype.txtShinseiKingaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShinseiKingaku"));
            };

            Controls.prototype.KashitsukeShinseiService = function () {
                return new UZA.Panel(this.convFiledName("KashitsukeShinseiService"));
            };

            Controls.prototype.txtService1 = function () {
                return new UZA.TextBox(this.convFiledName("txtService1"));
            };

            Controls.prototype.txtService2 = function () {
                return new UZA.TextBox(this.convFiledName("txtService2"));
            };

            Controls.prototype.txtService3 = function () {
                return new UZA.TextBox(this.convFiledName("txtService3"));
            };

            Controls.prototype.txtService4 = function () {
                return new UZA.TextBox(this.convFiledName("txtService4"));
            };

            Controls.prototype.KashitsukeShinseisha = function () {
                return new UZA.Panel(this.convFiledName("KashitsukeShinseisha"));
            };

            Controls.prototype.txtShinseishaName = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseishaName"));
            };

            Controls.prototype.txtShinseishaKana = function () {
                return new UZA.TextBoxKana(this.convFiledName("txtShinseishaKana"));
            };

            Controls.prototype.txtShinseishaKankei = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseishaKankei"));
            };

            Controls.prototype.txtShinseishaYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtShinseishaYubinNo"));
            };

            Controls.prototype.txtShinseishaTelNo = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseishaTelNo"));
            };

            Controls.prototype.txtShinseishaJusho = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseishaJusho"));
            };

            Controls.prototype.KashitsukeShinseiHoshonin = function () {
                return new UZA.Panel(this.convFiledName("KashitsukeShinseiHoshonin"));
            };

            Controls.prototype.txtHoshoninName = function () {
                return new UZA.TextBox(this.convFiledName("txtHoshoninName"));
            };

            Controls.prototype.txtHoshoninSeiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtHoshoninSeiYMD"));
            };

            Controls.prototype.txtHoshoninSeibetsu = function () {
                return new UZA.TextBox(this.convFiledName("txtHoshoninSeibetsu"));
            };

            Controls.prototype.txtHoshoninKana = function () {
                return new UZA.TextBoxKana(this.convFiledName("txtHoshoninKana"));
            };

            Controls.prototype.txtHoshoninKankei = function () {
                return new UZA.TextBox(this.convFiledName("txtHoshoninKankei"));
            };

            Controls.prototype.txtHoshoninYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtHoshoninYubinNo"));
            };

            Controls.prototype.txtHoshoninTelNo = function () {
                return new UZA.TextBox(this.convFiledName("txtHoshoninTelNo"));
            };

            Controls.prototype.txtHoshoninJusho = function () {
                return new UZA.TextBox(this.convFiledName("txtHoshoninJusho"));
            };

            Controls.prototype.KashitsukeShinseiHoshoninKinmu = function () {
                return new UZA.Panel(this.convFiledName("KashitsukeShinseiHoshonin_KashitsukeShinseiHoshoninKinmu"));
            };

            Controls.prototype.txtHoshoninKinmuName = function () {
                return new UZA.TextBox(this.convFiledName("txtHoshoninKinmuName"));
            };

            Controls.prototype.txtHoshoninKinmuTelNo = function () {
                return new UZA.TextBox(this.convFiledName("txtHoshoninKinmuTelNo"));
            };

            Controls.prototype.txtHoshoninKinmuJusho = function () {
                return new UZA.TextBox(this.convFiledName("txtHoshoninKinmuJusho"));
            };

            Controls.prototype.KashitsukeShinseiTeishutsu = function () {
                return new UZA.Panel(this.convFiledName("KashitsukeShinseiTeishutsu"));
            };

            Controls.prototype.txtSeikyuRyoshusho = function () {
                return new UZA.TextBox(this.convFiledName("txtSeikyuRyoshusho"));
            };

            Controls.prototype.txtTeishutsuKanriNo = function () {
                return new UZA.TextBox(this.convFiledName("txtTeishutsuKanriNo"));
            };

            Controls.prototype.tplKashitsukekinKettei = function () {
                return new UZA.TabPanel(this.convFiledName("tplKashitsukekinKettei"));
            };

            Controls.prototype.txtKetteiShoninKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtKetteiShoninKubun"));
            };

            Controls.prototype.txtKetteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKetteiYMD"));
            };

            Controls.prototype.KashitsukekinKetteiShonin = function () {
                return new UZA.Panel(this.convFiledName("KashitsukekinKetteiShonin"));
            };

            Controls.prototype.txtShoninKanriNo = function () {
                return new UZA.TextBox(this.convFiledName("txtShoninKanriNo"));
            };

            Controls.prototype.txtKashitsukeKingaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKashitsukeKingaku"));
            };

            Controls.prototype.txtKashitsukeYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKashitsukeYMD"));
            };

            Controls.prototype.txtHenkanHoho = function () {
                return new UZA.TextBox(this.convFiledName("txtHenkanHoho"));
            };

            Controls.prototype.txtShokanKigen = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShokanKigen"));
            };

            Controls.prototype.txtShiharaiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtShiharaiKubun"));
            };

            Controls.prototype.KashitsukekinKetteiShiharai = function () {
                return new UZA.Panel(this.convFiledName("KashitsukekinKetteiShonin_KashitsukekinKetteiShiharai"));
            };

            Controls.prototype.KashitsukekinKetteiMado = function () {
                return new UZA.Panel(this.convFiledName("KashitsukekinKetteiShonin_KashitsukekinKetteiShiharai_KashitsukekinKetteiMado"));
            };

            Controls.prototype.txtShiharaiBasho = function () {
                return new UZA.TextBox(this.convFiledName("txtShiharaiBasho"));
            };

            Controls.prototype.txtKaishiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKaishiYMD"));
            };

            Controls.prototype.txtKaishiH = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKaishiH"));
            };

            Controls.prototype.txtKaishiM = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKaishiM"));
            };

            Controls.prototype.txtShuryoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShuryoYMD"));
            };

            Controls.prototype.txtShuryoH = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShuryoH"));
            };

            Controls.prototype.txtShuryoM = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShuryoM"));
            };

            Controls.prototype.KashitsukekinKetteiKoza = function () {
                return new UZA.Panel(this.convFiledName("KashitsukekinKetteiShonin_KashitsukekinKetteiShiharai_KashitsukekinKetteiKoza"));
            };

            Controls.prototype.txtKinyuKikanCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKinyuKikanCode"));
            };

            Controls.prototype.txtKinyuKikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtKinyuKikanName"));
            };

            Controls.prototype.txtKozaShubetsu = function () {
                return new UZA.TextBox(this.convFiledName("txtKozaShubetsu"));
            };

            Controls.prototype.txtMeigininName = function () {
                return new UZA.TextBoxKana(this.convFiledName("txtMeigininName"));
            };

            Controls.prototype.txtShitenCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShitenCode"));
            };

            Controls.prototype.txtShitenName = function () {
                return new UZA.TextBox(this.convFiledName("txtShitenName"));
            };

            Controls.prototype.txtKozaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKozaNo"));
            };

            Controls.prototype.txtMeigininKana = function () {
                return new UZA.TextBoxKana(this.convFiledName("txtMeigininKana"));
            };

            Controls.prototype.txtKetteiFushoninRiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtKetteiFushoninRiyu"));
            };

            Controls.prototype.tplKashitsukekinKariuke = function () {
                return new UZA.TabPanel(this.convFiledName("tplKashitsukekinKariuke"));
            };

            Controls.prototype.txtKariukeYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKariukeYMD"));
            };

            Controls.prototype.KashitsukekinKariukenin = function () {
                return new UZA.Panel(this.convFiledName("KashitsukekinKariukenin"));
            };

            Controls.prototype.txtKariukeninName = function () {
                return new UZA.TextBox(this.convFiledName("txtKariukeninName"));
            };

            Controls.prototype.txtKariukeninKana = function () {
                return new UZA.TextBoxKana(this.convFiledName("txtKariukeninKana"));
            };

            Controls.prototype.txtKariukeninYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtKariukeninYubinNo"));
            };

            Controls.prototype.txtKariukeninTelNo = function () {
                return new UZA.TextBox(this.convFiledName("txtKariukeninTelNo"));
            };

            Controls.prototype.txtKariukeninJusho = function () {
                return new UZA.TextBox(this.convFiledName("txtKariukeninJusho"));
            };

            Controls.prototype.KashitsukekinKariukeHosho = function () {
                return new UZA.Panel(this.convFiledName("KashitsukekinKariukeHosho"));
            };

            Controls.prototype.txtKariukeHoshoName = function () {
                return new UZA.TextBox(this.convFiledName("txtKariukeHoshoName"));
            };

            Controls.prototype.txtKariukeHoshoKana = function () {
                return new UZA.TextBoxKana(this.convFiledName("txtKariukeHoshoKana"));
            };

            Controls.prototype.txtKariukeHoshoYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtKariukeHoshoYubinNo"));
            };

            Controls.prototype.txtKariukeHoshoTelNo = function () {
                return new UZA.TextBox(this.convFiledName("txtKariukeHoshoTelNo"));
            };

            Controls.prototype.txtKariukeHoshoJusho = function () {
                return new UZA.TextBox(this.convFiledName("txtKariukeHoshoJusho"));
            };

            Controls.prototype.tplKashitsukekinHenko = function () {
                return new UZA.TabPanel(this.convFiledName("tplKashitsukekinHenko"));
            };

            Controls.prototype.txtEnchoShinseiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtEnchoShinseiYMD"));
            };

            Controls.prototype.txtEnchoKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtEnchoKikan"));
            };

            Controls.prototype.txtMishokanKingaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtMishokanKingaku"));
            };

            Controls.prototype.txtEnchoRiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtEnchoRiyu"));
            };

            Controls.prototype.KashitsukekinHenkoKariuke = function () {
                return new UZA.Panel(this.convFiledName("KashitsukekinHenkoKariuke"));
            };

            Controls.prototype.txtHenkoKariukeninName = function () {
                return new UZA.TextBox(this.convFiledName("txtHenkoKariukeninName"));
            };

            Controls.prototype.txtHenkoKariukeninKana = function () {
                return new UZA.TextBoxKana(this.convFiledName("txtHenkoKariukeninKana"));
            };

            Controls.prototype.txtHenkoKariukeninYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtHenkoKariukeninYubinNo"));
            };

            Controls.prototype.txtHenkoKariukeninTelNo = function () {
                return new UZA.TextBox(this.convFiledName("txtHenkoKariukeninTelNo"));
            };

            Controls.prototype.txtHenkoKariukeninJusho = function () {
                return new UZA.TextBox(this.convFiledName("txtHenkoKariukeninJusho"));
            };

            Controls.prototype.KashitsukekinHenkoKettei = function () {
                return new UZA.Panel(this.convFiledName("KashitsukekinHenkoKettei"));
            };

            Controls.prototype.txtHenkoShoninKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtHenkoShoninKubun"));
            };

            Controls.prototype.txtHenkogoKigen = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtHenkogoKigen"));
            };

            Controls.prototype.txtHenkoKetteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtHenkoKetteiYMD"));
            };

            Controls.prototype.txtHenkoFushoninRiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtHenkoFushoninRiyu"));
            };

            Controls.prototype.tplKashitsukekinKoza = function () {
                return new UZA.TabPanel(this.convFiledName("tplKashitsukekinKoza"));
            };

            Controls.prototype.txtKojinKinyuKikanCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKojinKinyuKikanCode"));
            };

            Controls.prototype.txtKojinKinyuKikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtKojinKinyuKikanName"));
            };

            Controls.prototype.txtKojinKozaShubetsu = function () {
                return new UZA.TextBox(this.convFiledName("txtKojinKozaShubetsu"));
            };

            Controls.prototype.txtKojinMeigininName = function () {
                return new UZA.TextBoxKana(this.convFiledName("txtKojinMeigininName"));
            };

            Controls.prototype.txtKojinShitenCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKojinShitenCode"));
            };

            Controls.prototype.txtKojinShitenName = function () {
                return new UZA.TextBox(this.convFiledName("txtKojinShitenName"));
            };

            Controls.prototype.txtKojinKozaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKojinKozaNo"));
            };

            Controls.prototype.txtKojinMeigininKana = function () {
                return new UZA.TextBoxKana(this.convFiledName("txtKojinMeigininKana"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        KyufuhiKashitsukekinInfo.Controls = Controls;
    })(DBC.KyufuhiKashitsukekinInfo || (DBC.KyufuhiKashitsukekinInfo = {}));
    var KyufuhiKashitsukekinInfo = DBC.KyufuhiKashitsukekinInfo;
})(DBC || (DBC = {}));
