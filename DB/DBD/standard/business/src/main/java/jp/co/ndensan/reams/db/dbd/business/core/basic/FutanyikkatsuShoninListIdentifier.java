/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 一括承認結果一覧の識別子です。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class FutanyikkatsuShoninListIdentifier implements Serializable {

    private final YMDHMS ninteiBatchExecutedTimestamp;
    private final FlexibleYear sakuseiNendo;
    private final FlexibleDate ketteiYmd;
    private final boolean isTest;
    private final boolean hadApproved;

    /**
     * コンストラクタです。
     *
     * @param ninteiBatchExecutedTimestamp ninteiBatchExecutedTimestamp
     * @param sakuseiNendo sakuseiNendo
     * @param ketteiYmd ketteiYmd
     * @param isTest isTest
     * @param hadApproved hadApproved
     */
    public FutanyikkatsuShoninListIdentifier(YMDHMS ninteiBatchExecutedTimestamp,
            FlexibleYear sakuseiNendo,
            FlexibleDate ketteiYmd,
            boolean isTest,
            boolean hadApproved) {
        this.ninteiBatchExecutedTimestamp = ninteiBatchExecutedTimestamp;
        this.sakuseiNendo = sakuseiNendo;
        this.ketteiYmd = ketteiYmd;
        this.isTest = isTest;
        this.hadApproved = hadApproved;
    }
}
