/// <reference path='RirekiShusei_Design.ts' />
module DBZ
{
    export module RirekiShusei
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
            public DisplayType() {
                return new Modes.DisplayType(this.controls);
            }
        }

        export module Modes {
            export class DisplayType {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }
                public tsuika(): void {
                    //�ٓ����R�̂ݓ��͉\
                }
                public sakujo(): void {
                    //�폜���R�̂ݓ��͉\
                }
                public sakujoShusei(): void {
                    //�폜���R�E�����F��J�n-�I���E�󋋎��i�ؖ���1-2�E�\���敪(�\����)-(�@��)�@�����͉�
                }
                public torikeshiTsuika(): void {
                    //ccd�F����́E�폜���R�E�r�����@��������
                }
                public torikeshiShusei(): void {
                    //ccd�F����́E�폜���R�E�r�����E���莾�a�@��������
                }
                public ninteiShusei(): void {
                    //tuikaShusei�E�ٓ����R
                }
            }
        }
    }
}

module DBZ
{
    export module RirekiShusei
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

