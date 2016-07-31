/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.tokuchotaishoshaichiransakusei;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBBBZ81003_1_特徴対象者一覧作成
 *
 * @reamsid_L DBB-1860-030 yangchenbing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoTaishoshaIchiranSakuseiResult {

    private RString 捕捉月１;
    private RString 捕捉月２;
    private RString 捕捉月３;
    private RString 捕捉月表示内容;
    private RString 特別徴収開始月;
    private List<RString> 捕捉月リスト;
    private RString 出力対象;
    private boolean 確認状況区分;

}
