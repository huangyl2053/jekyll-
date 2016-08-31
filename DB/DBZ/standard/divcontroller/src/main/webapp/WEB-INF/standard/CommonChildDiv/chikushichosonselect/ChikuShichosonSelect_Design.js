var DBZ;
(function (DBZ) {
    (function (ChikuShichosonSelect) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_DdlChiku = function () {
                return "onChange_DdlChiku";
            };

            Events.onOkClose_btnChoikiGuide = function () {
                return "onOkClose_btnChoikiGuide";
            };

            Events.onOkClose_btnChikuNyuryokuGuide = function () {
                return "onOkClose_btnChikuNyuryokuGuide";
            };

            Events.onChange_市町村DDL = function () {
                return "onChange_市町村DDL";
            };
            return Events;
        })();
        ChikuShichosonSelect.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ChikuShichosonSelect";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ChikuShichosonSelect.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ChikuShichosonSelect.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ChikuShichosonSelect = function () {
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

            Controls.prototype.btnChoikiGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnChoikiGuide"));
            };

            Controls.prototype.btnChikuNyuryokuGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnChikuNyuryokuGuide"));
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
        ChikuShichosonSelect.Controls = Controls;
    })(DBZ.ChikuShichosonSelect || (DBZ.ChikuShichosonSelect = {}));
    var ChikuShichosonSelect = DBZ.ChikuShichosonSelect;
})(DBZ || (DBZ = {}));
