/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.yokaigoninteijoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijoho.YokaigoNinteiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.apache.ibatis.annotations.Param;

/**
 * 介護認定処理情報の処理します。
 *
 * @reamsid_L DBD-1530-010 lit
 */
public interface IYokaigoNinteiJohoMapper {

    /**
     * 今回認定情報の取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定広域フラグ 認定広域フラグ
     * @return 今回認定情報 List<YokaigoNinteiJohoEntity>
     */
    List<YokaigoNinteiJohoEntity> get今回認定情報(@Param("申請書管理番号") RString 申請書管理番号, @Param("認定広域フラグ") boolean 認定広域フラグ);

    /**
     * 前回認定情報の取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 前回認定情報 List<YokaigoNinteiJohoEntity>
     */
    List<YokaigoNinteiJohoEntity> get前回認定情報(@Param("申請書管理番号") RString 申請書管理番号);

    /**
     * Max履歴番号の取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return Max履歴番号 RString
     */
    RString getMax履歴番号(@Param("申請書管理番号") RString 申請書管理番号);

    /**
     * 認定情報受給の取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 認定情報受給 List<YokaigoNinteiJohoEntity>
     */
    List<YokaigoNinteiJohoEntity> get認定情報受給(@Param("被保険者番号") RString 被保険者番号);

    /**
     * 認定情報認定の取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 認定情報認定 List<YokaigoNinteiJohoEntity>
     */
    List<YokaigoNinteiJohoEntity> get認定情報認定(@Param("被保険者番号") RString 被保険者番号);
}
