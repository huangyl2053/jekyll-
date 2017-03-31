/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5240001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.chosaocrtorikomi.ChosaOCRTorikomiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteikekkajoho.NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinsakaiwariateiinjoho.ShinsakaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.OcrTorikomiUtil;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJoho2;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OcrDataType;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OcrFiles;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5240001.ChosaOCRTorikomiMainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5240001.TorikomiData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5240001.TorikomiEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5240001.dgChosahyoTorikomiKekka_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.dokuji.NijiHanteiKekkaInputHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.ShinsakaiShinchokuJokyo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.batch.externalcharacter.reader.CsvListReader;
import jp.co.ndensan.reams.uz.uza.batch.externalcharacter.reader.CsvListReaderParameter;
import jp.co.ndensan.reams.uz.uza.batch.externalcharacter.reader.CsvListReaderParameterBuilder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 介護認定審査会審査結果登録（OCR)クラスです。
 *
 * @reamsid_L DBE-1560-010 suguangjun
 */
public class ChosaOCRTorikomiHandler {

    private static final RString 空白 = RString.EMPTY;
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private final Code 識別コード_09A = new Code("09A");
    private final Code 識別コード_09B = new Code("09B");
    private final Code 識別コード_99A = new Code("99A");
    private final ChosaOCRTorikomiMainDiv div;
    private static final RString INDEX_1 = new RString("1");
    private static final int INDEX_4 = 4;
    private static final RString 非該当 = new RString("非該当");
    private static final RString 要支援1 = new RString("要支援1");
    private static final RString 要支援2 = new RString("要支援2");
    private static final RString 要介護1 = new RString("要介護1");
    private static final RString 要介護2 = new RString("要介護2");
    private static final RString 要介護3 = new RString("要介護3");
    private static final RString 要介護4 = new RString("要介護4");
    private static final RString 要介護5 = new RString("要介護5");
    private static final int INDEX_60 = 60;
    private static final int INDEX_61 = 60;

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会審査結果div
     */
    public ChosaOCRTorikomiHandler(ChosaOCRTorikomiMainDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理。
     *
     * @param torikomiList 介護認定審査会審査結果情報
     */
    public void onLoad(List<ChosaOCRTorikomiBusiness> torikomiList) {
        div.getTxtShinsakaiName().setValue(torikomiList.get(0).get審査会名称());
        div.getTxtGogitaiNo().setValue(torikomiList.get(0).get合議体名称());
        div.getTxtShinsaTaishosha().setValue(new RString(torikomiList.get(0).get介護認定審査会割当済み人数()));
        div.getTxtTaishoNinzu().setValue(new RString(torikomiList.get(0).get介護認定審査会実施人数()));
        div.getTxtGogitaiNo().setValue(torikomiList.get(0).get合議体名称());
        if (!torikomiList.get(0).get介護認定審査会進捗状況().isEmpty()) {
            div.getTxtStutas().setValue(ShinsakaiShinchokuJokyo.toValue(torikomiList.get(0).get介護認定審査会進捗状況().value()).get画面表示名称());
        }
        div.getTxtShinsakaiKaijo().setValue(torikomiList.get(0).get介護認定審査会開催場所名称());
        if (torikomiList.get(0).get介護認定審査会開催地区コード() != null) {
            div.getTxtChiku().setValue(torikomiList.get(0).get介護認定審査会開催地区コード().value());
            div.getTxtShinsakaijoJusho().setValue(CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DBECodeShubetsu.審査会地区コード.getコード(),
                    torikomiList.get(0).get介護認定審査会開催地区コード(), FlexibleDate.getNowDate()));
        }
        div.getTxtKaisaiNichiji().setValue(torikomiList.get(0).get介護認定審査会開催年月日());
        div.getTxtKaisaiTimeRange().setFromValue(RTime.of(rStringToInt(torikomiList.get(0).get介護認定審査会開始時刻().substring(0, 2)),
                rStringToInt(torikomiList.get(0).get介護認定審査会開始時刻().substring(2))));
        div.getTxtKaisaiTimeRange().setToValue(RTime.of(rStringToInt(torikomiList.get(0).get介護認定審査会終了時刻().substring(0, 2)),
                rStringToInt(torikomiList.get(0).get介護認定審査会終了時刻().substring(2))));
    }

    /**
     * ヘッドエリアが非活性に設定します。
     */
    public void setDisabledTrue() {
        div.getTxtShinsakaiName().setDisabled(true);
        div.getTxtGogitaiNo().setDisabled(true);
        div.getTxtShinsaTaishosha().setDisabled(true);
        div.getTxtTaishoNinzu().setDisabled(true);
        div.getTxtGogitaiNo().setDisabled(true);
        div.getTxtStutas().setDisabled(true);
        div.getTxtShinsakaiKaijo().setDisabled(true);
        div.getTxtChiku().setDisabled(true);
        div.getTxtShinsakaijoJusho().setDisabled(true);
        div.getTxtKaisaiNichiji().setDisabled(true);
        div.getTxtKaisaiTimeRange().setDisabled(true);
        div.getTxtKaisaiTimeRange().setDisabled(true);
    }

    /**
     * 審査結果OCRを取込ボタンを押します。
     *
     * @param sfed 共有ファイルエントリ
     * @return CSVData
     */
    public List<TorikomiData> perseShinsaKekkaCsv(SharedFileEntryDescriptor sfed) {
        if (sfed == null) {
            return Collections.emptyList();
        }
        return getCSVファイル(sfed);
    }

    private List<TorikomiData> getCSVファイル(SharedFileEntryDescriptor sfed) {
        Map<OcrDataType, OcrFiles> filesByType = OcrTorikomiUtil.copyToLocalAndGroupingByType(
                ReadOnlySharedFileEntryDescriptor.fromString(sfed.toString())
        );
        RString csvFilePath = filesByType.get(OcrDataType.二次判定結果記入シート).findCsvFilePath();
        List<TorikomiData> list = new ArrayList<>();
        if (csvFilePath.isEmpty()) {
            return list;
        }
        try (CsvListReader reader = new CsvListReader(param(csvFilePath))) {
            while (true) {
                List<RString> aLine = reader.readLine();
                if (aLine == null) {
                    break;
                }
                list.add(toTorikomiData(aLine));
            }
        }
        return list;
    }

    private static CsvListReaderParameter param(RString csvFilePath) {
        return new CsvListReaderParameterBuilder(csvFilePath)
                .colDelimiter(CSV_WRITER_DELIMITER).rowDelimiter(NewLine.CRLF).encode(Encode.UTF_8).hasHeader(false).build();
    }

    //TODO TorikomiDataのコンストラクタにする。
    private static TorikomiData toTorikomiData(List<RString> list) {
        TorikomiData data = new TorikomiData();
        data.set項目数(list.size());
        return data;
    }

    /**
     * 画面一覧の設定します。
     *
     * @param dataList DBとCSV情報
     * @param 審査会開催番号 審査会開催番号
     */
    public void set画面一覧(List<TorikomiEntity> dataList, RString 審査会開催番号) {
        set一覧(dataList, 審査会開催番号);
    }

    private void set一覧(List<TorikomiEntity> dataList, RString 審査会開催番号) {
        List<dgChosahyoTorikomiKekka_Row> rowList = new ArrayList<>();
        int 連番 = 1;
        for (TorikomiEntity data : dataList) {
            TextBoxFlexibleDate flexibleDate = new TextBoxFlexibleDate();
            flexibleDate.setValue(data.get申請日());
            RString 申請書管理番号 = RString.EMPTY;
            if (data.get申請書管理番号() != null) {
                申請書管理番号 = data.get申請書管理番号().value();
            }
            dgChosahyoTorikomiKekka_Row row = new dgChosahyoTorikomiKekka_Row(new RString(連番),
                    data.getOK_NG(),
                    data.get保険者(),
                    data.get被保険者番号(),
                    flexibleDate,
                    get申請区分(data.get申請区分()),
                    data.get被保険者氏名().value(),
                    get1次判定結果(data),
                    get要介護状態像例(data),
                    get二次判定結果(data),
                    data.get認定有効期間(),
                    dateFormat1(get認定有効期間開始日(data)),
                    get認定有効期間終了日(data),
                    data.get保険者番号(),
                    申請書管理番号,
                    審査会開催番号);
            rowList.add(row);
            連番++;
        }
        div.getDgChosahyoTorikomiKekka().setDataSource(rowList);
    }

    private RString get認定有効期間終了日(TorikomiEntity data) {
        FlexibleDate 開始年月日 = get認定有効期間開始日(data);
        if (!開始年月日.isEmpty()) {
            RStringBuilder builder = new RStringBuilder();
            if (開始年月日.getDayValue() == 1) {
                FlexibleDate date = 開始年月日.plusMonth(rStringToInt(data.get認定有効期間()) - 1);
                builder.append(date.getYearMonth());
                builder.append(date.getLastDay());
            } else {
                FlexibleDate date = 開始年月日.plusMonth(rStringToInt(data.get認定有効期間()));
                builder.append(date.getYearMonth());
                builder.append(date.getLastDay());
            }
            return dateFormat1(new FlexibleDate(builder.toRString()));
        }
        return RString.EMPTY;
    }

    private int rStringToInt(RString data) {
        if (data != null) {
            return Integer.valueOf(data.toString());
        }
        return 0;
    }

    private FlexibleDate get認定有効期間開始日(TorikomiEntity data) {
        FlexibleDate 認定有効期間開始日 = FlexibleDate.EMPTY;
        if (data.get申請区分() != null && NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(data.get申請区分().value())
                && (要支援1.equals(get二次判定結果(data)) || 要支援2.equals(get二次判定結果(data)))) {
            認定有効期間開始日 = data.get申請日();
        }
        if (data.get申請区分() != null && NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(data.get申請区分().value())
                && (要介護1.equals(get二次判定結果(data)) || 要介護2.equals(get二次判定結果(data))
                || 要介護3.equals(get二次判定結果(data)) || 要介護4.equals(get二次判定結果(data))
                || 要介護5.equals(get二次判定結果(data)))) {
            認定有効期間開始日 = data.get申請日();
        }
        認定有効期間開始日 = get認定有効期間開始日1(data, 認定有効期間開始日);
        認定有効期間開始日 = get認定有効期間開始日2(data, 認定有効期間開始日);
        認定有効期間開始日 = get認定有効期間開始日3(data, 認定有効期間開始日);
        認定有効期間開始日 = get認定有効期間開始日4(data, 認定有効期間開始日);
        認定有効期間開始日 = get認定有効期間開始日5(data, 認定有効期間開始日);
        認定有効期間開始日 = get認定有効期間開始日6(data, 認定有効期間開始日);
        認定有効期間開始日 = get認定有効期間開始日7(data, 認定有効期間開始日);
        認定有効期間開始日 = get認定有効期間開始日8(data, 認定有効期間開始日);
        認定有効期間開始日 = get認定有効期間開始日9(data, 認定有効期間開始日);
        認定有効期間開始日 = get認定有効期間開始日10(data, 認定有効期間開始日);
        return 認定有効期間開始日;
    }

    private FlexibleDate get認定有効期間開始日1(TorikomiEntity data, FlexibleDate 認定有効期間開始日) {
        if (data.get申請区分() != null && NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(data.get申請区分().value())
                && (data.get二次判定認定有効終了年月日() != null && !data.get二次判定認定有効終了年月日().isEmpty())
                && (data.get介護認定審査会開催予定年月日() != null && !data.get介護認定審査会開催予定年月日().isEmpty())
                && data.get介護認定審査会開催予定年月日().isBeforeOrEquals(data.get二次判定認定有効終了年月日())
                && (YokaigoJotaiKubun.要支援1.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要支援2.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード())))
                && data.get申請日().isBefore(data.get二次判定認定有効終了年月日().minusDay(INDEX_60))
                && (要支援1.equals(get二次判定結果(data)) || 要支援2.equals(get二次判定結果(data)))
                && get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()).equals(get二次判定結果(data))) {
            認定有効期間開始日 = get認定有効終了年月日の次月１日(data.get二次判定認定有効終了年月日());
        }
        return 認定有効期間開始日;
    }

    private RString get二次判定要介護状態区分(Code code) {
        if (code != null && !code.isEmpty()) {
            return YokaigoJotaiKubun.toValue(code.value()).get名称();
        }
        return RString.EMPTY;
    }

    private FlexibleDate get認定有効終了年月日の次月１日(FlexibleDate data) {
        RStringBuilder builder = new RStringBuilder();
        if (data != null && !data.isEmpty()) {
            builder.append(data.plusMonth(1).getYearMonth());
            builder.append("01");
            return new FlexibleDate(builder.toRString());
        }
        return FlexibleDate.EMPTY;
    }

    private FlexibleDate get認定有効期間開始日2(TorikomiEntity data, FlexibleDate 認定有効期間開始日) {
        if (data.get申請区分() != null && NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(data.get申請区分().value())
                && (data.get二次判定認定有効終了年月日() != null && !data.get二次判定認定有効終了年月日().isEmpty())
                && (data.get介護認定審査会開催予定年月日() != null && !data.get介護認定審査会開催予定年月日().isEmpty())
                && data.get介護認定審査会開催予定年月日().isBeforeOrEquals(data.get二次判定認定有効終了年月日())
                && (YokaigoJotaiKubun.要支援1.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要支援2.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード())))
                && data.get申請日().isBefore(data.get二次判定認定有効終了年月日().minusDay(INDEX_61))
                && (要支援1.equals(get二次判定結果(data)) || 要支援2.equals(get二次判定結果(data)))
                && get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()).equals(get二次判定結果(data))) {
            認定有効期間開始日 = data.get二次判定年月日();
        }
        return 認定有効期間開始日;
    }

    private FlexibleDate get認定有効期間開始日3(TorikomiEntity data, FlexibleDate 認定有効期間開始日) {
        if (data.get申請区分() != null && NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(data.get申請区分().value())
                && (data.get二次判定認定有効終了年月日() != null && !data.get二次判定認定有効終了年月日().isEmpty())
                && (data.get介護認定審査会開催予定年月日() != null && !data.get介護認定審査会開催予定年月日().isEmpty())
                && data.get介護認定審査会開催予定年月日().isBeforeOrEquals(data.get二次判定認定有効終了年月日())
                && (YokaigoJotaiKubun.要支援1.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要支援2.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード())))
                && (要支援1.equals(get二次判定結果(data)) || 要支援2.equals(get二次判定結果(data)))
                && !get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()).equals(get二次判定結果(data))) {
            認定有効期間開始日 = data.get申請日();
        }
        return 認定有効期間開始日;
    }

    private FlexibleDate get認定有効期間開始日4(TorikomiEntity data, FlexibleDate 認定有効期間開始日) {
        if (data.get申請区分() != null && NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(data.get申請区分().value())
                && (data.get二次判定認定有効終了年月日() != null && !data.get二次判定認定有効終了年月日().isEmpty())
                && (data.get介護認定審査会開催予定年月日() != null && !data.get介護認定審査会開催予定年月日().isEmpty())
                && data.get介護認定審査会開催予定年月日().isBeforeOrEquals(data.get二次判定認定有効終了年月日())
                && (YokaigoJotaiKubun.要支援1.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要支援2.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード())))
                && (要介護1.equals(get二次判定結果(data)) || 要介護2.equals(get二次判定結果(data)) || 要介護3.equals(get二次判定結果(data))
                || 要介護4.equals(get二次判定結果(data)) || 要介護5.equals(get二次判定結果(data)))) {
            認定有効期間開始日 = data.get申請日();
        }
        return 認定有効期間開始日;
    }

    private FlexibleDate get認定有効期間開始日5(TorikomiEntity data, FlexibleDate 認定有効期間開始日) {
        if (data.get申請区分() != null && NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(data.get申請区分().value())
                && (data.get二次判定認定有効終了年月日() != null && !data.get二次判定認定有効終了年月日().isEmpty())
                && (data.get介護認定審査会開催予定年月日() != null && !data.get介護認定審査会開催予定年月日().isEmpty())
                && (YokaigoJotaiKubun.要介護1.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要介護2.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要介護3.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要介護4.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要介護5.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード())))
                && data.get申請日().isBefore(data.get二次判定認定有効終了年月日().minusDay(INDEX_60))
                && (要介護1.equals(get二次判定結果(data)) || 要介護2.equals(get二次判定結果(data)) || 要介護3.equals(get二次判定結果(data))
                || 要介護4.equals(get二次判定結果(data)) || 要介護5.equals(get二次判定結果(data)))
                && get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()).equals(get二次判定結果(data))) {
            認定有効期間開始日 = data.get二次判定年月日();
        }
        return 認定有効期間開始日;
    }

    private FlexibleDate get認定有効期間開始日6(TorikomiEntity data, FlexibleDate 認定有効期間開始日) {
        if (data.get申請区分() != null && NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(data.get申請区分().value())
                && (data.get二次判定認定有効終了年月日() != null && !data.get二次判定認定有効終了年月日().isEmpty())
                && !get開催予定年月日(data.get介護認定審査会開催予定年月日()).isEmpty()
                && data.get介護認定審査会開催予定年月日().isBeforeOrEquals(data.get二次判定認定有効終了年月日())
                && (YokaigoJotaiKubun.要介護1.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要介護2.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要介護3.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要介護4.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要介護5.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード())))
                && data.get申請日().isBefore(data.get二次判定認定有効終了年月日().minusDay(INDEX_61))
                && (要介護1.equals(get二次判定結果(data)) || 要介護2.equals(get二次判定結果(data)) || 要介護3.equals(get二次判定結果(data))
                || 要介護4.equals(get二次判定結果(data)) || 要介護5.equals(get二次判定結果(data)))
                && get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()).equals(get二次判定結果(data))) {
            認定有効期間開始日 = get認定有効終了年月日の次月１日(data.get二次判定認定有効終了年月日());
        }
        return 認定有効期間開始日;
    }

    private FlexibleDate get開催予定年月日(FlexibleDate data) {
        FlexibleDate 開催予定年月日 = FlexibleDate.EMPTY;
        if (data != null) {
            開催予定年月日 = data;
        }
        return 開催予定年月日;
    }

    private FlexibleDate get認定有効期間開始日7(TorikomiEntity data, FlexibleDate 認定有効期間開始日) {
        if (data.get申請区分() != null && NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(data.get申請区分().value())
                && (data.get二次判定認定有効終了年月日() != null && !data.get二次判定認定有効終了年月日().isEmpty())
                && !get開催予定年月日(data.get介護認定審査会開催予定年月日()).isEmpty()
                && data.get介護認定審査会開催予定年月日().isBeforeOrEquals(data.get二次判定認定有効終了年月日())
                && (YokaigoJotaiKubun.要介護1.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要介護2.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要介護3.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要介護4.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要介護5.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード())))
                && (要介護1.equals(get二次判定結果(data)) || 要介護2.equals(get二次判定結果(data)) || 要介護3.equals(get二次判定結果(data))
                || 要介護4.equals(get二次判定結果(data)) || 要介護5.equals(get二次判定結果(data)))
                && !get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()).equals(get二次判定結果(data))) {
            認定有効期間開始日 = data.get申請日();
        }
        return 認定有効期間開始日;
    }

    private FlexibleDate get認定有効期間開始日8(TorikomiEntity data, FlexibleDate 認定有効期間開始日) {
        if (data.get申請区分() != null && NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(data.get申請区分().value())
                && (data.get二次判定認定有効終了年月日() != null && !data.get二次判定認定有効終了年月日().isEmpty())
                && !get開催予定年月日(data.get介護認定審査会開催予定年月日()).isEmpty()
                && data.get介護認定審査会開催予定年月日().isBeforeOrEquals(data.get二次判定認定有効終了年月日())
                && (YokaigoJotaiKubun.要介護1.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要介護2.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要介護3.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要介護4.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要介護5.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード())))
                && (要支援1.equals(get二次判定結果(data)) || 要支援2.equals(get二次判定結果(data)))) {
            認定有効期間開始日 = data.get二次判定年月日();
        }
        return 認定有効期間開始日;
    }

    private FlexibleDate get認定有効期間開始日9(TorikomiEntity data, FlexibleDate 認定有効期間開始日) {
        if (data.get申請区分() != null && NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(data.get申請区分().value())
                && (data.get二次判定認定有効終了年月日() != null && !data.get二次判定認定有効終了年月日().isEmpty())
                && !get開催予定年月日(data.get介護認定審査会開催予定年月日()).isEmpty()
                && data.get介護認定審査会開催予定年月日().isBeforeOrEquals(data.get二次判定認定有効終了年月日())
                && (YokaigoJotaiKubun.要支援1.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要支援2.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード())))
                && (要介護1.equals(get二次判定結果(data)) || 要介護2.equals(get二次判定結果(data)) || 要介護3.equals(get二次判定結果(data))
                || 要介護4.equals(get二次判定結果(data)) || 要介護5.equals(get二次判定結果(data)))) {
            認定有効期間開始日 = get認定有効終了年月日の次月１日(data.get二次判定認定有効終了年月日());
        }
        return 認定有効期間開始日;
    }

    private FlexibleDate get認定有効期間開始日10(TorikomiEntity data, FlexibleDate 認定有効期間開始日) {
        if (data.get申請区分() != null && NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(data.get申請区分().value())
                && (data.get二次判定認定有効終了年月日() != null && !data.get二次判定認定有効終了年月日().isEmpty())
                && !get開催予定年月日(data.get介護認定審査会開催予定年月日()).isEmpty()
                && data.get介護認定審査会開催予定年月日().isBeforeOrEquals(data.get二次判定認定有効終了年月日())
                && (YokaigoJotaiKubun.要介護1.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要介護2.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要介護3.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要介護4.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード()))
                || YokaigoJotaiKubun.要介護5.get名称().equals(get二次判定要介護状態区分(data.get二次判定要介護状態区分コード())))
                && (要支援1.equals(get二次判定結果(data)) || 要支援2.equals(get二次判定結果(data)))) {
            認定有効期間開始日 = get認定有効終了年月日の次月１日(data.get二次判定認定有効終了年月日());
        }
        return 認定有効期間開始日;
    }

    private RString get二次判定結果(TorikomiEntity data) {
        RString 二次判定結果 = RString.EMPTY;
        if (INDEX_1.equals(data.get非該当())) {
            二次判定結果 = new RString("非該当");
        } else if (INDEX_1.equals(data.get要支援1())) {
            二次判定結果 = new RString("要支援1");
        } else if (INDEX_1.equals(data.get要支援2())) {
            二次判定結果 = new RString("要支援2");
        } else if (INDEX_1.equals(data.get要介護1())) {
            二次判定結果 = new RString("要介護1");
        } else if (INDEX_1.equals(data.get要介護2())) {
            二次判定結果 = new RString("要介護2");
        } else if (INDEX_1.equals(data.get要介護3())) {
            二次判定結果 = new RString("要介護3");
        } else if (INDEX_1.equals(data.get要介護4())) {
            二次判定結果 = new RString("要介護4");
        } else if (INDEX_1.equals(data.get要介護5())) {
            二次判定結果 = new RString("要介護5");
        }
        return 二次判定結果;
    }

    private RString get要介護状態像例(TorikomiEntity data) {
        RString 要介護状態像例 = RString.EMPTY;
        if (INDEX_1.equals(data.get状態像1())) {
            要介護状態像例 = new RString("認知機能の低下");
        } else if (INDEX_1.equals(data.get状態像2())) {
            要介護状態像例 = new RString("不安定な状態");
        }
        return 要介護状態像例;
    }

    private RString get申請区分(Code code) {
        if (code != null) {
            return NinteiShinseiShinseijiKubunCode.toValue(code.value()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get1次判定結果(TorikomiEntity data) {
        RString 判定結果 = RString.EMPTY;
        if (data != null && data.get一次判定結果() != null) {
            if (識別コード_99A.equals(data.get厚労省IF識別コード())) {
                判定結果 = IchijiHanteiKekkaCode99.toValue(data.get一次判定結果().value()).get名称();
            } else if (識別コード_09A.equals(data.get厚労省IF識別コード()) || 識別コード_09B.equals(data.get厚労省IF識別コード())) {
                判定結果 = IchijiHanteiKekkaCode09.toValue(data.get一次判定結果().value()).get名称();
            }
        }
        return 判定結果;
    }

    /**
     * 要介護認定結果情報を設定します。
     *
     * @param ninteiKekkaJoho 要介護認定結果情報
     * @param row 画面一覧
     * @param data 登録用オブジェクト
     * @param 審査会開催番号 審査会開催番号
     * @return NinteiKekkaJoho 要介護認定結果情報)
     */
    public NinteiKekkaJoho editNinteiKekkaJoho(NinteiKekkaJoho ninteiKekkaJoho, dgChosahyoTorikomiKekka_Row row, TorikomiEntity data, RString 審査会開催番号) {
        int 認定有効期間 = 0;
        if (row.getNinteiYukoKikan() != null) {
            認定有効期間 = Integer.valueOf(row.getNinteiYukoKikan().toString());
        }
        return ninteiKekkaJoho.createBuilderForEdit().set二次判定年月日(new FlexibleDate(get審査会開催日(data.get審査会開催日())))
                .set二次判定要介護状態区分コード(get二次判定要介護状態区分コード(data, row))
                .set二次判定認定有効期間(認定有効期間)
                .set二次判定認定有効開始年月日(new FlexibleDate(dateFormat34(row.getNinteiYukoKikanKaishiYMD())))
                .set二次判定認定有効終了年月日(new FlexibleDate(dateFormat34(row.getNinteiYukoKikanShuryoYMD())))
                .set介護認定審査会資料作成年月日(FlexibleDate.EMPTY)
                .set介護認定審査会開催番号(審査会開催番号)
                .set介護認定審査会意見(空白)
                .set一次判定結果変更理由(空白)
                .set要介護状態像例コード(Code.EMPTY)
                .set認定審査会意見種類(空白)
                .set審査会メモ(空白)
                .set二次判定結果入力方法(new Code(NijiHanteiKekkaInputHoho.OCR取込み.getコード()))
                .set二次判定結果入力年月日(FlexibleDate.getNowDate())
                .build();
    }

    private Code get二次判定要介護状態区分コード(TorikomiEntity data, dgChosahyoTorikomiKekka_Row row) {
        RString 状態区分コード = RString.EMPTY;
        if (!RString.isNullOrEmpty(row.getSecondJudgmentResult())) {
            if (識別コード_99A.equals(data.get厚労省IF識別コード())) {
                状態区分コード = get状態区分コード99(get区分名称(row.getSecondJudgmentResult()));
            } else if (識別コード_09A.equals(data.get厚労省IF識別コード()) || 識別コード_09B.equals(data.get厚労省IF識別コード())) {
                状態区分コード = get状態区分コード09(get区分名称(row.getSecondJudgmentResult()));
            }
        }
        return new Code(状態区分コード);
    }

    private RString get区分名称(RString name) {
        if (非該当.equals(name)) {
            name = new RString("非該");
        } else if (要支援1.equals(name)) {
            name = new RString("支1");
        } else if (要支援2.equals(name)) {
            name = new RString("支2");
        } else if (要介護1.equals(name)) {
            name = new RString("介1");
        } else if (要介護2.equals(name)) {
            name = new RString("介2");
        } else if (要介護3.equals(name)) {
            name = new RString("介3");
        } else if (要介護4.equals(name)) {
            name = new RString("介4");
        } else if (要介護5.equals(name)) {
            name = new RString("介5");
        }
        return name;
    }

    private RString get状態区分コード99(RString name) {
        RString 状態区分コード = RString.EMPTY;
        if (!RString.isNullOrEmpty(name)) {
            for (IchijiHanteiKekkaCode99 kekkaCode99 : IchijiHanteiKekkaCode99.values()) {
                if (kekkaCode99.get名称().equals(name)) {
                    状態区分コード = kekkaCode99.getコード();
                }
            }
        }
        return 状態区分コード;
    }

    private RString get状態区分コード09(RString name) {
        RString 状態区分コード = RString.EMPTY;
        if (!RString.isNullOrEmpty(name)) {
            for (IchijiHanteiKekkaCode09 kekkaCode09 : IchijiHanteiKekkaCode09.values()) {
                if (kekkaCode09.get名称().equals(name)) {
                    状態区分コード = kekkaCode09.getコード();
                }
            }
        }
        return 状態区分コード;
    }

    /**
     * 介護認定審査会割当委員情報を設定します。
     *
     * @param shinsakaiWariateIinJoho 介護認定審査会割当委員情報
     * @param row 画面一覧
     * @param data 登録用オブジェクト
     * @param 審査会開催番号 審査会開催番号
     * @return NinteiKekkaJoho 介護認定審査会割当委員情報
     */
    public ShinsakaiWariateIinJoho editShinsakaiWariateIinJoho(ShinsakaiWariateIinJoho shinsakaiWariateIinJoho, dgChosahyoTorikomiKekka_Row row,
            TorikomiEntity data, RString 審査会開催番号) {
        return shinsakaiWariateIinJoho.createBuilderForEdit().set介護認定審査会開催年月日(new FlexibleDate(get審査会開催日(data.get審査会開催日())))
                .set委員遅刻有無(false)
                .set委員出席時間(data.get開催開始時間())
                .set委員早退有無(false)
                .set委員退席時間(data.get開催終了時間())
                .build();
    }

    private RString dateFormat34(RString date) {
        if (!RString.isNullOrEmpty(date)) {
            return new RDate(date.toString()).seireki().separator(Separator.NONE).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }

    /**
     * 介護認定審査会開催結果情報を設定します。
     *
     * @param kekkaJoho 介護認定審査会開催結果情報
     * @param row 画面一覧
     * @param data 登録用オブジェクト
     * @return ShinsakaiKaisaiKekkaJoho2 介護認定審査会開催結果情報
     */
    public ShinsakaiKaisaiKekkaJoho2 editShinsakaiKaisaiKekkaJoho(ShinsakaiKaisaiKekkaJoho2 kekkaJoho, dgChosahyoTorikomiKekka_Row row, TorikomiEntity data) {
        return kekkaJoho.createBuilderForEdit().set合議体番号(data.get合議体番号())
                .set介護認定審査会開催年月日(new FlexibleDate(get審査会開催日(data.get審査会開催日())))
                .set介護認定審査会開始時刻(data.get開催開始時間())
                .set介護認定審査会終了時刻(data.get開催終了時間())
                .set介護認定審査会開催場所コード(data.get介護認定審査会開催予定場所コード())
                .set所要時間合計(get所要時間合計(data))
                .set介護認定審査会実施人数(rStringToInt(data.get実施人数()))
                .build();
    }

    private RString get審査会開催日(RString data) {
        RStringBuilder builder1 = new RStringBuilder();
        builder1.append(new RString("平成"));
        builder1.append(data.substring(0, 2));
        builder1.append(new RString("年"));
        RStringBuilder builder2 = new RStringBuilder();
        builder2.append(new RDate(builder1.toString()).seireki().toDateString().substring(0, INDEX_4));
        builder2.append(data.substring(2));
        return builder2.toRString();
    }

    private int get所要時間合計(TorikomiEntity data) {
        if (data != null && !RString.isNullOrEmpty(data.get開催開始時間()) && !RString.isNullOrEmpty(data.get開催終了時間())) {
            return Integer.valueOf(data.get開催終了時間().toString()) - Integer.valueOf(data.get開催開始時間().toString());
        }
        return 0;
    }

    private RString dateFormat1(FlexibleDate date) {
        if (date != null) {
            return date.wareki().toDateString();
        }
        return RString.EMPTY;
    }

    /**
     * DB更新用データの設定します。
     *
     * @param csvData csvData
     * @return TorikomiData
     */
    public TorikomiData setDB更新用データ(TorikomiData csvData) {
        TorikomiData data = new TorikomiData();
        data.set項目数(csvData.get項目数());
        data.setOK_NG(csvData.getOK_NG());
        data.setID1(csvData.getID1());
        data.set審査会開催番号(csvData.get審査会開催番号());
        data.set審査会開催日(csvData.get審査会開催日());
        data.set開催開始時間(csvData.get開催開始時間());
        data.set開催終了時間(csvData.get開催終了時間());
        data.set実施人数(csvData.get実施人数());
        data.set審査員コード1(csvData.get審査員コード1());
        data.set審査員1(csvData.get審査員1());
        data.set審査員コード2(csvData.get審査員コード2());
        data.set審査員2(csvData.get審査員2());
        data.set審査員コード3(csvData.get審査員コード3());
        data.set審査員3(csvData.get審査員3());
        data.set審査員コード4(csvData.get審査員コード4());
        data.set審査員4(csvData.get審査員4());
        data.set審査員コード5(csvData.get審査員コード5());
        data.set審査員5(csvData.get審査員5());
        data.set審査員コード6(csvData.get審査員コード6());
        data.set審査員6(csvData.get審査員6());
        data.set審査員コード7(csvData.get審査員コード7());
        data.set審査員7(csvData.get審査員7());
        data.set審査員コード8(csvData.get審査員コード8());
        data.set審査員8(csvData.get審査員8());
        data.setID2(csvData.getID2());
        data.set保険者番号(csvData.get保険者番号());
        data.set被保険者番号(csvData.get被保険者番号());
        data.set非該当(csvData.get非該当());
        data.set要支援1(csvData.get要支援1());
        data.set要支援2(csvData.get要支援2());
        data.set要介護1(csvData.get要介護1());
        data.set要介護2(csvData.get要介護2());
        data.set要介護3(csvData.get要介護3());
        data.set要介護4(csvData.get要介護4());
        data.set要介護5(csvData.get要介護5());
        data.set状態像1(csvData.get状態像1());
        data.set状態像2(csvData.get状態像2());
        data.set再調査(csvData.get再調査());
        data.set取下げ(csvData.get取下げ());
        data.set認定有効期間(csvData.get認定有効期間());
        return data;
    }
}
