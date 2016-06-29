var DBC;
(function (DBC) {
    (function (TaishoshaIchiran) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnSelect = function () {
                return "onClick_btnSelect";
            };

            Events.onClick_btnModify = function () {
                return "onClick_btnModify";
            };
            return Events;
        })();
        TaishoshaIchiran.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TaishoshaIchiran";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.TaishoshaIchiran.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.TaishoshaIchiran.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TaishoshaIchiran = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgJukyushaIdoRenrakuhyoHenkoSearchResultList = function () {
                return new UZA.DataGrid(this.convFiledName("dgJukyushaIdoRenrakuhyoHenkoSearchResultList"));
            };
            return Controls;
        })();
        TaishoshaIchiran.Controls = Controls;
    })(DBC.TaishoshaIchiran || (DBC.TaishoshaIchiran = {}));
    var TaishoshaIchiran = DBC.TaishoshaIchiran;
})(DBC || (DBC = {}));
