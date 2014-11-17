/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.IHihokenshaShikaku;
import jp.co.ndensan.reams.db.dbz.business.KaigoShikakuKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakutokusorireki.ShikakuTokusoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakutokusorireki.dgShikakuShutokuRireki_Row;
import jp.co.ndensan.reams.db.dbz.realservice.HihokenshaDaichoManager;
import jp.co.ndensan.reams.db.dbz.realservice.search.HihokenshaDaichoSearchItem;
import jp.co.ndensan.reams.ur.urz.realservice.search.INewSearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.search.SearchConditionFactory;
import jp.co.ndensan.reams.ur.urz.realservice.search.StringOperator;

/**
 * 資格特喪履歴情報Divの操作を行うクラスです。
 *
 * @author N8156 宮本 康
 */
public class ShikakuTokusoRirekiHandler {

    private final ShikakuTokusoRirekiDiv div;
    private final HihokenshaDaichoManager hihokenshaDaichoManager;

    /**
     * コンストラクタです。
     *
     * @param div 資格特喪履歴情報Div
     */
    public ShikakuTokusoRirekiHandler(ShikakuTokusoRirekiDiv div) {
        this.div = div;
        hihokenshaDaichoManager = new HihokenshaDaichoManager();
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param div 資格特喪履歴情報Div
     * @param hihokenshaDaichoManager 被保険者台帳Manager
     */
    ShikakuTokusoRirekiHandler(ShikakuTokusoRirekiDiv div, HihokenshaDaichoManager hihokenshaDaichoManager) {
        this.div = div;
        this.hihokenshaDaichoManager = hihokenshaDaichoManager;
    }

    /**
     * 検索キーを元にデータを取得し、Divに設定します。
     *
     * @param 検索キー 介護資格基本情報の検索キー
     */
    public void load(KaigoShikakuKihonSearchKey 検索キー) {

        INewSearchCondition 市町村コード検索条件 = SearchConditionFactory.condition(
                HihokenshaDaichoSearchItem.市町村コード, StringOperator.完全一致, 検索キー.get市町村コード().value());
        INewSearchCondition 識別コード検索条件 = SearchConditionFactory.condition(
                HihokenshaDaichoSearchItem.識別コード, StringOperator.完全一致, 検索キー.get識別コード().value());

        List<IHihokenshaShikaku> shikakuList = hihokenshaDaichoManager.get被保険者資格ListOf(市町村コード検索条件.and(識別コード検索条件));

        List<dgShikakuShutokuRireki_Row> rowList = new ArrayList<>();
        for (IHihokenshaShikaku shikaku : shikakuList) {
            dgShikakuShutokuRireki_Row row = new dgShikakuShutokuRireki_Row();
            row.getShutokuDate().setValue(shikaku.get資格取得().getActionDate());
            row.getShutokuTodokedeDate().setValue(shikaku.get資格取得().getNoticeDate());
            row.setShutokuJiyu(shikaku.get資格取得().getReason().getName());
            row.setHihokenshaKubun(shikaku.get被保険者区分().getMeisho());
            row.getSoshitsuDate().setValue(shikaku.get資格喪失().getActionDate());
            row.getSoshitsuTodokedeDate().setValue(shikaku.get資格喪失().getNoticeDate());
            row.setSoshitsuJiyu(shikaku.get資格喪失().getReason().getName());
            row.setJutokuKubun(shikaku.get住所地特例者区分().get名称());
            row.setShozaiHokensha(shikaku.get市町村コード().value());
            row.setSochimotoHokensha(shikaku.get広域内住所地特例措置元保険者番号().value());
            row.setKyuHokensha(shikaku.get旧市町村コード().value());
            row.setShikibetsuCode(shikaku.get識別コード().value());
            rowList.add(row);
        }
        div.getDgShikakuShutokuRireki().setDataSource(rowList);
    }
}
