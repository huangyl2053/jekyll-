var DBZ;
(function (DBZ) {
    (function (SogoShokaiGenmenGengakuInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        SogoShokaiGenmenGengakuInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SogoShokaiGenmenGengakuInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SogoShokaiGenmenGengakuInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SogoShokaiGenmenGengakuInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SogoShokaiGenmenGengakuInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtGenmenShinseiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtGenmenShinseiYMD"));
            };

            Controls.prototype.txtGenmenKyuSochiUmu = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenKyuSochiUmu"));
            };

            Controls.prototype.SogoShokaiGenmenGengakuTecho = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiGenmenGengakuTecho"));
            };

            Controls.prototype.txtGenmenTechoUmu = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenTechoUmu"));
            };

            Controls.prototype.txtGenmenTechoTokyu = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenTechoTokyu"));
            };

            Controls.prototype.txtGenmenTechoNo = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenTechoNo"));
            };

            Controls.prototype.txtGenmenTechoKofuYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtGenmenTechoKofuYMD"));
            };

            Controls.prototype.txtGenmenSeihoUmu = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenSeihoUmu"));
            };

            Controls.prototype.txtGenmenSeihoTokureiUmu = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenSeihoTokureiUmu"));
            };

            Controls.prototype.txtGenmenRofukuUmu = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenRofukuUmu"));
            };

            Controls.prototype.txtGenmenFutanDankai = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenFutanDankai"));
            };

            Controls.prototype.txtGenmenKyokaiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenKyokaiKubun"));
            };

            Controls.prototype.txtGenmenGekihenDanwaKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenGekihenDanwaKubun"));
            };

            Controls.prototype.SogoShokaiGenmenGengakuFutan = function () {
                return new UZA.Panel(this.convFiledName("SogoShokaiGenmenGengakuFutan"));
            };

            Controls.prototype.txtGenmenFutanKetteiKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenFutanKetteiKubun"));
            };

            Controls.prototype.txtGenmenFutanKetteiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtGenmenFutanKetteiYMD"));
            };

            Controls.prototype.txtGenmenFutanTekiyoKaishiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtGenmenFutanTekiyoKaishiYMD"));
            };

            Controls.prototype.txtGenmenFutanYukoKigen = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtGenmenFutanYukoKigen"));
            };

            Controls.prototype.txtGenmenFutanKyufuritsu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmenFutanKyufuritsu"));
            };

            Controls.prototype.txtGenmenFutanFutanshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtGenmenFutanFutanshaNo"));
            };

            Controls.prototype.txtGenmenFutanJukyushaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtGenmenFutanJukyushaNo"));
            };

            Controls.prototype.txtGenmenFutanKyoshitsuShubetsu = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenFutanKyoshitsuShubetsu"));
            };

            Controls.prototype.txtGenmenFutanShokuji = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmenFutanShokuji"));
            };

            Controls.prototype.txtGenmenFutanUnit = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmenFutanUnit"));
            };

            Controls.prototype.txtGenmenFutanUnitJun = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmenFutanUnitJun"));
            };

            Controls.prototype.txtGenmenFutanTokuyo = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmenFutanTokuyo"));
            };

            Controls.prototype.txtGenmenFutanRoken = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmenFutanRoken"));
            };

            Controls.prototype.txtGenmenFutanTasho = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmenFutanTasho"));
            };

            Controls.prototype.txtGenmenFutanSeigen = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenFutanSeigen"));
            };

            Controls.prototype.txtGenmenFutanGengakuKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenFutanGengakuKubun"));
            };

            Controls.prototype.txtGenmenFutanFutangaku = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtGenmenFutanFutangaku"));
            };

            Controls.prototype.txtGenmenFutanHyojunKubun = function () {
                return new UZA.TextBox(this.convFiledName("txtGenmenFutanHyojunKubun"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        SogoShokaiGenmenGengakuInfo.Controls = Controls;
    })(DBZ.SogoShokaiGenmenGengakuInfo || (DBZ.SogoShokaiGenmenGengakuInfo = {}));
    var SogoShokaiGenmenGengakuInfo = DBZ.SogoShokaiGenmenGengakuInfo;
})(DBZ || (DBZ = {}));
