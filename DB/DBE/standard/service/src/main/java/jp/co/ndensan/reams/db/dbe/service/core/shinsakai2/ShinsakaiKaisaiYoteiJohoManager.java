/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakai2;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinwaritsuke.ShinsakaiKaisaiYoteiJoho;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinwaritsuke.ShinsakaiKaisaiYoteiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaiiinwaritsuke.IShinsakaiIinWaritsukeMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 審査会開催予定情報の取得処理です。
 *
 * @reamsid_L DBE-0130-050 xuyannan
 */
public class ShinsakaiKaisaiYoteiJohoManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShinsakaiKaisaiYoteiJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     */
    ShinsakaiKaisaiYoteiJohoManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiKaisaiYoteiJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShinsakaiKaisaiYoteiJohoManager}のインスタンス
     */
    public static ShinsakaiKaisaiYoteiJohoManager createInstance() {
        return InstanceProvider.create(ShinsakaiKaisaiYoteiJohoManager.class);
    }

    /**
     * 開催番号によって、審査会開催予定情報を取得します。
     *
     * @param kaisaiNo 開催番号
     * @return SearchResult<ShinsakaiKaisaiYoteiJoho>
     */
    @Transaction
    public SearchResult<ShinsakaiKaisaiYoteiJoho> search審査会開催予定情報Of開催番号(RString kaisaiNo) {
        requireNonNull(kaisaiNo, UrSystemErrorMessages.値がnull.getReplacedMessage("kaisaiNo"));
        IShinsakaiIinWaritsukeMapper mapper = mapperProvider.create(IShinsakaiIinWaritsukeMapper.class);
        ShinsakaiKaisaiYoteiJohoRelateEntity shinsakaiKaisaiYoteiJoho = mapper.get審査会開催予定情報By開催番号(kaisaiNo);
        List<ShinsakaiKaisaiYoteiJoho> business = new ArrayList();
        if (shinsakaiKaisaiYoteiJoho != null) {
            business.add(new ShinsakaiKaisaiYoteiJoho(shinsakaiKaisaiYoteiJoho));
        }
        return SearchResult.of(business, 0, false);
    }
}
