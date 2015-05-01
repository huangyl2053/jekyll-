/// <reference path='KaigoNinteiShinseiKihonJohoInput_Design.ts' />
module DBZ
{
    export module KaigoNinteiShinseiKihonJohoInput
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

            public InputType() {
                return new Modes.InputType(this.controls);
            }
        }

        export module Modes {
            export class InputType{
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public AllInputMode(): void {
                    this.controls.radShinseishoKubun().readOnly = false;
                    this.controls.txtShinseiYMD().readOnly = false;
                    this.controls.ddlShinseiShubetsu().readOnly = false;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = false;
                    this.controls.ddlShinseiKubunHorei().readOnly = false;
                    this.controls.chkKyuSochisha().readOnly = false;
                    this.controls.ddlHihokenshaKubun().readOnly = false;
                    this.controls.chkShikakuShutokuMae().readOnly = false;
                    this.controls.ddlTokuteiShippei().readOnly = false;

                    this.controls.ServiceSakujo().displayNone = false;
                    this.controls.ServiceSakujo().readOnly = false;
                    this.controls.NinteiShinseiRiyu().readOnly = false;                
                }

                public ServiceInputMode(): void {
                    this.controls.radShinseishoKubun().readOnly = false;
                    this.controls.txtShinseiYMD().readOnly = false;
                    this.controls.ddlShinseiShubetsu().readOnly = true;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = false;
                    this.controls.ddlShinseiKubunHorei().readOnly = false;
                    this.controls.chkKyuSochisha().readOnly = false;
                    this.controls.ddlHihokenshaKubun().readOnly = false;
                    this.controls.chkShikakuShutokuMae().readOnly = false;
                    this.controls.ddlTokuteiShippei().readOnly = false;

                    this.controls.ServiceSakujo().displayNone = false;
                    this.controls.ServiceSakujo().readOnly = false;
                    this.controls.NinteiShinseiRiyu().readOnly = false;     

                }
                
                public ServiceShokaiMode(): void {
                    this.controls.radShinseishoKubun().readOnly = true;
                    this.controls.txtShinseiYMD().readOnly = true;
                    this.controls.ddlShinseiShubetsu().readOnly = true;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = true;
                    this.controls.ddlShinseiKubunHorei().readOnly = true;
                    this.controls.chkKyuSochisha().readOnly = true;
                    this.controls.ddlHihokenshaKubun().readOnly = true;
                    this.controls.chkShikakuShutokuMae().readOnly = true;
                    this.controls.ddlTokuteiShippei().readOnly = true;

                    this.controls.ServiceSakujo().readOnly = true;
                    this.controls.NinteiShinseiRiyu().readOnly = true;

                }
                
                public ServiceNomalInputMode(): void {
                    this.controls.radShinseishoKubun().readOnly = false;
                    this.controls.txtShinseiYMD().readOnly = false;
                    this.controls.ddlShinseiShubetsu().readOnly = true;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = false;
                    this.controls.ddlShinseiKubunHorei().readOnly = false;
                    this.controls.chkKyuSochisha().readOnly = false;
                    this.controls.ddlHihokenshaKubun().readOnly = false;
                    this.controls.chkShikakuShutokuMae().readOnly = false;
                    this.controls.ddlTokuteiShippei().readOnly = false;

                    this.controls.ServiceSakujo().displayNone = true;
                    this.controls.NinteiShinseiRiyu().readOnly = false;

                }
                public TokuteiShippeiMode(): void {
                    this.controls.radShinseishoKubun().readOnly = true;
                    this.controls.txtShinseiYMD().readOnly = false;
                    this.controls.ddlShinseiShubetsu().readOnly = true;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = true;
                    this.controls.ddlShinseiKubunHorei().readOnly = true;
                    this.controls.chkKyuSochisha().readOnly = false;
                    this.controls.ddlHihokenshaKubun().readOnly = false;
                    this.controls.chkShikakuShutokuMae().readOnly = true;
                    this.controls.ddlTokuteiShippei().readOnly = false;

                    this.controls.ServiceSakujo().displayNone = true;
                    this.controls.NinteiShinseiRiyu().readOnly = true;
                }

                public TokuteiShippeiNashiMode(): void {
                    this.controls.radShinseishoKubun().readOnly = false;
                    this.controls.txtShinseiYMD().readOnly = false;
                    this.controls.ddlShinseiShubetsu().readOnly = false;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = false;
                    this.controls.ddlShinseiKubunHorei().readOnly = false;
                    this.controls.chkKyuSochisha().readOnly = false;
                    this.controls.ddlHihokenshaKubun().readOnly = false;
                    this.controls.chkShikakuShutokuMae().readOnly = false;
                    this.controls.ddlTokuteiShippei().readOnly = true;

                    this.controls.ServiceSakujo().displayNone = true;
                    this.controls.NinteiShinseiRiyu().readOnly = false;
                }
                public JizenShinseiNashiMode(): void {
                    this.controls.radShinseishoKubun().readOnly = false;
                    this.controls.txtShinseiYMD().readOnly = false;
                    this.controls.ddlShinseiShubetsu().readOnly = true;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = true;
                    this.controls.ddlShinseiKubunHorei().readOnly = true;
                    this.controls.chkKyuSochisha().readOnly = false;
                    this.controls.ddlHihokenshaKubun().readOnly = false;
                    this.controls.chkShikakuShutokuMae().readOnly = true;
                    this.controls.ddlTokuteiShippei().readOnly = false;

                    this.controls.ServiceSakujo().displayNone = true;
                    this.controls.NinteiShinseiRiyu().readOnly = true;
                }
                public ShinseibiMode(): void {
                    this.controls.radShinseishoKubun().readOnly = true;
                    this.controls.txtShinseiYMD().readOnly = false;
                    this.controls.ddlShinseiShubetsu().readOnly = true;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = true;
                    this.controls.ddlShinseiKubunHorei().readOnly = true;
                    this.controls.chkKyuSochisha().readOnly = true;
                    this.controls.ddlHihokenshaKubun().readOnly = true;
                    this.controls.chkShikakuShutokuMae().readOnly = true;
                    this.controls.ddlTokuteiShippei().readOnly = true;

                    this.controls.ServiceSakujo().displayNone = true;
                    this.controls.NinteiShinseiRiyu().readOnly = true;
                }
                public NinteiMode(): void {
                    this.controls.radShinseishoKubun().readOnly = true;
                    this.controls.txtShinseiYMD().readOnly = true;
                    this.controls.ddlShinseiShubetsu().readOnly = true;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = true;
                    this.controls.ddlShinseiKubunHorei().readOnly = true;
                    this.controls.chkKyuSochisha().readOnly = false;
                    this.controls.ddlHihokenshaKubun().readOnly = true;
                    this.controls.chkShikakuShutokuMae().readOnly = true;
                    this.controls.ddlTokuteiShippei().readOnly = true;

                    this.controls.ServiceSakujo().displayNone = true;
                    this.controls.NinteiShinseiRiyu().readOnly = true;
                }
                public ShokaiMode(): void {
                    this.controls.radShinseishoKubun().readOnly = true;
                    this.controls.txtShinseiYMD().readOnly = true;
                    this.controls.ddlShinseiShubetsu().readOnly = true;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = true;
                    this.controls.ddlShinseiKubunHorei().readOnly = true;
                    this.controls.chkKyuSochisha().readOnly = true;
                    this.controls.ddlHihokenshaKubun().readOnly = true;
                    this.controls.chkShikakuShutokuMae().readOnly = true;
                    this.controls.ddlTokuteiShippei().readOnly = true;

                    this.controls.ServiceSakujo().displayNone = true;
                    this.controls.NinteiShinseiRiyu().readOnly = true;
                }
                            
            }
        }
    }
}

module DBZ
{
    export module KaigoNinteiShinseiKihonJohoInput
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

