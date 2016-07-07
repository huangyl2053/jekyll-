/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaiiinhoshunyuryoku;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author soft863
 */
public class ShinsakaiIinHoshuNyuryokuMapperParameter {

    private final RString 介護認定審査会委員氏名;
    private final boolean is前方一致;
    private final boolean is後方一致;
    private final boolean is完全一致;
    private final boolean is部分一致;
    private final Decimal 最大表示件数;
    private final RString コード;
    private final RDate fromDate;
    private final RDate toDate;

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
     */
    public ShinsakaiIinHoshuNyuryokuMapperParameter(RString 介護認定審査会委員氏名, boolean is前方一致,
            boolean is後方一致, boolean is完全一致, boolean is部分一致, Decimal 最大表示件数, RString コード,
            RDate fromDate, RDate toDate) {
        this.介護認定審査会委員氏名 = 介護認定審査会委員氏名;
        this.is前方一致 = is前方一致;
        this.is後方一致 = is後方一致;
        this.is完全一致 = is完全一致;
        this.is部分一致 = is部分一致;
        this.最大表示件数 = 最大表示件数;
        this.コード = コード;
        this.fromDate = fromDate;
        this.toDate = toDate;
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
     * @return ShinsakaiIinHoshuNyuryokuMapperParameter 審査会委員報酬入力結果情報を特定するためのMyBatis用パラメータクラスです
     */
    public static ShinsakaiIinHoshuNyuryokuMapperParameter createSelectListParam(RString 介護認定審査会委員氏名, boolean is前方一致,
            boolean is後方一致, boolean is完全一致, boolean is部分一致, Decimal 最大表示件数, RString コード, RDate fromDate, RDate toDate) {
        return new ShinsakaiIinHoshuNyuryokuMapperParameter(介護認定審査会委員氏名, is前方一致, is後方一致, is完全一致, is部分一致, 最大表示件数, コード, fromDate, toDate);
    }

}
