var DBZ;
(function (DBZ) {
    (function (KaigoSaikinShorishaRireki) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoSaikinShorishaRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoSaikinShorishaRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoSaikinShorishaRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoSaikinShorishaRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoSaikinShorishaRireki = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };
            return Controls;
        })();
        KaigoSaikinShorishaRireki.Controls = Controls;
    })(DBZ.KaigoSaikinShorishaRireki || (DBZ.KaigoSaikinShorishaRireki = {}));
    var KaigoSaikinShorishaRireki = DBZ.KaigoSaikinShorishaRireki;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KaigoSaikinShorishaRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoSaikinShorishaRireki.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoSaikinShorishaRireki.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoSaikinShorishaRireki.ModeController = ModeController;
    })(DBZ.KaigoSaikinShorishaRireki || (DBZ.KaigoSaikinShorishaRireki = {}));
    var KaigoSaikinShorishaRireki = DBZ.KaigoSaikinShorishaRireki;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoSaikinShorishaRireki) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KaigoSaikinShorishaRireki.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoSaikinShorishaRireki.PublicProperties = PublicProperties;
    })(DBZ.KaigoSaikinShorishaRireki || (DBZ.KaigoSaikinShorishaRireki = {}));
    var KaigoSaikinShorishaRireki = DBZ.KaigoSaikinShorishaRireki;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (HihokenshaFinder) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnToClear = function () {
                return "onClick_btnToClear";
            };
            return Events;
        })();
        HihokenshaFinder.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "HihokenshaFinder";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.HihokenshaFinder.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.HihokenshaFinder.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.HihokenshaFinder = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.SearchCriteriaOfHihokensha = function () {
                return new UZA.Panel(this.convFiledName("SearchCriteriaOfHihokensha"));
            };

            Controls.prototype.ddlHokensha = function () {
                return new UZA.DropDownList(this.convFiledName("ddlHokensha"));
            };

            Controls.prototype.txtHihokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtHihokenshaNo"));
            };

            Controls.prototype.txtTuchishoNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtTuchishoNo"));
            };

            Controls.prototype.ddlFukaNendo = function () {
                return new UZA.DropDownList(this.convFiledName("ddlFukaNendo"));
            };

            Controls.prototype.SearchCriteriaDetail = function () {
                return new UZA.Panel(this.convFiledName("SearchCriteriaOfHihokensha_SearchCriteriaDetail"));
            };

            Controls.prototype.chkHihokensha = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkHihokensha"));
            };

            Controls.prototype.radMinashiNigo = function () {
                return new UZA.RadioButton(this.convFiledName("radMinashiNigo"));
            };

            Controls.prototype.chkMinashiNigo = function () {
                return new UZA.CheckBoxList(this.convFiledName("chkMinashiNigo"));
            };

            Controls.prototype.KaigoAtenaFinder = function () {
                return new URA.AtenaFinder.ModeController(this.convFiledName("KaigoAtenaFinder"));
            };

            Controls.prototype.ButtonsForHihokenshaFinder = function () {
                return new UZA.Panel(this.convFiledName("ButtonsForHihokenshaFinder"));
            };

            Controls.prototype.btnToClear = function () {
                return new UZA.Button(this.convFiledName("btnToClear"));
            };

            Controls.prototype.btnToSearch = function () {
                return new UZA.Button(this.convFiledName("btnToSearch"));
            };

            Controls.prototype.txtMaxNumber = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtMaxNumber"));
            };

            Controls.prototype.saikinShorisha = function () {
                return new DBZ.KaigoSaikinShorishaRireki.ModeController(this.convFiledName("saikinShorisha"));
            };
            return Controls;
        })();
        HihokenshaFinder.Controls = Controls;
    })(DBZ.HihokenshaFinder || (DBZ.HihokenshaFinder = {}));
    var HihokenshaFinder = DBZ.HihokenshaFinder;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (HihokenshaFinder) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HihokenshaFinder.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        HihokenshaFinder.ModeController = ModeController;
    })(DBZ.HihokenshaFinder || (DBZ.HihokenshaFinder = {}));
    var HihokenshaFinder = DBZ.HihokenshaFinder;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (HihokenshaFinder) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new HihokenshaFinder.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("onClick_BtnToSearch", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("displayNone_txtTsuchishoNo", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("displayNone_ddlFukaNendo", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("displayNone_SearchCriteriaDetail", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("canOpenAndClose_HihokenshaFinder", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("displayNone_saikinShorisha", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("displayNone_ddlHokensha", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("displayNone_chkMinashiNigo", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getonClick_BtnToSearch = function () {
                return this.controls.btnToSearch().onClick;
            };

            PublicProperties.prototype.setonClick_BtnToSearch = function (value) {
                this.controls.btnToSearch().onClick = value;
            };

            PublicProperties.prototype.getdisplayNone_txtTsuchishoNo = function () {
                return this.controls.txtTuchishoNo().displayNone;
            };

            PublicProperties.prototype.setdisplayNone_txtTsuchishoNo = function (value) {
                this.controls.txtTuchishoNo().displayNone = value;
            };

            PublicProperties.prototype.getdisplayNone_ddlFukaNendo = function () {
                return this.controls.ddlFukaNendo().displayNone;
            };

            PublicProperties.prototype.setdisplayNone_ddlFukaNendo = function (value) {
                this.controls.ddlFukaNendo().displayNone = value;
            };

            PublicProperties.prototype.getdisplayNone_SearchCriteriaDetail = function () {
                return this.controls.SearchCriteriaDetail().displayNone;
            };

            PublicProperties.prototype.setdisplayNone_SearchCriteriaDetail = function (value) {
                this.controls.SearchCriteriaDetail().displayNone = value;
            };

            PublicProperties.prototype.getcanOpenAndClose_HihokenshaFinder = function () {
                return this.controls.HihokenshaFinder().canOpenAndClose;
            };

            PublicProperties.prototype.setcanOpenAndClose_HihokenshaFinder = function (value) {
                this.controls.HihokenshaFinder().canOpenAndClose = value;
            };

            PublicProperties.prototype.getdisplayNone_saikinShorisha = function () {
                return this.controls.saikinShorisha().Properties().displayNone;
            };

            PublicProperties.prototype.setdisplayNone_saikinShorisha = function (value) {
                this.controls.saikinShorisha().Properties().displayNone = value;
            };

            PublicProperties.prototype.getdisplayNone_ddlHokensha = function () {
                return this.controls.ddlHokensha().displayNone;
            };

            PublicProperties.prototype.setdisplayNone_ddlHokensha = function (value) {
                this.controls.ddlHokensha().displayNone = value;
            };

            PublicProperties.prototype.getdisplayNone_chkMinashiNigo = function () {
                return this.controls.chkMinashiNigo().displayNone;
            };

            PublicProperties.prototype.setdisplayNone_chkMinashiNigo = function (value) {
                this.controls.chkMinashiNigo().displayNone = value;
            };
            return PublicProperties;
        })();
        HihokenshaFinder.PublicProperties = PublicProperties;
    })(DBZ.HihokenshaFinder || (DBZ.HihokenshaFinder = {}));
    var HihokenshaFinder = DBZ.HihokenshaFinder;
})(DBZ || (DBZ = {}));
