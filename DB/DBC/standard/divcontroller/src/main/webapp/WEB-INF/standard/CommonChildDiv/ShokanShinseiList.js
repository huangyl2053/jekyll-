var DBC;
(function (DBC) {
    (function (ShokanShinseiList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShokanShinseiList.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShokanShinseiList.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "DisplayType"
                ];
            };

            ModeController.prototype.DisplayType = function () {
                return new Modes.DisplayType(this.controls);
            };
            return ModeController;
        })();
        ShokanShinseiList.ModeController = ModeController;

        (function (Modes) {
            var DisplayType = (function () {
                function DisplayType(controls) {
                    this.controls = controls;
                }
                DisplayType.prototype.shokai = function () {
                    this.controls.txtServiceYM().displayNone = true;
                    this.controls.btnAdd().displayNone = true;
                    this.controls.line().displayNone = true;
                    this.controls.dgShinseiList().marginRight = 40;
                    this.controls.ShokanShinseiList().width = "G12";

                    this.controls.dgShinseiList().readOnly = true;
                    this.controls.dgShinseiList().width = 510;

                    var gridSetting = this.controls.dgShinseiList().gridSetting;

                    gridSetting.isShowSelectButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgShinseiList().gridSetting = gridSetting;

                    this.controls.dgShinseiList()._control.afterPropertiesSet();
                };

                DisplayType.prototype.toroku = function () {
                    this.controls.txtServiceYM().displayNone = false;
                    this.controls.btnAdd().displayNone = false;
                    this.controls.line().displayNone = false;

                    this.controls.ShokanShinseiList().width = "G12";

                    this.controls.dgShinseiList().readOnly = true;
                    this.controls.dgShinseiList().width = 580;

                    var gridSetting = this.controls.dgShinseiList().gridSetting;

                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgShinseiList().gridSetting = gridSetting;

                    this.controls.dgShinseiList()._control.afterPropertiesSet();
                };
                return DisplayType;
            })();
            Modes.DisplayType = DisplayType;
        })(ShokanShinseiList.Modes || (ShokanShinseiList.Modes = {}));
        var Modes = ShokanShinseiList.Modes;
    })(DBC.ShokanShinseiList || (DBC.ShokanShinseiList = {}));
    var ShokanShinseiList = DBC.ShokanShinseiList;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (ShokanShinseiList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShokanShinseiList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShokanShinseiList.PublicProperties = PublicProperties;
    })(DBC.ShokanShinseiList || (DBC.ShokanShinseiList = {}));
    var ShokanShinseiList = DBC.ShokanShinseiList;
})(DBC || (DBC = {}));
