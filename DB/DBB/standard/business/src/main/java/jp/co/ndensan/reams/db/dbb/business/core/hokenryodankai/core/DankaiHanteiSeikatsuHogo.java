/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.core;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.param.HokenryoDankaiHanteiParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.Month;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810
 */
class DankaiHanteiSeikatsuHogo implements IDai1DankaiHantei {

    private static final int LAST_DAY = 31;

    @Override
    public boolean matches(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter) {

        Calendar 生活保護開始日;
        Calendar 生活保護終了日;
        Calendar 賦課年度開始日 = Calendar.getInstance();
        Calendar 賦課年度終了日 = Calendar.getInstance();

        賦課年度開始日.set(Integer.parseInt(String.valueOf(hokenryoDankaiHanteiParameter.getFukaNendo())), Month.APRIL.getValue(), 1);
        賦課年度終了日.set(Integer.parseInt(String.valueOf(hokenryoDankaiHanteiParameter.getFukaNendo())) + 1, Month.MARCH.getValue(), LAST_DAY);

        boolean result = false;

        if (!isNullOrEmpty(hokenryoDankaiHanteiParameter.getFukaKonkyo().getSeihoStartYMD())) {
            生活保護開始日 = getRealDateCalendar(hokenryoDankaiHanteiParameter.getFukaKonkyo().getSeihoStartYMD());
            if (!isNullOrEmpty(hokenryoDankaiHanteiParameter.getFukaKonkyo().getSeihoEndYMD())) {
                生活保護終了日 = getRealDateCalendar(hokenryoDankaiHanteiParameter.getFukaKonkyo().getSeihoEndYMD());
                this.getResult(賦課年度開始日, 賦課年度終了日, 生活保護開始日, 生活保護終了日);

            } else if (生活保護開始日.compareTo(賦課年度終了日) <= 0) {
                result = true;
            }
        }
        return result;
    }

    private boolean isNullOrEmpty(FlexibleDate ymd) {
        return null == ymd || ymd.isEmpty();
    }

    @Override
    public TsukibetsuHokenryoDankai dai1dankaiSettei(HokenryoDankaiHanteiParameter hokenryoDankaiHanteiParameter,
            TsukibetsuHokenryoDankai tsukibetsuHokenryoDankai) {

//        Calendar 生活保護開始月;
        Calendar 判定年月 = Calendar.getInstance();

//        生活保護開始月 = getRealDateCalendar(hokenryoDankaiHanteiParameter.getFukaKonkyo().getSeihoStartYMD());
//        生活保護開始月.set(生活保護開始月.get(Calendar.YEAR), 生活保護開始月.get(Calendar.MONTH) + 1, 1);
        //生活保護開始月.set(hokenryoDankaiHanteiParameter.fukaKonkyo.SeihoStartYMD.getYear(),
        //hokenryoDankaiHanteiParameter.fukaKonkyo.SeihoStartYMD.getMonth(), 1);
        Map<RString, RString> hokenryoDankaiMap = tsukibetsuHokenryoDankai.createHokenryoDankaiMap();
        Set<Map.Entry<RString, RString>> set = hokenryoDankaiMap.entrySet();
        Iterator<Map.Entry<RString, RString>> it = set.iterator();

        while (it.hasNext()) {
            判定年月.clear();
            Map.Entry<RString, RString> entry = it.next();
            RString key = entry.getKey();
            if (Integer.parseInt(key.toString()) <= Month.MARCH.getValue()) {
                判定年月.set(Integer.parseInt(String.valueOf(hokenryoDankaiHanteiParameter.getFukaNendo())) + 1,
                        Integer.parseInt(key.toString()), 1);

            } else {
                判定年月.set(Integer.parseInt(String.valueOf(hokenryoDankaiHanteiParameter.getFukaNendo())), Integer.parseInt(key.toString()), 1);
            }

//            if (dateHantei(生活保護開始月, 判定年月)) {
//                hokenryoDankaiMap.get(key).setHokenryoDankai(new RString("1"));
//                hokenryoDankaiMap.get(key).setSystemDankai(new RString("1"));
//                hokenryoDankaiMap.get(key).setTokureiTaisho(false);
//            }
        }

        tsukibetsuHokenryoDankai.createHokenryoDankaiOutput(hokenryoDankaiMap);

        return tsukibetsuHokenryoDankai;

    }

//    private boolean dateHantei(Calendar 生活保護開始月, Calendar taishoYMD) {
//        return 生活保護開始月.compareTo(taishoYMD) <= 0;
//    }
    private Calendar getRealDateCalendar(FlexibleDate roreiNenkinStartYMD) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, roreiNenkinStartYMD.getYearValue());
        calendar.set(Calendar.MONTH, roreiNenkinStartYMD.getMonthValue());
        calendar.set(Calendar.DATE, roreiNenkinStartYMD.getDayValue());
        return calendar;
    }

    private boolean getResult(Calendar 賦課年度開始日, Calendar 賦課年度終了日, Calendar 生活保護開始日, Calendar 生活保護終了日) {
        boolean result = false;
        if (賦課年度開始日.compareTo(生活保護終了日) <= 0
                && 生活保護開始日.compareTo(賦課年度終了日) <= 0) {
            result = true;
        }
        return result;
    }
}
