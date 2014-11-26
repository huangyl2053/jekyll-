var DBC;
(function (DBC) {
    (function (JutakuKaishuShinseiDetailInput) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JutakuKaishuShinseiDetailInput.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        JutakuKaishuShinseiDetailInput.ModeController = ModeController;
    })(DBC.JutakuKaishuShinseiDetailInput || (DBC.JutakuKaishuShinseiDetailInput = {}));
    var JutakuKaishuShinseiDetailInput = DBC.JutakuKaishuShinseiDetailInput;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (JutakuKaishuShinseiDetailInput) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new JutakuKaishuShinseiDetailInput.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtChakkoDate_lableLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("txtKanseiDate_lableLText", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onClick_btnModifyDetail", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("btnModify_text", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("dg_gridSetting", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettxtChakkoDate_lableLText = function () {
                return this.controls.txtChakkoDueDate().labelLText;
            };

            PublicProperties.prototype.settxtChakkoDate_lableLText = function (value) {
                this.controls.txtChakkoDueDate().labelLText = value;
            };

            PublicProperties.prototype.gettxtKanseiDate_lableLText = function () {
                return this.controls.txtKanseiDueDate().labelLText;
            };

            PublicProperties.prototype.settxtKanseiDate_lableLText = function (value) {
                this.controls.txtKanseiDueDate().labelLText = value;
            };

            PublicProperties.prototype.getonClick_btnModifyDetail = function () {
                return this.controls.btnModifyDetail().onClick;
            };

            PublicProperties.prototype.setonClick_btnModifyDetail = function (value) {
                this.controls.btnModifyDetail().onClick = value;
            };

            PublicProperties.prototype.getbtnModify_text = function () {
                return this.controls.btnModifyDetail().text;
            };

            PublicProperties.prototype.setbtnModify_text = function (value) {
                this.controls.btnModifyDetail().text = value;
            };

            PublicProperties.prototype.getdg_gridSetting = function () {
                return this.controls.dgJutakuKaishuDetail().gridSetting;
            };

            PublicProperties.prototype.setdg_gridSetting = function (value) {
                this.controls.dgJutakuKaishuDetail().gridSetting = value;
            };
            return PublicProperties;
        })();
        JutakuKaishuShinseiDetailInput.PublicProperties = PublicProperties;
    })(DBC.JutakuKaishuShinseiDetailInput || (DBC.JutakuKaishuShinseiDetailInput = {}));
    var JutakuKaishuShinseiDetailInput = DBC.JutakuKaishuShinseiDetailInput;
})(DBC || (DBC = {}));
