var DBZ;
(function (DBZ) {
    (function (ShichosonSelector) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnReturn = function () {
                return "onClick_btnReturn";
            };

            Events.onClick_btnDecision = function () {
                return "onClick_btnDecision";
            };
            return Events;
        })();
        ShichosonSelector.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShichosonSelector";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShichosonSelector.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShichosonSelector.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShichosonSelector = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgShichoson = function () {
                return new UZA.DataGrid(this.convFiledName("dgShichoson"));
            };

            Controls.prototype.btnReturn = function () {
                return new UZA.Button(this.convFiledName("btnReturn"));
            };

            Controls.prototype.btnDecision = function () {
                return new UZA.Button(this.convFiledName("btnDecision"));
            };
            return Controls;
        })();
        ShichosonSelector.Controls = Controls;
    })(DBZ.ShichosonSelector || (DBZ.ShichosonSelector = {}));
    var ShichosonSelector = DBZ.ShichosonSelector;
})(DBZ || (DBZ = {}));
