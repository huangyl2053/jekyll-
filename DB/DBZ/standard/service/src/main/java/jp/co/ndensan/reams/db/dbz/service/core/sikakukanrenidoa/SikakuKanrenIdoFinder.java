/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.sikakukanrenidoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.gappeijoho.gappeishichoson.GappeiShichoson;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBZCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koseishichosonmaster.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.business.core.sikakujiyushutoku.SikakuJiyuShutoku;
import jp.co.ndensan.reams.db.dbz.business.core.sikakukanrenido.SikakuKanrenIdo;
import jp.co.ndensan.reams.db.dbz.business.core.sikakukanrenidoa.HenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.sikakukanrenido.SikakuKanrenIdoParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.SikakuKanrenIdoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shikakujiyushutoku.ShikakuJiyuShutoku;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.sikakukanrenido.ISikakuKanrenIdoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.kyushichosoncode.KyuShichosonCode;
import jp.co.ndensan.reams.db.dbz.service.core.kyushichosoncode.KyuShichosonCodeJoho;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 資格関連異動クラスです。
 *
 * @reamsid_L DBA-0120-010 wanghui
 */
public class SikakuKanrenIdoFinder {

    private final MapperProvider mapperProvider;
    private final DbT7051KoseiShichosonMasterDac db7051Dac;
    private final SikakuJiyuShutoku sikaku;

    /**
     * コンストラクタです。
     *
     */
    public SikakuKanrenIdoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.db7051Dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
        this.sikaku = InstanceProvider.create(SikakuJiyuShutoku.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param db7051Dac DbT7051KoseiShichosonMasterDac
     * @param sikaku SikakuJiyuShutoku
     */
    SikakuKanrenIdoFinder(MapperProvider mapperProvider,
            DbT7051KoseiShichosonMasterDac db7051Dac,
            SikakuJiyuShutoku sikaku) {
        this.mapperProvider = mapperProvider;
        this.db7051Dac = db7051Dac;
        this.sikaku = sikaku;
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
     * @return 所在保険者リスト
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
        CodeShubetsu 介護予防短期入所療養介護 = DBZCodeShubetsu.施設等の区分コード_介護予防短期入所療養介護_老健.getコード();
        List<ShikakuJiyuShutoku> 資格事由取得List = sikaku.
                shikakuJiyuShutoku(介護予防短期入所療養介護,
                        FlexibleDate.getNowDate(), 市町村セキュリティ.get導入形態コード().getKey(),
                        DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
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
                getKyuShichosonCodeJoho(
                        市町村セキュリティ.get市町村情報() == null ? null : 市町村セキュリティ.get市町村情報().get市町村コード(),
                        DonyuKeitaiCode.toValue(市町村セキュリティ.get導入形態コード().getKey() == null
                                ? null : 市町村セキュリティ.get導入形態コード().getKey()));
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
