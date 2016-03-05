/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.shinsakaijohokojin;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.param.shinsakaijohokojin.ShinsakaiJohoKojinMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shinsakaijohokojin.KaisaiKekkaAndBashoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shinsakaijohokojin.WariateIinAndIinJohoEntity;

/**
 *
 * 審査会情報照会(個人)のMapperクラスです。
 */
public interface IShinsakaiJohoKojinMapper {

    /**
     * 開催結果情報と開催場所情報を取得します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return KaisaiKekkaAndBashoJohoEntity
     */
    KaisaiKekkaAndBashoJohoEntity getKaisaikekkaandbashojoho(ShinseishoKanriNo 申請書管理番号);

    /**
     * 審査会委員情報を取得します。
     *
     * @param parameter ShinsakaiJohoKojinMapperParameter
     * @return List<WariateIinAndIinJohoEntity>
     */
    List<WariateIinAndIinJohoEntity> getShinsakaijyouhou(ShinsakaiJohoKojinMapperParameter parameter);

    /**
     * 補欠会委員情報を取得します。
     *
     * @param parameter ShinsakaiJohoKojinMapperParameter
     * @return List<WariateIinAndIinJohoEntity>
     */
    List<WariateIinAndIinJohoEntity> getHoketsukaijyouhou(ShinsakaiJohoKojinMapperParameter parameter);

}
