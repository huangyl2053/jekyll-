var DBZ;
(function (DBZ) {
    (function (KaigoTuchishoTeikeiBunMaintenance) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoTuchishoTeikeiBunMaintenance.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoTuchishoTeikeiBunMaintenance";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoTuchishoTeikeiBunMaintenance.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoTuchishoTeikeiBunMaintenance.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoTuchishoTeikeiBunMaintenance = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtBunsho = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtBunsho"));
            };
            return Controls;
        })();
        KaigoTuchishoTeikeiBunMaintenance.Controls = Controls;
    })(DBZ.KaigoTuchishoTeikeiBunMaintenance || (DBZ.KaigoTuchishoTeikeiBunMaintenance = {}));
    var KaigoTuchishoTeikeiBunMaintenance = DBZ.KaigoTuchishoTeikeiBunMaintenance;
})(DBZ || (DBZ = {}));
