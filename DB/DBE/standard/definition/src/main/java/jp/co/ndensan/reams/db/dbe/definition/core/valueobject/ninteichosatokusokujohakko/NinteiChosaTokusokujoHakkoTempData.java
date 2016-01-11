/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninteichosatokusokujohakko;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * NinteiChosaTokusokujoHakkoDivのTempDataクラスです。
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class NinteiChosaTokusokujoHakkoTempData implements Serializable {

    private RString temp_保険者コード;
    private RString temp_保険者名称;
    private RString temp_認定調査委託先コード;
    private RString temp_認定調査員コード;
    private FlexibleDate temp_基準日;
    private Decimal temp_認定調査督促期限日数;
    private RString temp_要介護認定調査督促状;
    private RString temp_認定調査督促対象者一覧表;
    private RString temp_CSV出力;
    private RString temp_印刷済対象者;
    private RString temp_発行履歴;
    private int temp_督促方法;
    private RString temp_督促メモ;
    private FlexibleDate temp_督促日;
    private RDate temp_印刷期間開始日;
    private RDate temp_印刷期間終了日;
    private RString temp_出力順;
    private RString temp_集計;
    private RString temp_改頁;
    private RString temp_印刷書類区分;

}
