var DBZ;
(function (DBZ) {
    (function (KihonChosaInput4) {
        var Events = (function () {
            function Events() {
            }
            Events.onBeforeOpenDialog_btnHiryaku = function () {
                return "onBeforeOpenDialog_btnHiryaku";
            };

            Events.onBeforeOpenDialog_btnTukuriHanashi = function () {
                return "onBeforeOpenDialog_btnTukuriHanashi";
            };

            Events.onBeforeOpenDialog_btnKanjyo = function () {
                return "onBeforeOpenDialog_btnKanjyo";
            };

            Events.onBeforeOpenDialog_btnChuyaku = function () {
                return "onBeforeOpenDialog_btnChuyaku";
            };

            Events.onBeforeOpenDialog_btnOnajiHanashi = function () {
                return "onBeforeOpenDialog_btnOnajiHanashi";
            };

            Events.onBeforeOpenDialog_btnBigVoice = function () {
                return "onBeforeOpenDialog_btnBigVoice";
            };

            Events.onBeforeOpenDialog_btnTeikou = function () {
                return "onBeforeOpenDialog_btnTeikou";
            };

            Events.onBeforeOpenDialog_btnOchituki = function () {
                return "onBeforeOpenDialog_btnOchituki";
            };

            Events.onBeforeOpenDialog_btnOutLonly = function () {
                return "onBeforeOpenDialog_btnOutLonly";
            };

            Events.onBeforeOpenDialog_btnShushu = function () {
                return "onBeforeOpenDialog_btnShushu";
            };

            Events.onBeforeOpenDialog_btnKowasu = function () {
                return "onBeforeOpenDialog_btnKowasu";
            };

            Events.onBeforeOpenDialog_btnMonoWasure = function () {
                return "onBeforeOpenDialog_btnMonoWasure";
            };

            Events.onBeforeOpenDialog_btnHitoriWarai = function () {
                return "onBeforeOpenDialog_btnHitoriWarai";
            };

            Events.onBeforeOpenDialog_btnKateKodo = function () {
                return "onBeforeOpenDialog_btnKateKodo";
            };

            Events.onBeforeOpenDialog_btnMatomeNai = function () {
                return "onBeforeOpenDialog_btnMatomeNai";
            };

            Events.onClick_btnBack = function () {
                return "onClick_btnBack";
            };

            Events.onClick_btnConfirm = function () {
                return "onClick_btnConfirm";
            };
            return Events;
        })();
        KihonChosaInput4.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KihonChosaInput4";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KihonChosaInput4.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KihonChosaInput4.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KihonChosaInput4 = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ZenkaiHyojiTeiji = function () {
                return new UZA.Label(this.convFiledName("ZenkaiHyojiTeiji"));
            };

            Controls.prototype.KoudoShogai = function () {
                return new UZA.Panel(this.convFiledName("KoudoShogai"));
            };

            Controls.prototype.Hiryaku = function () {
                return new UZA.Panel(this.convFiledName("Hiryaku"));
            };

            Controls.prototype.btnHiryaku = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHiryaku"));
            };

            Controls.prototype.radbtnHiryaku = function () {
                return new UZA.RadioButton(this.convFiledName("radbtnHiryaku"));
            };

            Controls.prototype.TukuriHanashi = function () {
                return new UZA.Panel(this.convFiledName("TukuriHanashi"));
            };

            Controls.prototype.btnTukuriHanashi = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnTukuriHanashi"));
            };

            Controls.prototype.radTukuriHanashi = function () {
                return new UZA.RadioButton(this.convFiledName("radTukuriHanashi"));
            };

            Controls.prototype.Kanjyo = function () {
                return new UZA.Panel(this.convFiledName("Kanjyo"));
            };

            Controls.prototype.btnKanjyo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKanjyo"));
            };

            Controls.prototype.radKanjyo = function () {
                return new UZA.RadioButton(this.convFiledName("radKanjyo"));
            };

            Controls.prototype.Chuyaku = function () {
                return new UZA.Panel(this.convFiledName("Chuyaku"));
            };

            Controls.prototype.btnChuyaku = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnChuyaku"));
            };

            Controls.prototype.radChuyaku = function () {
                return new UZA.RadioButton(this.convFiledName("radChuyaku"));
            };

            Controls.prototype.OnajiHanashi = function () {
                return new UZA.Panel(this.convFiledName("OnajiHanashi"));
            };

            Controls.prototype.btnOnajiHanashi = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnOnajiHanashi"));
            };

            Controls.prototype.radOnajiHanashi = function () {
                return new UZA.RadioButton(this.convFiledName("radOnajiHanashi"));
            };

            Controls.prototype.BigVoice = function () {
                return new UZA.Panel(this.convFiledName("BigVoice"));
            };

            Controls.prototype.btnBigVoice = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnBigVoice"));
            };

            Controls.prototype.radBigVoice = function () {
                return new UZA.RadioButton(this.convFiledName("radBigVoice"));
            };

            Controls.prototype.Teikou = function () {
                return new UZA.Panel(this.convFiledName("Teikou"));
            };

            Controls.prototype.btnTeikou = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnTeikou"));
            };

            Controls.prototype.radTeikou = function () {
                return new UZA.RadioButton(this.convFiledName("radTeikou"));
            };

            Controls.prototype.Ochituki = function () {
                return new UZA.Panel(this.convFiledName("Ochituki"));
            };

            Controls.prototype.btnOchituki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnOchituki"));
            };

            Controls.prototype.radOchituki = function () {
                return new UZA.RadioButton(this.convFiledName("radOchituki"));
            };

            Controls.prototype.OutLonly = function () {
                return new UZA.Panel(this.convFiledName("OutLonly"));
            };

            Controls.prototype.btnOutLonly = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnOutLonly"));
            };

            Controls.prototype.radOutLonly = function () {
                return new UZA.RadioButton(this.convFiledName("radOutLonly"));
            };

            Controls.prototype.Shushu = function () {
                return new UZA.Panel(this.convFiledName("Shushu"));
            };

            Controls.prototype.btnShushu = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnShushu"));
            };

            Controls.prototype.radShushu = function () {
                return new UZA.RadioButton(this.convFiledName("radShushu"));
            };

            Controls.prototype.Kowasu = function () {
                return new UZA.Panel(this.convFiledName("Kowasu"));
            };

            Controls.prototype.btnKowasu = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKowasu"));
            };

            Controls.prototype.radKowasu = function () {
                return new UZA.RadioButton(this.convFiledName("radKowasu"));
            };

            Controls.prototype.MonoWasure = function () {
                return new UZA.Panel(this.convFiledName("MonoWasure"));
            };

            Controls.prototype.btnMonoWasure = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnMonoWasure"));
            };

            Controls.prototype.radMonoWasure = function () {
                return new UZA.RadioButton(this.convFiledName("radMonoWasure"));
            };

            Controls.prototype.HitoriWarai = function () {
                return new UZA.Panel(this.convFiledName("HitoriWarai"));
            };

            Controls.prototype.btnHitoriWarai = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHitoriWarai"));
            };

            Controls.prototype.radHitoriWarai = function () {
                return new UZA.RadioButton(this.convFiledName("radHitoriWarai"));
            };

            Controls.prototype.KateKodo = function () {
                return new UZA.Panel(this.convFiledName("KateKodo"));
            };

            Controls.prototype.btnKateKodo = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKateKodo"));
            };

            Controls.prototype.radKateKodo = function () {
                return new UZA.RadioButton(this.convFiledName("radKateKodo"));
            };

            Controls.prototype.MatomeNai = function () {
                return new UZA.Panel(this.convFiledName("MatomeNai"));
            };

            Controls.prototype.btnMatomeNai = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnMatomeNai"));
            };

            Controls.prototype.radMatomeNai = function () {
                return new UZA.RadioButton(this.convFiledName("radMatomeNai"));
            };

            Controls.prototype.btnBack = function () {
                return new UZA.Button(this.convFiledName("btnBack"));
            };

            Controls.prototype.btnConfirm = function () {
                return new UZA.Button(this.convFiledName("btnConfirm"));
            };
            return Controls;
        })();
        KihonChosaInput4.Controls = Controls;
    })(DBZ.KihonChosaInput4 || (DBZ.KihonChosaInput4 = {}));
    var KihonChosaInput4 = DBZ.KihonChosaInput4;
})(DBZ || (DBZ = {}));
