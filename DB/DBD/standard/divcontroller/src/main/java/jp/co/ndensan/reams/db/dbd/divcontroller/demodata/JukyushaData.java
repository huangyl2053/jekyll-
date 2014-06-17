/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.demodata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001.dgNinteiRireki_Row;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.HihokenshaForSearchResult;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.IHihokenshaForSearchResult;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.GenderName;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 受給者のデモデータを扱います。
 *
 * @author N3327 三浦 凌
 */
public class JukyushaData {

    /**
     * 全受給者の情報を取得します。
     *
     * @return 全受給者
     */
    public IDemoData<IHihokenshaForSearchResult> getAll() {
        List<HashMap> dataFromYaml = YamlLoader.DBD.loadAsList(new RString("Jukyusha/Ichiran.yml"));
        return new DemoData<>(dataFromYaml, new YamlUtil.Converter.IConverter<IHihokenshaForSearchResult>() {
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

    /**
     * ある受給者の履歴を取得します。
     *
     * @param hihokenshaNo 被保険者番号
     * @return ある受給者の履歴
     */
    public IDemoData<dgNinteiRireki_Row> get履歴Of(RString hihokenshaNo) {
        List<HashMap> dataFromYaml = YamlLoader.DBD.loadAsList(new RString("Jukyusha/Rireki/" + hihokenshaNo + ".yml"));
        return new DemoData<>(dataFromYaml, new YamlUtil.Converter.IConverter<dgNinteiRireki_Row>() {

            @Override
            public dgNinteiRireki_Row exec(Map map) {
                return toDgNinteiRireki_Row(map);
            }

            private dgNinteiRireki_Row toDgNinteiRireki_Row(Map map) {
                ControlGenerator cg = new ControlGenerator(map);
                Decimal tsukisu = cg.getAsDecimal("有効期間月数");
                TextBoxFlexibleDate shuryoDate = cg.getAsTextBoxFlexibleDate("有効期間開始日");
                shuryoDate.setValue(calculateYukoKikanShuryoDate(shuryoDate.getValue(), tsukisu.intValue()));
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

            private FlexibleDate calculateYukoKikanShuryoDate(FlexibleDate date, int yukoKikanTsukisu) {
                FlexibleDate yukoKikanShuryoDate;
                if (date.getDayValue() == 1) {
                    yukoKikanShuryoDate = date.plusMonth(yukoKikanTsukisu - 1);
                } else {
                    yukoKikanShuryoDate = date.plusMonth(yukoKikanTsukisu);
                }
                return new FlexibleDate(yukoKikanShuryoDate.getYearMonth().toDateString()
                        + String.valueOf(yukoKikanShuryoDate.getLastDay()));
            }
        });
    }
}
