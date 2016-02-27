var DBC;
(function (DBC) {
    (function (ShokanbaraiketteiJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShokanbaraiketteiJoho.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "State"
                ];
            };

            ModeController.prototype.State = function () {
                return new Modes.State(this.controls);
            };
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShokanbaraiketteiJoho.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        ShokanbaraiketteiJoho.ModeController = ModeController;

        (function (Modes) {
            var State = (function () {
                function State(controls) {
                    this.controls = controls;
                }
                State.prototype.touroku = function () {
                    this.controls.txtKetebi().disabled = false;
                    this.controls.rdoShikyukubun().disabled = false;
                    this.controls.txtZogenriyu().disabled = false;
                    this.controls.txtShiharaikingakugoke().disabled = false;
                    this.controls.txtZogentani().disabled = false;
                    this.controls.txtFuSyikyuriyu1().disabled = false;
                    this.controls.txtFushikyuriyu2().disabled = true;
                };

                State.prototype.sagakutouroku = function () {
                    this.controls.txtKetebi().disabled = false;
                    this.controls.rdoShikyukubun().disabled = false;
                    this.controls.txtZogenriyu().disabled = false;
                    this.controls.txtShiharaikingakugoke().disabled = false;
                    this.controls.txtZogentani().disabled = false;
                    this.controls.txtFuSyikyuriyu1().disabled = false;
                    this.controls.txtFushikyuriyu2().disabled = true;
                };
                State.prototype.sansyo = function () {
                    this.controls.txtKetebi().disabled = true;
                    this.controls.rdoShikyukubun().disabled = true;
                    this.controls.txtZogenriyu().disabled = true;
                    this.controls.txtShiharaikingakugoke().disabled = true;
                    this.controls.txtZogentani().disabled = true;
                    this.controls.txtFuSyikyuriyu1().disabled = true;
                    this.controls.txtFushikyuriyu2().disabled = true;
                };
                return State;
            })();
            Modes.State = State;
        })(ShokanbaraiketteiJoho.Modes || (ShokanbaraiketteiJoho.Modes = {}));
        var Modes = ShokanbaraiketteiJoho.Modes;
    })(DBC.ShokanbaraiketteiJoho || (DBC.ShokanbaraiketteiJoho = {}));
    var ShokanbaraiketteiJoho = DBC.ShokanbaraiketteiJoho;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (ShokanbaraiketteiJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.getGyomuCode = function () {
                    return this.controls.lblGyomuCode().text;
                };
                this.setGyomuCode = function (value) {
                    this.controls.lblGyomuCode().text = value;
                };
                this.fieldName = fieldName;
                this.controls = new ShokanbaraiketteiJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();
                editTypes.addEditType("GyomuCode", UZA.EditTypeEnumForPublicProperty.StringType);

                return editTypes;
            };
            return PublicProperties;
        })();
        ShokanbaraiketteiJoho.PublicProperties = PublicProperties;
    })(DBC.ShokanbaraiketteiJoho || (DBC.ShokanbaraiketteiJoho = {}));
    var ShokanbaraiketteiJoho = DBC.ShokanbaraiketteiJoho;
})(DBC || (DBC = {}));
