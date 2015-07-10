var DBE;
(function (DBE) {
    (function (ShozokuChosainListCom) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ShozokuChosainListCom.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShozokuChosainListCom";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.ShozokuChosainListCom.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.ShozokuChosainListCom.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShozokuChosainListCom = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgShozokuChosainList = function () {
                return new UZA.DataGrid(this.convFiledName("dgShozokuChosainList"));
            };
            return Controls;
        })();
        ShozokuChosainListCom.Controls = Controls;
    })(DBE.ShozokuChosainListCom || (DBE.ShozokuChosainListCom = {}));
    var ShozokuChosainListCom = DBE.ShozokuChosainListCom;
})(DBE || (DBE = {}));
