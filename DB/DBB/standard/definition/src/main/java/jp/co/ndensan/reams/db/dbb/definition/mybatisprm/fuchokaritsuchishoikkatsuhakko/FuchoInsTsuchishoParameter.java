/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuchokaritsuchishoikkatsuhakko;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 異動賦課情報一時テーブルInsertパラメータ
 *
 * @reamsid_L DBB-0710-040 yebangqiang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public final class FuchoInsTsuchishoParameter implements IMyBatisParameter {

    private final ReportId 帳票ID;
    private final YMDHMS 帳票作成日時;
    private final int 普徴仮算定期間の最後の期;
    private final int 出力期;
    private final RString 納入通知書対象者;
    private final RString 出力順;

    /**
     * コンストラクタです。
     *
     * @param 普徴仮算定期間の最後の期 int
     * @param 出力期 int
     * @param 納入通知書対象者 RString
     * @param 出力順 RString
     * @param 帳票ID ReportId
     * @param 帳票作成日時 YMDHMS
     */
    private FuchoInsTsuchishoParameter(
            int 普徴仮算定期間の最後の期,
            int 出力期,
            RString 納入通知書対象者,
            RString 出力順,
            ReportId 帳票ID,
            YMDHMS 帳票作成日時) {
        this.帳票ID = 帳票ID;
        this.帳票作成日時 = 帳票作成日時;
        this.普徴仮算定期間の最後の期 = 普徴仮算定期間の最後の期;
        this.出力期 = 出力期;
        this.納入通知書対象者 = 納入通知書対象者;
        this.出力順 = 出力順;
    }

    /**
     * パラメータメソッドです。
     *
     * @param 普徴仮算定期間の最後の期 int
     * @param 出力期 int
     * @param 納入通知書対象者 RString
     * @param 出力順 RString
     * @param 帳票ID ReportId
     * @param 帳票作成日時 YMDHMS
     * @return FuchokaritsuchishoikkatsuhakkoParameter
     */
    public static FuchoInsTsuchishoParameter createSelectByKeyParam(
            int 普徴仮算定期間の最後の期,
            int 出力期,
            RString 納入通知書対象者,
            RString 出力順,
            ReportId 帳票ID,
            YMDHMS 帳票作成日時) {
        return new FuchoInsTsuchishoParameter(普徴仮算定期間の最後の期, 出力期, 納入通知書対象者,
                出力順, 帳票ID, 帳票作成日時);
    }
}
