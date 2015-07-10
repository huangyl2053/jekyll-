var DBZ;
(function (DBZ) {
    (function (KaigoBunshoNoMaintenance) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoBunshoNoMaintenance.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoBunshoNoMaintenance";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoBunshoNoMaintenance.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoBunshoNoMaintenance.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoBunshoNoMaintenance = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };
            return Controls;
        })();
        KaigoBunshoNoMaintenance.Controls = Controls;
    })(DBZ.KaigoBunshoNoMaintenance || (DBZ.KaigoBunshoNoMaintenance = {}));
    var KaigoBunshoNoMaintenance = DBZ.KaigoBunshoNoMaintenance;
})(DBZ || (DBZ = {}));
