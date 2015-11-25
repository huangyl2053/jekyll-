var DBZ;
(function (DBZ) {
    (function (IryohokenRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IryohokenRireki.Controls(fieldName);
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
                return new IryohokenRireki.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        IryohokenRireki.ModeController = ModeController;

        (function (Modes) {
            var State = (function () {
                function State(controls) {
                    this.controls = controls;
                }
                State.prototype.reference = function () {
                    this.controls.tbdKanyubi().readOnly = true;
                    this.controls.tbdDattabi().readOnly = true;
                    this.controls.ddlSyubetsu().disabled = true;
                    this.controls.txtHokensyaKodo().readOnly = true;
                    this.controls.txtHokensyaMeisho().readOnly = true;
                    this.controls.txtKigoBango().readOnly = true;
                    this.controls.btnIryohokenTsuika().visible = false;
                    this.controls.btnKakutei().visible = false;
                    this.controls.btnCancel().visible = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowSelectButtonColumn = true;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowDeleteButtonColumn = false;
                };

                State.prototype.registration = function () {
                    this.controls.tbdKanyubi().readOnly = true;
                    this.controls.tbdDattabi().readOnly = true;
                    this.controls.ddlSyubetsu().disabled = true;
                    this.controls.txtHokensyaKodo().readOnly = true;
                    this.controls.txtHokensyaMeisho().readOnly = true;
                    this.controls.txtKigoBango().readOnly = true;
                    this.controls.btnKakutei().disabled = true;
                    this.controls.btnCancel().disabled = true;
                    this.controls.btnIryohokenTsuika().visible = true;
                    this.controls.btnKakutei().visible = true;
                    this.controls.btnCancel().visible = true;
                    this.controls.btnIryohokenTsuika().disabled = false;
                    this.controls.btnKakutei().disabled = false;
                    this.controls.btnCancel().disabled = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowModifyButtonColumn = true;
                    this.controls.dgIryohokenIchiran().gridSetting.isShowDeleteButtonColumn = true;
                };
                return State;
            })();
            Modes.State = State;
        })(IryohokenRireki.Modes || (IryohokenRireki.Modes = {}));
        var Modes = IryohokenRireki.Modes;
    })(DBZ.IryohokenRireki || (DBZ.IryohokenRireki = {}));
    var IryohokenRireki = DBZ.IryohokenRireki;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (IryohokenRireki) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new IryohokenRireki.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        IryohokenRireki.PublicProperties = PublicProperties;
    })(DBZ.IryohokenRireki || (DBZ.IryohokenRireki = {}));
    var IryohokenRireki = DBZ.IryohokenRireki;
})(DBZ || (DBZ = {}));
