var DBC;
(function (DBC) {
    (function (KyufuhiKashitsukekinList) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KyufuhiKashitsukekinList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KyufuhiKashitsukekinList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.KyufuhiKashitsukekinList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.KyufuhiKashitsukekinList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KyufuhiKashitsukekinList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgKyufuhiKashitsukekinList = function () {
                return new UZA.DataGrid(this.convFiledName("dgKyufuhiKashitsukekinList"));
            };
            return Controls;
        })();
        KyufuhiKashitsukekinList.Controls = Controls;
    })(DBC.KyufuhiKashitsukekinList || (DBC.KyufuhiKashitsukekinList = {}));
    var KyufuhiKashitsukekinList = DBC.KyufuhiKashitsukekinList;
})(DBC || (DBC = {}));
