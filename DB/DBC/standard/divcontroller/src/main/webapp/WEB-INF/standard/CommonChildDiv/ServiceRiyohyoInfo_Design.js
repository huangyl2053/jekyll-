var DBC;
(function (DBC) {
    (function (ServiceRiyohyoInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onBlur_txtRiyoYM = function () {
                return "onBlur_txtRiyoYM";
            };

            Events.onClick_btnShowShuruiGendogaku = function () {
                return "onClick_btnShowShuruiGendogaku";
            };

            Events.onClick_btnZengetsuCopy = function () {
                return "onClick_btnZengetsuCopy";
            };

            Events.onBlur_txtZengetsuRiyoNissu = function () {
                return "onBlur_txtZengetsuRiyoNissu";
            };

            Events.onBlur_txtTogetsuRiyoNissu = function () {
                return "onBlur_txtTogetsuRiyoNissu";
            };

            Events.onClick_btnBeppyoMeisaiNew = function () {
                return "onClick_btnBeppyoMeisaiNew";
            };

            Events.onClick_btnBeppyoGokeiNew = function () {
                return "onClick_btnBeppyoGokeiNew";
            };

            Events.onClick_btnSelect = function () {
                return "onClick_btnSelect";
            };

            Events.onClick_btnModify = function () {
                return "onClick_btnModify";
            };

            Events.onClick_btnDelete = function () {
                return "onClick_btnDelete";
            };

            Events.onBlur_txtTani = function () {
                return "onBlur_txtTani";
            };

            Events.onBlur_txtWaribikigoRitsu = function () {
                return "onBlur_txtWaribikigoRitsu";
            };

            Events.onBlur_txtKaisu = function () {
                return "onBlur_txtKaisu";
            };

            Events.onClick_btnBeppyoMeisaiKakutei = function () {
                return "onClick_btnBeppyoMeisaiKakutei";
            };

            Events.onClick_btnCalcMeisaiGokei = function () {
                return "onClick_btnCalcMeisaiGokei";
            };

            Events.onClick_btnCancelMeisaiInput = function () {
                return "onClick_btnCancelMeisaiInput";
            };

            Events.onClick_btnCalcMeisai = function () {
                return "onClick_btnCalcMeisai";
            };

            Events.onBlur_txtShuruiGendoChokaTani = function () {
                return "onBlur_txtShuruiGendoChokaTani";
            };

            Events.onBlur_txtShuruiGendonaiTani = function () {
                return "onBlur_txtShuruiGendonaiTani";
            };

            Events.onBlur_txtTanisuTanka = function () {
                return "onBlur_txtTanisuTanka";
            };

            Events.onBlur_txtKubunGendoChokaTani = function () {
                return "onBlur_txtKubunGendoChokaTani";
            };

            Events.onBlur_txtKubunGendonaiTani = function () {
                return "onBlur_txtKubunGendonaiTani";
            };

            Events.onBlur_txtKyufuritsu = function () {
                return "onBlur_txtKyufuritsu";
            };

            Events.onClick_btnBeppyoGokeiKakutei = function () {
                return "onClick_btnBeppyoGokeiKakutei";
            };

            Events.onClick_btnCancelGokeiInput = function () {
                return "onClick_btnCancelGokeiInput";
            };

            Events.onClick_btnGokeiKeisan = function () {
                return "onClick_btnGokeiKeisan";
            };

            Events.onClick_btnUpdate = function () {
                return "onClick_btnUpdate";
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

            Controls.prototype.btnCancelGokeiInput = function () {
                return new UZA.Button(this.convFiledName("btnCancelGokeiInput"));
            };

            Controls.prototype.btnCalcGokei = function () {
                return new UZA.Button(this.convFiledName("btnCalcGokei"));
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
