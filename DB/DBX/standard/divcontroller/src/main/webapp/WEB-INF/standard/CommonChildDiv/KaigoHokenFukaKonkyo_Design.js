var DBX;
(function (DBX) {
    (function (KaigoHokenFukaKonkyo) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_ddlChoteiNendo = function () {
                return "onChange_ddlChoteiNendo";
            };

            Events.onChange_ddlFukaNendo = function () {
                return "onChange_ddlFukaNendo";
            };

            Events.onClick_btnSearch = function () {
                return "onClick_btnSearch";
            };

            Events.onClick_btnBefore = function () {
                return "onClick_btnBefore";
            };

            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        KaigoHokenFukaKonkyo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoHokenFukaKonkyo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBX.KaigoHokenFukaKonkyo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBX.KaigoHokenFukaKonkyo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoHokenFukaKonkyo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlChoteiNendo = function () {
                return new UZA.DropDownList(this.convFiledName("ddlChoteiNendo"));
            };

            Controls.prototype.ddlFukaNendo = function () {
                return new UZA.DropDownList(this.convFiledName("ddlFukaNendo"));
            };

            Controls.prototype.ddlTsuchishoNo = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTsuchishoNo"));
            };

            Controls.prototype.btnSearch = function () {
                return new UZA.Button(this.convFiledName("btnSearch"));
            };

            Controls.prototype.txtHihokenshaNo = function () {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaNo"));
            };

            Controls.prototype.txtShikibetsuCode = function () {
                return new UZA.TextBox(this.convFiledName("txtShikibetsuCode"));
            };

            Controls.prototype.btnAfter = function () {
                return new UZA.Button(this.convFiledName("btnAfter"));
            };

            Controls.prototype.btnBefore = function () {
                return new UZA.Button(this.convFiledName("btnBefore"));
            };

            Controls.prototype.txtRirekiNo = function () {
                return new UZA.TextBox(this.convFiledName("txtRirekiNo"));
            };

            Controls.prototype.tblFukaKonkyo = function () {
                return new UZA.TablePanel(this.convFiledName("tblFukaKonkyo"));
            };

            Controls.prototype.celFukaKonkyo11 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo11"));
            };

            Controls.prototype.lblFukaKijunbi = function () {
                return new UZA.Label(this.convFiledName("lblFukaKijunbi"));
            };

            Controls.prototype.celFukaKonkyo21 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo21"));
            };

            Controls.prototype.lblFukaKijunbiData = function () {
                return new UZA.Label(this.convFiledName("lblFukaKijunbiData"));
            };

            Controls.prototype.celFukaKonkyo31 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo31"));
            };

            Controls.prototype.lblMaenendoHokenryoDankai = function () {
                return new UZA.Label(this.convFiledName("lblMaenendoHokenryoDankai"));
            };

            Controls.prototype.lblHonninKazei = function () {
                return new UZA.Label(this.convFiledName("lblHonninKazei"));
            };

            Controls.prototype.celFukaKonkyo41 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo41"));
            };

            Controls.prototype.lblFukaKonkyoData1 = function () {
                return new UZA.Label(this.convFiledName("lblFukaKonkyoData1"));
            };

            Controls.prototype.celFukaKonkyo51 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo51"));
            };

            Controls.prototype.lblKarisanteiKeisanjoHokenryogaku = function () {
                return new UZA.Label(this.convFiledName("lblKarisanteiKeisanjoHokenryogaku"));
            };

            Controls.prototype.lblKeisanjoNenkanHokenryogaku = function () {
                return new UZA.Label(this.convFiledName("lblKeisanjoNenkanHokenryogaku"));
            };

            Controls.prototype.celFukaKonkyo61 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo61"));
            };

            Controls.prototype.lblFukaKonkyoData6 = function () {
                return new UZA.Label(this.convFiledName("lblFukaKonkyoData6"));
            };

            Controls.prototype.celFukaKonkyo12 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo12"));
            };

            Controls.prototype.lblShikakuShutokubi = function () {
                return new UZA.Label(this.convFiledName("lblShikakuShutokubi"));
            };

            Controls.prototype.celFukaKonkyo22 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo22"));
            };

            Controls.prototype.lblShikakuShutokubiData = function () {
                return new UZA.Label(this.convFiledName("lblShikakuShutokubiData"));
            };

            Controls.prototype.celFukaKonkyo32 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo32"));
            };

            Controls.prototype.lblZennendoHokenryoRitsu = function () {
                return new UZA.Label(this.convFiledName("lblZennendoHokenryoRitsu"));
            };

            Controls.prototype.lblSetaiKazei = function () {
                return new UZA.Label(this.convFiledName("lblSetaiKazei"));
            };

            Controls.prototype.celFukaKonkyo42 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo42"));
            };

            Controls.prototype.lblFukaKonkyoData2 = function () {
                return new UZA.Label(this.convFiledName("lblFukaKonkyoData2"));
            };

            Controls.prototype.celFukaKonkyo52 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo52"));
            };

            Controls.prototype.lblGenmengaku = function () {
                return new UZA.Label(this.convFiledName("lblGenmengaku"));
            };

            Controls.prototype.celFukaKonkyo62 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo62"));
            };

            Controls.prototype.lblFukaKonkyoData7 = function () {
                return new UZA.Label(this.convFiledName("lblFukaKonkyoData7"));
            };

            Controls.prototype.celFukaKonkyo13 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo13"));
            };

            Controls.prototype.lblSoshitsubi = function () {
                return new UZA.Label(this.convFiledName("lblSoshitsubi"));
            };

            Controls.prototype.celFukaKonkyo23 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo23"));
            };

            Controls.prototype.lblSoshitsubiData = function () {
                return new UZA.Label(this.convFiledName("lblSoshitsubiData"));
            };

            Controls.prototype.celFukaKonkyo33 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo33"));
            };

            Controls.prototype.lblZennendoNengakuHokenryo = function () {
                return new UZA.Label(this.convFiledName("lblZennendoNengakuHokenryo"));
            };

            Controls.prototype.lblGokeiShotokuKingaku = function () {
                return new UZA.Label(this.convFiledName("lblGokeiShotokuKingaku"));
            };

            Controls.prototype.celFukaKonkyo43 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo43"));
            };

            Controls.prototype.lblFukaKonkyoData3 = function () {
                return new UZA.Label(this.convFiledName("lblFukaKonkyoData3"));
            };

            Controls.prototype.celFukaKonkyo53 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo53"));
            };

            Controls.prototype.lblKarisanteiHokenryogaku = function () {
                return new UZA.Label(this.convFiledName("lblKarisanteiHokenryogaku"));
            };

            Controls.prototype.lblKakuteiNenkanHokenryogaku = function () {
                return new UZA.Label(this.convFiledName("lblKakuteiNenkanHokenryogaku"));
            };

            Controls.prototype.celFukaKonkyo63 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo63"));
            };

            Controls.prototype.lblFukaKonkyoData8 = function () {
                return new UZA.Label(this.convFiledName("lblFukaKonkyoData8"));
            };

            Controls.prototype.celFukaKonkyo14 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo14"));
            };

            Controls.prototype.lblSeihoKaishibi = function () {
                return new UZA.Label(this.convFiledName("lblSeihoKaishibi"));
            };

            Controls.prototype.celFukaKonkyo24 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo24"));
            };

            Controls.prototype.lblSeihoKaishibiData = function () {
                return new UZA.Label(this.convFiledName("lblSeihoKaishibiData"));
            };

            Controls.prototype.celFukaKonkyo34 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo34"));
            };

            Controls.prototype.lblNenkinShunyugaku = function () {
                return new UZA.Label(this.convFiledName("lblNenkinShunyugaku"));
            };

            Controls.prototype.celFukaKonkyo44 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo44"));
            };

            Controls.prototype.lblFukaKonkyoData4 = function () {
                return new UZA.Label(this.convFiledName("lblFukaKonkyoData4"));
            };

            Controls.prototype.celFukaKonkyo54 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo54"));
            };

            Controls.prototype.celFukaKonkyo64 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo64"));
            };

            Controls.prototype.celFukaKonkyo15 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo15"));
            };

            Controls.prototype.lblSeihoShuryobi = function () {
                return new UZA.Label(this.convFiledName("lblSeihoShuryobi"));
            };

            Controls.prototype.celFukaKonkyo25 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo25"));
            };

            Controls.prototype.lblSeihoShuryobiData = function () {
                return new UZA.Label(this.convFiledName("lblSeihoShuryobiData"));
            };

            Controls.prototype.celFukaKonkyo35 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo35"));
            };

            Controls.prototype.lblHokenryoDankai = function () {
                return new UZA.Label(this.convFiledName("lblHokenryoDankai"));
            };

            Controls.prototype.celFukaKonkyo45 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo45"));
            };

            Controls.prototype.lblFukaKonkyoData5 = function () {
                return new UZA.Label(this.convFiledName("lblFukaKonkyoData5"));
            };

            Controls.prototype.celFukaKonkyo55 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo55"));
            };

            Controls.prototype.celFukaKonkyo65 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo65"));
            };

            Controls.prototype.celFukaKonkyo16 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo16"));
            };

            Controls.prototype.lblronenKaishibi = function () {
                return new UZA.Label(this.convFiledName("lblronenKaishibi"));
            };

            Controls.prototype.celFukaKonkyo26 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo26"));
            };

            Controls.prototype.lblronenKaishibiData = function () {
                return new UZA.Label(this.convFiledName("lblronenKaishibiData"));
            };

            Controls.prototype.celFukaKonkyo36 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo36"));
            };

            Controls.prototype.celFukaKonkyo46 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo46"));
            };

            Controls.prototype.celFukaKonkyo56 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo56"));
            };

            Controls.prototype.celFukaKonkyo66 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo66"));
            };

            Controls.prototype.celFukaKonkyo17 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo17"));
            };

            Controls.prototype.lblRonenShuryobi = function () {
                return new UZA.Label(this.convFiledName("lblRonenShuryobi"));
            };

            Controls.prototype.celFukaKonkyo27 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo27"));
            };

            Controls.prototype.lblRonenShuryobiData = function () {
                return new UZA.Label(this.convFiledName("lblRonenShuryobiData"));
            };

            Controls.prototype.celFukaKonkyo37 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo37"));
            };

            Controls.prototype.celFukaKonkyo47 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo47"));
            };

            Controls.prototype.celFukaKonkyo57 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo57"));
            };

            Controls.prototype.celFukaKonkyo67 = function () {
                return new UZA.TableCell(this.convFiledName("celFukaKonkyo67"));
            };

            Controls.prototype.spcKikan = function () {
                return new UZA.Space(this.convFiledName("spcKikan"));
            };

            Controls.prototype.tblKikan = function () {
                return new UZA.TablePanel(this.convFiledName("tblKikan"));
            };

            Controls.prototype.celKikan11 = function () {
                return new UZA.TableCell(this.convFiledName("celKikan11"));
            };

            Controls.prototype.lblKikan = function () {
                return new UZA.Label(this.convFiledName("lblKikan"));
            };

            Controls.prototype.celKikan21 = function () {
                return new UZA.TableCell(this.convFiledName("celKikan21"));
            };

            Controls.prototype.lblGessu = function () {
                return new UZA.Label(this.convFiledName("lblGessu"));
            };

            Controls.prototype.celKikan31 = function () {
                return new UZA.TableCell(this.convFiledName("celKikan31"));
            };

            Controls.prototype.lblHokenryoDankaiKubun = function () {
                return new UZA.Label(this.convFiledName("lblHokenryoDankaiKubun"));
            };

            Controls.prototype.celKikan41 = function () {
                return new UZA.TableCell(this.convFiledName("celKikan41"));
            };

            Controls.prototype.lblHokenryoritsu = function () {
                return new UZA.Label(this.convFiledName("lblHokenryoritsu"));
            };

            Controls.prototype.celKikan51 = function () {
                return new UZA.TableCell(this.convFiledName("celKikan51"));
            };

            Controls.prototype.lblHokenryoSanshutsugaku = function () {
                return new UZA.Label(this.convFiledName("lblHokenryoSanshutsugaku"));
            };

            Controls.prototype.celKikan12 = function () {
                return new UZA.TableCell(this.convFiledName("celKikan12"));
            };

            Controls.prototype.lblKikanData1 = function () {
                return new UZA.Label(this.convFiledName("lblKikanData1"));
            };

            Controls.prototype.celKikan22 = function () {
                return new UZA.TableCell(this.convFiledName("celKikan22"));
            };

            Controls.prototype.lblGessuData1 = function () {
                return new UZA.Label(this.convFiledName("lblGessuData1"));
            };

            Controls.prototype.celKikan32 = function () {
                return new UZA.TableCell(this.convFiledName("celKikan32"));
            };

            Controls.prototype.lblHokenryoDankaiKubunData1 = function () {
                return new UZA.Label(this.convFiledName("lblHokenryoDankaiKubunData1"));
            };

            Controls.prototype.celKikan42 = function () {
                return new UZA.TableCell(this.convFiledName("celKikan42"));
            };

            Controls.prototype.lblHokenryoritsuData1 = function () {
                return new UZA.Label(this.convFiledName("lblHokenryoritsuData1"));
            };

            Controls.prototype.celKikan52 = function () {
                return new UZA.TableCell(this.convFiledName("celKikan52"));
            };

            Controls.prototype.lblHokenryoSanshutsugakuData1 = function () {
                return new UZA.Label(this.convFiledName("lblHokenryoSanshutsugakuData1"));
            };

            Controls.prototype.celKikan13 = function () {
                return new UZA.TableCell(this.convFiledName("celKikan13"));
            };

            Controls.prototype.lblKikanData2 = function () {
                return new UZA.Label(this.convFiledName("lblKikanData2"));
            };

            Controls.prototype.celKikan23 = function () {
                return new UZA.TableCell(this.convFiledName("celKikan23"));
            };

            Controls.prototype.lblGessuData2 = function () {
                return new UZA.Label(this.convFiledName("lblGessuData2"));
            };

            Controls.prototype.celKikan33 = function () {
                return new UZA.TableCell(this.convFiledName("celKikan33"));
            };

            Controls.prototype.lblHokenryoDankaiKubunData2 = function () {
                return new UZA.Label(this.convFiledName("lblHokenryoDankaiKubunData2"));
            };

            Controls.prototype.celKikan43 = function () {
                return new UZA.TableCell(this.convFiledName("celKikan43"));
            };

            Controls.prototype.lblHokenryoritsuData2 = function () {
                return new UZA.Label(this.convFiledName("lblHokenryoritsuData2"));
            };

            Controls.prototype.celKikan53 = function () {
                return new UZA.TableCell(this.convFiledName("celKikan53"));
            };

            Controls.prototype.lblHokenryoSanshutsugakuData2 = function () {
                return new UZA.Label(this.convFiledName("lblHokenryoSanshutsugakuData2"));
            };

            Controls.prototype.txtChoteiJiyu1 = function () {
                return new UZA.TextBox(this.convFiledName("txtChoteiJiyu1"));
            };

            Controls.prototype.txtChoteiJiyu2 = function () {
                return new UZA.TextBox(this.convFiledName("txtChoteiJiyu2"));
            };

            Controls.prototype.txtChoteiJiyu3 = function () {
                return new UZA.TextBox(this.convFiledName("txtChoteiJiyu3"));
            };

            Controls.prototype.txtChoteiJiyu4 = function () {
                return new UZA.TextBox(this.convFiledName("txtChoteiJiyu4"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        KaigoHokenFukaKonkyo.Controls = Controls;
    })(DBX.KaigoHokenFukaKonkyo || (DBX.KaigoHokenFukaKonkyo = {}));
    var KaigoHokenFukaKonkyo = DBX.KaigoHokenFukaKonkyo;
})(DBX || (DBX = {}));
