var DBZ;
(function (DBZ) {
    (function (JushochiTokureiRireki) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAdd = function () {
                return "onClick_btnAdd";
            };

            Events.onSelect_dgJushochiTokureiRireki = function () {
                return "onSelect_dgJushochiTokureiRireki";
            };

            Events.onSelectByDblClick_dgJushochiTokureiRireki = function () {
                return "onSelectByDblClick_dgJushochiTokureiRireki";
            };

            Events.onSelectBySelectButton_dgJushochiTokureiRireki = function () {
                return "onSelectBySelectButton_dgJushochiTokureiRireki";
            };

            Events.onSelectByModifyButton_dgJushochiTokureiRireki = function () {
                return "onSelectByModifyButton_dgJushochiTokureiRireki";
            };

            Events.onSelectByDeleteButton_dgJushochiTokureiRireki = function () {
                return "onSelectByDeleteButton_dgJushochiTokureiRireki";
            };
            return Events;
        })();
        JushochiTokureiRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JushochiTokureiRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.JushochiTokureiRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.JushochiTokureiRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JushochiTokureiRireki = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.Button(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgJushochiTokureiRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgJushochiTokureiRireki"));
            };
            return Controls;
        })();
        JushochiTokureiRireki.Controls = Controls;
    })(DBZ.JushochiTokureiRireki || (DBZ.JushochiTokureiRireki = {}));
    var JushochiTokureiRireki = DBZ.JushochiTokureiRireki;
})(DBZ || (DBZ = {}));
