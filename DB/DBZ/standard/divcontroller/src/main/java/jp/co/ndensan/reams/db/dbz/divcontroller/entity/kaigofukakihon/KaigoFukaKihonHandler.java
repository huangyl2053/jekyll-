/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigofukakihon;

import jp.co.ndensan.reams.db.dbz.business.HokenryoDankai;
import jp.co.ndensan.reams.db.dbz.business.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.business.searchkey.KaigoFukaKihonSearchKeyBuilder;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.model.FukaModel;
import jp.co.ndensan.reams.db.dbz.model.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.realservice.FukaManager;
import jp.co.ndensan.reams.db.dbz.realservice.HihokenshaDaichoManager;
import jp.co.ndensan.reams.db.dbz.realservice.HokenryoDankaiManager;
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
     * @param 通知書番号 通知書番号
     * @param 賦課年度 賦課年度
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     */
    public void load(TsuchishoNo 通知書番号, FlexibleYear 賦課年度, LasdecCode 市町村コード, ShikibetsuCode 識別コード) {

        div.getTxtTsuchishoNo().setValue(通知書番号.value());

        IOptional<FukaModel> fuka = fukaManager.get最新介護賦課(賦課年度, 通知書番号);
        if (fuka.isPresent()) {
            IOptional<HokenryoDankai> dankai = hokenryoDankaiManager.get保険料段階(賦課年度, 市町村コード, fuka.get().get保険料段階());
            if (dankai.isPresent()) {
                div.getTxtHokenryoDankai().setValue(dankai.get().edit表示用保険料段階());
            }
        }

        KaigoFukaKihonSearchKey 検索キー = new KaigoFukaKihonSearchKeyBuilder(通知書番号, 賦課年度, 市町村コード, 識別コード).build();
        IOptional<HihokenshaDaichoModel> daicho = hihokenshaDaichoManager.get最新被保険者台帳(検索キー.get市町村コード(), 検索キー.get識別コード());

        if (daicho.isPresent()) {
            HihokenshaDaichoModel daichoModel = daicho.get();
            div.getTxtHihokenshaNo().setValue(daichoModel.get被保険者番号().value());
            div.getTxtShutokuYmd().setValue(new RDate(daichoModel.get資格取得年月日().toString()));
            div.getTxtShutokuJiyu().setValue(daichoModel.get資格取得事由().getName());
            div.getTxtSoshitsuYmd().setValue(new RDate(daichoModel.get資格喪失年月日().toString()));
            div.getTxtSoshitsuJiyu().setValue(daichoModel.get資格喪失事由().getName());
        }
    }
}
