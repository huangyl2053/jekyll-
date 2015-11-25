var DBA;
(function (DBA) {
    (function (IryohokenRirekiCommonChildDiv) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        IryohokenRirekiCommonChildDiv.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "IryohokenRirekiCommonChildDiv";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBA.IryohokenRirekiCommonChildDiv.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBA.IryohokenRirekiCommonChildDiv.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.IryohokenRirekiCommonChildDiv = function () {
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

            Controls.prototype.btnIryohokenKakute = function () {
                return new UZA.Button(this.convFiledName("btnIryohokenKakute"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };
            return Controls;
        })();
        IryohokenRirekiCommonChildDiv.Controls = Controls;
    })(DBA.IryohokenRirekiCommonChildDiv || (DBA.IryohokenRirekiCommonChildDiv = {}));
    var IryohokenRirekiCommonChildDiv = DBA.IryohokenRirekiCommonChildDiv;
})(DBA || (DBA = {}));
