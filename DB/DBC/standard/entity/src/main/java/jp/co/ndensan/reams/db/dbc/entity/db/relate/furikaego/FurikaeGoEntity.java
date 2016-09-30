/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.furikaego;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業合算・事業分振込明細書作成（一括）Entity
 *
 * @reamsid_L DBC-4870-030 lijian
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FurikaeGoEntity {

    private RString 帳票タイトル;
    private FlexibleDate 依頼日;
    private FlexibleDate 振込指定日;
    private int 枚中;
    private RString 枚目;
    private RString 依頼文言１;
    private RString 依頼文言２;
    private RString 依頼人1;
    private RString 依頼人2;
    private RString 様;
    private Decimal 振込口数;
    private Decimal 振込金額;
    private RString 通知文言;
    private RString 指定金融機関名称1;
    private RString 指定金融機関名称2;
    private RString 御中;
    private KinyuKikanCode 金融機関コード;
    private RString 預金種目コード;
    private RString 受取人カナ;
    private RString 摘要;
    private RString 金融機関名;
    private RString 預金種目;
    private RString 口座番号;
    private RString 受取人氏名;
    private HihokenshaNo 被保険者番号;
    private Decimal 金額;
    private RString 摘要2;
    private Decimal 銀行計口数;
    private Decimal 銀行計金額;
    private Decimal 支店計口数;
    private Decimal 支店計金額;
    private Decimal 頁計口数;
    private Decimal 頁計金額;

}
