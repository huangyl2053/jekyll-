/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchotaishoshaichiransakusei;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBBBZ81003_1_特徴対象者一覧作成
 *
 * @reamsid_L DBB-1860-030 yangchenbing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoTaishoshaIchiranSakuseiMybatisParameter implements IMyBatisParameter {

    private GyomuCode 業務コード;
    private FlexibleYear 処理年度;
    private RString 基礎年金番号;
    private RString 年金コード;
    private RString 開始月;
    private RString 捕捉月;
    private ShikibetsuCode 識別コード;
    private RString 通知内容コード;
    private List<RString> 捕捉月リスト;
    private List<RString> 確認状況区分リスト;
}
