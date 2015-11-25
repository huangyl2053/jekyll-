/// <reference path='Hihosyosai_Design.ts' />
module DBZ
{
    export module Hihosyosai
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
                    "DisplayType"
                ];
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

                public shokai(): void {
                    this.controls.txtSyutokuYMD().readOnly = true;
                    this.controls.txtSyutokutodokedeYMD().readOnly = true;
                    this.controls.ddlSyutokuJiyu().readOnly = true;
                    this.controls.ddlHihokubun().readOnly = true;
                    this.controls.ddlSyozaiHokensya().readOnly = true;
                    this.controls.ddlSotimotoHokensya().readOnly = true;
                    this.controls.ddlKyuHokensya().readOnly = true;
                    this.controls.txtSosichiYMD().readOnly = true;
                    this.controls.txtSosichiTodokedeYMD().readOnly = true;
                    this.controls.ddlSosichiJiyu().readOnly = true;
                    
                    this.controls.tabPnlJyusyoti().visible = true;
                    this.controls.tabPnlShikaku().visible = true;
                }

                public toroku(): void {
                    this.controls.txtSyutokuYMD().readOnly = false;
                    this.controls.txtSyutokutodokedeYMD().readOnly = false;
                    this.controls.ddlSyutokuJiyu().readOnly = false;
                    this.controls.ddlHihokubun().readOnly = false;
                    this.controls.ddlSyozaiHokensya().readOnly = false;
                    this.controls.ddlSotimotoHokensya().readOnly = false;
                    this.controls.ddlKyuHokensya().readOnly = false;
                    this.controls.txtSosichiYMD().readOnly = false;
                    this.controls.txtSosichiTodokedeYMD().readOnly = false;
                    this.controls.ddlSosichiJiyu().readOnly = false;
                    
                    this.controls.tabPnlJyusyoti().visible = true;
                    this.controls.tabPnlShikaku().visible = true;

                }

                public teiseitoroku_jyusyoti(): void {
                    this.controls.txtSyutokuYMD().readOnly = false;
                    this.controls.txtSyutokutodokedeYMD().readOnly = false;
                    this.controls.ddlSyutokuJiyu().readOnly = false;
                    this.controls.ddlHihokubun().readOnly = false;
                    this.controls.ddlSyozaiHokensya().readOnly = false;
                    this.controls.ddlSotimotoHokensya().readOnly = false;
                    this.controls.ddlKyuHokensya().readOnly = false;
                    this.controls.txtSosichiYMD().readOnly = false;
                    this.controls.txtSosichiTodokedeYMD().readOnly = false;
                    this.controls.ddlSosichiJiyu().readOnly = false;
                    
                    this.controls.tabPnlJyusyoti().visible = true;
                    this.controls.tabPnlShikaku().visible = true;
                }
                
                 public teiseitoroku_shikaku(): void {
                    this.controls.txtSyutokuYMD().readOnly = false;
                    this.controls.txtSyutokutodokedeYMD().readOnly = false;
                    this.controls.ddlSyutokuJiyu().readOnly = false;
                    this.controls.ddlHihokubun().readOnly = false;
                    this.controls.ddlSyozaiHokensya().readOnly = false;
                    this.controls.ddlSotimotoHokensya().readOnly = false;
                    this.controls.ddlKyuHokensya().readOnly = false;
                    this.controls.txtSosichiYMD().readOnly = false;
                    this.controls.txtSosichiTodokedeYMD().readOnly = false;
                    this.controls.ddlSosichiJiyu().readOnly = false;
                    
                    this.controls.tabPnlJyusyoti().visible = false;
                    this.controls.tabPnlShikaku().visible = true;
                }

            }
        }
    }
}

module DBZ
{
    export module Hihosyosai
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

