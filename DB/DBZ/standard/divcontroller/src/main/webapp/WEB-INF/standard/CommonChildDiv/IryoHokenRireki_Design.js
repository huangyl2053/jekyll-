var DBZ;
(function (DBZ) {
    (function (IryoHokenRireki) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        IryoHokenRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "IryoHokenRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.IryoHokenRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.IryoHokenRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.IryoHokenRireki = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.plIryoHokenRireki = function () {
                return new UZA.Panel(this.convFiledName("plIryoHokenRireki"));
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
        IryoHokenRireki.Controls = Controls;
    })(DBZ.IryoHokenRireki || (DBZ.IryoHokenRireki = {}));
    var IryoHokenRireki = DBZ.IryoHokenRireki;
})(DBZ || (DBZ = {}));
