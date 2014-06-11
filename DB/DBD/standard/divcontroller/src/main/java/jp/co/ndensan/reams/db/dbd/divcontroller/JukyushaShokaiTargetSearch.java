/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.JukyushaShokaiTargetSearchDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.dgNinteiRireki_Row;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.HihokenshaForSearchResult;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.IHihokenshaForSearchResult;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.SearchResultOfHihokensha;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.GenderName;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * JukyushaShokaiTargetSearchDiv用のサーバサイド処理クラスです。
 *
 * @author N3327 三浦 凌
 */
public class JukyushaShokaiTargetSearch {

    /**
     * ロード時の処理です。
     *
     * @param div JukyushaShokaiTargetSearchDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaShokaiTargetSearchDiv> onLoad(JukyushaShokaiTargetSearchDiv div) {
        ResponseData<JukyushaShokaiTargetSearchDiv> response = new ResponseData<>();

        response.data = div;
        return response;
    }

    /**
     * 検索ボタン押下時の処理です。
     *
     * @param div JukyushaShokaiTargetSearchDiv
     * @return ResponseData
     */
    public ResponseData<JukyushaShokaiTargetSearchDiv> onClick_btnToSearch(JukyushaShokaiTargetSearchDiv div) {
        ResponseData<JukyushaShokaiTargetSearchDiv> response = new ResponseData<>();

        SearchResultOfHihokensha.setSearchResult(div.getSearchResult(), new DemoData().targetList());

        response.data = div;
        return response;
    }

    /**
     * デモ用データです。
     */
    static class DemoData {

        DemoData() {
        }

        List<IHihokenshaForSearchResult> targetList() {
            List<HashMap> dataFromYaml = YamlLoader.DBD.loadAsList(new RString("Jukyusha/Ichiran.yml"));
            return YamlUtil.convertList(dataFromYaml, new YamlUtil.Converter.IConverter<IHihokenshaForSearchResult>() {
                @Override
                public IHihokenshaForSearchResult exec(Map map) {
                    return toHihokenshaForSearchResult(map);
                }

                private IHihokenshaForSearchResult toHihokenshaForSearchResult(Map map) {
                    ControlGenerator cg = new ControlGenerator(map);
                    return new HihokenshaForSearchResult(
                            new KaigoHihokenshaNo(cg.getAsRString("被保番号")),
                            new ShikibetsuCode(cg.getAsRString("識別コード")),
                            cg.getAsRString("被保険者区分"),
                            cg.getAsRString("氏名"),
                            cg.getAsRString("カナ氏名"),
                            toGender(cg.getAsRString("性別")),
                            cg.getAsRDate("生年月日"),
                            cg.getAsYubinNo("郵便番号"),
                            new AtenaJusho(cg.getAsRString("住所")),
                            cg.getAsRString("個人番号"),
                            toJuminShubetsu(cg.getAsRString("住民種別")),
                            new SetaiCode(cg.getAsRString("世帯コード"))
                    );
                }

                private Gender toGender(RString rstr) {
                    for (Gender gender : Gender.values()) {
                        if (gender.getCode().equals(rstr) || gender.getCommonName().equals(rstr)
                                || gender.getName().equals(GenderName.toValue(rstr))) {
                            return gender;
                        }
                    }
                    return Gender.OTHER;
                }

                private JuminShubetsu toJuminShubetsu(RString rstr) {
                    for (JuminShubetsu juminShubetsu : JuminShubetsu.values()) {
                        if (juminShubetsu.getCode().equals(rstr) || juminShubetsu.toRString().equals(rstr)) {
                            return juminShubetsu;
                        }
                    }
                    return JuminShubetsu.日本人;
                }
            });
        }

        List<dgNinteiRireki_Row> histroyOf(RString hihokenshaNo) {
            List<HashMap> dataFromYaml = YamlLoader.DBD.loadAsList(new RString("Jukyusha/Rireki/" + hihokenshaNo + "Ichiran.yml"));
            if (dataFromYaml.isEmpty()) {
                return Collections.EMPTY_LIST;
            }
            return YamlUtil.<dgNinteiRireki_Row>convertList(dataFromYaml, new YamlUtil.Converter.IConverter<dgNinteiRireki_Row>() {

                @Override
                public dgNinteiRireki_Row exec(Map map) {
                    return toDgNinteiRireki_Row(map);
                }

                private dgNinteiRireki_Row toDgNinteiRireki_Row(Map map) {
                    ControlGenerator cg = new ControlGenerator(map);
                    Decimal tsukisu = cg.getAsDecimal("有効期間月数");
                    TextBoxFlexibleDate shuryoDate = cg.getAsTextBoxFlexibleDate("有効期間開始日");
                    shuryoDate.setValue(shuryoDate.getValue().plusMonth(tsukisu.intValue()));
                    return new dgNinteiRireki_Row(
                            new Button(),
                            cg.getAsTextBoxFlexibleDate("認定申請日"),
                            cg.getAsRString("申請区分_法令"),
                            cg.getAsTextBoxFlexibleDate("認定日"),
                            cg.getAsRString("要介護度"),
                            cg.getAsTextBoxFlexibleDate("有効期間開始日"),
                            shuryoDate,
                            cg.getAsRString("審査会意見"));
                }
            });
        }
    }
}
