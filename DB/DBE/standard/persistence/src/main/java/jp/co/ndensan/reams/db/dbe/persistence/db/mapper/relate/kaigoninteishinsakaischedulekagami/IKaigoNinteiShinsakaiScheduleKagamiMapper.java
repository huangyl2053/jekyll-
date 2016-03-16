/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.kaigoninteishinsakaischedulekagami;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.kaigoninteishinsakaischedulekagami.KaigoNinteiShinsakaiScheduleKagamiMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.kaigoninteishinsakaischedulekagami.KaigoNinteiShinsakaiScheduleKagamiRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会スケジュール表かがみのマッパーインタフェースです。
 */
public interface IKaigoNinteiShinsakaiScheduleKagamiMapper {

    /**
     * 出力明細一覧データを取得します。
     *
     * @param param 介護認定審査会スケジュール表かがみのパラメータ
     * @return List<KaigoNinteiShinsakaiScheduleKagamiRelateEntity>
     */
    List<KaigoNinteiShinsakaiScheduleKagamiRelateEntity> get出力明細一覧(KaigoNinteiShinsakaiScheduleKagamiMybitisParamter param);

    /**
     * 主治医医療機関情報を取得。
     *
     * @param kikanCode 機関コード
     * @return 宛名機関名
     */
    RString get医療機関名称(RString kikanCode);

    /**
     * 認定調査委託先情報を取得。
     *
     * @param kikanCode 機関コード
     * @return 宛名機関名
     */
    RString get事業者名称(RString kikanCode);

    /**
     * その他機関情報を取得。
     *
     * @param kikanCode 機関コード
     * @return 宛名機関名
     */
    RString get機関名称(RString kikanCode);
}
