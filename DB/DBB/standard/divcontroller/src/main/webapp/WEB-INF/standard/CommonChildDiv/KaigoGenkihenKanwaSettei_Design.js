var DBB;
(function (DBB) {
    (function (KaigoGenkihenKanwaSettei) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoGenkihenKanwaSettei.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoGenkihenKanwaSettei";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBB.KaigoGenkihenKanwaSettei.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBB.KaigoGenkihenKanwaSettei.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoGenkihenKanwaSettei = function () {
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
        KaigoGenkihenKanwaSettei.Controls = Controls;
    })(DBB.KaigoGenkihenKanwaSettei || (DBB.KaigoGenkihenKanwaSettei = {}));
    var KaigoGenkihenKanwaSettei = DBB.KaigoGenkihenKanwaSettei;
})(DBB || (DBB = {}));
