/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBD571001_受給者台帳を取得するEntityクラスです。
 *
 * @reamsid_L DBD-1760-020 panxiaobo
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiKekkaJohoEntity {

    private LasdecCode 受給者台帳_市町村コード1;
    private HihokenshaNo 受給者台帳_被保険者番号1;
    private RString 受給者台帳_履歴番号1;
    private RString 受給者台帳_枝番1;
    private ShikibetsuCode 受給者台帳_識別コード1;
    private FlexibleDate 受給者台帳_認定年月日1;
    private Code 受給者台帳_受給申請事由1;
    private RString 受給者台帳_データ区分1;
    private RString 受給者台帳_要介護認定状態区分コード1;
    private FlexibleDate 受給者台帳_認定有効期間開始年月日1;
    private FlexibleDate 受給者台帳_認定有効期間終了年月日1;
    private Decimal 受給者台帳_支給限度単位数1;
    private FlexibleDate 受給者台帳_支給限度有効開始年月日1;
    private FlexibleDate 受給者台帳_支給限度有効終了年月日1;
    private Decimal 受給者台帳_短期入所支給限度日数1;
    private FlexibleDate 受給者台帳_短期入所支給限度開始年月日1;
    private FlexibleDate 受給者台帳_短期入所支給限度終了年月日1;
    private boolean 受給者台帳_旧措置者フラグ1;
    private FlexibleDate 受給者台帳_喪失年月日1;
    private boolean 受給者台帳_資格取得前申請フラグ1;
    private FlexibleDate 受給者台帳_受給資格証明書発行年月日１1;
    private FlexibleDate 受給者台帳_受給資格証明書発行年月日２1;
    private RString 受給者台帳_届出者申請者関係コード1;
    private RString 受給者台帳_届出者本人との関係1;
    private RString t4101_申請書管理番号1;
    private RString t4101_厚労省IF識別コード1;
    private FlexibleDate t4101_延期通知発行年月日1;
    private Decimal t4101_延期通知発行回数1;
    private boolean t4101_指定医フラグ1;
    private RString t4101_認定申請区分_申請時_コード1;
    private RString t4101_認定申請区分_法令_コード1;
    private RString t4101_訪問調査先郵便番号1;
    private RString t4101_訪問調査先住所1;
    private RString t4101_訪問調査先名称1;
    private RString t4101_訪問調査先電話番号1;
    private RString t4123_申請書管理番号;
    private FlexibleDate t4123_認定調査予定年月日;
    private FlexibleDate t4123_主治医意見書作成登録予定日;
    private RString t4003_申請書管理番号;
    private FlexibleDate t4003_認定申請日;
    private FlexibleDate t4003_調査委託年月日;
    private FlexibleDate t4003_調査終了年月日;
    private FlexibleDate t4003_意見書依頼年月日;
    private FlexibleDate t4003_意見書取寄せ年月日;
    private FlexibleDate t4003_審査会資料作成年月日;
    private FlexibleDate t4003_審査会予定年月日;
    private FlexibleDate t4003_二次判定日;
    private RString t4003_一次判定結果;
    private FlexibleDate t4003_一次判定日;
    private RString t4003_一次判定結果重み;
    private RString t4003_特定疾病コード;
    private RString t4003_調査委託先コード;
    private RString t4003_調査員コード;
    private RString t4003_医療機関コード;
    private RString t4003_主治医コード;
    private RString t4003_審査会意見;
    private FlexibleDate t4101_認定申請年月日;
    private RString x4102_申請書管理番号;
    private FlexibleDate x4102_認定調査依頼年月日;
    private FlexibleDate x4102_認定調査実施年月日;
    private FlexibleDate x4102_主治医意見書作成依頼年月日;
    private FlexibleDate x4102_主治医意見書受領年月日;
    private FlexibleDate x4102_介護認定審査会資料作成年月日;
    private FlexibleDate t4123_認定審査会予定年月日;
    private FlexibleDate x4102_二次判定年月日;
    private RString x4102_要介護認定一次判定結果コード;
    private FlexibleDate x4102_要介護認定一次判定年月日;
    private RString x4102_要介護認定一次判定結果コード認知症加算;
    private RString t4101_２号特定疾病コード;
    private RString t4101_認定調査委託先コード;
    private RString t4101_認定調査員コード;
    private RString t4101_主治医医療機関コード;
    private RString t4101_主治医コード;
    private RString x4102_介護認定審査会意見;
    private RString t4910_市町村コード;
    private RString t4910_認定調査委託先コード;
    private RString t4910_事業者名称;
    private RString t4913_市町村コード;
    private RString t4913_認定調査委託先コード;
    private RString t4913_認定調査員コード;
    private RString t4913_調査員氏名;
    private RString t4911_市町村コード;
    private RString t4911_主治医医療機関コード;
    private RString t4911_医療機関名称;
    private RString t4912_市町村コード;
    private RString t4912_主治医医療機関コード;
    private RString t4912_主治医コード;
    private RString t4912_主治医氏名;
    private RString x4120_申請書管理番号;
    private RString x4120_申請届出代行区分コード;
    private RString x4120_申請届出者氏名;
    private RString x4120_事業者名称;
    private RString x4001_市町村コード;
    private RString x4001_被保険者番号;
    private RString x4001_履歴番号;
    private RString x4001_枝番;
    private RString x4001_受給申請事由;
    private RString x4001_データ区分の1桁目;
    private int rank_number1;
}
