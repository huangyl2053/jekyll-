var DBZ;
(function (DBZ) {
    (function (KaigoBunshoBangoInput) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoBunshoBangoInput.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoBunshoBangoInput.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoBunshoBangoInput.ModeController = ModeController;
    })(DBZ.KaigoBunshoBangoInput || (DBZ.KaigoBunshoBangoInput = {}));
    var KaigoBunshoBangoInput = DBZ.KaigoBunshoBangoInput;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoBunshoBangoInput) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoBunshoBangoInput.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoBunshoBangoInput.PublicProperties = PublicProperties;
    })(DBZ.KaigoBunshoBangoInput || (DBZ.KaigoBunshoBangoInput = {}));
    var KaigoBunshoBangoInput = DBZ.KaigoBunshoBangoInput;
})(DBZ || (DBZ = {}));
