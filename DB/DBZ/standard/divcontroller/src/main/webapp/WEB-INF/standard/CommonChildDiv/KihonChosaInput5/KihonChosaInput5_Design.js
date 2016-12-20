var DBZ;
(function (DBZ) {
    (function (KihonChosaInput5) {
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
        KihonChosaInput5.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KihonChosaInput5";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KihonChosaInput5.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KihonChosaInput5.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KihonChosaInput5 = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ZenkaiHyojiTeiji = function () {
                return new UZA.Label(this.convFiledName("ZenkaiHyojiTeiji"));
            };

            Controls.prototype.ShakaiSekatsu = function () {
                return new UZA.Panel(this.convFiledName("ShakaiSekatsu"));
            };

            Controls.prototype.Kusuri = function () {
                return new UZA.Panel(this.convFiledName("Kusuri"));
            };

            Controls.prototype.btnKusuri = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKusuri"));
            };

            Controls.prototype.radKusuri = function () {
                return new UZA.RadioButton(this.convFiledName("radKusuri"));
            };

            Controls.prototype.KingakuKanri = function () {
                return new UZA.Panel(this.convFiledName("KingakuKanri"));
            };

            Controls.prototype.btnKingakuKanri = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKingakuKanri"));
            };

            Controls.prototype.radKingakuKanri = function () {
                return new UZA.RadioButton(this.convFiledName("radKingakuKanri"));
            };

            Controls.prototype.IshiKetei = function () {
                return new UZA.Panel(this.convFiledName("IshiKetei"));
            };

            Controls.prototype.btnIshiKetei = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnIshiKetei"));
            };

            Controls.prototype.radIshiKetei = function () {
                return new UZA.RadioButton(this.convFiledName("radIshiKetei"));
            };

            Controls.prototype.Shudan = function () {
                return new UZA.Panel(this.convFiledName("Shudan"));
            };

            Controls.prototype.btnShudan = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShudan"));
            };

            Controls.prototype.radShudan = function () {
                return new UZA.RadioButton(this.convFiledName("radShudan"));
            };

            Controls.prototype.KaiMono = function () {
                return new UZA.Panel(this.convFiledName("KaiMono"));
            };

            Controls.prototype.btnKaiMono = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKaiMono"));
            };

            Controls.prototype.radKaiMono = function () {
                return new UZA.RadioButton(this.convFiledName("radKaiMono"));
            };

            Controls.prototype.KantanChori = function () {
                return new UZA.Panel(this.convFiledName("KantanChori"));
            };

            Controls.prototype.btnKantanChori = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKantanChori"));
            };

            Controls.prototype.radKantanChori = function () {
                return new UZA.RadioButton(this.convFiledName("radKantanChori"));
            };

            Controls.prototype.btnBack = function () {
                return new UZA.Button(this.convFiledName("btnBack"));
            };

            Controls.prototype.btnConfirm = function () {
                return new UZA.Button(this.convFiledName("btnConfirm"));
            };
            return Controls;
        })();
        KihonChosaInput5.Controls = Controls;
    })(DBZ.KihonChosaInput5 || (DBZ.KihonChosaInput5 = {}));
    var KihonChosaInput5 = DBZ.KihonChosaInput5;
})(DBZ || (DBZ = {}));
