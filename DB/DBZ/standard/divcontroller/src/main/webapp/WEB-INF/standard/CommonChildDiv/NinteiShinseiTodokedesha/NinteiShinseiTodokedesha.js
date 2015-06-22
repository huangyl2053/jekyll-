var DBZ;
(function (DBZ) {
    (function (NinteiShinseiTodokedesha) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiShinseiTodokedesha.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new NinteiShinseiTodokedesha.PublicProperties(this.fieldName);
            };

            ModeController.prototype.ShoriType = function () {
                return new Modes.ShoriType(this.controls);
            };
            ModeController.prototype.AtenaType = function () {
                return new Modes.AtenaType(this.controls);
            };
            return ModeController;
        })();
        NinteiShinseiTodokedesha.ModeController = ModeController;

        (function (Modes) {
            var ShoriType = (function () {
                function ShoriType(controls) {
                    this.controls = controls;
                }
                ShoriType.prototype.InputMode = function () {
                    this.controls.ddlTodokledeDaikoKubun().readOnly = false;
                    this.controls.btnZenkaiFukusha().disabled = false;
                    this.controls.txtShimei().readOnly = false;
                    this.controls.txtKanaShimei().readOnly = false;
                    this.controls.txtHonninKankeisei().readOnly = false;
                    this.controls.txtYubinNo().readOnly = false;
                    this.controls.txtJusho().readOnly = false;
                    this.controls.txtTelNo().readOnly = false;
                };

                ShoriType.prototype.ShgokaiMode = function () {
                    this.controls.ddlTodokledeDaikoKubun().readOnly = true;
                    this.controls.btnZenkaiFukusha().disabled = true;
                    this.controls.txtShimei().readOnly = true;
                    this.controls.txtKanaShimei().readOnly = true;
                    this.controls.txtHonninKankeisei().readOnly = true;
                    this.controls.txtYubinNo().readOnly = true;
                    this.controls.txtJusho().readOnly = true;
                    this.controls.txtTelNo().readOnly = true;
                };
                return ShoriType;
            })();
            Modes.ShoriType = ShoriType;
            var AtenaType = (function () {
                function AtenaType(controls) {
                    this.controls = controls;
                }
                AtenaType.prototype.AtenaMode = function () {
                };

                AtenaType.prototype.AtenaNonMode = function () {
                };
                return AtenaType;
            })();
            Modes.AtenaType = AtenaType;
        })(NinteiShinseiTodokedesha.Modes || (NinteiShinseiTodokedesha.Modes = {}));
        var Modes = NinteiShinseiTodokedesha.Modes;
    })(DBZ.NinteiShinseiTodokedesha || (DBZ.NinteiShinseiTodokedesha = {}));
    var NinteiShinseiTodokedesha = DBZ.NinteiShinseiTodokedesha;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (NinteiShinseiTodokedesha) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiShinseiTodokedesha.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        NinteiShinseiTodokedesha.PublicProperties = PublicProperties;
    })(DBZ.NinteiShinseiTodokedesha || (DBZ.NinteiShinseiTodokedesha = {}));
    var NinteiShinseiTodokedesha = DBZ.NinteiShinseiTodokedesha;
})(DBZ || (DBZ = {}));
