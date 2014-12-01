var DBZ;
(function (DBZ) {
    (function (KaigoKanryoMessage) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        KaigoKanryoMessage.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KaigoKanryoMessage";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KaigoKanryoMessage.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KaigoKanryoMessage.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KaigoKanryoMessage = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ccdKanryoMessage = function () {
                return new URZ.KanryoMessage.ModeController(this.convFiledName("ccdKanryoMessage"));
            };
            return Controls;
        })();
        KaigoKanryoMessage.Controls = Controls;
    })(DBZ.KaigoKanryoMessage || (DBZ.KaigoKanryoMessage = {}));
    var KaigoKanryoMessage = DBZ.KaigoKanryoMessage;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KaigoKanryoMessage) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoKanryoMessage.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoKanryoMessage.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KaigoKanryoMessage.ModeController = ModeController;
    })(DBZ.KaigoKanryoMessage || (DBZ.KaigoKanryoMessage = {}));
    var KaigoKanryoMessage = DBZ.KaigoKanryoMessage;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoKanryoMessage) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoKanryoMessage.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("KanryoMessage_width", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getKanryoMessage_width = function () {
                return this.controls.ccdKanryoMessage().Properties().width;
            };

            PublicProperties.prototype.setKanryoMessage_width = function (value) {
                this.controls.ccdKanryoMessage().Properties().width = value;
            };
            return PublicProperties;
        })();
        KaigoKanryoMessage.PublicProperties = PublicProperties;
    })(DBZ.KaigoKanryoMessage || (DBZ.KaigoKanryoMessage = {}));
    var KaigoKanryoMessage = DBZ.KaigoKanryoMessage;
})(DBZ || (DBZ = {}));
