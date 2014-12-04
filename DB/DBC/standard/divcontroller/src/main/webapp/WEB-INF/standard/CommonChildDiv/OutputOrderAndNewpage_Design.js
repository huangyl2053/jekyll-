var DBC;
(function (DBC) {
    (function (OutputOrderAndNewpage) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        OutputOrderAndNewpage.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "OutputOrderAndNewpage";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.OutputOrderAndNewpage.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.OutputOrderAndNewpage.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.OutputOrderAndNewpage = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnChangeOrder = function () {
                return new UZA.Button(this.convFiledName("btnChangeOrder"));
            };

            Controls.prototype.txtNewPageItem = function () {
                return new UZA.TextBox(this.convFiledName("txtNewPageItem"));
            };

            Controls.prototype.txt1 = function () {
                return new UZA.TextBox(this.convFiledName("txt1"));
            };

            Controls.prototype.txt2 = function () {
                return new UZA.TextBox(this.convFiledName("txt2"));
            };

            Controls.prototype.txt3 = function () {
                return new UZA.TextBox(this.convFiledName("txt3"));
            };

            Controls.prototype.txt4 = function () {
                return new UZA.TextBox(this.convFiledName("txt4"));
            };

            Controls.prototype.txt5 = function () {
                return new UZA.TextBox(this.convFiledName("txt5"));
            };
            return Controls;
        })();
        OutputOrderAndNewpage.Controls = Controls;
    })(DBC.OutputOrderAndNewpage || (DBC.OutputOrderAndNewpage = {}));
    var OutputOrderAndNewpage = DBC.OutputOrderAndNewpage;
})(DBC || (DBC = {}));
