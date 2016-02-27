var DBC;
(function (DBC) {
    (function (ShokanShinseiList) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_InsertButton = function () {
                return "onClick_InsertButton";
            };

            Events.onSelectByDbClick = function () {
                return "onSelectByDbClick";
            };

            Events.onClick_SelectButton = function () {
                return "onClick_SelectButton";
            };

            Events.onClick_ModifyButton = function () {
                return "onClick_ModifyButton";
            };

            Events.onClick_DeleteButton = function () {
                return "onClick_DeleteButton";
            };
            return Events;
        })();
        ShokanShinseiList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShokanShinseiList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.ShokanShinseiList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.ShokanShinseiList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShokanShinseiList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtServiceYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtServiceYM"));
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.line = function () {
                return new UZA.HorizontalLine(this.convFiledName("line"));
            };

            Controls.prototype.txtServiceYMFrom = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtServiceYMFrom"));
            };

            Controls.prototype.txtServiceYMTo = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtServiceYMTo"));
            };

            Controls.prototype.btnSelect = function () {
                return new UZA.Button(this.convFiledName("btnSelect"));
            };

            Controls.prototype.dgShinseiList = function () {
                return new UZA.DataGrid(this.convFiledName("dgShinseiList"));
            };
            return Controls;
        })();
        ShokanShinseiList.Controls = Controls;
    })(DBC.ShokanShinseiList || (DBC.ShokanShinseiList = {}));
    var ShokanShinseiList = DBC.ShokanShinseiList;
})(DBC || (DBC = {}));
