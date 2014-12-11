var DBZ;
(function (DBZ) {
    (function (SogoShokaiJutakuKaishuhiInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnModify = function () {
                return "onClick_btnModify";
            };

            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        SogoShokaiJutakuKaishuhiInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SogoShokaiJutakuKaishuhiInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SogoShokaiJutakuKaishuhiInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SogoShokaiJutakuKaishuhiInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SogoShokaiJutakuKaishuhiInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtJutakuOwner = function () {
                return new UZA.TextBox(this.convFiledName("txtJutakuOwner"));
            };

            Controls.prototype.txtRelationWithHihokensha = function () {
                return new UZA.TextBox(this.convFiledName("txtRelationWithHihokensha"));
            };

            Controls.prototype.dgJutakuKaishuDetail = function () {
                return new UZA.DataGrid(this.convFiledName("dgJutakuKaishuDetail"));
            };

            Controls.prototype.JutakuKaishuDetail = function () {
                return new UZA.Panel(this.convFiledName("JutakuKaishuDetail"));
            };

            Controls.prototype.txtKaishuContents = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKaishuContents"));
            };

            Controls.prototype.txtKaishuJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtKaishuJigyoshaName"));
            };

            Controls.prototype.txtKaishuTaishoAddress1 = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtKaishuTaishoAddress1"));
            };

            Controls.prototype.txtChakkoDueDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtChakkoDueDate"));
            };

            Controls.prototype.txtKanseiDueDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKanseiDueDate"));
            };

            Controls.prototype.txtEstimatedAmount = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtEstimatedAmount"));
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

            Controls.prototype.lblHiyoTotal = function () {
                return new UZA.Label(this.convFiledName("lblHiyoTotal"));
            };

            Controls.prototype.cel13 = function () {
                return new UZA.TableCell(this.convFiledName("cel13"));
            };

            Controls.prototype.lblHokenTaishoHiyo = function () {
                return new UZA.Label(this.convFiledName("lblHokenTaishoHiyo"));
            };

            Controls.prototype.cel14 = function () {
                return new UZA.TableCell(this.convFiledName("cel14"));
            };

            Controls.prototype.lblHokenKyufuAmount = function () {
                return new UZA.Label(this.convFiledName("lblHokenKyufuAmount"));
            };

            Controls.prototype.cel15 = function () {
                return new UZA.TableCell(this.convFiledName("cel15"));
            };

            Controls.prototype.lblRiyoshaFutanAmount = function () {
                return new UZA.Label(this.convFiledName("lblRiyoshaFutanAmount"));
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

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        SogoShokaiJutakuKaishuhiInfo.Controls = Controls;
    })(DBZ.SogoShokaiJutakuKaishuhiInfo || (DBZ.SogoShokaiJutakuKaishuhiInfo = {}));
    var SogoShokaiJutakuKaishuhiInfo = DBZ.SogoShokaiJutakuKaishuhiInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SogoShokaiJutakuKaishuhiInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SogoShokaiJutakuKaishuhiInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SogoShokaiJutakuKaishuhiInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SogoShokaiJutakuKaishuhiInfo.ModeController = ModeController;
    })(DBZ.SogoShokaiJutakuKaishuhiInfo || (DBZ.SogoShokaiJutakuKaishuhiInfo = {}));
    var SogoShokaiJutakuKaishuhiInfo = DBZ.SogoShokaiJutakuKaishuhiInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SogoShokaiJutakuKaishuhiInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SogoShokaiJutakuKaishuhiInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SogoShokaiJutakuKaishuhiInfo.PublicProperties = PublicProperties;
    })(DBZ.SogoShokaiJutakuKaishuhiInfo || (DBZ.SogoShokaiJutakuKaishuhiInfo = {}));
    var SogoShokaiJutakuKaishuhiInfo = DBZ.SogoShokaiJutakuKaishuhiInfo;
})(DBZ || (DBZ = {}));
