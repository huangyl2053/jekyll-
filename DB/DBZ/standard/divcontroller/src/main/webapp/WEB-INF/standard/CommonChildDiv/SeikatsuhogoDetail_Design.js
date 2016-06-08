var DBZ;
(function (DBZ) {
    (function (SeikatsuhogoDetail) {
        var Events = (function () {
            function Events() {
            }
            Events.onbtn_AddRow = function () {
                return "onbtn_AddRow";
            };

            Events.onbtn_Select = function () {
                return "onbtn_Select";
            };

            Events.onbtn_Modify = function () {
                return "onbtn_Modify";
            };

            Events.onbtn_Delete = function () {
                return "onbtn_Delete";
            };

            Events.onbtn_OK = function () {
                return "onbtn_OK";
            };

            Events.onbtn_Cancel = function () {
                return "onbtn_Cancel";
            };

            Events.onbtn_DetailAirOK = function () {
                return "onbtn_DetailAirOK";
            };

            Events.onbtn_DetailAirCancel = function () {
                return "onbtn_DetailAirCancel";
            };
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

            Controls.prototype.JukyuKikan = function () {
                return new UZA.Panel(this.convFiledName("JukyuKikan"));
            };

            Controls.prototype.txtJukyushaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJukyushaNo"));
            };

            Controls.prototype.txtJukyuKaishiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtJukyuKaishiYMD"));
            };

            Controls.prototype.txtJukyuHaishiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtJukyuHaishiYMD"));
            };

            Controls.prototype.HokenryoDairinofu = function () {
                return new UZA.Panel(this.convFiledName("HokenryoDairinofu"));
            };

            Controls.prototype.radDairinofuKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radDairinofuKubun"));
            };

            Controls.prototype.txtDainoNofuYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtDainoNofuYM"));
            };

            Controls.prototype.KyugoShisetsu = function () {
                return new UZA.Panel(this.convFiledName("KyugoShisetsu"));
            };

            Controls.prototype.radNyutaishoKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radNyutaishoKubun"));
            };

            Controls.prototype.txtNyutaishoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtNyutaishoYMD"));
            };

            Controls.prototype.FujoShurui = function () {
                return new UZA.Panel(this.convFiledName("FujoShurui"));
            };

            Controls.prototype.chkFujoShurui = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkFujoShurui"));
            };

            Controls.prototype.TeishiKikan = function () {
                return new UZA.Panel(this.convFiledName("TeishiKikan"));
            };

            Controls.prototype.btnTeishiRirekiAdd = function () {
                return new UZA.Button(this.convFiledName("btnTeishiRirekiAdd"));
            };

            Controls.prototype.dgTeishiRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgTeishiRireki"));
            };

            Controls.prototype.TeishiKikanInput = function () {
                return new UZA.Panel(this.convFiledName("TeishiKikanInput"));
            };

            Controls.prototype.txtTeishiKaishiYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTeishiKaishiYMD"));
            };

            Controls.prototype.txtTeishiShuryoYMD = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTeishiShuryoYMD"));
            };

            Controls.prototype.TeishiInputSeigyo = function () {
                return new UZA.Panel(this.convFiledName("TeishiInputSeigyo"));
            };

            Controls.prototype.btnTeishiInputKakutei = function () {
                return new UZA.Button(this.convFiledName("btnTeishiInputKakutei"));
            };

            Controls.prototype.btnTeishiInputTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnTeishiInputTorikeshi"));
            };

            Controls.prototype.SeikatsuHojoInputSeigyo = function () {
                return new UZA.Panel(this.convFiledName("SeikatsuHojoInputSeigyo"));
            };

            Controls.prototype.btnMeisaiKakutei = function () {
                return new UZA.Button(this.convFiledName("btnMeisaiKakutei"));
            };

            Controls.prototype.btnMeisaiTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnMeisaiTorikeshi"));
            };
            return Controls;
        })();
        SeikatsuhogoDetail.Controls = Controls;
    })(DBZ.SeikatsuhogoDetail || (DBZ.SeikatsuhogoDetail = {}));
    var SeikatsuhogoDetail = DBZ.SeikatsuhogoDetail;
})(DBZ || (DBZ = {}));
