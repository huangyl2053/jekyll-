/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200101gokei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hurikomiitiran.gokeidata.GokeiDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200101gokei.FurikomiMeisaiIchiranGokeiReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 振込明細一覧表（合計）Editorです。
 *
 * @reamsid_L DBC-2180-040 b_liuyang2
 */
public class FurikomiMeisaiIchiranGokeiEditor implements IFurikomiMeisaiIchiranGokeiEditor {

    private static final int LISTINDEX_3 = 3;
    private static final int LISTINDEX_4 = 4;
    private static final int LISTINDEX_8 = 8;
    private static final RString 作成 = new RString("作成");

    private final GokeiDataEntity 合計データリスト;
    private final IOutputOrder 出力順;
    private final RString 設定値;
    private final RDateTime 作成日時;

    /**
     * インスタンスを生成します。
     *
     * @param 合計データリスト GokeiDataEntity
     * @param 出力順 IOutputOrder
     * @param 設定値 RString
     * @param 作成日時 RDateTime
     */
    protected FurikomiMeisaiIchiranGokeiEditor(GokeiDataEntity 合計データリスト, IOutputOrder 出力順,
            RString 設定値, RDateTime 作成日時) {
        this.合計データリスト = 合計データリスト;
        this.出力順 = 出力順;
        this.設定値 = 設定値;
        this.作成日時 = 作成日時;
    }

    @Override
    public FurikomiMeisaiIchiranGokeiReportSource edit(FurikomiMeisaiIchiranGokeiReportSource source) {
        editHeader(source);
        edit明細(source);
        return source;
    }

    private void editHeader(FurikomiMeisaiIchiranGokeiReportSource source) {
        source.printTimeStamp = new RStringBuilder()
                .append(作成日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                        .fillType(FillType.BLANK).toDateString())
                .append(RString.FULL_SPACE)
                .append(作成日時.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒))
                .append(RString.FULL_SPACE)
                .append(作成).toRString();
        if (null != this.設定値) {
            source.title = this.設定値;
        }
        source.hokenshaNo = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        source.hokenshaName = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (null != this.出力順 && (null != this.出力順.get設定項目リスト() && !this.出力順.get設定項目リスト().isEmpty())) {
            List<ISetSortItem> 設定項目リスト = this.出力順.get設定項目リスト();
            if (!設定項目リスト.isEmpty()) {
                source.shutsuryokujun1 = 設定項目リスト.get(0).get項目名();
            }
            if (設定項目リスト.size() > 1) {
                source.shutsuryokujun2 = 設定項目リスト.get(1).get項目名();
            }
            if (設定項目リスト.size() > 2) {
                source.shutsuryokujun2 = 設定項目リスト.get(2).get項目名();
            }
            if (設定項目リスト.size() > LISTINDEX_3) {
                source.shutsuryokujun2 = 設定項目リスト.get(LISTINDEX_3).get項目名();
            }
            if (設定項目リスト.size() > LISTINDEX_4) {
                source.shutsuryokujun2 = 設定項目リスト.get(LISTINDEX_4).get項目名();
            }
        }
    }

    private void edit明細(FurikomiMeisaiIchiranGokeiReportSource source) {
        if (null != this.合計データリスト) {
            if (null != this.合計データリスト.get様式名称()) {
                get様式名称(source);
            }
            if (null != this.合計データリスト.get要介護件数()) {
                source.list_2 = DecimalFormatter.toコンマ区切りRString(this.合計データリスト.get要介護件数(), 0);
            }
            if (null != this.合計データリスト.get要介護金額()) {
                source.list_3 = DecimalFormatter.toコンマ区切りRString(this.合計データリスト.get要介護金額(), 0);
            }
            if (null != this.合計データリスト.get要支援件数()) {
                source.list_4 = DecimalFormatter.toコンマ区切りRString(this.合計データリスト.get要支援件数(), 0);
            }
            if (null != this.合計データリスト.get要支援金額()) {
                source.list_5 = DecimalFormatter.toコンマ区切りRString(this.合計データリスト.get要支援金額(), 0);
            }
            if (null != this.合計データリスト.getその他件数()) {
                source.list_6 = DecimalFormatter.toコンマ区切りRString(this.合計データリスト.getその他件数(), 0);
            }
            if (null != this.合計データリスト.getその他金額()) {
                source.list_7 = DecimalFormatter.toコンマ区切りRString(this.合計データリスト.getその他金額(), 0);
            }
            if (null != this.合計データリスト.get要介護件数()
                    || null != this.合計データリスト.get要支援件数()
                    || null != this.合計データリスト.getその他件数()) {
                Decimal 要介護件数 = this.合計データリスト.get要介護件数();
                Decimal 要支援件数 = this.合計データリスト.get要支援件数();
                Decimal その他件数 = this.合計データリスト.getその他件数();
                source.list_8 = DecimalFormatter.toコンマ区切りRString(要介護件数.add(要支援件数).add(その他件数), 0);
            }
            if (null != this.合計データリスト.get要介護金額()
                    || null != this.合計データリスト.get要支援金額()
                    || null != this.合計データリスト.getその他金額()) {
                Decimal 要介護金額 = this.合計データリスト.get要介護金額();
                Decimal 要支援金額 = this.合計データリスト.get要支援金額();
                Decimal その他金額 = this.合計データリスト.getその他金額();
                source.list_9 = DecimalFormatter.toコンマ区切りRString(要介護金額.add(要支援金額).add(その他金額), 0);
            }
        }
    }

    private void get様式名称(FurikomiMeisaiIchiranGokeiReportSource source) {
        if (this.合計データリスト.get様式名称().length() <= LISTINDEX_8) {
            source.list_1 = this.合計データリスト.get様式名称();
        } else {
            source.list_1 = this.合計データリスト.get様式名称().substring(0, LISTINDEX_8);
        }
    }
}
