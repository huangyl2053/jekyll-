var DBZ;
(function (DBZ) {
    (function (KihonChosaInput6) {
        var Events = (function () {
            function Events() {
            }
            Events.onBeforeOpenDialog_btnTenteki = function () {
                return "onBeforeOpenDialog_btnTenteki";
            };

            Events.onBeforeOpenDialog_btnSeimyaku = function () {
                return "onBeforeOpenDialog_btnSeimyaku";
            };

            Events.onBeforeOpenDialog_btnTouseki = function () {
                return "onBeforeOpenDialog_btnTouseki";
            };

            Events.onBeforeOpenDialog_btnSutoma = function () {
                return "onBeforeOpenDialog_btnSutoma";
            };

            Events.onBeforeOpenDialog_btnSansou = function () {
                return "onBeforeOpenDialog_btnSansou";
            };

            Events.onBeforeOpenDialog_btnResupireta = function () {
                return "onBeforeOpenDialog_btnResupireta";
            };

            Events.onBeforeOpenDialog_btnKikan = function () {
                return "onBeforeOpenDialog_btnKikan";
            };

            Events.onBeforeOpenDialog_btnToutsu = function () {
                return "onBeforeOpenDialog_btnToutsu";
            };

            Events.onBeforeOpenDialog_btnKeikan = function () {
                return "onBeforeOpenDialog_btnKeikan";
            };

            Events.onBeforeOpenDialog_btnMonita = function () {
                return "onBeforeOpenDialog_btnMonita";
            };

            Events.onBeforeOpenDialog_btnJyokuso = function () {
                return "onBeforeOpenDialog_btnJyokuso";
            };

            Events.onBeforeOpenDialog_btnKateru = function () {
                return "onBeforeOpenDialog_btnKateru";
            };

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

            Controls.prototype.btnTenteki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnTenteki"));
            };

            Controls.prototype.chkTenteki = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkTenteki"));
            };

            Controls.prototype.btnSeimyaku = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnSeimyaku"));
            };

            Controls.prototype.chkSeimyaku = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSeimyaku"));
            };

            Controls.prototype.btnTouseki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnTouseki"));
            };

            Controls.prototype.chkTouseki = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkTouseki"));
            };

            Controls.prototype.btnSutoma = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnSutoma"));
            };

            Controls.prototype.chkSutoma = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSutoma"));
            };

            Controls.prototype.btnSansou = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnSansou"));
            };

            Controls.prototype.chkSansou = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSansou"));
            };

            Controls.prototype.btnResupireta = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnResupireta"));
            };

            Controls.prototype.chkResupireta = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkResupireta"));
            };

            Controls.prototype.btnKikan = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKikan"));
            };

            Controls.prototype.chkKikan = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKikan"));
            };

            Controls.prototype.btnToutsu = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnToutsu"));
            };

            Controls.prototype.chkToutsu = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkToutsu"));
            };

            Controls.prototype.btnKeikan = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnKeikan"));
            };

            Controls.prototype.chkKeikan = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKeikan"));
            };

            Controls.prototype.TokiTaiou = function () {
                return new UZA.Panel(this.convFiledName("TokiTaiou"));
            };

            Controls.prototype.btnMonita = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnMonita"));
            };

            Controls.prototype.chkMonita = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkMonita"));
            };

            Controls.prototype.btnJyokuso = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnJyokuso"));
            };

            Controls.prototype.chkJyokuso = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkJyokuso"));
            };

            Controls.prototype.btnbtnKateru = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnbtnKateru"));
            };

            Controls.prototype.chkKateru = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKateru"));
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
