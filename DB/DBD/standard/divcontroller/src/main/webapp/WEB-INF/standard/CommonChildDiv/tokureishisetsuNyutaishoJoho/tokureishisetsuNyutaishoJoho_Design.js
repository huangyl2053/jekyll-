var DBD;
(function (DBD) {
    (function (tokureishisetsuNyutaishoJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.CloseOK = function () {
                return "CloseOK";
            };
            return Events;
        })();
        tokureishisetsuNyutaishoJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "tokureishisetsuNyutaishoJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.tokureishisetsuNyutaishoJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.tokureishisetsuNyutaishoJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.tokureishisetsuNyutaishoJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgtokureishisetsuNyutaishoJoho = function () {
                return new UZA.DataGrid(this.convFiledName("dgtokureishisetsuNyutaishoJoho"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        tokureishisetsuNyutaishoJoho.Controls = Controls;
    })(DBD.tokureishisetsuNyutaishoJoho || (DBD.tokureishisetsuNyutaishoJoho = {}));
    var tokureishisetsuNyutaishoJoho = DBD.tokureishisetsuNyutaishoJoho;
})(DBD || (DBD = {}));
