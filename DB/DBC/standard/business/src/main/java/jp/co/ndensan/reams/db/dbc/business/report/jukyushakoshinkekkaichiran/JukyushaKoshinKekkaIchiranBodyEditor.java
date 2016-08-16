/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jukyushakoshinkekkaichiran;

import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_GemmenShinseichuKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_HenkoShinseichuKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_HyojunFutanKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_IdoKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_JukyushaIdoJiyu;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_JutokuJigyoKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KeikakuSakuseiKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_NijiyoboJigyoKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_NinteiShinseichuKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_RiyoshaFutanKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_ServiceKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_ShinseiShubetsuCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_ShokiboKyotakuServiceRIyoCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_TeiseiKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_TokureiGengakuSochiTaisho;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_kohiFutanJogengakuGengakuUmu;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushakoshinkekka.DbWT5331JukyushaJohoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushajoho.JukyushaHihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushakoshinkekkaichiran.JukyushaKoshinKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.MinashiCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 受給者情報更新結果情報取込一覧表帳票BodyEditor
 *
 * @reamsid_L DBC-2730-030 chenjie
 */
public class JukyushaKoshinKekkaIchiranBodyEditor implements IJukyushaKoshinKekkaIchiranEditor {

    private final JukyushaHihokenshaEntity 帳票出力対象データ;
    private final RString 住所情報;
    private static final RString コロン = new RString(":");
    private static final RString パーセント = new RString("%");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ JukyushaHihokenshaEntity
     * @param 住所情報 RString
     */
    public JukyushaKoshinKekkaIchiranBodyEditor(JukyushaHihokenshaEntity 帳票出力対象データ, RString 住所情報) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.住所情報 = 住所情報;
    }

    @Override
    public JukyushaKoshinKekkaIchiranSource edit(JukyushaKoshinKekkaIchiranSource source) {
        DbWT5331JukyushaJohoTempEntity 受給者情報 = 帳票出力対象データ.get受給者情報明細一時();
        DbWT0001HihokenshaTempEntity 被保険者情報 = 帳票出力対象データ.get被保険者一時();
        source.listList1_1 = date_to_string(受給者情報.get訂正年月日());
        source.listList1_2 = date_to_string(受給者情報.get異動年月日());
        RString 異動区分コード = 受給者情報.get異動区分コード();
        source.listList1_3 = 異動区分コード.concat(コロン)
                .concat(JukyushaIF_IdoKubunCode.toValue(異動区分コード).name());
        source.listList1_4 = 被保険者情報.get登録被保険者番号().getColumnValue();
        source.listList1_5 = 被保険者情報.get宛名カナ名称();
        source.listList1_6 = 被保険者情報.get行政区コード();
        source.listList1_7 = 被保険者情報.get行政区名();
        source.listList1_8 = date_to_string(受給者情報.get生年月日());
        source.listList1_9 = date_to_string(受給者情報.get資格取得年月日());
        RString 訂正区分コード = 受給者情報.get訂正区分コード();
        source.listList2_1 = 訂正区分コード.concat(コロン)
                .concat(JukyushaIF_TeiseiKubunCode.toValue(訂正区分コード).name());
        RString 異動事由区分 = 受給者情報.get異動事由区分();
        source.listList2_2 = 異動事由区分.concat(コロン)
                .concat(JukyushaIF_JukyushaIdoJiyu.toValue(異動事由区分).name());
        source.listList2_3 = 被保険者情報.get宛名名称();
        source.listList2_4 = 被保険者情報.get町域コード();
        if (this.住所情報 != null) {
            if (30 < this.住所情報.length()) {
                source.listList2_5 = this.住所情報.substring(0, 30);
            } else {
                source.listList2_5 = this.住所情報;
            }
        }
        RString 性別コード = 受給者情報.get性別コード();
        if (!isEmptyOrNull(性別コード)) {
            source.listList2_6 = 性別コード.concat(コロン)
                    .concat(Seibetsu.toValue(性別コード).name());
        }
        source.listList2_7 = date_to_string(受給者情報.get資格喪失年月日());
        RString みなし要介護区分コード = 受給者情報.getみなし要介護区分コード();
        if (!isEmptyOrNull(みなし要介護区分コード)) {
            source.listList3_1 = みなし要介護区分コード.concat(コロン)
                    .concat(MinashiCode.toValue(みなし要介護区分コード).name());
        }
        source.listList3_2 = date_to_string(受給者情報.get認定有効期間開始年月日());
        RString 申請種別コード = 受給者情報.get申請種別コード();
        if (!isEmptyOrNull(申請種別コード)) {
            source.listList3_3 = 申請種別コード.concat(コロン)
                    .concat(JukyushaIF_ShinseiShubetsuCode.toValue(申請種別コード).name());
        }
        source.listList3_4 = date_to_string(受給者情報.get申請年月日());
        RString 計画作成区分 = 受給者情報.get居宅サービス計画作成区分コード();
        if (!isEmptyOrNull(計画作成区分)) {
            source.listList3_5 = 計画作成区分.concat(コロン)
                    .concat(JukyushaIF_KeikakuSakuseiKubunCode.toValue(計画作成区分).name());
        }
        source.listList3_6 = date_to_string(受給者情報.get居宅サービス計画適用開始年月日());
        source.listList3_7 = decimal_to_string(受給者情報.get訪問通所_支給限度基準額());
        source.listList3_8 = date_to_string(受給者情報.get訪問通所_上限管理適用期間開始年月日());
        source.listList3_9 = decimal_to_string(受給者情報.get短期入所_支給限度基準額());
        source.listList3_10 = date_to_string(受給者情報.get短期入所_上限管理適用期間開始年月日());
        RString 標準負担区分 = 受給者情報.get標準負担区分コード();
        if (!isEmptyOrNull(標準負担区分)) {
            source.listList3_11 = 標準負担区分.concat(コロン)
                    .concat(JukyushaIF_HyojunFutanKubunCode.toValue(標準負担区分).name());
        }
        source.listList3_12 = date_to_string(受給者情報.get負担額適用開始年月日());
        RString 減免中区分 = 受給者情報.get減免申請中区分コード();
        if (!isEmptyOrNull(減免中区分)) {
            source.listList3_13 = 減免中区分.concat(コロン)
                    .concat(JukyushaIF_GemmenShinseichuKubunCode.toValue(減免中区分).name());
        }
        RString 要介護区分 = 受給者情報.get要介護状態区分コード();
        if (!isEmptyOrNull(要介護区分) && 被保険者情報.getサービス提供年月末日() != null) {
             source.listList4_1 = 要介護区分.concat(コロン).concat(YokaigoJotaiKubunSupport
                     .toValue(被保険者情報.getサービス提供年月末日().getYearMonth(), 要介護区分).getName());
        }
        source.listList4_2 = date_to_string(受給者情報.get認定有効期間終了年月日());
        RString 変更申請区分 = 受給者情報.get変更申請中区分コード();
        if (!isEmptyOrNull(変更申請区分)) {
            source.listList4_3 = 変更申請区分.concat(コロン)
                    .concat(JukyushaIF_HenkoShinseichuKubunCode.toValue(変更申請区分).name());
        }
        source.listList4_4 = 受給者情報.get居宅介護支援事業所番号();
        source.listList4_5 = date_to_string(受給者情報.get居宅サービス計画適用終了年月日());
        source.listList4_6 = date_to_string(受給者情報.get訪問通所_上限管理適用期間終了年月日());
        source.listList4_7 = date_to_string(受給者情報.get短期入所_上限管理適用期間終了年月日());
        source.listList4_8 = decimal_to_string(受給者情報.get負担額());
        source.listList4_9 = date_to_string(受給者情報.get負担額適用終了年月日());
        RString 利用者負担区分 = 受給者情報.get利用者負担区分コード();
        if (!isEmptyOrNull(利用者負担区分)) {
            source.listList5_1 = 利用者負担区分.concat(コロン)
                    .concat(JukyushaIF_RiyoshaFutanKubunCode.toValue(利用者負担区分).name());
        }
        source.listList5_2 = date_to_string(受給者情報.get利用者負担適用開始年月日());
        RString 公費負担上限額減額の有無 = 受給者情報.get公費負担上限額減額の有無();
        if (!isEmptyOrNull(公費負担上限額減額の有無)) {
            source.listList5_3 = 公費負担上限額減額の有無.concat(コロン)
                    .concat(JukyushaIF_kohiFutanJogengakuGengakuUmu.toValue(公費負担上限額減額の有無).name());
        }
        source.listList5_4 = date_to_string(受給者情報.get償還払化開始年月日());
        source.listList5_5 = date_to_string(受給者情報.get給付率引下げ開始年月日());
        RString 住所地特例区分 = 受給者情報.get住所地特例対象者区分コード();
        if (!isEmptyOrNull(住所地特例区分)) {
            source.listList5_6 = 住所地特例区分.concat(コロン)
                    .concat(JukyushaIF_JutokuJigyoKubunCode.toValue(住所地特例区分).name());
        }
        source.listList5_7 = date_to_string(受給者情報.get住所地特例適用開始年月日());
        source.listList5_8 = 受給者情報.get老人保健市町村番号();
        RString 小規模居宅サービス利用有無 = 受給者情報.get小規模居宅サービス利用有無();
        if (!isEmptyOrNull(小規模居宅サービス利用有無)) {
            source.listList5_9 = 小規模居宅サービス利用有無.concat(コロン)
                    .concat(JukyushaIF_ShokiboKyotakuServiceRIyoCode.toValue(小規模居宅サービス利用有無).name());
        }
        source.listList5_10 = date_to_string(受給者情報.get二次予防事業有効期間開始年月日());
        source.listList6_1 = decimal_to_percentStr(受給者情報.get給付率());
        source.listList6_2 = date_to_string(受給者情報.get利用者負担適用終了年月日());
        source.listList6_3 = 受給者情報.get広域連合_政令市_保険者番号();
        source.listList6_4 = date_to_string(受給者情報.get償還払化終了年月日());
        source.listList6_5 = date_to_string(受給者情報.get給付率引下げ終了年月日());
        source.listList6_6 = 受給者情報.get施設所在保険者番号();
        source.listList6_7 = date_to_string(受給者情報.get住所地特例適用終了年月日());
        source.listList6_8 = 受給者情報.get老人保健受給者番号();
        source.listList6_9 = RString.EMPTY;
        RString 二次予防事業区分コード = 受給者情報.get二次予防事業区分コード();
        if (!isEmptyOrNull(二次予防事業区分コード)) {
             source.listList6_10 = 二次予防事業区分コード.concat(コロン)
                     .concat(JukyushaIF_NijiyoboJigyoKubunCode.toValue(二次予防事業区分コード).name());
        }
        source.listList6_11 = date_to_string(受給者情報.get二次予防事業有効期間終了年月日());
        RString 特定入所者認定申請中区分 = 受給者情報.get特定入所者認定申請中区分コード();
        if (!isEmptyOrNull(特定入所者認定申請中区分)) {
            source.listList7_1 = 特定入所者認定申請中区分.concat(コロン)
                    .concat(JukyushaIF_NinteiShinseichuKubunCode.toValue(特定入所者認定申請中区分).name());
        }
        
        RString 課税層の特例減額措置対象区分 = 受給者情報.get課税層の特例減額措置対象区分();
        if (!isEmptyOrNull(課税層の特例減額措置対象区分)) {
            source.listList7_2 = 課税層の特例減額措置対象区分.concat(コロン)
                    .concat(JukyushaIF_TokureiGengakuSochiTaisho.toValue(課税層の特例減額措置対象区分).name());
        }
        source.listList7_3 = date_to_string(受給者情報.get負担限度額適用開始年月日());
        source.listList7_4 = decimal_to_string(受給者情報.get居住費_ユニット型個室_負担限度額());
        source.listList7_5 = decimal_to_string(受給者情報.get居住費_従来型個室_特養等_負担限度額());
        source.listList7_6 = decimal_to_string(受給者情報.get居住費_多床室_負担限度額());
        source.listList7_7 = decimal_to_string(受給者情報.get居住費_新２_負担限度額());
        source.listList7_8 = date_to_string(受給者情報.get二割負担適用開始年月日());
        source.listList7_9 = date_to_string(受給者情報.get軽減率適用開始年月日());
        source.listList7_10 = 受給者情報.get保険者番号_後期_();
        source.listList7_11 = 受給者情報.get保険者番号_国保_();
        source.listList7_12 = 受給者情報.get宛名番号();
        RString 特定入所者介護サービス区分 = 受給者情報.get特定入所者介護サービス区分コード();
        if (!isEmptyOrNull(特定入所者介護サービス区分)) {
            source.listList8_1 = 特定入所者介護サービス区分.concat(コロン)
                    .concat(JukyushaIF_ServiceKubunCode.toValue(特定入所者介護サービス区分).name());
        }
        source.listList8_2 = date_to_string(受給者情報.get負担限度額適用終了年月日());
        source.listList8_3 = decimal_to_string(受給者情報.get特定入所者食費負担限度額());
        source.listList8_4 = decimal_to_string(受給者情報.get居住費_ユニット型準個室_負担限度額());
        source.listList8_5 = decimal_to_string(受給者情報.get居住費_従来型個室_老健_療養等_負担限度額());
        source.listList8_6 = decimal_to_string(受給者情報.get居住費_新１_負担限度額());
        source.listList8_7 = decimal_to_string(受給者情報.get居住費_新３_負担限度額());
        source.listList8_8 = date_to_string(受給者情報.get二割負担適用終了年月日());
        source.listList8_9 = decimal_to_percentStr(受給者情報.get軽減率());
        source.listList8_10 = date_to_string(受給者情報.get軽減率適用終了年月日());
        source.listList8_11 = 受給者情報.get被保険者番号_後期_();
        source.listList8_12 = 受給者情報.get被保険者証番号_国保_();

        return source;
    }
    
    /**
     * 日付からstringに転換する。
     * 
     * @param  年月日
     *          日付
     * @return stringで表示する日付
     */
    private static RString date_to_string(FlexibleDate 年月日) {
        if (null == 年月日) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
    }
    
    /**
     * 数値からstringに転換する。
     * 
     * @param  number
     *          数値
     * @return カンマで編集した値
     */
    private static RString decimal_to_string(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }
    
    /**
     * 数値からstring(ZZ9%)に転換する。
     * 
     * @param  number
     *          数値
     * @return 「%」で付けた値
     */
    private static RString decimal_to_percentStr(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        number = number.multiply(100);
        return DecimalFormatter.toRString(number, 0).concat(パーセント);
    }
    
    /**
     * 文字列がnull或るい空文字かどうか判断する。
     * 
     * @param str 文字列
     * @return 判断結果
     */
    private static boolean isEmptyOrNull(RString str) {
        if (str == null) {
            return true;
        }
        return str.isEmpty();
    }
}
