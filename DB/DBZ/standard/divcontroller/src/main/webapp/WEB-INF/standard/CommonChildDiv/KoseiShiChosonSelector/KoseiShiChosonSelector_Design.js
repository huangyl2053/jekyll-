var DBZ;
(function (DBZ) {
    (function (KoseiShiChosonSelector) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_Kensaku = function () {
                return "onClick_Kensaku";
            };

            Events.onClick_Moderu = function () {
                return "onClick_Moderu";
            };
            return Events;
        })();
        KoseiShiChosonSelector.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KoseiShiChosonSelector";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KoseiShiChosonSelector.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KoseiShiChosonSelector.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KoseiShiChosonSelector = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgKoseiShichosonList = function () {
                return new UZA.DataGrid(this.convFiledName("dgKoseiShichosonList"));
            };

            Controls.prototype.btnback = function () {
                return new UZA.Button(this.convFiledName("btnback"));
            };
            return Controls;
        })();
        KoseiShiChosonSelector.Controls = Controls;
    })(DBZ.KoseiShiChosonSelector || (DBZ.KoseiShiChosonSelector = {}));
    var KoseiShiChosonSelector = DBZ.KoseiShiChosonSelector;
})(DBZ || (DBZ = {}));
