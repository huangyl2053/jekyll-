/// <reference path='NinteiInput_Design.ts' />
module DBD
{
    export module NinteiInput
    {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }
            public ShoriType() {
                return new Modes.ShoriType(this.controls);
            }
        }

        export module Modes {

            export class ShoriType {

                private controls: Controls;

                constructor(controls: Controls) {

                    this.controls = controls;
                }

                public TemnyuMode(): void {

                    this.controls.txtNinteiYMD().readOnly = false;
                    this.controls.txtShinsakaiIken().readOnly = false;
                    this.controls.txtYokaigodoCode().readOnly = false;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = false;
                    this.controls.txtYukoShuryoYMD().readOnly = false;

                    this.controls.radNinteiKubun().selectedItem = "0";
                    this.controls.radNinteiKubun().readOnly = true;
                    this.controls.radNinteiKubun().displayNone = false;

                    this.controls.dgServiceIchiran().readOnly = false;

                    this.controls.chkMinashiKoshinNintei().readOnly = true;

                    this.controls.btnYokaigodoGuide().disabled = false;

                    this.controls.btnAfter6Month().disabled = false;
                    this.controls.btnAfter12Month().disabled = false;
                    this.controls.btnAfter18Month().disabled = false;
                    this.controls.btnAfter24Month().disabled = false;

                }

                public InputMode(): void {

                    this.controls.txtNinteiYMD().readOnly = false;
                    this.controls.txtShinsakaiIken().readOnly = false;
                    this.controls.txtYokaigodoCode().readOnly = false;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = false;
                    this.controls.txtYukoShuryoYMD().readOnly = false;

                    this.controls.radNinteiKubun().selectedItem = "0";
                    this.controls.radNinteiKubun().readOnly = true;
                    this.controls.radNinteiKubun().displayNone = false;

                    this.controls.dgServiceIchiran().readOnly = false;

                    this.controls.chkMinashiKoshinNintei().readOnly = true;

                    this.controls.btnYokaigodoGuide().disabled = false;
                    this.controls.btnAfter6Month().disabled = false;
                    this.controls.btnAfter12Month().disabled = false;
                    this.controls.btnAfter18Month().disabled = false;
                    this.controls.btnAfter24Month().disabled = false;

                }
                public TokushuTsuikaMode(): void {

                    this.controls.txtNinteiYMD().readOnly = false;
                    this.controls.txtShinsakaiIken().readOnly = false;
                    this.controls.txtYokaigodoCode().readOnly = false;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = false;
                    this.controls.txtYukoShuryoYMD().readOnly = false;

                    this.controls.radNinteiKubun().selectedItem = "0";
                    this.controls.radNinteiKubun().readOnly = true;
                    this.controls.radNinteiKubun().displayNone = false;

                    this.controls.dgServiceIchiran().readOnly = false;

                    this.controls.chkMinashiKoshinNintei().readOnly = true;

                    this.controls.btnYokaigodoGuide().disabled = false;
                    this.controls.btnAfter6Month().disabled = false;
                    this.controls.btnAfter12Month().disabled = false;
                    this.controls.btnAfter18Month().disabled = false;
                    this.controls.btnAfter24Month().disabled = false;

                }
                public TokushuShuseiMode(): void {

                    this.controls.txtNinteiYMD().readOnly = false;
                    this.controls.txtShinsakaiIken().readOnly = false;
                    this.controls.txtYokaigodoCode().readOnly = false;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = false;
                    this.controls.txtYukoShuryoYMD().readOnly = false;

                    this.controls.radNinteiKubun().selectedItem = "0";
                    this.controls.radNinteiKubun().readOnly = true;
                    this.controls.radNinteiKubun().displayNone = false;

                    this.controls.dgServiceIchiran().readOnly = false;

                    this.controls.chkMinashiKoshinNintei().readOnly = false;

                    this.controls.btnYokaigodoGuide().disabled = false;
                    this.controls.btnAfter6Month().disabled = false;
                    this.controls.btnAfter12Month().disabled = false;
                    this.controls.btnAfter18Month().disabled = false;
                    this.controls.btnAfter24Month().disabled = false;

                }
                public ShokaiMode(): void {

                    this.controls.txtNinteiYMD().readOnly = true;
                    this.controls.txtShinsakaiIken().readOnly = true;
                    this.controls.txtYokaigodoCode().readOnly = true;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = true;
                    this.controls.txtYukoShuryoYMD().readOnly = true;

                    this.controls.radNinteiKubun().selectedItem = "0";
                    this.controls.radNinteiKubun().readOnly = true;
                    this.controls.radNinteiKubun().displayNone = false;

                    this.controls.dgServiceIchiran().readOnly = true;

                    this.controls.chkMinashiKoshinNintei().readOnly = true;

                    this.controls.btnYokaigodoGuide().disabled = true;
                    this.controls.btnAfter6Month().disabled = true;
                    this.controls.btnAfter12Month().disabled = true;
                    this.controls.btnAfter18Month().disabled = true;
                    this.controls.btnAfter24Month().disabled = true;

                }
                public NinteiMode(): void {
                    this.controls.txtNinteiYMD().readOnly = false;
                    this.controls.txtShinsakaiIken().readOnly = false;
                    this.controls.txtYokaigodoCode().readOnly = false;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = false;
                    this.controls.txtYukoShuryoYMD().readOnly = false;

                    this.controls.radNinteiKubun().readOnly = false;
                    this.controls.radNinteiKubun().displayNone = false;


                    this.controls.dgServiceIchiran().readOnly = true;

                    this.controls.chkMinashiKoshinNintei().readOnly = true;

                    this.controls.btnYokaigodoGuide().disabled = false;
                    this.controls.btnAfter6Month().disabled = false;
                    this.controls.btnAfter12Month().disabled = false;
                    this.controls.btnAfter18Month().disabled = false;
                    this.controls.btnAfter24Month().disabled = false;
                }
                public ShokkenTsuikaMode(): void {
                    this.controls.txtNinteiYMD().readOnly = false;
                    this.controls.txtShinsakaiIken().readOnly = false;
                    this.controls.txtYokaigodoCode().readOnly = false;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = false;
                    this.controls.txtYukoShuryoYMD().readOnly = false;

                    this.controls.radNinteiKubun().readOnly = true;
                    this.controls.radNinteiKubun().displayNone = false;


                    this.controls.dgServiceIchiran().readOnly = false;

                    this.controls.chkMinashiKoshinNintei().readOnly = true;

                    this.controls.btnYokaigodoGuide().disabled = false;
                    this.controls.btnAfter6Month().disabled = false;
                    this.controls.btnAfter12Month().disabled = false;
                    this.controls.btnAfter18Month().disabled = false;
                    this.controls.btnAfter24Month().disabled = false;
                }
                public ShokkenShuseiMode(): void {
                    this.controls.txtNinteiYMD().readOnly = false;
                    this.controls.txtShinsakaiIken().readOnly = false;
                    this.controls.txtYokaigodoCode().readOnly = false;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = false;
                    this.controls.txtYukoShuryoYMD().readOnly = false;

                    this.controls.radNinteiKubun().readOnly = true;
                    this.controls.radNinteiKubun().displayNone = true;

                    this.controls.dgServiceIchiran().readOnly = false;

                    this.controls.chkMinashiKoshinNintei().readOnly = true;

                    this.controls.btnYokaigodoGuide().disabled = false;
                    this.controls.btnAfter6Month().disabled = false;
                    this.controls.btnAfter12Month().disabled = false;
                    this.controls.btnAfter18Month().disabled = false;
                    this.controls.btnAfter24Month().disabled = false;
                }
                public IchibuSoshitsuMode(): void {
                    this.controls.txtNinteiYMD().readOnly = false;
                    this.controls.txtShinsakaiIken().readOnly = true;
                    this.controls.txtYokaigodoCode().readOnly = true;
                    this.controls.txtYokaigodoName().readOnly = true;
                    this.controls.txtYukoKaishiYMD().readOnly = false;
                    this.controls.txtYukoShuryoYMD().readOnly = true;

                    this.controls.radNinteiKubun().selectedItem = "0";
                    this.controls.radNinteiKubun().readOnly = true;
                    this.controls.radNinteiKubun().displayNone = true;

                    this.controls.dgServiceIchiran().readOnly = true;

                    this.controls.chkMinashiKoshinNintei().readOnly = true;

                    this.controls.btnYokaigodoGuide().disabled = true;
                    this.controls.btnAfter6Month().disabled = true;
                    this.controls.btnAfter12Month().disabled = true;
                    this.controls.btnAfter18Month().disabled = true;
                    this.controls.btnAfter24Month().disabled = true;
                }
            }
        }
    }
}

module DBD
{
    export module NinteiInput
    {
        export class PublicProperties {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            }
        }
    }
}

