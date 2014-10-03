var DBZ;
(function (DBZ) {
    (function (JushochiTokureiRireki) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.controls = new JushochiTokureiRireki.Controls(fieldName);
            }
            ModeController.prototype.DisplayMode = function () {
                return new Modes.DisplayMode(this.controls);
            };
            return ModeController;
        })();
        JushochiTokureiRireki.ModeController = ModeController;
        (function (Modes) {
            var DisplayMode = (function () {
                function DisplayMode(controls) {
                    this.controls = controls;
                }
                DisplayMode.prototype.Shokai = function () {
                    this.controls.btnAdd().visible = false;
                    this.controls.btnAdd().displayNone = true;
                    this.controls.dgJushochiTokureiRireki().readOnly = true;

                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowDeleteButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                };

                DisplayMode.prototype.IdoToroku = function () {
                    this.controls.btnAdd().visible = true;
                    this.controls.btnAdd().displayNone = false;
                    this.controls.dgJushochiTokureiRireki().readOnly = false;

                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowSelectButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowModifyButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki().gridSetting.isShowDeleteButtonColumn = false;
                    this.controls.dgJushochiTokureiRireki()._control.afterPropertiesSet();
                };
                return DisplayMode;
            })();
            Modes.DisplayMode = DisplayMode;
        })(JushochiTokureiRireki.Modes || (JushochiTokureiRireki.Modes = {}));
        var Modes = JushochiTokureiRireki.Modes;
    })(DBZ.JushochiTokureiRireki || (DBZ.JushochiTokureiRireki = {}));
    var JushochiTokureiRireki = DBZ.JushochiTokureiRireki;
})(DBZ || (DBZ = {}));
