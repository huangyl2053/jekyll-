/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraikin;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraikin.param.TokubetsuChoshuIraikingakuMeisaiIchiranInputParam;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuiraikin.TokubetsuChoshuIraikingakuMeisaiIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 帳票設計_DBBRP44002_特別徴収依頼金額明細一覧表のHeaderEditor
 *
 * @reamsid_L DBB-0880-080 zhangrui
 */
public class TokubetsuChoshuIraikingakuMeisaiIchiranHeaderEditor
        implements ITokubetsuChoshuIraikingakuMeisaiIchiranEditor {

    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final RString SAKUSEI = new RString("作成");
    private final RDateTime 調定日時;
    private final FlexibleYear 賦課年度;
    private final Association 地方公共団体;
    private final List<RString> 出力項目リスト;
    private final List<RString> 改頁項目リスト;

    /**
     * インスタンスを生成します。
     *
     * @param inputEntity
     * {@link TokubetsuChoshuIraikingakuMeisaiIchiranInputParam}
     */
    protected TokubetsuChoshuIraikingakuMeisaiIchiranHeaderEditor(
            TokubetsuChoshuIraikingakuMeisaiIchiranInputParam inputEntity) {
        this.調定日時 = inputEntity.get調定日時();
        this.賦課年度 = inputEntity.get賦課年度();
        this.地方公共団体 = inputEntity.get地方公共団体();
        this.出力項目リスト = inputEntity.get出力項目リスト();
        this.改頁項目リスト = inputEntity.get改頁項目リスト();
    }

    @Override
    public TokubetsuChoshuIraikingakuMeisaiIchiranSource edit(TokubetsuChoshuIraikingakuMeisaiIchiranSource source) {
        if (null != 調定日時) {
            RString date = 調定日時.getDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString time = 調定日時.getTime()
                    .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
            source.printTimeStamp = date.concat(RString.HALF_SPACE).concat(time);
        }
        if (null != 賦課年度) {
            source.nendo = 賦課年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .fillType(FillType.BLANK).toDateString();
            source.nendoTitle = 賦課年度.wareki().firstYear(FirstYear.ICHI_NEN).toDateString();
        }
        if (地方公共団体.get地方公共団体コード() != null) {
            source.hokenshaNo = 地方公共団体.get地方公共団体コード().value();
        }
        if (地方公共団体.get市町村名() != null) {
            source.hokenshaName = 地方公共団体.get市町村名();
        }
        set出力順And改ページ(source);
        return source;
    }

    private void set出力順And改ページ(TokubetsuChoshuIraikingakuMeisaiIchiranSource source) {
        if (null != 出力項目リスト && !出力項目リスト.isEmpty()) {
            if (出力項目リスト.size() > NUM_0) {
                source.shutsuryokujun1 = 出力項目リスト.get(NUM_0);
            }
            if (出力項目リスト.size() > NUM_1) {
                source.shutsuryokujun2 = 出力項目リスト.get(NUM_1);
            }
            if (出力項目リスト.size() > NUM_2) {
                source.shutsuryokujun3 = 出力項目リスト.get(NUM_2);
            }
            if (出力項目リスト.size() > NUM_3) {
                source.shutsuryokujun4 = 出力項目リスト.get(NUM_3);
            }
            if (出力項目リスト.size() > NUM_4) {
                source.shutsuryokujun5 = 出力項目リスト.get(NUM_4);
            }
        }
        if (null != 改頁項目リスト && !改頁項目リスト.isEmpty()) {
            if (改頁項目リスト.size() > NUM_0) {
                source.kaipage1 = 改頁項目リスト.get(NUM_0);
            }
            if (改頁項目リスト.size() > NUM_1) {
                source.kaipage2 = 改頁項目リスト.get(NUM_1);
            }
            if (改頁項目リスト.size() > NUM_2) {
                source.kaipage3 = 改頁項目リスト.get(NUM_2);
            }
            if (改頁項目リスト.size() > NUM_3) {
                source.kaipage4 = 改頁項目リスト.get(NUM_3);
            }
            if (改頁項目リスト.size() > NUM_4) {
                source.kaipage5 = 改頁項目リスト.get(NUM_4);
            }
        }
    }

}
