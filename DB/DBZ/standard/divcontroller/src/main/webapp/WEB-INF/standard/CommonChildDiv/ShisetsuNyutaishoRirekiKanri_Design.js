var DBZ;
(function (DBZ) {
    (function (ShisetsuNyutaishoRirekiKanri) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAddShisetsuNyutaisho = function () {
                return "onClick_btnAddShisetsuNyutaisho";
            };

            Events.onSelect_dgShisetsuNyutaishoRireki = function () {
                return "onSelect_dgShisetsuNyutaishoRireki";
            };

            Events.onSelectByDblClick_dgShisetsuNyutaishoRireki = function () {
                return "onSelectByDblClick_dgShisetsuNyutaishoRireki";
            };

            Events.onSelectBySelectButton_dgShisetsuNyutaishoRireki = function () {
                return "onSelectBySelectButton_dgShisetsuNyutaishoRireki";
            };

            Events.onSelectByModifyButton_dgShisetsuNyutaishoRireki = function () {
                return "onSelectByModifyButton_dgShisetsuNyutaishoRireki";
            };

            Events.onSelectByDeleteButton_dgShisetsuNyutaishoRireki = function () {
                return "onSelectByDeleteButton_dgShisetsuNyutaishoRireki";
            };
            return Events;
        })();
        ShisetsuNyutaishoRirekiKanri.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShisetsuNyutaishoRirekiKanri";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShisetsuNyutaishoRirekiKanri.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShisetsuNyutaishoRirekiKanri.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShisetsuNyutaishoRirekiKanri = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAddShisetsuNyutaisho = function () {
                return new UZA.Button(this.convFiledName("btnAddShisetsuNyutaisho"));
            };

            Controls.prototype.dgShisetsuNyutaishoRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgShisetsuNyutaishoRireki"));
            };
            return Controls;
        })();
        ShisetsuNyutaishoRirekiKanri.Controls = Controls;
    })(DBZ.ShisetsuNyutaishoRirekiKanri || (DBZ.ShisetsuNyutaishoRirekiKanri = {}));
    var ShisetsuNyutaishoRirekiKanri = DBZ.ShisetsuNyutaishoRirekiKanri;
})(DBZ || (DBZ = {}));
