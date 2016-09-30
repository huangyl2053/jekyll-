/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.toushoshotokujohochushutsurenkei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigoshoto.KaigoShotoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigoshoto.ShotokuJohoIchiranKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.toushoshotokujohochushutsurenkei.DbTShotokuJohoToShotokuKanriEntity;

/**
 * 所得情報抽出・連携バッチのmapperです。
 *
 * @reamsid_L DBB-1690-060 gongliang
 */
public interface IToushoShotokuJohoChushutsuRenkeiMapper {

    /**
     * 所得情報を抽出する。
     *
     * @return 所得情報 List<DbTShotokuJohoTempTableEntity>
     */
    List<DbTShotokuJohoToShotokuKanriEntity> get所得情報と介護所得管理();

    /**
     * 介護所得Tempを抽出する。
     *
     * @return 介護所得Tempの全部データ List<KaigoShotoTempTableEntity>
     */
    List<KaigoShotoTempTableEntity> get介護所得Temp();

    /**
     * 出力対象データを抽出する。
     *
     * @return 出力対象データ List<ShotokuJohoIchiranKozaEntity>
     */
    List<ShotokuJohoIchiranKozaEntity> get出力対象データ();
}
