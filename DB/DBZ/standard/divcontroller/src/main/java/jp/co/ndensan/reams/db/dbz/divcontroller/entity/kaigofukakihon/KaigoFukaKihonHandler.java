/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigofukakihon;

import jp.co.ndensan.reams.db.dbz.business.Hihokensha;
import jp.co.ndensan.reams.db.dbz.business.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.business.searchkey.KaigoFukaKihonSearchKeyBuilder;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.realservice.HihokenshaFinder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 介護賦課基本情報Divの操作を行うクラスです。
 *
 * @author N8156 宮本 康
 */
public class KaigoFukaKihonHandler {

    private final KaigoFukaKihonDiv div;
    private final HihokenshaFinder hihokenshaFinder;

    /**
     * コンストラクタです。
     *
     * @param div 介護賦課基本情報Div
     */
    public KaigoFukaKihonHandler(KaigoFukaKihonDiv div) {
        this.div = div;
        hihokenshaFinder = new HihokenshaFinder();
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param div 介護賦課基本情報Div
     * @param hihokenshaFinder 被保険者Finder
     */
    KaigoFukaKihonHandler(KaigoFukaKihonDiv div, HihokenshaFinder hihokenshaFinder) {
        this.div = div;
        this.hihokenshaFinder = hihokenshaFinder;
    }

    /**
     * 検索キーを元にデータを取得し、Divに設定します。
     *
     * @param 通知書番号 通知書番号
     * @param 賦課年度 賦課年度
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     */
    public void load(TsuchishoNo 通知書番号, FlexibleYear 賦課年度, LasdecCode 市町村コード, ShikibetsuCode 識別コード) {

        // TODO N8156 宮本 康 賦課情報の取得処理が実装され次第対応する。（オフショアで対応中）
        KaigoFukaKihonSearchKey 検索キー = new KaigoFukaKihonSearchKeyBuilder(通知書番号, 賦課年度, 市町村コード, 識別コード).build();
        Hihokensha hihokensha = hihokenshaFinder.get被保険者(検索キー.get市町村コード(), 検索キー.get識別コード());

        if (hihokensha != null) {
            div.getTxtShutokuYmd().setValue(new RDate(hihokensha.get資格取得().getActionDate().toString()));
            div.getTxtShutokuJiyu().setValue(hihokensha.get資格取得().getReason().getName());
            div.getTxtSoshitsuYmd().setValue(new RDate(hihokensha.get資格喪失().getActionDate().toString()));
            div.getTxtSoshitsuJiyu().setValue(hihokensha.get資格喪失().getReason().getName());
        }
    }
}
