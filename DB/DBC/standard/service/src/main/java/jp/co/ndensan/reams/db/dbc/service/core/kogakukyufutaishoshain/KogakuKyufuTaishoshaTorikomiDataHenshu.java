/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakukyufutaishoshain;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
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

    /**
     * コンストラクタです。
     */
    KogakuKyufuTaishoshaTorikomiDataHenshu() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.国保連インターフェース管理Dac = InstanceProvider.create(DbT3104KokuhorenInterfaceKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 国保連インターフェース管理Dac 国保連インターフェース管理Dac
     */
    KogakuKyufuTaishoshaTorikomiDataHenshu(MapperProvider mapperProvider,
            DbT3104KokuhorenInterfaceKanriDac 国保連インターフェース管理Dac) {
        this.mapperProvider = mapperProvider;
        this.国保連インターフェース管理Dac = 国保連インターフェース管理Dac;
    }

    /**
     * {@link InstanceProvider#create}により生成されたインタフェースを返します。
     *
     * @return {@link InstanceProvider#create}により生成された{@link KogakuKyufuTaishoshaTorikomiDataHenshu}
     */
    public static KogakuKyufuTaishoshaTorikomiDataHenshu createInstance() {
        return InstanceProvider.create(KogakuKyufuTaishoshaTorikomiDataHenshu.class);
    }

    public void updateDataIntoDb(FlexibleYearMonth 処理年月, List<RString> fileNameList, RString 再処理区分) {
        IKogakuKyufuTaishoshaInMapper mapper = mapperProvider.create(IKogakuKyufuTaishoshaInMapper.class);
        if (SaiShoriKubun.再処理.getコード().equals(再処理区分)) {
            mapper.updateDbT3054サービス提供年月();
            mapper.updateDbT3055サービス提供年月();
        }
        mapper.insert高額介護サービス費給付対象者合計();
        mapper.insert高額介護サービス費給付対象者明細();

        DbT3104KokuhorenInterfaceKanriEntity dbt3104entity = 国保連インターフェース管理Dac.selectByKey(処理年月, new RString("331"));
        dbt3104entity.setSofuTorikomiKubun(new RString("2"));
        dbt3104entity.setShoriJotaiKubun(new RString("3"));
        dbt3104entity.setShoriJisshiTimestamp(YMDHMS.now());
        dbt3104entity.setSaiShoriKanoKubun(false);
        // TODO 履歴番号
        dbt3104entity.setShoriJikkoKaisu(Decimal.ZERO);
        dbt3104entity.setFileName1(fileNameList == null || fileNameList.isEmpty()
                || fileNameList.get(0) == null ? RString.EMPTY : fileNameList.get(0));
        dbt3104entity.setFileName2(fileNameList == null || fileNameList.size() <= 1
                || fileNameList.get(1) == null ? RString.EMPTY : fileNameList.get(1));
        dbt3104entity.setFileName3(fileNameList == null || fileNameList.size() <= 2
                || fileNameList.get(2) == null ? RString.EMPTY : fileNameList.get(2));
        dbt3104entity.setFileName4(fileNameList == null || fileNameList.size() <= 3
                || fileNameList.get(3) == null ? RString.EMPTY : fileNameList.get(3));
        dbt3104entity.setFileName5(fileNameList == null || fileNameList.size() <= 4
                || fileNameList.get(4) == null ? RString.EMPTY : fileNameList.get(4));
        dbt3104entity.setState(EntityDataState.Modified);
        国保連インターフェース管理Dac.save(dbt3104entity);
    }
}
