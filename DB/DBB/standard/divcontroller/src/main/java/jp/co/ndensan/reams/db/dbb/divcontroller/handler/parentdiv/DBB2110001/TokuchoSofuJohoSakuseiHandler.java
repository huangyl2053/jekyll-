/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2110001;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchosofu.TokuChoSoufuJohoSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB211001.DBB211001_TokuchoSofuJohoSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2110001.TokuchoSofuJohoSakuseiDiv;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchosofu.TokuChoSoufuJohoSakusei;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.OutputChohyoIchiran.dgOutputChohyoIchiran_Row;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 画面設計_DBBGM82001_1_特徴送付情報作成のハンドラクラス
 *
 * @reamsid_L DBB-1840-010 zhangrui
 */
public final class TokuchoSofuJohoSakuseiHandler {

    private final TokuchoSofuJohoSakuseiDiv div;

    private static final RString 特徴開始月_4月 = new RString("04");
    private static final RString 漢字_月 = new RString("月");
    private static final RString 実行する = new RString("btnSakusei");
    private static final RString 帳票グループコード = new RString("DBB2110001");
    private static final RString 特別徴収依頼情報一覧表ID = new RString("DBB200019_TokubetsuChoshuIraiJohoIchiran");
    private static final RString 特別徴収異動情報一覧表ID = new RString("DBB200021_TokubetsuChoshuIdojohoIchiran");

    private static final int 月分_1 = 1;
    private static final int 月分_2 = 2;
    private static final int 月分_3 = 3;
    private static final int 月分_4 = 4;
    private static final int 月分_5 = 5;
    private static final int 月分_6 = 6;
    private static final int 月分_7 = 7;
    private static final int 月分_8 = 8;
    private static final int 月分_9 = 9;
    private static final int 月分_10 = 10;
    private static final int 月分_11 = 11;

    private Map<RString, YMDHMS> 処理日時Map = new HashMap<>();

    /**
     * コンストラクタ
     *
     * @param div
     */
    private TokuchoSofuJohoSakuseiHandler(TokuchoSofuJohoSakuseiDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです
     *
     * @param div 画面DIV
     * @return Mainハンドラークラス
     */
    public static TokuchoSofuJohoSakuseiHandler of(TokuchoSofuJohoSakuseiDiv div) {
        return new TokuchoSofuJohoSakuseiHandler(div);
    }

    /**
     * 画面初期化処理です。
     *
     */
    public void onload() {
        do初期値取得();
    }

    private void do初期値取得() {
        RDate now = RDate.getNowDate();
        TokuChoSoufuJohoSakusei manager = TokuChoSoufuJohoSakusei.createInstance();
        FlexibleYear 賦課年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                now, SubGyomuCode.DBB介護賦課));
        処理日時Map = manager.getShoriDate(賦課年度);
        set処理日時(処理日時Map);
        日付関連_所得年度コンフィグによる制御(賦課年度);
        set初期状態(now);

        div.getCcdOutputChohyoIchiran().load(SubGyomuCode.DBB介護賦課, 帳票グループコード);
        List<dgOutputChohyoIchiran_Row> chohyoList = div.getCcdOutputChohyoIchiran().get出力帳票一覧();
        if (null != chohyoList) {
            for (dgOutputChohyoIchiran_Row row : chohyoList) {
                row.setSelected(Boolean.FALSE);
            }
        }
    }

    private void set初期状態(RDate now) {
        int month = now.getMonthValue();
        switch (month) {
            case 月分_1:
                div.getChkSentaku01().setVisible(true);
                div.getChkSentaku02().setVisible(true);
                break;
            case 月分_2:
                div.getChkSentaku02().setVisible(true);
                div.getChkSentaku03().setVisible(true);
                break;
            case 月分_3:
                div.getChkSentaku03().setVisible(true);
                div.getChkSentaku04().setVisible(true);
                break;
            case 月分_4:
                div.getChkSentaku04().setVisible(true);
                div.getChkSentaku05().setVisible(true);
                break;
            case 月分_5:
                div.getChkSentaku05().setVisible(true);
                div.getChkSentaku06().setVisible(true);
                break;
            case 月分_6:
                div.getChkSentaku06().setVisible(true);
                div.getChkSentaku07().setVisible(true);
                break;
            case 月分_7:
                div.getChkSentaku07().setVisible(true);
                div.getChkSentaku08().setVisible(true);
                break;
            case 月分_8:
                div.getChkSentaku08().setVisible(true);
                div.getChkSentaku09().setVisible(true);
                break;
            case 月分_9:
                div.getChkSentaku09().setVisible(true);
                div.getChkSentaku10().setVisible(true);
                break;
            case 月分_10:
                div.getChkSentaku10().setVisible(true);
                div.getChkSentaku11().setVisible(true);
                break;
            case 月分_11:
                div.getChkSentaku11().setVisible(true);
                div.getChkSentaku12().setVisible(true);
                break;
            default:
                div.getChkSentaku12().setVisible(true);
                div.getChkSentaku01().setVisible(true);
        }
        RString key_06月捕捉 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_6月捕捉, now,
                SubGyomuCode.DBB介護賦課);
        RString key_08月捕捉 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_8月捕捉, now,
                SubGyomuCode.DBB介護賦課);
        if (特徴開始月_4月.equals(key_06月捕捉)) {
            div.getIcoTokuchotsuikaIrai10().setVisible(false);
        }
        if (特徴開始月_4月.equals(key_08月捕捉)) {
            div.getIcoTokuchotsuikaIrai12().setVisible(false);
        }
    }

    /**
     * 排他選択です。
     *
     * @param flag RString
     * @return RString
     */
    public RString doExclusiveChk(RString flag) {
        int count = getSelectedCount();
        if (count == 0) {
            flag = RString.EMPTY;
        } else if (count == 1) {
            CheckBoxList selected = getSelectedCheckBox();
            flag = selected.getSelectControlID();
        } else {
            RString flag1 = doExclusive(flag);
            RString flag2 = doExclusive2(flag);
            if (RString.isNullOrEmpty(flag1)) {
                flag = flag2;
            } else {
                flag = flag1;
            }
        }
        Entry<RString, Boolean> entry = get処理対象月();
        YMDHMS now = YMDHMS.now();
        RString 本月 = new RString(now.getMonthValue()).concat(漢字_月);
        List<dgOutputChohyoIchiran_Row> chohyoList = div.getCcdOutputChohyoIchiran().get出力帳票一覧();
        dgOutputChohyoIchiran_Row 特別徴収依頼情報一覧表row = new dgOutputChohyoIchiran_Row();
        dgOutputChohyoIchiran_Row 特別徴収異動情報一覧表row = new dgOutputChohyoIchiran_Row();
        if (null != chohyoList) {
            for (dgOutputChohyoIchiran_Row row : chohyoList) {
                if (特別徴収依頼情報一覧表ID.equals(row.getChohyoID())) {
                    特別徴収依頼情報一覧表row = row;
                } else if (特別徴収異動情報一覧表ID.equals(row.getChohyoID())) {
                    特別徴収異動情報一覧表row = row;
                }
            }
        }
        if (Tsuki._7月.getコード().equals(entry.getKey())) {
            特別徴収依頼情報一覧表row.setSelected(Boolean.TRUE);
            特別徴収異動情報一覧表row.setSelected(Boolean.FALSE);
        } else {
            特別徴収依頼情報一覧表row.setSelected(Boolean.FALSE);
            特別徴収異動情報一覧表row.setSelected(Boolean.TRUE);
        }
        if (本月.equals(entry.getKey()) && entry.getValue()) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(実行する, true);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(実行する, false);
        }
        return flag;
    }

    private int getSelectedCount() {
        int count = 0;
        if (div.getChkSentaku01().isAllSelected()) {
            count = count + 1;
        }
        if (div.getChkSentaku02().isAllSelected()) {
            count = count + 1;
        }
        if (div.getChkSentaku03().isAllSelected()) {
            count = count + 1;
        }
        if (div.getChkSentaku04().isAllSelected()) {
            count = count + 1;
        }
        if (div.getChkSentaku05().isAllSelected()) {
            count = count + 1;
        }
        if (div.getChkSentaku06().isAllSelected()) {
            count = count + 1;
        }
        if (div.getChkSentaku07().isAllSelected()) {
            count = count + 1;
        }
        if (div.getChkSentaku08().isAllSelected()) {
            count = count + 1;
        }
        if (div.getChkSentaku09().isAllSelected()) {
            count = count + 1;
        }
        if (div.getChkSentaku10().isAllSelected()) {
            count = count + 1;
        }
        if (div.getChkSentaku11().isAllSelected()) {
            count = count + 1;
        }
        if (div.getChkSentaku12().isAllSelected()) {
            count = count + 1;
        }
        return count;
    }

    private CheckBoxList getSelectedCheckBox() {
        if (div.getChkSentaku01().isAllSelected()) {
            return div.getChkSentaku01();
        }
        if (div.getChkSentaku02().isAllSelected()) {
            return div.getChkSentaku02();
        }
        if (div.getChkSentaku03().isAllSelected()) {
            return div.getChkSentaku03();
        }
        if (div.getChkSentaku04().isAllSelected()) {
            return div.getChkSentaku04();
        }
        if (div.getChkSentaku05().isAllSelected()) {
            return div.getChkSentaku05();
        }
        if (div.getChkSentaku06().isAllSelected()) {
            return div.getChkSentaku06();
        }
        if (div.getChkSentaku07().isAllSelected()) {
            return div.getChkSentaku07();
        }
        if (div.getChkSentaku08().isAllSelected()) {
            return div.getChkSentaku08();
        }
        if (div.getChkSentaku09().isAllSelected()) {
            return div.getChkSentaku09();
        }
        if (div.getChkSentaku10().isAllSelected()) {
            return div.getChkSentaku10();
        }
        if (div.getChkSentaku11().isAllSelected()) {
            return div.getChkSentaku11();
        }
        if (div.getChkSentaku12().isAllSelected()) {
            return div.getChkSentaku12();
        }
        return null;
    }

    private RString doExclusive(RString flag) {
        RString newFlag = RString.EMPTY;
        if (div.getChkSentaku01().isAllSelected()) {
            if (div.getChkSentaku01().getSelectControlID().equals(flag)) {
                div.getChkSentaku01().getSelectedItems().clear();
            } else {
                newFlag = div.getChkSentaku01().getSelectControlID();
            }
        }
        if (div.getChkSentaku02().isAllSelected()) {
            if (div.getChkSentaku02().getSelectControlID().equals(flag)) {
                div.getChkSentaku02().getSelectedItems().clear();
            } else {
                newFlag = div.getChkSentaku02().getSelectControlID();
            }
        }
        if (div.getChkSentaku03().isAllSelected()) {
            if (div.getChkSentaku03().getSelectControlID().equals(flag)) {
                div.getChkSentaku03().getSelectedItems().clear();
            } else {
                newFlag = div.getChkSentaku03().getSelectControlID();
            }
        }
        if (div.getChkSentaku04().isAllSelected()) {
            if (div.getChkSentaku04().getSelectControlID().equals(flag)) {
                div.getChkSentaku04().getSelectedItems().clear();
            } else {
                newFlag = div.getChkSentaku04().getSelectControlID();
            }
        }
        if (div.getChkSentaku05().isAllSelected()) {
            if (div.getChkSentaku05().getSelectControlID().equals(flag)) {
                div.getChkSentaku05().getSelectedItems().clear();
            } else {
                newFlag = div.getChkSentaku05().getSelectControlID();
            }
        }
        if (div.getChkSentaku06().isAllSelected()) {
            if (div.getChkSentaku06().getSelectControlID().equals(flag)) {
                div.getChkSentaku06().getSelectedItems().clear();
            } else {
                newFlag = div.getChkSentaku06().getSelectControlID();
            }
        }
        return newFlag;
    }

    private RString doExclusive2(RString flag) {
        RString newFlag = RString.EMPTY;
        if (div.getChkSentaku07().isAllSelected()) {
            if (div.getChkSentaku07().getSelectControlID().equals(flag)) {
                div.getChkSentaku07().getSelectedItems().clear();
            } else {
                newFlag = div.getChkSentaku07().getSelectControlID();
            }
        }
        if (div.getChkSentaku08().isAllSelected()) {
            if (div.getChkSentaku08().getSelectControlID().equals(flag)) {
                div.getChkSentaku08().getSelectedItems().clear();
            } else {
                newFlag = div.getChkSentaku08().getSelectControlID();
            }
        }
        if (div.getChkSentaku09().isAllSelected()) {
            if (div.getChkSentaku09().getSelectControlID().equals(flag)) {
                div.getChkSentaku09().getSelectedItems().clear();
            } else {
                newFlag = div.getChkSentaku09().getSelectControlID();
            }
        }
        if (div.getChkSentaku10().isAllSelected()) {
            if (div.getChkSentaku10().getSelectControlID().equals(flag)) {
                div.getChkSentaku10().getSelectedItems().clear();
            } else {
                newFlag = div.getChkSentaku10().getSelectControlID();
            }
        }
        if (div.getChkSentaku11().isAllSelected()) {
            if (div.getChkSentaku11().getSelectControlID().equals(flag)) {
                div.getChkSentaku11().getSelectedItems().clear();
            } else {
                newFlag = div.getChkSentaku11().getSelectControlID();
            }
        }
        if (div.getChkSentaku12().isAllSelected()) {
            if (div.getChkSentaku12().getSelectControlID().equals(flag)) {
                div.getChkSentaku12().getSelectedItems().clear();
            } else {
                newFlag = div.getChkSentaku12().getSelectControlID();
            }
        }
        return newFlag;
    }

    private void set処理日時(Map<RString, YMDHMS> 処理日時Map) {
        if (null != 処理日時Map.get(Tsuki._1月.getコード())) {
            div.getLblShoriNichiji01().setText(get処理日時Str(処理日時Map.get(Tsuki._1月.getコード())));
        }
        if (null != 処理日時Map.get(Tsuki._2月.getコード())) {
            div.getLblShoriNichiji02().setText(get処理日時Str(処理日時Map.get(Tsuki._2月.getコード())));
        }
        if (null != 処理日時Map.get(Tsuki._3月.getコード())) {
            div.getLblShoriNichiji03().setText(get処理日時Str(処理日時Map.get(Tsuki._3月.getコード())));
        }
        if (null != 処理日時Map.get(Tsuki._4月.getコード())) {
            div.getLblShoriNichiji04().setText(get処理日時Str(処理日時Map.get(Tsuki._4月.getコード())));
        }
        if (null != 処理日時Map.get(Tsuki._5月.getコード())) {
            div.getLblShoriNichiji05().setText(get処理日時Str(処理日時Map.get(Tsuki._5月.getコード())));
        }
        if (null != 処理日時Map.get(Tsuki._6月.getコード())) {
            div.getLblShoriNichiji06().setText(get処理日時Str(処理日時Map.get(Tsuki._6月.getコード())));
        }
        if (null != 処理日時Map.get(Tsuki._7月.getコード())) {
            div.getLblShoriNichiji07().setText(get処理日時Str(処理日時Map.get(Tsuki._7月.getコード())));
        }
        if (null != 処理日時Map.get(Tsuki._8月.getコード())) {
            div.getLblShoriNichiji08().setText(get処理日時Str(処理日時Map.get(Tsuki._8月.getコード())));
        }
        if (null != 処理日時Map.get(Tsuki._9月.getコード())) {
            div.getLblShoriNichiji09().setText(get処理日時Str(処理日時Map.get(Tsuki._9月.getコード())));
        }
        if (null != 処理日時Map.get(Tsuki._10月.getコード())) {
            div.getLblShoriNichiji10().setText(get処理日時Str(処理日時Map.get(Tsuki._10月.getコード())));
        }
        if (null != 処理日時Map.get(Tsuki._11月.getコード())) {
            div.getLblShoriNichiji11().setText(get処理日時Str(処理日時Map.get(Tsuki._11月.getコード())));
        }
        if (null != 処理日時Map.get(Tsuki._12月.getコード())) {
            div.getLblShoriNichiji12().setText(get処理日時Str(処理日時Map.get(Tsuki._12月.getコード())));
        }
    }

    private RString get処理日時Str(YMDHMS 処理日時) {
        if (null != 処理日時) {
            RString 処理年月日 = 処理日時.getRDateTime().getDate().wareki().toDateString();
            RString 処理時 = 処理日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss);
            return 処理年月日.concat(RString.HALF_SPACE).concat(処理時);
        }
        return RString.EMPTY;
    }

    /**
     * 「実行」ボタンを押下して、バッチパラメータを設定します。
     *
     * @return DBB211001_TokuchoSofuJohoSakuseiParameter
     */
    public DBB211001_TokuchoSofuJohoSakuseiParameter getバッチパラメータ() {
        TokuChoSoufuJohoSakusei manager = TokuChoSoufuJohoSakusei.createInstance();
        TokuChoSoufuJohoSakuseiParameter param = new TokuChoSoufuJohoSakuseiParameter();
        param.set賦課年度(new RDate(div.getDdlFukaNendo().getSelectedValue().toString()).getYear());
        param.set処理対象月(get処理対象月().getKey());
        List<dgOutputChohyoIchiran_Row> chohyoList = div.getCcdOutputChohyoIchiran().get出力帳票一覧();
        RString 出力順ID = RString.EMPTY;
        for (dgOutputChohyoIchiran_Row row : chohyoList) {
            if (row.getSelected()) {
                出力順ID = row.getShutsuryokujunID();
            }
        }
        param.set出力順ID(出力順ID);
        return manager.createTokuChoSoufuJohoParameter(param);
    }

    private void 日付関連_所得年度コンフィグによる制御(FlexibleYear 所得年度) {
        List<KeyValueDataSource> kazeiNendoList = new ArrayList();
        RString 年度 = new RString(所得年度.wareki().getYear().toString());
        KeyValueDataSource keyValue = new KeyValueDataSource();
        keyValue.setKey(年度);
        keyValue.setValue(年度);
        kazeiNendoList.add(keyValue);
        RString selectedIndex = 年度;
        div.getDdlFukaNendo().setDataSource(kazeiNendoList);
        div.getDdlFukaNendo().setSelectedKey(selectedIndex);
    }

    private Entry<RString, Boolean> get処理対象月() {
        RString 処理対象月 = RString.EMPTY;
        Boolean flag = false;
        if (div.getTbldgTokuchoIdoJoho().getChkSentaku01().isAllSelected()) {
            処理対象月 = Tsuki._1月.getコード();
            flag = !div.getLblShoriNichiji02().getText().isNullOrEmpty();
        }
        if (div.getTbldgTokuchoIdoJoho().getChkSentaku02().isAllSelected()) {
            処理対象月 = Tsuki._2月.getコード();
            flag = !div.getLblShoriNichiji03().getText().isNullOrEmpty();
        }
        if (div.getTbldgTokuchoIdoJoho().getChkSentaku03().isAllSelected()) {
            処理対象月 = Tsuki._3月.getコード();
            flag = !div.getLblShoriNichiji04().getText().isNullOrEmpty();
        }
        if (div.getTbldgTokuchoIdoJoho().getChkSentaku04().isAllSelected()) {
            処理対象月 = Tsuki._4月.getコード();
            flag = !div.getLblShoriNichiji05().getText().isNullOrEmpty();
        }
        if (div.getTbldgTokuchoIdoJoho().getChkSentaku05().isAllSelected()) {
            処理対象月 = Tsuki._5月.getコード();
            flag = !div.getLblShoriNichiji06().getText().isNullOrEmpty();
        }
        if (div.getTbldgTokuchoIdoJoho().getChkSentaku06().isAllSelected()) {
            処理対象月 = Tsuki._6月.getコード();
            flag = !div.getLblShoriNichiji07().getText().isNullOrEmpty();
        }
        if (div.getTbldgTokuchoIdoJoho().getChkSentaku07().isAllSelected()) {
            処理対象月 = Tsuki._7月.getコード();
            flag = !div.getLblShoriNichiji08().getText().isNullOrEmpty();
        }
        if (div.getTbldgTokuchoIdoJoho().getChkSentaku08().isAllSelected()) {
            処理対象月 = Tsuki._8月.getコード();
            flag = !div.getLblShoriNichiji09().getText().isNullOrEmpty();
        }
        if (div.getTbldgTokuchoIdoJoho().getChkSentaku09().isAllSelected()) {
            処理対象月 = Tsuki._9月.getコード();
            flag = !div.getLblShoriNichiji10().getText().isNullOrEmpty();
        }
        if (div.getTbldgTokuchoIdoJoho().getChkSentaku10().isAllSelected()) {
            処理対象月 = Tsuki._10月.getコード();
            flag = !div.getLblShoriNichiji11().getText().isNullOrEmpty();
        }
        if (div.getTbldgTokuchoIdoJoho().getChkSentaku11().isAllSelected()) {
            処理対象月 = Tsuki._11月.getコード();
            flag = !div.getLblShoriNichiji12().getText().isNullOrEmpty();
        }
        if (div.getTbldgTokuchoIdoJoho().getChkSentaku12().isAllSelected()) {
            処理対象月 = Tsuki._12月.getコード();
            flag = !div.getLblShoriNichiji01().getText().isNullOrEmpty();
        }
        return new SimpleEntry(処理対象月, flag);
    }

    /**
     * 選択された処理対象月の処理が既に実行済みの判断です。
     *
     * @return is実行済
     */
    public boolean is選択された処理対象実行済() {
        return get処理対象月().getValue();
    }

}
