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

                public ServiceHenkoMode(): void {
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

                public ShinseiMode(): void {
                    this.controls.radShinseishoKubun().readOnly = false;
                    this.controls.txtShinseiYMD().readOnly = false;
                    this.controls.ddlShinseiShubetsu().readOnly = true;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = false;
                    this.controls.ddlShinseiKubunHorei().readOnly = false;
                    this.controls.chkKyuSochisha().readOnly = false;
                    this.controls.ddlHihokenshaKubun().readOnly = false;
                    this.controls.chkShikakuShutokuMae().readOnly = false;
                    this.controls.ddlTokuteiShippei().readOnly = false;

                    this.controls.ServiceSakujo().readOnly = true;
                    this.controls.NinteiShinseiRiyu().readOnly = false;

                }
                public RirekiShuseiMode(): void {
                    this.controls.radShinseishoKubun().readOnly = false;
                    this.controls.txtShinseiYMD().readOnly = false;
                    this.controls.ddlShinseiShubetsu().readOnly = false;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = false;
                    this.controls.ddlShinseiKubunHorei().readOnly = false;
                    this.controls.chkKyuSochisha().readOnly = false;
                    this.controls.ddlHihokenshaKubun().readOnly = false;
                    this.controls.chkShikakuShutokuMae().readOnly = false;
                    this.controls.ddlTokuteiShippei().readOnly = true;

                    this.controls.ServiceSakujo().readOnly = true;
                    this.controls.NinteiShinseiRiyu().readOnly = false;

                }
                public ShokkenShuseiAndTorikeshiMode(): void {
                    this.controls.radShinseishoKubun().readOnly = true;
                    this.controls.txtShinseiYMD().readOnly = false;
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
                public ShinseiShuseiMode(): void {
                    this.controls.radShinseishoKubun().readOnly = false;
                    this.controls.txtShinseiYMD().readOnly = false;
                    this.controls.ddlShinseiShubetsu().readOnly = false;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = false;
                    this.controls.ddlShinseiKubunHorei().readOnly = true;
                    this.controls.chkKyuSochisha().readOnly = false;
                    this.controls.ddlHihokenshaKubun().readOnly = false;
                    this.controls.chkShikakuShutokuMae().readOnly = false;
                    this.controls.ddlTokuteiShippei().readOnly = false;

                    this.controls.ServiceSakujo().readOnly = true;
                    this.controls.NinteiShinseiRiyu().readOnly = false;
                }

                public KubunHenkoMode(): void {
                    this.controls.radShinseishoKubun().readOnly = false;
                    this.controls.txtShinseiYMD().readOnly = false;
                    this.controls.ddlShinseiShubetsu().readOnly = false;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = false;
                    this.controls.ddlShinseiKubunHorei().readOnly = true;
                    this.controls.chkKyuSochisha().readOnly = false;
                    this.controls.ddlHihokenshaKubun().readOnly = false;
                    this.controls.chkShikakuShutokuMae().readOnly = false;
                    this.controls.ddlTokuteiShippei().readOnly = false;

                    this.controls.ServiceSakujo().readOnly = true;
                    this.controls.NinteiShinseiRiyu().readOnly = false;
                }
                public TennyuMode(): void {
                    this.controls.radShinseishoKubun().readOnly = false;
                    this.controls.txtShinseiYMD().readOnly = false;
                    this.controls.ddlShinseiShubetsu().readOnly = true;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = false;
                    this.controls.ddlShinseiKubunHorei().readOnly = true;
                    this.controls.chkKyuSochisha().readOnly = false;
                    this.controls.ddlHihokenshaKubun().readOnly = false;
                    this.controls.chkShikakuShutokuMae().readOnly = true;
                    this.controls.ddlTokuteiShippei().readOnly = false;

                    this.controls.ServiceSakujo().readOnly = true;
                    this.controls.NinteiShinseiRiyu().readOnly = false;
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

                    this.controls.ServiceSakujo().readOnly = true;
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

                    this.controls.ServiceSakujo().readOnly = true;
                    this.controls.NinteiShinseiRiyu().readOnly = true;
                }
                public TorikeshiAndSakujoMode(): void {
                    this.controls.radShinseishoKubun().readOnly = false;
                    this.controls.txtShinseiYMD().readOnly = false;
                    this.controls.ddlShinseiShubetsu().readOnly = true;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = false;
                    this.controls.ddlShinseiKubunHorei().readOnly = false;
                    this.controls.chkKyuSochisha().readOnly = false;
                    this.controls.ddlHihokenshaKubun().readOnly = false;
                    this.controls.chkShikakuShutokuMae().readOnly = true;
                    this.controls.ddlTokuteiShippei().readOnly = false;

                    this.controls.ServiceSakujo().readOnly = true;
                    this.controls.NinteiShinseiRiyu().readOnly = false;
                }
                public TokushuTsuikaMode(): void {
                    this.controls.radShinseishoKubun().readOnly = false;
                    this.controls.txtShinseiYMD().readOnly = false;
                    this.controls.ddlShinseiShubetsu().readOnly = true;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = false;
                    this.controls.ddlShinseiKubunHorei().readOnly = false;
                    this.controls.chkKyuSochisha().readOnly = false;
                    this.controls.ddlHihokenshaKubun().readOnly = false;
                    this.controls.chkShikakuShutokuMae().readOnly = true;
                    this.controls.ddlTokuteiShippei().readOnly = false;

                    this.controls.ServiceSakujo().readOnly = true;
                    this.controls.NinteiShinseiRiyu().readOnly = false;
                }
                public TokushuShuseiMode(): void {
                    this.controls.radShinseishoKubun().readOnly = false;
                    this.controls.txtShinseiYMD().readOnly = false;
                    this.controls.ddlShinseiShubetsu().readOnly = false;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = false;
                    this.controls.ddlShinseiKubunHorei().readOnly = false;
                    this.controls.chkKyuSochisha().readOnly = false;
                    this.controls.ddlHihokenshaKubun().readOnly = false;
                    this.controls.chkShikakuShutokuMae().readOnly = false;
                    this.controls.ddlTokuteiShippei().readOnly = false;

                    this.controls.ServiceSakujo().readOnly = true;
                    this.controls.NinteiShinseiRiyu().readOnly = false;
                }
                public ShokkenKisaiMode(): void {
                    this.controls.radShinseishoKubun().readOnly = false;
                    this.controls.txtShinseiYMD().readOnly = false;
                    this.controls.ddlShinseiShubetsu().readOnly = true;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = false;
                    this.controls.ddlShinseiKubunHorei().readOnly = false;
                    this.controls.chkKyuSochisha().readOnly = false;
                    this.controls.ddlHihokenshaKubun().readOnly = false;
                    this.controls.chkShikakuShutokuMae().readOnly = true;
                    this.controls.ddlTokuteiShippei().readOnly = false;

                    this.controls.ServiceSakujo().readOnly = true;
                    this.controls.NinteiShinseiRiyu().readOnly = false;
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

