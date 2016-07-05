/// <reference path='KokuhorenJohoSofu_Design.ts' />
module DBC
{
    export module KokuhorenJohoSofu
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
            
            public priorities(): Array < string > {
                return [
                    "DisplayMode"
                ];
            }
            
            public DisplayMode() {
                return new Modes.DisplayMode(this.controls);
            }
        }

        export module Modes {
            export class DisplayMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }
                
                public mode1(): void {
                    this.controls.lblChushutsuJoken().displayNone = false;		//���o�������x��
                    this.controls.txtShoriSaikuruKubun().displayNone = true;		//�����T�C�N���敪
                    this.controls.txtShoritaishoNengetsu().displayNone = false;		//�����Ώ۔N��
                    this.controls.txtsaishoriKubun().displayNone = false;		//�ď����敪
                    this.controls.txtFileName().displayNone = false;			//�t�@�C����
                    this.controls.ddlSofuTaishojoho().displayNone = true;		//���t�Ώۏ��DDL
                    this.controls.ShoriJikkoMaekakuninJiko().displayNone = true;	//�������s�O�̊m�F�����p�l��
                    this.controls.lblKakuninJiko1().displayNone = true;			//�m�F����1���x��
                    this.controls.lblKakuninJiko2().displayNone = true;			//�m�F����2���x��
                }
                public mode2(): void {
                    this.controls.lblChushutsuJoken().displayNone = false;		//���o�������x��
                    this.controls.txtShoriSaikuruKubun().displayNone = true;		//�����T�C�N���敪
                    this.controls.txtShoritaishoNengetsu().displayNone = false;		//�����Ώ۔N��
                    this.controls.txtsaishoriKubun().displayNone = false;		//�ď����敪
                    this.controls.txtFileName().displayNone = false;			//�t�@�C����
                    this.controls.ddlSofuTaishojoho().displayNone = false;		//���t�Ώۏ��DDL
                    this.controls.ShoriJikkoMaekakuninJiko().displayNone = true;	//�������s�O�̊m�F�����p�l��
                    this.controls.lblKakuninJiko1().displayNone = true;			//�m�F����1���x��
                    this.controls.lblKakuninJiko2().displayNone = true;			//�m�F����2���x��
                }
                public mode3(): void {
                    this.controls.lblChushutsuJoken().displayNone = false;		//���o�������x��
                    this.controls.txtShoriSaikuruKubun().displayNone = false;		//�����T�C�N���敪
                    this.controls.txtShoritaishoNengetsu().displayNone = false;		//�����Ώ۔N��
                    this.controls.txtsaishoriKubun().displayNone = false;		//�ď����敪
                    this.controls.txtFileName().displayNone = false;			//�t�@�C����
                    this.controls.ddlSofuTaishojoho().displayNone = true;		//���t�Ώۏ��DDL
                    this.controls.ShoriJikkoMaekakuninJiko().displayNone = true;	//�������s�O�̊m�F�����p�l��
                    this.controls.lblKakuninJiko1().displayNone = true;			//�m�F����1���x��
                    this.controls.lblKakuninJiko2().displayNone = true;			//�m�F����2���x��
                }
                public mode4(): void {
                    this.controls.lblChushutsuJoken().displayNone = false;		//���o�������x��
                    this.controls.txtShoriSaikuruKubun().displayNone = false;		//�����T�C�N���敪
                    this.controls.txtShoritaishoNengetsu().displayNone = false;		//�����Ώ۔N��
                    this.controls.txtsaishoriKubun().displayNone = false;		//�ď����敪
                    this.controls.txtFileName().displayNone = false;			//�t�@�C����
                    this.controls.ddlSofuTaishojoho().displayNone = true;		//���t�Ώۏ��DDL
                    this.controls.ShoriJikkoMaekakuninJiko().displayNone = false;	//�������s�O�̊m�F�����p�l��
                    this.controls.lblKakuninJiko1().displayNone = false;		//�m�F����1���x��
                    this.controls.lblKakuninJiko2().displayNone = false;		//�m�F����2���x��
                }
                
            }
        }
    }
}

module DBC
{
    export module KokuhorenJohoSofu
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

