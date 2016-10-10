/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.sougoujigyoujyohou;

import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_DataSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_Idokubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.DataSetNo;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShinkiIdoKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.TeikyoKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.TokuteiKojinJohomeiCode;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 総合事業情報のMybatisParameterクラスです。
 *
 * @reamsid_L DBU-4880-080 lishengli
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class SougouJigyouJyohouMybatisParameter implements IMyBatisParameter {

    private final boolean is当初または版改定;
    private final boolean is再登録;
    private final boolean is異動;
    private final RString 個人番号付替対象者被保険者番号;
    private final RDateTime 対象開始日時;
    private final RDateTime 対象終了日時;
    private final RString 特定個人情報版管理番号04;
    private final RString 住所地特例情報_0102;
    private final RString 版番号;
    private final RString 個人番号未設定により未提供;
    private final RString その他エラーにより未提供;
    private final RString 仮データ;
    private final RString 国保連;
    private final RString 自己負担額確認情報_括;

    /**
     * コンストラクタです。
     *
     * @param is当初または版改定 is当初または版改定
     * @param is再登録 is再登録
     * @param is異動 is異動
     * @param 個人番号付替対象者被保険者番号 個人番号付替対象者被保険者番号
     * @param 対象開始日時 対象開始日時
     * @param 対象終了日時 対象終了日時
     * @param 特定個人情報版管理番号04 特定個人情報版管理番号04
     * @param 住所地特例情報_0102 住所地特例情報_0102
     * @param 版番号 版番号
     * @param 個人番号未設定により未提供 個人番号未設定により未提供
     * @param その他エラーにより未提供 その他エラーにより未提供
     */
    private SougouJigyouJyohouMybatisParameter(
            boolean is当初または版改定,
            boolean is再登録,
            boolean is異動,
            RString 個人番号付替対象者被保険者番号,
            RDateTime 対象開始日時,
            RDateTime 対象終了日時,
            RString 特定個人情報版管理番号04,
            RString 住所地特例情報_0102,
            RString 版番号,
            RString 個人番号未設定により未提供,
            RString その他エラーにより未提供,
            RString 仮データ,
            RString 国保連,
            RString 自己負担額確認情報_括) {
        this.is当初または版改定 = is当初または版改定;
        this.is再登録 = is再登録;
        this.is異動 = is異動;
        this.個人番号付替対象者被保険者番号 = 個人番号付替対象者被保険者番号;
        this.対象開始日時 = 対象開始日時;
        this.対象終了日時 = 対象終了日時;
        this.特定個人情報版管理番号04 = 特定個人情報版管理番号04;
        this.住所地特例情報_0102 = 住所地特例情報_0102;
        this.版番号 = 版番号;
        this.個人番号未設定により未提供 = 個人番号未設定により未提供;
        this.その他エラーにより未提供 = その他エラーにより未提供;
        this.仮データ = 仮データ;
        this.国保連 = 国保連;
        this.自己負担額確認情報_括 = 自己負担額確認情報_括;
    }

    /**
     * 総合事業情報のMybatisParameter設定です。
     *
     * @param 新規異動区分 新規異動区分
     * @param 個人番号付替対象者被保険者番号 個人番号付替対象者被保険者番号
     * @param 対象開始日時 対象開始日時
     * @param 対象終了日時 対象終了日時
     * @param 版番号 版番号
     * @return 総合事業情報のMybatisParameterクラス
     */
    public static SougouJigyouJyohouMybatisParameter create_Parameter(
            RString 新規異動区分,
            RString 個人番号付替対象者被保険者番号,
            RDateTime 対象開始日時,
            RDateTime 対象終了日時,
            RString 版番号) {
        boolean 当初または版改定 = false;
        boolean 再登録 = false;
        boolean 異動 = false;
        if (ShinkiIdoKubun.当初.getコード().equals(新規異動区分) || ShinkiIdoKubun.版改定.getコード().equals(新規異動区分)) {
            当初または版改定 = true;
        }
        if (ShinkiIdoKubun.再登録.getコード().equals(新規異動区分)) {
            再登録 = true;
        }
        if (ShinkiIdoKubun.異動.getコード().equals(新規異動区分)) {
            異動 = true;
        }
        return new SougouJigyouJyohouMybatisParameter(
                当初または版改定,
                再登録,
                異動,
                個人番号付替対象者被保険者番号,
                対象開始日時,
                対象終了日時,
                TokuteiKojinJohomeiCode.特定個人情報版管理番号04.getコード(),
                DataSetNo._0102住所地特例情報.getコード(),
                版番号,
                TeikyoKubun.個人番号未設定により未提供.getコード(),
                TeikyoKubun.その他エラーにより未提供.getコード(),
                KaigoGassan_Idokubun.仮データ.getCode(),
                KaigoGassan_DataSakuseiKubun.自己負担額確認情報括.getコード(),
                KaigoGassan_DataSakuseiKubun.国保連.getコード());
    }
}
