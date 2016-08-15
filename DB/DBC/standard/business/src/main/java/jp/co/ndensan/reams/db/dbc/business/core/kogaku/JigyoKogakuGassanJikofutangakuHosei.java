/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogaku;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業高額合算自己負担額補正保持ラスです。
 *
 * @reamsid_L DBC-4800-030 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoKogakuGassanJikofutangakuHosei implements Serializable {

    private HihokenshaNo 被保険者番号;
    private FlexibleYear 対象年度;
    private HokenshaNo 保険者番号;
    private RString 支給申請書整理番号;
    private RString 履歴番号;
    private FlexibleDate 生年月日;
    private RString 呼び出しフラグ;
    private RString 変更フラグ;
    private Decimal 補正前_自己負担額_8月分;
    private Decimal 補正前_自己負担額_9月分;
    private Decimal 補正前_自己負担額_10月分;
    private Decimal 補正前_自己負担額_11月分;
    private Decimal 補正前_自己負担額_12月分;
    private Decimal 補正前_自己負担額_1月分;
    private Decimal 補正前_自己負担額_2月分;
    private Decimal 補正前_自己負担額_3月分;
    private Decimal 補正前_自己負担額_4月分;
    private Decimal 補正前_自己負担額_5月分;
    private Decimal 補正前_自己負担額_6月分;
    private Decimal 補正前_自己負担額_7月分;
    private Decimal 補正前_うち70_74歳に係る負担額_8月分;
    private Decimal 補正前_うち70_74歳に係る負担額_9月分;
    private Decimal 補正前_うち70_74歳に係る負担額_10月分;
    private Decimal 補正前_うち70_74歳に係る負担額_11月分;
    private Decimal 補正前_うち70_74歳に係る負担額_12月分;
    private Decimal 補正前_うち70_74歳に係る負担額_1月分;
    private Decimal 補正前_うち70_74歳に係る負担額_2月分;
    private Decimal 補正前_うち70_74歳に係る負担額_3月分;
    private Decimal 補正前_うち70_74歳に係る負担額_4月分;
    private Decimal 補正前_うち70_74歳に係る負担額_5月分;
    private Decimal 補正前_うち70_74歳に係る負担額_6月分;
    private Decimal 補正前_うち70_74歳に係る負担額_7月分;
    private Decimal 補正前_高額総合事業サービス費_8月分;
    private Decimal 補正前_高額総合事業サービス費_9月分;
    private Decimal 補正前_高額総合事業サービス費_10月分;
    private Decimal 補正前_高額総合事業サービス費_11月分;
    private Decimal 補正前_高額総合事業サービス費_12月分;
    private Decimal 補正前_高額総合事業サービス費_1月分;
    private Decimal 補正前_高額総合事業サービス費_2月分;
    private Decimal 補正前_高額総合事業サービス費_3月分;
    private Decimal 補正前_高額総合事業サービス費_4月分;
    private Decimal 補正前_高額総合事業サービス費_5月分;
    private Decimal 補正前_高額総合事業サービス費_6月分;
    private Decimal 補正前_高額総合事業サービス費_7月分;
    private Decimal 補正前_実際の自己負担額_8月分;
    private Decimal 補正前_実際の自己負担額_9月分;
    private Decimal 補正前_実際の自己負担額_10月分;
    private Decimal 補正前_実際の自己負担額_11月分;
    private Decimal 補正前_実際の自己負担額_12月分;
    private Decimal 補正前_実際の自己負担額_1月分;
    private Decimal 補正前_実際の自己負担額_2月分;
    private Decimal 補正前_実際の自己負担額_3月分;
    private Decimal 補正前_実際の自己負担額_4月分;
    private Decimal 補正前_実際の自己負担額_5月分;
    private Decimal 補正前_実際の自己負担額_6月分;
    private Decimal 補正前_実際の自己負担額_7月分;
    private Decimal 変更前_補正後_自己負担額_8月分;
    private Decimal 変更前_補正後_自己負担額_9月分;
    private Decimal 変更前_補正後_自己負担額_10月分;
    private Decimal 変更前_補正後_自己負担額_11月分;
    private Decimal 変更前_補正後_自己負担額_12月分;
    private Decimal 変更前_補正後_自己負担額_1月分;
    private Decimal 変更前_補正後_自己負担額_2月分;
    private Decimal 変更前_補正後_自己負担額_3月分;
    private Decimal 変更前_補正後_自己負担額_4月分;
    private Decimal 変更前_補正後_自己負担額_5月分;
    private Decimal 変更前_補正後_自己負担額_6月分;
    private Decimal 変更前_補正後_自己負担額_7月分;
    private Decimal 変更前_補正後_うち70_74歳に係る負担額_8月分;
    private Decimal 変更前_補正後_うち70_74歳に係る負担額_9月分;
    private Decimal 変更前_補正後_うち70_74歳に係る負担額_10月分;
    private Decimal 変更前_補正後_うち70_74歳に係る負担額_11月分;
    private Decimal 変更前_補正後_うち70_74歳に係る負担額_12月分;
    private Decimal 変更前_補正後_うち70_74歳に係る負担額_1月分;
    private Decimal 変更前_補正後_うち70_74歳に係る負担額_2月分;
    private Decimal 変更前_補正後_うち70_74歳に係る負担額_3月分;
    private Decimal 変更前_補正後_うち70_74歳に係る負担額_4月分;
    private Decimal 変更前_補正後_うち70_74歳に係る負担額_5月分;
    private Decimal 変更前_補正後_うち70_74歳に係る負担額_6月分;
    private Decimal 変更前_補正後_うち70_74歳に係る負担額_7月分;
    private Decimal 変更前_補正後_高額総合事業サービス費_8月分;
    private Decimal 変更前_補正後_高額総合事業サービス費_9月分;
    private Decimal 変更前_補正後_高額総合事業サービス費_10月分;
    private Decimal 変更前_補正後_高額総合事業サービス費_11月分;
    private Decimal 変更前_補正後_高額総合事業サービス費_12月分;
    private Decimal 変更前_補正後_高額総合事業サービス費_1月分;
    private Decimal 変更前_補正後_高額総合事業サービス費_2月分;
    private Decimal 変更前_補正後_高額総合事業サービス費_3月分;
    private Decimal 変更前_補正後_高額総合事業サービス費_4月分;
    private Decimal 変更前_補正後_高額総合事業サービス費_5月分;
    private Decimal 変更前_補正後_高額総合事業サービス費_6月分;
    private Decimal 変更前_補正後_高額総合事業サービス費_7月分;
    private Decimal 変更前_補正後_実際の自己負担額_8月分;
    private Decimal 変更前_補正後_実際の自己負担額_9月分;
    private Decimal 変更前_補正後_実際の自己負担額_10月分;
    private Decimal 変更前_補正後_実際の自己負担額_11月分;
    private Decimal 変更前_補正後_実際の自己負担額_12月分;
    private Decimal 変更前_補正後_実際の自己負担額_1月分;
    private Decimal 変更前_補正後_実際の自己負担額_2月分;
    private Decimal 変更前_補正後_実際の自己負担額_3月分;
    private Decimal 変更前_補正後_実際の自己負担額_4月分;
    private Decimal 変更前_補正後_実際の自己負担額_5月分;
    private Decimal 変更前_補正後_実際の自己負担額_6月分;
    private Decimal 変更前_補正後_実際の自己負担額_7月分;
    private Decimal 変更後_補正後_自己負担額_8月分;
    private Decimal 変更後_補正後_自己負担額_9月分;
    private Decimal 変更後_補正後_自己負担額_10月分;
    private Decimal 変更後_補正後_自己負担額_11月分;
    private Decimal 変更後_補正後_自己負担額_12月分;
    private Decimal 変更後_補正後_自己負担額_1月分;
    private Decimal 変更後_補正後_自己負担額_2月分;
    private Decimal 変更後_補正後_自己負担額_3月分;
    private Decimal 変更後_補正後_自己負担額_4月分;
    private Decimal 変更後_補正後_自己負担額_5月分;
    private Decimal 変更後_補正後_自己負担額_6月分;
    private Decimal 変更後_補正後_自己負担額_7月分;
    private Decimal 変更後_補正後_うち70_74歳に係る負担額_8月分;
    private Decimal 変更後_補正後_うち70_74歳に係る負担額_9月分;
    private Decimal 変更後_補正後_うち70_74歳に係る負担額_10月分;
    private Decimal 変更後_補正後_うち70_74歳に係る負担額_11月分;
    private Decimal 変更後_補正後_うち70_74歳に係る負担額_12月分;
    private Decimal 変更後_補正後_うち70_74歳に係る負担額_1月分;
    private Decimal 変更後_補正後_うち70_74歳に係る負担額_2月分;
    private Decimal 変更後_補正後_うち70_74歳に係る負担額_3月分;
    private Decimal 変更後_補正後_うち70_74歳に係る負担額_4月分;
    private Decimal 変更後_補正後_うち70_74歳に係る負担額_5月分;
    private Decimal 変更後_補正後_うち70_74歳に係る負担額_6月分;
    private Decimal 変更後_補正後_うち70_74歳に係る負担額_7月分;
    private Decimal 変更後_補正後_高額総合事業サービス費_8月分;
    private Decimal 変更後_補正後_高額総合事業サービス費_9月分;
    private Decimal 変更後_補正後_高額総合事業サービス費_10月分;
    private Decimal 変更後_補正後_高額総合事業サービス費_11月分;
    private Decimal 変更後_補正後_高額総合事業サービス費_12月分;
    private Decimal 変更後_補正後_高額総合事業サービス費_1月分;
    private Decimal 変更後_補正後_高額総合事業サービス費_2月分;
    private Decimal 変更後_補正後_高額総合事業サービス費_3月分;
    private Decimal 変更後_補正後_高額総合事業サービス費_4月分;
    private Decimal 変更後_補正後_高額総合事業サービス費_5月分;
    private Decimal 変更後_補正後_高額総合事業サービス費_6月分;
    private Decimal 変更後_補正後_高額総合事業サービス費_7月分;
    private Decimal 変更後_補正後_実際の自己負担額_8月分;
    private Decimal 変更後_補正後_実際の自己負担額_9月分;
    private Decimal 変更後_補正後_実際の自己負担額_10月分;
    private Decimal 変更後_補正後_実際の自己負担額_11月分;
    private Decimal 変更後_補正後_実際の自己負担額_12月分;
    private Decimal 変更後_補正後_実際の自己負担額_1月分;
    private Decimal 変更後_補正後_実際の自己負担額_2月分;
    private Decimal 変更後_補正後_実際の自己負担額_3月分;
    private Decimal 変更後_補正後_実際の自己負担額_4月分;
    private Decimal 変更後_補正後_実際の自己負担額_5月分;
    private Decimal 変更後_補正後_実際の自己負担額_6月分;
    private Decimal 変更後_補正後_実際の自己負担額_7月分;
    private Decimal 変更後_補正後_実際の自己負担額;
    private Decimal 変更前_合計_自己負担額;
    private Decimal 変更前_合計_うち70_74歳に係る負担額;
    private Decimal 変更前_合計_高額総合事業サービス費;
    private Decimal 変更前_合計_実際の自己負担額;
    private Decimal 変更後_合計_補正後_自己負担額;
    private Decimal 変更後_合計_補正後_うち70_74歳に係る負担額;
    private Decimal 変更後_合計_補正後_高額総合事業サービス費;
    private Decimal 変更後_合計_補正後_実際の自己負担額;
}
