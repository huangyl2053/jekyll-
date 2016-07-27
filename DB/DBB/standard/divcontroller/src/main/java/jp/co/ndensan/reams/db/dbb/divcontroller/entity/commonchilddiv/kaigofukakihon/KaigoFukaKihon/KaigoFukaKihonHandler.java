/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigofukakihon.KaigoFukaKihon;

import jp.co.ndensan.reams.db.dbb.business.util.HokenryoDankaiUtil;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Fuka;
import jp.co.ndensan.reams.db.dbb.business.core.basic.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.service.core.FukaMiscManager;
import jp.co.ndensan.reams.db.dbb.service.core.basic.HokenryoDankaiManager;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMasterNoOption;

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
    private static final RString 照会モード = new RString("shokai");

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
        div.setMode(照会モード);
        if (searchKey.get賦課年度() == null || searchKey.get通知書番号() == null
            || searchKey.get賦課年度().isEmpty() || searchKey.get通知書番号().isEmpty()) {
            div.getBtnHihoRireki().setDisabled(true);
        } else {
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
                div.getTxtShutokuJiyu().setValue(CodeMasterNoOption.getCodeRyakusho(
                        SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格取得事由_被保険者.getCodeShubetsu(), new Code(daichoModel.get資格取得事由コード())));
                div.getTxtSoshitsuYmd().setValue(daichoModel.get資格喪失年月日());
                if (daichoModel.get資格喪失事由コード() != null && !daichoModel.get資格喪失事由コード().isEmpty()) {
                    div.getTxtSoshitsuJiyu().setValue(CodeMasterNoOption.getCodeRyakusho(
                            SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格喪失事由_被保険者.getCodeShubetsu(), new Code(daichoModel.get資格喪失事由コード())));
                }
            }
        }
    }
}
