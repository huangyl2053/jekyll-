/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.shikakushutokujogaishakanri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.shikakushutokujogaishakanri.ShikakuShutokuJogaishaKanri;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.shikakushutokujogaishakanri.ShikakuShutokuJogaishaKanriParameter;
import jp.co.ndensan.reams.db.dba.entity.db.shikakushutokujogaishakanri.ShikakuShutokuJogaishaKanriEntity;
import jp.co.ndensan.reams.db.dba.persistence.mapper.shikakushutoku.IShikakuShutokuJogaishaKanriMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1009ShikakuShutokuJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1009ShikakuShutokuJogaishaDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 資格取得除外者管理の取得します
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
     * 資格取得除外者一覧取得します
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
            ShikakuShutokuJogaishaKanriEntity shikakuentity = get宛名情報(entity.getShikibetsuCode());
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

    private ShikakuShutokuJogaishaKanriEntity get宛名情報(ShikibetsuCode 識別コード) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先), true);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        ShikakuShutokuJogaishaKanriParameter parameter = new ShikakuShutokuJogaishaKanriParameter(
                識別コード, new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        IShikakuShutokuJogaishaKanriMapper mapper = mapperProvider.create(IShikakuShutokuJogaishaKanriMapper.class);
        return mapper.get宛名情報(parameter);
    }

    /**
     * 資格取得除外者登録
     *
     * @param shakanrientity ShikakuShutokuJogaishaKanriEntity
     * @return count 件数
     */
    @Transaction
    public int insertShikakuShutokuJogaisha(ShikakuShutokuJogaishaKanriEntity shakanrientity) {
        IShikakuShutokuJogaishaKanriMapper mapper = mapperProvider.create(IShikakuShutokuJogaishaKanriMapper.class);
        int 履歴番号 = mapper.get履歴番号(shakanrientity.getShikibetsuCode());
        DbT1009ShikakuShutokuJogaishaEntity shikakuentity = new DbT1009ShikakuShutokuJogaishaEntity();
        shikakuentity.setShikibetsuCode(shakanrientity.getShikibetsuCode());
        shikakuentity.setShichosonCode(shakanrientity.getShichosonCode());
        shikakuentity.setShikakuShutokuJogaiRiyu(shakanrientity.getShikakuShutokuJogaiRiyu());
        shikakuentity.setShikakuShutokuJogaiYMD(shakanrientity.getShikakuShutokuJogaiYMD());
        shikakuentity.setShikakuShutokuJogaiKaijoYMD(shakanrientity.getShikakuShutokuJogaiKaijoYMD());
        shikakuentity.setRirekiNo(履歴番号 + 1);
        shikakuentity.setIsDeleted(false);
        shikakuentity.setState(EntityDataState.Added);
        return dac.save(shikakuentity);
    }

    /**
     * 資格取得除外者更新
     *
     * @param shakanrientity ShikakuShutokuJogaishaKanriEntity
     * @return count 件数
     */
    public int updateShikakuShutokuJogaisha(ShikakuShutokuJogaishaKanriEntity shakanrientity) {
        DbT1009ShikakuShutokuJogaishaEntity entity = dac.selectByKey(shakanrientity.getShikibetsuCode(),
                shakanrientity.getRirekiNo());
        entity.setIsDeleted(true);
        entity.setState(EntityDataState.Modified);
        int count = dac.save(entity);
        insertShikakuShutokuJogaisha(shakanrientity);
        return count;
    }

    /**
     * 資格取得除外者削除
     *
     * @param shakanrientity ShikakuShutokuJogaishaKanriEntity
     * @return count 件数
     */
    public int delShikakuShutokuJogaisha(ShikakuShutokuJogaishaKanriEntity shakanrientity) {
        DbT1009ShikakuShutokuJogaishaEntity entity = dac.selectByKey(shakanrientity.getShikibetsuCode(),
                shakanrientity.getRirekiNo());
        entity.setIsDeleted(true);
        entity.setState(EntityDataState.Deleted);
        return dac.save(entity);
    }

    /**
     * 除外期間重複チェック
     *
     * @param shakanrientity ShikakuShutokuJogaishaKanriEntity
     * @return true
     */
    public boolean jogaiKikanJufukuCheck(ShikakuShutokuJogaishaKanriEntity shakanrientity) {
        IShikakuShutokuJogaishaKanriMapper mapper = mapperProvider.create(IShikakuShutokuJogaishaKanriMapper.class
        );
        int count = mapper.get除外期間重複チェック(shakanrientity);
        return count != 0;
    }
}
