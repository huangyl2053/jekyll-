var DBZ;
(function (DBZ) {
    (function (ChosaJisshishaJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaJisshishaJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ChosaJisshishaJoho.PublicProperties(this.fieldName);
            };

            ModeController.prototype.State = function () {
                return new Modes.State(this.controls);
            };
            return ModeController;
        })();
        ChosaJisshishaJoho.ModeController = ModeController;

        (function (Modes) {
            var State = (function () {
                function State(controls) {
                    this.controls = controls;
                }
                State.prototype.Input = function () {
                    this.controls.txtChosaJisshiDate().readOnly = false;
                    this.controls.ddlChosaJisshiBasho().readOnly = false;
                    this.controls.txtJisshiBashoMeisho().readOnly = false;
                    this.controls.ddlShozokuKikan().readOnly = false;
                    this.controls.ddlKinyusha().readOnly = false;
                    this.controls.txtChosaKubun().readOnly = true;
                    this.controls.txtChosaJisshiDate().required = true;
                    this.controls.ddlChosaJisshiBasho().required = true;
                    this.controls.txtJisshiBashoMeisho().required = true;
                    this.controls.ddlShozokuKikan().required = true;
                    this.controls.ddlKinyusha().required = true;
                };

                State.prototype.Shokai = function () {
                    this.controls.txtChosaJisshiDate().readOnly = true;
                    this.controls.ddlChosaJisshiBasho().readOnly = true;
                    this.controls.txtJisshiBashoMeisho().readOnly = true;
                    this.controls.ddlShozokuKikan().readOnly = true;
                    this.controls.ddlKinyusha().readOnly = true;
                    this.controls.txtChosaKubun().readOnly = true;
                    this.controls.txtChosaJisshiDate().required = false;
                    this.controls.ddlChosaJisshiBasho().required = false;
                    this.controls.txtJisshiBashoMeisho().required = false;
                    this.controls.ddlShozokuKikan().required = false;
                    this.controls.ddlKinyusha().required = false;
                };
                return State;
            })();
            Modes.State = State;
        })(ChosaJisshishaJoho.Modes || (ChosaJisshishaJoho.Modes = {}));
        var Modes = ChosaJisshishaJoho.Modes;
    })(DBZ.ChosaJisshishaJoho || (DBZ.ChosaJisshishaJoho = {}));
    var ChosaJisshishaJoho = DBZ.ChosaJisshishaJoho;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ChosaJisshishaJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaJisshishaJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ChosaJisshishaJoho.PublicProperties = PublicProperties;
    })(DBZ.ChosaJisshishaJoho || (DBZ.ChosaJisshishaJoho = {}));
    var ChosaJisshishaJoho = DBZ.ChosaJisshishaJoho;
})(DBZ || (DBZ = {}));
