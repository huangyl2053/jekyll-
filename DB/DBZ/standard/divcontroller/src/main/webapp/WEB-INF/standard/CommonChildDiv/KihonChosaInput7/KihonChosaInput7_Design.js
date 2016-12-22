var DBZ;
(function (DBZ) {
    (function (KihonChosaInput7) {
        var Events = (function () {
            function Events() {
            }
            Events.onBeforeOpenDialog_btnShogaiKoreisha = function () {
                return "onBeforeOpenDialog_btnShogaiKoreisha";
            };

            Events.onBeforeOpenDialog_btnNinchishaJiritsudo = function () {
                return "onBeforeOpenDialog_btnNinchishaJiritsudo";
            };

            Events.onClick_btnBack = function () {
                return "onClick_btnBack";
            };

            Events.onClick_btnConfirm = function () {
                return "onClick_btnConfirm";
            };
            return Events;
        })();
        KihonChosaInput7.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KihonChosaInput7";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KihonChosaInput7.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KihonChosaInput7.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KihonChosaInput7 = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ZenkaiHyojiTeiji = function () {
                return new UZA.Label(this.convFiledName("ZenkaiHyojiTeiji"));
            };

            Controls.prototype.Jiritsudo = function () {
                return new UZA.Panel(this.convFiledName("Jiritsudo"));
            };

            Controls.prototype.ShogaiKoreisha = function () {
                return new UZA.Panel(this.convFiledName("ShogaiKoreisha"));
            };

            Controls.prototype.btnShogaiKoreisha = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShogaiKoreisha"));
            };

            Controls.prototype.radShogaiKoreisha = function () {
                return new UZA.RadioButton(this.convFiledName("radShogaiKoreisha"));
            };

            Controls.prototype.NinchishaJiritsudo = function () {
                return new UZA.Panel(this.convFiledName("NinchishaJiritsudo"));
            };

            Controls.prototype.btnNinchishaJiritsudo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnNinchishaJiritsudo"));
            };

            Controls.prototype.radNinchishaJiritsudo = function () {
                return new UZA.RadioButton(this.convFiledName("radNinchishaJiritsudo"));
            };

            Controls.prototype.btnBack = function () {
                return new UZA.Button(this.convFiledName("btnBack"));
            };

            Controls.prototype.btnConfirm = function () {
                return new UZA.Button(this.convFiledName("btnConfirm"));
            };
            return Controls;
        })();
        KihonChosaInput7.Controls = Controls;
    })(DBZ.KihonChosaInput7 || (DBZ.KihonChosaInput7 = {}));
    var KihonChosaInput7 = DBZ.KihonChosaInput7;
})(DBZ || (DBZ = {}));
