/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.dbe233001;

import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shujiiikentokusokujohakko.ShujiiIkenTokusokujoHakkoTempData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;

/**
 * 主治医意見書督促状発行のバッチパラメータクラスです。
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class Dbe233001FlowParameter {

    private final RString temp_保険者コード;
    private final RString temp_保険者名称;
    private final RString temp_主治医医療機関コード;
    private final RString temp_主治医コード;
    private final FlexibleDate temp_基準日;
    private final Decimal temp_主治医意見書督促期限日数;
    private final RString temp_主治医意見書督促状;
    private final RString temp_主治医意見書督促対象者一覧表;
    private final RString temp_CSV出力;
    private final RString temp_印刷済対象者;
    private final RString temp_発行履歴;
    private final int temp_督促方法;
    private final RString temp_督促メモ;
    private final FlexibleDate temp_督促日;
    private final RDate temp_印刷期間開始日;
    private final RDate temp_印刷期間終了日;
    private final RString temp_出力順;
    private final RString temp_集計;
    private final RString temp_改頁;
    private final RString temp_印刷書類区分;
    private final RString temp_最大履歴番号;

    private Dbe233001FlowParameter(RString temp_保険者コード, RString temp_保険者名称, RString temp_主治医医療機関コード,
            RString temp_主治医コード, FlexibleDate temp_基準日, Decimal temp_主治医意見書督促期限日数, RString temp_主治医意見書督促状,
            RString temp_主治医意見書督促対象者一覧表, RString temp_CSV出力, RString temp_印刷済対象者, RString temp_発行履歴,
            int temp_督促方法, RString temp_督促メモ, FlexibleDate temp_督促日, RDate temp_印刷期間開始日, RDate temp_印刷期間終了日,
            RString temp_出力順, RString temp_集計, RString temp_改頁, RString temp_印刷書類区分, RString temp_最大履歴番号) {
        this.temp_保険者コード = temp_保険者コード;
        this.temp_保険者名称 = temp_保険者名称;
        this.temp_主治医医療機関コード = temp_主治医医療機関コード;
        this.temp_主治医コード = temp_主治医コード;
        this.temp_基準日 = temp_基準日;
        this.temp_主治医意見書督促期限日数 = temp_主治医意見書督促期限日数;
        this.temp_主治医意見書督促状 = temp_主治医意見書督促状;
        this.temp_主治医意見書督促対象者一覧表 = temp_主治医意見書督促対象者一覧表;
        this.temp_CSV出力 = temp_CSV出力;
        this.temp_印刷済対象者 = temp_印刷済対象者;
        this.temp_発行履歴 = temp_発行履歴;
        this.temp_督促方法 = temp_督促方法;
        this.temp_督促メモ = temp_督促メモ;
        this.temp_督促日 = temp_督促日;
        this.temp_印刷期間開始日 = temp_印刷期間開始日;
        this.temp_印刷期間終了日 = temp_印刷期間終了日;
        this.temp_出力順 = temp_出力順;
        this.temp_集計 = temp_集計;
        this.temp_改頁 = temp_改頁;
        this.temp_印刷書類区分 = temp_印刷書類区分;
        this.temp_最大履歴番号 = temp_最大履歴番号;
    }

    /**
     * 画面からのパラメータを作成します。
     *
     * @param tempData 画面データ
     * @return 主治医意見書督促状発行パラメータ
     */
    public static Dbe233001FlowParameter toDBE223001Parameter(ShujiiIkenTokusokujoHakkoTempData tempData) {

        return new Dbe233001FlowParameter(tempData.getTemp_保険者コード(), tempData.getTemp_保険者名称(), tempData.getTemp_主治医医療機関コード(),
                tempData.getTemp_主治医コード(), tempData.getTemp_基準日(), tempData.getTemp_主治医意見書督促期限日数(),
                tempData.getTemp_主治医意見書督促状(), tempData.getTemp_主治医意見書督促対象者一覧表(), tempData.getTemp_CSV出力(),
                tempData.getTemp_印刷済対象者(), tempData.getTemp_発行履歴(), tempData.getTemp_督促方法(), tempData.getTemp_督促メモ(),
                tempData.getTemp_督促日(), tempData.getTemp_印刷期間開始日(), tempData.getTemp_印刷期間終了日(), tempData.getTemp_出力順(),
                tempData.getTemp_集計(), tempData.getTemp_改頁(), tempData.getTemp_印刷書類区分(), tempData.getTemp_最大履歴番号());
    }
}
