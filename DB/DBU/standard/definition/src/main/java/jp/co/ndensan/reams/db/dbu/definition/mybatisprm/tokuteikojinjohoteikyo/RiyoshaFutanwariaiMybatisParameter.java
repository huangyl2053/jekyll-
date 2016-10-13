/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo;

import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.DataSetNo;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShinkiIdoKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.TeikyoKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担割合のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBU-4880-060 zhaoyao
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class RiyoshaFutanwariaiMybatisParameter implements IMyBatisParameter {

    private final RString 新規異動区分;
    private final boolean is当初または版改定;
    private final boolean is再登録;
    private final boolean is異動;
    private final RDateTime 対象開始日時;
    private final RDateTime 対象終了日時;
    private final RString 個人番号付替対象者被保険者番号;
    private final RString データセット番号_0202利用者割合;
    private final RString 提供区分_個人番号未設定;
    private final RString 提供区分_その他エラー;
    private final RString psmShikibetsuTaisho;

    private RiyoshaFutanwariaiMybatisParameter(
            RString 新規異動区分,
            boolean is当初または版改定,
            boolean is再登録,
            boolean is異動,
            RDateTime 対象開始日時,
            RDateTime 対象終了日時,
            RString 個人番号付替対象者被保険者番号,
            RString データセット番号_0202利用者割合,
            RString 提供区分_個人番号未設定,
            RString 提供区分_その他エラー,
            RString psmShikibetsuTaisho
    ) {
        this.新規異動区分 = 新規異動区分;
        this.is当初または版改定 = is当初または版改定;
        this.is再登録 = is再登録;
        this.is異動 = is異動;
        this.対象開始日時 = 対象開始日時;
        this.対象終了日時 = 対象終了日時;
        this.個人番号付替対象者被保険者番号 = 個人番号付替対象者被保険者番号;
        this.データセット番号_0202利用者割合 = データセット番号_0202利用者割合;
        this.提供区分_個人番号未設定 = 提供区分_個人番号未設定;
        this.提供区分_その他エラー = 提供区分_その他エラー;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * 提供情報_候補のMybatisParameterを生成します。
     *
     * @param 新規異動区分 新規異動区分
     * @param 対象開始日時 対象開始日時
     * @param 対象終了日時 対象終了日時
     * @param 個人番号付替対象者被保険者番号 個人番号付替対象者被保険者番号
     * @return RiyoshaFutanwariaiMybatisParameter
     */
    public static RiyoshaFutanwariaiMybatisParameter createParamter提供情報_候補(
            RString 新規異動区分,
            RDateTime 対象開始日時,
            RDateTime 対象終了日時,
            RString 個人番号付替対象者被保険者番号
    ) {
        boolean is当初または版改定 = false;
        boolean is再登録 = false;
        boolean is異動 = false;
        if (ShinkiIdoKubun.当初.getコード().equals(新規異動区分)
                || ShinkiIdoKubun.版改定.getコード().equals(新規異動区分)) {
            is当初または版改定 = true;
        }
        if (ShinkiIdoKubun.再登録.getコード().equals(新規異動区分)) {
            is再登録 = true;
        }
        if (ShinkiIdoKubun.異動.getコード().equals(新規異動区分)) {
            is異動 = true;
        }
        return new RiyoshaFutanwariaiMybatisParameter(
                新規異動区分,
                is当初または版改定,
                is再登録,
                is異動,
                対象開始日時,
                対象終了日時,
                個人番号付替対象者被保険者番号,
                DataSetNo._0202負担割合.getコード(),
                TeikyoKubun.個人番号未設定により未提供.getコード(),
                TeikyoKubun.その他エラーにより未提供.getコード(),
                RString.EMPTY
        );
    }

    /**
     * 提供対象者のMybatisParameterを生成します。
     *
     * @param 宛名 宛名
     * @return RiyoshaFutanwariaiMybatisParameter
     */
    public static RiyoshaFutanwariaiMybatisParameter createParamter提供対象者(RString 宛名) {
        return new RiyoshaFutanwariaiMybatisParameter(
                RString.EMPTY,
                false,
                false,
                false,
                RDateTime.MAX,
                RDateTime.MAX,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                宛名);
    }
}
