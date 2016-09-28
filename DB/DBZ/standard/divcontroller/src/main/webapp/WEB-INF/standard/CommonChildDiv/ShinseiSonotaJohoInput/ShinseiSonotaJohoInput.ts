/// <reference path='ShinseiSonotaJohoInput_Design.ts' />
module DBZ
{
    export module ShinseiSonotaJohoInput
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
                public TokushuTsuikaMode(): void {

                    this.controls.ddlIdoJiyu().readOnly = false;
                    this.controls.ddlSakujoJiyu().disabled = true;
                    this.controls.txtRiyu().readOnly = false;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorisageDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = true;
                    this.controls.txtToshoNinteiKikanTo().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = true;

                }

                public TokushuShuseiMode(): void {

                    this.controls.ddlIdoJiyu().readOnly = false;
                    this.controls.ddlSakujoJiyu().disabled = true;
                    this.controls.txtRiyu().readOnly = false;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorisageDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = false;
                    this.controls.txtToshoNinteiKikanTo().readOnly = false;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = false;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = false;

                } 
                public TokushuSakujyoMode(): void {

                    this.controls.ddlIdoJiyu().readOnly = true;
                    this.controls.ddlSakujoJiyu().disabled = false;
                    this.controls.txtRiyu().readOnly = true;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorisageDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = true;
                    this.controls.txtToshoNinteiKikanTo().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = true;

                } 
                
                public TokushuRirekiShuseiMode(): void {

                    this.controls.ddlIdoJiyu().readOnly = true;
                    this.controls.ddlSakujoJiyu().disabled = true;
                    this.controls.txtRiyu().readOnly = false;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorisageDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = false;
                    this.controls.txtToshoNinteiKikanTo().readOnly = false;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = false;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = false;

                } 
                
                public NinteiMode(): void {

                    this.controls.ddlIdoJiyu().readOnly = true;
                    this.controls.ddlSakujoJiyu().disabled = true;
                    this.controls.txtRiyu().readOnly = false;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorisageDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = true;
                    this.controls.txtToshoNinteiKikanTo().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = true;
                }
                public KyakkaMode(): void {

                    this.controls.ddlIdoJiyu().readOnly = false;
                    this.controls.ddlSakujoJiyu().disabled = true;
                    this.controls.txtRiyu().readOnly = false;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorisageDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = true;
                    this.controls.txtToshoNinteiKikanTo().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = true;
                }

                public ShokkenKisaiMode(): void {

                    this.controls.ddlIdoJiyu().readOnly = true;
                    this.controls.ddlSakujoJiyu().disabled = true;
                    this.controls.txtRiyu().readOnly = false;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorisageDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = true;
                    this.controls.txtToshoNinteiKikanTo().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = true;
                }
                public TorikeshiMode(): void {
                    this.controls.ddlIdoJiyu().readOnly = false;
                    this.controls.ddlSakujoJiyu().disabled = true;
                    this.controls.txtRiyu().readOnly = false;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorisageDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = true;
                    this.controls.txtToshoNinteiKikanTo().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = true;
                }
                public ZenbuSoshitsuMode(): void {
                    this.controls.ddlIdoJiyu().readOnly = false;
                    this.controls.ddlSakujoJiyu().disabled = true;
                    this.controls.txtRiyu().readOnly = false;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorisageDay().readOnly = false;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = true;
                    this.controls.txtToshoNinteiKikanTo().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = true;
                }
                public IchibuSoshitsuMode(): void {
                    this.controls.ddlIdoJiyu().readOnly = false;
                    this.controls.ddlSakujoJiyu().disabled = true;
                    this.controls.txtRiyu().readOnly = false;
                    this.controls.txtSoshitsuDay().readOnly = false;
                    this.controls.txtTorisageDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = true;
                    this.controls.txtToshoNinteiKikanTo().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = true;
                }
                public JukyuShikakushashoMode(): void {
                    this.controls.ddlIdoJiyu().readOnly = true;
                    this.controls.ddlSakujoJiyu().disabled = true;
                    this.controls.txtRiyu().readOnly = true;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorisageDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = true;
                    this.controls.txtToshoNinteiKikanTo().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = false;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = false;
                }

                public ShokaiMode(): void {
                    this.controls.ddlIdoJiyu().readOnly = true;
                    this.controls.ddlSakujoJiyu().disabled = true;
                    this.controls.txtRiyu().readOnly = true;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorisageDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = true;
                    this.controls.txtToshoNinteiKikanTo().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = true;
                }

               public RirekiSakujoShuseiMode(): void {
                    this.controls.ddlIdoJiyu().readOnly = true;
                    this.controls.ddlSakujoJiyu().disabled = false;
                    this.controls.txtRiyu().readOnly = true;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorisageDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = false;
                    this.controls.txtToshoNinteiKikanTo().readOnly = false;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = false;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = false;
                }
                public RirekiTsuikaMode(): void {
                    this.controls.ddlIdoJiyu().readOnly = false;
                    this.controls.ddlSakujoJiyu().disabled = true;
                    this.controls.txtRiyu().readOnly = true;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorisageDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = true;
                    this.controls.txtToshoNinteiKikanTo().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = true;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = true;
                }
               public TorikeshiRirekiTsuikaMode(): void {
                    this.controls.ddlIdoJiyu().readOnly = false;
                    this.controls.ddlSakujoJiyu().disabled = true;
                    this.controls.txtRiyu().readOnly = false;
                    this.controls.txtSoshitsuDay().readOnly = false;
                    this.controls.txtTorisageDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = false;
                    this.controls.txtToshoNinteiKikanTo().readOnly = false;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = false;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = false;
                }
                public RirekiTsuikaKyakkaMode(): void {
                    this.controls.ddlIdoJiyu().readOnly = false;
                    this.controls.ddlSakujoJiyu().disabled = true;
                    this.controls.txtRiyu().readOnly = false;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorisageDay().readOnly = true;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = false;
                    this.controls.txtToshoNinteiKikanTo().readOnly = false;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = false;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = false;
                }
                
                public ShinseiTorikeshiTsuikaMode(): void {
                    this.controls.ddlIdoJiyu().readOnly = false;
                    this.controls.ddlSakujoJiyu().disabled = true;
                    this.controls.txtRiyu().readOnly = false;
                    this.controls.txtSoshitsuDay().readOnly = true;
                    this.controls.txtTorisageDay().readOnly = false;
                    this.controls.txtToshoNinteiKikanFrom().readOnly = false;
                    this.controls.txtToshoNinteiKikanTo().readOnly = false;
                    this.controls.txtJukyuShikakuHakkoDay1().readOnly = false;
                    this.controls.txtJukyuShikakuHakkoDay2().readOnly = false;
                }
            }
        }
    }
}

module DBZ
{
    export module ShinseiSonotaJohoInput
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

