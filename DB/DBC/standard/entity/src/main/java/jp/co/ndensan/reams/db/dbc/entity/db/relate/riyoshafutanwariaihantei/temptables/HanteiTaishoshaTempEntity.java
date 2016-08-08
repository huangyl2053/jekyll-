/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 判定対象者Tempエンティティのクラスです。
 *
 * @reamsid_L DBC-4950-032 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanteiTaishoshaTempEntity extends DbTableEntityBase<HanteiTaishoshaTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    //対象年度
    private FlexibleYear taishoNendo;
    @TempTableColumnOrder(2)
    //対象月
    private FlexibleYearMonth taishoGetsu;
    @TempTableColumnOrder(3)
    //対象区分
    private RString taishoKubun;
    @TempTableColumnOrder(4)
    //被保険者番号
    private RString hihokenshaNo;
    @TempTableColumnOrder(5)
    //識別コード
    private RString shikibetsuCode;
    @TempTableColumnOrder(6)
    //世帯コード
    private RString setaiCode;
    @TempTableColumnOrder(7)
    //異動種別
    private RString idoShubetsu;
    @TempTableColumnOrder(8)
    //宛名異動日
    private FlexibleDate atenaIdobi;
    @TempTableColumnOrder(9)
    //宛名異動事由コード
    private RString atenaIdoJiyu;
    @TempTableColumnOrder(10)
    //異動日
    private FlexibleDate idobi;
    @TempTableColumnOrder(11)
    //異動事由コード
    private RString idoJiyuCode;
    @TempTableColumnOrder(12)
    //資格取得年月日
    private FlexibleDate shikakuShiyutokiDate;
    @TempTableColumnOrder(13)
    //第１号資格取得年月日
    private FlexibleDate firstShikakuShiyutokiDate;
    @TempTableColumnOrder(14)
    //被保険者区分コード
    private RString hihokenshaKubunCode;
    @TempTableColumnOrder(15)
    //市町村コード
    private RString cityCode;
    @TempTableColumnOrder(16)
    //履歴番号
    private RString rirekiNo;
    @TempTableColumnOrder(17)
    //枝番
    private RString edaNo;
    @TempTableColumnOrder(18)
    //受給申請事由
    private RString jukyuShinseiJiyu;
    @TempTableColumnOrder(19)
    //認定有効期間開始年月日
    private FlexibleDate ninteiYukoKaishiDate;
    @TempTableColumnOrder(20)
    //認定有効期間終了年月日
    private FlexibleDate ninteiYukoShuryoDate;
    @TempTableColumnOrder(21)
    //認定年月日
    private FlexibleDate ninteiDate;
    @TempTableColumnOrder(22)
    //要介護認定状態区分コード
    private RString yoKaigoninteiJoutaiKubunCode;
    @TempTableColumnOrder(23)
    //旧措置者フラグ
    private boolean kyuSochishaFlag;
    @TempTableColumnOrder(24)
    //所得年度
    private FlexibleYear shotokuNendo;
    @TempTableColumnOrder(25)
    //所得履歴番号
    private RString shotokuRirekiNo;
    @TempTableColumnOrder(26)
    //課税区分(住民税減免前)
    private RString kazeiKubun;
    @TempTableColumnOrder(27)
    //課税区分(住民税減免後)
    private RString kazeiKubunGemmenGo;
    @TempTableColumnOrder(28)
    //合計所得金額
    private Decimal gokeiShotokuGaku;
    @TempTableColumnOrder(29)
    //公的年金収入額
    private Decimal nenkiniShunyuGaku;
    @TempTableColumnOrder(30)
    //公的年金所得額
    private Decimal nenkiniShotokuGaku;
    @TempTableColumnOrder(31)
    //課税所得額
    private Decimal kazeiShotokuGaku;
    @TempTableColumnOrder(32)
    //激変緩和措置区分
    private RString gekihenKanwaKubun;

}
