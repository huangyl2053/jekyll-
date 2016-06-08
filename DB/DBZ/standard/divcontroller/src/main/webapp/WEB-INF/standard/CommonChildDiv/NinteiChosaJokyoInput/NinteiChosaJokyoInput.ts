/// <reference path='NinteiChosaJokyoInput_Design.ts' />
module DBZ
{
    export module NinteiChosaJokyoInput
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

                public InputMode(): void {
                    this.controls.txtNinteiChosainCode().readOnly = false;
                    this.controls.txtNinteiChosaItakusakiCode().readOnly = false;
                    this.controls.txtNinteiChosaIraiDay().readOnly = false;
                    this.controls.txtNinteiChosaJisshiYoteiDay().readOnly = false;
                    this.controls.txtNinteiChosaJisshiDay().readOnly = false;
                    this.controls.ddlNinteiChosaItakusakiKubun().readOnly = false;

                    this.controls.btnChosainGuide().disabled = false;
                    this.controls.btnItakusakiGuide().disabled = false;

                    this.controls.txtShujiiCode().readOnly = false;
                    this.controls.txtShujiiIryoKikanCode().readOnly = false;
                    this.controls.txtShujiiIryoKikanIraiDay().readOnly = false;
                    this.controls.txtShujiiIryoKikanNyushuYoteiDay().readOnly = false;
                    this.controls.txtShujiiIryoKikanNyushuDay().readOnly = false;
                    this.controls.chkShujiiKubun().readOnly = false;

                    this.controls.btnShujiiGuide().disabled = false;
                    this.controls.btnIryoKikanGuide().disabled = false;

                    this.controls.HomonChosasaki().readOnly = false;
                    this.controls.IchijiHantei().readOnly = false;
                    this.controls.KaigoNinteiShinsakai().readOnly = false;
                    this.controls.EnkiTsuchi().readOnly = false;

                }

                public ShokaiMode(): void {
                    this.controls.txtNinteiChosainCode().readOnly = true;
                    this.controls.txtNinteiChosaItakusakiCode().readOnly = true;
                    this.controls.txtNinteiChosaIraiDay().readOnly = true;
                    this.controls.txtNinteiChosaJisshiYoteiDay().readOnly = true;
                    this.controls.txtNinteiChosaJisshiDay().readOnly = true;
                    this.controls.ddlNinteiChosaItakusakiKubun().readOnly = true;

                    this.controls.btnChosainGuide().disabled = true;
                    this.controls.btnItakusakiGuide().disabled = true;

                    this.controls.txtShujiiCode().readOnly = true;
                    this.controls.txtShujiiIryoKikanCode().readOnly = true;
                    this.controls.txtShujiiIryoKikanIraiDay().readOnly = true;
                    this.controls.txtShujiiIryoKikanNyushuYoteiDay().readOnly = true;
                    this.controls.txtShujiiIryoKikanNyushuDay().readOnly = true;
                    this.controls.chkShujiiKubun().readOnly = true;
                    
                    this.controls.btnShujiiGuide().disabled = true;
                    this.controls.btnIryoKikanGuide().disabled = true;
                    
                    this.controls.HomonChosasaki().readOnly = true;
                    this.controls.IchijiHantei().readOnly = true;
                    this.controls.KaigoNinteiShinsakai().readOnly = true;
                    this.controls.EnkiTsuchi().readOnly = true;
                }



            }



        }
    }
}

module DBZ
{
    export module NinteiChosaJokyoInput
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

