/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.kaigoatenakihon;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.kaigoatenakihon.KaigoAtenaKihonBusiness;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kaigoatenakihon.KaigoAtenaKihonEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.kaigoatenakihon.IKaigoAtenaKihonMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護宛名基本情報を取得するクラスです。
 *
 */
public class KaigoAtenaKihonFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    KaigoAtenaKihonFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    KaigoAtenaKihonFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaigoAtenaKihonFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KaigoAtenaKihonFinder}のインスタンス
     */
    public static KaigoAtenaKihonFinder createInstance() {
        return InstanceProvider.create(KaigoAtenaKihonFinder.class);
    }

    /**
     * 介護資格系基本情報取得する。
     *
     * @param 識別コード ShikibetsuCode
     * @return SearchResult<KaigoAtenaKihonBusiness>
     */
    @Transaction
    public KaigoAtenaKihonBusiness getKaigoShikakuKihon(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        IKaigoAtenaKihonMapper mapper = mapperProvider.create(IKaigoAtenaKihonMapper.class);
        List<KaigoAtenaKihonEntity> kaigoAtenaKihonList = mapper.selectKaigoShikakuKihonByShikibetsuCode(識別コード);
        if (kaigoAtenaKihonList == null || kaigoAtenaKihonList.isEmpty()) {
            throw new RuntimeException();
        }
        return new KaigoAtenaKihonBusiness(kaigoAtenaKihonList.get(0));
    }

    /**
     * 介護資格系基本情報取得する。
     *
     * @param 被保険者番号 被保険者番号
     * @return SearchResult<KaigoAtenaKihonBusiness>
     */
    @Transaction
    public KaigoAtenaKihonBusiness getKaigoHihokenshaNo(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        IKaigoAtenaKihonMapper mapper = mapperProvider.create(IKaigoAtenaKihonMapper.class);
        List<KaigoAtenaKihonEntity> kaigoAtenaKihonList = mapper.selectKaigoShikakuKihonByHihokenshaNo(被保険者番号);
        if (kaigoAtenaKihonList == null || kaigoAtenaKihonList.isEmpty()) {
            throw new RuntimeException();
        }
        return new KaigoAtenaKihonBusiness(kaigoAtenaKihonList.get(0));
    }
}
