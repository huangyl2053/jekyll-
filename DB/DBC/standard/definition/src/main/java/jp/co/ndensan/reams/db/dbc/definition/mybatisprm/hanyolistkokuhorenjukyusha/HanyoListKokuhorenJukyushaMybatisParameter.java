/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyolistkokuhorenjukyusha;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kyodoshoriyojukyushajoho.HizukeChushutsuKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト 国保連受給者情報MybatisParameter
 *
 * @reamsid_L DBC-3104-020 yaodongsheng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HanyoListKokuhorenJukyushaMybatisParameter implements IMyBatisParameter {

    private final RString 保険者コード;
    private final RString 日付抽出区分;
    private final RString 処理対象年月From;
    private final RString 処理対象年月To;
    private final RString 異動年月From;
    private final RString 異動年月To;
    private final boolean is各異動月の最新のみ;
    private final List<RString> idokubuns;
    private final List<RString> minashiYokaigoKubuns;
    private final RString 事業者番号;
    private final List<Boolean> kohiFutanJyogengakuGengakus;
    private final List<RString> riyoshaFutanKubuns;
    private final List<RString> tokuteiNyushoshaSabisuKubuns;
    private final boolean is削除含める;
    private final boolean has事業者番号;
    private final boolean is範囲指定;
    private final boolean is直近のみ;
    private final boolean has処理対象年月From;
    private final boolean has処理対象年月To;
    private final boolean has異動年月From;
    private final boolean has異動年月To;
    private final boolean has保険者コード;
    private final RString psmShikibetsuTaisho;
    private final RString 出力順;

    /**
     * コンストラクタです。
     */
    private HanyoListKokuhorenJukyushaMybatisParameter(
            RString 保険者コード,
            RString 日付抽出区分,
            RString 処理対象年月From,
            RString 処理対象年月To,
            RString 異動年月From,
            RString 異動年月To,
            boolean is各異動月の最新のみ,
            List<RString> idokubuns,
            List<RString> minashiYokaigoKubuns,
            RString 事業者番号,
            List<Boolean> kohiFutanJyogengakuGengakus,
            List<RString> riyoshaFutanKubuns,
            List<RString> tokuteiNyushoshaSabisuKubuns,
            boolean is削除含める,
            boolean has事業者番号,
            boolean is範囲指定,
            boolean is直近のみ,
            boolean has処理対象年月From,
            boolean has処理対象年月To,
            boolean has異動年月From,
            boolean has異動年月To,
            boolean has保険者コード,
            RString psmShikibetsuTaisho,
            RString 出力順
    ) {
        this.保険者コード = 保険者コード;
        this.日付抽出区分 = 日付抽出区分;
        this.処理対象年月From = 処理対象年月From;
        this.処理対象年月To = 処理対象年月To;
        this.異動年月From = 異動年月From;
        this.異動年月To = 異動年月To;
        this.is各異動月の最新のみ = is各異動月の最新のみ;
        this.idokubuns = idokubuns;
        this.minashiYokaigoKubuns = minashiYokaigoKubuns;
        this.事業者番号 = 事業者番号;
        this.kohiFutanJyogengakuGengakus = kohiFutanJyogengakuGengakus;
        this.riyoshaFutanKubuns = riyoshaFutanKubuns;
        this.tokuteiNyushoshaSabisuKubuns = tokuteiNyushoshaSabisuKubuns;
        this.is削除含める = is削除含める;
        this.has事業者番号 = has事業者番号;
        this.is範囲指定 = is範囲指定;
        this.is直近のみ = is直近のみ;
        this.has処理対象年月From = has処理対象年月From;
        this.has処理対象年月To = has処理対象年月To;
        this.has異動年月From = has異動年月From;
        this.has異動年月To = has異動年月To;
        this.has保険者コード = has保険者コード;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.出力順 = 出力順;
    }

    /**
     * MybatisParameterの作成です。
     *
     * @param 保険者コード 保険者コード
     * @param 日付抽出区分 日付抽出区分
     * @param 処理対象年月From 処理対象年月From
     * @param 処理対象年月To 処理対象年月To
     * @param 異動年月From 異動年月From
     * @param 異動年月To 異動年月To
     * @param is各異動月の最新のみ is各異動月の最新のみ
     * @param 異動区分s 異動区分s
     * @param みなし要介護区分s みなし要介護区分s
     * @param 事業者番号 事業者番号
     * @param 公費負担上限額減額s 公費負担上限額減額s
     * @param 利用者負担区分s 利用者負担区分s
     * @param 特定入所者サービス区分s 特定入所者サービス区分s
     * @param is削除含める is削除含める
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param 出力順 出力順
     * @return KijunShunyugakuTekiyoMybatisParameter
     */
    public static HanyoListKokuhorenJukyushaMybatisParameter createMybatisParameter(RString 保険者コード,
            RString 日付抽出区分,
            RString 処理対象年月From,
            RString 処理対象年月To,
            RString 異動年月From,
            RString 異動年月To,
            boolean is各異動月の最新のみ,
            List<RString> 異動区分s,
            List<RString> みなし要介護区分s,
            RString 事業者番号,
            List<Boolean> 公費負担上限額減額s,
            List<RString> 利用者負担区分s,
            List<RString> 特定入所者サービス区分s,
            boolean is削除含める,
            RString psmShikibetsuTaisho,
            RString 出力順) {
        boolean has事業者番号 = isNotNull(事業者番号);
        boolean is範囲指定 = false;
        boolean is直近のみ = false;
        boolean has処理対象年月From = isNotNull(処理対象年月From);
        boolean has処理対象年月To = isNotNull(処理対象年月To);
        boolean has異動年月From = isNotNull(異動年月From);
        boolean has異動年月To = isNotNull(異動年月To);
        boolean has保険者コード = false;
        if (HizukeChushutsuKubun.直近のみ.getコード().equals(日付抽出区分)) {
            is直近のみ = true;
        } else if (HizukeChushutsuKubun.範囲指定.getコード().equals(日付抽出区分)) {
            is範囲指定 = true;
        }
        if (!RString.isNullOrEmpty(保険者コード) && !new RString("000000").equals(保険者コード)) {
            has保険者コード = true;
        }
        return new HanyoListKokuhorenJukyushaMybatisParameter(保険者コード,
                日付抽出区分,
                処理対象年月From,
                処理対象年月To,
                異動年月From,
                異動年月To,
                is各異動月の最新のみ,
                異動区分s,
                みなし要介護区分s,
                事業者番号,
                公費負担上限額減額s,
                利用者負担区分s,
                特定入所者サービス区分s,
                is削除含める,
                has事業者番号,
                is範囲指定,
                is直近のみ,
                has処理対象年月From,
                has処理対象年月To,
                has異動年月From,
                has異動年月To,
                has保険者コード,
                psmShikibetsuTaisho,
                出力順);
    }

    private static boolean isNotNull(RString value) {
        boolean flag = false;
        if (!RString.isNullOrEmpty(value)) {
            flag = true;
        }
        return flag;
    }
}
