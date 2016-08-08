/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables;

import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 判定対象者Tempエンティティのクラスです。
 *
 * @reamsid_L DBC-4950-032 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RiyoshaFutanWariaiMeisaiTempEntity extends DbTableEntityBase<RiyoshaFutanWariaiMeisaiTempEntity> implements IDbAccessable {

    //年度
    private FlexibleYear nendo;
    //被保険者番号
    private RString hihokenshaNo;
    //枝番号
    private int edaNo;
    //    資格区分
    private RString shikakuKubun;
    //負担割合区分
    private RString futanWariaiKubun;
    //有効開始日
    private FlexibleDate yukoKaishiYMD;
    //有効終了日
    private FlexibleDate yukoShuryoYMD;
    //本人合計所得金額
    private Decimal honninGoukeiShotokuGaku;
    //世帯１号被保険者数
    private int setaiIchigouHihokenshaSu;
    //年金収入合計
    private Decimal nenkinShunyuGoukei;
    //その他の合計所得金額合計
    private Decimal sonotanoGoukeiShotokuKingakuGoukei;
    //更正理由
    private RString koseiRiyu;
    //世帯コード
    private SetaiCode setaiCd;
    //更正事由
    private RString koseiJiyu;
    //判定区分
    private RString hanteiKubun;
    //認定有効期間開始年月日
    private FlexibleDate ninteiYukoKaishiDate;
    //受給開始日
    private FlexibleDate jukyuKaishiYMD;
    //受給廃止日
    private FlexibleDate jukyuHaishiYMD;
    //宛名異動日
    private FlexibleDate atenaIdobi;
}
