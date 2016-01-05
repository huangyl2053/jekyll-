var DBA;
(function (DBA) {
    (function (RoreiFukushiNenkinShokai) {
        var Events = (function () {
            function Events() {
            }
            Events.Add = function () {
                return "Add";
            };

            Events.Update = function () {
                return "Update";
            };

            Events.Delete = function () {
                return "Delete";
            };

            Events.btnSave = function () {
                return "btnSave";
            };

            Events.Cancel = function () {
                return "Cancel";
            };
            return Events;
        })();
        RoreiFukushiNenkinShokai.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "RoreiFukushiNenkinShokai";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBA.RoreiFukushiNenkinShokai.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBA.RoreiFukushiNenkinShokai.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.RoreiFukushiNenkinShokai = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.panelRireki = function () {
                return new UZA.Panel(this.convFiledName("panelRireki"));
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.datagridRireki = function () {
                return new UZA.DataGrid(this.convFiledName("datagridRireki"));
            };

            Controls.prototype.panelInput = function () {
                return new UZA.Panel(this.convFiledName("panelInput"));
            };

            Controls.prototype.txtStartDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtStartDate"));
            };

            Controls.prototype.txtEndDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtEndDate"));
            };

            Controls.prototype.btnSave = function () {
                return new UZA.Button(this.convFiledName("btnSave"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };
            return Controls;
        })();
        RoreiFukushiNenkinShokai.Controls = Controls;
    })(DBA.RoreiFukushiNenkinShokai || (DBA.RoreiFukushiNenkinShokai = {}));
    var RoreiFukushiNenkinShokai = DBA.RoreiFukushiNenkinShokai;
})(DBA || (DBA = {}));
