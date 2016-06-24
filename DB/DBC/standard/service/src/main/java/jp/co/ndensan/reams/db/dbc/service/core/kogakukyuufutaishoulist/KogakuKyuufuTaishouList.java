/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakukyuufutaishoulist;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.kogakukyuufutaishoulist.KogakuKyuufuTaishouListEntityResult;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukyuufutaishoulist.KogakuKyuufuTaishouListParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyuufutaishoulist.KogakuKyuufuTaishouListEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukyuufutaishoulist.IKogakuKyuufuTaishouListMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
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

    private final MapperProvider mapperProvider;
    private final DbT7060KaigoJigyoshaDac 介護事業者管理Dac;
    private final DbT7063KaigoJigyoshaShiteiServiceDac 介護事業者指定サービスDac;
    private final DbT7130KaigoServiceShuruiDac 介護サービス種類Dac;
    private static final RString ZERO_RS = new RString("0");
    private static final RString ONE_RS = new RString("1");

    /**
     * コンストラクタです。
     */
    public KogakuKyuufuTaishouList() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.介護事業者管理Dac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
        this.介護事業者指定サービスDac = InstanceProvider.create(DbT7063KaigoJigyoshaShiteiServiceDac.class);
        this.介護サービス種類Dac = InstanceProvider.create(DbT7130KaigoServiceShuruiDac.class);
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
        IKogakuKyuufuTaishouListMapper mapper = mapperProvider.create(IKogakuKyuufuTaishouListMapper.class);
        KogakuKyuufuTaishouListParameter parameter = new KogakuKyuufuTaishouListParameter(被保険者番号, サービス提供年月);
        List<KogakuKyuufuTaishouListEntity> kotaList = mapper.getKogakuKyuufuTaishouList(parameter);
        List<KogakuKyuufuTaishouListEntityResult> result = new ArrayList<>();
        if (kotaList == null || kotaList.isEmpty()) {
            return new ArrayList<>();
        } else {
            for (KogakuKyuufuTaishouListEntity entity : kotaList) {
                result.add(new KogakuKyuufuTaishouListEntityResult(entity));
            }
        }
        set事業者名称と種類(サービス提供年月, result);
        return result;
    }

    /**
     * 高額給付対象一覧情報（事業高額）取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @return List<KogakuKyuufuTaishouListEntity>
     */
    public List<KogakuKyuufuTaishouListEntityResult> getJigyouKogakuKyuufuTaishouList(
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        IKogakuKyuufuTaishouListMapper mapper = mapperProvider.create(IKogakuKyuufuTaishouListMapper.class);
        KogakuKyuufuTaishouListParameter parameter = new KogakuKyuufuTaishouListParameter(被保険者番号, サービス提供年月);
        List<KogakuKyuufuTaishouListEntity> kotaList = mapper.getJigyouKogakuKyuufuTaishouList(parameter);
        List<KogakuKyuufuTaishouListEntityResult> result = new ArrayList<>();
        if (kotaList == null || kotaList.isEmpty()) {
            return new ArrayList<>();
        } else {
            for (KogakuKyuufuTaishouListEntity entity : kotaList) {
                result.add(new KogakuKyuufuTaishouListEntityResult(entity));
            }
        }
        set事業者名称と種類(サービス提供年月, result);
        return result;
    }

    private void set事業者名称と種類(FlexibleYearMonth サービス提供年月,
            List<KogakuKyuufuTaishouListEntityResult> result) {
        for (KogakuKyuufuTaishouListEntityResult kogaEntity : result) {
            if (kogaEntity.getEntity().get事業者番号() == null || kogaEntity.getEntity().
                    getサービス種類コード() == null) {
                kogaEntity.getEntity().set事業者名(null);
            } else {
                DbT7060KaigoJigyoshaEntity 介護事業者名称 = 介護事業者管理Dac.select事業者の名称(
                        kogaEntity.getEntity().get事業者番号(), new FlexibleDate(サービス提供年月.toString()));
                DbT7063KaigoJigyoshaShiteiServiceEntity 介護事業者指定事業者名称 = 介護事業者指定サービスDac.
                        select事業者名称(kogaEntity.getEntity().get事業者番号().value(), kogaEntity.getEntity().
                                getサービス種類コード().value(), new FlexibleDate(サービス提供年月.toString()));
                set事業者名称(介護事業者名称, 介護事業者指定事業者名称, kogaEntity);
            }
            if (kogaEntity.getEntity().getサービス種類コード() == null
                    || kogaEntity.getEntity().getサービス種類コード().value() == null) {
                kogaEntity.getEntity().setサービス種類(null);
            } else {
                DbT7130KaigoServiceShuruiEntity 種類略称 = 介護サービス種類Dac.selectサービス種類名称Andサービス種類略称(
                        kogaEntity.getEntity().getサービス種類コード().value(), サービス提供年月);
                setサービス種類(種類略称, kogaEntity);
            }
        }
    }

    private void set事業者名称(DbT7060KaigoJigyoshaEntity 介護事業者名称,
            DbT7063KaigoJigyoshaShiteiServiceEntity 介護事業者指定事業者名称,
            KogakuKyuufuTaishouListEntityResult result) {
        if (介護事業者名称 == null || 介護事業者指定事業者名称 == null) {
            result.getEntity().set事業者名(null);
        } else if (ONE_RS.equals(介護事業者指定事業者名称.getKihonJohoJunkyoKubun())) {
            result.getEntity().set事業者名(介護事業者名称.getJigyoshaName().value());
        } else if (ZERO_RS.equals(介護事業者指定事業者名称.getKihonJohoJunkyoKubun())) {
            result.getEntity().set事業者名(介護事業者指定事業者名称.getJigyoshaName().value());
        }
    }

    private void setサービス種類(DbT7130KaigoServiceShuruiEntity 種類略称,
            KogakuKyuufuTaishouListEntityResult result) {
        if (種類略称 == null) {
            result.getEntity().setサービス種類(null);
        } else {
            result.getEntity().setサービス種類(種類略称.getServiceShuruiRyakusho());
        }
    }
}
