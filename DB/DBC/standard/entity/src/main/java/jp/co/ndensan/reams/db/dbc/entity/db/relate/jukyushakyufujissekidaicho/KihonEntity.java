/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 受給者給付実績台帳の基本Entityクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
@OnNextSchema("rgdb")
public class KihonEntity extends DbTableEntityBase<KihonEntity> implements IDbAccessable {

    /**
     * TableNameを設定です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("tempKihon"));
    }

    @TempTableColumnOrder(1)
    private RString 入力識別番号;
    @TempTableColumnOrder(2)
    private RString 被保険者番号;
    @TempTableColumnOrder(3)
    private RString サービス提供年月;
    @TempTableColumnOrder(4)
    private RString 給付実績区分コード;
    @TempTableColumnOrder(5)
    private RString 事業所番号;
    @TempTableColumnOrder(6)
    private RString 通し番号;
    @TempTableColumnOrder(7)
    private RString 生年月日;
    @TempTableColumnOrder(8)
    private RString 性別コード;
    @TempTableColumnOrder(9)
    private RString 要介護度;
    @TempTableColumnOrder(10)
    private RString 認定有効期間;
    @TempTableColumnOrder(11)
    private RString 証記載保険者番号;
    @TempTableColumnOrder(12)
    private RString 老人保険市町村番号;
    @TempTableColumnOrder(13)
    private RString 老人保険受給者番号;
    @TempTableColumnOrder(14)
    private RString 旧措置入所者特例コード;
    @TempTableColumnOrder(15)
    private RString 警告区分コード;
    @TempTableColumnOrder(16)
    private RString 審査年月;
    @TempTableColumnOrder(17)
    private RString 保険者番号後期;
    @TempTableColumnOrder(18)
    private RString 被保険者番号後期;
    @TempTableColumnOrder(19)
    private RString 保険者番号国保;
    @TempTableColumnOrder(20)
    private RString 被保険者証番号国保;
    @TempTableColumnOrder(21)
    private RString 個人番号国保;
    @TempTableColumnOrder(22)
    private RString 整理番号;
    @TempTableColumnOrder(23)
    private RString 居住サービス計画作成区分コード;
    @TempTableColumnOrder(24)
    private RString 居住サービス計画作成区分名１;
    @TempTableColumnOrder(25)
    private RString 居住サービス計画作成区分名２;
    @TempTableColumnOrder(26)
    private RString 居住サービス計画事業者番号;
    @TempTableColumnOrder(27)
    private RString 居住サービス計画事業者名１;
    @TempTableColumnOrder(28)
    private RString 居住サービス計画事業者名２;
    @TempTableColumnOrder(29)
    private RString 入所院期間;
    @TempTableColumnOrder(30)
    private RString 入所院実日数;
    @TempTableColumnOrder(31)
    private RString 外泊日数;
    @TempTableColumnOrder(32)
    private RString 出力様式;
    @TempTableColumnOrder(33)
    private RString 出力様式１;
    @TempTableColumnOrder(34)
    private RString 出力様式２;
    @TempTableColumnOrder(35)
    private RString サービス事業者番号;
    @TempTableColumnOrder(36)
    private RString サービス事業者名;
    @TempTableColumnOrder(37)
    private RString 退所院の状態;
    @TempTableColumnOrder(38)
    private RString サービス期間;
    @TempTableColumnOrder(39)
    private RString 中止理由タイトル;
    @TempTableColumnOrder(40)
    private RString 中止理由コード;
    @TempTableColumnOrder(41)
    private RString 保険給付率;
    @TempTableColumnOrder(42)
    private RString 前サービス単位数;
    @TempTableColumnOrder(43)
    private RString 後サービス単位数;
    @TempTableColumnOrder(44)
    private RString 前保険請求額;
    @TempTableColumnOrder(45)
    private RString 後保険請求額;
    @TempTableColumnOrder(46)
    private RString 前利用者負担額;
    @TempTableColumnOrder(47)
    private RString 後利用者負担額;
    @TempTableColumnOrder(48)
    private RString 前緊急時施設療養費請求額;
    @TempTableColumnOrder(49)
    private RString 後緊急時施設療養費請求額;
    @TempTableColumnOrder(50)
    private RString 基本ヘッダー１;
    @TempTableColumnOrder(51)
    private RString 基本ヘッダー２;
    @TempTableColumnOrder(52)
    private RString 前特定診療費請求額;
    @TempTableColumnOrder(53)
    private RString 後特定診療費請求額;
    @TempTableColumnOrder(54)
    private RString 基本ヘッダー3;
    @TempTableColumnOrder(55)
    private RString 基本ヘッダー４;
    @TempTableColumnOrder(56)
    private RString 前特定入所者介護サービス等等請求額;
    @TempTableColumnOrder(57)
    private RString 後特定入所者介護サービス等等請求額;
    @TempTableColumnOrder(58)
    private RString 公費１負担者番号;
    @TempTableColumnOrder(59)
    private RString 公費１受給者番号;
    @TempTableColumnOrder(60)
    private RString 公費１給付率;
    @TempTableColumnOrder(61)
    private RString 前公費１サービス単位数;
    @TempTableColumnOrder(62)
    private RString 後公費１サービス単位数;
    @TempTableColumnOrder(63)
    private RString 前公費１保険請求額;
    @TempTableColumnOrder(64)
    private RString 後公費１保険請求額;
    @TempTableColumnOrder(65)
    private RString 前公費１利用者負担額;
    @TempTableColumnOrder(66)
    private RString 後公費１利用者負担額;
    @TempTableColumnOrder(67)
    private RString 前公費１緊急時施設療養費請求額;
    @TempTableColumnOrder(68)
    private RString 後公費１緊急時施設療養費請求額;
    @TempTableColumnOrder(69)
    private RString 前公費１特定診療費請求額;
    @TempTableColumnOrder(70)
    private RString 後公費１特定診療費請求額;
    @TempTableColumnOrder(71)
    private RString 前公費１特定入所者介護サービス費等請求額;
    @TempTableColumnOrder(72)
    private RString 後公費１特定入所者介護サービス費等請求額;
    @TempTableColumnOrder(73)
    private RString 公費２負担者番号;
    @TempTableColumnOrder(74)
    private RString 公費２受給者番号;
    @TempTableColumnOrder(75)
    private RString 公費２給付率;
    @TempTableColumnOrder(76)
    private RString 前公費２サービス単位数;
    @TempTableColumnOrder(77)
    private RString 後公費２サービス単位数;
    @TempTableColumnOrder(78)
    private RString 前公費２保険請求額;
    @TempTableColumnOrder(79)
    private RString 後公費２保険請求額;
    @TempTableColumnOrder(80)
    private RString 前公費２利用者負担額;
    @TempTableColumnOrder(81)
    private RString 後公費２利用者負担額;
    @TempTableColumnOrder(82)
    private RString 前公費２緊急時施設療養費請求額;
    @TempTableColumnOrder(83)
    private RString 後公費２緊急時施設療養費請求額;
    @TempTableColumnOrder(84)
    private RString 前公費２特定診療費請求額;
    @TempTableColumnOrder(85)
    private RString 後公費２特定診療費請求額;
    @TempTableColumnOrder(86)
    private RString 前公費２特定入所者介護サービス費等請求額;
    @TempTableColumnOrder(87)
    private RString 後公費２特定入所者介護サービス費等請求額;
    @TempTableColumnOrder(88)
    private RString 公費３負担者番号;
    @TempTableColumnOrder(89)
    private RString 公費３受給者番号;
    @TempTableColumnOrder(90)
    private RString 公費３給付率;
    @TempTableColumnOrder(91)
    private RString 前公費３サービス単位数;
    @TempTableColumnOrder(92)
    private RString 後公費３サービス単位数;
    @TempTableColumnOrder(93)
    private RString 前公費３保険請求額;
    @TempTableColumnOrder(94)
    private RString 後公費３保険請求額;
    @TempTableColumnOrder(95)
    private RString 前公費３利用者負担額;
    @TempTableColumnOrder(96)
    private RString 後公費３利用者負担額;
    @TempTableColumnOrder(97)
    private RString 前公費３緊急時施設療養費請求額;
    @TempTableColumnOrder(98)
    private RString 後公費３緊急時施設療養費請求額;
    @TempTableColumnOrder(99)
    private RString 前公費３特定診療費請求額;
    @TempTableColumnOrder(100)
    private RString 後公費３特定診療費請求額;
    @TempTableColumnOrder(101)
    private RString 前公費３特定入所者介護サービス費等請求額;
    @TempTableColumnOrder(102)
    private RString 後公費３特定入所者介護サービス費等請求額;
    @TempTableColumnOrder(103)
    private RString 被保険者氏名カナ;
    @TempTableColumnOrder(104)
    private RString 被保険者氏名;
    @TempTableColumnOrder(105)
    private RString 世帯コード;
    @TempTableColumnOrder(106)
    private RString 住所コード;
    @TempTableColumnOrder(107)
    private RString 住所;
    @TempTableColumnOrder(108)
    private RString 行政区コード;
    @TempTableColumnOrder(109)
    private RString 行政区;
    @TempTableColumnOrder(110)
    private RString 住民コード;
    @TempTableColumnOrder(111)
    private RString 高額受付年月日;
    @TempTableColumnOrder(112)
    private RString 高額決定年月日;
    @TempTableColumnOrder(113)
    private RString 高額公費１負担番号;
    @TempTableColumnOrder(114)
    private RString 高額公費２負担番号;
    @TempTableColumnOrder(115)
    private RString 高額公費３負担番号;
    @TempTableColumnOrder(116)
    private RString 高額利用者負担額;
    @TempTableColumnOrder(117)
    private RString 高額公費１負担額;
    @TempTableColumnOrder(118)
    private RString 高額公費２負担額;
    @TempTableColumnOrder(119)
    private RString 高額公費３負担額;
    @TempTableColumnOrder(120)
    private RString 高額支給額;
    @TempTableColumnOrder(121)
    private RString 高額公費１支給額;
    @TempTableColumnOrder(122)
    private RString 高額公費２支給額;
    @TempTableColumnOrder(123)
    private RString 高額公費３支給額;
    @TempTableColumnOrder(124)
    private RString 区分;
    @TempTableColumnOrder(125)
    private RString 市町村コード;

}
