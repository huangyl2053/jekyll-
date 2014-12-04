var DBZ;
(function (DBZ) {
    (function (KaigoTeikeibun) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_ddlTeikenbunShubetsu = function () {
                return "onChange_ddlTeikenbunShubetsu";
            };

            Events.onSelectBySB_Teikeibun = function () {
                return "onSelectBySB_Teikeibun";
            };

            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        KaigoTeikeibun.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoTeikeibun";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoTeikeibun.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoTeikeibun.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoTeikeibun = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlTeikenbunShubetsu = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTeikenbunShubetsu"));
            };

            Controls.prototype.dgTeikeibun = function () {
                return new UZA.DataGrid(this.convFiledName("dgTeikeibun"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        KaigoTeikeibun.Controls = Controls;
    })(DBZ.KaigoTeikeibun || (DBZ.KaigoTeikeibun = {}));
    var KaigoTeikeibun = DBZ.KaigoTeikeibun;
})(DBZ || (DBZ = {}));
