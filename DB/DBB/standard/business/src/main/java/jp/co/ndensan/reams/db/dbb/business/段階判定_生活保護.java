/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import java.util.Calendar;
import java.util.Map;

/**
 *
 * @author N2810
 */
public class 段階判定_生活保護 implements I1段階判定 {

    @Override
    public boolean isMatch(HokenryoDankaiInput hokenryoDankaiInput) {

        Calendar 生活保護開始日 = Calendar.getInstance();
        Calendar 生活保護終了日 = Calendar.getInstance();
        Calendar 賦課年度開始日 = Calendar.getInstance();
        Calendar 賦課年度終了日 = Calendar.getInstance();

        賦課年度開始日.set(Integer.parseInt(hokenryoDankaiInput.getFukaNendo()), 4, 1);
        賦課年度終了日.set(Integer.parseInt(hokenryoDankaiInput.getFukaNendo()) + 1, 3, 31);

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
    public HokenryoDankaiOutput Dai1dankaiSettei(HokenryoDankaiInput hokenryoDankaiInput, HokenryoDankaiOutput hokenryoDankaiOutput) {

        Calendar 生活保護開始月 = Calendar.getInstance();
        Calendar 判定年月 = Calendar.getInstance();

        生活保護開始月.setTime(hokenryoDankaiInput.getFukaKonkyo().getSeihoStartYMD());
        生活保護開始月.set(生活保護開始月.get(Calendar.YEAR), 生活保護開始月.get(Calendar.MONTH) + 1, 1);
        //生活保護開始月.set(hokenryoDankaiInput.fukaKonkyo.SeihoStartYMD.getYear(), hokenryoDankaiInput.fukaKonkyo.SeihoStartYMD.getMonth(), 1);

        Map<String, HokenryoDankai> hokenryoDankaiMap = hokenryoDankaiOutput.CreateHokenryoDankaiMap();

        for (String tsuki : hokenryoDankaiMap.keySet()) {
            判定年月.clear();
            if (Integer.parseInt(tsuki) <= 3) {
                判定年月.set(Integer.parseInt(hokenryoDankaiInput.getFukaNendo()) + 1, Integer.parseInt(tsuki), 1);

            } else {
                判定年月.set(Integer.parseInt(hokenryoDankaiInput.getFukaNendo()), Integer.parseInt(tsuki), 1);
            }

            if (DateHantei(生活保護開始月, 判定年月)) {
                hokenryoDankaiMap.get(tsuki).setHokenryoDankai("1");
                hokenryoDankaiMap.get(tsuki).setSystemDankai("1");
                hokenryoDankaiMap.get(tsuki).setTokureiTaisho(false);
            }
        }

        hokenryoDankaiOutput.CreateHokenryoDankaiOutput(hokenryoDankaiMap);

        return hokenryoDankaiOutput;

    }

    private boolean DateHantei(Calendar 生活保護開始月, Calendar TaishoYMD) {
        return 生活保護開始月.compareTo(TaishoYMD) <= 0;
    }
}
