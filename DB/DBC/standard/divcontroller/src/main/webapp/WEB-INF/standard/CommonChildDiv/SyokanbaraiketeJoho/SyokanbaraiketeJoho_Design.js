var DBC;
(function (DBC) {
    (function (SyokanbaraiketeJoho) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        SyokanbaraiketeJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SyokanbaraiketeJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.SyokanbaraiketeJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.SyokanbaraiketeJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SyokanbaraiketeJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgSyokanbaraikete = function () {
                return new UZA.DataGrid(this.convFiledName("dgSyokanbaraikete"));
            };

            Controls.prototype.hlLine1 = function () {
                return new UZA.HorizontalLine(this.convFiledName("hlLine1"));
            };

            Controls.prototype.txtSagakuGoke = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSagakuGoke"));
            };

            Controls.prototype.txtKetebi = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKetebi"));
            };

            Controls.prototype.rdoShikyukubun = function () {
                return new UZA.RadioButton(this.convFiledName("rdoShikyukubun"));
            };

            Controls.prototype.txtZogenriyu = function () {
                return new UZA.TextBox(this.convFiledName("txtZogenriyu"));
            };

            Controls.prototype.txtShiharaikingakugoke = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShiharaikingakugoke"));
            };

            Controls.prototype.txtFuSyikyuriyu1 = function () {
                return new UZA.TextBox(this.convFiledName("txtFuSyikyuriyu1"));
            };

            Controls.prototype.txtZogentani = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtZogentani"));
            };

            Controls.prototype.txtFushikyuriyu2 = function () {
                return new UZA.TextBox(this.convFiledName("txtFushikyuriyu2"));
            };

            Controls.prototype.lblKokuhorenkete = function () {
                return new UZA.Label(this.convFiledName("lblKokuhorenkete"));
            };
            return Controls;
        })();
        SyokanbaraiketeJoho.Controls = Controls;
    })(DBC.SyokanbaraiketeJoho || (DBC.SyokanbaraiketeJoho = {}));
    var SyokanbaraiketeJoho = DBC.SyokanbaraiketeJoho;
})(DBC || (DBC = {}));
