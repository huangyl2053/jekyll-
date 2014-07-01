/// <reference path="../../../../NetBeansProjects/DB/DB/DBE/standard/d.ts/jquery.d.ts" />
/// <reference path="../../../../NetBeansProjects/DB/DB/DBE/standard/d.ts/UzViewControls.d.ts" />
var DBE;
(function (DBE) {
    var DBE2010002 = (function () {
        function DBE2010002() {
        }
        DBE2010002.onLoadThisFile = /**
        * onLoadよりも早くよばれます。
        * deployEvents()内に、layoutへ設定したいイベントを羅列してあります。
        */
        function () {
            DBE2010002.deployEvents();
        };

        DBE2010002.deployEvents = /**
        * イベントを登録します。
        */
        function () {
            // ロード時の処理
            Uz.GyomuJSHelper.registOriginalEvent("onLoad_NinteichosaIraiByHand", function (control) {
                DBE2010002._onLoad_NinteichosaIraiByHand();
            });

            // 「割付化」ボタン押下時処理
            Uz.GyomuJSHelper.registOriginalEvent("onClick_btnToBind", function (control) {
                DBE2010002.onClick_btnToBind();
                DBE2010002.onAfterEvent();
            });

            // 「未割付化」ボタン押下時処理
            Uz.GyomuJSHelper.registOriginalEvent("onClick_btnToFree", function (control) {
                DBE2010002.onClick_btnToFree();
                DBE2010002.onAfterEvent();
            });

            // 調査委託先一覧選択時処理
            Uz.GyomuJSHelper.registOriginalEvent("onSelect_dgChosaItakusakiList", function (control) {
                DBE2010002.unselect_Chosain_all();
                DBE2010002.onAfterEvent();
            });

            // 調査員リスト内の割付ボタン押下時処理
            Uz.GyomuJSHelper.registOriginalEvent(DBE2010002.eventName_for_btnToBindChosain, function (control) {
                DBE2010002.bindSelectedChosainToTarget();
                DBE2010002.onAfterEvent();
            });
        };

        DBE2010002._onLoad_NinteichosaIraiByHand = /**
        * onLoad後の処理です。
        */
        function () {
            DBE2010002.divideWaritsukeOrMiwaritsuke();
            DBE2010002.setUpWaritukeNum();
        };

        DBE2010002.deployOnClickEventToButtonOfChosain = /**
        * 調査員のbtnToBindChosainのonClickにイベントを追加します。
        * 現状、この処理はうまくいきません。
        */
        function () {
            var dataSource = DBE2010002.comChosainListAll.dataSource;
            for (var i = 0; i < dataSource.length; i++) {
                dataSource[i].btnToBindChosain.onClick = DBE2010002.eventName_for_btnToBindChosain;
            }
            DBE2010002.comChosainListAll.dataSource = dataSource;
        };

        DBE2010002.setUpWaritukeNum = /**
        * 割付数をカウントします。
        */
        function () {
            DBE2010002._setUpWaritukeNum_ChosaItakusaki();
            DBE2010002._setUpWaritukeNum_Chosain();
        };

        DBE2010002._setUpWaritukeNum_ChosaItakusaki = /** 調査委託先リストの割付数を、対象者からカウントし、設定します。 */
        function () {
            var dataSource = DBE2010002.dgChosaItakusakiList.dataSource;
            for (var i = 0; i < dataSource.length; i++) {
                dataSource[i].waritsukeNum = DBE2010002.__countChosaItakusakiAtChosairaiTargets(dataSource[i].chosaItakusakiNo);
            }
            DBE2010002.dgChosaItakusakiList.dataSource = dataSource;
        };

        DBE2010002.__countChosaItakusakiAtChosairaiTargets = /** 調査委託先ごとの割付数をカウントします。 */
        function (chosaItakusakiNo) {
            var count = 0;
            var targets = DBE2010002.comNinteichosaIraiListGod.dataSource;
            for (var i = 0; i < targets.length; i++) {
                if (targets[i].chosaItakusakiNo === chosaItakusakiNo) {
                    count++;
                }
            }
            return count;
        };

        DBE2010002._setUpWaritukeNum_Chosain = /** 調査員リストの割付数を、対象者からカウントし、設定します。 */
        function () {
            var dataSource = DBE2010002.comChosainListAll.dataSource;
            for (var i = 0; i < dataSource.length; i++) {
                dataSource[i].waritsukeNum = DBE2010002.__countChosainAtChosaIraiTargets(dataSource[i].chosainNo);
            }
            DBE2010002.comChosainListAll.dataSource = dataSource;
        };

        DBE2010002.__countChosainAtChosaIraiTargets = /** 対象者中の調査員ごとの割付数をカウントします。 */
        function (chosainNo) {
            var count = 0;
            var targets = DBE2010002.comNinteichosaIraiListGod.dataSource;
            for (var i = 0; i < targets.length; i++) {
                if (targets[i].chosainNo === chosainNo) {
                    count++;
                }
            }
            return count;
        };

        DBE2010002.divideWaritsukeOrMiwaritsuke = /**
        * 非表示の全対象者を持ったDataGridのRowそれぞれについて、
        * 割付済みか未割付かを判定して、それぞれ専用のDataGridへ振り分けます。
        * また、調査依頼先を選択している調査依頼先に対応した割付済み者のみ表示します。
        */
        function () {
            var chosaIraiTargets = DBE2010002.comNinteichosaIraiListGod.dataSource;

            var waritsuke = [];
            var miwaritsuke = [];

            function isMiwariate(item) {
                function isEmpty(str) {
                    return str === "";
                }
                ;
                return isEmpty(item.chosaIraiDate.value) || isEmpty(item.chosaIraiKubun) || isEmpty(item.chosaKigenDate.value);
            }

            for (var i = 0; i < chosaIraiTargets.length; i++) {
                if (isMiwariate(chosaIraiTargets[i])) {
                    miwaritsuke.push(chosaIraiTargets[i]);
                } else {
                    var chosaItakusaki = DBE2010002.selectedChosaItakuskai();
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
        };

        DBE2010002.onAfterEvent = /**
        * イベント後の共通処理です。
        */
        function () {
            DBE2010002.displayChosain();
            DBE2010002.divideWaritsukeOrMiwaritsuke();
        };

        DBE2010002.displayChosain = /**
        * 調査委託先に所属する調査員の情報をビューへ反映します。
        */
        function () {
            var selectedItem = DBE2010002.selectedChosaItakuskai();
            if (selectedItem != null) {
                DBE2010002.comChosainList.dataSource = DBE2010002.getChosainList(selectedItem.chosaItakusakiNo);
            }
        };

        DBE2010002.onClick_btnToBind = /**
        * 割付完了化処理です。
        */
        function () {
            var targets = DBE2010002.selectedMiwaritsukeshaList();
            var chosaItakusaki = DBE2010002.selectedChosaItakuskai();
            var chosain = DBE2010002.selectedChosain_onDisp();
            for (var i = 0; i < targets.length; i++) {
                DBE2010002._setChosaIraiTo(targets[i], chosaItakusaki, chosain);
            }
        };

        DBE2010002._setChosaIraiTo = /**
        * 調査依頼を設定します。
        */
        function (target, chosaItakusaki, chosain) {
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
        };

        DBE2010002.__chosaIraiKubun = /**
        * 調査依頼区分をddlIraiKubunから取得します。
        */
        function () {
            var key = DBE2010002.ddlIraiKubun.selectedItem;
            var dataSource = DBE2010002.ddlIraiKubun.dataSource;
            for (var i = 0; i < dataSource.length; i++) {
                if (dataSource[i].key === key) {
                    return dataSource[i].value;
                }
            }
            return "1：初回";
        };

        DBE2010002.onClick_btnToFree = /**
        * 未割付化処理です。
        */
        function () {
            // 調査依頼をクリアします。
            function clearChosaIrai(target) {
                target.chosaIraiDate.value = "";
                target.chosaKigenDate.value = "";
                target.chosaIraiKubun = "";

                var allocated_Itakusaki = DBE2010002.getChosaItakusaki(target.chosaItakusakiNo);
                if (allocated_Itakusaki != null) {
                    DBE2010002.replaceDataSourceFor_ChosaItakusaki_AsDecreaseWaritsukeNum(allocated_Itakusaki);
                }
                target.chosaItakusakiNo = "";
                target.chosaItakusakiName = "";

                var chosain = DBE2010002.getChosain(target.chosainNo);
                if (chosain != null) {
                    DBE2010002.replaceDataSourceFor_Chosain_AsDecreaseWaritsukeNum(chosain);
                }
                target.chosainNo = "";
                target.chosainName = "";
                DBE2010002.replaceDataSourceFor_Target(target);
            }

            var targets = DBE2010002.selectedWaritukezumishaList();
            for (var i = 0; i < targets.length; i++) {
                if (targets[i].chosaKanryoFlag) {
                    continue;
                }
                clearChosaIrai(targets[i]);
            }
        };

        DBE2010002.bindSelectedChosainToTarget = /**
        * 選択している調査員を、対象者の調査員として割付ます。
        * 選択している調査員がすでに割付済みのときには、なにもしません。
        * 調査員と対象者のどちらかが未選択のときも、なにもしません。
        */
        function () {
            // 調査員を割り付けます。
            function bind(newChosain, target) {
                if (newChosain === null || target === null) {
                    return;
                }
                if (newChosain.chosainNo === target.chosainNo) {
                    return;
                }
                if (target.chosainNo != null) {
                    var oldChosain = DBE2010002.getChosain(target.chosainNo);
                    DBE2010002.replaceDataSourceFor_Chosain_AsDecreaseWaritsukeNum(oldChosain);
                }
                newChosain.waritsukeNum++;
                DBE2010002.replaceDataSourceFor_Chosain(newChosain);

                //調査員を設定
                target.chosainNo = newChosain.chosainNo;
                target.chosainName = newChosain.chosainName;
                DBE2010002.replaceDataSourceFor_Target(target);
            }

            var selected_chosain = DBE2010002.selectedChosain_onDisp();
            var targets = DBE2010002.selectedWaritukezumishaList();
            for (var i = 0; i < targets.length; i++) {
                bind(selected_chosain, targets[i]);
            }
        };

        DBE2010002.replaceDataSourceFor_Chosain_AsDecreaseWaritsukeNum = /**
        * 調査員の割付数を減らしつつ、置き換えます。
        */
        function (chosain) {
            if (chosain === null) {
                return;
            }
            if (0 < chosain.waritsukeNum) {
                chosain.waritsukeNum--;
            } else {
                chosain.waritsukeNum = 0;
            }
            DBE2010002.replaceDataSourceFor_Chosain(chosain);
        };

        DBE2010002.replaceDataSourceFor_ChosaItakusaki_AsDecreaseWaritsukeNum = /**
        * 調査委託先の割付数を減らしつつ、置き換えます。
        */
        function (chosaItakusaki) {
            if (chosaItakusaki === null) {
                return;
            }
            if (0 < chosaItakusaki.waritsukeNum) {
                chosaItakusaki.waritsukeNum--;
            } else {
                chosaItakusaki.waritsukeNum = 0;
            }
            DBE2010002.replaceDataSourceFor_ChosaItakusaki(chosaItakusaki);
        };

        DBE2010002.selectedChosaItakuskai = /**
        * 選択中の調査依頼対象者を取得します。
        */
        function () {
            return DBE2010002._selectedItemFrom(DBE2010002.dgChosaItakusakiList.dataSource);
        };

        DBE2010002.selectedChosain_onDisp = /**
        * 表示中の調査員の中から、選択されているものを取得します。
        */
        function () {
            return DBE2010002._selectedItemFrom(DBE2010002.comChosainList.dataSource);
        };

        DBE2010002.selectedChosain_fromAll = /**
        * すべての調査員中から、選択されているものを取得します。
        */
        function () {
            return DBE2010002._selectedItemFrom(DBE2010002.comChosainListAll.dataSource);
        };

        DBE2010002.selectedWaritukezumishaList = /**
        * 選択中の割付済み者を取得します。
        */
        function () {
            return DBE2010002._selectedItemsFrom(DBE2010002.comWaritukezumiList.dataSource);
        };

        DBE2010002.selectedMiwaritsukeshaList = /**
        * 選択中の未割付者のリストを取得します。
        */
        function () {
            return DBE2010002._selectedItemsFrom(DBE2010002.comMiwaritsukeList.dataSource);
        };

        DBE2010002._selectedItemFrom = /**
        * dataSourceから、選択されているitem(複数あれば、一番先頭)を返します。
        * なければ、nullを返します。
        */
        function (dataSource) {
            for (var i = 0; i < dataSource.length; i++) {
                if (dataSource[i].selected) {
                    return dataSource[i];
                }
            }
            return null;
        };

        DBE2010002._selectedItemsFrom = /**
        * dataSourceから、選択されているitemをすべて返します。
        */
        function (dataSource) {
            var selectedItems = [];
            for (var i = 0; i < dataSource.length; i++) {
                if (dataSource[i].selected) {
                    selectedItems.push(dataSource[i]);
                }
            }
            return selectedItems;
        };

        DBE2010002.replaceDataSourceFor_Target = /**
        * 渡した情報で、調査依頼対象者を置き換えます。
        */
        function (target) {
            if (target === null) {
                return;
            }
            var dataSource = DBE2010002.comNinteichosaIraiListGod.dataSource;
            for (var i = 0; i < dataSource.length; i++) {
                if (dataSource[i].hihokenshaNo === target.hihokenshaNo) {
                    dataSource[i] = target;
                }
            }
            DBE2010002.comNinteichosaIraiListGod.dataSource = dataSource;
        };

        DBE2010002.replaceDataSourceFor_Chosain = /**
        * 渡した情報で、調査員を置き換えます。
        */
        function (chosain) {
            if (chosain === null) {
                return;
            }
            var dataSource = DBE2010002.comChosainListAll.dataSource;
            for (var i = 0; i < dataSource.length; i++) {
                if (dataSource[i].chosainNo === chosain.chosainNo) {
                    dataSource[i] = chosain;
                }
            }
            DBE2010002.comChosainListAll.dataSource = dataSource;
        };

        DBE2010002.replaceDataSourceFor_ChosaItakusaki = /**
        * 渡した情報で、調査委託先を置き換えます。
        */
        function (chosaItakusaki) {
            if (chosaItakusaki === null) {
                return;
            }
            var dataSource = DBE2010002.dgChosaItakusakiList.dataSource;
            for (var i = 0; i < dataSource.length; i++) {
                if (dataSource[i].chosaItakusakiNo === chosaItakusaki.chosaItakusakiNo) {
                    dataSource[i] = chosaItakusaki;
                }
            }
            DBE2010002.dgChosaItakusakiList.dataSource = dataSource;
        };

        DBE2010002.getChosaIraiTarget = /**
        * 被保険者番号から、調査依頼対象者を取得します。
        */
        function (hihokenshaNo) {
            var dataSource = DBE2010002.comNinteichosaIraiListGod.dataSource;
            for (var i = 0; i < dataSource.length; i++) {
                if (dataSource[i].hihokenshaNo === hihokenshaNo) {
                    return dataSource[i];
                }
            }
            return null;
        };

        DBE2010002.getChosain = /**
        * 調査員番号から、調査員を取得します。
        */
        function (chosainNo) {
            var dataSource = DBE2010002.comChosainListAll.dataSource;
            for (var i = 0; i < dataSource.length; i++) {
                if (dataSource[i].chosainNo === chosainNo) {
                    return dataSource[i];
                }
            }
            return null;
        };

        DBE2010002.getChosaItakusaki = /**
        * 調査委託先番号から、調査委託先を取得します。
        */
        function (chosaItakusakiNo) {
            var dataSource = DBE2010002.dgChosaItakusakiList.dataSource;
            for (var i = 0; i < dataSource.length; i++) {
                if (dataSource[i].chosaItakusakiNo === chosaItakusakiNo) {
                    return dataSource[i];
                }
            }
            return null;
        };

        DBE2010002.getChosainList = /**
        * 選択されている調査委託先に属する調査員を抽出します。
        */
        function (chousaItakusakiNo) {
            var chosainList = [];
            var dataSource = DBE2010002.comChosainListAll.dataSource;
            for (var i = 0; i < dataSource.length; i++) {
                if (dataSource[i].chousaItakusakiNo === chousaItakusakiNo) {
                    chosainList.push(dataSource[i]);
                }
            }
            return chosainList;
        };

        DBE2010002.unselect_Chosain_all = /**
        * 調査員の選択を解除します。
        * 現状のコードでは希望の動作をしません。
        * 同じように、対象者側も選択を解除する必要性がありますが、そちらにも手をつけていません。
        */
        function () {
        };
        DBE2010002.comNinteichosaIraiListGod = Uz.GyomuJSHelper.getCompositeChildControl('comNinteichosaIraiListGod', 'NinteichosaIraiListForByHandCom', 'dgNinteichosaIraiListForByHand');
        DBE2010002.comWaritukezumiList = Uz.GyomuJSHelper.getCompositeChildControl('comWaritukezumiList', 'NinteichosaIraiListForByHandCom', 'dgNinteichosaIraiListForByHand');
        DBE2010002.comMiwaritsukeList = Uz.GyomuJSHelper.getCompositeChildControl('comMiwarituskeList', 'NinteichosaIraiListForByHandCom', 'dgNinteichosaIraiListForByHand');

        DBE2010002.txtChosaIraiDate = Uz.GyomuJSHelper.getJSControl('txtChosaIraiDate');
        DBE2010002.txtChosaKigenDate = Uz.GyomuJSHelper.getJSControl('txtChosaKigenDate');
        DBE2010002.ddlIraiKubun = Uz.GyomuJSHelper.getJSControl('ddlIraiKubun');

        DBE2010002.dgChosaItakusakiList = Uz.GyomuJSHelper.getJSControl('dgChosaItakusakiList');
        DBE2010002.comChosainList = Uz.GyomuJSHelper.getCompositeChildControl('comChosainList', 'ShozokuChosainListCom', 'dgShozokuChosainList');
        DBE2010002.comChosainListAll = Uz.GyomuJSHelper.getCompositeChildControl('comChosainListAll', 'ShozokuChosainListCom', 'dgShozokuChosainList');
        DBE2010002.eventName_for_btnToBindChosain = "bind_SelectedChosain";
        return DBE2010002;
    })();
    DBE.DBE2010002 = DBE2010002;
})(DBE || (DBE = {}));

DBE.DBE2010002.onLoadThisFile();
//@ sourceMappingURL=DBE2010002.js.map
