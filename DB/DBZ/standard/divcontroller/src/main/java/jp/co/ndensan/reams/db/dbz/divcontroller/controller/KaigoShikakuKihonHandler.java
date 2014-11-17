/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import jp.co.ndensan.reams.db.dbz.business.IHihokenshaShikaku;
import jp.co.ndensan.reams.db.dbz.business.KaigoShikakuKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.realservice.HihokenshaDaichoManager;
import jp.co.ndensan.reams.ur.urz.business.IKobetsuJikoKaigoJukyu;
import jp.co.ndensan.reams.ur.urz.realservice.IJukyuDaichoFinder;
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
    private final HihokenshaDaichoManager hihokenshaDaichoManager;
    private final IJukyuDaichoFinder jukyuDaichoFinder;

    /**
     * コンストラクタです。
     *
     * @param div 介護資格基本情報Div
     */
    public KaigoShikakuKihonHandler(KaigoShikakuKihonDiv div) {
        this.div = div;
        hihokenshaDaichoManager = new HihokenshaDaichoManager();
        jukyuDaichoFinder = InstanceProvider.createWithCustomize(IJukyuDaichoFinder.class);
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param div 介護資格基本情報Div
     * @param hihokenshaDaichoManager 被保険者台帳Manager
     * @param jukyuDaichoFinder 受給者台帳Finder
     */
    KaigoShikakuKihonHandler(KaigoShikakuKihonDiv div, HihokenshaDaichoManager hihokenshaDaichoManager, IJukyuDaichoFinder jukyuDaichoFinder) {
        this.div = div;
        this.hihokenshaDaichoManager = hihokenshaDaichoManager;
        this.jukyuDaichoFinder = jukyuDaichoFinder;
    }

    /**
     * 検索キーを元にデータを取得し、Divに設定します。
     *
     * @param 検索キー 介護資格基本情報の検索キー
     */
    public void load(KaigoShikakuKihonSearchKey 検索キー) {

        IHihokenshaShikaku shikaku = hihokenshaDaichoManager.get直近被保険者資格(検索キー.get市町村コード(), 検索キー.get識別コード());

        if (shikaku == null) {
            return;
        }

        div.getTxtHihokenshaNo().setValue(shikaku.get被保険者番号().value());
        div.getTxtShutokuYmd().setValue(new RDate(shikaku.get資格取得().getActionDate().toString()));
        div.getTxtShutokuJiyu().setValue(shikaku.get資格取得().getReason().getName());
        div.getTxtSoshitsuYmd().setValue(new RDate(shikaku.get資格喪失().getActionDate().toString()));
        div.getTxtSoshitsuJiyu().setValue(shikaku.get資格喪失().getReason().getName());
        div.getTxtJutokuKubun().setValue(shikaku.get住所地特例者区分().get名称());

        IKobetsuJikoKaigoJukyu jukyu = jukyuDaichoFinder.get個別事項介護受給(検索キー.get識別コード(), shikaku.get処理日時().getDate());

        if (jukyu != null) {
            div.getTxtYokaigoJotaiKubun().setValue(new RString(jukyu.get要介護状態区分().name()));
            div.getTxtNinteiKaishiYmd().setValue(new RDate(jukyu.get認定有効開始日().toString()));
            div.getTxtNinteiShuryoYmd().setValue(new RDate(jukyu.get認定有効終了日().toString()));
        }
    }
}
