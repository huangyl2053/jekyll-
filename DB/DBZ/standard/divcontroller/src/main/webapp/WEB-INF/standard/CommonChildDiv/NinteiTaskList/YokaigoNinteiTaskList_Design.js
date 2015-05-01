var DBZ;
(function (DBZ) {
    (function (YokaigoNinteiTaskList) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        YokaigoNinteiTaskList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "YokaigoNinteiTaskList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.YokaigoNinteiTaskList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.YokaigoNinteiTaskList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.YokaigoNinteiTaskList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.NarabekaeJoken = function () {
                return new UZA.Panel(this.convFiledName("NarabekaeJoken"));
            };

            Controls.prototype.ddlFirstPriority = function () {
                return new UZA.DropDownList(this.convFiledName("ddlFirstPriority"));
            };

            Controls.prototype.ddlSecondPriority = function () {
                return new UZA.DropDownList(this.convFiledName("ddlSecondPriority"));
            };

            Controls.prototype.ddlThirdPriority = function () {
                return new UZA.DropDownList(this.convFiledName("ddlThirdPriority"));
            };

            Controls.prototype.btnNarabekae = function () {
                return new UZA.Button(this.convFiledName("btnNarabekae"));
            };

            Controls.prototype.NinteiTaskIchiran = function () {
                return new UZA.PanelBatchParameter(this.convFiledName("NinteiTaskIchiran"));
            };

            Controls.prototype.txtCompleteCount = function () {
                return new UZA.TextBox(this.convFiledName("txtCompleteCount"));
            };

            Controls.prototype.txtTotalCount = function () {
                return new UZA.TextBox(this.convFiledName("txtTotalCount"));
            };

            Controls.prototype.txtNarabekae = function () {
                return new UZA.Button(this.convFiledName("txtNarabekae"));
            };

            Controls.prototype.dgNinteiTaskList = function () {
                return new UZA.DataGrid(this.convFiledName("dgNinteiTaskList"));
            };

            Controls.prototype.btnCSVShutsuryoku = function () {
                return new UZA.ButtonBatchRegister(this.convFiledName("btnCSVShutsuryoku"));
            };

            Controls.prototype.btnIchiranhyoShutsuryoku = function () {
                return new UZA.ButtonBatchRegister(this.convFiledName("btnIchiranhyoShutsuryoku"));
            };
            return Controls;
        })();
        YokaigoNinteiTaskList.Controls = Controls;
    })(DBZ.YokaigoNinteiTaskList || (DBZ.YokaigoNinteiTaskList = {}));
    var YokaigoNinteiTaskList = DBZ.YokaigoNinteiTaskList;
})(DBZ || (DBZ = {}));
