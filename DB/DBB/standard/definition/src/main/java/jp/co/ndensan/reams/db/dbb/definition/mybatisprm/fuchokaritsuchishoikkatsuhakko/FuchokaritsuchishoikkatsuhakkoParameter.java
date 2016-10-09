/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuchokaritsuchishoikkatsuhakko;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 異動賦課情報一時テーブルInsertパラメータ
 *
 * @reamsid_L DBB-0710-030 yebangqiang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public final class FuchokaritsuchishoikkatsuhakkoParameter implements IMyBatisParameter {

    private final int 普徴仮算定期間の最後の期;
    private final int 出力期;
    private final RString 納入通知書対象者;
    private final RString 生活保護者先頭出力フラグ;
    private final RString 出力順;

    /**
     * コンストラクタです。
     *
     * @param 普徴仮算定期間の最後の期 int
     * @param 出力期 int
     * @param 納入通知書対象者 RString
     * @param 生活保護者先頭出力フラグ RString
     * @param 出力順 RString
     */
    private FuchokaritsuchishoikkatsuhakkoParameter(
            int 普徴仮算定期間の最後の期,
            int 出力期,
            RString 納入通知書対象者,
            RString 生活保護者先頭出力フラグ,
            RString 出力順) {
        this.普徴仮算定期間の最後の期 = 普徴仮算定期間の最後の期;
        this.出力期 = 出力期;
        this.納入通知書対象者 = 納入通知書対象者;
        this.生活保護者先頭出力フラグ = 生活保護者先頭出力フラグ;
        this.出力順 = 出力順;
    }

    /**
     * パラメータメソッドです。
     *
     * @param 普徴仮算定期間の最後の期 int
     * @param 出力期 int
     * @param 納入通知書対象者 RString
     * @param 生活保護者先頭出力フラグ RString
     * @param 出力順 RString
     * @return FuchokaritsuchishoikkatsuhakkoParameter
     */
    public static FuchokaritsuchishoikkatsuhakkoParameter createSelectByKeyParam(
            int 普徴仮算定期間の最後の期,
            int 出力期,
            RString 納入通知書対象者,
            RString 生活保護者先頭出力フラグ,
            RString 出力順) {
        return new FuchokaritsuchishoikkatsuhakkoParameter(普徴仮算定期間の最後の期, 出力期, 納入通知書対象者,
                生活保護者先頭出力フラグ, 出力順);
    }
}
