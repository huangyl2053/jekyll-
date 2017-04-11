var DBE;
(function (DBE) {
    (function (TokkiJikoInput) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_radTokkiJikoGroup = function () {
                return "onChange_radTokkiJikoGroup";
            };

            Events.onChange_ddlTokkiJikoNo = function () {
                return "onChange_ddlTokkiJikoNo";
            };

            Events.onClick_btnInput = function () {
                return "onClick_btnInput";
            };

            Events.onClick_btnAddRemban = function () {
                return "onClick_btnAddRemban";
            };

            Events.onClick_btnSave = function () {
                return "onClick_btnSave";
            };

            Events.onClick_btnCancel = function () {
                return "onClick_btnCancel";
            };

            Events.onClick_btnDelete = function () {
                return "onClick_btnDelete";
            };

            Events.onClick_btnDeleteCancel = function () {
                return "onClick_btnDeleteCancel";
            };

            Events.onClick_dgTokkiBtnModify = function () {
                return "onClick_dgTokkiBtnModify";
            };

            Events.onClick_dgTokkiBtnDelete = function () {
                return "onClick_dgTokkiBtnDelete";
            };

            Events.onClick_btnUpdateReturn = function () {
                return "onClick_btnUpdateReturn";
            };

            Events.onClick_btnCancelReturn = function () {
                return "onClick_btnCancelReturn";
            };
            return Events;
        })();
        TokkiJikoInput.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TokkiJikoInput";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.TokkiJikoInput.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.TokkiJikoInput.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TokkiJikoInput = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ChosaTaishosha = function () {
                return new UZA.Panel(this.convFiledName("ChosaTaishosha"));
            };

            Controls.prototype.ChosaJisshisha = function () {
                return new UZA.Panel(this.convFiledName("ChosaJisshisha"));
            };

            Controls.prototype.TokkiJikoNyuryoku = function () {
                return new UZA.Panel(this.convFiledName("TokkiJikoNyuryoku"));
            };

            Controls.prototype.radTokkiJikoGroup = function () {
                return new UZA.RadioButton(this.convFiledName("radTokkiJikoGroup"));
            };

            Controls.prototype.ddlTokkiJikoNo = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTokkiJikoNo"));
            };

            Controls.prototype.btnInput = function () {
                return new UZA.Button(this.convFiledName("btnInput"));
            };

            Controls.prototype.btnAddRemban = function () {
                return new UZA.Button(this.convFiledName("btnAddRemban"));
            };

            Controls.prototype.txtTokkiJiko = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtTokkiJiko"));
            };

            Controls.prototype.btnSave = function () {
                return new UZA.Button(this.convFiledName("btnSave"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };

            Controls.prototype.btnDelete = function () {
                return new UZA.Button(this.convFiledName("btnDelete"));
            };

            Controls.prototype.btnDeleteCancel = function () {
                return new UZA.Button(this.convFiledName("btnDeleteCancel"));
            };

            Controls.prototype.dgTokkiJikoJoho = function () {
                return new UZA.DataGrid(this.convFiledName("dgTokkiJikoJoho"));
            };

            Controls.prototype.btnUpdateReturn = function () {
                return new UZA.Button(this.convFiledName("btnUpdateReturn"));
            };

            Controls.prototype.btnCancelReturn = function () {
                return new UZA.Button(this.convFiledName("btnCancelReturn"));
            };
            return Controls;
        })();
        TokkiJikoInput.Controls = Controls;
    })(DBE.TokkiJikoInput || (DBE.TokkiJikoInput = {}));
    var TokkiJikoInput = DBE.TokkiJikoInput;
})(DBE || (DBE = {}));
