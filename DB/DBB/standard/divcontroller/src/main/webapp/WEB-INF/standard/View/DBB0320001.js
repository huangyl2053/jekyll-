var DBB;
(function (DBB) {
    var DBB0320001_Events = (function () {
        function DBB0320001_Events() {
        }
        DBB0320001_Events.onLoad = function () {
            return "onLoad";
        };

        Object.defineProperty(DBB0320001_Events, "onClick_btnForRirekiFirst", {
            get: function () {
                return "onClick_btnForRirekiFirst";
            },
            enumerable: true,
            configurable: true
        });
        Object.defineProperty(DBB0320001_Events, "onClick_btnForRirekiSecond", {
            get: function () {
                return "onClick_btnForRirekiSecond";
            },
            enumerable: true,
            configurable: true
        });
        Object.defineProperty(DBB0320001_Events, "onClick_rireki", {
            get: function () {
                return "onClick_rireki";
            },
            enumerable: true,
            configurable: true
        });
        Object.defineProperty(DBB0320001_Events, "onClick_loadFukakonkyo", {
            get: function () {
                return "onClick_loadFukakonkyo";
            },
            enumerable: true,
            configurable: true
        });
        Object.defineProperty(DBB0320001_Events, "onClick_btnSetaiinShotoku", {
            get: function () {
                return "onClick_btnSetaiinShotoku";
            },
            enumerable: true,
            configurable: true
        });
        Object.defineProperty(DBB0320001_Events, "onClick_btnTokucho", {
            get: function () {
                return "onClick_btnTokucho";
            },
            enumerable: true,
            configurable: true
        });
        Object.defineProperty(DBB0320001_Events, "onClick_btnGenmen", {
            get: function () {
                return "onClick_btnGenmen";
            },
            enumerable: true,
            configurable: true
        });
        Object.defineProperty(DBB0320001_Events, "onClick_MaeHikaku", {
            get: function () {
                return "onClick_MaeHikaku";
            },
            enumerable: true,
            configurable: true
        });
        Object.defineProperty(DBB0320001_Events, "onSelect_FukaRireki", {
            get: function () {
                return "onSelect_FukaRireki";
            },
            enumerable: true,
            configurable: true
        });
        Object.defineProperty(DBB0320001_Events, "onAfterSelect_FukaRireki", {
            get: function () {
                return "onAfterSelect_FukaRireki";
            },
            enumerable: true,
            configurable: true
        });
        return DBB0320001_Events;
    })();
    DBB.DBB0320001_Events = DBB0320001_Events;

    var DBB0320001_Control = (function () {
        function DBB0320001_Control() {
        }
        DBB0320001_Control.EventPanel = function () {
            return new UZA.Panel("EventPanel");
        };

        DBB0320001_Control.btnForRirekiFirst = function () {
            return new UZA.Button("btnForRirekiFirst");
        };

        DBB0320001_Control.btnForRirekiSecond = function () {
            return new UZA.Button("btnForRirekiSecond");
        };

        DBB0320001_Control.KihonJoho = function () {
            return new UZA.Panel("KihonJoho");
        };

        DBB0320001_Control.FukaShokaiControl = function () {
            return new UZA.Panel("FukaShokaiControl");
        };

        DBB0320001_Control.txtChoteiNendo = function () {
            return new UZA.TextBoxFlexibleYear("txtChoteiNendo");
        };

        DBB0320001_Control.txtKoseiM = function () {
            return new UZA.TextBox("txtKoseiM");
        };

        DBB0320001_Control.txtKoseiYMD = function () {
            return new UZA.TextBoxFlexibleDate("txtKoseiYMD");
        };

        DBB0320001_Control.txtKoseiTime = function () {
            return new UZA.TextBoxTime("txtKoseiTime");
        };

        DBB0320001_Control.btnRirekiHyoji = function () {
            return new UZA.Button("btnRirekiHyoji");
        };

        DBB0320001_Control.btnFukakonkyoKiwari = function () {
            return new UZA.Button("btnFukakonkyoKiwari");
        };

        DBB0320001_Control.btnSetaiinShotoku = function () {
            return new UZA.Button("btnSetaiinShotoku");
        };

        DBB0320001_Control.btnTokucho = function () {
            return new UZA.Button("btnTokucho");
        };

        DBB0320001_Control.btnGemmen = function () {
            return new UZA.Button("btnGemmen");
        };

        DBB0320001_Control.FukaRirekiAllPanel = function () {
            return new UZA.Panel("FukaRirekiAllPanel");
        };

        DBB0320001_Control.lblMode = function () {
            return new UZA.Label("lblMode");
        };

        DBB0320001_Control.FukaRirekiPanel = function () {
            return new UZA.Panel("FukaRirekiPanel");
        };

        DBB0320001_Control.txtFukaNendoFukaRireki = function () {
            return new UZA.TextBoxFlexibleYear("txtFukaNendoFukaRireki");
        };

        DBB0320001_Control.dgFukaRirekiFukaRireki = function () {
            return new UZA.DataGrid("dgFukaRirekiFukaRireki");
        };

        DBB0320001_Control.FukakonkyoAndKiwari = function () {
            return new UZA.Panel("FukakonkyoAndKiwari");
        };

        DBB0320001_Control.tblFukaKonkyo = function () {
            return new UZA.TablePanel("tblFukaKonkyo");
        };

        DBB0320001_Control.celFukaKonkyo = function () {
            return new UZA.TableCell("celFukaKonkyo");
        };

        DBB0320001_Control.tblFukakonkyoMeisai = function () {
            return new UZA.TablePanel("tblFukakonkyoMeisai");
        };

        DBB0320001_Control.celFukashokaiKonkyo = function () {
            return new UZA.TableCell("celFukashokaiKonkyo");
        };

        DBB0320001_Control.lblFukakonkyoMidashi = function () {
            return new UZA.Label("lblFukakonkyoMidashi");
        };

        DBB0320001_Control.celFukashokaiKonkyo11 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo11");
        };

        DBB0320001_Control.lblFukakonkyo11 = function () {
            return new UZA.Label("lblFukakonkyo11");
        };

        DBB0320001_Control.celFukashokaiKonkyo21 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo21");
        };

        DBB0320001_Control.lblFukakijunYMD = function () {
            return new UZA.Label("lblFukakijunYMD");
        };

        DBB0320001_Control.celFukashokaiKonkyo31 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo31");
        };

        DBB0320001_Control.lblHonninKazei = function () {
            return new UZA.Label("lblHonninKazei");
        };

        DBB0320001_Control.lblZenHokenryoDankai = function () {
            return new UZA.Label("lblZenHokenryoDankai");
        };

        DBB0320001_Control.celFukashokaiKonkyo68 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo68");
        };

        DBB0320001_Control.lblHonninKazeiValue = function () {
            return new UZA.Label("lblHonninKazeiValue");
        };

        DBB0320001_Control.lblZenHokenryoDankaiValue = function () {
            return new UZA.Label("lblZenHokenryoDankaiValue");
        };

        DBB0320001_Control.celFukashokaiKonkyo12 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo12");
        };

        DBB0320001_Control.lblFukakonkyo12 = function () {
            return new UZA.Label("lblFukakonkyo12");
        };

        DBB0320001_Control.celFukashokaiKonkyo22 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo22");
        };

        DBB0320001_Control.lblShikakuShutokuYMD = function () {
            return new UZA.Label("lblShikakuShutokuYMD");
        };

        DBB0320001_Control.celFukashokaiKonkyo32 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo32");
        };

        DBB0320001_Control.lblSetaiKazei = function () {
            return new UZA.Label("lblSetaiKazei");
        };

        DBB0320001_Control.lblZenHokenryoritsu = function () {
            return new UZA.Label("lblZenHokenryoritsu");
        };

        DBB0320001_Control.celFukashokaiKonkyo69 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo69");
        };

        DBB0320001_Control.lblSetaiKazeiValue = function () {
            return new UZA.Label("lblSetaiKazeiValue");
        };

        DBB0320001_Control.lblZenHokenryoritsuValue = function () {
            return new UZA.Label("lblZenHokenryoritsuValue");
        };

        DBB0320001_Control.celFukashokaiKonkyo13 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo13");
        };

        DBB0320001_Control.lblFukakonkyo13 = function () {
            return new UZA.Label("lblFukakonkyo13");
        };

        DBB0320001_Control.celFukashokaiKonkyo23 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo23");
        };

        DBB0320001_Control.lblShikakuSoshitsuYMD = function () {
            return new UZA.Label("lblShikakuSoshitsuYMD");
        };

        DBB0320001_Control.celFukashokaiKonkyo33 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo33");
        };

        DBB0320001_Control.lblShotokuSum = function () {
            return new UZA.Label("lblShotokuSum");
        };

        DBB0320001_Control.lblZenNengakuHokenryo = function () {
            return new UZA.Label("lblZenNengakuHokenryo");
        };

        DBB0320001_Control.celFukashokaiKonkyo70 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo70");
        };

        DBB0320001_Control.lblShotokuSumValue = function () {
            return new UZA.Label("lblShotokuSumValue");
        };

        DBB0320001_Control.lblZenNengakuHokenryoValue = function () {
            return new UZA.Label("lblZenNengakuHokenryoValue");
        };

        DBB0320001_Control.celFukashokaiKonkyo14 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo14");
        };

        DBB0320001_Control.lblFukakonkyo14 = function () {
            return new UZA.Label("lblFukakonkyo14");
        };

        DBB0320001_Control.celFukashokaiKonkyo24 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo24");
        };

        DBB0320001_Control.lblSeihoKaishiYMD = function () {
            return new UZA.Label("lblSeihoKaishiYMD");
        };

        DBB0320001_Control.celFukashokaiKonkyo34 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo34");
        };

        DBB0320001_Control.lblNenkinShunyu = function () {
            return new UZA.Label("lblNenkinShunyu");
        };

        DBB0320001_Control.celFukashokaiKonkyo71 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo71");
        };

        DBB0320001_Control.lblNenkinShunyuValue = function () {
            return new UZA.Label("lblNenkinShunyuValue");
        };

        DBB0320001_Control.celFukashokaiKonkyo15 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo15");
        };

        DBB0320001_Control.lblFukakonkyo15 = function () {
            return new UZA.Label("lblFukakonkyo15");
        };

        DBB0320001_Control.celFukashokaiKonkyo25 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo25");
        };

        DBB0320001_Control.lblSeihoShuryoYMD = function () {
            return new UZA.Label("lblSeihoShuryoYMD");
        };

        DBB0320001_Control.celFukashokaiKonkyo35 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo35");
        };

        DBB0320001_Control.lblHokenryoDankai = function () {
            return new UZA.Label("lblHokenryoDankai");
        };

        DBB0320001_Control.celFukashokaiKonkyo72 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo72");
        };

        DBB0320001_Control.lblHokenryoDankaiValue = function () {
            return new UZA.Label("lblHokenryoDankaiValue");
        };

        DBB0320001_Control.celFukashokaiKonkyo16 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo16");
        };

        DBB0320001_Control.lblFukakonkyo16 = function () {
            return new UZA.Label("lblFukakonkyo16");
        };

        DBB0320001_Control.celFukashokaiKonkyo26 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo26");
        };

        DBB0320001_Control.lblRonenKaishiYMD = function () {
            return new UZA.Label("lblRonenKaishiYMD");
        };

        DBB0320001_Control.celFukashokaiKonkyo36 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo36");
        };

        DBB0320001_Control.lbldamy1 = function () {
            return new UZA.Label("lbldamy1");
        };

        DBB0320001_Control.celFukashokaiKonkyo73 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo73");
        };

        DBB0320001_Control.celFukashokaiKonkyo17 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo17");
        };

        DBB0320001_Control.lblFukakonkyo17 = function () {
            return new UZA.Label("lblFukakonkyo17");
        };

        DBB0320001_Control.celFukashokaiKonkyo27 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo27");
        };

        DBB0320001_Control.lblRonenShuryoYMD = function () {
            return new UZA.Label("lblRonenShuryoYMD");
        };

        DBB0320001_Control.celFukashokaiKonkyo61 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo61");
        };

        DBB0320001_Control.celFukashokaiKonkyo74 = function () {
            return new UZA.TableCell("celFukashokaiKonkyo74");
        };

        DBB0320001_Control.lblDamy = function () {
            return new UZA.Label("lblDamy");
        };

        DBB0320001_Control.txtZanteiKeisanjoHokenryoGaku = function () {
            return new UZA.TextBoxNum("txtZanteiKeisanjoHokenryoGaku");
        };

        DBB0320001_Control.txtZanteiGemmenGaku = function () {
            return new UZA.TextBoxNum("txtZanteiGemmenGaku");
        };

        DBB0320001_Control.txtZanteiHokenryoGaku = function () {
            return new UZA.TextBoxNum("txtZanteiHokenryoGaku");
        };

        DBB0320001_Control.celKiwari = function () {
            return new UZA.TableCell("celKiwari");
        };

        DBB0320001_Control.celKikan = function () {
            return new UZA.TableCell("celKikan");
        };

        DBB0320001_Control.Kikan = function () {
            return new UZA.Panel("Kikan");
        };

        DBB0320001_Control.tblKikan1 = function () {
            return new UZA.TablePanel("tblKikan1");
        };

        DBB0320001_Control.cellFukaShokaiData1 = function () {
            return new UZA.TableCell("cellFukaShokaiData1");
        };

        DBB0320001_Control.lblKikan = function () {
            return new UZA.Label("lblKikan");
        };

        DBB0320001_Control.cellFukaShokaiData2 = function () {
            return new UZA.TableCell("cellFukaShokaiData2");
        };

        DBB0320001_Control.lblTsukiSu = function () {
            return new UZA.Label("lblTsukiSu");
        };

        DBB0320001_Control.cellFukaShokaiData3 = function () {
            return new UZA.TableCell("cellFukaShokaiData3");
        };

        DBB0320001_Control.lblShotokuDankai = function () {
            return new UZA.Label("lblShotokuDankai");
        };

        DBB0320001_Control.cellFukaShokaiData10 = function () {
            return new UZA.TableCell("cellFukaShokaiData10");
        };

        DBB0320001_Control.lblHokenryoritsu = function () {
            return new UZA.Label("lblHokenryoritsu");
        };

        DBB0320001_Control.cellFukaShokaiData11 = function () {
            return new UZA.TableCell("cellFukaShokaiData11");
        };

        DBB0320001_Control.lblHokenryoSansyutsu = function () {
            return new UZA.Label("lblHokenryoSansyutsu");
        };

        DBB0320001_Control.cellFukaShokaiData12 = function () {
            return new UZA.TableCell("cellFukaShokaiData12");
        };

        DBB0320001_Control.lblHokenryo = function () {
            return new UZA.Label("lblHokenryo");
        };

        DBB0320001_Control.cellFukaShokaiData4 = function () {
            return new UZA.TableCell("cellFukaShokaiData4");
        };

        DBB0320001_Control.lblKikan1 = function () {
            return new UZA.Label("lblKikan1");
        };

        DBB0320001_Control.cellFukaShokaiData5 = function () {
            return new UZA.TableCell("cellFukaShokaiData5");
        };

        DBB0320001_Control.lblTsukiSu1 = function () {
            return new UZA.Label("lblTsukiSu1");
        };

        DBB0320001_Control.cellFukaShokaiData6 = function () {
            return new UZA.TableCell("cellFukaShokaiData6");
        };

        DBB0320001_Control.lblHokenryoDankai1 = function () {
            return new UZA.Label("lblHokenryoDankai1");
        };

        DBB0320001_Control.cellFukaShokaiData13 = function () {
            return new UZA.TableCell("cellFukaShokaiData13");
        };

        DBB0320001_Control.lblHokenryoritsu1 = function () {
            return new UZA.Label("lblHokenryoritsu1");
        };

        DBB0320001_Control.cellFukaShokaiData14 = function () {
            return new UZA.TableCell("cellFukaShokaiData14");
        };

        DBB0320001_Control.lblHokenryoSansyutsu1 = function () {
            return new UZA.Label("lblHokenryoSansyutsu1");
        };

        DBB0320001_Control.cellFukaShokaiData15 = function () {
            return new UZA.TableCell("cellFukaShokaiData15");
        };

        DBB0320001_Control.lblHokenryo1 = function () {
            return new UZA.Label("lblHokenryo1");
        };

        DBB0320001_Control.tblKikan2 = function () {
            return new UZA.TablePanel("tblKikan2");
        };

        DBB0320001_Control.cellFukaShokaiData16 = function () {
            return new UZA.TableCell("cellFukaShokaiData16");
        };

        DBB0320001_Control.lblKikan2 = function () {
            return new UZA.Label("lblKikan2");
        };

        DBB0320001_Control.cellFukaShokaiData17 = function () {
            return new UZA.TableCell("cellFukaShokaiData17");
        };

        DBB0320001_Control.lblTsukiSu2 = function () {
            return new UZA.Label("lblTsukiSu2");
        };

        DBB0320001_Control.cellFukaShokaiData18 = function () {
            return new UZA.TableCell("cellFukaShokaiData18");
        };

        DBB0320001_Control.lblHokenryoDankai2 = function () {
            return new UZA.Label("lblHokenryoDankai2");
        };

        DBB0320001_Control.cellFukaShokaiData19 = function () {
            return new UZA.TableCell("cellFukaShokaiData19");
        };

        DBB0320001_Control.lblHokenryoritsu2 = function () {
            return new UZA.Label("lblHokenryoritsu2");
        };

        DBB0320001_Control.cellFukaShokaiData20 = function () {
            return new UZA.TableCell("cellFukaShokaiData20");
        };

        DBB0320001_Control.lblHokenryoSansyutsu2 = function () {
            return new UZA.Label("lblHokenryoSansyutsu2");
        };

        DBB0320001_Control.cellFukaShokaiData21 = function () {
            return new UZA.TableCell("cellFukaShokaiData21");
        };

        DBB0320001_Control.lblHokenryo2 = function () {
            return new UZA.Label("lblHokenryo2");
        };

        DBB0320001_Control.FukakonkyoNengaku = function () {
            return new UZA.Panel("FukakonkyoNengaku");
        };

        DBB0320001_Control.KakuteiNengaku = function () {
            return new UZA.Panel("KakuteiNengaku");
        };

        DBB0320001_Control.txtKeisanjoNenkanHokenryoGaku = function () {
            return new UZA.TextBoxNum("txtKeisanjoNenkanHokenryoGaku");
        };

        DBB0320001_Control.txtGemmenGaku = function () {
            return new UZA.TextBoxNum("txtGemmenGaku");
        };

        DBB0320001_Control.txtNenkanHokenryoGaku = function () {
            return new UZA.TextBoxNum("txtNenkanHokenryoGaku");
        };

        DBB0320001_Control.celChoteiJiyu = function () {
            return new UZA.TableCell("celChoteiJiyu");
        };

        DBB0320001_Control.txtFukashokaiChoteiJiyu1 = function () {
            return new UZA.TextBox("txtFukashokaiChoteiJiyu1");
        };

        DBB0320001_Control.txtFukashokaiChoteiJiyu2 = function () {
            return new UZA.TextBox("txtFukashokaiChoteiJiyu2");
        };

        DBB0320001_Control.txtFukashokaiChoteiJiyu3 = function () {
            return new UZA.TextBox("txtFukashokaiChoteiJiyu3");
        };

        DBB0320001_Control.txtFukashokaiChoteiJiyu4 = function () {
            return new UZA.TextBox("txtFukashokaiChoteiJiyu4");
        };
        return DBB0320001_Control;
    })();
    DBB.DBB0320001_Control = DBB0320001_Control;
})(DBB || (DBB = {}));
