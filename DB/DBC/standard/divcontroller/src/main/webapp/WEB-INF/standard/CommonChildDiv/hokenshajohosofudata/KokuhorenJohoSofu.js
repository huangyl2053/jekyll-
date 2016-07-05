var DBC;
(function (DBC) {
    (function (KokuhorenJohoSofu) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KokuhorenJohoSofu.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new KokuhorenJohoSofu.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "DisplayMode"
                ];
            };

            ModeController.prototype.DisplayMode = function () {
                return new Modes.DisplayMode(this.controls);
            };
            return ModeController;
        })();
        KokuhorenJohoSofu.ModeController = ModeController;

        (function (Modes) {
            var DisplayMode = (function () {
                function DisplayMode(controls) {
                    this.controls = controls;
                }
                DisplayMode.prototype.mode1 = function () {
                    this.controls.lblChushutsuJoken().displayNone = false;
                    this.controls.txtShoriSaikuruKubun().displayNone = true;
                    this.controls.txtShoritaishoNengetsu().displayNone = false;
                    this.controls.txtsaishoriKubun().displayNone = false;
                    this.controls.txtFileName().displayNone = false;
                    this.controls.ddlSofuTaishojoho().displayNone = true;
                    this.controls.ShoriJikkoMaekakuninJiko().displayNone = true;
                    this.controls.lblKakuninJiko1().displayNone = true;
                    this.controls.lblKakuninJiko2().displayNone = true;
                };
                DisplayMode.prototype.mode2 = function () {
                    this.controls.lblChushutsuJoken().displayNone = false;
                    this.controls.txtShoriSaikuruKubun().displayNone = true;
                    this.controls.txtShoritaishoNengetsu().displayNone = false;
                    this.controls.txtsaishoriKubun().displayNone = false;
                    this.controls.txtFileName().displayNone = false;
                    this.controls.ddlSofuTaishojoho().displayNone = false;
                    this.controls.ShoriJikkoMaekakuninJiko().displayNone = true;
                    this.controls.lblKakuninJiko1().displayNone = true;
                    this.controls.lblKakuninJiko2().displayNone = true;
                };
                DisplayMode.prototype.mode3 = function () {
                    this.controls.lblChushutsuJoken().displayNone = false;
                    this.controls.txtShoriSaikuruKubun().displayNone = false;
                    this.controls.txtShoritaishoNengetsu().displayNone = false;
                    this.controls.txtsaishoriKubun().displayNone = false;
                    this.controls.txtFileName().displayNone = false;
                    this.controls.ddlSofuTaishojoho().displayNone = true;
                    this.controls.ShoriJikkoMaekakuninJiko().displayNone = true;
                    this.controls.lblKakuninJiko1().displayNone = true;
                    this.controls.lblKakuninJiko2().displayNone = true;
                };
                DisplayMode.prototype.mode4 = function () {
                    this.controls.lblChushutsuJoken().displayNone = false;
                    this.controls.txtShoriSaikuruKubun().displayNone = false;
                    this.controls.txtShoritaishoNengetsu().displayNone = false;
                    this.controls.txtsaishoriKubun().displayNone = false;
                    this.controls.txtFileName().displayNone = false;
                    this.controls.ddlSofuTaishojoho().displayNone = true;
                    this.controls.ShoriJikkoMaekakuninJiko().displayNone = false;
                    this.controls.lblKakuninJiko1().displayNone = false;
                    this.controls.lblKakuninJiko2().displayNone = false;
                };
                return DisplayMode;
            })();
            Modes.DisplayMode = DisplayMode;
        })(KokuhorenJohoSofu.Modes || (KokuhorenJohoSofu.Modes = {}));
        var Modes = KokuhorenJohoSofu.Modes;
    })(DBC.KokuhorenJohoSofu || (DBC.KokuhorenJohoSofu = {}));
    var KokuhorenJohoSofu = DBC.KokuhorenJohoSofu;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (KokuhorenJohoSofu) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new KokuhorenJohoSofu.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        KokuhorenJohoSofu.PublicProperties = PublicProperties;
    })(DBC.KokuhorenJohoSofu || (DBC.KokuhorenJohoSofu = {}));
    var KokuhorenJohoSofu = DBC.KokuhorenJohoSofu;
})(DBC || (DBC = {}));
