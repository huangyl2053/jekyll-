/// <reference path='YokaigoNinteiTaskList_Design.ts' />
module DBZ
{
    export module YokaigoNinteiTaskList {
        export class ModeController {
            private controls: Controls;
            private fieldName: string;

            constructor(fieldName: string) {
                this.fieldName = fieldName;
                this.controls = new Controls(fieldName);
            }

            public GridDisplay() {
                return new Modes.GridDisplayMode(this.controls);
            }
           
        }

        export module Modes {
            export class GridDisplayMode {
                private controls: Controls;

                constructor(controls: Controls) {
                    this.controls = controls;
                }

                public KoshinTaisho(): void {
                    var gridSetting = this.controls.dgNinteiTaskList().gridSetting;


                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[6].visible = true;
                    gridSetting.columns[7].visible = true;

                    gridSetting.columns[1].visible = false;
                    gridSetting.columns[4].visible = false;
                    gridSetting.columns[5].visible = false;
                    gridSetting.columns[8].visible = false;
                    gridSetting.columns[9].visible = false;
                    gridSetting.columns[10].visible = false;
                    gridSetting.columns[11].visible = false;
                    gridSetting.columns[12].visible = false;
                    gridSetting.columns[13].visible = false;
                    gridSetting.columns[14].visible = false;
                    gridSetting.columns[15].visible = false;
                    gridSetting.columns[16].visible = false;
                    gridSetting.columns[17].visible = false;
                    gridSetting.columns[18].visible = false;
                    gridSetting.columns[19].visible = false;
                    gridSetting.columns[20].visible = false;
                    gridSetting.columns[21].visible = false;
                    gridSetting.columns[22].visible = false;
                    gridSetting.columns[23].visible = false;
                    gridSetting.columns[24].visible = false;
                    gridSetting.columns[25].visible = false;
                    gridSetting.columns[26].visible = false;
                    gridSetting.columns[27].visible = false;
                    gridSetting.columns[28].visible = false;
                    gridSetting.columns[29].visible = false;
                    gridSetting.columns[30].visible = false;
                    gridSetting.columns[31].visible = false;
                    gridSetting.columns[32].visible = false;
                    gridSetting.columns[33].visible = false;
                    gridSetting.columns[34].visible = false;
                    gridSetting.columns[35].visible = false;
                    gridSetting.columns[36].visible = false;
                    gridSetting.columns[37].visible = false;
                    gridSetting.columns[38].visible = false;
                    gridSetting.columns[39].visible = false;
                    gridSetting.columns[40].visible = false;
                    gridSetting.columns[41].visible = false;
                    gridSetting.columns[42].visible = false;
                    gridSetting.columns[43].visible = false;
                    gridSetting.columns[44].visible = false;
                    gridSetting.columns[45].visible = false;
                    gridSetting.columns[46].visible = false;
                    gridSetting.columns[47].visible = false;
                    gridSetting.columns[48].visible = false;
                    gridSetting.columns[49].visible = false;
                    gridSetting.columns[50].visible = false;
                    gridSetting.columns[51].visible = false;
                    gridSetting.columns[52].visible = false;
                    gridSetting.columns[53].visible = false;
                    gridSetting.columns[54].visible = false;
                    gridSetting.columns[55].visible = false;
                    gridSetting.columns[56].visible = false;
                    gridSetting.columns[57].visible = false;
                    gridSetting.columns[58].visible = false;
                    gridSetting.columns[59].visible = false;
                    gridSetting.columns[60].visible = false;
                    gridSetting.columns[61].visible = false;
                    gridSetting.columns[62].visible = false;
                    gridSetting.columns[63].visible = false;
                    gridSetting.columns[64].visible = false;
                    gridSetting.columns[65].visible = false;
                    gridSetting.columns[66].visible = false;
                    gridSetting.columns[67].visible = false;
                    gridSetting.columns[68].visible = false;
                    gridSetting.columns[69].visible = false;
                    gridSetting.columns[70].visible = false;
                    gridSetting.columns[71].visible = false;
                    gridSetting.columns[72].visible = false;
                    gridSetting.columns[73].visible = false;                    

                    this.controls.dgNinteiTaskList().gridSetting = gridSetting;
                    this.controls.dgNinteiTaskList()._control.afterPropertiesSet();
                }
                public ShinseiUketsuke(): void {
                    var gridSetting = this.controls.dgNinteiTaskList().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;
                    gridSetting.columns[8].visible = true;
                    gridSetting.columns[11].visible = true;
                    gridSetting.columns[12].visible = true;
                    gridSetting.columns[73].visible = true;
 

                    gridSetting.columns[5].visible = false;
                    gridSetting.columns[6].visible = false;
                    gridSetting.columns[7].visible = false;
                    gridSetting.columns[9].visible = false;
                    gridSetting.columns[10].visible = false;
                    gridSetting.columns[13].visible = false;
                    gridSetting.columns[14].visible = false;
                    gridSetting.columns[15].visible = false;
                    gridSetting.columns[16].visible = false;
                    gridSetting.columns[17].visible = false;
                    gridSetting.columns[18].visible = false;
                    gridSetting.columns[19].visible = false;
                    gridSetting.columns[20].visible = false;
                    gridSetting.columns[21].visible = false;
                    gridSetting.columns[22].visible = false;
                    gridSetting.columns[23].visible = false;
                    gridSetting.columns[24].visible = false;
                    gridSetting.columns[25].visible = false;
                    gridSetting.columns[26].visible = false;
                    gridSetting.columns[27].visible = false;
                    gridSetting.columns[28].visible = false;
                    gridSetting.columns[29].visible = false;
                    gridSetting.columns[30].visible = false;
                    gridSetting.columns[31].visible = false;
                    gridSetting.columns[32].visible = false;
                    gridSetting.columns[33].visible = false;
                    gridSetting.columns[34].visible = false;
                    gridSetting.columns[35].visible = false;
                    gridSetting.columns[36].visible = false;
                    gridSetting.columns[37].visible = false;
                    gridSetting.columns[38].visible = false;
                    gridSetting.columns[39].visible = false;
                    gridSetting.columns[40].visible = false;
                    gridSetting.columns[41].visible = false;
                    gridSetting.columns[42].visible = false;
                    gridSetting.columns[43].visible = false;
                    gridSetting.columns[44].visible = false;
                    gridSetting.columns[45].visible = false;
                    gridSetting.columns[46].visible = false;
                    gridSetting.columns[47].visible = false;
                    gridSetting.columns[48].visible = false;
                    gridSetting.columns[49].visible = false;
                    gridSetting.columns[50].visible = false;
                    gridSetting.columns[51].visible = false;
                    gridSetting.columns[52].visible = false;
                    gridSetting.columns[53].visible = false;
                    gridSetting.columns[54].visible = false;
                    gridSetting.columns[55].visible = false;
                    gridSetting.columns[56].visible = false;
                    gridSetting.columns[57].visible = false;
                    gridSetting.columns[58].visible = false;
                    gridSetting.columns[59].visible = false;
                    gridSetting.columns[60].visible = false;
                    gridSetting.columns[61].visible = false;
                    gridSetting.columns[62].visible = false;
                    gridSetting.columns[63].visible = false;
                    gridSetting.columns[64].visible = false;
                    gridSetting.columns[65].visible = false;
                    gridSetting.columns[66].visible = false;
                    gridSetting.columns[67].visible = false;
                    gridSetting.columns[68].visible = false;
                    gridSetting.columns[69].visible = false;
                    gridSetting.columns[70].visible = false;
                    gridSetting.columns[71].visible = false;
                    gridSetting.columns[72].visible = false;                   
                                     

                    this.controls.dgNinteiTaskList().gridSetting = gridSetting;
                    this.controls.dgNinteiTaskList()._control.afterPropertiesSet();
                }
                public ChosaIrai(): void {
                    var gridSetting = this.controls.dgNinteiTaskList().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;
                    gridSetting.columns[5].visible = true;
                    gridSetting.columns[9].visible = true;
                    gridSetting.columns[10].visible = true;
                    gridSetting.columns[11].visible = true;
                    gridSetting.columns[12].visible = true;
                    gridSetting.columns[13].visible = true;
                    gridSetting.columns[14].visible = true;
                    gridSetting.columns[15].visible = true;
                    gridSetting.columns[16].visible = true;
                    gridSetting.columns[17].visible = true;
                    gridSetting.columns[18].visible = true;
                    gridSetting.columns[19].visible = true;
                    gridSetting.columns[20].visible = true;
                    gridSetting.columns[21].visible = true;
					gridSetting.columns[38].visible = true;
                    gridSetting.columns[39].visible = true;
                    gridSetting.columns[40].visible = true;
                    gridSetting.columns[41].visible = true;
                    gridSetting.columns[42].visible = true;
                    gridSetting.columns[43].visible = true;
                    gridSetting.columns[44].visible = true;
                    gridSetting.columns[45].visible = true;                
					gridSetting.columns[73].visible = true;                    

                    gridSetting.columns[6].visible = false;
                    gridSetting.columns[7].visible = false;
                    gridSetting.columns[8].visible = false;
                    gridSetting.columns[22].visible = false;
                    gridSetting.columns[23].visible = false;
                    gridSetting.columns[24].visible = false;
                    gridSetting.columns[25].visible = false;
                    gridSetting.columns[26].visible = false;
                    gridSetting.columns[27].visible = false;
                    gridSetting.columns[28].visible = false;
                    gridSetting.columns[29].visible = false;
                    gridSetting.columns[30].visible = false;
                    gridSetting.columns[31].visible = false;
                    gridSetting.columns[32].visible = false;
                    gridSetting.columns[33].visible = false;
                    gridSetting.columns[34].visible = false;
                    gridSetting.columns[35].visible = false;
                    gridSetting.columns[36].visible = false;
                    gridSetting.columns[37].visible = false;                  
					gridSetting.columns[46].visible = false;
					gridSetting.columns[47].visible = false;
					gridSetting.columns[48].visible = false;
                    gridSetting.columns[49].visible = false;
                    gridSetting.columns[50].visible = false;
                    gridSetting.columns[51].visible = false;
                    gridSetting.columns[52].visible = false;
                    gridSetting.columns[53].visible = false;
                    gridSetting.columns[54].visible = false;
                    gridSetting.columns[55].visible = false;
                    gridSetting.columns[56].visible = false;
                    gridSetting.columns[57].visible = false;
                    gridSetting.columns[58].visible = false;
                    gridSetting.columns[59].visible = false;
                    gridSetting.columns[60].visible = false;
                    gridSetting.columns[61].visible = false;
                    gridSetting.columns[62].visible = false;
                    gridSetting.columns[63].visible = false;
                    gridSetting.columns[64].visible = false;
                    gridSetting.columns[65].visible = false;
                    gridSetting.columns[66].visible = false;
                    gridSetting.columns[67].visible = false;
                    gridSetting.columns[68].visible = false;
                    gridSetting.columns[69].visible = false;
                    gridSetting.columns[70].visible = false;
                    gridSetting.columns[71].visible = false;
                    gridSetting.columns[72].visible = false;                  
                 
              

                    this.controls.dgNinteiTaskList().gridSetting = gridSetting;
                    this.controls.dgNinteiTaskList()._control.afterPropertiesSet();
                }
                public IkenshoIraisho(): void {
                    var gridSetting = this.controls.dgNinteiTaskList().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;										
                    gridSetting.columns[24].visible = true;
                    gridSetting.columns[25].visible = true;
                    gridSetting.columns[26].visible = true;
                    gridSetting.columns[27].visible = true;
                    gridSetting.columns[28].visible = true;
                    gridSetting.columns[29].visible = true;
                    gridSetting.columns[30].visible = true;					
					
                    gridSetting.columns[33].visible = true;
                    gridSetting.columns[34].visible = true;
                    gridSetting.columns[35].visible = true;                
                    gridSetting.columns[36].visible = true;
                    gridSetting.columns[37].visible = true;
                    gridSetting.columns[38].visible = true;
                    gridSetting.columns[39].visible = true;
                    gridSetting.columns[40].visible = true;
                    gridSetting.columns[46].visible = true;
                    gridSetting.columns[47].visible = true;
                    gridSetting.columns[48].visible = true;
                    gridSetting.columns[49].visible = true;	
                    gridSetting.columns[72].visible = true;
                    gridSetting.columns[73].visible = true;


                    gridSetting.columns[5].visible = false;
                    gridSetting.columns[6].visible = false;
                    gridSetting.columns[7].visible = false;
                    gridSetting.columns[8].visible = false;
                    gridSetting.columns[9].visible = false;
                    gridSetting.columns[10].visible = false;
                    gridSetting.columns[11].visible = false;
                    gridSetting.columns[12].visible = false;
                    gridSetting.columns[13].visible = false;
                    gridSetting.columns[14].visible = false;
                    gridSetting.columns[15].visible = false;
                    gridSetting.columns[16].visible = false;
                    gridSetting.columns[17].visible = false;
                    gridSetting.columns[18].visible = false;
                    gridSetting.columns[19].visible = false;
                    gridSetting.columns[20].visible = false;
                    gridSetting.columns[21].visible = false;
                    gridSetting.columns[22].visible = false;
                    gridSetting.columns[23].visible = false;
                    gridSetting.columns[31].visible = false;
                    gridSetting.columns[32].visible = false;
                   
                    gridSetting.columns[41].visible = false;
                    gridSetting.columns[42].visible = false;
                    gridSetting.columns[43].visible = false;
                    gridSetting.columns[44].visible = false;
                    gridSetting.columns[45].visible = false;
                    gridSetting.columns[50].visible = false;
					gridSetting.columns[51].visible = false;
					gridSetting.columns[52].visible = false;
					gridSetting.columns[53].visible = false;
                    gridSetting.columns[54].visible = false;
                    gridSetting.columns[55].visible = false;
                    gridSetting.columns[56].visible = false;
                    gridSetting.columns[57].visible = false;
                    gridSetting.columns[58].visible = false;
                    gridSetting.columns[59].visible = false;
                    gridSetting.columns[60].visible = false;
                    gridSetting.columns[61].visible = false;
                    gridSetting.columns[62].visible = false;
                    gridSetting.columns[63].visible = false;
                    gridSetting.columns[64].visible = false;
                    gridSetting.columns[65].visible = false;
                    gridSetting.columns[66].visible = false;
                    gridSetting.columns[67].visible = false;
                    gridSetting.columns[68].visible = false;
                    gridSetting.columns[69].visible = false;
                    gridSetting.columns[70].visible = false;
                    gridSetting.columns[71].visible = false;                    
                    

                    this.controls.dgNinteiTaskList().gridSetting = gridSetting;
                    this.controls.dgNinteiTaskList()._control.afterPropertiesSet();
                }
                public ChosaNyushu(): void {
                    var gridSetting = this.controls.dgNinteiTaskList().gridSetting;


                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;
                    gridSetting.columns[10].visible = true;
                    gridSetting.columns[15].visible = true;
                    gridSetting.columns[16].visible = true;
                    gridSetting.columns[22].visible = true;
                    gridSetting.columns[23].visible = true;
                    gridSetting.columns[41].visible = true;
                    gridSetting.columns[42].visible = true;
                    gridSetting.columns[43].visible = true;
                    gridSetting.columns[44].visible = true;
                    gridSetting.columns[45].visible = true;
                    gridSetting.columns[73].visible = true;
           

                    gridSetting.columns[5].visible = false;
                    gridSetting.columns[6].visible = false;
                    gridSetting.columns[7].visible = false;
                    gridSetting.columns[8].visible = false;
                    gridSetting.columns[9].visible = false;
                    gridSetting.columns[11].visible = false;
                    gridSetting.columns[12].visible = false;
                    gridSetting.columns[13].visible = false;
                    gridSetting.columns[14].visible = false;
                    gridSetting.columns[17].visible = false;
                    gridSetting.columns[18].visible = false;
                    gridSetting.columns[19].visible = false;
                    gridSetting.columns[20].visible = false;
                    gridSetting.columns[21].visible = false;
                    gridSetting.columns[24].visible = false;
                    gridSetting.columns[25].visible = false;
                    gridSetting.columns[26].visible = false;
                    gridSetting.columns[27].visible = false;
                    gridSetting.columns[28].visible = false;
                    gridSetting.columns[29].visible = false;
                    gridSetting.columns[30].visible = false;
                    gridSetting.columns[31].visible = false;
                    gridSetting.columns[32].visible = false;                   
                    gridSetting.columns[33].visible = false;
                    gridSetting.columns[34].visible = false;
                    gridSetting.columns[35].visible = false;                    
                    gridSetting.columns[36].visible = false;
                    gridSetting.columns[37].visible = false;
                    gridSetting.columns[38].visible = false;
                    gridSetting.columns[39].visible = false;
                    gridSetting.columns[40].visible = false;
                    gridSetting.columns[46].visible = false;
					gridSetting.columns[47].visible = false;
					gridSetting.columns[48].visible = false;
					gridSetting.columns[49].visible = false;
                    gridSetting.columns[50].visible = false;
                    gridSetting.columns[51].visible = false;
                    gridSetting.columns[52].visible = false;
                    gridSetting.columns[53].visible = false;
                    gridSetting.columns[54].visible = false;
                    gridSetting.columns[55].visible = false;
                    gridSetting.columns[56].visible = false;
                    gridSetting.columns[57].visible = false;
                    gridSetting.columns[58].visible = false;
                    gridSetting.columns[59].visible = false;
                    gridSetting.columns[60].visible = false;
                    gridSetting.columns[61].visible = false;
                    gridSetting.columns[62].visible = false;
                    gridSetting.columns[63].visible = false;
                    gridSetting.columns[64].visible = false;
                    gridSetting.columns[65].visible = false;
                    gridSetting.columns[66].visible = false;
                    gridSetting.columns[67].visible = false;
                    gridSetting.columns[68].visible = false;
                    gridSetting.columns[69].visible = false;
                    gridSetting.columns[70].visible = false;
                    gridSetting.columns[71].visible = false;
                    gridSetting.columns[72].visible = false;
                  
                   

                    this.controls.dgNinteiTaskList().gridSetting = gridSetting;
                    this.controls.dgNinteiTaskList()._control.afterPropertiesSet();
                }
                public IkenshoNyushu(): void {
                    var gridSetting = this.controls.dgNinteiTaskList().gridSetting;


                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;
                    gridSetting.columns[25].visible = true;
                    gridSetting.columns[31].visible = true;
                    gridSetting.columns[32].visible = true;                   
                    gridSetting.columns[33].visible = true;
                    gridSetting.columns[46].visible = true;
                    gridSetting.columns[47].visible = true;
                    gridSetting.columns[48].visible = true;
                    gridSetting.columns[49].visible = true;
                    gridSetting.columns[72].visible = true;
                    gridSetting.columns[73].visible = true;


                    gridSetting.columns[5].visible = false;
                    gridSetting.columns[6].visible = false;
                    gridSetting.columns[7].visible = false;
                    gridSetting.columns[8].visible = false;
                    gridSetting.columns[9].visible = false;
                    gridSetting.columns[10].visible = false;
                    gridSetting.columns[11].visible = false;
                    gridSetting.columns[12].visible = false;
                    gridSetting.columns[13].visible = false;
                    gridSetting.columns[14].visible = false;
                    gridSetting.columns[15].visible = false;
                    gridSetting.columns[16].visible = false;
                    gridSetting.columns[17].visible = false;
                    gridSetting.columns[18].visible = false;
                    gridSetting.columns[19].visible = false;
                    gridSetting.columns[20].visible = false;
                    gridSetting.columns[21].visible = false;
                    gridSetting.columns[22].visible = false;
                    gridSetting.columns[23].visible = false;
                    gridSetting.columns[24].visible = false;
                    gridSetting.columns[26].visible = false;
                    gridSetting.columns[27].visible = false;
                    gridSetting.columns[28].visible = false;
                    gridSetting.columns[29].visible = false;
                    gridSetting.columns[30].visible = false;
                    gridSetting.columns[34].visible = false;
                    gridSetting.columns[35].visible = false;                    
                    gridSetting.columns[36].visible = false;
					gridSetting.columns[37].visible = false;
					gridSetting.columns[38].visible = false;
					gridSetting.columns[39].visible = false;
                    gridSetting.columns[40].visible = false;
                    gridSetting.columns[41].visible = false;
                    gridSetting.columns[42].visible = false;
                    gridSetting.columns[43].visible = false;
                    gridSetting.columns[44].visible = false;
                    gridSetting.columns[45].visible = false; 
					gridSetting.columns[50].visible = false;
					gridSetting.columns[51].visible = false;
					gridSetting.columns[52].visible = false;					
                    gridSetting.columns[53].visible = false;
                    gridSetting.columns[54].visible = false;
                    gridSetting.columns[55].visible = false;
                    gridSetting.columns[56].visible = false;
                    gridSetting.columns[57].visible = false;
                    gridSetting.columns[58].visible = false;
                    gridSetting.columns[59].visible = false;
                    gridSetting.columns[60].visible = false;
                    gridSetting.columns[61].visible = false;
                    gridSetting.columns[62].visible = false;
                    gridSetting.columns[63].visible = false;
                    gridSetting.columns[64].visible = false;
                    gridSetting.columns[65].visible = false;
                    gridSetting.columns[66].visible = false;
                    gridSetting.columns[67].visible = false;
                    gridSetting.columns[68].visible = false;
                    gridSetting.columns[69].visible = false;
                    gridSetting.columns[70].visible = false;
                    gridSetting.columns[71].visible = false;                   
                

                    this.controls.dgNinteiTaskList().gridSetting = gridSetting;
                    this.controls.dgNinteiTaskList()._control.afterPropertiesSet();
                }
                public IchijiHantei(): void {
                    var gridSetting = this.controls.dgNinteiTaskList().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;
                    gridSetting.columns[10].visible = true;
                    gridSetting.columns[25].visible = true;
                    gridSetting.columns[50].visible = true;
                    gridSetting.columns[51].visible = true;
                    gridSetting.columns[52].visible = true;
                    gridSetting.columns[53].visible = true;
                    gridSetting.columns[54].visible = true;
                    gridSetting.columns[73].visible = true;


                    gridSetting.columns[5].visible = false;
                    gridSetting.columns[6].visible = false;
                    gridSetting.columns[7].visible = false;
                    gridSetting.columns[8].visible = false;
                    gridSetting.columns[9].visible = false;
                    gridSetting.columns[11].visible = false;
                    gridSetting.columns[12].visible = false;
                    gridSetting.columns[13].visible = false;
                    gridSetting.columns[14].visible = false;
                    gridSetting.columns[15].visible = false;
                    gridSetting.columns[16].visible = false;
                    gridSetting.columns[17].visible = false;
                    gridSetting.columns[18].visible = false;
                    gridSetting.columns[19].visible = false;
                    gridSetting.columns[20].visible = false;
                    gridSetting.columns[21].visible = false;
                    gridSetting.columns[22].visible = false;
                    gridSetting.columns[23].visible = false;
                    gridSetting.columns[24].visible = false;
                    gridSetting.columns[26].visible = false;
                    gridSetting.columns[27].visible = false;
                    gridSetting.columns[28].visible = false;
                    gridSetting.columns[29].visible = false;
                    gridSetting.columns[30].visible = false;
                    gridSetting.columns[31].visible = false;
                    gridSetting.columns[32].visible = false;
                    gridSetting.columns[33].visible = false;
                    gridSetting.columns[34].visible = false;
                    gridSetting.columns[35].visible = false;
                    gridSetting.columns[36].visible = false;
                    gridSetting.columns[37].visible = false;
                    gridSetting.columns[38].visible = false;
                    gridSetting.columns[39].visible = false;
                    gridSetting.columns[40].visible = false;
                    gridSetting.columns[41].visible = false;
                    gridSetting.columns[42].visible = false;
                    gridSetting.columns[43].visible = false;
                    gridSetting.columns[44].visible = false;
                    gridSetting.columns[45].visible = false;
                    gridSetting.columns[46].visible = false;
                    gridSetting.columns[47].visible = false;
                    gridSetting.columns[48].visible = false;
                    gridSetting.columns[49].visible = false;
					
					gridSetting.columns[55].visible = false;
					gridSetting.columns[56].visible = false;
					gridSetting.columns[57].visible = false;					
                    gridSetting.columns[58].visible = false;
                    gridSetting.columns[59].visible = false;
                    gridSetting.columns[60].visible = false;
                    gridSetting.columns[61].visible = false;
                    gridSetting.columns[62].visible = false;
                    gridSetting.columns[63].visible = false;
                    gridSetting.columns[64].visible = false;
                    gridSetting.columns[65].visible = false;
                    gridSetting.columns[66].visible = false;
                    gridSetting.columns[67].visible = false;
                    gridSetting.columns[68].visible = false;
                    gridSetting.columns[69].visible = false;
                    gridSetting.columns[70].visible = false;
                    gridSetting.columns[71].visible = false;
                    gridSetting.columns[72].visible = false;                 
                
              

                    this.controls.dgNinteiTaskList().gridSetting = gridSetting;
                    this.controls.dgNinteiTaskList()._control.afterPropertiesSet();
                }
                public Masking(): void {
                    var gridSetting = this.controls.dgNinteiTaskList().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;
                    gridSetting.columns[10].visible = true;
                    gridSetting.columns[55].visible = true;                 
                    gridSetting.columns[73].visible = true;


                    gridSetting.columns[5].visible = false;
                    gridSetting.columns[6].visible = false;
                    gridSetting.columns[7].visible = false;
                    gridSetting.columns[8].visible = false;
                    gridSetting.columns[9].visible = false;
                    gridSetting.columns[11].visible = false;
                    gridSetting.columns[12].visible = false;
                    gridSetting.columns[13].visible = false;
                    gridSetting.columns[14].visible = false;
                    gridSetting.columns[15].visible = false;
                    gridSetting.columns[16].visible = false;
                    gridSetting.columns[17].visible = false;
                    gridSetting.columns[18].visible = false;
                    gridSetting.columns[19].visible = false;
                    gridSetting.columns[20].visible = false;
                    gridSetting.columns[21].visible = false;
                    gridSetting.columns[22].visible = false;
                    gridSetting.columns[23].visible = false;
                    gridSetting.columns[24].visible = false;
                    gridSetting.columns[25].visible = false;
                    gridSetting.columns[26].visible = false;
                    gridSetting.columns[27].visible = false;
                    gridSetting.columns[28].visible = false;
                    gridSetting.columns[29].visible = false;
                    gridSetting.columns[30].visible = false;
                    gridSetting.columns[31].visible = false;
                    gridSetting.columns[32].visible = false;
                    gridSetting.columns[33].visible = false;
                    gridSetting.columns[34].visible = false;
                    gridSetting.columns[35].visible = false;
                    gridSetting.columns[36].visible = false;
                    gridSetting.columns[37].visible = false;
                    gridSetting.columns[38].visible = false;
                    gridSetting.columns[39].visible = false;
                    gridSetting.columns[40].visible = false;
                    gridSetting.columns[41].visible = false;
                    gridSetting.columns[42].visible = false;
                    gridSetting.columns[43].visible = false;
                    gridSetting.columns[44].visible = false;
                    gridSetting.columns[45].visible = false;
                    gridSetting.columns[46].visible = false;
                    gridSetting.columns[47].visible = false;
                    gridSetting.columns[48].visible = false;
                    gridSetting.columns[49].visible = false;
                    gridSetting.columns[50].visible = false;
                    gridSetting.columns[51].visible = false;
                    gridSetting.columns[52].visible = false;
                    gridSetting.columns[53].visible = false;
                    gridSetting.columns[54].visible = false;                 
                    gridSetting.columns[56].visible = false;
                    gridSetting.columns[57].visible = false;
					gridSetting.columns[58].visible = false;
					gridSetting.columns[59].visible = false;
					gridSetting.columns[60].visible = false;
					gridSetting.columns[61].visible = false;
					gridSetting.columns[62].visible = false;
					gridSetting.columns[63].visible = false;
					gridSetting.columns[64].visible = false;
					gridSetting.columns[65].visible = false;				
                    gridSetting.columns[66].visible = false;
                    gridSetting.columns[67].visible = false;
                    gridSetting.columns[68].visible = false;
                    gridSetting.columns[69].visible = false;
                    gridSetting.columns[70].visible = false;
                    gridSetting.columns[71].visible = false;
                    gridSetting.columns[72].visible = false;
                    

                    this.controls.dgNinteiTaskList().gridSetting = gridSetting;
                    this.controls.dgNinteiTaskList()._control.afterPropertiesSet();

                }
                public ShinsakaiToroku(): void {
                    var gridSetting = this.controls.dgNinteiTaskList().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;
                    gridSetting.columns[10].visible = true;
                    gridSetting.columns[25].visible = true;
					
					
					
                    gridSetting.columns[56].visible = true;
                    gridSetting.columns[57].visible = true;
                    gridSetting.columns[58].visible = true;
                    gridSetting.columns[59].visible = true;
                    gridSetting.columns[60].visible = true;
                    gridSetting.columns[61].visible = true;
                    gridSetting.columns[62].visible = true;
                    gridSetting.columns[73].visible = true;

                    gridSetting.columns[5].visible = false;
                    gridSetting.columns[6].visible = false;
                    gridSetting.columns[7].visible = false;
                    gridSetting.columns[8].visible = false;
                    gridSetting.columns[9].visible = false;
                    gridSetting.columns[11].visible = false;
                    gridSetting.columns[12].visible = false;
                    gridSetting.columns[13].visible = false;
                    gridSetting.columns[14].visible = false;
                    gridSetting.columns[15].visible = false;
                    gridSetting.columns[16].visible = false;
                    gridSetting.columns[17].visible = false;
                    gridSetting.columns[18].visible = false;
                    gridSetting.columns[19].visible = false;
                    gridSetting.columns[20].visible = false;
                    gridSetting.columns[21].visible = false;
                    gridSetting.columns[22].visible = false;
                    gridSetting.columns[23].visible = false;
                    gridSetting.columns[24].visible = false;
                    gridSetting.columns[26].visible = false;
                    gridSetting.columns[27].visible = false;
                    gridSetting.columns[28].visible = false;
                    gridSetting.columns[29].visible = false;
                    gridSetting.columns[30].visible = false;
                    gridSetting.columns[31].visible = false;
                    gridSetting.columns[32].visible = false;
                    gridSetting.columns[33].visible = false;
                    gridSetting.columns[34].visible = false;
                    gridSetting.columns[35].visible = false;
                    gridSetting.columns[36].visible = false;
                    gridSetting.columns[37].visible = false;
                    gridSetting.columns[38].visible = false;
                    gridSetting.columns[39].visible = false;
                    gridSetting.columns[40].visible = false;
                    gridSetting.columns[41].visible = false;
                    gridSetting.columns[42].visible = false;
                    gridSetting.columns[43].visible = false;
                    gridSetting.columns[44].visible = false;
                    gridSetting.columns[45].visible = false;
                    gridSetting.columns[46].visible = false;
                    gridSetting.columns[47].visible = false;
                    gridSetting.columns[48].visible = false;
                    gridSetting.columns[49].visible = false;
                    gridSetting.columns[50].visible = false;
                    gridSetting.columns[51].visible = false;
                    gridSetting.columns[52].visible = false;
                    gridSetting.columns[53].visible = false;
                    gridSetting.columns[54].visible = false;
                    gridSetting.columns[55].visible = false;
                   	gridSetting.columns[63].visible = false;
					gridSetting.columns[64].visible = false;
					gridSetting.columns[65].visible = false;	
                    gridSetting.columns[66].visible = false;
                    gridSetting.columns[67].visible = false;
                    gridSetting.columns[68].visible = false;
                    gridSetting.columns[69].visible = false;
                    gridSetting.columns[70].visible = false;
                    gridSetting.columns[71].visible = false;
                    gridSetting.columns[72].visible = false;                  
                    

                    this.controls.dgNinteiTaskList().gridSetting = gridSetting;
                    this.controls.dgNinteiTaskList()._control.afterPropertiesSet();

                }
                public NijiHantei(): void {
                    var gridSetting = this.controls.dgNinteiTaskList().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;
                    gridSetting.columns[5].visible = true;                    
                    gridSetting.columns[63].visible = true;
                    gridSetting.columns[64].visible = true;
                    gridSetting.columns[65].visible = true;
					gridSetting.columns[66].visible = true;
                    gridSetting.columns[67].visible = true;
                    gridSetting.columns[68].visible = true;
                    gridSetting.columns[69].visible = true;
                    gridSetting.columns[73].visible = true;
 

                    gridSetting.columns[6].visible = false;
                    gridSetting.columns[7].visible = false;
                    gridSetting.columns[8].visible = false;
                    gridSetting.columns[9].visible = false;
                    gridSetting.columns[10].visible = false;
                    gridSetting.columns[11].visible = false;
                    gridSetting.columns[12].visible = false;
                    gridSetting.columns[13].visible = false;
                    gridSetting.columns[14].visible = false;
                    gridSetting.columns[15].visible = false;
                    gridSetting.columns[16].visible = false;
                    gridSetting.columns[17].visible = false;
                    gridSetting.columns[18].visible = false;
                    gridSetting.columns[19].visible = false;
                    gridSetting.columns[20].visible = false;
                    gridSetting.columns[21].visible = false;
                    gridSetting.columns[22].visible = false;
                    gridSetting.columns[23].visible = false;
                    gridSetting.columns[24].visible = false;
                    gridSetting.columns[25].visible = false;
                    gridSetting.columns[26].visible = false;
                    gridSetting.columns[27].visible = false;
                    gridSetting.columns[28].visible = false;
                    gridSetting.columns[29].visible = false;
                    gridSetting.columns[30].visible = false;
                    gridSetting.columns[31].visible = false;
                    gridSetting.columns[32].visible = false;
                    gridSetting.columns[33].visible = false;
                    gridSetting.columns[34].visible = false;
                    gridSetting.columns[35].visible = false;
                    gridSetting.columns[36].visible = false;
                    gridSetting.columns[37].visible = false;
                    gridSetting.columns[38].visible = false;
                    gridSetting.columns[39].visible = false;
                    gridSetting.columns[40].visible = false;
                    gridSetting.columns[41].visible = false;
                    gridSetting.columns[42].visible = false;
                    gridSetting.columns[43].visible = false;
                    gridSetting.columns[44].visible = false;
                    gridSetting.columns[45].visible = false;
                    gridSetting.columns[46].visible = false;
                    gridSetting.columns[47].visible = false;
                    gridSetting.columns[48].visible = false;
                    gridSetting.columns[49].visible = false;
                    gridSetting.columns[50].visible = false;
                    gridSetting.columns[51].visible = false;
                    gridSetting.columns[52].visible = false;
                    gridSetting.columns[53].visible = false;
                    gridSetting.columns[54].visible = false;
                    gridSetting.columns[55].visible = false;
                    gridSetting.columns[56].visible = false;
                    gridSetting.columns[57].visible = false;
                    gridSetting.columns[58].visible = false;
                    gridSetting.columns[59].visible = false;
                    gridSetting.columns[60].visible = false;
                    gridSetting.columns[61].visible = false;
                    gridSetting.columns[62].visible = false;
                    gridSetting.columns[70].visible = false;
                    gridSetting.columns[71].visible = false;
                    gridSetting.columns[72].visible = false;
                    
                    this.controls.dgNinteiTaskList().gridSetting = gridSetting;
                    this.controls.dgNinteiTaskList()._control.afterPropertiesSet();
                }

                public GetsureiShori(): void {
                    var gridSetting = this.controls.dgNinteiTaskList().gridSetting;

                    gridSetting.columns[0].visible = true;
                    gridSetting.columns[1].visible = true;
                    gridSetting.columns[2].visible = true;
                    gridSetting.columns[3].visible = true;
                    gridSetting.columns[4].visible = true;
                    gridSetting.columns[5].visible = true;
                    gridSetting.columns[70].visible = true;
                    gridSetting.columns[71].visible = true;
                    gridSetting.columns[73].visible = true;
 

                    gridSetting.columns[6].visible = false;
                    gridSetting.columns[7].visible = false;
                    gridSetting.columns[8].visible = false;
                    gridSetting.columns[9].visible = false;
                    gridSetting.columns[10].visible = false;
                    gridSetting.columns[11].visible = false;
                    gridSetting.columns[12].visible = false;
                    gridSetting.columns[13].visible = false;
                    gridSetting.columns[14].visible = false;
                    gridSetting.columns[15].visible = false;
                    gridSetting.columns[16].visible = false;
                    gridSetting.columns[17].visible = false;
                    gridSetting.columns[18].visible = false;
                    gridSetting.columns[19].visible = false;
                    gridSetting.columns[20].visible = false;
                    gridSetting.columns[21].visible = false;
                    gridSetting.columns[22].visible = false;
                    gridSetting.columns[23].visible = false;
                    gridSetting.columns[24].visible = false;
                    gridSetting.columns[25].visible = false;
                    gridSetting.columns[26].visible = false;
                    gridSetting.columns[27].visible = false;
                    gridSetting.columns[28].visible = false;
                    gridSetting.columns[29].visible = false;
                    gridSetting.columns[30].visible = false;
                    gridSetting.columns[31].visible = false;
                    gridSetting.columns[32].visible = false;
                    gridSetting.columns[33].visible = false;
                    gridSetting.columns[34].visible = false;
                    gridSetting.columns[35].visible = false;
                    gridSetting.columns[36].visible = false;
                    gridSetting.columns[37].visible = false;
                    gridSetting.columns[38].visible = false;
                    gridSetting.columns[39].visible = false;
                    gridSetting.columns[40].visible = false;
                    gridSetting.columns[41].visible = false;
                    gridSetting.columns[42].visible = false;
                    gridSetting.columns[43].visible = false;
                    gridSetting.columns[44].visible = false;
                    gridSetting.columns[45].visible = false;
                    gridSetting.columns[46].visible = false;
                    gridSetting.columns[47].visible = false;
                    gridSetting.columns[48].visible = false;
                    gridSetting.columns[49].visible = false;
                    gridSetting.columns[50].visible = false;
                    gridSetting.columns[51].visible = false;
                    gridSetting.columns[52].visible = false;
                    gridSetting.columns[53].visible = false;
                    gridSetting.columns[54].visible = false;
                    gridSetting.columns[55].visible = false;
                    gridSetting.columns[56].visible = false;
                    gridSetting.columns[57].visible = false;
                    gridSetting.columns[58].visible = false;
                    gridSetting.columns[59].visible = false;
                    gridSetting.columns[60].visible = false;
                    gridSetting.columns[61].visible = false;
                    gridSetting.columns[62].visible = false;
                    gridSetting.columns[63].visible = false;
                    gridSetting.columns[64].visible = false;
                    gridSetting.columns[65].visible = false;
                    gridSetting.columns[66].visible = false;
                    gridSetting.columns[67].visible = false;
                    gridSetting.columns[68].visible = false;
                    gridSetting.columns[69].visible = false;                  
                    gridSetting.columns[72].visible = false;              
                   
                    this.controls.dgNinteiTaskList().gridSetting = gridSetting;
                    this.controls.dgNinteiTaskList()._control.afterPropertiesSet();
                }
            }

         
        }
                }
            }
