var DBD;
(function (DBD) {
    (function (AtokureishisetsuNyutaishoJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.CloseOK = function () {
                return "CloseOK";
            };
            return Events;
        })();
        AtokureishisetsuNyutaishoJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "AtokureishisetsuNyutaishoJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.AtokureishisetsuNyutaishoJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.AtokureishisetsuNyutaishoJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.AtokureishisetsuNyutaishoJoho = function () {
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
        AtokureishisetsuNyutaishoJoho.Controls = Controls;
    })(DBD.AtokureishisetsuNyutaishoJoho || (DBD.AtokureishisetsuNyutaishoJoho = {}));
    var AtokureishisetsuNyutaishoJoho = DBD.AtokureishisetsuNyutaishoJoho;
})(DBD || (DBD = {}));
