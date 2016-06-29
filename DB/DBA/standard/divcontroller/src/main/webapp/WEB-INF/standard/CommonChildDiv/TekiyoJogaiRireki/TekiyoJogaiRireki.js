var DBA;
(function (DBA) {
    (function (TekiyoJogaiRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TekiyoJogaiRireki.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new TekiyoJogaiRireki.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        TekiyoJogaiRireki.ModeController = ModeController;
    })(DBA.TekiyoJogaiRireki || (DBA.TekiyoJogaiRireki = {}));
    var TekiyoJogaiRireki = DBA.TekiyoJogaiRireki;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (TekiyoJogaiRireki) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TekiyoJogaiRireki.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TekiyoJogaiRireki.PublicProperties = PublicProperties;
    })(DBA.TekiyoJogaiRireki || (DBA.TekiyoJogaiRireki = {}));
    var TekiyoJogaiRireki = DBA.TekiyoJogaiRireki;
})(DBA || (DBA = {}));
