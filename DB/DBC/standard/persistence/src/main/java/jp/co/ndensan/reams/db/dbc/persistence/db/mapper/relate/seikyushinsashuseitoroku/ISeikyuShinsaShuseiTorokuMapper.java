/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.seikyushinsashuseitoroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.seikyushinsashuseitoroku.SeikyuShinsaShuseiTorokuMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.seikyushinsashuseitoroku.SeikyuShinsaShuseiTorokuRelateEntity;

/**
 * 住宅改修理由書作成手数料請求情報修正登録(審査結果登録)のクラスです。
 *
 * @reamsid_L DBC-2870-010 zhangruitao
 *
 */
public interface ISeikyuShinsaShuseiTorokuMapper {

    /**
     * 住宅改修理由書作成手数料請求情報を取得します。
     *
     * @param parameter SeikyuShinsaShuseiTorokuMapperParameter
     * @return List<SeikyuShinsaShuseiTorokuRelateEntity>
     */
    List<SeikyuShinsaShuseiTorokuRelateEntity> selectSeikyuShinsaShuseiTorokuList(SeikyuShinsaShuseiTorokuMapperParameter parameter);
}
