/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigohokenryogaku.KaigoHokenryogakuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBBRP43002_4_特別徴収開始通知書（本算定）TokubetsuChoshuKaishiParameter
 *
 * @reamsid_L DBB-0780-100 yangchenbing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChoshuKaishiParameter {

    private RString 賦課年度;
    private RString 調定年度;
    private List<KaigoHokenryogakuEntity> 出力帳票entity;
    private RString 出力期;
}
