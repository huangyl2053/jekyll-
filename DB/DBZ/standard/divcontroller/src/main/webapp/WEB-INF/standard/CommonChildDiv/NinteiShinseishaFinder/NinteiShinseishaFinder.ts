/// <reference path='NinteiShinseishaFinder_Design.ts' />
module DBZ {
    export module NinteiShinseishaFinder {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
                this.controls.ShosaiJoken().isOpen = false;
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }
            public DisplayType() {
                return new Modes.DisplayType(this.controls);
            }
            public GyomuType() {
                return new Modes.GyomuType(this.controls);
            }
            public MinashiType() {
                return new Modes.MinashiType(this.controls);
            }
        }

        export module Modes {
            export class DisplayType {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public StandardMode(): void {
                    this.controls.ShosaiJoken().isOpen = false;
                    this.controls.KihonJoho().isOpen = true;
                    this.controls.NinteiChosa().isOpen = false;
                    this.controls.ShujiiJoho().isOpen = false;
                    this.controls.IchijiHantei().isOpen = false;
                    this.controls.KaigoNinteiShinsakaiJoho().isOpen = false;
                    this.controls.ZenkaiJoho().isOpen = false;
                    this.controls.SonotaJoho().isOpen = false;
                    this.controls.KanryoJoho().isOpen = false;
                }
                public PhaseMode(): void {
                    this.controls.ShosaiJoken().isOpen = false;
                    this.controls.KihonJoho().isOpen = true;
                    this.controls.NinteiChosa().isOpen = false;
                    this.controls.ShujiiJoho().isOpen = false;
                    this.controls.IchijiHantei().isOpen = false;
                    this.controls.KaigoNinteiShinsakaiJoho().isOpen = false;
                    this.controls.ZenkaiJoho().isOpen = false;
                    this.controls.SonotaJoho().isOpen = false;
                    this.controls.KanryoJoho().isOpen = true;
                }

                public NinteiChosaMode(): void {
                    this.controls.ShosaiJoken().isOpen = false;
                    this.controls.KihonJoho().isOpen = true;
                    this.controls.NinteiChosa().isOpen = true;
                    this.controls.ShujiiJoho().isOpen = false;
                    this.controls.IchijiHantei().isOpen = false;
                    this.controls.KaigoNinteiShinsakaiJoho().isOpen = false;
                    this.controls.ZenkaiJoho().isOpen = false;
                    this.controls.SonotaJoho().isOpen = false;
                    this.controls.KanryoJoho().isOpen = false;
                }

                public IkenshoMode(): void {
                    this.controls.ShosaiJoken().isOpen = false;
                    this.controls.KihonJoho().isOpen = true;
                    this.controls.NinteiChosa().isOpen = false;
                    this.controls.ShujiiJoho().isOpen = true;
                    this.controls.IchijiHantei().isOpen = false;
                    this.controls.KaigoNinteiShinsakaiJoho().isOpen = false;
                    this.controls.ZenkaiJoho().isOpen = false;
                    this.controls.SonotaJoho().isOpen = false;
                    this.controls.KanryoJoho().isOpen = false;
                }
                public ShinsakaiMode(): void {
                    this.controls.ShosaiJoken().isOpen = false;
                    this.controls.KihonJoho().isOpen = true;
                    this.controls.NinteiChosa().isOpen = false;
                    this.controls.ShujiiJoho().isOpen = false;
                    this.controls.IchijiHantei().isOpen = true;
                    this.controls.KaigoNinteiShinsakaiJoho().isOpen = true;
                    this.controls.ZenkaiJoho().isOpen = false;
                    this.controls.SonotaJoho().isOpen = false;
                    this.controls.KanryoJoho().isOpen = false;
                }

            }

            export class GyomuType {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }
                public Nintei(): void {

                    this.controls.chkShinseiUketsuke().readOnly = false;
                    this.controls.chkChosaIrai().readOnly = false;
                    this.controls.chkIkenshoIrai().readOnly = false;
                    this.controls.chkChosaNyushu().readOnly = false;
                    this.controls.chkIkenshoNyushu().readOnly = false;
                    this.controls.chkIchijiHantei().readOnly = false;
                    this.controls.chkMasking().readOnly = false;
                    this.controls.chkShinsakaiToroku().readOnly = false;
                    this.controls.chkNijiHantei().readOnly = false;
                    this.controls.chkTsuchiShori().readOnly = true;
                    this.controls.chkGetsureiShori().readOnly = false;

                }
                public Jukyu(): void {

                    this.controls.chkShinseiUketsuke().readOnly = true;
                    this.controls.chkChosaIrai().readOnly = true;
                    this.controls.chkIkenshoIrai().readOnly = true;
                    this.controls.chkChosaNyushu().readOnly = true;
                    this.controls.chkIkenshoNyushu().readOnly = true;
                    this.controls.chkIchijiHantei().readOnly = true;
                    this.controls.chkMasking().readOnly = true;
                    this.controls.chkShinsakaiToroku().readOnly = true;
                    this.controls.chkNijiHantei().readOnly = true;
                    this.controls.chkTsuchiShori().readOnly = false;
                    this.controls.chkGetsureiShori().readOnly = true;

                }
            }

            export class MinashiType {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }
                public Minashi(): void {
                    this.controls.chkMinashiFlag().readOnly = true;
                    }
                public NotMinashi(): void {
                    this.controls.chkMinashiFlag().readOnly = false;
                }
            }

        }
    }
}

    module DBZ {
        export module NinteiShinseishaFinder {
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

