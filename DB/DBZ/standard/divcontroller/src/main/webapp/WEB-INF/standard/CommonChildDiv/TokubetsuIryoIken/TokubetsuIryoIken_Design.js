var DBZ;
(function (DBZ) {
    (function (TokubetsuIryoIken) {
        var Events = (function () {
            function Events() {
            }
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
                return this._myName + "_" + DBZ.TokubetsuIryoIken.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.TokubetsuIryoIken.Controls.myType() + "_" + fieldName;
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

            Controls.prototype.btnBack = function () {
                return new UZA.Button(this.convFiledName("btnBack"));
            };

            Controls.prototype.btnKoshin = function () {
                return new UZA.Button(this.convFiledName("btnKoshin"));
            };
            return Controls;
        })();
        TokubetsuIryoIken.Controls = Controls;
    })(DBZ.TokubetsuIryoIken || (DBZ.TokubetsuIryoIken = {}));
    var TokubetsuIryoIken = DBZ.TokubetsuIryoIken;
})(DBZ || (DBZ = {}));
