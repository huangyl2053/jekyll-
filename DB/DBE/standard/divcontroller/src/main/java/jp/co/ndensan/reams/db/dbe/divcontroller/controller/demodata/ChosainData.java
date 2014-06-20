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
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.ChosaItakusakiData.ChosaItakusaki;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N3327 三浦 凌
 */
public class ChosainData {

    public static final class Chosain {

        public static final Chosain EMPTY;

        static {
            EMPTY = new Chosain(RString.EMPTY, RString.EMPTY, ChosaItakusaki.EMPTY);
        }
        private final RString theCode;
        private final RString theName;
        private final ChosaItakusaki theItakusaki;

        private Chosain(RString code, RString name, ChosaItakusaki itakusaki) {
            this.theCode = code;
            this.theName = name;
            this.theItakusaki = itakusaki;
        }

        public RString code() {
            return this.theCode;
        }

        public RString name() {
            return this.theName;
        }

        public ChosaItakusaki itakusaki() {
            return this.theItakusaki;
        }
    }

    /**
     * 調査員コードから、調査員を取得します。
     *
     * @param chosainCode 調査員コード
     * @return 調査員
     */
    public Chosain get調査員From(RString chosainCode) {
        List<Chosain> list = get調査員All();
        for (Chosain chosain : list) {
            if (chosain.code().equals(chosainCode)) {
                return chosain;
            }
        }
        return Chosain.EMPTY;
    }

    /**
     * 全調査員を取得します。
     *
     * @return 全調査員
     */
    public List<Chosain> get調査員All() {
        List<Chosain> chosainList = new ArrayList<>();
        for (RString chosaItakusakiCode : _chosaItakusakiCodeList()) {
            chosainList.addAll(get調査員ListOf(chosaItakusakiCode).asConvetedType());
        }
        return chosainList;
    }

    private List<RString> _chosaItakusakiCodeList() {
        List<RString> list = new ArrayList<>();
        for (ChosaItakusakiData.ChosaItakusaki chosaItakusaki : _chosaIrakuskaiAll()) {
            list.add(chosaItakusaki.code());
        }
        return list;
    }

    private List<ChosaItakusakiData.ChosaItakusaki>
            _chosaIrakuskaiAll() {
        return new ChosaItakusakiData().get調査委託先一覧().asConvetedType();
    }

    /**
     * 調査委託先コードから、調査員の一覧を取得します。
     *
     * @param chosaIrakusakiCode 調査委託先コード
     * @return 調査員のリスト
     */
    public IDemoData<Chosain> get調査員ListOf(final RString chosaIrakusakiCode) {
        List<HashMap> dataFromYaml = YamlLoader.DBE.loadAsList(composeFileName(chosaIrakusakiCode));
        return new DemoData<>(dataFromYaml, new YamlUtil.Converter.IConverter<Chosain>() {
            @Override
            public Chosain exec(Map map) {
                ControlGenerator cg = new ControlGenerator(map);
                return new Chosain(cg.getAsRString("調査員番号"), cg.getAsRString("調査員名"),
                        new ChosaItakusakiData().get調査委託先From(chosaIrakusakiCode));
            }
        });
    }

    private static RString composeFileName(RString chosaItakusakiCode) {
        return new RString("ChosaKikanDialog/ChosainList" + chosaItakusakiCode + ".yml");
    }

}
