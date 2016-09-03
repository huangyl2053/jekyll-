/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd206010;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 社福減免対象者Entityです。
 *
 * @reamsid_L DBD-3810-030 liuwei2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShafukugemmenTaishoshaJohoEntity {

    private RString 事業所番号;
    private RString 事業者名称;
    private RString 郵便番号;
    private AtenaJusho 事業者住所;
    private TelNo 電話番号;
    private HihokenshaNo 被保険者番号;
    private Code 要介護認定状態区分コード;
    private RString 確認番号;
    private FlexibleDate 適用開始年月日;
    private FlexibleDate 適用終了年月日;
    private boolean 居宅サービス限定;
    private boolean 居住費食費のみ;
    private boolean 旧措置者ユニット型個室のみ;
    private ShoKisaiHokenshaNo 証記載保険者番号;

    private RString 住民種別コード;
    private AtenaMeisho 名称;
    private AtenaKanaMeisho カナ名称;
    private FlexibleDate 生年月日;
    private RString 性別コード;
}
