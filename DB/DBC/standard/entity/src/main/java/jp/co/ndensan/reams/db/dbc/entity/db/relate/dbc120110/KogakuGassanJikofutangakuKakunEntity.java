/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120110;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 37J_高額合算自己負担額確認情報取込の一覧表用entity。
 *
 * @reamsid_L DBC-2650-010 chenjie
 */
@lombok.Getter
@lombok.Setter
public class KogakuGassanJikofutangakuKakunEntity {

    private RString 証記載保険者番号;
    private RString 証記載保険者名;
    private RString 被保険者番号;
    private RString 被保険者氏名;
    private RString 支給申請書整理番号;
    private FlexibleYear 対象年度;
    private int 履歴番号;
    private FlexibleDate 申請年月日;
    private RString 異動区分コード;
    private FlexibleDate 介護加入期間_開始;
    private FlexibleDate 介護加入期間_終了;
    private FlexibleDate 対象計算期間_開始;
    private FlexibleDate 対象計算期間_終了;
    private Decimal 自己負担額合計;
    private Decimal 自己負担額合計_うち70_74歳;
    private Decimal 高額介護サービス費;
    private ShikibetsuCode 識別コード;
    private RString 被保険者_郵便番号;
    private RString 被保険者_町域コード;
    private RString 被保険者_行政区コード;
    private RString 被保険者_氏名50音カナ;
    private RString 被保険者_市町村コード;

}
