var DBC;
(function (DBC) {
    (function (SyokanbaraiketeJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SyokanbaraiketeJoho.Controls(fieldName);
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
                return new SyokanbaraiketeJoho.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SyokanbaraiketeJoho.ModeController = ModeController;

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
        })(SyokanbaraiketeJoho.Modes || (SyokanbaraiketeJoho.Modes = {}));
        var Modes = SyokanbaraiketeJoho.Modes;
    })(DBC.SyokanbaraiketeJoho || (DBC.SyokanbaraiketeJoho = {}));
    var SyokanbaraiketeJoho = DBC.SyokanbaraiketeJoho;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (SyokanbaraiketeJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SyokanbaraiketeJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SyokanbaraiketeJoho.PublicProperties = PublicProperties;
    })(DBC.SyokanbaraiketeJoho || (DBC.SyokanbaraiketeJoho = {}));
    var SyokanbaraiketeJoho = DBC.SyokanbaraiketeJoho;
})(DBC || (DBC = {}));
