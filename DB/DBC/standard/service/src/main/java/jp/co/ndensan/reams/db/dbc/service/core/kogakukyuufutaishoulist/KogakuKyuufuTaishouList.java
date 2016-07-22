/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakukyuufutaishoulist;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuKyufuTaishoshaGokei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuKyufuTaishoshaMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuKyufuTaishoshaGokei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuKyufuTaishoshaMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.kogakukyuufutaishoulist.JigyouKogakuKyuufuTaishouResult;
import jp.co.ndensan.reams.db.dbc.business.core.kogakukyuufutaishoulist.KogakuKyuufuTaishouListEntityResult;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3055KogakuKyufuTaishoshaGokeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3108JigyoKogakuKyufuTaishoshaMeisaiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3109JigyoKogakuKyufuTaishoshaGokeiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7063KaigoJigyoshaShiteiServiceDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7130KaigoServiceShuruiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBCKD00006_高額給付対象一覧共有子Div（画面）
 *
 * @reamsid_L DBC-2020-060 quxiaodong
 */
public class KogakuKyuufuTaishouList {

    private final DbT7060KaigoJigyoshaDac 介護事業者管理Dac;
    private final DbT7063KaigoJigyoshaShiteiServiceDac 介護事業者指定サービスDac;
    private final DbT7130KaigoServiceShuruiDac 介護サービス種類Dac;
    private final DbT3054KogakuKyufuTaishoshaMeisaiDac 高額給付対象者明細Dac;
    private final DbT3055KogakuKyufuTaishoshaGokeiDac 高額給付対象者合計Dac;
    private final DbT3108JigyoKogakuKyufuTaishoshaMeisaiDac 事業高額給付対象者明細Dac;
    private final DbT3109JigyoKogakuKyufuTaishoshaGokeiDac 事業高額給付対象者合計Dac;
    private static final RString ZERO_RS = new RString("0");
    private static final RString ONE_RS = new RString("1");
    private static final RString TWO_RS = new RString("2");

    /**
     * コンストラクタです。
     */
    public KogakuKyuufuTaishouList() {
        this.介護事業者管理Dac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
        this.介護事業者指定サービスDac = InstanceProvider.create(DbT7063KaigoJigyoshaShiteiServiceDac.class);
        this.介護サービス種類Dac = InstanceProvider.create(DbT7130KaigoServiceShuruiDac.class);
        this.高額給付対象者明細Dac = InstanceProvider.create(DbT3054KogakuKyufuTaishoshaMeisaiDac.class);
        this.高額給付対象者合計Dac = InstanceProvider.create(DbT3055KogakuKyufuTaishoshaGokeiDac.class);
        this.事業高額給付対象者明細Dac = InstanceProvider.create(DbT3108JigyoKogakuKyufuTaishoshaMeisaiDac.class);
        this.事業高額給付対象者合計Dac = InstanceProvider.create(DbT3109JigyoKogakuKyufuTaishoshaGokeiDac.class);
    }

    /**
     * 初期化メソッドです。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KogakuKyuufuTaishouList}のインスタンス
     */
    public static KogakuKyuufuTaishouList createInstance() {
        return InstanceProvider.create(KogakuKyuufuTaishouList.class);
    }

    /**
     * 高額給付対象一覧情報（高額）取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @return List<KogakuKyuufuTaishouListEntity>
     */
    public List<KogakuKyuufuTaishouListEntityResult> getKogakuKyuufuTaishouList(
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        List<KogakuKyuufuTaishouListEntityResult> result = new ArrayList<>();
        List<DbT3054KogakuKyufuTaishoshaMeisaiEntity> 給付対象者明細list
                = 高額給付対象者明細Dac.selectAllByKey(被保険者番号, サービス提供年月);
        List<DbT3055KogakuKyufuTaishoshaGokeiEntity> 給付対象者合計list
                = 高額給付対象者合計Dac.selectAllByKey(被保険者番号, サービス提供年月);
        KogakuKyuufuTaishouListEntityResult 高額給付対象一覧情報 = new KogakuKyuufuTaishouListEntityResult();
        if ((給付対象者明細list == null || 給付対象者明細list.isEmpty())
                && (給付対象者合計list == null || 給付対象者合計list.isEmpty())) {
            return new ArrayList<>();
        } else {
            for (DbT3054KogakuKyufuTaishoshaMeisaiEntity entity : 給付対象者明細list) {
                高額給付対象一覧情報.set給付対象者明細entity(new KogakuKyufuTaishoshaMeisai(entity));
                高額給付対象一覧情報.set明細合計区分(ONE_RS);
                result.add(高額給付対象一覧情報);
            }
            set事業者名称と種類(サービス提供年月, result);
            for (DbT3055KogakuKyufuTaishoshaGokeiEntity entity : 給付対象者合計list) {
                高額給付対象一覧情報.set給付対象者合計entity(new KogakuKyufuTaishoshaGokei(entity));
                高額給付対象一覧情報.set明細合計区分(TWO_RS);
                result.add(高額給付対象一覧情報);
            }
        }
        return result;
    }

    /**
     * 高額給付対象一覧情報（事業高額）取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @return List<JigyouKogakuKyuufuTaishouResult>
     */
    public List<JigyouKogakuKyuufuTaishouResult> getJigyouKogakuKyuufuTaishouList(
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        List<JigyouKogakuKyuufuTaishouResult> result = new ArrayList<>();
        List<DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity> 給付対象者明細list
                = 事業高額給付対象者明細Dac.selectAllByKey(被保険者番号, サービス提供年月);
        List<DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity> 給付対象者合計list
                = 事業高額給付対象者合計Dac.selectAllByKey(被保険者番号, サービス提供年月);
        JigyouKogakuKyuufuTaishouResult 高額給付対象一覧情報 = new JigyouKogakuKyuufuTaishouResult();
        if ((給付対象者明細list == null || 給付対象者明細list.isEmpty())
                && (給付対象者合計list == null || 給付対象者合計list.isEmpty())) {
            return new ArrayList<>();
        } else {
            for (DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity entity : 給付対象者明細list) {
                高額給付対象一覧情報.set給付対象者明細entity(new JigyoKogakuKyufuTaishoshaMeisai(entity));
                高額給付対象一覧情報.set明細合計区分(ONE_RS);
                result.add(高額給付対象一覧情報);
            }
            set事業高額の事業者名称と種類(サービス提供年月, result);
            for (DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity entity : 給付対象者合計list) {
                高額給付対象一覧情報.set給付対象者合計entity(new JigyoKogakuKyufuTaishoshaGokei(entity));
                高額給付対象一覧情報.set明細合計区分(TWO_RS);
                result.add(高額給付対象一覧情報);
            }
        }
        return result;
    }

    private void set事業者名称と種類(FlexibleYearMonth サービス提供年月,
            List<KogakuKyuufuTaishouListEntityResult> result) {
        for (KogakuKyuufuTaishouListEntityResult kogaEntity : result) {
            if (kogaEntity.get給付対象者明細entity().get事業者番号() == null || kogaEntity.get給付対象者明細entity().
                    getサービス種類コード() == null) {
                kogaEntity.set事業者名(null);
            } else {
                DbT7060KaigoJigyoshaEntity 介護事業者名称 = 介護事業者管理Dac.select事業者の名称(
                        kogaEntity.get給付対象者明細entity().get事業者番号(),
                        new FlexibleDate(サービス提供年月.toString()));
                DbT7063KaigoJigyoshaShiteiServiceEntity 介護事業者指定事業者名称 = 介護事業者指定サービスDac.
                        select事業者名称(kogaEntity.get給付対象者明細entity().get事業者番号().value(),
                                kogaEntity.get給付対象者明細entity().
                                getサービス種類コード().value(), new FlexibleDate(サービス提供年月.toString()));
                set事業者名称(介護事業者名称, 介護事業者指定事業者名称, kogaEntity);
            }
            if (kogaEntity.get給付対象者明細entity().getサービス種類コード() == null
                    || kogaEntity.get給付対象者明細entity().getサービス種類コード().value() == null) {
                kogaEntity.setサービス種類(null);
            } else {
                DbT7130KaigoServiceShuruiEntity 種類略称 = 介護サービス種類Dac.selectサービス種類名称Andサービス種類略称(
                        kogaEntity.get給付対象者明細entity().getサービス種類コード().value(), サービス提供年月);
                setサービス種類(種類略称, kogaEntity);
            }
        }
    }

    private void set事業高額の事業者名称と種類(FlexibleYearMonth サービス提供年月,
            List<JigyouKogakuKyuufuTaishouResult> result) {
        for (JigyouKogakuKyuufuTaishouResult kogaEntity : result) {
            if (kogaEntity.get給付対象者明細entity().get事業者番号() == null || kogaEntity.get給付対象者明細entity().
                    getサービス種類コード() == null) {
                kogaEntity.set事業者名(null);
            } else {
                DbT7060KaigoJigyoshaEntity 介護事業者名称 = 介護事業者管理Dac.select事業者の名称(
                        kogaEntity.get給付対象者明細entity().get事業者番号(),
                        new FlexibleDate(サービス提供年月.toString()));
                DbT7063KaigoJigyoshaShiteiServiceEntity 介護事業者指定事業者名称 = 介護事業者指定サービスDac.
                        select事業者名称(kogaEntity.get給付対象者明細entity().get事業者番号().value(),
                                kogaEntity.get給付対象者明細entity().
                                getサービス種類コード().value(), new FlexibleDate(サービス提供年月.toString()));
                set事業高額の事業者名称(介護事業者名称, 介護事業者指定事業者名称, kogaEntity);
            }
            if (kogaEntity.get給付対象者明細entity().getサービス種類コード() == null
                    || kogaEntity.get給付対象者明細entity().getサービス種類コード().value() == null) {
                kogaEntity.setサービス種類(null);
            } else {
                DbT7130KaigoServiceShuruiEntity 種類略称 = 介護サービス種類Dac.selectサービス種類名称Andサービス種類略称(
                        kogaEntity.get給付対象者明細entity().getサービス種類コード().value(), サービス提供年月);
                set事業高額のサービス種類(種類略称, kogaEntity);
            }
        }
    }

    private void set事業者名称(DbT7060KaigoJigyoshaEntity 介護事業者名称,
            DbT7063KaigoJigyoshaShiteiServiceEntity 介護事業者指定事業者名称,
            KogakuKyuufuTaishouListEntityResult result) {
        if (介護事業者名称 == null || 介護事業者指定事業者名称 == null) {
            result.set事業者名(null);
        } else if (ONE_RS.equals(介護事業者指定事業者名称.getKihonJohoJunkyoKubun())) {
            result.set事業者名(介護事業者名称.getJigyoshaName().value());
        } else if (ZERO_RS.equals(介護事業者指定事業者名称.getKihonJohoJunkyoKubun())) {
            result.set事業者名(介護事業者指定事業者名称.getJigyoshaName().value());
        }
    }

    private void set事業高額の事業者名称(DbT7060KaigoJigyoshaEntity 介護事業者名称,
            DbT7063KaigoJigyoshaShiteiServiceEntity 介護事業者指定事業者名称,
            JigyouKogakuKyuufuTaishouResult result) {
        if (介護事業者名称 == null || 介護事業者指定事業者名称 == null) {
            result.set事業者名(null);
        } else if (ONE_RS.equals(介護事業者指定事業者名称.getKihonJohoJunkyoKubun())) {
            result.set事業者名(介護事業者名称.getJigyoshaName().value());
        } else if (ZERO_RS.equals(介護事業者指定事業者名称.getKihonJohoJunkyoKubun())) {
            result.set事業者名(介護事業者指定事業者名称.getJigyoshaName().value());
        }
    }

    private void setサービス種類(DbT7130KaigoServiceShuruiEntity 種類略称,
            KogakuKyuufuTaishouListEntityResult result) {
        if (種類略称 == null) {
            result.setサービス種類(null);
        } else {
            result.setサービス種類(種類略称.getServiceShuruiRyakusho());
        }
    }

    private void set事業高額のサービス種類(DbT7130KaigoServiceShuruiEntity 種類略称,
            JigyouKogakuKyuufuTaishouResult result) {
        if (種類略称 == null) {
            result.setサービス種類(null);
        } else {
            result.setサービス種類(種類略称.getServiceShuruiRyakusho());
        }
    }
}
