/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 今回利用者負担割合情報の一時表エンティティです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KonkaiRiyoshaFutanWariaiJohoTempEntity
        extends DbTableEntityBase<KonkaiRiyoshaFutanWariaiJohoTempEntity> implements IDbAccessable {

    //被保険者番号
    private HihokenshaNo hihokenshaNo;
    //更正事由
    private RString koseiJiyu;
    //年度
    private RString nendo;
    //枝番号
    private int edaNo;
    //負担割合区分
    private RString futanWariaiKubun;
    //本人合計所得金額
    private Decimal honinGokeishotokuKingaku;
    //世帯１号被保険者数
    private Integer setaiIchigouHihokenshaSu;
    //有効開始日
    private FlexibleDate yukoKaishiYMD;
    //有効終了日
    private FlexibleDate yukoShuryoYMD;
    //年金収入合計
    private Decimal nenkinShunyuGoukei;
    //その他の合計所得金額合計
    private Decimal sonotaGokeiShotokuKingaku;

}
