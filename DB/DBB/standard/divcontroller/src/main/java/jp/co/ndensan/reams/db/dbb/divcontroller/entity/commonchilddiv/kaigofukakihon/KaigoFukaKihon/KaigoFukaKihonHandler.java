/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigofukakihon.KaigoFukaKihon;

import jp.co.ndensan.reams.db.dbb.business.HokenryoDankaiUtil;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Fuka;
import jp.co.ndensan.reams.db.dbb.business.core.basic.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.service.core.FukaMiscManager;
import jp.co.ndensan.reams.db.dbb.service.core.basic.HokenryoDankaiManager;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;

/**
 * 介護賦課基本情報Divの操作を行うクラスです。
 *
 * @author N8156 宮本 康
 */
public class KaigoFukaKihonHandler {

    private final KaigoFukaKihonDiv div;
    private final HihokenshaDaichoManager hihokenshaDaichoManager;
    private final FukaMiscManager fukaMiscManager;
    private final HokenryoDankaiManager hokenryoDankaiManager;

    /**
     * コンストラクタです。
     *
     * @param div 介護賦課基本情報Div
     */
    public KaigoFukaKihonHandler(KaigoFukaKihonDiv div) {
        this.div = div;
        hihokenshaDaichoManager = new HihokenshaDaichoManager();
        fukaMiscManager = new FukaMiscManager();
        hokenryoDankaiManager = new HokenryoDankaiManager();
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param div 介護賦課基本情報Div
     * @param hihokenshaDaichoManager 被保険者台帳Manager
     * @param fukaMiscManager 介護賦課Manager
     * @param hokenryoDankaiManager 保険料段階Manager
     */
    public KaigoFukaKihonHandler(KaigoFukaKihonDiv div,
            HihokenshaDaichoManager hihokenshaDaichoManager, FukaMiscManager fukaMiscManager, HokenryoDankaiManager hokenryoDankaiManager) {
        this.div = div;
        this.hihokenshaDaichoManager = hihokenshaDaichoManager;
        this.fukaMiscManager = fukaMiscManager;
        this.hokenryoDankaiManager = hokenryoDankaiManager;
    }

    /**
     * 検索キーを元にデータを取得し、Divに設定します。
     *
     * @param searchKey 検索キー
     */
    public void load(KaigoFukaKihonSearchKey searchKey) {

        div.getTxtTsuchishoNo().setValue(searchKey.get通知書番号().value());

        Optional<Fuka> fuka = fukaMiscManager.get最新介護賦課(searchKey.get賦課年度(), searchKey.get通知書番号());
        if (fuka.isPresent()) {
            Optional<HokenryoDankai> dankai = hokenryoDankaiManager.get保険料段階(searchKey.get賦課年度(), fuka.get().get保険料段階());
            if (dankai.isPresent()) {
                div.getTxtHokenryoDankai().setValue(HokenryoDankaiUtil.edit表示用保険料段階(dankai.get()));
            }
        }

        Optional<HihokenshaDaicho> daicho = Optional.ofNullable(hihokenshaDaichoManager.get最新被保険者台帳(searchKey.get市町村コード(), searchKey.get識別コード()));
        if (daicho.isPresent()) {
            HihokenshaDaicho daichoModel = daicho.get();
            div.getTxtHihokenshaNo().setValue(daichoModel.get被保険者番号().value());
            div.getTxtShutokuYmd().setValue(daichoModel.get資格取得年月日());
            div.getTxtShutokuJiyu().setValue(daichoModel.get資格取得事由コード());
            div.getTxtSoshitsuYmd().setValue(daichoModel.get資格喪失年月日());
            div.getTxtSoshitsuJiyu().setValue(daichoModel.get資格喪失事由コード());
        }
    }
}
