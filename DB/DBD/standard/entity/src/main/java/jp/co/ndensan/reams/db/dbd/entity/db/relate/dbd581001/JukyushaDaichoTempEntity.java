/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd581001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 受給者台帳一時テーブルのクラスです。
 *
 * @reamsid_L DBD-1771-020 chenxin
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class JukyushaDaichoTempEntity extends DbTableEntityBase<JukyushaDaichoTempEntity> implements IDbAccessable {

    public static final RString TABLE_NAME = new RString("受給者台帳一時テーブル");

    @TempTableColumnOrder(1)
    private LasdecCode 市町村コード;
    @TempTableColumnOrder(2)
    private HihokenshaNo 被保険者番号;
    @TempTableColumnOrder(3)
    private RString 履歴番号;
    @TempTableColumnOrder(4)
    private RString 枝番;
    @TempTableColumnOrder(5)
    private ShinseishoKanriNo 申請書管理番号;
    @TempTableColumnOrder(6)
    private RString 申請状況区分;
    @TempTableColumnOrder(7)
    private RString 支所コード;
    @TempTableColumnOrder(8)
    private boolean 直近フラグ;
    @TempTableColumnOrder(9)
    private ShikibetsuCode 識別コード;
    @TempTableColumnOrder(10)
    private Code 受給申請事由;
    @TempTableColumnOrder(11)
    private RString 申請理由;
    @TempTableColumnOrder(12)
    private Code 申請者関係コード;
    @TempTableColumnOrder(13)
    private RString 本人との関係;
    @TempTableColumnOrder(14)
    private FlexibleDate 受給申請年月日;
    @TempTableColumnOrder(15)
    private Code 二号特定疾病コード;
    @TempTableColumnOrder(16)
    private FlexibleDate 審査会依頼年月日;
    @TempTableColumnOrder(17)
    private Code 要介護認定状態区分コード;
    @TempTableColumnOrder(18)
    private FlexibleDate 認定有効期間開始年月日;
    @TempTableColumnOrder(19)
    private FlexibleDate 認定有効期間終了年月日;
    @TempTableColumnOrder(20)
    private FlexibleDate 認定年月日;
    @TempTableColumnOrder(21)
    private Code みなし要介護区分コード;
    @TempTableColumnOrder(22)
    private ServiceShuruiCode 指定サービス種類01;
    @TempTableColumnOrder(23)
    private ServiceShuruiCode 指定サービス種類02;
    @TempTableColumnOrder(24)
    private ServiceShuruiCode 指定サービス種類03;
    @TempTableColumnOrder(25)
    private ServiceShuruiCode 指定サービス種類04;
    @TempTableColumnOrder(26)
    private ServiceShuruiCode 指定サービス種類05;
    @TempTableColumnOrder(27)
    private ServiceShuruiCode 指定サービス種類06;
    @TempTableColumnOrder(28)
    private ServiceShuruiCode 指定サービス種類07;
    @TempTableColumnOrder(29)
    private ServiceShuruiCode 指定サービス種類08;
    @TempTableColumnOrder(30)
    private ServiceShuruiCode 指定サービス種類09;
    @TempTableColumnOrder(31)
    private ServiceShuruiCode 指定サービス種類10;
    @TempTableColumnOrder(32)
    private ServiceShuruiCode 指定サービス種類11;
    @TempTableColumnOrder(33)
    private ServiceShuruiCode 指定サービス種類12;
    @TempTableColumnOrder(34)
    private ServiceShuruiCode 指定サービス種類13;
    @TempTableColumnOrder(35)
    private ServiceShuruiCode 指定サービス種類14;
    @TempTableColumnOrder(36)
    private ServiceShuruiCode 指定サービス種類15;
    @TempTableColumnOrder(37)
    private ServiceShuruiCode 指定サービス種類16;
    @TempTableColumnOrder(38)
    private ServiceShuruiCode 指定サービス種類17;
    @TempTableColumnOrder(39)
    private ServiceShuruiCode 指定サービス種類18;
    @TempTableColumnOrder(40)
    private ServiceShuruiCode 指定サービス種類19;
    @TempTableColumnOrder(41)
    private ServiceShuruiCode 指定サービス種類20;
    @TempTableColumnOrder(42)
    private ServiceShuruiCode 指定サービス種類21;
    @TempTableColumnOrder(43)
    private ServiceShuruiCode 指定サービス種類22;
    @TempTableColumnOrder(44)
    private ServiceShuruiCode 指定サービス種類23;
    @TempTableColumnOrder(45)
    private ServiceShuruiCode 指定サービス種類24;
    @TempTableColumnOrder(46)
    private ServiceShuruiCode 指定サービス種類25;
    @TempTableColumnOrder(47)
    private ServiceShuruiCode 指定サービス種類26;
    @TempTableColumnOrder(48)
    private ServiceShuruiCode 指定サービス種類27;
    @TempTableColumnOrder(49)
    private ServiceShuruiCode 指定サービス種類28;
    @TempTableColumnOrder(50)
    private ServiceShuruiCode 指定サービス種類29;
    @TempTableColumnOrder(51)
    private ServiceShuruiCode 指定サービス種類30;
    @TempTableColumnOrder(52)
    private FlexibleDate 喪失年月日;
    @TempTableColumnOrder(53)
    private FlexibleDate 直近異動年月日;
    @TempTableColumnOrder(54)
    private Code 直近異動事由コード;
    @TempTableColumnOrder(55)
    private Code 有効無効区分無効;
    @TempTableColumnOrder(56)
    private Code データ区分;
    @TempTableColumnOrder(57)
    private RString 同一連番;
    @TempTableColumnOrder(58)
    private RString 異動理由職権理由;
    @TempTableColumnOrder(59)
    private Code 申請書区分;
    @TempTableColumnOrder(60)
    private Code 削除事由コード;
    @TempTableColumnOrder(61)
    private boolean 要支援者認定申請区分以外;
    @TempTableColumnOrder(62)
    private Decimal 支給限度単位数;
    @TempTableColumnOrder(63)
    private FlexibleDate 支給限度有効開始年月日;
    @TempTableColumnOrder(64)
    private FlexibleDate 支給限度有効終了年月日;
    @TempTableColumnOrder(65)
    private int 短期入所支給限度日数;
    @TempTableColumnOrder(66)
    private FlexibleDate 短期入所支給限度開始年月日;
    @TempTableColumnOrder(67)
    private FlexibleDate 短期入所支給限度終了年月日;
    @TempTableColumnOrder(68)
    private FlexibleDate 当初認定有効開始年月日;
    @TempTableColumnOrder(69)
    private FlexibleDate 当初認定有効終了年月日;
    @TempTableColumnOrder(70)
    private FlexibleDate 受給資格証明書発行年月日１;
    @TempTableColumnOrder(71)
    private FlexibleDate 受給資格証明書発行年月日２;
    @TempTableColumnOrder(72)
    private FlexibleDate 診断命令書発行年月日;
    @TempTableColumnOrder(73)
    private FlexibleDate 二号申請受理通知書発行年月日;
    @TempTableColumnOrder(74)
    private FlexibleDate 認定結果通知書発行年月日;
    @TempTableColumnOrder(75)
    private FlexibleDate 区分変更通知書発行年月日;
    @TempTableColumnOrder(76)
    private FlexibleDate サービス変更通知書発行年月日;
    @TempTableColumnOrder(77)
    private FlexibleDate 認定却下通知書発行年月日;
    @TempTableColumnOrder(78)
    private FlexibleDate 認定取消通知書発行年月日;
    @TempTableColumnOrder(79)
    private boolean 資格取得前申請フラグ;
    @TempTableColumnOrder(80)
    private boolean 旧措置者フラグ;
    @TempTableColumnOrder(81)
    private boolean 論理削除フラグ;
    @TempTableColumnOrder(82)
    private FlexibleDate 調査委託年月日;
    @TempTableColumnOrder(83)
    private FlexibleDate 調査終了年月日;
    @TempTableColumnOrder(84)
    private FlexibleDate 意見書依頼年月日;
    @TempTableColumnOrder(85)
    private FlexibleDate 意見書取寄せ年月日;
    @TempTableColumnOrder(86)
    private FlexibleDate 認定審査会割当予定年月日;
    @TempTableColumnOrder(87)
    private FlexibleDate 認定調査予定年月日;
    @TempTableColumnOrder(88)
    private FlexibleDate 主治医意見書作成依頼予定年月日;

    @TempTableColumnOrder(90)
    private RString 市町村名;
    @TempTableColumnOrder(91)
    private FlexibleDate 審査会資料作成年月日;
    @TempTableColumnOrder(92)
    private RString 審査会予定年月日;
    @TempTableColumnOrder(93)
    private FlexibleDate 資格喪失年月日;

    @TempTableColumnOrder(94)
    private RString 認定年月;
    @TempTableColumnOrder(95)
    private RString 受給申請年月;
    @TempTableColumnOrder(96)
    private RString 調査委託年月;
    @TempTableColumnOrder(97)
    private RString 調査終了年月;
    @TempTableColumnOrder(98)
    private RString 意見書依頼年月;
    @TempTableColumnOrder(99)
    private RString 意見書取寄せ年月;
    @TempTableColumnOrder(100)
    private RString 審査会依頼年月;
    @TempTableColumnOrder(101)
    private RString 認定審査会割当予定年月;
    @TempTableColumnOrder(102)
    private RString 審査会資料作成年月;
    @TempTableColumnOrder(103)
    private RString 認定調査予定年月;
    @TempTableColumnOrder(104)
    private RString 主治医意見書作成依頼予定年月;

}
