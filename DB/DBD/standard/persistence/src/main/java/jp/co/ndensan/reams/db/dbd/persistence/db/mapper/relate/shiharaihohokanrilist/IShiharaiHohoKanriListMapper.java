/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohokanrilist;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.shiharaihohokanrilist.ShiharaiHohoKanriListMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist.HenkouJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import org.apache.ibatis.annotations.Param;

/**
 * 支払方法変更管理リスト作成用のMapperです。
 *
 * @reamsid_L DBD-3630-010 liangbc
 */
public interface IShiharaiHohoKanriListMapper {

    /**
     * 対象者情報の取得
     *
     * @param param パラメータ
     * @return 対象者情報
     */
    HihokenshaNo selectTaishoshaJoho(ShiharaiHohoKanriListMapperParameter param);

    /**
     * 変更情報の取得
     *
     * @param rDate基準日 基準日
     * @param flexibleDate基準日 基準日
     * @return 変更情報
     */
    HenkouJohoEntity selectHenkouJoho(@Param("rDate基準日") RDate rDate基準日, @Param("flexibleDate基準日") FlexibleDate flexibleDate基準日);
}
