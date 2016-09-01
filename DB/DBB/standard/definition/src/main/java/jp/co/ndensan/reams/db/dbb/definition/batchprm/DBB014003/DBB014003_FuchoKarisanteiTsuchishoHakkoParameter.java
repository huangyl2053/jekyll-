/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB014003;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb014003.FuchoKarisanteiTsuchishoHakkoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 普徴仮算定通知書一括発行のバッチパラメーターです。
 *
 * @reamsid_L DBB-0710-030 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBB014003_FuchoKarisanteiTsuchishoHakkoParameter extends BatchParameterBase {

    private static final String CHOTEINENDO = "調定年度";
    private static final String FUKANENDO = "賦課年度";
    private static final String LIST = "出力帳票一覧List";
    private static final String HAKKOYMD = "発行日";
    private static final String SYUTSURYOKUHOUHOU = "出力方法";
    private static final String NOTSUSHUTURYOKUKIHOUHOU = "出力期の表示方法";
    private static final String NOTSUSHUTURYOKUKI = "出力期";
    private static final String NOTSUTAISHOSHA = "対象者";
    private static final String NOTSUSEIKATSUHOGO = "生活保護対象者をまとめて先頭に出力";
    private static final String NOTSUYAMAWAKE = "ページごとに山分け";
    private static final String FLAG = "一括発行起動フラグ";

    @BatchParameter(key = CHOTEINENDO, name = "調定年度")
    private FlexibleYear 調定年度;
    @BatchParameter(key = FUKANENDO, name = "賦課年度")
    private FlexibleYear 賦課年度;
    @BatchParameter(key = LIST, name = "出力帳票一覧List")
    private List<BatchFuchoKariSanteiEntity> 出力帳票一覧List;
    @BatchParameter(key = HAKKOYMD, name = "発行日")
    private FlexibleDate 発行日;
    @BatchParameter(key = SYUTSURYOKUHOUHOU, name = "出力方法")
    private RString 出力方法;
    @BatchParameter(key = NOTSUSHUTURYOKUKIHOUHOU, name = "出力期の表示方法")
    private RString 出力期の表示方法;
    @BatchParameter(key = NOTSUSHUTURYOKUKI, name = "出力期")
    private RString 出力期;
    @BatchParameter(key = NOTSUTAISHOSHA, name = "対象者")
    private RString 対象者;
    @BatchParameter(key = NOTSUSEIKATSUHOGO, name = "生活保護対象者をまとめて先頭に出力")
    private RString 生活保護対象者をまとめて先頭に出力;
    @BatchParameter(key = NOTSUYAMAWAKE, name = "ページごとに山分け")
    private RString ページごとに山分け;
    @BatchParameter(key = FLAG, name = "一括発行起動フラグ")
    private boolean 一括発行起動フラグ;

    /**
     * processのパラメータを生成します。
     *
     * @param システム日時 YMDHMS
     * @return processパラメータ
     */
    public FuchoKarisanteiTsuchishoHakkoProcessParameter toProcessParam(YMDHMS システム日時) {
        return new FuchoKarisanteiTsuchishoHakkoProcessParameter(
                システム日時,
                調定年度,
                賦課年度,
                出力帳票一覧List,
                発行日,
                出力方法,
                出力期の表示方法,
                出力期,
                対象者,
                生活保護対象者をまとめて先頭に出力,
                ページごとに山分け,
                一括発行起動フラグ
        );
    }
}
