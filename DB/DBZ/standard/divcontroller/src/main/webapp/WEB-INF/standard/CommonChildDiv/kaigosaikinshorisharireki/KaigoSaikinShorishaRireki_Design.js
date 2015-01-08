var DBZ;
(function (DBZ) {
    (function (KaigoSaikinShorishaRireki) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnKaigoSaikinShorishaHyoji = function () {
                return "onClick_btnKaigoSaikinShorishaHyoji";
            };
            return Events;
        })();
        KaigoSaikinShorishaRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoSaikinShorishaRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoSaikinShorishaRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoSaikinShorishaRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoSaikinShorishaRireki = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnKaigoSaikinShorishaHyoji = function () {
                return new UZA.Button(this.convFiledName("btnKaigoSaikinShorishaHyoji"));
            };
            return Controls;
        })();
        KaigoSaikinShorishaRireki.Controls = Controls;
    })(DBZ.KaigoSaikinShorishaRireki || (DBZ.KaigoSaikinShorishaRireki = {}));
    var KaigoSaikinShorishaRireki = DBZ.KaigoSaikinShorishaRireki;
})(DBZ || (DBZ = {}));
