var DBC;
(function (DBC) {
    (function (ShiharaiHohoJyoho) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_radMadoguti = function () {
                return "onClick_radMadoguti";
            };

            Events.onBlur_txtStartYMD = function () {
                return "onBlur_txtStartYMD";
            };

            Events.onBlur_txtEndYMD = function () {
                return "onBlur_txtEndYMD";
            };

            Events.onClick_radKoza = function () {
                return "onClick_radKoza";
            };

            Events.onChange_ddlKozaID = function () {
                return "onChange_ddlKozaID";
            };

            Events.onClick_radJyryoinin = function () {
                return "onClick_radJyryoinin";
            };

            Events.onBlur_txtKeiyakuNo = function () {
                return "onBlur_txtKeiyakuNo";
            };
            return Events;
        })();
        ShiharaiHohoJyoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShiharaiHohoJyoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.ShiharaiHohoJyoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.ShiharaiHohoJyoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShiharaiHohoJyoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.radMadoguti = function () {
                return new UZA.RadioButton(this.convFiledName("radMadoguti"));
            };

            Controls.prototype.txtShiharaiBasho = function () {
                return new UZA.TextBox(this.convFiledName("txtShiharaiBasho"));
            };

            Controls.prototype.txtStartYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtStartYMD"));
            };

            Controls.prototype.txtStartYobi = function () {
                return new UZA.TextBox(this.convFiledName("txtStartYobi"));
            };

            Controls.prototype.txtStartHHMM = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtStartHHMM"));
            };

            Controls.prototype.txtEndYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtEndYMD"));
            };

            Controls.prototype.txtEndYobi = function () {
                return new UZA.TextBox(this.convFiledName("txtEndYobi"));
            };

            Controls.prototype.txtEndHHMM = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtEndHHMM"));
            };

            Controls.prototype.linMadoguti = function () {
                return new UZA.HorizontalLine(this.convFiledName("linMadoguti"));
            };

            Controls.prototype.radKoza = function () {
                return new UZA.RadioButton(this.convFiledName("radKoza"));
            };

            Controls.prototype.ddlKozaID = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKozaID"));
            };

            Controls.prototype.btnKozaToroku = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKozaToroku"));
            };

            Controls.prototype.txtKinyuKikanCode = function () {
                return new UZA.TextBoxKinyuKikanCode(this.convFiledName("txtKinyuKikanCode"));
            };

            Controls.prototype.txtKinyuKikanShitenCode = function () {
                return new UZA.TextBoxKinyuKikanShitenCode(this.convFiledName("txtKinyuKikanShitenCode"));
            };

            Controls.prototype.txtTenban = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtTenban"));
            };

            Controls.prototype.txtYokinShubetsu = function () {
                return new UZA.TextBox(this.convFiledName("txtYokinShubetsu"));
            };

            Controls.prototype.txtKozaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKozaNo"));
            };

            Controls.prototype.txtKinyuKikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtKinyuKikanName"));
            };

            Controls.prototype.txtMeigininKana = function () {
                return new UZA.TextBoxAtenaKanaMeisho(this.convFiledName("txtMeigininKana"));
            };

            Controls.prototype.ttxtMeigininKanji = function () {
                return new UZA.TextBoxAtenaMeisho(this.convFiledName("ttxtMeigininKanji"));
            };

            Controls.prototype.linKoza = function () {
                return new UZA.HorizontalLine(this.convFiledName("linKoza"));
            };

            Controls.prototype.radJyryoinin = function () {
                return new UZA.RadioButton(this.convFiledName("radJyryoinin"));
            };

            Controls.prototype.txtKeiyakuNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKeiyakuNo"));
            };

            Controls.prototype.btnSelect = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnSelect"));
            };

            Controls.prototype.txtKeiyakuCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKeiyakuCode"));
            };

            Controls.prototype.txtKeiyakuName = function () {
                return new UZA.TextBoxAtenaMeisho(this.convFiledName("txtKeiyakuName"));
            };

            Controls.prototype.txtKinyuKikanCode1 = function () {
                return new UZA.TextBoxKinyuKikanCode(this.convFiledName("txtKinyuKikanCode1"));
            };

            Controls.prototype.txtKinyuKikanShitenCode1 = function () {
                return new UZA.TextBoxKinyuKikanShitenCode(this.convFiledName("txtKinyuKikanShitenCode1"));
            };

            Controls.prototype.txtTenban1 = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtTenban1"));
            };

            Controls.prototype.txtYokinShubetsu1 = function () {
                return new UZA.TextBox(this.convFiledName("txtYokinShubetsu1"));
            };

            Controls.prototype.txtKozaNo1 = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKozaNo1"));
            };

            Controls.prototype.txtKinyuKikanName1 = function () {
                return new UZA.TextBox(this.convFiledName("txtKinyuKikanName1"));
            };

            Controls.prototype.txtMeigininKana1 = function () {
                return new UZA.TextBoxAtenaKanaMeisho(this.convFiledName("txtMeigininKana1"));
            };

            Controls.prototype.txtMeigininKanji1 = function () {
                return new UZA.TextBoxAtenaMeisho(this.convFiledName("txtMeigininKanji1"));
            };
            return Controls;
        })();
        ShiharaiHohoJyoho.Controls = Controls;
    })(DBC.ShiharaiHohoJyoho || (DBC.ShiharaiHohoJyoho = {}));
    var ShiharaiHohoJyoho = DBC.ShiharaiHohoJyoho;
})(DBC || (DBC = {}));
