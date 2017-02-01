/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinseitoroku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査依頼受付／みなし２号審査受付RelateEntityクラスです。
 *
 * @reamsid_L DBE-1310-010 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiShinseiTorokuRelateEntity {

    private ShinseishoKanriNo 申請書管理番号;
//    private Code 申請種別;
    private RString 申請書区分;
//    private RString 申請状況;
    private FlexibleDate 申請日;
    private Code 認定申請区分法令コード;
    private Code 認定申請区分申請時コード;
//    private RString 支所コード;
//    private boolean 旧措置者フラグ;
    private RString 被保険者区分コード;
//    private boolean 資格取得前申請フラグ;
    private Code 二号特定疾病コード;
    private RString 認定申請理由;
    private RString 申請サービス削除の理由;
    private RString 主治医コード;
    private RString 主治医氏名;
    private RString 主治医医療機関コード;
    private RString 医療機関名称;
    private boolean 指定医フラグ;
    private RString 認定調査委託先コード;
    private RString 事業者名称;
    private RString 認定調査員コード;
    private RString 調査員氏名;
    private boolean 家庭訪問の有無;
    private AtenaMeisho 訪問調査先名称;
    private YubinNo 訪問調査先郵便番号;
    private AtenaJusho 訪問調査先住所;
    private TelNo 訪問調査先電話番号;
    private Code 前回要介護状態区分コード;
    private FlexibleDate 前回認定年月日;
    private FlexibleDate 前回認定有効期間開始;
    private FlexibleDate 前回認定有効期間終了;
//    private Code 異動事由;
//    private Code 削除事由コード;
//    private RString 理由;
//    private FlexibleDate 喪失年月日;
    private FlexibleDate 取下年月日;
//    private FlexibleDate 当初認定有効開始年月日;
//    private FlexibleDate 当初認定有効終了年月日;
//    private FlexibleDate 受給資格証明書発行年月日１;
//    private FlexibleDate 受給資格証明書発行年月日２;
//    private RString 台帳種別;
//    private RString 入所施設種類;
    private JigyoshaNo 入所施設コード;
//    private FlexibleDate 認定有効期間開始年月日;
//    private FlexibleDate 認定有効期間終了年月日;
//    private FlexibleDate 認定年月日;
//    private RString 介護認定審査会意見;
    private RString 市町村連絡事項;
    private RString 主治医への連絡事項;
    private RString 調査員への連絡事項;
    private ShikibetsuCode 識別コード;
    private LasdecCode 市町村コード;
    private Code 申請届出代行区分コード;
    private RString 申請届出者氏名;
    private RString 申請届出者氏名カナ;
    private RString 申請届出者続柄;
    private JigyoshaNo 申請届出代行事業者番号;
    private RString 事業者区分;
    private YubinNo 申請届出者郵便番号;
    private RString 申請届出者住所;
    private TelNo 申請届出者電話番号;
    private Code 取下区分コード;
    private RString 取下理由;
    private FlexibleDate 延期決定年月日;
    private RString 延期理由;
    private FlexibleDate  延期通知発行年月日;
    private int 延期通知発行回数;
    private FlexibleDate  延期見込期間開始年月日;
    private FlexibleDate  延期見込期間終了年月日;
    private AtenaMeisho 被保険者氏名;
    private AtenaKanaMeisho 被保険者氏名カナ;
    private YubinNo 郵便番号;
    private AtenaJusho 住所;
    private TelNo 電話番号;
    private FlexibleDate 生年月日;
    private int 年齢;
    private Code 性別;
    private Code 介護認定審査会優先振分区分コード;
    private Code 自動割当除外者区分;
    private boolean みなし２号等対象フラグ;
    private boolean 情報提供フラグ;
    private boolean 認定延期通知発行しないことに対する同意有無フラグ;
    private FlexibleDate  IF送付年月日;
    private FlexibleDate  センター送信年月日;
    private FlexibleDate  認定調査依頼完了年月日;
    private FlexibleDate  主治医意見書作成依頼完了年月日;
    private FlexibleDate  認定申請情報登録完了年月日;
    private FlexibleDate  認定審査会割当完了年月日;
    private FlexibleDate  介護認定審査会割当年月日;
    private Code  判定結果コード;
}
