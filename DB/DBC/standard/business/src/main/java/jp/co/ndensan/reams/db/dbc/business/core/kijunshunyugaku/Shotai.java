/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugaku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ur.urz.business.core.jusho.IJusho;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 対象世帯員クラスの世帯員情報です
 *
 * @reamsid_L DBC-4640-080 liuxiaoyu
 */
@Getter
@Setter
public class Shotai {

    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;
    private RString 市町村コード;
    private RString 住所地特例フラグ;
    private RString 課税区分;
    private Decimal 課税所得;
    private Decimal 課税所得_控除後;
    private Decimal 年金収入;
    private Decimal その他の合計所得;
    private RString 編集続柄コード;
    private RString 宛名データ種別_1231;
    private RString 宛名データ種別_基準日;
    private RString 氏名;
    private RString 氏名カナ;
    private Gender 性別;
    private FlexibleDate 生年月日;
    private RString 資格区分;
    private RString 受給区分;
    private RString 要介護度;
    private FlexibleDate 認定開始日;
    private FlexibleDate 認定終了日;
    private FlexibleDate 適用開始日;
    private FlexibleDate 適用終了日;
    private RString 宛名_印字者区分;
    private IJusho 申請書住所;
    private RString 連絡先;
    private IAtesaki お知らせ通知書住所;

}
