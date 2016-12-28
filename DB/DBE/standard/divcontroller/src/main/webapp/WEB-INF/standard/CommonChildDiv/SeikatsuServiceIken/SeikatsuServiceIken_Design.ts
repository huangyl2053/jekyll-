/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBE {

     export module SeikatsuServiceIken {

        export class Events {

            public static onChange_radGenzaiEiyoJotai(): string {
                return "onChange_radGenzaiEiyoJotai";
            }

            public static onChange_chkJotaiSonota(): string {
                return "onChange_chkJotaiSonota";
            }

            public static onChange_chkSonotaIryoService(): string {
                return "onChange_chkSonotaIryoService";
            }

            public static onChange_radKetsuatsu(): string {
                return "onChange_radKetsuatsu";
            }

            public static onChange_radIdo(): string {
                return "onChange_radIdo";
            }

            public static onChange_radSesshoku(): string {
                return "onChange_radSesshoku";
            }

            public static onChange_radUndo(): string {
                return "onChange_radUndo";
            }

            public static onChange_radEnka(): string {
                return "onChange_radEnka";
            }

            public static onChange_radKansenshoUmu(): string {
                return "onChange_radKansenshoUmu";
            }

            public static onClick_btnCancel(): string {
                return "onClick_btnCancel";
            }

            public static onClick_btnKakutei(): string {
                return "onClick_btnKakutei";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "SeikatsuServiceIken";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBE.SeikatsuServiceIken.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBE.SeikatsuServiceIken.Controls.myType() + "_" + fieldName;
            }

            public SeikatsuServiceIken(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public Ido(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("Ido"));
            }

            public radOkugaiHokou(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radOkugaiHokou"));
            }

            public radKurumaisuShiyo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKurumaisuShiyo"));
            }

            public chkHokohojoShiyo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkHokohojoShiyo"));
            }

            public EiyoShokuseikatsu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("EiyoShokuseikatsu"));
            }

            public radShokujiKoi(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radShokujiKoi"));
            }

            public radGenzaiEiyoJotai(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radGenzaiEiyoJotai"));
            }

            public txtEiyoShokuseikatsuRyuiten(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtEiyoShokuseikatsuRyuiten"));
            }

            public HasseiJotaiTaishoHoshin(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("HasseiJotaiTaishoHoshin"));
            }

            public Dummy01(): UZA.Space {
                return new UZA.Space(this.convFiledName("Dummy01"));
            }

            public chkJotaiSonota(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkJotaiSonota"));
            }

            public txtSonotaJotaiShosai(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSonotaJotaiShosai"));
            }

            public txtTaishoHoushin(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtTaishoHoushin"));
            }

            public SeikatsuKinoMitoshi(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("SeikatsuKinoMitoshi"));
            }

            public radSeikatsuKinoMitoshi(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radSeikatsuKinoMitoshi"));
            }

            public IgakutekiKanriHitsuyosei(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("IgakutekiKanriHitsuyosei"));
            }

            public chkHasseiShojo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkHasseiShojo"));
            }

            public chkIgakutekiKanri(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkIgakutekiKanri"));
            }

            public chkSonotaIryoService(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSonotaIryoService"));
            }

            public txtShonotaIryoServiceShosai(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShonotaIryoServiceShosai"));
            }

            public chkSonotaIryoServiceHitsuyoSei(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSonotaIryoServiceHitsuyoSei"));
            }

            public IgakutekiKantenRyuiten(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("IgakutekiKantenRyuiten"));
            }

            public radKetsuatsu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKetsuatsu"));
            }

            public txtKetsuatsu(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKetsuatsu"));
            }

            public radIdo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radIdo"));
            }

            public txtIdo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtIdo"));
            }

            public radSesshoku(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radSesshoku"));
            }

            public txtSesshoku(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSesshoku"));
            }

            public radUndo(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radUndo"));
            }

            public txtUndo(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtUndo"));
            }

            public radEnka(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radEnka"));
            }

            public txtEnka(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtEnka"));
            }

            public txtSonotaRyuiJiko(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtSonotaRyuiJiko"));
            }

            public KansenshoUmu(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("KansenshoUmu"));
            }

            public radKansenshoUmu(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radKansenshoUmu"));
            }

            public spSpace1(): UZA.Space {
                return new UZA.Space(this.convFiledName("spSpace1"));
            }

            public txtKansenshoShosai(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtKansenshoShosai"));
            }

            public btnCancel(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnCancel"));
            }

            public btnKakutei(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            }

        }

     }

}

