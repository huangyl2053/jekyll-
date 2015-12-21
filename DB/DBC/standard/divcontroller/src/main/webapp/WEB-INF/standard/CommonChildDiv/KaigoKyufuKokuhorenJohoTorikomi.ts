/// <reference path='KaigoKyufuKokuhorenJohoTorikomi_Design.ts' />
module DBC
{
    export module KaigoKyufuKokuhorenJohoTorikomi
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
            
            public priorities(): Array {
                return [
                    "表示モード"
                ];
            }

            public 表示モード() {
                return new Modes.表示モード(this.controls);
            }
        }

        export module Modes {
        
        	export class 表示モード {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public Mode1(): void {
                    this.controls.ShoriTaishoJoho().displayNone = true;
                    this.controls.KakuninJikoMsg().displayNone = true;
                    this.controls.ShutsuRyokujun().displayNone = true;
                }
                
                public ModeShutsuryokujunJoken2(): void {
                    this.controls.ShoriTaishoJoho().displayNone = true;
                    this.controls.KakuninJikoMsg().displayNone = true;
                    this.controls.ShutsuRyokujun().displayNone = false;
                }
                
                public ModeKakuninMsgJoken3(): void {
                    this.controls.ShoriTaishoJoho().displayNone = false;
                    this.controls.KakuninJikoMsg().displayNone = false;
                    this.controls.ShutsuRyokujun().displayNone = false;
                }
            }
        }
    }
}

module DBC
{
    export module KaigoKyufuKokuhorenJohoTorikomi
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

