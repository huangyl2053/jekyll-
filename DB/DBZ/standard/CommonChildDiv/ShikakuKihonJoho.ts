

/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

/// <reference path="ShikakuKihonJoho_Design.ts" />


module DBZ {
    export module ShikakuKihonJoho {

        export class ModeController {
            private controls: Controls;

            constructor(fieldName: string) {
                this.controls = new Controls(fieldName);
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

                public RenrakusakiNashi(): void {
                    var btnRenrakusaki: Uz._Button = <Uz._Button> Uz.GyomuJSHelper.getCompositeChildControl('ccdKaigoShikakuKihon', 'KaigoShikakuKihon', 'btnRenrakusaki');
                    var btnHihoRireki: Uz._Button = <Uz._Button> Uz.GyomuJSHelper.getCompositeChildControl('ccdKaigoShikakuKihon', 'KaigoShikakuKihon', 'btnHihoRireki');
                    var btnNinteiRireki: Uz._Button = <Uz._Button> Uz.GyomuJSHelper.getCompositeChildControl('ccdKaigoShikakuKihon', 'KaigoShikakuKihon', 'btnNinteiRireki');

                    btnRenrakusaki.displayNone = false;
                    btnHihoRireki.displayNone = true;
                    btnNinteiRireki.displayNone = true;
                }                                                        

                public HihokenrirekiNashi(): void {
                    var btnRenrakusaki: Uz._Button = <Uz._Button> Uz.GyomuJSHelper.getCompositeChildControl('ccdKaigoShikakuKihon', 'KaigoShikakuKihon', 'btnRenrakusaki');
                    var btnHihoRireki: Uz._Button = <Uz._Button> Uz.GyomuJSHelper.getCompositeChildControl('ccdKaigoShikakuKihon', 'KaigoShikakuKihon', 'btnHihoRireki');
                    var btnNinteiRireki: Uz._Button = <Uz._Button> Uz.GyomuJSHelper.getCompositeChildControl('ccdKaigoShikakuKihon', 'KaigoShikakuKihon', 'btnNinteiRireki');

                    btnRenrakusaki.displayNone = true;
                    btnHihoRireki.displayNone = false;
                    btnNinteiRireki.displayNone = true;
                }
                public NinteirirekiNashi(): void {
                    var btnRenrakusaki: Uz._Button = <Uz._Button> Uz.GyomuJSHelper.getCompositeChildControl('ccdKaigoShikakuKihon', 'KaigoShikakuKihon', 'btnRenrakusaki');
                    var btnHihoRireki: Uz._Button = <Uz._Button> Uz.GyomuJSHelper.getCompositeChildControl('ccdKaigoShikakuKihon', 'KaigoShikakuKihon', 'btnHihoRireki');
                    var btnNinteiRireki: Uz._Button = <Uz._Button> Uz.GyomuJSHelper.getCompositeChildControl('ccdKaigoShikakuKihon', 'KaigoShikakuKihon', 'btnNinteiRireki');

                    btnRenrakusaki.displayNone = true;
                    btnHihoRireki.displayNone = true;
                    btnNinteiRireki.displayNone = false;
                }
            }
        }
    }
}



