/// <reference path='ShujiiIryokikanAndShujiiInput_Design.ts' />
module DBZ {
    export module ShujiiIryokikanAndShujiiInput {
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
                    this.controls.txtIryoKikanCode().readOnly = false;
                    this.controls.txtShujiiCode().readOnly = false;

                    this.controls.chkShiteii().readOnly = false;

                    this.controls.btnZenkaiIrokikanJoho().disabled = false;
                    this.controls.btnClear().disabled = false;

                    this.controls.btnIryokikanGuide().disabled = false;
                    this.controls.btnShujiiGuide().disabled = false;
                    this.controls.btnShujiiRenrakuJiko().disabled = false;

                    this.controls.btnZenkaiIrokikanJoho().displayNone = false;
                    this.controls.btnClear().displayNone = false;
                    this.controls.btnShujiiRenrakuJiko().displayNone = false;

                }
                public NinteiMode(): void {
                    this.controls.txtIryoKikanCode().readOnly = true;
                    this.controls.txtShujiiCode().readOnly = true;

                    this.controls.chkShiteii().readOnly = false;

                    this.controls.btnZenkaiIrokikanJoho().disabled = true;
                    this.controls.btnClear().disabled = true;
                    this.controls.btnShujiiRenrakuJiko().disabled = true;


                    this.controls.btnIryokikanGuide().disabled = true;
                    this.controls.btnShujiiGuide().disabled = true;
                    this.controls.btnShujiiRenrakuJiko().disabled = true;

                    this.controls.btnZenkaiIrokikanJoho().displayNone = false;
                    this.controls.btnClear().displayNone = false;
                    this.controls.btnShujiiRenrakuJiko().displayNone = false;
                 }

                public ShokaiMode(): void {
                    this.controls.txtIryoKikanCode().readOnly = true;
                    this.controls.txtShujiiCode().readOnly = true;
                    this.controls.chkShiteii().readOnly = true;

                    this.controls.btnZenkaiIrokikanJoho().disabled = true;
                    this.controls.btnClear().disabled = true;

                    this.controls.btnIryokikanGuide().disabled = true;
                    this.controls.btnShujiiGuide().disabled = true;
                    this.controls.btnShujiiRenrakuJiko().disabled = true;
                    
                    this.controls.btnZenkaiIrokikanJoho().displayNone = false;
                    this.controls.btnClear().displayNone = false;
                    this.controls.btnShujiiRenrakuJiko().displayNone = false;

                }

                public SimpleInputMode(): void {
                    this.controls.txtIryoKikanCode().readOnly = false;
                    this.controls.txtShujiiCode().readOnly = false;
                    this.controls.chkShiteii().readOnly = false;

                    this.controls.btnIryokikanGuide().disabled = false;
                    this.controls.btnShujiiGuide().disabled = false;
                    this.controls.btnShujiiRenrakuJiko().disabled = false;

                    this.controls.btnZenkaiIrokikanJoho().displayNone = true;
                    this.controls.btnClear().displayNone = true;
                    this.controls.btnShujiiRenrakuJiko().displayNone = true;

                }
                
                public SimpleShokaiMode(): void {
                    this.controls.txtShujiiCode().readOnly = true;
                    this.controls.btnShujiiGuide().disabled = true;

                    this.controls.txtIryoKikanCode().readOnly = true;
                    this.controls.btnIryokikanGuide().disabled = true;

                    this.controls.btnZenkaiIrokikanJoho().disabled = true;
                    this.controls.btnClear().disabled = true;
                    this.controls.btnShujiiRenrakuJiko().disabled = true;

                    this.controls.chkShiteii().readOnly = true;

                    this.controls.btnZenkaiIrokikanJoho().displayNone = true;
                    this.controls.btnClear().displayNone = true;
                    this.controls.btnShujiiRenrakuJiko().displayNone = true;
                    this.controls.btnShujiiGuide().displayNone = true;
                    this.controls.btnIryokikanGuide().displayNone = true;
                }

                public OnlyShujiiGuideInputMode(): void {
                    this.controls.txtIryoKikanCode().readOnly = true;
                    this.controls.txtShujiiCode().readOnly = true;
                    this.controls.chkShiteii().readOnly = false;

                    this.controls.btnIryokikanGuide().disabled = true;
                    this.controls.btnShujiiGuide().disabled = false;
                    this.controls.btnShujiiRenrakuJiko().disabled = false;

                    this.controls.btnZenkaiIrokikanJoho().displayNone = true;
                    this.controls.btnClear().displayNone = true;
                    this.controls.btnShujiiRenrakuJiko().displayNone = true;

                }
                
                public OnlyShujiiGuideInputMode2():void {
                    this.controls.txtIryoKikanCode().readOnly = true;
                    this.controls.txtShujiiCode().readOnly = true;
                    this.controls.chkShiteii().readOnly = false;

                    this.controls.btnIryokikanGuide().displayNone = true;
                    this.controls.btnShujiiGuide().disabled = false;
                    this.controls.btnShujiiRenrakuJiko().disabled = false;

                    this.controls.btnZenkaiIrokikanJoho().displayNone = true;
                    this.controls.btnClear().displayNone = true;
                    this.controls.btnShujiiRenrakuJiko().displayNone = true;
                }
            }
        }
    }
}
module DBZ {
    export module ShujiiIryokikanAndShujiiInput {
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