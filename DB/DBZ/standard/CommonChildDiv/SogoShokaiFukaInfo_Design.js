var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBZ;
(function (DBZ) {
    (function (SogoShokaiFukaInfo) {
        var Events = (function () {
            function Events() {
            }
            Object.defineProperty(Events, "onClick_btnClose", {
                get: function () {
                    return "onClick_btnClose";
                },
                enumerable: true,
                configurable: true
            });
            return Events;
        })();
        SogoShokaiFukaInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Object.defineProperty(Controls, "MyType", {
                get: function () {
                    return "SogoShokaiFukaInfo";
                },
                enumerable: true,
                configurable: true
            });

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

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + Controls.MyType;
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + Controls.MyType + "_" + fieldName;
            };
            return Controls;
        })();
        SogoShokaiFukaInfo.Controls = Controls;
    })(DBZ.SogoShokaiFukaInfo || (DBZ.SogoShokaiFukaInfo = {}));
    var SogoShokaiFukaInfo = DBZ.SogoShokaiFukaInfo;

    var SogoShokaiFukaInfo_Design = (function (_super) {
        __extends(SogoShokaiFukaInfo_Design, _super);
        function SogoShokaiFukaInfo_Design($parentElement, isDesignMode, fieldName) {
            _super.call(this, $parentElement, isDesignMode, SogoShokaiFukaInfo_Design.myLayout, fieldName);
        }
        SogoShokaiFukaInfo_Design.prototype.registProperty = function () {
            _super.prototype.registProperty.call(this);
        };

        SogoShokaiFukaInfo_Design.prototype.getEditablePropertyInfo = function () {
            var editablePropertyInfo = _super.prototype.getEditablePropertyInfo.call(this);

            return editablePropertyInfo;
        };
        SogoShokaiFukaInfo_Design.myLayout = {
            "fieldName": "defaultLayout",
            "items": [
                {
                    "fieldName": "SogoShokaiFukaInfo",
                    "items": [
                        {
                            "fieldName": "txtFukaChoteiNendo",
                            "items": [],
                            "controlType": "TextBoxDate",
                            "width": "60",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": true,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "txtFukaChoteiNendo_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "調定年度",
                            "labelRText": "",
                            "labelLWidth": "75",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 0,
                            "displayFormat": 0,
                            "value": "",
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "txtFukaChoteiJiyu",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "300",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": false,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "txtFukaChoteiJiyu_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "調定事由",
                            "labelRText": "",
                            "labelLWidth": "73",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "textKind": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "decorationClass": "",
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtFukaKoseiTsuki",
                            "items": [],
                            "controlType": "TextBoxNum",
                            "width": "40",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": false,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "txtFukaKoseiTsuki_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "更正月",
                            "labelRText": "",
                            "labelLWidth": "50",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 2,
                            "textKind": 2,
                            "isComboBox": false,
                            "suggest": [],
                            "decorationClass": "",
                            "permitCharactor": "+-,.\\",
                            "maxValue": 1.7976931348623157e+308,
                            "minValue": 0,
                            "isCurrency": false,
                            "isComma": false,
                            "decimalPointLength": 0
                        },
                        {
                            "fieldName": "txtFukaFukaNendo",
                            "items": [],
                            "controlType": "TextBoxDate",
                            "width": "60",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": true,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "txtFukaFukaNendo_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "賦課年度",
                            "labelRText": "",
                            "labelLWidth": "75",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "ymdKubun": 0,
                            "displayFormat": 0,
                            "value": "",
                            "permitCharactor": "./_-"
                        },
                        {
                            "fieldName": "txtFukaKazeiKubunHonnin",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "80",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": false,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "txtFukaKazeiKubunHonnin_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "市町村民税課税区分(本人)",
                            "labelRText": "",
                            "labelLWidth": "200",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "textKind": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "decorationClass": "",
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "txtFukaKazeiKubunSetai",
                            "items": [],
                            "controlType": "TextBox",
                            "width": "80",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": false,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "txtFukaKazeiKubunSetai_core",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "readOnly": true,
                            "required": false,
                            "placeHolder": "",
                            "isPrivateInfo": false,
                            "isPassword": false,
                            "onFocus": "",
                            "onBlur": "",
                            "onChange": "",
                            "onKeyPress": "",
                            "text": "",
                            "labelLText": "市町村民税課税区分(世帯)",
                            "labelRText": "",
                            "labelLWidth": "200",
                            "labelRWidth": "S",
                            "labelLAlign": 2,
                            "labelRAlign": 0,
                            "value": "",
                            "maxLength": 100000000,
                            "minLength": 0,
                            "textAlign": 0,
                            "textKind": 0,
                            "isComboBox": false,
                            "suggest": [],
                            "decorationClass": "",
                            "permitCharactor": ""
                        },
                        {
                            "fieldName": "tblFuka",
                            "items": [
                                {
                                    "fieldName": "celFuka11",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka11",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C1"
                                },
                                {
                                    "fieldName": "celFuka12",
                                    "items": [
                                        {
                                            "fieldName": "lblFukaKijun",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFukaKijun",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "賦課基準",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka12",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C2"
                                },
                                {
                                    "fieldName": "celFuka21",
                                    "items": [
                                        {
                                            "fieldName": "lblFukaKijunYMD",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "160",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFukaKijunYMD",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "賦課基準日",
                                            "decorationClass": "",
                                            "align": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka21",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C1"
                                },
                                {
                                    "fieldName": "celFuka22",
                                    "items": [
                                        {
                                            "fieldName": "txtFukaKijunYMD",
                                            "items": [],
                                            "controlType": "TextBoxDate",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtFukaKijunYMD_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "ymdKubun": 2,
                                            "displayFormat": 0,
                                            "value": "",
                                            "permitCharactor": "./_-"
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka22",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C2"
                                },
                                {
                                    "fieldName": "celFuka31",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka31",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R3C1"
                                },
                                {
                                    "fieldName": "celFuka32",
                                    "items": [
                                        {
                                            "fieldName": "lblZennendo",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblZennendo",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "前年度情報",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka32",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R3C2"
                                },
                                {
                                    "fieldName": "celFuka41",
                                    "items": [
                                        {
                                            "fieldName": "lblShotokuDankai",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "160",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblShotokuDankai",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "所得段階",
                                            "decorationClass": "",
                                            "align": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka41",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R4C1"
                                },
                                {
                                    "fieldName": "celFuka42",
                                    "items": [
                                        {
                                            "fieldName": "txtShotokuDankai",
                                            "items": [],
                                            "controlType": "TextBox",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtShotokuDankai_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 0,
                                            "textKind": 0,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": ""
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka42",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R4C2"
                                },
                                {
                                    "fieldName": "celFuka51",
                                    "items": [
                                        {
                                            "fieldName": "lblHokenryoRitsu",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "160",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblHokenryoRitsu",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "保険料率",
                                            "decorationClass": "",
                                            "align": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka51",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R5C1"
                                },
                                {
                                    "fieldName": "celFuka52",
                                    "items": [
                                        {
                                            "fieldName": "txtHokenryoRitsu",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtHokenryoRitsu_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka52",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R5C2"
                                },
                                {
                                    "fieldName": "celFuka61",
                                    "items": [
                                        {
                                            "fieldName": "lblNenHokenryo",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "160",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblNenHokenryo",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "年額保険料",
                                            "decorationClass": "",
                                            "align": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka61",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R6C1"
                                },
                                {
                                    "fieldName": "celFuka62",
                                    "items": [
                                        {
                                            "fieldName": "txtNenHokenryo",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtNenHokenryo_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka62",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R6C2"
                                },
                                {
                                    "fieldName": "celFuka71",
                                    "items": [
                                        {
                                            "fieldName": "lblTokubetsuSaishugaku",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "160",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokubetsuSaishugaku",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "最終期保険料額(特)",
                                            "decorationClass": "",
                                            "align": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka71",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R7C1"
                                },
                                {
                                    "fieldName": "celFuka72",
                                    "items": [
                                        {
                                            "fieldName": "txtTokubetsuSaishugaku",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtTokubetsuSaishugaku_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka72",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R7C2"
                                },
                                {
                                    "fieldName": "celFuka81",
                                    "items": [
                                        {
                                            "fieldName": "lblFutsuSaishugaku",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "160",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFutsuSaishugaku",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "最終期保険料額(普)",
                                            "decorationClass": "",
                                            "align": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka81",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R8C1"
                                },
                                {
                                    "fieldName": "celFuka82",
                                    "items": [
                                        {
                                            "fieldName": "txtFutsuSaishugaku",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtFutsuSaishugaku_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka82",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R8C2"
                                },
                                {
                                    "fieldName": "celFuka91",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka91",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R9C1"
                                },
                                {
                                    "fieldName": "celFuka92",
                                    "items": [
                                        {
                                            "fieldName": "lblGenmen",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblGenmen",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "減免",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka92",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R9C2"
                                },
                                {
                                    "fieldName": "celFuka101",
                                    "items": [
                                        {
                                            "fieldName": "lblGenmengaku",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "160",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblGenmengaku",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "減免額",
                                            "decorationClass": "",
                                            "align": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka101",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R10C1"
                                },
                                {
                                    "fieldName": "celFuka102",
                                    "items": [
                                        {
                                            "fieldName": "txtGenmengaku",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtGenmengaku_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka102",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R10C2"
                                },
                                {
                                    "fieldName": "celFuka111",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka111",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R11C1"
                                },
                                {
                                    "fieldName": "celFuka112",
                                    "items": [
                                        {
                                            "fieldName": "lblEtc",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblEtc",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "その他",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka112",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R11C2"
                                },
                                {
                                    "fieldName": "celFuka121",
                                    "items": [
                                        {
                                            "fieldName": "lblZanteiGokei",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "160",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblZanteiGokei",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "暫定保険料額合計",
                                            "decorationClass": "",
                                            "align": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka121",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R12C1"
                                },
                                {
                                    "fieldName": "celFuka122",
                                    "items": [
                                        {
                                            "fieldName": "txtZanteiGokei",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtZanteiGokei_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka122",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R12C2"
                                },
                                {
                                    "fieldName": "celFuka131",
                                    "items": [
                                        {
                                            "fieldName": "lblSudeniNofugaku",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "160",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblSudeniNofugaku",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "既に納付すべき額",
                                            "decorationClass": "",
                                            "align": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka131",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R13C1"
                                },
                                {
                                    "fieldName": "celFuka132",
                                    "items": [
                                        {
                                            "fieldName": "txtSudeniNofugaku",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtSudeniNofugaku_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka132",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R13C2"
                                },
                                {
                                    "fieldName": "celFuka141",
                                    "items": [
                                        {
                                            "fieldName": "lblKongoNofugaku",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "160",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblKongoNofugaku",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "今後納付すべき額",
                                            "decorationClass": "",
                                            "align": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka141",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R14C1"
                                },
                                {
                                    "fieldName": "celFuka142",
                                    "items": [
                                        {
                                            "fieldName": "txtKongoNofugaku",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtKongoNofugaku_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka142",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R14C2"
                                },
                                {
                                    "fieldName": "celFuka151",
                                    "items": [
                                        {
                                            "fieldName": "lblNofuzumigaku",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "160",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblNofuzumigaku",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "未到来期の納付済額",
                                            "decorationClass": "",
                                            "align": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka151",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R15C1"
                                },
                                {
                                    "fieldName": "celFuka152",
                                    "items": [
                                        {
                                            "fieldName": "txtNofuzumigaku",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtNofuzumigaku_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFuka152",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R15C2"
                                }
                            ],
                            "controlType": "TablePanel",
                            "width": "XS",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": true,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "S",
                            "marginRight": "XS",
                            "selectControlID": "tblFuka",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "html": "<table border='1'>\n  <tbody>\n    <tr><td id='R1C1' bgcolor=\"#d7ebf6\"></td><td id='R1C2' bgcolor=\"#d7ebf6\"></td></tr>\n    <tr><td id='R2C1' bgcolor=\"#d7ebf6\"></td><td id='R2C2'></td></tr>\n    <tr><td id='R3C1' bgcolor=\"#d7ebf6\"></td><td id='R3C2'></td></tr>\n    <tr><td id='R4C1' bgcolor=\"#d7ebf6\"></td><td id='R4C2'></td></tr>\n    <tr><td id='R5C1' bgcolor=\"#d7ebf6\"></td><td id='R5C2'></td></tr>\n    <tr><td id='R6C1' bgcolor=\"#d7ebf6\"></td><td id='R6C2'></td></tr>\n    <tr><td id='R7C1' bgcolor=\"#d7ebf6\"></td><td id='R7C2'></td></tr>\n    <tr><td id='R8C1' bgcolor=\"#d7ebf6\"></td><td id='R8C2'></td></tr>\n    <tr><td id='R9C1' bgcolor=\"#d7ebf6\"></td><td id='R9C2'></td></tr>\n    <tr><td id='R10C1' bgcolor=\"#d7ebf6\"></td><td id='R10C2'></td></tr>\n    <tr><td id='R11C1' bgcolor=\"#d7ebf6\"></td><td id='R11C2'></td></tr>\n    <tr><td id='R12C1' bgcolor=\"#d7ebf6\"></td><td id='R12C2'></td></tr>\n    <tr><td id='R13C1' bgcolor=\"#d7ebf6\"></td><td id='R13C2'></td></tr>\n    <tr><td id='R14C1' bgcolor=\"#d7ebf6\"></td><td id='R14C2'></td></tr>\n    <tr><td id='R15C1' bgcolor=\"#d7ebf6\"></td><td id='R15C2'></td></tr>\n  </tbody>\n</table>"
                        },
                        {
                            "fieldName": "tblFutsuChoshu",
                            "items": [
                                {
                                    "fieldName": "celFutsuChoshu11",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu11",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C1"
                                },
                                {
                                    "fieldName": "celFutsuChoshu12",
                                    "items": [
                                        {
                                            "fieldName": "lblFutsu",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFutsu",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "普徴",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu12",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C2"
                                },
                                {
                                    "fieldName": "celFutsuChoshu21",
                                    "items": [
                                        {
                                            "fieldName": "lblFutsu1",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFutsu1",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "１期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu21",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C1"
                                },
                                {
                                    "fieldName": "celFutsuChoshu22",
                                    "items": [
                                        {
                                            "fieldName": "txtFutsu1",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtFutsu1_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu22",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C2"
                                },
                                {
                                    "fieldName": "celFutsuChoshu31",
                                    "items": [
                                        {
                                            "fieldName": "lblFutsu2",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFutsu2",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "２期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu31",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R3C1"
                                },
                                {
                                    "fieldName": "celFutsuChoshu32",
                                    "items": [
                                        {
                                            "fieldName": "txtFutsu2",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtFutsu2_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu32",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R3C2"
                                },
                                {
                                    "fieldName": "celFutsuChoshu41",
                                    "items": [
                                        {
                                            "fieldName": "lblFutsu3",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFutsu3",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "３期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu41",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R4C1"
                                },
                                {
                                    "fieldName": "celFutsuChoshu42",
                                    "items": [
                                        {
                                            "fieldName": "txtFutsu3",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtFutsu3_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu42",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R4C2"
                                },
                                {
                                    "fieldName": "celFutsuChoshu51",
                                    "items": [
                                        {
                                            "fieldName": "lblFutsu4",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFutsu4",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "４期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu51",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R5C1"
                                },
                                {
                                    "fieldName": "celFutsuChoshu52",
                                    "items": [
                                        {
                                            "fieldName": "txtFutsu4",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtFutsu4_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu52",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R5C2"
                                },
                                {
                                    "fieldName": "celFutsuChoshu61",
                                    "items": [
                                        {
                                            "fieldName": "lblFutsu5",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFutsu5",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "５期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu61",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R6C1"
                                },
                                {
                                    "fieldName": "celFutsuChoshu62",
                                    "items": [
                                        {
                                            "fieldName": "txtFutsu5",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtFutsu5_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu62",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R6C2"
                                },
                                {
                                    "fieldName": "celFutsuChoshu71",
                                    "items": [
                                        {
                                            "fieldName": "lblFutsu6",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFutsu6",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "６期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu71",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R7C1"
                                },
                                {
                                    "fieldName": "celFutsuChoshu72",
                                    "items": [
                                        {
                                            "fieldName": "txtFutsu6",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtFutsu6_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu72",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R7C2"
                                },
                                {
                                    "fieldName": "celFutsuChoshu81",
                                    "items": [
                                        {
                                            "fieldName": "lblFutsu7",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFutsu7",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "７期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu81",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R8C1"
                                },
                                {
                                    "fieldName": "celFutsuChoshu82",
                                    "items": [
                                        {
                                            "fieldName": "txtFutsu7",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtFutsu7_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu82",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R8C2"
                                },
                                {
                                    "fieldName": "celFutsuChoshu91",
                                    "items": [
                                        {
                                            "fieldName": "lblFutsu8",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFutsu8",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "８期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu91",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R9C1"
                                },
                                {
                                    "fieldName": "celFutsuChoshu92",
                                    "items": [
                                        {
                                            "fieldName": "txtFutsu8",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtFutsu8_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu92",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R9C2"
                                },
                                {
                                    "fieldName": "celFutsuChoshu101",
                                    "items": [
                                        {
                                            "fieldName": "lblFutsu9",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFutsu9",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "９期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu101",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R10C1"
                                },
                                {
                                    "fieldName": "celFutsuChoshu102",
                                    "items": [
                                        {
                                            "fieldName": "txtFutsu9",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtFutsu9_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "0",
                                            "labelRWidth": "0",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu102",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R10C2"
                                },
                                {
                                    "fieldName": "celFutsuChoshu111",
                                    "items": [
                                        {
                                            "fieldName": "lblFutsu10",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFutsu10",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "１０期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu111",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R11C1"
                                },
                                {
                                    "fieldName": "celFutsuChoshu112",
                                    "items": [
                                        {
                                            "fieldName": "txtFutsu10",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtFutsu10_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "0",
                                            "labelRWidth": "0",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu112",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R11C2"
                                },
                                {
                                    "fieldName": "celFutsuChoshu121",
                                    "items": [
                                        {
                                            "fieldName": "lblFutsu11",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFutsu11",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "１１期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu121",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R12C1"
                                },
                                {
                                    "fieldName": "celFutsuChoshu122",
                                    "items": [
                                        {
                                            "fieldName": "txtFutsu11",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtFutsu11_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu122",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R12C2"
                                },
                                {
                                    "fieldName": "celFutsuChoshu131",
                                    "items": [
                                        {
                                            "fieldName": "lblFutsu12",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFutsu12",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "１２期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu131",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R13C1"
                                },
                                {
                                    "fieldName": "celFutsuChoshu132",
                                    "items": [
                                        {
                                            "fieldName": "txtFutsu12",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtFutsu12_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu132",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R13C2"
                                },
                                {
                                    "fieldName": "celFutsuChoshu141",
                                    "items": [
                                        {
                                            "fieldName": "lblFutsu13",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFutsu13",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "１３期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu141",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R14C1"
                                },
                                {
                                    "fieldName": "celFutsuChoshu142",
                                    "items": [
                                        {
                                            "fieldName": "txtFutsu13",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtFutsu13_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu142",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R14C2"
                                },
                                {
                                    "fieldName": "celFutsuChoshu151",
                                    "items": [
                                        {
                                            "fieldName": "lblFutsu14",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblFutsu14",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "１４期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu151",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R15C1"
                                },
                                {
                                    "fieldName": "celFutsuChoshu152",
                                    "items": [
                                        {
                                            "fieldName": "txtFutsu14",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtFutsu14_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celFutsuChoshu152",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R15C2"
                                }
                            ],
                            "controlType": "TablePanel",
                            "width": "XS",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": false,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "tblFutsuChoshu",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "html": "<table border='1'>\n  <tbody>\n    <tr><td id='R1C1' bgcolor=\"#d7ebf6\"></td><td id='R1C2' bgcolor=\"#d7ebf6\"></td></tr>\n    <tr><td id='R2C1' bgcolor=\"#d7ebf6\"></td><td id='R2C2'></td></tr>\n    <tr><td id='R3C1' bgcolor=\"#d7ebf6\"></td><td id='R3C2'></td></tr>\n    <tr><td id='R4C1' bgcolor=\"#d7ebf6\"></td><td id='R4C2'></td></tr>\n    <tr><td id='R5C1' bgcolor=\"#d7ebf6\"></td><td id='R5C2'></td></tr>\n    <tr><td id='R6C1' bgcolor=\"#d7ebf6\"></td><td id='R6C2'></td></tr>\n    <tr><td id='R7C1' bgcolor=\"#d7ebf6\"></td><td id='R7C2'></td></tr>\n    <tr><td id='R8C1' bgcolor=\"#d7ebf6\"></td><td id='R8C2'></td></tr>\n    <tr><td id='R9C1' bgcolor=\"#d7ebf6\"></td><td id='R9C2'></td></tr>\n    <tr><td id='R10C1' bgcolor=\"#d7ebf6\"></td><td id='R10C2'></td></tr>\n    <tr><td id='R11C1' bgcolor=\"#d7ebf6\"></td><td id='R11C2'></td></tr>\n    <tr><td id='R12C1' bgcolor=\"#d7ebf6\"></td><td id='R12C2'></td></tr>\n    <tr><td id='R13C1' bgcolor=\"#d7ebf6\"></td><td id='R13C2'></td></tr>\n    <tr><td id='R14C1' bgcolor=\"#d7ebf6\"></td><td id='R14C2'></td></tr>\n    <tr><td id='R15C1' bgcolor=\"#d7ebf6\"></td><td id='R15C2'></td></tr>\n  </tbody>\n</table>"
                        },
                        {
                            "fieldName": "tblTokubetsuChoshu",
                            "items": [
                                {
                                    "fieldName": "celTokubetsuChoshu11",
                                    "items": [],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celTokubetsuChoshu11",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C1"
                                },
                                {
                                    "fieldName": "celTokubetsuChoshu12",
                                    "items": [
                                        {
                                            "fieldName": "lblTokubetsu",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokubetsu",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "特徴",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celTokubetsuChoshu12",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R1C2"
                                },
                                {
                                    "fieldName": "celTokubetsuChoshu21",
                                    "items": [
                                        {
                                            "fieldName": "lblTokubetsu1",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokubetsu1",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "１期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celTokubetsuChoshu21",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C1"
                                },
                                {
                                    "fieldName": "celTokubetsuChoshu22",
                                    "items": [
                                        {
                                            "fieldName": "txtTokubetsu1",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtTokubetsu1_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celTokubetsuChoshu22",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R2C2"
                                },
                                {
                                    "fieldName": "celTokubetsuChoshu31",
                                    "items": [
                                        {
                                            "fieldName": "lblTokubetsu2",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokubetsu2",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "２期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celTokubetsuChoshu31",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R3C1"
                                },
                                {
                                    "fieldName": "celTokubetsuChoshu32",
                                    "items": [
                                        {
                                            "fieldName": "txtTokubetsu2",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtTokubetsu2_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celTokubetsuChoshu32",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R3C2"
                                },
                                {
                                    "fieldName": "celTokubetsuChoshu41",
                                    "items": [
                                        {
                                            "fieldName": "lblTokubetsu3",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokubetsu3",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "３期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celTokubetsuChoshu41",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R4C1"
                                },
                                {
                                    "fieldName": "celTokubetsuChoshu42",
                                    "items": [
                                        {
                                            "fieldName": "txtTokubetsu3",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtTokubetsu3_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celTokubetsuChoshu42",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R4C2"
                                },
                                {
                                    "fieldName": "celTokubetsuChoshu51",
                                    "items": [
                                        {
                                            "fieldName": "lblTokubetsu4",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokubetsu4",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "４期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celTokubetsuChoshu51",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R5C1"
                                },
                                {
                                    "fieldName": "celTokubetsuChoshu52",
                                    "items": [
                                        {
                                            "fieldName": "txtTokubetsu4",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtTokubetsu4_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celTokubetsuChoshu52",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R5C2"
                                },
                                {
                                    "fieldName": "celTokubetsuChoshu61",
                                    "items": [
                                        {
                                            "fieldName": "lblTokubetsu5",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokubetsu5",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "５期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celTokubetsuChoshu61",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R6C1"
                                },
                                {
                                    "fieldName": "celTokubetsuChoshu62",
                                    "items": [
                                        {
                                            "fieldName": "txtTokubetsu5",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtTokubetsu5_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celTokubetsuChoshu62",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R6C2"
                                },
                                {
                                    "fieldName": "celTokubetsuChoshu71",
                                    "items": [
                                        {
                                            "fieldName": "lblTokubetsu6",
                                            "items": [],
                                            "controlType": "Label",
                                            "width": "60",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": true,
                                            "dependencies": [],
                                            "float": 1,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "XS",
                                            "marginRight": "XS",
                                            "selectControlID": "lblTokubetsu6",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "required": false,
                                            "isPrivateInfo": false,
                                            "text": "６期",
                                            "decorationClass": "",
                                            "align": 1
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celTokubetsuChoshu71",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R7C1"
                                },
                                {
                                    "fieldName": "celTokubetsuChoshu72",
                                    "items": [
                                        {
                                            "fieldName": "txtTokubetsu6",
                                            "items": [],
                                            "controlType": "TextBoxNum",
                                            "width": "100",
                                            "visible": true,
                                            "displayNone": false,
                                            "disabled": false,
                                            "accessKey": "",
                                            "nextFocusFieldName": "",
                                            "wrap": false,
                                            "dependencies": [],
                                            "float": 0,
                                            "toolTip": "",
                                            "authorityMode": 0,
                                            "marginLeft": "0",
                                            "marginRight": "0",
                                            "selectControlID": "txtTokubetsu6_core",
                                            "helpMessageID": "",
                                            "jpControlName": "",
                                            "readOnly": true,
                                            "required": false,
                                            "placeHolder": "",
                                            "isPrivateInfo": false,
                                            "isPassword": false,
                                            "onFocus": "",
                                            "onBlur": "",
                                            "onChange": "",
                                            "onKeyPress": "",
                                            "text": "",
                                            "labelLText": "",
                                            "labelRText": "",
                                            "labelLWidth": "S",
                                            "labelRWidth": "S",
                                            "labelLAlign": 2,
                                            "labelRAlign": 0,
                                            "value": "",
                                            "maxLength": 100000000,
                                            "minLength": 0,
                                            "textAlign": 2,
                                            "textKind": 2,
                                            "isComboBox": false,
                                            "suggest": [],
                                            "decorationClass": "",
                                            "permitCharactor": "+-,.\\",
                                            "maxValue": 1.7976931348623157e+308,
                                            "minValue": 0,
                                            "isCurrency": false,
                                            "isComma": true,
                                            "decimalPointLength": 0
                                        }
                                    ],
                                    "controlType": "TableCell",
                                    "width": "XS",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "0",
                                    "marginRight": "0",
                                    "selectControlID": "celTokubetsuChoshu72",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "connectTd": "R7C2"
                                }
                            ],
                            "controlType": "TablePanel",
                            "width": "XS",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": false,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "tblTokubetsuChoshu",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "html": "<table border='1'>\n  <tbody>\n    <tr><td id='R1C1' bgcolor=\"#d7ebf6\"></td><td id='R1C2' bgcolor=\"#d7ebf6\"></td></tr>\n    <tr><td id='R2C1' bgcolor=\"#d7ebf6\"></td><td id='R2C2'></td></tr>\n    <tr><td id='R3C1' bgcolor=\"#d7ebf6\"></td><td id='R3C2'></td></tr>\n    <tr><td id='R4C1' bgcolor=\"#d7ebf6\"></td><td id='R4C2'></td></tr>\n    <tr><td id='R5C1' bgcolor=\"#d7ebf6\"></td><td id='R5C2'></td></tr>\n    <tr><td id='R6C1' bgcolor=\"#d7ebf6\"></td><td id='R6C2'></td></tr>\n    <tr><td id='R7C1' bgcolor=\"#d7ebf6\"></td><td id='R7C2'></td></tr>\n  </tbody>\n</table>"
                        },
                        {
                            "fieldName": "SogoShokaiFukaTokubetsuChoshu",
                            "items": [
                                {
                                    "fieldName": "txtFukaTokubetsuChoshuNenkin",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "300",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "txtFukaTokubetsuChoshuNenkin_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": true,
                                    "required": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "labelLText": "対象年金",
                                    "labelRText": "",
                                    "labelLWidth": "65",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "decorationClass": "",
                                    "permitCharactor": ""
                                },
                                {
                                    "fieldName": "txtFukaTokubetsuChoshuGimusha",
                                    "items": [],
                                    "controlType": "TextBox",
                                    "width": "300",
                                    "visible": true,
                                    "displayNone": false,
                                    "disabled": false,
                                    "accessKey": "",
                                    "nextFocusFieldName": "",
                                    "wrap": false,
                                    "dependencies": [],
                                    "float": 0,
                                    "toolTip": "",
                                    "authorityMode": 0,
                                    "marginLeft": "XS",
                                    "marginRight": "XS",
                                    "selectControlID": "txtFukaTokubetsuChoshuGimusha_core",
                                    "helpMessageID": "",
                                    "jpControlName": "",
                                    "readOnly": true,
                                    "required": false,
                                    "placeHolder": "",
                                    "isPrivateInfo": false,
                                    "isPassword": false,
                                    "onFocus": "",
                                    "onBlur": "",
                                    "onChange": "",
                                    "onKeyPress": "",
                                    "text": "",
                                    "labelLText": "義務者",
                                    "labelRText": "",
                                    "labelLWidth": "50",
                                    "labelRWidth": "S",
                                    "labelLAlign": 2,
                                    "labelRAlign": 0,
                                    "value": "",
                                    "maxLength": 100000000,
                                    "minLength": 0,
                                    "textAlign": 0,
                                    "textKind": 0,
                                    "isComboBox": false,
                                    "suggest": [],
                                    "decorationClass": "",
                                    "permitCharactor": ""
                                }
                            ],
                            "controlType": "Panel",
                            "width": "G2",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": true,
                            "dependencies": [],
                            "float": 0,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "SogoShokaiFukaTokubetsuChoshu",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "onLoad": "",
                            "title": "特別徴収",
                            "marginTop": "Default",
                            "marginBottom": "Default",
                            "isOpen": true,
                            "canOpenAndClose": false,
                            "postParameterPanelNames": [
                                {
                                    "postParameterPanelNames": "SogoShokaiFukaTokubetsuChoshu"
                                }
                            ],
                            "requestSettings": [],
                            "hiddenInput": [],
                            "onOpen": "",
                            "onClose": "",
                            "session": {},
                            "eraseBorder": false,
                            "backgroundColor": 0,
                            "widthAuto": true,
                            "panelDisplay": 1,
                            "isGroupBox": false,
                            "readOnly": false,
                            "height": "Auto"
                        },
                        {
                            "fieldName": "btnClose",
                            "items": [],
                            "controlType": "Button",
                            "width": "S",
                            "visible": true,
                            "displayNone": false,
                            "disabled": false,
                            "accessKey": "",
                            "nextFocusFieldName": "",
                            "wrap": true,
                            "dependencies": [],
                            "float": 2,
                            "toolTip": "",
                            "authorityMode": 0,
                            "marginLeft": "XS",
                            "marginRight": "XS",
                            "selectControlID": "btnClose",
                            "helpMessageID": "",
                            "jpControlName": "",
                            "text": "閉じる",
                            "onClick": "onClick_btnClose",
                            "appearance": 0,
                            "imageFileUrl": "",
                            "imageWidth": "",
                            "imageHeight": "",
                            "icon": 0,
                            "heightTextBoxMatches": false
                        }
                    ],
                    "controlType": "Panel",
                    "width": "G2",
                    "visible": true,
                    "displayNone": false,
                    "disabled": false,
                    "accessKey": "",
                    "nextFocusFieldName": "",
                    "wrap": false,
                    "dependencies": [],
                    "float": 0,
                    "toolTip": "",
                    "authorityMode": 0,
                    "marginLeft": "0",
                    "marginRight": "0",
                    "selectControlID": "SogoShokaiFukaInfo",
                    "helpMessageID": "",
                    "jpControlName": "",
                    "onLoad": "",
                    "title": "賦課情報",
                    "marginTop": "Default",
                    "marginBottom": "Default",
                    "isOpen": true,
                    "canOpenAndClose": true,
                    "postParameterPanelNames": [
                        {
                            "postParameterPanelNames": "SogoShokaiFukaInfo"
                        }
                    ],
                    "requestSettings": [
                        {
                            "eventName": "onLoad",
                            "requestUrl": "dbu/db/dbu/SogoShokaiInfo/onLoad_FukaInfo"
                        }
                    ],
                    "hiddenInput": [],
                    "onOpen": "",
                    "onClose": "",
                    "session": {},
                    "eraseBorder": false,
                    "backgroundColor": 0,
                    "widthAuto": true,
                    "panelDisplay": 0,
                    "isGroupBox": false,
                    "readOnly": false,
                    "height": "Auto"
                }
            ],
            "controlType": "CommonChildDiv",
            "width": "XS",
            "visible": true,
            "displayNone": false,
            "disabled": false,
            "accessKey": "",
            "nextFocusFieldName": "",
            "wrap": false,
            "dependencies": [],
            "float": 0,
            "toolTip": "",
            "authorityMode": 0,
            "marginLeft": "0",
            "marginRight": "0",
            "selectControlID": "defaultLayout",
            "helpMessageID": "",
            "jpControlName": "",
            "relation": [],
            "businessId": "DBZ",
            "controlName": "SogoShokaiFukaInfo",
            "marginTop": 0,
            "marginBottom": 0,
            "originalProperty": [],
            "dataPassingForDialog": [],
            "dialogOkEventNameForDialog": "",
            "dialogCancelEventNameForDialog": "onClick_btnClose",
            "canTransferEvent": true,
            "heightForDialog": "Auto"
        };
        return SogoShokaiFukaInfo_Design;
    })(Uz.CommonChildDiv);
    DBZ.SogoShokaiFukaInfo_Design = SogoShokaiFukaInfo_Design;
})(DBZ || (DBZ = {}));
