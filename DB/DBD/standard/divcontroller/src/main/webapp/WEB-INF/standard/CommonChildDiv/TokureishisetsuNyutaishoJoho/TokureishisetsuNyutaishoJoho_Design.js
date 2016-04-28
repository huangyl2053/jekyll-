var DBD;
(function (DBD) {
    (function (TokureishisetsuNyutaishoJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.CloseOK = function () {
                return "CloseOK";
            };
            return Events;
        })();
        TokureishisetsuNyutaishoJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TokureishisetsuNyutaishoJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.TokureishisetsuNyutaishoJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.TokureishisetsuNyutaishoJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TokureishisetsuNyutaishoJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgTokureishisetsuNyutaishoJoho = function () {
                return new UZA.DataGrid(this.convFiledName("dgTokureishisetsuNyutaishoJoho"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        TokureishisetsuNyutaishoJoho.Controls = Controls;
    })(DBD.TokureishisetsuNyutaishoJoho || (DBD.TokureishisetsuNyutaishoJoho = {}));
    var TokureishisetsuNyutaishoJoho = DBD.TokureishisetsuNyutaishoJoho;
})(DBD || (DBD = {}));
