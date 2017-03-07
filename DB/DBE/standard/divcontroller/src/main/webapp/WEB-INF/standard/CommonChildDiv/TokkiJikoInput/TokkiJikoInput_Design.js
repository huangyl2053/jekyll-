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

            Events.onChange_txtTokkiJiko = function () {
                return "onChange_txtTokkiJiko";
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

            Events.onClick_btnReturn = function () {
                return "onClick_btnReturn";
            };

            Events.onClick_btnUpdateCancel = function () {
                return "onClick_btnUpdateCancel";
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

            Controls.prototype.btnReturn = function () {
                return new UZA.Button(this.convFiledName("btnReturn"));
            };

            Controls.prototype.btnUpdateCancel = function () {
                return new UZA.Button(this.convFiledName("btnUpdateCancel"));
            };
            return Controls;
        })();
        TokkiJikoInput.Controls = Controls;
    })(DBE.TokkiJikoInput || (DBE.TokkiJikoInput = {}));
    var TokkiJikoInput = DBE.TokkiJikoInput;
})(DBE || (DBE = {}));
