var DBZ;
(function (DBZ) {
    (function (PrintContentsSetting) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new PrintContentsSetting.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        PrintContentsSetting.ModeController = ModeController;
    })(DBZ.PrintContentsSetting || (DBZ.PrintContentsSetting = {}));
    var PrintContentsSetting = DBZ.PrintContentsSetting;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (PrintContentsSetting) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new PrintContentsSetting.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("txtSendData_displayNone", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("PrintContentsSetting_title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("PrintContentsSetting_eraseBorder", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettxtSendData_displayNone = function () {
                return this.controls.txtSendDate().displayNone;
            };

            PublicProperties.prototype.settxtSendData_displayNone = function (value) {
                this.controls.txtSendDate().displayNone = value;
            };

            PublicProperties.prototype.getPrintContentsSetting_title = function () {
                return this.controls.PrintContentsSetting().title;
            };

            PublicProperties.prototype.setPrintContentsSetting_title = function (value) {
                this.controls.PrintContentsSetting().title = value;
            };

            PublicProperties.prototype.getPrintContentsSetting_eraseBorder = function () {
                return this.controls.PrintContentsSetting().eraseBorder;
            };

            PublicProperties.prototype.setPrintContentsSetting_eraseBorder = function (value) {
                this.controls.PrintContentsSetting().eraseBorder = value;
            };
            return PublicProperties;
        })();
        PrintContentsSetting.PublicProperties = PublicProperties;
    })(DBZ.PrintContentsSetting || (DBZ.PrintContentsSetting = {}));
    var PrintContentsSetting = DBZ.PrintContentsSetting;
})(DBZ || (DBZ = {}));
