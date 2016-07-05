/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ichijihanteikekkahyoa4;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa3.IchijihanteikekkahyoA4ReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa3.IchijihanteikekkahyoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 委員用一次判定結果票A4のEditorです。
 *
 * @reamsid_L DBE-0150-130 lishengli
 */
public class IchijihanteikekkahyoA4Editor implements IIchijihanteikekkahyoA4Editor {

    private static final int INT_4 = 4;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final int INT_8 = 8;
    private static final int INT_10 = 10;
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
        source.zenZenkaiNijihanteikekka1 = item.get前々回要介護度();
        source.zenzenkaiYukokikan = item.get前々回認定有効期間();
        source.zZenkaiNijiKaishiYMD = item.get前々回認定有効期間開始年月日();
        source.zZenkaiNijishuryoYMD = item.get前々回認定有効期間終了年月日();
        source.zenkaiNijihanteikekka = item.get前回要介護度();
        source.zenkaiYukokikan = item.get前回認定有効期間();
        source.zenkaiNijiKaishiYMD = item.get前回認定有効期間開始年月日();
        source.zenkaiNijishuryoYMD = item.get前回認定有効期間終了年月日();
        source.zenkaiNijihanteiDATE1 = item.get前回認定日();
        source.zenkaiJotaizo = item.get前回状態像();
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
        source.ichijiHanteiKekka = item.get一次判定結果();
        source.tokuteishippeiName = item.get特定疾病名();
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
        年齢歳.append(年齢);
        年齢歳.append(new RString("歳"));
        return 年齢歳.toRString();
    }

    private RString get元号(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return パターン12(年月日).substring(0, 2);
        }
        return RString.EMPTY;
    }

    private RString get年(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return パターン12(年月日).substring(2, INT_4);
        }
        return RString.EMPTY;
    }

    private RString get月(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return パターン12(年月日).substring(INT_6, INT_7);
        }
        return RString.EMPTY;
    }

    private RString get日(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return パターン12(年月日).substring(INT_8, INT_10);
        }
        return RString.EMPTY;
    }

    private RString パターン12(FlexibleDate 年月日) {
        return 年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }
}
