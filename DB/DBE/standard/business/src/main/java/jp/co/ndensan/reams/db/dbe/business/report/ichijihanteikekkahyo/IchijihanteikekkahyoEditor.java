/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ichijihanteikekkahyo;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyoa4.IchijihanteikekkahyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa4.IchijihanteikekkahyoReportSource;
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
 * 一次判定結果のEditorです。
 *
 * @reamsid_L DBE-0230-060 lizhuoxuan
 */
public class IchijihanteikekkahyoEditor implements IIchijihanteikekkahyoEditor {

    private final IchijihanteikekkahyoEntity item;
    private final int index;
    private static final int TEN = 10;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link IchijihanteikekkahyoEntity}
     * @param index Index
     */
    protected IchijihanteikekkahyoEditor(IchijihanteikekkahyoEntity item, int index) {
        this.item = item;
        this.index = index;
    }

    @Override
    public IchijihanteikekkahyoReportSource edit(IchijihanteikekkahyoReportSource source) {
        return editSource(source);
    }

    private IchijihanteikekkahyoReportSource editSource(IchijihanteikekkahyoReportSource source) {

        source.title = item.getタイトル();
        source.sakuseiGengo = item.get作成日_元号();
        source.sakuseiYY = item.get作成日_年();
        source.sakuseiMM = item.get作成日_月();
        source.sakuseiDD = item.get作成日_日();
        source.shinseiGengo = item.get申請日_元号();
        source.shinseiYY = item.get申請日_年();
        source.shinseiMM = item.get申請日_月();
        source.shinseiDD = item.get申請日_日();
        source.chosaGengo = item.get調査日_元号();
        source.chosaYY = item.get調査日_年();
        source.chosaMM = item.get調査日_月();
        source.chosaDD = item.get調査日_日();
        source.shinsaGengo = item.get審査日_元号();
        source.shinsaYY = item.get審査日_年();
        source.shinsaMM = item.get審査日_月();
        source.shinsaDD = item.get審査日_日();
        source.gogitaiNo = item.get合議体番号();
        source.shinseiCount = item.get審査順();
        source.hihokenshaKubun = item.get被保険者区分();
        source.shinseiKubun = item.get申請区分();
        source.age = item.get年齢();
        source.seibetsu = item.get性別();
        source.shisetsuriyo = item.get現在の状況();
        source.zenZenkaiNijihanteikekka = item.get前々回要介護度();
        source.zenzenkaiYukokikan = item.get前々回認定有効期間();
        source.zZenkaiNijiKaishiYMD = dateformat(item.get前々回認定有効期間開始年月日());
        source.zZenkaiNijishuryoYMD = dateformat(item.get前々回認定有効期間終了年月日());
        source.zenkaiNijihanteikekka = item.get前回要介護度();
        source.zenkaiYukokikan = item.get前回認定有効期間();
        source.zenkaiNijiKaishiYMD = dateformat(item.get前回認定有効期間開始年月日());
        source.zenkaiNijishuryoYMD = dateformat(item.get前回認定有効期間終了年月日());
        source.zenkaiNijihanteiDATE = dateformat(item.get前回認定日());
        source.zenkaiJotaizo = item.get前回状態像();
        source.kanriNo = item.get管理番号();
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
        source.nijiHanteiKekka = item.get二次判定結果();
        source.ｙukokikan = item.get認定有効期間();
        source.nijihanteiKaishiYMD = dateformat(item.get認定有効期間開始年月日());
        source.nijihanteishuryoYMD = dateformat(item.get認定有効期間終了年月日());
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
        RString 警告コード = item.get警告コード();
        if (!RString.isNullOrEmpty(警告コード)) {
            RStringBuilder rstringBuilder = new RStringBuilder();
            int len = 0;
            while (-1 < 警告コード.indexOf("1", len)) {
                int index1 = 警告コード.indexOf("1", len);
                rstringBuilder.append(index1 + 1 < TEN ? "0" + String.valueOf(index1 + 1) : String.valueOf(index1 + 1));
                rstringBuilder.append("、");
                len = index1 + 1;
            }
            if (!RString.isNullOrEmpty(rstringBuilder.toRString())) {
                RString result = rstringBuilder.toRString().substring(0, rstringBuilder.toRString().length() - 1);
                source.keikokuNo = result;
            }
        }
        source.listChukanhyoka_1 = item.get中間評価項目得点第1群();
        source.listChukanhyoka_2 = item.get中間評価項目得点第2群();
        source.listChukanhyoka_3 = item.get中間評価項目得点第3群();
        source.listChukanhyoka_4 = item.get中間評価項目得点第4群();
        source.listChukanhyoka_5 = item.get中間評価項目得点第5群();
        source.chosaNinchishoJiritsudo = item.get認定調査結果認知症高齢者自立度();
        source.ikenNinchishoJiritsudo = item.get意見書認知症高齢者自立度();
        RStringBuilder 蓋然性 = new RStringBuilder();
        蓋然性.append(item.get認知症自立度Ⅱ以上の蓋然性());
        蓋然性.append(new RString("%"));
        source.manzensei = 蓋然性.toRString();
        source.jotainoanteisei = item.get状態の安定性();
        source.kyufukubun = item.get給付区分();
        source.sabisuName = item.get現在のサービス利用状況名();
        source.sabisuText = item.get現在のサービス状況();
        editSource1(source);
        editSource2(source);
        editSource3(source);
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        source.hihokennshaNo = new ExpandedInformation(new Code("100"), new RString("被保険者番号"), item.get被保険者番号());
        return source;
    }

    private void editSource1(IchijihanteikekkahyoReportSource source) {
        if (index < item.get社会生活への適応1リスト().size()) {
            source.listGogun_1 = item.get社会生活への適応1リスト().get(index);
        }
        if (index < item.get社会生活への適応2リスト().size()) {
            source.listGogun_2 = item.get社会生活への適応2リスト().get(index);
        }
        if (index < item.get社会生活への適応3リスト().size()) {
            source.listGogun_3 = item.get社会生活への適応3リスト().get(index);
        }
        if (index < item.get社会生活への適応4リスト().size()) {
            source.listGogun_4 = item.get社会生活への適応4リスト().get(index);
        }
        if (index < item.get身体機能_起居動作1リスト().size()) {
            source.listIchigun_1 = item.get身体機能_起居動作1リスト().get(index);
        }
        if (index < item.get身体機能_起居動作2リスト().size()) {
            source.listIchigun_2 = item.get身体機能_起居動作2リスト().get(index);
        }
        if (index < item.get身体機能_起居動作3リスト().size()) {
            source.listIchigun_3 = item.get身体機能_起居動作3リスト().get(index);
        }
        if (index < item.get身体機能_起居動作4リスト().size()) {
            source.listIchigun_4 = item.get身体機能_起居動作4リスト().get(index);
        }
        if (index < item.get高齢者自立度リスト().size()) {
            source.ｌistNichijoseikatsujiritsudo_1 = item.get高齢者自立度リスト().get(index);
        }
        if (index < item.get生活機能1リスト().size()) {
            source.listNigun_1 = item.get生活機能1リスト().get(index);
        }
        if (index < item.get生活機能2リスト().size()) {
            source.listNigun_2 = item.get生活機能2リスト().get(index);
        }
        if (index < item.get生活機能3リスト().size()) {
            source.listNigun_3 = item.get生活機能3リスト().get(index);
        }
        if (index < item.get生活機能4リスト().size()) {
            source.listNigun_4 = item.get生活機能4リスト().get(index);
        }
        if (index < item.get認知機能1リスト().size()) {
            source.listSangun_1 = item.get認知機能1リスト().get(index);
        }
        if (index < item.get認知機能2リスト().size()) {
            source.listSangun_2 = item.get認知機能2リスト().get(index);
        }
        if (index < item.get認知機能3リスト().size()) {
            source.listSangun_3 = item.get認知機能3リスト().get(index);
        }
        if (index < item.get認知機能4リスト().size()) {
            source.listSangun_4 = item.get認知機能4リスト().get(index);
        }
        if (index < item.get主治医意見書項目1リスト().size()) {
            source.listshujiiikensho_1 = item.get主治医意見書項目1リスト().get(index);
        }
    }

    private void editSource2(IchijihanteikekkahyoReportSource source) {
        if (index < item.get主治医意見書項目2リスト().size()) {
            source.listshujiiikensho_2 = item.get主治医意見書項目2リスト().get(index);
        }
        if (index < item.get主治医意見書項目3リスト().size()) {
            source.listshujiiikensho_3 = item.get主治医意見書項目3リスト().get(index);
        }
        if (index < item.get主治医意見書項目4リスト().size()) {
            source.listshujiiikensho_4 = item.get主治医意見書項目4リスト().get(index);
        }
        if (index < item.get身体機能_起居動作リスト().size()) {
            source.listtokki1_1 = item.get身体機能_起居動作リスト().get(index);
        }
        if (index < item.get生活機能リスト().size()) {
            source.listtokki2_1 = item.get生活機能リスト().get(index);
        }
        if (index < item.get認知機能リスト().size()) {
            source.listtokki3_1 = item.get認知機能リスト().get(index);
        }
        if (index < item.get精神_行動障害リスト().size()) {
            source.listtokki4_1 = item.get精神_行動障害リスト().get(index);
        }
        if (index < item.get社会生活への適応リスト().size()) {
            source.listtokki5_1 = item.get社会生活への適応リスト().get(index);
        }
        if (index < item.get特別な医療1リスト().size()) {
            source.listtokki6_1 = item.get特別な医療1リスト().get(index);
        }
        if (index < item.get特別な医療2リスト().size()) {
            source.listtokki7_1 = item.get特別な医療2リスト().get(index);
        }
        if (index < item.get日常生活自立度リスト().size()) {
            source.listtokki8_1 = item.get日常生活自立度リスト().get(index);
        }
        if (index < item.get特別な医療3_1リスト().size()) {
            source.listtokubetsunaIryo1_1 = item.get特別な医療3_1リスト().get(index);
        }
        if (index < item.get特別な医療3_2リスト().size()) {
            source.listtokubetsunaIryo1_2 = item.get特別な医療3_2リスト().get(index);
        }

    }

    private void editSource3(IchijihanteikekkahyoReportSource source) {
        if (index < item.get特別な医療4_1リスト().size()) {
            source.listtokubetsunaIryo2_1 = item.get特別な医療4_1リスト().get(index);
        }
        if (index < item.get特別な医療4_2リスト().size()) {
            source.listtokubetsunaIryo2_2 = item.get特別な医療4_2リスト().get(index);
        }
        if (index < item.get精神_行動障害1リスト().size()) {
            source.listYongun_1 = item.get精神_行動障害1リスト().get(index);
        }
        if (index < item.get精神_行動障害2リスト().size()) {
            source.listYongun_2 = item.get精神_行動障害2リスト().get(index);
        }
        if (index < item.get精神_行動障害3リスト().size()) {
            source.listYongun_3 = item.get精神_行動障害3リスト().get(index);
        }
        if (index < item.get精神_行動障害4リスト().size()) {
            source.listYongun_4 = item.get精神_行動障害4リスト().get(index);
        }
    }

    private RString dateformat(RString date) {
        if (!RString.isNullOrEmpty(date)) {
            return new FlexibleDate(date).wareki().eraType(EraType.ALPHABET)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        } else {
            return RString.EMPTY;
        }
    }
}
