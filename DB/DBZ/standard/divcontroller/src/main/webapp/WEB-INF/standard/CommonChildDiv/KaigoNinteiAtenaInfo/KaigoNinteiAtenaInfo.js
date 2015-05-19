var DBZ;
(function (DBZ) {
    (function (KaigoNinteiAtenaInfo) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoNinteiAtenaInfo.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoNinteiAtenaInfo.PublicProperties(this.fieldName);
            };

            ModeController.prototype.AtenaType = function () {
                return new Modes.AtenaType(this.controls);
            };
            ModeController.prototype.ShoriType = function () {
                return new Modes.ShoriType(this.controls);
            };
            return ModeController;
        })();
        KaigoNinteiAtenaInfo.ModeController = ModeController;

        (function (Modes) {
            var AtenaType = (function () {
                function AtenaType(controls) {
                    this.controls = controls;
                }
                AtenaType.prototype.AtenaMode = function () {
                    this.controls.imgJuminShubetsu().displayNone = false;
                    this.controls.txtJuminShubetsu().displayNone = false;
                    this.controls.txtShikiBetsuCode().displayNone = false;
                    this.controls.btnKojinMemo().displayNone = false;
                    this.controls.txtKojinNo().displayNone = false;
                    this.controls.txtGyoseiku().displayNone = false;
                    this.controls.txtSetaiCode().displayNone = false;
                    this.controls.btnSetaiMemo().displayNone = false;
                };
                AtenaType.prototype.AtenaNonMode = function () {
                    this.controls.imgJuminShubetsu().displayNone = true;
                    this.controls.txtJuminShubetsu().displayNone = true;
                    this.controls.txtShikiBetsuCode().displayNone = true;
                    this.controls.btnKojinMemo().displayNone = true;
                    this.controls.txtKojinNo().displayNone = true;
                    this.controls.txtGyoseiku().displayNone = true;
                    this.controls.txtSetaiCode().displayNone = true;
                    this.controls.btnSetaiMemo().displayNone = true;
                };
                return AtenaType;
            })();
            Modes.AtenaType = AtenaType;

            var ShoriType = (function () {
                function ShoriType(controls) {
                    this.controls = controls;
                }
                ShoriType.prototype.NormalAddMode = function () {
                    this.controls.txtShimei().readOnly = true;
                    this.controls.txtBirthYMD().readOnly = true;
                    this.controls.txtNenrei().readOnly = true;
                    this.controls.txtSeibetsu().readOnly = true;
                    this.controls.txtYubinNo().readOnly = true;
                    this.controls.txtJusho().readOnly = true;
                    this.controls.txtTelNo().readOnly = true;
                };

                ShoriType.prototype.NormalUpdateMode = function () {
                    this.controls.txtShimei().readOnly = true;
                    this.controls.txtBirthYMD().readOnly = true;
                    this.controls.txtNenrei().readOnly = true;
                    this.controls.txtSeibetsu().readOnly = true;
                    this.controls.txtYubinNo().readOnly = true;
                    this.controls.txtJusho().readOnly = true;
                    this.controls.txtTelNo().readOnly = true;
                };

                ShoriType.prototype.SeihoAddMode = function () {
                    this.controls.txtShimei().readOnly = true;
                    this.controls.txtBirthYMD().readOnly = true;
                    this.controls.txtNenrei().readOnly = true;
                    this.controls.txtSeibetsu().readOnly = true;
                    this.controls.txtYubinNo().readOnly = true;
                    this.controls.txtJusho().readOnly = true;
                    this.controls.txtTelNo().readOnly = true;
                };

                ShoriType.prototype.SeihoUpdateMode = function () {
                    this.controls.txtShimei().readOnly = false;
                    this.controls.txtBirthYMD().readOnly = false;
                    this.controls.txtNenrei().readOnly = false;
                    this.controls.txtSeibetsu().readOnly = false;
                    this.controls.txtYubinNo().readOnly = false;
                    this.controls.txtJusho().readOnly = false;
                    this.controls.txtTelNo().readOnly = false;
                };

                ShoriType.prototype.ShokaiMode = function () {
                    this.controls.txtShimei().readOnly = true;
                    this.controls.txtBirthYMD().readOnly = true;
                    this.controls.txtNenrei().readOnly = true;
                    this.controls.txtSeibetsu().readOnly = true;
                    this.controls.txtYubinNo().readOnly = true;
                    this.controls.txtJusho().readOnly = true;
                    this.controls.txtTelNo().readOnly = true;
                };
                return ShoriType;
            })();
            Modes.ShoriType = ShoriType;
        })(KaigoNinteiAtenaInfo.Modes || (KaigoNinteiAtenaInfo.Modes = {}));
        var Modes = KaigoNinteiAtenaInfo.Modes;
    })(DBZ.KaigoNinteiAtenaInfo || (DBZ.KaigoNinteiAtenaInfo = {}));
    var KaigoNinteiAtenaInfo = DBZ.KaigoNinteiAtenaInfo;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (KaigoNinteiAtenaInfo) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoNinteiAtenaInfo.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoNinteiAtenaInfo.PublicProperties = PublicProperties;
    })(DBZ.KaigoNinteiAtenaInfo || (DBZ.KaigoNinteiAtenaInfo = {}));
    var KaigoNinteiAtenaInfo = DBZ.KaigoNinteiAtenaInfo;
})(DBZ || (DBZ = {}));
