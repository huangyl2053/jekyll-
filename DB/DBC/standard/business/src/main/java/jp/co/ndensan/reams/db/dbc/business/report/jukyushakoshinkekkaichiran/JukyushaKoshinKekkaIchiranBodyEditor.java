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
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_TsugoKekkaKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_kohiFutanJogengakuGengakuUmu;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushakoshinkekka.DbWT5331JukyushaJohoCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushajoho.JukyushaHihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushakoshinkekkaichiran.JukyushaKoshinKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.MinashiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
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
    private static final int 住所最大桁数 = 15;
    private final RString 帳票ID;
    private final RString 帳票DBC200006 = new RString("DBC200006_KokuhorenJukyushaDaichoIchiran");
    private final RString 帳票DBC200055 = new RString("DBC200055_JukyushaKoshinkekkaIchiran");
    private final RString 帳票DBC200058 = new RString("DBC200058_JukyushaTotsugokekkaIchiran");
    private static final RString 被保険者番号 = new RString("被保険者番号");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ JukyushaHihokenshaEntity
     * @param 住所情報 RString
     * @param 帳票ID RString
     */
    public JukyushaKoshinKekkaIchiranBodyEditor(JukyushaHihokenshaEntity 帳票出力対象データ, RString 住所情報, RString 帳票ID) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.住所情報 = 住所情報;
        this.帳票ID = 帳票ID;
    }

    @Override
    public JukyushaKoshinKekkaIchiranSource edit(JukyushaKoshinKekkaIchiranSource source) {
        DbWT5331JukyushaJohoCsvEntity 受給者情報 = 帳票出力対象データ.get受給者情報明細一時();
        DbWT0001HihokenshaTempEntity 被保険者情報 = 帳票出力対象データ.get被保険者一時();
        if (帳票DBC200006.equals(帳票ID) || 帳票DBC200055.equals(帳票ID)) {
            source.listList1_1 = date_to_string(受給者情報.get訂正年月日());
        } else if (帳票DBC200058.equals(帳票ID)) {
            RString 突合結果名称 = JukyushaIF_TsugoKekkaKubun.toValue(受給者情報.get突合結果区分()).get名称();
            source.listList1_1 = 受給者情報.get突合結果区分().concat(コロン).concat(突合結果名称);
        }
        if (被保険者情報.get登録被保険者番号() != null) {
            source.listList1_4 = 被保険者情報.get登録被保険者番号().getColumnValue();
        } else {
            source.listList1_4 = RString.EMPTY;
        }
        source.expandedInformation = new ExpandedInformation(new Code("0003"), 被保険者番号,
                source.listList1_4);
        source.listList1_5 = 被保険者情報.get宛名カナ名称();
        source.listList1_6 = 被保険者情報.get行政区コード();
        source.listList1_7 = 被保険者情報.get行政区名();
        source.listList2_3 = 被保険者情報.get宛名名称();
        source.listList2_4 = 被保険者情報.get町域コード();
        if (this.住所情報 != null && 住所最大桁数 < this.住所情報.length()) {
            source.listList2_5 = this.住所情報.substring(0, 住所最大桁数);
        } else {
            source.listList2_5 = this.住所情報;
        }
        source.listList4_4 = 受給者情報.get居宅介護支援事業所番号();
        source.listList5_8 = 受給者情報.get老人保健市町村番号();
        source.listList6_3 = 受給者情報.get広域連合_政令市_保険者番号();
        source.listList6_6 = 受給者情報.get施設所在保険者番号();
        source.listList6_8 = 受給者情報.get老人保健受給者番号();
        source.listList6_9 = RString.EMPTY;
        source.listList7_10 = 受給者情報.get保険者番号_後期_();
        source.listList7_11 = 受給者情報.get保険者番号_国保_();
        source.listList7_12 = 受給者情報.get宛名番号();
        source.listList8_12 = 受給者情報.get被保険者番号_後期_();
        source.listList8_13 = 受給者情報.get被保険者証番号_国保_();
        source.listList8_12 = 受給者情報.get被保険者番号_後期_();
        source.listList8_13 = 受給者情報.get被保険者証番号_国保_();
        source.yubinNo = getNotNull(被保険者情報.get郵便番号());
        source.choikiCode = getNotNull(被保険者情報.get町域コード());
        source.gyoseikuCode = getNotNull(被保険者情報.get行政区コード());
        source.shimei50onKana = getNotNull(被保険者情報.get氏名50音カナ());
        if (被保険者情報.get市町村コード() != null) {
            source.shichosonCode = 被保険者情報.get市町村コード();
        } else {
            source.shichosonCode = LasdecCode.EMPTY;
        }
        if (!RString.isNullOrEmpty(被保険者情報.get識別コード())) {
            source.shikibetuCode = new ShikibetsuCode(被保険者情報.get識別コード());
        }
        this.コード項目設定1(source);
        this.コード項目設定2(source);
        this.日付項目設定(source);
        this.数値項目設定(source);
        return source;
    }

    /**
     * 帳票のコード項目を設定する。
     *
     * @param source 受給者情報更新結果情報取込一覧表帳票ソース
     */
    private void コード項目設定1(JukyushaKoshinKekkaIchiranSource source) {
        DbWT5331JukyushaJohoCsvEntity 受給者情報 = 帳票出力対象データ.get受給者情報明細一時();
        RString 異動区分コード = 受給者情報.get異動区分コード();
        if (!RString.isNullOrEmpty(異動区分コード)) {
            source.listList1_3 = 異動区分コード.concat(コロン)
                    .concat(JukyushaIF_IdoKubunCode.toValue(異動区分コード).name());
        }
        RString 訂正区分コード = 受給者情報.get訂正区分コード();
        if (!RString.isNullOrEmpty(訂正区分コード)) {
            source.listList2_1 = 訂正区分コード.concat(コロン)
                    .concat(JukyushaIF_TeiseiKubunCode.toValue(訂正区分コード).name());
        }

        RString 異動事由区分 = 受給者情報.get異動事由区分();
        if (!RString.isNullOrEmpty(異動事由区分)) {
            source.listList2_2 = 異動事由区分.concat(コロン)
                    .concat(JukyushaIF_JukyushaIdoJiyu.toValue(異動事由区分).name());
        }

        RString 性別コード = 受給者情報.get性別コード();
        if (!RString.isNullOrEmpty(性別コード)) {
            source.listList2_6 = 性別コード.concat(コロン)
                    .concat(Seibetsu.toValue(性別コード).name());
        }
        RString みなし要介護区分コード = 受給者情報.getみなし要介護区分コード();
        if (!RString.isNullOrEmpty(みなし要介護区分コード)) {
            source.listList3_1 = みなし要介護区分コード.concat(コロン)
                    .concat(MinashiCode.toValue(みなし要介護区分コード).name());
        }
        RString 申請種別コード = 受給者情報.get申請種別コード();
        if (!RString.isNullOrEmpty(申請種別コード)) {
            source.listList3_3 = 申請種別コード.concat(コロン)
                    .concat(JukyushaIF_ShinseiShubetsuCode.toValue(申請種別コード).name());
        }
        RString 計画作成区分 = 受給者情報.get居宅サービス計画作成区分コード();
        if (!RString.isNullOrEmpty(計画作成区分)) {
            source.listList3_5 = 計画作成区分.concat(コロン)
                    .concat(JukyushaIF_KeikakuSakuseiKubunCode.toValue(計画作成区分).name());
        }
        RString 標準負担区分 = 受給者情報.get標準負担区分コード();
        if (!RString.isNullOrEmpty(標準負担区分)) {
            source.listList3_11 = 標準負担区分.concat(コロン)
                    .concat(JukyushaIF_HyojunFutanKubunCode.toValue(標準負担区分).name());
        }
    }

    /**
     * 帳票のコード項目を設定する。
     *
     * @param source 受給者情報更新結果情報取込一覧表帳票ソース
     */
    private void コード項目設定2(JukyushaKoshinKekkaIchiranSource source) {
        DbWT5331JukyushaJohoCsvEntity 受給者情報 = 帳票出力対象データ.get受給者情報明細一時();
        DbWT0001HihokenshaTempEntity 被保険者情報 = 帳票出力対象データ.get被保険者一時();
        RString 減免中区分 = 受給者情報.get減免申請中区分コード();
        if (!RString.isNullOrEmpty(減免中区分)) {
            source.listList3_13 = 減免中区分.concat(コロン)
                    .concat(JukyushaIF_GemmenShinseichuKubunCode.toValue(減免中区分).name());
        }
        RString 要介護区分 = 受給者情報.get要介護状態区分コード();
        if (!RString.isNullOrEmpty(要介護区分) && 被保険者情報.getサービス提供年月末日() != null) {
            source.listList4_1 = 要介護区分.concat(コロン).concat(YokaigoJotaiKubunSupport
                    .toValue(被保険者情報.getサービス提供年月末日().getYearMonth(), 要介護区分).getName());
        }
        RString 変更申請区分 = 受給者情報.get変更申請中区分コード();
        if (!RString.isNullOrEmpty(変更申請区分)) {
            source.listList4_3 = 変更申請区分.concat(コロン)
                    .concat(JukyushaIF_HenkoShinseichuKubunCode.toValue(変更申請区分).name());
        }
        RString 利用者負担区分 = 受給者情報.get利用者負担区分コード();
        if (!RString.isNullOrEmpty(利用者負担区分)) {
            source.listList5_1 = 利用者負担区分.concat(コロン)
                    .concat(JukyushaIF_RiyoshaFutanKubunCode.toValue(利用者負担区分).name());
        }
        RString 公費負担上限額減額の有無 = 受給者情報.get公費負担上限額減額の有無();
        if (!RString.isNullOrEmpty(公費負担上限額減額の有無)) {
            source.listList5_3 = 公費負担上限額減額の有無.concat(コロン)
                    .concat(JukyushaIF_kohiFutanJogengakuGengakuUmu.toValue(公費負担上限額減額の有無).name());
        }
        RString 住所地特例区分 = 受給者情報.get住所地特例対象者区分コード();
        if (!RString.isNullOrEmpty(住所地特例区分)) {
            source.listList5_6 = 住所地特例区分.concat(コロン)
                    .concat(JukyushaIF_JutokuJigyoKubunCode.toValue(住所地特例区分).name());
        }
        RString 小規模居宅サービス利用有無 = 受給者情報.get小規模居宅サービス利用有無();
        if (!RString.isNullOrEmpty(小規模居宅サービス利用有無)) {
            source.listList5_9 = 小規模居宅サービス利用有無.concat(コロン)
                    .concat(JukyushaIF_ShokiboKyotakuServiceRIyoCode.toValue(小規模居宅サービス利用有無).name());
        }
        RString 二次予防事業区分コード = 受給者情報.get二次予防事業区分コード();
        if (!RString.isNullOrEmpty(二次予防事業区分コード)) {
            source.listList6_10 = 二次予防事業区分コード.concat(コロン)
                    .concat(JukyushaIF_NijiyoboJigyoKubunCode.toValue(二次予防事業区分コード).name());
        }
        RString 特定入所者認定申請中区分 = 受給者情報.get特定入所者認定申請中区分コード();
        if (!RString.isNullOrEmpty(特定入所者認定申請中区分)) {
            source.listList7_1 = 特定入所者認定申請中区分.concat(コロン)
                    .concat(JukyushaIF_NinteiShinseichuKubunCode.toValue(特定入所者認定申請中区分).name());
        }
        RString 課税層の特例減額措置対象区分 = 受給者情報.get課税層の特例減額措置対象区分();
        if (!RString.isNullOrEmpty(課税層の特例減額措置対象区分)) {
            source.listList7_2 = 課税層の特例減額措置対象区分.concat(コロン)
                    .concat(JukyushaIF_TokureiGengakuSochiTaisho.toValue(課税層の特例減額措置対象区分).name());
        }
        RString 特定入所者介護サービス区分 = 受給者情報.get特定入所者介護サービス区分コード();
        if (!RString.isNullOrEmpty(特定入所者介護サービス区分)) {
            source.listList8_1 = 特定入所者介護サービス区分.concat(コロン)
                    .concat(JukyushaIF_ServiceKubunCode.toValue(特定入所者介護サービス区分).name());
        }
    }

    /**
     * 帳票の日付項目を設定する。
     *
     * @param source 受給者情報更新結果情報取込一覧表帳票ソース
     */
    private void 日付項目設定(JukyushaKoshinKekkaIchiranSource source) {
        DbWT5331JukyushaJohoCsvEntity 受給者情報 = 帳票出力対象データ.get受給者情報明細一時();
        source.listList1_2 = date_to_string(受給者情報.get異動年月日());
        source.listList1_8 = date_to_string(受給者情報.get生年月日());
        source.listList1_9 = date_to_string(受給者情報.get資格取得年月日());
        source.listList2_7 = date_to_string(受給者情報.get資格喪失年月日());
        source.listList3_2 = date_to_string(受給者情報.get認定有効期間開始年月日());
        source.listList3_4 = date_to_string(受給者情報.get申請年月日());
        source.listList3_6 = date_to_string(受給者情報.get居宅サービス計画適用開始年月日());
        source.listList3_8 = date_to_string(受給者情報.get訪問通所_上限管理適用期間開始年月日());
        source.listList3_10 = date_to_string(受給者情報.get短期入所_上限管理適用期間開始年月日());
        source.listList3_12 = date_to_string(受給者情報.get負担額適用開始年月日());
        source.listList4_2 = date_to_string(受給者情報.get認定有効期間終了年月日());
        source.listList4_5 = date_to_string(受給者情報.get居宅サービス計画適用終了年月日());
        source.listList4_6 = date_to_string(受給者情報.get訪問通所_上限管理適用期間終了年月日());
        source.listList4_7 = date_to_string(受給者情報.get短期入所_上限管理適用期間終了年月日());
        source.listList4_9 = date_to_string(受給者情報.get負担額適用終了年月日());
        source.listList5_2 = date_to_string(受給者情報.get利用者負担適用開始年月日());
        source.listList5_4 = date_to_string(受給者情報.get償還払化開始年月日());
        source.listList5_5 = date_to_string(受給者情報.get給付率引下げ開始年月日());
        source.listList5_7 = date_to_string(受給者情報.get住所地特例適用開始年月日());
        source.listList5_10 = date_to_string(受給者情報.get二次予防事業有効期間開始年月日());
        source.listList6_2 = date_to_string(受給者情報.get利用者負担適用終了年月日());
        source.listList6_4 = date_to_string(受給者情報.get償還払化終了年月日());
        source.listList6_5 = date_to_string(受給者情報.get給付率引下げ終了年月日());
        source.listList6_7 = date_to_string(受給者情報.get住所地特例適用終了年月日());
        source.listList6_11 = date_to_string(受給者情報.get二次予防事業有効期間終了年月日());
        source.listList7_3 = date_to_string(受給者情報.get負担限度額適用開始年月日());
        source.listList7_8 = date_to_string(受給者情報.get二割負担適用開始年月日());
        source.listList7_9 = date_to_string(受給者情報.get軽減率適用開始年月日());
        source.listList8_2 = date_to_string(受給者情報.get負担限度額適用終了年月日());
        source.listList8_9 = date_to_string(受給者情報.get二割負担適用終了年月日());
        source.listList8_11 = date_to_string(受給者情報.get軽減率適用終了年月日());
    }

    /**
     * 帳票の数値項目を設定する。
     *
     * @param source 受給者情報更新結果情報取込一覧表帳票ソース
     */
    private void 数値項目設定(JukyushaKoshinKekkaIchiranSource source) {
        DbWT5331JukyushaJohoCsvEntity 受給者情報 = 帳票出力対象データ.get受給者情報明細一時();
        source.listList3_7 = decimal_to_string(受給者情報.get訪問通所_支給限度基準額());
        source.listList3_9 = decimal_to_string(受給者情報.get短期入所_支給限度基準額());
        source.listList4_8 = decimal_to_string(受給者情報.get負担額());
        source.listList6_1 = decimal_to_percentStr(受給者情報.get給付率());
        source.listList7_4 = decimal_to_string(受給者情報.get居住費_ユニット型個室_負担限度額());
        source.listList7_5 = decimal_to_string(受給者情報.get居住費_従来型個室_特養等_負担限度額());
        source.listList7_6 = decimal_to_string(受給者情報.get居住費_多床室_負担限度額());
        source.listList7_7 = decimal_to_string(受給者情報.get居住費_新２_負担限度額());
        source.listList8_3 = decimal_to_string(受給者情報.get特定入所者食費負担限度額());
        source.listList8_4 = decimal_to_string(受給者情報.get居住費_ユニット型準個室_負担限度額());
        source.listList8_5 = decimal_to_string(受給者情報.get居住費_従来型個室_老健_療養等_負担限度額());
        source.listList8_6 = decimal_to_string(受給者情報.get居住費_新１_負担限度額());
        source.listList8_7 = decimal_to_string(受給者情報.get居住費_新３_負担限度額());
        source.listList8_8 = RString.EMPTY;
        source.listList8_10 = decimal_to_percentStr(受給者情報.get軽減率());
    }

    /**
     * 日付からstringに転換する。
     *
     * @param 年月日 日付
     * @return stringで表示する日付
     */
    private static RString date_to_string(FlexibleDate 年月日) {
        if (null == 年月日) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
    }

    private static RString date_to_string(RString 年月日) {
        if (null == 年月日) {
            return RString.EMPTY;
        }
        if (FlexibleDate.canConvert(年月日)) {
            if (new FlexibleDate(年月日).isWareki()) {
                return new FlexibleDate(年月日).wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                        .fillType(FillType.BLANK).toDateString();
            }
        }
        return 年月日;
    }

    /**
     * 数値からstringに転換する。
     *
     * @param number 数値
     * @return カンマで編集した値
     */
    private static RString decimal_to_string(RString number) {
        if (null == number) {
            return RString.EMPTY;
        }
        if (Decimal.canConvert(number)) {
            return DecimalFormatter.toコンマ区切りRString(new Decimal(number.toString()), 0);
        }
        return number;
    }

    /**
     * 数値からstring(ZZ9%)に転換する。
     *
     * @param number 数値
     * @return 「%」で付けた値
     */
    private static RString decimal_to_percentStr(RString number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return number.concat(パーセント);
    }

    private RString getNotNull(RString str) {
        if (RString.isNullOrEmpty(str)) {
            return RString.EMPTY;
        }
        return str;
    }
}
