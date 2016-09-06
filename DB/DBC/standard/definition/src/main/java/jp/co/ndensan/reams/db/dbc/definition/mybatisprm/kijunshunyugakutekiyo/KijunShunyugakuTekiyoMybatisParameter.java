/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kijunshunyugakutekiyo;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kijunshunyugakutekiyo.ChushutsuKubun;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kijunshunyugakutekiyo.DataShubetsu;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト_基準収入額適用情報のMybatis用パラメータクラスです。
 *
 * @reamsid_L DBC-5050-030 duanzhanli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KijunShunyugakuTekiyoMybatisParameter implements IMyBatisParameter {

    private final RString 保険者コード;
    private final boolean is保険者コード;
    private final RString 対象年度;
    private final boolean is対象年度NULL;
    private final boolean is削除含める;
    private final RString データ種別;
    private final boolean isデータ種別_適用決定;
    private final boolean isデータ種別_申請中;
    private final RString 抽出区分;
    private final boolean is抽出区分_最新履歴;
    private final boolean is抽出区分_基準日時点;
    private final RString 基準年月;
    private final RString 申請日From;
    private final boolean is申請日FromNULL;
    private final RString 申請日To;
    private final boolean is申請日ToNULL;
    private final RString 決定日From;
    private final boolean is決定日FromNULL;
    private final RString 決定日To;
    private final boolean is決定日ToNULL;
    private final RString psmShikibetsuTaisho;
    private final RString psmAtesaki;
    private final RString 出力順;

    /**
     * コンストラクタです。
     *
     * @param 保険者コード 保険者コード
     * @param 対象年度 対象年度
     * @param is削除含める is削除含める
     * @param データ種別 データ種別
     * @param 抽出区分 抽出区分
     * @param 基準年月 基準年月
     * @param 申請日From 申請日From
     * @param 申請日To 申請日To
     * @param 決定日From 決定日From
     * @param 決定日To 決定日To
     * @param 出力順 出力順
     */
    private KijunShunyugakuTekiyoMybatisParameter(
            RString 保険者コード,
            boolean is保険者コード,
            RString 対象年度,
            boolean is対象年度NULL,
            boolean is削除含める,
            RString データ種別,
            boolean isデータ種別_適用決定,
            boolean isデータ種別_申請中,
            RString 抽出区分,
            boolean is抽出区分_最新履歴,
            boolean is抽出区分_基準日時点,
            RString 基準年月,
            RString 申請日From,
            boolean is申請日FromNULL,
            RString 申請日To,
            boolean is申請日ToNULL,
            RString 決定日From,
            boolean is決定日FromNULL,
            RString 決定日To,
            boolean is決定日ToNULL,
            RString psmShikibetsuTaisho,
            RString psmAtesaki,
            RString 出力順) {
        this.保険者コード = 保険者コード;
        this.is保険者コード = is保険者コード;
        this.対象年度 = 対象年度;
        this.is対象年度NULL = is対象年度NULL;
        this.is削除含める = is削除含める;
        this.データ種別 = データ種別;
        this.isデータ種別_適用決定 = isデータ種別_適用決定;
        this.isデータ種別_申請中 = isデータ種別_申請中;
        this.抽出区分 = 抽出区分;
        this.is抽出区分_最新履歴 = is抽出区分_最新履歴;
        this.is抽出区分_基準日時点 = is抽出区分_基準日時点;
        this.基準年月 = 基準年月;
        this.申請日From = 申請日From;
        this.is申請日FromNULL = is申請日FromNULL;
        this.申請日To = 申請日To;
        this.is申請日ToNULL = is申請日ToNULL;
        this.決定日From = 決定日From;
        this.is決定日FromNULL = is決定日FromNULL;
        this.決定日To = 決定日To;
        this.is決定日ToNULL = is決定日ToNULL;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.psmAtesaki = psmAtesaki;
        this.出力順 = 出力順;
    }

    /**
     * MybatisParameterの作成です。
     *
     * @param 保険者コード 保険者コード
     * @param 対象年度 対象年度
     * @param is削除含める is削除含める
     * @param データ種別 データ種別
     * @param 抽出区分 抽出区分
     * @param 基準年月 基準年月
     * @param 申請日From 申請日From
     * @param 申請日To 申請日To
     * @param 決定日From 決定日From
     * @param 決定日To 決定日To
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param psmAtesaki psmAtesaki
     * @param 出力順 出力順
     * @return KijunShunyugakuTekiyoMybatisParameter
     */
    public static KijunShunyugakuTekiyoMybatisParameter createMybatisParameter(RString 保険者コード,
            RString 対象年度,
            boolean is削除含める,
            RString データ種別,
            RString 抽出区分,
            RString 基準年月,
            RString 申請日From,
            RString 申請日To,
            RString 決定日From,
            RString 決定日To,
            RString psmShikibetsuTaisho,
            RString psmAtesaki,
            RString 出力順) {
        boolean is保険者コード = false;
        boolean is対象年度 = false;
        boolean isデータ種別_適用 = false;
        boolean isデータ種別_申請 = false;
        boolean is抽出区分_履歴 = false;
        boolean is抽出区分_基準日 = false;
        if (!RString.isNullOrEmpty(保険者コード) && !new RString("000000").equals(保険者コード)) {
            is保険者コード = true;
        }
        if (RString.isNullOrEmpty(対象年度)) {
            is対象年度 = true;
        }
        if (DataShubetsu.申請中データ.getコード().equals(データ種別)) {
            isデータ種別_申請 = true;
        }
        if (DataShubetsu.適用決定データ.getコード().equals(データ種別)) {
            isデータ種別_適用 = true;
        }
        if (ChushutsuKubun.最新履歴.getコード().equals(抽出区分)) {
            is抽出区分_履歴 = true;
        }
        if (ChushutsuKubun.基準年月時点のデータ.getコード().equals(抽出区分)) {
            is抽出区分_基準日 = true;
        }
        return new KijunShunyugakuTekiyoMybatisParameter(保険者コード,
                is保険者コード,
                対象年度,
                is対象年度,
                is削除含める,
                データ種別,
                isデータ種別_適用,
                isデータ種別_申請,
                抽出区分,
                is抽出区分_履歴,
                is抽出区分_基準日,
                基準年月,
                申請日From,
                isnull(申請日From),
                申請日To,
                isnull(申請日To),
                決定日From,
                isnull(決定日From),
                決定日To,
                isnull(決定日To),
                psmShikibetsuTaisho,
                psmAtesaki,
                出力順);
    }

    private static boolean isnull(RString value) {
        boolean flag = false;
        if (RString.isNullOrEmpty(value)) {
            flag = true;
        }
        return flag;
    }
}
