/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0240011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.jukyusyaidoujohorirek.JukyusyaIdouJohoRirekEntity;
import jp.co.ndensan.reams.db.dbc.business.core.kyodojukyushataishosha.KyodoJukyushaTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0240011.KyoutsuIdoReanrakuhyoEraTeiseiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0240011.dgIdoReanrakuhyoEraTeisei_Row;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 共同処理用受給者異動連絡票エラー訂正のハンドラクラスです。
 *
 * @reamsid_L DBC-2850-010 chenxiangyu
 */
public class KyoutsuIdoReanrakuhyoEraTeiseiHandler {

    private final KyoutsuIdoReanrakuhyoEraTeiseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public KyoutsuIdoReanrakuhyoEraTeiseiHandler(KyoutsuIdoReanrakuhyoEraTeiseiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化します。
     *
     * @param entityList 履歴訂正のCSVEntity
     */
    public void onLoad(List<JukyusyaIdouJohoRirekEntity> entityList) {
        List<dgIdoReanrakuhyoEraTeisei_Row> rowList = new ArrayList<>();
        for (JukyusyaIdouJohoRirekEntity entity : entityList) {
            dgIdoReanrakuhyoEraTeisei_Row row = new dgIdoReanrakuhyoEraTeisei_Row();
            if (entity.get異動日() != null) {
                row.getTxtIdobi().setValue(new RDate(
                        entity.get異動日().getYearValue(),
                        entity.get異動日().getMonthValue(),
                        entity.get異動日().getDayValue()));
            }
            if (entity.get被保番号() != null) {
                row.setTxtHihoBango(entity.get被保番号().value());
            }
            row.setTxtHihokenshaShimei(entity.getかな氏名());
            row.setTxtKomoku(entity.get項目());
            rowList.add(row);
        }
        div.getDgIdoReanrakuhyoEraTeisei().setDataSource(rowList);
    }

    /**
     * 一覧検索キーEntityを取得します。
     *
     * @return 一覧検索キーEntity
     */
    public KyodoJukyushaTaishoshaEntity get一覧検索キー() {
        KyodoJukyushaTaishoshaEntity entity = new KyodoJukyushaTaishoshaEntity();
        return entity;
    }
}
