var DBZ;
(function (DBZ) {
    (function (JogaiShinsainJoho) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JogaiShinsainJoho.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new JogaiShinsainJoho.PublicProperties(this.fieldName);
            };
            ModeController.prototype.ShoriType = function () {
                return new Modes.ShoriType(this.controls);
            };
            return ModeController;
        })();
        JogaiShinsainJoho.ModeController = ModeController;

        (function (Modes) {
            var ShoriType = (function () {
                function ShoriType(controls) {
                    this.controls = controls;
                }
                ShoriType.prototype.Input = function () {
                    this.controls.btnShinkiTsuika().disabled = false;
                    var gridSetting = this.controls.dgShinsakaiIinIchiran().gridSetting;

                    gridSetting.isShowDeleteButtonColumn = true;
                    this.controls.txtShinsakaiIinCode().readOnly = false;
                    this.controls.btnShinsakaiIinGuide().disabled = false;
                    this.controls.btnToroku().disabled = false;
                    this.controls.btnShinkiTsuika().disabled = false;
                    this.controls.btnKakutei().disabled = false;
                    this.controls.dgShinsakaiIinIchiran().gridSetting = gridSetting;
                    this.controls.dgShinsakaiIinIchiran()._control.afterPropertiesSet();
                };

                ShoriType.prototype.Shokai = function () {
                    var gridSetting = this.controls.dgShinsakaiIinIchiran().gridSetting;
                    gridSetting.isShowDeleteButtonColumn = false;
                    this.controls.txtShinsakaiIinCode().readOnly = true;
                    this.controls.btnShinsakaiIinGuide().disabled = true;
                    this.controls.btnToroku().disabled = true;
                    this.controls.btnShinkiTsuika().disabled = true;
                    this.controls.btnKakutei().disabled = true;
                    this.controls.dgShinsakaiIinIchiran().gridSetting = gridSetting;
                    this.controls.dgShinsakaiIinIchiran()._control.afterPropertiesSet();
                };
                return ShoriType;
            })();
            Modes.ShoriType = ShoriType;
        })(JogaiShinsainJoho.Modes || (JogaiShinsainJoho.Modes = {}));
        var Modes = JogaiShinsainJoho.Modes;
    })(DBZ.JogaiShinsainJoho || (DBZ.JogaiShinsainJoho = {}));
    var JogaiShinsainJoho = DBZ.JogaiShinsainJoho;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (JogaiShinsainJoho) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JogaiShinsainJoho.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JogaiShinsainJoho.PublicProperties = PublicProperties;
    })(DBZ.JogaiShinsainJoho || (DBZ.JogaiShinsainJoho = {}));
    var JogaiShinsainJoho = DBZ.JogaiShinsainJoho;
})(DBZ || (DBZ = {}));
