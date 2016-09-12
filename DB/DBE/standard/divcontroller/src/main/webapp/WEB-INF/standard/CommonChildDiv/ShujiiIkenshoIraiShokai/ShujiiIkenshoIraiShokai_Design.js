var DBE;
(function (DBE) {
    (function (ShujiiIkenshoIraiShokai) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnModoru = function () {
                return "onClick_btnModoru";
            };
            return Events;
        })();
        ShujiiIkenshoIraiShokai.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShujiiIkenshoIraiShokai";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.ShujiiIkenshoIraiShokai.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.ShujiiIkenshoIraiShokai.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShujiiIkenshoIraiShokai = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgIkenshoIraiIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgIkenshoIraiIchiran"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };
            return Controls;
        })();
        ShujiiIkenshoIraiShokai.Controls = Controls;
    })(DBE.ShujiiIkenshoIraiShokai || (DBE.ShujiiIkenshoIraiShokai = {}));
    var ShujiiIkenshoIraiShokai = DBE.ShujiiIkenshoIraiShokai;
})(DBE || (DBE = {}));
