var DBZ;
(function (DBZ) {
    (function (ChosaItakusakiAndChosainGuide) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaItakusakiAndChosainGuide.Controls(fieldName);
                this.controls.KensakuKekkaIchiran().isOpen = true;
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new ChosaItakusakiAndChosainGuide.PublicProperties(this.fieldName);
            };

            ModeController.prototype.TaishoMode = function () {
                return new Modes.TaishoMode(this.controls);
            };
            return ModeController;
        })();
        ChosaItakusakiAndChosainGuide.ModeController = ModeController;

        (function (Modes) {
            var TaishoMode = (function () {
                function TaishoMode(controls) {
                    this.controls = controls;
                }
                TaishoMode.prototype.Itakusaki = function () {
                    this.controls.txtChosainCodeFrom().displayNone = true;
                    this.controls.txtChosainCodeTo().displayNone = true;
                    this.controls.txtChosainName().displayNone = true;
                    this.controls.txtChosainKanaShimei().displayNone = false;
                    this.controls.radChosainJokyo().displayNone = true;

                    this.controls.txtChosaItakusakiCodeFrom().displayNone = false;
                    this.controls.txtChosaItakuaskiCodeTo().displayNone = false;
                    this.controls.txtChosaItakusakiName().displayNone = false;
                    this.controls.txtChosaItakusakiKanaMeisho().displayNone = false;
                    this.controls.txtChosainKanaShimei().displayNone = false;
                    this.controls.radItakusakiJokyo().displayNone = false;

                    var gridSetting = this.controls.dgKensakuKekkaIchiran().gridSetting;
                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = false;
                    gridSetting.columns[5].visible = false;
                    gridSetting.columns[6].visible = false;
                    this.controls.dgKensakuKekkaIchiran().gridSetting = gridSetting;
                    this.controls.dgKensakuKekkaIchiran()._control.afterPropertiesSet();
                };

                TaishoMode.prototype.Chosain = function () {
                    this.controls.txtChosainCodeFrom().displayNone = false;
                    this.controls.txtChosainCodeTo().displayNone = false;
                    this.controls.txtChosainName().displayNone = false;
                    this.controls.txtChosainKanaShimei().displayNone = false;
                    this.controls.radChosainJokyo().displayNone = false;

                    this.controls.txtChosaItakusakiCodeFrom().displayNone = true;
                    this.controls.txtChosaItakuaskiCodeTo().displayNone = true;
                    this.controls.txtChosaItakusakiName().displayNone = true;
                    this.controls.txtChosaItakusakiKanaMeisho().displayNone = true;
                    this.controls.radItakusakiJokyo().displayNone = true;

                    var gridSetting = this.controls.dgKensakuKekkaIchiran().gridSetting;
                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;
                    gridSetting.columns[5].visible = true;
                    gridSetting.columns[6].visible = true;
                    this.controls.dgKensakuKekkaIchiran().gridSetting = gridSetting;
                    this.controls.dgKensakuKekkaIchiran()._control.afterPropertiesSet();
                };
                return TaishoMode;
            })();
            Modes.TaishoMode = TaishoMode;
        })(ChosaItakusakiAndChosainGuide.Modes || (ChosaItakusakiAndChosainGuide.Modes = {}));
        var Modes = ChosaItakusakiAndChosainGuide.Modes;
    })(DBZ.ChosaItakusakiAndChosainGuide || (DBZ.ChosaItakusakiAndChosainGuide = {}));
    var ChosaItakusakiAndChosainGuide = DBZ.ChosaItakusakiAndChosainGuide;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (ChosaItakusakiAndChosainGuide) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ChosaItakusakiAndChosainGuide.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        ChosaItakusakiAndChosainGuide.PublicProperties = PublicProperties;
    })(DBZ.ChosaItakusakiAndChosainGuide || (DBZ.ChosaItakusakiAndChosainGuide = {}));
    var ChosaItakusakiAndChosainGuide = DBZ.ChosaItakusakiAndChosainGuide;
})(DBZ || (DBZ = {}));
