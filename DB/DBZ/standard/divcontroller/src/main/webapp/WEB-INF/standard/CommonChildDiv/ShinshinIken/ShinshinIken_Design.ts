/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module ShinshinIken {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ShinshinIken";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ShinshinIken.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ShinshinIken.Controls.myType() + "_" + fieldName;
            }

            public ShinshinIken(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public NichijoJiritsudo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NichijoJiritsudo"));
            }

            public radShogaiKoreishaNichijoSeikatsuJiritsudo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShogaiKoreishaNichijoSeikatsuJiritsudo"));
            }

            public radNinchishoKoreishaJiritsu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radNinchishoKoreishaJiritsu"));
            }

            public NinchishoChukakuShojo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NinchishoChukakuShojo"));
            }

            public TankiKioku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TankiKioku"));
            }

            public radTankiKioku(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radTankiKioku"));
            }

            public NichijoNinchiNoryoku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NichijoNinchiNoryoku"));
            }

            public radNichijoNinchiNoryoku(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radNichijoNinchiNoryoku"));
            }

            public IshiDentatsuNoryoku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("IshiDentatsuNoryoku"));
            }

            public radIshiDentatsuNoryoku(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radIshiDentatsuNoryoku"));
            }

            public ShokujiKoi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("ShokujiKoi"));
            }

            public radShokujiKoi(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShokujiKoi"));
            }

            public NinchishoShuhenShojo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NinchishoShuhenShojo"));
            }

            public chkNinchishoShuhenShojoUmu(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkNinchishoShuhenShojoUmu"));
            }

            public chkNinchishoShuhenShojo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkNinchishoShuhenShojo"));
            }

            public chkNinchishoShuhenShojoSonota(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkNinchishoShuhenShojoSonota"));
            }

            public txtSonotaKinyu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSonotaKinyu"));
            }

            public SonotaShojo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SonotaShojo"));
            }

            public chkSonotaShojo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSonotaShojo"));
            }

            public txtShojomei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShojomei"));
            }

            public chkSenmonJushin(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSenmonJushin"));
            }

            public txtShosaiTokkiJiko(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShosaiTokkiJiko"));
            }

            public KaradaJotai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KaradaJotai"));
            }

            public chkKikiude(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKikiude"));
            }

            public txtShincho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShincho"));
            }

            public txtTaiju(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTaiju"));
            }

            public chkKakoTaijuHenka(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKakoTaijuHenka"));
            }

            public chkShishiKesson(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkShishiKesson"));
            }

            public txtShishiKessonBui(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShishiKessonBui"));
            }

            public linHorizon1(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linHorizon1"));
            }

            public chkMahi(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkMahi"));
            }

            public chkMigiJoshiMahi(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkMigiJoshiMahi"));
            }

            public chkMigiJoshiMahiTeido(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkMigiJoshiMahiTeido"));
            }

            public chkHidariJoshiMahi(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkHidariJoshiMahi"));
            }

            public chkHidariJoshiMahiTeido(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkHidariJoshiMahiTeido"));
            }

            public chkMigiKashiMahi(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkMigiKashiMahi"));
            }

            public chkMigiKashiMahiTeido(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkMigiKashiMahiTeido"));
            }

            public chkHidariKashiMahi(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkHidariKashiMahi"));
            }

            public chkHidariKashiMahiTeido(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkHidariKashiMahiTeido"));
            }

            public chkSonotaMahi(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSonotaMahi"));
            }

            public txtSonotaMahiBui(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSonotaMahiBui"));
            }

            public SonotaMahiTeido(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("SonotaMahiTeido"));
            }

            public linHorizon2(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linHorizon2"));
            }

            public chkKinryokuTeika(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKinryokuTeika"));
            }

            public txtKinryokuTeikaBui(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKinryokuTeikaBui"));
            }

            public chkKinryokuTeikaTeido(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKinryokuTeikaTeido"));
            }

            public linHorizon3(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linHorizon3"));
            }

            public chkKansetsuKoshuku(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKansetsuKoshuku"));
            }

            public txtKansetsuKoshukuBui(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKansetsuKoshukuBui"));
            }

            public chkKansetsuKoshukuTeido(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKansetsuKoshukuTeido"));
            }

            public linHorizon4(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linHorizon4"));
            }

            public chkKansetsuItami(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKansetsuItami"));
            }

            public txtKansetsuItamiBui(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKansetsuItamiBui"));
            }

            public chkKansetsuItamiTeido(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkKansetsuItamiTeido"));
            }

            public linHorizon5(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linHorizon5"));
            }

            public chkShicchoFuzuii(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkShicchoFuzuii"));
            }

            public chkFuzuiiJoshi(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkFuzuiiJoshi"));
            }

            public chkFuzuiiKashi(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkFuzuiiKashi"));
            }

            public chkTaikan(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkTaikan"));
            }

            public linHorizon6(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linHorizon6"));
            }

            public chkJokuso(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkJokuso"));
            }

            public txtJokusoBui(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtJokusoBui"));
            }

            public chkJokusoTeido(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkJokusoTeido"));
            }

            public linHorizon7(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("linHorizon7"));
            }

            public chkSonotaHifuShikkan(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSonotaHifuShikkan"));
            }

            public txtSonotaHifuShikkanBui(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSonotaHifuShikkanBui"));
            }

            public chkSonotaHifuShikkanTeido(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSonotaHifuShikkanTeido"));
            }

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

            public btnKoshin(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKoshin"));
            }

        }

     }

}

