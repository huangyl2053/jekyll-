var DBZ;
(function (DBZ) {
    (function (YokaigoNinteiShinsakaiIchiranList) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new YokaigoNinteiShinsakaiIchiranList.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.GridDisplayMode = function () {
                return new Modes.GridDisplayMode(this.controls);
            };
            return ModeController;
        })();
        YokaigoNinteiShinsakaiIchiranList.ModeController = ModeController;
        (function (Modes) {
            var GridDisplayMode = (function () {
                function GridDisplayMode(controls) {
                    this.controls = controls;
                }
                GridDisplayMode.prototype.KaisaiYoteiToroku = function () {
                    this.controls.radHyojiJokenWaritsukeMikanryo().displayNone = false;
                    this.controls.radHyojiJokenWaritsukeMikanryo().visible = false;
                    this.controls.radHyojiJokenWaritsukeKanryo().displayNone = true;
                    this.controls.radHyojiJokenShinsakaiMikanryo().displayNone = true;
                    this.controls.radHyojiJokenShinsakaiKanryo().displayNone = true;
                    this.controls.radDammyShinsakai().displayNone = false;

                    var gridSetting = this.controls.dgShinsakaiIchiran().gridSetting;
                    this.controls.dgShinsakaiIchiran().width = 1085;

                    gridSetting.isShowSelectButtonColumn = false;
                    gridSetting.isMultiSelectable = true;
                    gridSetting.isShowFilter = false;

                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;
                    gridSetting.columns[5].visible = true;
                    gridSetting.columns[6].visible = true;
                    gridSetting.columns[7].visible = false;
                    gridSetting.columns[8].visible = false;
                    gridSetting.columns[9].visible = false;
                    gridSetting.columns[10].visible = true;
                    gridSetting.columns[11].visible = true;
                    gridSetting.columns[12].visible = false;
                    gridSetting.columns[13].visible = false;
                    gridSetting.columns[14].visible = false;
                    gridSetting.columns[15].visible = false;
                    gridSetting.columns[16].visible = true;
                    gridSetting.columns[17].visible = true;

                    this.controls.dgShinsakaiIchiran().gridSetting = gridSetting;
                    this.controls.dgShinsakaiIchiran()._control.afterPropertiesSet();
                };

                GridDisplayMode.prototype.TaishoshaWaritsuke = function () {
                    this.controls.radHyojiJokenWaritsukeMikanryo().displayNone = false;
                    this.controls.radHyojiJokenWaritsukeMikanryo().visible = false;
                    this.controls.radHyojiJokenWaritsukeKanryo().displayNone = true;
                    this.controls.radHyojiJokenShinsakaiMikanryo().displayNone = true;
                    this.controls.radHyojiJokenShinsakaiKanryo().displayNone = true;
                    this.controls.radDammyShinsakai().displayNone = false;

                    var gridSetting = this.controls.dgShinsakaiIchiran().gridSetting;
                    this.controls.dgShinsakaiIchiran().width = this.controls.dgShinsakaiIchiran().width = 1085;

                    gridSetting.isShowSelectButtonColumn = true;
                    gridSetting.isMultiSelectable = false;
                    gridSetting.isShowFilter = false;

                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;
                    gridSetting.columns[5].visible = true;
                    gridSetting.columns[6].visible = true;
                    gridSetting.columns[7].visible = false;
                    gridSetting.columns[8].visible = false;
                    gridSetting.columns[9].visible = false;
                    gridSetting.columns[10].visible = true;
                    gridSetting.columns[11].visible = true;
                    gridSetting.columns[12].visible = false;
                    gridSetting.columns[13].visible = false;
                    gridSetting.columns[14].visible = false;
                    gridSetting.columns[15].visible = false;
                    gridSetting.columns[16].visible = true;
                    gridSetting.columns[17].visible = true;

                    this.controls.dgShinsakaiIchiran().gridSetting = gridSetting;
                    this.controls.dgShinsakaiIchiran()._control.afterPropertiesSet();
                };
                GridDisplayMode.prototype.ShinsakaiShiryoSakusei = function () {
                    this.controls.radHyojiJokenWaritsukeMikanryo().displayNone = true;
                    this.controls.radHyojiJokenWaritsukeMikanryo().visible = true;
                    this.controls.radHyojiJokenWaritsukeKanryo().displayNone = false;
                    this.controls.radHyojiJokenShinsakaiMikanryo().displayNone = true;
                    this.controls.radHyojiJokenShinsakaiKanryo().displayNone = true;
                    this.controls.radDammyShinsakai().displayNone = true;

                    var gridSetting = this.controls.dgShinsakaiIchiran().gridSetting;
                    this.controls.dgShinsakaiIchiran().width = 1085;

                    gridSetting.isShowFilter = false;
                    gridSetting.isMultiSelectable = false;
                    gridSetting.isShowSelectButtonColumn = true;

                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;
                    gridSetting.columns[5].visible = true;
                    gridSetting.columns[6].visible = true;
                    gridSetting.columns[7].visible = false;
                    gridSetting.columns[8].visible = false;
                    gridSetting.columns[9].visible = false;
                    gridSetting.columns[10].visible = true;
                    gridSetting.columns[11].visible = true;
                    gridSetting.columns[12].visible = false;
                    gridSetting.columns[13].visible = false;
                    gridSetting.columns[14].visible = false;
                    gridSetting.columns[15].visible = true;
                    gridSetting.columns[16].visible = true;
                    gridSetting.columns[17].visible = true;

                    this.controls.dgShinsakaiIchiran().gridSetting = gridSetting;
                    this.controls.dgShinsakaiIchiran()._control.afterPropertiesSet();
                };
                GridDisplayMode.prototype.ShinsaKekkaToroku = function () {
                    this.controls.radHyojiJokenWaritsukeMikanryo().displayNone = true;
                    this.controls.radHyojiJokenWaritsukeMikanryo().visible = true;
                    this.controls.radHyojiJokenWaritsukeKanryo().displayNone = true;
                    this.controls.radHyojiJokenShinsakaiMikanryo().displayNone = false;
                    this.controls.radHyojiJokenShinsakaiKanryo().displayNone = true;
                    this.controls.radDammyShinsakai().displayNone = true;

                    var gridSetting = this.controls.dgShinsakaiIchiran().gridSetting;
                    this.controls.dgShinsakaiIchiran().width = 1085;

                    gridSetting.isMultiSelectable = false;
                    gridSetting.isShowSelectButtonColumn = true;
                    gridSetting.isShowFilter = false;

                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = false;
                    gridSetting.columns[2].visible = false;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;
                    gridSetting.columns[5].visible = true;
                    gridSetting.columns[6].visible = true;
                    gridSetting.columns[7].visible = true;
                    gridSetting.columns[8].visible = true;
                    gridSetting.columns[9].visible = true;
                    gridSetting.columns[10].visible = false;
                    gridSetting.columns[11].visible = true;
                    gridSetting.columns[12].visible = true;
                    gridSetting.columns[13].visible = true;
                    gridSetting.columns[14].visible = true;
                    gridSetting.columns[15].visible = true;
                    gridSetting.columns[16].visible = true;
                    gridSetting.columns[17].visible = true;

                    this.controls.dgShinsakaiIchiran().gridSetting = gridSetting;
                    this.controls.dgShinsakaiIchiran()._control.afterPropertiesSet();
                };
                GridDisplayMode.prototype.JizenKekkaToroku = function () {
                    this.controls.radHyojiJokenWaritsukeMikanryo().displayNone = true;
                    this.controls.radHyojiJokenWaritsukeMikanryo().visible = true;
                    this.controls.radHyojiJokenWaritsukeKanryo().displayNone = true;
                    this.controls.radHyojiJokenShinsakaiMikanryo().displayNone = false;
                    this.controls.radHyojiJokenShinsakaiKanryo().displayNone = true;
                    this.controls.radDammyShinsakai().displayNone = true;

                    var gridSetting = this.controls.dgShinsakaiIchiran().gridSetting;
                    this.controls.dgShinsakaiIchiran().width = 1085;

                    gridSetting.isShowFilter = false;
                    gridSetting.isMultiSelectable = false;
                    gridSetting.isShowSelectButtonColumn = true;

                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;
                    gridSetting.columns[5].visible = true;
                    gridSetting.columns[6].visible = true;
                    gridSetting.columns[7].visible = true;
                    gridSetting.columns[8].visible = true;
                    gridSetting.columns[9].visible = true;
                    gridSetting.columns[10].visible = false;
                    gridSetting.columns[11].visible = true;
                    gridSetting.columns[12].visible = true;
                    gridSetting.columns[13].visible = false;
                    gridSetting.columns[14].visible = false;
                    gridSetting.columns[15].visible = true;
                    gridSetting.columns[16].visible = true;
                    gridSetting.columns[17].visible = true;

                    this.controls.dgShinsakaiIchiran().gridSetting = gridSetting;
                    this.controls.dgShinsakaiIchiran()._control.afterPropertiesSet();
                };
                GridDisplayMode.prototype.DataShutsuryoku = function () {
                    this.controls.radHyojiJokenWaritsukeMikanryo().displayNone = true;
                    this.controls.radHyojiJokenWaritsukeMikanryo().visible = true;
                    this.controls.radHyojiJokenWaritsukeKanryo().displayNone = true;
                    this.controls.radHyojiJokenShinsakaiMikanryo().displayNone = false;
                    this.controls.radHyojiJokenShinsakaiKanryo().displayNone = true;
                    this.controls.radDammyShinsakai().displayNone = true;

                    var gridSetting = this.controls.dgShinsakaiIchiran().gridSetting;
                    this.controls.dgShinsakaiIchiran().width = 1085;

                    gridSetting.isShowFilter = false;
                    gridSetting.isMultiSelectable = true;
                    gridSetting.isShowSelectButtonColumn = false;

                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;
                    gridSetting.columns[5].visible = true;
                    gridSetting.columns[6].visible = true;
                    gridSetting.columns[7].visible = true;
                    gridSetting.columns[8].visible = true;
                    gridSetting.columns[9].visible = true;
                    gridSetting.columns[10].visible = true;
                    gridSetting.columns[11].visible = true;
                    gridSetting.columns[12].visible = false;
                    gridSetting.columns[13].visible = false;
                    gridSetting.columns[14].visible = true;
                    gridSetting.columns[15].visible = true;
                    gridSetting.columns[16].visible = true;
                    gridSetting.columns[17].visible = true;

                    this.controls.dgShinsakaiIchiran().gridSetting = gridSetting;
                    this.controls.dgShinsakaiIchiran()._control.afterPropertiesSet();
                };
                GridDisplayMode.prototype.HanteiKekka = function () {
                    this.controls.radHyojiJokenWaritsukeMikanryo().displayNone = true;
                    this.controls.radHyojiJokenWaritsukeMikanryo().visible = true;
                    this.controls.radHyojiJokenWaritsukeKanryo().displayNone = true;
                    this.controls.radHyojiJokenShinsakaiMikanryo().displayNone = true;
                    this.controls.radHyojiJokenShinsakaiKanryo().displayNone = false;
                    this.controls.radDammyShinsakai().displayNone = true;

                    var gridSetting = this.controls.dgShinsakaiIchiran().gridSetting;
                    this.controls.dgShinsakaiIchiran().width = 1085;

                    gridSetting.isShowFilter = false;
                    gridSetting.isMultiSelectable = true;
                    gridSetting.isShowSelectButtonColumn = false;

                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = false;
                    gridSetting.columns[2].visible = false;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;
                    gridSetting.columns[5].visible = true;
                    gridSetting.columns[6].visible = true;
                    gridSetting.columns[7].visible = true;
                    gridSetting.columns[8].visible = true;
                    gridSetting.columns[9].visible = true;
                    gridSetting.columns[10].visible = false;
                    gridSetting.columns[11].visible = true;
                    gridSetting.columns[12].visible = true;
                    gridSetting.columns[13].visible = false;
                    gridSetting.columns[14].visible = true;
                    gridSetting.columns[15].visible = true;
                    gridSetting.columns[16].visible = true;
                    gridSetting.columns[17].visible = true;

                    this.controls.dgShinsakaiIchiran().gridSetting = gridSetting;
                    this.controls.dgShinsakaiIchiran()._control.afterPropertiesSet();
                };
                return GridDisplayMode;
            })();
            Modes.GridDisplayMode = GridDisplayMode;
        })(YokaigoNinteiShinsakaiIchiranList.Modes || (YokaigoNinteiShinsakaiIchiranList.Modes = {}));
        var Modes = YokaigoNinteiShinsakaiIchiranList.Modes;
    })(DBZ.YokaigoNinteiShinsakaiIchiranList || (DBZ.YokaigoNinteiShinsakaiIchiranList = {}));
    var YokaigoNinteiShinsakaiIchiranList = DBZ.YokaigoNinteiShinsakaiIchiranList;
})(DBZ || (DBZ = {}));
var DBZ;
(function (DBZ) {
    (function (YokaigoNinteiShinsakaiIchiranList) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.fieldName = fieldName;
                this.controls = new YokaigoNinteiShinsakaiIchiranList.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            };
            return PublicProperties;
        })();
        YokaigoNinteiShinsakaiIchiranList.PublicProperties = PublicProperties;
    })(DBZ.YokaigoNinteiShinsakaiIchiranList || (DBZ.YokaigoNinteiShinsakaiIchiranList = {}));
    var YokaigoNinteiShinsakaiIchiranList = DBZ.YokaigoNinteiShinsakaiIchiranList;
})(DBZ || (DBZ = {}));
