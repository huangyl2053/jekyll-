var DBZ;
(function (DBZ) {
    (function (KaigoNinteiShinseiKihonJohoInput) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoNinteiShinseiKihonJohoInput.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KaigoNinteiShinseiKihonJohoInput.PublicProperties(this.fieldName);
            };

            ModeController.prototype.InputType = function () {
                return new Modes.InputType(this.controls);
            };
            return ModeController;
        })();
        KaigoNinteiShinseiKihonJohoInput.ModeController = ModeController;

        (function (Modes) {
            var InputType = (function () {
                function InputType(controls) {
                    this.controls = controls;
                }
                InputType.prototype.AllInputMode = function () {
                    this.controls.radShinseishoKubun().readOnly = false;
                    this.controls.txtShinseiYMD().readOnly = false;
                    this.controls.ddlShinseiShubetsu().readOnly = false;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = false;
                    this.controls.ddlShinseiKubunHorei().readOnly = false;
                    this.controls.chkKyuSochisha().readOnly = false;
                    this.controls.ddlHihokenshaKubun().readOnly = false;
                    this.controls.chkShikakuShutokuMae().readOnly = false;
                    this.controls.ddlTokuteiShippei().readOnly = false;

                    this.controls.ServiceSakujo().displayNone = false;
                    this.controls.ServiceSakujo().readOnly = false;
                    this.controls.NinteiShinseiRiyu().readOnly = false;
                };

                InputType.prototype.ServiceInputMode = function () {
                    this.controls.radShinseishoKubun().readOnly = false;
                    this.controls.txtShinseiYMD().readOnly = false;
                    this.controls.ddlShinseiShubetsu().readOnly = true;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = false;
                    this.controls.ddlShinseiKubunHorei().readOnly = false;
                    this.controls.chkKyuSochisha().readOnly = false;
                    this.controls.ddlHihokenshaKubun().readOnly = false;
                    this.controls.chkShikakuShutokuMae().readOnly = false;
                    this.controls.ddlTokuteiShippei().readOnly = false;

                    this.controls.ServiceSakujo().displayNone = false;
                    this.controls.ServiceSakujo().readOnly = false;
                    this.controls.NinteiShinseiRiyu().readOnly = false;
                };

                InputType.prototype.ServiceShokaiMode = function () {
                    this.controls.radShinseishoKubun().readOnly = true;
                    this.controls.txtShinseiYMD().readOnly = true;
                    this.controls.ddlShinseiShubetsu().readOnly = true;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = true;
                    this.controls.ddlShinseiKubunHorei().readOnly = true;
                    this.controls.chkKyuSochisha().readOnly = true;
                    this.controls.ddlHihokenshaKubun().readOnly = true;
                    this.controls.chkShikakuShutokuMae().readOnly = true;
                    this.controls.ddlTokuteiShippei().readOnly = true;

                    this.controls.ServiceSakujo().readOnly = true;
                    this.controls.NinteiShinseiRiyu().readOnly = true;
                };

                InputType.prototype.ServiceNomalInputMode = function () {
                    this.controls.radShinseishoKubun().readOnly = false;
                    this.controls.txtShinseiYMD().readOnly = false;
                    this.controls.ddlShinseiShubetsu().readOnly = true;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = false;
                    this.controls.ddlShinseiKubunHorei().readOnly = false;
                    this.controls.chkKyuSochisha().readOnly = false;
                    this.controls.ddlHihokenshaKubun().readOnly = false;
                    this.controls.chkShikakuShutokuMae().readOnly = false;
                    this.controls.ddlTokuteiShippei().readOnly = false;

                    this.controls.ServiceSakujo().displayNone = true;
                    this.controls.NinteiShinseiRiyu().readOnly = false;
                };
                InputType.prototype.TokuteiShippeiMode = function () {
                    this.controls.radShinseishoKubun().readOnly = true;
                    this.controls.txtShinseiYMD().readOnly = false;
                    this.controls.ddlShinseiShubetsu().readOnly = true;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = true;
                    this.controls.ddlShinseiKubunHorei().readOnly = true;
                    this.controls.chkKyuSochisha().readOnly = false;
                    this.controls.ddlHihokenshaKubun().readOnly = false;
                    this.controls.chkShikakuShutokuMae().readOnly = true;
                    this.controls.ddlTokuteiShippei().readOnly = false;

                    this.controls.ServiceSakujo().displayNone = true;
                    this.controls.NinteiShinseiRiyu().readOnly = true;
                };

                InputType.prototype.TokuteiShippeiNashiMode = function () {
                    this.controls.radShinseishoKubun().readOnly = false;
                    this.controls.txtShinseiYMD().readOnly = false;
                    this.controls.ddlShinseiShubetsu().readOnly = false;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = false;
                    this.controls.ddlShinseiKubunHorei().readOnly = false;
                    this.controls.chkKyuSochisha().readOnly = false;
                    this.controls.ddlHihokenshaKubun().readOnly = false;
                    this.controls.chkShikakuShutokuMae().readOnly = false;
                    this.controls.ddlTokuteiShippei().readOnly = true;

                    this.controls.ServiceSakujo().displayNone = true;
                    this.controls.NinteiShinseiRiyu().readOnly = false;
                };
                InputType.prototype.JizenShinseiNashiMode = function () {
                    this.controls.radShinseishoKubun().readOnly = false;
                    this.controls.txtShinseiYMD().readOnly = false;
                    this.controls.ddlShinseiShubetsu().readOnly = true;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = true;
                    this.controls.ddlShinseiKubunHorei().readOnly = true;
                    this.controls.chkKyuSochisha().readOnly = false;
                    this.controls.ddlHihokenshaKubun().readOnly = false;
                    this.controls.chkShikakuShutokuMae().readOnly = true;
                    this.controls.ddlTokuteiShippei().readOnly = false;

                    this.controls.ServiceSakujo().displayNone = true;
                    this.controls.NinteiShinseiRiyu().readOnly = true;
                };
                InputType.prototype.ShinseibiMode = function () {
                    this.controls.radShinseishoKubun().readOnly = true;
                    this.controls.txtShinseiYMD().readOnly = false;
                    this.controls.ddlShinseiShubetsu().readOnly = true;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = true;
                    this.controls.ddlShinseiKubunHorei().readOnly = true;
                    this.controls.chkKyuSochisha().readOnly = true;
                    this.controls.ddlHihokenshaKubun().readOnly = true;
                    this.controls.chkShikakuShutokuMae().readOnly = true;
                    this.controls.ddlTokuteiShippei().readOnly = true;

                    this.controls.ServiceSakujo().displayNone = true;
                    this.controls.NinteiShinseiRiyu().readOnly = true;
                };
                InputType.prototype.NinteiMode = function () {
                    this.controls.radShinseishoKubun().readOnly = true;
                    this.controls.txtShinseiYMD().readOnly = true;
                    this.controls.ddlShinseiShubetsu().readOnly = true;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = true;
                    this.controls.ddlShinseiKubunHorei().readOnly = true;
                    this.controls.chkKyuSochisha().readOnly = false;
                    this.controls.ddlHihokenshaKubun().readOnly = true;
                    this.controls.chkShikakuShutokuMae().readOnly = true;
                    this.controls.ddlTokuteiShippei().readOnly = true;

                    this.controls.ServiceSakujo().displayNone = true;
                    this.controls.NinteiShinseiRiyu().readOnly = true;
                };
                InputType.prototype.ShokaiMode = function () {
                    this.controls.radShinseishoKubun().readOnly = true;
                    this.controls.txtShinseiYMD().readOnly = true;
                    this.controls.ddlShinseiShubetsu().readOnly = true;
                    this.controls.ddlShinseiKubunShinseiji().readOnly = true;
                    this.controls.ddlShinseiKubunHorei().readOnly = true;
                    this.controls.chkKyuSochisha().readOnly = true;
                    this.controls.ddlHihokenshaKubun().readOnly = true;
                    this.controls.chkShikakuShutokuMae().readOnly = true;
                    this.controls.ddlTokuteiShippei().readOnly = true;

                    this.controls.ServiceSakujo().displayNone = true;
                    this.controls.NinteiShinseiRiyu().readOnly = true;
                };
                return InputType;
            })();
            Modes.InputType = InputType;
        })(KaigoNinteiShinseiKihonJohoInput.Modes || (KaigoNinteiShinseiKihonJohoInput.Modes = {}));
        var Modes = KaigoNinteiShinseiKihonJohoInput.Modes;
    })(DBZ.KaigoNinteiShinseiKihonJohoInput || (DBZ.KaigoNinteiShinseiKihonJohoInput = {}));
    var KaigoNinteiShinseiKihonJohoInput = DBZ.KaigoNinteiShinseiKihonJohoInput;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (KaigoNinteiShinseiKihonJohoInput) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KaigoNinteiShinseiKihonJohoInput.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KaigoNinteiShinseiKihonJohoInput.PublicProperties = PublicProperties;
    })(DBZ.KaigoNinteiShinseiKihonJohoInput || (DBZ.KaigoNinteiShinseiKihonJohoInput = {}));
    var KaigoNinteiShinseiKihonJohoInput = DBZ.KaigoNinteiShinseiKihonJohoInput;
})(DBZ || (DBZ = {}));
