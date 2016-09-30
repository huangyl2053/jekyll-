var DBC;
(function (DBC) {
    (function (ShotokuJokyo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };

            Events.onClick_btnKakutei = function () {
                return "onClick_btnKakutei";
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
                return this._myName + "_" + DBC.ShotokuJokyo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.ShotokuJokyo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShotokuJokyo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtKijunYMD = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtKijunYMD"));
            };

            Controls.prototype.txtShoriNendo = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShoriNendo"));
            };

            Controls.prototype.lin1 = function () {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            };

            Controls.prototype.lblSetaiinShotoku = function () {
                return new UZA.Label(this.convFiledName("lblSetaiinShotoku"));
            };

            Controls.prototype.dgSteaiinShotoku = function () {
                return new UZA.DataGrid(this.convFiledName("dgSteaiinShotoku"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };

            Controls.prototype.btnKakutei = function () {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            };
            return Controls;
        })();
        ShotokuJokyo.Controls = Controls;
    })(DBC.ShotokuJokyo || (DBC.ShotokuJokyo = {}));
    var ShotokuJokyo = DBC.ShotokuJokyo;
})(DBC || (DBC = {}));
