/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kougakusabisuhishousainaiyou;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3058KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3110JigyoKogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3112KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;

/**
 * ビジネス設計_KogakuServicehiDetail_高額サービス費詳細内容入力共有子Div
 *
 * @reamsid_L DBC-4380-020 quxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KougakuSabisuhiShousaiNaiyouEntity {

    private DbT3055KogakuKyufuTaishoshaGokeiEntity 高額介護サービス費支給対象者合計Entity;
    private DbT3056KogakuShikyuShinseiEntity 高額介護サービス費支給申請Entity;
    private DbT3057KogakuShikyuHanteiKekkaEntity 高額介護サービス費支給判定結果Entity;
    private DbT3058KogakuShikyuShinsaKetteiEntity 高額介護サービス費支給審査決定Entity;
    private DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity 事業高額介護サービス費支給対象者合計Entity;
    private DbT3110JigyoKogakuShikyuShinseiEntity 事業高額介護サービス費支給申請Entity;
    private DbT3111JigyoKogakuShikyuHanteiKekkaEntity 事業高額介護サービス費支給判定結果Entity;
    private DbT3112KogakuShikyuShinsaKetteiEntity 事業高額介護サービス費支給審査決定Entity;

}
