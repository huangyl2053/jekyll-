var DBD;
(function (DBD) {
    (function (KyotakuServiceKeikakuIchiran) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_select = function () {
                return "onClick_select";
            };

            Events.CloseOK = function () {
                return "CloseOK";
            };

            Events.onClick_btnKeikakuIraiUketsuke = function () {
                return "onClick_btnKeikakuIraiUketsuke";
            };

            Events.onClick_btnJikosakuseiKeikaku = function () {
                return "onClick_btnJikosakuseiKeikaku";
            };

            Events.onClick_btnKyotakuService = function () {
                return "onClick_btnKyotakuService";
            };

            Events.onClickClose_keikakuIraiUketsuke = function () {
                return "onClickClose_keikakuIraiUketsuke";
            };

            Events.onClickClose_jikosakuseiKeikaku = function () {
                return "onClickClose_jikosakuseiKeikaku";
            };

            Events.onClick_btnShuruiGendoGakuKakunin = function () {
                return "onClick_btnShuruiGendoGakuKakunin";
            };

            Events.onSelect_dgKyotakuService = function () {
                return "onSelect_dgKyotakuService";
            };

            Events.onClickClose_kyotakuServiceJoho = function () {
                return "onClickClose_kyotakuServiceJoho";
            };

            Events.onClickClose_kyotakuServiceMeisai = function () {
                return "onClickClose_kyotakuServiceMeisai";
            };

            Events.onClickClose_shuruiGendoGakuKakunin = function () {
                return "onClickClose_shuruiGendoGakuKakunin";
            };
            return Events;
        })();
        KyotakuServiceKeikakuIchiran.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KyotakuServiceKeikakuIchiran";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.KyotakuServiceKeikakuIchiran.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.KyotakuServiceKeikakuIchiran.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KyotakuServiceKeikakuIchiran = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgKyotakuServiceKeikakuIchiranMain = function () {
                return new UZA.Panel(this.convFiledName("dgKyotakuServiceKeikakuIchiranMain"));
            };

            Controls.prototype.dgKyotakuServiceKeikakuIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgKyotakuServiceKeikakuIchiran"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };

            Controls.prototype.DvJohoSelect = function () {
                return new UZA.Panel(this.convFiledName("DvJohoSelect"));
            };

            Controls.prototype.btnKeikakuIraiUketsuke = function () {
                return new UZA.Button(this.convFiledName("btnKeikakuIraiUketsuke"));
            };

            Controls.prototype.btnJikosakuseiKeikaku = function () {
                return new UZA.Button(this.convFiledName("btnJikosakuseiKeikaku"));
            };

            Controls.prototype.btnKyotakuService = function () {
                return new UZA.Button(this.convFiledName("btnKyotakuService"));
            };

            Controls.prototype.DvKeikakuIraiUketsuke = function () {
                return new UZA.Panel(this.convFiledName("DvKeikakuIraiUketsuke"));
            };

            Controls.prototype.txtIraiNinteiShinseiJokyo = function () {
                return new UZA.TextBox(this.convFiledName("txtIraiNinteiShinseiJokyo"));
            };

            Controls.prototype.txtTodokedeKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtTodokedeKubun"));
            };

            Controls.prototype.txtIraiShinseiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtIraiShinseiDate"));
            };

            Controls.prototype.txtKeikakuTekiyoStartDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKeikakuTekiyoStartDate"));
            };

            Controls.prototype.txtIraiKeikakuTekiyoEndDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtIraiKeikakuTekiyoEndDate"));
            };

            Controls.prototype.txtKeikakuSakuseiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtKeikakuSakuseiKubun"));
            };

            Controls.prototype.linLine1 = function () {
                return new UZA.HorizontalLine(this.convFiledName("linLine1"));
            };

            Controls.prototype.txtJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));
            };

            Controls.prototype.txtJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaName"));
            };

            Controls.prototype.txtServiceShurui = function () {
                return new UZA.TextBox(this.convFiledName("txtServiceShurui"));
            };

            Controls.prototype.txtYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            };

            Controls.prototype.txtJusho = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtJusho"));
            };

            Controls.prototype.txtKanrishaName = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKanrishaName"));
            };

            Controls.prototype.txtTelNo = function () {
                return new UZA.TextBoxTelNo(this.convFiledName("txtTelNo"));
            };

            Controls.prototype.txtItakusakiJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtItakusakiJigyoshaNo"));
            };

            Controls.prototype.txtItakusakiJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtItakusakiJigyoshaName"));
            };

            Controls.prototype.txtHenkoDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtHenkoDate"));
            };

            Controls.prototype.txtHenkoRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtHenkoRiyu"));
            };

            Controls.prototype.btnKeikakuIraiClose = function () {
                return new UZA.Button(this.convFiledName("btnKeikakuIraiClose"));
            };

            Controls.prototype.DvJikoSakuseiKeikaku = function () {
                return new UZA.Panel(this.convFiledName("DvJikoSakuseiKeikaku"));
            };

            Controls.prototype.txtJikoNinteiShinseiJokyo = function () {
                return new UZA.TextBox(this.convFiledName("txtJikoNinteiShinseiJokyo"));
            };

            Controls.prototype.linLine6 = function () {
                return new UZA.HorizontalLine(this.convFiledName("linLine6"));
            };

            Controls.prototype.txtSetteiYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSetteiYM"));
            };

            Controls.prototype.linLine2 = function () {
                return new UZA.HorizontalLine(this.convFiledName("linLine2"));
            };

            Controls.prototype.txtSakuseiDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSakuseiDate"));
            };

            Controls.prototype.txtJikoShinseiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtJikoShinseiDate"));
            };

            Controls.prototype.txtJikoKeikakuTekiyoStartDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtJikoKeikakuTekiyoStartDate"));
            };

            Controls.prototype.txtJikoKeikakuTekiyoEndDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtJikoKeikakuTekiyoEndDate"));
            };

            Controls.prototype.chkZanteiKeikaku = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkZanteiKeikaku"));
            };

            Controls.prototype.ninteiJoho = function () {
                return new UZA.Panel(this.convFiledName("ninteiJoho"));
            };

            Controls.prototype.txtYokaigodo = function () {
                return new UZA.TextBox(this.convFiledName("txtYokaigodo"));
            };

            Controls.prototype.txtNinteiYukokikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNinteiYukokikan"));
            };

            Controls.prototype.btnJikoSakuseiClose = function () {
                return new UZA.Button(this.convFiledName("btnJikoSakuseiClose"));
            };

            Controls.prototype.DvKyotakuService = function () {
                return new UZA.Panel(this.convFiledName("DvKyotakuService"));
            };

            Controls.prototype.txtShikyuGendoGaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShikyuGendoGaku"));
            };

            Controls.prototype.txtGendoKanriKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtGendoKanriKikan"));
            };

            Controls.prototype.tankiNyushoRiyoNissu = function () {
                return new UZA.Panel(this.convFiledName("tankiNyushoRiyoNissu"));
            };

            Controls.prototype.txtZengetsuMadeRiyoNissu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtZengetsuMadeRiyoNissu"));
            };

            Controls.prototype.txtTogetsuKeikakuRiyoNissu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTogetsuKeikakuRiyoNissu"));
            };

            Controls.prototype.txtRuisekiRiyoNissu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRuisekiRiyoNissu"));
            };

            Controls.prototype.btnShuruiGendoGakuKakunin = function () {
                return new UZA.Button(this.convFiledName("btnShuruiGendoGakuKakunin"));
            };

            Controls.prototype.dgKyotakuService = function () {
                return new UZA.DataGrid(this.convFiledName("dgKyotakuService"));
            };

            Controls.prototype.btnKyotakuServiceClose = function () {
                return new UZA.Button(this.convFiledName("btnKyotakuServiceClose"));
            };

            Controls.prototype.DvKyotakuMeisai = function () {
                return new UZA.Panel(this.convFiledName("DvKyotakuMeisai"));
            };

            Controls.prototype.txtKyotakuJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKyotakuJigyoshaNo"));
            };

            Controls.prototype.txtKyotakuJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtKyotakuJigyoshaName"));
            };

            Controls.prototype.txtServiceCode1 = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceCode1"));
            };

            Controls.prototype.txtServiceCode2 = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceCode2"));
            };

            Controls.prototype.txtServiceName = function () {
                return new UZA.TextBox(this.convFiledName("txtServiceName"));
            };

            Controls.prototype.txtTani = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTani"));
            };

            Controls.prototype.txtWaribikiTekiyogoRitsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtWaribikiTekiyogoRitsu"));
            };

            Controls.prototype.txtWaribikiTekiyogoTani = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtWaribikiTekiyogoTani"));
            };

            Controls.prototype.txtKaisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKaisu"));
            };

            Controls.prototype.txtServiceTani = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtServiceTani"));
            };

            Controls.prototype.linLine3 = function () {
                return new UZA.HorizontalLine(this.convFiledName("linLine3"));
            };

            Controls.prototype.txtShuruiGendoChokaTani = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShuruiGendoChokaTani"));
            };

            Controls.prototype.txtShuruiGendonaiTani = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShuruiGendonaiTani"));
            };

            Controls.prototype.txtTaniTanka = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTaniTanka"));
            };

            Controls.prototype.txtKubunGendoChokaTani = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKubunGendoChokaTani"));
            };

            Controls.prototype.txtKubunGendonaiTani = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKubunGendonaiTani"));
            };

            Controls.prototype.txtKyufuRitsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKyufuRitsu"));
            };

            Controls.prototype.txtHiyoSogaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHiyoSogaku"));
            };

            Controls.prototype.txtHokenKyufuGaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenKyufuGaku"));
            };

            Controls.prototype.txtHokenTaishoRiyoshaFutanGaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenTaishoRiyoshaFutanGaku"));
            };

            Controls.prototype.txtZengakuRiyoshaFutanngaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtZengakuRiyoshaFutanngaku"));
            };

            Controls.prototype.btnKyotakuServiceShosaiClose = function () {
                return new UZA.Button(this.convFiledName("btnKyotakuServiceShosaiClose"));
            };

            Controls.prototype.DvShuruiGendoKakunin = function () {
                return new UZA.Panel(this.convFiledName("DvShuruiGendoKakunin"));
            };

            Controls.prototype.dgShuruiGendoKakunin = function () {
                return new UZA.DataGrid(this.convFiledName("dgShuruiGendoKakunin"));
            };

            Controls.prototype.btnShuruiGendoGakuKakuninClose = function () {
                return new UZA.Button(this.convFiledName("btnShuruiGendoGakuKakuninClose"));
            };
            return Controls;
        })();
        KyotakuServiceKeikakuIchiran.Controls = Controls;
    })(DBD.KyotakuServiceKeikakuIchiran || (DBD.KyotakuServiceKeikakuIchiran = {}));
    var KyotakuServiceKeikakuIchiran = DBD.KyotakuServiceKeikakuIchiran;
})(DBD || (DBD = {}));
