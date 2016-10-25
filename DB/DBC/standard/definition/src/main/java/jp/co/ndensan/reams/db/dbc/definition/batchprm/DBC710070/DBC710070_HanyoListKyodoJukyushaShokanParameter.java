/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710070;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc710070.HanyoListKyodoJukyushaShokanProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト 共同処理用受給者情報（償還）バッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-3104-010 yaodongsheng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC710070_HanyoListKyodoJukyushaShokanParameter extends BatchParameterBase {

    private static final String CHOHYOID = "chohyoId";
    private static final String SHUTSURYOKUJUNID = "shutsuryokujunId";
    private static final String SHUTSURYOKUKOMOKUID = "shutsuryokukomokuId";
    private static final String KOMOKUMEFUKA = "komokumeFuka";
    private static final String RENBANFUKA = "renbanFuka";
    private static final String HITSUKEHENSHU = "hitsukeHenshu";
    private static final String HOKENSHAKODO = "hokenshaKodo";
    private static final String HITSUKECHUSHUTSUKUBUN = "hitsukeChushutsuKubun";
    private static final String SHORITAISHONENGETSUFROM = "shoriTaishoNengetsuFrom";
    private static final String SHORITAISHONENGETSUTO = "shoriTaishoNengetsuTo";
    private static final String IDONENGETSUFROM = "idoNengetsuFrom";
    private static final String IDONENGETSUTO = "idoNengetsuTo";
    private static final String KAKUIDOZUKINOSAISHINNOMI = "kakuidozukinoSaishinNomi";
    private static final String IDOKUBUN = "idoKubun";
    private static final String SAKUJYOMERU = "sakujyoMeru";
    @BatchParameter(key = CHOHYOID, name = "帳票ID")
    private RString chohyoId;
    @BatchParameter(key = SHUTSURYOKUJUNID, name = "出力順ID")
    private Long shutsuryokujunId;
    @BatchParameter(key = SHUTSURYOKUKOMOKUID, name = "出力項目ID")
    private RString shutsuryokukomokuId;
    @BatchParameter(key = KOMOKUMEFUKA, name = "項目名付加")
    private boolean komokumeFuka;
    @BatchParameter(key = RENBANFUKA, name = "連番付加")
    private boolean renbanFuka;
    @BatchParameter(key = HITSUKEHENSHU, name = "日付編集")
    private boolean hitsukeHenshu;
    @BatchParameter(key = HOKENSHAKODO, name = "保険者コード")
    private RString hokenshaKodo;
    @BatchParameter(key = HITSUKECHUSHUTSUKUBUN, name = "日付抽出区分")
    private RString hitsukeChushutsuKubun;
    @BatchParameter(key = SHORITAISHONENGETSUFROM, name = "処理対象年月From")
    private RString shoriTaishoNengetsuFrom;
    @BatchParameter(key = SHORITAISHONENGETSUTO, name = "処理対象年月To")
    private RString shoriTaishoNengetsuTo;
    @BatchParameter(key = IDONENGETSUFROM, name = "異動年月From")
    private RString idoNengetsuFrom;
    @BatchParameter(key = IDONENGETSUTO, name = "異動年月To")
    private RString idoNengetsuTo;
    @BatchParameter(key = KAKUIDOZUKINOSAISHINNOMI, name = "各異動月の最新のみ")
    private boolean kakuidozukinoSaishinNomi;
    @BatchParameter(key = IDOKUBUN, name = "異動区分s")
    private List<RString> idoKubun;
    @BatchParameter(key = SAKUJYOMERU, name = "削除含める")
    private boolean sakujyoMeru;

    /**
     * toProcessParameterのメソッドです。
     *
     * @return 汎用リスト_共同処理用受給者情報（償還）用ProcessParameter HanyoListKyodoJukyushaShokanProcessParameter
     */
    public HanyoListKyodoJukyushaShokanProcessParameter toProcessParameter() {
        FlexibleYearMonth 処理対象年月From = null;
        FlexibleYearMonth 処理対象年月To = null;
        FlexibleYearMonth 異動年月From = null;
        FlexibleYearMonth 異動年月To = null;
        RString 帳票ID = RString.EMPTY;
        if (!RString.isNullOrEmpty(shoriTaishoNengetsuFrom)) {
            処理対象年月From = new FlexibleYearMonth(shoriTaishoNengetsuFrom);
        }
        if (!RString.isNullOrEmpty(shoriTaishoNengetsuTo)) {
            処理対象年月To = new FlexibleYearMonth(shoriTaishoNengetsuTo);
        }
        if (!RString.isNullOrEmpty(idoNengetsuFrom)) {
            異動年月From = new FlexibleYearMonth(idoNengetsuFrom);
        }
        if (!RString.isNullOrEmpty(idoNengetsuTo)) {
            異動年月To = new FlexibleYearMonth(idoNengetsuTo);
        }
        if (shutsuryokujunId != null) {
            帳票ID = new RString(shutsuryokujunId);
        }
        return new HanyoListKyodoJukyushaShokanProcessParameter(
                chohyoId, 帳票ID, shutsuryokukomokuId, komokumeFuka, renbanFuka, hitsukeHenshu, hokenshaKodo, hitsukeChushutsuKubun,
                処理対象年月From, 処理対象年月To, 異動年月From, 異動年月To, kakuidozukinoSaishinNomi, idoKubun, sakujyoMeru);
    }
}
