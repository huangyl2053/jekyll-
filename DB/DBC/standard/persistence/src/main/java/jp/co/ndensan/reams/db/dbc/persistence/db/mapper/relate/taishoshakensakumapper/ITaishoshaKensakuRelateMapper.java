/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.taishoshakensakumapper;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.taishoshakensakumybatisprm.TaishoshaKensakuMybitisParamter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.taishoshakensaku.TaishoshaKensakuRelateEntity;

/**
 * 過誤申立決定情報照会のマッパーインタフェースです。
 *
 * @reamsid_L DBC-2940-010 jinjue
 */
public interface ITaishoshaKensakuRelateMapper {

    /**
     * 過誤決定情報を取得します。
     *
     * @param paramter 過誤申立決定情報照会のパラメータクラス
     * @return 過誤決定情報
     */
    List<TaishoshaKensakuRelateEntity> get過誤決定情報(TaishoshaKensakuMybitisParamter paramter);

    /**
     * 履歴番号情報取得します。
     *
     * @param 履歴番号検索条件 履歴番号検索条件
     * @return 履歴番号情報
     */
    List<TaishoshaKensakuRelateEntity> select履歴番号情報(TaishoshaKensakuMybitisParamter 履歴番号検索条件);
}
