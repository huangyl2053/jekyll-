/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinseikensaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinseikensaku.ShinseiKensakuMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseikensaku.ShinseiKensakuRelateEntity;

/**
 * 要介護認定申請検索のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1370-010 sunhaidi
 */
public interface IShinseiKensakuMapper {

    /**
     * 認定申請情報の取得処理です。
     *
     * @param parameter パラメータ
     * @return 認定申請情報
     */
    List<ShinseiKensakuRelateEntity> selectShinseiJoho(ShinseiKensakuMapperParameter parameter);

    /**
     * 指定条件による認定申請情報の該当件数を返します。
     *
     * @param parameter パラメータ
     * @return 認定申請情報の件数
     */
    int countShinseiJoho(ShinseiKensakuMapperParameter parameter);
}
