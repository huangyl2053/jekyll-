/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.karisanteiidofuka;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 特別徴収開始TempEntityです
 *
 * @reamsid_L DBB-0850-020 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetuTyoushuuKaisiTempEntity implements Serializable {

    private FlexibleYear 賦課年度;
    private HihokenshaNo 被保険者番号;
    private int 履歴番号;
    private RString 徴収方法4月;
    private RString 徴収方法5月;
    private RString 徴収方法6月;
    private RString 徴収方法7月;
    private RString 徴収方法8月;
    private RString 徴収方法9月;
    private RString 徴収方法10月;
    private RString 徴収方法11月;
    private RString 徴収方法12月;
    private RString 徴収方法1月;
    private RString 徴収方法2月;
    private RString 徴収方法3月;
    private RString 徴収方法翌4月;
    private RString 徴収方法翌5月;
    private RString 徴収方法翌6月;
    private RString 徴収方法翌7月;
    private RString 徴収方法翌8月;
    private RString 徴収方法翌9月;
    private RString 仮徴収_基礎年金番号;
    private RString 仮徴収_年金コード;
    private RString 仮徴収_捕捉月;
    private RString 本徴収_基礎年金番号;
    private RString 本徴収_年金コード;
    private RString 本徴収_捕捉月;
    private RString 翌年度仮徴収_基礎年金番号;
    private RString 翌年度仮徴収_年金コード;
    private RString 翌年度仮徴収_捕捉月;
    private boolean 依頼情報送付済みフラグ;
    private boolean 追加依頼情報送付済みフラグ;
    private YMDHMS 特別徴収停止日時;
    private RString 特別徴収停止事由コード;
    private TsuchishoNo 通知書番号;
    private RString 保険料算定段階1;
    private RString 保険料算定段階2;
    private Decimal 合計所得金額;
    private Decimal 公的年金収入額;

}
