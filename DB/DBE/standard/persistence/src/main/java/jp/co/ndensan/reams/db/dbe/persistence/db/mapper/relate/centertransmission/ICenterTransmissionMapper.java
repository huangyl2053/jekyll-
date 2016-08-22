/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.centertransmission;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.centertransmission.CenterTransmissionMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.CenterTransmissionEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.ZenkaiChosaItemEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.ZenkaiServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5129TennyuShiboEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;

/**
 * センター送信データ作成のMapperクラスです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
public interface ICenterTransmissionMapper {

    /**
     * バッチパラメータ.二次判定日によって、転入・死亡情報から申請書管理番号を取得します。
     *
     * @param paramter CenterTransmissionMybitisParamter
     * @return List<DbT5129TennyuShiboEntity>
     */
    List<DbT5129TennyuShiboEntity> getShinseishoKanriNoByTennyuShibo(CenterTransmissionMybitisParamter paramter);

    /**
     * 調査票（概況調査）サービスの状況を取得します。
     *
     * @param paramter CenterTransmissionMybitisParamter
     * @return List<DbT5207NinteichosahyoServiceJokyoEntity>
     */
    List<DbT5207NinteichosahyoServiceJokyoEntity> getNinteichosahyoServiceJokyo(CenterTransmissionMybitisParamter paramter);

    /**
     * 認定調査票（基本調査）調査項目を取得します。
     *
     * @param paramter CenterTransmissionMybitisParamter
     * @return List<DbT5211NinteichosahyoChosaItemEntity>
     */
    List<DbT5211NinteichosahyoChosaItemEntity> getNinteichosahyoChosaItem(CenterTransmissionMybitisParamter paramter);

    /**
     * 要介護認定主治医意見書意見項目を取得します。
     *
     * @param paramter CenterTransmissionMybitisParamter
     * @return List<DbT5304ShujiiIkenshoIkenItemEntity>
     */
    List<DbT5304ShujiiIkenshoIkenItemEntity> getShujiiIkenshoIkenItem(CenterTransmissionMybitisParamter paramter);

    /**
     * 前回調査票（概況調査）サービスの状況を取得します。
     *
     * @param paramter CenterTransmissionMybitisParamter
     * @return List<ZenkaiServiceJokyoEntity>
     */
    List<ZenkaiServiceJokyoEntity> getZenkaiNinteichosahyoServiceJokyo(CenterTransmissionMybitisParamter paramter);

    /**
     * 前回認定調査票（基本調査）調査項目を取得します。
     *
     * @param paramter CenterTransmissionMybitisParamter
     * @return List<ZenkaiChosaItemEntity>
     */
    List<ZenkaiChosaItemEntity> getZenkaiNinteichosahyoChosaItem(CenterTransmissionMybitisParamter paramter);

    /**
     * センター送信データを取得します。
     *
     * @param paramter CenterTransmissionMybitisParamter
     * @return List<CenterTransmissionEntity>
     */
    List<CenterTransmissionEntity> getCenterTransmissionData(CenterTransmissionMybitisParamter paramter);
}
