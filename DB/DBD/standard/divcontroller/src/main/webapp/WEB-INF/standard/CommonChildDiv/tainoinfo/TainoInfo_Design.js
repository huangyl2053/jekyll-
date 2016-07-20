var DBD;
(function (DBD) {
    (function (TainoInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnKensaku = function () {
                return "onClick_btnKensaku";
            };

            Events.onClick_btnReturn = function () {
                return "onClick_btnReturn";
            };

            Events.onClick_btnKakutei = function () {
                return "onClick_btnKakutei";
            };
            return Events;
        })();
        TainoInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TainoInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.TainoInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.TainoInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TainoInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtHanteiKijunYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtHanteiKijunYMD"));
            };

            Controls.prototype.btnKensaku = function () {
                return new UZA.Button(this.convFiledName("btnKensaku"));
            };

            Controls.prototype.btnDispGengakuJoho = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnDispGengakuJoho"));
            };

            Controls.prototype.txtSaikoNokigen = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSaikoNokigen"));
            };

            Controls.prototype.txtKeikaNen = function () {
                return new UZA.TextBox(this.convFiledName("txtKeikaNen"));
            };

            Controls.prototype.txtKeikaTsuki = function () {
                return new UZA.TextBox(this.convFiledName("txtKeikaTsuki"));
            };

            Controls.prototype.linTaino1 = function () {
                return new UZA.HorizontalLine(this.convFiledName("linTaino1"));
            };

            Controls.prototype.txtFukaNendo = function () {
                return new UZA.TextBoxFlexibleYear(this.convFiledName("txtFukaNendo"));
            };

            Controls.prototype.txtFukaNendo2 = function () {
                return new UZA.TextBoxFlexibleYear(this.convFiledName("txtFukaNendo2"));
            };

            Controls.prototype.txtFukaNendo1 = function () {
                return new UZA.TextBoxFlexibleYear(this.convFiledName("txtFukaNendo1"));
            };

            Controls.prototype.dgTainoJokyo3 = function () {
                return new UZA.DataGrid(this.convFiledName("dgTainoJokyo3"));
            };

            Controls.prototype.dgTainoJokyo2 = function () {
                return new UZA.DataGrid(this.convFiledName("dgTainoJokyo2"));
            };

            Controls.prototype.dgTainoJokyo1 = function () {
                return new UZA.DataGrid(this.convFiledName("dgTainoJokyo1"));
            };

            Controls.prototype.txtSonotaHokenryo = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSonotaHokenryo"));
            };

            Controls.prototype.txtSonotatainoGaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSonotatainoGaku"));
            };

            Controls.prototype.TainoSetsumei = function () {
                return new UZA.TablePanel(this.convFiledName("TainoSetsumei"));
            };

            Controls.prototype.celTainoSetsumei1 = function () {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumei1"));
            };

            Controls.prototype.TainocolorKanno = function () {
                return new UZA.TablePanel(this.convFiledName("TainocolorKanno"));
            };

            Controls.prototype.WhiteCell = function () {
                return new UZA.TableCell(this.convFiledName("WhiteCell"));
            };

            Controls.prototype.lblDummyWhite = function () {
                return new UZA.Label(this.convFiledName("lblDummyWhite"));
            };

            Controls.prototype.TainocolorMino = function () {
                return new UZA.TablePanel(this.convFiledName("TainocolorMino"));
            };

            Controls.prototype.RedCell = function () {
                return new UZA.TableCell(this.convFiledName("RedCell"));
            };

            Controls.prototype.lblDummyRed = function () {
                return new UZA.Label(this.convFiledName("lblDummyRed"));
            };

            Controls.prototype.celTainoSetsumei2 = function () {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumei2"));
            };

            Controls.prototype.lblMassage1 = function () {
                return new UZA.Label(this.convFiledName("lblMassage1"));
            };

            Controls.prototype.lblMassage2 = function () {
                return new UZA.Label(this.convFiledName("lblMassage2"));
            };

            Controls.prototype.celTainoSetsumei3 = function () {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumei3"));
            };

            Controls.prototype.TainocolorMitorai = function () {
                return new UZA.TablePanel(this.convFiledName("TainocolorMitorai"));
            };

            Controls.prototype.YellowCell = function () {
                return new UZA.TableCell(this.convFiledName("YellowCell"));
            };

            Controls.prototype.lblDummyYellow = function () {
                return new UZA.Label(this.convFiledName("lblDummyYellow"));
            };

            Controls.prototype.TainocolorKano = function () {
                return new UZA.TablePanel(this.convFiledName("TainocolorKano"));
            };

            Controls.prototype.GreenCell1 = function () {
                return new UZA.TableCell(this.convFiledName("GreenCell1"));
            };

            Controls.prototype.lblDummyGreen = function () {
                return new UZA.Label(this.convFiledName("lblDummyGreen"));
            };

            Controls.prototype.celTainoSetsumei4 = function () {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumei4"));
            };

            Controls.prototype.lblMassage3 = function () {
                return new UZA.Label(this.convFiledName("lblMassage3"));
            };

            Controls.prototype.lblMassage4 = function () {
                return new UZA.Label(this.convFiledName("lblMassage4"));
            };

            Controls.prototype.btnTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnTorikeshi"));
            };

            Controls.prototype.btnKakutei = function () {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            };
            return Controls;
        })();
        TainoInfo.Controls = Controls;
    })(DBD.TainoInfo || (DBD.TainoInfo = {}));
    var TainoInfo = DBD.TainoInfo;
})(DBD || (DBD = {}));
