/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.chohyoseigyokyotsucontro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.chohyoseigyokyotsucontro.ChohyoSeigyoKyotsuParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7066ChohyoSeigyoKyotsuControlEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7066ChohyoSeigyoKyotsuControlDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic.IDbT7065ChohyoSeigyoKyotsuMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 帳票選択データの取得処理クラスです。
 *
 * @reamsid_L DBA-1201-010 wanghui
 */
public class ChohyoSeigyoKyotsuControFinder {

    private final MapperProvider mapperProvider;
    private final DbT7066ChohyoSeigyoKyotsuControlDac dbT7066dac;

    /**
     * コンストラクタです。
     */
    public ChohyoSeigyoKyotsuControFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT7066dac = InstanceProvider.create(DbT7066ChohyoSeigyoKyotsuControlDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param DbT4001JukyushaDaichoDac
     * @param DbT1001HihokenshaDaichoDac
     */
    ChohyoSeigyoKyotsuControFinder(
            MapperProvider mapperProvider,
            DbT7066ChohyoSeigyoKyotsuControlDac dbT7066dac) {
        this.mapperProvider = mapperProvider;
        this.dbT7066dac = dbT7066dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ChohyoSeigyoKyotsuControFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ChohyoSeigyoKyotsuControFinder}のインスタンス
     */
    public static ChohyoSeigyoKyotsuControFinder createInstance() {
        return InstanceProvider.create(ChohyoSeigyoKyotsuControFinder.class);
    }

    /**
     * 帳票分類名称をセットする。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 共通画面使用有無 boolean
     * @return 帳票分類名称
     */
    @Transaction
    public SearchResult<ChohyoSeigyoKyotsu> select帳票分類名称(SubGyomuCode サブ業務コード, boolean 共通画面使用有無) {
        List<ReportId> 帳票分類ID = new ArrayList<>();
        List<DbT7066ChohyoSeigyoKyotsuControlEntity> 帳票分類IDリスト = dbT7066dac.select帳票分類ID(サブ業務コード, 共通画面使用有無);
        for (DbT7066ChohyoSeigyoKyotsuControlEntity entitylist : 帳票分類IDリスト) {
            帳票分類ID.add(entitylist.getChohyoBunruiID());
        }
        List<ChohyoSeigyoKyotsu> serviceShuruiList = new ArrayList<>();
        ChohyoSeigyoKyotsuParameter params = ChohyoSeigyoKyotsuParameter.createParam(サブ業務コード, 帳票分類ID);
        IDbT7065ChohyoSeigyoKyotsuMapper mapper = mapperProvider.create(IDbT7065ChohyoSeigyoKyotsuMapper.class);
        List<DbT7065ChohyoSeigyoKyotsuEntity> 帳票分類名称 = mapper.get帳票分類名称(params);
        if (帳票分類名称 == null || 帳票分類名称.isEmpty()) {
            return SearchResult.of(Collections.<ChohyoSeigyoKyotsu>emptyList(), 0, false);
        }
        for (DbT7065ChohyoSeigyoKyotsuEntity entity : 帳票分類名称) {
            serviceShuruiList.add(new ChohyoSeigyoKyotsu(entity));
        }
        return SearchResult.of(serviceShuruiList, 0, false);
    }
}
