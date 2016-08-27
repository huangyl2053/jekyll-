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

    @BatchParameter(key = "reportID", name = "帳票ID")
    private RString 帳票ID;
    @BatchParameter(key = "shutsuryokujunId", name = "出力順ID")
    private long 出力順ID;
    @BatchParameter(key = "shutsuryokujunkomokuId", name = "出力順項目ID")
    private RString 出力順項目ID;
    @BatchParameter(key = "komoukumei", name = "is項目名付加")
    private boolean is項目名付加;
    @BatchParameter(key = "renbanFuka", name = "is連番付加")
    private boolean is連番付加;
    @BatchParameter(key = "isdateedit", name = "is日付編集")
    private boolean is日付編集;
    @BatchParameter(key = "honkenshaCode", name = "保険者コード")
    private RString 保険者コード;
    @BatchParameter(key = "taishonendo", name = "対象年度")
    private RString 対象年度;
    @BatchParameter(key = "isdeleteflag", name = "is削除含める")
    private boolean is削除含める;
    @BatchParameter(key = "datashubetsu", name = "データ種別")
    private RString データ種別;
    @BatchParameter(key = "tyusyutuKubun", name = "抽出区分")
    private RString 抽出区分;
    @BatchParameter(key = "kijunYM", name = "基準年月")
    private RString 基準年月;
    @BatchParameter(key = "shinseiYMDFrom", name = "申請日From")
    private RString 申請日From;
    @BatchParameter(key = "shinseiYMDTo", name = "申請日To")
    private RString 申請日To;
    @BatchParameter(key = "kettiYMDFrom", name = "決定日From")
    private RString 決定日From;
    @BatchParameter(key = "kettiYMDTo", name = "決定日To")
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
