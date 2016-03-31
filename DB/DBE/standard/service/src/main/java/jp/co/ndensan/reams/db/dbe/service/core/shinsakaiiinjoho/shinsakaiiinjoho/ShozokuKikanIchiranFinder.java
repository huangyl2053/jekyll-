/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakaiiinjoho.shinsakaiiinjoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShozokuKikanIchiranFinderBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaiiinjoho.ShinsakaiIinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinjoho.shinsakaiiinjoho.ShozokuKikanIchiranEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaiiinjoho.IShinsakaiIinJohoMapper;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 所属機関一覧情報を取得するクラスです。
 */
public class ShozokuKikanIchiranFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShozokuKikanIchiranFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    ShozokuKikanIchiranFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShozokuKikanIchiranFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShozokuKikanIchiranFinder}のインスタンス
     */
    public static ShozokuKikanIchiranFinder createInstance() {
        return InstanceProvider.create(ShozokuKikanIchiranFinder.class);
    }

    /**
     * 審査会委員コードで所属機関一覧情報を取得する。
     *
     * @param 審査会委員コード 介護認定審査会委員情報パラメータ
     * @return List<ShozokuKikanIchiranFinderBusiness>
     */
    @Transaction
    public SearchResult<ShozokuKikanIchiranFinderBusiness> get所属機関一覧情報(ShinsakaiIinJohoMapperParameter 審査会委員コード) {
        IShinsakaiIinJohoMapper mapper = mapperProvider.create(IShinsakaiIinJohoMapper.class);
        List<ShozokuKikanIchiranFinderBusiness> 所属機関一覧情報 = new ArrayList<>();
        List<ShozokuKikanIchiranEntity> entityList = mapper.get所属機関一覧情報(審査会委員コード);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(所属機関一覧情報, 0, false);
        }
        for (ShozokuKikanIchiranEntity entity : entityList) {
            所属機関一覧情報.add(new ShozokuKikanIchiranFinderBusiness(entity));
        }
        return SearchResult.of(所属機関一覧情報, 0, false);
    }

}
