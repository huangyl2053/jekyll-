var DBC;
(function (DBC) {
    (function (ServiceTeikyoShomeishoGokei) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnServiceTeikyoShomeishoGokeiReturn = function () {
                return "onClick_btnServiceTeikyoShomeishoGokeiReturn";
            };
            return Events;
        })();
        ServiceTeikyoShomeishoGokei.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ServiceTeikyoShomeishoGokei";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoGokei.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.ServiceTeikyoShomeishoGokei.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ServiceTeikyoShomeishoGokei = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtServiceTani = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtServiceTani"));
            };

            Controls.prototype.txtHokengaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHokengaku"));
            };

            Controls.prototype.txtFutangaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutangaku"));
            };

            Controls.prototype.txtRyoyohi = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtRyoyohi"));
            };

            Controls.prototype.txtShinryohi = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShinryohi"));
            };

            Controls.prototype.txtShokujihi = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShokujihi"));
            };

            Controls.prototype.btnServiceTeikyoShomeishoGokeiReturn = function () {
                return new UZA.Button(this.convFiledName("btnServiceTeikyoShomeishoGokeiReturn"));
            };
            return Controls;
        })();
        ServiceTeikyoShomeishoGokei.Controls = Controls;
    })(DBC.ServiceTeikyoShomeishoGokei || (DBC.ServiceTeikyoShomeishoGokei = {}));
    var ServiceTeikyoShomeishoGokei = DBC.ServiceTeikyoShomeishoGokei;
})(DBC || (DBC = {}));
