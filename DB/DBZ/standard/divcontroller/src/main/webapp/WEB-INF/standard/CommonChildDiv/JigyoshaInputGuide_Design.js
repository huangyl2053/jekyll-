var DBZ;
(function (DBZ) {
    (function (JigyoshaInputGuide) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnSearchJigyosha = function () {
                return "onClick_btnSearchJigyosha";
            };

            Events.onSelectBySelectButton_dgSearchResultJigyosha = function () {
                return "onSelectBySelectButton_dgSearchResultJigyosha";
            };

            Events.onClick_btnKaigoHokenShisetsuReturn = function () {
                return "onClick_btnKaigoHokenShisetsuReturn";
            };
            return Events;
        })();
        JigyoshaInputGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JigyoshaInputGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.JigyoshaInputGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.JigyoshaInputGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JigyoshaInputGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.radJigyoshaSearchType = function () {
                return new UZA.RadioButton(this.convFiledName("radJigyoshaSearchType"));
            };

            Controls.prototype.txtJigyoshaCode = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaCode"));
            };

            Controls.prototype.btnSearchJigyosha = function () {
                return new UZA.Button(this.convFiledName("btnSearchJigyosha"));
            };

            Controls.prototype.SearchResultJigyosha = function () {
                return new UZA.Panel(this.convFiledName("SearchResultJigyosha"));
            };

            Controls.prototype.dgSearchResultJigyosha = function () {
                return new UZA.DataGrid(this.convFiledName("dgSearchResultJigyosha"));
            };

            Controls.prototype.btnKaigoHokenShisetsuReturn = function () {
                return new UZA.Button(this.convFiledName("btnKaigoHokenShisetsuReturn"));
            };
            return Controls;
        })();
        JigyoshaInputGuide.Controls = Controls;
    })(DBZ.JigyoshaInputGuide || (DBZ.JigyoshaInputGuide = {}));
    var JigyoshaInputGuide = DBZ.JigyoshaInputGuide;
})(DBZ || (DBZ = {}));
