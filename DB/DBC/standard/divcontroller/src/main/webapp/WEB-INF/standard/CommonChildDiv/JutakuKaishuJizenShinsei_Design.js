var DBC;
(function (DBC) {
    (function (JutakuKaishuJizenShinsei) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        JutakuKaishuJizenShinsei.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JutakuKaishuJizenShinsei";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.JutakuKaishuJizenShinsei.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.JutakuKaishuJizenShinsei.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JutakuKaishuJizenShinsei = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.JutakuKaishuJizenShinseiContents = function () {
                return new UZA.Panel(this.convFiledName("JutakuKaishuJizenShinseiContents"));
            };

            Controls.prototype.txtJutakuOwner = function () {
                return new UZA.TextBox(this.convFiledName("txtJutakuOwner"));
            };

            Controls.prototype.txtRelationWithHihokensha = function () {
                return new UZA.TextBox(this.convFiledName("txtRelationWithHihokensha"));
            };

            Controls.prototype.JutakuKaishuZizenShinseiDetail = function () {
                return new UZA.Panel(this.convFiledName("JutakuKaishuJizenShinseiContents_JutakuKaishuZizenShinseiDetail"));
            };

            Controls.prototype.dgJutakuKaishuJizenShinseiDetail = function () {
                return new UZA.DataGrid(this.convFiledName("dgJutakuKaishuJizenShinseiDetail"));
            };

            Controls.prototype.JutakuKaishuJizenShinseiKyufugakuSummary = function () {
                return new DBC.KyufugakuSummary.ModeController(this.convFiledName("JutakuKaishuJizenShinseiKyufugakuSummary"));
            };

            Controls.prototype.JutakuKaishuJizenShinseiSha = function () {
                return new DBC.ShinseishaInfo.ModeController(this.convFiledName("JutakuKaishuJizenShinseiSha"));
            };

            Controls.prototype.JutakuKaishuJizenShinseiReason = function () {
                return new UZA.Panel(this.convFiledName("JutakuKaishuJizenShinseiContents_JutakuKaishuJizenShinseiReason"));
            };

            Controls.prototype.txtCreateDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtCreateDate"));
            };

            Controls.prototype.txtCreationJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtCreationJigyoshaNo"));
            };

            Controls.prototype.btnSearchCreationJigyoshaName = function () {
                return new UZA.Button(this.convFiledName("btnSearchCreationJigyoshaName"));
            };

            Controls.prototype.txtCreationJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtCreationJigyoshaName"));
            };

            Controls.prototype.txtCreatorKanaName = function () {
                return new UZA.TextBox(this.convFiledName("txtCreatorKanaName"));
            };

            Controls.prototype.txtCreatorName = function () {
                return new UZA.TextBox(this.convFiledName("txtCreatorName"));
            };

            Controls.prototype.JutakuKaishuJizenShinseiKozaInfoMock = function () {
                return new UZA.Panel(this.convFiledName("JutakuKaishuJizenShinseiContents_JutakuKaishuJizenShinseiKozaInfoMock"));
            };

            Controls.prototype.txtKinyuKikanCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKinyuKikanCode"));
            };

            Controls.prototype.txtKinyuKikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtKinyuKikanName"));
            };

            Controls.prototype.radKozaType = function () {
                return new UZA.RadioButton(this.convFiledName("radKozaType"));
            };

            Controls.prototype.txtKozaMeigininKanaName = function () {
                return new UZA.TextBox(this.convFiledName("txtKozaMeigininKanaName"));
            };

            Controls.prototype.txtKinyuBranchCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKinyuBranchCode"));
            };

            Controls.prototype.txtKinyuBranchName = function () {
                return new UZA.TextBox(this.convFiledName("txtKinyuBranchName"));
            };

            Controls.prototype.txtKozaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKozaNo"));
            };

            Controls.prototype.txtKozaMeigininName = function () {
                return new UZA.TextBox(this.convFiledName("txtKozaMeigininName"));
            };

            Controls.prototype.JutakuKaishuJizenShinseiResult = function () {
                return new UZA.Panel(this.convFiledName("JutakuKaishuJizenShinseiResult"));
            };

            Controls.prototype.JutakuKaishuJizenShinseiShinsaResult = function () {
                return new UZA.Panel(this.convFiledName("JutakuKaishuJizenShinseiResult_JutakuKaishuJizenShinseiShinsaResult"));
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

            Controls.prototype.JutakuKaishuJizenShinseiResetInfo = function () {
                return new UZA.Panel(this.convFiledName("JutakuKaishuJizenShinseiResult_JutakuKaishuJizenShinseiResetInfo"));
            };

            Controls.prototype.chkResetInfo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkResetInfo"));
            };

            Controls.prototype.JutakuKaishuJizenShoninKetteiTsuchisho = function () {
                return new UZA.PanelPublish(this.convFiledName("JutakuKaishuJizenShoninKetteiTsuchisho"));
            };

            Controls.prototype.txtHakkoDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtHakkoDate"));
            };
            return Controls;
        })();
        JutakuKaishuJizenShinsei.Controls = Controls;
    })(DBC.JutakuKaishuJizenShinsei || (DBC.JutakuKaishuJizenShinsei = {}));
    var JutakuKaishuJizenShinsei = DBC.JutakuKaishuJizenShinsei;
})(DBC || (DBC = {}));
