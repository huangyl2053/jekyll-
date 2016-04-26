var DBD;
(function (DBD) {
    (function (ShisetsuIdoJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.CloseOK = function () {
                return "CloseOK";
            };
            return Events;
        })();
        ShisetsuIdoJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShisetsuIdoJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.ShisetsuIdoJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.ShisetsuIdoJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShisetsuIdoJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgShisetsuIdoJoho = function () {
                return new UZA.DataGrid(this.convFiledName("dgShisetsuIdoJoho"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        ShisetsuIdoJoho.Controls = Controls;
    })(DBD.ShisetsuIdoJoho || (DBD.ShisetsuIdoJoho = {}));
    var ShisetsuIdoJoho = DBD.ShisetsuIdoJoho;
})(DBD || (DBD = {}));
