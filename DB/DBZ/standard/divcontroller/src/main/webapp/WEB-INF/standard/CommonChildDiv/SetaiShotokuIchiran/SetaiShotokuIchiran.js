var DBZ;
(function (DBZ) {
    (function (SetaiShotokuIchiran) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.controls = new SetaiShotokuIchiran.Controls(fieldName);
            }
            ModeController.prototype.DisplayMode = function () {
                return new Modes.DisplayMode(this.controls);
            };
            return ModeController;
        })();
        SetaiShotokuIchiran.ModeController = ModeController;

        (function (Modes) {
            var DisplayMode = (function () {
                function DisplayMode(controls) {
                    this.controls = controls;
                }
                DisplayMode.prototype.FukaShokai = function () {
                    this.controls.ddlSetaiIchiranKazeiNendo().displayNone = true;
                    this.controls.btnSaiHyoji().displayNone = true;
                    this.controls.dgShotokuRireki().displayNone = true;
                    this.controls.btnRirekiClose().displayNone = true;
                    this.controls.dgSetaiShotoku().displayNone = false;
                    this.controls.dgSetaiShotoku().gridSetting.isMultiSelectable = true;
                };

                DisplayMode.prototype.ShotokuShokai = function () {
                    this.controls.txtSetaiIchiranKazeiNendo().displayNone = true;
                    this.controls.ddlSetaiIchiranKazeiNendo().displayNone = false;
                    this.controls.btnSaiHyoji().displayNone = false;
                    this.controls.ddlSetaiIchiranKazeiNendo().disabled = false;
                    this.controls.btnSaiHyoji().disabled = false;
                    this.controls.txtSetaiIchiranSetaiCode().disabled = true;
                    this.controls.chkSetaiIchiranAll().displayNone = true;
                    this.controls.btnNarabeteHyoji().displayNone = true;
                    this.controls.dgSetaiShotoku().gridSetting.isMultiSelectable = false;
                    this.controls.dgShotokuRireki().displayNone = true;
                    this.controls.dgSetaiShotoku().displayNone = false;
                    this.controls.btnRirekiClose().displayNone = true;
                };

                DisplayMode.prototype.ShotokuRirekiShokai = function () {
                    this.controls.txtSetaiIchiranKazeiNendo().displayNone = true;
                    this.controls.ddlSetaiIchiranKazeiNendo().displayNone = true;
                    this.controls.btnSaiHyoji().displayNone = true;
                    this.controls.txtSetaiIchiranSetaiCode().displayNone = true;
                    this.controls.chkSetaiIchiranAll().displayNone = true;
                    this.controls.btnNarabeteHyoji().displayNone = true;
                    this.controls.dgSetaiShotoku().displayNone = true;
                    this.controls.dgSetaiShotoku().gridSetting.isMultiSelectable = true;
                    this.controls.dgShotokuRireki().displayNone = false;
                    this.controls.dgShotokuRireki().disabled = false;
                    this.controls.btnRirekiClose().disabled = false;
                    this.controls.btnRirekiClose().displayNone = false;
                };

                DisplayMode.prototype.KogakuKaigoServicehi = function () {
                    this.controls.txtSetaiIchiranKijunYMD().disabled = false;
                    this.controls.txtSetaiIchiranKazeiNendo().displayNone = true;
                    this.controls.dgShotokuRireki().displayNone = true;
                    this.controls.dgSetaiShotoku().displayNone = false;
                    this.controls.dgSetaiShotoku().gridSetting.isMultiSelectable = true;
                    this.controls.btnRirekiClose().displayNone = true;
                };
                return DisplayMode;
            })();
            Modes.DisplayMode = DisplayMode;
        })(SetaiShotokuIchiran.Modes || (SetaiShotokuIchiran.Modes = {}));
        var Modes = SetaiShotokuIchiran.Modes;
    })(DBZ.SetaiShotokuIchiran || (DBZ.SetaiShotokuIchiran = {}));
    var SetaiShotokuIchiran = DBZ.SetaiShotokuIchiran;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SetaiShotokuIchiran) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SetaiShotokuIchiran.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        SetaiShotokuIchiran.PublicProperties = PublicProperties;
    })(DBZ.SetaiShotokuIchiran || (DBZ.SetaiShotokuIchiran = {}));
    var SetaiShotokuIchiran = DBZ.SetaiShotokuIchiran;
})(DBZ || (DBZ = {}));
