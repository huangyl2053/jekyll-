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
var DBZ;
(function (DBZ) {
    (function (SeikatsuhogoDetail) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SeikatsuhogoDetail.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SeikatsuhogoDetail.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SeikatsuhogoDetail.ModeController = ModeController;
    })(DBZ.SeikatsuhogoDetail || (DBZ.SeikatsuhogoDetail = {}));
    var SeikatsuhogoDetail = DBZ.SeikatsuhogoDetail;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SeikatsuhogoDetail) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SeikatsuhogoDetail.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("btnHokenshaGuide_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getbtnHokenshaGuide_displayNone = function () {
                return this.controls.btnHokenshaGuide().displayNone;
            };

            PublicProperties.prototype.setbtnHokenshaGuide_displayNone = function (value) {
                this.controls.btnHokenshaGuide().displayNone = value;
            };
            return PublicProperties;
        })();
        SeikatsuhogoDetail.PublicProperties = PublicProperties;
    })(DBZ.SeikatsuhogoDetail || (DBZ.SeikatsuhogoDetail = {}));
    var SeikatsuhogoDetail = DBZ.SeikatsuhogoDetail;
})(DBZ || (DBZ = {}));
