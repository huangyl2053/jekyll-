/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.seikatsuhogotoroku;

import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * みなし2号登録RelateEntityクラスです。
 *
 * @reamsid_L DBE-1310-020 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikatsuhogoTorokuRelateEntity {

    private AtenaKanaMeisho 被保険者氏名カナ;
    private AtenaMeisho 被保険者氏名;
    private FlexibleDate 生年月日;
    private Code 性別;
    private YubinNo 郵便番号;
    private AtenaJusho 住所;
    private TelNo 電話番号;
    private ShikibetsuCode 識別コード;
    private RString 被保険者番号;
}
