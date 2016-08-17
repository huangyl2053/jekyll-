var DBA;
(function (DBA) {
    (function (TaJushochiTokureishaKanri) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TaJushochiTokureishaKanri.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new TaJushochiTokureishaKanri.PublicProperties(this.fieldName);
            };
            ModeController.prototype.priorities = function () {
                return [
                    "DisplayMode"
                ];
            };

            ModeController.prototype.DisplayMode = function () {
                return new Modes.DisplayMode(this.controls);
            };
            return ModeController;
        })();
        TaJushochiTokureishaKanri.ModeController = ModeController;

        (function (Modes) {
            var DisplayMode = (function () {
                function DisplayMode(controls) {
                    this.controls = controls;
                }
                DisplayMode.prototype.Shokai = function () {
                    this.controls.btnAdd().displayNone = true;
                    this.controls.btnKakunin().displayNone = true;
                    this.controls.btnTorikeshi().displayNone = true;

                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;
                    var columns = gridSetting.columns;

                    gridSetting.isShowRowState = false;
                    gridSetting.isShowSelectButtonColumn = true;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;

                    this.controls.TajushochiTokureiInput().title = "他市町村住所地特例情報";
                    this.controls.TajushochiTokureiInput().displayNone = false;
                    this.controls.TajushochiTokureiInput().disabled = true;

                    this.controls.txtNyusyobi().displayNone = true;
                    this.controls.txtTekiyobi().displayNone = false;
                    this.controls.txtTekiyoTodokedebi().displayNone = false;
                    this.controls.ddlTekiyoJiyo().displayNone = false;

                    this.controls.txtTasyobi().displayNone = true;
                    this.controls.txtKaijyobi().displayNone = false;
                    this.controls.txtKaijyoTodokedebi().displayNone = false;
                    this.controls.ddlKaijyoJiyo().displayNone = false;
                    this.controls.txtKaijyobi().wrap = true;

                    this.controls.panSotimotoJyoho().displayNone = false;
                    this.controls.panShisetsuJoho().displayNone = true;
                };

                DisplayMode.prototype.Teisei = function () {
                    this.controls.btnAdd().displayNone = false;
                    this.controls.btnKakunin().displayNone = false;
                    this.controls.btnTorikeshi().displayNone = false;

                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;
                    var columns = gridSetting.columns;

                    gridSetting.isShowRowState = true;
                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;

                    this.controls.TajushochiTokureiInput().title = "他市町村住所地特例情報入力";
                    this.controls.TajushochiTokureiInput().displayNone = false;
                    this.controls.TajushochiTokureiInput().disabled = false;

                    this.controls.txtNyusyobi().displayNone = true;
                    this.controls.txtTekiyobi().displayNone = false;
                    this.controls.txtTekiyoTodokedebi().displayNone = false;
                    this.controls.ddlTekiyoJiyo().displayNone = false;

                    this.controls.txtTasyobi().displayNone = true;
                    this.controls.txtKaijyobi().displayNone = false;
                    this.controls.txtKaijyoTodokedebi().displayNone = false;
                    this.controls.ddlKaijyoJiyo().displayNone = false;
                    this.controls.txtKaijyobi().wrap = true;

                    this.controls.panSotimotoJyoho().displayNone = false;
                    this.controls.panShisetsuJoho().displayNone = true;
                };

                DisplayMode.prototype.Tekiyo = function () {
                    this.controls.btnAdd().displayNone = false;
                    this.controls.btnKakunin().displayNone = false;
                    this.controls.btnTorikeshi().displayNone = true;

                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;
                    var columns = gridSetting.columns;

                    gridSetting.isShowRowState = false;
                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = true;
                    gridSetting.isShowDeleteButtonColumn = true;

                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;

                    this.controls.TajushochiTokureiInput().title = "他市町村住所地特例情報入力";
                    this.controls.TajushochiTokureiInput().displayNone = false;
                    this.controls.TajushochiTokureiInput().disabled = false;

                    this.controls.txtNyusyobi().displayNone = false;
                    this.controls.txtTekiyobi().displayNone = false;
                    this.controls.txtTekiyoTodokedebi().displayNone = false;
                    this.controls.ddlTekiyoJiyo().displayNone = false;

                    this.controls.txtTasyobi().displayNone = true;
                    this.controls.txtKaijyobi().displayNone = true;
                    this.controls.txtKaijyoTodokedebi().displayNone = true;
                    this.controls.ddlKaijyoJiyo().displayNone = true;

                    this.controls.panSotimotoJyoho().displayNone = false;
                    this.controls.panShisetsuJoho().displayNone = false;
                };

                DisplayMode.prototype.Kaijyo = function () {
                    this.controls.btnAdd().displayNone = true;
                    this.controls.btnKakunin().displayNone = false;
                    this.controls.btnTorikeshi().displayNone = true;

                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;
                    var columns = gridSetting.columns;

                    gridSetting.isShowRowState = false;
                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;

                    this.controls.TajushochiTokureiInput().title = "他市町村住所地特例情報入力";
                    this.controls.TajushochiTokureiInput().displayNone = false;
                    this.controls.TajushochiTokureiInput().disabled = false;

                    this.controls.txtNyusyobi().displayNone = true;
                    this.controls.txtTekiyobi().displayNone = true;
                    this.controls.txtTekiyoTodokedebi().displayNone = true;
                    this.controls.ddlTekiyoJiyo().displayNone = true;

                    this.controls.txtTasyobi().displayNone = false;
                    this.controls.txtKaijyobi().displayNone = false;
                    this.controls.txtKaijyoTodokedebi().displayNone = false;
                    this.controls.ddlKaijyoJiyo().displayNone = false;
                    this.controls.txtKaijyobi().wrap = false;

                    this.controls.panSotimotoJyoho().displayNone = true;
                    this.controls.panShisetsuJoho().displayNone = true;
                };

                DisplayMode.prototype.ShisetuHenko = function () {
                    this.controls.btnAdd().displayNone = true;
                    this.controls.btnKakunin().displayNone = true;
                    this.controls.btnTorikeshi().displayNone = true;

                    var gridSetting = this.controls.dgJushochiTokureiRireki().gridSetting;
                    var columns = gridSetting.columns;

                    gridSetting.isShowRowState = false;
                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isShowModifyButtonColumn = false;
                    gridSetting.isShowDeleteButtonColumn = false;

                    this.controls.dgJushochiTokureiRireki().gridSetting = gridSetting;

                    this.controls.TajushochiTokureiInput().displayNone = true;
                };
                return DisplayMode;
            })();
            Modes.DisplayMode = DisplayMode;
        })(TaJushochiTokureishaKanri.Modes || (TaJushochiTokureishaKanri.Modes = {}));
        var Modes = TaJushochiTokureishaKanri.Modes;
    })(DBA.TaJushochiTokureishaKanri || (DBA.TaJushochiTokureishaKanri = {}));
    var TaJushochiTokureishaKanri = DBA.TaJushochiTokureishaKanri;
})(DBA || (DBA = {}));

var DBA;
(function (DBA) {
    (function (TaJushochiTokureishaKanri) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new TaJushochiTokureishaKanri.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        TaJushochiTokureishaKanri.PublicProperties = PublicProperties;
    })(DBA.TaJushochiTokureishaKanri || (DBA.TaJushochiTokureishaKanri = {}));
    var TaJushochiTokureishaKanri = DBA.TaJushochiTokureishaKanri;
})(DBA || (DBA = {}));
