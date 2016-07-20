/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.tokubetsuchoshudoteimidoteiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokubetsuchoshudoteimidoteiichiran.TokubetsuChoshuDoteiMiDoteiIchiranProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * ビジネス設計_DBBBZ81003_1_特徴対象者一覧作成
 *
 * @reamsid_L DBB-1860-030 yangchenbing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChoshuDoteiMiDoteiIchiranBatchParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;
    private static final String KEY_SHORINENDO = "shoriNendo";
    @BatchParameter(key = KEY_SHORINENDO, name = "処理年度")
    private FlexibleYear shoriNendo;
    private static final String KEY_HOSOKUDUKILIST = "hosokudukiList";
    @BatchParameter(key = KEY_HOSOKUDUKILIST, name = "捕捉月リスト")
    private List<RString> hosokudukiList;
    private static final String KEY_TOKUBETUCHOSHUKAISHIDUKI = "tokubetuchoshuKaishiDuki";
    @BatchParameter(key = KEY_TOKUBETUCHOSHUKAISHIDUKI, name = "特別徴収開始月")
    private RString tokubetuchoshuKaishiDuki;
    private static final String KEY_SHURYOTAISHO = "shuryoTaisho";
    @BatchParameter(key = KEY_SHURYOTAISHO, name = "出力対象")
    private RString shuturyokuTaisho;
    private static final String KEY_SHORINICHIJI = "shoriNichiji";
    @BatchParameter(key = KEY_SHORINICHIJI, name = "処理日時")
    private YMDHMS shoriNichiji;
    private static final String KEY_KAKUNINJOKYOKUBUN = "kakuninJokyoKubun";
    @BatchParameter(key = KEY_KAKUNINJOKYOKUBUN, name = "確認状況区分")
    private boolean kakuninJokyoKubun;

    /**
     * toProcessParameterのメソドです。
     *
     * @return TokubetsuChoshuDoteiMiDoteiIchiranProcessParameter
     */
    public TokubetsuChoshuDoteiMiDoteiIchiranProcessParameter toProcessParameter() {
        return new TokubetsuChoshuDoteiMiDoteiIchiranProcessParameter(
                shoriNendo, hosokudukiList, tokubetuchoshuKaishiDuki, shuturyokuTaisho, shoriNichiji
        );
    }
}
