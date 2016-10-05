/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kaigokyufuhikagomositatetouroku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kaigokyufuhikagomositatetouroku.KaigoKyufuhiKagoMositateTourokuResult;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kaigokyufuhikagomositatetouroku.KaigoKyufuhiParamter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3059KagoMoshitateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigokyufuhikagomositatetouroku.KaigoKyufuhiKagoMositateTourokuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3059KagoMoshitateDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kaigokyufuhikagomositatetouroku.IKaigoKyufuhiKagoMositateTourokuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7056GappeiShichosonDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1001HihokenshaDaichoAliveDac;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護給付費過誤申立登録（事業分、経過措置分含む）のビジネスクラスです。
 *
 * @reamsid_L DBC-2220-030 dongyabin
 */
public class KaigoKyufuhiKagoMositateTourokuFinder {

    private final MapperProvider mapperProvider;
    private final DbT3059KagoMoshitateDac dbT3059dac;
    private final DbT7051KoseiShichosonMasterDac dbT7051dac;
    private final DbT7056GappeiShichosonDac dbT7056dac;
    private final DbV1001HihokenshaDaichoAliveDac dbv1001dac;

    /**
     * コンストラクタです。
     */
    KaigoKyufuhiKagoMositateTourokuFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT3059dac = InstanceProvider.create(DbT3059KagoMoshitateDac.class);
        this.dbT7051dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
        this.dbT7056dac = InstanceProvider.create(DbT7056GappeiShichosonDac.class);
        this.dbv1001dac = InstanceProvider.create(DbV1001HihokenshaDaichoAliveDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvide mapperProvide
     * @param dbT3059dac dac
     * @param dbT7051dac dbT7051dac
     * @param dbT7056dac dbT7056dac
     * @param dbv1001dac dbv1001dac
     */
    KaigoKyufuhiKagoMositateTourokuFinder(MapperProvider mapperProvide,
            DbT3059KagoMoshitateDac dbT3059dac,
            DbT7051KoseiShichosonMasterDac dbT7051dac,
            DbT7056GappeiShichosonDac dbT7056dac,
            DbV1001HihokenshaDaichoAliveDac dbv1001dac) {
        this.mapperProvider = mapperProvide;
        this.dbT3059dac = dbT3059dac;
        this.dbT7051dac = dbT7051dac;
        this.dbT7056dac = dbT7056dac;
        this.dbv1001dac = dbv1001dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaigoKyufuhiKagoMositateTourokuFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KaigoKyufuhiKagoMositateTourokuFinder}のインスタンス
     */
    public static KaigoKyufuhiKagoMositateTourokuFinder createInstance() {
        return InstanceProvider.create(KaigoKyufuhiKagoMositateTourokuFinder.class);
    }

    /**
     * 過誤申立情報の最大連番取得します。
     *
     * @param 事業所番号 事業所番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @return 最大連番
     */
    public int selectKyufuKanrihyoList(JigyoshaNo 事業所番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月) {
        DbT3059KagoMoshitateEntity entity = dbT3059dac.getMax履歴番号(事業所番号, 被保険者番号, サービス提供年月);
        if (entity != null) {
            return entity.getRirekiNo();
        }
        return 0;
    }

    /**
     * 給付実績一覧取得します。
     *
     * @param param パラメータ
     * @return SearchResult<KaigoKyufuhiKagoMositateTourokuResult>
     */
    public SearchResult<KaigoKyufuhiKagoMositateTourokuResult> selectKyufuJissekiList(KaigoKyufuhiParamter param) {
        List<KaigoKyufuhiKagoMositateTourokuResult> result = new ArrayList<>();
        IKaigoKyufuhiKagoMositateTourokuMapper mapper = mapperProvider.create(IKaigoKyufuhiKagoMositateTourokuMapper.class);
        List<KaigoKyufuhiKagoMositateTourokuEntity> entityList = mapper.get給付実績一覧(param);
        for (KaigoKyufuhiKagoMositateTourokuEntity entity : entityList) {
            entity.initializeMd5ToEntities();
            result.add(new KaigoKyufuhiKagoMositateTourokuResult(entity));
        }
        return SearchResult.of(result, 0, false);
    }

    /**
     * 保険者が単一保険者の場合の証記載保険者名の取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return 旧市町村名称
     */
    public RString get旧市町村名称(RString 証記載保険者番号) {
        List<DbT7056GappeiShichosonEntity> entityList = dbT7056dac.get旧市町村名称(証記載保険者番号);
        if (!entityList.isEmpty()) {
            return entityList.get(0).getKyuShichosonMeisho();
        }
        return RString.EMPTY;
    }

    /**
     * 保険者が広域保険者の場合、証記載保険者名の取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return 市町村名称
     */
    public RString get市町村名称(RString 証記載保険者番号) {
        List<DbT7051KoseiShichosonMasterEntity> entityList = dbT7051dac.get市町村名称(証記載保険者番号);
        if (!entityList.isEmpty()) {
            return entityList.get(0).getShichosonMeisho();
        }
        return RString.EMPTY;
    }

    /**
     * 被保険者番号より、識別コードを取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード(HihokenshaNo 被保険者番号) {
        DbV1001HihokenshaDaichoEntity entity = dbv1001dac.get最新の被保険者台帳情報(被保険者番号);
        if (entity == null) {
            return ShikibetsuCode.EMPTY;
        }
        return entity.getShikibetsuCode();
    }
}
