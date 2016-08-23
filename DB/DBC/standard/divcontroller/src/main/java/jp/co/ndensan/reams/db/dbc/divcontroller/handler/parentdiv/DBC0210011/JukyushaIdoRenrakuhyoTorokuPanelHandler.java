/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0210011;

import jp.co.ndensan.reams.db.dbc.business.core.basic.JukyushaIdoRenrakuhyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JukyushaIdoRenrakuhyoBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.jukyushaidorenrakuhyotoroku.JukyushaIdoRenrakuhyoTorokuEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyushaIdoRenrakuhyo.IJukyushaIdoRenrakuhyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0210011.JukyushaIdoRenrakuhyoTorokuPanelDiv;
import jp.co.ndensan.reams.db.dbc.service.core.jukyushaidorenrakuhyotoroku.JukyushaIdoRenrakuhyoToroku;
import jp.co.ndensan.reams.db.dbc.service.report.jukyushaidorenrakuhyo.JukyushaIdoRenrakuhyoPrintSevice;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 受給者異動連絡票（追加）登録Handlerです。
 *
 * @reamsid_L DBC-2100-010 jiangzongyue
 */
public class JukyushaIdoRenrakuhyoTorokuPanelHandler {

    private final JukyushaIdoRenrakuhyoTorokuPanelDiv div;
    private static final RString 被保険者番号R = new RString("被保険者番号");
    private static final RString 半角アスタリスク = new RString("*");
    private static final Decimal ZERO = new Decimal("0");
    private static final int ZERO0 = 0;

    /**
     * コンストラクタです。
     *
     * @param div JukyushaIdoRenrakuhyoTorokuPanelDiv
     */
    public JukyushaIdoRenrakuhyoTorokuPanelHandler(JukyushaIdoRenrakuhyoTorokuPanelDiv div) {
        this.div = div;
    }

    /**
     * onLoad時アクセスログ出力します。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     */
    public void printLog識別コード照会(ShikibetsuCode 識別コード, RString 被保険者番号) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(識別コード, 被保険者番号));
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード, RString 被保険者番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), 被保険者番号R, 被保険者番号);
        return PersonalData.of(識別コード, expandedInfo);
    }

    /**
     * Save時DB出力(受給者異動送付)ます。
     *
     * @param result result
     * @return JukyushaIdoRenrakuhyo
     */
    public JukyushaIdoRenrakuhyo editResult(JukyushaIdoRenrakuhyo result) {
        JukyushaIdoRenrakuhyoBuilder resultEdit = result.createBuilderForEdit();
        if (RString.isNullOrEmpty(result.get居宅サービス計画作成区分コード())) {
            result = resultEdit.set居宅サービス計画作成区分コード(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get利用者負担区分コード())) {
            result = resultEdit.set利用者負担区分コード(半角アスタリスク).build();
        }
        if (result.get給付率() == null) {
            result = resultEdit.set給付率(ZERO).build();
        }
        if (RString.isNullOrEmpty(result.get標準負担区分コード())) {
            result = resultEdit.set標準負担区分コード(半角アスタリスク).build();
        }
        if (result.get負担額() == null) {
            result = resultEdit.set負担額(ZERO).build();
        }
        if (RString.isNullOrEmpty(result.get特定入所者介護サービス区分コード())) {
            result = resultEdit.set特定入所者介護サービス区分コード(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.is課税層の特例減額措置対象フラグ())) {
            result = resultEdit.set特定入所者介護サービス区分コード(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get軽減率())) {
            result = resultEdit.set軽減率(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get住所地特例対象者区分コード())) {
            result = resultEdit.set住所地特例対象者区分コード(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get住所地特例適用開始日())) {
            result = resultEdit.set住所地特例適用開始日(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get住所地特例適用終了日())) {
            result = resultEdit.set住所地特例適用終了日(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get利用者負担割合有効開始日())) {
            result = resultEdit.set利用者負担割合有効開始日(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get利用者負担割合有効終了日())) {
            result = resultEdit.set利用者負担割合有効終了日(半角アスタリスク).build();
        }
        edit番号(result);
        edit開始終了年月日(result);
        edit限度額(result);
        return result;
    }

    private void edit限度額(JukyushaIdoRenrakuhyo result) {
        JukyushaIdoRenrakuhyoBuilder resultEdit = result.createBuilderForEdit();
        if (RString.isNullOrEmpty(result.get食費負担限度額())) {
            result = resultEdit.set食費負担限度額(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get居住費ユニット型個室負担限度額())) {
            result = resultEdit.set居住費ユニット型個室負担限度額(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get居住費ユニット型準個室負担限度額())) {
            result = resultEdit.set居住費ユニット型準個室負担限度額(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get居住費従来型個室特養等負担限度額())) {
            result = resultEdit.set居住費従来型個室特養等負担限度額(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get居住費従来型個室老健療養等負担限度額())) {
            result = resultEdit.set居住費従来型個室老健療養等負担限度額(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get居住費多床室負担限度額())) {
            result = resultEdit.set居住費多床室負担限度額(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get居宅費_新１_負担限度額())) {
            result = resultEdit.set居宅費_新１_負担限度額(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get居宅費_新２_負担限度額())) {
            result = resultEdit.set居宅費_新２_負担限度額(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get居宅費_新３_負担限度額())) {
            result = resultEdit.set居宅費_新３_負担限度額(半角アスタリスク).build();
        }
    }

    private void edit番号(JukyushaIdoRenrakuhyo result) {
        JukyushaIdoRenrakuhyoBuilder resultEdit = result.createBuilderForEdit();
        if (RString.isNullOrEmpty(result.get居宅介護支援事業所番号())) {
            result = resultEdit.set居宅介護支援事業所番号(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get後期高齢者医療保険者番号())) {
            result = resultEdit.set後期高齢者医療保険者番号(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get後期高齢者医療被保険者番号())) {
            result = resultEdit.set後期高齢者医療被保険者番号(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get国民健康保険保険者番号())) {
            result = resultEdit.set国民健康保険保険者番号(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get国民健康保険被保険者証番号())) {
            result = resultEdit.set国民健康保険被保険者証番号(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get国民健康保険個人番号())) {
            result = resultEdit.set国民健康保険個人番号(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get施設所在保険者番号())) {
            result = resultEdit.set施設所在保険者番号(半角アスタリスク).build();
        }
    }

    private void edit開始終了年月日(JukyushaIdoRenrakuhyo result) {
        JukyushaIdoRenrakuhyoBuilder resultEdit = result.createBuilderForEdit();
        if (RString.isNullOrEmpty(result.get認定有効期間終了年月日())) {
            result = resultEdit.set認定有効期間終了年月日(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get認定有効期間終了年月日())) {
            result = resultEdit.set認定有効期間終了年月日(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get居宅サービス計画適用開始年月日())) {
            result = resultEdit.set居宅サービス計画適用開始年月日(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get居宅サービス計画適用終了年月日())) {
            result = resultEdit.set居宅サービス計画適用終了年月日(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get訪問通所サービス上限管理適用期間終了年月日())) {
            result = resultEdit.set訪問通所サービス上限管理適用期間終了年月日(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get償還払化開始年月日())) {
            result = resultEdit.set償還払化開始年月日(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get償還払化終了年月日())) {
            result = resultEdit.set償還払化終了年月日(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get適用開始年月日())) {
            result = resultEdit.set適用開始年月日(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get適用終了年月日())) {
            result = resultEdit.set適用終了年月日(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get負担額適用開始年月日())) {
            result = resultEdit.set負担額適用開始年月日(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get負担額適用終了年月日())) {
            result = resultEdit.set負担額適用終了年月日(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get負担限度額適用開始年月日())) {
            result = resultEdit.set負担限度額適用開始年月日(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get負担限度額適用終了年月日())) {
            result = resultEdit.set負担限度額適用終了年月日(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get軽減率適用開始年月日())) {
            result = resultEdit.set軽減率適用開始年月日(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get軽減率適用終了年月日())) {
            result = resultEdit.set軽減率適用終了年月日(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get給付率引下げ開始年月日())) {
            result = resultEdit.set給付率引下げ開始年月日(半角アスタリスク).build();
        }
        if (RString.isNullOrEmpty(result.get給付率引下げ終了年月日())) {
            result = resultEdit.set給付率引下げ終了年月日(半角アスタリスク).build();
        }
    }

    /**
     * 帳票発行処理のメソッドです。
     *
     *
     * @param idiv IJukyushaIdoRenrakuhyoDiv
     * @return SourceDataCollection
     */
    public SourceDataCollection to帳票発行(IJukyushaIdoRenrakuhyoDiv idiv) {
        JukyushaIdoRenrakuhyoToroku 受給者連絡票データ作成 = JukyushaIdoRenrakuhyoToroku.createInstance();
        JukyushaIdoRenrakuhyoTorokuEntity 受給者連絡票データ = 受給者連絡票データ作成
                .editJukyushaIdoRenrakuhyo(idiv.get受給者異動送付().get被保険者番号().getColumnValue(), new RDate(idiv.get受給者異動送付().get異動年月日().toString()),
                        div.getJukyushaIdoRenrakuhyoShinkiTorokuPanel().getOutputJukyushaIdoRenrakuhyo().getChkJukyushaIdoRenrakuhyo().getSelectedKeys().get(ZERO0));
        JukyushaIdoRenrakuhyoPrintSevice printService
                = new JukyushaIdoRenrakuhyoPrintSevice();
        return printService.printSingle(受給者連絡票データ);
    }

}
