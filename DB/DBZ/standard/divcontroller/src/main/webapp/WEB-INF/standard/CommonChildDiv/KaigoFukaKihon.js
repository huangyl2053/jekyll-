var DBZ;
(function (DBZ) {
    (function (KaigoFukaKihon) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoFukaKihon.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoFukaKihon";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoFukaKihon.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoFukaKihon.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoFukaKihon = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtTsuchishoNo = function () {
                return new UZA.TextBox(this.convFiledName("txtTsuchishoNo"));
            };

            Controls.prototype.txtHihokenshaNo = function () {
                return new UZA.TextBox(this.convFiledName("txtHihokenshaNo"));
            };

            Controls.prototype.txtHokenryoDankai = function () {
                return new UZA.TextBox(this.convFiledName("txtHokenryoDankai"));
            };

            Controls.prototype.txtShutokuYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtShutokuYmd"));
            };

            Controls.prototype.txtShutokuJiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtShutokuJiyu"));
            };

            Controls.prototype.txtSoshitsuYmd = function () {
                return new UZA.TextBoxDate(this.convFiledName("txtSoshitsuYmd"));
            };

            Controls.prototype.txtSoshitsuJiyu = function () {
                return new UZA.TextBox(this.convFiledName("txtSoshitsuJiyu"));
            };

            Controls.prototype.btnHihoRireki = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHihoRireki"));
            };
            return Controls;
        })();
        KaigoFukaKihon.Controls = Controls;
    })(DBZ.KaigoFukaKihon || (DBZ.KaigoFukaKihon = {}));
    var KaigoFukaKihon = DBZ.KaigoFukaKihon;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
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
    })(DBZ.KaigoFukaKihon || (DBZ.KaigoFukaKihon = {}));
    var KaigoFukaKihon = DBZ.KaigoFukaKihon;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
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
    })(DBZ.KaigoFukaKihon || (DBZ.KaigoFukaKihon = {}));
    var KaigoFukaKihon = DBZ.KaigoFukaKihon;
})(DBZ || (DBZ = {}));
