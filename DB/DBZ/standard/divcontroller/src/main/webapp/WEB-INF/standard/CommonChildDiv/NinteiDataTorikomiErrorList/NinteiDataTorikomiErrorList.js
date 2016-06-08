var DBZ;
(function (DBZ) {
    (function (NinteiDataTorikomiErrorList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiDataTorikomiErrorList.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new NinteiDataTorikomiErrorList.PublicProperties(this.fieldName);
            };
            ModeController.prototype.TorikomiType = function () {
                return new Modes.TorikomiType(this.controls);
            };
            return ModeController;
        })();
        NinteiDataTorikomiErrorList.ModeController = ModeController;

        (function (Modes) {
            var TorikomiType = (function () {
                function TorikomiType(controls) {
                    this.controls = controls;
                }
                TorikomiType.prototype.ShinseiJohoMode = function () {
                    var gridSetting = this.controls.dgDataTorikomiErrorIchiran().gridSetting;
                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;
                    gridSetting.columns[5].visible = true;
                    gridSetting.columns[6].visible = false;
                    gridSetting.columns[7].visible = true;
                    this.controls.dgDataTorikomiErrorIchiran().gridSetting = gridSetting;
                    this.controls.dgDataTorikomiErrorIchiran()._control.afterPropertiesSet();
                };

                TorikomiType.prototype.ChosaKekkaMode = function () {
                    var gridSetting = this.controls.dgDataTorikomiErrorIchiran().gridSetting;

                    gridSetting.columns[6].visible = false;

                    this.controls.dgDataTorikomiErrorIchiran().gridSetting = gridSetting;
                    this.controls.dgDataTorikomiErrorIchiran()._control.afterPropertiesSet();
                };

                TorikomiType.prototype.OrcaMode = function () {
                    var gridSetting = this.controls.dgDataTorikomiErrorIchiran().gridSetting;

                    gridSetting.columns[6].visible = false;

                    this.controls.dgDataTorikomiErrorIchiran().gridSetting = gridSetting;
                    this.controls.dgDataTorikomiErrorIchiran()._control.afterPropertiesSet();
                };

                TorikomiType.prototype.ShinsaKekkaMode = function () {
                    var gridSetting = this.controls.dgDataTorikomiErrorIchiran().gridSetting;

                    gridSetting.columns[6].visible = true;

                    this.controls.dgDataTorikomiErrorIchiran().gridSetting = gridSetting;
                    this.controls.dgDataTorikomiErrorIchiran()._control.afterPropertiesSet();
                };

                TorikomiType.prototype.NinteiKekkaMode = function () {
                    var gridSetting = this.controls.dgDataTorikomiErrorIchiran().gridSetting;

                    gridSetting.columns[6].visible = true;

                    this.controls.dgDataTorikomiErrorIchiran().gridSetting = gridSetting;
                    this.controls.dgDataTorikomiErrorIchiran()._control.afterPropertiesSet();
                };
                return TorikomiType;
            })();
            Modes.TorikomiType = TorikomiType;
        })(NinteiDataTorikomiErrorList.Modes || (NinteiDataTorikomiErrorList.Modes = {}));
        var Modes = NinteiDataTorikomiErrorList.Modes;
    })(DBZ.NinteiDataTorikomiErrorList || (DBZ.NinteiDataTorikomiErrorList = {}));
    var NinteiDataTorikomiErrorList = DBZ.NinteiDataTorikomiErrorList;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (NinteiDataTorikomiErrorList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new NinteiDataTorikomiErrorList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        NinteiDataTorikomiErrorList.PublicProperties = PublicProperties;
    })(DBZ.NinteiDataTorikomiErrorList || (DBZ.NinteiDataTorikomiErrorList = {}));
    var NinteiDataTorikomiErrorList = DBZ.NinteiDataTorikomiErrorList;
})(DBZ || (DBZ = {}));
