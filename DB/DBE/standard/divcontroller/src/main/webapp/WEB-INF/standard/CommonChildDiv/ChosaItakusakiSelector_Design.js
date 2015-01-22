var DBE;
(function (DBE) {
    (function (ChosaItakusakiSelector) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelect_dgChosaItakusakiList = function () {
                return "onSelect_dgChosaItakusakiList";
            };

            Events.onSelectByDC_ChosaItakusaki = function () {
                return "onSelectByDC_ChosaItakusaki";
            };

            Events.onSelectBySB_ChosaItakusaki = function () {
                return "onSelectBySB_ChosaItakusaki";
            };

            Events.onSelectByDC_Chosain = function () {
                return "onSelectByDC_Chosain";
            };

            Events.onSelectBySB_Chosain = function () {
                return "onSelectBySB_Chosain";
            };

            Events.onClick_btnSelectAndClose = function () {
                return "onClick_btnSelectAndClose";
            };

            Events.onClick_btnNonSelectReturn = function () {
                return "onClick_btnNonSelectReturn";
            };
            return Events;
        })();
        ChosaItakusakiSelector.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ChosaItakusakiSelector";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.ChosaItakusakiSelector.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.ChosaItakusakiSelector.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ChosaItakusakiSelector = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ChosaItakusaki = function () {
                return new UZA.Panel(this.convFiledName("ChosaItakusaki"));
            };

            Controls.prototype.ChosaItakusakiList = function () {
                return new UZA.Panel(this.convFiledName("ChosaItakusaki_ChosaItakusakiList"));
            };

            Controls.prototype.btnToMentenanceChosaKikan = function () {
                return new UZA.Button(this.convFiledName("btnToMentenanceChosaKikan"));
            };

            Controls.prototype.dgChosaItakusakiList = function () {
                return new UZA.DataGrid(this.convFiledName("dgChosaItakusakiList"));
            };

            Controls.prototype.Chosain = function () {
                return new UZA.Panel(this.convFiledName("ChosaItakusaki_Chosain"));
            };

            Controls.prototype.spaChosain = function () {
                return new UZA.Space(this.convFiledName("spaChosain"));
            };

            Controls.prototype.ChosainList = function () {
                return new UZA.Panel(this.convFiledName("ChosaItakusaki_Chosain_ChosainList"));
            };

            Controls.prototype.dgChosainList = function () {
                return new UZA.DataGrid(this.convFiledName("dgChosainList"));
            };

            Controls.prototype.SelectedContents = function () {
                return new UZA.Panel(this.convFiledName("SelectedContents"));
            };

            Controls.prototype.txtChosaItakusakiCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtChosaItakusakiCode"));
            };

            Controls.prototype.txtChosaItakusakiName = function () {
                return new UZA.TextBox(this.convFiledName("txtChosaItakusakiName"));
            };

            Controls.prototype.txtChosainCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtChosainCode"));
            };

            Controls.prototype.txtChosainName = function () {
                return new UZA.TextBox(this.convFiledName("txtChosainName"));
            };

            Controls.prototype.btnSelectAndClose = function () {
                return new UZA.Button(this.convFiledName("btnSelectAndClose"));
            };

            Controls.prototype.btnNonSelectReturn = function () {
                return new UZA.Button(this.convFiledName("btnNonSelectReturn"));
            };
            return Controls;
        })();
        ChosaItakusakiSelector.Controls = Controls;
    })(DBE.ChosaItakusakiSelector || (DBE.ChosaItakusakiSelector = {}));
    var ChosaItakusakiSelector = DBE.ChosaItakusakiSelector;
})(DBE || (DBE = {}));
