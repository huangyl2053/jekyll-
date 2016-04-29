/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolistkyotakuservicekeikaku;

import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistkyotakuservicekeikaku.HanyoListKyotakuServiceKeikakuProcessParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト 居宅サービス計画のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-3091-020 surun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKyotakuServiceKeikakuBatchParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;

    private static final String KEY_ONE = "構成市町村コード";
    private static final String KEY_TWO = "作成区分";
    private static final String KEY_THREE = "抽出区分";
    private static final String KEY_FOUR = "基準年月日";
    private static final String KEY_FIVE = "支援事業者番号";
    private static final String KEY_SIX = "改頁出力順ID";
    private static final String KEY_SEVEN = "出力項目ID";
    private static final String KEY_EIGHT = "CSV項目名付加";
    private static final String KEY_NINE = "CSV連番付加";
    private static final String KEY_TEN = "CSV日付スラッシュ編集";
    private static final String KEY_ELEVEN = "宛名検索条件";

    @BatchParameter(key = KEY_ONE, name = "構成市町村コード")
    private LasdecCode 構成市町村コード;
    @BatchParameter(key = KEY_TWO, name = "作成区分")
    private RString 作成区分;
    @BatchParameter(key = KEY_THREE, name = "抽出区分")
    private RString 抽出区分;
    @BatchParameter(key = KEY_FOUR, name = "基準年月日")
    private FlexibleDate 基準年月日;
    @BatchParameter(key = KEY_FIVE, name = "支援事業者番号")
    private RString 支援事業者番号;
    @BatchParameter(key = KEY_SIX, name = "改頁出力順ID")
    private RString 改頁出力順ID;
    @BatchParameter(key = KEY_SEVEN, name = "出力項目ID")
    private RString 出力項目ID;
    @BatchParameter(key = KEY_EIGHT, name = "CSV項目名付加")
    private boolean csv項目名付加;
    @BatchParameter(key = KEY_NINE, name = "CSV連番付加")
    private boolean csv連番付加;
    @BatchParameter(key = KEY_TEN, name = "CSV日付スラッシュ編集")
    private boolean csv日付スラッシュ編集;
    @BatchParameter(key = KEY_ELEVEN, name = "宛名検索条件")
    private IShikibetsuTaishoPSMSearchKey 宛名検索条件;

    /**
     * toProcessParameter
     *
     * @return HanyoListKyotakuServiceKeikakuProcessParameter
     */
    public HanyoListKyotakuServiceKeikakuProcessParameter toProcessParameter() {
        return new HanyoListKyotakuServiceKeikakuProcessParameter(構成市町村コード, 作成区分, 抽出区分, 基準年月日, 支援事業者番号,
                改頁出力順ID, 出力項目ID, csv項目名付加, csv連番付加, csv日付スラッシュ編集, 宛名検索条件);
    }
}
