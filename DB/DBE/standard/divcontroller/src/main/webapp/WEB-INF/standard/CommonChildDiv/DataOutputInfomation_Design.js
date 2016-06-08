var DBE;
(function (DBE) {
    (function (DataOutputInfomation) {
        var Events = (function () {
            function Events() {
            }
            Events.CloseOK = function () {
                return "CloseOK";
            };
            return Events;
        })();
        DataOutputInfomation.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "DataOutputInfomation";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.DataOutputInfomation.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.DataOutputInfomation.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.DataOutputInfomation = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.icnKanryo = function () {
                return new UZA.Icon(this.convFiledName("icnKanryo"));
            };

            Controls.prototype.lblMessage = function () {
                return new UZA.Label(this.convFiledName("lblMessage"));
            };

            Controls.prototype.btnKakunin = function () {
                return new UZA.Button(this.convFiledName("btnKakunin"));
            };
            return Controls;
        })();
        DataOutputInfomation.Controls = Controls;
    })(DBE.DataOutputInfomation || (DBE.DataOutputInfomation = {}));
    var DataOutputInfomation = DBE.DataOutputInfomation;
})(DBE || (DBE = {}));
