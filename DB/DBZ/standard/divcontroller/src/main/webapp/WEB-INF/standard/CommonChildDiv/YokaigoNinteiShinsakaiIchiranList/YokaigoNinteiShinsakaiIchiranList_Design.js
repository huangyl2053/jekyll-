var DBZ;
(function (DBZ) {
    (function (YokaigoNinteiShinsakaiIchiranList) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_BtnKensaku = function () {
                return "onClick_BtnKensaku";
            };

            Events.onClick_btnClear = function () {
                return "onClick_btnClear";
            };

            Events.onClick_btnSelect = function () {
                return "onClick_btnSelect";
            };

            Events.onClick_CheckBox = function () {
                return "onClick_CheckBox";
            };
            return Events;
        })();
        YokaigoNinteiShinsakaiIchiranList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "YokaigoNinteiShinsakaiIchiranList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.YokaigoNinteiShinsakaiIchiranList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.YokaigoNinteiShinsakaiIchiranList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.YokaigoNinteiShinsakaiIchiranList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.HyojiJoken = function () {
                return new UZA.Panel(this.convFiledName("HyojiJoken"));
            };

            Controls.prototype.txtHyojiKikanFrom = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtHyojiKikanFrom"));
            };

            Controls.prototype.txtHyojiKikanTo = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtHyojiKikanTo"));
            };

            Controls.prototype.txtSaidaiHyojiKensu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSaidaiHyojiKensu"));
            };

            Controls.prototype.radHyojiJokenWaritsukeMikanryo = function () {
                return new UZA.RadioButton(this.convFiledName("radHyojiJokenWaritsukeMikanryo"));
            };

            Controls.prototype.radHyojiJokenWaritsukeKanryo = function () {
                return new UZA.RadioButton(this.convFiledName("radHyojiJokenWaritsukeKanryo"));
            };

            Controls.prototype.radHyojiJokenShinsakaiMikanryo = function () {
                return new UZA.RadioButton(this.convFiledName("radHyojiJokenShinsakaiMikanryo"));
            };

            Controls.prototype.radHyojiJokenShinsakaiKanryo = function () {
                return new UZA.RadioButton(this.convFiledName("radHyojiJokenShinsakaiKanryo"));
            };

            Controls.prototype.radDammyShinsakai = function () {
                return new UZA.RadioButton(this.convFiledName("radDammyShinsakai"));
            };

            Controls.prototype.btnKensaku = function () {
                return new UZA.Button(this.convFiledName("btnKensaku"));
            };

            Controls.prototype.btnClear = function () {
                return new UZA.Button(this.convFiledName("btnClear"));
            };

            Controls.prototype.dgShinsakaiIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgShinsakaiIchiran"));
            };
            return Controls;
        })();
        YokaigoNinteiShinsakaiIchiranList.Controls = Controls;
    })(DBZ.YokaigoNinteiShinsakaiIchiranList || (DBZ.YokaigoNinteiShinsakaiIchiranList = {}));
    var YokaigoNinteiShinsakaiIchiranList = DBZ.YokaigoNinteiShinsakaiIchiranList;
})(DBZ || (DBZ = {}));
