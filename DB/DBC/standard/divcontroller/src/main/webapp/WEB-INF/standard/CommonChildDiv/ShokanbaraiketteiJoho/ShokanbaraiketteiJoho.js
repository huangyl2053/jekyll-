var DBC;
(function (DBC) {
    (function (ShokanbaraiketteiJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShokanbaraiketteiJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShokanbaraiketteiJoho.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShokanbaraiketteiJoho.ModeController = ModeController;
    })(DBC.ShokanbaraiketteiJoho || (DBC.ShokanbaraiketteiJoho = {}));
    var ShokanbaraiketteiJoho = DBC.ShokanbaraiketteiJoho;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (ShokanbaraiketteiJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShokanbaraiketteiJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShokanbaraiketteiJoho.PublicProperties = PublicProperties;
    })(DBC.ShokanbaraiketteiJoho || (DBC.ShokanbaraiketteiJoho = {}));
    var ShokanbaraiketteiJoho = DBC.ShokanbaraiketteiJoho;
})(DBC || (DBC = {}));
