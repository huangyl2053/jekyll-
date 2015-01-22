/// <reference path='ShisetsuJoho_Design.ts' />
module DBZ {
    export module ShisetsuJoho {
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
					"利用機能",
                    "台帳種別",
                    "施設種類",
                    "入力補助",
                    "表示モード"
                ];
            }

			public 利用機能() {
				return new Modes.利用機能(this.controls);
			}

            public 台帳種別() {
                return new Modes.台帳種別(this.controls);
            }

            public 施設種類() {
                return new Modes.施設種類(this.controls);
            }

            public 入力補助() {
                return new Modes.入力補助(this.controls);
            }

            public 表示モード() {
                return new Modes.表示モード(this.controls);
            }

        }

        export module Modes {


			export class 利用機能 {
				private controls: Controls;

				constructor(controls: Controls) {
					this.controls = controls;
				}

				public 台帳種別表示機能(): void {
				}

				public 全施設対象機能(): void {
				}

				public 被保険者対象機能(): void {
				}

				public 他市町村住所地特例者対象機能(): void {
				}

				public 適用除外者対象機能(): void {
				}
			}

            export class 台帳種別 {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 台帳種別表示する(): void {

                    this.controls.ddlDaichoShubetsu().displayNone = false;

                }

                public 台帳種別非表示する(): void {

                    this.controls.ddlDaichoShubetsu().displayNone = true;
                }
            }

            
            export class 施設種類 {
                private controls: Controls;


                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 施設種類を表示する(): void {
                    this.controls.radShisetsuShurui().displayNone = false;                    
                }

                public 施設種類を表示しない(): void {
                    this.controls.radShisetsuShurui().displayNone = true;
                }

           }


            export class 入力補助 {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 事業者を表示する(): void {
                    this.controls.btnJigyoshaInputGuide().displayNone = false;
                    this.controls.btnOtherTokureiShisetsuInputGuide().displayNone = true;
                    this.controls.btnJogaiShisetsuInputGuide().displayNone = true;
                }

                public 他特例施設を表示する(): void {
                    this.controls.btnJigyoshaInputGuide().displayNone = true;
                    this.controls.btnOtherTokureiShisetsuInputGuide().displayNone = false;
                    this.controls.btnJogaiShisetsuInputGuide().displayNone = true;
                }

                public 除外施設を表示する(): void {
                    this.controls.btnJigyoshaInputGuide().displayNone = true;
                    this.controls.btnOtherTokureiShisetsuInputGuide().displayNone = true;
                    this.controls.btnJogaiShisetsuInputGuide().displayNone = false;
                }
            }

            export class 表示モード {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public defaultView(): void {
                    
                    this.controls.ShisetsuJoho().readOnly = false;
                    this.controls.ShisetsuJoho().displayNone = false;
                }

                public readOnly(): void {
                    
                    this.controls.ShisetsuJoho().readOnly = true;
                    this.controls.ShisetsuJoho().displayNone = false;
                }

                public displayNone(): void {
                    
                    this.controls.ShisetsuJoho().readOnly = true;
                    this.controls.ShisetsuJoho().displayNone = true;
                }
            }

        }
    }
}



module DBZ {

    export module ShisetsuJoho {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            }

        }
    }
}

