/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.yokaigoninteishinseijyohokensaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigonintei.YouKaiGoNinTeiShinJyuKyuParameter;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigonintei.YouKaiGoNinTeiShinNiTeiParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;

/**
 *
 * 要介護認定申請情報検索Mapperクラスです。
 *
 * @reamsid_L DBZ-1300-150 houtianpeng
 */
public interface IYoKaiGoNinTeiShinSeiJyoHoKenSaKuMapper {

    /**
     * 介護認定申請情報認定の取得処理です。
     *
     * @param parameter 介護認定申請情報認定パラメータ。
     * @return DbT5101NinteiShinseiJohoEntity 介護認定申請情報認定
     */
    List<DbT5101NinteiShinseiJohoEntity> get介護認定申請情報認定(YouKaiGoNinTeiShinNiTeiParameter parameter);

    /**
     * 介護認定申請情報受給を取得します。
     *
     * @param parameter 介護認定申請情報受給パラメータ
     * @return DbT4101NinteiShinseiJohoEntity
     */
    List<DbT4101NinteiShinseiJohoEntity> get介護認定申請情報受給(YouKaiGoNinTeiShinJyuKyuParameter parameter);
}
