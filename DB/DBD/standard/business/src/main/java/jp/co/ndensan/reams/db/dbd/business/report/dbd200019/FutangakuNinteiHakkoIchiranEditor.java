/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200019;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangakuninteihakkoichiran.FutangakuNinteiHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200019.FutangakuNinteiHakkoIchiranReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 負担額認定証・決定通知書発行一覧表Editorです。
 *
 * @reamsid_L DBD-3981-060 b_liuyang2
 */
public class FutangakuNinteiHakkoIchiranEditor implements IFutangakuNinteiHakkoIchiranEditor {

    private static final int LISTINDEX_0 = 0;
    private static final int LISTINDEX_1 = 1;
    private static final int LISTINDEX_2 = 2;
    private static final int LISTINDEX_3 = 3;
    private static final int LISTINDEX_4 = 4;

    private final FutangakuNinteiHakkoIchiranEntity 帳票情報;
    private final Association association;
    private final IOutputOrder iOutputOrder;
    private final IKojin 個人情報;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票情報 FutanGenndoGakuNinnteiListRecordEntity
     * @param association Association
     * @param iOutputOrder IOutputOrder
     * @param 個人情報 IKojin
     * @param index int
     */
    public FutangakuNinteiHakkoIchiranEditor(FutangakuNinteiHakkoIchiranEntity 帳票情報,
            Association association, IOutputOrder iOutputOrder, IKojin 個人情報, int index) {
        this.帳票情報 = 帳票情報;
        this.association = association;
        this.iOutputOrder = iOutputOrder;
        this.個人情報 = 個人情報;
        this.index = index;
    }

    @Override
    public FutangakuNinteiHakkoIchiranReportSource edit(FutangakuNinteiHakkoIchiranReportSource source) {
        setLayer1Step1(source);
        setLayer1Step2(source);
        setAccessLogEditor(source);
        return source;
    }

    private void setLayer1Step1(FutangakuNinteiHakkoIchiranReportSource source) {
        source.printTimeStamp = get印刷日時();
        source.title = new RString("負担限度額認定証・決定通知書発行一覧表");
        if (null != association) {
            source.hokenshaNo = this.association.get地方公共団体コード().value();
            source.hokenshaName = this.association.get市町村名();
        }
        if (null != iOutputOrder) {
            source = set出力順改頁(source);
        }
        source.list_1 = new RString(String.valueOf(index + 1));
        if (null != 帳票情報) {
            FlexibleDate 喪失年月日 = this.帳票情報.get喪失年月日();
            if (null != 喪失年月日 && !喪失年月日.isEmpty()) {
                source.list_2 = new RString("*");
            }
            if (null != this.帳票情報.get被保険者番号()) {
                source.list_3 = this.帳票情報.get被保険者番号().value();
            }
            if (null != this.個人情報.get名称()) {
                source.list_4 = this.個人情報.get名称().getName().value();
            }
            if (null != this.個人情報.get住所()) {
                source.list_5 = this.個人情報.get住所().get住所();
            }
            if (null != this.帳票情報.get申請日()) {
                source.list_6 = this.帳票情報.get申請日().wareki().toDateString();
            }
        }
    }

    private void setLayer1Step2(FutangakuNinteiHakkoIchiranReportSource source) {
        if (null != 帳票情報) {

            if (null != this.帳票情報.get決定日()) {
                source.list_7 = this.帳票情報.get決定日().wareki().toDateString();
            }
            source.list_8 = get適用日有効期限();
            if (this.帳票情報.get決定().equals(KetteiKubun.承認する)) {
                source.list_9 = new RString("承認");
            } else if (this.帳票情報.get決定().equals(KetteiKubun.承認しない)) {
                source.list_9 = new RString("却下");
            }
            if (this.帳票情報.get決定().equals(KetteiKubun.承認する)) {
                source.list_10 = this.帳票情報.get負担段階();
            } else if (this.帳票情報.get決定().equals(KetteiKubun.承認しない)) {
                source.list_10 = RString.EMPTY;
            }
            if (this.帳票情報.is認定証発行フラグ() && this.帳票情報.is認定証発行済み()) {
                source.list_11 = new RString("○");
            }
            if (this.帳票情報.is認定証発行フラグ() && !this.帳票情報.is認定証発行済み()) {
                source.list_11 = new RString("却下");
            }
            if (!this.帳票情報.is認定証発行フラグ()) {
                source.list_11 = RString.EMPTY;
            }
            if (this.帳票情報.is通知書発行フラグ()) {
                source.list_12 = new RString("○");
            }
            if (null != this.帳票情報.get入所施設CD()) {
//                source.list_13 = this.帳票情報.get入所施設CD().getColumnValue();
            }
        }
    }

    private void setAccessLogEditor(FutangakuNinteiHakkoIchiranReportSource source) {
        if (個人情報 != null) {
            source.shikibetsuCode = this.個人情報.get識別コード().getColumnValue();
        }
    }

    private RString get印刷日時() {
        FlexibleDate システム日 = FlexibleDate.getNowDate();
        RTime システム日時 = RTime.now();
        RString 年月日 = システム日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 時分秒 = システム日時.toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        return 年月日.concat("").concat(時分秒).concat("").concat("作成");
    }

    private RString get適用日有効期限() {
        RString 適用日 = this.帳票情報.get適用日().wareki().toDateString();
        RString 有効期限 = this.帳票情報.get有効期限().wareki().toDateString();
        return 適用日.concat(new RString("~")).concat(有効期限);
    }

    private FutangakuNinteiHakkoIchiranReportSource set出力順改頁(FutangakuNinteiHakkoIchiranReportSource source) {
        List<ISetSortItem> 設定項目リスト = this.iOutputOrder.get設定項目リスト();
        if (設定項目リスト.size() > LISTINDEX_0) {
            source.shutsuryokujun1 = 設定項目リスト.get(LISTINDEX_0).get項目名();
            if (設定項目リスト.get(LISTINDEX_0).is改頁項目()) {
                source.kaipage1 = 設定項目リスト.get(LISTINDEX_0).get項目名();
            }
        }
        if (設定項目リスト.size() > LISTINDEX_1) {
            source.shutsuryokujun2 = 設定項目リスト.get(LISTINDEX_1).get項目名();
            if (設定項目リスト.get(LISTINDEX_1).is改頁項目()) {
                source.kaipage2 = 設定項目リスト.get(LISTINDEX_1).get項目名();
            }
        }
        if (設定項目リスト.size() > LISTINDEX_2) {
            source.shutsuryokujun3 = 設定項目リスト.get(LISTINDEX_2).get項目名();
            if (設定項目リスト.get(LISTINDEX_2).is改頁項目()) {
                source.kaipage3 = 設定項目リスト.get(LISTINDEX_2).get項目名();
            }
        }
        if (設定項目リスト.size() > LISTINDEX_3) {
            source.shutsuryokujun4 = 設定項目リスト.get(LISTINDEX_3).get項目名();
            if (設定項目リスト.get(LISTINDEX_3).is改頁項目()) {
                source.kaipage4 = 設定項目リスト.get(LISTINDEX_3).get項目名();
            }
        }
        if (設定項目リスト.size() > LISTINDEX_4) {
            source.shutsuryokujun5 = 設定項目リスト.get(LISTINDEX_4).get項目名();
            if (設定項目リスト.get(LISTINDEX_4).is改頁項目()) {
                source.kaipage5 = 設定項目リスト.get(LISTINDEX_4).get項目名();
            }
        }
        return source;
    }
}
