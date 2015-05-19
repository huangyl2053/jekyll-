var DBZ;
(function (DBZ) {
    (function (ShinshinIken) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ShinshinIken.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShinshinIken";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShinshinIken.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShinshinIken.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShinshinIken = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.NichijoJiritsudo = function () {
                return new UZA.Panel(this.convFiledName("NichijoJiritsudo"));
            };

            Controls.prototype.radShogaiKoreishaNichijoSeikatsuJiritsudo = function () {
                return new UZA.RadioButton(this.convFiledName("radShogaiKoreishaNichijoSeikatsuJiritsudo"));
            };

            Controls.prototype.radNinchishoKoreishaJiritsu = function () {
                return new UZA.RadioButton(this.convFiledName("radNinchishoKoreishaJiritsu"));
            };

            Controls.prototype.NinchishoChukakuShojo = function () {
                return new UZA.Panel(this.convFiledName("NinchishoChukakuShojo"));
            };

            Controls.prototype.TankiKioku = function () {
                return new UZA.Panel(this.convFiledName("TankiKioku"));
            };

            Controls.prototype.radTankiKioku = function () {
                return new UZA.RadioButton(this.convFiledName("radTankiKioku"));
            };

            Controls.prototype.NichijoNinchiNoryoku = function () {
                return new UZA.Panel(this.convFiledName("NichijoNinchiNoryoku"));
            };

            Controls.prototype.radNichijoNinchiNoryoku = function () {
                return new UZA.RadioButton(this.convFiledName("radNichijoNinchiNoryoku"));
            };

            Controls.prototype.IshiDentatsuNoryoku = function () {
                return new UZA.Panel(this.convFiledName("IshiDentatsuNoryoku"));
            };

            Controls.prototype.radIshiDentatsuNoryoku = function () {
                return new UZA.RadioButton(this.convFiledName("radIshiDentatsuNoryoku"));
            };

            Controls.prototype.ShokujiKoi = function () {
                return new UZA.Panel(this.convFiledName("ShokujiKoi"));
            };

            Controls.prototype.radShokujiKoi = function () {
                return new UZA.RadioButton(this.convFiledName("radShokujiKoi"));
            };

            Controls.prototype.NinchishoShuhenShojo = function () {
                return new UZA.Panel(this.convFiledName("NinchishoShuhenShojo"));
            };

            Controls.prototype.chkNinchishoShuhenShojoUmu = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkNinchishoShuhenShojoUmu"));
            };

            Controls.prototype.chkNinchishoShuhenShojo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkNinchishoShuhenShojo"));
            };

            Controls.prototype.chkNinchishoShuhenShojoSonota = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkNinchishoShuhenShojoSonota"));
            };

            Controls.prototype.txtSonotaKinyu = function () {
                return new UZA.TextBox(this.convFiledName("txtSonotaKinyu"));
            };

            Controls.prototype.SonotaShojo = function () {
                return new UZA.Panel(this.convFiledName("SonotaShojo"));
            };

            Controls.prototype.chkSonotaShojo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSonotaShojo"));
            };

            Controls.prototype.txtShojomei = function () {
                return new UZA.TextBox(this.convFiledName("txtShojomei"));
            };

            Controls.prototype.chkSenmonJushin = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSenmonJushin"));
            };

            Controls.prototype.txtShosaiTokkiJiko = function () {
                return new UZA.TextBox(this.convFiledName("txtShosaiTokkiJiko"));
            };

            Controls.prototype.KaradaJotai = function () {
                return new UZA.Panel(this.convFiledName("KaradaJotai"));
            };

            Controls.prototype.chkKikiude = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKikiude"));
            };

            Controls.prototype.txtShincho = function () {
                return new UZA.TextBox(this.convFiledName("txtShincho"));
            };

            Controls.prototype.txtTaiju = function () {
                return new UZA.TextBox(this.convFiledName("txtTaiju"));
            };

            Controls.prototype.chkKakoTaijuHenka = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKakoTaijuHenka"));
            };

            Controls.prototype.chkShishiKesson = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkShishiKesson"));
            };

            Controls.prototype.txtShishiKessonBui = function () {
                return new UZA.TextBox(this.convFiledName("txtShishiKessonBui"));
            };

            Controls.prototype.linHorizon1 = function () {
                return new UZA.HorizontalLine(this.convFiledName("linHorizon1"));
            };

            Controls.prototype.chkMahi = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkMahi"));
            };

            Controls.prototype.chkMigiJoshiMahi = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkMigiJoshiMahi"));
            };

            Controls.prototype.chkMigiJoshiMahiTeido = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkMigiJoshiMahiTeido"));
            };

            Controls.prototype.chkHidariJoshiMahi = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkHidariJoshiMahi"));
            };

            Controls.prototype.chkHidariJoshiMahiTeido = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkHidariJoshiMahiTeido"));
            };

            Controls.prototype.chkMigiKashiMahi = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkMigiKashiMahi"));
            };

            Controls.prototype.chkMigiKashiMahiTeido = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkMigiKashiMahiTeido"));
            };

            Controls.prototype.chkHidariKashiMahi = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkHidariKashiMahi"));
            };

            Controls.prototype.chkHidariKashiMahiTeido = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkHidariKashiMahiTeido"));
            };

            Controls.prototype.chkSonotaMahi = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSonotaMahi"));
            };

            Controls.prototype.txtSonotaMahiBui = function () {
                return new UZA.TextBox(this.convFiledName("txtSonotaMahiBui"));
            };

            Controls.prototype.SonotaMahiTeido = function () {
                return new UZA.CheckBoxList(this.convFiledName("SonotaMahiTeido"));
            };

            Controls.prototype.linHorizon2 = function () {
                return new UZA.HorizontalLine(this.convFiledName("linHorizon2"));
            };

            Controls.prototype.chkKinryokuTeika = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKinryokuTeika"));
            };

            Controls.prototype.txtKinryokuTeikaBui = function () {
                return new UZA.TextBox(this.convFiledName("txtKinryokuTeikaBui"));
            };

            Controls.prototype.chkKinryokuTeikaTeido = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKinryokuTeikaTeido"));
            };

            Controls.prototype.linHorizon3 = function () {
                return new UZA.HorizontalLine(this.convFiledName("linHorizon3"));
            };

            Controls.prototype.chkKansetsuKoshuku = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKansetsuKoshuku"));
            };

            Controls.prototype.txtKansetsuKoshukuBui = function () {
                return new UZA.TextBox(this.convFiledName("txtKansetsuKoshukuBui"));
            };

            Controls.prototype.chkKansetsuKoshukuTeido = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKansetsuKoshukuTeido"));
            };

            Controls.prototype.linHorizon4 = function () {
                return new UZA.HorizontalLine(this.convFiledName("linHorizon4"));
            };

            Controls.prototype.chkKansetsuItami = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKansetsuItami"));
            };

            Controls.prototype.txtKansetsuItamiBui = function () {
                return new UZA.TextBox(this.convFiledName("txtKansetsuItamiBui"));
            };

            Controls.prototype.chkKansetsuItamiTeido = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkKansetsuItamiTeido"));
            };

            Controls.prototype.linHorizon5 = function () {
                return new UZA.HorizontalLine(this.convFiledName("linHorizon5"));
            };

            Controls.prototype.chkShicchoFuzuii = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkShicchoFuzuii"));
            };

            Controls.prototype.chkFuzuiiJoshi = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkFuzuiiJoshi"));
            };

            Controls.prototype.chkFuzuiiKashi = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkFuzuiiKashi"));
            };

            Controls.prototype.chkTaikan = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkTaikan"));
            };

            Controls.prototype.linHorizon6 = function () {
                return new UZA.HorizontalLine(this.convFiledName("linHorizon6"));
            };

            Controls.prototype.chkJokuso = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkJokuso"));
            };

            Controls.prototype.txtJokusoBui = function () {
                return new UZA.TextBox(this.convFiledName("txtJokusoBui"));
            };

            Controls.prototype.chkJokusoTeido = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkJokusoTeido"));
            };

            Controls.prototype.linHorizon7 = function () {
                return new UZA.HorizontalLine(this.convFiledName("linHorizon7"));
            };

            Controls.prototype.chkSonotaHifuShikkan = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSonotaHifuShikkan"));
            };

            Controls.prototype.txtSonotaHifuShikkanBui = function () {
                return new UZA.TextBox(this.convFiledName("txtSonotaHifuShikkanBui"));
            };

            Controls.prototype.chkSonotaHifuShikkanTeido = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkSonotaHifuShikkanTeido"));
            };

            Controls.prototype.btnModoru = function () {
                return new UZA.Button(this.convFiledName("btnModoru"));
            };

            Controls.prototype.btnKoshin = function () {
                return new UZA.Button(this.convFiledName("btnKoshin"));
            };
            return Controls;
        })();
        ShinshinIken.Controls = Controls;
    })(DBZ.ShinshinIken || (DBZ.ShinshinIken = {}));
    var ShinshinIken = DBZ.ShinshinIken;
})(DBZ || (DBZ = {}));
