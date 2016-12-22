var DBZ;
(function (DBZ) {
    (function (ShujiiIryokikanAndShujiiGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShujiiIryokikanAndShujiiGuide.Controls(fieldName);
                this.controls.KensakuKekkaIchiran().isOpen = true;
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ShujiiIryokikanAndShujiiGuide.PublicProperties(this.fieldName);
            };

            ModeController.prototype.TaishoMode = function () {
                return new Modes.TaishoMode(this.controls);
            };
            return ModeController;
        })();
        ShujiiIryokikanAndShujiiGuide.ModeController = ModeController;

        (function (Modes) {
            var TaishoMode = (function () {
                function TaishoMode(controls) {
                    this.controls = controls;
                }
                TaishoMode.prototype.IryoKikanMode = function () {
                    this.controls.txtShuijiiCodeFrom().displayNone = true;
                    this.controls.txtShujiiCodeTo().displayNone = true;
                    this.controls.txtShujiiShimei().displayNone = true;
                    this.controls.txtShujiiKanaShimei().displayNone = true;
                    this.controls.radShujiiJokyo().displayNone = true;

                    var gridSetting = this.controls.dgKensakuKekkaIchiran().gridSetting;
                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;
                    gridSetting.columns[5].visible = false;
                    gridSetting.columns[6].visible = false;
                    gridSetting.columns[7].visible = false;
                    this.controls.dgKensakuKekkaIchiran().gridSetting = gridSetting;
                    this.controls.dgKensakuKekkaIchiran()._control.afterPropertiesSet();
                };

                TaishoMode.prototype.ShujiiMode = function () {
                    this.controls.txtShuijiiCodeFrom().displayNone = false;
                    this.controls.txtShujiiCodeTo().displayNone = false;
                    this.controls.txtShujiiShimei().displayNone = false;
                    this.controls.txtShujiiKanaShimei().displayNone = false;
                    this.controls.radShujiiJokyo().displayNone = false;

                    var gridSetting = this.controls.dgKensakuKekkaIchiran().gridSetting;
                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;
                    gridSetting.columns[5].visible = true;
                    gridSetting.columns[6].visible = true;
                    gridSetting.columns[7].visible = true;
                    this.controls.dgKensakuKekkaIchiran().gridSetting = gridSetting;
                    this.controls.dgKensakuKekkaIchiran()._control.afterPropertiesSet();
                };
                return TaishoMode;
            })();
            Modes.TaishoMode = TaishoMode;
        })(ShujiiIryokikanAndShujiiGuide.Modes || (ShujiiIryokikanAndShujiiGuide.Modes = {}));
        var Modes = ShujiiIryokikanAndShujiiGuide.Modes;
    })(DBZ.ShujiiIryokikanAndShujiiGuide || (DBZ.ShujiiIryokikanAndShujiiGuide = {}));
    var ShujiiIryokikanAndShujiiGuide = DBZ.ShujiiIryokikanAndShujiiGuide;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ShujiiIryokikanAndShujiiGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShujiiIryokikanAndShujiiGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ShujiiIryokikanAndShujiiGuide.PublicProperties = PublicProperties;
    })(DBZ.ShujiiIryokikanAndShujiiGuide || (DBZ.ShujiiIryokikanAndShujiiGuide = {}));
    var ShujiiIryokikanAndShujiiGuide = DBZ.ShujiiIryokikanAndShujiiGuide;
})(DBZ || (DBZ = {}));
