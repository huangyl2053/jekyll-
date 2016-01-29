var DBZ;
(function (DBZ) {
    (function (SonotaKikanGuide) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        SonotaKikanGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SonotaKikanGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SonotaKikanGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SonotaKikanGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SonotaKikanGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.KensakuJoken = function () {
                return new UZA.Panel(this.convFiledName("KensakuJoken"));
            };

            Controls.prototype.ccdHokenshaList = function () {
                return new DBZ.HokenshaList.ModeController(this.convFiledName("ccdHokenshaList"));
            };

            Controls.prototype.txtSonotaKikanCodefrom = function () {
                return new UZA.TextBox(this.convFiledName("txtSonotaKikanCodefrom"));
            };

            Controls.prototype.blkara = function () {
                return new UZA.Label(this.convFiledName("blkara"));
            };

            Controls.prototype.txtSonotaKikanCodeto = function () {
                return new UZA.TextBox(this.convFiledName("txtSonotaKikanCodeto"));
            };

            Controls.prototype.radHaisi = function () {
                return new UZA.RadioButton(this.convFiledName("radHaisi"));
            };

            Controls.prototype.txtSonotaKikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtSonotaKikanName"));
            };

            Controls.prototype.ddlChosaItakusakiKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlChosaItakusakiKubun"));
            };

            Controls.prototype.txtMaxDisp = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtMaxDisp"));
            };

            Controls.prototype.btnClear = function () {
                return new UZA.Button(this.convFiledName("btnClear"));
            };

            Controls.prototype.btnKensaku = function () {
                return new UZA.Button(this.convFiledName("btnKensaku"));
            };

            Controls.prototype.SelectIchiran = function () {
                return new UZA.Panel(this.convFiledName("SelectIchiran"));
            };

            Controls.prototype.dgSonotaKikanIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgSonotaKikanIchiran"));
            };

            Controls.prototype.btnback = function () {
                return new UZA.Button(this.convFiledName("btnback"));
            };
            return Controls;
        })();
        SonotaKikanGuide.Controls = Controls;
    })(DBZ.SonotaKikanGuide || (DBZ.SonotaKikanGuide = {}));
    var SonotaKikanGuide = DBZ.SonotaKikanGuide;
})(DBZ || (DBZ = {}));
