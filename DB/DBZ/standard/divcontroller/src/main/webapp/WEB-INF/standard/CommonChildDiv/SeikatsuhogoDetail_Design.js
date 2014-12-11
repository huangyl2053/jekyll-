var DBZ;
(function (DBZ) {
    (function (SeikatsuhogoDetail) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        SeikatsuhogoDetail.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SeikatsuhogoDetail";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SeikatsuhogoDetail.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SeikatsuhogoDetail.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SeikatsuhogoDetail = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.SeikatsuhogoDetailSub = function () {
                return new UZA.Panel(this.convFiledName("SeikatsuhogoDetailSub"));
            };

            Controls.prototype.txtJukyushaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJukyushaNo"));
            };

            Controls.prototype.txtKaishiYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKaishiYM"));
            };

            Controls.prototype.txtHaishiYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtHaishiYM"));
            };

            Controls.prototype.txtHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtHokenshaNo"));
            };

            Controls.prototype.btnHokenshaGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHokenshaGuide"));
            };

            Controls.prototype.txtHokenshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtHokenshaName"));
            };

            Controls.prototype.HokenryoDairinofu = function () {
                return new UZA.Panel(this.convFiledName("SeikatsuhogoDetailSub_HokenryoDairinofu"));
            };

            Controls.prototype.radDairinofuKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radDairinofuKubun"));
            };

            Controls.prototype.txtNofuYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNofuYM"));
            };

            Controls.prototype.KyugoShisetsu = function () {
                return new UZA.Panel(this.convFiledName("SeikatsuhogoDetailSub_KyugoShisetsu"));
            };

            Controls.prototype.radNyutaishoKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radNyutaishoKubun"));
            };

            Controls.prototype.txtNyushoDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNyushoDate"));
            };

            Controls.prototype.txtTaishoDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTaishoDate"));
            };

            Controls.prototype.FujoShurui = function () {
                return new UZA.Panel(this.convFiledName("FujoShurui"));
            };

            Controls.prototype.chkFujyoShurui = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkFujyoShurui"));
            };
            return Controls;
        })();
        SeikatsuhogoDetail.Controls = Controls;
    })(DBZ.SeikatsuhogoDetail || (DBZ.SeikatsuhogoDetail = {}));
    var SeikatsuhogoDetail = DBZ.SeikatsuhogoDetail;
})(DBZ || (DBZ = {}));
