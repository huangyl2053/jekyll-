var DBZ;
(function (DBZ) {
    (function (ShoKaishuKirokuKanri) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelectByDblClick_dgShoKaishuJokyo = function () {
                return "onSelectByDblClick_dgShoKaishuJokyo";
            };

            Events.onSelectBySelectButton_dgShoKaishuJokyo = function () {
                return "onSelectBySelectButton_dgShoKaishuJokyo";
            };

            Events.onClick_btnUpdateShoKaishuJokyo = function () {
                return "onClick_btnUpdateShoKaishuJokyo";
            };
            return Events;
        })();
        ShoKaishuKirokuKanri.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShoKaishuKirokuKanri";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShoKaishuKirokuKanri.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShoKaishuKirokuKanri.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShoKaishuKirokuKanri = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ShoKaishuJokyoList = function () {
                return new DBZ.ShoKaishuJokyoList.ModeController(this.convFiledName("ShoKaishuJokyoList"));
            };

            Controls.prototype.ShoKaishuJokyoShosai = function () {
                return new DBZ.ShoKaishuJokyoShosai.ModeController(this.convFiledName("ShoKaishuJokyoShosai"));
            };

            Controls.prototype.btnUpdateShoKaishuJokyo = function () {
                return new UZA.Button(this.convFiledName("btnUpdateShoKaishuJokyo"));
            };
            return Controls;
        })();
        ShoKaishuKirokuKanri.Controls = Controls;
    })(DBZ.ShoKaishuKirokuKanri || (DBZ.ShoKaishuKirokuKanri = {}));
    var ShoKaishuKirokuKanri = DBZ.ShoKaishuKirokuKanri;
})(DBZ || (DBZ = {}));
