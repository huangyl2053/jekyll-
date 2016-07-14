/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaiiinhoshunyuryoku;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 審査会委員報酬入力パラメタクラです。
 *
 * @reamsid_L DBE-1950-010 zhengsongling
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class ShinsakaiIinHoshuNyuryokuMapperParameter {

    private final RString 介護認定審査会委員氏名;
    private final boolean is前方一致;
    private final boolean is後方一致;
    private final boolean is完全一致;
    private final boolean is部分一致;
    private final Decimal 最大表示件数;
    private final RString コード;
    private final RDate fromDate;
    private final RDate toDate;
    private final RDate 実施日;
    private final boolean hasFromDate;
    private final boolean hasToDate;

    /**
     * コンストラクタです。
     *
     * @param 介護認定審査会委員氏名 介護認定審査会委員氏名
     * @param is前方一致 is前方一致
     * @param is完全一致 is完全一致
     * @param is後方一致 is後方一致
     * @param is部分一致 is部分一致
     * @param 最大表示件数 最大表示件数
     * @param コード コード
     * @param toDate ToDate
     * @param fromDate FromDate
     * @param 実施日 実施日
     * @param hasFromDate hasFromDate
     * @param hasToDate hasToDate
     */
    private ShinsakaiIinHoshuNyuryokuMapperParameter(
            RString 介護認定審査会委員氏名,
            boolean is前方一致,
            boolean is後方一致,
            boolean is完全一致,
            boolean is部分一致,
            Decimal 最大表示件数,
            RString コード,
            RDate fromDate,
            RDate toDate,
            RDate 実施日,
            boolean hasFromDate,
            boolean hasToDate) {
        this.介護認定審査会委員氏名 = 介護認定審査会委員氏名;
        this.is前方一致 = is前方一致;
        this.is後方一致 = is後方一致;
        this.is完全一致 = is完全一致;
        this.is部分一致 = is部分一致;
        this.最大表示件数 = 最大表示件数;
        this.コード = コード;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.実施日 = 実施日;
        this.hasFromDate = hasFromDate;
        this.hasToDate = hasToDate;
    }

    /**
     * 審査会委員一覧検索用のパラメータを生成します。
     *
     * @param 介護認定審査会委員氏名 介護認定審査会委員氏名
     * @param is前方一致 is前方一致
     * @param is後方一致 is後方一致
     * @param is完全一致 is完全一致
     * @param is部分一致 is部分一致
     * @param 最大表示件数 最大表示件数
     * @param コード コード
     * @param fromDate fromDate
     * @param toDate toDate
     * @param 実施日 実施日
     * @param hasFromDate hasFromDate
     * @param hasToDate hasToDate
     * @return ShinsakaiIinHoshuNyuryokuMapperParameter 審査会委員報酬入力結果情報を特定するためのMyBatis用パラメータクラスです
     */
    public static ShinsakaiIinHoshuNyuryokuMapperParameter createSelectListParam(
            RString 介護認定審査会委員氏名,
            boolean is前方一致,
            boolean is後方一致,
            boolean is完全一致,
            boolean is部分一致,
            Decimal 最大表示件数,
            RString コード,
            RDate fromDate,
            RDate toDate,
            RDate 実施日,
            boolean hasFromDate,
            boolean hasToDate) {
        return new ShinsakaiIinHoshuNyuryokuMapperParameter(
                介護認定審査会委員氏名,
                is前方一致,
                is後方一致,
                is完全一致,
                is部分一致,
                最大表示件数,
                コード,
                fromDate,
                toDate,
                実施日,
                hasFromDate,
                hasToDate);
    }

}
