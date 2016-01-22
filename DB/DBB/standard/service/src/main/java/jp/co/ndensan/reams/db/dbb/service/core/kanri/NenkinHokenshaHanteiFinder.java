/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.kanri;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kanri.NenkinHokenshaHanteiParameter;
import jp.co.ndensan.reams.db.dbb.persistence.core.kanri.INenkinHokenshaHanteiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 年金保険者判定クラス。
 */
public class NenkinHokenshaHanteiFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    NenkinHokenshaHanteiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     */
    NenkinHokenshaHanteiFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NenkinHokenshaHantei}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link NenkinHokenshaHantei}のインスタンス
     */
    public static NenkinHokenshaHanteiFinder createInstance() {
        return InstanceProvider.create(NenkinHokenshaHanteiFinder.class);
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
        RString 特別徴収義務者グループコード = mapper.selectByKey(NenkinHokenshaHanteiParameter.createParam(特別徴収義務者コード));
        // TODO 凌護行 仕様に「UE年金コード・特徴義務者コード.特別徴収義務者グループコード.地方公務員共済組合連合会(001)であるの場合」
//       の意味は不明ため、 QA545回答まち、
        return !new RString("001").equals(特別徴収義務者グループコード);
    }
}
