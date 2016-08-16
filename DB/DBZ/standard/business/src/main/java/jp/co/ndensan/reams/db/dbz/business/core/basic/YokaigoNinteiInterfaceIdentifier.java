/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定インターフェース情報の識別子です。
 *
 * @reamsid_L DBD-9999-013 chenxin
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class YokaigoNinteiInterfaceIdentifier implements Serializable {

    private final ShinseishoKanriNo 申請書管理番号;
    private final HihokenshaNo 被保険者番号;
    private final YMDHMS 取込日時;
    private final RString 申請種別コード;
    private final RString 取下区分コード;
    private final FlexibleDate 認定申請日;
    private final FlexibleDate 一次判定日;
    private final RString 一次判定結果;
    private final FlexibleDate 二次判定日;
    private final RString 二次判定結果;
    private final FlexibleDate 認定有効開始年月日;
    private final FlexibleDate 認定有効終了年月日;
    private final RString 予備区分４;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 被保険者番号 被保険者番号
     * @param 取込日時 取込日時
     * @param 申請種別コード 申請種別コード
     * @param 取下区分コード 取下区分コード
     * @param 認定申請日 認定申請日
     * @param 一次判定日 一次判定日
     * @param 一次判定結果 一次判定結果
     * @param 二次判定日 二次判定日
     * @param 二次判定結果 二次判定結果
     * @param 認定有効開始年月日 認定有効開始年月日
     * @param 認定有効終了年月日 認定有効終了年月日
     * @param 予備区分４ 申請区分（法令）コード 予備区分４ 申請区分（法令）コード
     */
    public YokaigoNinteiInterfaceIdentifier(ShinseishoKanriNo 申請書管理番号,
            HihokenshaNo 被保険者番号,
            YMDHMS 取込日時,
            RString 申請種別コード,
            RString 取下区分コード,
            FlexibleDate 認定申請日,
            FlexibleDate 一次判定日,
            RString 一次判定結果,
            FlexibleDate 二次判定日,
            RString 二次判定結果,
            FlexibleDate 認定有効開始年月日,
            FlexibleDate 認定有効終了年月日,
            RString 予備区分４) {
        this.申請書管理番号 = 申請書管理番号;
        this.被保険者番号 = 被保険者番号;
        this.取込日時 = 取込日時;
        this.申請種別コード = 申請種別コード;
        this.取下区分コード = 取下区分コード;
        this.認定申請日 = 認定申請日;
        this.一次判定日 = 一次判定日;
        this.一次判定結果 = 一次判定結果;
        this.二次判定日 = 二次判定日;
        this.二次判定結果 = 二次判定結果;
        this.認定有効開始年月日 = 認定有効開始年月日;
        this.認定有効終了年月日 = 認定有効終了年月日;
        this.予備区分４ = 予備区分４;
    }
}
