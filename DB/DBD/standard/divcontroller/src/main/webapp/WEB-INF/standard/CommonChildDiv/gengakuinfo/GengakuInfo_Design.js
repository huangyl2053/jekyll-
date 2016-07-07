var DBD;
(function (DBD) {
    (function (GengakuInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnKensaku = function () {
                return "onClick_btnKensaku";
            };

            Events.onSelect_dgGenGaku = function () {
                return "onSelect_dgGenGaku";
            };

            Events.onClick_chkHyojiKirikae = function () {
                return "onClick_chkHyojiKirikae";
            };

            Events.onClick_btnModoru = function () {
                return "onClick_btnModoru";
            };

            Events.onClick_btnReturn = function () {
                return "onClick_btnReturn";
            };
            return Events;
        })();
        GengakuInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "GengakuInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBD.GengakuInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBD.GengakuInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.GengakuInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.TainoNendo = function () {
                return new UZA.Panel(this.convFiledName("TainoNendo"));
            };

            Controls.prototype.txtHanteiKijunYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtHanteiKijunYMD"));
            };

            Controls.prototype.btnKensaku = function () {
                return new UZA.Button(this.convFiledName("btnKensaku"));
            };

            Controls.prototype.dgGenGaku = function () {
                return new UZA.DataGrid(this.convFiledName("dgGenGaku"));
            };

            Controls.prototype.GenGakuKeisan = function () {
                return new UZA.Panel(this.convFiledName("GenGakuKeisan"));
            };

            Controls.prototype.ChoshuKenKeimetsuKikan1 = function () {
                return new UZA.Panel(this.convFiledName("ChoshuKenKeimetsuKikan1"));
            };

            Controls.prototype.lblChoShushometsu1 = function () {
                return new UZA.Label(this.convFiledName("lblChoShushometsu1"));
            };

            Controls.prototype.txtChoShushometsu1 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtChoShushometsu1"));
            };

            Controls.prototype.Kakesan = function () {
                return new UZA.Panel(this.convFiledName("Kakesan"));
            };

            Controls.prototype.lblKakesan = function () {
                return new UZA.Label(this.convFiledName("lblKakesan"));
            };

            Controls.prototype.ChoshuKenKeimetsuKikan2 = function () {
                return new UZA.Panel(this.convFiledName("ChoshuKenKeimetsuKikan2"));
            };

            Controls.prototype.ChoshuKenKeimetsuKikan3 = function () {
                return new UZA.Panel(this.convFiledName("ChoshuKenKeimetsuKikan3"));
            };

            Controls.prototype.lblChoShushometsu2 = function () {
                return new UZA.Label(this.convFiledName("lblChoShushometsu2"));
            };

            Controls.prototype.txtChoShushometsu2 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtChoShushometsu2"));
            };

            Controls.prototype.lblLine = function () {
                return new UZA.Label(this.convFiledName("lblLine"));
            };

            Controls.prototype.ChoshuKenKeimetsuKikan4 = function () {
                return new UZA.Panel(this.convFiledName("ChoshuKenKeimetsuKikan4"));
            };

            Controls.prototype.lblChoShushometsu3 = function () {
                return new UZA.Label(this.convFiledName("lblChoShushometsu3"));
            };

            Controls.prototype.txtChoShushometsu3 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtChoShushometsu3"));
            };

            Controls.prototype.Kasan = function () {
                return new UZA.Panel(this.convFiledName("Kasan"));
            };

            Controls.prototype.lblKasan = function () {
                return new UZA.Label(this.convFiledName("lblKasan"));
            };

            Controls.prototype.NofuZumiKikan = function () {
                return new UZA.Panel(this.convFiledName("NofuZumiKikan"));
            };

            Controls.prototype.lblNofuZumiKikan = function () {
                return new UZA.Label(this.convFiledName("lblNofuZumiKikan"));
            };

            Controls.prototype.txtNofuZumiKikan = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtNofuZumiKikan"));
            };

            Controls.prototype.GnegakuKikan = function () {
                return new UZA.Panel(this.convFiledName("GnegakuKikan"));
            };

            Controls.prototype.lblKeisanShiki = function () {
                return new UZA.Label(this.convFiledName("lblKeisanShiki"));
            };

            Controls.prototype.GenGakuKikan2 = function () {
                return new UZA.Panel(this.convFiledName("GenGakuKikan2"));
            };

            Controls.prototype.lblGenGakuKikan = function () {
                return new UZA.Label(this.convFiledName("lblGenGakuKikan"));
            };

            Controls.prototype.txtGenGakuKikan = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGenGakuKikan"));
            };

            Controls.prototype.TainoGengakuShosaiInfo = function () {
                return new UZA.Panel(this.convFiledName("TainoGengakuShosaiInfo"));
            };

            Controls.prototype.chkHyojiKirikae = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkHyojiKirikae"));
            };

            Controls.prototype.txtNendo = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNendo"));
            };

            Controls.prototype.dgTainoShosaiInfo = function () {
                return new UZA.DataGrid(this.convFiledName("dgTainoShosaiInfo"));
            };

            Controls.prototype.tblComment = function () {
                return new UZA.TablePanel(this.convFiledName("tblComment"));
            };

            Controls.prototype.celTainocolorKanno = function () {
                return new UZA.TableCell(this.convFiledName("celTainocolorKanno"));
            };

            Controls.prototype.TainocolorKanno = function () {
                return new UZA.TablePanel(this.convFiledName("TainocolorKanno"));
            };

            Controls.prototype.celWhite = function () {
                return new UZA.TableCell(this.convFiledName("celWhite"));
            };

            Controls.prototype.lblColorWhite = function () {
                return new UZA.Label(this.convFiledName("lblColorWhite"));
            };

            Controls.prototype.celTainoSetsumeiKanno = function () {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumeiKanno"));
            };

            Controls.prototype.lblTainoSetsumeiKanno = function () {
                return new UZA.Label(this.convFiledName("lblTainoSetsumeiKanno"));
            };

            Controls.prototype.celTainocolorMitorai = function () {
                return new UZA.TableCell(this.convFiledName("celTainocolorMitorai"));
            };

            Controls.prototype.TainocolorMitorai = function () {
                return new UZA.TablePanel(this.convFiledName("TainocolorMitorai"));
            };

            Controls.prototype.celDummyYellow = function () {
                return new UZA.TableCell(this.convFiledName("celDummyYellow"));
            };

            Controls.prototype.lblDummyYellow = function () {
                return new UZA.Label(this.convFiledName("lblDummyYellow"));
            };

            Controls.prototype.celTainoSetsumeiMiTorai = function () {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumeiMiTorai"));
            };

            Controls.prototype.lblTainoSetsumeiMiTorai = function () {
                return new UZA.Label(this.convFiledName("lblTainoSetsumeiMiTorai"));
            };

            Controls.prototype.celTainocolorTorai = function () {
                return new UZA.TableCell(this.convFiledName("celTainocolorTorai"));
            };

            Controls.prototype.TainocolorTorai = function () {
                return new UZA.TablePanel(this.convFiledName("TainocolorTorai"));
            };

            Controls.prototype.celDummyRed = function () {
                return new UZA.TableCell(this.convFiledName("celDummyRed"));
            };

            Controls.prototype.lblDummyRed = function () {
                return new UZA.Label(this.convFiledName("lblDummyRed"));
            };

            Controls.prototype.celTainoSetsumeiTorai = function () {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumeiTorai"));
            };

            Controls.prototype.lblTainoSetsumeiTorai = function () {
                return new UZA.Label(this.convFiledName("lblTainoSetsumeiTorai"));
            };

            Controls.prototype.celTainocolorTaishoGai = function () {
                return new UZA.TableCell(this.convFiledName("celTainocolorTaishoGai"));
            };

            Controls.prototype.TainocolorTaishoGai = function () {
                return new UZA.TablePanel(this.convFiledName("TainocolorTaishoGai"));
            };

            Controls.prototype.celLightSalmon = function () {
                return new UZA.TableCell(this.convFiledName("celLightSalmon"));
            };

            Controls.prototype.lblLightSalmon = function () {
                return new UZA.Label(this.convFiledName("lblLightSalmon"));
            };

            Controls.prototype.celTainoSetsumeiTaishoGai = function () {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumeiTaishoGai"));
            };

            Controls.prototype.lblTainoSetsumeiTaishoGai = function () {
                return new UZA.Label(this.convFiledName("lblTainoSetsumeiTaishoGai"));
            };

            Controls.prototype.celTainocolorKano = function () {
                return new UZA.TableCell(this.convFiledName("celTainocolorKano"));
            };

            Controls.prototype.TainocolorKano = function () {
                return new UZA.TablePanel(this.convFiledName("TainocolorKano"));
            };

            Controls.prototype.celDummyGreen = function () {
                return new UZA.TableCell(this.convFiledName("celDummyGreen"));
            };

            Controls.prototype.lblDummyGreen = function () {
                return new UZA.Label(this.convFiledName("lblDummyGreen"));
            };

            Controls.prototype.celTainoSetsumeiKano = function () {
                return new UZA.TableCell(this.convFiledName("celTainoSetsumeiKano"));
            };

            Controls.prototype.lblTainoSetsumeiKano = function () {
                return new UZA.Label(this.convFiledName("lblTainoSetsumeiKano"));
            };

            Controls.prototype.Modoru = function () {
                return new UZA.Panel(this.convFiledName("Modoru"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };

            Controls.prototype.btnReturn = function () {
                return new UZA.Button(this.convFiledName("btnReturn"));
            };
            return Controls;
        })();
        GengakuInfo.Controls = Controls;
    })(DBD.GengakuInfo || (DBD.GengakuInfo = {}));
    var GengakuInfo = DBD.GengakuInfo;
})(DBD || (DBD = {}));
