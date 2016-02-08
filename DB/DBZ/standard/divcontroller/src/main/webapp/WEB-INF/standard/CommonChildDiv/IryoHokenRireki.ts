/// <reference path='IryoHokenRireki_Design.ts' />
module DBZ
{
    export module IryoHokenRireki
    {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }
            
          public priorities(): Array {
                return [
                    "DisplayMode",
                    "MeisaiMode",
                    "WidthMode",
                   
                ];
            }
            
            public DisplayMode() {
                return new Modes.DisplayMode(this.controls);
            }

            public MeisaiMode() {
                return new Modes.MeisaiMode(this.controls);
            }

            public WidthMode() {
                return new Modes.WidthMode(this.controls);
            }
            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public PublicProperties() {
                return new PublicProperties(this.fieldName);
            }
        }

            export module Modes {
        	export class DisplayMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public reference (): void {
                    this.controls.tbdKanyubi().readOnly = true;
                    this.controls.tbdDattabi().readOnly = true;
                    this.controls.ddlSyubetsu().disabled = true;
                    this.controls.txtHokensyaKodo().readOnly = true;
                    this.controls.txtHokensyaMeisho().readOnly = true;
                    this.controls.txtKigoBango().readOnly = true;
                    this.controls.btnIryohokenTsuika().visible = false;
                    this.controls.btnKakutei().visible = false;
                    this.controls.btnCancel().visible = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowSelectButtonColumn = true;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowDeleteButtonColumn = false;
                    
                }
				 public referenceNoSelect(): void {
                    this.controls.tbdKanyubi().readOnly = true;
                    this.controls.tbdDattabi().readOnly = true;
                    this.controls.ddlSyubetsu().disabled = true;
                    this.controls.txtHokensyaKodo().readOnly = true;
                    this.controls.txtHokensyaMeisho().readOnly = true;
                    this.controls.txtKigoBango().readOnly = true;
                    this.controls.btnIryohokenTsuika().visible = false;
                    this.controls.btnKakutei().visible = false;
                    this.controls.btnCancel().visible = false;
					this.controls.dgIryohokenIchiran().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowDeleteButtonColumn = false;
                 
                    
                }
		
                public registration (): void {
                    this.controls.tbdKanyubi().readOnly = true;
                    this.controls.tbdDattabi().readOnly = true;
                    this.controls.ddlSyubetsu().disabled = true;
                    this.controls.txtHokensyaKodo().readOnly = true;
                    this.controls.txtHokensyaMeisho().readOnly = true;
                    this.controls.txtKigoBango().readOnly = true;
                    this.controls.btnKakutei().disabled = true;
                    this.controls.btnCancel().disabled = true;
                    this.controls.btnIryohokenTsuika().visible = true;
                    this.controls.btnKakutei().visible = true;
                    this.controls.btnCancel().visible = true;
                    this.controls.btnIryohokenTsuika().disabled = false;
                    this.controls.btnKakutei().disabled = false;
                    this.controls.btnCancel().disabled = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowModifyButtonColumn = true;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowDeleteButtonColumn = true;
                }
								
            }
				export class MeisaiMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }
                public meisai1 (): void {
                    this.controls.pnlIryohokenJoho().displayNone = true;
                                     
                }
             
				
				
            }
			export class WidthMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

				public Size1(): void {
                    this.controls.dgIryohokenIchiran().width = 700;

                    this.controls.dgIryohokenIchiran()._control.afterPropertiesSet();
                }
				public Size2(): void {
                    this.controls.dgIryohokenIchiran().width = 770;

                    this.controls.dgIryohokenIchiran()._control.afterPropertiesSet();
                }
				public Size3(): void {
                    this.controls.dgIryohokenIchiran().width = 870;

                    this.controls.dgIryohokenIchiran()._control.afterPropertiesSet();
                }
				
            }
		
        }
    }
}

module DBZ
{
    export module IryoHokenRireki
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

