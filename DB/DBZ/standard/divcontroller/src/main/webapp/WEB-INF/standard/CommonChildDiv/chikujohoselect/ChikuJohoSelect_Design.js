var DBZ;
(function (DBZ) {
    (function (ChikuJohoSelect) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ChikuJohoSelect.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ChikuJohoSelect";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ChikuJohoSelect.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ChikuJohoSelect.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ChikuJohoSelect = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.lblChushutsuJoken = function () {
                return new UZA.Label(this.convFiledName("lblChushutsuJoken"));
            };

            Controls.prototype.TanitsuShichoson = function () {
                return new UZA.Panel(this.convFiledName("TanitsuShichoson"));
            };

            Controls.prototype.ddlChiku = function () {
                return new UZA.DropDownList(this.convFiledName("ddlChiku"));
            };

            Controls.prototype.btnSelect = function () {
                return new UZA.Button(this.convFiledName("btnSelect"));
            };

            Controls.prototype.SelectedResult = function () {
                return new UZA.Panel(this.convFiledName("SelectedResult"));
            };

            Controls.prototype.ddlCodeList = function () {
                return new UZA.DataGrid(this.convFiledName("ddlCodeList"));
            };

            Controls.prototype.KoikiShichoson = function () {
                return new UZA.Panel(this.convFiledName("KoikiShichoson"));
            };

            Controls.prototype.ddlShichoson = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShichoson"));
            };

            Controls.prototype.ddlKyushichosonKoiki = function () {
                return new UZA.DropDownList(this.convFiledName("ddlKyushichosonKoiki"));
            };
            return Controls;
        })();
        ChikuJohoSelect.Controls = Controls;
    })(DBZ.ChikuJohoSelect || (DBZ.ChikuJohoSelect = {}));
    var ChikuJohoSelect = DBZ.ChikuJohoSelect;
})(DBZ || (DBZ = {}));
