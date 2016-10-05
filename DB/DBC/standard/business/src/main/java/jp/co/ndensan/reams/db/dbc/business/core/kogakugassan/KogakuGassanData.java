/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogakugassan;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算データのクラスです。
 *
 * @reamsid_L DBC-2380-030 pengxingyi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KogakuGassanData {

    private HihokenshaNo 被保険者番号;
    private FlexibleYear 対象年度;
    private LasdecCode 保険者番号;
    private RString 保険者名;
    private RString 支給申請書整理番号;
    private FlexibleDate 対象計算期間開始年月日;
    private FlexibleDate 対象計算期間終了年月日;
    private AtenaKanaMeisho 被保険者氏名カナ;
    private AtenaMeisho 被保険者氏名;
    private FlexibleDate 生年月日;
    private Gender 性別;
    private RString 自己負担額証明書整理番号;
    private FlexibleDate 被保険者期間開始年月日;
    private FlexibleDate 被保険者期間終了年月日;
    private Decimal 合計_自己負担額;
    private Decimal 合計_70_74自己負担額_内訳;
    private Decimal 補正済_合計_自己負担額;
    private Decimal 補正済_合計_70_74自己負担額_内訳;
    private ShikibetsuCode 識別コード;
    private List<KogakuGassanMeisai> 明細List;

    private RString 郵便番号;
    private RString 町域コード;
    private RString 行政区コード;
    private RString 市町村コード;
    private RString 証記載保険者番号;
    private RString 氏名５０音カナ;

}
