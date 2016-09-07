/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd2020001;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * DBDMN32001_2_支払方法変更管理バッチパラメタークラスです．
 *
 * @reamsid_L DBD-3650-030 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoHaakuKanriBatchParameter extends BatchParameterBase {

    private static final String KIJUNYMD = "kijunYMD";
    private static final String TOUROKUSYASENNTAKU = "tourokuSyaSenntaku";
    private static final String SASHITOMEYOKOKU = "sashitomeYokoku";
    private static final String SASHITOME = "sashitome";
    private static final String SHOUKANNYOKOKU = "shoukannYokoku";
    private static final String SHOUKANNKETTEI = "shoukannKettei";
    private static final String SHOUKANNKETTEISASHITOME = "shoukannKetteiSashitome";
    private static final String SHOUKANNKETTEIHOKENNRYOU = "shoukannKetteiHokennryou";
    private static final String CHANGEPAGEOUTPUTJUNNID = "changePageOutputJunnId";
    private static final String REPORTBUNNRUIID = "reportBunnruiId";
    private static final String REPORTID = "reportId";
    private static final String REPORTCREATEDATETIME = "reportCreateDateTime";

    @BatchParameter(key = KIJUNYMD, name = "基準日")
    private FlexibleDate 基準日;
    @BatchParameter(key = TOUROKUSYASENNTAKU, name = "登録者選択")
    private RString 登録者選択;
    @BatchParameter(key = SASHITOMEYOKOKU, name = "差止予告登録者２号の選択")
    private RString 差止予告登録者２号の選択;
    @BatchParameter(key = SASHITOME, name = "差止登録者２号の選択")
    private RString 差止登録者２号の選択;
    @BatchParameter(key = SHOUKANNYOKOKU, name = "償還予告登録者１号の選択")
    private RString 償還予告登録者１号の選択;
    @BatchParameter(key = SHOUKANNKETTEI, name = "償還決定登録者１号の選択")
    private RString 償還決定登録者１号の選択;
    @BatchParameter(key = SHOUKANNKETTEISASHITOME, name = "償還決定登録者１号_差止中あり者のみの選択年度")
    private RString 償還決定登録者１号_差止中あり者のみの選択;
    @BatchParameter(key = SHOUKANNKETTEIHOKENNRYOU, name = "償還決定登録者１号_保険料控除あり者のみの選択")
    private RString 償還決定登録者１号_保険料控除あり者のみの選択;
    @BatchParameter(key = CHANGEPAGEOUTPUTJUNNID, name = "改頁出力順ID")
    private RString 改頁出力順ID;
    @BatchParameter(key = REPORTBUNNRUIID, name = "帳票分類ID")
    private ReportId 帳票分類ID;
    @BatchParameter(key = REPORTID, name = "帳票ID")
    private ReportId 帳票ID;
    @BatchParameter(key = REPORTCREATEDATETIME, name = "帳票作成日時")
    private RDateTime 帳票作成日時;
}
