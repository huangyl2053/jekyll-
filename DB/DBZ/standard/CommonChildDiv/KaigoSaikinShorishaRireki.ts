/// <reference path='KaigoSaikinShorishaRireki_Design.ts' />
module DBZ
{
    export module KaigoSaikinShorishaRireki
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
        }
    }
}

