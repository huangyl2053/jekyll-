/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.kaigohohenshisetsunyutaishoshakanri;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.kaigohohenshisetsu.KaigoHohenShisetsuMybatisParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kaigohohenshisetsu.KaigoHohenShisetsuRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.kaigohohenshisetsu.IKaigoHohenShisetsuMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1004ShisetsuNyutaishoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 施設入退所履歴の管理クラスです。
 *
 */
public class KaigoHohenShisetsuNyutaishoshaKanriManager {

    private static final RString 介護保険施設 = new RString("11");
    private static final RString 住所地特例対象施設 = new RString("12");
    private static final RString 適用除外施設 = new RString("21");
    private final MapperProvider mapperProvider;
    private final DbT1004ShisetsuNyutaishoDac dac;

    /**
     * コンストラクタです。
     */
    public KaigoHohenShisetsuNyutaishoshaKanriManager() {
        dac = InstanceProvider.create(DbT1004ShisetsuNyutaishoDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    KaigoHohenShisetsuNyutaishoshaKanriManager(MapperProvider mapperProvider, DbT1004ShisetsuNyutaishoDac dac) {
        this.dac = dac;
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaigoHohenShisetsuNyutaishoshaKanriManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KaigoHohenShisetsuNyutaishoshaKanriManager}のインスタンス
     */
    public static KaigoHohenShisetsuNyutaishoshaKanriManager createInstance() {
        return InstanceProvider.create(KaigoHohenShisetsuNyutaishoshaKanriManager.class);
    }

    /**
     * 施設種類によって、施設入退所履歴一覧データを取得します。
     *
     * @param 識別コード 識別コード
     * @return SearchResult<KaigoHohenShisetsuRelateEntity> 介護保険入退所履歴リスト
     */
    public SearchResult<KaigoHohenShisetsuRelateEntity> select介護保険施設入退所一覧By識別コード(ShikibetsuCode 識別コード) {
        IKaigoHohenShisetsuMapper mapper = mapperProvider.create(IKaigoHohenShisetsuMapper.class);
        List<DbT1004ShisetsuNyutaishoEntity> entityList = mapper.getShiSeTsuJyoHon(new KaigoHohenShisetsuMybatisParameter(識別コード, null, null));
        List<KaigoHohenShisetsuRelateEntity> resultList = new ArrayList<>();
        for (DbT1004ShisetsuNyutaishoEntity entity : entityList) {
            if (介護保険施設.equals(entity.getNyushoShisetsuShurui())) {
                resultList.addAll(mapper.getShiSeTsuJyoHon_A(new KaigoHohenShisetsuMybatisParameter(識別コード, 介護保険施設,
                        entity.getNyushoShisetsuCode().getColumnValue())));
            } else if (住所地特例対象施設.equals(entity.getNyushoShisetsuShurui())) {
                resultList.addAll(mapper.getShiSeTsuJyoHon_I(new KaigoHohenShisetsuMybatisParameter(識別コード, 住所地特例対象施設,
                        entity.getNyushoShisetsuCode().getColumnValue())));
            } else if (適用除外施設.equals(entity.getNyushoShisetsuShurui())) {
                resultList.addAll(mapper.getShiSeTsuJyoHon_I(new KaigoHohenShisetsuMybatisParameter(識別コード, 適用除外施設,
                        entity.getNyushoShisetsuCode().getColumnValue())));
            }
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 施設入退所履歴一覧データを取得する。
     *
     * @param 識別コード 識別コード
     * @return SearchResult<ShisetsuNyutaisho> 介護保険入退所履歴リスト
     */
    public SearchResult<ShisetsuNyutaisho> get介護保険施設入退所一覧By識別コード(ShikibetsuCode 識別コード) {
        IKaigoHohenShisetsuMapper mapper = mapperProvider.create(IKaigoHohenShisetsuMapper.class);
        List<ShisetsuNyutaisho> businessList = new ArrayList<>();
        List<DbT1004ShisetsuNyutaishoEntity> entityList = mapper.getShiSeTsuJyoHon(new KaigoHohenShisetsuMybatisParameter(識別コード, null, null));
        for (DbT1004ShisetsuNyutaishoEntity entity : entityList) {
            entity.initializeMd5();
            businessList.add(new ShisetsuNyutaisho(entity));
        }

        return SearchResult.of(businessList, businessList.size(), true);
    }

    /**
     * 施設入退所履歴一覧情報{@link ShisetsuNyutaisho}を追加します。
     *
     * @param 施設入退所履歴一覧情報 {@link ShisetsuNyutaisho}
     * @return 追加件数 追加結果の件数を返します。
     */
    @Transaction
    public boolean 施設入退所履歴一覧情報の追加(ShisetsuNyutaisho 施設入退所履歴一覧情報) {
        requireNonNull(施設入退所履歴一覧情報,
                UrSystemErrorMessages.値がnull.getReplacedMessage("施設入退所履歴一覧情報"));
        if (!施設入退所履歴一覧情報.hasChanged()) {
            return false;
        }
        DbT1004ShisetsuNyutaishoEntity dbT1004Entity = 施設入退所履歴一覧情報.toEntity();
        dbT1004Entity.setState(EntityDataState.Added);
        return 1 == dac.save(dbT1004Entity);
    }

    /**
     * 施設入退所履歴一覧情報{@link ShisetsuNyutaisho}を削除します。
     *
     * @param 施設入退所履歴一覧情報 {@link ShisetsuNyutaisho}
     * @return 削除件数 削除結果の件数を返します。
     */
    @Transaction
    public boolean 施設入退所履歴一覧情報の削除(ShisetsuNyutaisho 施設入退所履歴一覧情報) {
        requireNonNull(施設入退所履歴一覧情報,
                UrSystemErrorMessages.値がnull.getReplacedMessage("施設入退所履歴一覧情報"));
        DbT1004ShisetsuNyutaishoEntity dbT1004Entity = 施設入退所履歴一覧情報.toEntity();
        dbT1004Entity.setState(EntityDataState.Deleted);
        return 1 == dac.save(dbT1004Entity);
    }

    /**
     * 施設入退所履歴一覧情報{@link ShisetsuNyutaisho}を更新します。
     *
     * @param 施設入退所履歴一覧情報 {@link ShisetsuNyutaisho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean 介護認定審査会開催場所情報の更新(ShisetsuNyutaisho 施設入退所履歴一覧情報) {
        requireNonNull(施設入退所履歴一覧情報,
                UrSystemErrorMessages.値がnull.getReplacedMessage("施設入退所履歴一覧情報"));
        if (!施設入退所履歴一覧情報.hasChanged()) {
            return false;
        }
        DbT1004ShisetsuNyutaishoEntity dbT1004Entity = 施設入退所履歴一覧情報.toEntity();
        dbT1004Entity.setState(EntityDataState.Modified);
        return 1 == dac.save(dbT1004Entity);
    }

}
