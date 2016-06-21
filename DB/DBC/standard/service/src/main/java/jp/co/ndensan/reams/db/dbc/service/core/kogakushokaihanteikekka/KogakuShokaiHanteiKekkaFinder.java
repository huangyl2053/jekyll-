/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakushokaihanteikekka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.kogakushokaihanteikekka.KogakuShokaiHanteiKekkaResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogakushokaihanteikekka.ShikyuMeisaiResult;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakushokaihanteikekka.KogakuShokaiHanteiKekkaParam;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3058KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3110JigyoKogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3112KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakushokaihanteikekka.JigyoKogakuShokaiHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakushokaihanteikekka.JigyoKogakuShokaiHanteiKekkaIchiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakushokaihanteikekka.KogakuShokaiHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakushokaihanteikekka.KogakuShokaiHanteiKekkaIchiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakushokaihanteikekka.IKogakuShokaiHanteiKekkaMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBCMN11004_世帯合算並列表示（画面）のクラスです。
 *
 * @reamsid_L DBC-3000-050 gongliang
 */
public class KogakuShokaiHanteiKekkaFinder {

    private final MapperProvider mapperProvider;
    private static final RString 審査結果反映区分_反映済 = new RString("1");
    private static final RString 明細 = new RString("明細");
    private static final RString 事業者名 = new RString("事業者名称");
    private static final RString メニューID_高額介護 = new RString("DBCMN11004");
    private static final RString メニューID_総合事業高額介護 = new RString("DBCMN11016");

    /**
     * コンストラクタです。
     */
    public KogakuShokaiHanteiKekkaFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 初期化メソッド
     *
     * @return KogakuShokaiHanteiKekkaFinder
     */
    public static KogakuShokaiHanteiKekkaFinder createInstance() {
        return InstanceProvider.create(KogakuShokaiHanteiKekkaFinder.class);
    }

    /**
     * 検索条件をもとに、（事業）高額介護サービス費支給判定結果・審査結果情報を取得する。
     *
     * @param parameter 入力のパラメータです。
     * @return 支給判定結果
     */
    public KogakuShokaiHanteiKekkaResult get支給判定結果(KogakuShokaiHanteiKekkaParam parameter) {
        IKogakuShokaiHanteiKekkaMapper mapper = mapperProvider.create(IKogakuShokaiHanteiKekkaMapper.class);
        KogakuShokaiHanteiKekkaResult result = new KogakuShokaiHanteiKekkaResult();
        if (メニューID_高額介護.equals(parameter.getメニューID())) {
            KogakuShokaiHanteiKekkaIchiEntity entity = mapper.get高額介護支給判定結果(parameter);
            if (entity == null || entity.get高額判定結果_決定情報List() == null || entity.get高額判定結果_決定情報List().isEmpty()) {
                return null;
            }
            result = get高額介護情報(entity.get高額判定結果_決定情報List());
        } else if (メニューID_総合事業高額介護.equals(parameter.getメニューID())) {
            JigyoKogakuShokaiHanteiKekkaIchiEntity entity = mapper.get事業高額介護支給判定結果(parameter);
            if (entity == null || entity.get事業高額判定結果_決定情報List() == null || entity.get事業高額判定結果_決定情報List().isEmpty()) {
                return null;
            }
            result = get事業高額介護情報(entity.get事業高額判定結果_決定情報List());
        }
        return result;
    }

    private KogakuShokaiHanteiKekkaResult get高額介護情報(List<KogakuShokaiHanteiKekkaEntity> entityList) {
        KogakuShokaiHanteiKekkaResult result = new KogakuShokaiHanteiKekkaResult();
        List<ShikyuMeisaiResult> 支給明細list = new ArrayList<>();
        DbT3057KogakuShikyuHanteiKekkaEntity 判定結果entity = entityList.get(0).get高額介護サービス費支給判定結果Entity();
        DbT3055KogakuKyufuTaishoshaGokeiEntity 合計Entity = entityList.get(0).get高額介護サービス費給付対象者合計Entity();
        DbT3058KogakuShikyuShinsaKetteiEntity 審査決定Entity = entityList.get(0).get高額介護サービス費支給審査決定Entity();
        List<Map<RString, Object>> 明細Listと事業者名称 = get明細Listと事業者名称(entityList);
        if (合計Entity != null) {
            result.set世帯集約番号(合計Entity.getSetaiShuyakuNo());
            result.set自動償還対象フラグ(合計Entity.getJidoShokanTaishoFlag());
        } else {
            result.set世帯集約番号(RString.EMPTY);
            result.set自動償還対象フラグ(Boolean.FALSE);
        }
        if (明細Listと事業者名称 != null && !明細Listと事業者名称.isEmpty()) {
            DbT3054KogakuKyufuTaishoshaMeisaiEntity 明細entity1件目
                    = (DbT3054KogakuKyufuTaishoshaMeisaiEntity) 明細Listと事業者名称.get(0).get(明細);
            result.set高額給付根拠(明細entity1件目.getKogakuKyufuKonkyo());
            for (Map<RString, Object> map : 明細Listと事業者名称) {
                DbT3054KogakuKyufuTaishoshaMeisaiEntity 明細entity = (DbT3054KogakuKyufuTaishoshaMeisaiEntity) map.get(明細);
                ShikyuMeisaiResult 支給明細entity = new ShikyuMeisaiResult();
                支給明細entity.set事業者番号(明細entity.getJigyoshaNo());
                AtenaMeisho 事業者名称 = (AtenaMeisho) map.get(事業者名);
                支給明細entity.set事業者名称(事業者名称);
                支給明細entity.setサービス種類コード(明細entity.getServiceShuruiCode());
                支給明細entity.setサービス費用合計(明細entity.getServiceHiyoGokeiGaku());
                支給明細entity.set利用者負担額(明細entity.getRiyoshaFutanGaku());
                支給明細entity.set算定基準額(null);
                支給明細entity.set支払済金額(null);
                支給明細entity.set高額支給額(null);
                支給明細list.add(支給明細entity);
            }
            ShikyuMeisaiResult 支給明細entity = new ShikyuMeisaiResult();
            支給明細entity.set事業者番号(JigyoshaNo.EMPTY);
            支給明細entity.set事業者名称(AtenaMeisho.EMPTY);
            支給明細entity.setサービス種類コード(ServiceShuruiCode.EMPTY);
            if (合計Entity != null) {
                支給明細entity.setサービス費用合計(合計Entity.getServiceHiyoGokeiGakuGokei());
                支給明細entity.set利用者負担額(合計Entity.getRiyoshaFutanGakuGokei());
                支給明細entity.set算定基準額(合計Entity.getSanteiKijunGaku());
                支給明細entity.set支払済金額(合計Entity.getShiharaiSumiKingakuGokei());
                支給明細entity.set高額支給額(合計Entity.getKogakuShikyuGaku());
            } else {
                支給明細entity.setサービス費用合計(null);
                支給明細entity.set利用者負担額(null);
                支給明細entity.set算定基準額(null);
                支給明細entity.set支払済金額(null);
                支給明細entity.set高額支給額(null);
            }
            支給明細list.add(支給明細entity);
        } else {
            result.set高額給付根拠(RString.EMPTY);
        }
        result.set支給明細list(支給明細list);
        result.set受付年月日(entityList.get(0).get高額介護サービス費支給申請Entity().getUketsukeYMD());
        if (判定結果entity != null) {
            result.set決定年月日(判定結果entity.getKetteiYMD());
            result.set審査方法区分(判定結果entity.getShinsaHohoKubun());
            result = set審査決定_判定結果(result, 判定結果entity, 審査決定Entity);
            result.set不支給理由(判定結果entity.getFushikyuRiyu());
        } else {
            result.set決定年月日(FlexibleDate.EMPTY);
            result.set審査方法区分(RString.EMPTY);
            result.set不支給理由(RString.EMPTY);
            result.set支給区分コード(RString.EMPTY);
            result.set本人支払額(null);
            result.set支給金額(null);
        }
        return result;
    }

    private KogakuShokaiHanteiKekkaResult get事業高額介護情報(List<JigyoKogakuShokaiHanteiKekkaEntity> entityList) {
        KogakuShokaiHanteiKekkaResult result = new KogakuShokaiHanteiKekkaResult();
        List<ShikyuMeisaiResult> 支給明細list = new ArrayList<>();
        DbT3111JigyoKogakuShikyuHanteiKekkaEntity 判定結果entity = entityList.get(0).get事業高額介護サービス費支給判定結果Entity();
        DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity 合計Entity = entityList.get(0).get事業高額介護サービス費給付対象者合計Entity();
        DbT3112KogakuShikyuShinsaKetteiEntity 審査決定Entity = entityList.get(0).get事業高額介護サービス費支給審査決定Entity();
        List<Map<RString, Object>> 事業明細Listと事業者名称 = get事業明細Listと事業者名称(entityList);
        if (合計Entity != null) {
            result.set世帯集約番号(合計Entity.getSetaiShuyakuNo());
            result.set自動償還対象フラグ(合計Entity.getJidoShokanTaishoFlag());
        } else {
            result.set世帯集約番号(RString.EMPTY);
            result.set自動償還対象フラグ(Boolean.FALSE);
        }
        if (事業明細Listと事業者名称 != null && !事業明細Listと事業者名称.isEmpty()) {
            DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity 明細entity1件目
                    = (DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity) 事業明細Listと事業者名称.get(0).get(明細);
            result.set高額給付根拠(明細entity1件目.getJigyoKogakuKyufuKonkyo());
            for (Map<RString, Object> map : 事業明細Listと事業者名称) {
                DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity 明細entity = (DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity) map.get(明細);
                ShikyuMeisaiResult 支給明細entity = new ShikyuMeisaiResult();
                支給明細entity.set事業者番号(明細entity.getJigyoshaNo());
                AtenaMeisho 事業者名称 = (AtenaMeisho) map.get(事業者名);
                支給明細entity.set事業者名称(事業者名称);
                支給明細entity.setサービス種類コード(明細entity.getServiceShuruiCode());
                支給明細entity.setサービス費用合計(明細entity.getServiceHiyoGokeiGaku());
                支給明細entity.set利用者負担額(明細entity.getRiyoshaFutanGaku());
                支給明細entity.set算定基準額(null);
                支給明細entity.set支払済金額(null);
                支給明細entity.set高額支給額(null);
                支給明細list.add(支給明細entity);
            }
            ShikyuMeisaiResult 支給明細entity = new ShikyuMeisaiResult();
            支給明細entity.set事業者番号(JigyoshaNo.EMPTY);
            支給明細entity.set事業者名称(AtenaMeisho.EMPTY);
            支給明細entity.setサービス種類コード(ServiceShuruiCode.EMPTY);
            if (合計Entity != null) {
                支給明細entity.setサービス費用合計(合計Entity.getServiceHiyoGokeiGakuGokei());
                支給明細entity.set利用者負担額(合計Entity.getRiyoshaFutanGakuGokei());
                支給明細entity.set算定基準額(合計Entity.getSanteiKijunGaku());
                支給明細entity.set支払済金額(合計Entity.getShiharaiSumiKingakuGokei());
                支給明細entity.set高額支給額(合計Entity.getJigyoKogakuShikyuGaku());
            } else {
                支給明細entity.setサービス費用合計(null);
                支給明細entity.set利用者負担額(null);
                支給明細entity.set算定基準額(null);
                支給明細entity.set支払済金額(null);
                支給明細entity.set高額支給額(null);
            }
            支給明細list.add(支給明細entity);
        } else {
            result.set高額給付根拠(RString.EMPTY);
        }
        result.set支給明細list(支給明細list);
        result.set受付年月日(entityList.get(0).get事業高額介護サービス費支給申請Entity().getUketsukeYMD());
        if (判定結果entity != null) {
            result.set決定年月日(判定結果entity.getKetteiYMD());
            result.set審査方法区分(判定結果entity.getShinsaHohoKubun());
            result = set審査決定_判定結果事業(result, 判定結果entity, 審査決定Entity);
            result.set不支給理由(判定結果entity.getFushikyuRiyu());
        } else {
            result.set決定年月日(FlexibleDate.EMPTY);
            result.set審査方法区分(RString.EMPTY);
            result.set不支給理由(RString.EMPTY);
            result.set支給区分コード(RString.EMPTY);
            result.set本人支払額(null);
            result.set支給金額(null);
        }
        return result;
    }

    private KogakuShokaiHanteiKekkaResult set審査決定_判定結果(KogakuShokaiHanteiKekkaResult result,
            DbT3057KogakuShikyuHanteiKekkaEntity 判定結果entity,
            DbT3058KogakuShikyuShinsaKetteiEntity 審査決定Entity) {
        RString 審査結果反映区分 = 判定結果entity.getShinsaKekkaHaneiKubun();
        if (審査結果反映区分_反映済.equals(審査結果反映区分) && 審査決定Entity != null) {
            result.set本人支払額(審査決定Entity.getRiyoshaFutanGaku());
            result.set支給区分コード(審査決定Entity.getShikyuKubunCode());
            result.set支給金額(審査決定Entity.getKogakuShikyuGaku());
        } else {
            result.set本人支払額(判定結果entity.getHonninShiharaiGaku());
            result.set支給区分コード(判定結果entity.getShikyuKubunCode());
            result.set支給金額(判定結果entity.getShikyuKingaku());
        }
        return result;
    }

    private KogakuShokaiHanteiKekkaResult set審査決定_判定結果事業(KogakuShokaiHanteiKekkaResult result,
            DbT3111JigyoKogakuShikyuHanteiKekkaEntity 判定結果entity,
            DbT3112KogakuShikyuShinsaKetteiEntity 審査決定Entity) {
        RString 審査結果反映区分 = 判定結果entity.getShinsaKekkaHaneiKubun();
        if (審査結果反映区分_反映済.equals(審査結果反映区分) && 審査決定Entity != null) {
            result.set本人支払額(審査決定Entity.getRiyoshaFutanGaku());
            result.set支給区分コード(審査決定Entity.getShikyuKubunCode());
            result.set支給金額(審査決定Entity.getJigyoKogakuShikyuGaku());
        } else {
            result.set本人支払額(判定結果entity.getHonninShiharaiGaku());
            result.set支給区分コード(判定結果entity.getShiharaiKubunCode());
            result.set支給金額(判定結果entity.getShiharaiKingaku());
        }
        return result;
    }

    private List<Map<RString, Object>> get明細Listと事業者名称(List<KogakuShokaiHanteiKekkaEntity> entityList) {
        List<Map<RString, Object>> mapList = new ArrayList<>();
        DbT3056KogakuShikyuShinseiEntity 支給申請Entity = entityList.get(0).get高額介護サービス費支給申請Entity();
        HihokenshaNo hihokenshaNo = 支給申請Entity.getHihokenshaNo();
        FlexibleYearMonth serviceTeikyoYM = 支給申請Entity.getServiceTeikyoYM();
        Decimal rirekiNo = 支給申請Entity.getRirekiNo();
        List<DbT3054KogakuKyufuTaishoshaMeisaiEntity> 明細List = new ArrayList<>();
        for (KogakuShokaiHanteiKekkaEntity entity : entityList) {
            DbT3056KogakuShikyuShinseiEntity 支給申請_明細Entity = entity.get高額介護サービス費支給申請Entity();
            if (hihokenshaNo.equals(支給申請_明細Entity.getHihokenshaNo())
                    && serviceTeikyoYM.equals(支給申請_明細Entity.getServiceTeikyoYM())
                    && rirekiNo.equals(支給申請_明細Entity.getRirekiNo())) {
                DbT3054KogakuKyufuTaishoshaMeisaiEntity 明細entity = entity.get高額介護サービス費給付対象者明細Entity();
                if (明細entity == null || 明細List.contains(明細entity)) {
                    continue;
                }
                Map<RString, Object> map = new HashMap<>();
                map.put(明細, 明細entity);
                DbT7060KaigoJigyoshaEntity 介護事業者entity = entity.get介護事業者Entity();
                AtenaMeisho 事業者名称 = 介護事業者entity == null ? AtenaMeisho.EMPTY : 介護事業者entity.getJigyoshaName();
                map.put(事業者名, 事業者名称);
                mapList.add(map);
                明細List.add(明細entity);
            }
        }
        return mapList;
    }

    private List<Map<RString, Object>> get事業明細Listと事業者名称(List<JigyoKogakuShokaiHanteiKekkaEntity> entityList) {
        List<Map<RString, Object>> mapList = new ArrayList<>();
        DbT3110JigyoKogakuShikyuShinseiEntity 支給申請Entity = entityList.get(0).get事業高額介護サービス費支給申請Entity();
        HihokenshaNo hihokenshaNo = 支給申請Entity.getHihokenshaNo();
        FlexibleYearMonth serviceTeikyoYM = 支給申請Entity.getServiceTeikyoYM();
        Decimal rirekiNo = 支給申請Entity.getRirekiNo();
        List<DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity> 明細List = new ArrayList<>();
        for (JigyoKogakuShokaiHanteiKekkaEntity entity : entityList) {
            DbT3110JigyoKogakuShikyuShinseiEntity 支給申請_明細Entity = entity.get事業高額介護サービス費支給申請Entity();
            if (hihokenshaNo.equals(支給申請_明細Entity.getHihokenshaNo())
                    && serviceTeikyoYM.equals(支給申請_明細Entity.getServiceTeikyoYM())
                    && rirekiNo.equals(支給申請_明細Entity.getRirekiNo())) {
                DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity 明細entity = entity.get事業高額介護サービス費給付対象者明細Entity();
                if (明細entity == null || 明細List.contains(明細entity)) {
                    continue;
                }
                Map<RString, Object> map = new HashMap<>();
                map.put(明細, 明細entity);
                DbT7060KaigoJigyoshaEntity 介護事業者entity = entity.get介護事業者Entity();
                AtenaMeisho 事業者名称 = 介護事業者entity == null ? AtenaMeisho.EMPTY : 介護事業者entity.getJigyoshaName();
                map.put(事業者名, 事業者名称);
                mapList.add(map);
                明細List.add(明細entity);
            }
        }
        return mapList;
    }

}
