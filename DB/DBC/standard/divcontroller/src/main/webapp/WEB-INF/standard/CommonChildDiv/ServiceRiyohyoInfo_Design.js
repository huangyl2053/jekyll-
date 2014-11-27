var DBC;
(function (DBC) {
    (function (ServiceRiyohyoInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onBlurServiceCode = function () {
                return "onBlurServiceCode";
            };
            return Events;
        })();
        ServiceRiyohyoInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ServiceRiyohyoInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.ServiceRiyohyoInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.ServiceRiyohyoInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ServiceRiyohyoInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtTodokedeYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTodokedeYMD"));
            };

            Controls.prototype.txtTekiyoKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtTekiyoKikan"));
            };

            Controls.prototype.txtKeikakuJigyoshaCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKeikakuJigyoshaCode"));
            };

            Controls.prototype.txtKeikakuJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtKeikakuJigyoshaName"));
            };

            Controls.prototype.txtTaishoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTaishoYM"));
            };

            Controls.prototype.txtRiyohyoSakuseiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtRiyohyoSakuseiYMD"));
            };

            Controls.prototype.txtRiyohyoTodokedeYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtRiyohyoTodokedeYMD"));
            };

            Controls.prototype.txtKubunShikyuGendogaku = function () {
                return new UZA.TextBox(this.convFiledName("txtKubunShikyuGendogaku"));
            };

            Controls.prototype.txtRiyohyoSakuseisha = function () {
                return new UZA.TextBox(this.convFiledName("txtRiyohyoSakuseisha"));
            };

            Controls.prototype.txtGendoKanriKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtGendoKanriKikan"));
            };

            Controls.prototype.btnZengetsuCopy = function () {
                return new UZA.Button(this.convFiledName("btnZengetsuCopy"));
            };

            Controls.prototype.tabServiceRiyohyo = function () {
                return new UZA.TabContainer(this.convFiledName("tabServiceRiyohyo"));
            };

            Controls.prototype.ServiceRiyohyo = function () {
                return new UZA.TabPanel(this.convFiledName("ServiceRiyohyo"));
            };

            Controls.prototype.lblServiceRiyohyoList = function () {
                return new UZA.Label(this.convFiledName("lblServiceRiyohyoList"));
            };

            Controls.prototype.btnRiyohyoMeisaiAdd = function () {
                return new UZA.Button(this.convFiledName("btnRiyohyoMeisaiAdd"));
            };

            Controls.prototype.dgServiceRiyohyoList = function () {
                return new UZA.DataGrid(this.convFiledName("dgServiceRiyohyoList"));
            };

            Controls.prototype.ServiceRiyohyoBeppyo = function () {
                return new UZA.TabPanel(this.convFiledName("ServiceRiyohyoBeppyo"));
            };

            Controls.prototype.ServiceRiyohyoBeppyoRiyoNissu = function () {
                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoRiyoNissu"));
            };

            Controls.prototype.txtZengetsuRiyoNissu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtZengetsuRiyoNissu"));
            };

            Controls.prototype.txtTogetsuRiyoNissu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTogetsuRiyoNissu"));
            };

            Controls.prototype.txtRuikeiRiyoNissu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRuikeiRiyoNissu"));
            };

            Controls.prototype.ServiceRiyohyoBeppyoList = function () {
                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoList"));
            };

            Controls.prototype.btnBeppyoMeisaiNew = function () {
                return new UZA.Button(this.convFiledName("btnBeppyoMeisaiNew"));
            };

            Controls.prototype.btnBeppyoGokeiNew = function () {
                return new UZA.Button(this.convFiledName("btnBeppyoGokeiNew"));
            };

            Controls.prototype.dgServiceRiyohyoBeppyoList = function () {
                return new UZA.DataGrid(this.convFiledName("dgServiceRiyohyoBeppyoList"));
            };

            Controls.prototype.ServiceRiyohyoBeppyoMeisai = function () {
                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoMeisai"));
            };

            Controls.prototype.txtJigyoshaCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaCode"));
            };

            Controls.prototype.btnJigyosha = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnJigyosha"));
            };

            Controls.prototype.txtJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaName"));
            };

            Controls.prototype.txtServiceCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceCode"));
            };

            Controls.prototype.btnService = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnService"));
            };

            Controls.prototype.txtServiceName = function () {
                return new UZA.TextBox(this.convFiledName("txtServiceName"));
            };

            Controls.prototype.txtTani = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTani"));
            };

            Controls.prototype.txtWaribikigoRitsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtWaribikigoRitsu"));
            };

            Controls.prototype.txtWaribikigoTani = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtWaribikigoTani"));
            };

            Controls.prototype.txtKaisu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKaisu"));
            };

            Controls.prototype.lblKaisu = function () {
                return new UZA.Label(this.convFiledName("lblKaisu"));
            };

            Controls.prototype.txtServiceTani = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtServiceTani"));
            };

            Controls.prototype.lblServiceTani = function () {
                return new UZA.Label(this.convFiledName("lblServiceTani"));
            };

            Controls.prototype.btnCalcMeisai = function () {
                return new UZA.Button(this.convFiledName("btnCalcMeisai"));
            };

            Controls.prototype.btnBeppyoMeisaiKakutei = function () {
                return new UZA.Button(this.convFiledName("btnBeppyoMeisaiKakutei"));
            };

            Controls.prototype.ServiceRiyohyoBeppyoGokei = function () {
                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoGokei"));
            };

            Controls.prototype.txtShuruiGendoChokaTani = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShuruiGendoChokaTani"));
            };

            Controls.prototype.txtShuruiGendonaiTani = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShuruiGendonaiTani"));
            };

            Controls.prototype.txtTanisuTanka = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTanisuTanka"));
            };

            Controls.prototype.txtKubunGendoChokaTani = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKubunGendoChokaTani"));
            };

            Controls.prototype.txtKubunGendonaiTani = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKubunGendonaiTani"));
            };

            Controls.prototype.txtKyufuritsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKyufuritsu"));
            };

            Controls.prototype.txtHiyoSogaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHiyoSogaku"));
            };

            Controls.prototype.lblHiyoSogaku = function () {
                return new UZA.Label(this.convFiledName("lblHiyoSogaku"));
            };

            Controls.prototype.txtHokenKyufugaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenKyufugaku"));
            };

            Controls.prototype.lblHokenKyufugaku = function () {
                return new UZA.Label(this.convFiledName("lblHokenKyufugaku"));
            };

            Controls.prototype.txtRiyoshaFutangakuHoken = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutangakuHoken"));
            };

            Controls.prototype.lblRiyoshaFutangakuHoken = function () {
                return new UZA.Label(this.convFiledName("lblRiyoshaFutangakuHoken"));
            };

            Controls.prototype.txtRiyoshaFutangakuZengaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutangakuZengaku"));
            };

            Controls.prototype.lblRiyoshaFutangakuZengaku = function () {
                return new UZA.Label(this.convFiledName("lblRiyoshaFutangakuZengaku"));
            };

            Controls.prototype.btnCalcGokei = function () {
                return new UZA.Button(this.convFiledName("btnCalcGokei"));
            };

            Controls.prototype.btnBeppyoGokeiKakutei = function () {
                return new UZA.Button(this.convFiledName("btnBeppyoGokeiKakutei"));
            };
            return Controls;
        })();
        ServiceRiyohyoInfo.Controls = Controls;
    })(DBC.ServiceRiyohyoInfo || (DBC.ServiceRiyohyoInfo = {}));
    var ServiceRiyohyoInfo = DBC.ServiceRiyohyoInfo;
})(DBC || (DBC = {}));
