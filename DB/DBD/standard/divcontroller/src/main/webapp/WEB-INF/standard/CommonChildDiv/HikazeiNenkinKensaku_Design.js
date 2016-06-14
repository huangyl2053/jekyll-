var DBD;
(function (DBD) {
    (function (HikazeiNenkinKensaku) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        HikazeiNenkinKensaku.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "HikazeiNenkinKensaku";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.HikazeiNenkinKensaku.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.HikazeiNenkinKensaku.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.HikazeiNenkinKensaku = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.TextBox1 = function () {
                return new UZA.TextBox(this.convFiledName("TextBox1"));
            };

            Controls.prototype.TextBox2 = function () {
                return new UZA.TextBox(this.convFiledName("TextBox2"));
            };

            Controls.prototype.DataGrid1 = function () {
                return new UZA.DataGrid(this.convFiledName("DataGrid1"));
            };

            Controls.prototype.Button1 = function () {
                return new UZA.Button(this.convFiledName("Button1"));
            };
            return Controls;
        })();
        HikazeiNenkinKensaku.Controls = Controls;
    })(DBD.HikazeiNenkinKensaku || (DBD.HikazeiNenkinKensaku = {}));
    var HikazeiNenkinKensaku = DBD.HikazeiNenkinKensaku;
})(DBD || (DBD = {}));
