/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBE {

     export module ShinshinIken {

        export class Events {

            public static changeRadNinchishoShuhenShojoUmu(): string {
                return "changeRadNinchishoShuhenShojoUmu";
            }

            public static changeChkNinchishoShuhenShojoSonota(): string {
                return "changeChkNinchishoShuhenShojoSonota";
            }

            public static changeRadSonotaShojo(): string {
                return "changeRadSonotaShojo";
            }

            public static changeRadSenmonJushin(): string {
                return "changeRadSenmonJushin";
            }

            public static changeChkShishiKesson(): string {
                return "changeChkShishiKesson";
            }

            public static changeChkMahi(): string {
                return "changeChkMahi";
            }

            public static changeChkMigiJoshiMahi(): string {
                return "changeChkMigiJoshiMahi";
            }

            public static changeChkHidariJoshiMahi(): string {
                return "changeChkHidariJoshiMahi";
            }

            public static changeChkMigiKashiMahi(): string {
                return "changeChkMigiKashiMahi";
            }

            public static changeChkHidariKashiMahi(): string {
                return "changeChkHidariKashiMahi";
            }

            public static changeChkSonotaMahi(): string {
                return "changeChkSonotaMahi";
            }

            public static changeChkKinryokuTeika(): string {
                return "changeChkKinryokuTeika";
            }

            public static changeChkKansetsuKoshuku(): string {
                return "changeChkKansetsuKoshuku";
            }

            public static changeChkKansetsuItami(): string {
                return "changeChkKansetsuItami";
            }

            public static changeChkShicchoFuzuii(): string {
                return "changeChkShicchoFuzuii";
            }

            public static changeChkJokuso(): string {
                return "changeChkJokuso";
            }

            public static changeChkSonotaHifuShikkan(): string {
                return "changeChkSonotaHifuShikkan";
            }

            public static onClickBtnKakutei(): string {
                return "onClickBtnKakutei";
            }

            public static onClickBtnCancel(): string {
                return "onClickBtnCancel";
            }

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
                return this._myName + "_" + DBE.ShinshinIken.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.ShinshinIken.Controls.myType() + "_" + fieldName;
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

            public radTankiKioku(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radTankiKioku"));
            }

            public radNichijoNinchiNoryoku(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radNichijoNinchiNoryoku"));
            }

            public radIshiDentatsuNoryoku(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radIshiDentatsuNoryoku"));
            }

            public NinchishoShuhenShojo(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("NinchishoShuhenShojo"));
            }

            public radNinchishoShuhenShojoUmu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radNinchishoShuhenShojoUmu"));
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

            public radSonotaShojo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radSonotaShojo"));
            }

            public txtShojomei(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShojomei"));
            }

            public radSenmonJushin(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radSenmonJushin"));
            }

            public txtShosaiTokkiJiko(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShosaiTokkiJiko"));
            }

            public KaradaJotai(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KaradaJotai"));
            }

            public radKikiude(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKikiude"));
            }

            public txtShincho(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShincho"));
            }

            public radKakoTaijuHenka(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKakoTaijuHenka"));
            }

            public txtTaiju(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTaiju"));
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

            public radMigiJoshiMahiTeido(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radMigiJoshiMahiTeido"));
            }

            public chkHidariJoshiMahi(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkHidariJoshiMahi"));
            }

            public radHidariJoshiMahiTeido(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHidariJoshiMahiTeido"));
            }

            public chkMigiKashiMahi(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkMigiKashiMahi"));
            }

            public radMigiKashiMahiTeido(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radMigiKashiMahiTeido"));
            }

            public chkHidariKashiMahi(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkHidariKashiMahi"));
            }

            public radHidariKashiMahiTeido(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radHidariKashiMahiTeido"));
            }

            public Sp1(): UZA.Space {
                return new UZA.Space(this.convFiledName("Sp1"));
            }

            public chkSonotaMahi(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSonotaMahi"));
            }

            public txtSonotaMahiBui(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSonotaMahiBui"));
            }

            public radSonotaMahiTeido(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radSonotaMahiTeido"));
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

            public radKinryokuTeikaTeido(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKinryokuTeikaTeido"));
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

            public radKansetsuKoshukuTeido(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKansetsuKoshukuTeido"));
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

            public radKansetsuItamiTeido(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKansetsuItamiTeido"));
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

            public radJokusoTeido(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radJokusoTeido"));
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

            public radSonotaHifuShikkanTeido(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radSonotaHifuShikkanTeido"));
            }

            public btnKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

        }

     }

}

