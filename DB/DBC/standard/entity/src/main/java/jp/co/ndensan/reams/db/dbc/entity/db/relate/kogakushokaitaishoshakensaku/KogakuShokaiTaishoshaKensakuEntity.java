/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakushokaitaishoshakensaku;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3058KogakuShikyuShinsaKetteiEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額介護サービス費一覧Entity
 *
 * @reamsid_L DBC-3000-060 gongliang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuShokaiTaishoshaKensakuEntity {

    /**
     * -- GETTER -- 高額介護サービス費支給申請Entityを返します。
     *
     * @return 高額介護サービス費支給申請Entity -- SETTER -- 高額介護サービス費支給申請Entityを設定します。
     *
     * @param 高額介護サービス費支給申請Entity 高額介護サービス費支給申請Entity
     */
    private DbT3056KogakuShikyuShinseiEntity 高額介護サービス費支給申請Entity;

    /**
     * -- GETTER -- 高額介護サービス費支給判定結果Entityを返します。
     *
     * @return 高額介護サービス費支給判定結果Entity -- SETTER -- 高額介護サービス費支給判定結果Entityを設定します。
     *
     * @param 高額介護サービス費支給判定結果Entity 高額介護サービス費支給判定結果Entity
     */
    private DbT3057KogakuShikyuHanteiKekkaEntity 高額介護サービス費支給判定結果Entity;

    /**
     * -- GETTER -- 高額介護サービス費支給審査決定Entityを返します。
     *
     * @return 高額介護サービス費支給審査決定Entity -- SETTER -- 高額介護サービス費支給審査決定Entityを設定します。
     *
     * @param 高額介護サービス費支給審査決定Entity 高額介護サービス費支給審査決定Entity
     */
    private DbT3058KogakuShikyuShinsaKetteiEntity 高額介護サービス費支給審査決定Entity;

    /**
     * -- GETTER -- 高額介護サービス費給付対象者合計Entityを返します。
     *
     * @return 高額介護サービス費給付対象者合計Entity -- SETTER -- 高額介護サービス費給付対象者合計Entityを設定します。
     *
     * @param 高額介護サービス費給付対象者合計Entity 高額介護サービス費給付対象者合計Entity
     */
    private DbT3055KogakuKyufuTaishoshaGokeiEntity 高額介護サービス費給付対象者合計Entity;

}
