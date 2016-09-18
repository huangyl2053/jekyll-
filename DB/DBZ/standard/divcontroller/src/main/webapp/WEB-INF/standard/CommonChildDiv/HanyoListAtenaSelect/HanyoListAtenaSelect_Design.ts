/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />
// <reference path="./../hokenshalist/HokenshaList.ts" />
// <reference path="../../d.ts/URACommonChildDiv.d.ts" />

module DBZ {

     export module HanyoListAtenaSelect {

        export class Events {

            public static onChange_SelectKijun(): string {
                return "onChange_SelectKijun";
            }

            public static onChange_SelectChiku(): string {
                return "onChange_SelectChiku";
            }

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "HanyoListAtenaSelect";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.HanyoListAtenaSelect.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.HanyoListAtenaSelect.Controls.myType() + "_" + fieldName;
            }

            public HanyoListAtenaSelect(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public DvAtena(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("DvAtena"));
            }

            public DvJokenSelect(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("DvJokenSelect"));
            }

            public radSelectKijun(): UZA.RadioButton {
                return new UZA.RadioButton(this.convFiledName("radSelectKijun"));
            }

            public dvKensakuJoken(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("dvKensakuJoken"));
            }

            public txtNenrei(): UZA.TextBoxNumRange {
                return new UZA.TextBoxNumRange(this.convFiledName("txtNenrei"));
            }

            public txtNenreiKijunbi(): UZA.TextBoxDate {
                return new UZA.TextBoxDate(this.convFiledName("txtNenreiKijunbi"));
            }

            public txtSeinengappi(): UZA.TextBoxDateRange {
                return new UZA.TextBoxDateRange(this.convFiledName("txtSeinengappi"));
            }

            //public ccdHokenshaList(): DBZ.HokenshaList.ModeController {
            //    return new DBZ.HokenshaList.ModeController(this.convFiledName("ccdHokenshaList"));
            //}

            public DvChiku(): UZA.Panel {
                return new UZA.Panel(this.convFiledName("DvChiku"));
            }

            public ddlChikuSelect(): UZA.DropDownList {
                return new UZA.DropDownList(this.convFiledName("ddlChikuSelect"));
            }

            public lblStart(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblStart"));
            }

            //public ccdJushoFrom(): URA.ChoikiInput.ModeController {
            //    return new URA.ChoikiInput.ModeController(this.convFiledName("ccdJushoFrom"));
            //}

            //public ccdGyoseikuFrom(): URA.GyoseikuInput.ModeController {
            //    return new URA.GyoseikuInput.ModeController(this.convFiledName("ccdGyoseikuFrom"));
            //}

            //public ccdChiku1From(): URA.Chiku1Input.ModeController {
            //    return new URA.Chiku1Input.ModeController(this.convFiledName("ccdChiku1From"));
            //}

            //public ccdChiku2From(): URA.Chiku2Input.ModeController {
            //    return new URA.Chiku2Input.ModeController(this.convFiledName("ccdChiku2From"));
            //}

            //public ccdChiku3From(): URA.Chiku3Input.ModeController {
            //    return new URA.Chiku3Input.ModeController(this.convFiledName("ccdChiku3From"));
            //}

            public lblEnd(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblEnd"));
            }

            //public ccdJushoTo(): URA.ChoikiInput.ModeController {
            //    return new URA.ChoikiInput.ModeController(this.convFiledName("ccdJushoTo"));
            //}

            //public ccdGyoseikuTo(): URA.GyoseikuInput.ModeController {
            //    return new URA.GyoseikuInput.ModeController(this.convFiledName("ccdGyoseikuTo"));
            //}

            //public ccdChiku1To(): URA.Chiku1Input.ModeController {
            //    return new URA.Chiku1Input.ModeController(this.convFiledName("ccdChiku1To"));
            //}

            //public ccdChiku2To(): URA.Chiku2Input.ModeController {
            //    return new URA.Chiku2Input.ModeController(this.convFiledName("ccdChiku2To"));
            //}

            //public ccdChiku3To(): URA.Chiku3Input.ModeController {
            //    return new URA.Chiku3Input.ModeController(this.convFiledName("ccdChiku3To"));
            //}

        }

     }

}

