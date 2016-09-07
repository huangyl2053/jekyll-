/// <reference path='ServiceRiyohyoInfo_Design.ts' />
module DBC
{
    export module ServiceRiyohyoInfo
    {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public priorities(): Array<string> {
                return ["GamenMode","KaigoType"];
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }

            public GamenMode() {
                return new Modes.GamenMode(this.controls);
            } 

            public KaigoType() {
                return new Modes.KaigoType(this.controls);
            } 
        }

        export module Modes {
            export class GamenMode {
                private controls: Controls;
                
                constructor(controls: Controls) {
                    this.controls = controls;
                }
                public TsuikaMode(): void {
                    // 前月コピーボタン
                    this.controls.btnZengetsuCopy().displayNone = false;
                    this.controls.btnZengetsuCopy().disabled = false;
                    // 追加ボタン
                    this.controls.btnBeppyoMeisaiNew().displayNone = false;
                    this.controls.btnBeppyoGokeiNew().displayNone = false;
                    this.controls.btnBeppyoMeisaiNew().disabled = false;
                    this.controls.btnBeppyoGokeiNew().disabled = false;
                    // 入力パネル
                    this.controls.ServiceRiyohyoBeppyoFooter().displayNone = false;
                    this.controls.btnUpdate().displayNone = false;
                    this.controls.btnUpdate().disabled = true;
                    this.controls.btnBackRiyoNengetsuIchiran().displayNone = false;
                    this.controls.ServiceRiyohyoBeppyoJigyoshaServiceInput().displayNone = true;
                    this.controls.ServiceRiyohyoBeppyoMeisai().displayNone = true;
                    this.controls.ServiceRiyohyoBeppyoGokei().displayNone = true;
                }
                public ShuseiMode(): void {
                    // 前月コピーボタン
                    this.controls.btnZengetsuCopy().displayNone = false;
                    this.controls.btnZengetsuCopy().disabled = true;
                    // 追加ボタン
                    this.controls.btnBeppyoMeisaiNew().displayNone = false;
                    this.controls.btnBeppyoGokeiNew().displayNone = false;
                    this.controls.btnBeppyoMeisaiNew().disabled = false;
                    this.controls.btnBeppyoGokeiNew().disabled = false;
                    // 入力パネル
                    this.controls.ServiceRiyohyoBeppyoFooter().displayNone = false;
                    this.controls.btnUpdate().displayNone = false;
                    this.controls.btnUpdate().disabled = true;
                    this.controls.btnBackRiyoNengetsuIchiran().displayNone = false;
                    this.controls.ServiceRiyohyoBeppyoJigyoshaServiceInput().displayNone = true;
                    this.controls.ServiceRiyohyoBeppyoMeisai().displayNone = true;
                    this.controls.ServiceRiyohyoBeppyoGokei().displayNone = true;
                }
                public SakujoMode(): void {
                    // 前月コピーボタン
                    this.controls.btnZengetsuCopy().displayNone = false;
                    this.controls.btnZengetsuCopy().disabled = true;
                    // 追加ボタン
                    this.controls.btnBeppyoMeisaiNew().displayNone = false;
                    this.controls.btnBeppyoGokeiNew().displayNone = false;
                    this.controls.btnBeppyoMeisaiNew().disabled = true;
                    this.controls.btnBeppyoGokeiNew().disabled = true;
                    // 入力パネル
                    this.controls.ServiceRiyohyoBeppyoFooter().displayNone = false;
                    this.controls.btnUpdate().displayNone = false;
                    this.controls.btnUpdate().disabled = true;
                    this.controls.btnBackRiyoNengetsuIchiran().displayNone = false;
                    this.controls.ServiceRiyohyoBeppyoJigyoshaServiceInput().displayNone = true;
                    this.controls.ServiceRiyohyoBeppyoMeisai().displayNone = true;
                    this.controls.ServiceRiyohyoBeppyoGokei().displayNone = true;
                }
                public ShokaiMode(): void {
                    // 前月コピーボタン
                    this.controls.btnZengetsuCopy().displayNone = true;
                    // 追加ボタン
                    this.controls.btnBeppyoMeisaiNew().displayNone = true;
                    this.controls.btnBeppyoGokeiNew().displayNone = true;
                    // 入力パネル
                    this.controls.ServiceRiyohyoBeppyoFooter().displayNone = false;
                    this.controls.btnUpdate().displayNone = true;
                    this.controls.btnBackRiyoNengetsuIchiran().displayNone = false;
                    this.controls.ServiceRiyohyoBeppyoJigyoshaServiceInput().displayNone = false;
                    this.controls.ServiceRiyohyoBeppyoJigyoshaServiceInput().disabled = true;
                    this.controls.ServiceRiyohyoBeppyoMeisai().displayNone = false;
                    this.controls.ServiceRiyohyoBeppyoMeisai().disabled = true;
                    this.controls.ServiceRiyohyoBeppyoGokei().displayNone = false;
                    this.controls.ServiceRiyohyoBeppyoGokei().disabled = true;
                }
            }
            
            export class KaigoType {
                private controls: Controls;
                
                constructor(controls: Controls) {
                    this.controls = controls;
                }
                
                public kyotakuService(): void {
                    this.controls.txtRiyoushaFutangaku().displayNone = true;
                    this.controls.txtTeigakuRiyoushaFutangaku().displayNone = true;
                    this.controls.chkZanteiKubun().disabled = false;
                }
                public Sogojigyohi(): void {
                    this.controls.txtRiyoushaFutangaku().displayNone = false;
                    this.controls.txtTeigakuRiyoushaFutangaku().displayNone = false;
                    this.controls.chkZanteiKubun().disabled = true;
                }
            }
        }
    }
}

module DBC
{
    export module ServiceRiyohyoInfo
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

