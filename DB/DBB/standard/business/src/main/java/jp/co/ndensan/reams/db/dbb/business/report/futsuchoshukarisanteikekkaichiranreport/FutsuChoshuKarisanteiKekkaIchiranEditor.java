/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.futsuchoshukarisanteikekkaichiranreport;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.futsuchoshukarisanteikekkaichiranreport.FuchoKariKeisanGoFukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.futsuchoshukarisanteikekkaichiranreport.FutsuChoshuKarisanteiKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ue.uex.definition.core.UEXCodeShubetsu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 普徴仮算定計算後賦課Editor
 *
 * @reamsid_L DBB-0870-030 surun
 */
public class FutsuChoshuKarisanteiKekkaIchiranEditor implements IFutsuChoshuKarisanteiKekkaIchiranEditor {

    private static final RString 定数4月 = new RString("4月");
    private static final RString 定数5月 = new RString("5月");
    private static final RString 定数6月 = new RString("6月");
    private static final RString 定数7月 = new RString("7月");
    private static final RString 定数8月 = new RString("8月");
    private static final RString 定数9月 = new RString("9月");
    private static final RString SAKUSEI = new RString("作成");
    private static final RString 徴収方法_普通徴収 = new RString("普通徴収");
    private static final RString 徴収方法_併用徴収 = new RString("併用徴収");
    private final FuchoKariKeisanGoFukaEntity 普徴仮算定計算後賦課;
    private final ReportId 帳票分類ID = new ReportId(new RString("DBB200009_HonsanteiKekkaIcihiran"));
    private final FlexibleYear 調定年度;
    private final FlexibleYear 賦課年度;
    private final YMDHMS 調定日時;
    private final Association association;
    private final List<RString> 出力項目リスト;
    private final List<RString> 改頁項目リスト;
    private final int 連番;
    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM2 = 2;
    private static final int NUM3 = 3;
    private static final int NUM4 = 4;

    /**
     * コンストラクタです
     *
     * @param 普徴仮算定計算後賦課 FuchoKariKeisanGoFukaEntity
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param association Association
     * @param 出力項目リスト List<RString>
     * @param 改頁項目リスト List<RString>
     * @param 連番 int
     */
    public FutsuChoshuKarisanteiKekkaIchiranEditor(FuchoKariKeisanGoFukaEntity 普徴仮算定計算後賦課, FlexibleYear 調定年度,
            FlexibleYear 賦課年度, YMDHMS 調定日時, Association association, List<RString> 出力項目リスト, List<RString> 改頁項目リスト,
            int 連番) {
        this.普徴仮算定計算後賦課 = 普徴仮算定計算後賦課;
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.調定日時 = 調定日時;
        this.association = association;
        this.出力項目リスト = 出力項目リスト;
        this.改頁項目リスト = 改頁項目リスト;
        this.連番 = 連番;
    }

    @Override
    public FutsuChoshuKarisanteiKekkaIchiranSource edit(FutsuChoshuKarisanteiKekkaIchiranSource source) {
        if (調定日時 != null && !調定日時.isEmpty()) {
            RString 調定日 = 調定日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 調定時 = 調定日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            source.printTimeStamp = 調定日.concat(RString.HALF_SPACE).concat(調定時).concat(RString.HALF_SPACE).concat(SAKUSEI);
        }
        if (賦課年度 != null && !賦課年度.isEmpty()) {
            source.nendo = 賦課年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK).toDateString();
        }
        if (association != null) {
            source.hokenshaNo = association.get地方公共団体コード().value();
            source.hokenshaName = association.get市町村名();
        }
        set出力改頁(source);
        source.listUpper_1 = new RString(連番);
        if (普徴仮算定計算後賦課 != null && 普徴仮算定計算後賦課.get宛名の情報() != null) {
            IKojin iKojin = ShikibetsuTaishoFactory.createKojin(普徴仮算定計算後賦課.get宛名の情報());
            ChohyoSeigyoKyotsu 帳票制御共通 = new ChohyoSeigyoKyotsu(SubGyomuCode.DBB介護賦課, 帳票分類ID);
            EditedKojin 編集後個人 = new EditedKojin(iKojin, 帳票制御共通, null);
            source.listUpper_2 = 編集後個人.get郵便番号();
            source.listUpper_3 = 編集後個人.get町域();
            source.listUpper_5 = 編集後個人.get生年月日For帳票();
            source.listUpper_6 = 編集後個人.get性別();
            if (編集後個人.get世帯主名() != null) {
                source.listUpper_7 = 編集後個人.get世帯主名().getColumnValue();
            }
        }

        if (普徴仮算定計算後賦課 != null && 普徴仮算定計算後賦課.get宛名の情報() != null) {
            source.listUpper_4 = 普徴仮算定計算後賦課.get宛名の情報().getGyoseikuName();
        }
        setListCenter(source);
        setListCenterTwo(source);
        setlistLower(source);
        setlistLowerTwo(source);
        return source;
    }

    private void set出力改頁(FutsuChoshuKarisanteiKekkaIchiranSource source) {
        if (NUM0 < 出力項目リスト.size()) {
            source.shutsuryokujun1 = 出力項目リスト.get(NUM0);
            if (NUM0 < 改頁項目リスト.size()) {
                source.kaipage1 = 改頁項目リスト.get(NUM0);
            }
        }
        if (NUM1 < 出力項目リスト.size()) {
            source.shutsuryokujun2 = 出力項目リスト.get(NUM1);
            if (NUM1 < 改頁項目リスト.size()) {
                source.kaipage2 = 改頁項目リスト.get(NUM1);
            }
        }
        if (NUM2 < 出力項目リスト.size()) {
            source.shutsuryokujun3 = 出力項目リスト.get(NUM2);
            if (NUM2 < 改頁項目リスト.size()) {
                source.kaipage3 = 改頁項目リスト.get(NUM2);
            }
        }
        if (NUM3 < 出力項目リスト.size()) {
            source.shutsuryokujun4 = 出力項目リスト.get(NUM3);
            if (NUM3 < 改頁項目リスト.size()) {
                source.kaipage4 = 改頁項目リスト.get(NUM3);
            }
        }
        if (NUM4 < 出力項目リスト.size()) {
            source.shutsuryokujun5 = 出力項目リスト.get(NUM4);
            if (NUM4 < 改頁項目リスト.size()) {
                source.kaipage5 = 改頁項目リスト.get(NUM4);
            }
        }
    }

    /**
     * setListCenter
     *
     * @param source FutsuChoshuKarisanteiKekkaIchiranSource
     */
    private void setListCenter(FutsuChoshuKarisanteiKekkaIchiranSource source) {
        if (普徴仮算定計算後賦課 != null && 普徴仮算定計算後賦課.get通知書番号() != null) {
            source.listCenter_1 = 普徴仮算定計算後賦課.get通知書番号().getColumnValue();
        }
        if (普徴仮算定計算後賦課 != null && 普徴仮算定計算後賦課.get世帯コード() != null) {
            source.listCenter_2 = 普徴仮算定計算後賦課.get世帯コード().getColumnValue();
        }
        if (普徴仮算定計算後賦課 != null && 普徴仮算定計算後賦課.get宛名の情報() != null) {
            AtenaMeisho atenaMeisho = 普徴仮算定計算後賦課.get宛名の情報().getKanjiShimei();
            if (atenaMeisho != null) {
                source.listCenter_3 = atenaMeisho.getColumnValue();
            }
        }
        if (普徴仮算定計算後賦課 != null && 普徴仮算定計算後賦課.get特別徴収業務者コード() != null
                && !普徴仮算定計算後賦課.get特別徴収業務者コード().isEmpty()) {
            source.listCenter_4 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                    new Code(普徴仮算定計算後賦課.get特別徴収業務者コード()));
        }
    }

    /**
     * setListCenterTwo
     *
     * @param source FutsuChoshuKarisanteiKekkaIchiranSource
     */
    private void setListCenterTwo(FutsuChoshuKarisanteiKekkaIchiranSource source) {
        if (普徴仮算定計算後賦課 != null && 普徴仮算定計算後賦課.get本徴収年金コード() != null
                && !普徴仮算定計算後賦課.get本徴収年金コード().isEmpty() && 普徴仮算定計算後賦課.get本徴収年金コード().length() >= NUM3) {
            source.listCenter_5 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, UEXCodeShubetsu.年金コード.getCodeShubetsu(),
                    new Code(普徴仮算定計算後賦課.get本徴収年金コード().substring(0, NUM3)));
        }
        source.listCenter_6 = 定数4月;
        if (普徴仮算定計算後賦課 != null && 普徴仮算定計算後賦課.get特徴期別金額01() != null) {
            source.listCenter_7 = DecimalFormatter.toコンマ区切りRString(普徴仮算定計算後賦課.get特徴期別金額01(), 0);
        }
        source.listCenter_8 = 定数5月;
        if (普徴仮算定計算後賦課 != null && 普徴仮算定計算後賦課.get特徴期別金額02() != null) {
            source.listCenter_9 = DecimalFormatter.toコンマ区切りRString(普徴仮算定計算後賦課.get特徴期別金額02(), 0);
        }
        source.listCenter_10 = 定数6月;
        if (普徴仮算定計算後賦課 != null && 普徴仮算定計算後賦課.get特徴期別金額03() != null) {
            source.listCenter_11 = DecimalFormatter.toコンマ区切りRString(普徴仮算定計算後賦課.get特徴期別金額03(), 0);
        }
    }

    /**
     * setlistLower
     *
     * @param source FutsuChoshuKarisanteiKekkaIchiranSource
     */
    private void setlistLower(FutsuChoshuKarisanteiKekkaIchiranSource source) {
        if (普徴仮算定計算後賦課 != null && 普徴仮算定計算後賦課.get前年度賦課の情報() != null) {
            if (普徴仮算定計算後賦課.get前年度賦課の情報().getHokenryoDankai2() != null) {
                source.listLower_1 = 普徴仮算定計算後賦課.get前年度賦課の情報().getHokenryoDankai2();
            } else {
                source.listLower_1 = 普徴仮算定計算後賦課.get前年度賦課の情報().getHokenryoDankai1();
            }
            if (普徴仮算定計算後賦課.get前年度賦課の情報().getNengakuHokenryo2() != null) {
                source.listLower_2 = DecimalFormatter.toコンマ区切りRString(普徴仮算定計算後賦課.get前年度賦課の情報().getNengakuHokenryo2(), 0);
            } else {
                source.listLower_2 = DecimalFormatter.toコンマ区切りRString(普徴仮算定計算後賦課.get前年度賦課の情報().getNengakuHokenryo1(), 0);
            }
        }
        //TODO
        source.listLower_3 = null;
        if (普徴仮算定計算後賦課 != null && 普徴仮算定計算後賦課.get前年度賦課の情報() != null
                && 普徴仮算定計算後賦課.get前年度賦課の情報().getGemmenMaeHokenryo() != null) {
            source.listLower_4 = DecimalFormatter.toコンマ区切りRString(普徴仮算定計算後賦課.get前年度賦課の情報().getGemmenMaeHokenryo(), 0);
        }

        FlexibleYear 前年度 = new FlexibleYear(new RString(調定年度.getYearValue() - 1));
        FuchoKiUtil fuchoKiUtil = new FuchoKiUtil(前年度);
        KitsukiList 普徴期月リスト = fuchoKiUtil.get期月リスト();
        Kitsuki 最終法定納期 = 普徴期月リスト.get最終法定納期();
        int 納期数 = 最終法定納期.get期AsInt();
        source.listLower_5 = new RString(納期数);
        //TODO
        source.listLower_6 = null;
        if (普徴仮算定計算後賦課 != null) {
            Decimal 合計値 = 普徴仮算定計算後賦課.get特徴期別金額01().add(普徴仮算定計算後賦課.get特徴期別金額02()).
                    add(普徴仮算定計算後賦課.get特徴期別金額03());
            if (合計値.intValue() == NUM0) {
                source.listLower_7 = 徴収方法_普通徴収;
            } else if (合計値.intValue() > NUM1) {
                source.listLower_7 = 徴収方法_併用徴収;
            }
        }

    }

    /**
     * setlistLowerTwo
     *
     * @param source FutsuChoshuKarisanteiKekkaIchiranSource
     */
    private void setlistLowerTwo(FutsuChoshuKarisanteiKekkaIchiranSource source) {
        source.listLower_8 = 定数4月;
        if (普徴仮算定計算後賦課 != null && 普徴仮算定計算後賦課.get普徴期別金額01() != null) {
            source.listLower_9 = DecimalFormatter.toコンマ区切りRString(普徴仮算定計算後賦課.get普徴期別金額01(), 0);
        }
        source.listLower_10 = 定数5月;
        if (普徴仮算定計算後賦課 != null && 普徴仮算定計算後賦課.get普徴期別金額02() != null) {
            source.listLower_11 = DecimalFormatter.toコンマ区切りRString(普徴仮算定計算後賦課.get普徴期別金額02(), 0);
        }
        source.listLower_12 = 定数6月;
        if (普徴仮算定計算後賦課 != null && 普徴仮算定計算後賦課.get普徴期別金額03() != null) {
            source.listLower_13 = DecimalFormatter.toコンマ区切りRString(普徴仮算定計算後賦課.get普徴期別金額03(), 0);
        }
        source.listLower_14 = 定数7月;
        if (普徴仮算定計算後賦課 != null && 普徴仮算定計算後賦課.get普徴期別金額04() != null) {
            source.listLower_15 = DecimalFormatter.toコンマ区切りRString(普徴仮算定計算後賦課.get普徴期別金額04(), 0);
        }
        source.listLower_16 = 定数8月;
        if (普徴仮算定計算後賦課 != null && 普徴仮算定計算後賦課.get普徴期別金額05() != null) {
            source.listLower_17 = DecimalFormatter.toコンマ区切りRString(普徴仮算定計算後賦課.get普徴期別金額05(), 0);
        }
        source.listLower_18 = 定数9月;
        if (普徴仮算定計算後賦課 != null && 普徴仮算定計算後賦課.get普徴期別金額06() != null) {
            source.listLower_19 = DecimalFormatter.toコンマ区切りRString(普徴仮算定計算後賦課.get普徴期別金額06(), 0);
        }
        source.listLower_20 = RString.EMPTY;
    }

}
