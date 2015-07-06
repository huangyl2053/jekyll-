/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBZ {

     export module NinteiChosaIkkatsuInput {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "NinteiChosaIkkatsuInput";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBZ.NinteiChosaIkkatsuInput.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBZ.NinteiChosaIkkatsuInput.Controls.myType() + "_" + fieldName;
            }

            public NinteiChosaIkkatsuInput(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public tblJikanwaku1(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblJikanwaku1"));
            }

            public celTab1R1C1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab1R1C1"));
            }

            public chkJikanwaku1(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkJikanwaku1"));
            }

            public celTab1R1C2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab1R1C2"));
            }

            public chkJikanwaku2(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkJikanwaku2"));
            }

            public celTab1R1C3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab1R1C3"));
            }

            public chkJikanwaku3(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkJikanwaku3"));
            }

            public celTab1R1C4(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab1R1C4"));
            }

            public chkJikanwaku4(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkJikanwaku4"));
            }

            public celTab1R1C5(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab1R1C5"));
            }

            public chkJikanwaku5(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkJikanwaku5"));
            }

            public celTab1R2C1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab1R2C1"));
            }

            public txtStartTime1(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtStartTime1"));
            }

            public celTab1R2C2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab1R2C2"));
            }

            public txtStartTime2(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtStartTime2"));
            }

            public celTab1R2C3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab1R2C3"));
            }

            public txtStartTime3(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtStartTime3"));
            }

            public celTab1R2C4(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab1R2C4"));
            }

            public txtStartTime4(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtStartTime4"));
            }

            public celTab1R2C5(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab1R2C5"));
            }

            public txtStartTime5(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtStartTime5"));
            }

            public celTab1R3C1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab1R3C1"));
            }

            public txtEndTime1(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtEndTime1"));
            }

            public celTab1R3C2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab1R3C2"));
            }

            public txtEndTime2(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtEndTime2"));
            }

            public celTab1R3C3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab1R3C3"));
            }

            public txtEndTime3(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtEndTime3"));
            }

            public celTab1R3C4(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab1R3C4"));
            }

            public txtEndTime4(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtEndTime4"));
            }

            public celTab1R3C5(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab1R3C5"));
            }

            public txtEndTime5(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtEndTime5"));
            }

            public lin1(): UZA.HorizontalLine {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            }

            public tblJikanwaku2(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblJikanwaku2"));
            }

            public celTab2R4C1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab2R4C1"));
            }

            public chkJikanwaku6(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkJikanwaku6"));
            }

            public celTab2R4C2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab2R4C2"));
            }

            public chkJikanwaku7(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkJikanwaku7"));
            }

            public celTab2R4C3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab2R4C3"));
            }

            public chkJikanwaku8(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkJikanwaku8"));
            }

            public celTab2R4C4(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab2R4C4"));
            }

            public chkJikanwaku9(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkJikanwaku9"));
            }

            public celTab2R4C5(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab2R4C5"));
            }

            public chkJikanwaku10(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkJikanwaku10"));
            }

            public celTab2R5C1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab2R5C1"));
            }

            public txtStartTime6(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtStartTime6"));
            }

            public celTab2R5C2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab2R5C2"));
            }

            public txtStartTime7(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtStartTime7"));
            }

            public celTab2R5C3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab2R5C3"));
            }

            public txtStartTime8(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtStartTime8"));
            }

            public celTab2R5C4(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab2R5C4"));
            }

            public txtStartTime9(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtStartTime9"));
            }

            public celTab2R5C5(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab2R5C5"));
            }

            public txtStartTime10(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtStartTime10"));
            }

            public celTab2R6C1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab2R6C1"));
            }

            public txtEndTime6(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtEndTime6"));
            }

            public celTab2R6C2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab2R6C2"));
            }

            public txtEndTime7(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtEndTime7"));
            }

            public celTab2R6C3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab2R6C3"));
            }

            public txtEndTime8(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtEndTime8"));
            }

            public celTab2R6C4(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab2R6C4"));
            }

            public txtEndTime9(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtEndTime9"));
            }

            public celTab2R6C5(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTab2R6C5"));
            }

            public txtEndTime10(): UZA.TextBoxTime {
                return new UZA.TextBoxTime(this.convFiledName("txtEndTime10"));
            }

            public chkDay(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkDay"));
            }

            public chkUpdate(): UZA.CheckBoxList {
                return new UZA.CheckBoxList(this.convFiledName("chkUpdate"));
            }

            public btnBack(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnBack"));
            }

            public btnUpdate(): UZA.Button {
                return new UZA.Button(this.convFiledName("btnUpdate"));
            }

        }

     }

}

