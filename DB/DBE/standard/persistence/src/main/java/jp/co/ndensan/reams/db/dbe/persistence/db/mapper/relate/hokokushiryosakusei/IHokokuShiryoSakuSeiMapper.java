package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hokokushiryosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hokokushiryosakusei.JigyoJyokyoHokokuMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hokokushiryosakusei.JisshiJokyoTokeiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hokokushiryosakusei.ShinsahanteinoHenkojokyoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hokokushiryosakusei.SinsakaiHanteiJyokyoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.JigyoJyokyoHokokuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.JigyoJyokyoHokokuHeaderEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.JisshiJokyoTokeiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.ShinsakaishukeihyoHanteiBetsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.SinsakaiHanteiJyokyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.SinsakaiHanteiJyokyoHeaderEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5591GogitaiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 報告資料発行のMapperクラスです。
 *
 * @reamsid_L DBE-1450-010 wangxiaodong
 */
public interface IHokokuShiryoSakuSeiMapper {

    /**
     * 要介護認定事業状況報告を取得します。
     *
     * @param parameter JisshiJokyoTokeiMyBatisParameter
     * @return List<JisshiJokyoTokeiEntity>
     */
    List<JisshiJokyoTokeiEntity> getJisshiJokyoTokei(JisshiJokyoTokeiMyBatisParameter parameter);

    /**
     * 要介護認定事業状況報告を取得します。
     *
     * @return List<JigyoJyokyoHokokuEntity>
     */
    List<JigyoJyokyoHokokuEntity> getJigyoJyokyoHokoku();

    /**
     * 要介護認定事業状況報告のheaderを取得します。
     *
     * @param parameter JigyoJyokyoHokokuMyBatisParameter
     * @return List<JigyoJyokyoHokokuHeaderEntity>
     */
    List<JigyoJyokyoHokokuHeaderEntity> getJigyoJyokyoHokokuHeader(JigyoJyokyoHokokuMyBatisParameter parameter);

    /**
     * システム日付で合議体番号を取得します。
     *
     * @param systemDate FlexibleDate
     * @return DbT5591GogitaiJohoEntity
     */
    List<DbT5591GogitaiJohoEntity> getGogitaiNo(FlexibleDate systemDate);

    /**
     * 介護認定審査会判定状況のヘッダ情報リストを取得します。
     *
     * @param parameter 介護認定審査会判定状況MyBatisParameter
     * @return SinsakaiHanteiJyokyoHeaderEntityリスト
     */
    List<SinsakaiHanteiJyokyoHeaderEntity> getSinsakaiHanteiJyokyoHeader(SinsakaiHanteiJyokyoMyBatisParameter parameter);

    /**
     * 介護認定審査会判定状況の情報リストを取得します。
     *
     * @param parameter 介護認定審査会判定状況MyBatisParameter
     * @return SinsakaiHanteiJyokyoEntityリスト
     */
    List<SinsakaiHanteiJyokyoEntity> getSinsakaiHanteiJyokyo(SinsakaiHanteiJyokyoMyBatisParameter parameter);

    /**
     * 介護認定審査会判定状況のヘッダ情報リストを取得します。
     *
     * @param parameter 介護認定審査会判定状況MyBatisParameter
     * @return SinsakaiHanteiJyokyoHeaderEntityリスト
     */
    List<SinsakaiHanteiJyokyoHeaderEntity> getJotaikubumbetsuhanteiHeader(SinsakaiHanteiJyokyoMyBatisParameter parameter);

    /**
     * 審査判定の変更状況ヘッダ情報リストを取得します。
     *
     * @param parameter ShinsahanteinoHenkojokyoMyBatisParameter
     * @return SinsakaiHanteiJyokyoHeaderEntityリスト
     */
    List<SinsakaiHanteiJyokyoHeaderEntity> getShinsahanteinoHenkojokyoHeader(ShinsahanteinoHenkojokyoMyBatisParameter parameter);

    /**
     * 審査判定の変更状況情報リストを取得します。
     *
     * @param parameter ShinsahanteinoHenkojokyoMyBatisParameter
     * @return SinsakaiHanteiJyokyoEntityリスト
     */
    List<SinsakaiHanteiJyokyoEntity> getShinsahanteinoHenkojokyo(ShinsahanteinoHenkojokyoMyBatisParameter parameter);

    /**
     * 審査判定の変更状況情報リストを取得します。
     *
     * @param parameter ShinsahanteinoHenkojokyoMyBatisParameter
     * @return SinsakaiHanteiJyokyoEntityリスト
     */
    List<SinsakaiHanteiJyokyoEntity> getShinsahanteinoHenkojokyoYukoKikanEntyo(ShinsahanteinoHenkojokyoMyBatisParameter parameter);

    /**
     * 介護認定審査会集計表（判定別）情報リストを取得します。
     *
     * @param parameter ShinsahanteinoHenkojokyoMyBatisParameter
     * @return SinsakaiHanteiJyokyoHeaderEntityリスト
     */
    List<SinsakaiHanteiJyokyoHeaderEntity> getShinsakaishukeihyoHanteiBetsuHeader(ShinsahanteinoHenkojokyoMyBatisParameter parameter);

    /**
     * 審査判定の変更状況情報リストを取得します。
     *
     * @param parameter ShinsahanteinoHenkojokyoMyBatisParameter
     * @return ShinsakaishukeihyoHanteiBetsuEntity
     */
    List<ShinsakaishukeihyoHanteiBetsuEntity> getShinsakaishukeihyoHanteiBetsu(SinsakaiHanteiJyokyoMyBatisParameter parameter);

}
