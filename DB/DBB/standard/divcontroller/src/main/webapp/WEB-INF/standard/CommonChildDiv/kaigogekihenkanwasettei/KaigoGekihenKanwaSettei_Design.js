var DBB;
(function (DBB) {
    (function (KaigoGekihenKanwaSettei) {
        var Events = (function () {
            function Events() {
            }
            Events.onClickBtnClose = function () {
                return "onClickBtnClose";
            };

            Events.onClickBtnKakutei = function () {
                return "onClickBtnKakutei";
            };
            return Events;
        })();
        KaigoGekihenKanwaSettei.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoGekihenKanwaSettei";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBB.KaigoGekihenKanwaSettei.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBB.KaigoGekihenKanwaSettei.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoGekihenKanwaSettei = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgGekihenKanwa = function () {
                return new UZA.DataGrid(this.convFiledName("dgGekihenKanwa"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };

            Controls.prototype.btnKakutei = function () {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            };
            return Controls;
        })();
        KaigoGekihenKanwaSettei.Controls = Controls;
    })(DBB.KaigoGekihenKanwaSettei || (DBB.KaigoGekihenKanwaSettei = {}));
    var KaigoGekihenKanwaSettei = DBB.KaigoGekihenKanwaSettei;
})(DBB || (DBB = {}));
