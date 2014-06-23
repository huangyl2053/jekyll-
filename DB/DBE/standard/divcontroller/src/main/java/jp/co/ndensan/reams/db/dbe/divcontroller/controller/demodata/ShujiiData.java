/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.ShujiiIryoKikanData.IryoKikan;
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

    /**
     * 主治医コードから、主治医を取得します。
     *
     * @param shujiiCode 主治医コード
     * @return 主治医
     */
    public Doctor get主治医From(RString shujiiCode) {
        List<Doctor> list = get主治医All();
        for (Doctor doctor : list) {
            if (doctor.code().equals(shujiiCode)) {
                return doctor;
            }
        }
        return Doctor.EMPTY;
    }

    /**
     * 全主治医を取得します。
     *
     * @return 全主治医
     */
    public List<Doctor> get主治医All() {
        List<Doctor> doctorList = new ArrayList<>();
        for (RString iryoKikanCode : _iryoKikanCodeList()) {
            doctorList.addAll(get医師ListOf(iryoKikanCode).asConvertedType());
        }
        return doctorList;
    }

    private List<RString> _iryoKikanCodeList() {
        List<RString> list = new ArrayList<>();
        for (IryoKikan iryoKikan : _iryoKikanAll()) {
            list.add(iryoKikan.code());
        }
        return list;
    }

    private List<IryoKikan>
            _iryoKikanAll() {
        return new ShujiiIryoKikanData().get医療機関一覧().asConvertedType();
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
