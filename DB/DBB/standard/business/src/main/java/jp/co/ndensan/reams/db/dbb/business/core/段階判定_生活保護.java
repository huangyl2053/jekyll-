/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core;

import java.util.Calendar;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.Month;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810
 */
public class 段階判定_生活保護 implements I1段階判定 {

    private static final int LAST_DAY = 31;

    @Override
    public boolean isMatch(HokenryoDankaiInput hokenryoDankaiInput) {

        Calendar 生活保護開始日 = Calendar.getInstance();
        Calendar 生活保護終了日 = Calendar.getInstance();
        Calendar 賦課年度開始日 = Calendar.getInstance();
        Calendar 賦課年度終了日 = Calendar.getInstance();

        賦課年度開始日.set(Integer.parseInt(String.valueOf(hokenryoDankaiInput.getFukaNendo())), Month.APRIL.getValue(), 1);
        賦課年度終了日.set(Integer.parseInt(String.valueOf(hokenryoDankaiInput.getFukaNendo())) + 1, Month.MARCH.getValue(), LAST_DAY);

        boolean result = false;

        if (hokenryoDankaiInput.getFukaKonkyo().getSeihoStartYMD() != null) {
            生活保護開始日.setTime(hokenryoDankaiInput.getFukaKonkyo().getSeihoStartYMD());
            if (hokenryoDankaiInput.getFukaKonkyo().getSeihoEndYMD() != null) {
                生活保護終了日.setTime(hokenryoDankaiInput.getFukaKonkyo().getSeihoEndYMD());
                if (賦課年度開始日.compareTo(生活保護終了日) <= 0
                        && 生活保護開始日.compareTo(賦課年度終了日) <= 0) {
                    result = true;
                }
            } else {
                if (生活保護開始日.compareTo(賦課年度終了日) <= 0) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public HokenryoDankaiOutput dai1dankaiSettei(HokenryoDankaiInput hokenryoDankaiInput, HokenryoDankaiOutput hokenryoDankaiOutput) {

        Calendar 生活保護開始月 = Calendar.getInstance();
        Calendar 判定年月 = Calendar.getInstance();

        生活保護開始月.setTime(hokenryoDankaiInput.getFukaKonkyo().getSeihoStartYMD());
        生活保護開始月.set(生活保護開始月.get(Calendar.YEAR), 生活保護開始月.get(Calendar.MONTH) + 1, 1);
        //生活保護開始月.set(hokenryoDankaiInput.fukaKonkyo.SeihoStartYMD.getYear(), hokenryoDankaiInput.fukaKonkyo.SeihoStartYMD.getMonth(), 1);

        Map<RString, HokenryoDankai> hokenryoDankaiMap = hokenryoDankaiOutput.createHokenryoDankaiMap();

        for (RString tsuki : hokenryoDankaiMap.keySet()) {
            判定年月.clear();
            if (Integer.parseInt(tsuki.toString()) <= Month.MARCH.getValue()) {
                判定年月.set(Integer.parseInt(String.valueOf(hokenryoDankaiInput.getFukaNendo())) + 1, Integer.parseInt(tsuki.toString()), 1);

            } else {
                判定年月.set(Integer.parseInt(String.valueOf(hokenryoDankaiInput.getFukaNendo())), Integer.parseInt(tsuki.toString()), 1);
            }

            if (dateHantei(生活保護開始月, 判定年月)) {
                hokenryoDankaiMap.get(tsuki).setHokenryoDankai(new RString("1"));
                hokenryoDankaiMap.get(tsuki).setSystemDankai(new RString("1"));
                hokenryoDankaiMap.get(tsuki).setTokureiTaisho(false);
            }
        }

        hokenryoDankaiOutput.createHokenryoDankaiOutput(hokenryoDankaiMap);

        return hokenryoDankaiOutput;

    }

    private boolean dateHantei(Calendar 生活保護開始月, Calendar taishoYMD) {
        return 生活保護開始月.compareTo(taishoYMD) <= 0;
    }
}
