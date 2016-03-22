/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core;

import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import java.util.Calendar;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.Month;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810
 */
class DankaiHanteiRoreiNenkin implements IDai1DankaiHantei {

    private static final int LAST_DAY = 31;

    @Override
    public boolean matches(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter) {

        Calendar 老齢年金開始日;
        Calendar 老齢年金終了日;
        Calendar 賦課年度開始日 = Calendar.getInstance();
        Calendar 賦課年度終了日 = Calendar.getInstance();

        賦課年度開始日.set(Integer.parseInt(String.valueOf(hokenryoDankaiHanteiParameter.getFukaNendo())), Month.APRIL.getValue(), 1);
        賦課年度終了日.set(Integer.parseInt(String.valueOf(hokenryoDankaiHanteiParameter.getFukaNendo())) + 1, Month.MARCH.getValue(), LAST_DAY);

        boolean result = false;

        if (hokenryoDankaiHanteiParameter.getFukaKonkyo().getRoreiNenkinStartYMD() != null
                && hokenryoDankaiHanteiParameter.getFukaKonkyo().getSetaiKazeiKubun().equals(KazeiKubun.valueOf("非課税"))) {
            老齢年金開始日 = getRealDateCalendar(hokenryoDankaiHanteiParameter.getFukaKonkyo().getRoreiNenkinStartYMD());
            if (hokenryoDankaiHanteiParameter.getFukaKonkyo().getRoreiNenkinEndYMD() != null) {
                老齢年金終了日 = getRealDateCalendar(hokenryoDankaiHanteiParameter.getFukaKonkyo().getRoreiNenkinEndYMD());
                if (賦課年度開始日.compareTo(老齢年金終了日) <= 0
                        && 老齢年金開始日.compareTo(賦課年度終了日) <= 0) {
                    result = true;
                }
            } else {
                if (老齢年金開始日.compareTo(賦課年度終了日) <= 0) {
                    result = true;
                }
            }
        }

        return result;

    }

    @Override
    public TsukibetsuHokenryoDankai dai1dankaiSettei(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter,
            TsukibetsuHokenryoDankai tsukibetsuHokenryoDankai) {

        Calendar 老齢年金開始月 = Calendar.getInstance();
        Calendar 判定年月 = Calendar.getInstance();

        老齢年金開始月.set(hokenryoDankaiHanteiParameter.getFukaKonkyo().getSeihoStartYMD().getYearValue(),
                hokenryoDankaiHanteiParameter.getFukaKonkyo().getSeihoStartYMD().getMonthValue(), 1);

        Map<RString, HokenryoDankai> hokenryoDankaiMap = tsukibetsuHokenryoDankai.createHokenryoDankaiMap();

        for (RString tsuki : hokenryoDankaiMap.keySet()) {
            判定年月.clear();
            if (Integer.parseInt(tsuki.toString()) < Month.MARCH.getValue()) {
                判定年月.set(Integer.parseInt(String.valueOf(hokenryoDankaiHanteiParameter.getFukaNendo())) + 1,
                        Integer.parseInt(tsuki.toString()), 1);

            } else {
                判定年月.set(Integer.parseInt(String.valueOf(hokenryoDankaiHanteiParameter.getFukaNendo())), Integer.parseInt(tsuki.toString()), 1);
            }

            if (dateHantei(老齢年金開始月, 判定年月)) {
                hokenryoDankaiMap.get(tsuki).setHokenryoDankai(new RString("1"));
            }
        }

        tsukibetsuHokenryoDankai.createHokenryoDankaiOutput(hokenryoDankaiMap);

        return tsukibetsuHokenryoDankai;

    }

    private boolean dateHantei(Calendar 老齢年金開始月, Calendar taishoYMD) {
        return 老齢年金開始月.compareTo(taishoYMD) <= 0;
    }

    private Calendar getRealDateCalendar(FlexibleDate roreiNenkinStartYMD) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, roreiNenkinStartYMD.getYearValue());
        calendar.set(Calendar.MONTH, roreiNenkinStartYMD.getMonthValue());
        calendar.set(Calendar.DATE, roreiNenkinStartYMD.getDayValue());
        return calendar;
    }
}
