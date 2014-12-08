var DBZ;
(function (DBZ) {
    (function (TekiyoJogaiShisetsuInputGuide) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelectBySelectButton_dgTekiyoJogaiShisetsu = function () {
                return "onSelectBySelectButton_dgTekiyoJogaiShisetsu";
            };

            Events.onClick_btnReturn = function () {
                return "onClick_btnReturn";
            };
            return Events;
        })();
        TekiyoJogaiShisetsuInputGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TekiyoJogaiShisetsuInputGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.TekiyoJogaiShisetsuInputGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.TekiyoJogaiShisetsuInputGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TekiyoJogaiShisetsuInputGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgTekiyoJogaiShisetsu = function () {
                return new UZA.DataGrid(this.convFiledName("dgTekiyoJogaiShisetsu"));
            };

            Controls.prototype.btnReturn = function () {
                return new UZA.Button(this.convFiledName("btnReturn"));
            };
            return Controls;
        })();
        TekiyoJogaiShisetsuInputGuide.Controls = Controls;
    })(DBZ.TekiyoJogaiShisetsuInputGuide || (DBZ.TekiyoJogaiShisetsuInputGuide = {}));
    var TekiyoJogaiShisetsuInputGuide = DBZ.TekiyoJogaiShisetsuInputGuide;
})(DBZ || (DBZ = {}));
