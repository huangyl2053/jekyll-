/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.ChosainData.Chosain;
import jp.co.ndensan.reams.db.dbe.divcontroller.controller.demodata.ShujiiData.Doctor;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.HihokenshaForSearchResult;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.IHihokenshaForSearchResult;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlUtil.Converter.IConverter;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.GenderName;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 要介護認定申請者のデモデータを扱います。
 *
 * @author N3327 三浦 凌
 */
public class YokaigoninteiShinseishaData {

    private static final RString FILE_NAME = new RString("dbe1010001/YokaigoninteiShinseisha.yml");

    /**
     * 要介護認定申請者のデモデータを返します。
     *
     * @return 要介護認定申請者のデモデータ
     */
    public IDemoData<IHihokenshaForSearchResult>
            get要介護認定申請者List() {
        List<HashMap> dataFromYaml = YamlLoader.DBE.loadAsList(FILE_NAME);
        return new DemoData(dataFromYaml, new IConverter<IHihokenshaForSearchResult>() {

            @Override
            public IHihokenshaForSearchResult exec(Map map) {
                return toIHihokneshaForSearchResult(map);
            }

            private IHihokenshaForSearchResult toIHihokneshaForSearchResult(Map map) {
                ControlGenerator cg = new ControlGenerator(map);
                return new HihokenshaForSearchResult(
                        new KaigoHihokenshaNo(cg.getAsRString("被保番号")),
                        new ShikibetsuCode(cg.getAsRString("識別コード")),
                        cg.getAsRString("被保区分"),
                        cg.getAsRString("氏名"),
                        cg.getAsRString("カナ氏名"),
                        toGender(cg.getAsRString("性別")),
                        cg.getAsRDate("生年月日"),
                        cg.getAsYubinNo("郵便番号"),
                        new AtenaJusho(cg.getAsRString("住所")),
                        cg.getAsRString("個人番号"),
                        toJuminShubetsu(cg.getAsRString("住民種別")),
                        new SetaiCode(cg.getAsRString("世帯コード")));
            }

            private Gender toGender(RString value) {
                GenderName genderName;
                try {
                    genderName = GenderName.toValue(value);
                } catch (IllegalArgumentException e) {
                    genderName = GenderName.MALE_NAME;
                }
                if (genderName == GenderName.MALE_NAME) {
                    return Gender.MALE;
                } else {
                    return Gender.FEMALE;
                }
            }

            private JuminShubetsu toJuminShubetsu(RString value) {
                for (JuminShubetsu item : JuminShubetsu.values()) {
                    if (item.getCode().equals(value) || item.toRString().equals(value)) {
                        return item;
                    }
                }
                return JuminShubetsu.日本人;
            }
        });
    }

    /**
     * 要介護状態区分です。
     */
    public enum YokaigoJotaiKubun {

        非該当(false),
        要支援1(false),
        要支援2(false),
        要介護1(true),
        要介護2(true),
        要介護3(true),
        要介護4(true),
        要介護5(true);

        private final RString theName;
        private final boolean isYokaigo;

        private YokaigoJotaiKubun(boolean isYokaigo) {
            this.theName = new RString(name());
            this.isYokaigo = isYokaigo;
        }

        /**
         * name()と同じ文字列を持ったRStringを返します。
         *
         * @return name()と同じ文字列を持ったRString
         */
        public RString toRString() {
            return theName;
        }

        /**
         * 要介護ならtrueを返します。
         *
         * @return 要介護ならtrue
         */
        public boolean is要介護() {
            return isYokaigo;
        }

        public static YokaigoJotaiKubun toValue(RString rstr) {
            for (YokaigoJotaiKubun item : values()) {
                if (item.toRString().equals(rstr)) {
                    return item;
                }
            }
            return 非該当;
        }
    }

    /**
     * 前回認定結果です。
     */
    public static class LatestNinteiResult {

        public static final LatestNinteiResult NOTHING;

        static {
            NOTHING = new LatestNinteiResult(YokaigoJotaiKubun.非該当, FlexibleDate.EMPTY, new Range<>(FlexibleDate.EMPTY, FlexibleDate.EMPTY));
        }

        private final YokaigoJotaiKubun theYokaigodo;
        private final FlexibleDate theNinteiDate;
        private final Range<FlexibleDate> theYukoKikan;

        LatestNinteiResult(YokaigoJotaiKubun yokaigodo, FlexibleDate ninteiDate, Range<FlexibleDate> yukoKikan) {
            this.theYokaigodo = yokaigodo;
            this.theNinteiDate = ninteiDate;
            this.theYukoKikan = yukoKikan;
        }

        LatestNinteiResult(YokaigoJotaiKubun yokaigodo, FlexibleDate ninteiDate, FlexibleDate yukoKikanFrom, int yukokikanTukishu) {
            this.theYokaigodo = yokaigodo;
            this.theNinteiDate = ninteiDate;

            FlexibleDate yukoKikanTo
                    = isFirst(yukoKikanFrom)
                    ? toLastDateOfMonth(yukoKikanFrom.plusMonth(yukokikanTukishu - 1))
                    : toLastDateOfMonth(yukoKikanFrom.plusMonth(yukokikanTukishu));
            this.theYukoKikan = new Range<>(yukoKikanFrom, yukoKikanTo);
        }

        private static boolean isFirst(FlexibleDate date) {
            return date.getDayValue() == 1;
        }

        private static FlexibleDate toLastDateOfMonth(FlexibleDate date) {
            return new FlexibleDate(date.getYearMonth().toDateString() + String.valueOf(date.getLastDay()));
        }

        public YokaigoJotaiKubun yokaigodo() {
            return this.theYokaigodo;
        }

        public FlexibleDate ninteiDate() {
            return this.theNinteiDate;
        }

        public Range<FlexibleDate> yukoKikan() {
            return this.theYukoKikan;
        }
    }

    public LatestNinteiResult get前回認定結果(RString hihokenshaNo) {
        List<HashMap> hihokenshaList = get要介護認定申請者List().asRaw();
        for (Map hihokensha : hihokenshaList) {
            ControlGenerator cg = new ControlGenerator(hihokensha);
            if (hihokenshaNo.equals(cg.getAsRString("被保番号"))) {
                FlexibleDate latestNinteiDate = cg.getAsFlexibleDate("前回認定日");
                if (FlexibleDate.EMPTY.equals(latestNinteiDate)) {
                    return LatestNinteiResult.NOTHING;
                }
                return new LatestNinteiResult(
                        YokaigoJotaiKubun.toValue(cg.getAsRString("前回要介護度")),
                        latestNinteiDate,
                        cg.getAsFlexibleDate("前回有効期間開始日"),
                        cg.getAsDecimal("前回有効期間月数").intValue());
            }
        }
        return LatestNinteiResult.NOTHING;
    }

    public Doctor get前回主治医(RString hihokenshaNo) {
        List<HashMap> hihokenshaList = get要介護認定申請者List().asRaw();
        for (Map hihokensha : hihokenshaList) {
            ControlGenerator cg = new ControlGenerator(hihokensha);
            if (hihokenshaNo.equals(cg.getAsRString("被保番号"))) {
                return new ShujiiData().get主治医From(cg.getAsRString("前回主治医コード"));
            }
        }
        return Doctor.EMPTY;
    }

    public Chosain get前回調査員(RString hihokenshaNo) {
        List<HashMap> hihokenshaList = get要介護認定申請者List().asRaw();
        for (Map hihokensha : hihokenshaList) {
            ControlGenerator cg = new ControlGenerator(hihokensha);
            if (hihokenshaNo.equals(cg.getAsRString("被保番号"))) {
                return new ChosainData().get調査員From(cg.getAsRString("前回調査員コード"));
            }
        }
        return Chosain.EMPTY;
    }
}
