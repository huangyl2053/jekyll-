var DBC;
(function (DBC) {
    (function (ServiceRiyohyoInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onOkClosebtnShowShuruiGendogaku = function () {
                return "onOkClosebtnShowShuruiGendogaku";
            };

            Events.onBeforeOpenDialogbtnShowShuruiGendogaku = function () {
                return "onBeforeOpenDialogbtnShowShuruiGendogaku";
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

            Controls.prototype.txtKubunShikyuGendogaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKubunShikyuGendogaku"));
            };

            Controls.prototype.txtGendoKanriKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtGendoKanriKikan"));
            };

            Controls.prototype.txtRiyoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtRiyoYM"));
            };

            Controls.prototype.chkZanteiKubun = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkZanteiKubun"));
            };

            Controls.prototype.ddlKoshinKbn = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKoshinKbn"));
            };

            Controls.prototype.txtKoshinYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKoshinYMD"));
            };

            Controls.prototype.txtSofuYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSofuYM"));
            };

            Controls.prototype.btnShowShuruiGendogaku = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShowShuruiGendogaku"));
            };

            Controls.prototype.btnZengetsuCopy = function () {
                return new UZA.Button(this.convFiledName("btnZengetsuCopy"));
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

            Controls.prototype.ServiceRiyohyoBeppyoJigyoshaServiceInput = function () {
                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoJigyoshaServiceInput"));
            };

            Controls.prototype.ServiceRiyohyoBeppyoMeisai = function () {
                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoMeisai"));
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

            Controls.prototype.txtRiyoushaFutangaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoushaFutangaku"));
            };

            Controls.prototype.txtTeigakuRiyoushaFutangaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTeigakuRiyoushaFutangaku"));
            };

            Controls.prototype.ServiceRiyohyoBeppyoMeisaiFooter = function () {
                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoMeisaiFooter"));
            };

            Controls.prototype.btnBeppyoMeisaiKakutei = function () {
                return new UZA.Button(this.convFiledName("btnBeppyoMeisaiKakutei"));
            };

            Controls.prototype.btnCalcMeisaiGokei = function () {
                return new UZA.Button(this.convFiledName("btnCalcMeisaiGokei"));
            };

            Controls.prototype.btnCancelMeisaiInput = function () {
                return new UZA.Button(this.convFiledName("btnCancelMeisaiInput"));
            };

            Controls.prototype.btnCalcMeisai = function () {
                return new UZA.Button(this.convFiledName("btnCalcMeisai"));
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

            Controls.prototype.ServiceRiyohyoBeppyoGokeiFooter = function () {
                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoGokeiFooter"));
            };

            Controls.prototype.btnBeppyoGokeiKakutei = function () {
                return new UZA.Button(this.convFiledName("btnBeppyoGokeiKakutei"));
            };

            Controls.prototype.btnCalcGokei = function () {
                return new UZA.Button(this.convFiledName("btnCalcGokei"));
            };

            Controls.prototype.btnCancelGokeiInput = function () {
                return new UZA.Button(this.convFiledName("btnCancelGokeiInput"));
            };

            Controls.prototype.ServiceRiyohyoBeppyoFooter = function () {
                return new UZA.Panel(this.convFiledName("ServiceRiyohyoBeppyoFooter"));
            };

            Controls.prototype.btnUpdate = function () {
                return new UZA.Button(this.convFiledName("btnUpdate"));
            };

            Controls.prototype.btnBackRiyoNengetsuIchiran = function () {
                return new UZA.Button(this.convFiledName("btnBackRiyoNengetsuIchiran"));
            };
            return Controls;
        })();
        ServiceRiyohyoInfo.Controls = Controls;
    })(DBC.ServiceRiyohyoInfo || (DBC.ServiceRiyohyoInfo = {}));
    var ServiceRiyohyoInfo = DBC.ServiceRiyohyoInfo;
})(DBC || (DBC = {}));
