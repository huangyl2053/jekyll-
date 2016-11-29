/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo;

import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.TeikyoYohi;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定個人情報提供のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBU-4880-100 dingyi
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TokuteiKojinJohoHensyuMybatisParamater implements IMyBatisParameter {

    private final RString 中間DBのテーブル名;
    private final RString 特定個人情報名コード;
    private final RString 提供区分;

    private TokuteiKojinJohoHensyuMybatisParamater(RString 中間DBのテーブル名, RString 特定個人情報名コード, RString 提供区分) {
        this.中間DBのテーブル名 = 中間DBのテーブル名;
        this.特定個人情報名コード = 特定個人情報名コード;
        this.提供区分 = 提供区分;
    }

    /**
     * 中間DB提供基本情報取得（標準用）パラメータを生成します。
     *
     * @param 中間DBのテーブル名 中間DBのテーブル名
     * @param 特定個人情報名コード 特定個人情報名コード
     *
     * @return 中間DB提供基本情報取得のParamter
     */
    public static TokuteiKojinJohoHensyuMybatisParamater createParamter中間DB提供基本情報取得_標準(RString 中間DBのテーブル名,
            RString 特定個人情報名コード) {
        return new TokuteiKojinJohoHensyuMybatisParamater(中間DBのテーブル名, 特定個人情報名コード, TeikyoYohi.提供要.getコード());
    }

}
