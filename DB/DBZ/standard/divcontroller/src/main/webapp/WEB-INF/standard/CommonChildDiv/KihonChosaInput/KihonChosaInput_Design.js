var DBZ;
(function (DBZ) {
    (function (KihonChosaInput) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnOpenDialog = function () {
                return "onClick_btnOpenDialog";
            };

            Events.onClick_chkMahiChange = function () {
                return "onClick_chkMahiChange";
            };

            Events.onClick_chkKoshukuChange = function () {
                return "onClick_chkKoshukuChange";
            };
            return Events;
        })();
        KihonChosaInput.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KihonChosaInput";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KihonChosaInput.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KihonChosaInput.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KihonChosaInput = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ZenkaiHyojiTeiji = function () {
                return new UZA.Label(this.convFiledName("ZenkaiHyojiTeiji"));
            };

            Controls.prototype.DaiichigunShintaiKino = function () {
                return new UZA.Panel(this.convFiledName("DaiichigunShintaiKino"));
            };

            Controls.prototype.Mahi = function () {
                return new UZA.Panel(this.convFiledName("Mahi"));
            };

            Controls.prototype.btnMahi = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnMahi"));
            };

            Controls.prototype.chkMahi = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkMahi"));
            };

            Controls.prototype.Koshuku = function () {
                return new UZA.Panel(this.convFiledName("Koshuku"));
            };

            Controls.prototype.btnKoshuku = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKoshuku"));
            };

            Controls.prototype.chkKoshuku = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKoshuku"));
            };

            Controls.prototype.NeKaeri = function () {
                return new UZA.Panel(this.convFiledName("NeKaeri"));
            };

            Controls.prototype.btnNeKaeri = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnNeKaeri"));
            };

            Controls.prototype.radNeKaeri = function () {
                return new UZA.RadioButton(this.convFiledName("radNeKaeri"));
            };

            Controls.prototype.OkiAgari = function () {
                return new UZA.Panel(this.convFiledName("OkiAgari"));
            };

            Controls.prototype.btnOkiAgari = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnOkiAgari"));
            };

            Controls.prototype.radOkiAgari = function () {
                return new UZA.RadioButton(this.convFiledName("radOkiAgari"));
            };

            Controls.prototype.Zai = function () {
                return new UZA.Panel(this.convFiledName("Zai"));
            };

            Controls.prototype.btnZai = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnZai"));
            };

            Controls.prototype.radZai = function () {
                return new UZA.RadioButton(this.convFiledName("radZai"));
            };

            Controls.prototype.RyoAshi = function () {
                return new UZA.Panel(this.convFiledName("RyoAshi"));
            };

            Controls.prototype.btnRyoAshi = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnRyoAshi"));
            };

            Controls.prototype.radRyoAshi = function () {
                return new UZA.RadioButton(this.convFiledName("radRyoAshi"));
            };

            Controls.prototype.Buko = function () {
                return new UZA.Panel(this.convFiledName("Buko"));
            };

            Controls.prototype.btnBuko = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnBuko"));
            };

            Controls.prototype.radBuko = function () {
                return new UZA.RadioButton(this.convFiledName("radBuko"));
            };

            Controls.prototype.TachiAgari = function () {
                return new UZA.Panel(this.convFiledName("TachiAgari"));
            };

            Controls.prototype.btnTachiAgari = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnTachiAgari"));
            };

            Controls.prototype.radTachiAgari = function () {
                return new UZA.RadioButton(this.convFiledName("radTachiAgari"));
            };

            Controls.prototype.KataAshi = function () {
                return new UZA.Panel(this.convFiledName("KataAshi"));
            };

            Controls.prototype.btnKataAshi = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKataAshi"));
            };

            Controls.prototype.radKataAshi = function () {
                return new UZA.RadioButton(this.convFiledName("radKataAshi"));
            };

            Controls.prototype.Senshin = function () {
                return new UZA.Panel(this.convFiledName("Senshin"));
            };

            Controls.prototype.btnSenshin = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnSenshin"));
            };

            Controls.prototype.radSenshin = function () {
                return new UZA.RadioButton(this.convFiledName("radSenshin"));
            };

            Controls.prototype.TumeKiri = function () {
                return new UZA.Panel(this.convFiledName("TumeKiri"));
            };

            Controls.prototype.btnTumeKiri = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnTumeKiri"));
            };

            Controls.prototype.radTumeKiri = function () {
                return new UZA.RadioButton(this.convFiledName("radTumeKiri"));
            };

            Controls.prototype.Shiryoku = function () {
                return new UZA.Panel(this.convFiledName("Shiryoku"));
            };

            Controls.prototype.btnShiryoku = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShiryoku"));
            };

            Controls.prototype.radShiryoku = function () {
                return new UZA.RadioButton(this.convFiledName("radShiryoku"));
            };

            Controls.prototype.Choryoku = function () {
                return new UZA.Panel(this.convFiledName("Choryoku"));
            };

            Controls.prototype.btnChoryoku = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnChoryoku"));
            };

            Controls.prototype.radChoryoku = function () {
                return new UZA.RadioButton(this.convFiledName("radChoryoku"));
            };

            Controls.prototype.SeikatsuKinou = function () {
                return new UZA.Panel(this.convFiledName("SeikatsuKinou"));
            };

            Controls.prototype.Ijyo = function () {
                return new UZA.Panel(this.convFiledName("Ijyo"));
            };

            Controls.prototype.btnIjyo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnIjyo"));
            };

            Controls.prototype.radIjyo = function () {
                return new UZA.RadioButton(this.convFiledName("radIjyo"));
            };

            Controls.prototype.Idou = function () {
                return new UZA.Panel(this.convFiledName("Idou"));
            };

            Controls.prototype.btnIdou = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnIdou"));
            };

            Controls.prototype.radIdou = function () {
                return new UZA.RadioButton(this.convFiledName("radIdou"));
            };

            Controls.prototype.Enka = function () {
                return new UZA.Panel(this.convFiledName("Enka"));
            };

            Controls.prototype.btnEnka = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnEnka"));
            };

            Controls.prototype.radEnka = function () {
                return new UZA.RadioButton(this.convFiledName("radEnka"));
            };

            Controls.prototype.Shokuji = function () {
                return new UZA.Panel(this.convFiledName("Shokuji"));
            };

            Controls.prototype.btnShokuji = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShokuji"));
            };

            Controls.prototype.radShokuji = function () {
                return new UZA.RadioButton(this.convFiledName("radShokuji"));
            };

            Controls.prototype.Hainyo = function () {
                return new UZA.Panel(this.convFiledName("Hainyo"));
            };

            Controls.prototype.btnHainyo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHainyo"));
            };

            Controls.prototype.radHainyo = function () {
                return new UZA.RadioButton(this.convFiledName("radHainyo"));
            };

            Controls.prototype.Haiben = function () {
                return new UZA.Panel(this.convFiledName("Haiben"));
            };

            Controls.prototype.btnHaiben = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHaiben"));
            };

            Controls.prototype.radHaiben = function () {
                return new UZA.RadioButton(this.convFiledName("radHaiben"));
            };

            Controls.prototype.Kokou = function () {
                return new UZA.Panel(this.convFiledName("Kokou"));
            };

            Controls.prototype.btnKokou = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKokou"));
            };

            Controls.prototype.radKokou = function () {
                return new UZA.RadioButton(this.convFiledName("radKokou"));
            };

            Controls.prototype.Sengan = function () {
                return new UZA.Panel(this.convFiledName("Sengan"));
            };

            Controls.prototype.btnSengan = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnSengan"));
            };

            Controls.prototype.radSengan = function () {
                return new UZA.RadioButton(this.convFiledName("radSengan"));
            };

            Controls.prototype.Seihatsu = function () {
                return new UZA.Panel(this.convFiledName("Seihatsu"));
            };

            Controls.prototype.btnSeihatsu = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnSeihatsu"));
            };

            Controls.prototype.radSeihatsu = function () {
                return new UZA.RadioButton(this.convFiledName("radSeihatsu"));
            };

            Controls.prototype.Uwagi = function () {
                return new UZA.Panel(this.convFiledName("Uwagi"));
            };

            Controls.prototype.btnUwagi = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnUwagi"));
            };

            Controls.prototype.radUwagi = function () {
                return new UZA.RadioButton(this.convFiledName("radUwagi"));
            };

            Controls.prototype.Zubon = function () {
                return new UZA.Panel(this.convFiledName("Zubon"));
            };

            Controls.prototype.btnZubon = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnZubon"));
            };

            Controls.prototype.radZubon = function () {
                return new UZA.RadioButton(this.convFiledName("radZubon"));
            };

            Controls.prototype.Hindo = function () {
                return new UZA.Panel(this.convFiledName("Hindo"));
            };

            Controls.prototype.btnHindo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHindo"));
            };

            Controls.prototype.radHindo = function () {
                return new UZA.RadioButton(this.convFiledName("radHindo"));
            };

            Controls.prototype.NinchiKinou = function () {
                return new UZA.Panel(this.convFiledName("NinchiKinou"));
            };

            Controls.prototype.IshiDentatsu = function () {
                return new UZA.Panel(this.convFiledName("IshiDentatsu"));
            };

            Controls.prototype.btnIshiDentatsu = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnIshiDentatsu"));
            };

            Controls.prototype.radIshiDentatsu = function () {
                return new UZA.RadioButton(this.convFiledName("radIshiDentatsu"));
            };

            Controls.prototype.Nikka = function () {
                return new UZA.Panel(this.convFiledName("Nikka"));
            };

            Controls.prototype.btnNikka = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnNikka"));
            };

            Controls.prototype.radNikka = function () {
                return new UZA.RadioButton(this.convFiledName("radNikka"));
            };

            Controls.prototype.Info = function () {
                return new UZA.Panel(this.convFiledName("Info"));
            };

            Controls.prototype.btnInfo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnInfo"));
            };

            Controls.prototype.radInfo = function () {
                return new UZA.RadioButton(this.convFiledName("radInfo"));
            };

            Controls.prototype.DankiKioku = function () {
                return new UZA.Panel(this.convFiledName("DankiKioku"));
            };

            Controls.prototype.btnDankiKioku = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnDankiKioku"));
            };

            Controls.prototype.radDankiKioku = function () {
                return new UZA.RadioButton(this.convFiledName("radDankiKioku"));
            };

            Controls.prototype.NameInfo = function () {
                return new UZA.Panel(this.convFiledName("NameInfo"));
            };

            Controls.prototype.btnNameInfo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnNameInfo"));
            };

            Controls.prototype.radNameInfo = function () {
                return new UZA.RadioButton(this.convFiledName("radNameInfo"));
            };

            Controls.prototype.Kisetsu = function () {
                return new UZA.Panel(this.convFiledName("Kisetsu"));
            };

            Controls.prototype.btnKisetsu = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKisetsu"));
            };

            Controls.prototype.radKisetsu = function () {
                return new UZA.RadioButton(this.convFiledName("radKisetsu"));
            };

            Controls.prototype.Basho = function () {
                return new UZA.Panel(this.convFiledName("Basho"));
            };

            Controls.prototype.btnBasho = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnBasho"));
            };

            Controls.prototype.radBasho = function () {
                return new UZA.RadioButton(this.convFiledName("radBasho"));
            };

            Controls.prototype.Haikai = function () {
                return new UZA.Panel(this.convFiledName("Haikai"));
            };

            Controls.prototype.btnHaikai = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHaikai"));
            };

            Controls.prototype.radHaikai = function () {
                return new UZA.RadioButton(this.convFiledName("radHaikai"));
            };

            Controls.prototype.Modoru = function () {
                return new UZA.Panel(this.convFiledName("Modoru"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnModoru"));
            };

            Controls.prototype.radModoru = function () {
                return new UZA.RadioButton(this.convFiledName("radModoru"));
            };

            Controls.prototype.KoudoShogai = function () {
                return new UZA.Panel(this.convFiledName("KoudoShogai"));
            };

            Controls.prototype.Hiryaku = function () {
                return new UZA.Panel(this.convFiledName("Hiryaku"));
            };

            Controls.prototype.btnHiryaku = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHiryaku"));
            };

            Controls.prototype.radbtnHiryaku = function () {
                return new UZA.RadioButton(this.convFiledName("radbtnHiryaku"));
            };

            Controls.prototype.TukuriHanashi = function () {
                return new UZA.Panel(this.convFiledName("TukuriHanashi"));
            };

            Controls.prototype.btnTukuriHanashi = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnTukuriHanashi"));
            };

            Controls.prototype.radTukuriHanashi = function () {
                return new UZA.RadioButton(this.convFiledName("radTukuriHanashi"));
            };

            Controls.prototype.Kanjyo = function () {
                return new UZA.Panel(this.convFiledName("Kanjyo"));
            };

            Controls.prototype.btnKanjyo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKanjyo"));
            };

            Controls.prototype.radKanjyo = function () {
                return new UZA.RadioButton(this.convFiledName("radKanjyo"));
            };

            Controls.prototype.Chuyaku = function () {
                return new UZA.Panel(this.convFiledName("Chuyaku"));
            };

            Controls.prototype.btnChuyaku = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnChuyaku"));
            };

            Controls.prototype.radChuyaku = function () {
                return new UZA.RadioButton(this.convFiledName("radChuyaku"));
            };

            Controls.prototype.OnajiHanashi = function () {
                return new UZA.Panel(this.convFiledName("OnajiHanashi"));
            };

            Controls.prototype.btnOnajiHanashi = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnOnajiHanashi"));
            };

            Controls.prototype.radOnajiHanashi = function () {
                return new UZA.RadioButton(this.convFiledName("radOnajiHanashi"));
            };

            Controls.prototype.BigVoice = function () {
                return new UZA.Panel(this.convFiledName("BigVoice"));
            };

            Controls.prototype.btnBigVoice = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnBigVoice"));
            };

            Controls.prototype.radBigVoice = function () {
                return new UZA.RadioButton(this.convFiledName("radBigVoice"));
            };

            Controls.prototype.Teikou = function () {
                return new UZA.Panel(this.convFiledName("Teikou"));
            };

            Controls.prototype.btnTeikou = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnTeikou"));
            };

            Controls.prototype.radTeikou = function () {
                return new UZA.RadioButton(this.convFiledName("radTeikou"));
            };

            Controls.prototype.Ochituki = function () {
                return new UZA.Panel(this.convFiledName("Ochituki"));
            };

            Controls.prototype.btnOchituki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnOchituki"));
            };

            Controls.prototype.radOchituki = function () {
                return new UZA.RadioButton(this.convFiledName("radOchituki"));
            };

            Controls.prototype.OutLonly = function () {
                return new UZA.Panel(this.convFiledName("OutLonly"));
            };

            Controls.prototype.btnOutLonly = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnOutLonly"));
            };

            Controls.prototype.radOutLonly = function () {
                return new UZA.RadioButton(this.convFiledName("radOutLonly"));
            };

            Controls.prototype.Shushu = function () {
                return new UZA.Panel(this.convFiledName("Shushu"));
            };

            Controls.prototype.btnShushu = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShushu"));
            };

            Controls.prototype.radShushu = function () {
                return new UZA.RadioButton(this.convFiledName("radShushu"));
            };

            Controls.prototype.Kowasu = function () {
                return new UZA.Panel(this.convFiledName("Kowasu"));
            };

            Controls.prototype.btnKowasu = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKowasu"));
            };

            Controls.prototype.radKowasu = function () {
                return new UZA.RadioButton(this.convFiledName("radKowasu"));
            };

            Controls.prototype.MonoWasure = function () {
                return new UZA.Panel(this.convFiledName("MonoWasure"));
            };

            Controls.prototype.btnMonoWasure = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnMonoWasure"));
            };

            Controls.prototype.radMonoWasure = function () {
                return new UZA.RadioButton(this.convFiledName("radMonoWasure"));
            };

            Controls.prototype.HitoriWarai = function () {
                return new UZA.Panel(this.convFiledName("HitoriWarai"));
            };

            Controls.prototype.btnHitoriWarai = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHitoriWarai"));
            };

            Controls.prototype.radHitoriWarai = function () {
                return new UZA.RadioButton(this.convFiledName("radHitoriWarai"));
            };

            Controls.prototype.KateKodo = function () {
                return new UZA.Panel(this.convFiledName("KateKodo"));
            };

            Controls.prototype.btnKateKodo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKateKodo"));
            };

            Controls.prototype.radKateKodo = function () {
                return new UZA.RadioButton(this.convFiledName("radKateKodo"));
            };

            Controls.prototype.MatomeNai = function () {
                return new UZA.Panel(this.convFiledName("MatomeNai"));
            };

            Controls.prototype.btnMatomeNai = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnMatomeNai"));
            };

            Controls.prototype.radMatomeNai = function () {
                return new UZA.RadioButton(this.convFiledName("radMatomeNai"));
            };

            Controls.prototype.ShakaiSekatsu = function () {
                return new UZA.Panel(this.convFiledName("ShakaiSekatsu"));
            };

            Controls.prototype.Kusuri = function () {
                return new UZA.Panel(this.convFiledName("Kusuri"));
            };

            Controls.prototype.btnKusuri = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKusuri"));
            };

            Controls.prototype.radKusuri = function () {
                return new UZA.RadioButton(this.convFiledName("radKusuri"));
            };

            Controls.prototype.KingakuKanri = function () {
                return new UZA.Panel(this.convFiledName("KingakuKanri"));
            };

            Controls.prototype.btnKingakuKanri = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKingakuKanri"));
            };

            Controls.prototype.radKingakuKanri = function () {
                return new UZA.RadioButton(this.convFiledName("radKingakuKanri"));
            };

            Controls.prototype.IshiKetei = function () {
                return new UZA.Panel(this.convFiledName("IshiKetei"));
            };

            Controls.prototype.btnIshiKetei = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnIshiKetei"));
            };

            Controls.prototype.radIshiKetei = function () {
                return new UZA.RadioButton(this.convFiledName("radIshiKetei"));
            };

            Controls.prototype.Shudan = function () {
                return new UZA.Panel(this.convFiledName("Shudan"));
            };

            Controls.prototype.btnShudan = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShudan"));
            };

            Controls.prototype.radShudan = function () {
                return new UZA.RadioButton(this.convFiledName("radShudan"));
            };

            Controls.prototype.KaiMono = function () {
                return new UZA.Panel(this.convFiledName("KaiMono"));
            };

            Controls.prototype.btnKaiMono = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKaiMono"));
            };

            Controls.prototype.radKaiMono = function () {
                return new UZA.RadioButton(this.convFiledName("radKaiMono"));
            };

            Controls.prototype.KantanChori = function () {
                return new UZA.Panel(this.convFiledName("KantanChori"));
            };

            Controls.prototype.btnKantanChori = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKantanChori"));
            };

            Controls.prototype.radKantanChori = function () {
                return new UZA.RadioButton(this.convFiledName("radKantanChori"));
            };

            Controls.prototype.TokubetsuIryo = function () {
                return new UZA.Panel(this.convFiledName("TokubetsuIryo"));
            };

            Controls.prototype.ShochiNaiyo = function () {
                return new UZA.Panel(this.convFiledName("ShochiNaiyo"));
            };

            Controls.prototype.btnShochiNaiyo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShochiNaiyo"));
            };

            Controls.prototype.chkShochiNaiyo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkShochiNaiyo"));
            };

            Controls.prototype.TokiTaiou = function () {
                return new UZA.Panel(this.convFiledName("TokiTaiou"));
            };

            Controls.prototype.btnTokiTaiou = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnTokiTaiou"));
            };

            Controls.prototype.chkTokiTaiou = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkTokiTaiou"));
            };

            Controls.prototype.Jiritsudo = function () {
                return new UZA.Panel(this.convFiledName("Jiritsudo"));
            };

            Controls.prototype.ShogaiKoreisha = function () {
                return new UZA.Panel(this.convFiledName("ShogaiKoreisha"));
            };

            Controls.prototype.btnShogaiKoreisha = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShogaiKoreisha"));
            };

            Controls.prototype.radShogaiKoreisha = function () {
                return new UZA.RadioButton(this.convFiledName("radShogaiKoreisha"));
            };

            Controls.prototype.NinchishaJiritsudo = function () {
                return new UZA.Panel(this.convFiledName("NinchishaJiritsudo"));
            };

            Controls.prototype.btnNinchishaJiritsudo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnNinchishaJiritsudo"));
            };

            Controls.prototype.radNinchishaJiritsudo = function () {
                return new UZA.RadioButton(this.convFiledName("radNinchishaJiritsudo"));
            };
            return Controls;
        })();
        KihonChosaInput.Controls = Controls;
    })(DBZ.KihonChosaInput || (DBZ.KihonChosaInput = {}));
    var KihonChosaInput = DBZ.KihonChosaInput;
})(DBZ || (DBZ = {}));
