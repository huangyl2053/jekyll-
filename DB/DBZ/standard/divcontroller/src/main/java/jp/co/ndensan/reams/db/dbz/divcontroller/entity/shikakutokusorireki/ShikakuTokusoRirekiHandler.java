///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakutokusorireki;
//
//import java.util.ArrayList;
//import java.util.List;
//import jp.co.ndensan.reams.db.dbz.business.Hihokensha;
//import jp.co.ndensan.reams.db.dbz.business.HihokenshaList;
//import jp.co.ndensan.reams.db.dbz.business.searchkey.KaigoShikakuKihonSearchKey;
//import jp.co.ndensan.reams.db.dbz.business.searchkey.KaigoShikakuKihonSearchKeyBuilder;
//import jp.co.ndensan.reams.db.dbz.realservice.HihokenshaFinder;
//import jp.co.ndensan.reams.db.dbz.realservice.search.HihokenshaSearchItem;
//import jp.co.ndensan.reams.ur.urz.realservice.search.INewSearchCondition;
//import jp.co.ndensan.reams.ur.urz.realservice.search.SearchConditionFactory;
//import jp.co.ndensan.reams.ur.urz.realservice.search.StringOperator;
//import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
//import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
//
///**
// * 資格特喪履歴情報Divの操作を行うクラスです。
// *
// * @author N8156 宮本 康
// */
//public class ShikakuTokusoRirekiHandler {
//
//    private final ShikakuTokusoRirekiDiv div;
//    private final HihokenshaFinder hihokenshaFinder;
//
//    /**
//     * コンストラクタです。
//     *
//     * @param div 資格特喪履歴情報Div
//     */
//    public ShikakuTokusoRirekiHandler(ShikakuTokusoRirekiDiv div) {
//        this.div = div;
//        hihokenshaFinder = new HihokenshaFinder();
//    }
//
//    /**
//     * モックを使用するテスト用コンストラクタです。
//     *
//     * @param div 資格特喪履歴情報Div
//     * @param hihokenshaFinder 被保険者Finder
//     */
//    ShikakuTokusoRirekiHandler(ShikakuTokusoRirekiDiv div, HihokenshaFinder hihokenshaFinder) {
//        this.div = div;
//        this.hihokenshaFinder = hihokenshaFinder;
//    }
//
//    /**
//     * 検索キーを元にデータを取得し、Divに設定します。
//     *
//     * @param 市町村コード 市町村コード
//     * @param 識別コード 識別コード
//     */
//    public void load(LasdecCode 市町村コード, ShikibetsuCode 識別コード) {
//
//        KaigoShikakuKihonSearchKey 検索キー = new KaigoShikakuKihonSearchKeyBuilder(市町村コード, 識別コード).build();
//        INewSearchCondition 市町村コード検索条件 = SearchConditionFactory.condition(
//                HihokenshaSearchItem.市町村コード, StringOperator.完全一致, 検索キー.get市町村コード().value());
//        INewSearchCondition 識別コード検索条件 = SearchConditionFactory.condition(
//                HihokenshaSearchItem.識別コード, StringOperator.完全一致, 検索キー.get識別コード().value());
//
//        HihokenshaList hihokenshaList = hihokenshaFinder.get被保険者List(市町村コード検索条件.and(識別コード検索条件));
//
//        List<dgShikakuShutokuRireki_Row> rowList = new ArrayList<>();
//        for (Hihokensha hihokensha : hihokenshaList) {
//            dgShikakuShutokuRireki_Row row = new dgShikakuShutokuRireki_Row();
//            row.getShutokuDate().setValue(hihokensha.get資格取得().getActionDate());
//            row.getShutokuTodokedeDate().setValue(hihokensha.get資格取得().getNoticeDate());
//            row.setShutokuJiyu(hihokensha.get資格取得().getReason().getName());
//            row.setHihokenshaKubun(hihokensha.get被保険者区分().getMeisho());
//            row.getSoshitsuDate().setValue(hihokensha.get資格喪失().getActionDate());
//            row.getSoshitsuTodokedeDate().setValue(hihokensha.get資格喪失().getNoticeDate());
//            row.setSoshitsuJiyu(hihokensha.get資格喪失().getReason().getName());
//            row.setJutokuKubun(hihokensha.get住所地特例者区分().get名称());
//            row.setShozaiHokensha(hihokensha.get市町村コード().value());
//            row.setSochimotoHokensha(hihokensha.get広域内住所地特例措置元保険者番号().value());
//            row.setKyuHokensha(hihokensha.get旧市町村コード().value());
//            row.setShikibetsuCode(hihokensha.get識別コード().value());
//            rowList.add(row);
//        }
//        div.getDgShikakuShutokuRireki().setDataSource(rowList);
//    }
//}
