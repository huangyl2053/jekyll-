var DBX;
(function (DBX) {
    (function (JigyoshaSearchConditionOption) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_radIncludeKyushiHaishi = function () {
                return "onClick_radIncludeKyushiHaishi";
            };

            Events.onClick_radShowRireki = function () {
                return "onClick_radShowRireki";
            };

            Events.onClick_btnSearch = function () {
                return "onClick_btnSearch";
            };
            return Events;
        })();
        JigyoshaSearchConditionOption.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JigyoshaSearchConditionOption";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBX.JigyoshaSearchConditionOption.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBX.JigyoshaSearchConditionOption.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JigyoshaSearchConditionOption = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.chkOutputKyushiHaishi = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkOutputKyushiHaishi"));
            };

            Controls.prototype.chkOutputShisetsuRireki = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkOutputShisetsuRireki"));
            };

            Controls.prototype.txtMaxNum = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtMaxNum"));
            };

            Controls.prototype.btnSearchShisetsu = function () {
                return new UZA.Button(this.convFiledName("btnSearchShisetsu"));
            };
            return Controls;
        })();
        JigyoshaSearchConditionOption.Controls = Controls;
    })(DBX.JigyoshaSearchConditionOption || (DBX.JigyoshaSearchConditionOption = {}));
    var JigyoshaSearchConditionOption = DBX.JigyoshaSearchConditionOption;
})(DBX || (DBX = {}));
