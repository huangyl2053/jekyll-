var DBC;
(function (DBC) {
    (function (ShokanbaraiketteiJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_rdoShikyukubun = function () {
                return "onChange_rdoShikyukubun";
            };
            return Events;
        })();
        ShokanbaraiketteiJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShokanbaraiketteiJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.ShokanbaraiketteiJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.ShokanbaraiketteiJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShokanbaraiketteiJoho = function () {
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

            Controls.prototype.lblGyomuCode = function () {
                return new UZA.Label(this.convFiledName("lblGyomuCode"));
            };
            return Controls;
        })();
        ShokanbaraiketteiJoho.Controls = Controls;
    })(DBC.ShokanbaraiketteiJoho || (DBC.ShokanbaraiketteiJoho = {}));
    var ShokanbaraiketteiJoho = DBC.ShokanbaraiketteiJoho;
})(DBC || (DBC = {}));
