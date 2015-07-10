var DBE;
(function (DBE) {
    (function (IryoKikanSelector) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelect_dgIryoKikanList = function () {
                return "onSelect_dgIryoKikanList";
            };

            Events.onSelectByDC_IryoKikan = function () {
                return "onSelectByDC_IryoKikan";
            };

            Events.onSelectBySB_IryoKikan = function () {
                return "onSelectBySB_IryoKikan";
            };

            Events.onSelectByDC_Ishi = function () {
                return "onSelectByDC_Ishi";
            };

            Events.onSelectBySB_Ishi = function () {
                return "onSelectBySB_Ishi";
            };

            Events.onClick_btnSelectAndClose = function () {
                return "onClick_btnSelectAndClose";
            };

            Events.onClick_btnNonSelectReturn = function () {
                return "onClick_btnNonSelectReturn";
            };
            return Events;
        })();
        IryoKikanSelector.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "IryoKikanSelector";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.IryoKikanSelector.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.IryoKikanSelector.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.IryoKikanSelector = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.IryoKikan = function () {
                return new UZA.Panel(this.convFiledName("IryoKikan"));
            };

            Controls.prototype.IryoKikanList = function () {
                return new UZA.Panel(this.convFiledName("IryoKikan_IryoKikanList"));
            };

            Controls.prototype.btnToMentenanceIryoKikan = function () {
                return new UZA.Button(this.convFiledName("btnToMentenanceIryoKikan"));
            };

            Controls.prototype.dgIryoKikanList = function () {
                return new UZA.DataGrid(this.convFiledName("dgIryoKikanList"));
            };

            Controls.prototype.Ishi = function () {
                return new UZA.Panel(this.convFiledName("IryoKikan_Ishi"));
            };

            Controls.prototype.spaIshi = function () {
                return new UZA.Space(this.convFiledName("spaIshi"));
            };

            Controls.prototype.IshiList = function () {
                return new UZA.Panel(this.convFiledName("IryoKikan_Ishi_IshiList"));
            };

            Controls.prototype.dgIshiList = function () {
                return new UZA.DataGrid(this.convFiledName("dgIshiList"));
            };

            Controls.prototype.SelectedContents = function () {
                return new UZA.Panel(this.convFiledName("SelectedContents"));
            };

            Controls.prototype.txtiryoKikanCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtiryoKikanCode"));
            };

            Controls.prototype.txtiryoKikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtiryoKikanName"));
            };

            Controls.prototype.txtishiCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtishiCode"));
            };

            Controls.prototype.txtishiName = function () {
                return new UZA.TextBox(this.convFiledName("txtishiName"));
            };

            Controls.prototype.btnSelectAndClose = function () {
                return new UZA.Button(this.convFiledName("btnSelectAndClose"));
            };

            Controls.prototype.btnNonSelectReturn = function () {
                return new UZA.Button(this.convFiledName("btnNonSelectReturn"));
            };
            return Controls;
        })();
        IryoKikanSelector.Controls = Controls;
    })(DBE.IryoKikanSelector || (DBE.IryoKikanSelector = {}));
    var IryoKikanSelector = DBE.IryoKikanSelector;
})(DBE || (DBE = {}));
