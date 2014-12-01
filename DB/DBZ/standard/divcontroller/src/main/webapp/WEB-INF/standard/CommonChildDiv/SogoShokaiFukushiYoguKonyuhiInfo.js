var DBZ;
(function (DBZ) {
    (function (SogoShokaiFukushiYoguKonyuhiInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        SogoShokaiFukushiYoguKonyuhiInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SogoShokaiFukushiYoguKonyuhiInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SogoShokaiFukushiYoguKonyuhiInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SogoShokaiFukushiYoguKonyuhiInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SogoShokaiFukushiYoguKonyuhiInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtTeikyoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTeikyoYM"));
            };

            Controls.prototype.txtSeiriNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtSeiriNo"));
            };

            Controls.prototype.txtKyufuritsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKyufuritsu"));
            };

            Controls.prototype.dgYoguSeikyuDetail = function () {
                return new UZA.DataGrid(this.convFiledName("dgYoguSeikyuDetail"));
            };

            Controls.prototype.YoguKonyuhiShikyuShinseiSeikyuDetail = function () {
                return new UZA.Panel(this.convFiledName("YoguKonyuhiShikyuShinseiSeikyuDetail"));
            };

            Controls.prototype.txtBuyYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtBuyYMD"));
            };

            Controls.prototype.txtShumoku = function () {
                return new UZA.TextBox(this.convFiledName("txtShumoku"));
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

            Controls.prototype.txtShinsaMethod = function () {
                return new UZA.TextBox(this.convFiledName("txtShinsaMethod"));
            };

            Controls.prototype.tblYoguSeikyuSummary = function () {
                return new UZA.TablePanel(this.convFiledName("tblYoguSeikyuSummary"));
            };

            Controls.prototype.celYogu11 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu11"));
            };

            Controls.prototype.lblYoguSummary = function () {
                return new UZA.Label(this.convFiledName("lblYoguSummary"));
            };

            Controls.prototype.celYogu12 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu12"));
            };

            Controls.prototype.lblYoguPayTotal = function () {
                return new UZA.Label(this.convFiledName("lblYoguPayTotal"));
            };

            Controls.prototype.celYogu13 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu13"));
            };

            Controls.prototype.lblYoguHokenSeikyuAmount = function () {
                return new UZA.Label(this.convFiledName("lblYoguHokenSeikyuAmount"));
            };

            Controls.prototype.celYogu14 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu14"));
            };

            Controls.prototype.lblYoguRiyoshaFutanAmount = function () {
                return new UZA.Label(this.convFiledName("lblYoguRiyoshaFutanAmount"));
            };

            Controls.prototype.celYogu15 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu15"));
            };

            Controls.prototype.lblYoguLimitOverAmount = function () {
                return new UZA.Label(this.convFiledName("lblYoguLimitOverAmount"));
            };

            Controls.prototype.celYogu21 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu21"));
            };

            Controls.prototype.lblYoguSummaryMae = function () {
                return new UZA.Label(this.convFiledName("lblYoguSummaryMae"));
            };

            Controls.prototype.celYogu22 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu22"));
            };

            Controls.prototype.txtYoguPayTotalMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguPayTotalMae"));
            };

            Controls.prototype.celYogu23 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu23"));
            };

            Controls.prototype.txtYoguHokenSeikyuAmountMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguHokenSeikyuAmountMae"));
            };

            Controls.prototype.celYogu24 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu24"));
            };

            Controls.prototype.txtYoguRiyoshaFutanAmountMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguRiyoshaFutanAmountMae"));
            };

            Controls.prototype.celYogu25 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu25"));
            };

            Controls.prototype.txtYoguLimitOverAmountMae = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguLimitOverAmountMae"));
            };

            Controls.prototype.celYogu31 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu31"));
            };

            Controls.prototype.lblYoguSummaryNow = function () {
                return new UZA.Label(this.convFiledName("lblYoguSummaryNow"));
            };

            Controls.prototype.celYogu32 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu32"));
            };

            Controls.prototype.txtYoguPayTotalNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguPayTotalNow"));
            };

            Controls.prototype.celYogu33 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu33"));
            };

            Controls.prototype.txtYoguHokenSeikyuAmountNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguHokenSeikyuAmountNow"));
            };

            Controls.prototype.celYogu34 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu34"));
            };

            Controls.prototype.txtYoguRiyoshaFutanAmountNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguRiyoshaFutanAmountNow"));
            };

            Controls.prototype.celYogu35 = function () {
                return new UZA.TableCell(this.convFiledName("celYogu35"));
            };

            Controls.prototype.txtYoguLimitOverAmountNow = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtYoguLimitOverAmountNow"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        SogoShokaiFukushiYoguKonyuhiInfo.Controls = Controls;
    })(DBZ.SogoShokaiFukushiYoguKonyuhiInfo || (DBZ.SogoShokaiFukushiYoguKonyuhiInfo = {}));
    var SogoShokaiFukushiYoguKonyuhiInfo = DBZ.SogoShokaiFukushiYoguKonyuhiInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiFukushiYoguKonyuhiInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiFukushiYoguKonyuhiInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SogoShokaiFukushiYoguKonyuhiInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiFukushiYoguKonyuhiInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiFukushiYoguKonyuhiInfo || (DBZ.SogoShokaiFukushiYoguKonyuhiInfo = {}));
    var SogoShokaiFukushiYoguKonyuhiInfo = DBZ.SogoShokaiFukushiYoguKonyuhiInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiFukushiYoguKonyuhiInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiFukushiYoguKonyuhiInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiFukushiYoguKonyuhiInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiFukushiYoguKonyuhiInfo || (DBZ.SogoShokaiFukushiYoguKonyuhiInfo = {}));
    var SogoShokaiFukushiYoguKonyuhiInfo = DBZ.SogoShokaiFukushiYoguKonyuhiInfo;
})(DBZ || (DBZ = {}));
