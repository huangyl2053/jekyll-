var DBD;
(function (DBD) {
    (function (ShotokuJokyo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_Saihyoji = function () {
                return "onClick_Saihyoji";
            };

            Events.onClick_SetaiinSentaku = function () {
                return "onClick_SetaiinSentaku";
            };

            Events.onClick_btnRirekiClose = function () {
                return "onClick_btnRirekiClose";
            };
            return Events;
        })();
        ShotokuJokyo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShotokuJokyo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.ShotokuJokyo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.ShotokuJokyo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShotokuJokyo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtSetaiKijunYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSetaiKijunYMD"));
            };

            Controls.prototype.ddShotokuNendo = function () {
                return new UZA.DropDownList(this.convFiledName("ddShotokuNendo"));
            };

            Controls.prototype.btnSaiHyoji = function () {
                return new UZA.Button(this.convFiledName("btnSaiHyoji"));
            };

            Controls.prototype.dgSetaiShotoku = function () {
                return new UZA.DataGrid(this.convFiledName("dgSetaiShotoku"));
            };

            Controls.prototype.btnRirekiClose = function () {
                return new UZA.Button(this.convFiledName("btnRirekiClose"));
            };
            return Controls;
        })();
        ShotokuJokyo.Controls = Controls;
    })(DBD.ShotokuJokyo || (DBD.ShotokuJokyo = {}));
    var ShotokuJokyo = DBD.ShotokuJokyo;
})(DBD || (DBD = {}));
