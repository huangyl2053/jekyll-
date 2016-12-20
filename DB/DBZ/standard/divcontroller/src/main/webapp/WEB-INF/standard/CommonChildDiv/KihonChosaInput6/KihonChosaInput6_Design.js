var DBZ;
(function (DBZ) {
    (function (KihonChosaInput6) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnBack = function () {
                return "onClick_btnBack";
            };

            Events.onClick_btnConfirm = function () {
                return "onClick_btnConfirm";
            };
            return Events;
        })();
        KihonChosaInput6.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KihonChosaInput6";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KihonChosaInput6.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KihonChosaInput6.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KihonChosaInput6 = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ZenkaiHyojiTeiji = function () {
                return new UZA.Label(this.convFiledName("ZenkaiHyojiTeiji"));
            };

            Controls.prototype.TokubetsuIryo = function () {
                return new UZA.Panel(this.convFiledName("TokubetsuIryo"));
            };

            Controls.prototype.ShochiNaiyo = function () {
                return new UZA.Panel(this.convFiledName("ShochiNaiyo"));
            };

            Controls.prototype.btnShochiNaiyo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShochiNaiyo"));
            };

            Controls.prototype.chkShochiNaiyo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkShochiNaiyo"));
            };

            Controls.prototype.TokiTaiou = function () {
                return new UZA.Panel(this.convFiledName("TokiTaiou"));
            };

            Controls.prototype.btnTokiTaiou = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnTokiTaiou"));
            };

            Controls.prototype.chkTokiTaiou = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkTokiTaiou"));
            };

            Controls.prototype.btnBack = function () {
                return new UZA.Button(this.convFiledName("btnBack"));
            };

            Controls.prototype.btnConfirm = function () {
                return new UZA.Button(this.convFiledName("btnConfirm"));
            };
            return Controls;
        })();
        KihonChosaInput6.Controls = Controls;
    })(DBZ.KihonChosaInput6 || (DBZ.KihonChosaInput6 = {}));
    var KihonChosaInput6 = DBZ.KihonChosaInput6;
})(DBZ || (DBZ = {}));
