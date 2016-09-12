/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kijunshunyugakutekiyo;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト_基準収入額適用情報のProcess用パラメータクラスです。
 *
 * @reamsid_L DBC-5050-030 duanzhanli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KijunShunyugakuTekiyoProcessParameter implements IBatchProcessParameter {

    private final RString 帳票ID;
    private final long 出力順ID;
    private final RString 出力順項目ID;
    private final boolean is項目名付加;
    private final boolean is日付編集;
    private final RString 保険者コード;
    private final RString 対象年度;
    private final boolean is削除含める;
    private final RString データ種別;
    private final RString 抽出区分;
    private final RString 基準年月;
    private final RString 申請日From;
    private final RString 申請日To;
    private final RString 決定日From;
    private final RString 決定日To;

    /**
     * コンストラクタです。
     *
     * @param 帳票ID 帳票ID
     * @param 出力順ID 出力順ID
     * @param 出力順項目ID 出力順項目ID
     * @param is項目名付加 is項目名付加
     * @param is日付編集 is日付編集
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
     */
    public KijunShunyugakuTekiyoProcessParameter(RString 帳票ID,
            long 出力順ID,
            RString 出力順項目ID,
            boolean is項目名付加,
            boolean is日付編集,
            RString 保険者コード,
            RString 対象年度,
            boolean is削除含める,
            RString データ種別,
            RString 抽出区分,
            RString 基準年月,
            RString 申請日From,
            RString 申請日To,
            RString 決定日From,
            RString 決定日To) {
        this.帳票ID = 帳票ID;
        this.出力順ID = 出力順ID;
        this.出力順項目ID = 出力順項目ID;
        this.is項目名付加 = is項目名付加;
        this.is日付編集 = is日付編集;
        this.保険者コード = 保険者コード;
        this.対象年度 = 対象年度;
        this.is削除含める = is削除含める;
        this.データ種別 = データ種別;
        this.抽出区分 = 抽出区分;
        this.基準年月 = 基準年月;
        this.申請日From = 申請日From;
        this.申請日To = 申請日To;
        this.決定日From = 決定日From;
        this.決定日To = 決定日To;
    }
}
