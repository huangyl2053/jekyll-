/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請情報IFEntity。
 *
 * @reamsid_L DBD-1480-040 liuyl
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ModifyNinteiShinseiJohoEntity {

    private ShinseishoKanriNo 申請書管理番号;
    private Code 厚労省IF識別コード;
    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private FlexibleDate 認定申請年月日;
    private Code 認定申請区分法令コード;
    private Code 認定申請区分申請時コード;
    private Code 取下区分コード;
    private RString 被保険者区分コード;
    private FlexibleDate 生年月日;
    private int 年齢;
    private Code 性別;
    private AtenaKanaMeisho 被保険者氏名カナ;
    private AtenaMeisho 被保険者氏名;
    private YubinNo 郵便番号;
    private AtenaMeisho 住所;
    private Code 前回要介護状態区分コード;
    private FlexibleDate 前回認定有効期間開始;
    private FlexibleDate 前回認定有効期間終了;
    private RString 主治医医療機関コード;
    private RString 主治医コード;
    private Code に号特定疾病コード;
    private JigyoshaNo 入所施設コード;
    private ChosaItakusakiCode 認定調査委託先コード;
    private Code 申請届出代行区分コード;
    private RString 申請届出者氏名;
    private RString 申請届出者氏名カナ;
    private YubinNo 申請届出者郵便番号;
    private RString 申請届出者住所;
    private TelNo 申請届出者電話番号;
    private Code 申請者関係コード;
    private RString 本人との関係;
    private TelNo 連絡先1;
    private TelNo 連絡先2;
    private AtenaMeisho 事業者名称;
    private AtenaJusho 事業者住所;
    private AtenaKanaMeisho 事業者名称カナ;
    private YubinNo dbT7060郵便番号;
    private TelNo 電話番号;
    private LasdecCode 市町村コード;
    private RString 一次判定内容;
}
