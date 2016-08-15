/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5120001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 要介護認定申請情報のNinteShinseiJohoEntity
 *
 * @reamsid_L DBD-1300-010 huangh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiShinseiTorokuUketsukeEntity {

    //介護認定申請基本情報入力
    private ShinseishoKanriNo 申請書管理番号;
    private Code 申請種別;
    private RString 申請書区分;
    private RString 申請状況;
    private FlexibleDate 申請日;
    private Code 認定申請区分コード_法令;
    private Code 認定申請区分コード_申請時;
    private RString 支所コード;
    private boolean 旧措置者フラグ;
    private RString 被保険者区分コード;
    private boolean 資格取得前申請フラグ;
    private Code 二号特定疾病コード;
    private RString 認定申請理由;
    private RString 申請サービス削除の理由;
    //認定申請届出者
    private Code 申請届出代行区分コード;
    private JigyoshaNo 事業者番号;
    private Code 届出者_申請者関係コード;
    private RString 申請届出者氏名;
    private RString 申請届出者氏名カナ;
    private RString 届出者_本人との関係;
    private RString 管内管外区分;
    private LasdecCode 市町村コード;
    private TelNo 申請届出者電話番号;
    private YubinNo 申請届出者郵便番号;
    private RString 申請届出者住所;
    //主治医医療機関＆主治医入力
    private RString 主治医コード;
    private RString 主治医氏名;
    private RString 主治医医療機関コード;
    private RString 医療機関名称;
    private boolean 指定医フラグ;
    //調査委託先＆調査員入力
    private ChosaItakusakiCode 認定調査委託先コード;
    private RString 事業者名称;
    private RString 認定調査員コード;
    private RString 調査員氏名;
    //認定情報
    private Code 要介護認定状態区分コード;
    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 認定有効期間終了年月日;
    private FlexibleDate 認定年月日;
    private RString 介護認定審査会意見;
//前回認定結果
    private Code 前回要介護状態区分コード;
    private FlexibleDate 前回認定年月日;
    private FlexibleDate 前回認定有効期間_開始;
    private FlexibleDate 前回認定有効期間_終了;
//申請その他情報
    private Code 異動事由;
    private Code 削除事由コード;
    private RString 理由;
    private FlexibleDate 喪失年月日;
    private FlexibleDate 取下年月日;
    private FlexibleDate 当初認定有効開始年月日;
    private FlexibleDate 当初認定有効終了年月日;
    private FlexibleDate 受給資格証明書発行年月日１;
    private FlexibleDate 受給資格証明書発行年月日２;
    //延期タブ表示用の情報
    private FlexibleDate 延期決定年月日;
    private FlexibleDate 延期見込期間開始年月日;
    private FlexibleDate 延期見込期間終了年月日;
    private RString 延期理由;
    private FlexibleDate 延期通知発行年月日;
    private Decimal 延期通知発行回数;

}
