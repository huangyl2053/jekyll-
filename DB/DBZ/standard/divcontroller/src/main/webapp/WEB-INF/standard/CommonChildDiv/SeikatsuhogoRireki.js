var DBZ;
(function (DBZ) {
    (function (SeikatsuhogoRireki) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        SeikatsuhogoRireki.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SeikatsuhogoRireki";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SeikatsuhogoRireki.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SeikatsuhogoRireki.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SeikatsuhogoRireki = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAddRow = function () {
                return new UZA.Button(this.convFiledName("btnAddRow"));
            };

            Controls.prototype.dgSeikatsuhogoRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgSeikatsuhogoRireki"));
            };
            return Controls;
        })();
        SeikatsuhogoRireki.Controls = Controls;
    })(DBZ.SeikatsuhogoRireki || (DBZ.SeikatsuhogoRireki = {}));
    var SeikatsuhogoRireki = DBZ.SeikatsuhogoRireki;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (SeikatsuhogoRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SeikatsuhogoRireki.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SeikatsuhogoRireki.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SeikatsuhogoRireki.ModeController = ModeController;
    })(DBZ.SeikatsuhogoRireki || (DBZ.SeikatsuhogoRireki = {}));
    var SeikatsuhogoRireki = DBZ.SeikatsuhogoRireki;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SeikatsuhogoRireki) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SeikatsuhogoRireki.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SeikatsuhogoRireki.PublicProperties = PublicProperties;
    })(DBZ.SeikatsuhogoRireki || (DBZ.SeikatsuhogoRireki = {}));
    var SeikatsuhogoRireki = DBZ.SeikatsuhogoRireki;
})(DBZ || (DBZ = {}));
