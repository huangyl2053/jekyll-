/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 計算対象者ファイルEntity項目定義クラスです。
 *
 * @reamsid_L DBE-1500-020 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class KyufuJissekiTempTableEntity extends DbTableEntityBase<KakobunJissekiKihonTempTableEntity> implements IDbAccessable {
    // <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TempTableColumnOrder(1)
    private RString 交換情報識別番号;
    @TempTableColumnOrder(2)
    private RString 入力識別番号;
    @TempTableColumnOrder(3)
    private RString レコード種別コード;
    @TempTableColumnOrder(4)
    private RString 給付実績情報作成区分コード;
    @TempTableColumnOrder(5)
    private RString 証記載保険者番号;
    @TempTableColumnOrder(6)
    private HihokenshaNo 被保険者番号;
    @TempTableColumnOrder(7)
    private RString サービス提供年月;
    @TempTableColumnOrder(8)
    private RString 給付実績区分コード;
    @TempTableColumnOrder(9)
    private RString 事業所番号;
    @TempTableColumnOrder(10)
    private RString 通し番号;
    @TempTableColumnOrder(11)
    private RString 公費１負担者番号;
    @TempTableColumnOrder(12)
    private RString 公費１受給者番号;
    @TempTableColumnOrder(13)
    private RString 公費２負担者番号;
    @TempTableColumnOrder(14)
    private RString 公費２受給者番号;
    @TempTableColumnOrder(15)
    private RString 公費３負担者番号;
    @TempTableColumnOrder(16)
    private RString 公費３受給者番号;
    @TempTableColumnOrder(17)
    private RString 生年月日;
    @TempTableColumnOrder(18)
    private RString 性別コード;
    @TempTableColumnOrder(19)
    private RString 要介護状態区分コード;
    @TempTableColumnOrder(20)
    private RString 旧措置入所者特例コード;
    @TempTableColumnOrder(21)
    private RString 認定有効期間開始年月日;
    @TempTableColumnOrder(22)
    private RString 認定有功期間終了年月日;
    @TempTableColumnOrder(23)
    private RString 老人保健市町村番号;
    @TempTableColumnOrder(24)
    private RString 老人保健受給者番号;
    @TempTableColumnOrder(25)
    private RString 保険者番号後期;
    @TempTableColumnOrder(26)
    private RString 被保険者番号後期;
    @TempTableColumnOrder(27)
    private RString 保険者番号国保;
    @TempTableColumnOrder(28)
    private RString 被保険者証番号国保;
    @TempTableColumnOrder(29)
    private RString 個人番号国保;
    @TempTableColumnOrder(30)
    private RString 居宅サービス計画作成区分コード;
    @TempTableColumnOrder(31)
    private RString 事業所番号居宅介護支援事業所等;
    @TempTableColumnOrder(32)
    private RString 開始年月日;
    @TempTableColumnOrder(33)
    private RString 中止年月日;
    @TempTableColumnOrder(34)
    private RString 中止理由入所院前の状況コード;
    @TempTableColumnOrder(35)
    private RString 入所院年月日;
    @TempTableColumnOrder(36)
    private RString 退所院年月日;
    @TempTableColumnOrder(37)
    private int 入所院実日数;
    @TempTableColumnOrder(38)
    private int 外泊日数;
    @TempTableColumnOrder(39)
    private RString 退所院後の状態コード;
    @TempTableColumnOrder(40)
    private RString 保険給付率;
    @TempTableColumnOrder(41)
    private RString 公費１給付率;
    @TempTableColumnOrder(42)
    private RString 公費２給付率;
    @TempTableColumnOrder(43)
    private RString 公費３給付率;
    @TempTableColumnOrder(44)
    private int 前保険サービス単位数;
    @TempTableColumnOrder(45)
    private Decimal 前保険請求額;
    @TempTableColumnOrder(46)
    private RString 前保険利用者負担額;
    @TempTableColumnOrder(47)
    private Decimal 前保険緊急時施設療養費請求額;
    @TempTableColumnOrder(48)
    private Decimal 前保険特定診療費請求額;
    @TempTableColumnOrder(49)
    private RString 前保険特定入所者介護サービス費等請求額;
    @TempTableColumnOrder(50)
    private int 前公費１サービス単位数;
    @TempTableColumnOrder(51)
    private int 前公費１請求額;
    @TempTableColumnOrder(52)
    private int 前公費１本人負担額;
    @TempTableColumnOrder(53)
    private int 前公費１緊急時施設療養費請求額;
    @TempTableColumnOrder(54)
    private int 前公費１特定診療費請求額;
    @TempTableColumnOrder(55)
    private int 前公費１特定入所者介護サービス費等請求額;
    @TempTableColumnOrder(56)
    private int 前公費２サービス単位数;
    @TempTableColumnOrder(57)
    private int 前公費２請求額;
    @TempTableColumnOrder(58)
    private int 前公費２本人負担額;
    @TempTableColumnOrder(59)
    private int 前公費２緊急時施設療養費請求額;
    @TempTableColumnOrder(60)
    private int 前公費２特定診療費請求額;
    @TempTableColumnOrder(61)
    private int 前公費２特定入所者介護サービス費等請求額;
    @TempTableColumnOrder(62)
    private int 前公費３サービス単位数;
    @TempTableColumnOrder(63)
    private int 前公費３請求額;
    @TempTableColumnOrder(64)
    private int 前公費３本人負担額;
    @TempTableColumnOrder(65)
    private int 前公費３緊急時施設療養費請求額;
    @TempTableColumnOrder(66)
    private int 前公費３特定診療費請求額;
    @TempTableColumnOrder(67)
    private int 前公費３特定入所者介護サービス費等請求額;
    @TempTableColumnOrder(68)
    private int 後保険サービス単位数;
    @TempTableColumnOrder(69)
    private Decimal 後保険請求額;
    @TempTableColumnOrder(70)
    private int 後保険利用者負担額;
    @TempTableColumnOrder(71)
    private Decimal 後緊急時施設療養費請求額;
    @TempTableColumnOrder(72)
    private Decimal 後保険特定診療費請求額;
    @TempTableColumnOrder(73)
    private int 後保険特定入所者介護サービス費等請求額;
    @TempTableColumnOrder(74)
    private int 後公費１サービス単位数;
    @TempTableColumnOrder(75)
    private int 後公費１請求額;
    @TempTableColumnOrder(76)
    private int 後公費１本人負担額;
    @TempTableColumnOrder(77)
    private int 後公費１緊急時施設療養費請求額;
    @TempTableColumnOrder(78)
    private int 後公費１特定診療費請求額;
    @TempTableColumnOrder(79)
    private int 後公費１特定入所者介護サービス費等請求額;
    @TempTableColumnOrder(80)
    private int 後公費２サービス単位数;
    @TempTableColumnOrder(81)
    private int 後公費２請求額;
    @TempTableColumnOrder(82)
    private int 後公費２利用者負担額;
    @TempTableColumnOrder(83)
    private int 後公費２緊急時施設療養費請求額;
    @TempTableColumnOrder(84)
    private int 後公費２特定診療費請求額;
    @TempTableColumnOrder(85)
    private int 後公費２特定入所者介護サービス費等請求額;
    @TempTableColumnOrder(86)
    private int 後公費３サービス単位数;
    @TempTableColumnOrder(87)
    private int 後公費３請求額;
    @TempTableColumnOrder(88)
    private int 後公費３利用者負担額;
    @TempTableColumnOrder(89)
    private int 後公費３緊急時施設療養費請求額;
    @TempTableColumnOrder(90)
    private int 後公費３特定診療費請求額;
    @TempTableColumnOrder(91)
    private int 後公費３特定入所者介護サービス費等請求額;
    @TempTableColumnOrder(92)
    private RString 警告区分コード;
    @TempTableColumnOrder(93)
    private RString 審査年月;
    @TempTableColumnOrder(94)
    private RString 整理番号;
    @TempTableColumnOrder(95)
    private RString 送付年月;
    @TempTableColumnOrder(96)
    private RString 取込年月;
    @TempTableColumnOrder(97)
    private RString 独自作成区分;
    @TempTableColumnOrder(98)
    private boolean 保険者保有給付実績情報削除済フラグ;

}
