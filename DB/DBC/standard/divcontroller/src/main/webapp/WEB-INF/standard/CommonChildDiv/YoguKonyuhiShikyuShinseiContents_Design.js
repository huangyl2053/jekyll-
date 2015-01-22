var DBC;
(function (DBC) {
    (function (YoguKonyuhiShikyuShinseiContents) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAddSeikyuDetail = function () {
                return "onClick_btnAddSeikyuDetail";
            };

            Events.onClick_btnReflect = function () {
                return "onClick_btnReflect";
            };
            return Events;
        })();
        YoguKonyuhiShikyuShinseiContents.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "YoguKonyuhiShikyuShinseiContents";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.YoguKonyuhiShikyuShinseiContents.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.YoguKonyuhiShikyuShinseiContents.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.YoguKonyuhiShikyuShinseiContents = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtKeikyoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKeikyoYM"));
            };

            Controls.prototype.txtSeiriNo = function () {
                return new UZA.TextBox(this.convFiledName("txtSeiriNo"));
            };

            Controls.prototype.txtKyufuRitsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKyufuRitsu"));
            };

            Controls.prototype.YoguKonyuhiShikyuShinseiSeikyuDetail = function () {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiSeikyuDetail"));
            };

            Controls.prototype.btnInputDetail = function () {
                return new UZA.Button(this.convFiledName("btnInputDetail"));
            };

            Controls.prototype.dgSeikyuDetail = function () {
                return new UZA.DataGrid(this.convFiledName("dgSeikyuDetail"));
            };

            Controls.prototype.YoguKonyuhiShikyuShinseiSeikyuDetailInput = function () {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiSeikyuDetail_YoguKonyuhiShikyuShinseiSeikyuDetailInput"));
            };

            Controls.prototype.txtBuyYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtBuyYMD"));
            };

            Controls.prototype.ddlShumoku = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShumoku"));
            };

            Controls.prototype.txtShohinName = function () {
                return new UZA.TextBox(this.convFiledName("txtShohinName"));
            };

            Controls.prototype.txtSeizoJigyosha = function () {
                return new UZA.TextBox(this.convFiledName("txtSeizoJigyosha"));
            };

            Controls.prototype.txtHanbaiJigyosha = function () {
                return new UZA.TextBox(this.convFiledName("txtHanbaiJigyosha"));
            };

            Controls.prototype.txtBuyAmount = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtBuyAmount"));
            };

            Controls.prototype.txtHinmokuCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtHinmokuCode"));
            };

            Controls.prototype.radShinsaMethod = function () {
                return new UZA.RadioButton(this.convFiledName("radShinsaMethod"));
            };

            Controls.prototype.btnClear = function () {
                return new UZA.Button(this.convFiledName("btnClear"));
            };

            Controls.prototype.btnAddSeikyuDetail = function () {
                return new UZA.Button(this.convFiledName("btnAddSeikyuDetail"));
            };

            Controls.prototype.SeikyuSummary = function () {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiSeikyuDetail_SeikyuSummary"));
            };

            Controls.prototype.tblSeikyuSummary = function () {
                return new UZA.TablePanel(this.convFiledName("tblSeikyuSummary"));
            };

            Controls.prototype.cel11 = function () {
                return new UZA.TableCell(this.convFiledName("cel11"));
            };

            Controls.prototype.lblSummary = function () {
                return new UZA.Label(this.convFiledName("lblSummary"));
            };

            Controls.prototype.cel12 = function () {
                return new UZA.TableCell(this.convFiledName("cel12"));
            };

            Controls.prototype.lblPayTotal = function () {
                return new UZA.Label(this.convFiledName("lblPayTotal"));
            };

            Controls.prototype.cel13 = function () {
                return new UZA.TableCell(this.convFiledName("cel13"));
            };

            Controls.prototype.lblHokenSeikyuAmount = function () {
                return new UZA.Label(this.convFiledName("lblHokenSeikyuAmount"));
            };

            Controls.prototype.cel14 = function () {
                return new UZA.TableCell(this.convFiledName("cel14"));
            };

            Controls.prototype.lblRiyoshaFutanAmount = function () {
                return new UZA.Label(this.convFiledName("lblRiyoshaFutanAmount"));
            };

            Controls.prototype.cel15 = function () {
                return new UZA.TableCell(this.convFiledName("cel15"));
            };

            Controls.prototype.lblLimitOverAmount = function () {
                return new UZA.Label(this.convFiledName("lblLimitOverAmount"));
            };

            Controls.prototype.cel21 = function () {
                return new UZA.TableCell(this.convFiledName("cel21"));
            };

            Controls.prototype.lblSummaryMae = function () {
                return new UZA.Label(this.convFiledName("lblSummaryMae"));
            };

            Controls.prototype.cel22 = function () {
                return new UZA.TableCell(this.convFiledName("cel22"));
            };

            Controls.prototype.txtPayTotalMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtPayTotalMae"));
            };

            Controls.prototype.cel23 = function () {
                return new UZA.TableCell(this.convFiledName("cel23"));
            };

            Controls.prototype.txtHokenSeikyuAmountMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenSeikyuAmountMae"));
            };

            Controls.prototype.cel24 = function () {
                return new UZA.TableCell(this.convFiledName("cel24"));
            };

            Controls.prototype.txtRiyoshaFutanAmountMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutanAmountMae"));
            };

            Controls.prototype.cel25 = function () {
                return new UZA.TableCell(this.convFiledName("cel25"));
            };

            Controls.prototype.txtLimitOverAmountMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtLimitOverAmountMae"));
            };

            Controls.prototype.cel31 = function () {
                return new UZA.TableCell(this.convFiledName("cel31"));
            };

            Controls.prototype.lblSummaryNow = function () {
                return new UZA.Label(this.convFiledName("lblSummaryNow"));
            };

            Controls.prototype.cel32 = function () {
                return new UZA.TableCell(this.convFiledName("cel32"));
            };

            Controls.prototype.txtPayTotalNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtPayTotalNow"));
            };

            Controls.prototype.cel33 = function () {
                return new UZA.TableCell(this.convFiledName("cel33"));
            };

            Controls.prototype.txtHokenSeikyuAmountNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenSeikyuAmountNow"));
            };

            Controls.prototype.cel34 = function () {
                return new UZA.TableCell(this.convFiledName("cel34"));
            };

            Controls.prototype.txtRiyoshaFutanAmountNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRiyoshaFutanAmountNow"));
            };

            Controls.prototype.cel35 = function () {
                return new UZA.TableCell(this.convFiledName("cel35"));
            };

            Controls.prototype.txtLimitOverAmountNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtLimitOverAmountNow"));
            };

            Controls.prototype.cel36 = function () {
                return new UZA.TableCell(this.convFiledName("cel36"));
            };

            Controls.prototype.btnLimitOverCheck = function () {
                return new UZA.Button(this.convFiledName("btnLimitOverCheck"));
            };

            Controls.prototype.YoguKonyuhiShikyuShinseishaJoho = function () {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseishaJoho"));
            };

            Controls.prototype.txtShinseiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiYMD"));
            };

            Controls.prototype.txtUketsukeYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtUketsukeYMD"));
            };

            Controls.prototype.YoguKonyuhiShikyuShinseisha = function () {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseishaJoho_YoguKonyuhiShikyuShinseisha"));
            };

            Controls.prototype.radShinseishaKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radShinseishaKubun"));
            };

            Controls.prototype.txtShinseishaName = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseishaName"));
            };

            Controls.prototype.txtYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            };

            Controls.prototype.txtAddress = function () {
                return new UZA.TextBox(this.convFiledName("txtAddress"));
            };

            Controls.prototype.txtTelNo = function () {
                return new UZA.TextBox(this.convFiledName("txtTelNo"));
            };

            Controls.prototype.txtJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));
            };

            Controls.prototype.btnSearchJigyosha = function () {
                return new UZA.Button(this.convFiledName("btnSearchJigyosha"));
            };

            Controls.prototype.YoguKonyuhiShikyuShinseiPaymentMethod = function () {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiPaymentMethod"));
            };

            Controls.prototype.radPayMethod = function () {
                return new UZA.RadioButton(this.convFiledName("radPayMethod"));
            };

            Controls.prototype.URKoza = function () {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiPaymentMethod_URKoza"));
            };

            Controls.prototype.txtKari1 = function () {
                return new UZA.TextBox(this.convFiledName("txtKari1"));
            };

            Controls.prototype.DBZJuryoinin = function () {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiPaymentMethod_DBZJuryoinin"));
            };

            Controls.prototype.txtKari2 = function () {
                return new UZA.TextBox(this.convFiledName("txtKari2"));
            };

            Controls.prototype.btnUpdateShikyuShinsei = function () {
                return new UZA.Button(this.convFiledName("btnUpdateShikyuShinsei"));
            };

            Controls.prototype.btnCancelShikyuShinsei = function () {
                return new UZA.Button(this.convFiledName("btnCancelShikyuShinsei"));
            };
            return Controls;
        })();
        YoguKonyuhiShikyuShinseiContents.Controls = Controls;
    })(DBC.YoguKonyuhiShikyuShinseiContents || (DBC.YoguKonyuhiShikyuShinseiContents = {}));
    var YoguKonyuhiShikyuShinseiContents = DBC.YoguKonyuhiShikyuShinseiContents;
})(DBC || (DBC = {}));
