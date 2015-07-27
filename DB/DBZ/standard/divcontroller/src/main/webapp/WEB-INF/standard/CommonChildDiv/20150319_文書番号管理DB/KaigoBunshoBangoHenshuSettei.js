var DBZ;
(function (DBZ) {
    (function (KaigoBunshoBangoHenshuSettei) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoBunshoBangoHenshuSettei.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoBunshoBangoHenshuSettei.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoBunshoBangoHenshuSettei.ModeController = ModeController;
    })(DBZ.KaigoBunshoBangoHenshuSettei || (DBZ.KaigoBunshoBangoHenshuSettei = {}));
    var KaigoBunshoBangoHenshuSettei = DBZ.KaigoBunshoBangoHenshuSettei;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoBunshoBangoHenshuSettei) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoBunshoBangoHenshuSettei.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoBunshoBangoHenshuSettei.PublicProperties = PublicProperties;
    })(DBZ.KaigoBunshoBangoHenshuSettei || (DBZ.KaigoBunshoBangoHenshuSettei = {}));
    var KaigoBunshoBangoHenshuSettei = DBZ.KaigoBunshoBangoHenshuSettei;
})(DBZ || (DBZ = {}));
