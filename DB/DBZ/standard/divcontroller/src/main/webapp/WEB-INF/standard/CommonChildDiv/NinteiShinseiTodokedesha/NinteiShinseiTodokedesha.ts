/// <reference path='NinteiShinseiTodokedesha_Design.ts' />
module DBZ {
    export module NinteiShinseiTodokedesha {
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

            public ShoriType() {
                return new Modes.ShoriType(this.controls);
            }
            public DisplayType() {
                return new Modes.DisplayType(this.controls);
            }
            public AtenaType() {
                return new Modes.AtenaType(this.controls);
            }

        }

        export module Modes {

            export class ShoriType {

                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public InputMode() {
                    this.controls.ddlTodokledeDaikoKubun().readOnly = false;
                    this.controls.ddlShinseiKankeisha().readOnly = true;
                    this.controls.btnSetaiIchiran().disabled = true;
                    this.controls.btnAtenaKensaku().disabled = true;
                    this.controls.btnZenkaiFukusha().disabled = false;
                    //this.controls.txtJigyoshaCode().readOnly = true;
                    //this.controls.btnJigyoshaGuide().disabled = true;
                    this.controls.txtShimei().readOnly = false;
                    this.controls.txtKanaShimei().readOnly = false;
                    this.controls.txtHonninKankeisei().readOnly = false;
                    this.controls.ccdZenkokuJushoInput().State().入力();
                    this.controls.ccdChoikiInput().State().入力();
                    this.controls.txtYubinNo().readOnly = false;
                    this.controls.txtTelNo().readOnly = false;
                }

                public ShokaiMode() {
                    this.controls.ddlTodokledeDaikoKubun().readOnly = true;
                    this.controls.btnSetaiIchiran().disabled = true;
                    this.controls.btnAtenaKensaku().disabled = true;
                    this.controls.btnZenkaiFukusha().disabled = true;
                    //this.controls.txtJigyoshaCode().readOnly = true;
                    //this.controls.btnJigyoshaGuide().disabled = true;
                    this.controls.txtShimei().readOnly = true;
                    this.controls.txtKanaShimei().readOnly = true;
                    this.controls.txtHonninKankeisei().readOnly = true;
                    this.controls.radKannaiKangai().disabled = true;
                    this.controls.ccdZenkokuJushoInput().State().照会();
                    this.controls.ccdChoikiInput().State().照会();
                    this.controls.txtYubinNo().readOnly = true;
                    this.controls.txtTelNo().readOnly = true;
                }
            }
            
                 export class DisplayType {

                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public 管内() {
                    this.controls.ccdZenkokuJushoInput().DisplayNoneSetMode().使用しない();
                    this.controls.ccdChoikiInput().DisplayNoneSetMode().使用する();
                    this.controls.txtYubinNo().displayNone=false
                }

                public 管外() {

                    this.controls.ccdZenkokuJushoInput().DisplayNoneSetMode().使用する();
                    this.controls.ccdChoikiInput().DisplayNoneSetMode().使用しない();
                    this.controls.txtYubinNo().displayNone=true
                }
            }
            
            export class AtenaType {

                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }
                
                public AtenaMode(): void {
                    this.controls.ddlTodokledeDaikoKubun().readOnly = true;
                    this.controls.btnSetaiIchiran().disabled = true;
                    this.controls.btnAtenaKensaku().disabled = true;
                    this.controls.btnZenkaiFukusha().disabled = true;
                    //this.controls.txtJigyoshaCode().readOnly = true;
                    //this.controls.btnJigyoshaGuide().disabled = true;
                    this.controls.txtShimei().readOnly = true;
                    this.controls.txtKanaShimei().readOnly = true;
                    this.controls.txtHonninKankeisei().readOnly = true;
                    this.controls.radKannaiKangai().disabled = true;
                    this.controls.ccdZenkokuJushoInput().State().照会();
                    this.controls.ccdChoikiInput().State().照会();
                    this.controls.txtYubinNo().readOnly = true;
                    this.controls.txtTelNo().readOnly = true;
                }

                public AtenaNonMode(): void {
                    this.controls.ddlTodokledeDaikoKubun().readOnly = true;
                    this.controls.btnSetaiIchiran().disabled = true;
                    this.controls.btnAtenaKensaku().disabled = true;
                    this.controls.btnZenkaiFukusha().disabled = true;
                    //this.controls.txtJigyoshaCode().readOnly = true;
                    //this.controls.btnJigyoshaGuide().disabled = true;
                    this.controls.txtShimei().readOnly = true;
                    this.controls.txtKanaShimei().readOnly = true;
                    this.controls.txtHonninKankeisei().readOnly = true;
                    this.controls.radKannaiKangai().disabled = true;
                    this.controls.ccdZenkokuJushoInput().State().照会();
                    this.controls.ccdChoikiInput().State().照会();
                    this.controls.txtYubinNo().readOnly = true;
                    this.controls.txtTelNo().readOnly = true;

                }

            }


        }
    }
}

module DBZ
{
    export module NinteiShinseiTodokedesha
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

