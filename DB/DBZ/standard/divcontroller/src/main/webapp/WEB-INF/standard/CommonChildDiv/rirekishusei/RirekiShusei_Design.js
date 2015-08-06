var DBZ;
(function (DBZ) {
    (function (RirekiShusei) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        RirekiShusei.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "RirekiShusei";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.RirekiShusei.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.RirekiShusei.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.RirekiShusei = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnChosaJokyo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnChosaJokyo"));
            };

            Controls.prototype.btnOK = function () {
                return new UZA.Button(this.convFiledName("btnOK"));
            };

            Controls.prototype.btnCansel = function () {
                return new UZA.Button(this.convFiledName("btnCansel"));
            };
            return Controls;
        })();
        RirekiShusei.Controls = Controls;
    })(DBZ.RirekiShusei || (DBZ.RirekiShusei = {}));
    var RirekiShusei = DBZ.RirekiShusei;
})(DBZ || (DBZ = {}));
