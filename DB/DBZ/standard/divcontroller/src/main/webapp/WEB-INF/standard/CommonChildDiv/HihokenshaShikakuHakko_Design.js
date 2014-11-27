var DBZ;
(function (DBZ) {
    (function (HihokenshaShikakuHakko) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        HihokenshaShikakuHakko.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "HihokenshaShikakuHakko";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.HihokenshaShikakuHakko.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.HihokenshaShikakuHakko.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.HihokenshaShikakuHakko = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.radInjiIchi = function () {
                return new UZA.RadioButton(this.convFiledName("radInjiIchi"));
            };

            Controls.prototype.txtKofuDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKofuDate"));
            };

            Controls.prototype.ddlKofuJiyu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKofuJiyu"));
            };

            Controls.prototype.txtYukoKigen = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtYukoKigen"));
            };

            Controls.prototype.txtHokensha = function () {
                return new UZA.TextBox(this.convFiledName("txtHokensha"));
            };

            Controls.prototype.txtYokaigodo = function () {
                return new UZA.TextBox(this.convFiledName("txtYokaigodo"));
            };

            Controls.prototype.txtNinteiYukoKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtNinteiYukoKikan"));
            };

            Controls.prototype.txtShinseiDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShinseiDate"));
            };

            Controls.prototype.tabHihokenshaShikakuShosai = function () {
                return new UZA.TabContainer(this.convFiledName("tabHihokenshaShikakuShosai"));
            };

            Controls.prototype.tplGendoGaku = function () {
                return new UZA.TabPanel(this.convFiledName("tplGendoGaku"));
            };

            Controls.prototype.lblKubunShikyuGendoGaku = function () {
                return new UZA.Label(this.convFiledName("lblKubunShikyuGendoGaku"));
            };

            Controls.prototype.txtKubunShikyuGendoKijunGaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKubunShikyuGendoKijunGaku"));
            };

            Controls.prototype.txtKyuhuYukoKikan = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyuhuYukoKikan"));
            };

            Controls.prototype.ShuruiShikyuGendoKijungaku = function () {
                return new UZA.Panel(this.convFiledName("ShuruiShikyuGendoKijungaku"));
            };

            Controls.prototype.dgShuruiShikyuGendoKijunGaku = function () {
                return new UZA.DataGrid(this.convFiledName("dgShuruiShikyuGendoKijunGaku"));
            };

            Controls.prototype.tplShinsakaiIken = function () {
                return new UZA.TabPanel(this.convFiledName("tplShinsakaiIken"));
            };

            Controls.prototype.lblShinsakaiIken = function () {
                return new UZA.Label(this.convFiledName("lblShinsakaiIken"));
            };

            Controls.prototype.txtShinsakaiIken = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinsakaiIken"));
            };

            Controls.prototype.tplKyufuSeigen = function () {
                return new UZA.TabPanel(this.convFiledName("tplKyufuSeigen"));
            };

            Controls.prototype.lblKyufuSeigen = function () {
                return new UZA.Label(this.convFiledName("lblKyufuSeigen"));
            };

            Controls.prototype.tblKyuhuSeigen = function () {
                return new UZA.TablePanel(this.convFiledName("tblKyuhuSeigen"));
            };

            Controls.prototype.celKyufuSeigenNaiyoTitle = function () {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenNaiyoTitle"));
            };

            Controls.prototype.lblKyufuSeigenNaiyo = function () {
                return new UZA.Label(this.convFiledName("lblKyufuSeigenNaiyo"));
            };

            Controls.prototype.celKyufuSeigenKikanTitle = function () {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenKikanTitle"));
            };

            Controls.prototype.lblKyufuSeigenKikan = function () {
                return new UZA.Label(this.convFiledName("lblKyufuSeigenKikan"));
            };

            Controls.prototype.celKyufuSeigenNaiyo1 = function () {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenNaiyo1"));
            };

            Controls.prototype.txtKyufuSeigenNaiyo1 = function () {
                return new UZA.TextBox(this.convFiledName("txtKyufuSeigenNaiyo1"));
            };

            Controls.prototype.celKyufuSeigenKikan1 = function () {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenKikan1"));
            };

            Controls.prototype.txtKyufuSeigenKikan1 = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyufuSeigenKikan1"));
            };

            Controls.prototype.celKyufuSeigenNaiyo2 = function () {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenNaiyo2"));
            };

            Controls.prototype.txtKyufuSeigenNaiyo2 = function () {
                return new UZA.TextBox(this.convFiledName("txtKyufuSeigenNaiyo2"));
            };

            Controls.prototype.celKyufuSeigenKikan2 = function () {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenKikan2"));
            };

            Controls.prototype.txtKyufuSeigenKikan2 = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyufuSeigenKikan2"));
            };

            Controls.prototype.celKyufuSeigenNaiyo3 = function () {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenNaiyo3"));
            };

            Controls.prototype.txtKyufuSeigenNaiyo3 = function () {
                return new UZA.TextBox(this.convFiledName("txtKyufuSeigenNaiyo3"));
            };

            Controls.prototype.celKyufuSeigenKikan3 = function () {
                return new UZA.TableCell(this.convFiledName("celKyufuSeigenKikan3"));
            };

            Controls.prototype.txtKyufuSeigenKikan3 = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtKyufuSeigenKikan3"));
            };

            Controls.prototype.tplShienJigyosha = function () {
                return new UZA.TabPanel(this.convFiledName("tplShienJigyosha"));
            };

            Controls.prototype.lblShienJigyosha = function () {
                return new UZA.Label(this.convFiledName("lblShienJigyosha"));
            };

            Controls.prototype.tblJigyosha = function () {
                return new UZA.TablePanel(this.convFiledName("tblJigyosha"));
            };

            Controls.prototype.celJigyoshaTitle = function () {
                return new UZA.TableCell(this.convFiledName("celJigyoshaTitle"));
            };

            Controls.prototype.lblJigyosha = function () {
                return new UZA.Label(this.convFiledName("lblJigyosha"));
            };

            Controls.prototype.celTodokedeDateTitle = function () {
                return new UZA.TableCell(this.convFiledName("celTodokedeDateTitle"));
            };

            Controls.prototype.lblTodokedeDate = function () {
                return new UZA.Label(this.convFiledName("lblTodokedeDate"));
            };

            Controls.prototype.celJigyosha1 = function () {
                return new UZA.TableCell(this.convFiledName("celJigyosha1"));
            };

            Controls.prototype.txtJigyosha1 = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyosha1"));
            };

            Controls.prototype.celTodokedeDate1 = function () {
                return new UZA.TableCell(this.convFiledName("celTodokedeDate1"));
            };

            Controls.prototype.txtTodokedeDate1 = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTodokedeDate1"));
            };

            Controls.prototype.celJigyosha2 = function () {
                return new UZA.TableCell(this.convFiledName("celJigyosha2"));
            };

            Controls.prototype.txtJigyosha2 = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyosha2"));
            };

            Controls.prototype.celTodokedeDate2 = function () {
                return new UZA.TableCell(this.convFiledName("celTodokedeDate2"));
            };

            Controls.prototype.txtTodokedeDate2 = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTodokedeDate2"));
            };

            Controls.prototype.celJigyosha3 = function () {
                return new UZA.TableCell(this.convFiledName("celJigyosha3"));
            };

            Controls.prototype.txtJigyosha3 = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyosha3"));
            };

            Controls.prototype.celTodokedeDate3 = function () {
                return new UZA.TableCell(this.convFiledName("celTodokedeDate3"));
            };

            Controls.prototype.txtTodokedeDate3 = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTodokedeDate3"));
            };

            Controls.prototype.tplShisetsuNyutaisho = function () {
                return new UZA.TabPanel(this.convFiledName("tplShisetsuNyutaisho"));
            };

            Controls.prototype.lblKaigoHokensha = function () {
                return new UZA.Label(this.convFiledName("lblKaigoHokensha"));
            };

            Controls.prototype.tblShisetsuNyutaisho = function () {
                return new UZA.TablePanel(this.convFiledName("tblShisetsuNyutaisho"));
            };

            Controls.prototype.celShisetsuShuruiTitle = function () {
                return new UZA.TableCell(this.convFiledName("celShisetsuShuruiTitle"));
            };

            Controls.prototype.lblShisetsuShurui = function () {
                return new UZA.Label(this.convFiledName("lblShisetsuShurui"));
            };

            Controls.prototype.celNyushoShisetsuTitle = function () {
                return new UZA.TableCell(this.convFiledName("celNyushoShisetsuTitle"));
            };

            Controls.prototype.lblNyushoShisetsu = function () {
                return new UZA.Label(this.convFiledName("lblNyushoShisetsu"));
            };

            Controls.prototype.celShisetsuNyushoDateTitle = function () {
                return new UZA.TableCell(this.convFiledName("celShisetsuNyushoDateTitle"));
            };

            Controls.prototype.lblShisetsuNyushoDate = function () {
                return new UZA.Label(this.convFiledName("lblShisetsuNyushoDate"));
            };

            Controls.prototype.celShisetsuTaishoDateTitle = function () {
                return new UZA.TableCell(this.convFiledName("celShisetsuTaishoDateTitle"));
            };

            Controls.prototype.lblShisetsuTaishoDate = function () {
                return new UZA.Label(this.convFiledName("lblShisetsuTaishoDate"));
            };

            Controls.prototype.celShisetsuShurui1 = function () {
                return new UZA.TableCell(this.convFiledName("celShisetsuShurui1"));
            };

            Controls.prototype.txtShisetsuShurui1 = function () {
                return new UZA.TextBox(this.convFiledName("txtShisetsuShurui1"));
            };

            Controls.prototype.celNyushoShisetsu1 = function () {
                return new UZA.TableCell(this.convFiledName("celNyushoShisetsu1"));
            };

            Controls.prototype.txtNyushoShisetsu1 = function () {
                return new UZA.TextBox(this.convFiledName("txtNyushoShisetsu1"));
            };

            Controls.prototype.celShisetsuNyushoDate1 = function () {
                return new UZA.TableCell(this.convFiledName("celShisetsuNyushoDate1"));
            };

            Controls.prototype.txtShisetsuNyushoDate1 = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuNyushoDate1"));
            };

            Controls.prototype.celShisetsuTaishoDate1 = function () {
                return new UZA.TableCell(this.convFiledName("celShisetsuTaishoDate1"));
            };

            Controls.prototype.txtShisetsuTaishoDate1 = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuTaishoDate1"));
            };

            Controls.prototype.celShisetsuShurui2 = function () {
                return new UZA.TableCell(this.convFiledName("celShisetsuShurui2"));
            };

            Controls.prototype.txtShisetsuShurui2 = function () {
                return new UZA.TextBox(this.convFiledName("txtShisetsuShurui2"));
            };

            Controls.prototype.celNyushoShisetsu2 = function () {
                return new UZA.TableCell(this.convFiledName("celNyushoShisetsu2"));
            };

            Controls.prototype.txtNyushoShisetsu2 = function () {
                return new UZA.TextBox(this.convFiledName("txtNyushoShisetsu2"));
            };

            Controls.prototype.celShisetsuNyushoDate2 = function () {
                return new UZA.TableCell(this.convFiledName("celShisetsuNyushoDate2"));
            };

            Controls.prototype.txtShisetsuNyushoDate2 = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuNyushoDate2"));
            };

            Controls.prototype.celShisetsuTaishoDate2 = function () {
                return new UZA.TableCell(this.convFiledName("celShisetsuTaishoDate2"));
            };

            Controls.prototype.txtShisetsuTaishoDate2 = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuTaishoDate2"));
            };

            Controls.prototype.celShisetsuShurui3 = function () {
                return new UZA.TableCell(this.convFiledName("celShisetsuShurui3"));
            };

            Controls.prototype.txtShisetsuShurui3 = function () {
                return new UZA.TextBox(this.convFiledName("txtShisetsuShurui3"));
            };

            Controls.prototype.celNyushoShisetsu3 = function () {
                return new UZA.TableCell(this.convFiledName("celNyushoShisetsu3"));
            };

            Controls.prototype.txtNyushoShisetsu3 = function () {
                return new UZA.TextBox(this.convFiledName("txtNyushoShisetsu3"));
            };

            Controls.prototype.celShisetsuNyushoDate3 = function () {
                return new UZA.TableCell(this.convFiledName("celShisetsuNyushoDate3"));
            };

            Controls.prototype.txtShisetsuNyushoDate3 = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuNyushoDate3"));
            };

            Controls.prototype.celShisetsuTaishoDate3 = function () {
                return new UZA.TableCell(this.convFiledName("celShisetsuTaishoDate3"));
            };

            Controls.prototype.txtShisetsuTaishoDate3 = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuTaishoDate3"));
            };
            return Controls;
        })();
        HihokenshaShikakuHakko.Controls = Controls;
    })(DBZ.HihokenshaShikakuHakko || (DBZ.HihokenshaShikakuHakko = {}));
    var HihokenshaShikakuHakko = DBZ.HihokenshaShikakuHakko;
})(DBZ || (DBZ = {}));
