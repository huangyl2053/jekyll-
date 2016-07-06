/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimukyokuyouichijihanteikekkahyoa4;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa3.IchijihanteikekkahyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jimukyokuyouichijihanteikekkahyo.IchijihanteikekkahyoA4ReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FillTypeFormatted;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 事務局用一次判定結果票A4のEditorです。
 *
 * @reamsid_L DBE-0150-040 lishengli
 */
public class IchijihanteikekkahyoA4Editor implements IIchijihanteikekkahyoA4Editor {

    private static final RString 品目_6月間 = new RString("品目/6月間");
    private static final RString 品目 = new RString("品目");
    private static final RString 回月 = new RString("回 /月");
    private static final RString 日月 = new RString("日 /月");
    private static final RString 住宅改修 = new RString("住宅改修                                           ：");
    private static final RString 予防サービス状況リスト = new RString("(予防サービス状況リスト)");
    private static final RString 介護予防訪問介護 = new RString("介護予防訪問介護（ホームヘルプ）・訪問型サービス   ：");
    private static final RString 介護予防訪問入浴介護 = new RString("介護予防訪問入浴介護                               ：");
    private static final RString 介護予防訪問看護 = new RString("介護予防訪問看護                                   ：");
    private static final RString 介護予防訪問リハビリテーション = new RString("介護予防訪問リハビリテーション                     ：");
    private static final RString 介護予防居宅療養管理指導 = new RString("介護予防居宅療養管理指導                           ：");
    private static final RString 介護予防通所介護 = new RString("介護予防通所介護（デイサービス）・通所型サービス   ：");
    private static final RString 介護予防通所リハビリテーション = new RString("介護予防通所リハビリテーション                     ：");
    private static final RString 介護予防短期入所生活介護 = new RString("介護予防短期入所生活介護（ショートステイ）         ：");
    private static final RString 介護予防短期入所療養介護 = new RString("介護予防短期入所療養介護                           ：");
    private static final RString 介護予防特定施設入居者生活介護 = new RString("介護予防特定施設入居者生活介護                     ：");
    private static final RString 介護予防福祉用具貸与 = new RString("介護予防福祉用具貸与                               ：");
    private static final RString 特定介護予防福祉用具販売 = new RString("特定介護予防福祉用具販売                           ：");
    private static final RString 介護予防小規模多機能型居宅介護 = new RString("介護予防小規模多機能型居宅介護                     ：");
    private static final RString 介護予防認知症対応型共同生活介護 = new RString("介護予防認知症対応型共同生活介護（グループホーム） ：");

    private static final RString 介護サービス状況リスト = new RString("(介護サービス状況リスト)");
    private static final RString 訪問介護_ホームヘルプサービス = new RString("訪問介護（ホームヘルプサービス）            ：");
    private static final RString 訪問入浴介護 = new RString("訪問入浴介護                                ：");
    private static final RString 訪問看護 = new RString("訪問看護                                    ：");
    private static final RString 訪問リハビリテーション = new RString("訪問リハビリテーション                      ：");
    private static final RString 居宅療養管理指導 = new RString("居宅療養管理指導                            ：");
    private static final RString 通所介護_デイサービス = new RString("通所介護（デイサービス）                    ：");
    private static final RString 通所リハビリテーション = new RString("通所リハビリテーション                      ：");
    private static final RString 短期入所生活介護 = new RString("短期入所生活介護（ショートステイ）          ：");
    private static final RString 短期入所療養介護 = new RString("短期入所療養介護                            ：");
    private static final RString 特定施設入居者生活介護 = new RString("特定施設入居者生活介護                      ：");
    private static final RString 福祉用具貸与 = new RString("福祉用具貸与                                ：");
    private static final RString 特定福祉用具販売 = new RString("特定福祉用具販売                            ：");
    private static final RString 夜間対応型訪問介護 = new RString("夜間対応型訪問介護                          ：");
    private static final RString 認知症対応型通所介護 = new RString("認知症対応型通所介護                        ：");
    private static final RString 小規模多機能型住宅介護 = new RString("小規模多機能型住宅介護                      ：");
    private static final RString 認知症対応型共同生活介護 = new RString("認知症対応型共同生活介護（グループホーム）　：");
    private static final RString 地域密着型特定施設入所者生活介護 = new RString("地域密着型特定施設入所者生活介護　          ：");
    private static final RString 地域密着型介護老人福祉施設入所者生活介護 = new RString("地域密着型介護老人福祉施設入所者生活介護    ：");
    private static final RString 定期巡回_随時対応型訪問介護看護 = new RString("定期巡回・随時対応型訪問介護看護　　　　　　：");
    private static final RString 看護小規模多機能型居宅介護 = new RString("看護小規模多機能型居宅介護　　　　　　　　　：");

    private final IchijihanteikekkahyoEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link IchijihanteikekkahyoEntity}
     */
    protected IchijihanteikekkahyoA4Editor(IchijihanteikekkahyoEntity item) {
        this.item = item;
    }

    @Override
    public IchijihanteikekkahyoA4ReportSource edit(IchijihanteikekkahyoA4ReportSource source) {
        return editSource(source);
    }

    private IchijihanteikekkahyoA4ReportSource editSource(IchijihanteikekkahyoA4ReportSource source) {
        source.title = item.get帳票名();
        source.gogitaiNo = item.get合議体番号();
        source.shinseiCount = item.get審査会審査順();
        source.hihokenshaKubun = item.get被保険者区分();
        source.shinseiKubun = item.get申請区分();
        source.age = get年齢(item.get年齢());
        source.seibetsu = item.get性別();
        source.shisetsuriyo = item.get現在の状況();
        source.zenZenkaiNijihanteikekka = item.get前々回要介護度();
        source.zenzenkaiYukokikan = item.get前々回認定有効期間();
        source.zZenkaiNijiKaishiYMD = item.get前々回認定有効期間開始年月日();
        source.zZenkaiNijishuryoYMD = item.get前々回認定有効期間終了年月日();
        source.zenkaiNijihanteikekka = item.get前回要介護度();
        source.zenkaiYukokikan = item.get前回認定有効期間();
        source.zenkaiNijiKaishiYMD = item.get前回認定有効期間開始年月日();
        source.zenkaiNijishuryoYMD = item.get前回認定有効期間終了年月日();
        source.zenkaiNijihanteiDATE = item.get前回認定日();
        source.zenkaiJotaizo = item.get前回状態像();
        source.kanriNo = item.get管理番号();
        source.sakuseiGengo = get元号(item.get審査会資料作成年月日());
        source.sakuseiYY = get年(item.get審査会資料作成年月日());
        source.sakuseiMM = get月(item.get審査会資料作成年月日());
        source.sakuseiDD = get日(item.get審査会資料作成年月日());
        source.shinseiGengo = get元号(item.get今回認定申請年月日());
        source.shinseiYY = get年(item.get今回認定申請年月日());
        source.shinseiMM = get月(item.get今回認定申請年月日());
        source.shinseiDD = get日(item.get今回認定申請年月日());
        source.chosaGengo = get元号(item.get今回認定調査実施年月日());
        source.chosaYY = get年(item.get今回認定調査実施年月日());
        source.chosaMM = get月(item.get今回認定調査実施年月日());
        source.chosaDD = get日(item.get今回認定調査実施年月日());
        source.shinsaGengo = get元号(item.get今回認定審査年月日());
        source.shinsaYY = get年(item.get今回認定審査年月日());
        source.shinsaMM = get月(item.get今回認定審査年月日());
        source.shinsaDD = get日(item.get今回認定審査年月日());
        source.hihokenshaName = item.get氏名();
        source.hihokenshaNo = item.get被保険者番号();
        source.hokenshaNo = item.get保険者番号();
        source.shozokuName = item.get所属();
        source.shichosonName = item.get市町村名();
        source.chosaItakusakiNo = item.get事業者番号();
        source.chosaItakusakiName = item.get事業者名();
        source.chosainNo = item.get認定調査員番号();
        source.chosainName = item.get認定調査員氏名();
        source.chosainShikaku = item.get認定調査員資格();
        source.iryokikanNo = item.get医療機関番号();
        source.iryokikanName = item.get医療機関名称();
        source.ishiNo = item.get主治医番号();
        source.ishiName = item.get主治医氏名();
        source.ichijiHanteiKekka = item.get一次判定結果();
        source.nijiHanteiKekka = RString.EMPTY;
        source.ｙukokikan = RString.EMPTY;
        source.nijihanteiKaishiYMD = RString.EMPTY;
        source.nijihanteishuryoYMD = RString.EMPTY;
        source.tokuteishippeiName = item.get特定疾病名();
        source.jotaizo = item.get状態像名称();
        source.kijunGokeiTime = item.get要介護認定等基準時間();
        source.listkijunTime_1 = item.get要介護認定等基準時間_食事();
        source.listkijunTime_2 = item.get要介護認定等基準時間_排泄();
        source.listkijunTime_3 = item.get要介護認定等基準時間_移動();
        source.listkijunTime_4 = item.get要介護認定等基準時間_清潔保持();
        source.listkijunTime_5 = item.get要介護認定等基準時間_間接();
        source.listkijunTime_6 = item.get要介護認定等基準時間_BPSD関連();
        source.listkijunTime_7 = item.get要介護認定等基準時間_機能訓練();
        source.listkijunTime_8 = item.get要介護認定等基準時間_医療関連();
        source.listkijunTime_9 = item.get要介護認定等基準時間_認知症加算();
        source.keikokuNo = item.get警告コード();
        source.listChukanhyoka_1 = item.get中間評価項目得点表第1群();
        source.listChukanhyoka_2 = item.get中間評価項目得点表第2群();
        source.listChukanhyoka_3 = item.get中間評価項目得点表第3群();
        source.listChukanhyoka_4 = item.get中間評価項目得点表第4群();
        source.listChukanhyoka_5 = item.get中間評価項目得点表第5群();
        source.chosaNinchishoJiritsudo = item.get認定調査結果認知症高齢者自立度();
        source.ikenNinchishoJiritsudo = item.get意見書認知症高齢者自立度();
        source.manzensei = item.get認知症自立度Ⅱ以上の蓋然性();
        source.jotainoanteisei = item.get状態の安定性();
        source.kyufukubun = item.get給付区分();
        source.sabisuName = item.get現在のサービス利用状況();
        if (ServiceKubunCode.予防給付サービス.get名称().equals(item.get現在のサービス利用状況())) {
            source.sabisuText = get予防サービス状況リスト();
        } else if (ServiceKubunCode.介護給付サービス.get名称().equals(item.get現在のサービス利用状況())) {
            source.sabisuText = get介護サービス状況リスト();
        } else {
            source.sabisuText = new RString("                                      (なし)");
        }
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        if (item.get申請書管理番号() == null) {
            source.shinseishoKanriNo = null;
        } else {
            source.shinseishoKanriNo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), item.get申請書管理番号());
        }
        return source;
    }

    private RString get年齢(RString 年齢) {
        RStringBuilder 年齢歳 = new RStringBuilder();
        if (!RString.isNullOrEmpty(年齢)) {
            年齢歳.append(年齢);
            年齢歳.append(new RString("歳"));
            return 年齢歳.toRString();
        }
        return RString.EMPTY;
    }

    private RString get元号(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return パターン12(年月日).getEra();
        }
        return RString.EMPTY;
    }

    private RString get年(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return パターン12(年月日).getYear();
        }
        return RString.EMPTY;
    }

    private RString get月(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return パターン12(年月日).getMonth();
        }
        return RString.EMPTY;
    }

    private RString get日(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return パターン12(年月日).getDay();
        }
        return RString.EMPTY;
    }

    private FillTypeFormatted パターン12(FlexibleDate 年月日) {
        return 年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK);
    }

    private RString get予防サービス状況リスト() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(予防サービス状況リスト);
        builder.append(System.lineSeparator());
        builder.append(介護予防訪問介護);
        builder.append(item.get介護予防訪問介護_ﾎｰﾑﾍﾙﾌﾟ_訪問型ｻｰﾋﾞｽ());
        builder.append(回月);
        builder.append(System.lineSeparator());
        builder.append(介護予防訪問入浴介護);
        builder.append(item.get介護予防訪問入浴介護());
        builder.append(回月);
        builder.append(System.lineSeparator());
        builder.append(介護予防訪問看護);
        builder.append(item.get介護予防訪問看護());
        builder.append(回月);
        builder.append(System.lineSeparator());
        builder.append(介護予防訪問リハビリテーション);
        builder.append(item.get介護予防訪問リハビリテーション());
        builder.append(回月);
        builder.append(System.lineSeparator());
        builder.append(介護予防居宅療養管理指導);
        builder.append(item.get介護予防居宅療養管理指導());
        builder.append(回月);
        builder.append(System.lineSeparator());
        builder.append(介護予防通所介護);
        builder.append(item.get介護予防通所介護_ﾃﾞｲｻｰﾋﾞｽ_通所型ｻｰﾋﾞｽ());
        builder.append(回月);
        builder.append(System.lineSeparator());
        builder.append(介護予防通所リハビリテーション);
        builder.append(item.get介護予防通所リハビリテーション());
        builder.append(回月);
        builder.append(System.lineSeparator());
        builder.append(介護予防短期入所生活介護);
        builder.append(item.get介護予防短期入所生活介護_ショートステイ());
        builder.append(日月);
        builder.append(System.lineSeparator());
        builder.append(介護予防短期入所療養介護);
        builder.append(item.get介護予防短期入所療養介護());
        builder.append(日月);
        builder.append(System.lineSeparator());
        builder.append(介護予防特定施設入居者生活介護);
        builder.append(item.get介護予防特定施設入居者生活介護());
        builder.append(日月);
        builder.append(System.lineSeparator());
        builder.append(介護予防福祉用具貸与);
        builder.append(item.get介護予防福祉用具貸与());
        builder.append(品目);
        builder.append(System.lineSeparator());
        builder.append(特定介護予防福祉用具販売);
        builder.append(item.get特定介護予防福祉用具販売());
        builder.append(品目_6月間);
        builder.append(System.lineSeparator());
        builder.append(住宅改修);
        builder.append(item.get住宅改修1());
        builder.append(System.lineSeparator());
        builder.append(特定介護予防福祉用具販売);
        builder.append(item.get特定介護予防福祉用具販売());
        builder.append(日月);
        builder.append(System.lineSeparator());
        builder.append(介護予防小規模多機能型居宅介護);
        builder.append(item.get介護予防小規模多機能型居宅介護());
        builder.append(日月);
        builder.append(System.lineSeparator());
        builder.append(介護予防認知症対応型共同生活介護);
        builder.append(item.get介護予防認知症対応型共同生活介護_グループホーム());
        builder.append(日月);
        return builder.toRString();
    }

    private RString get介護サービス状況リスト() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(介護サービス状況リスト);
        builder.append(System.lineSeparator());
        builder.append(訪問介護_ホームヘルプサービス);
        builder.append(item.get訪問介護_ホームヘルプサービス());
        builder.append(回月);
        builder.append(System.lineSeparator());
        builder.append(訪問入浴介護);
        builder.append(item.get訪問入浴介護());
        builder.append(回月);
        builder.append(System.lineSeparator());
        builder.append(訪問看護);
        builder.append(item.get訪問看護());
        builder.append(回月);
        builder.append(System.lineSeparator());
        builder.append(訪問リハビリテーション);
        builder.append(item.get訪問リハビリテーション());
        builder.append(回月);
        builder.append(System.lineSeparator());
        builder.append(居宅療養管理指導);
        builder.append(item.get居宅療養管理指導());
        builder.append(回月);
        builder.append(System.lineSeparator());
        builder.append(通所介護_デイサービス);
        builder.append(item.get通所介護_デイサービス());
        builder.append(回月);
        builder.append(System.lineSeparator());
        builder.append(通所リハビリテーション);
        builder.append(item.get通所リハビリテーション());
        builder.append(回月);
        builder.append(System.lineSeparator());
        builder.append(短期入所生活介護);
        builder.append(item.get短期入所生活介護_ショートステイ());
        builder.append(日月);
        builder.append(System.lineSeparator());
        builder.append(短期入所療養介護);
        builder.append(item.get短期入所療養介護());
        builder.append(日月);
        builder.append(System.lineSeparator());
        builder.append(特定施設入居者生活介護);
        builder.append(item.get特定施設入居者生活介護());
        builder.append(日月);
        builder.append(System.lineSeparator());
        builder.append(福祉用具貸与);
        builder.append(item.get福祉用具貸与());
        builder.append(品目);
        builder.append(System.lineSeparator());
        builder.append(特定福祉用具販売);
        builder.append(item.get特定福祉用具販売());
        builder.append(品目_6月間);
        builder.append(System.lineSeparator());
        builder.append(住宅改修);
        builder.append(item.get住宅改修2());
        builder.append(System.lineSeparator());
        builder.append(夜間対応型訪問介護);
        builder.append(item.get夜間対応型訪問介護());
        builder.append(日月);
        builder.append(System.lineSeparator());
        builder.append(認知症対応型通所介護);
        builder.append(item.get認知症対応型通所介護());
        builder.append(日月);
        builder.append(System.lineSeparator());
        builder.append(小規模多機能型住宅介護);
        builder.append(item.get小規模多機能型居宅介護());
        builder.append(日月);
        builder.append(System.lineSeparator());
        builder.append(認知症対応型共同生活介護);
        builder.append(item.get認知症対応型共同生活介護_グループホーム());
        builder.append(日月);
        builder.append(System.lineSeparator());
        builder.append(地域密着型特定施設入所者生活介護);
        builder.append(item.get地域密着型特定施設入居者生活介護());
        builder.append(日月);
        builder.append(System.lineSeparator());
        builder.append(地域密着型介護老人福祉施設入所者生活介護);
        builder.append(item.get地域密着型介護老人福祉施設入所者生活介護());
        builder.append(日月);
        builder.append(System.lineSeparator());
        builder.append(定期巡回_随時対応型訪問介護看護);
        builder.append(item.get定期巡回_随時対応型訪問介護看護());
        builder.append(回月);
        builder.append(System.lineSeparator());
        builder.append(看護小規模多機能型居宅介護);
        builder.append(item.get看護小規模多機能型居宅介護());
        builder.append(日月);
        return builder.toRString();
    }
}
