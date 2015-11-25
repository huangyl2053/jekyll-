var DBA;
(function (DBA) {
    (function (JukyuSikakuShomeishoHakkoCommonChildDiv) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JukyuSikakuShomeishoHakkoCommonChildDiv.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new JukyuSikakuShomeishoHakkoCommonChildDiv.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        JukyuSikakuShomeishoHakkoCommonChildDiv.ModeController = ModeController;
    })(DBA.JukyuSikakuShomeishoHakkoCommonChildDiv || (DBA.JukyuSikakuShomeishoHakkoCommonChildDiv = {}));
    var JukyuSikakuShomeishoHakkoCommonChildDiv = DBA.JukyuSikakuShomeishoHakkoCommonChildDiv;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (JukyuSikakuShomeishoHakkoCommonChildDiv) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JukyuSikakuShomeishoHakkoCommonChildDiv.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JukyuSikakuShomeishoHakkoCommonChildDiv.PublicProperties = PublicProperties;
    })(DBA.JukyuSikakuShomeishoHakkoCommonChildDiv || (DBA.JukyuSikakuShomeishoHakkoCommonChildDiv = {}));
    var JukyuSikakuShomeishoHakkoCommonChildDiv = DBA.JukyuSikakuShomeishoHakkoCommonChildDiv;
})(DBA || (DBA = {}));
