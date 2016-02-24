/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KihonChosaInput {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "KihonChosaInput";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.KihonChosaInput.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.KihonChosaInput.Controls.myType() + "_" + fieldName;
            }

            public KihonChosaInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public ZenkaiHyojiTeiji(): UZA.Label {
                return new UZA.Label(this.convFiledName("ZenkaiHyojiTeiji"));
            }

            public DaiichigunShintaiKino(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("DaiichigunShintaiKino"));
            }

            public Mahi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Mahi"));
            }

            public btnMahi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnMahi"));
            }

            public chkMahi(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkMahi"));
            }

            public Koshuku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Koshuku"));
            }

            public btnKoshuku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKoshuku"));
            }

            public chkKoshuku(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKoshuku"));
            }

            public NeKaeri(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NeKaeri"));
            }

            public btnNeKaeri(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnNeKaeri"));
            }

            public radNeKaeri(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radNeKaeri"));
            }

            public OkiAgari(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("OkiAgari"));
            }

            public btnOkiAgari(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnOkiAgari"));
            }

            public radOkiAgari(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radOkiAgari"));
            }

            public Zai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Zai"));
            }

            public btnZai(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnZai"));
            }

            public radZai(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radZai"));
            }

            public RyoAshi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("RyoAshi"));
            }

            public btnRyoAshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnRyoAshi"));
            }

            public radRyoAshi(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radRyoAshi"));
            }

            public Buko(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Buko"));
            }

            public btnBuko(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBuko"));
            }

            public radBuko(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radBuko"));
            }

            public TachiAgari(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TachiAgari"));
            }

            public btnTachiAgari(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnTachiAgari"));
            }

            public radTachiAgari(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radTachiAgari"));
            }

            public KataAshi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KataAshi"));
            }

            public btnKataAshi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKataAshi"));
            }

            public radKataAshi(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKataAshi"));
            }

            public Senshin(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Senshin"));
            }

            public btnSenshin(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSenshin"));
            }

            public radSenshin(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radSenshin"));
            }

            public TumeKiri(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TumeKiri"));
            }

            public btnTumeKiri(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnTumeKiri"));
            }

            public radTumeKiri(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radTumeKiri"));
            }

            public Shiryoku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Shiryoku"));
            }

            public btnShiryoku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnShiryoku"));
            }

            public radShiryoku(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShiryoku"));
            }

            public Choryoku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Choryoku"));
            }

            public btnChoryoku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnChoryoku"));
            }

            public radChoryoku(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radChoryoku"));
            }

            public SeikatsuKinou(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SeikatsuKinou"));
            }

            public Ijyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Ijyo"));
            }

            public btnIjyo(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnIjyo"));
            }

            public radIjyo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radIjyo"));
            }

            public Idou(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Idou"));
            }

            public btnIdou(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnIdou"));
            }

            public radIdou(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radIdou"));
            }

            public Enka(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Enka"));
            }

            public btnEnka(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnEnka"));
            }

            public radEnka(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radEnka"));
            }

            public Shokuji(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Shokuji"));
            }

            public btnShokuji(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnShokuji"));
            }

            public radShokuji(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShokuji"));
            }

            public Hainyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Hainyo"));
            }

            public btnHainyo(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHainyo"));
            }

            public radHainyo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHainyo"));
            }

            public Haiben(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Haiben"));
            }

            public btnHaiben(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHaiben"));
            }

            public radHaiben(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHaiben"));
            }

            public Kokou(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Kokou"));
            }

            public btnKokou(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKokou"));
            }

            public radKokou(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKokou"));
            }

            public Sengan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Sengan"));
            }

            public btnSengan(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSengan"));
            }

            public radSengan(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radSengan"));
            }

            public Seihatsu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Seihatsu"));
            }

            public btnSeihatsu(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnSeihatsu"));
            }

            public radSeihatsu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radSeihatsu"));
            }

            public Uwagi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Uwagi"));
            }

            public btnUwagi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnUwagi"));
            }

            public radUwagi(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radUwagi"));
            }

            public Zubon(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Zubon"));
            }

            public btnZubon(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnZubon"));
            }

            public radZubon(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radZubon"));
            }

            public Hindo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Hindo"));
            }

            public btnHindo(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHindo"));
            }

            public radHindo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHindo"));
            }

            public NinchiKinou(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NinchiKinou"));
            }

            public IshiDentatsu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("IshiDentatsu"));
            }

            public btnIshiDentatsu(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnIshiDentatsu"));
            }

            public radIshiDentatsu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radIshiDentatsu"));
            }

            public Nikka(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Nikka"));
            }

            public btnNikka(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnNikka"));
            }

            public radNikka(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radNikka"));
            }

            public Info(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Info"));
            }

            public btnInfo(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnInfo"));
            }

            public radInfo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radInfo"));
            }

            public DankiKioku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("DankiKioku"));
            }

            public btnDankiKioku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnDankiKioku"));
            }

            public radDankiKioku(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radDankiKioku"));
            }

            public NameInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NameInfo"));
            }

            public btnNameInfo(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnNameInfo"));
            }

            public radNameInfo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radNameInfo"));
            }

            public Kisetsu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Kisetsu"));
            }

            public btnKisetsu(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKisetsu"));
            }

            public radKisetsu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKisetsu"));
            }

            public Basho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Basho"));
            }

            public btnBasho(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBasho"));
            }

            public radBasho(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radBasho"));
            }

            public Haikai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Haikai"));
            }

            public btnHaikai(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHaikai"));
            }

            public radHaikai(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHaikai"));
            }

            public Modoru(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Modoru"));
            }

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

            public radModoru(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radModoru"));
            }

            public KoudoShogai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KoudoShogai"));
            }

            public Hiryaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Hiryaku"));
            }

            public btnHiryaku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHiryaku"));
            }

            public radbtnHiryaku(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radbtnHiryaku"));
            }

            public TukuriHanashi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TukuriHanashi"));
            }

            public btnTukuriHanashi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnTukuriHanashi"));
            }

            public radTukuriHanashi(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radTukuriHanashi"));
            }

            public Kanjyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Kanjyo"));
            }

            public btnKanjyo(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKanjyo"));
            }

            public radKanjyo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKanjyo"));
            }

            public Chuyaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Chuyaku"));
            }

            public btnChuyaku(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnChuyaku"));
            }

            public radChuyaku(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radChuyaku"));
            }

            public OnajiHanashi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("OnajiHanashi"));
            }

            public btnOnajiHanashi(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnOnajiHanashi"));
            }

            public radOnajiHanashi(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radOnajiHanashi"));
            }

            public BigVoice(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("BigVoice"));
            }

            public btnBigVoice(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBigVoice"));
            }

            public radBigVoice(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radBigVoice"));
            }

            public Teikou(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Teikou"));
            }

            public btnTeikou(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnTeikou"));
            }

            public radTeikou(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radTeikou"));
            }

            public Ochituki(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Ochituki"));
            }

            public btnOchituki(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnOchituki"));
            }

            public radOchituki(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radOchituki"));
            }

            public OutLonly(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("OutLonly"));
            }

            public btnOutLonly(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnOutLonly"));
            }

            public radOutLonly(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radOutLonly"));
            }

            public Shushu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Shushu"));
            }

            public btnShushu(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnShushu"));
            }

            public radShushu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShushu"));
            }

            public Kowasu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Kowasu"));
            }

            public btnKowasu(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKowasu"));
            }

            public radKowasu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKowasu"));
            }

            public MonoWasure(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("MonoWasure"));
            }

            public btnMonoWasure(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnMonoWasure"));
            }

            public radMonoWasure(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radMonoWasure"));
            }

            public HitoriWarai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("HitoriWarai"));
            }

            public btnHitoriWarai(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnHitoriWarai"));
            }

            public radHitoriWarai(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHitoriWarai"));
            }

            public KateKodo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KateKodo"));
            }

            public btnKateKodo(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKateKodo"));
            }

            public radKateKodo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKateKodo"));
            }

            public MatomeNai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("MatomeNai"));
            }

            public btnMatomeNai(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnMatomeNai"));
            }

            public radMatomeNai(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radMatomeNai"));
            }

            public ShakaiSekatsu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShakaiSekatsu"));
            }

            public Kusuri(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Kusuri"));
            }

            public btnKusuri(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKusuri"));
            }

            public radKusuri(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKusuri"));
            }

            public KingakuKanri(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KingakuKanri"));
            }

            public btnKingakuKanri(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKingakuKanri"));
            }

            public radKingakuKanri(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKingakuKanri"));
            }

            public IshiKetei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("IshiKetei"));
            }

            public btnIshiKetei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnIshiKetei"));
            }

            public radIshiKetei(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radIshiKetei"));
            }

            public Shudan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Shudan"));
            }

            public btnShudan(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnShudan"));
            }

            public radShudan(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShudan"));
            }

            public KaiMono(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KaiMono"));
            }

            public btnKaiMono(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKaiMono"));
            }

            public radKaiMono(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKaiMono"));
            }

            public KantanChori(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KantanChori"));
            }

            public btnKantanChori(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKantanChori"));
            }

            public radKantanChori(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKantanChori"));
            }

            public TokubetsuIryo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TokubetsuIryo"));
            }

            public ShochiNaiyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShochiNaiyo"));
            }

            public btnShochiNaiyo(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnShochiNaiyo"));
            }

            public chkShochiNaiyo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkShochiNaiyo"));
            }

            public TokiTaiou(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TokiTaiou"));
            }

            public btnTokiTaiou(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnTokiTaiou"));
            }

            public chkTokiTaiou(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkTokiTaiou"));
            }

            public Jiritsudo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Jiritsudo"));
            }

            public ShogaiKoreisha(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShogaiKoreisha"));
            }

            public btnShogaiKoreisha(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnShogaiKoreisha"));
            }

            public radShogaiKoreisha(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShogaiKoreisha"));
            }

            public NinchishaJiritsudo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NinchishaJiritsudo"));
            }

            public btnNinchishaJiritsudo(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnNinchishaJiritsudo"));
            }

            public radNinchishaJiritsudo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radNinchishaJiritsudo"));
            }

        }

     }

}

