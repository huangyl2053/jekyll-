var DBZ;
(function (DBZ) {
    (function (KihonChosaInput) {
        var Events = (function () {
            function Events() {
            }
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

            Controls.prototype.DaiichigunShintaiKino = function () {
                return new UZA.Panel(this.convFiledName("DaiichigunShintaiKino"));
            };

            Controls.prototype.Mahi = function () {
                return new UZA.Panel(this.convFiledName("Mahi"));
            };

            Controls.prototype.btnMahi = function () {
                return new UZA.Button(this.convFiledName("btnMahi"));
            };

            Controls.prototype.chkMahi = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkMahi"));
            };

            Controls.prototype.chkMahi2 = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkMahi2"));
            };

            Controls.prototype.Koshuku = function () {
                return new UZA.Panel(this.convFiledName("Koshuku"));
            };

            Controls.prototype.btnKoshuku = function () {
                return new UZA.Button(this.convFiledName("btnKoshuku"));
            };

            Controls.prototype.chkKoshuku = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKoshuku"));
            };

            Controls.prototype.chkKoshuku2 = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKoshuku2"));
            };

            Controls.prototype.NeKaeri = function () {
                return new UZA.Panel(this.convFiledName("NeKaeri"));
            };

            Controls.prototype.btnNeKaeri = function () {
                return new UZA.Button(this.convFiledName("btnNeKaeri"));
            };

            Controls.prototype.radNeKaeri = function () {
                return new UZA.RadioButton(this.convFiledName("radNeKaeri"));
            };

            Controls.prototype.radNeKaeri2 = function () {
                return new UZA.RadioButton(this.convFiledName("radNeKaeri2"));
            };

            Controls.prototype.OkiAgari = function () {
                return new UZA.Panel(this.convFiledName("OkiAgari"));
            };

            Controls.prototype.btnOkiAgari = function () {
                return new UZA.Button(this.convFiledName("btnOkiAgari"));
            };

            Controls.prototype.radOkiAgari = function () {
                return new UZA.RadioButton(this.convFiledName("radOkiAgari"));
            };

            Controls.prototype.radOkiAgari2 = function () {
                return new UZA.RadioButton(this.convFiledName("radOkiAgari2"));
            };

            Controls.prototype.Zai = function () {
                return new UZA.Panel(this.convFiledName("Zai"));
            };

            Controls.prototype.btnZai = function () {
                return new UZA.Button(this.convFiledName("btnZai"));
            };

            Controls.prototype.radZai = function () {
                return new UZA.RadioButton(this.convFiledName("radZai"));
            };

            Controls.prototype.radZai2 = function () {
                return new UZA.RadioButton(this.convFiledName("radZai2"));
            };

            Controls.prototype.RyoAshi = function () {
                return new UZA.Panel(this.convFiledName("RyoAshi"));
            };

            Controls.prototype.btnRyoAshi = function () {
                return new UZA.Button(this.convFiledName("btnRyoAshi"));
            };

            Controls.prototype.radRyoAshi = function () {
                return new UZA.RadioButton(this.convFiledName("radRyoAshi"));
            };

            Controls.prototype.radRyoAshi2 = function () {
                return new UZA.RadioButton(this.convFiledName("radRyoAshi2"));
            };

            Controls.prototype.Buko = function () {
                return new UZA.Panel(this.convFiledName("Buko"));
            };

            Controls.prototype.btnBuko = function () {
                return new UZA.Button(this.convFiledName("btnBuko"));
            };

            Controls.prototype.radBuko = function () {
                return new UZA.RadioButton(this.convFiledName("radBuko"));
            };

            Controls.prototype.radBuko2 = function () {
                return new UZA.RadioButton(this.convFiledName("radBuko2"));
            };

            Controls.prototype.TachiAgari = function () {
                return new UZA.Panel(this.convFiledName("TachiAgari"));
            };

            Controls.prototype.btnTachiAgari = function () {
                return new UZA.Button(this.convFiledName("btnTachiAgari"));
            };

            Controls.prototype.radTachiAgari = function () {
                return new UZA.RadioButton(this.convFiledName("radTachiAgari"));
            };

            Controls.prototype.radTachiAgari2 = function () {
                return new UZA.RadioButton(this.convFiledName("radTachiAgari2"));
            };

            Controls.prototype.KataAshi = function () {
                return new UZA.Panel(this.convFiledName("KataAshi"));
            };

            Controls.prototype.btnKataAshi = function () {
                return new UZA.Button(this.convFiledName("btnKataAshi"));
            };

            Controls.prototype.radKataAshi = function () {
                return new UZA.RadioButton(this.convFiledName("radKataAshi"));
            };

            Controls.prototype.radKataAshi2 = function () {
                return new UZA.RadioButton(this.convFiledName("radKataAshi2"));
            };

            Controls.prototype.Senshin = function () {
                return new UZA.Panel(this.convFiledName("Senshin"));
            };

            Controls.prototype.btnSenshin = function () {
                return new UZA.Button(this.convFiledName("btnSenshin"));
            };

            Controls.prototype.radSenshin = function () {
                return new UZA.RadioButton(this.convFiledName("radSenshin"));
            };

            Controls.prototype.radSenshin2 = function () {
                return new UZA.RadioButton(this.convFiledName("radSenshin2"));
            };

            Controls.prototype.TumeKiri = function () {
                return new UZA.Panel(this.convFiledName("TumeKiri"));
            };

            Controls.prototype.btnTumeKiri = function () {
                return new UZA.Button(this.convFiledName("btnTumeKiri"));
            };

            Controls.prototype.radTumeKiri = function () {
                return new UZA.RadioButton(this.convFiledName("radTumeKiri"));
            };

            Controls.prototype.radTumeKiri2 = function () {
                return new UZA.RadioButton(this.convFiledName("radTumeKiri2"));
            };

            Controls.prototype.Shiryoku = function () {
                return new UZA.Panel(this.convFiledName("Shiryoku"));
            };

            Controls.prototype.btnShiryoku = function () {
                return new UZA.Button(this.convFiledName("btnShiryoku"));
            };

            Controls.prototype.radShiryoku = function () {
                return new UZA.RadioButton(this.convFiledName("radShiryoku"));
            };

            Controls.prototype.radShiryoku2 = function () {
                return new UZA.RadioButton(this.convFiledName("radShiryoku2"));
            };

            Controls.prototype.Choryoku = function () {
                return new UZA.Panel(this.convFiledName("Choryoku"));
            };

            Controls.prototype.btnChoryoku = function () {
                return new UZA.Button(this.convFiledName("btnChoryoku"));
            };

            Controls.prototype.radChoryoku = function () {
                return new UZA.RadioButton(this.convFiledName("radChoryoku"));
            };

            Controls.prototype.radChoryoku2 = function () {
                return new UZA.RadioButton(this.convFiledName("radChoryoku2"));
            };

            Controls.prototype.SeikatsuKinou = function () {
                return new UZA.Panel(this.convFiledName("SeikatsuKinou"));
            };

            Controls.prototype.Ijyo = function () {
                return new UZA.Panel(this.convFiledName("Ijyo"));
            };

            Controls.prototype.btnIjyo = function () {
                return new UZA.Button(this.convFiledName("btnIjyo"));
            };

            Controls.prototype.radIjyo = function () {
                return new UZA.RadioButton(this.convFiledName("radIjyo"));
            };

            Controls.prototype.radIjyo2 = function () {
                return new UZA.RadioButton(this.convFiledName("radIjyo2"));
            };

            Controls.prototype.Idou = function () {
                return new UZA.Panel(this.convFiledName("Idou"));
            };

            Controls.prototype.btnIdou = function () {
                return new UZA.Button(this.convFiledName("btnIdou"));
            };

            Controls.prototype.radIdou = function () {
                return new UZA.RadioButton(this.convFiledName("radIdou"));
            };

            Controls.prototype.radIdou2 = function () {
                return new UZA.RadioButton(this.convFiledName("radIdou2"));
            };

            Controls.prototype.Enka = function () {
                return new UZA.Panel(this.convFiledName("Enka"));
            };

            Controls.prototype.btnEnka = function () {
                return new UZA.Button(this.convFiledName("btnEnka"));
            };

            Controls.prototype.radEnka = function () {
                return new UZA.RadioButton(this.convFiledName("radEnka"));
            };

            Controls.prototype.radEnka2 = function () {
                return new UZA.RadioButton(this.convFiledName("radEnka2"));
            };

            Controls.prototype.Shokuji = function () {
                return new UZA.Panel(this.convFiledName("Shokuji"));
            };

            Controls.prototype.btnShokuji = function () {
                return new UZA.Button(this.convFiledName("btnShokuji"));
            };

            Controls.prototype.radShokuji = function () {
                return new UZA.RadioButton(this.convFiledName("radShokuji"));
            };

            Controls.prototype.radShokuji2 = function () {
                return new UZA.RadioButton(this.convFiledName("radShokuji2"));
            };

            Controls.prototype.Hainyo = function () {
                return new UZA.Panel(this.convFiledName("Hainyo"));
            };

            Controls.prototype.btnHainyo = function () {
                return new UZA.Button(this.convFiledName("btnHainyo"));
            };

            Controls.prototype.radHainyo = function () {
                return new UZA.RadioButton(this.convFiledName("radHainyo"));
            };

            Controls.prototype.radHainyo2 = function () {
                return new UZA.RadioButton(this.convFiledName("radHainyo2"));
            };

            Controls.prototype.Haiben = function () {
                return new UZA.Panel(this.convFiledName("Haiben"));
            };

            Controls.prototype.btnHaiben = function () {
                return new UZA.Button(this.convFiledName("btnHaiben"));
            };

            Controls.prototype.radHaiben = function () {
                return new UZA.RadioButton(this.convFiledName("radHaiben"));
            };

            Controls.prototype.radHaiben2 = function () {
                return new UZA.RadioButton(this.convFiledName("radHaiben2"));
            };

            Controls.prototype.Kokou = function () {
                return new UZA.Panel(this.convFiledName("Kokou"));
            };

            Controls.prototype.btnKokou = function () {
                return new UZA.Button(this.convFiledName("btnKokou"));
            };

            Controls.prototype.radKokou = function () {
                return new UZA.RadioButton(this.convFiledName("radKokou"));
            };

            Controls.prototype.radKokou2 = function () {
                return new UZA.RadioButton(this.convFiledName("radKokou2"));
            };

            Controls.prototype.Sengan = function () {
                return new UZA.Panel(this.convFiledName("Sengan"));
            };

            Controls.prototype.btnSengan = function () {
                return new UZA.Button(this.convFiledName("btnSengan"));
            };

            Controls.prototype.radSengan = function () {
                return new UZA.RadioButton(this.convFiledName("radSengan"));
            };

            Controls.prototype.radSengan2 = function () {
                return new UZA.RadioButton(this.convFiledName("radSengan2"));
            };

            Controls.prototype.Seihatsu = function () {
                return new UZA.Panel(this.convFiledName("Seihatsu"));
            };

            Controls.prototype.btnSeihatsu = function () {
                return new UZA.Button(this.convFiledName("btnSeihatsu"));
            };

            Controls.prototype.radSeihatsu = function () {
                return new UZA.RadioButton(this.convFiledName("radSeihatsu"));
            };

            Controls.prototype.radSeihatsu2 = function () {
                return new UZA.RadioButton(this.convFiledName("radSeihatsu2"));
            };

            Controls.prototype.Uwagi = function () {
                return new UZA.Panel(this.convFiledName("Uwagi"));
            };

            Controls.prototype.btnUwagi = function () {
                return new UZA.Button(this.convFiledName("btnUwagi"));
            };

            Controls.prototype.radUwagi = function () {
                return new UZA.RadioButton(this.convFiledName("radUwagi"));
            };

            Controls.prototype.radUwagi2 = function () {
                return new UZA.RadioButton(this.convFiledName("radUwagi2"));
            };

            Controls.prototype.Zubon = function () {
                return new UZA.Panel(this.convFiledName("Zubon"));
            };

            Controls.prototype.btnZubon = function () {
                return new UZA.Button(this.convFiledName("btnZubon"));
            };

            Controls.prototype.radZubon = function () {
                return new UZA.RadioButton(this.convFiledName("radZubon"));
            };

            Controls.prototype.radZubon2 = function () {
                return new UZA.RadioButton(this.convFiledName("radZubon2"));
            };

            Controls.prototype.Hindo = function () {
                return new UZA.Panel(this.convFiledName("Hindo"));
            };

            Controls.prototype.btnHindo = function () {
                return new UZA.Button(this.convFiledName("btnHindo"));
            };

            Controls.prototype.radHindo = function () {
                return new UZA.RadioButton(this.convFiledName("radHindo"));
            };

            Controls.prototype.radHindo2 = function () {
                return new UZA.RadioButton(this.convFiledName("radHindo2"));
            };

            Controls.prototype.NinchiKinou = function () {
                return new UZA.Panel(this.convFiledName("NinchiKinou"));
            };

            Controls.prototype.IshiDentatsu = function () {
                return new UZA.Panel(this.convFiledName("IshiDentatsu"));
            };

            Controls.prototype.btnIshiDentatsu = function () {
                return new UZA.Button(this.convFiledName("btnIshiDentatsu"));
            };

            Controls.prototype.radIshiDentatsu = function () {
                return new UZA.RadioButton(this.convFiledName("radIshiDentatsu"));
            };

            Controls.prototype.radIshiDentatsu2 = function () {
                return new UZA.RadioButton(this.convFiledName("radIshiDentatsu2"));
            };

            Controls.prototype.Nikka = function () {
                return new UZA.Panel(this.convFiledName("Nikka"));
            };

            Controls.prototype.btnNikka = function () {
                return new UZA.Button(this.convFiledName("btnNikka"));
            };

            Controls.prototype.radNikka = function () {
                return new UZA.RadioButton(this.convFiledName("radNikka"));
            };

            Controls.prototype.radNikka2 = function () {
                return new UZA.RadioButton(this.convFiledName("radNikka2"));
            };

            Controls.prototype.Info = function () {
                return new UZA.Panel(this.convFiledName("Info"));
            };

            Controls.prototype.btnInfo = function () {
                return new UZA.Button(this.convFiledName("btnInfo"));
            };

            Controls.prototype.radInfo = function () {
                return new UZA.RadioButton(this.convFiledName("radInfo"));
            };

            Controls.prototype.radInfo2 = function () {
                return new UZA.RadioButton(this.convFiledName("radInfo2"));
            };

            Controls.prototype.DankiKioku = function () {
                return new UZA.Panel(this.convFiledName("DankiKioku"));
            };

            Controls.prototype.btnDankiKioku = function () {
                return new UZA.Button(this.convFiledName("btnDankiKioku"));
            };

            Controls.prototype.radDankiKioku = function () {
                return new UZA.RadioButton(this.convFiledName("radDankiKioku"));
            };

            Controls.prototype.radDankiKioku2 = function () {
                return new UZA.RadioButton(this.convFiledName("radDankiKioku2"));
            };

            Controls.prototype.NameInfo = function () {
                return new UZA.Panel(this.convFiledName("NameInfo"));
            };

            Controls.prototype.btnNameInfo = function () {
                return new UZA.Button(this.convFiledName("btnNameInfo"));
            };

            Controls.prototype.radNameInfo = function () {
                return new UZA.RadioButton(this.convFiledName("radNameInfo"));
            };

            Controls.prototype.radNameInfo2 = function () {
                return new UZA.RadioButton(this.convFiledName("radNameInfo2"));
            };

            Controls.prototype.Kisetsu = function () {
                return new UZA.Panel(this.convFiledName("Kisetsu"));
            };

            Controls.prototype.btnKisetsu = function () {
                return new UZA.Button(this.convFiledName("btnKisetsu"));
            };

            Controls.prototype.radKisetsu = function () {
                return new UZA.RadioButton(this.convFiledName("radKisetsu"));
            };

            Controls.prototype.radKisetsu2 = function () {
                return new UZA.RadioButton(this.convFiledName("radKisetsu2"));
            };

            Controls.prototype.Basho = function () {
                return new UZA.Panel(this.convFiledName("Basho"));
            };

            Controls.prototype.btnBasho = function () {
                return new UZA.Button(this.convFiledName("btnBasho"));
            };

            Controls.prototype.radBasho = function () {
                return new UZA.RadioButton(this.convFiledName("radBasho"));
            };

            Controls.prototype.radBasho2 = function () {
                return new UZA.RadioButton(this.convFiledName("radBasho2"));
            };

            Controls.prototype.Haikai = function () {
                return new UZA.Panel(this.convFiledName("Haikai"));
            };

            Controls.prototype.btnHaikai = function () {
                return new UZA.Button(this.convFiledName("btnHaikai"));
            };

            Controls.prototype.radHaikai = function () {
                return new UZA.RadioButton(this.convFiledName("radHaikai"));
            };

            Controls.prototype.radHaikai2 = function () {
                return new UZA.RadioButton(this.convFiledName("radHaikai2"));
            };

            Controls.prototype.Modoru = function () {
                return new UZA.Panel(this.convFiledName("Modoru"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };

            Controls.prototype.radModoru = function () {
                return new UZA.RadioButton(this.convFiledName("radModoru"));
            };

            Controls.prototype.radModoru2 = function () {
                return new UZA.RadioButton(this.convFiledName("radModoru2"));
            };

            Controls.prototype.KoudoShogai = function () {
                return new UZA.Panel(this.convFiledName("KoudoShogai"));
            };

            Controls.prototype.Hiryaku = function () {
                return new UZA.Panel(this.convFiledName("Hiryaku"));
            };

            Controls.prototype.btnHiryaku = function () {
                return new UZA.Button(this.convFiledName("btnHiryaku"));
            };

            Controls.prototype.radbtnHiryaku = function () {
                return new UZA.RadioButton(this.convFiledName("radbtnHiryaku"));
            };

            Controls.prototype.radbtnHiryaku2 = function () {
                return new UZA.RadioButton(this.convFiledName("radbtnHiryaku2"));
            };

            Controls.prototype.TukuriHanashi = function () {
                return new UZA.Panel(this.convFiledName("TukuriHanashi"));
            };

            Controls.prototype.btnTukuriHanashi = function () {
                return new UZA.Button(this.convFiledName("btnTukuriHanashi"));
            };

            Controls.prototype.radTukuriHanashi = function () {
                return new UZA.RadioButton(this.convFiledName("radTukuriHanashi"));
            };

            Controls.prototype.radTukuriHanashi2 = function () {
                return new UZA.RadioButton(this.convFiledName("radTukuriHanashi2"));
            };

            Controls.prototype.Kanjyo = function () {
                return new UZA.Panel(this.convFiledName("Kanjyo"));
            };

            Controls.prototype.btnKanjyo = function () {
                return new UZA.Button(this.convFiledName("btnKanjyo"));
            };

            Controls.prototype.radKanjyo = function () {
                return new UZA.RadioButton(this.convFiledName("radKanjyo"));
            };

            Controls.prototype.radKanjyo2 = function () {
                return new UZA.RadioButton(this.convFiledName("radKanjyo2"));
            };

            Controls.prototype.Chuyaku = function () {
                return new UZA.Panel(this.convFiledName("Chuyaku"));
            };

            Controls.prototype.btnChuyaku = function () {
                return new UZA.Button(this.convFiledName("btnChuyaku"));
            };

            Controls.prototype.radChuyaku = function () {
                return new UZA.RadioButton(this.convFiledName("radChuyaku"));
            };

            Controls.prototype.radChuyaku2 = function () {
                return new UZA.RadioButton(this.convFiledName("radChuyaku2"));
            };

            Controls.prototype.OnajiHanashi = function () {
                return new UZA.Panel(this.convFiledName("OnajiHanashi"));
            };

            Controls.prototype.btnOnajiHanashi = function () {
                return new UZA.Button(this.convFiledName("btnOnajiHanashi"));
            };

            Controls.prototype.radOnajiHanashi = function () {
                return new UZA.RadioButton(this.convFiledName("radOnajiHanashi"));
            };

            Controls.prototype.radOnajiHanashi2 = function () {
                return new UZA.RadioButton(this.convFiledName("radOnajiHanashi2"));
            };

            Controls.prototype.BigVoice = function () {
                return new UZA.Panel(this.convFiledName("BigVoice"));
            };

            Controls.prototype.btnBigVoice = function () {
                return new UZA.Button(this.convFiledName("btnBigVoice"));
            };

            Controls.prototype.radBigVoice = function () {
                return new UZA.RadioButton(this.convFiledName("radBigVoice"));
            };

            Controls.prototype.radBigVoice2 = function () {
                return new UZA.RadioButton(this.convFiledName("radBigVoice2"));
            };

            Controls.prototype.Teikou = function () {
                return new UZA.Panel(this.convFiledName("Teikou"));
            };

            Controls.prototype.btnTeikou = function () {
                return new UZA.Button(this.convFiledName("btnTeikou"));
            };

            Controls.prototype.radTeikou = function () {
                return new UZA.RadioButton(this.convFiledName("radTeikou"));
            };

            Controls.prototype.radTeikou2 = function () {
                return new UZA.RadioButton(this.convFiledName("radTeikou2"));
            };

            Controls.prototype.Ochituki = function () {
                return new UZA.Panel(this.convFiledName("Ochituki"));
            };

            Controls.prototype.btnOchituki = function () {
                return new UZA.Button(this.convFiledName("btnOchituki"));
            };

            Controls.prototype.radOchituki = function () {
                return new UZA.RadioButton(this.convFiledName("radOchituki"));
            };

            Controls.prototype.radOchituki2 = function () {
                return new UZA.RadioButton(this.convFiledName("radOchituki2"));
            };

            Controls.prototype.OutLonly = function () {
                return new UZA.Panel(this.convFiledName("OutLonly"));
            };

            Controls.prototype.btnOutLonly = function () {
                return new UZA.Button(this.convFiledName("btnOutLonly"));
            };

            Controls.prototype.radOutLonly = function () {
                return new UZA.RadioButton(this.convFiledName("radOutLonly"));
            };

            Controls.prototype.radOutLonly2 = function () {
                return new UZA.RadioButton(this.convFiledName("radOutLonly2"));
            };

            Controls.prototype.Shushu = function () {
                return new UZA.Panel(this.convFiledName("Shushu"));
            };

            Controls.prototype.btnShushu = function () {
                return new UZA.Button(this.convFiledName("btnShushu"));
            };

            Controls.prototype.radShushu = function () {
                return new UZA.RadioButton(this.convFiledName("radShushu"));
            };

            Controls.prototype.radShushu2 = function () {
                return new UZA.RadioButton(this.convFiledName("radShushu2"));
            };

            Controls.prototype.Kowasu = function () {
                return new UZA.Panel(this.convFiledName("Kowasu"));
            };

            Controls.prototype.btnKowasu = function () {
                return new UZA.Button(this.convFiledName("btnKowasu"));
            };

            Controls.prototype.radKowasu = function () {
                return new UZA.RadioButton(this.convFiledName("radKowasu"));
            };

            Controls.prototype.radKowasu2 = function () {
                return new UZA.RadioButton(this.convFiledName("radKowasu2"));
            };

            Controls.prototype.MonoWasure = function () {
                return new UZA.Panel(this.convFiledName("MonoWasure"));
            };

            Controls.prototype.btnMonoWasure = function () {
                return new UZA.Button(this.convFiledName("btnMonoWasure"));
            };

            Controls.prototype.radMonoWasure = function () {
                return new UZA.RadioButton(this.convFiledName("radMonoWasure"));
            };

            Controls.prototype.radMonoWasure2 = function () {
                return new UZA.RadioButton(this.convFiledName("radMonoWasure2"));
            };

            Controls.prototype.HitoriWarai = function () {
                return new UZA.Panel(this.convFiledName("HitoriWarai"));
            };

            Controls.prototype.btnHitoriWarai = function () {
                return new UZA.Button(this.convFiledName("btnHitoriWarai"));
            };

            Controls.prototype.radHitoriWarai = function () {
                return new UZA.RadioButton(this.convFiledName("radHitoriWarai"));
            };

            Controls.prototype.radHitoriWarai2 = function () {
                return new UZA.RadioButton(this.convFiledName("radHitoriWarai2"));
            };

            Controls.prototype.KateKodo = function () {
                return new UZA.Panel(this.convFiledName("KateKodo"));
            };

            Controls.prototype.btnKateKodo = function () {
                return new UZA.Button(this.convFiledName("btnKateKodo"));
            };

            Controls.prototype.radKateKodo = function () {
                return new UZA.RadioButton(this.convFiledName("radKateKodo"));
            };

            Controls.prototype.radKateKodo2 = function () {
                return new UZA.RadioButton(this.convFiledName("radKateKodo2"));
            };

            Controls.prototype.MatomeNai = function () {
                return new UZA.Panel(this.convFiledName("MatomeNai"));
            };

            Controls.prototype.btnMatomeNai = function () {
                return new UZA.Button(this.convFiledName("btnMatomeNai"));
            };

            Controls.prototype.radMatomeNai = function () {
                return new UZA.RadioButton(this.convFiledName("radMatomeNai"));
            };

            Controls.prototype.radMatomeNai2 = function () {
                return new UZA.RadioButton(this.convFiledName("radMatomeNai2"));
            };

            Controls.prototype.ShakaiSekatsu = function () {
                return new UZA.Panel(this.convFiledName("ShakaiSekatsu"));
            };

            Controls.prototype.Kusuri = function () {
                return new UZA.Panel(this.convFiledName("Kusuri"));
            };

            Controls.prototype.btnKusuri = function () {
                return new UZA.Button(this.convFiledName("btnKusuri"));
            };

            Controls.prototype.radKusuri = function () {
                return new UZA.RadioButton(this.convFiledName("radKusuri"));
            };

            Controls.prototype.radKusuri2 = function () {
                return new UZA.RadioButton(this.convFiledName("radKusuri2"));
            };

            Controls.prototype.KingakuKanri = function () {
                return new UZA.Panel(this.convFiledName("KingakuKanri"));
            };

            Controls.prototype.btnKingakuKanri = function () {
                return new UZA.Button(this.convFiledName("btnKingakuKanri"));
            };

            Controls.prototype.radKingakuKanri = function () {
                return new UZA.RadioButton(this.convFiledName("radKingakuKanri"));
            };

            Controls.prototype.radKingakuKanri2 = function () {
                return new UZA.RadioButton(this.convFiledName("radKingakuKanri2"));
            };

            Controls.prototype.IshiKetei = function () {
                return new UZA.Panel(this.convFiledName("IshiKetei"));
            };

            Controls.prototype.btnIshiKetei = function () {
                return new UZA.Button(this.convFiledName("btnIshiKetei"));
            };

            Controls.prototype.radIshiKetei = function () {
                return new UZA.RadioButton(this.convFiledName("radIshiKetei"));
            };

            Controls.prototype.radIshiKetei2 = function () {
                return new UZA.RadioButton(this.convFiledName("radIshiKetei2"));
            };

            Controls.prototype.Shudan = function () {
                return new UZA.Panel(this.convFiledName("Shudan"));
            };

            Controls.prototype.btnShudan = function () {
                return new UZA.Button(this.convFiledName("btnShudan"));
            };

            Controls.prototype.radShudan = function () {
                return new UZA.RadioButton(this.convFiledName("radShudan"));
            };

            Controls.prototype.radShudan2 = function () {
                return new UZA.RadioButton(this.convFiledName("radShudan2"));
            };

            Controls.prototype.KaiMono = function () {
                return new UZA.Panel(this.convFiledName("KaiMono"));
            };

            Controls.prototype.btnKaiMono = function () {
                return new UZA.Button(this.convFiledName("btnKaiMono"));
            };

            Controls.prototype.radKaiMono = function () {
                return new UZA.RadioButton(this.convFiledName("radKaiMono"));
            };

            Controls.prototype.radKaiMono2 = function () {
                return new UZA.RadioButton(this.convFiledName("radKaiMono2"));
            };

            Controls.prototype.KantanChori = function () {
                return new UZA.Panel(this.convFiledName("KantanChori"));
            };

            Controls.prototype.btnKantanChori = function () {
                return new UZA.Button(this.convFiledName("btnKantanChori"));
            };

            Controls.prototype.radKantanChori = function () {
                return new UZA.RadioButton(this.convFiledName("radKantanChori"));
            };

            Controls.prototype.radKantanChori2 = function () {
                return new UZA.RadioButton(this.convFiledName("radKantanChori2"));
            };

            Controls.prototype.TokubetsuIryo = function () {
                return new UZA.Panel(this.convFiledName("TokubetsuIryo"));
            };

            Controls.prototype.ShochiNaiyo = function () {
                return new UZA.Panel(this.convFiledName("ShochiNaiyo"));
            };

            Controls.prototype.btnShochiNaiyo = function () {
                return new UZA.Button(this.convFiledName("btnShochiNaiyo"));
            };

            Controls.prototype.chkShochiNaiyo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkShochiNaiyo"));
            };

            Controls.prototype.chkShochiNaiyo2 = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkShochiNaiyo2"));
            };

            Controls.prototype.TokiTaiou = function () {
                return new UZA.Panel(this.convFiledName("TokiTaiou"));
            };

            Controls.prototype.btnTokiTaiou = function () {
                return new UZA.Button(this.convFiledName("btnTokiTaiou"));
            };

            Controls.prototype.chkTokiTaiou = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkTokiTaiou"));
            };

            Controls.prototype.chkTokiTaiou2 = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkTokiTaiou2"));
            };

            Controls.prototype.Jiritsudo = function () {
                return new UZA.Panel(this.convFiledName("Jiritsudo"));
            };

            Controls.prototype.ShogaiKoreisha = function () {
                return new UZA.Panel(this.convFiledName("ShogaiKoreisha"));
            };

            Controls.prototype.btnShogaiKoreisha = function () {
                return new UZA.Button(this.convFiledName("btnShogaiKoreisha"));
            };

            Controls.prototype.radShogaiKoreisha = function () {
                return new UZA.RadioButton(this.convFiledName("radShogaiKoreisha"));
            };

            Controls.prototype.radShogaiKoreisha2 = function () {
                return new UZA.RadioButton(this.convFiledName("radShogaiKoreisha2"));
            };

            Controls.prototype.NinchishaJiritsudo = function () {
                return new UZA.Panel(this.convFiledName("NinchishaJiritsudo"));
            };

            Controls.prototype.btnNinchishaJiritsudo = function () {
                return new UZA.Button(this.convFiledName("btnNinchishaJiritsudo"));
            };

            Controls.prototype.radNinchishaJiritsudo = function () {
                return new UZA.RadioButton(this.convFiledName("radNinchishaJiritsudo"));
            };

            Controls.prototype.radNinchishaJiritsudo2 = function () {
                return new UZA.RadioButton(this.convFiledName("radNinchishaJiritsudo2"));
            };
            return Controls;
        })();
        KihonChosaInput.Controls = Controls;
    })(DBZ.KihonChosaInput || (DBZ.KihonChosaInput = {}));
    var KihonChosaInput = DBZ.KihonChosaInput;
})(DBZ || (DBZ = {}));
