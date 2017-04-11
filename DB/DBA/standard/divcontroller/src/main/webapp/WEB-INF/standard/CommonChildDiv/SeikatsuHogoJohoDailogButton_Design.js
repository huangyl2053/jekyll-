var DBA;
(function (DBA) {
    (function (SeikatsuHogoJohoDailogButton) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        SeikatsuHogoJohoDailogButton.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SeikatsuHogoJohoDailogButton";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBA.SeikatsuHogoJohoDailogButton.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBA.SeikatsuHogoJohoDailogButton.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SeikatsuHogoJohoDailogButton = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnSeikatsuHogoJoho = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnSeikatsuHogoJoho"));
            };
            return Controls;
        })();
        SeikatsuHogoJohoDailogButton.Controls = Controls;
    })(DBA.SeikatsuHogoJohoDailogButton || (DBA.SeikatsuHogoJohoDailogButton = {}));
    var SeikatsuHogoJohoDailogButton = DBA.SeikatsuHogoJohoDailogButton;
})(DBA || (DBA = {}));
