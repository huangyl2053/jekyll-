/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2260001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItem;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshokinyuitem.ShujiiIkenshoKinyuItem;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2260001.ImageinputDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2260001.TorokuData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2260001.dgshinseishaichiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku05;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKinyuMapping99A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping99A;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListReader;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * イメージ取込み（規定・規定外）のコントローラクラスです。
 *
 * @reamsid_L DBE-1580-010 dongyabin
 */
public class ImageinputHandler {

    private static final RString 空白 = RString.EMPTY;
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString ファイル名 = new RString("OCRIKEN.CSV");
    private List<RString> 記入項目連番レスト;
    private List<RString> 意見項目連番レスト;
    private final ImageinputDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public ImageinputHandler(ImageinputDiv div) {
        this.div = div;
    }

    /**
     * 意見書OCRを取込ボタンを押します。
     *
     * @return CSVData
     */
    public List<TorokuData> onClick_Ikensho() {
        return getCSVファイル();
    }

    /**
     * 画面一覧の設定します。
     *
     * @param dataList DBとCSV情報
     */
    public void set画面一覧(List<TorokuData> dataList) {
        set一覧(dataList);
    }

    private void set一覧(List<TorokuData> dataList) {
        int 連番 = 1;
        DropDownList 生活自立度 = set生活自立度();
        DropDownList 短期記憶 = set短期記憶();
        DropDownList 認知能力 = set認知能力();
        DropDownList 伝達能力 = set伝達能力();
        DropDownList 食事行為 = set食事行為();
        List<dgshinseishaichiran_Row> rowList = new ArrayList<>();
        for (TorokuData data : dataList) {
            dgshinseishaichiran_Row row = new dgshinseishaichiran_Row(new RString(連番),
                    data.getOK_NG(),
                    data.getT7051_市町村名称(),
                    data.get被保険者番号(),
                    data.getT5101_被保険者氏名(),
                    dateFormat(data.get申請日()),
                    data.getT5301_主治医医療機関コード(),
                    data.getT5911_医療機関名称(),
                    data.getT5912_主治医コード(),
                    data.getT5912_主治医氏名(),
                    RDate.getNowDate().wareki().toDateString(),
                    dateFormat(data.get記入日()),
                    data.getT5101_申請書管理番号(),
                    rDatetimeFormat(data.getT5115_イメージ共有ファイルID()),
                    生活自立度,
                    短期記憶,
                    認知能力,
                    伝達能力,
                    食事行為,
                    data.getT5101_証記載保険者番号());
            連番++;
            rowList.add(row);
        }
        div.getDgshinseishaichiran().setDataSource(rowList);
    }

    private RString rDatetimeFormat(RDateTime time) {
        if (time == null) {
            return RString.EMPTY;
        }
        return new RString(time.toString());
    }

    private DropDownList set生活自立度() {
        DropDownList 生活自立度 = new DropDownList();
        List<KeyValueDataSource> 生活自立度Source = new ArrayList<>();
        for (IkenKomoku03 code : IkenKomoku03.values()) {
            KeyValueDataSource source = new KeyValueDataSource(code.getコード(), code.get名称());
            生活自立度Source.add(source);
        }
        生活自立度.setDataSource(生活自立度Source);
        return 生活自立度;
    }

    private DropDownList set短期記憶() {
        DropDownList 短期記憶 = new DropDownList();
        List<KeyValueDataSource> 短期記憶Source = new ArrayList<>();
        for (IkenKomoku04 code : IkenKomoku04.values()) {
            KeyValueDataSource source = new KeyValueDataSource(code.getコード(), code.get名称());
            短期記憶Source.add(source);
        }
        短期記憶.setDataSource(短期記憶Source);
        return 短期記憶;
    }

    private DropDownList set認知能力() {
        DropDownList 認知能力 = new DropDownList();
        List<KeyValueDataSource> 認知能力Source = new ArrayList<>();
        for (IkenKomoku05 code : IkenKomoku05.values()) {
            KeyValueDataSource source = new KeyValueDataSource(code.getコード(), code.get名称());
            認知能力Source.add(source);
        }
        認知能力.setDataSource(認知能力Source);
        return 認知能力;
    }

    private DropDownList set伝達能力() {
        DropDownList 伝達能力 = new DropDownList();
        List<KeyValueDataSource> 伝達能力Source = new ArrayList<>();
        for (IkenKomoku06 code : IkenKomoku06.values()) {
            KeyValueDataSource source = new KeyValueDataSource(code.getコード(), code.get名称());
            伝達能力Source.add(source);
        }
        伝達能力.setDataSource(伝達能力Source);
        return 伝達能力;
    }

    private DropDownList set食事行為() {
        DropDownList 食事行為 = new DropDownList();
        List<KeyValueDataSource> 食事行為Source = new ArrayList<>();
        for (NinchishoNichijoSeikatsuJiritsudoCode code : NinchishoNichijoSeikatsuJiritsudoCode.values()) {
            KeyValueDataSource source = new KeyValueDataSource(code.getコード(), code.get名称());
            食事行為Source.add(source);
        }
        食事行為.setDataSource(食事行為Source);
        return 食事行為;
    }

    private RString dateFormat(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return 空白;
        }
        return new RDate(date.toString()).wareki().toDateString();
    }

    private List<TorokuData> getCSVファイル() {
        RString imagePath = Path.combinePath(Path.getRootPath(空白), new RString("/home/D209007/shared/sharedFiles/xxx/"));
        RString csvReaderPath = Path.combinePath(imagePath, ファイル名);
        CsvReader csvReader = new CsvReader.InstanceBuilder(csvReaderPath, TorokuData.class)
                .setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8)
                .hasHeader(false).setNewLine(NewLine.CRLF).build();
        return readCsvFile(csvReader, csvReaderPath);
    }

    private List<TorokuData> readCsvFile(CsvReader csvReader, RString csvReaderPath) {
        CsvListReader read = new CsvListReader.InstanceBuilder(csvReaderPath).build();
        List<TorokuData> csvEntityList = new ArrayList<>();
        while (true) {
            TorokuData entity = (TorokuData) csvReader.readLine();
            if (entity != null) {
                entity.set項目数(read.readLine().size());
                csvEntityList.add(entity);
            } else {
                break;
            }
        }
        csvReader.close();
        read.close();
        return csvEntityList;
    }

    /**
     * 記入項目を設定します。
     *
     * @param joho 要介護認定主治医意見書情報
     * @param row 一覧データ
     * @param data CSVデータ
     * @return 要介護認定主治医意見書情報
     */
    public ShujiiIkenshoJoho set項目(ShujiiIkenshoJoho joho, dgshinseishaichiran_Row row, TorokuData data) {
        記入項目連番レスト = new ArrayList<>();
        意見項目連番レスト = new ArrayList<>();
        List<ShujiiIkenshoKinyuItem> itemList = joho.getShujiiIkenshoKinyuItemList();
        List<ShujiiIkenshoIkenItem> 意見項目List = joho.getShujiiIkenshoIkenItemList();
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(data.getT5101_厚労省IF識別コード())) {
            ShujiiIkenshoJohoBuilder builder = joho.createBuilderForEdit();
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(data.getT5101_厚労省IF識別コード())) {
                for (ShujiiIkenshoKinyuItem item : itemList) {
                    item = set99A記入項目1(data, item);
                    item = set99A記入項目2(data, item);
                    item = set99A記入項目3(data, item);
                    item = set99A記入項目4(data, item);
                    builder.setShujiiIkenshoKinyuItem(item.modifiedModel());
                }
                for (ShujiiIkenshoIkenItem 意見項目 : 意見項目List) {
                    意見項目 = set99A意見項目1(data, 意見項目);
                    意見項目 = set99A意見項目2(row, data, 意見項目);
                    意見項目 = set99A意見項目3(data, 意見項目);
                    意見項目 = set99A意見項目4(data, 意見項目);
                    意見項目 = set99A意見項目5(data, 意見項目);
                    意見項目 = set99A意見項目6(data, 意見項目);
                    意見項目 = set99A意見項目7(data, 意見項目);
                    意見項目 = set99A意見項目8(data, 意見項目);
                    意見項目 = set99A意見項目9(data, 意見項目);
                    意見項目 = set99A意見項目10(data, 意見項目);
                    意見項目 = set99A意見項目11(data, 意見項目);
                    builder.setShujiiIkenshoIkenItem(意見項目.modifiedModel());
                }
            }
            set新規の記入項目1(builder, row, data);
            set新規の記入項目2(builder, row, data);
            set新規の記入項目3(builder, row, data);
            set新規の意見項目1(builder, row, data);
            set新規の意見項目2(builder, row, data);
            set新規の意見項目3(builder, row, data);
            set新規の意見項目4(builder, row, data);
            set新規の意見項目5(builder, row, data);
            set新規の意見項目6(builder, row, data);
            set新規の意見項目7(builder, row, data);
            set新規の意見項目8(builder, row, data);
            set新規の意見項目9(builder, row, data);
            set新規の意見項目10(builder, row, data);
            set新規の意見項目11(builder, row, data);
        }
        joho = get02AHandler().set02A項目(joho, row, data);
        joho = get06AHandler().set06A項目(joho, row, data);
        joho = get09AHandler().set09A項目(joho, row, data);
        joho = get09BHandler().set09B項目(joho, row, data);
        return joho;
    }

    private void set新規の記入項目1(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping99A.その他.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping99A.その他.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.getその他()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping99A.その他の精神_神経症状.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping99A.その他の精神_神経症状.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get精神_神経症状()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping99A.専門医受診の有無.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping99A.専門医受診の有無.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get専門科医受診()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping99A.身長.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping99A.身長.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping99A.体重.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping99A.体重.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping99A.四肢欠損.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping99A.四肢欠損.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get四肢欠損()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping99A.麻痺.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping99A.麻痺.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get麻痺_その他()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping99A.筋力の低下.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping99A.筋力の低下.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get筋力低下()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping99A.じょくそう.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping99A.じょくそう.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get褥瘡()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
    }

    private void set新規の記入項目2(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping99A.その他の皮膚疾患.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping99A.その他の皮膚疾患.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.getその他皮膚疾患()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping99A.病態_その他.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping99A.病態_その他.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get高い病態_その他()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping99A.病態_対処方針.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping99A.病態_対処方針.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping99A.その他の医療系のサービス.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping99A.その他の医療系のサービス.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.getその他の医療系サービス()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping99A.介護サービスの留意事項_血圧.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping99A.介護サービスの留意事項_血圧.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get血圧()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping99A.介護サービスの留意事項_嚥下.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping99A.介護サービスの留意事項_嚥下.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get嚥下()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping99A.介護サービスの留意事項_摂食.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping99A.介護サービスの留意事項_摂食.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.getその他()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping99A.介護サービスの留意事項_移動.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping99A.介護サービスの留意事項_移動.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get移動()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping99A.介護サービスの留意事項_その他.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping99A.介護サービスの留意事項_その他.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
    }

    private void set新規の記入項目3(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!記入項目連番レスト.contains(IkenshoKinyuMapping99A.感染症の有無.getコード())) {
            ShujiiIkenshoKinyuItem なしデータ = new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKinyuMapping99A.感染症の有無.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set記入項目(data.get感染症()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoKinyuItem(なしデータ).build();
        }
    }

    private void set新規の意見項目1(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.点滴の管理.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.予後の見通し.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get予後の見通し()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.点滴の管理.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.点滴の管理.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get点滴の管理()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.中心静脈栄養.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.中心静脈栄養.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get中心静脈栄養()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.透析.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.透析.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get透折()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.ストーマの処置.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.ストーマの処置.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getストーマの処置()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.酸素療法.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.酸素療法.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get酸素療法()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.レスピレーター.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.レスピレーター.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getレスピレーター()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.気管切開の処置.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.気管切開の処置.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get気管切開の処置()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.疼痛の看護.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.疼痛の看護.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get疼痛の看護()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
    }

    private void set新規の意見項目2(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.モニター測定.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.モニター測定.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getモニター測定()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.じょくそうの処置.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.じょくそうの処置.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get褥痩の処置()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.カテーテル.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.カテーテル.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getカテーテル()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.寝たきり度.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.寝たきり度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(row.getNinchishoNichijoSeikatsuJiritsudoCode().getSelectedKey()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.認知症高齢者の日常生活自立度.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.認知症高齢者の日常生活自立度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(row.getNinchishoNichijoSeikatsuJiritsudoCode().getSelectedKey()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.短期記憶.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.短期記憶.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(row.getTankiKioku().getSelectedKey()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.認知能力.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.認知能力.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(row.getNintiNoryoku().getSelectedKey()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.伝達能力.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.伝達能力.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get伝達能力()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.食事.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.食事.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get異食行動()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
    }

    private void set新規の意見項目3(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.認知症の周辺症状.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.認知症の周辺症状.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get問題行動の有無()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.幻視_幻聴.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.幻視_幻聴.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get幻視_幻聴()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.妄想.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.妄想.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get妄想()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.昼夜逆転.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.昼夜逆転.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get昼夜逆転()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.暴言.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.暴言.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get暴言()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.暴行.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.暴行.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get暴行()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.介護への抵抗.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.介護への抵抗.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get介護への抵抗()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.徘徊_問題行動.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.徘徊_問題行動.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get徘徊()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.火の不始末.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.火の不始末.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get火の不始末()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
    }

    private void set新規の意見項目4(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.異食行動.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.異食行動.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get異食行動()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.性的問題行動.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.性的問題行動.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get性的問題行動()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.その他.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.その他.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getその他()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.その他の精神_神経症状.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.その他の精神_神経症状.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get精神_神経症状()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.専門医受診の有無.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.専門医受診の有無.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get専門科医受診()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.利き腕.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.利き腕.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get利き腕()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.四肢欠損.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.四肢欠損.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get四肢欠損()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.四肢欠損_程度.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.四肢欠損_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.麻痺.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.麻痺.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get麻痺()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
    }

    private void set新規の意見項目5(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.麻痺_程度.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.麻痺_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.筋力の低下.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.筋力の低下.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get筋力低下()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.筋力の低下_程度.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.筋力の低下_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get筋力低下_程度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.じょくそう.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.じょくそう.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get褥痩()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.じょくそう_程度.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.じょくそう_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get褥痩_程度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.その他の皮膚疾患.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.その他の皮膚疾患.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getその他皮膚疾患()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.その他の皮膚疾患_程度.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.その他の皮膚疾患_程度.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getその他皮膚疾患_程度()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.関節の拘縮.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.関節の拘縮.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get間接の拘縮()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.関節の拘縮_肩関節_右.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.関節の拘縮_肩関節_右.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
    }

    private void set新規の意見項目6(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.関節の拘縮_肩関節_左.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.関節の拘縮_肩関節_左.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.関節の拘縮_股関節_右.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.関節の拘縮_股関節_右.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.関節の拘縮_股関節_左.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.関節の拘縮_股関節_左.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.関節の拘縮_肘関節_右.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.関節の拘縮_肘関節_右.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.関節の拘縮_肘関節_左.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.関節の拘縮_肘関節_左.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.関節の拘縮_膝関節_右.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.関節の拘縮_膝関節_右.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.失調_不随意運動.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.失調_不随意運動.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get失調_不随意運動()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.失調_不随意運動_上肢_右.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.失調_不随意運動_上肢_右.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get上肢_右()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.失調_不随意運動_上肢_左.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.失調_不随意運動_上肢_左.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get上肢_左()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
    }

    private void set新規の意見項目7(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.失調_不随意運動_体幹_右.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.失調_不随意運動_体幹_右.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get体幹_右()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.失調_不随意運動_下肢_右.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.失調_不随意運動_下肢_右.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get下肢_右()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.失調_不随意運動_下肢_左.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.失調_不随意運動_下肢_左.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get下肢_左()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.尿失禁.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.尿失禁.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get尿失禁()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.転倒_骨折.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.転倒_骨折.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get転倒_骨折()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.徘徊_可能性が高い病態.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.徘徊_可能性が高い病態.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get高い病態_徘徊()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.褥瘡.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.褥瘡.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get褥瘡()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.嚥下性肺炎.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.嚥下性肺炎.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.腸閉塞.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.腸閉塞.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
    }

    private void set新規の意見項目8(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.易感染性.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.易感染性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(空白).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.心肺機能の低下.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.心肺機能の低下.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get心肺機能の低下()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.がん等による疼痛.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.がん等による疼痛.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getがん等による疼痛()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.脱水.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.脱水.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get脱水()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.病態_その他.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.病態_その他.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get高い病態_その他()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.訪問診療.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.訪問診療.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問診療()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.訪問診療_必要性.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.訪問診療_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問診療_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.訪問看護.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.訪問看護.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問看護()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.訪問看護_必要性.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.訪問看護_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問看護_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
    }

    private void set新規の意見項目9(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.訪問リハビリテーション.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.訪問リハビリテーション.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問リハビリテーション()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.訪問リハビリテーション_必要性.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.訪問リハビリテーション_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問リハビリテーション_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.通所リハビリテーション.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.通所リハビリテーション.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get通所リハビリテーション()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.通所リハビリテーション_必要性.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.通所リハビリテーション_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get通所リハビリテーション_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.短期入所療養介護.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.短期入所療養介護.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get短期入所療養介護()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.短期入所療養介護_必要性.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.短期入所療養介護_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get短期入所療養介護_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.訪問歯科診療.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.訪問歯科診療.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問歯科診療()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.訪問歯科診療_必要性.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.訪問歯科診療_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問歯科診療_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.訪問歯科衛生指導.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.訪問歯科衛生指導.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問歯科衛生指導()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
    }

    private void set新規の意見項目10(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.訪問歯科衛生指導_必要性.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.訪問歯科衛生指導_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問歯科衛生指導_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.訪問薬剤管理指導.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.訪問薬剤管理指導.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問薬剤管理指導()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.訪問薬剤管理指導_必要性.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.訪問薬剤管理指導_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問薬剤管理指導_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.訪問栄養食事指導.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.訪問栄養食事指導.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問栄養食事指導()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.訪問栄養食事指導_必要性.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.訪問栄養食事指導_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get訪問栄養食事指導_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.その他の医療系のサービス.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.その他の医療系のサービス.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getその他の医療系サービス()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.その他の医療系のサービス_必要性.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.その他の医療系のサービス_必要性.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.getその他の医療系サービス_必要性()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.介護サービスの留意事項_血圧.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.介護サービスの留意事項_血圧.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get血圧()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.介護サービスの留意事項_嚥下.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.介護サービスの留意事項_嚥下.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get嚥下()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
    }

    private void set新規の意見項目11(ShujiiIkenshoJohoBuilder builder, dgshinseishaichiran_Row row, TorokuData data) {
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.介護サービスの留意事項_摂食.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.介護サービスの留意事項_摂食.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get摂食()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.介護サービスの留意事項_移動.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.介護サービスの留意事項_移動.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get移動()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.感染症の有無.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.感染症の有無.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get感染症()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.失調_不随意運動_体幹_左.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.失調_不随意運動_体幹_左.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get体幹_左()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
        if (!意見項目連番レスト.contains(IkenshoKomokuMapping99A.経管栄養.getコード())) {
            ShujiiIkenshoIkenItem なしデータ = new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                    data.getT5301_主治医意見書作成依頼履歴番号(), rStringToInt(IkenshoKomokuMapping99A.経管栄養.getコード()));
            なしデータ = なしデータ.createBuilderForEdit().set意見項目(data.get経管栄養()).build();
            if (isNotEmpty(data.getT5101_厚労省IF識別コード())) {
                なしデータ = なしデータ.createBuilderForEdit().set厚労省IF識別コード(new Code(data.getT5101_厚労省IF識別コード())).build();
            }
            builder.setShujiiIkenshoIkenItem(なしデータ).build();
        }
    }

    private ShujiiIkenshoKinyuItem set99A記入項目1(
            TorokuData data,
            ShujiiIkenshoKinyuItem item) {
        if (IkenshoKinyuMapping99A.その他.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.getその他()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping99A.その他.getコード());
        }
        if (IkenshoKinyuMapping99A.その他の精神_神経症状.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get精神_神経症状()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping99A.その他の精神_神経症状.getコード());
        }
        if (IkenshoKinyuMapping99A.専門医受診の有無.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get専門科医受診()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping99A.専門医受診の有無.getコード());
        }
        if (IkenshoKinyuMapping99A.身長.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(空白).build();
            記入項目連番レスト.add(IkenshoKinyuMapping99A.身長.getコード());
        }
        if (IkenshoKinyuMapping99A.体重.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(空白).build();
            記入項目連番レスト.add(IkenshoKinyuMapping99A.体重.getコード());
        }
        return item;
    }

    private ShujiiIkenshoKinyuItem set99A記入項目2(
            TorokuData data,
            ShujiiIkenshoKinyuItem item) {
        if (IkenshoKinyuMapping99A.四肢欠損.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get四肢欠損()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping99A.四肢欠損.getコード());
        }
        if (IkenshoKinyuMapping99A.麻痺.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get麻痺_その他()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping99A.麻痺.getコード());
        }
        if (IkenshoKinyuMapping99A.筋力の低下.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get筋力低下()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping99A.筋力の低下.getコード());
        }
        if (IkenshoKinyuMapping99A.じょくそう.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get褥瘡()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping99A.じょくそう.getコード());
        }
        return item;
    }

    private ShujiiIkenshoKinyuItem set99A記入項目3(
            TorokuData data,
            ShujiiIkenshoKinyuItem item) {
        if (IkenshoKinyuMapping99A.その他の皮膚疾患.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.getその他皮膚疾患()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping99A.その他の皮膚疾患.getコード());
        }
        if (IkenshoKinyuMapping99A.病態_その他.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get高い病態_その他()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping99A.病態_その他.getコード());
        }
        if (IkenshoKinyuMapping99A.病態_対処方針.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(空白).build();
            記入項目連番レスト.add(IkenshoKinyuMapping99A.病態_対処方針.getコード());
        }
        if (IkenshoKinyuMapping99A.その他の医療系のサービス.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.getその他の医療系サービス()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping99A.その他の医療系のサービス.getコード());
        }
        if (IkenshoKinyuMapping99A.介護サービスの留意事項_血圧.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get血圧()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping99A.介護サービスの留意事項_血圧.getコード());
        }
        return item;
    }

    private ShujiiIkenshoKinyuItem set99A記入項目4(
            TorokuData data,
            ShujiiIkenshoKinyuItem item) {
        if (IkenshoKinyuMapping99A.介護サービスの留意事項_嚥下.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get嚥下()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping99A.介護サービスの留意事項_嚥下.getコード());
        }
        if (IkenshoKinyuMapping99A.介護サービスの留意事項_摂食.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get摂食()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping99A.介護サービスの留意事項_摂食.getコード());
        }
        if (IkenshoKinyuMapping99A.介護サービスの留意事項_移動.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get移動()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping99A.介護サービスの留意事項_移動.getコード());
        }
        if (IkenshoKinyuMapping99A.介護サービスの留意事項_その他.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(空白).build();
            記入項目連番レスト.add(IkenshoKinyuMapping99A.その他.getコード());
        }
        if (IkenshoKinyuMapping99A.感染症の有無.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set記入項目(data.get感染症()).build();
            記入項目連番レスト.add(IkenshoKinyuMapping99A.その他.getコード());
        }
        return item;
    }

    private ShujiiIkenshoIkenItem set99A意見項目1(
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping99A.予後の見通し.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get予後の見通し()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.予後の見通し.getコード());
        }
        if (IkenshoKomokuMapping99A.点滴の管理.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get点滴の管理()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.点滴の管理.getコード());
        }
        if (IkenshoKomokuMapping99A.中心静脈栄養.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get中心静脈栄養()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.中心静脈栄養.getコード());
        }
        if (IkenshoKomokuMapping99A.透析.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get透折()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.透析.getコード());
        }
        if (IkenshoKomokuMapping99A.ストーマの処置.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.getストーマの処置()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.ストーマの処置.getコード());
        }
        if (IkenshoKomokuMapping99A.酸素療法.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get酸素療法()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.酸素療法.getコード());
        }
        if (IkenshoKomokuMapping99A.レスピレーター.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.getレスピレーター()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.レスピレーター.getコード());
        }
        if (IkenshoKomokuMapping99A.気管切開の処置.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get気管切開の処置()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.気管切開の処置.getコード());
        }
        if (IkenshoKomokuMapping99A.疼痛の看護.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get疼痛の看護()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.疼痛の看護.getコード());
        }
        return item;
    }

    private ShujiiIkenshoIkenItem set99A意見項目2(
            dgshinseishaichiran_Row row,
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping99A.モニター測定.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.getモニター測定()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.モニター測定.getコード());
        }
        if (IkenshoKomokuMapping99A.じょくそうの処置.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get褥痩の処置()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.じょくそうの処置.getコード());
        }
        if (IkenshoKomokuMapping99A.カテーテル.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.getカテーテル()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.カテーテル.getコード());
        }
        if (IkenshoKomokuMapping99A.寝たきり度.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(row.getNinchishoNichijoSeikatsuJiritsudoCode().getSelectedKey()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.寝たきり度.getコード());
        }
        if (IkenshoKomokuMapping99A.認知症高齢者の日常生活自立度.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(row.getNinchishoNichijoSeikatsuJiritsudoCode().getSelectedKey()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.認知症高齢者の日常生活自立度.getコード());
        }
        if (IkenshoKomokuMapping99A.短期記憶.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(row.getTankiKioku().getSelectedKey()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.短期記憶.getコード());
        }
        if (IkenshoKomokuMapping99A.認知能力.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(row.getNintiNoryoku().getSelectedKey()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.認知能力.getコード());
        }
        if (IkenshoKomokuMapping99A.伝達能力.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get伝達能力()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.伝達能力.getコード());
        }
        if (IkenshoKomokuMapping99A.食事.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get異食行動()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.食事.getコード());
        }
        return item;
    }

    private ShujiiIkenshoIkenItem set99A意見項目3(
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping99A.認知症の周辺症状.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get問題行動の有無()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.認知症の周辺症状.getコード());
        }
        if (IkenshoKomokuMapping99A.幻視_幻聴.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get幻視_幻聴()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.幻視_幻聴.getコード());
        }
        if (IkenshoKomokuMapping99A.妄想.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get妄想()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.妄想.getコード());
        }
        if (IkenshoKomokuMapping99A.昼夜逆転.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get昼夜逆転()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.昼夜逆転.getコード());
        }
        if (IkenshoKomokuMapping99A.暴言.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get暴言()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.暴言.getコード());
        }
        if (IkenshoKomokuMapping99A.暴行.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get暴行()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.暴行.getコード());
        }
        if (IkenshoKomokuMapping99A.介護への抵抗.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get介護への抵抗()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.介護への抵抗.getコード());
        }
        if (IkenshoKomokuMapping99A.徘徊_問題行動.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get徘徊()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.徘徊_問題行動.getコード());
        }
        if (IkenshoKomokuMapping99A.火の不始末.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get火の不始末()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.火の不始末.getコード());
        }
        return item;
    }

    private ShujiiIkenshoIkenItem set99A意見項目4(
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping99A.不潔行為.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get不潔行為()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.不潔行為.getコード());
        }
        if (IkenshoKomokuMapping99A.異食行動.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get異食行動()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.異食行動.getコード());
        }
        if (IkenshoKomokuMapping99A.性的問題行動.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get性的問題行動()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.性的問題行動.getコード());
        }
        if (IkenshoKomokuMapping99A.その他.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.getその他()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.その他.getコード());
        }
        if (IkenshoKomokuMapping99A.その他の精神_神経症状.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get精神_神経症状()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.その他の精神_神経症状.getコード());
        }
        if (IkenshoKomokuMapping99A.専門医受診の有無.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get専門科医受診()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.専門医受診の有無.getコード());
        }
        if (IkenshoKomokuMapping99A.利き腕.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get利き腕()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.利き腕.getコード());
        }
        if (IkenshoKomokuMapping99A.四肢欠損.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get四肢欠損()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.四肢欠損.getコード());
        }
        if (IkenshoKomokuMapping99A.四肢欠損_程度.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(空白).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.四肢欠損_程度.getコード());
        }
        return item;
    }

    private ShujiiIkenshoIkenItem set99A意見項目5(
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping99A.麻痺.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get麻痺()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.麻痺.getコード());
        }
        if (IkenshoKomokuMapping99A.麻痺_程度.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(空白).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.麻痺_程度.getコード());
        }
        if (IkenshoKomokuMapping99A.筋力の低下.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get筋力低下()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.筋力の低下.getコード());
        }
        if (IkenshoKomokuMapping99A.筋力の低下_程度.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get筋力低下_程度()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.筋力の低下_程度.getコード());
        }
        if (IkenshoKomokuMapping99A.じょくそう.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get褥痩()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.じょくそう.getコード());
        }
        if (IkenshoKomokuMapping99A.じょくそう_程度.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get褥痩_程度()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.じょくそう_程度.getコード());
        }
        if (IkenshoKomokuMapping99A.その他の皮膚疾患.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.getその他皮膚疾患()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.その他の皮膚疾患.getコード());
        }
        if (IkenshoKomokuMapping99A.その他の皮膚疾患_程度.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.getその他皮膚疾患_程度()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.その他の皮膚疾患_程度.getコード());
        }
        if (IkenshoKomokuMapping99A.関節の拘縮.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get間接の拘縮()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.関節の拘縮.getコード());
        }
        return item;
    }

    private ShujiiIkenshoIkenItem set99A意見項目6(
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping99A.関節の拘縮_肩関節_右.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(空白).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.関節の拘縮_肩関節_右.getコード());
        }
        if (IkenshoKomokuMapping99A.関節の拘縮_肩関節_左.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(空白).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.関節の拘縮_肩関節_左.getコード());
        }
        if (IkenshoKomokuMapping99A.関節の拘縮_股関節_右.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(空白).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.関節の拘縮_股関節_右.getコード());
        }
        if (IkenshoKomokuMapping99A.関節の拘縮_股関節_左.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(空白).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.関節の拘縮_股関節_左.getコード());
        }
        if (IkenshoKomokuMapping99A.関節の拘縮_肘関節_右.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(空白).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.関節の拘縮_肘関節_右.getコード());
        }
        if (IkenshoKomokuMapping99A.関節の拘縮_肘関節_左.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(空白).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.関節の拘縮_肘関節_左.getコード());
        }
        if (IkenshoKomokuMapping99A.関節の拘縮_膝関節_右.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(空白).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.関節の拘縮_膝関節_右.getコード());
        }
        if (IkenshoKomokuMapping99A.関節の拘縮_膝関節_左.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(空白).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.関節の拘縮_膝関節_左.getコード());
        }
        if (IkenshoKomokuMapping99A.失調_不随意運動.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get失調_不随意運動()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.失調_不随意運動.getコード());
        }
        return item;
    }

    private ShujiiIkenshoIkenItem set99A意見項目7(
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping99A.失調_不随意運動_上肢_右.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get上肢_右()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.失調_不随意運動_上肢_右.getコード());
        }
        if (IkenshoKomokuMapping99A.失調_不随意運動_上肢_左.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get上肢_左()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.失調_不随意運動_上肢_左.getコード());
        }
        if (IkenshoKomokuMapping99A.失調_不随意運動_体幹_右.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get体幹_右()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.失調_不随意運動_体幹_右.getコード());
        }
        if (IkenshoKomokuMapping99A.失調_不随意運動_下肢_右.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get下肢_右()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.失調_不随意運動_下肢_右.getコード());
        }
        if (IkenshoKomokuMapping99A.失調_不随意運動_下肢_左.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get下肢_左()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.失調_不随意運動_下肢_左.getコード());
        }
        if (IkenshoKomokuMapping99A.尿失禁.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get尿失禁()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.尿失禁.getコード());
        }
        if (IkenshoKomokuMapping99A.転倒_骨折.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get転倒_骨折()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.転倒_骨折.getコード());
        }
        if (IkenshoKomokuMapping99A.徘徊_可能性が高い病態.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get高い病態_徘徊()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.徘徊_可能性が高い病態.getコード());
        }
        if (IkenshoKomokuMapping99A.褥瘡.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get褥瘡()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.褥瘡.getコード());
        }
        return item;
    }

    private ShujiiIkenshoIkenItem set99A意見項目8(
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping99A.嚥下性肺炎.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(空白).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.嚥下性肺炎.getコード());
        }
        if (IkenshoKomokuMapping99A.腸閉塞.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(空白).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.腸閉塞.getコード());
        }
        if (IkenshoKomokuMapping99A.易感染性.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(空白).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.易感染性.getコード());
        }
        if (IkenshoKomokuMapping99A.心肺機能の低下.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get心肺機能の低下()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.心肺機能の低下.getコード());
        }
        if (IkenshoKomokuMapping99A.がん等による疼痛.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.getがん等による疼痛()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.がん等による疼痛.getコード());
        }
        if (IkenshoKomokuMapping99A.脱水.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get脱水()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.脱水.getコード());
        }
        if (IkenshoKomokuMapping99A.病態_その他.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get高い病態_その他()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.病態_その他.getコード());
        }
        if (IkenshoKomokuMapping99A.訪問診療.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問診療()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.訪問診療.getコード());
        }
        if (IkenshoKomokuMapping99A.訪問診療_必要性.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問診療_必要性()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.訪問診療_必要性.getコード());
        }
        return item;
    }

    private ShujiiIkenshoIkenItem set99A意見項目9(
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping99A.訪問看護.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問看護()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.訪問看護.getコード());
        }
        if (IkenshoKomokuMapping99A.訪問看護_必要性.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問看護_必要性()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.訪問看護_必要性.getコード());
        }
        if (IkenshoKomokuMapping99A.訪問リハビリテーション.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問リハビリテーション()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.訪問リハビリテーション.getコード());
        }
        if (IkenshoKomokuMapping99A.訪問リハビリテーション_必要性.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問リハビリテーション_必要性()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.訪問リハビリテーション_必要性.getコード());
        }
        if (IkenshoKomokuMapping99A.通所リハビリテーション.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get通所リハビリテーション()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.通所リハビリテーション.getコード());
        }
        if (IkenshoKomokuMapping99A.通所リハビリテーション_必要性.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get通所リハビリテーション_必要性()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.通所リハビリテーション_必要性.getコード());
        }
        if (IkenshoKomokuMapping99A.短期入所療養介護.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get短期入所療養介護()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.短期入所療養介護.getコード());
        }
        if (IkenshoKomokuMapping99A.短期入所療養介護_必要性.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get短期入所療養介護_必要性()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.短期入所療養介護_必要性.getコード());
        }
        if (IkenshoKomokuMapping99A.訪問歯科診療.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問歯科診療()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.訪問歯科診療.getコード());
        }
        return item;
    }

    private ShujiiIkenshoIkenItem set99A意見項目10(
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping99A.訪問歯科診療_必要性.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問歯科診療_必要性()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.訪問歯科診療_必要性.getコード());
        }
        if (IkenshoKomokuMapping99A.訪問歯科衛生指導.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問歯科衛生指導()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.訪問歯科衛生指導.getコード());
        }
        if (IkenshoKomokuMapping99A.訪問歯科衛生指導_必要性.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問歯科衛生指導_必要性()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.訪問歯科衛生指導_必要性.getコード());
        }
        if (IkenshoKomokuMapping99A.訪問薬剤管理指導.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問薬剤管理指導()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.訪問薬剤管理指導.getコード());
        }
        if (IkenshoKomokuMapping99A.訪問薬剤管理指導_必要性.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問薬剤管理指導_必要性()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.訪問薬剤管理指導_必要性.getコード());
        }
        if (IkenshoKomokuMapping99A.訪問栄養食事指導.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問栄養食事指導()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.訪問栄養食事指導.getコード());
        }
        if (IkenshoKomokuMapping99A.訪問栄養食事指導_必要性.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get訪問栄養食事指導_必要性()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.訪問栄養食事指導_必要性.getコード());
        }
        if (IkenshoKomokuMapping99A.その他の医療系のサービス.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.getその他の医療系サービス()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.その他の医療系のサービス.getコード());
        }
        if (IkenshoKomokuMapping99A.その他の医療系のサービス_必要性.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.getその他の医療系サービス_必要性()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.その他の医療系のサービス_必要性.getコード());
        }
        return item;
    }

    private ShujiiIkenshoIkenItem set99A意見項目11(
            TorokuData data,
            ShujiiIkenshoIkenItem item) {
        if (IkenshoKomokuMapping99A.介護サービスの留意事項_血圧.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get血圧()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.介護サービスの留意事項_血圧.getコード());
        }
        if (IkenshoKomokuMapping99A.介護サービスの留意事項_嚥下.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get嚥下()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.介護サービスの留意事項_嚥下.getコード());
        }
        if (IkenshoKomokuMapping99A.介護サービスの留意事項_摂食.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get摂食()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.介護サービスの留意事項_摂食.getコード());
        }
        if (IkenshoKomokuMapping99A.介護サービスの留意事項_移動.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get移動()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.介護サービスの留意事項_移動.getコード());
        }
        if (IkenshoKomokuMapping99A.感染症の有無.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get感染症()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.感染症の有無.getコード());
        }
        if (IkenshoKomokuMapping99A.失調_不随意運動_体幹_左.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get体幹_左()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.失調_不随意運動_体幹_左.getコード());
        }
        if (IkenshoKomokuMapping99A.経管栄養.getコード().equals(new RString(item.get連番()))) {
            item.createBuilderForEdit().set意見項目(data.get経管栄養()).build();
            意見項目連番レスト.add(IkenshoKomokuMapping99A.経管栄養.getコード());
        }
        return item;
    }

    private int rStringToInt(RString 連番) {
        return Integer.parseInt(連番.toString());
    }

    private boolean isNotEmpty(RString data) {
        return !RString.isNullOrEmpty(data);
    }

    private Imageinput02AHandler get02AHandler() {
        return new Imageinput02AHandler();
    }

    private Imageinput06AHandler get06AHandler() {
        return new Imageinput06AHandler();
    }

    private Imageinput09AHandler get09AHandler() {
        return new Imageinput09AHandler();
    }

    private Imageinput09BHandler get09BHandler() {
        return new Imageinput09BHandler();
    }
}
