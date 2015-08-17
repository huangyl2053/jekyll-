var DBX;
(function (DBX) {
    (function (KaigoJigyoshaServiceList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoJigyoshaServiceList.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoJigyoshaServiceList.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoJigyoshaServiceList.ModeController = ModeController;
    })(DBX.KaigoJigyoshaServiceList || (DBX.KaigoJigyoshaServiceList = {}));
    var KaigoJigyoshaServiceList = DBX.KaigoJigyoshaServiceList;
})(DBX || (DBX = {}));

var DBX;
(function (DBX) {
    (function (KaigoJigyoshaServiceList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoJigyoshaServiceList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoJigyoshaServiceList.PublicProperties = PublicProperties;
    })(DBX.KaigoJigyoshaServiceList || (DBX.KaigoJigyoshaServiceList = {}));
    var KaigoJigyoshaServiceList = DBX.KaigoJigyoshaServiceList;
})(DBX || (DBX = {}));
