package jp.co.ndensan.reams.db.dba.service.core.shikakushutokujogaishakanri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.shikakushutokujogaishakanri.ShikakuShutokuJogaishaKanri;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.shikakushutokujogaishakanri.ShikakuShutokuJogaishaKanriParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.shikakushutokujogaishakanri.ShikakuShutokuJogaishaKanriEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.shikakushutoku.IShikakuShutokuJogaishaKanriMapper;
import jp.co.ndensan.reams.db.dbz.business.core.ShikakuShutokuJogaisha;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1009ShikakuShutokuJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1009ShikakuShutokuJogaishaDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 資格取得除外者管理の取得します。
 *
 * @reamsid_L DBA-0440-030 zhangzhiming
 */
public class ShikakuShutokuJogaishaKanriManager {

    private final MapperProvider mapperProvider;
    private final DbT1009ShikakuShutokuJogaishaDac dac;

    /**
     * コンストラクタです。
     */
    ShikakuShutokuJogaishaKanriManager(MapperProvider mapperProvider, DbT1009ShikakuShutokuJogaishaDac dac) {
        this.mapperProvider = mapperProvider;
        this.dac = dac;
    }

    /**
     * コンストラクタです。
     */
    public ShikakuShutokuJogaishaKanriManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dac = InstanceProvider.create(DbT1009ShikakuShutokuJogaishaDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShikakuShutokuJogaishaKanriManager}のインスタンスを返します。
     *
     * @return KijuntsukiShichosonjohoFinder
     */
    public static ShikakuShutokuJogaishaKanriManager createInstance() {
        return InstanceProvider.create(ShikakuShutokuJogaishaKanriManager.class);
    }

    /**
     * 資格取得除外者一覧取得します。
     *
     * @return SearchResult<ShikakuShutokuJogaishaKanri>
     */
    @Transaction
    public SearchResult<ShikakuShutokuJogaishaKanri> getTennyuHoryuTokuteiJushoIchiran() {
        IShikakuShutokuJogaishaKanriMapper mapper = mapperProvider.create(IShikakuShutokuJogaishaKanriMapper.class);
        List<ShikakuShutokuJogaishaKanriEntity> entityList = mapper.get資格取得除外者一覧();
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<ShikakuShutokuJogaishaKanri>emptyList(), 0, false);
        }
        List<ShikakuShutokuJogaishaKanri> businessList = new ArrayList<>();
        for (ShikakuShutokuJogaishaKanriEntity entity : entityList) {
            ShikakuShutokuJogaishaKanriEntity shikakuentity = 宛名情報(entity.getShikibetsuCode());
            if (shikakuentity != null) {
                entity.setMeisho(shikakuentity.getMeisho());
                entity.setSeinengappiYMD(shikakuentity.getSeinengappiYMD());
                entity.setSeibetsuCode(shikakuentity.getSeibetsuCode());
                entity.setJuminJotaiCode(shikakuentity.getJuminJotaiCode());
            }
            businessList.add(new ShikakuShutokuJogaishaKanri(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 資格取得除外者一覧取得します。
     *
     * @return SearchResult<ShikakuShutokuJogaisha>
     */
    @Transaction
    public SearchResult<ShikakuShutokuJogaisha> get資格取得除外者一覧() {
        List<DbT1009ShikakuShutokuJogaishaEntity> entityList = dac.select一覧();
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<ShikakuShutokuJogaisha>emptyList(), 0, false);
        }
        List<ShikakuShutokuJogaisha> businessList = new ArrayList<>();
        for (DbT1009ShikakuShutokuJogaishaEntity entity : entityList) {
            entity.initializeMd5();
            businessList.add(new ShikakuShutokuJogaisha(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    private ShikakuShutokuJogaishaKanriEntity 宛名情報(ShikibetsuCode 識別コード) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        ShikakuShutokuJogaishaKanriParameter parameter = new ShikakuShutokuJogaishaKanriParameter(
                識別コード, new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        IShikakuShutokuJogaishaKanriMapper mapper = mapperProvider.create(IShikakuShutokuJogaishaKanriMapper.class);
        return mapper.get宛名情報(parameter);
    }

    /**
     * 宛名情報取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @return ShikakuShutokuJogaishaKanri
     */
    @Transaction
    public ShikakuShutokuJogaishaKanri get宛名情報(ShikibetsuCode 識別コード) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        key.set識別コード(識別コード);

        IKojin kojin = null;
        List<IKojin> kojins = ShikibetsuTaishoService.getKojinFinder().get個人s(key.build());
        if (kojins != null && !kojins.isEmpty()) {
            kojin = kojins.get(0);
        }

        ShikakuShutokuJogaishaKanriEntity entity = new ShikakuShutokuJogaishaKanriEntity();
        if (kojin != null) {
            entity.setJuminJotaiCode(kojin.get住民状態().コード());
            entity.setMeisho(kojin.get名称().getName());
            entity.setSeibetsuCode(kojin.get性別().code());
            entity.setSeinengappiYMD(kojin.get生年月日().toFlexibleDate());
        }
        return new ShikakuShutokuJogaishaKanri(entity);
    }

    /**
     * 資格取得除外者登録します。
     *
     * @param insertKuJogaishaList 資格取得除外者登録リスト
     * @return insertCount 資格取得除外者登録件数
     */
    @Transaction
    public int insertShikakuShutokuJogaisha(List<ShikakuShutokuJogaisha> insertKuJogaishaList) {
        int insertCount = 0;
        for (ShikakuShutokuJogaisha shikakuShutokuJogaisha : insertKuJogaishaList) {
            DbT1009ShikakuShutokuJogaishaEntity shikakuentity = shikakuShutokuJogaisha.toEntity();
            int 履歴番号 = dac.select履歴番号(shikakuentity.getShikibetsuCode()) == null
                    ? 1 : dac.select履歴番号(shikakuentity.getShikibetsuCode()).getRirekiNo();
            if (!EntityDataState.Added.equals(shikakuentity.getState())) {
                if (shikakuentity.getRirekiNo() <= 履歴番号) {
                    shikakuentity.setRirekiNo(履歴番号 + 1);
                } else {
                    shikakuentity.setRirekiNo(shikakuentity.getRirekiNo() + 1);
                }
            }
            shikakuentity.setIsDeleted(false);
            shikakuentity.setState(EntityDataState.Added);
            insertCount = insertCount + dac.save(shikakuentity);
        }
        return insertCount;
    }

    /**
     * 資格取得除外者更新します。
     *
     * @param updateKuJogaishaList 資格取得除外者更新リスト
     * @return updateCount 資格取得除外者更新件数
     */
    @Transaction
    public int updateShikakuShutokuJogaisha(List<ShikakuShutokuJogaisha> updateKuJogaishaList) {
        delShikakuShutokuJogaisha(updateKuJogaishaList);
        return insertShikakuShutokuJogaisha(updateKuJogaishaList);
    }

    /**
     * 資格取得除外者削除します。
     *
     * @param deleteKuJogaishaList 資格取得除外者削除リスト
     * @return deleteCount 資格取得除外者削除件数
     */
    @Transaction
    public int delShikakuShutokuJogaisha(List<ShikakuShutokuJogaisha> deleteKuJogaishaList) {
        int deleteCount = 0;
        for (ShikakuShutokuJogaisha shikakuShutokuJogaisha : deleteKuJogaishaList) {
            DbT1009ShikakuShutokuJogaishaEntity shikakuentity = shikakuShutokuJogaisha.toEntity();
            shikakuentity.setIsDeleted(true);
            shikakuentity.setState(EntityDataState.Deleted);
            deleteCount = deleteCount + dac.save(shikakuentity);
        }
        return deleteCount;
    }

    /**
     * 除外期間重複チェックします。
     *
     * @param kuJogaishaList 資格取得除外者リスト
     * @return 重複しない場合、falseを返却します、以外の場合は、trueを返却します。
     */
    @Transaction
    public boolean jogaiKikanJufukuCheck(List<ShikakuShutokuJogaisha> kuJogaishaList) {
        IShikakuShutokuJogaishaKanriMapper mapper = mapperProvider.create(IShikakuShutokuJogaishaKanriMapper.class);
        for (ShikakuShutokuJogaisha shikakuShutokuJogaisha : kuJogaishaList) {
            if (0 < mapper.get除外期間重複チェック(shikakuShutokuJogaisha.toEntity())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 履歴番号を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @return 履歴番号
     */
    @Transaction
    public int select履歴番号(ShikibetsuCode 識別コード) {
        DbT1009ShikakuShutokuJogaishaEntity entity = dac.select履歴番号(識別コード);
        if (entity == null) {
            return 1;
        }
        return entity.getRirekiNo() + 1;
    }
}
