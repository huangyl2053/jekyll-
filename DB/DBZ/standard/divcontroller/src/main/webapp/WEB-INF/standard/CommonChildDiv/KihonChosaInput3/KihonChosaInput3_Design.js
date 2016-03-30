var DBZ;
(function (DBZ) {
    (function (KihonChosaInput3) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnOpenDialog = function () {
                return "onClick_btnOpenDialog";
            };

            Events.onClick_btnConfirm = function () {
                return "onClick_btnConfirm";
            };

            Events.onClick_btnBack = function () {
                return "onClick_btnBack";
            };
            return Events;
        })();
        KihonChosaInput3.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KihonChosaInput3";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KihonChosaInput3.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KihonChosaInput3.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KihonChosaInput3 = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ZenkaiHyojiTeiji = function () {
                return new UZA.Label(this.convFiledName("ZenkaiHyojiTeiji"));
            };

            Controls.prototype.NinchiKinou = function () {
                return new UZA.Panel(this.convFiledName("NinchiKinou"));
            };

            Controls.prototype.IshiDentatsu = function () {
                return new UZA.Panel(this.convFiledName("IshiDentatsu"));
            };

            Controls.prototype.btnIshiDentatsu = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnIshiDentatsu"));
            };

            Controls.prototype.radIshiDentatsu = function () {
                return new UZA.RadioButton(this.convFiledName("radIshiDentatsu"));
            };

            Controls.prototype.Nikka = function () {
                return new UZA.Panel(this.convFiledName("Nikka"));
            };

            Controls.prototype.btnNikka = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnNikka"));
            };

            Controls.prototype.radNikka = function () {
                return new UZA.RadioButton(this.convFiledName("radNikka"));
            };

            Controls.prototype.Info = function () {
                return new UZA.Panel(this.convFiledName("Info"));
            };

            Controls.prototype.btnInfo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnInfo"));
            };

            Controls.prototype.radInfo = function () {
                return new UZA.RadioButton(this.convFiledName("radInfo"));
            };

            Controls.prototype.DankiKioku = function () {
                return new UZA.Panel(this.convFiledName("DankiKioku"));
            };

            Controls.prototype.btnDankiKioku = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnDankiKioku"));
            };

            Controls.prototype.radDankiKioku = function () {
                return new UZA.RadioButton(this.convFiledName("radDankiKioku"));
            };

            Controls.prototype.NameInfo = function () {
                return new UZA.Panel(this.convFiledName("NameInfo"));
            };

            Controls.prototype.btnNameInfo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnNameInfo"));
            };

            Controls.prototype.radNameInfo = function () {
                return new UZA.RadioButton(this.convFiledName("radNameInfo"));
            };

            Controls.prototype.Kisetsu = function () {
                return new UZA.Panel(this.convFiledName("Kisetsu"));
            };

            Controls.prototype.btnKisetsu = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKisetsu"));
            };

            Controls.prototype.radKisetsu = function () {
                return new UZA.RadioButton(this.convFiledName("radKisetsu"));
            };

            Controls.prototype.Basho = function () {
                return new UZA.Panel(this.convFiledName("Basho"));
            };

            Controls.prototype.btnBasho = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnBasho"));
            };

            Controls.prototype.radBasho = function () {
                return new UZA.RadioButton(this.convFiledName("radBasho"));
            };

            Controls.prototype.Haikai = function () {
                return new UZA.Panel(this.convFiledName("Haikai"));
            };

            Controls.prototype.btnHaikai = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHaikai"));
            };

            Controls.prototype.radHaikai = function () {
                return new UZA.RadioButton(this.convFiledName("radHaikai"));
            };

            Controls.prototype.Modoru = function () {
                return new UZA.Panel(this.convFiledName("Modoru"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnModoru"));
            };

            Controls.prototype.radModoru = function () {
                return new UZA.RadioButton(this.convFiledName("radModoru"));
            };

            Controls.prototype.btnConfirm = function () {
                return new UZA.Button(this.convFiledName("btnConfirm"));
            };

            Controls.prototype.btnBack = function () {
                return new UZA.Button(this.convFiledName("btnBack"));
            };
            return Controls;
        })();
        KihonChosaInput3.Controls = Controls;
    })(DBZ.KihonChosaInput3 || (DBZ.KihonChosaInput3 = {}));
    var KihonChosaInput3 = DBZ.KihonChosaInput3;
})(DBZ || (DBZ = {}));
