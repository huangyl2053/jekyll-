var DBE;
(function (DBE) {
    (function (ShobyoIken) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_double = function () {
                return "onClick_double";
            };

            Events.onClick_syusei = function () {
                return "onClick_syusei";
            };

            Events.onClick_sakujyo = function () {
                return "onClick_sakujyo";
            };

            Events.onClick_selectok = function () {
                return "onClick_selectok";
            };

            Events.onClick_select = function () {
                return "onClick_select";
            };

            Events.onClick_btnNo = function () {
                return "onClick_btnNo";
            };

            Events.onClick_btnOK = function () {
                return "onClick_btnOK";
            };

            Events.onChange_antei = function () {
                return "onChange_antei";
            };

            Events.onClick_btnKakutei = function () {
                return "onClick_btnKakutei";
            };

            Events.onClick_btnCansel = function () {
                return "onClick_btnCansel";
            };
            return Events;
        })();
        ShobyoIken.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShobyoIken";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.ShobyoIken.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.ShobyoIken.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShobyoIken = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ShindanName = function () {
                return new UZA.Panel(this.convFiledName("ShindanName"));
            };

            Controls.prototype.txtShindanName1 = function () {
                return new UZA.TextBox(this.convFiledName("txtShindanName1"));
            };

            Controls.prototype.txtShindanYMD1 = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShindanYMD1"));
            };

            Controls.prototype.txtShindanName2 = function () {
                return new UZA.TextBox(this.convFiledName("txtShindanName2"));
            };

            Controls.prototype.txtShindanYMD2 = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShindanYMD2"));
            };

            Controls.prototype.txtShindanName3 = function () {
                return new UZA.TextBox(this.convFiledName("txtShindanName3"));
            };

            Controls.prototype.txtShindanYMD3 = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShindanYMD3"));
            };

            Controls.prototype.geninShikkanPanel = function () {
                return new UZA.Panel(this.convFiledName("geninShikkanPanel"));
            };

            Controls.prototype.btnAdd = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnAdd"));
            };

            Controls.prototype.dgGenyin = function () {
                return new UZA.DataGrid(this.convFiledName("dgGenyin"));
            };

            Controls.prototype.geninShikkanShosai = function () {
                return new UZA.Panel(this.convFiledName("geninShikkanShosai"));
            };

            Controls.prototype.txtGeninShikkanCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtGeninShikkanCode"));
            };

            Controls.prototype.btnToSearch = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnToSearch"));
            };

            Controls.prototype.txtMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtMeisho"));
            };

            Controls.prototype.radIsShutaruGeninShikkan = function () {
                return new UZA.RadioButton(this.convFiledName("radIsShutaruGeninShikkan"));
            };

            Controls.prototype.btnNo = function () {
                return new UZA.Button(this.convFiledName("btnNo"));
            };

            Controls.prototype.btnOK = function () {
                return new UZA.Button(this.convFiledName("btnOK"));
            };

            Controls.prototype.ShojoAnteisei = function () {
                return new UZA.Panel(this.convFiledName("ShojoAnteisei"));
            };

            Controls.prototype.radShojoAnteisei = function () {
                return new UZA.RadioButton(this.convFiledName("radShojoAnteisei"));
            };

            Controls.prototype.txtFuanteiShosaiJokyo = function () {
                return new UZA.TextBox(this.convFiledName("txtFuanteiShosaiJokyo"));
            };

            Controls.prototype.SeikatsuKinoGenin = function () {
                return new UZA.Panel(this.convFiledName("SeikatsuKinoGenin"));
            };

            Controls.prototype.lblChiryoNaiyo = function () {
                return new UZA.Label(this.convFiledName("lblChiryoNaiyo"));
            };

            Controls.prototype.txtNaiyo = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtNaiyo"));
            };

            Controls.prototype.btnKakutei = function () {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            };

            Controls.prototype.btnCansel = function () {
                return new UZA.Button(this.convFiledName("btnCansel"));
            };
            return Controls;
        })();
        ShobyoIken.Controls = Controls;
    })(DBE.ShobyoIken || (DBE.ShobyoIken = {}));
    var ShobyoIken = DBE.ShobyoIken;
})(DBE || (DBE = {}));
