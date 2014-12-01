var DBZ;
(function (DBZ) {
    (function (ShichosonSelector) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnReturn = function () {
                return "onClick_btnReturn";
            };

            Events.onClick_btnDecision = function () {
                return "onClick_btnDecision";
            };
            return Events;
        })();
        ShichosonSelector.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShichosonSelector";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShichosonSelector.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShichosonSelector.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShichosonSelector = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgShichoson = function () {
                return new UZA.DataGrid(this.convFiledName("dgShichoson"));
            };

            Controls.prototype.btnReturn = function () {
                return new UZA.Button(this.convFiledName("btnReturn"));
            };

            Controls.prototype.btnDecision = function () {
                return new UZA.Button(this.convFiledName("btnDecision"));
            };
            return Controls;
        })();
        ShichosonSelector.Controls = Controls;
    })(DBZ.ShichosonSelector || (DBZ.ShichosonSelector = {}));
    var ShichosonSelector = DBZ.ShichosonSelector;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (ShichosonSelector) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShichosonSelector.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShichosonSelector.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShichosonSelector.ModeController = ModeController;
    })(DBZ.ShichosonSelector || (DBZ.ShichosonSelector = {}));
    var ShichosonSelector = DBZ.ShichosonSelector;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShichosonSelector) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShichosonSelector.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShichosonSelector.PublicProperties = PublicProperties;
    })(DBZ.ShichosonSelector || (DBZ.ShichosonSelector = {}));
    var ShichosonSelector = DBZ.ShichosonSelector;
})(DBZ || (DBZ = {}));
