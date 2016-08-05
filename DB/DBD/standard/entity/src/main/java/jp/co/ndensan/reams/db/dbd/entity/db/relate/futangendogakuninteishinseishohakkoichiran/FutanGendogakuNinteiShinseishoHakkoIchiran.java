/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogakuninteishinseishohakkoichiran;

import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.SetaiKazeiKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 負担限度額認定申請書発行一覧表情報Entityクラスです。
 *
 * @reamsid_L DBD-3530-090 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
public class FutanGendogakuNinteiShinseishoHakkoIchiran {

    private HihokenshaNo 被保番号;
    private RString 計画事業者コード;
    private RString 計画事業者名;
    private boolean is自己作成;
    private RiyoshaFutanDankai 利用者負担段階;
    private boolean 生保;
    private boolean 老齢;
    private RString 入所施設コード;
    private RString 入所施設名;
    private Decimal 合計所得;
    private FlexibleDate 認定開始日;
    private FlexibleDate 認定終了日;
    private RString 要介護認定状態区分コード;
    private RString 厚労省IF識別コード;
    private boolean 旧措置フラグ;
    private SetaiKazeiKubun 世帯課税;
    private FlexibleDate 申請年月日;
    private FlexibleDate 適用日;
    private RiyoshaFutanDankai 担段階;
    private Decimal ユニット型順個室;
    private Decimal 多床室;
    private FlexibleDate 決定年月日;
    private FlexibleDate 有効期限;
    private Decimal 食費負担額;
    private Decimal 従来型特養;
    private KetteiKubun 決定区分;
    private KyuSochishaKubun 旧措置;
    private Decimal ユニット型個室;
    private Decimal 従来型老健;
    private FlexibleDate 住民となった日;
    private RString 住所地特例フラグ;
    private Decimal 非課税年金勘案額;
}
