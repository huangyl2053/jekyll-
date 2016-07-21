/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.honsanteiidokanendofuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidogennen.ChohyoResult;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 本算定通知書一括発行（過年度）のパラメータクラスです。
 *
 * @reamsid_L DBB-0920-030 huzongcheng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KanendoHonsanteifukaProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 調定年度;
    private ChohyoResult 出力帳票;
    private List<FlexibleYear> 決定_対象賦課年度;
    private List<FlexibleYear> 変更_対象賦課年度;
    private List<FlexibleYear> 納入_対象賦課年度;
    private RDate 決定_発行日;
    private RString 決定_文書番号;
    private RDate 変更_発行日;
    private RString 変更_文書番号;
    private RString 変更_対象者;
    private RDate 納入_発行日;
    private RString 納入_出力期;
    private RString 納入_対象者;
    private RString 納入_口座振替様式;
    private RString 納入_生保護対象者先頭出力;
    private RString 納入_ページごとに山分け;
    private boolean 一括発行起動フラグ;
    private YMDHMS 帳票作成日時;

    /**
     * コンストラクタ
     *
     * @param 調定年度 FlexibleYear
     * @param 出力帳票 ChohyoResult
     * @param 決定_対象賦課年度 List<FlexibleYear>
     * @param 変更_対象賦課年度 List<FlexibleYear>
     * @param 納入_対象賦課年度 List<FlexibleYear>
     * @param 決定_発行日 RDate
     * @param 決定_文書番号 RString
     * @param 変更_発行日 RDate
     * @param 変更_文書番号 RString
     * @param 変更_対象者 RString
     * @param 納入_出力期 RString
     * @param 納入_対象者 RString
     * @param 納入_発行日 RDate
     * @param 納入_口座振替様式 RString
     * @param 納入_生保護対象者先頭出力 RString
     * @param 納入_ページごとに山分け RString
     * @param 一括発行起動フラグ boolean
     * @param 帳票作成日時 YMDHMS
     */
    public KanendoHonsanteifukaProcessParameter(FlexibleYear 調定年度,
            ChohyoResult 出力帳票,
            List<FlexibleYear> 決定_対象賦課年度,
            List<FlexibleYear> 変更_対象賦課年度,
            List<FlexibleYear> 納入_対象賦課年度,
            RDate 決定_発行日,
            RString 決定_文書番号,
            RDate 変更_発行日,
            RString 変更_文書番号,
            RString 変更_対象者,
            RDate 納入_発行日,
            RString 納入_出力期,
            RString 納入_対象者,
            RString 納入_口座振替様式,
            RString 納入_生保護対象者先頭出力,
            RString 納入_ページごとに山分け,
            boolean 一括発行起動フラグ,
            YMDHMS 帳票作成日時) {
        this.調定年度 = 調定年度;
        this.出力帳票 = 出力帳票;
        this.決定_対象賦課年度 = 決定_対象賦課年度;
        this.変更_対象賦課年度 = 変更_対象賦課年度;
        this.納入_対象賦課年度 = 納入_対象賦課年度;
        this.決定_発行日 = 決定_発行日;
        this.決定_文書番号 = 決定_文書番号;
        this.変更_発行日 = 変更_発行日;
        this.変更_文書番号 = 変更_文書番号;
        this.変更_対象者 = 変更_対象者;
        this.納入_発行日 = 納入_発行日;
        this.納入_出力期 = 納入_出力期;
        this.納入_対象者 = 納入_対象者;
        this.納入_口座振替様式 = 納入_口座振替様式;
        this.納入_生保護対象者先頭出力 = 納入_生保護対象者先頭出力;
        this.納入_ページごとに山分け = 納入_ページごとに山分け;
        this.一括発行起動フラグ = 一括発行起動フラグ;
        this.帳票作成日時 = 帳票作成日時;
    }
}
