/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200022;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogakuninteishinseishohakkoichiran.FutanGendogakuNinteiShinseishoHakkoIchiran;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200022.FutanGendogakuNinteiShinseishoHakkoIchiranReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.SetaiKazeiKubun;
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
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 負担限度額認定申請書発行一覧表Editorです。
 *
 * @reamsid_L DBD-3530-090 b_liuyang2
 */
public class FutanGendogakuNinteiShinseishoHakkoIchiranEditor implements IFutanGendogakuNinteiShinseishoHakkoIchiranEditor {

    private static final int LISTINDEX_0 = 0;
    private static final int LISTINDEX_1 = 1;
    private static final int LISTINDEX_2 = 2;
    private static final int LISTINDEX_3 = 3;
    private static final int LISTINDEX_4 = 4;

    private final FutanGendogakuNinteiShinseishoHakkoIchiran 帳票情報;
    private final Association association;
    private final IOutputOrder iOutputOrder;
    private final IKojin 個人;
    private final int index;

    /**
     * インスタンスを生成します。
     *
     * @param 帳票情報 FutanGendogakuNinteiShinseishoHakkoIchiran
     * @param association Association
     * @param iOutputOrder IOutputOrder
     * @param 個人 IKojin
     * @param index int
     */
    public FutanGendogakuNinteiShinseishoHakkoIchiranEditor(FutanGendogakuNinteiShinseishoHakkoIchiran 帳票情報,
            Association association, IOutputOrder iOutputOrder, IKojin 個人, int index) {
        this.帳票情報 = 帳票情報;
        this.association = association;
        this.iOutputOrder = iOutputOrder;
        this.個人 = 個人;
        this.index = index;
    }

    @Override
    public FutanGendogakuNinteiShinseishoHakkoIchiranReportSource edit(FutanGendogakuNinteiShinseishoHakkoIchiranReportSource source) {
        setLayer1Step1(source);
        setLayer1Step2(source);
        setLayer1Step3(source);
        setAccessLogEditor(source);
        return source;
    }

    private void setLayer1Step1(FutanGendogakuNinteiShinseishoHakkoIchiranReportSource source) {
        source.printTimeStamp = get印刷日時();
        if (null != association) {
            source.hokenshaNo = this.association.get地方公共団体コード().value();
            source.hokenshaName = this.association.get市町村名();
        }
        if (null != iOutputOrder) {
            source = set出力順改頁(source);
        }
        source.hdrGekihenKanwa = RString.EMPTY;
        source.listUpper_1 = new RString(String.valueOf(index + 1));
        if (null != 帳票情報) {
            if (this.帳票情報.get被保番号() != null) {
                source.listUpper_2 = this.帳票情報.get被保番号().value();
            }
            if (this.帳票情報.get計画事業者コード() != null) {
                source.listUpper_4 = this.帳票情報.get計画事業者コード();
            }
            if (this.帳票情報.is自己作成()) {
                source.listUpper_5 = new RString("自己作成");
            } else if (this.帳票情報.get計画事業者名() != null) {
                source.listUpper_5 = this.帳票情報.get計画事業者名();
            }
            if (this.帳票情報.get利用者負担段階() != null) {
                source.listUpper_6 = this.帳票情報.get利用者負担段階().getコード();
            }
            if (this.帳票情報.is生保()) {
                source.listUpper_7 = new RString("*");
            }
            if (this.帳票情報.is老齢()) {
                source.listUpper_8 = new RString("*");
            }
            if (this.帳票情報.get申請年月日() != null) {
                source.listUpper_9 = this.帳票情報.get申請年月日().wareki().toDateString();
            }
            if (this.帳票情報.get適用日() != null) {
                source.listUpper_10 = this.帳票情報.get適用日().wareki().toDateString();
            }
        }
    }

    private void setLayer1Step2(FutanGendogakuNinteiShinseishoHakkoIchiranReportSource source) {
        if (null != 個人) {
            source.listUpper_3 = 個人.get名称().getName().value();
            source.listCenter_1 = 個人.get住所().get郵便番号().getEditedYubinNo();
            source.listCenter_2 = 個人.get住所().get住所();
        }
        if (null != 帳票情報) {
            RString 負担段階 = RString.EMPTY;
            if (this.帳票情報.get利用者負担段階() != null) {
                負担段階 = this.帳票情報.get利用者負担段階().getコード();
            }
            RString 負担段階名称 = RString.EMPTY;
            if (null != 負担段階 && !負担段階.isEmpty()) {
                負担段階名称 = new RString(RiyoshaFutanDankai.toValue(負担段階).name());
            }
            source.listUpper_11 = 負担段階名称;
            if (this.帳票情報.getユニット型順個室() != null) {
                source.listUpper_12 = DecimalFormatter.toコンマ区切りRString(this.帳票情報.getユニット型順個室(), 0);
            }
            if (this.帳票情報.get多床室() != null) {
                source.listUpper_13 = DecimalFormatter.toコンマ区切りRString(this.帳票情報.get多床室(), 0);
            }
            source.listCenter_3 = this.帳票情報.get入所施設コード();
            source.listCenter_4 = this.帳票情報.get入所施設名();
            if (this.帳票情報.get合計所得() != null) {
                source.listCenter_5 = DecimalFormatter.toコンマ区切りRString(this.帳票情報.get合計所得(), 0);
            }
            if (this.帳票情報.get決定年月日() != null) {
                source.listCenter_6 = this.帳票情報.get決定年月日().wareki().toDateString();
            }
            if (this.帳票情報.get有効期限() != null) {
                source.listCenter_7 = this.帳票情報.get有効期限().wareki().toDateString();
            }
            if (this.帳票情報.get食費負担額() != null) {
                source.listCenter_8 = DecimalFormatter.toコンマ区切りRString(this.帳票情報.get食費負担額(), 0);
            }
            if (this.帳票情報.get従来型特養() != null) {
                source.listCenter_9 = DecimalFormatter.toコンマ区切りRString(this.帳票情報.get従来型特養(), 0);
            }
            RString 決定区分 = RString.EMPTY;
            if (this.帳票情報.get決定区分() != null) {
                決定区分 = this.帳票情報.get決定区分().getコード();
            }
            RString 承認 = KetteiKubun.承認する.getコード();
            RString 承認しない = RiyoshaFutanDankai.課税層第三段階.getコード();
            if (決定区分.equals(承認) && null != 負担段階 && !負担段階.isEmpty() && 負担段階.equals(承認しない)) {
                source.listCenter_10 = new RString("該当");
            } else {
                source.listCenter_10 = new RString("非該当");
            }
        }
    }

    private void setLayer1Step3(FutanGendogakuNinteiShinseishoHakkoIchiranReportSource source) {
        if (null != 帳票情報) {
            if (this.帳票情報.get認定開始日() != null) {
                source.listLower_1 = this.帳票情報.get認定開始日().wareki().toDateString();
            }
            if (this.帳票情報.get認定終了日() != null) {
                source.listLower_2 = this.帳票情報.get認定終了日().wareki().toDateString();
            }
            source.listLower_3 = get要介護度();
            if (this.帳票情報.is旧措置フラグ()) {
                source.listLower_4 = new RString("*");
            }
            if (new RString("1").equals(this.帳票情報.get住所地特例フラグ())) {
                source.listLower_5 = new RString("*");
            }
            if (this.帳票情報.get非課税年金勘案額() != null) {
                source.listLower_6 = new RString("*");
            }
            if (this.帳票情報.get住民となった日() != null) {
                source.listLower_7 = this.帳票情報.get住民となった日().wareki().toDateString();
            }
            RString 世帯課税 = RString.EMPTY;
            RString 世帯課税名称 = RString.EMPTY;
            if (this.帳票情報.get世帯課税() != null) {
                世帯課税 = this.帳票情報.get世帯課税().getコード();
                世帯課税名称 = SetaiKazeiKubun.toValue(世帯課税).get名称();
            }
            source.listLower_8 = 世帯課税名称;
            RString 決定区分 = RString.EMPTY;
            if (this.帳票情報.get決定区分() != null) {
                決定区分 = this.帳票情報.get決定区分().getコード();
            }
            RString 承認 = KetteiKubun.承認する.getコード();
            if (決定区分.equals(承認)) {
                source.listLower_9 = new RString("承認");
            } else {
                source.listLower_9 = new RString("非承認");
            }
            if (this.帳票情報.get旧措置() != null) {
                source.listLower_10 = this.帳票情報.get旧措置().getコード();
            }
            if (this.帳票情報.getユニット型個室() != null) {
                source.listLower_11 = new RString(this.帳票情報.getユニット型個室().toString());
            }
            if (this.帳票情報.get従来型老健() != null) {
                source.listLower_11 = new RString(this.帳票情報.get従来型老健().toString());
            }
        }
    }

    private void setAccessLogEditor(FutanGendogakuNinteiShinseishoHakkoIchiranReportSource source) {
        if (null != 個人) {
            source.shikibetsuCode = this.個人.get識別コード().getColumnValue();
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

    private RString get要介護度() {
        RString 要介護認定状態区分コード = this.帳票情報.get要介護認定状態区分コード();
        if (要介護認定状態区分コード != null && this.帳票情報.get厚労省IF識別コード() != null) {
            KoroshoInterfaceShikibetsuCode 厚労省IF識別コード = KoroshoInterfaceShikibetsuCode.toValue(this.帳票情報.get厚労省IF識別コード());
            return YokaigoJotaiKubunSupport.toValue(厚労省IF識別コード, 要介護認定状態区分コード).getName();
        }
        return RString.EMPTY;
    }

    private FutanGendogakuNinteiShinseishoHakkoIchiranReportSource set出力順改頁(FutanGendogakuNinteiShinseishoHakkoIchiranReportSource source) {
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
