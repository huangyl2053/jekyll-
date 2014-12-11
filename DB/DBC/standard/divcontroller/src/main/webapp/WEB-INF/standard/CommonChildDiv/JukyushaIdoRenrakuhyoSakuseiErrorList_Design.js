var DBC;
(function (DBC) {
    (function (JukyushaIdoRenrakuhyoSakuseiErrorList) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        JukyushaIdoRenrakuhyoSakuseiErrorList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "JukyushaIdoRenrakuhyoSakuseiErrorList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.JukyushaIdoRenrakuhyoSakuseiErrorList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.JukyushaIdoRenrakuhyoSakuseiErrorList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.JukyushaIdoRenrakuhyoSakuseiErrorList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.lblErrorList = function () {
                return new UZA.Label(this.convFiledName("lblErrorList"));
            };

            Controls.prototype.dgErrorList = function () {
                return new UZA.DataGrid(this.convFiledName("dgErrorList"));
            };

            Controls.prototype.lblTeiseiList = function () {
                return new UZA.Label(this.convFiledName("lblTeiseiList"));
            };

            Controls.prototype.dgTeiseiList = function () {
                return new UZA.DataGrid(this.convFiledName("dgTeiseiList"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        JukyushaIdoRenrakuhyoSakuseiErrorList.Controls = Controls;
    })(DBC.JukyushaIdoRenrakuhyoSakuseiErrorList || (DBC.JukyushaIdoRenrakuhyoSakuseiErrorList = {}));
    var JukyushaIdoRenrakuhyoSakuseiErrorList = DBC.JukyushaIdoRenrakuhyoSakuseiErrorList;
})(DBC || (DBC = {}));
