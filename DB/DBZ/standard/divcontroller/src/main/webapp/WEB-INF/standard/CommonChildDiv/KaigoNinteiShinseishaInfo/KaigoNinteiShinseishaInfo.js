var DBZ;
(function (DBZ) {
    (function (KaigoNinteiShinseishaInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoNinteiShinseishaInfo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoNinteiShinseishaInfo.PublicProperties(this.fieldName);
            };

            ModeController.prototype.AtenaType = function () {
                return new Modes.AtenaType(this.controls);
            };
            return ModeController;
        })();
        KaigoNinteiShinseishaInfo.ModeController = ModeController;

        (function (Modes) {
            var AtenaType = (function () {
                function AtenaType(controls) {
                    this.controls = controls;
                }
                AtenaType.prototype.AtenaMode = function () {
                    this.controls.ccdKaigoNinteiAtenaInfo().AtenaType().AtenaMode;
                };

                AtenaType.prototype.AtenNoneMode = function () {
                    this.controls.ccdKaigoNinteiAtenaInfo().AtenaType().AtenaNonMode;
                };
                return AtenaType;
            })();
            Modes.AtenaType = AtenaType;
        })(KaigoNinteiShinseishaInfo.Modes || (KaigoNinteiShinseishaInfo.Modes = {}));
        var Modes = KaigoNinteiShinseishaInfo.Modes;
    })(DBZ.KaigoNinteiShinseishaInfo || (DBZ.KaigoNinteiShinseishaInfo = {}));
    var KaigoNinteiShinseishaInfo = DBZ.KaigoNinteiShinseishaInfo;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoNinteiShinseishaInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoNinteiShinseishaInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoNinteiShinseishaInfo.PublicProperties = PublicProperties;
    })(DBZ.KaigoNinteiShinseishaInfo || (DBZ.KaigoNinteiShinseishaInfo = {}));
    var KaigoNinteiShinseishaInfo = DBZ.KaigoNinteiShinseishaInfo;
})(DBZ || (DBZ = {}));
