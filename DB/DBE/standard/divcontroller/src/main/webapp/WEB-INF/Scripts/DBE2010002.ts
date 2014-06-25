/// <reference path="../../../../NetBeansProjects/DB/DB/DBE/standard/d.ts/jquery.d.ts" />
/// <reference path="../../../../NetBeansProjects/DB/DB/DBE/standard/d.ts/UzViewControls.d.ts" />

module DBE {
    export class DBE2010002 {
        // ChosairaiBindByHandMain
        private static comNinteichosaIraiListGod: Uz._DataGrid
        = <Uz._DataGrid>Uz.GyomuJSHelper.getCompositeChildControl('comNinteichosaIraiListGod', 'NinteichosaIraiListForByHandCom', 'dgNinteichosaIraiListForByHand');
        private static comWaritukezumiList: Uz._DataGrid
        = <Uz._DataGrid>Uz.GyomuJSHelper.getCompositeChildControl('comWaritukezumiList', 'NinteichosaIraiListForByHandCom', 'dgNinteichosaIraiListForByHand');
        private static comMiwaritsukeList: Uz._DataGrid
        = <Uz._DataGrid>Uz.GyomuJSHelper.getCompositeChildControl('comMiwarituskeList', 'NinteichosaIraiListForByHandCom', 'dgNinteichosaIraiListForByHand');
        // RequestContents
        private static txtChosaIraiDate: Uz._TextBoxFlexibleDate = <Uz._TextBoxFlexibleDate>Uz.GyomuJSHelper.getJSControl('txtChosaIraiDate');
        private static txtChosaKigenDate: Uz._TextBoxFlexibleDate = <Uz._TextBoxFlexibleDate>Uz.GyomuJSHelper.getJSControl('txtChosaKigenDate');
        private static ddlIraiKubun: Uz._DropDownList = <Uz._DropDownList>Uz.GyomuJSHelper.getJSControl('ddlIraiKubun');
        // ChosaItakusakiAndChosainList
        private static dgChosaItakusakiList: Uz._DataGrid = <Uz._DataGrid>Uz.GyomuJSHelper.getJSControl('dgChosaItakusakiList');
        private static comChosainList: Uz._DataGrid = <Uz._DataGrid>Uz.GyomuJSHelper.getCompositeChildControl('comChosainList', 'ShozokuChosainListCom', 'dgShozokuChosainList');
        private static comChosainListAll: Uz._DataGrid = <Uz._DataGrid>Uz.GyomuJSHelper.getCompositeChildControl('comChosainListAll', 'ShozokuChosainListCom', 'dgShozokuChosainList');
        private static eventName_for_btnToBindChosain: string = "bind_SelectedChosain";

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
            // ロード時の処理
            Uz.GyomuJSHelper.registOriginalEvent("onLoad_NinteichosaIraiByHand", (control: Uz._ViewControl) => {
                DBE2010002._onLoad_NinteichosaIraiByHand();
            });
            // 「割付化」ボタン押下時処理
            Uz.GyomuJSHelper.registOriginalEvent("onClick_btnToBind", (control: Uz._ViewControl) => {
                DBE2010002.onClick_btnToBind();
                DBE2010002.onAfterEvent();
            });
            // 「未割付化」ボタン押下時処理
            Uz.GyomuJSHelper.registOriginalEvent("onClick_btnToFree", (control: Uz._ViewControl) => {
                DBE2010002.onClick_btnToFree();
                DBE2010002.onAfterEvent();
            });
            // 調査委託先一覧選択時処理
            Uz.GyomuJSHelper.registOriginalEvent("onSelect_dgChosaItakusakiList", (control: Uz._ViewControl) => {
                DBE2010002.unselect_Chosain_all();
                DBE2010002.onAfterEvent();
            });
            // 調査員リスト内の割付ボタン押下時処理
            Uz.GyomuJSHelper.registOriginalEvent(DBE2010002.eventName_for_btnToBindChosain, (control: Uz._ViewControl) => {
                DBE2010002.bindSelectedChosainToTarget();
                DBE2010002.onAfterEvent();
            });
        }

        /**
         * onLoad後の処理です。
         */
        private static _onLoad_NinteichosaIraiByHand() {
            DBE2010002.divideWaritsukeOrMiwaritsuke();
            DBE2010002.setUpWaritukeNum();
            //DBE2010002.deployOnClickEventToButtonOfChosain();
        }

        /**
         * 調査員のbtnToBindChosainのonClickにイベントを追加します。
         * 現状、この処理はうまくいきません。
         */
        private static deployOnClickEventToButtonOfChosain() {
            var dataSource: IChosain[] = DBE2010002.comChosainListAll.dataSource;
            for (var i = 0; i < dataSource.length; i++) {
                dataSource[i].btnToBindChosain.onClick = DBE2010002.eventName_for_btnToBindChosain;
            }
            DBE2010002.comChosainListAll.dataSource = dataSource;
        }

        /**
         * 割付数をカウントします。
         */
        private static setUpWaritukeNum() {
            DBE2010002._setUpWaritukeNum_ChosaItakusaki();
            DBE2010002._setUpWaritukeNum_Chosain();
        }

        /** 調査委託先リストの割付数を、対象者からカウントし、設定します。 */
        private static _setUpWaritukeNum_ChosaItakusaki() {
            var dataSource: IChosaItakusaki[] = DBE2010002.dgChosaItakusakiList.dataSource;
            for (var i = 0; i < dataSource.length; i++) {
                dataSource[i].waritsukeNum = DBE2010002.__countChosaItakusakiAtChosairaiTargets(dataSource[i].chosaItakusakiNo);
            }
            DBE2010002.dgChosaItakusakiList.dataSource = dataSource;
        }

        /** 調査委託先ごとの割付数をカウントします。 */
        private static __countChosaItakusakiAtChosairaiTargets(chosaItakusakiNo: string): number {
            var count: number = 0;
            var targets: IChosaIraiTarget[] = DBE2010002.comNinteichosaIraiListGod.dataSource;
            for (var i = 0; i < targets.length; i++) {
                if (targets[i].chosaItakusakiNo === chosaItakusakiNo) {
                    count++;
                }
            }
            return count;
        }

        /** 調査員リストの割付数を、対象者からカウントし、設定します。 */
        private static _setUpWaritukeNum_Chosain() {
            var dataSource: IChosain[] = DBE2010002.comChosainListAll.dataSource;
            for (var i = 0; i < dataSource.length; i++) {
                dataSource[i].waritsukeNum = DBE2010002.__countChosainAtChosaIraiTargets(dataSource[i].chosainNo);
            }
            DBE2010002.comChosainListAll.dataSource = dataSource;
        }

        /** 対象者中の調査員ごとの割付数をカウントします。 */
        private static __countChosainAtChosaIraiTargets(chosainNo: string): number {
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
                    var chosaItakusaki: IChosaItakusaki = DBE2010002.selectedChosaItakuskai();
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
         * イベント後の共通処理です。
         */
        private static onAfterEvent() {
            DBE2010002.displayChosain();
            DBE2010002.divideWaritsukeOrMiwaritsuke();
        }

        /**
         * 調査委託先に所属する調査員の情報をビューへ反映します。
         */
        private static displayChosain() {
            var selectedItem: IChosaItakusaki = DBE2010002.selectedChosaItakuskai();
            if (selectedItem != null) {
                DBE2010002.comChosainList.dataSource = DBE2010002.getChosainList(selectedItem.chosaItakusakiNo);
            }
        }

        /**
         * 割付完了化処理です。
         */
        private static onClick_btnToBind() {
            var targets: IChosaIraiTarget[] = DBE2010002.selectedMiwaritsukeshaList();
            var chosaItakusaki: IChosaItakusaki = DBE2010002.selectedChosaItakuskai();
            var chosain: IChosain = DBE2010002.selectedChosain_onDisp();
            for (var i = 0; i < targets.length; i++) {
                DBE2010002._setChosaIraiTo(targets[i], chosaItakusaki, chosain);
            }
        }

        /**
         * 調査依頼を設定します。 
         */
        private static _setChosaIraiTo(target: IChosaIraiTarget, chosaItakusaki:IChosaItakusaki,chosain:IChosain) {
            target.chosaIraiDate.value = DBE2010002.txtChosaIraiDate.value;
            target.chosaKigenDate.value = DBE2010002.txtChosaKigenDate.value;
            target.chosaIraiKubun = DBE2010002.__chosaIraiKubun();

            if (chosaItakusaki === null) {
                return;
            }
            target.chosaItakusakiName = chosaItakusaki.chosaItakusakiName;
            target.chosaItakusakiNo = chosaItakusaki.chosaItakusakiNo;
            chosaItakusaki.waritsukeNum++;
            DBE2010002.replaceDataSourceFor_ChosaItakusaki(chosaItakusaki);

            if (chosain != null) {
                target.chosainName = chosain.chosainName;
                target.chosainNo = chosain.chosainNo;
                chosain.waritsukeNum++;
                DBE2010002.replaceDataSourceFor_Chosain(chosain);
            }

            DBE2010002.replaceDataSourceFor_Target(target);
        }

        /**
         * 調査依頼区分をddlIraiKubunから取得します。
         */
        private static __chosaIraiKubun(): string {
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
        private static onClick_btnToFree() {

            // 調査依頼をクリアします。
            function clearChosaIrai(target: IChosaIraiTarget) {
                target.chosaIraiDate.value = "";
                target.chosaKigenDate.value = "";
                target.chosaIraiKubun = "";

                var allocated_Itakusaki: IChosaItakusaki = DBE2010002.getChosaItakusaki(target.chosaItakusakiNo);
                if (allocated_Itakusaki != null) {
                    DBE2010002.replaceDataSourceFor_ChosaItakusaki_AsDecreaseWaritsukeNum(allocated_Itakusaki);
                }
                target.chosaItakusakiNo = "";
                target.chosaItakusakiName = "";

                var chosain: IChosain = DBE2010002.getChosain(target.chosainNo);
                if (chosain != null) {
                    DBE2010002.replaceDataSourceFor_Chosain_AsDecreaseWaritsukeNum(chosain);
                }
                target.chosainNo = "";
                target.chosainName = "";
                DBE2010002.replaceDataSourceFor_Target(target);
            }

            var targets: IChosaIraiTarget[] = DBE2010002.selectedWaritukezumishaList();
            for (var i = 0; i < targets.length; i++) {
                if (targets[i].chosaKanryoFlag) {
                    continue;
                }
                clearChosaIrai(targets[i]);
            }
        }

        /**
         * 選択している調査員を、対象者の調査員として割付ます。
         * 選択している調査員がすでに割付済みのときには、なにもしません。
         * 調査員と対象者のどちらかが未選択のときも、なにもしません。
         */
        private static bindSelectedChosainToTarget() {

            // 調査員を割り付けます。
            function bind(newChosain: IChosain, target: IChosaIraiTarget) {
                if (newChosain === null || target === null) {
                    return;
                }
                if (newChosain.chosainNo === target.chosainNo) {
                    return;
                }
                if (target.chosainNo != null) {
                    var oldChosain: IChosain = DBE2010002.getChosain(target.chosainNo);
                    DBE2010002.replaceDataSourceFor_Chosain_AsDecreaseWaritsukeNum(oldChosain);
                }
                newChosain.waritsukeNum++;
                DBE2010002.replaceDataSourceFor_Chosain(newChosain);
                //調査員を設定
                target.chosainNo = newChosain.chosainNo;
                target.chosainName = newChosain.chosainName;
                DBE2010002.replaceDataSourceFor_Target(target);
            }

            var selected_chosain: IChosain = DBE2010002.selectedChosain_onDisp();
            var targets: IChosaIraiTarget[] = DBE2010002.selectedWaritukezumishaList();
            for (var i = 0; i < targets.length; i++) {
                bind(selected_chosain, targets[i]);
            }
        }

        /**
         * 調査員の割付数を減らしつつ、置き換えます。
         */
        private static replaceDataSourceFor_Chosain_AsDecreaseWaritsukeNum(chosain: IChosain) {
            if (chosain === null) {
                return;
            }
            if (0 < chosain.waritsukeNum) {
                chosain.waritsukeNum--;
            } else {
                chosain.waritsukeNum = 0;
            }
            DBE2010002.replaceDataSourceFor_Chosain(chosain);
        }

        /**
         * 調査委託先の割付数を減らしつつ、置き換えます。
         */
        private static replaceDataSourceFor_ChosaItakusaki_AsDecreaseWaritsukeNum(chosaItakusaki: IChosaItakusaki) {
            if (chosaItakusaki === null) {
                return;
            }
            if (0 < chosaItakusaki.waritsukeNum) {
                chosaItakusaki.waritsukeNum--;
            } else {
                chosaItakusaki.waritsukeNum = 0;
            }
            DBE2010002.replaceDataSourceFor_ChosaItakusaki(chosaItakusaki);
        }

        /**
         * 選択中の調査依頼対象者を取得します。
         */
        private static selectedChosaItakuskai(): IChosaItakusaki {
            return <IChosaItakusaki>DBE2010002._selectedItemFrom(DBE2010002.dgChosaItakusakiList.dataSource);
        }

        /**
         * 表示中の調査員の中から、選択されているものを取得します。
         */
        private static selectedChosain_onDisp(): IChosain {
            return <IChosain>DBE2010002._selectedItemFrom(DBE2010002.comChosainList.dataSource);
        }

        /**
         * すべての調査員中から、選択されているものを取得します。
         */
        private static selectedChosain_fromAll(): IChosain {
            return <IChosain>DBE2010002._selectedItemFrom(DBE2010002.comChosainListAll.dataSource);
        }

        /**
         * 選択中の割付済み者を取得します。
         */
        private static selectedWaritukezumishaList(): IChosaIraiTarget[] {
            return <IChosaIraiTarget[]> DBE2010002._selectedItemsFrom(DBE2010002.comWaritukezumiList.dataSource);
        }

        /**
         * 選択中の未割付者のリストを取得します。
         */
        private static selectedMiwaritsukeshaList(): IChosaIraiTarget[] {
            return <IChosaIraiTarget[]> DBE2010002._selectedItemsFrom(DBE2010002.comMiwaritsukeList.dataSource);
        }

        /**
         * dataSourceから、選択されているitem(複数あれば、一番先頭)を返します。
         * なければ、nullを返します。
        */
        private static _selectedItemFrom(dataSource: ISelectable[]): ISelectable {
            for (var i = 0; i < dataSource.length; i++) {
                if (dataSource[i].selected) {
                    return dataSource[i];
                }
            }
            return null;
        }

        /**
         * dataSourceから、選択されているitemをすべて返します。
         */
        private static _selectedItemsFrom(dataSource: ISelectable[]): ISelectable[] {
            var selectedItems: ISelectable[] = [];
            for (var i = 0; i < dataSource.length; i++) {
                if (dataSource[i].selected) {
                    selectedItems.push(dataSource[i]);
                }
            }
            return selectedItems;
        }

        /**
         * 渡した情報で、調査依頼対象者を置き換えます。
         */
        private static replaceDataSourceFor_Target(target: IChosaIraiTarget) {
            if (target === null) {
                return;
            }
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
        private static replaceDataSourceFor_Chosain(chosain: IChosain) {
            if (chosain === null) {
                return;
            }
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
        private static replaceDataSourceFor_ChosaItakusaki(chosaItakusaki: IChosaItakusaki) {
            if (chosaItakusaki === null) {
                return;
            }
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
        private static getChosaIraiTarget(hihokenshaNo: string): IChosaIraiTarget {
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
        private static getChosaItakusaki(chosaItakusakiNo: string): IChosaItakusaki {
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
            //  var chosain: IChosain = DBE2010002.selected_Chosain_all();
            // if (chosain != null) {
            //     chosain.selected = false;
            //     DBE2010002.replaceChosain_all(chosain);
            //     alert(chosain.chosainName + "\n" + "selected : " + chosain.selected);
            // }
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
    interface IChosaIraiTarget extends ISelectable {
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
        btnToBindChosain: Uz._Button;
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