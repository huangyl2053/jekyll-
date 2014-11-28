var DBC;
(function (DBC) {
    (function (YoguKonyuhiShikyuShinseiSeikyuDetail) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelectBySelectButton = function () {
                return "onSelectBySelectButton";
            };

            Events.onSelectByModifyButton = function () {
                return "onSelectByModifyButton";
            };

            Events.onSelectByDeleteButton = function () {
                return "onSelectByDeleteButton";
            };

            Events.onClick_btnClear = function () {
                return "onClick_btnClear";
            };

            Events.onClick_btnModifyDetail = function () {
                return "onClick_btnModifyDetail";
            };
            return Events;
        })();
        YoguKonyuhiShikyuShinseiSeikyuDetail.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "YoguKonyuhiShikyuShinseiSeikyuDetail";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.YoguKonyuhiShikyuShinseiSeikyuDetail.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.YoguKonyuhiShikyuShinseiSeikyuDetail.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.YoguKonyuhiShikyuShinseiSeikyuDetail = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgSeikyuDetail = function () {
                return new UZA.DataGrid(this.convFiledName("dgSeikyuDetail"));
            };

            Controls.prototype.YoguKonyuhiShikyuShinseiSeikyuDetailInput = function () {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiSeikyuDetailInput"));
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

            Controls.prototype.btnShohinmeiSearch = function () {
                return new UZA.Button(this.convFiledName("btnShohinmeiSearch"));
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

            Controls.prototype.btnModifyDetail = function () {
                return new UZA.Button(this.convFiledName("btnModifyDetail"));
            };
            return Controls;
        })();
        YoguKonyuhiShikyuShinseiSeikyuDetail.Controls = Controls;
    })(DBC.YoguKonyuhiShikyuShinseiSeikyuDetail || (DBC.YoguKonyuhiShikyuShinseiSeikyuDetail = {}));
    var YoguKonyuhiShikyuShinseiSeikyuDetail = DBC.YoguKonyuhiShikyuShinseiSeikyuDetail;
})(DBC || (DBC = {}));
