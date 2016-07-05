/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ichijihanteikekkahyoa3;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa3.IchijihanteikekkahyoA3ReportSource;
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
 * 委員用一次判定結果票A3のEditorです。
 *
 * @reamsid_L DBE-0150-130 lishengli
 */
public class IchijihanteikekkahyoA3Editor implements IIchijihanteikekkahyoA3Editor {

    private final IchijihanteikekkahyoEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link IchijihanteikekkahyoEntity}
     */
    protected IchijihanteikekkahyoA3Editor(IchijihanteikekkahyoEntity item) {
        this.item = item;
    }

    @Override
    public IchijihanteikekkahyoA3ReportSource edit(IchijihanteikekkahyoA3ReportSource source) {
        return editSource(source);
    }

    private IchijihanteikekkahyoA3ReportSource editSource(IchijihanteikekkahyoA3ReportSource source) {
        source.shinseiCount = item.get審査人数();
        source.shinseiCountGokei = item.get申請書管理番号の個数();
        source.gogitaiNo = item.get合議体番号();
        source.kanriNo = item.get管理番号();
        source.hihokenshaKubun = item.get被保険者区分();
        source.shinseiKubun = item.get申請区分();
        source.age = get年齢(item.get年齢());
        source.seibetsu = item.get性別();
        source.zenZenkaiHanteikekka = item.get前々回要介護度();
        source.zenzenkaiYukokikan = item.get前々回認定有効期間();
        source.zZenkaiNijiKaishiYMD = item.get前々回認定有効期間開始年月日();
        source.zZenkaiNijishuryoYMD = item.get前々回認定有効期間終了年月日();
        source.zenkaiNijihanteikekka = item.get前回要介護度();
        source.zenkaiYukokikan = item.get前回認定有効期間();
        source.zenkaiNijiKaishiYMD = item.get前回認定有効期間開始年月日();
        source.zenkaiNijiShuryoYMD = item.get前回認定有効期間終了年月日();
        source.zenkaiNijihanteiDate = item.get前回認定日();
        source.zenkaiJotaizo = item.get前回状態像();
        source.chosaJisshiDate2 = パターン16(item.get審査会資料作成年月日());
        source.shinseiYMD1 = パターン16(item.get今回認定申請年月日());
        source.shinseiYMD = パターン16(item.get今回認定調査実施年月日());
        source.shinsaYMD = パターン16(item.get今回認定審査年月日());
        source.ichijiHanteiKekka = item.get一次判定結果();
        source.chosaJisshiDate1 = パターン16(item.get今回認定調査実施年月日());
        source.chosaJisshiBasho = item.get認定調査実施場所名称();
        source.tokuteishippeiName = item.get特定疾病名();
        source.kijunGokeiTime = item.get要介護認定等基準時間();
        source.zenkaiKijunGokeiTime = item.get要介護認定等基準時間();
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
        source.chosaNinchishoJiritsudo = item.get認定調査結果認知症高齢者自立度();
        source.ikenNinchiJiritsudo = item.get意見書認知症高齢者自立度();
        source.manzensei = item.get認知症自立度Ⅱ以上の蓋然性();
        source.jotainoanteisei = item.get状態の安定性();
        source.kyufukubun = item.get給付区分();
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

    private RString パターン16(FlexibleDate 年月日) {
        return 年月日.wareki().eraType(EraType.ALPHABET)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
    }
}
