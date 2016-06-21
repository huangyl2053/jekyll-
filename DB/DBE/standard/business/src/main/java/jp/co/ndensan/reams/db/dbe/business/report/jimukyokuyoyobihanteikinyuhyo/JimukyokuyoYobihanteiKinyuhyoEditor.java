/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimukyokuyoyobihanteikinyuhyo;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.jimukyokuyoyobihanteikinyuhyo.JimukyokuyoYobihanteiKinyuhyoEntity;
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

    private final JimukyokuyoYobihanteiKinyuhyoEntity item;
    private static final int INT_NUM = 2;
    private static final int INT_LENGTH = 4;

    /**
     * コンストラクタです。
     *
     * @param item {@link JimukyokuyoYobihanteiKinyuhyoEntity}
     */
    protected JimukyokuyoYobihanteiKinyuhyoEditor(JimukyokuyoYobihanteiKinyuhyoEntity item) {
        this.item = item;
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
        source.listTaishoshaIchiran_1 = item.get被保険者番号();
        source.listTaishoshaIchiran_2 = item.get氏名();
        source.listTaishoshaIchiran_3 = Seibetsu.toValue(item.get性別()).get名称();
        source.listTaishoshaIchiran_4 = item.get年齢();

        if (item.get前回二次判定() == null) {
            source.listTaishoshaIchiran_5 = RString.EMPTY;
        } else {
            source.listTaishoshaIchiran_5 = YokaigoJotaiKubun09.toValue(item.get前回二次判定()).get名称();
        }

        if (item.get前回認定有効期間() == null) {
            source.listTaishoshaIchiran_6 = RString.EMPTY;
        } else {
            source.listTaishoshaIchiran_6 = item.get前回認定有効期間().concat(new RString("ヵ月"));

        }
        source.listTaishoshaIchiran_7 = IchijiHanteiKekkaCode09.toValue(item.get一次判定()).get名称();
        source.listTaishoshaIchiran_8 = RString.EMPTY;
        source.listTaishoshaIchiran_9 = RString.EMPTY;
        source.listTaishoshaIchiran_10 = RString.EMPTY;
        source.listTokuteiShippeiName_1 = TokuteiShippei.toValue(item.get特定疾病コード()).get名称();
        source.listTokuteiShippeiCode_1 = item.get特定疾病コード();
        source.listIchijihanteiKeikokuCode_1 = item.get一次判定警告コード();
        source.listShinseiKubun_1 = NinteiShinseiShinseijiKubunCode.toValue(item.get申請区分()).get名称();
        source.listNo_1 = item.getNo();
        source.listHokenshaName_1 = item.get保険者();
        source.shinsakaiKaisaiNo = new RString(item.get審査会開催番号().toString()
                .substring(item.get審査会開催番号().length() - INT_LENGTH));
        source.kaisaiYMD = getパターン33(new RDate(item.get開催年月日().toString()));
        source.kaisaiHH = item.get開催時().padZeroToLeft(INT_NUM);
        source.kaisaiMM = item.get開催分().padZeroToLeft(INT_NUM);
        source.gogitaiName = item.get合議体名称();
        source.shikibetuCode = ShikibetsuCode.EMPTY;

        if (!RString.isNullOrEmpty(item.get被保険者番号())) {
            source.hishokenshaNo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                    item.get被保険者番号());
        }
        return source;
    }

    private RString getパターン33(RDate 開催年月日) {
        if (開催年月日 != null) {
            return 開催年月日.seireki().separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }

}
