var DBD;
(function (DBD) {
    (function (FutanGendogakuNintei) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new FutanGendogakuNintei.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        FutanGendogakuNintei.ModeController = ModeController;
    })(DBD.FutanGendogakuNintei || (DBD.FutanGendogakuNintei = {}));
    var FutanGendogakuNintei = DBD.FutanGendogakuNintei;
})(DBD || (DBD = {}));

var DBD;
(function (DBD) {
    (function (FutanGendogakuNintei) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new FutanGendogakuNintei.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("visible_Kyusochisha", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.getvisible_Kyusochisha = function () {
                return this.controls.txtKyushochisha().visible;
            };

            PublicProperties.prototype.setvisible_Kyusochisha = function (value) {
                this.controls.txtKyushochisha().visible = value;
            };
            return PublicProperties;
        })();
        FutanGendogakuNintei.PublicProperties = PublicProperties;
    })(DBD.FutanGendogakuNintei || (DBD.FutanGendogakuNintei = {}));
    var FutanGendogakuNintei = DBD.FutanGendogakuNintei;
})(DBD || (DBD = {}));
