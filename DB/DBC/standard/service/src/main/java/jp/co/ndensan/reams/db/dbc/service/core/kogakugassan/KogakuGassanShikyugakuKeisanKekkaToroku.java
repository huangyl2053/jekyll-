/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakugassan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanShikyuGakuKeisanKekkaRelate;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070.KogakuGassanShikyuGakuKeisanKekkaRelateEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassanshikyugakukeisankekkatoroku.IKogakuGassanShikyugakuKeisanKekkaMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 高額合算支給額計算結果登録のビジネスです。
 *
 * @reamsid_L DBC-2030-030 huzongcheng
 */
public class KogakuGassanShikyugakuKeisanKekkaToroku {

    private final MapperProvider mapperProvider;
    private static final RString KEY_被保険者番号 = new RString("被保険者番号");
    private static final RString KEY_検索年度開始 = new RString("検索年度開始");
    private static final RString KEY_検索年度終了 = new RString("検索年度終了");

    /**
     * コンストラクタです。
     */
    KogakuGassanShikyugakuKeisanKekkaToroku() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    KogakuGassanShikyugakuKeisanKekkaToroku(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KogakuGassanShikyugakuKeisanKekkaToroku}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KogakuGassanShikyugakuKeisanKekkaToroku}のインスタンス
     */
    public static KogakuGassanShikyugakuKeisanKekkaToroku createInstance() {
        return InstanceProvider.create(KogakuGassanShikyugakuKeisanKekkaToroku.class);
    }

    /**
     * 支給額計算結果取得処理のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 検索年度開始 FlexibleYear
     * @param 検索年度終了 FlexibleYear
     * @param 履歴表示 boolean
     * @return List<KogakuGassanShikyuGakuKeisanKekkaResult>
     */
    public List<KogakuGassanShikyuGakuKeisanKekkaRelate> selectShikyugakuKeisanKekka(
            HihokenshaNo 被保険者番号,
            FlexibleYear 検索年度開始,
            FlexibleYear 検索年度終了,
            boolean 履歴表示) {
        List<KogakuGassanShikyuGakuKeisanKekkaRelate> resultList = new ArrayList();
        IKogakuGassanShikyugakuKeisanKekkaMapper mapper = this.mapperProvider.create(IKogakuGassanShikyugakuKeisanKekkaMapper.class);
        Map<String, Object> pram = new HashMap<>();
        pram.put(KEY_被保険者番号.toString(), 被保険者番号);
        pram.put(KEY_検索年度開始.toString(), 検索年度開始);
        pram.put(KEY_検索年度終了.toString(), 検索年度終了);
        List<KogakuGassanShikyuGakuKeisanKekkaRelateEntity> entityList;
        if (履歴表示) {
            entityList = mapper.select支給額計算結果履歴チェックオン(pram);
            if (entityList.isEmpty()) {
                return resultList;
            }
        } else {
            entityList = mapper.select支給額計算結果履歴チェックオフ(pram);
            if (entityList.isEmpty()) {
                return resultList;
            }
        }
        for (KogakuGassanShikyuGakuKeisanKekkaRelateEntity entity : entityList) {
            entity.initializeMd5ToEntities();
            KogakuGassanShikyuGakuKeisanKekkaRelate relate = new KogakuGassanShikyuGakuKeisanKekkaRelate(entity);
            resultList.add(relate);
        }
        return resultList;
    }
}
