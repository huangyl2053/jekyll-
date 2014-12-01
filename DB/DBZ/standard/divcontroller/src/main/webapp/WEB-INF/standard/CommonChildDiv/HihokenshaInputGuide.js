var DBZ;
(function (DBZ) {
    (function (HihokenshaInputGuide) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnReturn = function () {
                return "onClick_btnReturn";
            };
            return Events;
        })();
        HihokenshaInputGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "HihokenshaInputGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.HihokenshaInputGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.HihokenshaInputGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.HihokenshaInputGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.lblSearchResultOfHihokensha = function () {
                return new UZA.Label(this.convFiledName("lblSearchResultOfHihokensha"));
            };

            Controls.prototype.dgSearchResultOfHihokensha = function () {
                return new UZA.DataGrid(this.convFiledName("dgSearchResultOfHihokensha"));
            };

            Controls.prototype.btnReturn = function () {
                return new UZA.Button(this.convFiledName("btnReturn"));
            };
            return Controls;
        })();
        HihokenshaInputGuide.Controls = Controls;
    })(DBZ.HihokenshaInputGuide || (DBZ.HihokenshaInputGuide = {}));
    var HihokenshaInputGuide = DBZ.HihokenshaInputGuide;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (HihokenshaInputGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new HihokenshaInputGuide.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new HihokenshaInputGuide.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        HihokenshaInputGuide.ModeController = ModeController;
    })(DBZ.HihokenshaInputGuide || (DBZ.HihokenshaInputGuide = {}));
    var HihokenshaInputGuide = DBZ.HihokenshaInputGuide;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (HihokenshaInputGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new HihokenshaInputGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        HihokenshaInputGuide.PublicProperties = PublicProperties;
    })(DBZ.HihokenshaInputGuide || (DBZ.HihokenshaInputGuide = {}));
    var HihokenshaInputGuide = DBZ.HihokenshaInputGuide;
})(DBZ || (DBZ = {}));
