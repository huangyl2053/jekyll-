/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.dbe223001;

import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninteichosatokusokujohakko.NinteiChosaTokusokujoHakkoTempData;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査督促状発行のバッチパラメータクラスです。
 *
 */
@Getter
@Setter
public class DBE223001FlowParameter extends BatchParameterBase {

    private RString 保険者コード;
    private RString 保険者名称;
    private RString 認定調査委託先コード;
    private RString 認定調査員コード;
    private FlexibleDate 基準日;
    private Decimal 認定調査督促期限日数;
    private RString 要介護認定調査督促状;
    private RString 認定調査督促対象者一覧表;
    private RString CSV出力;
    private RString 印刷済対象者;
    private RString 発行履歴;
    private int 督促方法;
    private RString 督促メモ;
    private FlexibleDate 督促日;
    private RDate 印刷期間開始日;
    private RDate 印刷期間終了日;
    private RString 出力順;
    private RString 集計;
    private RString 改頁;

    public DBE223001FlowParameter toDBE223001Parameter(NinteiChosaTokusokujoHakkoTempData tempData) {
        DBE223001FlowParameter parameter = new DBE223001FlowParameter();
        this.保険者コード = tempData.getTemp_保険者コード();
        this.保険者名称 = tempData.getTemp_保険者名称();
        this.認定調査委託先コード = tempData.getTemp_認定調査委託先コード();
        this.認定調査員コード = tempData.getTemp_認定調査員コード();
        this.基準日 = tempData.getTemp_基準日();
        this.認定調査督促期限日数 = tempData.getTemp_認定調査督促期限日数();
        this.要介護認定調査督促状 = tempData.getTemp_要介護認定調査督促状();
        this.認定調査督促対象者一覧表 = tempData.getTemp_認定調査督促対象者一覧表();
        this.CSV出力 = tempData.getTemp_CSV出力();
        this.印刷済対象者 = tempData.getTemp_印刷済対象者();
        this.発行履歴 = tempData.getTemp_発行履歴();
        this.督促方法 = tempData.getTemp_督促方法();
        this.督促メモ = tempData.getTemp_督促メモ();
        this.督促日 = tempData.getTemp_督促日();
        this.印刷期間開始日 = tempData.getTemp_印刷期間開始日();
        this.印刷期間終了日 = tempData.getTemp_印刷期間終了日();
        this.出力順 = tempData.getTemp_出力順();
        this.集計 = tempData.getTemp_集計();
        this.改頁 = tempData.getTemp_改頁();
        return parameter;
    }
}
