var DBZ;
(function (DBZ) {
    (function (NinteiShinseiShichosonRenrakuJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnModoru = function () {
                return "onClick_btnModoru";
            };
            return Events;
        })();
        NinteiShinseiShichosonRenrakuJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "NinteiShinseiShichosonRenrakuJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.NinteiShinseiShichosonRenrakuJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.NinteiShinseiShichosonRenrakuJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.NinteiShinseiShichosonRenrakuJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtRenrakujiko = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtRenrakujiko"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };
            return Controls;
        })();
        NinteiShinseiShichosonRenrakuJoho.Controls = Controls;
    })(DBZ.NinteiShinseiShichosonRenrakuJoho || (DBZ.NinteiShinseiShichosonRenrakuJoho = {}));
    var NinteiShinseiShichosonRenrakuJoho = DBZ.NinteiShinseiShichosonRenrakuJoho;
})(DBZ || (DBZ = {}));
