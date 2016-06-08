var DBZ;
(function (DBZ) {
    (function (NinteiShinseiShichosonRenrakuJiko) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnKakutei = function () {
                return "onClick_btnKakutei";
            };

            Events.onClick_btnTorikeshi = function () {
                return "onClick_btnTorikeshi";
            };
            return Events;
        })();
        NinteiShinseiShichosonRenrakuJiko.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "NinteiShinseiShichosonRenrakuJiko";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.NinteiShinseiShichosonRenrakuJiko.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.NinteiShinseiShichosonRenrakuJiko.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.NinteiShinseiShichosonRenrakuJiko = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtRenrakujiko = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtRenrakujiko"));
            };

            Controls.prototype.btnToroku = function () {
                return new UZA.Button(this.convFiledName("btnToroku"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };
            return Controls;
        })();
        NinteiShinseiShichosonRenrakuJiko.Controls = Controls;
    })(DBZ.NinteiShinseiShichosonRenrakuJiko || (DBZ.NinteiShinseiShichosonRenrakuJiko = {}));
    var NinteiShinseiShichosonRenrakuJiko = DBZ.NinteiShinseiShichosonRenrakuJiko;
})(DBZ || (DBZ = {}));
