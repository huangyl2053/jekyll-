var DBC;
(function (DBC) {
    (function (YokaigoninteiJigyotaishoRirekiList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new YokaigoninteiJigyotaishoRirekiList.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new YokaigoninteiJigyotaishoRirekiList.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        YokaigoninteiJigyotaishoRirekiList.ModeController = ModeController;
    })(DBC.YokaigoninteiJigyotaishoRirekiList || (DBC.YokaigoninteiJigyotaishoRirekiList = {}));
    var YokaigoninteiJigyotaishoRirekiList = DBC.YokaigoninteiJigyotaishoRirekiList;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (YokaigoninteiJigyotaishoRirekiList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new YokaigoninteiJigyotaishoRirekiList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        YokaigoninteiJigyotaishoRirekiList.PublicProperties = PublicProperties;
    })(DBC.YokaigoninteiJigyotaishoRirekiList || (DBC.YokaigoninteiJigyotaishoRirekiList = {}));
    var YokaigoninteiJigyotaishoRirekiList = DBC.YokaigoninteiJigyotaishoRirekiList;
})(DBC || (DBC = {}));
