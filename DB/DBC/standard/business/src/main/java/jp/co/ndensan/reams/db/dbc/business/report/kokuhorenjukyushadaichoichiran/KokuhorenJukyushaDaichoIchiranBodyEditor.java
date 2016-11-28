/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kokuhorenjukyushadaichoichiran;

import jp.co.ndensan.reams.db.dbc.business.report.util.ReportKomokuEditorUtil;
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
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_TokureiGengakuSochiTaisho;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_kohiFutanJogengakuGengakuUmu;
import jp.co.ndensan.reams.db.dbc.entity.csv.kokuhorenjukyushain.DbWT0001DbWT5331Entity;
import jp.co.ndensan.reams.db.dbc.entity.report.jukyushakoshinkekkaichiran.JukyushaKoshinkekkaIchiranSource;
import jp.co.ndensan.reams.db.dbz.definition.core.IYokaigoJotaiKubun;
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
 * 帳票設計_DBC200006_受給者台帳（一覧表）BodyEditor
 *
 * @reamsid_L DBC-2740-010 fuyanling
 */
public class KokuhorenJukyushaDaichoIchiranBodyEditor
        implements IKokuhoernJukyushaDaichoIchiranEditor {

    private final DbWT0001DbWT5331Entity 対象データ;
    private final RString 編集住所;

    private static final RString コロン = new RString("：");
    private static final RString 百分率 = new RString("%");

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ DbWT0001DbWT5331Entity
     * @param 編集住所 RString
     */
    public KokuhorenJukyushaDaichoIchiranBodyEditor(DbWT0001DbWT5331Entity 帳票出力対象データ,
            RString 編集住所) {
        this.対象データ = 帳票出力対象データ;
        this.編集住所 = 編集住所;
    }

    @Override
    public JukyushaKoshinkekkaIchiranSource edit(JukyushaKoshinkekkaIchiranSource source) {

        source.listList1_1 = doパターン4(対象データ.get訂正年月日());
        source.listList1_2 = doパターン4(対象データ.get異動年月日());
        if (!RString.isNullOrEmpty(対象データ.get異動区分コード())) {
            source.listList1_3 = JukyushaIF_IdoKubunCode.toValue(対象データ.get異動区分コード()).get名称();
        }
        if (null != 対象データ.get登録被保険者番号()) {
            source.listList1_4 = 対象データ.get登録被保険者番号().getColumnValue();
        } else {
            source.listList1_4 = RString.EMPTY;
        }
        source.listList1_5 = 対象データ.get宛名カナ名称();
        source.listList1_6 = 対象データ.get行政区コード();
        source.listList1_7 = 対象データ.get行政区名();
        source.listList1_8 = doパターン4(対象データ.get生年月日());
        source.listList1_9 = doパターン4(対象データ.get資格取得年月日());
        source.listList2_1 = RString.EMPTY;
        if (!RString.isNullOrEmpty(対象データ.get異動事由区分())) {
            source.listList2_2 = JukyushaIF_JukyushaIdoJiyu.toValue(対象データ.get異動事由区分()).get名称();
        }
        source.listList2_3 = 対象データ.get宛名名称();
        source.listList2_4 = 対象データ.get町域コード();
        source.listList2_5 = this.編集住所;
        if (!RString.isNullOrEmpty(対象データ.get性別コード())) {
            source.listList2_6 = 対象データ.get性別コード().concat(コロン)
                    .concat(Seibetsu.toValue(対象データ.get性別コード()).name());
        }
        source.listList2_7 = doパターン4(対象データ.get資格喪失年月日());
        if (!RString.isNullOrEmpty(対象データ.getみなし要介護区分コード())) {
            source.listList3_1 = 対象データ.getみなし要介護区分コード().concat(コロン)
                    .concat(MinashiCode.toValue(対象データ.getみなし要介護区分コード()).get名称());
        }
        source.listList3_2 = doパターン4(対象データ.get認定有効期間開始年月日());
        if (!RString.isNullOrEmpty(対象データ.get申請種別コード())) {
            source.listList3_3 = 対象データ.get申請種別コード().concat(コロン)
                    .concat(JukyushaIF_ShinseiShubetsuCode.toValue(対象データ.get申請種別コード()).name());
        }
        source.listList3_4 = doパターン4(対象データ.get申請年月日());
        if (!RString.isNullOrEmpty(対象データ.get居宅サービス計画作成区分コード())) {
            source.listList3_5 = 対象データ.get居宅サービス計画作成区分コード().concat(コロン)
                    .concat(JukyushaIF_KeikakuSakuseiKubunCode.toValue(対象データ
                                    .get居宅サービス計画作成区分コード()).name());
        }
        source.listList3_6 = doパターン4(対象データ.get居宅サービス計画適用開始年月日());
        source.listList3_7 = doカンマ編集(対象データ.get訪問通所支給限度基準額());
        source.listList3_8 = doパターン4(対象データ.get訪問通所上限管理適用期間開始年月日());
        source.listList3_9 = doカンマ編集(対象データ.get短期入所支給限度基準額());
        source.listList3_10 = doパターン4(対象データ.get短期入所上限管理適用期間開始年月日());
        if (!RString.isNullOrEmpty(対象データ.get標準負担区分コード())) {
            source.listList3_11 = 対象データ.get標準負担区分コード().concat(コロン)
                    .concat(JukyushaIF_HyojunFutanKubunCode.toValue(対象データ.get標準負担区分コード()).name());
        }
        source.listList3_12 = doパターン4(対象データ.get負担額適用開始年月日());
        if (!RString.isNullOrEmpty(対象データ.get減免申請中区分コード())) {
            source.listList3_13 = 対象データ.get減免申請中区分コード().concat(コロン)
                    .concat(JukyushaIF_GemmenShinseichuKubunCode.toValue(対象データ.get減免申請中区分コード()).name());
        }
        if (null != 対象データ.getサービス提供年月末日() && !RString.isNullOrEmpty(対象データ.get要介護状態区分コード())) {
            IYokaigoJotaiKubun support = YokaigoJotaiKubunSupport.toValue(対象データ
                    .getサービス提供年月末日().getYearMonth(), 対象データ.get要介護状態区分コード());
            source.listList4_1 = support.getName();
        }
        source.listList4_2 = doパターン4(対象データ.get認定有効期間終了年月日());
        source.listList4_4 = 対象データ.get居宅介護支援事業所番号();
        source.listList4_5 = doパターン4(対象データ.get居宅サービス計画適用終了年月日());
        source.listList4_6 = doパターン4(対象データ.get訪問通所上限管理適用期間終了年月日());
        source.listList4_7 = doパターン4(対象データ.get短期入所上限管理適用期間終了年月日());
        source.listList4_8 = doカンマ編集(対象データ.get負担額());
        source.listList4_9 = doパターン4(対象データ.get負担額適用終了年月日());
        source.listList5_2 = doパターン4(対象データ.get利用者負担適用開始年月日());
        source.listList5_4 = doパターン4(対象データ.get償還払化開始年月日());
        source.listList5_5 = doパターン4(対象データ.get給付率引下げ開始年月日());
        source.listList5_7 = doパターン4(対象データ.get住所地特例適用開始年月日());
        source.listList5_8 = 対象データ.get老人保健市町村番号();
        source.listList5_9 = doパターン4(対象データ.get二次予防事業有効期間開始年月日());
        if (null != 対象データ.get給付率()) {
            source.listList6_1 = new RString(対象データ.get給付率().toString()).concat(百分率);
        }
        source.listList6_2 = doパターン4(対象データ.get利用者負担適用終了年月日());
        source.listList6_3 = 対象データ.get広域連合政令市保険者番号();
        source.listList6_4 = doパターン4(対象データ.get償還払化終了年月日());
        source.listList6_5 = doパターン4(対象データ.get給付率引下げ終了年月日());
        source.listList6_6 = 対象データ.get施設所在保険者番号();
        source.listList6_7 = doパターン4(対象データ.get住所地特例適用終了年月日());
        source.listList6_8 = 対象データ.get老人保健受給者番号();
        source.listList6_11 = doパターン4(対象データ.get二次予防事業有効期間終了年月日());
        source.listList7_3 = doパターン4(対象データ.get負担限度額適用開始年月日());
        source.listList7_4 = doカンマ編集(対象データ.get居住費ユニット型個室負担限度額());
        source.listList7_5 = doカンマ編集(対象データ.get居住費従来型個室特養等負担限度額());
        source.listList7_6 = doカンマ編集(対象データ.get居住費多床室負担限度額());
        source.listList7_7 = doカンマ編集(対象データ.get居住費新２負担限度額());
        source.listList7_8 = doパターン4(対象データ.get二割負担適用開始年月日());
        source.listList7_9 = doパターン4(対象データ.get軽減率適用開始年月日());
        source.listList7_10 = 対象データ.get保険者番号後期();
        source.listList7_11 = 対象データ.get保険者番号国保();
        source.listList7_12 = 対象データ.get宛名番号();
        source.listList8_2 = doパターン4(対象データ.get負担限度額適用終了年月日());
        source.listList8_3 = doカンマ編集(対象データ.get特定入所者食費負担限度額());
        source.listList8_4 = doカンマ編集(対象データ.get居住費ユニット型準個室負担限度額());
        source.listList8_5 = doカンマ編集(対象データ.get居住費従来型個室老健療養等負担限度額());
        source.listList8_6 = doカンマ編集(対象データ.get居住費新１負担限度額());
        source.listList8_7 = doカンマ編集(対象データ.get居住費新３負担限度額());
        source.listList8_8 = doパターン4(対象データ.get二割負担終了開始年月日());
        if (null != 対象データ.get軽減率()) {
            source.listList8_9 = new RString(対象データ.get軽減率().toString()).concat(百分率);
        }
        source.listList8_10 = doパターン4(対象データ.get軽減率適用終了年月日());
        source.listList8_11 = 対象データ.get被保険者番号後期();
        source.listList8_12 = 対象データ.get被保険者証番号国保();
        名称項目編集(source);
        source.yubinNo = getNotNull(対象データ.get郵便番号());
        source.choikiCode = getNotNull(対象データ.get町域コード());
        source.gyoseikuCode = getNotNull(対象データ.get行政区コード());
        source.shimei50onKana = getNotNull(対象データ.get氏名50音カナ());
        source.shichosonCode = 対象データ.get市町村コード();
        if (!RString.isNullOrEmpty(対象データ.get識別コード())) {
            source.shikibetuCode = new ShikibetsuCode(対象データ.get識別コード());
        }
        source.拡張情報 = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                ReportKomokuEditorUtil.get非空文字列(source.listList1_4));
        setPageBreakEmpty(source);
        return source;
    }

    private void setPageBreakEmpty(JukyushaKoshinkekkaIchiranSource source) {
        if (source.listList2_4 == null) {
            source.listList2_4 = RString.EMPTY;
        }
        if (source.listList1_6 == null) {
            source.listList1_6 = RString.EMPTY;
        }
        if (source.shichosonCode == null) {
            source.shichosonCode = LasdecCode.EMPTY;
        }
    }

    private void 名称項目編集(JukyushaKoshinkekkaIchiranSource source) {
        if (!RString.isNullOrEmpty(対象データ.get変更申請中区分コード())) {
            source.listList4_3 = 対象データ.get変更申請中区分コード().concat(コロン)
                    .concat(JukyushaIF_HenkoShinseichuKubunCode.toValue(対象データ
                                    .get変更申請中区分コード()).name());
        }
        if (!RString.isNullOrEmpty(対象データ.get利用者負担区分コード())) {
            source.listList5_1 = 対象データ.get利用者負担区分コード().concat(コロン)
                    .concat(JukyushaIF_RiyoshaFutanKubunCode.toValue(対象データ
                                    .get利用者負担区分コード()).name());
        }
        if (!RString.isNullOrEmpty(対象データ.get公費負担上限額減額の有無())) {
            source.listList5_3 = 対象データ.get公費負担上限額減額の有無().concat(コロン)
                    .concat(JukyushaIF_kohiFutanJogengakuGengakuUmu.toValue(対象データ
                                    .get公費負担上限額減額の有無()).name());
        }
        if (!RString.isNullOrEmpty(対象データ.get住所地特例対象者区分コード())) {
            source.listList5_6 = 対象データ.get住所地特例対象者区分コード().concat(コロン)
                    .concat(JukyushaIF_JutokuJigyoKubunCode.toValue(対象データ.get住所地特例対象者区分コード()).name());
        }
        if (!RString.isNullOrEmpty(対象データ.get小規模居宅サービス利用有無())) {
            source.listList5_9 = 対象データ.get小規模居宅サービス利用有無().concat(コロン)
                    .concat(JukyushaIF_ShokiboKyotakuServiceRIyoCode.toValue(対象データ
                                    .get小規模居宅サービス利用有無()).name());
        }
        if (!RString.isNullOrEmpty(対象データ.get二次予防事業区分コード())) {
            source.listList6_10 = 対象データ.get二次予防事業区分コード().concat(コロン)
                    .concat(JukyushaIF_NijiyoboJigyoKubunCode
                            .toValue(対象データ.get二次予防事業区分コード()).name());
        }
        if (!RString.isNullOrEmpty(対象データ.get二次予防事業区分コード())) {
            source.listList6_10 = 対象データ.get二次予防事業区分コード().concat(コロン)
                    .concat(JukyushaIF_NijiyoboJigyoKubunCode
                            .toValue(対象データ.get二次予防事業区分コード()).name());
        }
        if (!RString.isNullOrEmpty(対象データ.get特定入所者認定申請中区分コード())) {
            source.listList7_1 = 対象データ.get特定入所者認定申請中区分コード().concat(コロン)
                    .concat(JukyushaIF_NinteiShinseichuKubunCode
                            .toValue(対象データ.get特定入所者認定申請中区分コード()).name());
        }
        if (!RString.isNullOrEmpty(対象データ.get課税層の特例減額措置対象区分())) {
            source.listList7_2 = 対象データ.get課税層の特例減額措置対象区分().concat(コロン)
                    .concat(JukyushaIF_TokureiGengakuSochiTaisho.toValue(対象データ
                                    .get課税層の特例減額措置対象区分()).name());
        }
        if (!RString.isNullOrEmpty(対象データ.get特定入所者介護サービス区分コード())) {
            source.listList8_1 = 対象データ.get特定入所者介護サービス区分コード().concat(コロン)
                    .concat(JukyushaIF_ServiceKubunCode.toValue(対象データ.get特定入所者介護サービス区分コード()).name());
        }
    }

    private RString doパターン4(RString 年月日) {
        if (null == 年月日) {
            return RString.EMPTY;
        }
        if (FlexibleDate.canConvert(年月日)) {
            return new FlexibleDate(年月日).wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD)
                    .fillType(FillType.BLANK).toDateString();
        }
        return 年月日;
    }

    private RString doパターン4(FlexibleDate 年月日) {
        if (null == 年月日) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
    }

    private RString doカンマ編集(RString number) {
        if (null == number) {
            return RString.EMPTY;
        }
        if (Decimal.canConvert(number)) {
            return DecimalFormatter.toコンマ区切りRString(new Decimal(number.toString()), 0);
        }
        return number;
    }

    private RString getNotNull(RString str) {
        if (RString.isNullOrEmpty(str)) {
            return RString.EMPTY;
        }
        return str;
    }

}
