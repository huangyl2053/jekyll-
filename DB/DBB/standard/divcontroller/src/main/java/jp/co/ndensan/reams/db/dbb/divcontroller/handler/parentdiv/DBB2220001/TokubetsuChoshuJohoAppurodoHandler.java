/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB2220001;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2220001.TokubetsuChoshuJohoAppurodoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2220001.dgGetuShoriSelect_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2220001.dgShichosonShoriSelect_Row;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchoinfoshoridatekanri.TokuchoInfoShoriDateKanri;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurityjoho.KoseiShichosonJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.FileReader;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;

/**
 * 画面設計_DBB2110002_特別徴収情報をアップロードのクラスです。
 *
 * @reamsid_L DBB-5670-010 chenhui
 */
public class TokubetsuChoshuJohoAppurodoHandler {

    private final TokubetsuChoshuJohoAppurodoDiv div;
    private static final int SUBTRACT_1 = -1;
    private static final RString 引数 = new RString("広域保険者でないため、");
    private static final RString 月_1 = new RString("1月");
    private static final RString 月_2 = new RString("2月");
    private static final RString 月_3 = new RString("3月");
    private static final RString 月_4 = new RString("4月");
    private static final RString 月_5 = new RString("5月");
    private static final RString 月_6 = new RString("6月");
    private static final RString 月_7 = new RString("7月");
    private static final RString 月_8 = new RString("8月");
    private static final RString 月_9 = new RString("9月");
    private static final RString 月_10 = new RString("10月");
    private static final RString 月_11 = new RString("11月");
    private static final RString 月_12 = new RString("12月");
    private static final RString STR_0 = new RString("0");
    private static final RString STR_1 = new RString("1");
    private static final RString STR_2 = new RString("2");
    private static final RString STR_3 = new RString("3");
    private static final RString STR_4 = new RString("4");
    private static final RString STR_5 = new RString("5");
    private static final RString STR_6 = new RString("6");
    private static final RString STR_7 = new RString("7");
    private static final RString STR_8 = new RString("8");
    private static final RString STR_9 = new RString("9");
    private static final RString STR_10 = new RString("10");
    private static final RString STR_11 = new RString("11");
    private static final RString STR_12 = new RString("12");
    private static final RString STR_22 = new RString("22");
    private static final RString STR_0001 = new RString("0001");
    private static final RString STR_0002 = new RString("0002");
    private static final RString STR_0003 = new RString("0003");
    private static final RString STR_0004 = new RString("0004");
    private static final RString STR_0005 = new RString("0005");
    private static final RString STR_0006 = new RString("0006");
    private static final RString STR_0007 = new RString("0007");
    private static final RString STR_0008 = new RString("0008");
    private static final RString STR_0009 = new RString("0009");
    private static final RString STR_0010 = new RString("0010");
    private static final RString STR_0011 = new RString("0011");
    private static final RString STR_0012 = new RString("0012");
    private static final RString STR_01 = new RString("01");
    private static final RString STR_02 = new RString("02");
    private static final RString STR_03 = new RString("03");
    private static final RString STR_04 = new RString("04");
    private static final RString STR_05 = new RString("05");
    private static final RString STR_06 = new RString("06");
    private static final RString STR_07 = new RString("07");
    private static final RString STR_08 = new RString("08");
    private static final RString STR_09 = new RString("09");
    private static final RString STR_00 = new RString("00");
    private static final RString SPACE = new RString(" ");
    private static final RString 異動処理結果情報 = new RString("異動処理結果情報");
    private static final RString 結果情報_４月天引分 = new RString("結果情報（４月天引分）");
    private static final RString 対象者情報 = new RString("対象者情報");
    private static final RString 結果情報_６月天引分 = new RString("結果情報（６月天引分）");
    private static final RString 結果情報_８月天引分 = new RString("結果情報（８月天引分）");
    private static final RString 依頼処理結果情報 = new RString("依頼処理結果情報");
    private static final RString 結果情報_１０月天引分 = new RString("結果情報（１０月天引分）");
    private static final RString 結果情報_１２月天引分 = new RString("結果情報（１２月天引分）");
    private static final RString 結果情報_２月天引分 = new RString("結果情報（２月天引分）");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_5 = 5;
    private static final int INT_9 = 9;
    private static final int INT_11 = 11;
    private static final int INT_12 = 12;
    private static final int INT_13 = 13;
    private static final int INT_48 = 48;
    private static final int INT_96 = 96;
    private static final int INT_500 = 500;
    private static final RString 結果情報 = new RString("結果情報");
    private static final RString 状態_市町村 = new RString("市町村");
    private static final RString 状態_月 = new RString("月");
    private static final RString Z1 = new RString("Z1");
    private static final RString Z14 = new RString("Z14");
    private static final RString Z11 = new RString("Z11");
    private static final RString Z13 = new RString("Z13");
    private static final RString 対象ファイル_異動処理結果情報 = new RString("Z14*****.DTA");
    private static final RString 対象ファイル_結果情報 = new RString("Z14*****.DTA");
    private static final RString 対象ファイル_対象者情報 = new RString("Z11*****.DTA");
    private static final RString 対象ファイル_依頼処理結果情報 = new RString("Z13*****.DTA");
    private static final RString 拡張子 = new RString(".DTA");
    private static final RString REACH_KEY = new RString("_*");
    private static final RString 市町村コードチェック_MSG = new RString("他市町村のファイルです。");
    private static final RString ファイル破損チェック_MSG = new RString("ファイルが読み込めませんでした。");
    private static final RString 対象ファイル情報種別の存在チェック_MSG = new RString("対象のファイルではありません。");
    private static final RString 対象ファイルの重複チェック_MSG = new RString("同一情報が複数あります。");
    private static final RString 奇数月のチェック_MSG = new RString("天引き結果情報がありません。");
    private static final RString 偶数月のチェック_MSG = new RString("天引き結果情報が含まれています。");
    private static final RString 介護の制度コードのチェック_MSG = new RString("介護用のファイルではありません。");
    private static final RString 拡張子のチェック_MSG = new RString("ファイル拡張子が不正です。");
    private static final RString その他チェック_MSG = new RString("ファイルがアップロードできません。");
    private static final RString 共有ファイル名 = new RString("連携種別_500_市町村ID_対象月.DTA");
    private static final RString 連携種別 = new RString("連携種別");
    private static final RString 市町村ID = new RString("市町村ID");
    private static final RString 対象月 = new RString("対象月");
    private static final RString 済 = new RString("済");

    /**
     * コンストラクタです。
     *
     * @param div TokubetsuChoshuJohoAppurodoDiv
     */
    public TokubetsuChoshuJohoAppurodoHandler(TokubetsuChoshuJohoAppurodoDiv div) {
        this.div = div;
    }

    /**
     * 広域保険者チェックのメソッドます。
     */
    public void check広域保険者() {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        RString 導入形態コード = 市町村セキュリティ情報.get導入形態コード().getKey();
        if (!DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード)) {
            throw new ApplicationException(DbzErrorMessages.使用不可.getMessage().replace(引数.toString()));
        }
    }

    /**
     * 画面初期化のメソッドです。
     *
     */
    public void initialize() {
        RDate 調定年度 = new RDate(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課).toString());
        処理年度初期化(調定年度);
        市町村制御();
        月制御();
        市町村処理対象制御(調定年度);
    }

    private void 処理年度初期化(RDate 調定年度) {
        RDate 調定年度前 = 調定年度.plusYear(SUBTRACT_1);
        RString 調定年度STR = DateConverter.getWarekiYear(調定年度.getYear());
        RString 調定年度前STR = DateConverter.getWarekiYear(調定年度前.getYear());
        List<KeyValueDataSource> keiyakuServiceShuruiList = new ArrayList<>();
        keiyakuServiceShuruiList.add(new KeyValueDataSource(調定年度.toDateString(), 調定年度STR));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(調定年度前.toDateString(), 調定年度前STR));
        div.getShoriJokyoPanel().getDdlShoriNendo().setDataSource(keiyakuServiceShuruiList);
        div.getShoriJokyoPanel().getDdlShoriNendo().setSelectedKey(調定年度.toDateString());
    }

    private void 市町村制御() {
        RString 市町村識別ID = ShichosonSecurityJoho.getShichosonShikibetsuId(
                ControlDataHolder.getUserId()).get(INT_0).getItemId();
        List<KeyValueDataSource> 市町村DataSourceList = new ArrayList<>();
        if (!STR_00.equals(市町村識別ID)) {
            ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
            if (市町村セキュリティ情報 != null) {
                RString 自分市町村ID = 市町村セキュリティ情報.get市町村情報().get市町村識別ID();
                RString コード名称 = new RString(市町村セキュリティ情報.get市町村情報().get市町村コード().getColumnValue().toString()
                        + SPACE.toString() + 市町村セキュリティ情報.get市町村情報().get市町村名称().toString());
                市町村DataSourceList.add(new KeyValueDataSource(自分市町村ID, コード名称));
            }
        } else {
            List<KoikiZenShichosonJoho> 構成市町村List = KoikiShichosonJohoFinder.createInstance().getGenShichosonJoho().records();
            if (構成市町村List != null && !構成市町村List.isEmpty()) {
                for (KoikiZenShichosonJoho 構成市町村 : 構成市町村List) {
                    RString 構成市町村ID = 構成市町村.get市町村識別ID();
                    RString コード名称 = new RString(構成市町村.get市町村コード().value().toString()
                            + SPACE.toString() + 構成市町村.get市町村名称().toString());
                    市町村DataSourceList.add(new KeyValueDataSource(構成市町村ID, コード名称));
                }
            }
        }
        div.getShoriJokyoPanel().getDdlShichoson().setDataSource(市町村DataSourceList);
    }

    private void 月制御() {
        div.getShoriJokyoPanel().getDdlGetu().setDataSource(get処理対象月DataSource());
        int 選択月 = RDate.getNowDate().getMonthValue();
        div.getShoriJokyoPanel().getDdlGetu().setSelectedKey(new RString(選択月));
    }

    private List<KeyValueDataSource> get処理対象月DataSource() {
        List<KeyValueDataSource> keiyakuServiceShuruiList = new ArrayList<>();
        keiyakuServiceShuruiList.add(new KeyValueDataSource(STR_4, 月_4));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(STR_5, 月_5));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(STR_6, 月_6));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(STR_7, 月_7));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(STR_8, 月_8));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(STR_9, 月_9));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(STR_10, 月_10));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(STR_11, 月_11));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(STR_12, 月_12));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(STR_1, 月_1));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(STR_2, 月_2));
        keiyakuServiceShuruiList.add(new KeyValueDataSource(STR_3, 月_3));
        return keiyakuServiceShuruiList;
    }

    private void 市町村処理対象制御(RDate 調定年度) {
        if (!STR_0.equals(div.getShoriJokyoPanel().getGrpHyojikeishiki().getSelectedKey())) {
            return;
        }
        RString 選択市町村ID = div.getShoriJokyoPanel().getDdlShichoson().getSelectedKey();
        FlexibleYear year = new FlexibleYear(調定年度.getYear().toDateString());
        List<RString> 処理名List = new ArrayList<>();
        処理名List.add(ShoriName.特徴結果情報取込.get名称());
        処理名List.add(ShoriName.特徴対象者情報取込.get名称());
        処理名List.add(ShoriName.特徴依頼処理結果情報取込.get名称());
        ShoriDateKanri 処理日付 = TokuchoInfoShoriDateKanri
                .createInstance().get市町村処理日付(year, new RString(STR_00.toString() + 選択市町村ID.toString()), 処理名List);
        RString 処理日時パターン = get処理日時パターン(処理日付);
        Map<RString, RString> map = get処理月と月Map();
        List<RString> 処理月List = 処理月取得();
        Map<RString, RString> 処理月と処理名Map = get処理月と処理名Map();
        List<dgGetuShoriSelect_Row> 処理対象Rows = new ArrayList<>();
        for (RString 処理月 : 処理月List) {
            dgGetuShoriSelect_Row row = new dgGetuShoriSelect_Row();
            row.setData1(処理月);
            row.setData2(処理月と処理名Map.get(処理月));
            row.setData3(処理日時パターン);
            RString sharedファイル = 共有ファイル名.replace(連携種別, get行連携種別(処理月と処理名Map.get(処理月))).
                    replace(市町村ID, 選択市町村ID).replace(対象月, map.get(処理月));
            boolean isUpload = !SharedFile.searchSharedFile(sharedファイル).isEmpty();
            if (isUpload) {
                row.setData4(済);
                row.setSelectable(false);
            }
            処理対象Rows.add(row);
            if (月_5.equals(処理月)) {
                row = new dgGetuShoriSelect_Row();
                row.setData1(月_5);
                row.setData2(対象者情報);
                row.setData3(処理日時パターン);
                sharedファイル = 共有ファイル名.replace(連携種別, get行連携種別(対象者情報)).
                        replace(市町村ID, 選択市町村ID).replace(対象月, map.get(処理月));
                isUpload = !SharedFile.searchSharedFile(sharedファイル).isEmpty();
                if (isUpload) {
                    row.setData4(済);
                    row.setSelectable(false);
                }
                処理対象Rows.add(row);
            } else if (月_9.equals(処理月)) {
                row = new dgGetuShoriSelect_Row();
                row.setData1(月_9);
                row.setData2(依頼処理結果情報);
                row.setData3(処理日時パターン);
                sharedファイル = 共有ファイル名.replace(連携種別, get行連携種別(依頼処理結果情報)).
                        replace(市町村ID, 選択市町村ID).replace(対象月, map.get(処理月));
                isUpload = !SharedFile.searchSharedFile(sharedファイル).isEmpty();
                if (isUpload) {
                    row.setData4(済);
                    row.setSelectable(false);
                }
                処理対象Rows.add(row);
            }
        }
        div.getShoriTaishoShichosonPanel().getDgGetuShoriSelect().setDataSource(処理対象Rows);
    }

    private List<RString> 処理月取得() {
        List<RString> 処理月List = new ArrayList<>();
        処理月List.add(月_4);
        処理月List.add(月_5);
        処理月List.add(月_6);
        処理月List.add(月_7);
        処理月List.add(月_8);
        処理月List.add(月_9);
        処理月List.add(月_10);
        処理月List.add(月_11);
        処理月List.add(月_12);
        処理月List.add(月_1);
        処理月List.add(月_2);
        処理月List.add(月_3);
        return 処理月List;
    }

    private Map<RString, RString> get処理月と処理名Map() {
        Map<RString, RString> 処理月と処理名Map = new HashMap<>();
        処理月と処理名Map.put(月_4, 異動処理結果情報);
        処理月と処理名Map.put(月_5, 結果情報_４月天引分);
        処理月と処理名Map.put(月_6, 異動処理結果情報);
        処理月と処理名Map.put(月_7, 結果情報_６月天引分);
        処理月と処理名Map.put(月_8, 異動処理結果情報);
        処理月と処理名Map.put(月_9, 結果情報_８月天引分);
        処理月と処理名Map.put(月_10, 異動処理結果情報);
        処理月と処理名Map.put(月_11, 結果情報_１０月天引分);
        処理月と処理名Map.put(月_12, 異動処理結果情報);
        処理月と処理名Map.put(月_1, 結果情報_１２月天引分);
        処理月と処理名Map.put(月_2, 異動処理結果情報);
        処理月と処理名Map.put(月_3, 結果情報_２月天引分);
        return 処理月と処理名Map;
    }

    private Map<RString, RString> get処理月と年度内連番Map() {
        Map<RString, RString> 処理月と処理名Map = new HashMap<>();
        処理月と処理名Map.put(月_4, STR_0001);
        処理月と処理名Map.put(月_5, STR_0002);
        処理月と処理名Map.put(月_6, STR_0003);
        処理月と処理名Map.put(月_7, STR_0004);
        処理月と処理名Map.put(月_8, STR_0005);
        処理月と処理名Map.put(月_9, STR_0006);
        処理月と処理名Map.put(月_10, STR_0007);
        処理月と処理名Map.put(月_11, STR_0008);
        処理月と処理名Map.put(月_12, STR_0009);
        処理月と処理名Map.put(月_1, STR_0010);
        処理月と処理名Map.put(月_2, STR_0011);
        処理月と処理名Map.put(月_3, STR_0012);
        return 処理月と処理名Map;
    }

    private Map<RString, RString> get処理月と月Map() {
        Map<RString, RString> 処理月と処理名Map = new HashMap<>();
        処理月と処理名Map.put(月_4, STR_04);
        処理月と処理名Map.put(月_5, STR_05);
        処理月と処理名Map.put(月_6, STR_06);
        処理月と処理名Map.put(月_7, STR_07);
        処理月と処理名Map.put(月_8, STR_08);
        処理月と処理名Map.put(月_9, STR_09);
        処理月と処理名Map.put(月_10, STR_10);
        処理月と処理名Map.put(月_11, STR_11);
        処理月と処理名Map.put(月_12, STR_12);
        処理月と処理名Map.put(月_1, STR_01);
        処理月と処理名Map.put(月_2, STR_02);
        処理月と処理名Map.put(月_3, STR_03);
        return 処理月と処理名Map;
    }

    private RString get処理日時パターン(ShoriDateKanri 処理日付) {
        if (処理日付 == null || 処理日付.get基準日時() == null) {
            return RString.EMPTY;
        }
        RDate 年月日 = 処理日付.get基準日時().getDate();
        RTime 時刻 = 処理日付.get基準日時().getRDateTime().getTime();
        RString 前回処理日時 = new RString(年月日.wareki().toDateString().toString() + SPACE
                + 時刻.toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        return 前回処理日時;
    }

    /**
     * 「市町村」もしくは「月」の切替のメソッドです。
     *
     * @return RString
     */
    public RString 市町村月の切替() {
        RDate 処理年度 = new RDate(div.getShoriJokyoPanel().getDdlShoriNendo().getSelectedKey().toString());
        if (STR_0.equals(div.getShoriJokyoPanel().getGrpHyojikeishiki().getSelectedKey())) {
            市町村処理対象制御(処理年度);
            return 状態_市町村;
        }
        月処理対象制御(処理年度);
        return 状態_月;
    }

    private void 月処理対象制御(RDate 処理年度) {
        if (!STR_1.equals(div.getShoriJokyoPanel().getGrpHyojikeishiki().getSelectedKey())) {
            return;
        }
        FlexibleYear year = new FlexibleYear(処理年度.getYear().toDateString());
        RString 選択月 = div.getShoriJokyoPanel().getDdlGetu().getSelectedValue();
        Map<RString, RString> 月と年度内連番Map = get処理月と年度内連番Map();
        Map<RString, RString> 月と処理名Map = get処理月と処理名Map();
        Map<RString, RString> map = get処理月と月Map();
        RString 市町村識別ID = ShichosonSecurityJoho.getShichosonShikibetsuId(
                ControlDataHolder.getUserId()).get(INT_0).getItemId();
        if (!STR_00.equals(市町村識別ID)) {
            if (月_5.equals(選択月) || 月_9.equals(選択月)) {
                set5月と9月構成市町村Row(year, 月と年度内連番Map, 選択月, 市町村識別ID, 月と処理名Map);
                return;
            }
            KoseiShichosonJoho 市町村 = ShichosonSecurityJoho.getKouseiShichosonJoho(市町村識別ID);
            ShoriDateKanri 処理日付 = TokuchoInfoShoriDateKanri.createInstance().get月処理日付(year,
                    ShoriName.特徴結果情報取込.get名称(), 月と年度内連番Map.get(選択月),
                    new RString(STR_00.toString() + 市町村識別ID.toString()));
            RString 処理日時パターン = get処理日時パターン(処理日付);
            dgShichosonShoriSelect_Row row = new dgShichosonShoriSelect_Row();
            row.setData1(市町村.get市町村名称());
            row.setData2(月と処理名Map.get(選択月));
            row.setData3(処理日時パターン);
            RString sharedファイル = 共有ファイル名.replace(連携種別, get行連携種別(月と処理名Map.get(選択月))).
                    replace(市町村ID, 市町村識別ID).replace(対象月, map.get(選択月));
            boolean isUpload = !SharedFile.searchSharedFile(sharedファイル).isEmpty();
            if (isUpload) {
                row.setData4(済);
                row.setSelectable(false);
            }
            row.setData5(市町村.get市町村コード().getColumnValue());
            row.setData6(市町村.get市町村識別ID());
            List<dgShichosonShoriSelect_Row> 月処理対象Rows = new ArrayList<>();
            月処理対象Rows.add(row);
            div.getShoriTaishoGetuPanel().getDgShichosonShoriSelect().setDataSource(月処理対象Rows);
            return;
        }
        List<KoikiZenShichosonJoho> 構成市町村List = KoikiShichosonJohoFinder.createInstance().getGenShichosonJoho().records();
        List<RString> 市町村IDList = new ArrayList<>();
        for (KoikiZenShichosonJoho 構成市町村 : 構成市町村List) {
            市町村IDList.add(構成市町村.get市町村識別ID());
        }
        if (!月_5.equals(選択月) && !月_9.equals(選択月)) {
            List<ShoriDateKanri> 処理日付List = TokuchoInfoShoriDateKanri.createInstance().
                    get広域月処理日付(year, ShoriName.特徴結果情報取込.get名称(),
                            月と年度内連番Map.get(選択月), 市町村IDList);
            Map<RString, ShoriDateKanri> 処理日付Map = new HashMap<>();
            for (ShoriDateKanri 処理日付 : 処理日付List) {
                処理日付Map.put(処理日付.get処理枝番(), 処理日付);
            }
            List<dgShichosonShoriSelect_Row> 月処理対象Rows = new ArrayList<>();
            for (KoikiZenShichosonJoho 構成市町村 : 構成市町村List) {
                dgShichosonShoriSelect_Row row = new dgShichosonShoriSelect_Row();
                row.setData1(構成市町村.get市町村名称());
                row.setData2(月と処理名Map.get(選択月));
                row.setData3(get処理日時パターン(処理日付Map.get(
                        new RString(STR_00.toString() + 構成市町村.get市町村識別ID().toString()))));
                RString sharedファイル = 共有ファイル名.replace(連携種別, get行連携種別(月と処理名Map.get(選択月))).
                        replace(市町村ID, 構成市町村.get市町村識別ID()).replace(対象月, map.get(選択月));
                boolean isUpload = !SharedFile.searchSharedFile(sharedファイル).isEmpty();
                if (isUpload) {
                    row.setData4(済);
                    row.setSelectable(false);
                }
                row.setData5(構成市町村.get市町村コード().getColumnValue());
                row.setData6(構成市町村.get市町村識別ID());
                月処理対象Rows.add(row);
            }
            div.getShoriTaishoGetuPanel().getDgShichosonShoriSelect().setDataSource(月処理対象Rows);
            return;
        }

        RString 処理名;
        if (月_5.equals(選択月)) {
            処理名 = ShoriName.特徴対象者情報取込.get名称();
        } else {
            処理名 = ShoriName.特徴依頼処理結果情報取込.get名称();
        }
        List<ShoriDateKanri> 処理日付List = TokuchoInfoShoriDateKanri.createInstance().
                get広域5月と9月処理日付(year, 処理名, 月と年度内連番Map.get(選択月), 市町村IDList);
        Map<RString, ShoriDateKanri> 処理日付Map = new HashMap<>();
        for (ShoriDateKanri 処理日付 : 処理日付List) {
            処理日付Map.put(処理日付.get処理枝番(), 処理日付);
        }
        List<dgShichosonShoriSelect_Row> 月処理対象Rows = new ArrayList<>();
        for (KoikiZenShichosonJoho 構成市町村 : 構成市町村List) {
            RString 処理日時パターン = get処理日時パターン(処理日付Map.get(
                    new RString(STR_00.toString() + 構成市町村.get市町村識別ID().toString())));
            dgShichosonShoriSelect_Row row = new dgShichosonShoriSelect_Row();
            row.setData1(構成市町村.get市町村名称());
            row.setData2(月と処理名Map.get(選択月));
            row.setData3(処理日時パターン);
            RString sharedファイル = 共有ファイル名.replace(連携種別, get行連携種別(月と処理名Map.get(選択月))).
                    replace(市町村ID, 構成市町村.get市町村識別ID()).replace(対象月, map.get(選択月));
            boolean isUpload = !SharedFile.searchSharedFile(sharedファイル).isEmpty();
            if (isUpload) {
                row.setData4(済);
                row.setSelectable(false);
            }
            row.setData5(構成市町村.get市町村コード().getColumnValue());
            row.setData6(構成市町村.get市町村識別ID());
            月処理対象Rows.add(row);
            row = new dgShichosonShoriSelect_Row();
            row.setData1(構成市町村.get市町村名称());
            if (月_5.equals(選択月)) {
                row.setData2(対象者情報);
                sharedファイル = 共有ファイル名.replace(連携種別, get行連携種別(対象者情報)).
                        replace(市町村ID, 構成市町村.get市町村識別ID()).replace(対象月, map.get(選択月));
            } else {
                row.setData2(依頼処理結果情報);
                sharedファイル = 共有ファイル名.replace(連携種別, get行連携種別(依頼処理結果情報)).
                        replace(市町村ID, 構成市町村.get市町村識別ID()).replace(対象月, map.get(選択月));
            }
            isUpload = !SharedFile.searchSharedFile(sharedファイル).isEmpty();
            row.setData3(処理日時パターン);
            if (isUpload) {
                row.setData4(済);
                row.setSelectable(false);
            }
            row.setData5(構成市町村.get市町村コード().getColumnValue());
            row.setData6(構成市町村.get市町村識別ID());
            月処理対象Rows.add(row);
        }
        div.getShoriTaishoGetuPanel().getDgShichosonShoriSelect().setDataSource(月処理対象Rows);
    }

    private void set5月と9月構成市町村Row(FlexibleYear year, Map<RString, RString> 月と年度内連番Map,
            RString 選択月, RString 市町村識別ID, Map<RString, RString> 月と処理名Map) {
        KoseiShichosonJoho 市町村 = ShichosonSecurityJoho.getKouseiShichosonJoho(市町村識別ID);
        List<RString> 処理名List = new ArrayList<>();
        処理名List.add(ShoriName.特徴結果情報取込.get名称());
        if (月_5.equals(選択月)) {
            処理名List.add(ShoriName.特徴対象者情報取込.get名称());
        } else {
            処理名List.add(ShoriName.特徴依頼処理結果情報取込.get名称());
        }
        List<dgShichosonShoriSelect_Row> 月処理対象Rows = new ArrayList<>();
        ShoriDateKanri 処理日付 = TokuchoInfoShoriDateKanri.createInstance().
                get月構成市町村処理日付(year, new RString(STR_00.toString() + 市町村識別ID.toString()),
                        月と年度内連番Map.get(選択月), 処理名List);
        RString 処理日時パターン = get処理日時パターン(処理日付);
        Map<RString, RString> map = get処理月と月Map();
        dgShichosonShoriSelect_Row row = new dgShichosonShoriSelect_Row();
        row.setData1(市町村.get市町村名称());
        row.setData2(月と処理名Map.get(選択月));
        row.setData3(処理日時パターン);
        RString sharedファイル = 共有ファイル名.replace(連携種別, get行連携種別(月と処理名Map.get(選択月))).
                replace(市町村ID, 市町村.get市町村識別ID()).replace(対象月, map.get(選択月));
        boolean isUpload = !SharedFile.searchSharedFile(sharedファイル).isEmpty();
        if (isUpload) {
            row.setData4(済);
            row.setSelectable(false);
        }
        row.setData5(市町村.get市町村コード().getColumnValue());
        row.setData6(市町村.get市町村識別ID());
        月処理対象Rows.add(row);
        row = new dgShichosonShoriSelect_Row();
        row.setData1(市町村.get市町村名称());
        if (月_5.equals(選択月)) {
            row.setData2(対象者情報);
            sharedファイル = 共有ファイル名.replace(連携種別, get行連携種別(対象者情報)).
                    replace(市町村ID, 市町村.get市町村識別ID()).replace(対象月, map.get(選択月));
        } else {
            row.setData2(依頼処理結果情報);
            sharedファイル = 共有ファイル名.replace(連携種別, get行連携種別(依頼処理結果情報)).
                    replace(市町村ID, 市町村.get市町村識別ID()).replace(対象月, map.get(選択月));
        }
        isUpload = !SharedFile.searchSharedFile(sharedファイル).isEmpty();
        row.setData3(処理日時パターン);
        if (isUpload) {
            row.setData4(済);
            row.setSelectable(false);
        }
        row.setData5(市町村.get市町村コード().getColumnValue());
        row.setData6(市町村.get市町村識別ID());
        月処理対象Rows.add(row);
        div.getShoriTaishoGetuPanel().getDgShichosonShoriSelect().setDataSource(月処理対象Rows);

    }

    /**
     * 処理年度の切替のメソッドです。
     *
     */
    public void 処理年度の変更() {
        RString 選択value = div.getShoriJokyoPanel().getDdlShoriNendo().getSelectedKey();
        RDate 処理年度 = new RDate(選択value.toString());
        div.getShoriJokyoPanel().getGrpHyojikeishiki().getSelectedKey();
        if (STR_0.equals(div.getShoriJokyoPanel().getGrpHyojikeishiki().getSelectedKey())) {
            市町村処理対象制御(処理年度);
        } else {
            月処理対象制御(処理年度);
        }
    }

    /**
     * 市町村の変更のメソッドです。
     *
     */
    public void 市町村の変更() {
        RString 選択value = div.getShoriJokyoPanel().getDdlShoriNendo().getSelectedKey();
        RDate 処理年度 = new RDate(選択value.toString());
        市町村処理対象制御(処理年度);
    }

    /**
     * 月の変更のメソッドです。
     *
     */
    public void 月の変更() {
        RString 選択value = div.getShoriJokyoPanel().getDdlShoriNendo().getSelectedKey();
        RDate 処理年度 = new RDate(選択value.toString());
        月処理対象制御(処理年度);
    }

    /**
     * 処理対象選択（市町村）のメソッドです。
     *
     */
    public void 処理対象選択_市町村() {
        List<dgGetuShoriSelect_Row> 処理対象Rows = div.getShoriTaishoShichosonPanel().
                getDgGetuShoriSelect().getSelectedItems();
        if (処理対象Rows == null || 処理対象Rows.isEmpty()) {
            div.getShoriJokyoPanel().getTxtTaisyoFile().setValue(RString.EMPTY);
            return;
        }
        dgGetuShoriSelect_Row 選択Row = div.getShoriTaishoShichosonPanel().
                getDgGetuShoriSelect().getActiveRow();
        RString 処理 = 選択Row.getData2();
        if (処理.startsWith(異動処理結果情報)) {
            div.getShoriJokyoPanel().getTxtTaisyoFile().setValue(対象ファイル_異動処理結果情報);
        } else if (処理.startsWith(結果情報)) {
            div.getShoriJokyoPanel().getTxtTaisyoFile().setValue(対象ファイル_結果情報);
        } else if (処理.startsWith(対象者情報)) {
            div.getShoriJokyoPanel().getTxtTaisyoFile().setValue(対象ファイル_対象者情報);
        } else {
            div.getShoriJokyoPanel().getTxtTaisyoFile().setValue(対象ファイル_依頼処理結果情報);
        }
        処理対象Rows.clear();
        処理対象Rows.add(選択Row);
        div.getShoriTaishoShichosonPanel().getDgGetuShoriSelect().isFiltered();
        div.getShoriTaishoShichosonPanel().getDgGetuShoriSelect().setSelectedItems(処理対象Rows);
    }

    /**
     * 処理対象選択（月）のメソッドです。
     *
     */
    public void 処理対象選択_月() {
        List<dgShichosonShoriSelect_Row> 処理対象Rows = div.getShoriTaishoGetuPanel().
                getDgShichosonShoriSelect().getSelectedItems();
        if (処理対象Rows == null || 処理対象Rows.isEmpty()) {
            div.getShoriJokyoPanel().getTxtTaisyoFile().setValue(RString.EMPTY);
            return;
        }
        dgShichosonShoriSelect_Row 選択Row = div.getShoriTaishoGetuPanel().
                getDgShichosonShoriSelect().getActiveRow();
        RString 処理 = 選択Row.getData2();
        if (処理.startsWith(異動処理結果情報)) {
            div.getShoriJokyoPanel().getTxtTaisyoFile().setValue(対象ファイル_異動処理結果情報);
        } else if (処理.startsWith(結果情報)) {
            div.getShoriJokyoPanel().getTxtTaisyoFile().setValue(対象ファイル_結果情報);
        } else if (処理.startsWith(対象者情報)) {
            div.getShoriJokyoPanel().getTxtTaisyoFile().setValue(対象ファイル_対象者情報);
        } else {
            div.getShoriJokyoPanel().getTxtTaisyoFile().setValue(対象ファイル_依頼処理結果情報);
        }
        処理対象Rows.clear();
        処理対象Rows.add(選択Row);
        div.getShoriTaishoGetuPanel().getDgShichosonShoriSelect().setSelectedItems(処理対象Rows);
    }

    /**
     * upLoadファイルチェックのメソッドます。
     *
     * @param files FileData[]
     *
     * @return boolean
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public boolean ファイルチェック(FileData[] files) {
        if (div.getShoriTaishoShichosonPanel().getDgGetuShoriSelect().getSelectedItems().isEmpty()
                && div.getShoriTaishoGetuPanel().getDgShichosonShoriSelect().getSelectedItems().isEmpty()) {
            throw new ApplicationException(その他チェック_MSG.toString());
        }
        RString 選択Key = div.getShoriJokyoPanel().getGrpHyojikeishiki().getSelectedKey();
        if (STR_0.equals(選択Key)) {
            List<dgGetuShoriSelect_Row> 処理対象Rows = div.getShoriTaishoShichosonPanel().getDgGetuShoriSelect().getDataSource();
            int max = INT_0;
            Map<RString, RString> 処理月と年度内連番 = get処理月と年度内連番Map();
            for (dgGetuShoriSelect_Row row : 処理対象Rows) {
                if (済.equals(row.getData4())) {
                    int 年度内連番 = Integer.parseInt(処理月と年度内連番.get(row.getData1()).toString());
                    max = max < 年度内連番 ? 年度内連番 : max;
                }
            }
            dgGetuShoriSelect_Row 選択row = div.getShoriTaishoShichosonPanel().getDgGetuShoriSelect().getSelectedItems().get(INT_0);
            int 選択月 = Integer.parseInt(処理月と年度内連番.get(選択row.getData1()).toString());
            if (選択月 != (max + INT_1)) {
                throw new ApplicationException(その他チェック_MSG.toString());
            }

        }
        FileData 選択ファイル = files[INT_0];
        RString ファイル名 = 選択ファイル.getFileName();
        if (!ファイル名.endsWith(拡張子)) {
            throw new ApplicationException(拡張子のチェック_MSG.toString());
        }
        try (FileReader reader = new FileReader(選択ファイル.getFilePath(), Encode.UTF_8)) {
            RString ファイルのデータレコード = reader.readLine();
            reader.close();
            市町村コードチェック(ファイルのデータレコード);
            ファイル破損チェック(ファイルのデータレコード);
            対象ファイル情報種別の存在チェック(ファイル名);
            対象ファイルの重複チェック(ファイル名);
            通知内容コードのチェック(ファイルのデータレコード);
            奇数月_偶数月のチェック(ファイルのデータレコード);
            制度コードのチェック(ファイルのデータレコード, ファイル名);
        }
        return true;
    }

    private void 市町村コードチェック(RString ファイルのデータレコード) {
        if (RString.isNullOrEmpty(div.getShoriJokyoPanel().getDdlShichoson().getSelectedValue())) {
            throw new ApplicationException(市町村コードチェック_MSG.toString());
        }
        RString 管理市町村コード = ファイルのデータレコード.substring(INT_0, INT_5);
        RString 市町村コード;
        if (STR_0.equals(div.getShoriJokyoPanel().getGrpHyojikeishiki().getSelectedKey())) {
            市町村コード = div.getShoriJokyoPanel().getDdlShichoson().getSelectedValue().substring(INT_0, INT_5);
        } else {
            市町村コード = div.getShoriTaishoGetuPanel().getDgShichosonShoriSelect().getSelectedItems().get(INT_0).getData5();
        }
        if (!市町村コード.startsWith(管理市町村コード)) {
            throw new ApplicationException(市町村コードチェック_MSG.toString());
        }
    }

    private void ファイル破損チェック(RString ファイルのデータレコード) {
        int ファイルバイト数 = ファイルのデータレコード.length();
        if ((ファイルバイト数 - INT_48 - INT_48) % INT_500 != 0) {
            throw new ApplicationException(ファイル破損チェック_MSG.toString());
        }
    }

    private void 対象ファイル情報種別の存在チェック(RString ファイル名) {
        RString ファイル連携種別 = ファイル名.substring(INT_0, INT_3);
        RString 情報名 = div.getShoriJokyoPanel().getTxtTaisyoFile().getValue();
        if (!情報名.startsWith(ファイル連携種別)) {
            throw new ApplicationException(対象ファイル情報種別の存在チェック_MSG.toString());
        }
    }

    private void 対象ファイルの重複チェック(RString ファイル名) {
        RString ファイル連携種別 = ファイル名.substring(INT_0, INT_3);
        RString searchKey = new RString(ファイル連携種別.toString() + REACH_KEY.toString());
        if (!SharedFile.searchSharedFile(searchKey).isEmpty()) {
            throw new ApplicationException(対象ファイルの重複チェック_MSG.toString());
        }
    }

    private void 通知内容コードのチェック(RString ファイルのデータレコード) {
        RString ブロック = ファイルのデータレコード.substring(INT_96);
        RString ヘッダー通知内容コード = null;
        boolean checkFlag = true;
        int レコード数 = ブロック.length() / INT_500;
        for (int レコード = INT_0; レコード < レコード数; レコード++) {
            if (レコード == INT_0) {
                RString ヘッダー = ブロック.substring(レコード * INT_500, (レコード + INT_1) * INT_500);
                ヘッダー通知内容コード = ヘッダー.substring(INT_9, INT_11);
                continue;
            }
            if (レコード == レコード数 - INT_1) {
                continue;
            }
            RString データレコード = ブロック.substring(レコード * INT_500, (レコード + INT_1) * INT_500);
            RString データ通知内容コード = データレコード.substring(INT_9, INT_11);
            if (!データ通知内容コード.equals(ヘッダー通知内容コード)) {
                checkFlag = false;
                break;
            }
        }
        if (!checkFlag) {
            throw new ApplicationException(対象ファイル情報種別の存在チェック_MSG.toString());
        }
    }

    private void 奇数月_偶数月のチェック(RString ファイルのデータレコード) {
        RString ブロック = ファイルのデータレコード.substring(INT_96);
        RString ヘッダー = ブロック.substring(INT_0, INT_500);
        RString ヘッダー通知内容コード = ヘッダー.substring(INT_9, INT_11);
        RString 選択月;
        RString 選択Key = div.getShoriJokyoPanel().getGrpHyojikeishiki().getSelectedKey();
        if (STR_1.equals(選択Key)) {
            選択月 = div.getShoriJokyoPanel().getDdlGetu().getSelectedKey();
        } else {
            List<dgGetuShoriSelect_Row> 処理対象Rows = div.getShoriTaishoShichosonPanel().getDgGetuShoriSelect().getSelectedItems();
            選択月 = 処理対象Rows.get(INT_0).getData1();
            選択月 = 選択月.substring(INT_0, 選択月.length() - 1);
        }
        int 選択月_INT = Integer.parseInt(選択月.toString());
        if ((選択月_INT % INT_2 != 0) && !STR_22.equals(ヘッダー通知内容コード)) {
            throw new ApplicationException(奇数月のチェック_MSG.toString());
        }
        if ((選択月_INT % INT_2 == 0) && STR_22.equals(ヘッダー通知内容コード)) {
            throw new ApplicationException(偶数月のチェック_MSG.toString());
        }
    }

    private void 制度コードのチェック(RString ファイルのデータレコード, RString ファイル名) {
        RString ブロック = ファイルのデータレコード.substring(INT_96);
        RString ヘッダー = ブロック.substring(INT_0, INT_500);
        RString 特別徴収制度コード = ヘッダー.substring(INT_12, INT_13);
        if (ファイル名.startsWith(Z1) && !STR_0.equals(特別徴収制度コード)) {
            throw new ApplicationException(介護の制度コードのチェック_MSG.toString());
        }
    }

    /**
     * upLoadメソッドです。
     *
     * @param files FileData[]
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public void upLoad(FileData[] files) {
        FileData 選択ファイル = files[INT_0];
        RString ファイル名 = 選択ファイル.getFileName();
        RString shareファイル名 = 共有ファイル名.replace(連携種別, ファイル名.substring(INT_0, INT_3));
        RString 選択Key = div.getShoriJokyoPanel().getGrpHyojikeishiki().getSelectedKey();
        RString 選択月;
        RString 選択市町村ID;
        if (STR_1.equals(選択Key)) {
            選択月 = div.getShoriJokyoPanel().getDdlGetu().getSelectedKey();
            if (選択月.length() < INT_2) {
                選択月 = STR_0.concat(選択月);
            }
            選択市町村ID = div.getShoriTaishoGetuPanel().getDgShichosonShoriSelect().
                    getSelectedItems().get(INT_0).getData6();
        } else {
            List<dgGetuShoriSelect_Row> 処理対象Rows = div.getShoriTaishoShichosonPanel().getDgGetuShoriSelect().getSelectedItems();
            Map<RString, RString> map = get処理月と月Map();
            選択月 = map.get(処理対象Rows.get(INT_0).getData1());
            選択市町村ID = div.getShoriJokyoPanel().getDdlShichoson().getSelectedKey();
        }
        shareファイル名 = shareファイル名.replace(市町村ID, 選択市町村ID);
        shareファイル名 = shareファイル名.replace(対象月, 選択月);
        RString filePath = 選択ファイル.getFilePath();
        File tempFile = new File(filePath.toString());
        filePath = filePath.replace(選択ファイル.getFileName(), shareファイル名);
        if (tempFile.exists()) {
            boolean renameTo = tempFile.renameTo(new File(filePath.toString()));
            if (!renameTo) {
                return;
            }
            SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(shareファイル名));
            sfd = SharedFile.defineSharedFile(sfd);
            CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
            FilesystemPath 絶対パス = new FilesystemPath(filePath);
            SharedFile.copyToSharedFile(sfd, 絶対パス, opts);
            if (STR_1.equals(選択Key)) {
                div.getShoriTaishoGetuPanel().getDgShichosonShoriSelect().
                        getSelectedItems().get(INT_0).setData4(済);
                div.getShoriTaishoGetuPanel().getDgShichosonShoriSelect().
                        getSelectedItems().get(INT_0).setSelectable(false);
            } else {
                div.getShoriTaishoShichosonPanel().getDgGetuShoriSelect().getSelectedItems().get(INT_0).setData4(済);
                div.getShoriTaishoShichosonPanel().getDgGetuShoriSelect().getSelectedItems().get(INT_0).setSelectable(false);
            }
        }
    }

    private RString get行連携種別(RString 処理名) {
        if (処理名.startsWith(異動処理結果情報)) {
            return Z14;
        } else if (処理名.startsWith(結果情報)) {
            return Z14;
        } else if (処理名.startsWith(対象者情報)) {
            return Z11;
        } else {
            return Z13;
        }
    }
}
