var DBC;
(function (DBC) {
    (function (ShikibetsuBangoSelector) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnSearch = function () {
                return "onClick_btnSearch";
            };

            Events.CloseCancel = function () {
                return "CloseCancel";
            };
            return Events;
        })();
        ShikibetsuBangoSelector.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShikibetsuBangoSelector";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.ShikibetsuBangoSelector.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.ShikibetsuBangoSelector.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShikibetsuBangoSelector = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtShikibetsuCode = function () {
                return new UZA.TextBoxShikibetsuCode(this.convFiledName("txtShikibetsuCode"));
            };

            Controls.prototype.txtShiyoCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShiyoCode"));
            };

            Controls.prototype.txtKinjunYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKinjunYM"));
            };

            Controls.prototype.btnSearch = function () {
                return new UZA.Button(this.convFiledName("btnSearch"));
            };

            Controls.prototype.dgDetail = function () {
                return new UZA.DataGrid(this.convFiledName("dgDetail"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };
            return Controls;
        })();
        ShikibetsuBangoSelector.Controls = Controls;
    })(DBC.ShikibetsuBangoSelector || (DBC.ShikibetsuBangoSelector = {}));
    var ShikibetsuBangoSelector = DBC.ShikibetsuBangoSelector;
})(DBC || (DBC = {}));
