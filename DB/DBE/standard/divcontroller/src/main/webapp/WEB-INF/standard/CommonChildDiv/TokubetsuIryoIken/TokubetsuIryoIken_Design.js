var DBE;
(function (DBE) {
    (function (TokubetsuIryoIken) {
        var Events = (function () {
            function Events() {
            }
            Events.btnCancel = function () {
                return "btnCancel";
            };

            Events.btnKakutei = function () {
                return "btnKakutei";
            };
            return Events;
        })();
        TokubetsuIryoIken.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "TokubetsuIryoIken";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.TokubetsuIryoIken.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.TokubetsuIryoIken.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.TokubetsuIryoIken = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.chkTokubetsuIryo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkTokubetsuIryo"));
            };

            Controls.prototype.chkTokubetsuTaiou = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkTokubetsuTaiou"));
            };

            Controls.prototype.chkShikkinTaio = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkShikkinTaio"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };

            Controls.prototype.btnKakutei = function () {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            };
            return Controls;
        })();
        TokubetsuIryoIken.Controls = Controls;
    })(DBE.TokubetsuIryoIken || (DBE.TokubetsuIryoIken = {}));
    var TokubetsuIryoIken = DBE.TokubetsuIryoIken;
})(DBE || (DBE = {}));
