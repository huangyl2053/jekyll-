var DBA;
(function (DBA) {
    (function (ShoKaishuKirokuKanri) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShoKaishuKirokuKanri.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShoKaishuKirokuKanri.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShoKaishuKirokuKanri.ModeController = ModeController;
    })(DBA.ShoKaishuKirokuKanri || (DBA.ShoKaishuKirokuKanri = {}));
    var ShoKaishuKirokuKanri = DBA.ShoKaishuKirokuKanri;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (ShoKaishuKirokuKanri) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShoKaishuKirokuKanri.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShoKaishuKirokuKanri.PublicProperties = PublicProperties;
    })(DBA.ShoKaishuKirokuKanri || (DBA.ShoKaishuKirokuKanri = {}));
    var ShoKaishuKirokuKanri = DBA.ShoKaishuKirokuKanri;
})(DBA || (DBA = {}));
