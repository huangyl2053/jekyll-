var DBZ;
(function (DBZ) {
    (function (ServiceInputGuide) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnSearchJigyosha = function () {
                return "onClick_btnSearchJigyosha";
            };

            Events.onSelectBySelectButton_SearchResultService = function () {
                return "onSelectBySelectButton_SearchResultService";
            };

            Events.onClick_btnServiceInputGuideReturn = function () {
                return "onClick_btnServiceInputGuideReturn";
            };
            return Events;
        })();
        ServiceInputGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ServiceInputGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ServiceInputGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ServiceInputGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ServiceInputGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtServiceShuruiCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceShuruiCode"));
            };

            Controls.prototype.txtServiceCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtServiceCode"));
            };

            Controls.prototype.txtKijyunYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKijyunYM"));
            };

            Controls.prototype.btnSearchJService = function () {
                return new UZA.Button(this.convFiledName("btnSearchJService"));
            };

            Controls.prototype.SearchResultService = function () {
                return new UZA.Panel(this.convFiledName("SearchResultService"));
            };

            Controls.prototype.dgSearchResultService = function () {
                return new UZA.DataGrid(this.convFiledName("dgSearchResultService"));
            };

            Controls.prototype.btnServiceInputGuideReturn = function () {
                return new UZA.Button(this.convFiledName("btnServiceInputGuideReturn"));
            };
            return Controls;
        })();
        ServiceInputGuide.Controls = Controls;
    })(DBZ.ServiceInputGuide || (DBZ.ServiceInputGuide = {}));
    var ServiceInputGuide = DBZ.ServiceInputGuide;
})(DBZ || (DBZ = {}));
