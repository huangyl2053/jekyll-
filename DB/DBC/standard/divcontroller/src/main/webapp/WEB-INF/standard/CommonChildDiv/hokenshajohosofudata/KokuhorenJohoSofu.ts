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
                    this.controls.lblChushutsuJoken().displayNone = false;		//抽出条件ラベル
                    this.controls.txtShoriSaikuruKubun().displayNone = true;		//処理サイクル区分
                    this.controls.txtShoritaishoNengetsu().displayNone = false;		//処理対象年月
                    this.controls.txtsaishoriKubun().displayNone = false;		//再処理区分
                    this.controls.txtFileName().displayNone = false;			//ファイル名
                    this.controls.ddlSofuTaishojoho().displayNone = true;		//送付対象情報DDL
                    this.controls.ShoriJikkoMaekakuninJiko().displayNone = true;	//処理実行前の確認事項パネル
                    this.controls.lblKakuninJiko1().displayNone = true;			//確認事項1ラベル
                    this.controls.lblKakuninJiko2().displayNone = true;			//確認事項2ラベル
                }
                public mode2(): void {
                    this.controls.lblChushutsuJoken().displayNone = false;		//抽出条件ラベル
                    this.controls.txtShoriSaikuruKubun().displayNone = true;		//処理サイクル区分
                    this.controls.txtShoritaishoNengetsu().displayNone = false;		//処理対象年月
                    this.controls.txtsaishoriKubun().displayNone = false;		//再処理区分
                    this.controls.txtFileName().displayNone = false;			//ファイル名
                    this.controls.ddlSofuTaishojoho().displayNone = false;		//送付対象情報DDL
                    this.controls.ShoriJikkoMaekakuninJiko().displayNone = true;	//処理実行前の確認事項パネル
                    this.controls.lblKakuninJiko1().displayNone = true;			//確認事項1ラベル
                    this.controls.lblKakuninJiko2().displayNone = true;			//確認事項2ラベル
                }
                public mode3(): void {
                    this.controls.lblChushutsuJoken().displayNone = false;		//抽出条件ラベル
                    this.controls.txtShoriSaikuruKubun().displayNone = false;		//処理サイクル区分
                    this.controls.txtShoritaishoNengetsu().displayNone = false;		//処理対象年月
                    this.controls.txtsaishoriKubun().displayNone = false;		//再処理区分
                    this.controls.txtFileName().displayNone = false;			//ファイル名
                    this.controls.ddlSofuTaishojoho().displayNone = true;		//送付対象情報DDL
                    this.controls.ShoriJikkoMaekakuninJiko().displayNone = true;	//処理実行前の確認事項パネル
                    this.controls.lblKakuninJiko1().displayNone = true;			//確認事項1ラベル
                    this.controls.lblKakuninJiko2().displayNone = true;			//確認事項2ラベル
                }
                public mode4(): void {
                    this.controls.lblChushutsuJoken().displayNone = false;		//抽出条件ラベル
                    this.controls.txtShoriSaikuruKubun().displayNone = false;		//処理サイクル区分
                    this.controls.txtShoritaishoNengetsu().displayNone = false;		//処理対象年月
                    this.controls.txtsaishoriKubun().displayNone = false;		//再処理区分
                    this.controls.txtFileName().displayNone = false;			//ファイル名
                    this.controls.ddlSofuTaishojoho().displayNone = true;		//送付対象情報DDL
                    this.controls.ShoriJikkoMaekakuninJiko().displayNone = false;	//処理実行前の確認事項パネル
                    this.controls.lblKakuninJiko1().displayNone = false;		//確認事項1ラベル
                    this.controls.lblKakuninJiko2().displayNone = false;		//確認事項2ラベル
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

