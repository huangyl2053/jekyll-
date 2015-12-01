var DBA;
(function (DBA) {
    (function (ShichosonSelector) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_radShichosonKubun = function () {
                return "onClick_radShichosonKubun";
            };

            Events.onClick_modoru = function () {
                return "onClick_modoru";
            };

            Events.onClick_sentaku = function () {
                return "onClick_sentaku";
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
                return this._myName + "_" + DBA.ShichosonSelector.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBA.ShichosonSelector.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShichosonSelector = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.radShichosonKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radShichosonKubun"));
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
    })(DBA.ShichosonSelector || (DBA.ShichosonSelector = {}));
    var ShichosonSelector = DBA.ShichosonSelector;
})(DBA || (DBA = {}));
