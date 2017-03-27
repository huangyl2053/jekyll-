/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimukyokuyoyobihanteikinyuhyo;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.YobihanteiKinyuhyoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jimukyokuyoyobihanteikinyuhyo.JimukyokuyoYobihanteiKinyuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 事務局用予備判定記入表のEditorです。
 *
 * @reamsid_L DBE-0150-100 wangrenze
 */
public class JimukyokuyoYobihanteiKinyuhyoEditor implements IJimukyokuyoYobihanteiKinyuhyoEditor {

    private final YobihanteiKinyuhyoBusiness business;
    private static final int INT_NUM = 2;
    private static final int INT_LENGTH = 4;

    /**
     * コンストラクタです。
     *
     * @param business {@link YobihanteiKinyuhyoBusiness}
     */
    protected JimukyokuyoYobihanteiKinyuhyoEditor(YobihanteiKinyuhyoBusiness business) {
        this.business = business;
    }

    /**
     * 事務局用予備判定記入表を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public JimukyokuyoYobihanteiKinyuhyoReportSource edit(JimukyokuyoYobihanteiKinyuhyoReportSource source) {
        source.printTimeStamp = business.get作成年月日();
        source.title = new RString("予備判定記入表(事務局用)");
        source.listTaishoshaIchiran_1 = business.get被保険者番号();
        source.listTaishoshaIchiran_2 = business.get被保険者氏名();
        source.listTaishoshaIchiran_3 = business.get性別();
        source.listTaishoshaIchiran_4 = business.get年齢();
        source.listTaishoshaIchiran_5 = business.get前回二次判定();
        source.listTaishoshaIchiran_6 = business.get前回認定有効期間();
        source.listTaishoshaIchiran_7 = business.get一次判定();
        source.listTaishoshaIchiran_8 = RString.EMPTY;
        source.listTaishoshaIchiran_9 = RString.EMPTY;
        source.listTaishoshaIchiran_10 = RString.EMPTY;
        source.listTokuteiShippeiCode_1 = business.get特定疾病コード();
        source.listTokuteiShippeiName_1 = business.get特定疾病名称();
        source.listIchijihanteiKeikokuCode_1 = business.get一次判定警告コード();
        source.listShinseiKubun_1 = business.get申請区分();
        source.listNo_1 = business.getNo();
        source.listHokenshaName_1 = business.get保険者();
        source.shinsakaiKaisaiNo = new RString("第").concat(new RString(business.get審査会開催番号().substring(business.get審査会開催番号()
                .length() - INT_LENGTH).toInt())).concat(new RString("回　審査会"));
        if (business.get開催年月日() != null && !business.get開催年月日().isEmpty()) {
            source.kaisaiYMD = getパターン33(business.get開催年月日(), FillType.BLANK);
        }
        source.kaisaiHH = business.get開催時().padZeroToLeft(INT_NUM);
        source.kaisaiMM = business.get開催分().padZeroToLeft(INT_NUM);
        source.gogitaiName = business.get合議体名称();
        setAccessLogInfo(source);
        return source;
    }

    private RString getパターン33(FlexibleDate 開催年月日, FillType fillType) {
        if (開催年月日 != null) {
            return 開催年月日.wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(fillType)
                    .toDateString();
        }
        return RString.EMPTY;
    }

    private void setAccessLogInfo(JimukyokuyoYobihanteiKinyuhyoReportSource source) {
        source.識別コード = new ShikibetsuCode(business.get識別コード());
        ExpandedInformation 拡張情報 = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                business.get申請書管理番号().getColumnValue());
        source.拡張情報 = 拡張情報;
    }

}
