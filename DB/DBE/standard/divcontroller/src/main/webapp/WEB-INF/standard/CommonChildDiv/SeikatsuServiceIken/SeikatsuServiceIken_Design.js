var DBE;
(function (DBE) {
    (function (SeikatsuServiceIken) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_radGenzaiEiyoJotai = function () {
                return "onChange_radGenzaiEiyoJotai";
            };

            Events.onChange_chkJotaiSonota = function () {
                return "onChange_chkJotaiSonota";
            };

            Events.onChange_chkSonotaIryoService = function () {
                return "onChange_chkSonotaIryoService";
            };

            Events.onChange_radKetsuatsu = function () {
                return "onChange_radKetsuatsu";
            };

            Events.onChange_radIdo = function () {
                return "onChange_radIdo";
            };

            Events.onChange_radSesshoku = function () {
                return "onChange_radSesshoku";
            };

            Events.onChange_radUndo = function () {
                return "onChange_radUndo";
            };

            Events.onChange_radEnka = function () {
                return "onChange_radEnka";
            };

            Events.onChange_radKansenshoUmu = function () {
                return "onChange_radKansenshoUmu";
            };

            Events.onClick_btnCancel = function () {
                return "onClick_btnCancel";
            };

            Events.onClick_btnKakutei = function () {
                return "onClick_btnKakutei";
            };
            return Events;
        })();
        SeikatsuServiceIken.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SeikatsuServiceIken";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.SeikatsuServiceIken.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.SeikatsuServiceIken.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SeikatsuServiceIken = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.Ido = function () {
                return new UZA.Panel(this.convFiledName("Ido"));
            };

            Controls.prototype.radOkugaiHokou = function () {
                return new UZA.RadioButton(this.convFiledName("radOkugaiHokou"));
            };

            Controls.prototype.radKurumaisuShiyo = function () {
                return new UZA.RadioButton(this.convFiledName("radKurumaisuShiyo"));
            };

            Controls.prototype.chkHokohojoShiyo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkHokohojoShiyo"));
            };

            Controls.prototype.EiyoShokuseikatsu = function () {
                return new UZA.Panel(this.convFiledName("EiyoShokuseikatsu"));
            };

            Controls.prototype.radShokujiKoi = function () {
                return new UZA.RadioButton(this.convFiledName("radShokujiKoi"));
            };

            Controls.prototype.radGenzaiEiyoJotai = function () {
                return new UZA.RadioButton(this.convFiledName("radGenzaiEiyoJotai"));
            };

            Controls.prototype.txtEiyoShokuseikatsuRyuiten = function () {
                return new UZA.TextBox(this.convFiledName("txtEiyoShokuseikatsuRyuiten"));
            };

            Controls.prototype.HasseiJotaiTaishoHoshin = function () {
                return new UZA.Panel(this.convFiledName("HasseiJotaiTaishoHoshin"));
            };

            Controls.prototype.chkHasseiShojo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkHasseiShojo"));
            };

            Controls.prototype.chkJotaiSonota = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkJotaiSonota"));
            };

            Controls.prototype.txtSonotaJotaiShosai = function () {
                return new UZA.TextBox(this.convFiledName("txtSonotaJotaiShosai"));
            };

            Controls.prototype.txtTaishoHoushin = function () {
                return new UZA.TextBox(this.convFiledName("txtTaishoHoushin"));
            };

            Controls.prototype.SeikatsuKinoMitoshi = function () {
                return new UZA.Panel(this.convFiledName("SeikatsuKinoMitoshi"));
            };

            Controls.prototype.radSeikatsuKinoMitoshi = function () {
                return new UZA.RadioButton(this.convFiledName("radSeikatsuKinoMitoshi"));
            };

            Controls.prototype.IgakutekiKanriHitsuyosei = function () {
                return new UZA.Panel(this.convFiledName("IgakutekiKanriHitsuyosei"));
            };

            Controls.prototype.chkIgakutekiKanri = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkIgakutekiKanri"));
            };

            Controls.prototype.chkSonotaIryoService = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSonotaIryoService"));
            };

            Controls.prototype.txtShonotaIryoServiceShosai = function () {
                return new UZA.TextBox(this.convFiledName("txtShonotaIryoServiceShosai"));
            };

            Controls.prototype.chkSonotaIryoServiceHitsuyoSei = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSonotaIryoServiceHitsuyoSei"));
            };

            Controls.prototype.IgakutekiKantenRyuiten = function () {
                return new UZA.Panel(this.convFiledName("IgakutekiKantenRyuiten"));
            };

            Controls.prototype.radKetsuatsu = function () {
                return new UZA.RadioButton(this.convFiledName("radKetsuatsu"));
            };

            Controls.prototype.txtKetsuatsu = function () {
                return new UZA.TextBox(this.convFiledName("txtKetsuatsu"));
            };

            Controls.prototype.radIdo = function () {
                return new UZA.RadioButton(this.convFiledName("radIdo"));
            };

            Controls.prototype.txtIdo = function () {
                return new UZA.TextBox(this.convFiledName("txtIdo"));
            };

            Controls.prototype.radSesshoku = function () {
                return new UZA.RadioButton(this.convFiledName("radSesshoku"));
            };

            Controls.prototype.txtSesshoku = function () {
                return new UZA.TextBox(this.convFiledName("txtSesshoku"));
            };

            Controls.prototype.radUndo = function () {
                return new UZA.RadioButton(this.convFiledName("radUndo"));
            };

            Controls.prototype.txtUndo = function () {
                return new UZA.TextBox(this.convFiledName("txtUndo"));
            };

            Controls.prototype.radEnka = function () {
                return new UZA.RadioButton(this.convFiledName("radEnka"));
            };

            Controls.prototype.txtEnka = function () {
                return new UZA.TextBox(this.convFiledName("txtEnka"));
            };

            Controls.prototype.txtSonotaRyuiJiko = function () {
                return new UZA.TextBox(this.convFiledName("txtSonotaRyuiJiko"));
            };

            Controls.prototype.KansenshoUmu = function () {
                return new UZA.Panel(this.convFiledName("KansenshoUmu"));
            };

            Controls.prototype.radKansenshoUmu = function () {
                return new UZA.RadioButton(this.convFiledName("radKansenshoUmu"));
            };

            Controls.prototype.spSpace1 = function () {
                return new UZA.Space(this.convFiledName("spSpace1"));
            };

            Controls.prototype.txtKansenshoShosai = function () {
                return new UZA.TextBox(this.convFiledName("txtKansenshoShosai"));
            };

            Controls.prototype.btnCancel = function () {
                return new UZA.Button(this.convFiledName("btnCancel"));
            };

            Controls.prototype.btnKakutei = function () {
                return new UZA.Button(this.convFiledName("btnKakutei"));
            };
            return Controls;
        })();
        SeikatsuServiceIken.Controls = Controls;
    })(DBE.SeikatsuServiceIken || (DBE.SeikatsuServiceIken = {}));
    var SeikatsuServiceIken = DBE.SeikatsuServiceIken;
})(DBE || (DBE = {}));
