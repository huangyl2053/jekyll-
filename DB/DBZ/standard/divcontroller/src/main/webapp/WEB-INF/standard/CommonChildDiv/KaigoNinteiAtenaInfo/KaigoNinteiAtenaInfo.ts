/// <reference path='KaigoNinteiAtenaInfo_Design.ts' />
module DBZ {
    export module KaigoNinteiAtenaInfo {
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

            public AtenaType() {
                return new Modes.AtenaType(this.controls);
            }
            public ShoriType() {
                return new Modes.ShoriType(this.controls);
            }
        }

        export module Modes {

            export class AtenaType {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }
                public AtenaMode(): void {
                    this.controls.imgJuminShubetsu().displayNone = false;
                    this.controls.txtJuminShubetsu().displayNone = false;
                    this.controls.txtShikiBetsuCode().displayNone = false;
                    this.controls.btnKojinMemo().displayNone = false;
                    this.controls.txtKojinNo().displayNone = false;
                    this.controls.txtGyoseiku().displayNone = false;
                    this.controls.txtSetaiCode().displayNone = false;
                    this.controls.btnSetaiMemo().displayNone = false;
                }
                public AtenaNonMode(): void {
                    this.controls.imgJuminShubetsu().displayNone = true;
                    this.controls.txtJuminShubetsu().displayNone = true;
                    this.controls.txtShikiBetsuCode().displayNone = true;
                    this.controls.btnKojinMemo().displayNone = true;
                    this.controls.txtKojinNo().displayNone = true;
                    this.controls.txtGyoseiku().displayNone = true;
                    this.controls.txtSetaiCode().displayNone = true;
                    this.controls.btnSetaiMemo().displayNone = true;
                }
            }


            export class ShoriType {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }
                public NormalAddMode(): void {
                    this.controls.txtShimei().readOnly = true;
                    this.controls.txtBirthYMD().readOnly = true;
                    this.controls.txtNenrei().readOnly = true;
                    this.controls.txtSeibetsu().readOnly = true;
                    this.controls.txtYubinNo().readOnly = true;
                    this.controls.txtJusho().readOnly = true;
                    this.controls.txtTelNo().readOnly = true;
                }

                public NormalUpdateMode(): void {
                    this.controls.txtShimei().readOnly = true;
                    this.controls.txtBirthYMD().readOnly = true;
                    this.controls.txtNenrei().readOnly = true;
                    this.controls.txtSeibetsu().readOnly = true;
                    this.controls.txtYubinNo().readOnly = true;
                    this.controls.txtJusho().readOnly = true;
                    this.controls.txtTelNo().readOnly = true;
                }

                public SeihoAddMode(): void {
                    this.controls.txtShimei().readOnly = true;
                    this.controls.txtBirthYMD().readOnly = true;
                    this.controls.txtNenrei().readOnly = true;
                    this.controls.txtSeibetsu().readOnly = true;
                    this.controls.txtYubinNo().readOnly = true;
                    this.controls.txtJusho().readOnly = true;
                    this.controls.txtTelNo().readOnly = true;
                }

                public SeihoUpdateMode(): void {
                    this.controls.txtShimei().readOnly = false;
                    this.controls.txtBirthYMD().readOnly = false;
                    this.controls.txtNenrei().readOnly = false;
                    this.controls.txtSeibetsu().readOnly = false;
                    this.controls.txtYubinNo().readOnly = false;
                    this.controls.txtJusho().readOnly = false;
                    this.controls.txtTelNo().readOnly = false;
                }

                public ShokaiMode(): void {
                    this.controls.txtShimei().readOnly = true;
                    this.controls.txtBirthYMD().readOnly = true;
                    this.controls.txtNenrei().readOnly = true;
                    this.controls.txtSeibetsu().readOnly = true;
                    this.controls.txtYubinNo().readOnly = true;
                    this.controls.txtJusho().readOnly = true;
                    this.controls.txtTelNo().readOnly = true;
                }
            }
        }
    }
}
module DBZ {
    export module KaigoNinteiAtenaInfo {
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

