var DBZ;
(function (DBZ) {
    (function (ShobyoIken) {
        var Events = (function () {
            function Events() {
            }
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
                return this._myName + "_" + DBZ.ShobyoIken.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShobyoIken.Controls.myType() + "_" + fieldName;
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

            Controls.prototype.txtShindanName = function () {
                return new UZA.TextBox(this.convFiledName("txtShindanName"));
            };

            Controls.prototype.txtShindanYMD3 = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShindanYMD3"));
            };

            Controls.prototype.btnShuyoShippeiGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShuyoShippeiGuide"));
            };

            Controls.prototype.txtShuyoShippeiCode = function () {
                return new UZA.TextBox(this.convFiledName("txtShuyoShippeiCode"));
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

            Controls.prototype.imgChiryoNaiyo = function () {
                return new UZA.StaticImage(this.convFiledName("imgChiryoNaiyo"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };

            Controls.prototype.btnKoshin = function () {
                return new UZA.Button(this.convFiledName("btnKoshin"));
            };
            return Controls;
        })();
        ShobyoIken.Controls = Controls;
    })(DBZ.ShobyoIken || (DBZ.ShobyoIken = {}));
    var ShobyoIken = DBZ.ShobyoIken;
})(DBZ || (DBZ = {}));
