var DBB;
(function (DBB) {
    (function (KaigoFukaKihon) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoFukaKihon.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoFukaKihon.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoFukaKihon.ModeController = ModeController;
    })(DBB.KaigoFukaKihon || (DBB.KaigoFukaKihon = {}));
    var KaigoFukaKihon = DBB.KaigoFukaKihon;
})(DBB || (DBB = {}));

var DBB;
(function (DBB) {
    (function (KaigoFukaKihon) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KaigoFukaKihon.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("title", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("canOpenAndClose", UZA.EditTypeEnumForPublicProperty.BooleanType);
                editTypes.addEditType("eraseBorder", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("backGroundColor", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("btnHihoRireki_visible", UZA.EditTypeEnumForPublicProperty.BooleanType);
                return editTypes;
            };

            PublicProperties.prototype.gettitle = function () {
                return this.controls.KaigoFukaKihon().title;
            };

            PublicProperties.prototype.settitle = function (value) {
                this.controls.KaigoFukaKihon().title = value;
            };

            PublicProperties.prototype.getcanOpenAndClose = function () {
                return this.controls.KaigoFukaKihon().canOpenAndClose;
            };

            PublicProperties.prototype.setcanOpenAndClose = function (value) {
                this.controls.KaigoFukaKihon().canOpenAndClose = value;
            };

            PublicProperties.prototype.geteraseBorderTop = function () {
                return this.controls.KaigoFukaKihon().eraseBorder;
            };

            PublicProperties.prototype.seteraseBorderTop = function (value) {
                this.controls.KaigoFukaKihon().eraseBorder = value;
            };

            PublicProperties.prototype.getbackGroundColor = function () {
                return this.controls.KaigoFukaKihon().backgroundColor;
            };

            PublicProperties.prototype.setbackGroundColor = function (value) {
                this.controls.KaigoFukaKihon().backgroundColor = value;
            };

            PublicProperties.prototype.getbtnHihoRireki_visible = function () {
                return this.controls.btnHihoRireki().visible;
            };

            PublicProperties.prototype.setbtnHihoRireki_visible = function (value) {
                this.controls.btnHihoRireki().visible = value;
            };
            return PublicProperties;
        })();
        KaigoFukaKihon.PublicProperties = PublicProperties;
    })(DBB.KaigoFukaKihon || (DBB.KaigoFukaKihon = {}));
    var KaigoFukaKihon = DBB.KaigoFukaKihon;
})(DBB || (DBB = {}));
