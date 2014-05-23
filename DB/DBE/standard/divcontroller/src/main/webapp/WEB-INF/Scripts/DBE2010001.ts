/// <reference path="jquery.d.ts" />
/// <reference path="UzViewControls.d.ts" />

module DBE {
    export class DBE2010001 {
        private static dgNinteichosaIraiList: Uz._DataGrid = <Uz._DataGrid>Uz.GyomuJSHelper.getJSControl('dgNinteichosaIraiList');
        private static btnToEntryChosaIrai: Uz._Button = <Uz._Button>Uz.GyomuJSHelper.getJSControl('btnToEntryChosaIrai');
        private static btnToComplete: Uz._Button = <Uz._Button>Uz.GyomuJSHelper.getJSControl('btnToComplete');
        public static setCoding() {
            DBE2010001.init();
            DBE2010001.deployEvents();
        }

        private static init() {
            
            alert("ver.2.o");
            DBE2010001.changeStateOfBtnToComplete();
        }

        private static deployEvents() {
            Uz.GyomuJSHelper.registOriginalEvent("changeStateOfBtnToComplete", (control: Uz._ViewControl) => {
                DBE2010001.changeStateOfBtnToComplete();
            });
        }

        private static countOfSelectedItems(): number {
            var count: number = 0;
            var selectedItems : any[] = DBE2010001.dgNinteichosaIraiList.dataSource;
            for (var i: number = 0; i < selectedItems.length; i ++){ 
                if (selectedItems[i].selected === true) {
                    count++;
                }
            }
            return count;
        }

        private static changeStateOfBtnToComplete() {
            DBE2010001.btnToComplete.disabled = DBE2010001.judgeStateOfBtnToComplete();
        }

        private static judgeStateOfBtnToComplete() : boolean {
            var selectedItems: any[] = DBE2010001.dgNinteichosaIraiList.dataSource;
            if (DBE2010001.countOfSelectedItems() === 0) {
                return true;
            }
            for (var i: number = 0; i < selectedItems.length; i++) {
                if ((selectedItems[i].依頼登録済 === false) || (selectedItems[i].依頼書発行済 === false)) {
                    return true;
                }
            }
            return false;
        }
    }
}

DBE.DBE2010001.setCoding();