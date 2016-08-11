/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyuIdoKeikakuRirekiList;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.keikakurirekiichiran.KeikakuRireki;
import jp.co.ndensan.reams.db.dbc.service.core.keikakurirekiichiran.KeikakuRirekiIchiran;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * 画面設計_DBCKD00002_計画履歴一覧です。
 *
 * @reamsid_L DBC-4350-020 liuxiaoyu
 */
public class JukyuIdoKeikakuRirekiListHandler {

    private final JukyuIdoKeikakuRirekiListDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     */
    public JukyuIdoKeikakuRirekiListHandler(JukyuIdoKeikakuRirekiListDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     *
     * @return JukyuIdoKeikakuRirekiListHandler
     */
    public static JukyuIdoKeikakuRirekiListHandler of(JukyuIdoKeikakuRirekiListDiv div) {
        return new JukyuIdoKeikakuRirekiListHandler(div);
    }

    /**
     * 計画履歴一覧情報画面のonLoadンメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     */
    public void onLoad(HihokenshaNo 被保険者番号) {

        dgKyotakuKeikaku_Row dgRow;
        List<dgKyotakuKeikaku_Row> rowList = new ArrayList<>();
        List<KeikakuRireki> list = KeikakuRirekiIchiran.createInstance()
                .getKeikakuRirekiIchiranJoho(被保険者番号);
        if (list != null && !list.isEmpty()) {
            for (KeikakuRireki keikakurireki : list) {
                dgRow = new dgKyotakuKeikaku_Row();
                dgRow.setZanteiKubun(keikakurireki.get暫定状態());
                dgRow.getTekiyoKaishiYMD().setValue(keikakurireki.get適用開始日());
                dgRow.getTekiyoShuryoYMD().setValue(keikakurireki.get適用終了日());
                if (keikakurireki.get計画事業者名称() != null) {
                    dgRow.setKeikakuJigyoshaName(keikakurireki.get計画事業者名称().value());
                }
                if (keikakurireki.get委託先事業者番号() != null) {
                    dgRow.setItakusakiJigyoshaNo(keikakurireki.get委託先事業者番号().value());
                }
                if (keikakurireki.get委託先事業者名称() != null) {
                    dgRow.setItakusakiJigyoshaName(keikakurireki.get委託先事業者名称().value());
                }
                rowList.add(dgRow);
            }
        }
        div.getPnlKyotakuKeikaku().getDgKyotakuKeikaku().setDataSource(rowList);
    }

}
