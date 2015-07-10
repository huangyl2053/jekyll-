/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module SeikatsuServiceIken {

        export class Events {

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
                return this._myName + "_" + DBZ.SeikatsuServiceIken.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.SeikatsuServiceIken.Controls.myType() + "_" + fieldName;
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

            public chkHasseiShojo(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkHasseiShojo"));
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

            public chkIgakutekiKanriHitsuyosei(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkIgakutekiKanriHitsuyosei"));
            }

            public chkSonotaIryoService(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkSonotaIryoService"));
            }

            public txtShonotaIryoServiceShosai(): UZA.TextBox {
                return new UZA.TextBox(this.convFiledName("txtShonotaIryoServiceShosai"));
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

            public btnModoru(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnModoru"));
            }

            public btnKoshin(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnKoshin"));
            }

        }

     }

}

