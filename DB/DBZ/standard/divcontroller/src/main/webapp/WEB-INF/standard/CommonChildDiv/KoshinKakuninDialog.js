var DBZ;
(function (DBZ) {
    (function (KoshinKakuninDialog) {
        var Events = (function () {
            function Events() {
            }
            Events.CloseOK = function () {
                return "CloseOK";
            };

            Events.CloseCancel = function () {
                return "CloseCancel";
            };
            return Events;
        })();
        KoshinKakuninDialog.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KoshinKakuninDialog";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.KoshinKakuninDialog.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.KoshinKakuninDialog.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KoshinKakuninDialog = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.lblKoshinMassage = function () {
                return new UZA.Label(this.convFiledName("lblKoshinMassage"));
            };

            Controls.prototype.btnYes = function () {
                return new UZA.Button(this.convFiledName("btnYes"));
            };

            Controls.prototype.btnNo = function () {
                return new UZA.Button(this.convFiledName("btnNo"));
            };
            return Controls;
        })();
        KoshinKakuninDialog.Controls = Controls;
    })(DBZ.KoshinKakuninDialog || (DBZ.KoshinKakuninDialog = {}));
    var KoshinKakuninDialog = DBZ.KoshinKakuninDialog;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KoshinKakuninDialog) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KoshinKakuninDialog.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KoshinKakuninDialog.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        KoshinKakuninDialog.ModeController = ModeController;
    })(DBZ.KoshinKakuninDialog || (DBZ.KoshinKakuninDialog = {}));
    var KoshinKakuninDialog = DBZ.KoshinKakuninDialog;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KoshinKakuninDialog) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new KoshinKakuninDialog.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KoshinKakuninDialog.PublicProperties = PublicProperties;
    })(DBZ.KoshinKakuninDialog || (DBZ.KoshinKakuninDialog = {}));
    var KoshinKakuninDialog = DBZ.KoshinKakuninDialog;
})(DBZ || (DBZ = {}));
