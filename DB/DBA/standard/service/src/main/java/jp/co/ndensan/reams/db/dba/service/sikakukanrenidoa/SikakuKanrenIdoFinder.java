/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.sikakukanrenidoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.HenkoJiyu;
import jp.co.ndensan.reams.db.dba.business.core.koseishichosonmaster.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dba.business.core.sikakukanrenido.SikakuKanrenIdo;
import jp.co.ndensan.reams.db.dba.definition.param.sikakukanrenido.SikakuKanrenIdoParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.SikakuKanrenIdoEntity;
import jp.co.ndensan.reams.db.dba.persistence.mapper.basic.sikakukanrenido.ISikakuKanrenIdoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.DonyukeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.gappeijoho.gappeishichoson.GappeiShichoson;
import jp.co.ndensan.reams.db.dbz.business.sikakujiyushutoku.SikakuJiyuShutoku;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.gappei.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.koseishichoson.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shikakujiyushutoku.ShikakuJiyuShutoku;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.service.KyuShichosonCode;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.kyushichosoncode.KyuShichosonCodeJoho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 資格関連異動クラスです。
 */
public class SikakuKanrenIdoFinder {

    private final MapperProvider mapperProvider;
    private final DbT7051KoseiShichosonMasterDac db7051Dac;
    private final SikakuJiyuShutoku sikaku;

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param DbT7051KoseiShichosonMasterDac db7051Dac
     * @param SikakuJiyuShutoku sikaku
     */
    public SikakuKanrenIdoFinder(MapperProvider mapperProvider,
            DbT7051KoseiShichosonMasterDac db7051Dac,
            SikakuJiyuShutoku sikaku) {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.db7051Dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
        this.sikaku = InstanceProvider.create(SikakuJiyuShutoku.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SikakuKanrenIdoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SikakuKanrenIdoFinder}のインスタンス
     */
    public static SikakuKanrenIdoFinder createInstance() {
        return InstanceProvider.create(SikakuKanrenIdoFinder.class);
    }

    /**
     * 一覧データ取得リストを取得する。
     *
     * @param params SikakuKanrenIdoParameter
     * @return 一覧データ取得取得リスト
     */
    public SearchResult<SikakuKanrenIdo> getSikakuKanrenIdo(SikakuKanrenIdoParameter params) {
        if ((params.getHihokenshaNo() == null || params.getHihokenshaNo().isEmpty())
                && (params.getshikibetsuCode() == null || params.getshikibetsuCode().isEmpty())) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り.getMessage());
        }
        ISikakuKanrenIdoMapper shikakuTokusoMappers = mapperProvider.create(ISikakuKanrenIdoMapper.class);
        List<SikakuKanrenIdoEntity> 一覧データ取得リスト = shikakuTokusoMappers.getSikakuKanrenIdo(params);
        if (一覧データ取得リスト == null || 一覧データ取得リスト.isEmpty()) {
            return SearchResult.of(Collections.<SikakuKanrenIdo>emptyList(), 0, false);
        }
        List<SikakuKanrenIdo> serviceShuruiList = new ArrayList<>();
        for (SikakuKanrenIdoEntity entity : 一覧データ取得リスト) {
            serviceShuruiList.add(new SikakuKanrenIdo(entity));
        }
        return SearchResult.of(serviceShuruiList, 0, false);
    }

    /**
     * 所在保険者リスト情報取得。
     *
     * @return　所在保険者リスト
     */
    @Transaction
    public SearchResult<KoseiShichosonMaster> selectByKoseiShichosonMasterList() {

        List<KoseiShichosonMaster> serviceShuruiList = new ArrayList<>();
        List<DbT7051KoseiShichosonMasterEntity> 所在保険者リスト = db7051Dac.selectByKoseiShichosonMasterList();
        if (所在保険者リスト == null || 所在保険者リスト.isEmpty()) {
            return SearchResult.of(Collections.<KoseiShichosonMaster>emptyList(), 0, false);
        }
        for (DbT7051KoseiShichosonMasterEntity entity : 所在保険者リスト) {
            serviceShuruiList.add(new KoseiShichosonMaster(entity));
        }
        return SearchResult.of(serviceShuruiList, 0, false);
    }

    /**
     * 変更事由リスト情報を取得。
     *
     * @return 変更事由リスト
     */
    @Transaction
    public SearchResult<HenkoJiyu> getHenkoJiyuList() {
        List<HenkoJiyu> serviceShuruiList = new ArrayList<>();
        ShichosonSecurityJoho 市町村セキュリティ = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        List<ShikakuJiyuShutoku> 資格事由取得List = sikaku.
                shikakuJiyuShutoku(new CodeShubetsu("0126"),
                        FlexibleDate.getNowDate(), 市町村セキュリティ.get導入形態コード().getKey(),
                        BusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, SubGyomuCode.DBU介護統計報告));
        for (ShikakuJiyuShutoku entity : 資格事由取得List) {
            HenkoJiyu list = new HenkoJiyu();
            list.setCode(entity.getCode());
            list.setCodeRyakusho(entity.getCodeRyakusho());
            serviceShuruiList.add(list);
        }
        return SearchResult.of(serviceShuruiList, 0, true);
    }

    /**
     * 市町村セキュリティ取得。
     *
     * @return 旧市町村コード情報List
     */
    public SearchResult<GappeiShichoson> getGappeiShichosonList() {
        List<GappeiShichoson> 旧市町村コード情報List = new ArrayList<>();
        ShichosonSecurityJoho 市町村セキュリティ = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        KyuShichosonCodeJoho 旧市町村コード情報 = KyuShichosonCode.
                getKyuShichosonCodeJoho(市町村セキュリティ.get市町村情報().get市町村コード(),
                        DonyukeitaiCode.toValue(市町村セキュリティ.get導入形態コード().getKey()));
        if (旧市町村コード情報 == null) {

            return SearchResult.of(Collections.<GappeiShichoson>emptyList(), 0, false);
        } else {
            for (KyuShichosonCode entity : 旧市町村コード情報.get旧市町村コード情報List()) {
                DbT7056GappeiShichosonEntity dbT7056GappeiShichosonEntity = new DbT7056GappeiShichosonEntity();
                dbT7056GappeiShichosonEntity.setKyuShichosonCode(entity.get旧市町村コード());
                dbT7056GappeiShichosonEntity.setKyuHokenshaNo(entity.get旧保険者番号());
                dbT7056GappeiShichosonEntity.setKyuShichosonMeisho(entity.get旧市町村名称());
                旧市町村コード情報List.add(new GappeiShichoson(dbT7056GappeiShichosonEntity));
            }
            return SearchResult.of(旧市町村コード情報List, 0, false);
        }
    }
}
