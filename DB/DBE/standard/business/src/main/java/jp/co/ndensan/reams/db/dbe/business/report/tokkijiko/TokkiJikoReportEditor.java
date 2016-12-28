/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkijiko;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.TokkiJiko;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitexta4.TokkiA4Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkijiko.TokkiJikoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FillTypeFormatted;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 特記事項帳票のReportEditorクラスです。
 */
public class TokkiJikoReportEditor implements ITokkiJikoReportEditor {

    private final TokkiJiko item;

    /**
     * コンストラクタです。
     *
     * @param item {@link TokkiJiko}
     */
    public TokkiJikoReportEditor(TokkiJiko item) {
        this.item = item;
    }

    @Override
    public TokkiJikoReportSource edit(TokkiJikoReportSource source) {
        if (item.is委員用()) {
            source.hokenshaNo = RString.EMPTY;
            source.hihokenshaNo = RString.EMPTY;
            source.hihokenshaName = RString.EMPTY;
        } else {
            source.hokenshaNo = item.get保険者番号();
            source.hihokenshaNo = item.get被保険者番号();
            source.hihokenshaName = item.get名前();
        }
        source.shinseiGengo = get元号(item.get認定申請年月日());
        source.shinseiYY = get年(item.get認定申請年月日()).replace(get元号(item.get認定申請年月日()), RString.EMPTY)
                .replace(new RString("年"), RString.EMPTY);
        source.shinseiMM = new RString(item.get認定申請年月日().getMonthValue());
        source.shinseiDD = new RString(item.get認定申請年月日().getDayValue());
        FlexibleDate システム日付 = FlexibleDate.getNowDate();
        source.sakuseiGengo = get元号(システム日付);
        source.sakuseiYY = get年(システム日付).replace(get元号(システム日付), RString.EMPTY)
                .replace(new RString("年"), RString.EMPTY);
        source.sakuseiMM = new RString(システム日付.getMonthValue());
        source.sakuseiDD = new RString(システム日付.getDayValue());
        source.chosaGengo = get元号(item.get認定調査実施年月日());
        source.chosaYY = get年(item.get認定調査実施年月日()).replace(get元号(item.get認定調査実施年月日()),
                RString.EMPTY).replace(new RString("年"), RString.EMPTY);
        source.chosaMM = new RString(item.get認定調査実施年月日().getMonthValue());
        source.chosaDD = new RString(item.get認定調査実施年月日().getDayValue());
        source.shinsaGengo = get元号(item.get介護認定審査会開催年月日());
        source.shinsaYY = get年(item.get介護認定審査会開催年月日()).replace(get元号(item.get介護認定審査会開催年月日()),
                RString.EMPTY).replace(new RString("年"), RString.EMPTY);
        source.shinsaMM = new RString(item.get介護認定審査会開催年月日().getMonthValue());
        source.shinsaDD = new RString(item.get介護認定審査会開催年月日().getDayValue());

        if (TokkijikoTextImageKubun.テキスト.getコード().equals(item.get概況特記テキスト_イメージ区分())) {
            source.gaikyotokkiText = item.get概況調査の特記事項テキスト();
        }

        if (TokkijikoTextImageKubun.イメージ.getコード().equals(item.get概況特記テキスト_イメージ区分())) {
            source.gaikyotokkiImg = item.get概況調査の特記事項イメージ();
        }

        set特記事項短冊テキスト(source);
        set特記事項全面イメージ(source);
        set特記事項短冊イメージ(source);
        if (!item.is委員用()) {
            source.shikibetuCode = RString.isNullOrEmpty(item.get識別コード()) ? ShikibetsuCode.EMPTY : new ShikibetsuCode(item.get識別コード());
            if (!RString.isNullOrEmpty(item.get申請書管理番号())) {
                source.hishokenshaNo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                        item.get申請書管理番号());
            }
        }
        return source;
    }

    private void set特記事項短冊テキスト(TokkiJikoReportSource source) {
        int index = 0;
        List<TokkiA4Entity> 短冊テキストリスト = item.get短冊テキストリスト();
        if (index < 短冊テキストリスト.size()) {
            source.tokkiText1 = 短冊テキストリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊テキストリスト.size()) {
            source.tokkiText2 = 短冊テキストリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊テキストリスト.size()) {
            source.tokkiText3 = 短冊テキストリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊テキストリスト.size()) {
            source.tokkiText4 = 短冊テキストリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊テキストリスト.size()) {
            source.tokkiText5 = 短冊テキストリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊テキストリスト.size()) {
            source.tokkiText6 = 短冊テキストリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊テキストリスト.size()) {
            source.tokkiText7 = 短冊テキストリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊テキストリスト.size()) {
            source.tokkiText8 = 短冊テキストリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊テキストリスト.size()) {
            source.tokkiText9 = 短冊テキストリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊テキストリスト.size()) {
            source.tokkiText10 = 短冊テキストリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊テキストリスト.size()) {
            source.tokkiText11 = 短冊テキストリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊テキストリスト.size()) {
            source.tokkiText12 = 短冊テキストリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊テキストリスト.size()) {
            source.tokkiText13 = 短冊テキストリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊テキストリスト.size()) {
            source.tokkiText14 = 短冊テキストリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊テキストリスト.size()) {
            source.tokkiText15 = 短冊テキストリスト.get(index).get特記事項テキスト_イメージ();
        }
    }

    private void set特記事項全面イメージ(TokkiJikoReportSource source) {
        if (!item.get全画面イメージリスト().isEmpty()) {
            source.tokkiImg = item.get全画面イメージリスト().get(0);
        }
    }

    private void set特記事項短冊イメージ(TokkiJikoReportSource source) {
        int index = 0;
        List<TokkiA4Entity> 短冊イメージリスト = item.get短冊イメージリスト();
        if (index < 短冊イメージリスト.size()) {
            source.tokkiImg1 = 短冊イメージリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊イメージリスト.size()) {
            source.tokkiImg2 = 短冊イメージリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊イメージリスト.size()) {
            source.tokkiImg3 = 短冊イメージリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊イメージリスト.size()) {
            source.tokkiImg4 = 短冊イメージリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊イメージリスト.size()) {
            source.tokkiImg5 = 短冊イメージリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊イメージリスト.size()) {
            source.tokkiImg6 = 短冊イメージリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊イメージリスト.size()) {
            source.tokkiImg7 = 短冊イメージリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊イメージリスト.size()) {
            source.tokkiImg8 = 短冊イメージリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊イメージリスト.size()) {
            source.tokkiImg9 = 短冊イメージリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊イメージリスト.size()) {
            source.tokkiImg10 = 短冊イメージリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊イメージリスト.size()) {
            source.tokkiImg11 = 短冊イメージリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊イメージリスト.size()) {
            source.tokkiImg12 = 短冊イメージリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊イメージリスト.size()) {
            source.tokkiImg13 = 短冊イメージリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊イメージリスト.size()) {
            source.tokkiImg14 = 短冊イメージリスト.get(index).get特記事項テキスト_イメージ();
        }
        index++;
        if (index < 短冊イメージリスト.size()) {
            source.tokkiImg15 = 短冊イメージリスト.get(index).get特記事項テキスト_イメージ();
        }
    }

    private RString get元号(FlexibleDate 年月日) {
        return get和暦(年月日).getEra();
    }

    private RString get年(FlexibleDate 年月日) {
        return get和暦(年月日).getYear();
    }

    private FillTypeFormatted get和暦(FlexibleDate 年月日) {
        return 年月日.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK);
    }

}
