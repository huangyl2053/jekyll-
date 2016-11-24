package jp.co.ndensan.reams.db.dba.business.core.nenreitoutatsuyoteishacheck;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.nenreitotatsuyoteishaichiranhyo.NenreitotatsuYoteishaIchiranhyoBodyItem;
import jp.co.ndensan.reams.db.dba.business.report.nenreitotatsuyoteishaichiranhyo.NenreitotatsuYoteishaIchiranhyoHeadItem;
import jp.co.ndensan.reams.db.dba.business.report.nenreitotatsuyoteishaichiranhyo.NenreitotatsuYoteishaIchiranhyoItem;
import jp.co.ndensan.reams.db.dba.entity.db.relate.nenreitoutatsuyoteishachecklist.NenreiToutatsuYoteishaCheckListEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.nenreitoutatsuyoteishachecklist.NenreiToutatsuYoteishaCheckListJyohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 *
 * 年齢到達予定者チェックリスト_帳票データ作成します。
 *
 * @reamsid_L DBA-0580-050 yaodongsheng
 */
public class NenreiTotatsuYoteishaCheckListChohyo {

    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private NenreitotatsuYoteishaIchiranhyoItem item;
    private NenreitotatsuYoteishaIchiranhyoHeadItem headItem;
    private final List<NenreitotatsuYoteishaIchiranhyoBodyItem> bodyItemList = new ArrayList<>();

    /**
     * 年齢到達予定者チェックリスト_帳票データ作成。
     *
     * @param nenreiCheckListJyohoEntity 年齢到達予定者チェックリスト情報Entity
     * @return 年齢到達予定者チェックリスト_帳票データ
     */
    public NenreitotatsuYoteishaIchiranhyoItem createNenreiToutatsuYoteishaCheckListChohyo(
            NenreiToutatsuYoteishaCheckListJyohoEntity nenreiCheckListJyohoEntity) {
        List<RString> 並び順 = nenreiCheckListJyohoEntity.get並び順();
        List<RString> 改頁 = nenreiCheckListJyohoEntity.get改頁();
        headItem = new NenreitotatsuYoteishaIchiranhyoHeadItem(
                get印刷日時(), nenreiCheckListJyohoEntity.get市町村コード(), nenreiCheckListJyohoEntity.get市町村名(),
                並び順.get(0), 並び順.get(INDEX_1), 並び順.get(INDEX_2), 並び順.get(INDEX_3), 並び順.get(INDEX_4),
                改頁.get(0), 改頁.get(INDEX_1), 改頁.get(INDEX_2), 改頁.get(INDEX_3), 改頁.get(INDEX_4),
                nenreiCheckListJyohoEntity.get抽出期間From(), nenreiCheckListJyohoEntity.get抽出期間To(),
                nenreiCheckListJyohoEntity.get出力対象(), nenreiCheckListJyohoEntity.get住民種別());
        if (nenreiCheckListJyohoEntity.get年齢到達予定者チェックリスト().isEmpty()) {
            NenreitotatsuYoteishaIchiranhyoBodyItem bodyItem = new NenreitotatsuYoteishaIchiranhyoBodyItem(
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    new RString("該当データはありません"), RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);

            bodyItemList.add(bodyItem);
            item = new NenreitotatsuYoteishaIchiranhyoItem(headItem, bodyItemList);
        } else {
            帳票用データリスト(nenreiCheckListJyohoEntity);
        }
        return item;
    }

    private RString get印刷日時() {
        RStringBuilder systemDateTime = new RStringBuilder();
        RDateTime datetime = RDate.getNowDateTime();
        systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(String.format("%02d", datetime.getHour()));
        systemDateTime.append(new RString("時"));
        systemDateTime.append(String.format("%02d", datetime.getMinute()));
        systemDateTime.append(new RString("分"));
        systemDateTime.append(String.format("%02d", datetime.getSecond()));
        systemDateTime.append(new RString("秒"));
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(new RString("作成"));
        return systemDateTime.toRString();
    }

    private void 帳票用データリスト(
            NenreiToutatsuYoteishaCheckListJyohoEntity nenreiCheckListJyohoEntity) {
        List<NenreiToutatsuYoteishaCheckListEntity> 年齢到達予定者チェックリスト = nenreiCheckListJyohoEntity.get年齢到達予定者チェックリスト();
        for (NenreiToutatsuYoteishaCheckListEntity checkList : 年齢到達予定者チェックリスト) {
            RString 被保険者番号 = checkList.getHihokenshaNo() == null || checkList.getHihokenshaNo().isEmpty()
                             ? RString.EMPTY : checkList.getHihokenshaNo().value();
            RString 識別コード = checkList.getShikibetsuCode().value();
            RString カナ氏名 = checkList.getKanaMeisho();
            RString 氏名 = checkList.getMeisho();
            RString 性別 = RString.EMPTY;
            if (Seibetsu.男.getコード().equals(checkList.getSeibetsuCode())) {
                性別 = Seibetsu.男.get名称();
            } else if (Seibetsu.女.getコード().equals(checkList.getSeibetsuCode())) {
                性別 = Seibetsu.女.get名称();
            }
            RString 生年月日 = checkList.getSeinengappiYMD() == null || checkList.getSeinengappiYMD().isEmpty() ? RString.EMPTY
                           : checkList.getSeinengappiYMD().wareki().eraType(EraType.KANJI_RYAKU).firstYear(
                    FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.NONE).toDateString();
            RString 年齢到達日 = checkList.getNenreiyotainichi() == null || checkList.getNenreiyotainichi().isEmpty() ? RString.EMPTY
                            : checkList.getNenreiyotainichi().wareki().eraType(EraType.KANJI_RYAKU).firstYear(
                    FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.NONE).toDateString();
            RString 住民種別 = RString.EMPTY;
            if (JuminShubetsu.日本人.getCode().equals(checkList.getJuminShubetsuCode())
                || JuminShubetsu.住登外個人_日本人.getCode().equals(checkList.getJuminShubetsuCode())) {
                住民種別 = RString.EMPTY;
            } else if (JuminShubetsu.外国人.getCode().equals(checkList.getJuminShubetsuCode())
                       || JuminShubetsu.住登外個人_外国人.getCode().equals(checkList.getJuminShubetsuCode())) {
                住民種別 = JuminShubetsu.外国人.toRString();
            }
            RString 生活 = checkList.getSeikatsu();
            RString 状態 = checkList.getJyotei();
            NenreitotatsuYoteishaIchiranhyoBodyItem bodyItem = new NenreitotatsuYoteishaIchiranhyoBodyItem(
                    被保険者番号, カナ氏名, 性別, 生年月日, checkList.getShigekubun(), checkList.getZenkokuJushoCode(), checkList.getJusho(), 生活,
                    識別コード, 氏名, 年齢到達日, checkList.getJutosyakubun(), checkList.getGyoseikuCode(), checkList.getGyoseikuName(), 住民種別, 状態);
            bodyItemList.add(bodyItem);
        }
        item = new NenreitotatsuYoteishaIchiranhyoItem(headItem, bodyItemList);
    }
}
