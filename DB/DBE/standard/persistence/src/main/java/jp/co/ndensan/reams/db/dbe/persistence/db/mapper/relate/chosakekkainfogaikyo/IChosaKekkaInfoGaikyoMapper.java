/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.chosakekkainfogaikyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosakekkainfogaikyo.RembanServiceJokyoRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;

/**
 * 認定調査結果情報照会_概況調査のマッパーインタフェースです。
 *
 * @reamsid_L DBE-3000-260 lizhuoxuan
 */
public interface IChosaKekkaInfoGaikyoMapper {

    /**
     * 認定調査結果情報照会_概況調査のリストを取得します。
     *
     * @param 認定調査票_概況調査検索条件 認定調査票_概況調査検索条件
     * @return ChosaKekkaInfoGaikyoRelateEntity
     */
    List<ChosaKekkaInfoGaikyoRelateEntity> getChosaKekkaInfoGaikyoList1(ChosaKekkaInfoGaikyoParameter 認定調査票_概況調査検索条件);

    /**
     * 認定調査結果情報照会_概況調査のリストを取得します。
     *
     * @param 認定調査票_サービスの状況検索条件 認定調査票_サービスの状況検索条件
     * @return RembanServiceJokyoRelateEntity
     */
    List<RembanServiceJokyoRelateEntity> getChosaKekkaInfoGaikyoList2(ChosaKekkaInfoGaikyoParameter 認定調査票_サービスの状況検索条件);

    /**
     * 認定調査結果情報照会_概況調査のリストを取得します。
     *
     * @param 認定調査票_施設利用検索条件 認定調査票_施設利用検索条件
     * @return DbT5210NinteichosahyoShisetsuRiyoEntity
     */
    List<DbT5210NinteichosahyoShisetsuRiyoEntity> getChosaKekkaInfoGaikyoList3(ChosaKekkaInfoGaikyoParameter 認定調査票_施設利用検索条件);
}
