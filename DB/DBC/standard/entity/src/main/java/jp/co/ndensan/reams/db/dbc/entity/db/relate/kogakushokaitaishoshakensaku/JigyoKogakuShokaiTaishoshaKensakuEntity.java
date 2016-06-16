/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakushokaitaishoshakensaku;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3110JigyoKogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3112KogakuShikyuShinsaKetteiEntity;

/**
 * 事業高額介護サービス費一覧Entity
 *
 * @reamsid_L DBC-3000-060 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoKogakuShokaiTaishoshaKensakuEntity {

    /**
     * -- GETTER -- 事業高額介護サービス費支給申請Entityを返します。
     *
     * @return 事業高額介護サービス費支給申請Entity -- SETTER -- 事業高額介護サービス費支給申請Entityを設定します。
     *
     * @param 事業高額介護サービス費支給申請Entity 事業高額介護サービス費支給申請Entity
     */
    private DbT3110JigyoKogakuShikyuShinseiEntity 事業高額介護サービス費支給申請Entity;

    /**
     * -- GETTER -- 事業高額介護サービス費支給判定結果Entityを返します。
     *
     * @return 事業高額介護サービス費支給判定結果Entity -- SETTER --
     * 事業高額介護サービス費支給判定結果Entityを設定します。
     *
     * @param 事業高額介護サービス費支給判定結果Entity 事業高額介護サービス費支給判定結果Entity
     */
    private DbT3111JigyoKogakuShikyuHanteiKekkaEntity 事業高額介護サービス費支給判定結果Entity;

    /**
     * -- GETTER -- 事業高額介護サービス費支給審査決定Entityを返します。
     *
     * @return 事業高額介護サービス費支給審査決定Entity -- SETTER --
     * 事業高額介護サービス費支給審査決定Entityを設定します。
     *
     * @param 事業高額介護サービス費支給審査決定Entity 事業高額介護サービス費支給審査決定Entity
     */
    private DbT3112KogakuShikyuShinsaKetteiEntity 事業高額介護サービス費支給審査決定Entity;

    /**
     * -- GETTER -- 事業高額介護サービス費給付対象者合計Entityを返します。
     *
     * @return 事業高額介護サービス費給付対象者合計Entity -- SETTER --
     * 事業高額介護サービス費給付対象者合計Entityを設定します。
     *
     * @param 事業高額介護サービス費給付対象者合計Entity 事業高額介護サービス費給付対象者合計Entity
     */
    private DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity 事業高額介護サービス費給付対象者合計Entity;

}
