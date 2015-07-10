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
