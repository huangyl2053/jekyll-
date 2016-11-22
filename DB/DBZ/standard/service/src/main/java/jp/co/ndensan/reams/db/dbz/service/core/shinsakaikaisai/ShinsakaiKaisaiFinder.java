/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.shinsakaikaisai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.shinsakaikaisai.ShinsakaiKaisai;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakaikaisai.ShinsakaiKaisaiParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shinsakaikaisai.ShinsakaiKaisaiRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.shinsakaikaisai.IShinsakaiKaisaiMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会共有一覧の検索クラスです。
 *
 * @reamsid_L DBE-0120-010 lishengli
 */
public class ShinsakaiKaisaiFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShinsakaiKaisaiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    ShinsakaiKaisaiFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiKaisaiFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShinsakaiKaisaiFinder}のインスタンス
     */
    public static ShinsakaiKaisaiFinder createInstance() {
        return InstanceProvider.create(ShinsakaiKaisaiFinder.class);
    }

    /**
     * 審査会一覧を検索します。
     *
     * @param 表示期間From 表示期間From
     * @param 表示期間To 表示期間To
     * @param モード モード
     * @param 表示条件 表示条件
     * @param 最大表示件数 Decimal
     * @param ダミー審査会 ダミー審査会
     * @return ShinsakaiKaisai 審査会一覧情報 nullが返る可能性があります。
     */
    @Transaction
    public SearchResult<ShinsakaiKaisai> get審査会一覧(
            RDate 表示期間From,
            RDate 表示期間To,
            RString モード,
            RString 表示条件,
            Decimal 最大表示件数,
            RString ダミー審査会) {
        IShinsakaiKaisaiMapper mapper = mapperProvider.create(IShinsakaiKaisaiMapper.class);
        RString 期間From;
        RString 期間To;
        if (表示期間From != null && 表示期間To != null) {
            期間From = 表示期間From.toDateString();
            期間To = 表示期間To.toDateString();
        } else if (表示期間From != null && 表示期間To == null) {
            期間From = 表示期間From.toDateString();
            期間To = RDate.MAX.toDateString();

        } else if (表示期間From == null && 表示期間To != null) {
            期間From = RDate.MIN.toDateString();
            期間To = 表示期間To.toDateString();
        } else {
            期間From = RDate.MIN.toDateString();
            期間To = RDate.MAX.toDateString();
        }
        ShinsakaiKaisaiParameter parameter = ShinsakaiKaisaiParameter.createParam(
                期間From,
                期間To,
                モード, 表示条件, 最大表示件数, ダミー審査会);
        List<ShinsakaiKaisaiRelateEntity> relateEntityList = mapper.get審査会一覧(parameter);

        if (relateEntityList == null || relateEntityList.isEmpty()) {
            return SearchResult.of(Collections.<ShinsakaiKaisai>emptyList(), 0, false);
        }
        List<ShinsakaiKaisai> 審査会情報List = new ArrayList<>();
        for (ShinsakaiKaisaiRelateEntity relateEntity : relateEntityList) {
            審査会情報List.add(new ShinsakaiKaisai(relateEntity));
        }
        return SearchResult.of(審査会情報List, 0, false);
    }
}
