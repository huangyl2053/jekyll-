var DBZ;
(function (DBZ) {
    (function (NinteiDataTorikomiErrorList) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        NinteiDataTorikomiErrorList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "NinteiDataTorikomiErrorList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.NinteiDataTorikomiErrorList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.NinteiDataTorikomiErrorList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.NinteiDataTorikomiErrorList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgDataTorikomiErrorIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgDataTorikomiErrorIchiran"));
            };
            return Controls;
        })();
        NinteiDataTorikomiErrorList.Controls = Controls;
    })(DBZ.NinteiDataTorikomiErrorList || (DBZ.NinteiDataTorikomiErrorList = {}));
    var NinteiDataTorikomiErrorList = DBZ.NinteiDataTorikomiErrorList;
})(DBZ || (DBZ = {}));
