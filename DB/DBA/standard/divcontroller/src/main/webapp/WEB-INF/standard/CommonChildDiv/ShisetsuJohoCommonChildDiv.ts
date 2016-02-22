/// <reference path='ShisetsuJohoCommonChildDiv_Design.ts' />
module DBA
{
    export module ShisetsuJohoCommonChildDiv
    {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public priorities(): Array<string> {
                return [
                    "State"
                ];
            }

            public State() {
                return new Modes.State(this.controls);
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }
        }

        export module Modes {
        	export class State {
	                private controls: Controls;

	                constructor(controls: Controls) {
	                    this.controls = controls;
	                }
	                
	                public 台帳種別表示有りモード(): void {
	                    this.controls.ddlDaichoShubetsu().displayNone = false;
	                    this.controls.radKaigoHokenShisetsu().displayNone = false;
	                    this.controls.radOtherTokureiShisetsu().displayNone = false;
	                    this.controls.radTekiyoJyogaiShisetsu().displayNone = false;
	                }
	                public 台帳種別表示無しモード(): void {
	                    this.controls.ddlDaichoShubetsu().displayNone = true;
	                    this.controls.radKaigoHokenShisetsu().displayNone = false;
	                    this.controls.radOtherTokureiShisetsu().displayNone = false;
	                    this.controls.radTekiyoJyogaiShisetsu().displayNone = false;
	                }
	                public 被保険者モード(): void {
	                    this.controls.ddlDaichoShubetsu().displayNone = true;
	                    this.controls.radKaigoHokenShisetsu().displayNone = false;
	                    this.controls.radOtherTokureiShisetsu().displayNone = false;
	                    this.controls.radTekiyoJyogaiShisetsu().displayNone = true;
	                }
	                public 他市町村住所地特例者モード(): void {
	                    this.controls.ddlDaichoShubetsu().displayNone = true;
	                    this.controls.radKaigoHokenShisetsu().displayNone = false;
	                    this.controls.radOtherTokureiShisetsu().displayNone = false;
	                    this.controls.radTekiyoJyogaiShisetsu().displayNone = true;
	                }
	                public 適用除外者モード(): void {
	                    this.controls.ddlDaichoShubetsu().displayNone = true;
	                    this.controls.radKaigoHokenShisetsu().displayNone = true;
	                    this.controls.radOtherTokureiShisetsu().displayNone = true;
	                    this.controls.radTekiyoJyogaiShisetsu().displayNone = true;
	                }
        	}
        }
    }
}

module DBA
{
    export module ShisetsuJohoCommonChildDiv
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

