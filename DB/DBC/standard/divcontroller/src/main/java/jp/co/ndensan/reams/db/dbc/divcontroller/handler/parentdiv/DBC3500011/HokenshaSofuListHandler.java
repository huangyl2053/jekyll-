/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC3500011;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.business.core.hokenshasofulist.HokenshaSofuResult;
import jp.co.ndensan.reams.db.dbc.definition.core.config.ConfigKeysKokuhorenTorikomi;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hokenshasofulist.HokenshaSofuListMybatisParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3500011.JyusinDataBaitaiTorikomuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3500011.JyusinDataList_Row;
import jp.co.ndensan.reams.db.dbc.service.core.hokenshasofu.HokenshaSofuFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 国保連情報データ媒体取込のHandlerクラスです。
 *
 * @reamsid_L DBC-3030-010 lihang
 */
public class HokenshaSofuListHandler {

    private final JyusinDataBaitaiTorikomuDiv div;
    private final RString searchSharedFile = new RString("1\\_%");
    private static final int ゼロ = 0;
    private static final int 二2 = 2;
    private static final int 三 = 3;
    private static final int 四 = 4;
    private static final int 五 = 5;
    private static final int 六 = 6;
    private static final int 七 = 7;
    private static final int 八 = 8;
    private static final int 十 = 10;
    private static final int 十二 = 12;
    private static final int 八十九 = 89;
    private static final RString カンマ = new RString(",");
    private static final RString ブラケット左 = new RString("[");
    private static final RString ブラケット右 = new RString("]");
    private static final RString DB = new RString("DB");
    private static final RString コロン = new RString(":");
    private static final RString 中黒 = new RString(".");
    private static final RString ハイフン = new RString("-");
    private static final RString REPLACE1 = new RString("_");
    private static final RString REPLACE2 = new RString("\\_");
    private static final RString 給付実績情報111 = new RString("111");
    private static final RString データ種別112 = new RString("112");
    private static final RString データ種別114 = new RString("114");
    private static final RString データ種別151 = new RString("151");
    private static final RString データ種別161 = new RString("161");
    private static final RString データ種別171 = new RString("171");
    private static final RString データ種別172 = new RString("172");
    private static final RString データ種別221 = new RString("221");
    private static final RString データ種別222 = new RString("222");
    private static final RString データ種別331 = new RString("331");
    private static final RString データ種別332 = new RString("332");
    private static final RString データ種別351 = new RString("351");
    private static final RString データ種別533 = new RString("533");
    private static final RString データ種別534 = new RString("534");
    private static final RString データ種別537 = new RString("537");
    private static final RString データ種別5C3 = new RString("5C3");
    private static final RString データ種別5C4 = new RString("5C4");
    private static final RString データ種別121 = new RString("121");
    private static final RString データ種別122 = new RString("122");
    private static final RString データ種別123 = new RString("123");
    private static final RString データ種別152 = new RString("152");
    private static final RString データ種別153 = new RString("153");
    private static final RString データ種別162 = new RString("162");
    private static final RString データ種別163 = new RString("163");
    private static final RString データ種別175 = new RString("175");
    private static final RString データ種別177 = new RString("177");
    private static final RString データ種別178 = new RString("178");
    private static final RString データ種別386 = new RString("386");
    private static final RString データ種別38B = new RString("38B");
    private static final RString データ種別38H = new RString("38H");
    private static final RString データ種別38J = new RString("38J");
    private static final RString データ種別38P = new RString("38P");
    private static final RString データ種別631 = new RString("631");
    private static final RString データ種別632 = new RString("632");
    private static final RString データ種別641 = new RString("641");
    private static final RString データ種別642 = new RString("642");
    private static final RString データ種別651 = new RString("651");
    private static final RString データ種別652 = new RString("652");
    private static final RString データ種別661 = new RString("661");
    private static final RString データ種別662 = new RString("662");
    private static final RString データ種別741 = new RString("741");
    private static final RString 取消3 = new RString("3");
    private static final RString 新規1 = new RString("1");
    private static final RString 一 = new RString("1");
    private static final RString ゼロゼロ = new RString("0");
    private static final RString 二 = new RString("2");
    private static final RString 九 = new RString("9");
    private static final RString H1 = new RString("H1");
    private static final RString D8 = new RString("D8");
    private static RString 保険者番号;

    /**
     * コンストラクタです。
     *
     * @param div JyusinDataBaitaiTorikomuDiv
     */
    public HokenshaSofuListHandler(JyusinDataBaitaiTorikomuDiv div) {
        this.div = div;
    }

    /**
     * initializeのメッソドです。
     */
    public void initialize() {

        List<UzT0885SharedFileEntryEntity> uzt0885EntityList = SharedFile.searchSharedFile(searchSharedFile);
        setDatasource(uzt0885EntityList);
    }

    /**
     * setDatasourceのメソッドです。
     *
     * @param uzt0885EntityList List<UzT0885SharedFileEntryEntity>
     */
    public void setDatasource(List<UzT0885SharedFileEntryEntity> uzt0885EntityList) {
        List<HokenshaSofuResult> hokenshaSofuList1 = new ArrayList();
        List<JyusinDataList_Row> rowList = div.getJyusinDataList().getDataSource();
        if (uzt0885EntityList != null && !uzt0885EntityList.isEmpty()) {
            for (UzT0885SharedFileEntryEntity uzt0885Entity : uzt0885EntityList) {
                hokenshaSofuList1.add(getHokenshaSofuList(uzt0885Entity));
            }
            Collections.sort(hokenshaSofuList1, new Comparator<HokenshaSofuResult>() {
                @Override
                public int compare(HokenshaSofuResult o1, HokenshaSofuResult o2) {
                    RString 一覧表示順1 = o1.getH一覧表示順();
                    RString 一覧表示順2 = o2.getH一覧表示順();
                    int flag = 0;
                    if (一覧表示順1 != null && 一覧表示順2 != null) {
                        flag = 一覧表示順2.compareTo(一覧表示順1);
                    }
                    return flag;
                }
            });
            div.getJyusinDataList().getDataSource().clear();
            for (HokenshaSofuResult entity : hokenshaSofuList1) {
                JyusinDataList_Row row = new JyusinDataList_Row();
                row.setTxtTorikomiJohoMeisho(entity.get取込情報名称());
                row.setTxtFile(entity.getファイル());
                row.setTxtHokenshaNo(entity.get被保険者番号().getColumnValue());
                row.setTxtShoriTaishoNengetsu(entity.get対象年月().toDateString());
                RString 作成日 = entity.get処理日時().getDate().seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
                RString 作成時 = entity.get処理日時().getTime()
                        .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
                row.setTxtKoshinNichiji(作成日.concat(RString.HALF_SPACE).concat(作成時));
                row.setTxtItiranHyoujiJyun(entity.getH一覧表示順());
                row.setDeleteButtonState(DataGridButtonState.Enabled);
                rowList.add(row);
            }
        }
        div.getJyusinDataList().setDataSource(rowList);
    }

    private HokenshaSofuResult getHokenshaSofuList(UzT0885SharedFileEntryEntity uzt0885Entity) {

        RString ファイル = uzt0885Entity.getSharedFileName();
        File file = new File(SharedFile.getBasePath().concat(File.separator)
                .concat(DB.toString()).concat(File.separator)
                .concat(uzt0885Entity.getSharedFileName().toString()).concat(File.separator)
                .concat((uzt0885Entity.getSharedFileId().toString().replace(コロン.toString(), 中黒.toString())
                        .replace(ハイフン.toString(), 中黒.toString()))).concat(File.separator)
                .concat(uzt0885Entity.getLocalFileName().toString()));

        HokenshaSofuResult hokenshaSofuListEntity;
        try (CsvListReader csvReader = new CsvListReader.InstanceBuilder(new RString(file.getAbsolutePath()))
                .setDelimiter(カンマ).setEncode(Encode.SJIS)
                .hasHeader(false).setNewLine(NewLine.CRLF).build()) {
            List<RString> コントロールレコード = csvReader.readLine();
            RString データ種別 = コントロールレコード.get(四);
            ConfigKeysKokuhorenTorikomi 国保連取込情報名称 = ConfigKeysKokuhorenTorikomi.toValue(データ種別);
            hokenshaSofuListEntity = new HokenshaSofuResult();
            if (!コントロールレコード.isEmpty()) {

                RString 一覧表示順 = 国保連取込情報名称.get一覧表示順();
                hokenshaSofuListEntity.set取込情報名称(ブラケット左.concat(データ種別).concat(ブラケット右).concat(国保連取込情報名称.get略称()));
                hokenshaSofuListEntity.setファイル(ファイル);
                hokenshaSofuListEntity.set被保険者番号(new HihokenshaNo(コントロールレコード.get(六)));
                hokenshaSofuListEntity.set対象年月(new FlexibleYearMonth(コントロールレコード.get(十)));
                hokenshaSofuListEntity.set処理日時(uzt0885Entity.getSharedFileId());
                hokenshaSofuListEntity.setH一覧表示順(一覧表示順);
            }
            csvReader.close();
        }
        return hokenshaSofuListEntity;
    }

    /**
     * 受信データリスト.「削除」ボタンのメソッドです。
     */
    public void deleteCsv() {

        List<UzT0885SharedFileEntryEntity> uzt0885EntityList = SharedFile.searchSharedFile(
                div.getJyusinDataList().getClickedItem().getTxtFile().replace(REPLACE1, REPLACE2));
        for (UzT0885SharedFileEntryEntity uzt0885Entity : uzt0885EntityList) {
            ReadOnlySharedFileEntryDescriptor deleteEntity = new ReadOnlySharedFileEntryDescriptor(
                    new FilesystemName(uzt0885Entity.getSharedFileName()), uzt0885Entity.getSharedFileId());
            SharedFile.deleteEntry(deleteEntity);
        }
        List<JyusinDataList_Row> rowList = div.getJyusinDataList().getDataSource();
        rowList.remove(div.getJyusinDataList().getClickedItem());
        div.getJyusinDataList().setDataSource(rowList);
    }

    /**
     * 処理年月取得のメソッドです。
     *
     * @param データ種別 RString
     * @return FlexibleYearMonth
     */
    public FlexibleYearMonth 処理年月取得(RString データ種別) {
        FlexibleYearMonth 処理年月 = FlexibleYearMonth.EMPTY;
        HokenshaSofuResult entity = HokenshaSofuFinder.createInstance().getSukejuruRirekiJoho(データ種別, 一);
        if (entity != null && !entity.getKokuhorenInterfaceKanriList().isEmpty()
                && entity.getKokuhorenInterfaceKanriList().get(ゼロ).get処理年月() != null) {
            処理年月 = entity.getKokuhorenInterfaceKanriList().get(ゼロ).get処理年月();
        } else {
            HokenshaSofuResult entity2 = HokenshaSofuFinder.createInstance().getBykokanShikibetsuNo(データ種別);
            if (entity2 != null && !entity2.getKokuhorenInterfaceKanriList().isEmpty()
                    && entity2.getKokuhorenInterfaceKanriList().get(ゼロ).get処理年月() != null) {
                処理年月 = entity2.getKokuhorenInterfaceKanriList().get(ゼロ).get処理年月();
            }
        }
        return 処理年月;
    }

    /**
     * コントロールレコード配列内容チェックのメソッドです。
     *
     * @param コントロールレコード List<RString>
     * @param file FileData
     * @param データレコード List<RString>
     * @param データ種別 RString
     * @return RString
     */
    public RString コントロールレコード配列内容チェック(
            List<RString> コントロールレコード, FileData file, List<RString> データレコード, RString データ種別) {
        if (コントロールレコード.size() != 十二) {
            throw new ApplicationException(DbcErrorMessages.国保連データフォーマット不正.getMessage());
        }

        if (!コントロールレコード.get(ゼロ).equals(一)) {
            throw new ApplicationException(DbcErrorMessages.国保連レコード種別不正.getMessage());
        }

        RDate nowDate = RDate.getNowDate();
        if (コントロールレコード.get(六) != null && !コントロールレコード.get(六).equals(DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号,
                nowDate, SubGyomuCode.DBU介護統計報告))) {
            throw new ApplicationException(DbcErrorMessages.国保連保険者番号不正.getMessage());
        }

        if (ゼロゼロ.equals(DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, nowDate, SubGyomuCode.DBU介護統計報告))) {
            保険者番号 = コントロールレコード.get(六);
        } else if (一.equals(DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, nowDate, SubGyomuCode.DBU介護統計報告))) {
            保険者番号取得(データレコード, データ種別);
        }
        if (コントロールレコード.get(二2).compareTo(一) > 0) {
            throw new ApplicationException(DbcErrorMessages.国保連ボリューム連番不正.getMessage());
        }
        return 保険者番号;
    }

    private RString 保険者番号取得(List<RString> データレコード, RString データ種別) {
        if (データレコード.get(ゼロ).equals(二)) {
            if (データ種別.equals(給付実績情報111) || データ種別.equals(データ種別112) || データ種別.equals(データ種別114)
                    || データ種別.equals(データ種別386) || データ種別.equals(データ種別38B) || データ種別.equals(データ種別38H)
                    || データ種別.equals(データ種別38J) || データ種別.equals(データ種別38P)) {
                保険者番号 = データレコード.get(六);
            }
            保険者番号取得四(データレコード, データ種別);
            保険者番号取得五(データレコード, データ種別);
        }
        return 保険者番号;
    }

    private RString 保険者番号取得四(List<RString> データレコード, RString データ種別) {
        if (データ種別.equals(データ種別151) || データ種別.equals(データ種別161) || データ種別.equals(データ種別221)
                || データ種別.equals(データ種別222) || データ種別.equals(データ種別331) || データ種別.equals(データ種別351)
                || データ種別.equals(データ種別121) || データ種別.equals(データ種別122) || データ種別.equals(データ種別123)
                || データ種別.equals(データ種別152) || データ種別.equals(データ種別153) || データ種別.equals(データ種別162)
                || データ種別.equals(データ種別163) || データ種別.equals(データ種別631) || データ種別.equals(データ種別632)
                || データ種別.equals(データ種別641) || データ種別.equals(データ種別642) || データ種別.equals(データ種別332)) {
            保険者番号 = データレコード.get(四);
        }
        return 保険者番号;
    }

    private RString 保険者番号取得五(List<RString> データレコード, RString データ種別) {
        保険者番号取得四(データレコード, データ種別);
        if (データ種別.equals(データ種別171) || データ種別.equals(データ種別172) || データ種別.equals(データ種別175)
                || データ種別.equals(データ種別177) || データ種別.equals(データ種別178) || データ種別.equals(データ種別651)
                || データ種別.equals(データ種別652) || データ種別.equals(データ種別661) || データ種別.equals(データ種別662)) {
            保険者番号 = データレコード.get(五);
        }
        if (データ種別.equals(データ種別534) || データ種別.equals(データ種別5C4)) {
            保険者番号 = データレコード.get(七);
        }
        if (データ種別.equals(データ種別537) || データ種別.equals(データ種別5C3) || データ種別.equals(データ種別533)) {
            保険者番号 = データレコード.get(八);
        }
        if (データ種別.equals(データ種別741)) {
            保険者番号 = データレコード.get(二2);
        }
        return 保険者番号;
    }

    /**
     * 二重取込チェックのメソッドです。
     *
     * @param file FileData
     * @param データ種別 RString
     * @param myBatisParameter HokenshaSofuListMybatisParameter
     * @param コントロールレコード List<RString>
     * @param entity HokenshaSofuResult
     * @return RString
     */
    public RString 二重取込チェック(FileData file, RString データ種別, HokenshaSofuListMybatisParameter myBatisParameter,
            List<RString> コントロールレコード, HokenshaSofuResult entity) {
        for (KokuhorenInterfaceKanri faceKanri : entity.getKokuhorenInterfaceKanriList()) {
            if (!myBatisParameter.is同月過誤取下分フラグ()
                    && faceKanri.getコントロール上処理年月() != null
                    && faceKanri.getコントロール上処理年月().toDateString().equals(コントロールレコード.get(十))) {
                if (new RString(DbcQuestionMessages.国保連取込済続行確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                        && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                    return RString.EMPTY;
                }
                if (二重取込チェック判断1(コントロールレコード, faceKanri)) {
                    return new RString("国保連取込済続行確認");
                }
            } else if (myBatisParameter.is同月過誤取下分フラグ()
                    && faceKanri.get過誤コントロール上処理年月() != null
                    && faceKanri.get過誤コントロール上処理年月().toDateString().equals(コントロールレコード.get(十))) {
                if (new RString(DbcQuestionMessages.国保連取込済二重取込続行確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                        && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                    return RString.EMPTY;
                }
                if (二重取込チェック判断2(コントロールレコード, faceKanri)) {
                    return new RString("国保連取込済二重取込続行確認");
                }
            }
        }
        return null;
    }

    /**
     * 審査年月チェックのメソッドです。
     *
     * @param file FileData
     * @param データ種別 RString
     * @param 審査年月の翌月 FlexibleYearMonth
     * @param 審査年月 FlexibleYearMonth
     * @param kanri KokuhorenInterfaceKanri
     * @return RString
     */
    public RString 審査年月チェック(FileData file, RString データ種別, FlexibleYearMonth 審査年月の翌月,
            FlexibleYearMonth 審査年月, KokuhorenInterfaceKanri kanri) {
        if (審査年月 != null && 審査年月の翌月 != null && kanri != null && !(審査年月の翌月.isEmpty() && kanri.get処理状態区分().equals(取消3))) {
            if (new RString(DbcQuestionMessages.国保連先月処理なし取込漏れ確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return RString.EMPTY;
            }
            if (審査年月チェック判断1(データ種別, kanri)) {
                return new RString("国保連先月処理なし取込漏れ確認");
            }
            if (new RString(DbcQuestionMessages.国保連取込漏れ確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return RString.EMPTY;
            }
            if (審査年月の翌月.isBefore(審査年月)
                    && !(new RString(DbcQuestionMessages.国保連取込漏れ確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode()))) {
                return new RString("国保連取込漏れ確認");
            }
            if (new RString(DbcQuestionMessages.国保連取込順序逆転確認.getMessage().getCode())
                    .equals(ResponseHolder.getMessageCode())
                    && ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
                return RString.EMPTY;
            }
            if (審査年月.isBefore(審査年月の翌月)
                    && !(new RString(DbcQuestionMessages.国保連取込順序逆転確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode()))) {
                return new RString("国保連取込順序逆転確認");
            }
        }
        return null;
    }

    /**
     * 判断１のメソッドです。
     *
     * @param データレコード List<RString>
     * @param 給付実績情報作成区分コード RString
     * @param myBatisParameter HokenshaSofuListMybatisParameter
     * @return FlexibleYearMonth
     */
    public FlexibleYearMonth 判断１(List<RString> データレコード, RString 給付実績情報作成区分コード,
            HokenshaSofuListMybatisParameter myBatisParameter) {
        FlexibleYearMonth 審査年月 = FlexibleYearMonth.EMPTY;
        if (データレコード.get(ゼロ).equals(二) && (データレコード.get(四).equals(D8) || データレコード.get(四).equals(H1))) {
            if (取消3.equals(給付実績情報作成区分コード)) {
                myBatisParameter.set同月過誤取下分フラグ(true);
            } else if (新規1.equals(給付実績情報作成区分コード)) {
                myBatisParameter.set同月過誤取下分フラグ(false);
            }
            審査年月 = new FlexibleYearMonth(データレコード.get(八十九));
        }
        return 審査年月;
    }

    private boolean 二重取込チェック判断1(List<RString> コントロールレコード, KokuhorenInterfaceKanri faceKanri) {
        return コントロールレコード.get(三) != null && !コントロールレコード.get(三).isEmpty()
                && faceKanri.getコントロール上レコード件数() == Integer.parseInt(コントロールレコード.get(三).toString())
                && !(new RString(DbcQuestionMessages.国保連取込済続行確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode()))
                && !(new RString(DbcQuestionMessages.国保連先月処理なし取込漏れ確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode()))
                && !(new RString(DbcQuestionMessages.国保連取込順序逆転確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode()))
                && !(new RString(DbcQuestionMessages.国保連取込漏れ確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode()));
    }

    private boolean 二重取込チェック判断2(List<RString> コントロールレコード, KokuhorenInterfaceKanri faceKanri) {
        return !コントロールレコード.get(三).isEmpty()
                && faceKanri.get過誤コントロール上レコード件数() == Integer.parseInt(コントロールレコード.get(三).toString())
                && !(new RString(DbcQuestionMessages.国保連取込済二重取込続行確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode()))
                && !(new RString(DbcQuestionMessages.国保連先月処理なし取込漏れ確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode()))
                && !(new RString(DbcQuestionMessages.国保連取込順序逆転確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode()))
                && !(new RString(DbcQuestionMessages.国保連取込漏れ確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode()));
    }

    private boolean 審査年月チェック判断1(RString データ種別, KokuhorenInterfaceKanri kanri) {
        return 給付実績情報111.equals(データ種別) && kanri.get処理状態区分().equals(九)
                && !(new RString(DbcQuestionMessages.国保連先月処理なし取込漏れ確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode()))
                && !(new RString(DbcQuestionMessages.国保連取込順序逆転確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode()))
                && !(new RString(DbcQuestionMessages.国保連取込漏れ確認.getMessage().getCode()).equals(ResponseHolder.getMessageCode()));
    }
}
