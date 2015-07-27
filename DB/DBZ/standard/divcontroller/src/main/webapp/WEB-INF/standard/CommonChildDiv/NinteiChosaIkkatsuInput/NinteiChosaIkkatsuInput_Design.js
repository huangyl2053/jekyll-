var DBZ;
(function (DBZ) {
    (function (NinteiChosaIkkatsuInput) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        NinteiChosaIkkatsuInput.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "NinteiChosaIkkatsuInput";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.NinteiChosaIkkatsuInput.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.NinteiChosaIkkatsuInput.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.NinteiChosaIkkatsuInput = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.tblJikanwaku1 = function () {
                return new UZA.TablePanel(this.convFiledName("tblJikanwaku1"));
            };

            Controls.prototype.celTab1R1C1 = function () {
                return new UZA.TableCell(this.convFiledName("celTab1R1C1"));
            };

            Controls.prototype.chkJikanwaku1 = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkJikanwaku1"));
            };

            Controls.prototype.celTab1R1C2 = function () {
                return new UZA.TableCell(this.convFiledName("celTab1R1C2"));
            };

            Controls.prototype.chkJikanwaku2 = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkJikanwaku2"));
            };

            Controls.prototype.celTab1R1C3 = function () {
                return new UZA.TableCell(this.convFiledName("celTab1R1C3"));
            };

            Controls.prototype.chkJikanwaku3 = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkJikanwaku3"));
            };

            Controls.prototype.celTab1R1C4 = function () {
                return new UZA.TableCell(this.convFiledName("celTab1R1C4"));
            };

            Controls.prototype.chkJikanwaku4 = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkJikanwaku4"));
            };

            Controls.prototype.celTab1R1C5 = function () {
                return new UZA.TableCell(this.convFiledName("celTab1R1C5"));
            };

            Controls.prototype.chkJikanwaku5 = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkJikanwaku5"));
            };

            Controls.prototype.celTab1R2C1 = function () {
                return new UZA.TableCell(this.convFiledName("celTab1R2C1"));
            };

            Controls.prototype.txtStartTime1 = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtStartTime1"));
            };

            Controls.prototype.celTab1R2C2 = function () {
                return new UZA.TableCell(this.convFiledName("celTab1R2C2"));
            };

            Controls.prototype.txtStartTime2 = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtStartTime2"));
            };

            Controls.prototype.celTab1R2C3 = function () {
                return new UZA.TableCell(this.convFiledName("celTab1R2C3"));
            };

            Controls.prototype.txtStartTime3 = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtStartTime3"));
            };

            Controls.prototype.celTab1R2C4 = function () {
                return new UZA.TableCell(this.convFiledName("celTab1R2C4"));
            };

            Controls.prototype.txtStartTime4 = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtStartTime4"));
            };

            Controls.prototype.celTab1R2C5 = function () {
                return new UZA.TableCell(this.convFiledName("celTab1R2C5"));
            };

            Controls.prototype.txtStartTime5 = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtStartTime5"));
            };

            Controls.prototype.celTab1R3C1 = function () {
                return new UZA.TableCell(this.convFiledName("celTab1R3C1"));
            };

            Controls.prototype.txtEndTime1 = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtEndTime1"));
            };

            Controls.prototype.celTab1R3C2 = function () {
                return new UZA.TableCell(this.convFiledName("celTab1R3C2"));
            };

            Controls.prototype.txtEndTime2 = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtEndTime2"));
            };

            Controls.prototype.celTab1R3C3 = function () {
                return new UZA.TableCell(this.convFiledName("celTab1R3C3"));
            };

            Controls.prototype.txtEndTime3 = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtEndTime3"));
            };

            Controls.prototype.celTab1R3C4 = function () {
                return new UZA.TableCell(this.convFiledName("celTab1R3C4"));
            };

            Controls.prototype.txtEndTime4 = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtEndTime4"));
            };

            Controls.prototype.celTab1R3C5 = function () {
                return new UZA.TableCell(this.convFiledName("celTab1R3C5"));
            };

            Controls.prototype.txtEndTime5 = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtEndTime5"));
            };

            Controls.prototype.lin1 = function () {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            };

            Controls.prototype.tblJikanwaku2 = function () {
                return new UZA.TablePanel(this.convFiledName("tblJikanwaku2"));
            };

            Controls.prototype.celTab2R4C1 = function () {
                return new UZA.TableCell(this.convFiledName("celTab2R4C1"));
            };

            Controls.prototype.chkJikanwaku6 = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkJikanwaku6"));
            };

            Controls.prototype.celTab2R4C2 = function () {
                return new UZA.TableCell(this.convFiledName("celTab2R4C2"));
            };

            Controls.prototype.chkJikanwaku7 = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkJikanwaku7"));
            };

            Controls.prototype.celTab2R4C3 = function () {
                return new UZA.TableCell(this.convFiledName("celTab2R4C3"));
            };

            Controls.prototype.chkJikanwaku8 = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkJikanwaku8"));
            };

            Controls.prototype.celTab2R4C4 = function () {
                return new UZA.TableCell(this.convFiledName("celTab2R4C4"));
            };

            Controls.prototype.chkJikanwaku9 = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkJikanwaku9"));
            };

            Controls.prototype.celTab2R4C5 = function () {
                return new UZA.TableCell(this.convFiledName("celTab2R4C5"));
            };

            Controls.prototype.chkJikanwaku10 = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkJikanwaku10"));
            };

            Controls.prototype.celTab2R5C1 = function () {
                return new UZA.TableCell(this.convFiledName("celTab2R5C1"));
            };

            Controls.prototype.txtStartTime6 = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtStartTime6"));
            };

            Controls.prototype.celTab2R5C2 = function () {
                return new UZA.TableCell(this.convFiledName("celTab2R5C2"));
            };

            Controls.prototype.txtStartTime7 = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtStartTime7"));
            };

            Controls.prototype.celTab2R5C3 = function () {
                return new UZA.TableCell(this.convFiledName("celTab2R5C3"));
            };

            Controls.prototype.txtStartTime8 = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtStartTime8"));
            };

            Controls.prototype.celTab2R5C4 = function () {
                return new UZA.TableCell(this.convFiledName("celTab2R5C4"));
            };

            Controls.prototype.txtStartTime9 = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtStartTime9"));
            };

            Controls.prototype.celTab2R5C5 = function () {
                return new UZA.TableCell(this.convFiledName("celTab2R5C5"));
            };

            Controls.prototype.txtStartTime10 = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtStartTime10"));
            };

            Controls.prototype.celTab2R6C1 = function () {
                return new UZA.TableCell(this.convFiledName("celTab2R6C1"));
            };

            Controls.prototype.txtEndTime6 = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtEndTime6"));
            };

            Controls.prototype.celTab2R6C2 = function () {
                return new UZA.TableCell(this.convFiledName("celTab2R6C2"));
            };

            Controls.prototype.txtEndTime7 = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtEndTime7"));
            };

            Controls.prototype.celTab2R6C3 = function () {
                return new UZA.TableCell(this.convFiledName("celTab2R6C3"));
            };

            Controls.prototype.txtEndTime8 = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtEndTime8"));
            };

            Controls.prototype.celTab2R6C4 = function () {
                return new UZA.TableCell(this.convFiledName("celTab2R6C4"));
            };

            Controls.prototype.txtEndTime9 = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtEndTime9"));
            };

            Controls.prototype.celTab2R6C5 = function () {
                return new UZA.TableCell(this.convFiledName("celTab2R6C5"));
            };

            Controls.prototype.txtEndTime10 = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtEndTime10"));
            };

            Controls.prototype.chkDay = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkDay"));
            };

            Controls.prototype.chkUpdate = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkUpdate"));
            };

            Controls.prototype.btnBack = function () {
                return new UZA.Button(this.convFiledName("btnBack"));
            };

            Controls.prototype.btnUpdate = function () {
                return new UZA.Button(this.convFiledName("btnUpdate"));
            };
            return Controls;
        })();
        NinteiChosaIkkatsuInput.Controls = Controls;
    })(DBZ.NinteiChosaIkkatsuInput || (DBZ.NinteiChosaIkkatsuInput = {}));
    var NinteiChosaIkkatsuInput = DBZ.NinteiChosaIkkatsuInput;
})(DBZ || (DBZ = {}));
