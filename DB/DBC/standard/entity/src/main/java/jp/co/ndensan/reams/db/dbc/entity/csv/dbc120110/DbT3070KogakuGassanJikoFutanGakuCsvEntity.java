/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc120110;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算自己負担額TBL
 *
 * @reamsid_L DBC-2650-010 chenjie
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbT3070KogakuGassanJikoFutanGakuCsvEntity {

    private HihokenshaNo 被保険者番号;
    private FlexibleYear 対象年度;
    private HokenshaNo 保険者番号;
    private RString 支給申請書整理番号;
    private int 履歴番号;
    private RString 保険制度コード;
    private RString 保険者名;
    private RString 国保被保険者証記号;
    private AtenaKanaMeisho 被保険者氏名カナ;
    private AtenaMeisho 被保険者氏名;
    private FlexibleDate 生年月日;
    private Code 性別;
    private RString 所得区分;
    private RString 超過70歳者に係る所得区分;
    private RString 自己負担額証明書整理番号;
    private RString 後期保険者番号;
    private RString 後期被保険者番号;
    private RString 国保保険者番号;
    private RString 国保被保険者証番号;
    private RString 国保個人番号;
    private RString 異動区分;
    private RString 補正済自己負担額送付区分;
    private FlexibleDate 対象計算期間開始年月日;
    private FlexibleDate 対象計算期間終了年月日;
    private FlexibleDate 被保険者期間開始年月日;
    private FlexibleDate 被保険者期間終了年月日;
    private FlexibleDate 申請年月日;
    private Decimal 合計_自己負担額;
    private Decimal 合計_70_74自己負担額_内訳;
    private Decimal 合計_70未満高額支給額;
    private Decimal 合計_70_74高額支給額;
    private Decimal 補正済_合計_自己負担額;
    private Decimal 補正済_合計_70_74自己負担額_内訳;
    private Decimal 補正済_合計_70未満高額支給額;
    private Decimal 補正済_合計_70_74高額支給額;
    private AtenaMeisho 宛先氏名;
    private YubinNo 宛先郵便番号;
    private RString 宛先住所;
    private RString 窓口払対象者判定コード;
    private RString 支払場所;
    private FlexibleDate 支払期間開始年月日;
    private FlexibleDate 支払期間終了年月日;
    private RString 閉庁内容;
    private RString 支払期間開始時間;
    private RString 支払期間終了時間;
    private RString 備考;
    private RString データ作成区分;
    private FlexibleYearMonth 自己負担額確認情報受取年月;
    private FlexibleYearMonth 補正済自己負担額情報送付年月;
    private FlexibleYearMonth 自己負担額証明書情報受取年月;
    private RString 再送フラグ;
    private RString 送付対象外フラグ;
    private FlexibleDate 自己負担額計算年月日;
    private FlexibleDate 自己負担額証明書作成年月日;
    private RString 後期_国保処理区分;
    private RString 自己負担額証明書リアル発行フラグ;
    private FlexibleDate バッチ補正実施年月日;
    private FlexibleDate リアル補正実施年月日;

}
