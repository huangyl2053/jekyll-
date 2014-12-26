/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoshikakukihon;

import jp.co.ndensan.reams.db.dbz.business.Hihokensha;
import jp.co.ndensan.reams.db.dbz.business.searchkey.KaigoShikakuKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.business.searchkey.KaigoShikakuKihonSearchKeyBuilder;
import jp.co.ndensan.reams.db.dbz.realservice.HihokenshaFinder;
import jp.co.ndensan.reams.ur.urz.business.IKobetsuJikoKaigoJukyu;
import jp.co.ndensan.reams.ur.urz.realservice.IJukyuDaichoFinder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護資格基本情報Divの操作を行うクラスです。
 *
 * @author N8156 宮本 康
 */
public class KaigoShikakuKihonHandler {

    private final KaigoShikakuKihonDiv div;
    private final HihokenshaFinder hihokenshaFinder;
    private final IJukyuDaichoFinder jukyuDaichoFinder;

    /**
     * コンストラクタです。
     *
     * @param div 介護資格基本情報Div
     */
    public KaigoShikakuKihonHandler(KaigoShikakuKihonDiv div) {
        this.div = div;
        hihokenshaFinder = new HihokenshaFinder();
        jukyuDaichoFinder = InstanceProvider.createWithCustomize(IJukyuDaichoFinder.class);
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param div 介護資格基本情報Div
     * @param hihokenshaFinder 被保険者Finder
     * @param jukyuDaichoFinder 受給者台帳Finder
     */
    KaigoShikakuKihonHandler(KaigoShikakuKihonDiv div, HihokenshaFinder hihokenshaFinder, IJukyuDaichoFinder jukyuDaichoFinder) {
        this.div = div;
        this.hihokenshaFinder = hihokenshaFinder;
        this.jukyuDaichoFinder = jukyuDaichoFinder;
    }

    /**
     * 検索キーを元にデータを取得し、Divに設定します。
     *
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     */
    public void load(LasdecCode 市町村コード, ShikibetsuCode 識別コード) {

        KaigoShikakuKihonSearchKey 検索キー = new KaigoShikakuKihonSearchKeyBuilder(市町村コード, 識別コード).build();
        Hihokensha hihokensha = hihokenshaFinder.get被保険者(検索キー.get市町村コード(), 検索キー.get識別コード());
        if (hihokensha == null) {
            return;
        }

        div.getTxtHihokenshaNo().setValue(hihokensha.get被保険者番号().value());
        div.getTxtShutokuYmd().setValue(new RDate(hihokensha.get資格取得().getActionDate().toString()));
        div.getTxtShutokuJiyu().setValue(hihokensha.get資格取得().getReason().getName());
        div.getTxtSoshitsuYmd().setValue(new RDate(hihokensha.get資格喪失().getActionDate().toString()));
        div.getTxtSoshitsuJiyu().setValue(hihokensha.get資格喪失().getReason().getName());
        div.getTxtJutokuKubun().setValue(hihokensha.get住所地特例者区分().get名称());

        IKobetsuJikoKaigoJukyu jukyu = jukyuDaichoFinder.get個別事項介護受給(検索キー.get識別コード(), hihokensha.get処理日時().getDate());

        if (jukyu != null) {
            div.getTxtYokaigoJotaiKubun().setValue(new RString(jukyu.get要介護状態区分().name()));
            div.getTxtNinteiKaishiYmd().setValue(new RDate(jukyu.get認定有効開始日().toString()));
            div.getTxtNinteiShuryoYmd().setValue(new RDate(jukyu.get認定有効終了日().toString()));
        }
    }
}
