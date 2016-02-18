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

            Controls.prototype.txtCompleteCount = function () {
                return new UZA.TextBox(this.convFiledName("txtCompleteCount"));
            };

            Controls.prototype.txtTotalCount = function () {
                return new UZA.TextBox(this.convFiledName("txtTotalCount"));
            };

            Controls.prototype.dgNinteiTaskList = function () {
                return new UZA.DataGrid(this.convFiledName("dgNinteiTaskList"));
            };
            return Controls;
        })();
        YokaigoNinteiTaskList.Controls = Controls;
    })(DBZ.YokaigoNinteiTaskList || (DBZ.YokaigoNinteiTaskList = {}));
    var YokaigoNinteiTaskList = DBZ.YokaigoNinteiTaskList;
})(DBZ || (DBZ = {}));
