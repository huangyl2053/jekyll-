/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.yokaigoyoshienchiran;

import jp.co.ndensan.reams.db.dbe.business.report.yokaigoyoshienshinseiichiran.YokaigoYoshienShinseiIchiranItem;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseimonitor.ShinseiMonitorEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 申請情報印刷ビジネスクラスです。
 *
 * @reamsid_L DBE-1390-020 suguangjun
 */
public class YokaigoyoShienchiran {

    /**
     * 要介護認定・要支援認定等申請者の編集処理です。
     *
     * @param entity 要介護認定申請
     * @return YokaigoYoshienShinseiIchiranItem
     */
    public YokaigoYoshienShinseiIchiranItem getIchiranItem(ShinseiMonitorEntity entity) {
        YokaigoYoshienShinseiIchiranItem item = new YokaigoYoshienShinseiIchiranItem();
        item.setTitle(new RString("要介護認定・要支援認定等申請者一覧"));
        item.setShichosonName(entity.get保険者名());
        item.setPrintTimeStamp(get作成年月日時());
        item.setShoKisaiHokenshaNo(entity.get保険者番号());
        item.setShichosonName(entity.get保険者名());
        item.setHihokenshaName(entity.get氏名());
        item.setHihokenshaNo(entity.get被保険者番号());
        item.setSeinengappiYMD(entity.get生年月日());
        item.setSeibetsu(entity.get性別() == null ? Code.EMPTY : new Code(entity.get性別().toString()));
        item.setKoroshoIfShikibetsuCode(entity.get厚労省認定ソフトバージョン() == null
                ? Code.EMPTY : new Code(entity.get厚労省認定ソフトバージョン().toString()));
        item.setNijiHanteiYokaigoJotaiKubun(entity.get前回二次判定結果コード() == null
                ? Code.EMPTY : new Code(entity.get前回二次判定結果コード().toString()));
        item.setNijiHanteiNinteiYukoKikan(new RString(entity.get前回月数()));
        item.setNijiHanteiNinteiYukoKaishiYMD(entity.get前回認定有効期間開始日());
        item.setNijiHanteiNinteiYukoShuryoYMD(entity.get前回認定有効期間終了日());
        item.setNinteiShinseiYMD(entity.get認定申請年月日());
        item.setNinteiShinseiShinseijiKubun(entity.get認定申請区分申請時コード() == null
                ? Code.EMPTY : new Code(entity.get認定申請区分申請時コード().toString()));
        item.setJigyoshaMeisho(entity.get調査事業所());
        item.setChosainShimei(entity.get調査員氏名());
        item.setIryoKikanMeisho(entity.get医療機関名());
        item.setShujiiName(entity.get主治医氏名());
        return item;
    }

    private RString get作成年月日時() {
        RDateTime dateTime = RDateTime.now();
        RStringBuilder hakkoYMD = new RStringBuilder();
        hakkoYMD.append(dateTime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        hakkoYMD.append(RString.HALF_SPACE);
        hakkoYMD.append(dateTime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        return hakkoYMD.toRString();
    }
}
