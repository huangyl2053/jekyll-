/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0220011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyodojukyushataishosha.KyodoJukyushaTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.business.core.taishoshakensaku.TaishoshaKensakuResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220011.JukyushaIdoRenrakuhyoHenkoMainPanelDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBCMN81002_受給者訂正連絡票登録（対象者検索）
 *
 * @reamsid_L DBC-2101-010 quxiaodong
 */
public class JukyushaIdoRenrakuhyoHenkoMainPanelHandler {

    private final JukyushaIdoRenrakuhyoHenkoMainPanelDiv div;
    private static final RString 受給者異動連絡票変更登録 = new RString("DBCMN81002");
    private static final RString 受給者異動_訂正連絡票発行 = new RString("DBCMN83001");
    private static final RString 受給者異動連絡票情報照会 = new RString("DBCMN11007");
    private static final RString 修正モード = new RString("修正");
    private static final RString 選択モード = new RString("選択");

    /**
     * 初期化です。
     *
     * @param div JukyushaIdoRenrakuhyoHenkoMainPanelDiv
     */
    public JukyushaIdoRenrakuhyoHenkoMainPanelHandler(JukyushaIdoRenrakuhyoHenkoMainPanelDiv div) {
        this.div = div;
    }

    /**
     * 検索処理です。
     *
     * @param メニューID RString
     * @param 異動日From FlexibleDate
     * @param 異動日To FlexibleDate
     * @param 被保険者番号 HihokenshaNo
     * @param 異動対象者一覧情報 List<TaishoshaKensakuResult>
     */
    public void initialize対象者一覧(RString メニューID, FlexibleDate 異動日From, FlexibleDate 異動日To,
            HihokenshaNo 被保険者番号, List<TaishoshaKensakuResult> 異動対象者一覧情報) {
        RString 表示モード = RString.EMPTY;
        if (受給者異動連絡票変更登録.equals(メニューID)) {
            表示モード = 修正モード;

        } else if (受給者異動_訂正連絡票発行.equals(メニューID) || 受給者異動連絡票情報照会.equals(メニューID)) {
            表示モード = 選択モード;
        }
        List<KyodoJukyushaTaishoshaEntity> 対象者一覧list = new ArrayList<>();
        for (TaishoshaKensakuResult result : 異動対象者一覧情報) {
            KyodoJukyushaTaishoshaEntity entity = new KyodoJukyushaTaishoshaEntity();
            entity.set異動日(result.get対象者一覧情報Entity().get異動年月日());
            entity.set対象年月(result.get対象者一覧情報Entity().get送付年月());
            entity.set被保番号(result.get対象者一覧情報Entity().get被保険者番号());
            entity.set被保険者氏名(result.get対象者一覧情報Entity().get被保険者氏名カナ());
            entity.set履歴番号(result.get対象者一覧情報Entity().get履歴番号());
            entity.set論理削除フラグ(result.get対象者一覧情報Entity().is論理削除フラグ());
            対象者一覧list.add(entity);
        }
        if (div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getChkIsSearchDeletedData().isAllSelected()) {
            RString 削除データ = new RString(Boolean.TRUE.toString());
            div.getJukyushaIdoRenrakuhyoHenkoSearchResultListPanel().getCommonChildDiv().initialize(メニューID,
                    被保険者番号, 異動日From, 異動日To, 表示モード, 削除データ, 対象者一覧list);
        } else {
            RString 削除データ = new RString(Boolean.FALSE.toString());
            div.getJukyushaIdoRenrakuhyoHenkoSearchResultListPanel().getCommonChildDiv().initialize(メニューID,
                    被保険者番号, 異動日From, 異動日To, 表示モード, 削除データ, 対象者一覧list);
        }
    }

    /**
     * クリア条件です。
     */
    public void clearSearchCondition() {
        div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getTxtIdoDateRange().clearFromValue();
        div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getTxtIdoDateRange().clearToValue();
        div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().getTxtSearchHihoNo().clearValue();
        List<RString> list = new ArrayList<>();
        div.getJukyushaIdoRenrakuhyoHenkoSearchConditionPanel().
                getChkIsSearchDeletedData().setSelectedItemsByKey(list);
    }
}
