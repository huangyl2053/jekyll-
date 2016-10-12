/// <reference path='ShisetsuJohoCommonChildDiv_Design.ts' />
module DBZ
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

				public DaichoShubetsuAriMode(): void {
					this.controls.ddlDaichoShubetsu().displayNone = false;
					this.controls.radKaigoHokenShisetsu().displayNone = false;
					this.controls.radOtherTokureiShisetsu().displayNone = false;
					this.controls.radTekiyoJyogaiShisetsu().displayNone = false;

				}
				public DaichoShubetsuNashiMode(): void {
					this.controls.ddlDaichoShubetsu().displayNone = true;
					this.controls.radKaigoHokenShisetsu().labelLText = " ";
					this.controls.radKaigoHokenShisetsu().displayNone = false;
					this.controls.radOtherTokureiShisetsu().displayNone = false;
					this.controls.radTekiyoJyogaiShisetsu().displayNone = false;
	
				}
				public KaigoHokenMode(): void {
					this.controls.ddlDaichoShubetsu().displayNone = true;
					this.controls.radKaigoHokenShisetsu().labelLText = " ";
					this.controls.radKaigoHokenShisetsu().displayNone = false;
					this.controls.radOtherTokureiShisetsu().displayNone = false;
					this.controls.radTekiyoJyogaiShisetsu().displayNone = true;

				}
				public OtherTokureiMode(): void {
					this.controls.ddlDaichoShubetsu().displayNone = true;
					this.controls.radKaigoHokenShisetsu().labelLText = " ";
					this.controls.radKaigoHokenShisetsu().displayNone = false;
					this.controls.radOtherTokureiShisetsu().displayNone = false;
					this.controls.radTekiyoJyogaiShisetsu().displayNone = true;

				}
				public TekiyoJogaiMode(): void {
					this.controls.ddlDaichoShubetsu().displayNone = true;
					this.controls.radKaigoHokenShisetsu().displayNone = true;
					this.controls.radOtherTokureiShisetsu().displayNone = true;
					this.controls.radTekiyoJyogaiShisetsu().displayNone = true;

				}
				public JigyoshaInputGuideMode(): void {
					this.controls.ddlDaichoShubetsu().displayNone = true;
					this.controls.radKaigoHokenShisetsu().displayNone = true;
					this.controls.radOtherTokureiShisetsu().displayNone = true;
					this.controls.radTekiyoJyogaiShisetsu().displayNone = true;
				}
			}
        }
    }
}

module DBZ
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
				editTypes.addEditType("ShisetsuJohoCommonChildDiv_width", UZA.EditTypeEnumForPublicProperty.StringType);
				editTypes.addEditType("NyuryokuShisetsuKodo_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
				editTypes.addEditType("NyuryokuShisetsuKodo_labelLWidth", UZA.EditTypeEnumForPublicProperty.StringType);
				editTypes.addEditType("NyuryokuShisetsuKodo_required", UZA.EditTypeEnumForPublicProperty.BooleanType);
				editTypes.addEditType("NyuryokuShisetsuMeisho_width", UZA.EditTypeEnumForPublicProperty.StringType);
				editTypes.addEditType("NyuryokuShisetsuMeisho_wrap", UZA.EditTypeEnumForPublicProperty.BooleanType);
				editTypes.addEditType("NyuryokuShisetsuMeisho_marginLeft", UZA.EditTypeEnumForPublicProperty.StringType);				
                return editTypes;
            }

			 public getNyuryokuShisetsuKodo_labelLText = function () {
                return this.controls.txtNyuryokuShisetsuKodo().labelLText;
            }

            public  setNyuryokuShisetsuKodo_labelLText = function (value) {
                this.controls.txtNyuryokuShisetsuKodo().labelLText = value;
            }

			 public getNyuryokuShisetsuKodo_required = function () {
                return this.controls.txtNyuryokuShisetsuKodo().required;
            }

            public  setNyuryokuShisetsuKodo_required = function (value) {
                this.controls.txtNyuryokuShisetsuKodo().required = value;
            }

			 public getNyuryokuShisetsuKodo_labelLWidth = function () {
                return this.controls.txtNyuryokuShisetsuKodo().labelLWidth;
            }

            public  setNyuryokuShisetsuKodo_labelLWidth = function (value) {
                this.controls.txtNyuryokuShisetsuKodo().labelLWidth = value;
            }

			/** 入所施設名称 width */
			public getNyuryokuShisetsuMeisho_width = function() {
				return this.controls.txtNyuryokuShisetsuMeisho().width;
			}

			/** 入所施設名称 width */
			public setNyuryokuShisetsuMeisho_width = function(value) {
				this.controls.txtNyuryokuShisetsuMeisho().width = value;
			}

			/** 入所施設名称 marginLeft */
			public getNyuryokuShisetsuMeisho_marginLeft = function() {
				return this.controls.txtNyuryokuShisetsuMeisho().marginLeft;
			}

			/** 入所施設名称 marginLeft */
			public setNyuryokuShisetsuMeisho_marginLeft = function(value) {
				this.controls.txtNyuryokuShisetsuMeisho().marginLeft = value;
			}
			
			/** 入所施設名称 wrap */
			public getNyuryokuShisetsuMeisho_wrap = function() {
				return this.controls.txtNyuryokuShisetsuMeisho().wrap;
			}

			/** 入所施設名称 wrap */
			public setNyuryokuShisetsuMeisho_wrap = function(value) {
				this.controls.txtNyuryokuShisetsuMeisho().wrap = value;
			}
			
			/** パネル width */
			public getShisetsuJohoCommonChildDiv_width = function(){
				return this.controls.ShisetsuJohoCommonChildDiv().width;
			}

			/** パネル width */
			public setShisetsuJohoCommonChildDiv_width = function(value){
				this.controls.ShisetsuJohoCommonChildDiv().width = value;
			}

        }
    }
}

