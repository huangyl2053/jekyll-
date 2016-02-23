var DBC;
(function (DBC) {
    (function (JyutakugaisyunaiyoList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JyutakugaisyunaiyoList.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [
                    "State"
                ];
            };
            ModeController.prototype.State = function () {
                return new Modes.State(this.controls);
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new JyutakugaisyunaiyoList.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        JyutakugaisyunaiyoList.ModeController = ModeController;

        (function (Modes) {
            var State = (function () {
                function State(controls) {
                    this.controls = controls;
                }
                State.prototype.touroku = function () {
                    this.controls.btnDetailAdd().displayNone = false;
                    this.controls.dgGaisyuList().gridSetting.isShowModifyButtonColumn = true;
                    this.controls.dgGaisyuList().gridSetting.isShowDeleteButtonColumn = true;
                    this.controls.dgGaisyuList().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgGaisyuList()._control.afterPropertiesSet();
                };
                State.prototype.sansyo = function () {
                    this.controls.btnDetailAdd().displayNone = true;
                    this.controls.dgGaisyuList().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgGaisyuList().gridSetting.isShowDeleteButtonColumn = false;
                    this.controls.dgGaisyuList().gridSetting.isShowSelectButtonColumn = true;
                    this.controls.dgGaisyuList()._control.afterPropertiesSet();
                };
                return State;
            })();
            Modes.State = State;
        })(JyutakugaisyunaiyoList.Modes || (JyutakugaisyunaiyoList.Modes = {}));
        var Modes = JyutakugaisyunaiyoList.Modes;
    })(DBC.JyutakugaisyunaiyoList || (DBC.JyutakugaisyunaiyoList = {}));
    var JyutakugaisyunaiyoList = DBC.JyutakugaisyunaiyoList;
})(DBC || (DBC = {}));

var DBC;
(function (DBC) {
    (function (JyutakugaisyunaiyoList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new JyutakugaisyunaiyoList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        JyutakugaisyunaiyoList.PublicProperties = PublicProperties;
    })(DBC.JyutakugaisyunaiyoList || (DBC.JyutakugaisyunaiyoList = {}));
    var JyutakugaisyunaiyoList = DBC.JyutakugaisyunaiyoList;
})(DBC || (DBC = {}));
