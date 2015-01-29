/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />
// <reference path="../d.ts/URACommonChildDiv.d.ts" />

module DBZ {

     export module ChikuJohoSelect {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "ChikuJohoSelect";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.ChikuJohoSelect.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.ChikuJohoSelect.Controls.myType() + "_" + fieldName;
            }

            public ChikuJohoSelect(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public TanitsuShichoson(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TanitsuShichoson"));
            }

            public ddlChiku(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlChiku"));
            }

            public ddlKyushichosonTanitsu(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKyushichosonTanitsu"));
            }

            public ChoikiSelect(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TanitsuShichoson_ChoikiSelect"));
            }

            //public ccdChoikiInputSt(): URA.ChoikiInput.ModeController {
            //    return new URA.ChoikiInput.ModeController(this.convFiledName("ccdChoikiInputSt"));
            //}

            public lblKaraChoiki(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKaraChoiki"));
            }

            //public ccdChoikiInputEd(): URA.ChoikiInput.ModeController {
            //    return new URA.ChoikiInput.ModeController(this.convFiledName("ccdChoikiInputEd"));
            //}

            public GyoseikuSelect(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TanitsuShichoson_GyoseikuSelect"));
            }

            //public ccdGyoseikuInputSt(): URA.GyoseikuInput.ModeController {
            //    return new URA.GyoseikuInput.ModeController(this.convFiledName("ccdGyoseikuInputSt"));
            //}

            public lblKaraGyoseiku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKaraGyoseiku"));
            }

            //public ccdGyoseikuInputEd(): URA.GyoseikuInput.ModeController {
            //    return new URA.GyoseikuInput.ModeController(this.convFiledName("ccdGyoseikuInputEd"));
            //}

            public Chikiku1Select(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TanitsuShichoson_Chikiku1Select"));
            }

            //public ccdChiku1InputSt(): URA.Chiku1Input.ModeController {
            //    return new URA.Chiku1Input.ModeController(this.convFiledName("ccdChiku1InputSt"));
            //}

            public lblKaraChiku1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKaraChiku1"));
            }

            //public ccdChiku1InputEd(): URA.Chiku1Input.ModeController {
            //    return new URA.Chiku1Input.ModeController(this.convFiledName("ccdChiku1InputEd"));
            //}

            public Chikiku2Select(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TanitsuShichoson_Chikiku2Select"));
            }

            //public ccdChiku2InputSt(): URA.Chiku2Input.ModeController {
            //    return new URA.Chiku2Input.ModeController(this.convFiledName("ccdChiku2InputSt"));
            //}

            public lblKaraChiku2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKaraChiku2"));
            }

            //public ccdChiku2InputEd(): URA.Chiku2Input.ModeController {
            //    return new URA.Chiku2Input.ModeController(this.convFiledName("ccdChiku2InputEd"));
            //}

            public Chikiku3Select(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("TanitsuShichoson_Chikiku3Select"));
            }

            //public ccdChiku3InputSt(): URA.Chiku3Input.ModeController {
            //    return new URA.Chiku3Input.ModeController(this.convFiledName("ccdChiku3InputSt"));
            //}

            public lblKaraChiku3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblKaraChiku3"));
            }

            //public ccdChiku3InputEd(): URA.Chiku3Input.ModeController {
            //    return new URA.Chiku3Input.ModeController(this.convFiledName("ccdChiku3InputEd"));
            //}

            public koikiShichoson(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("koikiShichoson"));
            }

            public ddlShichoson(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlShichoson"));
            }

            public ddlKyushichosonKoiki(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlKyushichosonKoiki"));
            }

        }

     }

}

