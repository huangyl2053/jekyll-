var DBZ;
(function (DBZ) {
    (function (ShinseishaInfo) {
        var Events = (function () {
            function Events() {
            }
            Events.onChange_ddlShinseishaKubun = function () {
                return "onChange_ddlShinseishaKubun";
            };
            return Events;
        })();
        ShinseishaInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShinseishaInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShinseishaInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShinseishaInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShinseishaInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtShinseiDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShinseiDate"));
            };

            Controls.prototype.ddlShinseishaKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlShinseishaKubun"));
            };

            Controls.prototype.txtUketsukeDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtUketsukeDate"));
            };

            Controls.prototype.txtShinseiRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinseiRiyu"));
            };

            Controls.prototype.txtJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));
            };

            Controls.prototype.btnJigyoshaInputGuide = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnJigyoshaInputGuide"));
            };

            Controls.prototype.btnHonninJohoCopy = function () {
                return new UZA.Button(this.convFiledName("btnHonninJohoCopy"));
            };

            Controls.prototype.ddlHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHokensha"));
            };

            Controls.prototype.txtShinseishaNameKana = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseishaNameKana"));
            };

            Controls.prototype.txtShinseishaName = function () {
                return new UZA.TextBox(this.convFiledName("txtShinseishaName"));
            };

            Controls.prototype.txtTelNo = function () {
                return new UZA.TextBox(this.convFiledName("txtTelNo"));
            };

            Controls.prototype.txtYubinNo = function () {
                return new UZA.TextBoxYubinNo(this.convFiledName("txtYubinNo"));
            };

            Controls.prototype.txtAddress = function () {
                return new UZA.TextBox(this.convFiledName("txtAddress"));
            };
            return Controls;
        })();
        ShinseishaInfo.Controls = Controls;
    })(DBZ.ShinseishaInfo || (DBZ.ShinseishaInfo = {}));
    var ShinseishaInfo = DBZ.ShinseishaInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShinseishaInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShinseishaInfo.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShinseishaInfo.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShinseishaInfo.ModeController = ModeController;
    })(DBZ.ShinseishaInfo || (DBZ.ShinseishaInfo = {}));
    var ShinseishaInfo = DBZ.ShinseishaInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShinseishaInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShinseishaInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("btnJigyoshaInputGuide_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtUkestukeDate_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtJigyoshaNo_disabled", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtShinseishaName_labelLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtYubinNo_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("txtAddress_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("btnJigyoshaInputGuide_disabled", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("shinseishaInfo_eraseBorder", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getbtnJigyoshaInputGuide_displayNone = function () {
                return this.controls.btnJigyoshaInputGuide().displayNone;
            };

            PublicProperties.prototype.setbtnJigyoshaInputGuide_displayNone = function (value) {
                this.controls.btnJigyoshaInputGuide().displayNone = value;
            };

            PublicProperties.prototype.gettxtUkestukeDate_displayNone = function () {
                return this.controls.txtUketsukeDate().displayNone;
            };

            PublicProperties.prototype.settxtUkestukeDate_displayNone = function (value) {
                this.controls.txtUketsukeDate().displayNone = value;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.ShinseishaInfo().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.ShinseishaInfo().title = value;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.ShinseishaInfo().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.ShinseishaInfo().panelDisplay = value;
            };

            PublicProperties.prototype.gettxtJigyoshaNo_disabled = function () {
                return this.controls.txtJigyoshaNo().disabled;
            };

            PublicProperties.prototype.settxtJigyoshaNo_disabled = function (value) {
                this.controls.txtJigyoshaNo().disabled = value;
            };

            PublicProperties.prototype.gettxtShinseishaName_labelLText = function () {
                return this.controls.txtShinseishaNameKana().labelLText;
            };

            PublicProperties.prototype.settxtShinseishaName_labelLText = function (value) {
                this.controls.txtShinseishaNameKana().labelLText = value;
            };

            PublicProperties.prototype.gettxtYubinNo_displayNone = function () {
                return this.controls.txtYubinNo().displayNone;
            };

            PublicProperties.prototype.settxtYubinNo_displayNone = function (value) {
                this.controls.txtYubinNo().displayNone = value;
            };

            PublicProperties.prototype.gettxtAddress_displayNone = function () {
                return this.controls.txtAddress().displayNone;
            };

            PublicProperties.prototype.settxtAddress_displayNone = function (value) {
                this.controls.txtAddress().displayNone = value;
            };

            PublicProperties.prototype.getbtnJigyoshaInputGuide_disabled = function () {
                return this.controls.btnJigyoshaInputGuide().disabled;
            };

            PublicProperties.prototype.setbtnJigyoshaInputGuide_disabled = function (value) {
                this.controls.btnJigyoshaInputGuide().disabled = value;
            };

            PublicProperties.prototype.getshinseishaInfo_eraseBorder = function () {
                return this.controls.ShinseishaInfo().eraseBorder;
            };

            PublicProperties.prototype.setshinseishaInfo_eraseBorder = function (value) {
                this.controls.ShinseishaInfo().eraseBorder = value;
            };
            return PublicProperties;
        })();
        ShinseishaInfo.PublicProperties = PublicProperties;
    })(DBZ.ShinseishaInfo || (DBZ.ShinseishaInfo = {}));
    var ShinseishaInfo = DBZ.ShinseishaInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KozaPayment) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KozaPayment.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KozaPayment";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KozaPayment.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KozaPayment.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KozaPayment = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtKinyuKikanCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKinyuKikanCode"));
            };

            Controls.prototype.txtKinyuKikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtKinyuKikanName"));
            };

            Controls.prototype.radKozaShubetsu = function () {
                return new UZA.RadioButton(this.convFiledName("radKozaShubetsu"));
            };

            Controls.prototype.txtKozaMeigininKana = function () {
                return new UZA.TextBox(this.convFiledName("txtKozaMeigininKana"));
            };

            Controls.prototype.txtKinyuKikanBrunchCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKinyuKikanBrunchCode"));
            };

            Controls.prototype.txtKinyuKikanBrunchName = function () {
                return new UZA.TextBox(this.convFiledName("txtKinyuKikanBrunchName"));
            };

            Controls.prototype.txtKozaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtKozaNo"));
            };

            Controls.prototype.txtKozaMeiginin = function () {
                return new UZA.TextBox(this.convFiledName("txtKozaMeiginin"));
            };
            return Controls;
        })();
        KozaPayment.Controls = Controls;
    })(DBZ.KozaPayment || (DBZ.KozaPayment = {}));
    var KozaPayment = DBZ.KozaPayment;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KozaPayment) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KozaPayment.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KozaPayment.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KozaPayment.ModeController = ModeController;
    })(DBZ.KozaPayment || (DBZ.KozaPayment = {}));
    var KozaPayment = DBZ.KozaPayment;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KozaPayment) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KozaPayment.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.KozaPayment().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.KozaPayment().title = value;
            };

            PublicProperties.prototype.geteraseBorder = function () {
                return this.controls.KozaPayment().eraseBorder;
            };

            PublicProperties.prototype.seteraseBorder = function (value) {
                this.controls.KozaPayment().eraseBorder = value;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.KozaPayment().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.KozaPayment().panelDisplay = value;
            };
            return PublicProperties;
        })();
        KozaPayment.PublicProperties = PublicProperties;
    })(DBZ.KozaPayment || (DBZ.KozaPayment = {}));
    var KozaPayment = DBZ.KozaPayment;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (PaymentMethod) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        PaymentMethod.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "PaymentMethod";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.PaymentMethod.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.PaymentMethod.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.PaymentMethod = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.radPayMethod1 = function () {
                return new UZA.RadioButton(this.convFiledName("radPayMethod1"));
            };

            Controls.prototype.JuryoininJoho = function () {
                return new UZA.Panel(this.convFiledName("JuryoininJoho"));
            };

            Controls.prototype.txtJuryoininKeiyakuNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJuryoininKeiyakuNo"));
            };

            Controls.prototype.txtJigyoshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtJigyoshaNo"));
            };

            Controls.prototype.txtJigyoshaName = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaName"));
            };

            Controls.prototype.txtJigyoshaNameKana = function () {
                return new UZA.TextBox(this.convFiledName("txtJigyoshaNameKana"));
            };

            Controls.prototype.radPayMethod2 = function () {
                return new UZA.RadioButton(this.convFiledName("radPayMethod2"));
            };

            Controls.prototype.KozaPayment = function () {
                return new DBZ.KozaPayment.ModeController(this.convFiledName("KozaPayment"));
            };

            Controls.prototype.radPayMethod3 = function () {
                return new UZA.RadioButton(this.convFiledName("radPayMethod3"));
            };

            Controls.prototype.MadoguchiPayment = function () {
                return new UZA.Panel(this.convFiledName("MadoguchiPayment"));
            };

            Controls.prototype.txtShiharaiBasho = function () {
                return new UZA.TextBox(this.convFiledName("txtShiharaiBasho"));
            };

            Controls.prototype.txtShiharaiKaishiDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShiharaiKaishiDate"));
            };

            Controls.prototype.txtShiharaiKaishiDay = function () {
                return new UZA.TextBox(this.convFiledName("txtShiharaiKaishiDay"));
            };

            Controls.prototype.txtShiharaiKaishiTime = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtShiharaiKaishiTime"));
            };

            Controls.prototype.txtShiharaiShuryoDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShiharaiShuryoDate"));
            };

            Controls.prototype.txtShiharaiShuryoDay = function () {
                return new UZA.TextBox(this.convFiledName("txtShiharaiShuryoDay"));
            };

            Controls.prototype.txtShiharaiShuryoTime = function () {
                return new UZA.TextBoxTime(this.convFiledName("txtShiharaiShuryoTime"));
            };
            return Controls;
        })();
        PaymentMethod.Controls = Controls;
    })(DBZ.PaymentMethod || (DBZ.PaymentMethod = {}));
    var PaymentMethod = DBZ.PaymentMethod;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (PaymentMethod) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new PaymentMethod.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new PaymentMethod.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        PaymentMethod.ModeController = ModeController;
    })(DBZ.PaymentMethod || (DBZ.PaymentMethod = {}));
    var PaymentMethod = DBZ.PaymentMethod;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (PaymentMethod) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new PaymentMethod.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("KozaPayment_title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClick_radPayMethod", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("Juryoinin_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("Madoguchi_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("Koza_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.PaymentMethod().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.PaymentMethod().title = value;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.PaymentMethod().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.PaymentMethod().panelDisplay = value;
            };

            PublicProperties.prototype.getonClick_radPayMethod = function () {
                return this.controls.radPayMethod1().onClick;
            };

            PublicProperties.prototype.setonClick_radPayMethod = function (value) {
                this.controls.radPayMethod1().onClick = value;
            };

            PublicProperties.prototype.getJuryoinin_displayNone = function () {
                return this.controls.JuryoininJoho().displayNone;
            };

            PublicProperties.prototype.setJuryoinin_displayNone = function (value) {
                this.controls.JuryoininJoho().displayNone = value;
            };

            PublicProperties.prototype.getMadoguchi_displayNone = function () {
                return this.controls.MadoguchiPayment().displayNone;
            };

            PublicProperties.prototype.setMadoguchi_displayNone = function (value) {
                this.controls.MadoguchiPayment().displayNone = value;
            };

            PublicProperties.prototype.getKoza_displayNone = function () {
                return this.controls.KozaPayment().Properties().displayNone;
            };

            PublicProperties.prototype.setKoza_displayNone = function (value) {
                this.controls.KozaPayment().Properties().displayNone = value;
            };

            PublicProperties.prototype.geteraseBorder = function () {
                return this.controls.PaymentMethod().eraseBorder;
            };

            PublicProperties.prototype.seteraseBorder = function (value) {
                this.controls.PaymentMethod().eraseBorder = value;
            };
            return PublicProperties;
        })();
        PaymentMethod.PublicProperties = PublicProperties;
    })(DBZ.PaymentMethod || (DBZ.PaymentMethod = {}));
    var PaymentMethod = DBZ.PaymentMethod;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KogakuServicehiJudgementResult) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KogakuServicehiJudgementResult.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KogakuServicehiJudgementResult";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KogakuServicehiJudgementResult.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KogakuServicehiJudgementResult.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KogakuServicehiJudgementResult = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgJudgementResult = function () {
                return new UZA.DataGrid(this.convFiledName("dgJudgementResult"));
            };

            Controls.prototype.KogakuServicehiJudgementResultDetail1 = function () {
                return new UZA.Panel(this.convFiledName("KogakuServicehiJudgementResultDetail1"));
            };

            Controls.prototype.txtUketsukeDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtUketsukeDate"));
            };

            Controls.prototype.txtHonninPaymentAmount = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtHonninPaymentAmount"));
            };

            Controls.prototype.txtKetteiDate = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtKetteiDate"));
            };

            Controls.prototype.radShikyuKubun = function () {
                return new UZA.RadioButton(this.convFiledName("radShikyuKubun"));
            };

            Controls.prototype.txtsetaiShuyakuNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtsetaiShuyakuNo"));
            };

            Controls.prototype.txtShikyuAmount = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShikyuAmount"));
            };

            Controls.prototype.radIsKogakuAutoShokan = function () {
                return new UZA.RadioButton(this.convFiledName("radIsKogakuAutoShokan"));
            };

            Controls.prototype.KogakuServicehiJudgementResultDetail2 = function () {
                return new UZA.Panel(this.convFiledName("KogakuServicehiJudgementResultDetail2"));
            };

            Controls.prototype.txtBiko = function () {
                return new UZA.TextBox(this.convFiledName("txtBiko"));
            };

            Controls.prototype.radJudgementMethod = function () {
                return new UZA.RadioButton(this.convFiledName("radJudgementMethod"));
            };

            Controls.prototype.txtFushikyuRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtFushikyuRiyu"));
            };
            return Controls;
        })();
        KogakuServicehiJudgementResult.Controls = Controls;
    })(DBZ.KogakuServicehiJudgementResult || (DBZ.KogakuServicehiJudgementResult = {}));
    var KogakuServicehiJudgementResult = DBZ.KogakuServicehiJudgementResult;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KogakuServicehiJudgementResult) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KogakuServicehiJudgementResult.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KogakuServicehiJudgementResult.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KogakuServicehiJudgementResult.ModeController = ModeController;
    })(DBZ.KogakuServicehiJudgementResult || (DBZ.KogakuServicehiJudgementResult = {}));
    var KogakuServicehiJudgementResult = DBZ.KogakuServicehiJudgementResult;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KogakuServicehiJudgementResult) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KogakuServicehiJudgementResult.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.KogakuServicehiJudgementResult().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.KogakuServicehiJudgementResult().title = value;
            };

            PublicProperties.prototype.geteraseBorder = function () {
                return this.controls.KogakuServicehiJudgementResult().eraseBorder;
            };

            PublicProperties.prototype.seteraseBorder = function (value) {
                this.controls.KogakuServicehiJudgementResult().eraseBorder = value;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.KogakuServicehiJudgementResult().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.KogakuServicehiJudgementResult().panelDisplay = value;
            };
            return PublicProperties;
        })();
        KogakuServicehiJudgementResult.PublicProperties = PublicProperties;
    })(DBZ.KogakuServicehiJudgementResult || (DBZ.KogakuServicehiJudgementResult = {}));
    var KogakuServicehiJudgementResult = DBZ.KogakuServicehiJudgementResult;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KogakuServicehiDetail) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KogakuServicehiDetail.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KogakuServicehiDetail";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KogakuServicehiDetail.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KogakuServicehiDetail.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KogakuServicehiDetail = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtTeikyoYM = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtTeikyoYM"));
            };

            Controls.prototype.tabKogakuServicehiDetail = function () {
                return new UZA.TabContainer(this.convFiledName("tabKogakuServicehiDetail"));
            };

            Controls.prototype.tplShinseisha = function () {
                return new UZA.TabPanel(this.convFiledName("tplShinseisha"));
            };

            Controls.prototype.Shinseisha = function () {
                return new DBZ.ShinseishaInfo.ModeController(this.convFiledName("Shinseisha"));
            };

            Controls.prototype.txtShiharaiTotalAmount = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtShiharaiTotalAmount"));
            };

            Controls.prototype.txtShinseiRiyu = function () {
                return new UZA.TextBoxMultiLine(this.convFiledName("txtShinseiRiyu"));
            };

            Controls.prototype.tplKoza = function () {
                return new UZA.TabPanel(this.convFiledName("tplKoza"));
            };

            Controls.prototype.PaymentMethod = function () {
                return new DBZ.PaymentMethod.ModeController(this.convFiledName("PaymentMethod"));
            };

            Controls.prototype.tplJudgementResult = function () {
                return new UZA.TabPanel(this.convFiledName("tplJudgementResult"));
            };

            Controls.prototype.JudgementResult = function () {
                return new DBZ.KogakuServicehiJudgementResult.ModeController(this.convFiledName("JudgementResult"));
            };

            Controls.prototype.tplKetteiJoho = function () {
                return new UZA.TabPanel(this.convFiledName("tplKetteiJoho"));
            };
            return Controls;
        })();
        KogakuServicehiDetail.Controls = Controls;
    })(DBZ.KogakuServicehiDetail || (DBZ.KogakuServicehiDetail = {}));
    var KogakuServicehiDetail = DBZ.KogakuServicehiDetail;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KogakuServicehiDetail) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KogakuServicehiDetail.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KogakuServicehiDetail.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KogakuServicehiDetail.ModeController = ModeController;
    })(DBZ.KogakuServicehiDetail || (DBZ.KogakuServicehiDetail = {}));
    var KogakuServicehiDetail = DBZ.KogakuServicehiDetail;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KogakuServicehiDetail) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KogakuServicehiDetail.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("panelDisplay", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("tplJudgementResult_title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("tplKetteiJoho_visible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.KogakuServicehiDetail().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.KogakuServicehiDetail().title = value;
            };

            PublicProperties.prototype.geteraseBorder = function () {
                return this.controls.KogakuServicehiDetail().eraseBorder;
            };

            PublicProperties.prototype.seteraseBorder = function (value) {
                this.controls.KogakuServicehiDetail().eraseBorder = value;
            };

            PublicProperties.prototype.getpanelDisplay = function () {
                return this.controls.KogakuServicehiDetail().panelDisplay;
            };

            PublicProperties.prototype.setpanelDisplay = function (value) {
                this.controls.KogakuServicehiDetail().panelDisplay = value;
            };

            PublicProperties.prototype.gettplJudgementResult_title = function () {
                return this.controls.tplJudgementResult().title;
            };

            PublicProperties.prototype.settplJudgementResult_title = function (value) {
                this.controls.tplJudgementResult().title = value;
            };

            PublicProperties.prototype.gettplKetteiJoho_visible = function () {
                return this.controls.tplKetteiJoho().visible;
            };

            PublicProperties.prototype.settplKetteiJoho_visible = function (value) {
                this.controls.tplKetteiJoho().visible = value;
            };
            return PublicProperties;
        })();
        KogakuServicehiDetail.PublicProperties = PublicProperties;
    })(DBZ.KogakuServicehiDetail || (DBZ.KogakuServicehiDetail = {}));
    var KogakuServicehiDetail = DBZ.KogakuServicehiDetail;
})(DBZ || (DBZ = {}));
