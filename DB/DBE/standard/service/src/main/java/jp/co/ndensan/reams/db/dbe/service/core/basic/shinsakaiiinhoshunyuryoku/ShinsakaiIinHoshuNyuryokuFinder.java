/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.shinsakaiiinhoshunyuryoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiIinHoshuJissekiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiIinHoshuJissekiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinhoshunyuryoku.ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshohoshujissekijoho.ShujiiIkenshoHoshuJissekiJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaiiinhoshunyuryoku.ShinsakaiIinHoshuNyuryokuMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinhoshunyuryoku.ShinsakaiIinHoshuNyuryokuEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5603ShinsakaiIinHoshuJissekiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaiiinhoshunyuryoku.IShinsakaiIinHoshuNyuryokuMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 審査会委員報酬入力を管理するクラスです。
 *
 * @reamsid_L DBE-1950-010 zhengsongling
 */
public class ShinsakaiIinHoshuNyuryokuFinder {

    private final MapperProvider mapperProvider;
    private final DbT5603ShinsakaiIinHoshuJissekiJohoDac dbT5603;

    /**
     * コンストラクタです。
     */
    public ShinsakaiIinHoshuNyuryokuFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT5603 = InstanceProvider.create(DbT5603ShinsakaiIinHoshuJissekiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     */
    ShinsakaiIinHoshuNyuryokuFinder(MapperProvider mapperProvider,
            DbT5603ShinsakaiIinHoshuJissekiJohoDac dbT5603) {
        this.mapperProvider = mapperProvider;
        this.dbT5603 = dbT5603;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiIinHoshuNyuryokuFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShinsakaiIinHoshuNyuryokuFinder}のインスタンス
     */
    public static ShinsakaiIinHoshuNyuryokuFinder createInstance() {
        return InstanceProvider.create(ShinsakaiIinHoshuNyuryokuFinder.class);
    }

    /**
     * 審査会委員一覧情報を取得します。
     *
     * @param param 審査会委員報酬入力結果情報を特定するためのMyBatis用パラメータクラスです。
     * @return ShinsakaiIinHoshuNyuryoku{@code list}
     */
    public SearchResult<ShinsakaiIinJoho> get審査会委員一覧(ShinsakaiIinHoshuNyuryokuMapperParameter param) {
        List<ShinsakaiIinJoho> businessList = new ArrayList<>();
        IShinsakaiIinHoshuNyuryokuMapper shimapper = mapperProvider.create(IShinsakaiIinHoshuNyuryokuMapper.class);
        List<ShinsakaiIinHoshuNyuryokuEntity> youKaiEntityList = shimapper.getShinsakaiIin(param);
        if (youKaiEntityList.isEmpty()) {
            return SearchResult.of(Collections.<ShinsakaiIinJoho>emptyList(), 0, false);
        }
        for (ShinsakaiIinHoshuNyuryokuEntity entity : youKaiEntityList) {
            businessList.add(new ShinsakaiIinJoho(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 審査会実績一覧情報を取得します。
     *
     * @param param 審査会委員報酬入力結果情報を特定するためのMyBatis用パラメータクラスです。
     * @return ShinsakaiIinHoshuNyuryoku{@code list}
     */
    public SearchResult<ShinsakaiIinJoho> get審査会実績(ShinsakaiIinHoshuNyuryokuMapperParameter param) {
        List<ShinsakaiIinJoho> businessList = new ArrayList<>();
        IShinsakaiIinHoshuNyuryokuMapper shimapper = mapperProvider.create(IShinsakaiIinHoshuNyuryokuMapper.class);
        List<ShinsakaiIinHoshuNyuryokuEntity> youKaiEntityList = shimapper.getdgShinsakaiJisseki(param);
        if (youKaiEntityList.isEmpty()) {
            return SearchResult.of(Collections.<ShinsakaiIinJoho>emptyList(), 0, false);
        }
        for (ShinsakaiIinHoshuNyuryokuEntity entity : youKaiEntityList) {
            businessList.add(new ShinsakaiIinJoho(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * MAX連番を取得します。
     *
     * @param param 審査会委員報酬入力結果情報を特定するためのMyBatis用パラメータクラスです。
     * @return ShinsakaiIinHoshuNyuryoku{@code list}
     */
    public int getMAX連番(ShinsakaiIinHoshuNyuryokuMapperParameter param) {
        IShinsakaiIinHoshuNyuryokuMapper shimapper = mapperProvider.create(IShinsakaiIinHoshuNyuryokuMapper.class);
        return shimapper.getremban(param);
    }

    /**
     * 「保存する」ボタンを押下し、削除処理を続けます。
     *
     * @param models 審査会委員情報
     * @param key 審査会委員情報審査会委員情報
     * @return 審査会委員情報
     */
    public boolean delete(Models<ShinsakaiIinHoshuJissekiJohoIdentifier, ShinsakaiIinHoshuJissekiJoho> models,
            ShinsakaiIinHoshuJissekiJohoIdentifier key) {
        ShinsakaiIinHoshuJissekiJoho 審査会委員情報 = models.get(key);
        return 1 == dbT5603.deletePhysical(審査会委員情報.toEntity());
    }

    /**
     * 審査会委員情報{@link ShujiiIkenshoHoshuJissekiJoho}を登録/更新します。
     *
     * @param 審査会委員情報 {@link ShinsakaiIinHoshuJissekiJoho}
     * @return 登録/登録件数 更新/更新件数 の件数を返します。
     */
    public int insertOrUpdate(ShinsakaiIinHoshuJissekiJoho 審査会委員情報) {
        if (!審査会委員情報.hasChanged()) {
            return 0;
        }
        return dbT5603.save(審査会委員情報.toEntity());
    }
}
