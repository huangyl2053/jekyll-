/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shujiiikentokusokujo;

import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shujiiikentokusokujohakko.ShujiiIkenTokusokujoHakkoTempData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書を特定するためのMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class ShujiiIkenTokusokujoParameter {

    private final FlexibleDate 基準日;
    private final RString 印刷済対象者;
    private final RString 保険者コード;
    private final RString 主治医医療機関コード;
    private final RString 主治医コード;
    private final RString 印刷期間開始日;
    private final RString 印刷期間終了日;
    private final boolean uses印刷済対象者;
    private final boolean uses保険者コード;
    private final boolean uses主治医医療機関コード;
    private final boolean uses主治医コード;
    private final boolean uses印刷期間;
    private final boolean uses印刷期間From;
    private final boolean uses印刷期間To;

    private ShujiiIkenTokusokujoParameter(
            FlexibleDate 基準日,
            RString 印刷済対象者,
            RString 保険者コード,
            RString 主治医医療機関コード,
            RString 主治医コード,
            RString 印刷期間開始日,
            RString 印刷期間終了日,
            boolean uses印刷済対象者,
            boolean uses保険者コード,
            boolean uses主治医医療機関コード,
            boolean uses主治医コード,
            boolean uses印刷期間,
            boolean uses印刷期間From,
            boolean uses印刷期間To) {
        this.基準日 = 基準日;
        this.印刷済対象者 = 印刷済対象者;
        this.保険者コード = 保険者コード;
        this.主治医医療機関コード = 主治医医療機関コード;
        this.主治医コード = 主治医コード;
        this.印刷期間開始日 = 印刷期間開始日;
        this.印刷期間終了日 = 印刷期間終了日;
        this.uses印刷済対象者 = uses印刷済対象者;
        this.uses保険者コード = uses保険者コード;
        this.uses主治医医療機関コード = uses主治医医療機関コード;
        this.uses主治医コード = uses主治医コード;
        this.uses印刷期間 = uses印刷期間;
        this.uses印刷期間From = uses印刷期間From;
        this.uses印刷期間To = uses印刷期間To;
    }

    /**
     * 検索用のパラメータを生成します。
     *
     * @param tempData ShujiiIkenTokusokujoHakkoTempDataのTempData
     * @return 主治医意見書督促状発行パラメータ
     */
    public static ShujiiIkenTokusokujoParameter createParam督促状件数(ShujiiIkenTokusokujoHakkoTempData tempData) {
        boolean uses印刷済対象者 = false;
        boolean uses保険者コード = false;
        boolean uses主治医医療機関コード = false;
        boolean uses主治医コード = false;
        FlexibleDate 基準日 = tempData.getTemp_基準日().minusDay(tempData.getTemp_主治医意見書督促期限日数().intValue());
        if (tempData.getTemp_印刷済対象者().equals(new RString("1"))) {
            uses印刷済対象者 = true;
        }
        if (tempData.getTemp_保険者コード() != null && !tempData.getTemp_保険者コード().isEmpty()) {
            uses保険者コード = true;
        }
        if (tempData.getTemp_主治医医療機関コード() != null && !tempData.getTemp_主治医医療機関コード().isEmpty()) {
            uses主治医医療機関コード = true;
        }
        if (tempData.getTemp_主治医コード() != null && !tempData.getTemp_主治医コード().isEmpty()) {
            uses主治医コード = true;
        }
        return new ShujiiIkenTokusokujoParameter(
                基準日, tempData.getTemp_印刷済対象者(), tempData.getTemp_保険者コード(), tempData.getTemp_主治医医療機関コード(),
                tempData.getTemp_主治医コード(), RString.EMPTY, RString.EMPTY, uses印刷済対象者, uses保険者コード,
                uses主治医医療機関コード, uses主治医コード, false, false, false);
    }

    /**
     * 検索用のパラメータを生成します。
     *
     * @param tempData ShujiiIkenTokusokujoHakkoTempDataのTempData
     * @return 主治医意見書督促状発行パラメータ
     */
    public static ShujiiIkenTokusokujoParameter createParam督促状対象者件数(ShujiiIkenTokusokujoHakkoTempData tempData) {
        boolean uses印刷期間 = false;
        boolean uses印刷期間From = false;
        boolean uses印刷期間To = false;
        boolean uses保険者コード = false;
        boolean uses主治医医療機関コード = false;
        boolean uses主治医コード = false;
        if (tempData.getTemp_印刷期間開始日() != null && tempData.getTemp_印刷期間終了日() != null) {
            uses印刷期間 = true;
        }
        if (tempData.getTemp_印刷期間開始日() != null && tempData.getTemp_印刷期間終了日() == null) {
            uses印刷期間From = true;
        }
        if (tempData.getTemp_印刷期間終了日() != null && tempData.getTemp_印刷期間開始日() == null) {
            uses印刷期間To = true;
        }
        if (tempData.getTemp_保険者コード() != null && !tempData.getTemp_保険者コード().isEmpty()) {
            uses保険者コード = true;
        }
        if (tempData.getTemp_主治医医療機関コード() != null && !tempData.getTemp_主治医医療機関コード().isEmpty()) {
            uses主治医医療機関コード = true;
        }
        if (tempData.getTemp_主治医コード() != null && !tempData.getTemp_主治医コード().isEmpty()) {
            uses主治医コード = true;
        }
        return new ShujiiIkenTokusokujoParameter(
                FlexibleDate.EMPTY, RString.EMPTY, tempData.getTemp_保険者コード(), tempData.getTemp_主治医医療機関コード(),
                tempData.getTemp_主治医コード(), tempData.getTemp_印刷期間開始日() == null ? RString.EMPTY : tempData.getTemp_印刷期間開始日()
                .toDateString(), tempData.getTemp_印刷期間終了日() == null ? RString.EMPTY : tempData.getTemp_印刷期間終了日().toDateString(),
                false, uses保険者コード, uses主治医医療機関コード, uses主治医コード, uses印刷期間, uses印刷期間From, uses印刷期間To);
    }
}
