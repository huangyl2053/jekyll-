var DBE;
(function (DBE) {
    (function (ShinsakaiIinList) {
        var Events = (function () {
            function Events() {
            }
            Events.CloseCancel = function () {
                return "CloseCancel";
            };
            return Events;
        })();
        ShinsakaiIinList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShinsakaiIinList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.ShinsakaiIinList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.ShinsakaiIinList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShinsakaiIinList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgShinsakaiIinChildList = function () {
                return new UZA.DataGrid(this.convFiledName("dgShinsakaiIinChildList"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        ShinsakaiIinList.Controls = Controls;
    })(DBE.ShinsakaiIinList || (DBE.ShinsakaiIinList = {}));
    var ShinsakaiIinList = DBE.ShinsakaiIinList;
})(DBE || (DBE = {}));
