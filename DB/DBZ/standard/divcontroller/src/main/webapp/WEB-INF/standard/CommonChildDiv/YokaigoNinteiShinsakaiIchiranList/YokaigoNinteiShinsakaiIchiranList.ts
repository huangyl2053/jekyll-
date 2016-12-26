/// <reference path='YokaigoNinteiShinsakaiIchiranList_Design.ts' />
module DBZ {
    export module YokaigoNinteiShinsakaiIchiranList {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public Properties() {
                return new UZA.CommonChildDiv(this.fieldName);
            }

            public GridDisplayMode() {
                return new Modes.GridDisplayMode(this.controls);
            }
        }
        export module Modes {
            export class GridDisplayMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public KaisaiYoteiToroku(): void {

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


                }

                public TaishoshaWaritsuke(): void {

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
                }
                public ShinsakaiShiryoSakusei(): void {

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
                }
                public ShinsaKekkaToroku(): void {
                    
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


                    gridSetting.columns[0].visible = false;
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
                }
                public JizenKekkaToroku(): void {

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
                }
                public DataShutsuryoku(): void {

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
                }
                public HanteiKekka(): void {

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

                    gridSetting.columns[0].visible = false;
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
                }
            }
        }
    }
}
module DBZ
{
    export module YokaigoNinteiShinsakaiIchiranList
    {
        export class PublicProperties {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public getEditTypes(): UZA.EditTypeForPublicProperty {
                var editTypes = new UZA.EditTypeForPublicProperty();

                return editTypes;
            }
        }
    }
}

