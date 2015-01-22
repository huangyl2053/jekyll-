var DBC;
(function (DBC) {
    (function (SearchServiceCodeDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SearchServiceCodeDialog.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        SearchServiceCodeDialog.ModeController = ModeController;
    })(DBC.SearchServiceCodeDialog || (DBC.SearchServiceCodeDialog = {}));
    var SearchServiceCodeDialog = DBC.SearchServiceCodeDialog;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (SearchServiceCodeDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SearchServiceCodeDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("onClickDialogBtnCancel", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getonClickDialogBtnCancel = function () {
                return this.controls.btnCancel().onClick;
            };

            PublicProperties.prototype.setonClickDialogBtnCancel = function (value) {
                this.controls.btnCancel().onClick = value;
            };
            return PublicProperties;
        })();
        SearchServiceCodeDialog.PublicProperties = PublicProperties;
    })(DBC.SearchServiceCodeDialog || (DBC.SearchServiceCodeDialog = {}));
    var SearchServiceCodeDialog = DBC.SearchServiceCodeDialog;
})(DBC || (DBC = {}));
