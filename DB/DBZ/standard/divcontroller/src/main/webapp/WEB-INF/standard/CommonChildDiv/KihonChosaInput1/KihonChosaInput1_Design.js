var DBZ;
(function (DBZ) {
    (function (KihonChosaInput1) {
        var Events = (function () {
            function Events() {
            }
            Events.onBeforeOpenDialog_btnMahi = function () {
                return "onBeforeOpenDialog_btnMahi";
            };

            Events.onClick_chkMahiChange = function () {
                return "onClick_chkMahiChange";
            };

            Events.onBeforeOpenDialog_btnKoshuku = function () {
                return "onBeforeOpenDialog_btnKoshuku";
            };

            Events.onClick_chkKoshukuChange = function () {
                return "onClick_chkKoshukuChange";
            };

            Events.onBeforeOpenDialog_btnNeKaeri = function () {
                return "onBeforeOpenDialog_btnNeKaeri";
            };

            Events.onBeforeOpenDialog_btnOkiAgari = function () {
                return "onBeforeOpenDialog_btnOkiAgari";
            };

            Events.onBeforeOpenDialog_btnZai = function () {
                return "onBeforeOpenDialog_btnZai";
            };

            Events.onBeforeOpenDialog_btnRyoAshi = function () {
                return "onBeforeOpenDialog_btnRyoAshi";
            };

            Events.onBeforeOpenDialog_btnBuko = function () {
                return "onBeforeOpenDialog_btnBuko";
            };

            Events.onBeforeOpenDialog_btnTachiAgari = function () {
                return "onBeforeOpenDialog_btnTachiAgari";
            };

            Events.onBeforeOpenDialog_btnKataAshi = function () {
                return "onBeforeOpenDialog_btnKataAshi";
            };

            Events.onBeforeOpenDialog_btnSenshin = function () {
                return "onBeforeOpenDialog_btnSenshin";
            };

            Events.onBeforeOpenDialog_btnTumeKiri = function () {
                return "onBeforeOpenDialog_btnTumeKiri";
            };

            Events.onBeforeOpenDialog_btnShiryoku = function () {
                return "onBeforeOpenDialog_btnShiryoku";
            };

            Events.onBeforeOpenDialog_btnChoryoku = function () {
                return "onBeforeOpenDialog_btnChoryoku";
            };

            Events.onClick_btnConfirm = function () {
                return "onClick_btnConfirm";
            };

            Events.onClick_btnBack = function () {
                return "onClick_btnBack";
            };
            return Events;
        })();
        KihonChosaInput1.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KihonChosaInput1";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KihonChosaInput1.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KihonChosaInput1.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KihonChosaInput1 = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ZenkaiHyojiTeiji = function () {
                return new UZA.Label(this.convFiledName("ZenkaiHyojiTeiji"));
            };

            Controls.prototype.DaiichigunShintaiKino = function () {
                return new UZA.Panel(this.convFiledName("DaiichigunShintaiKino"));
            };

            Controls.prototype.Mahi = function () {
                return new UZA.Panel(this.convFiledName("Mahi"));
            };

            Controls.prototype.btnMahi = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnMahi"));
            };

            Controls.prototype.chkMahi = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkMahi"));
            };

            Controls.prototype.Koshuku = function () {
                return new UZA.Panel(this.convFiledName("Koshuku"));
            };

            Controls.prototype.btnKoshuku = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKoshuku"));
            };

            Controls.prototype.chkKoshuku = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKoshuku"));
            };

            Controls.prototype.NeKaeri = function () {
                return new UZA.Panel(this.convFiledName("NeKaeri"));
            };

            Controls.prototype.btnNeKaeri = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnNeKaeri"));
            };

            Controls.prototype.radNeKaeri = function () {
                return new UZA.RadioButton(this.convFiledName("radNeKaeri"));
            };

            Controls.prototype.OkiAgari = function () {
                return new UZA.Panel(this.convFiledName("OkiAgari"));
            };

            Controls.prototype.btnOkiAgari = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnOkiAgari"));
            };

            Controls.prototype.radOkiAgari = function () {
                return new UZA.RadioButton(this.convFiledName("radOkiAgari"));
            };

            Controls.prototype.Zai = function () {
                return new UZA.Panel(this.convFiledName("Zai"));
            };

            Controls.prototype.btnZai = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnZai"));
            };

            Controls.prototype.radZai = function () {
                return new UZA.RadioButton(this.convFiledName("radZai"));
            };

            Controls.prototype.RyoAshi = function () {
                return new UZA.Panel(this.convFiledName("RyoAshi"));
            };

            Controls.prototype.btnRyoAshi = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnRyoAshi"));
            };

            Controls.prototype.radRyoAshi = function () {
                return new UZA.RadioButton(this.convFiledName("radRyoAshi"));
            };

            Controls.prototype.Buko = function () {
                return new UZA.Panel(this.convFiledName("Buko"));
            };

            Controls.prototype.btnBuko = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnBuko"));
            };

            Controls.prototype.radBuko = function () {
                return new UZA.RadioButton(this.convFiledName("radBuko"));
            };

            Controls.prototype.TachiAgari = function () {
                return new UZA.Panel(this.convFiledName("TachiAgari"));
            };

            Controls.prototype.btnTachiAgari = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnTachiAgari"));
            };

            Controls.prototype.radTachiAgari = function () {
                return new UZA.RadioButton(this.convFiledName("radTachiAgari"));
            };

            Controls.prototype.KataAshi = function () {
                return new UZA.Panel(this.convFiledName("KataAshi"));
            };

            Controls.prototype.btnKataAshi = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKataAshi"));
            };

            Controls.prototype.radKataAshi = function () {
                return new UZA.RadioButton(this.convFiledName("radKataAshi"));
            };

            Controls.prototype.Senshin = function () {
                return new UZA.Panel(this.convFiledName("Senshin"));
            };

            Controls.prototype.btnSenshin = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnSenshin"));
            };

            Controls.prototype.radSenshin = function () {
                return new UZA.RadioButton(this.convFiledName("radSenshin"));
            };

            Controls.prototype.TumeKiri = function () {
                return new UZA.Panel(this.convFiledName("TumeKiri"));
            };

            Controls.prototype.btnTumeKiri = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnTumeKiri"));
            };

            Controls.prototype.radTumeKiri = function () {
                return new UZA.RadioButton(this.convFiledName("radTumeKiri"));
            };

            Controls.prototype.Shiryoku = function () {
                return new UZA.Panel(this.convFiledName("Shiryoku"));
            };

            Controls.prototype.btnShiryoku = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShiryoku"));
            };

            Controls.prototype.radShiryoku = function () {
                return new UZA.RadioButton(this.convFiledName("radShiryoku"));
            };

            Controls.prototype.Choryoku = function () {
                return new UZA.Panel(this.convFiledName("Choryoku"));
            };

            Controls.prototype.btnChoryoku = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnChoryoku"));
            };

            Controls.prototype.radChoryoku = function () {
                return new UZA.RadioButton(this.convFiledName("radChoryoku"));
            };

            Controls.prototype.btnConfirm = function () {
                return new UZA.Button(this.convFiledName("btnConfirm"));
            };

            Controls.prototype.btnBack = function () {
                return new UZA.Button(this.convFiledName("btnBack"));
            };
            return Controls;
        })();
        KihonChosaInput1.Controls = Controls;
    })(DBZ.KihonChosaInput1 || (DBZ.KihonChosaInput1 = {}));
    var KihonChosaInput1 = DBZ.KihonChosaInput1;
})(DBZ || (DBZ = {}));
