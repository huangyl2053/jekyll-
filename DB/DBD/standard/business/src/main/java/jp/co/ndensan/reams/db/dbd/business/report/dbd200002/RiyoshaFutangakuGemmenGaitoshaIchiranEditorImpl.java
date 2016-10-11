/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00002.NinteishaListSakuseiResultEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd00002.RiyoshaFutangakuGemmenGaitoshaIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.core.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 利用負担額減額免除認定証Editorのクラスです。
 *
 * @reamsid_L DBD-3980-060 x_youyj
 */
public class RiyoshaFutangakuGemmenGaitoshaIchiranEditorImpl implements IRiyoshaFutangakuGemmenGaitoshaIchiranEditor {

    private final NinteishaListSakuseiResultEntity entity;
    private static final RString スペース = new RString("　");
    private static final RString 作成 = new RString("作成");
    private static final RString ASTERISK = new RString("*");
    private static final RString 課 = new RString("課");
    private static final RString 空白 = new RString("");
    private static final RString 却下 = new RString("却下");
    private static final RString 承認 = new RString("承認");
    private static final int INDEX_0 = 0;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_8 = 8;
    private static final RString ZEROSIX = new RString("06");
    private static final int LISTINDEX_1 = 1;
    private static final int LISTINDEX_4 = 4;
    private final IOutputOrder outputOrder;

    /**
     * インスタンスを生成します。
     *
     * @param entity entity
     * @param outputOrder IOutputOrder
     */
    protected RiyoshaFutangakuGemmenGaitoshaIchiranEditorImpl(NinteishaListSakuseiResultEntity entity, IOutputOrder outputOrder) {
        this.entity = entity;
        this.outputOrder = outputOrder;
    }

    /**
     * 利用負担額減額免除認定証項目を編集する
     *
     * @param source source
     * @return RiyoshaFutangakuGemmenGaitoshaIchiranReportSource
     */
    @Override
    public RiyoshaFutangakuGemmenGaitoshaIchiranReportSource edit(RiyoshaFutangakuGemmenGaitoshaIchiranReportSource source) {
        return edit項目(source);
    }

    private RiyoshaFutangakuGemmenGaitoshaIchiranReportSource edit項目(RiyoshaFutangakuGemmenGaitoshaIchiranReportSource source) {
        edit作成日時(source);
        source.title = entity.get帳票タイトル();
        source.hokenshaNo = entity.get導入団体コード();
        source.hokenshaName = entity.get導入団体名称();
        set出力順改頁(source);
        source.listUpper_1 = entity.get被保険者番号().getColumnValue();
        if (null != edit宛名()) {
            source.listUpper_2 = edit宛名().get住所().get郵便番号().getColumnValue();
            source.listUpper_3 = edit宛名().get名称().getName().getColumnValue();
            source.listUpper_4 = edit宛名().get年齢算出().get年齢();
        }
        if (entity.get利用者負担額減額Entity() != null) {
            FlexibleDate youShinseiYMD = entity.get利用者負担額減額Entity().getShinseiYMD();
            if (youShinseiYMD != null) {
                source.listUpper_5 = editFormmatDate(youShinseiYMD);
            }
            FlexibleDate teiYMD = entity.get利用者負担額減額Entity().getKetteiYMD();
            if (teiYMD != null) {
                source.listUpper_6 = editFormmatDate(teiYMD);
            }
        }
        source.listUpper_7 = eidt空白と空白以外(entity.is老齢福祉年金受給者());
        if (entity.get本人課税区分() != null) {
            if (KazeiKubun.課税.getコード().equals(entity.get本人課税区分())) {
                source.listUpper_8 = 課;
            } else {
                source.listUpper_8 = 空白;
            }
        }
        source.listUpper_9 = eidt空白と課(entity.is所得税課税者());
        source.listUpper_10 = eidt空白と空白以外(entity.is生活保護受給者());
        source.listUpper_11 = 空白;
        if (entity.get厚労省IF識別コード() != null && !entity.get厚労省IF識別コード().isEmpty()) {
            source.listUpper_12 = get要介護度(KoroshoInterfaceShikibetsuCode.toValue(
                    entity.get厚労省IF識別コード()), entity.get認定情報の要介護状態区分コード()).getName();
        }
        if (entity.get認定情報の認定年月日() != null && !entity.get認定情報の認定年月日().isEmpty()) {
            source.listUpper_13 = editFormmatDate(entity.get認定情報の認定年月日());
        } else {
            source.listUpper_13 = editFormmatDate(entity.get総者のチェックリスト実施日());
        }
        if (null != entity.get世帯員Entity().getPsmEntity()) {
            source.listUpper_14 = edit世帯員宛名().get名称().getName().getColumnValue();
            source.listUpper_15 = edit世帯員宛名().get住民状態().住民状態略称();
        }
        if (entity.get世帯員Entity() != null && entity.get世帯員Entity().get課税区分() != null) {
            if (KazeiKubun.課税.getコード().equals(entity.get世帯員Entity().get課税区分())) {
                source.listUpper_16 = 課;
            } else {
                source.listUpper_16 = 空白;
            }
        }
        if (entity.get世帯員Entity() != null && entity.get世帯員Entity().get課税所得額() != null) {
            if (Decimal.ZERO.compareTo(entity.get世帯員Entity().get課税所得額()) < 0) {
                source.listUpper_17 = 空白;
            } else {
                source.listUpper_17 = 課;
            }
        }

        source.listUpper_18 = 空白;
        edit項目１(source);
        edit項目2(source);
        return source;
    }

    private RiyoshaFutangakuGemmenGaitoshaIchiranReportSource
            set出力順改頁(RiyoshaFutangakuGemmenGaitoshaIchiranReportSource source) {
        List<ISetSortItem> list = new ArrayList<>();
        if (outputOrder != null && outputOrder.get設定項目リスト() != null && !outputOrder.get設定項目リスト().isEmpty()) {
            list = outputOrder.get設定項目リスト();
        }
        if (list.size() > INDEX_0) {
            source.shutsuryokujun1 = list.get(INDEX_0).get項目名();
        }
        if (list.size() > LISTINDEX_1) {
            source.shutsuryokujun2 = list.get(LISTINDEX_1).get項目名();
        }
        if (list.size() > INDEX_2) {
            source.shutsuryokujun3 = list.get(INDEX_2).get項目名();
        }
        if (list.size() > INDEX_3) {
            source.shutsuryokujun4 = list.get(INDEX_3).get項目名();
        }
        if (list.size() > LISTINDEX_4) {
            source.shutsuryokujun5 = list.get(LISTINDEX_4).get項目名();
        }
        if (list.size() > INDEX_0 && list.get(INDEX_0).is改頁項目()) {
            source.kaiPege1 = list.get(0).get項目名();
        }
        if (list.size() > LISTINDEX_1 && list.get(LISTINDEX_1).is改頁項目()) {
            source.kaiPege2 = list.get(LISTINDEX_1).get項目名();
        }
        if (list.size() > INDEX_2 && list.get(INDEX_2).is改頁項目()) {
            source.kaiPege3 = list.get(INDEX_2).get項目名();
        }
        if (list.size() > INDEX_3 && list.get(INDEX_3).is改頁項目()) {
            source.kaiPege4 = list.get(INDEX_3).get項目名();
        }
        if (list.size() > LISTINDEX_4 && list.get(LISTINDEX_4).is改頁項目()) {
            source.kaiPege5 = list.get(LISTINDEX_4).get項目名();
        }
        return source;
    }

    private RiyoshaFutangakuGemmenGaitoshaIchiranReportSource edit項目１(
            RiyoshaFutangakuGemmenGaitoshaIchiranReportSource source) {

        if (entity.get利用者負担額減額Entity() != null && entity.get利用者負担額減額Entity().getShoKisaiHokenshaNo() != null) {
            source.listCenter_1 = entity.get利用者負担額減額Entity().getShoKisaiHokenshaNo().getColumnValue();
        }
        if (null != edit宛名()) {
            source.listCenter_2 = edit宛名().get住所().get全国住所コード().getColumnValue();
            source.listCenter_3 = edit宛名().get住所().get住所();
            source.listCenter_4 = edit宛名().get住民状態().住民状態略称();
        }
        if (entity.get利用者負担額減額Entity() != null) {
            FlexibleDate youTekiyoKaishiYMD = entity.get利用者負担額減額Entity().getTekiyoKaishiYMD();
            if (youTekiyoKaishiYMD != null) {
                source.listCenter_5 = editFormmatDate(youTekiyoKaishiYMD);
            }
            FlexibleDate youTekiyoShuryoYMD = entity.get利用者負担額減額Entity().getTekiyoShuryoYMD();
            if (youTekiyoShuryoYMD != null) {
                source.listCenter_6 = editFormmatDate(youTekiyoShuryoYMD);
            }
        }
        source.listCenter_7 = entity.get入所施設コード();
        source.listCenter_8 = eidt空白と空白以外(entity.is旧措置者フラグ());
        source.listCenter_9 = editFormmatDate(entity.get認定情報の認定有効期間開始年月日());

        if (null != entity.get世帯員Entity().getPsmEntity()) {
            source.listCenter_10 = edit世帯員宛名().get名称().getName().getColumnValue();
            source.listCenter_11 = edit世帯員宛名().get住民状態().住民状態略称();
        }
        if (KazeiKubun.課税.getコード().equals(entity.get世帯員Entity().get課税区分())) {
            source.listCenter_12 = 課;
        } else {
            source.listCenter_12 = 空白;
        }
        if (entity.get世帯員Entity() != null && entity.get世帯員Entity().get課税所得額() != null) {
            if (Decimal.ZERO.compareTo(entity.get世帯員Entity().get課税所得額()) < 0) {
                source.listCenter_13 = 空白;
            } else {
                source.listCenter_13 = 課;
            }
        }
        source.listCenter_14 = 空白;
        return source;
    }

    private RiyoshaFutangakuGemmenGaitoshaIchiranReportSource edit項目2(
            RiyoshaFutangakuGemmenGaitoshaIchiranReportSource source) {
        if (null != edit宛名()) {
            source.listLower_1 = edit宛名().get行政区画().getGyoseiku().getコード().getColumnValue();
            source.listLower_2 = edit宛名().get行政区画().getGyoseiku().get名称();
        }
        if (entity.get利用者負担額減額Entity() != null && entity.get利用者負担額減額Entity().getKetteiKubun() != null) {
            if (KetteiKubun.承認しない.getコード().equals(entity.get利用者負担額減額Entity().getKetteiKubun())) {
                source.listLower_3 = 却下;
            } else if (KetteiKubun.承認する.getコード().equals(entity.get利用者負担額減額Entity().getKetteiKubun())) {
                source.listLower_3 = 承認;
            } else {
                source.listLower_3 = 空白;
            }
        }
        if (entity.get利用者負担額減額Entity() == null || entity.get利用者負担額減額Entity().getKyuhuritsu() == null) {
            source.listLower_4 = 空白;
        } else {
            HokenKyufuRitsu kyuhuritsu = entity.get利用者負担額減額Entity().getKyuhuritsu();
            if (kyuhuritsu != null) {
                Decimal 利用者負担額減額 = kyuhuritsu.getColumnValue();
                source.listLower_4 = new RString(利用者負担額減額.toString());
            }
        }
        source.listLower_5 = entity.get入所施設名称();
        source.listLower_6 = editFormmatDate(entity.get認定情報の認定有効期間終了年月日());
        if (null != entity.get世帯員Entity().getPsmEntity()) {
            source.listLower_7 = edit世帯員宛名().get名称().getName().getColumnValue();
            source.listLower_8 = edit世帯員宛名().get住民状態().住民状態略称();
        }
        if (entity.get世帯員Entity() != null && entity.get世帯員Entity().get課税区分() != null) {
            if (KazeiKubun.課税.getコード().equals(entity.get世帯員Entity().get課税区分())) {
                source.listLower_9 = 課;
            } else {
                source.listLower_9 = 空白;
            }
        }
        if (entity.get世帯員Entity() != null && entity.get世帯員Entity().get課税所得額() != null) {
            if (Decimal.ZERO.compareTo(entity.get世帯員Entity().get課税所得額()) < 0) {
                source.listLower_10 = 空白;
            } else {
                source.listLower_10 = 課;
            }
        }
        source.listLower_11 = 空白;
        return source;
    }

    private IKojin edit世帯員宛名() {
        if (null != entity.get世帯員Entity().getPsmEntity()) {
            return ShikibetsuTaishoFactory.createKojin(entity.get世帯員Entity().getPsmEntity());
        }
        return null;
    }

    private IYokaigoJotaiKubun get要介護度(KoroshoInterfaceShikibetsuCode 厚労省IF識別コード, RString 要介護状態区分コード) {
        if (要介護状態区分コード != null && !要介護状態区分コード.isEmpty()) {
            return YokaigoJotaiKubunSupport.toValue(厚労省IF識別コード, 要介護状態区分コード);
        }
        return YokaigoJotaiKubunSupport.toValue(厚労省IF識別コード, ZEROSIX);
    }

    private void edit作成日時(RiyoshaFutangakuGemmenGaitoshaIchiranReportSource source) {
        source.printTimeStamp = get帳票作成日時();
    }

    private RString get帳票作成日時() {
        if (entity.get帳票作成日時() == null) {
            return 空白;
        }
        RTime time = RDate.getNowTime();
        RString hour = new RString(time.toString()).substring(INDEX_0, INDEX_2);
        RString min = new RString(time.toString()).substring(INDEX_3, INDEX_5);
        RString sec = new RString(time.toString()).substring(INDEX_6, INDEX_8);
        RString timeFormat = hour.concat("時").concat(min).concat("分").concat(sec).concat("秒");
        return entity.get帳票作成日時().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(スペース).concat(timeFormat).concat(作成);
    }

    private IKojin edit宛名() {
        if (null != entity.getPsmEntity()) {
            return ShikibetsuTaishoFactory.createKojin(entity.getPsmEntity());
        }
        return null;
    }

    private RString editFormmatDate(FlexibleDate obj) {
        if (obj == null || obj.isEmpty()) {
            return 空白;
        }
        return obj.wareki().toDateString();
    }

    private RString eidt空白と空白以外(boolean obj) {
        RString naiYou;
        if (obj) {
            naiYou = ASTERISK;
        } else {
            naiYou = 空白;
        }
        return naiYou;
    }

    private RString eidt空白と課(boolean obj) {
        RString naiYou;
        if (obj) {
            naiYou = 課;
        } else {
            naiYou = 空白;
        }
        return naiYou;
    }
}
