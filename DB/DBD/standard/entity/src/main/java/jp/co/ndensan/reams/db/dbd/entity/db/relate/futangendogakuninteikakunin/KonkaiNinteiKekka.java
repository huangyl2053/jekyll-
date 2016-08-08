/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogakuninteikakunin;

import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.HaigushaKazeiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.ShinseiRiyuKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 負担限度額認定（一括）確認リストEntityの今回特定入所者情報クラスです。
 *
 * @reamsid_L DBD-3710-100 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
public class KonkaiNinteiKekka {

    private ShinseiRiyuKubun 申請理由区分;
    private HaigushaKazeiKubun 配偶者課税区分;
    private FlexibleDate 申請年月日;
    private FlexibleDate 決定年月日;
    private KetteiKubun 決定区分;
    private FlexibleDate 適用日開始年月日;
    private FlexibleDate 適用終了年月日;
    private KyuSochishaKubun 旧措置者区分;
    private RiyoshaFutanDankai 利用者負担段階;
    private Decimal 食費負担額;
    private Decimal ユニット型個室;
    private Decimal ユニット型準個室;
    private Decimal 従来型個室特養;
    private Decimal 従来型個室老健療養;
    private Decimal 多床室;
}
