var DBX;
(function (DBX) {
    (function (JigyoshaSearchConditionCommon) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        JigyoshaSearchConditionCommon.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JigyoshaSearchConditionCommon";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBX.JigyoshaSearchConditionCommon.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBX.JigyoshaSearchConditionCommon.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JigyoshaSearchConditionCommon = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtSearchJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtSearchJigyoshaNo"));
            };

            Controls.prototype.txtSearchJigyoshaKaishiDateRange = function () {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSearchJigyoshaKaishiDateRange"));
            };

            Controls.prototype.txtSearchJigyoshaMeiOrKanaMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtSearchJigyoshaMeiOrKanaMeisho"));
            };

            Controls.prototype.ddlSearchMeishoMatchCondition = function () {
                return new UZA.DropDownList(this.convFiledName("ddlSearchMeishoMatchCondition"));
            };

            Controls.prototype.txtSearchYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtSearchYubinNo"));
            };

            Controls.prototype.txtSearchJusho = function () {
                return new UZA.TextBox(this.convFiledName("txtSearchJusho"));
            };
            return Controls;
        })();
        JigyoshaSearchConditionCommon.Controls = Controls;
    })(DBX.JigyoshaSearchConditionCommon || (DBX.JigyoshaSearchConditionCommon = {}));
    var JigyoshaSearchConditionCommon = DBX.JigyoshaSearchConditionCommon;
})(DBX || (DBX = {}));
