/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jyutakukaisyuyichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanjutakukaishu.ShokanJutakuKaishuBusiness;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3049ShokanJutakuKaishuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3049ShokanJutakuKaishuDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 住宅改修一覧の取得クラスです。
 */
public class JyutakukaisyuyichiranFinder {

    private final DbT3049ShokanJutakuKaishuDac dac;

    /**
     * コンストラクタです。
     */
    JyutakukaisyuyichiranFinder() {
        dac = InstanceProvider.create(DbT3049ShokanJutakuKaishuDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JyutakukaisyuyichiranFinder}のインスタンスを返します。
     *
     * @return JyutakukaisyuyichiranFinder
     */
    public static JyutakukaisyuyichiranFinder createInstance() {

        return InstanceProvider.create(JyutakukaisyuyichiranFinder.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3049ShokanJutakuKaishuDac}
     */
    JyutakukaisyuyichiranFinder(DbT3049ShokanJutakuKaishuDac dac) {
        this.dac = dac;
    }

    /**
     * 住宅改修一覧の取得です。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 様式番号 様式番号
     * @return SearchResult<ShokanJutakuKaishuBusiness> 住宅改修一覧
     */
    public SearchResult<ShokanJutakuKaishuBusiness> selectJyutakukaisyuList(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, RString 様式番号) {
        List<ShokanJutakuKaishuBusiness> 住宅改修一覧 = new ArrayList<>();
        List<DbT3049ShokanJutakuKaishuEntity> entityList = dac.getJyutakukaisyuList(
                被保険者番号, サービス提供年月, 整理番号, 様式番号);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(住宅改修一覧, 0, false);
        }
        for (DbT3049ShokanJutakuKaishuEntity entity : entityList) {
            住宅改修一覧.add(new ShokanJutakuKaishuBusiness(entity));
        }
        return SearchResult.of(住宅改修一覧, 0, false);
    }
}
