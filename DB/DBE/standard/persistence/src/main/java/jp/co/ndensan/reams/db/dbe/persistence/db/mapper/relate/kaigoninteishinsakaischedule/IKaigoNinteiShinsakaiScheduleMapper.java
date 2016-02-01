/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.kaigoninteishinsakaischedule;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.kaigoninteishinsakaischedule.KaigoNinteiShinsakaiScheduleMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.kaigoninteishinsakaischedule.KaigoNinteiShinsakaiScheduleRelateEntity;

/**
 * 介護認定審査会スケジュール表のマッパーインタフェースです。
 */
public interface IKaigoNinteiShinsakaiScheduleMapper {

    /**
     * 出力明細一覧データを取得します。
     *
     * @param param 介護認定審査会スケジュール表のパラメータ
     * @return List<KaigoNinteiShinsakaiScheduleRelateEntity>
     */
    List<KaigoNinteiShinsakaiScheduleRelateEntity> get出力明細一覧(KaigoNinteiShinsakaiScheduleMybitisParamter param);
}
