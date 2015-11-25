var DBA;
(function (DBA) {
    (function (IryohokenRirekiCommonChildDiv) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IryohokenRirekiCommonChildDiv.Controls(fieldName);
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
                return new IryohokenRirekiCommonChildDiv.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        IryohokenRirekiCommonChildDiv.ModeController = ModeController;

        (function (Modes) {
            var State = (function () {
                function State(controls) {
                    this.controls = controls;
                }
                State.prototype.照会 = function () {
                    this.controls.tbdKanyubi().readOnly = true;
                    this.controls.tbdDattabi().readOnly = true;
                    this.controls.ddlSyubetsu().disabled = true;
                    this.controls.txtHokensyaKodo().readOnly = true;
                    this.controls.txtHokensyaMeisho().readOnly = true;
                    this.controls.txtKigoBango().readOnly = true;
                    this.controls.btnIryohokenTsuika().visible = false;
                    this.controls.btnCancel().visible = false;
                    this.controls.btnIryohokenKakute().visible = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowSelectButtonColumn = true;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowDeleteButtonColumn = false;
                };

                State.prototype.追加 = function () {
                    this.controls.tbdKanyubi().readOnly = false;
                    this.controls.tbdDattabi().readOnly = false;
                    this.controls.ddlSyubetsu().disabled = false;
                    this.controls.txtHokensyaKodo().readOnly = false;
                    this.controls.txtHokensyaMeisho().readOnly = false;
                    this.controls.txtKigoBango().readOnly = false;
                    this.controls.btnIryohokenTsuika().visible = true;
                    this.controls.btnCancel().visible = true;
                    this.controls.btnIryohokenKakute().visible = true;
                    this.controls.btnIryohokenTsuika().disabled = false;
                    this.controls.btnCancel().disabled = false;
                    this.controls.btnIryohokenKakute().disabled = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowModifyButtonColumn = true;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowDeleteButtonColumn = true;
                };

                State.prototype.修正 = function () {
                    this.controls.tbdKanyubi().readOnly = false;
                    this.controls.tbdDattabi().readOnly = false;
                    this.controls.ddlSyubetsu().disabled = false;
                    this.controls.txtHokensyaKodo().readOnly = false;
                    this.controls.txtHokensyaMeisho().readOnly = false;
                    this.controls.txtKigoBango().readOnly = false;
                    this.controls.btnIryohokenTsuika().visible = true;
                    this.controls.btnCancel().visible = true;
                    this.controls.btnIryohokenKakute().visible = true;
                    this.controls.btnIryohokenTsuika().disabled = false;
                    this.controls.btnCancel().disabled = false;
                    this.controls.btnIryohokenKakute().disabled = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowModifyButtonColumn = true;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowDeleteButtonColumn = true;
                };

                State.prototype.削除 = function () {
                    this.controls.tbdKanyubi().readOnly = true;
                    this.controls.tbdDattabi().readOnly = true;
                    this.controls.ddlSyubetsu().disabled = true;
                    this.controls.txtHokensyaKodo().readOnly = true;
                    this.controls.txtHokensyaMeisho().readOnly = true;
                    this.controls.txtKigoBango().readOnly = true;
                    this.controls.btnIryohokenKakute().disabled = true;
                    this.controls.btnIryohokenTsuika().visible = true;
                    this.controls.btnCancel().visible = true;
                    this.controls.btnIryohokenKakute().visible = true;
                    this.controls.btnIryohokenTsuika().disabled = false;
                    this.controls.btnCancel().disabled = false;
                    this.controls.btnIryohokenKakute().disabled = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowModifyButtonColumn = true;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowDeleteButtonColumn = true;
                };
                return State;
            })();
            Modes.State = State;
        })(IryohokenRirekiCommonChildDiv.Modes || (IryohokenRirekiCommonChildDiv.Modes = {}));
        var Modes = IryohokenRirekiCommonChildDiv.Modes;
    })(DBA.IryohokenRirekiCommonChildDiv || (DBA.IryohokenRirekiCommonChildDiv = {}));
    var IryohokenRirekiCommonChildDiv = DBA.IryohokenRirekiCommonChildDiv;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (IryohokenRirekiCommonChildDiv) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IryohokenRirekiCommonChildDiv.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        IryohokenRirekiCommonChildDiv.PublicProperties = PublicProperties;
    })(DBA.IryohokenRirekiCommonChildDiv || (DBA.IryohokenRirekiCommonChildDiv = {}));
    var IryohokenRirekiCommonChildDiv = DBA.IryohokenRirekiCommonChildDiv;
})(DBA || (DBA = {}));
