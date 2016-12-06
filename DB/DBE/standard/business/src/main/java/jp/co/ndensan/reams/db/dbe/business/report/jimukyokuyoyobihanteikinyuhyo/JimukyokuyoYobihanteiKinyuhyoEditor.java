/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimukyokuyoyobihanteikinyuhyo;

import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuYobihanteiKinyuhyoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jimukyokuyoyobihanteikinyuhyo.JimukyokuyoYobihanteiKinyuhyoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 事務局用予備判定記入表のEditorです。
 *
 * @reamsid_L DBE-0150-100 wangrenze
 */
public class JimukyokuyoYobihanteiKinyuhyoEditor implements IJimukyokuyoYobihanteiKinyuhyoEditor {

    private final JimuYobihanteiKinyuhyoBusiness business;
    private static final int INT_NUM = 2;
    private static final int INT_LENGTH = 4;

    /**
     * コンストラクタです。
     *
     * @param business {@link JimuYobihanteiKinyuhyoBusiness}
     */
    protected JimukyokuyoYobihanteiKinyuhyoEditor(JimuYobihanteiKinyuhyoBusiness business) {
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
        RStringBuilder systemDateTime = new RStringBuilder();
        RDateTime datetime = RDate.getNowDateTime();
        systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(String.format("%02d", datetime.getHour()));
        systemDateTime.append(new RString("時"));
        systemDateTime.append(String.format("%02d", datetime.getMinute()));
        systemDateTime.append(new RString("分"));
        systemDateTime.append(String.format("%02d", datetime.getSecond()));
        systemDateTime.append(new RString("秒"));
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(new RString("作成"));
        source.printTimeStamp = systemDateTime.toRString();
        source.listTaishoshaIchiran_1 = business.get被保険者番号();
        source.listTaishoshaIchiran_2 = business.get氏名();
        if (RString.isNullOrEmpty(business.get性別())) {
            source.listTaishoshaIchiran_3 = RString.EMPTY;
        } else {
            source.listTaishoshaIchiran_3 = Seibetsu.toValue(business.get性別()).get名称();
        }

        source.listTaishoshaIchiran_4 = business.get年齢();

        if (RString.isNullOrEmpty(business.get前回二次判定())) {
            source.listTaishoshaIchiran_5 = RString.EMPTY;
        } else {
            source.listTaishoshaIchiran_5 = YokaigoJotaiKubun09.toValue(business.get前回二次判定()).get名称();
        }

        if (RString.isNullOrEmpty(business.get前回認定有効期間())) {
            source.listTaishoshaIchiran_6 = RString.EMPTY;
        } else {
            source.listTaishoshaIchiran_6 = business.get前回認定有効期間().concat(new RString("ヵ月"));

        }

        if (RString.isNullOrEmpty(business.get一次判定())) {
            source.listTaishoshaIchiran_7 = RString.EMPTY;
        } else {
            source.listTaishoshaIchiran_7 = IchijiHanteiKekkaCode09.toValue(business.get一次判定()).get名称();
        }

        source.listTaishoshaIchiran_8 = RString.EMPTY;
        source.listTaishoshaIchiran_9 = RString.EMPTY;
        source.listTaishoshaIchiran_10 = RString.EMPTY;

        if (RString.isNullOrEmpty(business.get特定疾病コード())) {
            source.listTokuteiShippeiCode_1 = RString.EMPTY;
            source.listTokuteiShippeiName_1 = RString.EMPTY;
        } else {
            source.listTokuteiShippeiCode_1 = business.get特定疾病コード();
            source.listTokuteiShippeiName_1 = TokuteiShippei.toValue(business.get特定疾病コード()).get名称();
        }
        source.listIchijihanteiKeikokuCode_1 = business.get一次判定警告コード();
        source.listShinseiKubun_1 = NinteiShinseiShinseijiKubunCode.toValue(business.get申請区分()).get名称();
        source.listNo_1 = business.getNo();
        source.listHokenshaName_1 = business.get保険者();
        source.shinsakaiKaisaiNo = business.get審査会開催番号().length() <= INT_LENGTH ? new RString(business.get審査会開催番号().toString())
                : new RString(business.get審査会開催番号().toString().substring(business.get審査会開催番号().length() - INT_LENGTH));
        if (business.get開催年月日() != null && !business.get開催年月日().isEmpty()) {
            source.kaisaiYMD = getパターン33(business.get開催年月日());
        }
        source.kaisaiHH = business.get開催時().padZeroToLeft(INT_NUM);
        source.kaisaiMM = business.get開催分().padZeroToLeft(INT_NUM);
        source.gogitaiName = business.get合議体名称();
        source.shikibetuCode = ShikibetsuCode.EMPTY;

        if (!RString.isNullOrEmpty(business.get被保険者番号())) {
            source.hishokenshaNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                    business.get被保険者番号());
        }
        return source;
    }

    private RString getパターン33(FlexibleDate 開催年月日) {
        if (開催年月日 != null) {
            return 開催年月日.seireki().separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }

}
