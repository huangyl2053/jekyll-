var DBA;
(function (DBA) {
    (function (SeikatsuHogoJohoCommonDiv) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        SeikatsuHogoJohoCommonDiv.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SeikatsuHogoJohoCommonDiv";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBA.SeikatsuHogoJohoCommonDiv.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBA.SeikatsuHogoJohoCommonDiv.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SeikatsuHogoJohoCommonDiv = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.pnlSeikatsuHogoJoho = function () {
                return new UZA.Panel(this.convFiledName("pnlSeikatsuHogoJoho"));
            };

            Controls.prototype.panelSeikatsuHogoIchiran = function () {
                return new UZA.Panel(this.convFiledName("panelSeikatsuHogoIchiran"));
            };

            Controls.prototype.dgRirekiIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgRirekiIchiran"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        SeikatsuHogoJohoCommonDiv.Controls = Controls;
    })(DBA.SeikatsuHogoJohoCommonDiv || (DBA.SeikatsuHogoJohoCommonDiv = {}));
    var SeikatsuHogoJohoCommonDiv = DBA.SeikatsuHogoJohoCommonDiv;
})(DBA || (DBA = {}));
