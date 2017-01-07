/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.shinseikensaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.shinseikensaku.ShinseiKensakuMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shinseikensaku.ShinseiKensakuRelateEntity;

/**
 * 要介護認定申請検索のマッパーインタフェースです。
 */
public interface IShinseiKensakuMapper {

    /**
     * 認定申請情報の取得処理です。
     *
     * @param parameter パラメータ
     * @return 認定申請情報
     */
    List<ShinseiKensakuRelateEntity> selectShinseiJoho認定(ShinseiKensakuMapperParameter parameter);

    /**
     * 指定条件による認定申請情報の該当件数を返します。
     *
     * @param parameter パラメータ
     * @return 認定申請情報の件数
     */
    int countShinseiJoho認定(ShinseiKensakuMapperParameter parameter);

    /**
     * 認定申請情報の取得処理です。
     *
     * @param parameter パラメータ
     * @return 認定申請情報
     */
    List<ShinseiKensakuRelateEntity> selectShinseiJoho受給(ShinseiKensakuMapperParameter parameter);

    /**
     * 指定条件による認定申請情報の該当件数を返します。
     *
     * @param parameter パラメータ
     * @return 認定申請情報の件数
     */
    int countShinseiJoho受給(ShinseiKensakuMapperParameter parameter);
}
