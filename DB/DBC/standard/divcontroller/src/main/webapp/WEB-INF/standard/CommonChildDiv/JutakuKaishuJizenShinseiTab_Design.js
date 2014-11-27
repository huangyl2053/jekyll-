var DBC;
(function (DBC) {
    (function (JutakuKaishuJizenShinseiTab) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        JutakuKaishuJizenShinseiTab.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JutakuKaishuJizenShinseiTab";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.JutakuKaishuJizenShinseiTab.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.JutakuKaishuJizenShinseiTab.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JutakuKaishuJizenShinseiTab = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.tabJizenShinsei = function () {
                return new UZA.TabContainer(this.convFiledName("tabJizenShinsei"));
            };

            Controls.prototype.tplJizenShinseiContents = function () {
                return new UZA.TabPanel(this.convFiledName("tplJizenShinseiContents"));
            };

            Controls.prototype.txtJutakuOwner = function () {
                return new UZA.TextBox(this.convFiledName("txtJutakuOwner"));
            };

            Controls.prototype.txtRelationWithHihokensha = function () {
                return new UZA.TextBox(this.convFiledName("txtRelationWithHihokensha"));
            };

            Controls.prototype.dgJutakuKaishuJizenShinseiDetail = function () {
                return new UZA.DataGrid(this.convFiledName("dgJutakuKaishuJizenShinseiDetail"));
            };

            Controls.prototype.JutakuKaishuJizenShinseiReasonForTab = function () {
                return new UZA.Panel(this.convFiledName("JutakuKaishuJizenShinseiReasonForTab"));
            };

            Controls.prototype.txtCreateDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtCreateDate"));
            };

            Controls.prototype.txtCreatorKanaName = function () {
                return new UZA.TextBox(this.convFiledName("txtCreatorKanaName"));
            };

            Controls.prototype.txtCreatorName = function () {
                return new UZA.TextBox(this.convFiledName("txtCreatorName"));
            };

            Controls.prototype.txtCreationJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtCreationJigyoshaNo"));
            };

            Controls.prototype.txtCreationJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtCreationJigyoshaName"));
            };

            Controls.prototype.tplJizenShinseiResult = function () {
                return new UZA.TabPanel(this.convFiledName("tplJizenShinseiResult"));
            };

            Controls.prototype.hl = function () {
                return new UZA.HorizontalLine(this.convFiledName("hl"));
            };

            Controls.prototype.txtJudgeDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtJudgeDate"));
            };

            Controls.prototype.radJudgeKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radJudgeKubun"));
            };

            Controls.prototype.txtShoninCondition = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShoninCondition"));
            };

            Controls.prototype.txtFushoninReason = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtFushoninReason"));
            };

            Controls.prototype.chkResetInfo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkResetInfo"));
            };

            Controls.prototype.tplJizenShinseiPayMethod = function () {
                return new UZA.TabPanel(this.convFiledName("tplJizenShinseiPayMethod"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        JutakuKaishuJizenShinseiTab.Controls = Controls;
    })(DBC.JutakuKaishuJizenShinseiTab || (DBC.JutakuKaishuJizenShinseiTab = {}));
    var JutakuKaishuJizenShinseiTab = DBC.JutakuKaishuJizenShinseiTab;
})(DBC || (DBC = {}));
