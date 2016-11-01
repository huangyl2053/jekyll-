/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakuseibatch;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * DBB-1840-040バッチ設計_DBBBT82001_特徴送付情報作成の特徴依頼TempEntityのクラスです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class TokuChoIraiTempEntity extends DbTableEntityBase<TokuChoIraiTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private RString 業務コード;
    @TempTableColumnOrder(2)
    private RString 処理年度;
    @TempTableColumnOrder(3)
    private RString 通知内容コード;
    @TempTableColumnOrder(4)
    private RString 処理対象年月;
    @TempTableColumnOrder(5)
    private RString 基礎年金番号;
    @TempTableColumnOrder(6)
    private RString 年金コード;
    @TempTableColumnOrder(7)
    private RString 構成市町村コード;
    @TempTableColumnOrder(8)
    private RString 連番;
    @TempTableColumnOrder(9)
    private RString 処理日時;
    @TempTableColumnOrder(10)
    private RString 連携種別;
    @TempTableColumnOrder(11)
    private RString 捕捉月;
    @TempTableColumnOrder(12)
    private RString 天引月;
    @TempTableColumnOrder(13)
    private RString 識別コード;
    @TempTableColumnOrder(14)
    private RString 被保険者番号;
    @TempTableColumnOrder(15)
    private RString 国保世代コード;
    @TempTableColumnOrder(16)
    private RString dT市町村コード;
    @TempTableColumnOrder(17)
    private RString dT特別徴収義務者コード;
    @TempTableColumnOrder(18)
    private RString dT通知内容コード;
    @TempTableColumnOrder(19)
    private RString dT媒体コード;
    @TempTableColumnOrder(20)
    private RString dT特別徴収制度コード;
    @TempTableColumnOrder(21)
    private RString dT作成年月日;
    @TempTableColumnOrder(22)
    private RString dT基礎年金番号;
    @TempTableColumnOrder(23)
    private RString dT年金コード;
    @TempTableColumnOrder(24)
    private RString dT予備1;
    @TempTableColumnOrder(25)
    private RString dT生年月日;
    @TempTableColumnOrder(26)
    private RString dT性別;
    @TempTableColumnOrder(27)
    private RString dTカナ氏名;
    @TempTableColumnOrder(28)
    private RString dTシフトコード1;
    @TempTableColumnOrder(29)
    private RString dT漢字氏名;
    @TempTableColumnOrder(30)
    private RString dTシフトコード2;
    @TempTableColumnOrder(31)
    private RString dT郵便番号;
    @TempTableColumnOrder(32)
    private RString dTカナ住所;
    @TempTableColumnOrder(33)
    private RString dTシフトコード3;
    @TempTableColumnOrder(34)
    private RString dT漢字住所;
    @TempTableColumnOrder(35)
    private RString dTシフトコード4;
    @TempTableColumnOrder(36)
    private RString dT各種区分;
    @TempTableColumnOrder(37)
    private RString dT処理結果;
    @TempTableColumnOrder(38)
    private RString dT後期移管コード;
    @TempTableColumnOrder(39)
    private RString dT各種年月日;
    @TempTableColumnOrder(40)
    private RString dT各種金額欄１;
    @TempTableColumnOrder(41)
    private RString dT各種金額欄２;
    @TempTableColumnOrder(42)
    private RString dT各種金額欄3;
    @TempTableColumnOrder(43)
    private RString dT予備2;
    @TempTableColumnOrder(44)
    private RString dT共済年金証書記号番号;
    @TempTableColumnOrder(45)
    private RString dT各種金額欄4;
    @TempTableColumnOrder(46)
    private RString dT各種金額欄5;
    @TempTableColumnOrder(47)
    private RString dT各種金額欄6;
    @TempTableColumnOrder(48)
    private RString dT各種金額欄7;
    @TempTableColumnOrder(49)
    private RString dT各種金額欄8;
    @TempTableColumnOrder(50)
    private RString dT停止年月;
    @TempTableColumnOrder(51)
    private RString dT予備4住民税;
    @TempTableColumnOrder(52)
    private RString dT個人番号;

}
