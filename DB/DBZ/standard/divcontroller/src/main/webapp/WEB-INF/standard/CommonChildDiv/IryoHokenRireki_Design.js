var DBZ;
(function (DBZ) {
    (function (IryohokenRireki) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        IryohokenRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "IryohokenRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.IryohokenRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.IryohokenRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.IryohokenRireki = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.plIryohokenRireki = function () {
                return new UZA.Panel(this.convFiledName("plIryohokenRireki"));
            };

            Controls.prototype.btnIryohokenTsuika = function () {
                return new UZA.Button(this.convFiledName("btnIryohokenTsuika"));
            };

            Controls.prototype.dgIryohokenIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgIryohokenIchiran"));
            };

            Controls.prototype.pnlIryohokenJoho = function () {
                return new UZA.Panel(this.convFiledName("pnlIryohokenJoho"));
            };

            Controls.prototype.tbdKanyubi = function () {
                return new UZA.TextBoxDate(this.convFiledName("tbdKanyubi"));
            };

            Controls.prototype.tbdDattabi = function () {
                return new UZA.TextBoxDate(this.convFiledName("tbdDattabi"));
            };

            Controls.prototype.ddlSyubetsu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlSyubetsu"));
            };

            Controls.prototype.txtHokensyaKodo = function () {
                return new UZA.TextBox(this.convFiledName("txtHokensyaKodo"));
            };

            Controls.prototype.txtHokensyaMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtHokensyaMeisho"));
            };

            Controls.prototype.txtKigoBango = function () {
                return new UZA.TextBox(this.convFiledName("txtKigoBango"));
            };

            Controls.prototype.btnKakutei = function () {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };
            return Controls;
        })();
        IryohokenRireki.Controls = Controls;
    })(DBZ.IryohokenRireki || (DBZ.IryohokenRireki = {}));
    var IryohokenRireki = DBZ.IryohokenRireki;
})(DBZ || (DBZ = {}));
