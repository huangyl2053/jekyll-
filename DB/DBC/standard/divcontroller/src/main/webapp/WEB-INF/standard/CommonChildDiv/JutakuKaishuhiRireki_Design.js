var DBC;
(function (DBC) {
    (function (JutakuKaishuhiRireki) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        JutakuKaishuhiRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JutakuKaishuhiRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.JutakuKaishuhiRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.JutakuKaishuhiRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JutakuKaishuhiRireki = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgJutakuKaishuRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgJutakuKaishuRireki"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        JutakuKaishuhiRireki.Controls = Controls;
    })(DBC.JutakuKaishuhiRireki || (DBC.JutakuKaishuhiRireki = {}));
    var JutakuKaishuhiRireki = DBC.JutakuKaishuhiRireki;
})(DBC || (DBC = {}));
