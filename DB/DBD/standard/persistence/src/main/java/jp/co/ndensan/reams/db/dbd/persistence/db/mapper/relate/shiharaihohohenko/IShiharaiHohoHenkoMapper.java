/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohohenko;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.shiharaihohohenko.ShiharaiHohoHenkoMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenko.JukyushaSogoJigyoTaishoshaHantei;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenko.ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenko.ShokanHaraiShikyuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import org.apache.ibatis.annotations.Param;

/**
 * 支払方法変更管理（画面）のマッパーインタフェースです。
 *
 * @reamsid_L DBD-3620-070 liangbc
 */
public interface IShiharaiHohoHenkoMapper {

    /**
     * 支払方法変更管理情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 支払方法変更管理情報List
     */
    List<ShiharaiHohoHenkoEntity> findShiharaiHohoHenko(HihokenshaNo 被保険者番号);

    /**
     * 支払方法変更管理情報を取得します。（論理削除フラグを問わず）
     *
     * @param 被保険者番号 被保険者番号
     * @return 支払方法変更管理情報List
     */
    List<ShiharaiHohoHenkoEntity> findShiharaiHohoHenkoIgnoreDelete(HihokenshaNo 被保険者番号);

    /**
     * 償還払支給申請情報の取得
     *
     * @param 被保険者番号 被保険者番号
     * @return 償還払支給申請
     */
    List<ShokanHaraiShikyuEntity> find償還払支給申請(HihokenshaNo 被保険者番号);

    /**
     * 受給者or事業対象者の判定結果を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 基準日 基準日
     * @return 判定結果
     */
    JukyushaSogoJigyoTaishoshaHantei get受給者or事業対象者の判定(@Param("被保険者番号") HihokenshaNo 被保険者番号, @Param("基準日") FlexibleDate 基準日);

    /**
     * 支払方法変更情報をキー検索で１件取得します。
     *
     * @param 支払方法変更検索条件 支払方法変更検索条件
     * @return ShiharaiHohoHenkoEntity
     */
    ShiharaiHohoHenkoEntity select支払方法変更ByKey(ShiharaiHohoHenkoMapperParameter 支払方法変更検索条件);
}
