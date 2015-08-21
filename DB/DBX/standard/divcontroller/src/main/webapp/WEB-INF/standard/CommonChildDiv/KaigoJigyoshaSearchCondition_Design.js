var DBX;
(function (DBX) {
    (function (KaigoJigyoshaSearchCondition) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoJigyoshaSearchCondition.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoJigyoshaSearchCondition";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBX.KaigoJigyoshaSearchCondition.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBX.KaigoJigyoshaSearchCondition.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoJigyoshaSearchCondition = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ServiceJigyoshaSearchCondition = function () {
                return new UZA.Panel(this.convFiledName("ServiceJigyoshaSearchCondition"));
            };

            Controls.prototype.ddlSearchPrefecturesCode = function () {
                return new UZA.DropDownList(this.convFiledName("ddlSearchPrefecturesCode"));
            };

            Controls.prototype.ddlSearchJigyoshaKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlSearchJigyoshaKubun"));
            };

            Controls.prototype.ddlSearchToshiCode = function () {
                return new UZA.DropDownList(this.convFiledName("ddlSearchToshiCode"));
            };

            Controls.prototype.ddlSearchServiceType = function () {
                return new UZA.DropDownList(this.convFiledName("ddlSearchServiceType"));
            };
            return Controls;
        })();
        KaigoJigyoshaSearchCondition.Controls = Controls;
    })(DBX.KaigoJigyoshaSearchCondition || (DBX.KaigoJigyoshaSearchCondition = {}));
    var KaigoJigyoshaSearchCondition = DBX.KaigoJigyoshaSearchCondition;
})(DBX || (DBX = {}));
