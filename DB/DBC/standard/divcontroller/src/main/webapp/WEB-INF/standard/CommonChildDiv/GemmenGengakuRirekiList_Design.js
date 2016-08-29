var DBC;
(function (DBC) {
    (function (GemmenGengakuRirekiList) {
        var Events = (function () {
            function Events() {
            }
            Events.onClose = function () {
                return "onClose";
            };
            return Events;
        })();
        GemmenGengakuRirekiList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "GemmenGengakuRirekiList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.GemmenGengakuRirekiList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.GemmenGengakuRirekiList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.GemmenGengakuRirekiList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.pnlFutangendogakuRireki = function () {
                return new UZA.Panel(this.convFiledName("pnlFutangendogakuRireki"));
            };

            Controls.prototype.dgFutanGendogakuList = function () {
                return new UZA.DataGrid(this.convFiledName("dgFutanGendogakuList"));
            };

            Controls.prototype.pnlTaGemmenGengakuRireki = function () {
                return new UZA.Panel(this.convFiledName("pnlTaGemmenGengakuRireki"));
            };

            Controls.prototype.dgTaGemmenGengakuList = function () {
                return new UZA.DataGrid(this.convFiledName("dgTaGemmenGengakuList"));
            };

            Controls.prototype.pnlButton = function () {
                return new UZA.Panel(this.convFiledName("pnlButton"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        GemmenGengakuRirekiList.Controls = Controls;
    })(DBC.GemmenGengakuRirekiList || (DBC.GemmenGengakuRirekiList = {}));
    var GemmenGengakuRirekiList = DBC.GemmenGengakuRirekiList;
})(DBC || (DBC = {}));
