var DBC;
(function (DBC) {
    (function (TaishoshaIchiran) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TaishoshaIchiran.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new TaishoshaIchiran.PublicProperties(this.fieldName);
            };

            ModeController.prototype.priorities = function () {
                return [
                    "State"
                ];
            };

            ModeController.prototype.State = function () {
                return new Modes.State(this.controls);
            };
            return ModeController;
        })();
        TaishoshaIchiran.ModeController = ModeController;

        (function (Modes) {
            var State = (function () {
                function State(controls) {
                    this.controls = controls;
                }
                State.prototype.ModifyMode = function () {
                    var gridSetting = this.controls.dgJukyushaIdoRenrakuhyoHenkoSearchResultList().gridSetting;

                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = true;

                    this.controls.dgJukyushaIdoRenrakuhyoHenkoSearchResultList().gridSetting = gridSetting;
                    this.controls.dgJukyushaIdoRenrakuhyoHenkoSearchResultList()._control.afterPropertiesSet();
                };

                State.prototype.SelectMode = function () {
                    var gridSetting = this.controls.dgJukyushaIdoRenrakuhyoHenkoSearchResultList().gridSetting;

                    gridSetting.isShowSelectButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = false;

                    this.controls.dgJukyushaIdoRenrakuhyoHenkoSearchResultList().gridSetting = gridSetting;
                    this.controls.dgJukyushaIdoRenrakuhyoHenkoSearchResultList()._control.afterPropertiesSet();
                };
                return State;
            })();
            Modes.State = State;
        })(TaishoshaIchiran.Modes || (TaishoshaIchiran.Modes = {}));
        var Modes = TaishoshaIchiran.Modes;
    })(DBC.TaishoshaIchiran || (DBC.TaishoshaIchiran = {}));
    var TaishoshaIchiran = DBC.TaishoshaIchiran;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (TaishoshaIchiran) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TaishoshaIchiran.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TaishoshaIchiran.PublicProperties = PublicProperties;
    })(DBC.TaishoshaIchiran || (DBC.TaishoshaIchiran = {}));
    var TaishoshaIchiran = DBC.TaishoshaIchiran;
})(DBC || (DBC = {}));
