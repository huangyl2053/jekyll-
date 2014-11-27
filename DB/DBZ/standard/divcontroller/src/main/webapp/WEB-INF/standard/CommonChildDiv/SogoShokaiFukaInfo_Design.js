var DBZ;
(function (DBZ) {
    (function (SogoShokaiFukaInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        SogoShokaiFukaInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SogoShokaiFukaInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SogoShokaiFukaInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SogoShokaiFukaInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SogoShokaiFukaInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtFukaChoteiNendo = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtFukaChoteiNendo"));
            };

            Controls.prototype.txtFukaChoteiJiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtFukaChoteiJiyu"));
            };

            Controls.prototype.txtFukaKoseiTsuki = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFukaKoseiTsuki"));
            };

            Controls.prototype.txtFukaFukaNendo = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtFukaFukaNendo"));
            };

            Controls.prototype.txtFukaKazeiKubunHonnin = function () {
                return new UZA.TextBox(this.convFiledName("txtFukaKazeiKubunHonnin"));
            };

            Controls.prototype.txtFukaKazeiKubunSetai = function () {
                return new UZA.TextBox(this.convFiledName("txtFukaKazeiKubunSetai"));
            };

            Controls.prototype.tblFuka = function () {
                return new UZA.TablePanel(this.convFiledName("tblFuka"));
            };

            Controls.prototype.celFuka11 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka11"));
            };

            Controls.prototype.celFuka12 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka12"));
            };

            Controls.prototype.lblFukaKijun = function () {
                return new UZA.Label(this.convFiledName("lblFukaKijun"));
            };

            Controls.prototype.celFuka21 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka21"));
            };

            Controls.prototype.lblFukaKijunYMD = function () {
                return new UZA.Label(this.convFiledName("lblFukaKijunYMD"));
            };

            Controls.prototype.celFuka22 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka22"));
            };

            Controls.prototype.txtFukaKijunYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtFukaKijunYMD"));
            };

            Controls.prototype.celFuka31 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka31"));
            };

            Controls.prototype.celFuka32 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka32"));
            };

            Controls.prototype.lblZennendo = function () {
                return new UZA.Label(this.convFiledName("lblZennendo"));
            };

            Controls.prototype.celFuka41 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka41"));
            };

            Controls.prototype.lblShotokuDankai = function () {
                return new UZA.Label(this.convFiledName("lblShotokuDankai"));
            };

            Controls.prototype.celFuka42 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka42"));
            };

            Controls.prototype.txtShotokuDankai = function () {
                return new UZA.TextBox(this.convFiledName("txtShotokuDankai"));
            };

            Controls.prototype.celFuka51 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka51"));
            };

            Controls.prototype.lblHokenryoRitsu = function () {
                return new UZA.Label(this.convFiledName("lblHokenryoRitsu"));
            };

            Controls.prototype.celFuka52 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka52"));
            };

            Controls.prototype.txtHokenryoRitsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHokenryoRitsu"));
            };

            Controls.prototype.celFuka61 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka61"));
            };

            Controls.prototype.lblNenHokenryo = function () {
                return new UZA.Label(this.convFiledName("lblNenHokenryo"));
            };

            Controls.prototype.celFuka62 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka62"));
            };

            Controls.prototype.txtNenHokenryo = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtNenHokenryo"));
            };

            Controls.prototype.celFuka71 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka71"));
            };

            Controls.prototype.lblTokubetsuSaishugaku = function () {
                return new UZA.Label(this.convFiledName("lblTokubetsuSaishugaku"));
            };

            Controls.prototype.celFuka72 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka72"));
            };

            Controls.prototype.txtTokubetsuSaishugaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsuSaishugaku"));
            };

            Controls.prototype.celFuka81 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka81"));
            };

            Controls.prototype.lblFutsuSaishugaku = function () {
                return new UZA.Label(this.convFiledName("lblFutsuSaishugaku"));
            };

            Controls.prototype.celFuka82 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka82"));
            };

            Controls.prototype.txtFutsuSaishugaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsuSaishugaku"));
            };

            Controls.prototype.celFuka91 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka91"));
            };

            Controls.prototype.celFuka92 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka92"));
            };

            Controls.prototype.lblGenmen = function () {
                return new UZA.Label(this.convFiledName("lblGenmen"));
            };

            Controls.prototype.celFuka101 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka101"));
            };

            Controls.prototype.lblGenmengaku = function () {
                return new UZA.Label(this.convFiledName("lblGenmengaku"));
            };

            Controls.prototype.celFuka102 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka102"));
            };

            Controls.prototype.txtGenmengaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmengaku"));
            };

            Controls.prototype.celFuka111 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka111"));
            };

            Controls.prototype.celFuka112 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka112"));
            };

            Controls.prototype.lblEtc = function () {
                return new UZA.Label(this.convFiledName("lblEtc"));
            };

            Controls.prototype.celFuka121 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka121"));
            };

            Controls.prototype.lblZanteiGokei = function () {
                return new UZA.Label(this.convFiledName("lblZanteiGokei"));
            };

            Controls.prototype.celFuka122 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka122"));
            };

            Controls.prototype.txtZanteiGokei = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtZanteiGokei"));
            };

            Controls.prototype.celFuka131 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka131"));
            };

            Controls.prototype.lblSudeniNofugaku = function () {
                return new UZA.Label(this.convFiledName("lblSudeniNofugaku"));
            };

            Controls.prototype.celFuka132 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka132"));
            };

            Controls.prototype.txtSudeniNofugaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtSudeniNofugaku"));
            };

            Controls.prototype.celFuka141 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka141"));
            };

            Controls.prototype.lblKongoNofugaku = function () {
                return new UZA.Label(this.convFiledName("lblKongoNofugaku"));
            };

            Controls.prototype.celFuka142 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka142"));
            };

            Controls.prototype.txtKongoNofugaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtKongoNofugaku"));
            };

            Controls.prototype.celFuka151 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka151"));
            };

            Controls.prototype.lblNofuzumigaku = function () {
                return new UZA.Label(this.convFiledName("lblNofuzumigaku"));
            };

            Controls.prototype.celFuka152 = function () {
                return new UZA.TableCell(this.convFiledName("celFuka152"));
            };

            Controls.prototype.txtNofuzumigaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtNofuzumigaku"));
            };

            Controls.prototype.tblFutsuChoshu = function () {
                return new UZA.TablePanel(this.convFiledName("tblFutsuChoshu"));
            };

            Controls.prototype.celFutsuChoshu11 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu11"));
            };

            Controls.prototype.celFutsuChoshu12 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu12"));
            };

            Controls.prototype.lblFutsu = function () {
                return new UZA.Label(this.convFiledName("lblFutsu"));
            };

            Controls.prototype.celFutsuChoshu21 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu21"));
            };

            Controls.prototype.lblFutsu1 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu1"));
            };

            Controls.prototype.celFutsuChoshu22 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu22"));
            };

            Controls.prototype.txtFutsu1 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu1"));
            };

            Controls.prototype.celFutsuChoshu31 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu31"));
            };

            Controls.prototype.lblFutsu2 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu2"));
            };

            Controls.prototype.celFutsuChoshu32 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu32"));
            };

            Controls.prototype.txtFutsu2 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu2"));
            };

            Controls.prototype.celFutsuChoshu41 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu41"));
            };

            Controls.prototype.lblFutsu3 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu3"));
            };

            Controls.prototype.celFutsuChoshu42 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu42"));
            };

            Controls.prototype.txtFutsu3 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu3"));
            };

            Controls.prototype.celFutsuChoshu51 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu51"));
            };

            Controls.prototype.lblFutsu4 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu4"));
            };

            Controls.prototype.celFutsuChoshu52 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu52"));
            };

            Controls.prototype.txtFutsu4 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu4"));
            };

            Controls.prototype.celFutsuChoshu61 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu61"));
            };

            Controls.prototype.lblFutsu5 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu5"));
            };

            Controls.prototype.celFutsuChoshu62 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu62"));
            };

            Controls.prototype.txtFutsu5 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu5"));
            };

            Controls.prototype.celFutsuChoshu71 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu71"));
            };

            Controls.prototype.lblFutsu6 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu6"));
            };

            Controls.prototype.celFutsuChoshu72 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu72"));
            };

            Controls.prototype.txtFutsu6 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu6"));
            };

            Controls.prototype.celFutsuChoshu81 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu81"));
            };

            Controls.prototype.lblFutsu7 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu7"));
            };

            Controls.prototype.celFutsuChoshu82 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu82"));
            };

            Controls.prototype.txtFutsu7 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu7"));
            };

            Controls.prototype.celFutsuChoshu91 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu91"));
            };

            Controls.prototype.lblFutsu8 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu8"));
            };

            Controls.prototype.celFutsuChoshu92 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu92"));
            };

            Controls.prototype.txtFutsu8 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu8"));
            };

            Controls.prototype.celFutsuChoshu101 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu101"));
            };

            Controls.prototype.lblFutsu9 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu9"));
            };

            Controls.prototype.celFutsuChoshu102 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu102"));
            };

            Controls.prototype.txtFutsu9 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu9"));
            };

            Controls.prototype.celFutsuChoshu111 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu111"));
            };

            Controls.prototype.lblFutsu10 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu10"));
            };

            Controls.prototype.celFutsuChoshu112 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu112"));
            };

            Controls.prototype.txtFutsu10 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu10"));
            };

            Controls.prototype.celFutsuChoshu121 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu121"));
            };

            Controls.prototype.lblFutsu11 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu11"));
            };

            Controls.prototype.celFutsuChoshu122 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu122"));
            };

            Controls.prototype.txtFutsu11 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu11"));
            };

            Controls.prototype.celFutsuChoshu131 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu131"));
            };

            Controls.prototype.lblFutsu12 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu12"));
            };

            Controls.prototype.celFutsuChoshu132 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu132"));
            };

            Controls.prototype.txtFutsu12 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu12"));
            };

            Controls.prototype.celFutsuChoshu141 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu141"));
            };

            Controls.prototype.lblFutsu13 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu13"));
            };

            Controls.prototype.celFutsuChoshu142 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu142"));
            };

            Controls.prototype.txtFutsu13 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu13"));
            };

            Controls.prototype.celFutsuChoshu151 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu151"));
            };

            Controls.prototype.lblFutsu14 = function () {
                return new UZA.Label(this.convFiledName("lblFutsu14"));
            };

            Controls.prototype.celFutsuChoshu152 = function () {
                return new UZA.TableCell(this.convFiledName("celFutsuChoshu152"));
            };

            Controls.prototype.txtFutsu14 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtFutsu14"));
            };

            Controls.prototype.tblTokubetsuChoshu = function () {
                return new UZA.TablePanel(this.convFiledName("tblTokubetsuChoshu"));
            };

            Controls.prototype.celTokubetsuChoshu11 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu11"));
            };

            Controls.prototype.celTokubetsuChoshu12 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu12"));
            };

            Controls.prototype.lblTokubetsu = function () {
                return new UZA.Label(this.convFiledName("lblTokubetsu"));
            };

            Controls.prototype.celTokubetsuChoshu21 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu21"));
            };

            Controls.prototype.lblTokubetsu1 = function () {
                return new UZA.Label(this.convFiledName("lblTokubetsu1"));
            };

            Controls.prototype.celTokubetsuChoshu22 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu22"));
            };

            Controls.prototype.txtTokubetsu1 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsu1"));
            };

            Controls.prototype.celTokubetsuChoshu31 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu31"));
            };

            Controls.prototype.lblTokubetsu2 = function () {
                return new UZA.Label(this.convFiledName("lblTokubetsu2"));
            };

            Controls.prototype.celTokubetsuChoshu32 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu32"));
            };

            Controls.prototype.txtTokubetsu2 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsu2"));
            };

            Controls.prototype.celTokubetsuChoshu41 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu41"));
            };

            Controls.prototype.lblTokubetsu3 = function () {
                return new UZA.Label(this.convFiledName("lblTokubetsu3"));
            };

            Controls.prototype.celTokubetsuChoshu42 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu42"));
            };

            Controls.prototype.txtTokubetsu3 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsu3"));
            };

            Controls.prototype.celTokubetsuChoshu51 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu51"));
            };

            Controls.prototype.lblTokubetsu4 = function () {
                return new UZA.Label(this.convFiledName("lblTokubetsu4"));
            };

            Controls.prototype.celTokubetsuChoshu52 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu52"));
            };

            Controls.prototype.txtTokubetsu4 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsu4"));
            };

            Controls.prototype.celTokubetsuChoshu61 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu61"));
            };

            Controls.prototype.lblTokubetsu5 = function () {
                return new UZA.Label(this.convFiledName("lblTokubetsu5"));
            };

            Controls.prototype.celTokubetsuChoshu62 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu62"));
            };

            Controls.prototype.txtTokubetsu5 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsu5"));
            };

            Controls.prototype.celTokubetsuChoshu71 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu71"));
            };

            Controls.prototype.lblTokubetsu6 = function () {
                return new UZA.Label(this.convFiledName("lblTokubetsu6"));
            };

            Controls.prototype.celTokubetsuChoshu72 = function () {
                return new UZA.TableCell(this.convFiledName("celTokubetsuChoshu72"));
            };

            Controls.prototype.txtTokubetsu6 = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtTokubetsu6"));
            };

            Controls.prototype.SogoShokaiFukaTokubetsuChoshu = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiFukaTokubetsuChoshu"));
            };

            Controls.prototype.txtFukaTokubetsuChoshuNenkin = function () {
                return new UZA.TextBox(this.convFiledName("txtFukaTokubetsuChoshuNenkin"));
            };

            Controls.prototype.txtFukaTokubetsuChoshuGimusha = function () {
                return new UZA.TextBox(this.convFiledName("txtFukaTokubetsuChoshuGimusha"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        SogoShokaiFukaInfo.Controls = Controls;
    })(DBZ.SogoShokaiFukaInfo || (DBZ.SogoShokaiFukaInfo = {}));
    var SogoShokaiFukaInfo = DBZ.SogoShokaiFukaInfo;
})(DBZ || (DBZ = {}));
