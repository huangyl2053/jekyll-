/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakushokaitaishoshakensaku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogakushokaitaishoshakensaku.KogakuShokaiTaishoshaKensakuResultEntity;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakushokaitaishoshakensaku.KogakuShokaiTaishoshaKensakuSearch;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3058KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3110JigyoKogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3112KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakushokaitaishoshakensaku.JigyoKogakuShokaiTaishoshaKensakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakushokaitaishoshakensaku.KogakuShokaiTaishoshaKensakuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakushokaitaishoshakensaku.IKogakuShokaiTaishoshaKensakuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.persistence.db.mapper.IUaFt200FindShikibetsuTaishoFunctionMapper;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 高額介護サービス費照会（対象者検索）（画面）
 *
 * @reamsid_L DBC-3000-060 gongliang
 */
public class KogakuShokaiTaishoshaKensaku {

    private final MapperProvider mapperProvider;
    private static final RString 審査結果反映区分_反映済 = new RString("1");
    private static final RString メニューID_高額介護 = new RString("DBCMN11004");
    private static final RString メニューID_総合事業高額介護 = new RString("DBCMN11016");

    /**
     * コンストラクタです。
     */
    public KogakuShokaiTaishoshaKensaku() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 初期化メソッド
     *
     * @return KogakuShokaiTaishoshaKensaku
     */
    public static KogakuShokaiTaishoshaKensaku createInstance() {
        return InstanceProvider.create(KogakuShokaiTaishoshaKensaku.class);
    }

    /**
     * 検索条件より、対象者一覧を取得する。
     *
     * @param condition 高額介護サービス費一覧検索条件Entity
     * @return list＜高額介護サービス費一覧＞
     */
    public List<KogakuShokaiTaishoshaKensakuResultEntity> selectTaishosha(KogakuShokaiTaishoshaKensakuSearch condition) {
        IKogakuShokaiTaishoshaKensakuMapper mapper = mapperProvider.create(IKogakuShokaiTaishoshaKensakuMapper.class);
        List<KogakuShokaiTaishoshaKensakuResultEntity> resultList = new ArrayList<>();
        if (メニューID_高額介護.equals(condition.getメニューID())) {
            List<KogakuShokaiTaishoshaKensakuEntity> entityList = mapper.get高額介護サービス費一覧(condition);
            if (entityList == null || entityList.isEmpty()) {
                return resultList;
            }
            for (KogakuShokaiTaishoshaKensakuEntity entity : entityList) {
                DbT3056KogakuShikyuShinseiEntity 支給申請Entity = entity.get高額介護サービス費支給申請Entity();
                DbT3057KogakuShikyuHanteiKekkaEntity 判定結果Entity = entity.get高額介護サービス費支給判定結果Entity();
                DbT3058KogakuShikyuShinsaKetteiEntity 審査決定Entity = entity.get高額介護サービス費支給審査決定Entity();
                DbT3055KogakuKyufuTaishoshaGokeiEntity 対象者合計Entity = entity.get高額介護サービス費給付対象者合計Entity();
                KogakuShokaiTaishoshaKensakuResultEntity result = new KogakuShokaiTaishoshaKensakuResultEntity();
                result.set被保険者番号(支給申請Entity.getHihokenshaNo());
                result.setサービス提供年月(支給申請Entity.getServiceTeikyoYM());
                result.set申請年月日(支給申請Entity.getShinseiYMD());
                result.set履歴番号(支給申請Entity.getRirekiNo());
                result.set証記載保険者番号(支給申請Entity.getShoKisaiHokenshaNo());
                if (対象者合計Entity != null) {
                    result.set高額支給額(対象者合計Entity.getKogakuShikyuGaku());
                    result.set自動償還対象フラグ(対象者合計Entity.getJidoShokanTaishoFlag());
                } else {
                    result.set高額支給額(null);
                    result.set自動償還対象フラグ(Boolean.FALSE);
                }
                if (判定結果Entity != null) {
                    result.set決定年月日(判定結果Entity.getKetteiYMD());
                    RString 審査結果反映区分 = 判定結果Entity.getShinsaKekkaHaneiKubun();
                    result = set支給区分コードと支給金額(審査結果反映区分, result, 判定結果Entity, 審査決定Entity);
                } else {
                    result.set決定年月日(FlexibleDate.EMPTY);
                    result.set支給区分コード(RString.EMPTY);
                    result.set支給金額(null);
                }
                // TODO QAあり。
//                result.get識別対象();
                resultList.add(result);
            }
        } else if (メニューID_総合事業高額介護.equals(condition.getメニューID())) {
            List<JigyoKogakuShokaiTaishoshaKensakuEntity> entityList = mapper.get事業高額介護サービス費一覧(condition);
            if (entityList == null || entityList.isEmpty()) {
                return resultList;
            }
            for (JigyoKogakuShokaiTaishoshaKensakuEntity entity : entityList) {
                DbT3110JigyoKogakuShikyuShinseiEntity 支給申請Entity = entity.get事業高額介護サービス費支給申請Entity();
                DbT3111JigyoKogakuShikyuHanteiKekkaEntity 判定結果Entity = entity.get事業高額介護サービス費支給判定結果Entity();
                DbT3112KogakuShikyuShinsaKetteiEntity 審査決定Entity = entity.get事業高額介護サービス費支給審査決定Entity();
                DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity 対象者合計Entity = entity.get事業高額介護サービス費給付対象者合計Entity();
                KogakuShokaiTaishoshaKensakuResultEntity result = new KogakuShokaiTaishoshaKensakuResultEntity();
                result.set被保険者番号(支給申請Entity.getHihokenshaNo());
                result.setサービス提供年月(支給申請Entity.getServiceTeikyoYM());
                result.set申請年月日(支給申請Entity.getShinseiYMD());
                result.set履歴番号(支給申請Entity.getRirekiNo());
                result.set証記載保険者番号(支給申請Entity.getShoKisaiHokenshaNo());
                if (対象者合計Entity != null) {
                    result.set高額支給額(対象者合計Entity.getJigyoKogakuShikyuGaku());
                    result.set自動償還対象フラグ(対象者合計Entity.getJidoShokanTaishoFlag());
                } else {
                    result.set高額支給額(null);
                    result.set自動償還対象フラグ(Boolean.FALSE);
                }
                if (判定結果Entity != null) {
                    result.set決定年月日(判定結果Entity.getKetteiYMD());
                    RString 審査結果反映区分 = 判定結果Entity.getShinsaKekkaHaneiKubun();
                    result = set事業支給区分コードと支給金額(審査結果反映区分, result, 判定結果Entity, 審査決定Entity);
                } else {
                    result.set決定年月日(FlexibleDate.EMPTY);
                    result.set支給区分コード(RString.EMPTY);
                    result.set支給金額(null);
                }
                // TODO QAあり。
//                result.get識別対象();
                resultList.add(result);
            }
        }
        return resultList;
    }

    private KogakuShokaiTaishoshaKensakuResultEntity set支給区分コードと支給金額(RString 審査結果反映区分,
            KogakuShokaiTaishoshaKensakuResultEntity result,
            DbT3057KogakuShikyuHanteiKekkaEntity 判定結果Entity,
            DbT3058KogakuShikyuShinsaKetteiEntity 審査決定Entity) {
        if (審査結果反映区分_反映済.equals(審査結果反映区分)) {
            if (審査決定Entity != null) {
                result.set支給区分コード(審査決定Entity.getShikyuKubunCode());
                result.set支給金額(審査決定Entity.getKogakuShikyuGaku());
            } else {
                result.set支給区分コード(RString.EMPTY);
                result.set支給金額(null);
            }
        } else {
            result.set支給区分コード(判定結果Entity.getShikyuKubunCode());
            result.set支給金額(判定結果Entity.getShikyuKingaku());
        }
        return result;
    }

    private KogakuShokaiTaishoshaKensakuResultEntity set事業支給区分コードと支給金額(RString 審査結果反映区分,
            KogakuShokaiTaishoshaKensakuResultEntity result,
            DbT3111JigyoKogakuShikyuHanteiKekkaEntity 判定結果Entity,
            DbT3112KogakuShikyuShinsaKetteiEntity 審査決定Entity) {
        if (審査結果反映区分_反映済.equals(審査結果反映区分)) {
            if (審査決定Entity != null) {
                result.set支給区分コード(審査決定Entity.getShikyuKubunCode());
                result.set支給金額(審査決定Entity.getJigyoKogakuShikyuGaku());
            } else {
                result.set支給区分コード(RString.EMPTY);
                result.set支給金額(null);
            }
        } else {
            result.set支給区分コード(判定結果Entity.getShiharaiKubunCode());
            result.set支給金額(判定結果Entity.getShiharaiKingaku());
        }
        return result;
    }

    /**
     * 画面．被保番号をもとに宛名情報を取得する。
     *
     * @param parameter IShikibetsuTaishoPSMSearchKey
     * @return 氏名
     */
    public AtenaMeisho get氏名(IShikibetsuTaishoPSMSearchKey parameter) {
        UaFt200FindShikibetsuTaishoParam param = new UaFt200FindShikibetsuTaishoParam(parameter);
        IUaFt200FindShikibetsuTaishoFunctionMapper mapper = mapperProvider.create(IUaFt200FindShikibetsuTaishoFunctionMapper.class);
        List<UaFt200FindShikibetsuTaishoEntity> 宛名PSMlist = mapper.selectByParameterClass(param);
        if (宛名PSMlist == null || 宛名PSMlist.isEmpty()) {
            return AtenaMeisho.EMPTY;
        } else {
            IShikibetsuTaisho 宛名情報 = ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名PSMlist.get(0));
            return 宛名情報.get名称().getName();
        }
    }
}
