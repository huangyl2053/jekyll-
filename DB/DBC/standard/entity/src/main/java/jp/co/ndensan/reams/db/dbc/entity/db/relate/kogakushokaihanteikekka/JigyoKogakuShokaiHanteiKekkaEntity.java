/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakushokaihanteikekka;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3110JigyoKogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3112KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;

/**
 * ビジネス設計_DBCMN11004_世帯合算並列表示（画面）のXML返した高額Entityです。
 *
 * @reamsid_L DBC-3000-050 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoKogakuShokaiHanteiKekkaEntity {

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

    /**
     * -- GETTER -- 事業高額介護サービス費給付対象者明細Listを返します。
     *
     * @return 事業高額介護サービス費給付対象者明細List -- SETTER -- 事業高額介護サービス費給付対象者明細Listを設定します。
     *
     * @param 事業高額介護サービス費給付対象者明細List 事業高額介護サービス費給付対象者明細List
     */
    private List<DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity> 事業高額介護サービス費給付対象者明細List;

    /**
     * -- GETTER -- 介護事業者Listを返します。
     *
     * @return 介護事業者List -- SETTER -- 介護事業者Listを設定します。
     *
     * @param 介護事業者List 介護事業者List
     */
    private List<DbT7060KaigoJigyoshaEntity> 介護事業者List;
}
