/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060005.dgChosahyoTorikomiKekka_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil.Converter.IConverter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 * @author N3327 三浦 凌
 */
public class NinteichosaOCRTorikomiTargetData {

    private static final RString DEMO_DATA_FILE_NAME = new RString("dbe2060005/NinteichosaOCRTorikomiTarget.yml");

    /**
     * 上記ファイルのkeyを変更したときは、以下も変更してください。
     */
    public enum YAMLKeys {

        保険者番号("保険者番号"),
        保険者名("保険者名"),
        被保番号("被保番号"),
        OCR成功区分("OCR成功区分"),
        申請日("申請日"),
        申請区分("申請区分"),
        調査員コード("調査員コード"),
        調査実施日("調査実施日"),
        調査票受領日("調査票受領日");
        private final RString theKey;

        private YAMLKeys(String key) {
            this.theKey = new RString(key);
        }

        public RString value() {
            return theKey;
        }
    }

    //<editor-fold defaultstate="collapsed" desc="public enum ShinseiKubun{...}">
    public enum ShinseiKubun {

        新規("shinki"), 更新("koshin"), 区分変更("henko");
        private final RString theKey;
        private final RString theName;
        private final RString theShortName;

        private ShinseiKubun(String key) {
            this.theKey = new RString(key);
            this.theShortName = new RString(name());
            this.theName = new RString(theShortName + "申請");
        }

        public RString getKey() {
            return this.theKey;
        }

        public RString getName() {
            return this.theName;
        }

        public RString getShortName() {
            return this.theShortName;
        }

        public static ShinseiKubun toValue(RString rstr) {
            for (ShinseiKubun item : values()) {
                if (item.getKey().equals(rstr) || item.getName().equals(rstr) || item.getShortName().equals(rstr)) {
                    return item;
                }
            }
            return 新規;
        }

        public KeyValueDataSource toKeyValueDataSource() {
            return new KeyValueDataSource(getKey(), getName());
        }

        public static List<KeyValueDataSource> getDataSources() {
            List<KeyValueDataSource> dataSource = new ArrayList<>();
            for (ShinseiKubun item : values()) {
                dataSource.add(item.toKeyValueDataSource());
            }
            return dataSource;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="public enum OCRSuccessKubun{...}">
    public enum OCRSuccessKubun {

        OK, NG;
        private final RString theName;

        private OCRSuccessKubun() {
            this.theName = new RString(name());
        }

        public RString toRString() {
            return theName;
        }
    }
//</editor-fold>

    /**
     * 全取込み対象者を取得します。
     *
     * @return 全取込み対象者
     */
    public IDemoData<dgChosahyoTorikomiKekka_Row> getAll() {
        List<HashMap> dataFromYaml = YamlLoader.DBE.loadAsList(DEMO_DATA_FILE_NAME);
        return new MyDemoData(dataFromYaml, new IConverter<dgChosahyoTorikomiKekka_Row>() {
            @Override
            public dgChosahyoTorikomiKekka_Row exec(Map map) {
                return toDgChosahyoTorikomiKekka_Row(map);
            }

            private dgChosahyoTorikomiKekka_Row toDgChosahyoTorikomiKekka_Row(Map map) {
                ControlGenerator cg = new ControlGenerator(map);
                return new dgChosahyoTorikomiKekka_Row(
                        new Button(),
                        RString.EMPTY,
                        _OkOrNg(cg.getAsRString(YAMLKeys.OCR成功区分.value())),
                        cg.getAsRString(YAMLKeys.保険者名.value()),
                        cg.getAsRString(YAMLKeys.被保番号.value()),
                        cg.getAsTextBoxFlexibleDate(YAMLKeys.申請日.value()),
                        cg.getAsRString(YAMLKeys.申請区分.value()),
                        cg.getAsTextBoxFlexibleDate(YAMLKeys.調査実施日.value()),
                        cg.getAsTextBoxFlexibleDate(YAMLKeys.調査票受領日.value()));
            }

            private RString _OkOrNg(RString value) {
                if (OCRSuccessKubun.NG.toRString().equals(value)) {
                    return OCRSuccessKubun.NG.toRString();
                }
                return OCRSuccessKubun.OK.toRString();
            }
        });

    }

    //<editor-fold defaultstate="collapsed" desc="private class MyDemoData{...}">
    private static class MyDemoData implements IDemoData<dgChosahyoTorikomiKekka_Row> {

        private final List<HashMap> rawData;
        private final IConverter<dgChosahyoTorikomiKekka_Row> converter;

        private MyDemoData(List<HashMap> dataFromYaml, IConverter<dgChosahyoTorikomiKekka_Row> converter) {
            this.rawData = Collections.unmodifiableList(dataFromYaml);
            this.converter = converter;
        }

        @Override
        public List<dgChosahyoTorikomiKekka_Row> asConvertedType() {
            List<dgChosahyoTorikomiKekka_Row> converted = new ArrayList<>();
            int rowNo = 1;
            for (Map map : rawData) {
                dgChosahyoTorikomiKekka_Row row = converter.exec(map);
                row.setNo(new RString(String.valueOf(rowNo++)));
                converted.add(row);
            }
            return converted;
        }

        @Override
        public List<HashMap> asRaw() {
            return this.rawData;
        }
    }
    //</editor-fold>

    /**
     * 被保険者番号から、デモデータを取得します。
     *
     * @param hihokenshaNo 被保険者番号
     * @return Map
     */
    public Map get対象者From(RString hihokenshaNo) {
        IDemoData<dgChosahyoTorikomiKekka_Row> list = getAll();
        for (int i = 0; i < list.asRaw().size(); i++) {
            if (list.asConvertedType().get(i).getHihokenshaNo().equals(hihokenshaNo)) {
                return list.asRaw().get(i);
            }
        }
        return Collections.EMPTY_MAP;
    }
}
