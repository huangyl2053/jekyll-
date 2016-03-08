/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.ninteichosaitakusakijoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosaitakusakijoho.JiKanKanRiParameter;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosaitakusakijoho.JiMuSyoParameter;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosaitakusakijoho.NinteichosaScheduleParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosaitakusakijoho.ChikuShichosonRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosaitakusakijoho.JiKanKanRiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosaitakusakijoho.JiMuSyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosaitakusakijoho.NinteichosaScheduleRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査スケジュール登録9のマッパーインタフェースです。
 */
public interface INinteichosaItakusakiJohoMapper {

    /**
     * 検索条件より、市町村リストを取得する。
     *
     * @param 調査地区コード RString
     * @return List<ChikuShichosonRelateEntity>
     */
    List<ChikuShichosonRelateEntity> select市町村リスト(RString 調査地区コード);

    /**
     * 調査員の場合、認定調査スケジュール情報を取得する。
     *
     * @param parameter NinteichosaScheduleParameter
     * @return List<NinteichosaScheduleRelateEntity>
     */
    List<NinteichosaScheduleRelateEntity> get調査員(NinteichosaScheduleParameter parameter);

    /**
     * 事務所の場合、認定調査スケジュール情報を取得する。
     *
     * @param parameter JiMuSyoParameter
     * @return List<JiMuSyoEntity>
     */
    List<JiMuSyoEntity> get事務所(JiMuSyoParameter parameter);

    /**
     * 時間管理の場合、認定調査スケジュール情報を取得する。
     *
     * @param parameter JiKanKanRiParameter
     * @return List<JiKanKanRiEntity>
     */
    List<JiKanKanRiEntity> get時間管理(JiKanKanRiParameter parameter);
}
