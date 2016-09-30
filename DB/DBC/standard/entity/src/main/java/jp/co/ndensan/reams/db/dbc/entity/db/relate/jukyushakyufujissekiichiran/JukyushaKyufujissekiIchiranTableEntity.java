/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekiichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 受給者給付実績一覧表 のEntityクラスです。
 *
 * @reamsid_L DBC-3070-030 dangjingjing
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class JukyushaKyufujissekiIchiranTableEntity extends DbTableEntityBase<JukyushaKyufujissekiIchiranTableEntity> implements IDbAccessable {

    private static final long serialVersionUID = 1L;
    @TempTableColumnOrder(1)
    private RString 入力識別番号;
    @TempTableColumnOrder(2)
    private RString 証記載保険者番号;
    @TempTableColumnOrder(3)
    private RString 被保険者番号;
    @TempTableColumnOrder(4)
    private RString サービス提供年月;
    @TempTableColumnOrder(5)
    private RString 事業所番号;
    @TempTableColumnOrder(6)
    private RString 給付実績区分コード;
    @TempTableColumnOrder(7)
    private RString 公費1_負担者番号;
    @TempTableColumnOrder(8)
    private RString 公費1_受給者番号;
    @TempTableColumnOrder(9)
    private RString 公費2_負担者番号;
    @TempTableColumnOrder(10)
    private RString 公費2_受給者番号;
    @TempTableColumnOrder(11)
    private RString 公費3_負担者番号;
    @TempTableColumnOrder(12)
    private RString 公費3_受給者番号;
    @TempTableColumnOrder(13)
    private RString 要介護状態区分コード;
    @TempTableColumnOrder(14)
    private RString 後_保険_サービス単位数;
    @TempTableColumnOrder(15)
    private RString 後_保険_請求額;
    @TempTableColumnOrder(16)
    private RString 後_保険_利用者負担額;
    @TempTableColumnOrder(17)
    private RString 後_緊急時施設療養費請求額;
    @TempTableColumnOrder(18)
    private RString 後_保険_特定診療費請求額;
    @TempTableColumnOrder(19)
    private RString 後_保険_特定入所者介護サービス費等請求額;
    @TempTableColumnOrder(20)
    private RString 後_公費1_サービス単位数;
    @TempTableColumnOrder(21)
    private RString 後_公費1_請求額;
    @TempTableColumnOrder(22)
    private RString 後_公費1_本人負担額;
    @TempTableColumnOrder(23)
    private RString 後_公費1_緊急時施設療養費請求額;
    @TempTableColumnOrder(24)
    private RString 後_公費1_特定診療費請求額;
    @TempTableColumnOrder(25)
    private RString 後_公費1_特定入所者介護サービス費等請求額;
    @TempTableColumnOrder(26)
    private RString 後_公費2_サービス単位数;
    @TempTableColumnOrder(27)
    private RString 後_公費2_請求額;
    @TempTableColumnOrder(28)
    private RString 後_公費2_本人負担額;
    @TempTableColumnOrder(29)
    private RString 後_公費2_緊急時施設療養費請求額;
    @TempTableColumnOrder(30)
    private RString 後_公費2_特定診療費請求額;
    @TempTableColumnOrder(31)
    private RString 後_公費2_特定入所者介護サービス費等請求額;
    @TempTableColumnOrder(32)
    private RString 後_公費3_サービス単位数;
    @TempTableColumnOrder(33)
    private RString 後_公費3_請求額;
    @TempTableColumnOrder(34)
    private RString 後_公費3_本人負担額;
    @TempTableColumnOrder(35)
    private RString 後_公費3_緊急時施設療養費請求額;
    @TempTableColumnOrder(36)
    private RString 後_公費3_特定診療費請求額;
    @TempTableColumnOrder(37)
    private RString 後_公費3_特定入所者介護サービス費等請求額;
    @TempTableColumnOrder(38)
    private RString 審査年月;
    @TempTableColumnOrder(39)
    private RString 識別コード;
    @TempTableColumnOrder(40)
    private RString 市町村コード;
    @TempTableColumnOrder(41)
    private RString 被保険者氏名;
    @TempTableColumnOrder(42)
    private RString 被保険者カナ;
    @TempTableColumnOrder(43)
    private RString 住所;
    @TempTableColumnOrder(44)
    private RString 町域コード;
    @TempTableColumnOrder(45)
    private RString 行政区コード;
    @TempTableColumnOrder(46)
    private RString 世帯コード;
    @TempTableColumnOrder(47)
    private RString 事業者名称;
    @TempTableColumnOrder(48)
    private RString 要介護状態区分名称;
    @TempTableColumnOrder(49)
    private RString 給付実績区分名称;
    @TempTableColumnOrder(50)
    private RString 様式;
}
