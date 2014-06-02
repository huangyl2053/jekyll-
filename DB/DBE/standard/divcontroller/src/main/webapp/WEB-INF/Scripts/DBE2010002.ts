/// <reference path="jquery.d.ts" />
/// <reference path="UzViewControls.d.ts" />

module DBE {
    export class DBE2010002 {
        // ChosairaiBindByHandMain
        private static comNinteichosaIraiListGod: Uz._DataGrid
        = <Uz._DataGrid>Uz.GyomuJSHelper.getJSControl('comNinteichosaIraiListGod_dgNinteichosaIraiListForByHand');
        private static comWaritukezumiList: Uz._DataGrid
        = <Uz._DataGrid>Uz.GyomuJSHelper.getJSControl('comWaritukezumiList_dgNinteichosaIraiListForByHand');
        private static comMiwaritsukeList: Uz._DataGrid
        = <Uz._DataGrid>Uz.GyomuJSHelper.getJSControl('comMiwarituskeList_dgNinteichosaIraiListForByHand');
        // RequestContents
        private static txtChosaIraiDate: Uz._TextBoxFlexibleDate = <Uz._TextBoxFlexibleDate>Uz.GyomuJSHelper.getJSControl('txtChosaIraiDate');
        private static txtChosaKigenDate: Uz._TextBoxFlexibleDate = <Uz._TextBoxFlexibleDate>Uz.GyomuJSHelper.getJSControl('txtChosaKigenDate');
        private static ddlIraiKubun: Uz._DropDownList = <Uz._DropDownList>Uz.GyomuJSHelper.getJSControl('ddlIraiKubun');
        // ChosaItakusakiAndChosainList
        private static dgChosaItakusakiList: Uz._DataGrid = <Uz._DataGrid>Uz.GyomuJSHelper.getJSControl('dgChosaItakusakiList');
        private static comChosainList: Uz._DataGrid = <Uz._DataGrid>Uz.GyomuJSHelper.getJSControl('comChosainList_dgShozokuChosainList');
        private static comChosainListAll: Uz._DataGrid = <Uz._DataGrid>Uz.GyomuJSHelper.getJSControl('comChosainListAll_dgShozokuChosainList');

        /**
         * onLoadよりも早くよばれます。
         * deployEvents()内に、layoutへ設定したいイベントを羅列してあります。
         */
        public static onLoadThisFile() {
            DBE2010002.deployEvents();
        }

        /**
         * イベントを登録します。
         */
        private static deployEvents() {
            Uz.GyomuJSHelper.registOriginalEvent("onClick_btnToBind", (control: Uz._ViewControl) => {
                DBE2010002._onClick_btnToBind();
                DBE2010002.displayChosain();
                DBE2010002.divideWaritsukeOrMiwaritsuke();
            });
            Uz.GyomuJSHelper.registOriginalEvent("onClick_btnToFree", (control: Uz._ViewControl) => {
                DBE2010002._onClick_btnToFree();
                DBE2010002.displayChosain();
                DBE2010002.divideWaritsukeOrMiwaritsuke();
            });
            Uz.GyomuJSHelper.registOriginalEvent("onSelect_dgChosaItakusakiList", (control: Uz._ViewControl) => {
                DBE2010002.unselect_Chosain_all();
                DBE2010002.displayChosain();
                DBE2010002.divideWaritsukeOrMiwaritsuke();
            });
            Uz.GyomuJSHelper.registOriginalEvent("onLoad_NinteichosaIraiByHand", (control: Uz._ViewControl) => {
                DBE2010002.divideWaritsukeOrMiwaritsuke();
                DBE2010002.countWaritukeNum();
            });
        }

        /**
         * 割付数をカウントします。
         */
        private static countWaritukeNum(){
            DBE2010002._countWaritukeNum_ChosaItakusaki();
            DBE2010002._countWaritukeNum_Chosain();
        }

        private static _countWaritukeNum_ChosaItakusaki() {
            var dataSource: IChosaItakusaki[] = DBE2010002.dgChosaItakusakiList.dataSource;
            for (var i = 0; i < dataSource.length; i++) {
                dataSource[i].waritsukeNum = DBE2010002._countChosaItakusaki(dataSource[i].chosaItakusakiNo);
            }
            DBE2010002.dgChosaItakusakiList.dataSource = dataSource;
        }

        private static _countChosaItakusaki(chosaItakusakiNo : string): number {
            var count: number = 0;
            var targets: IChosaIraiTarget[] = DBE2010002.comNinteichosaIraiListGod.dataSource;
            for (var i = 0; i < targets.length; i++) {
                if (targets[i].chosaItakusakiNo === chosaItakusakiNo) {
                    count++;
                }
            }
            return count;
        }

        private static _countWaritukeNum_Chosain() {
            var dataSource: IChosain[] = DBE2010002.comChosainListAll.dataSource;
            for (var i = 0; i < dataSource.length; i++) {
                dataSource[i].waritsukeNum = DBE2010002._countChosain(dataSource[i].chosainNo);
            }
            DBE2010002.comChosainListAll.dataSource = dataSource;
        }

        private static _countChosain(chosainNo: string): number {
            var count: number = 0;
            var targets: IChosaIraiTarget[] = DBE2010002.comNinteichosaIraiListGod.dataSource;
            for (var i = 0; i < targets.length; i++) {
                if (targets[i].chosainNo === chosainNo) {
                    count++;
                }
            }
            return count;
        }

        /**
         * 非表示の全対象者を持ったDataGridのRowそれぞれについて、
         * 割付済みか未割付かを判定して、それぞれ専用のDataGridへ振り分けます。
         * また、調査依頼先を選択している調査依頼先に対応した割付済み者のみ表示します。
         */
        private static divideWaritsukeOrMiwaritsuke() {
            var chosaIraiTargets: IChosaIraiTarget[] = DBE2010002.comNinteichosaIraiListGod.dataSource;

            var waritsuke: IChosaIraiTarget[] = [];
            var miwaritsuke: IChosaIraiTarget[] = [];

            function isMiwariate(item: IChosaIraiTarget): boolean {
                function isEmpty(str: string) {return str === "" };
                return isEmpty(item.chosaIraiDate.value) || isEmpty(item.chosaIraiKubun) || isEmpty(item.chosaKigenDate.value);
            }

            for (var i = 0; i < chosaIraiTargets.length; i++) {
                if (isMiwariate(chosaIraiTargets[i])) {
                    miwaritsuke.push(chosaIraiTargets[i]);
                } else {
                    var chosaItakusaki: IChosaItakusaki = DBE2010002.selected_ChosaItakuskai();
                    if (chosaItakusaki === null) {
                        continue;
                    }
                    if (chosaIraiTargets[i].chosaItakusakiNo === chosaItakusaki.chosaItakusakiNo) {
                        waritsuke.push(chosaIraiTargets[i]);
                    }
                }
            }

            DBE2010002.comMiwaritsukeList.dataSource = miwaritsuke;
            DBE2010002.comWaritukezumiList.dataSource = waritsuke;
        }

        /**
         * 調査委託先に所属する調査員の情報をビューへ反映します。
         */
        private static displayChosain() {
            var selectedItem: IChosaItakusaki = DBE2010002.selected_ChosaItakuskai();
            if (selectedItem != null) {
                DBE2010002.comChosainList.dataSource = DBE2010002.getChosainList(selectedItem.chosaItakusakiNo);
            }
        }

        /**
         * 割付完了化処理です。
         */
        private static _onClick_btnToBind() {
            var target: IChosaIraiTarget = DBE2010002.selected_Miwaritsukesha();
            if (target != null) {
                DBE2010002.setChosaIraiTo(target);
            }
        }

        /**
         * 調査依頼を設定します。 
         */
        private static setChosaIraiTo(target: IChosaIraiTarget) {
            target.chosaIraiDate.value = DBE2010002.txtChosaIraiDate.value;
            target.chosaKigenDate.value = DBE2010002.txtChosaKigenDate.value;
            target.chosaIraiKubun = DBE2010002.chosaIraiKubun();

            var chosaItakusaki: IChosaItakusaki = DBE2010002.selected_ChosaItakuskai();
            if (chosaItakusaki === null) {
                return;
            }
            target.chosaItakusakiName = chosaItakusaki.chosaItakusakiName;
            target.chosaItakusakiNo = chosaItakusaki.chosaItakusakiNo;
            chosaItakusaki.waritsukeNum++;
            DBE2010002.replaceChosaItakusaki(chosaItakusaki);

            var chosain: IChosain = DBE2010002.selected_Chosain_onDisp()
            if (chosain != null) {
                target.chosainName = chosain.chosainName;
                target.chosainNo = chosain.chosainNo;
                chosain.waritsukeNum++;
                DBE2010002.replaceChosain_all(chosain);
            }

            DBE2010002.replaceChosaIraiTarget(target);
        }

        /**
         * 調査依頼区分をddlIraiKubunから取得します。
         */
        private static chosaIraiKubun(): string{
            var key: string = DBE2010002.ddlIraiKubun.selectedItem;
            var dataSource = DBE2010002.ddlIraiKubun.dataSource;
            for (var i = 0; i < dataSource.length; i++) {
                if (dataSource[i].key === key) {
                    return dataSource[i].value;
                }
            }
            return "1：初回"; // 実際はここへ来たらエラーです。
        }

        /**
         * 未割付化処理です。
         */
        private static _onClick_btnToFree() {
            var target: IChosaIraiTarget = DBE2010002.selected_Waritukezumisha();
                
            if (target != null) {
                if (target.chosaKanryoFlag) {
                    return;
                }
                DBE2010002.clearChosaIrai(target);
            }
        }

        /**
         * 調査依頼の設定内容をクリアします。
         */
        private static clearChosaIrai(target : IChosaIraiTarget) {
            target.chosaIraiDate.value = "";
            target.chosaKigenDate.value = "";
            target.chosaIraiKubun = "";

            var chosaItakusaki: IChosaItakusaki = DBE2010002.getChosaItakusaki(target.chosaItakusakiNo);
            if (chosaItakusaki != null) {
                if (0 < chosaItakusaki.waritsukeNum) {
                    chosaItakusaki.waritsukeNum--;
                } else {
                    chosaItakusaki.waritsukeNum = 0;
                }
                DBE2010002.replaceChosaItakusaki(chosaItakusaki);
            }
            target.chosaItakusakiNo = "";
            target.chosaItakusakiName = "";

            var chosain: IChosain = DBE2010002.getChosain(target.chosainNo);
            if (chosain != null) {
                if (0 < chosain.waritsukeNum) {
                    chosain.waritsukeNum--;
                } else {
                    chosain.waritsukeNum = 0;
                }
                DBE2010002.replaceChosain_all(chosain);
            }
            target.chosainNo = "";
            target.chosainName = "";
            DBE2010002.replaceChosaIraiTarget(target);
         }


        /**
         * 選択中の調査依頼対象者を取得します。
         */
        private static selected_ChosaItakuskai(): IChosaItakusaki {
            return <IChosaItakusaki>DBE2010002._extractSelectedItem(DBE2010002.dgChosaItakusakiList.dataSource);
        }

        /**
         * 選択中の調査員を取得します。
         */
        private static selected_Chosain_onDisp(): IChosain {
            return <IChosain>DBE2010002._extractSelectedItem(DBE2010002.comChosainList.dataSource);
        }

        /**
         *
         */
        private static selected_Chosain_all(): IChosain {
            return <IChosain>DBE2010002._extractSelectedItem(DBE2010002.comChosainListAll.dataSource);
        }

        /**
         * 選択中の割付済み者を取得します。
         */
        private static selected_Waritukezumisha(): IChosaIraiTarget {
            return <IChosaIraiTarget> DBE2010002._extractSelectedItem(DBE2010002.comWaritukezumiList.dataSource);
        }

        /**
         * 選択中の未割付者を取得します。
         */
        private static selected_Miwaritsukesha(): IChosaIraiTarget {
            return <IChosaIraiTarget>DBE2010002._extractSelectedItem(DBE2010002.comMiwaritsukeList.dataSource);
        }

        /**
         * 選択されている対象者を取得します。
         * なければ、nullを返します。
         */
        private static _extractSelectedItem(items: ISelectable[]): ISelectable {
            for (var i = 0; i < items.length; i++) {
                if (items[i].selected) {
                    return items[i];
                }
            }
            return null;
        }

        /**
         * 渡した情報で、調査依頼対象者を置き換えます。
         */
        private static replaceChosaIraiTarget(target: IChosaIraiTarget) {
            var dataSource: IChosaIraiTarget[] = DBE2010002.comNinteichosaIraiListGod.dataSource;
            for (var i = 0; i < dataSource.length; i++) {
                if (dataSource[i].hihokenshaNo === target.hihokenshaNo) {
                    dataSource[i] = target;
                }
            }
            DBE2010002.comNinteichosaIraiListGod.dataSource = dataSource;
        }

        /**
         * 渡した情報で、調査員を置き換えます。
         */
        private static replaceChosain_all(chosain: IChosain) {
            var dataSource: IChosain[] = DBE2010002.comChosainListAll.dataSource;
            for (var i = 0; i < dataSource.length; i++) {
                if (dataSource[i].chosainNo === chosain.chosainNo) {
                    dataSource[i] = chosain;
                }
            }
            DBE2010002.comChosainListAll.dataSource = dataSource;
        }

        /**
         * 渡した情報で、調査委託先を置き換えます。
         */
        private static replaceChosaItakusaki(chosaItakusaki: IChosaItakusaki) {
            var dataSource: IChosaItakusaki[] = DBE2010002.dgChosaItakusakiList.dataSource;
            for (var i = 0; i < dataSource.length; i++) {
                if (dataSource[i].chosaItakusakiNo === chosaItakusaki.chosaItakusakiNo) {
                    dataSource[i] = chosaItakusaki;
                }
            }
            DBE2010002.dgChosaItakusakiList.dataSource = dataSource;
        }

        /**
         * 被保険者番号から、調査依頼対象者を取得します。
         */
        private static getChosaIraiTarget(hihokenshaNo: string): IChosaIraiTarget{
            var dataSource: IChosaIraiTarget[] = DBE2010002.comNinteichosaIraiListGod.dataSource;
            for (var i = 0; i < dataSource.length; i++) {
                if (dataSource[i].hihokenshaNo === hihokenshaNo) {
                    return dataSource[i];
                }
            }
            return null;
        }

        /**
         * 調査員番号から、調査員を取得します。
         */
        private static getChosain(chosainNo: string): IChosain {
            var dataSource: IChosain[] = DBE2010002.comChosainListAll.dataSource;
            for (var i = 0; i < dataSource.length; i++) {
                if (dataSource[i].chosainNo === chosainNo) {
                    return dataSource[i];
                }
            }
            return null;
        }

        /**
         * 調査委託先番号から、調査委託先を取得します。
         */
        private static getChosaItakusaki(chosaItakusakiNo : string) : IChosaItakusaki {
            var dataSource: IChosaItakusaki[] = DBE2010002.dgChosaItakusakiList.dataSource;
            for (var i = 0; i < dataSource.length; i++) {
                if (dataSource[i].chosaItakusakiNo === chosaItakusakiNo) {
                    return dataSource[i];
                }
            }
            return null;
        }

        /**
         * 選択されている調査委託先に属する調査員を抽出します。
         */
        private static getChosainList(chousaItakusakiNo: string): IChosain[] {
            var chosainList: IChosain[] = [];
            var dataSource: IChosain[] = DBE2010002.comChosainListAll.dataSource;
            for (var i: number = 0; i < dataSource.length; i++) {
                if (dataSource[i].chousaItakusakiNo === chousaItakusakiNo) {
                    chosainList.push(dataSource[i]);
                }
            }
            return chosainList;
        }

        /**
         * 調査員の選択を解除します。
         * 現状のコードでは希望の動作をしません。
         * 同じように、対象者側も選択を解除する必要性がありますが、そちらにも手をつけていません。
         */
        private static unselect_Chosain_all() {
//            var chosain: IChosain = DBE2010002.selected_Chosain_all();
//            if (chosain != null) {
//                chosain.selected = false;
//                DBE2010002.replaceChosain_all(chosain);
//                alert(chosain.chosainName + "\n" + "selected : " + chosain.selected);
//            }
        }

    }

    /**
     * 調査依頼対象者です。
     *
     * メモ:
     * DataGrid内の項目を扱うために設けています。
     *
     * UZ._DataGrid.dataSourceは通常、any[]型で取得できるようですが、
     * それだと書きづらいので、このようにインタフェースを設けるといいでしょう。
     * dataSourceを受け取る際には、この型にキャストします。
     *
     * インタフェースを作らなくても、コードを書くことは可能です。
     * UZ._DataGrid.dataSource[0].xxx で、1行目のDataNameが xxx の項目が取得できます。
     * ( 配列のindex + 1 が実際の行になるのは、プログラマ的感覚で明確だと思います。)
     *
     * ですが、DataGridのDataNameを修正したときの影響範囲がわかりません。
     * インタフェースを介して利用するようにしておけば、インタフェースを修正することで、影響範囲が明確になります。
     * (any.xxx はどんな場合でも許可されるが、interface.xxx はインタフェース内に xxx がないといけないため。)
     * また、インタフェースを作っておけば、コード補完の機能も利用できるため、タイポを減らすことができます。
     */
    interface IChosaIraiTarget extends ISelectable{
        chosaIraiKubun;
        chosaIraiDate;
        chosaKigenDate;
        hihokenshaNo: string;
        chosaKanryoFlag: boolean;
        chosaItakusakiNo: string;
        chosaItakusakiName: string;
        chosainNo: string;
        chosainName: string;

    }

    /**
     * 認定調査委託先です。
     */
    interface IChosaItakusaki extends ISelectable {
        chosaItakusakiNo: string;
        chosaItakusakiName: string;
        waritsukeTeiin: number;
        waritsukeNum: number;
        waritsukeChiku: string;
    }

    /**
     * 認定調査員です。
     */
    interface IChosain extends ISelectable {
        chosainNo: string;
        chosainName: string;
        waritsukeNum: number;
        chiku: string;
        chousaItakusakiNo: string;
    }

    /**
     * 選択可能なオブジェクトであることをあらわします。
     * DataGridの選択(selected)と対応します。
     */
    interface ISelectable {
        selected: boolean;
    }
}

DBE.DBE2010002.onLoadThisFile();