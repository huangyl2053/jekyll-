var DBE;
(function (DBE) {
    (function (DankaibetsuShinseiList) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnToSearch = function () {
                return "onClick_btnToSearch";
            };
            return Events;
        })();
        DankaibetsuShinseiList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "DankaibetsuShinseiList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.DankaibetsuShinseiList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.DankaibetsuShinseiList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.DankaibetsuShinseiList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnToSearch = function () {
                return new UZA.Button(this.convFiledName("btnToSearch"));
            };

            Controls.prototype.txtKanryo = function () {
                return new UZA.TextBox(this.convFiledName("txtKanryo"));
            };

            Controls.prototype.txtGokei = function () {
                return new UZA.TextBox(this.convFiledName("txtGokei"));
            };

            Controls.prototype.btnNarabikae = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnNarabikae"));
            };

            Controls.prototype.dgTaishoIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgTaishoIchiran"));
            };
            return Controls;
        })();
        DankaibetsuShinseiList.Controls = Controls;
    })(DBE.DankaibetsuShinseiList || (DBE.DankaibetsuShinseiList = {}));
    var DankaibetsuShinseiList = DBE.DankaibetsuShinseiList;
})(DBE || (DBE = {}));
