/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710200;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kijunshunyugakutekiyo.KijunShunyugakuTekiyoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト_基準収入額適用情報のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-5050-030 duanzhanli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC710200_HanyoListKijunShunyugakuTekiyoParameter extends BatchParameterBase {

    private static final String KEY_REPORTID = "帳票ID";
    private static final String KEY_SHUTSURYOKUJUNID = "出力順ID";
    private static final String KEY_SHUTSURYOKUJUNKOMOKUID = "出力順項目ID";
    private static final String KEY_KOMOUKUMEI = "is項目名付加";
    private static final String KEY_RENBANFUKA = "is連番付加";
    private static final String KEY_ISDATEEDIT = "is日付編集";
    private static final String KEY_HONKENSHACODE = "保険者コード";
    private static final String KEY_TAISHONENDO = "対象年度";
    private static final String KEY_ISDELETEFLAG = "is削除含める";
    private static final String KEY_DATASHUBETSU = "データ種別";
    private static final String KEY_TYUSYUTUKUBUN = "抽出区分";
    private static final String KEY_KIJUNYM = "基準年月";
    private static final String KEY_SHINSEIYMDFROM = "申請日From";
    private static final String KEY_SHINSEIYMDTO = "申請日To";
    private static final String KEY_KETTIYMDFROM = "決定日From";
    private static final String KEY_KETTIYMDTO = "決定日To";

    @BatchParameter(key = KEY_REPORTID, name = "帳票ID")
    private RString 帳票ID;
    @BatchParameter(key = KEY_SHUTSURYOKUJUNID, name = "出力順ID")
    private long 出力順ID;
    @BatchParameter(key = KEY_SHUTSURYOKUJUNKOMOKUID, name = "出力順項目ID")
    private RString 出力順項目ID;
    @BatchParameter(key = KEY_KOMOUKUMEI, name = "is項目名付加")
    private boolean is項目名付加;
    @BatchParameter(key = KEY_RENBANFUKA, name = "is連番付加")
    private boolean is連番付加;
    @BatchParameter(key = KEY_ISDATEEDIT, name = "is日付編集")
    private boolean is日付編集;
    @BatchParameter(key = KEY_HONKENSHACODE, name = "保険者コード")
    private RString 保険者コード;
    @BatchParameter(key = KEY_TAISHONENDO, name = "対象年度")
    private RString 対象年度;
    @BatchParameter(key = KEY_ISDELETEFLAG, name = "is削除含める")
    private boolean is削除含める;
    @BatchParameter(key = KEY_DATASHUBETSU, name = "データ種別")
    private RString データ種別;
    @BatchParameter(key = KEY_TYUSYUTUKUBUN, name = "抽出区分")
    private RString 抽出区分;
    @BatchParameter(key = KEY_KIJUNYM, name = "基準年月")
    private RString 基準年月;
    @BatchParameter(key = KEY_SHINSEIYMDFROM, name = "申請日From")
    private RString 申請日From;
    @BatchParameter(key = KEY_SHINSEIYMDTO, name = "申請日To")
    private RString 申請日To;
    @BatchParameter(key = KEY_KETTIYMDFROM, name = "決定日From")
    private RString 決定日From;
    @BatchParameter(key = KEY_KETTIYMDTO, name = "決定日To")
    private RString 決定日To;

    /**
     * プロセスパラメータを作成します。
     *
     * @return プロセスパラメータ
     */
    public KijunShunyugakuTekiyoProcessParameter toProcessParameter() {
        return new KijunShunyugakuTekiyoProcessParameter(帳票ID,
                出力順ID,
                出力順項目ID,
                is項目名付加,
                is日付編集,
                保険者コード,
                対象年度,
                is削除含める,
                データ種別,
                抽出区分,
                基準年月,
                申請日From,
                申請日To,
                決定日From,
                決定日To);
    }
}
