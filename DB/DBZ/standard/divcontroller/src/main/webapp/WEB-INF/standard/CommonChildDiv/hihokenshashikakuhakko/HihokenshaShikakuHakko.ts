/// <reference path="HihokenshaShikakuHakko_Design.ts" />

// 共有子Divモード記述TypeScriptソースです。

module DBZ
{
    export module HihokenshaShikakuHakko {

        export class ModeController{
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public priorities(): Array<string> {
				return [
				"発行証タイプ"];
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

			public 発行証タイプ() {
				return new Modes.発行証タイプ(this.controls);
			}

            public PublicProperties() {
                return new DBZ.HihokenshaShikakuHakko.PublicProperties(this.fieldName);
			}
		}


		export module Modes {
			export class 発行証タイプ {
				private controls: Controls;
				
				constructor(controls: Controls) {
					this.controls = controls;
				}
				
				public 被保険者証(): void {
					this.controls.txtYukoKigen().displayNone = true;
					this.controls.txtShinsakaiIken().maxLength = 198;
					this.controls.txtShinsakaiIken().limitLength = 198;
				}
				
				public 資格者証(): void {
					this.controls.txtYukoKigen().displayNone = false;
					this.controls.txtShinsakaiIken().maxLength = 175;
					this.controls.txtShinsakaiIken().limitLength = 175;
				}
				
			}
		}

    }
}



module DBZ {

    export module HihokenshaShikakuHakko {

        export class PublicProperties {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtYukoKigen_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("onBlur_txtKofuDate", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onChange_ddlKofuJiyu", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            }

            public gettxtYukoKigen_displayNone() {
                return this.controls.txtYukoKigen().displayNone;
            }

            public settxtYukoKigen_displayNone(value) {
                this.controls.txtYukoKigen().displayNone = value;
            }

            public getonBlur_txtKofuDate() {
                return this.controls.txtKofuDate().onBlur;
            }

            public setonBlur_txtKofuDate(value) {
                this.controls.txtKofuDate().onBlur = value;
            }

            public getonChange_ddlKofuJiyu() {
                return this.controls.ddlKofuJiyu().onChange;
            }

            public setonChange_ddlKofuJiyu(value) {
                this.controls.ddlKofuJiyu().onChange = value;
            }

        }
    }
}




