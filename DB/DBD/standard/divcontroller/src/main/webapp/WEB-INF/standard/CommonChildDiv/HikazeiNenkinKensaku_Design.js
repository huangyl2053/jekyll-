var DBD;
(function (DBD) {
    (function (HikazeiNenkinKensaku) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_SelectedItem = function () {
                return "onClick_SelectedItem";
            };

            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
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

            Controls.prototype.txtHihokenshano = function () {
                return new UZA.TextBox(this.convFiledName("txtHihokenshano"));
            };

            Controls.prototype.txtTaishom = function () {
                return new UZA.TextBox(this.convFiledName("txtTaishom"));
            };

            Controls.prototype.dgHikazeNenkinKensaku = function () {
                return new UZA.DataGrid(this.convFiledName("dgHikazeNenkinKensaku"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        HikazeiNenkinKensaku.Controls = Controls;
    })(DBD.HikazeiNenkinKensaku || (DBD.HikazeiNenkinKensaku = {}));
    var HikazeiNenkinKensaku = DBD.HikazeiNenkinKensaku;
})(DBD || (DBD = {}));
