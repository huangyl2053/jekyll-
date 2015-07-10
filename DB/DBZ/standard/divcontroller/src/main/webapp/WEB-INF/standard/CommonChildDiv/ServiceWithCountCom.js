var DBE;
(function (DBE) {
    (function (ServiceWithCountCom) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ServiceWithCountCom.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ServiceWithCountCom.ModeController = ModeController;
    })(DBE.ServiceWithCountCom || (DBE.ServiceWithCountCom = {}));
    var ServiceWithCountCom = DBE.ServiceWithCountCom;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (ServiceWithCountCom) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ServiceWithCountCom.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("text_ServiceName", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("text_Frequency", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("text_Unit", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("radKaigoOrYobo_dataSource", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.gettext_ServiceName = function () {
                return this.controls.lblServiceName().text;
            };

            PublicProperties.prototype.settext_ServiceName = function (value) {
                this.controls.lblServiceName().text = value;
            };

            PublicProperties.prototype.gettext_Frequency = function () {
                return this.controls.txtNum().labelLText;
            };

            PublicProperties.prototype.settext_Frequency = function (value) {
                this.controls.txtNum().labelLText = value;
            };

            PublicProperties.prototype.gettext_Unit = function () {
                return this.controls.txtNum().labelRText;
            };

            PublicProperties.prototype.settext_Unit = function (value) {
                this.controls.txtNum().labelRText = value;
            };

            PublicProperties.prototype.getradKaigoOrYobo_dataSource = function () {
                return this.controls.radKaigoOrYobo().selectedItem;
            };

            PublicProperties.prototype.setradKaigoOrYobo_dataSource = function (value) {
                this.controls.radKaigoOrYobo().selectedItem = value;
            };
            return PublicProperties;
        })();
        ServiceWithCountCom.PublicProperties = PublicProperties;
    })(DBE.ServiceWithCountCom || (DBE.ServiceWithCountCom = {}));
    var ServiceWithCountCom = DBE.ServiceWithCountCom;
})(DBE || (DBE = {}));
