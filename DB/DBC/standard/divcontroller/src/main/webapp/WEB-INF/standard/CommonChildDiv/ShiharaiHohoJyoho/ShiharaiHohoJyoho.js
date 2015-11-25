var DBC;
(function (DBC) {
    (function (ShiharaiHohoJyoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShiharaiHohoJyoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShiharaiHohoJyoho.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "DisplayMode",
                    "PageMode"
                ];
            };

            ModeController.prototype.DisplayMode = function () {
                return new Modes.DisplayMode(this.controls);
            };

            ModeController.prototype.PageMode = function () {
                return new Modes.PageMode(this.controls);
            };
            return ModeController;
        })();
        ShiharaiHohoJyoho.ModeController = ModeController;

        (function (Modes) {
            var DisplayMode = (function () {
                function DisplayMode(controls) {
                    this.controls = controls;
                }
                DisplayMode.prototype.shokai = function () {
                    this.controls.radMadoguti().disabled = true;
                    this.controls.txtShiharaiBasho().disabled = true;
                    this.controls.txtStartYMD().disabled = true;
                    this.controls.txtStartHHMM().disabled = true;
                    this.controls.txtEndYMD().disabled = true;
                    this.controls.txtEndHHMM().disabled = true;
                    this.controls.radKoza().disabled = true;
                    this.controls.radJyryoinin().disabled = true;
                };

                DisplayMode.prototype.toroku = function () {
                    this.controls.radMadoguti().disabled = false;
                    this.controls.txtShiharaiBasho().disabled = false;
                    this.controls.txtStartYMD().disabled = false;
                    this.controls.txtStartHHMM().disabled = false;
                    this.controls.txtEndYMD().disabled = false;
                    this.controls.txtEndHHMM().disabled = false;
                    this.controls.radKoza().disabled = false;
                    this.controls.radJyryoinin().disabled = false;
                };
                return DisplayMode;
            })();
            Modes.DisplayMode = DisplayMode;
            var PageMode = (function () {
                function PageMode(controls) {
                    this.controls = controls;
                }
                PageMode.prototype.Shokan = function () {
                    this.controls.linKoza().displayNone = false;
                    this.controls.radJyryoinin().displayNone = false;
                    this.controls.txtKeiyakuNo().displayNone = false;
                    this.controls.btnSelect().displayNone = false;
                    this.controls.txtKeiyakuCode().displayNone = false;
                    this.controls.txtKeiyakuName().displayNone = false;
                    this.controls.txtKinyuKikanCode1().displayNone = false;
                    this.controls.txtKinyuKikanShitenCode1().displayNone = false;
                    this.controls.txtYokinShubetsu1().displayNone = false;
                    this.controls.txtKozaNo1().displayNone = false;
                    this.controls.txtKinyuKikanName1().displayNone = false;
                    this.controls.txtMeigininKana1().displayNone = false;
                    this.controls.txtMeigininKanji1().displayNone = false;
                };

                PageMode.prototype.JutakuKaishu = function () {
                    this.controls.linKoza().displayNone = false;
                    this.controls.radJyryoinin().displayNone = false;
                    this.controls.txtKeiyakuNo().displayNone = false;
                    this.controls.btnSelect().displayNone = false;
                    this.controls.txtKeiyakuCode().displayNone = false;
                    this.controls.txtKeiyakuName().displayNone = false;
                    this.controls.txtKinyuKikanCode1().displayNone = false;
                    this.controls.txtKinyuKikanShitenCode1().displayNone = false;
                    this.controls.txtYokinShubetsu1().displayNone = false;
                    this.controls.txtKozaNo1().displayNone = false;
                    this.controls.txtKinyuKikanName1().displayNone = false;
                    this.controls.txtMeigininKana1().displayNone = false;
                    this.controls.txtMeigininKanji1().displayNone = false;
                };

                PageMode.prototype.Fukushiyogu = function () {
                    this.controls.linKoza().displayNone = false;
                    this.controls.radJyryoinin().displayNone = false;
                    this.controls.txtKeiyakuNo().displayNone = false;
                    this.controls.btnSelect().displayNone = false;
                    this.controls.txtKeiyakuCode().displayNone = false;
                    this.controls.txtKeiyakuName().displayNone = false;
                    this.controls.txtKinyuKikanCode1().displayNone = false;
                    this.controls.txtKinyuKikanShitenCode1().displayNone = false;
                    this.controls.txtYokinShubetsu1().displayNone = false;
                    this.controls.txtKozaNo1().displayNone = false;
                    this.controls.txtKinyuKikanName1().displayNone = false;
                    this.controls.txtMeigininKana1().displayNone = false;
                    this.controls.txtMeigininKanji1().displayNone = false;
                };

                PageMode.prototype.KogakuService = function () {
                    this.controls.linKoza().displayNone = false;
                    this.controls.radJyryoinin().displayNone = false;
                    this.controls.txtKeiyakuNo().displayNone = false;
                    this.controls.btnSelect().displayNone = false;
                    this.controls.txtKeiyakuCode().displayNone = false;
                    this.controls.txtKeiyakuName().displayNone = false;
                    this.controls.txtKinyuKikanCode1().displayNone = false;
                    this.controls.txtKinyuKikanShitenCode1().displayNone = false;
                    this.controls.txtYokinShubetsu1().displayNone = false;
                    this.controls.txtKozaNo1().displayNone = false;
                    this.controls.txtKinyuKikanName1().displayNone = false;
                    this.controls.txtMeigininKana1().displayNone = false;
                    this.controls.txtMeigininKanji1().displayNone = false;
                };

                PageMode.prototype.KogakuGassan = function () {
                    this.controls.linKoza().displayNone = true;
                    this.controls.radJyryoinin().displayNone = true;
                    this.controls.txtKeiyakuNo().displayNone = true;
                    this.controls.btnSelect().displayNone = true;
                    this.controls.txtKeiyakuCode().displayNone = true;
                    this.controls.txtKeiyakuName().displayNone = true;
                    this.controls.txtKinyuKikanCode1().displayNone = true;
                    this.controls.txtKinyuKikanShitenCode1().displayNone = true;
                    this.controls.txtYokinShubetsu1().displayNone = true;
                    this.controls.txtKozaNo1().displayNone = true;
                    this.controls.txtKinyuKikanName1().displayNone = true;
                    this.controls.txtMeigininKana1().displayNone = true;
                    this.controls.txtMeigininKanji1().displayNone = true;
                };
                return PageMode;
            })();
            Modes.PageMode = PageMode;
        })(ShiharaiHohoJyoho.Modes || (ShiharaiHohoJyoho.Modes = {}));
        var Modes = ShiharaiHohoJyoho.Modes;
    })(DBC.ShiharaiHohoJyoho || (DBC.ShiharaiHohoJyoho = {}));
    var ShiharaiHohoJyoho = DBC.ShiharaiHohoJyoho;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (ShiharaiHohoJyoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShiharaiHohoJyoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShiharaiHohoJyoho.PublicProperties = PublicProperties;
    })(DBC.ShiharaiHohoJyoho || (DBC.ShiharaiHohoJyoho = {}));
    var ShiharaiHohoJyoho = DBC.ShiharaiHohoJyoho;
})(DBC || (DBC = {}));
