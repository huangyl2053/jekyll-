/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyotakuservicekeikakuichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共有子Div「居宅計画」の計画依頼受付情報Entityです。
 *
 * @reamsid_L DBD-3560-080 huangh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KeikakuIraiJohoEntity {

    private RString 届出区分;
    private FlexibleDate 届出年月日;
    private RString 作成区分コード;
    private JigyoshaNo 計画事業者番号;
    private AtenaMeisho 計画事業者名;
    private YubinNo 郵便番号;
    private AtenaJusho 事業者住所;
    private AtenaMeisho 代表者名;
    private TelNo 電話番号;
    private JigyoshaNo 委託先事業者番号;
    private AtenaMeisho 委託先事業者名;
    private FlexibleDate 事業者変更年月日;
    private FlexibleDate 適用開始年月日;
    private FlexibleDate 適用終了年月日;
    private RString 事業者変更事由;
}
