var DBZ;
(function (DBZ) {
    (function (HokenshaJoho) {
        var Events = (function () {
            function Events() {
            }
            Events.onBlur_txtHokenshaNo = function () {
                return "onBlur_txtHokenshaNo";
            };
            return Events;
        })();
        HokenshaJoho.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "HokenshaJoho";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.HokenshaJoho.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.HokenshaJoho.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.HokenshaJoho = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtHokenshaNo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtHokenshaNo"));
            };

            Controls.prototype.btnHokenshaSelect = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHokenshaSelect"));
            };

            Controls.prototype.txtHokenshaMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtHokenshaMeisho"));
            };
            return Controls;
        })();
        HokenshaJoho.Controls = Controls;
    })(DBZ.HokenshaJoho || (DBZ.HokenshaJoho = {}));
    var HokenshaJoho = DBZ.HokenshaJoho;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (HokenshaJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HokenshaJoho.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new HokenshaJoho.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        HokenshaJoho.ModeController = ModeController;
    })(DBZ.HokenshaJoho || (DBZ.HokenshaJoho = {}));
    var HokenshaJoho = DBZ.HokenshaJoho;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (HokenshaJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new HokenshaJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        HokenshaJoho.PublicProperties = PublicProperties;
    })(DBZ.HokenshaJoho || (DBZ.HokenshaJoho = {}));
    var HokenshaJoho = DBZ.HokenshaJoho;
})(DBZ || (DBZ = {}));
