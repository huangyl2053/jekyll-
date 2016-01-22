var DBZ;
(function (DBZ) {
    (function (NinteiChosaIraiShokai) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        NinteiChosaIraiShokai.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "NinteiChosaIraiShokai";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.NinteiChosaIraiShokai.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.NinteiChosaIraiShokai.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.NinteiChosaIraiShokai = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgNinteiChosaIrai = function () {
                return new UZA.DataGrid(this.convFiledName("dgNinteiChosaIrai"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        NinteiChosaIraiShokai.Controls = Controls;
    })(DBZ.NinteiChosaIraiShokai || (DBZ.NinteiChosaIraiShokai = {}));
    var NinteiChosaIraiShokai = DBZ.NinteiChosaIraiShokai;
})(DBZ || (DBZ = {}));
