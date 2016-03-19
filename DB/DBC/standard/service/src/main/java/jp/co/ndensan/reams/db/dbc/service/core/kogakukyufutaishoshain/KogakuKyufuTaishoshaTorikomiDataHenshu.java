/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakukyufutaishoshain;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shorijotaikubun.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3104KokuhorenInterfaceKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukyufutaishoshain.IKogakuKyufuTaishoshaInMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 高額介護サービス費給付対象者取込データ編集
 */
public class KogakuKyufuTaishoshaTorikomiDataHenshu {

    private final MapperProvider mapperProvider;
    private final DbT3104KokuhorenInterfaceKanriDac 国保連インターフェース管理Dac;
    private static final RString INDEX_2 = new RString("2");
    private static final RString INDEX_331 = new RString("331");
    private static final int LIST_INDEX_1 = 1;
    private static final int LIST_INDEX_2 = 2;
    private static final int LIST_INDEX_3 = 3;
    private static final int LIST_INDEX_4 = 4;

    /**
     * コンストラクタです。
     */
    public KogakuKyufuTaishoshaTorikomiDataHenshu() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.国保連インターフェース管理Dac = InstanceProvider.create(DbT3104KokuhorenInterfaceKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 国保連インターフェース管理Dac 国保連インターフェース管理Dac
     */
    public KogakuKyufuTaishoshaTorikomiDataHenshu(MapperProvider mapperProvider,
            DbT3104KokuhorenInterfaceKanriDac 国保連インターフェース管理Dac) {
        this.mapperProvider = mapperProvider;
        this.国保連インターフェース管理Dac = 国保連インターフェース管理Dac;
    }

    /**
     * 高額介護サービス費給付対象者取込データ編集
     *
     * @param 処理年月 FlexibleYearMonth
     * @param fileNameList List<RString>
     * @param 再処理区分 RString
     */
    public void updateDataIntoDb(FlexibleYearMonth 処理年月, List<RString> fileNameList, RString 再処理区分) {
        IKogakuKyufuTaishoshaInMapper mapper = mapperProvider.create(IKogakuKyufuTaishoshaInMapper.class);
        if (SaiShoriKubun.再処理.getコード().equals(再処理区分)) {
            mapper.updateDbT3054サービス提供年月();
            mapper.updateDbT3055サービス提供年月();
        }
        mapper.insert高額介護サービス費給付対象者合計();
        mapper.insert高額介護サービス費給付対象者明細();

        DbT3104KokuhorenInterfaceKanriEntity dbt3104entity = 国保連インターフェース管理Dac.selectByKey(処理年月, INDEX_331);
        dbt3104entity.setSofuTorikomiKubun(INDEX_2);
        dbt3104entity.setShoriJotaiKubun(ShoriJotaiKubun.終了.getコード());
        dbt3104entity.setShoriJisshiTimestamp(YMDHMS.now());
        dbt3104entity.setSaiShoriKanoKubun(false);
        // TODO 履歴番号
        dbt3104entity.setShoriJikkoKaisu(Decimal.ZERO);
        dbt3104entity.setFileName1(fileNameList == null || fileNameList.isEmpty()
                || fileNameList.get(0) == null ? RString.EMPTY : fileNameList.get(0));
        dbt3104entity.setFileName2(fileNameList == null || fileNameList.size() <= LIST_INDEX_1
                || fileNameList.get(1) == null ? RString.EMPTY : fileNameList.get(1));
        dbt3104entity.setFileName3(fileNameList == null || fileNameList.size() <= LIST_INDEX_2
                || fileNameList.get(2) == null ? RString.EMPTY : fileNameList.get(2));
        dbt3104entity.setFileName4(fileNameList == null || fileNameList.size() <= LIST_INDEX_3
                || fileNameList.get(3) == null ? RString.EMPTY : fileNameList.get(3));
        dbt3104entity.setFileName5(fileNameList == null || fileNameList.size() <= LIST_INDEX_4
                || fileNameList.get(4) == null ? RString.EMPTY : fileNameList.get(4));
        dbt3104entity.setState(EntityDataState.Modified);
        国保連インターフェース管理Dac.save(dbt3104entity);
    }
}
