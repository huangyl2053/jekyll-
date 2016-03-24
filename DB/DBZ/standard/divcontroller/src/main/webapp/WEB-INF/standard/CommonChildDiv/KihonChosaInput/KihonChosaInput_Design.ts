/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module KihonChosaInput {

        export class Events {

            public static onClick_btnOpenDialog(): string {
                return "onClick_btnOpenDialog";
            }

            public static onClick_chkMahiChange(): string {
                return "onClick_chkMahiChange";
            }

            public static onClick_chkKoshukuChange(): string {
                return "onClick_chkKoshukuChange";
            }

            public static onClick_btnConfirm(): string {
                return "onClick_btnConfirm";
            }

            public static onClick_btnBack(): string {
                return "onClick_btnBack";
            }

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

            public btnMahi(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnMahi"));
            }

            public chkMahi(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkMahi"));
            }

            public Koshuku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Koshuku"));
            }

            public btnKoshuku(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKoshuku"));
            }

            public chkKoshuku(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKoshuku"));
            }

            public NeKaeri(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NeKaeri"));
            }

            public btnNeKaeri(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnNeKaeri"));
            }

            public radNeKaeri(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radNeKaeri"));
            }

            public OkiAgari(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("OkiAgari"));
            }

            public btnOkiAgari(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnOkiAgari"));
            }

            public radOkiAgari(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radOkiAgari"));
            }

            public Zai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Zai"));
            }

            public btnZai(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnZai"));
            }

            public radZai(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radZai"));
            }

            public RyoAshi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("RyoAshi"));
            }

            public btnRyoAshi(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnRyoAshi"));
            }

            public radRyoAshi(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radRyoAshi"));
            }

            public Buko(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Buko"));
            }

            public btnBuko(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnBuko"));
            }

            public radBuko(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radBuko"));
            }

            public TachiAgari(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TachiAgari"));
            }

            public btnTachiAgari(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnTachiAgari"));
            }

            public radTachiAgari(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radTachiAgari"));
            }

            public KataAshi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KataAshi"));
            }

            public btnKataAshi(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKataAshi"));
            }

            public radKataAshi(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKataAshi"));
            }

            public Senshin(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Senshin"));
            }

            public btnSenshin(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnSenshin"));
            }

            public radSenshin(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radSenshin"));
            }

            public TumeKiri(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TumeKiri"));
            }

            public btnTumeKiri(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnTumeKiri"));
            }

            public radTumeKiri(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radTumeKiri"));
            }

            public Shiryoku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Shiryoku"));
            }

            public btnShiryoku(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShiryoku"));
            }

            public radShiryoku(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShiryoku"));
            }

            public Choryoku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Choryoku"));
            }

            public btnChoryoku(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnChoryoku"));
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

            public btnIjyo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnIjyo"));
            }

            public radIjyo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radIjyo"));
            }

            public Idou(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Idou"));
            }

            public btnIdou(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnIdou"));
            }

            public radIdou(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radIdou"));
            }

            public Enka(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Enka"));
            }

            public btnEnka(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnEnka"));
            }

            public radEnka(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radEnka"));
            }

            public Shokuji(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Shokuji"));
            }

            public btnShokuji(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShokuji"));
            }

            public radShokuji(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShokuji"));
            }

            public Hainyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Hainyo"));
            }

            public btnHainyo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnHainyo"));
            }

            public radHainyo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHainyo"));
            }

            public Haiben(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Haiben"));
            }

            public btnHaiben(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnHaiben"));
            }

            public radHaiben(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHaiben"));
            }

            public Kokou(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Kokou"));
            }

            public btnKokou(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKokou"));
            }

            public radKokou(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKokou"));
            }

            public Sengan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Sengan"));
            }

            public btnSengan(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnSengan"));
            }

            public radSengan(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radSengan"));
            }

            public Seihatsu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Seihatsu"));
            }

            public btnSeihatsu(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnSeihatsu"));
            }

            public radSeihatsu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radSeihatsu"));
            }

            public Uwagi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Uwagi"));
            }

            public btnUwagi(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnUwagi"));
            }

            public radUwagi(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radUwagi"));
            }

            public Zubon(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Zubon"));
            }

            public btnZubon(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnZubon"));
            }

            public radZubon(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radZubon"));
            }

            public Hindo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Hindo"));
            }

            public btnHindo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnHindo"));
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

            public btnIshiDentatsu(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnIshiDentatsu"));
            }

            public radIshiDentatsu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radIshiDentatsu"));
            }

            public Nikka(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Nikka"));
            }

            public btnNikka(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnNikka"));
            }

            public radNikka(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radNikka"));
            }

            public Info(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Info"));
            }

            public btnInfo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnInfo"));
            }

            public radInfo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radInfo"));
            }

            public DankiKioku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("DankiKioku"));
            }

            public btnDankiKioku(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnDankiKioku"));
            }

            public radDankiKioku(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radDankiKioku"));
            }

            public NameInfo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NameInfo"));
            }

            public btnNameInfo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnNameInfo"));
            }

            public radNameInfo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radNameInfo"));
            }

            public Kisetsu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Kisetsu"));
            }

            public btnKisetsu(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKisetsu"));
            }

            public radKisetsu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKisetsu"));
            }

            public Basho(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Basho"));
            }

            public btnBasho(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnBasho"));
            }

            public radBasho(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radBasho"));
            }

            public Haikai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Haikai"));
            }

            public btnHaikai(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnHaikai"));
            }

            public radHaikai(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHaikai"));
            }

            public Modoru(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Modoru"));
            }

            public btnModoru(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnModoru"));
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

            public btnHiryaku(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnHiryaku"));
            }

            public radbtnHiryaku(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radbtnHiryaku"));
            }

            public TukuriHanashi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TukuriHanashi"));
            }

            public btnTukuriHanashi(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnTukuriHanashi"));
            }

            public radTukuriHanashi(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radTukuriHanashi"));
            }

            public Kanjyo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Kanjyo"));
            }

            public btnKanjyo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKanjyo"));
            }

            public radKanjyo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKanjyo"));
            }

            public Chuyaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Chuyaku"));
            }

            public btnChuyaku(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnChuyaku"));
            }

            public radChuyaku(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radChuyaku"));
            }

            public OnajiHanashi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("OnajiHanashi"));
            }

            public btnOnajiHanashi(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnOnajiHanashi"));
            }

            public radOnajiHanashi(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radOnajiHanashi"));
            }

            public BigVoice(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("BigVoice"));
            }

            public btnBigVoice(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnBigVoice"));
            }

            public radBigVoice(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radBigVoice"));
            }

            public Teikou(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Teikou"));
            }

            public btnTeikou(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnTeikou"));
            }

            public radTeikou(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radTeikou"));
            }

            public Ochituki(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Ochituki"));
            }

            public btnOchituki(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnOchituki"));
            }

            public radOchituki(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radOchituki"));
            }

            public OutLonly(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("OutLonly"));
            }

            public btnOutLonly(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnOutLonly"));
            }

            public radOutLonly(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radOutLonly"));
            }

            public Shushu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Shushu"));
            }

            public btnShushu(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShushu"));
            }

            public radShushu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShushu"));
            }

            public Kowasu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Kowasu"));
            }

            public btnKowasu(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKowasu"));
            }

            public radKowasu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKowasu"));
            }

            public MonoWasure(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("MonoWasure"));
            }

            public btnMonoWasure(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnMonoWasure"));
            }

            public radMonoWasure(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radMonoWasure"));
            }

            public HitoriWarai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("HitoriWarai"));
            }

            public btnHitoriWarai(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnHitoriWarai"));
            }

            public radHitoriWarai(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHitoriWarai"));
            }

            public KateKodo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KateKodo"));
            }

            public btnKateKodo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKateKodo"));
            }

            public radKateKodo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKateKodo"));
            }

            public MatomeNai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("MatomeNai"));
            }

            public btnMatomeNai(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnMatomeNai"));
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

            public btnKusuri(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKusuri"));
            }

            public radKusuri(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKusuri"));
            }

            public KingakuKanri(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KingakuKanri"));
            }

            public btnKingakuKanri(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKingakuKanri"));
            }

            public radKingakuKanri(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKingakuKanri"));
            }

            public IshiKetei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("IshiKetei"));
            }

            public btnIshiKetei(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnIshiKetei"));
            }

            public radIshiKetei(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radIshiKetei"));
            }

            public Shudan(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Shudan"));
            }

            public btnShudan(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShudan"));
            }

            public radShudan(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShudan"));
            }

            public KaiMono(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KaiMono"));
            }

            public btnKaiMono(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKaiMono"));
            }

            public radKaiMono(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKaiMono"));
            }

            public KantanChori(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KantanChori"));
            }

            public btnKantanChori(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnKantanChori"));
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

            public btnShochiNaiyo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShochiNaiyo"));
            }

            public chkShochiNaiyo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkShochiNaiyo"));
            }

            public TokiTaiou(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TokiTaiou"));
            }

            public btnTokiTaiou(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnTokiTaiou"));
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

            public btnShogaiKoreisha(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnShogaiKoreisha"));
            }

            public radShogaiKoreisha(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShogaiKoreisha"));
            }

            public NinchishaJiritsudo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NinchishaJiritsudo"));
            }

            public btnNinchishaJiritsudo(): UZA.ButtonDialog {
                return new UZA.ButtonDialog(this.convFiledName("btnNinchishaJiritsudo"));
            }

            public radNinchishaJiritsudo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radNinchishaJiritsudo"));
            }

            public btnConfirm(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnConfirm"));
            }

            public btnBack(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBack"));
            }

        }

     }

}

