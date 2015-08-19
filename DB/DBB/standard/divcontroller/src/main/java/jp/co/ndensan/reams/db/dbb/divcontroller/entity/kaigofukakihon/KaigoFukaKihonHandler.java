/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.entity.kaigofukakihon;

import jp.co.ndensan.reams.db.dbb.business.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Fuka;
import jp.co.ndensan.reams.db.dbb.service.core.basic.FukaManager;
import jp.co.ndensan.reams.db.dbb.service.core.basic.HokenryoDankaiManager;
//import jp.co.ndensan.reams.db.dbb.service.core.relate.FukaManager;
//import jp.co.ndensan.reams.db.dbb.model.fuka.Fuka;
//import jp.co.ndensan.reams.db.dbb.realservice.FukaManager;
//import jp.co.ndensan.reams.db.dbb.realservice.HokenryoDankaiManager;
import jp.co.ndensan.reams.db.dbz.business.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
//import jp.co.ndensan.reams.db.dbz.realservice.HihokenshaDaichoManager;

/**
 * 介護賦課基本情報Divの操作を行うクラスです。
 *
 * @author N8156 宮本 康
 */
public class KaigoFukaKihonHandler {

    private final KaigoFukaKihonDiv div;
    private final HihokenshaDaichoManager hihokenshaDaichoManager;
    private final FukaManager fukaManager;
    private final HokenryoDankaiManager hokenryoDankaiManager;

    /**
     * コンストラクタです。
     *
     * @param div 介護賦課基本情報Div
     */
    public KaigoFukaKihonHandler(KaigoFukaKihonDiv div) {
        this.div = div;
        hihokenshaDaichoManager = new HihokenshaDaichoManager();
        fukaManager = new FukaManager();
        hokenryoDankaiManager = new HokenryoDankaiManager();
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param div 介護賦課基本情報Div
     * @param hihokenshaDaichoManager 被保険者台帳Manager
     * @param fukaManager 介護賦課Manager
     * @param hokenryoDankaiManager 保険料段階Manager
     */
    KaigoFukaKihonHandler(KaigoFukaKihonDiv div,
            HihokenshaDaichoManager hihokenshaDaichoManager, FukaManager fukaManager, HokenryoDankaiManager hokenryoDankaiManager) {
        this.div = div;
        this.hihokenshaDaichoManager = hihokenshaDaichoManager;
        this.fukaManager = fukaManager;
        this.hokenryoDankaiManager = hokenryoDankaiManager;
    }

    /**
     * 検索キーを元にデータを取得し、Divに設定します。
     *
     * @param searchKey 検索キー
     */
    public void load(KaigoFukaKihonSearchKey searchKey) {

        div.getTxtTsuchishoNo().setValue(searchKey.get通知書番号().value());

        //TODO n8187久保田 ビルドエラー回避のために暫定対応
//        Optional<Fuka> fuka = fukaManager.get最新介護賦課(searchKey.get賦課年度(), searchKey.get通知書番号());
//        if (fuka.isPresent()) {
//            // FlexibleYear 賦課年度, LasdecCode 市町村コード, RString 段階区分
//            Optional<HokenryoDankai> dankai = hokenryoDankaiManager.get保険料段階(searchKey.get賦課年度(), searchKey.get市町村コード(), fuka.get().get保険料段階());
//            if (dankai.isPresent()) {
//                div.getTxtHokenryoDankai().setValue(dankai.get().edit表示用保険料段階());
//            }
//        }
//
        //TODO n8300姜 ビルドエラー回避のために暫定対応
//        Optional<HihokenshaDaichoModel> daicho = hihokenshaDaichoManager.get保険料段階一覧(searchKey.get市町村コード(), searchKey.get識別コード());
//        if (daicho.isPresent()) {
//            HihokenshaDaichoModel daichoModel = daicho.get();
//            div.getTxtHihokenshaNo().setValue(daichoModel.get被保険者番号().value());
//            div.getTxtShutokuYmd().setValue(daichoModel.get資格取得年月日());
//            div.getTxtShutokuJiyu().setValue(daichoModel.get資格取得事由().getName());
//            div.getTxtSoshitsuYmd().setValue(daichoModel.get資格喪失年月日());
//            div.getTxtSoshitsuJiyu().setValue(daichoModel.get資格喪失事由().getName());
//        }
    }
}
