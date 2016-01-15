/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoshikakukihon;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.searchkey.KaigoShikakuKihonSearchKey;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護資格基本情報Divの操作を行うクラスです。
 *
 * @author N8156 宮本 康
 */
//TODO n8300姜　ビルドエラー回避のために暫定対応
//TODO n8178 城間篤人 IJukyoDaichoFinderが利用しているIKaigoHokenJukyoshaDacの具象クラスがインターフェースと同一パッケージに存在しないためエラーする。
//urを修正した後にコメントアウトを解除する 2015年2月
public class KaigoShikakuKihonHandler {

    private final KaigoShikakuKihonDiv div;
//    private final HihokenshaDaichoManager hihokenshaDaichoManager;
//    private final IJukyuDaichoFinder jukyuDaichoFinder;

    /**
     * コンストラクタです。
     *
     * @param div 介護資格基本情報Div
     */
    public KaigoShikakuKihonHandler(KaigoShikakuKihonDiv div) {
        this.div = div;
//        hihokenshaDaichoManager = new HihokenshaDaichoManager();
//        jukyuDaichoFinder = InstanceProvider.createWithCustomize(IJukyuDaichoFinder.class);
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param div 介護資格基本情報Div
     * @param hihokenshaDaichoManager 被保険者台帳Manager
     * @param jukyuDaichoFinder 受給者台帳Finder
     */
//    KaigoShikakuKihonHandler(KaigoShikakuKihonDiv div, HihokenshaDaichoManager hihokenshaDaichoManager, IJukyuDaichoFinder jukyuDaichoFinder) {
//        this.div = div;
//        this.hihokenshaDaichoManager = hihokenshaDaichoManager;
//        this.jukyuDaichoFinder = jukyuDaichoFinder;
//    }
    /**
     * 検索キーを元にデータを取得し、Divに設定します。
     *
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     */
    public void initialize(LasdecCode 市町村コード, ShikibetsuCode 識別コード) {

//        KaigoShikakuKihonSearchKey 検索キー = new KaigoShikakuKihonSearchKey.Builder(市町村コード, 識別コード).build();
//        Optional<HihokenshaDaichoModel> daicho = hihokenshaDaichoManager.get最新被保険者台帳(検索キー.get市町村コード(), 検索キー.get識別コード());
//        if (!daicho.isPresent()) {
//            return;
//        }

//        HihokenshaDaichoModel daichoModel = daicho.get();
        //TODO n2810久保　CheckStyle回避のために暫定対応
        div.getTxtHihokenshaNo().setValue(RString.EMPTY);
//        div.getTxtHihokenshaNo().setValue(daichoModel.get被保険者番号().value());
//        div.getTxtShutokuYmd().setValue(daichoModel.get資格取得年月日());
//        div.getTxtShutokuJiyu().setValue(daichoModel.get資格取得事由().getName());
//        div.getTxtSoshitsuYmd().setValue(daichoModel.get資格喪失年月日());
//        div.getTxtSoshitsuJiyu().setValue(daichoModel.get資格喪失事由().getName());
//        div.getTxtJutokuKubun().setValue(daichoModel.get住所地特例者区分().getName());
//        IKobetsuJikoKaigoJukyu jukyu = jukyuDaichoFinder.get個別事項介護受給(検索キー.get識別コード(), daichoModel.get処理日時().getColumnValue().getDate());
//
//        if (jukyu != null) {
//            div.getTxtYokaigoJotaiKubun().setValue(new RString(jukyu.get要介護状態区分().name()));
//            div.getTxtNinteiKaishiYmd().setValue(jukyu.get認定有効開始日());
//            div.getTxtNinteiShuryoYmd().setValue(jukyu.get認定有効終了日());
//        }
    }

    /**
     * 被保険者番号からデータを取得し、Divに設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    void initialize(HihokenshaNo 被保険者番号) {
    }

}
