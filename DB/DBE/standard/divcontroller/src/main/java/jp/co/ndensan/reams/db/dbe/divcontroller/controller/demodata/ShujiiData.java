/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医のデモデータです。
 *
 * @author N3327 三浦 凌
 */
public class ShujiiData {

    private static final RString FILE_NAME = new RString("Shujii/Doctor.yml");

    public static class Doctor {

        public static final Doctor EMPTY;

        static {
            EMPTY = new Doctor(RString.EMPTY, RString.EMPTY, ShujiiIryoKikanData.IryoKikan.EMPTY);
        }
        private final ShujiiIryoKikanData.IryoKikan theIryoKikan;
        private final RString theCode;
        private final RString theName;

        private Doctor(RString code, RString name, ShujiiIryoKikanData.IryoKikan iryoKikan) {
            this.theCode = code;
            this.theName = name;
            this.theIryoKikan = iryoKikan;
        }

        public RString code() {
            return theCode;
        }

        public RString name() {
            return theName;
        }

        public ShujiiIryoKikanData.IryoKikan iryoKikan() {
            return this.theIryoKikan;
        }
    }

    public IDemoData<Doctor> get主治医一覧() {
        List<HashMap> dataFromYaml = YamlLoader.DBE.loadAsList(FILE_NAME);
        return new DemoData<>(dataFromYaml, new YamlUtil.Converter.IConverter<Doctor>() {

            @Override
            public Doctor exec(Map map) {
                ControlGenerator cg = new ControlGenerator(map);
                return new Doctor(cg.getAsRString("医師コード"), cg.getAsRString("医師名称"),
                        new ShujiiIryoKikanData().get医療機関From(cg.getAsRString("医療機関コード")));
            }
        });
    }

    public Doctor get主治医From(RString code) {
        List<Doctor> list = get主治医一覧().asConvetedType();
        for (Doctor doctor : list) {
            if (doctor.code().equals(code)) {
                return doctor;
            }
        }
        return Doctor.EMPTY;
    }

    /**
     * 医療機関コードから、医師の一覧を取得します。
     *
     * @param iryoKikanCode 医療機関コード
     * @return 医師のリスト
     */
    public IDemoData<Doctor> get医師ListOf(final RString iryoKikanCode) {
        List<HashMap> dataFromYaml = YamlLoader.DBE.loadAsList(composeFileName(iryoKikanCode));
        return new DemoData<>(dataFromYaml, new YamlUtil.Converter.IConverter<Doctor>() {
            @Override
            public Doctor exec(Map map) {
                ControlGenerator cg = new ControlGenerator(map);
                return new Doctor(cg.getAsRString("医師番号"), cg.getAsRString("医師名"),
                        new ShujiiIryoKikanData().get医療機関From(iryoKikanCode));
            }
        });
    }

    private static RString composeFileName(RString iryoKikanCode) {
        return new RString("IryoKikanDialog/IshiList" + iryoKikanCode + ".yml");
    }

}
