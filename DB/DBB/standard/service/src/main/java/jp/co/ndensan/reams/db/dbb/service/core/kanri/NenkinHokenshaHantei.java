/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.kanri;

import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.kanri.INenkinHokenshaHanteiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 年金保険者判定のクラスです。
 *
 * @reamsid_L DBB-9040-050 wangxiaodong
 */
public class NenkinHokenshaHantei {

    private static final RString 地方公務員共済組合連合会 = new RString("001");
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public NenkinHokenshaHantei() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     */
    NenkinHokenshaHantei(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NenkinHokenshaHantei}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link NenkinHokenshaHantei}のインスタンス
     */
    public static NenkinHokenshaHantei createInstance() {
        return InstanceProvider.create(NenkinHokenshaHantei.class);
    }

    /**
     * 特別徴収義務者コード　から、その義務者が厚労省かどうかを判断します。
     *
     * @param 特別徴収義務者コード 特別徴収義務者コード
     * @return 義務者が厚労省かどうかを判断結果。true/義務者が厚労省、false/義務者は厚労省ではない(地共済)
     */
    @Transaction
    public boolean is厚労省(RString 特別徴収義務者コード) {

        INenkinHokenshaHanteiMapper mapper = mapperProvider.create(INenkinHokenshaHanteiMapper.class);
        return !地方公務員共済組合連合会.equals(mapper.selectByKey(特別徴収義務者コード));
    }
}
