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
public class 段階判定_老齢年金 implements I1段階判定 {

    private static final int LAST_DAY = 31;

    @Override
    public boolean isMatch(HokenryoDankaiInput hokenryoDankaiInput) {

        Calendar 老齢年金開始日 = Calendar.getInstance();
        Calendar 老齢年金終了日 = Calendar.getInstance();
        Calendar 賦課年度開始日 = Calendar.getInstance();
        Calendar 賦課年度終了日 = Calendar.getInstance();

        賦課年度開始日.set(Integer.parseInt(String.valueOf(hokenryoDankaiInput.getFukaNendo())), Month.APRIL.getValue(), 1);
        賦課年度終了日.set(Integer.parseInt(String.valueOf(hokenryoDankaiInput.getFukaNendo())) + 1, Month.MARCH.getValue(), LAST_DAY);

        boolean result = false;

        if (hokenryoDankaiInput.getFukaKonkyo().getRoreiNenkinStartYMD() != null
                && hokenryoDankaiInput.getFukaKonkyo().getSetaiKazeiKubun().equals("非課税")) {
            老齢年金開始日.setTime(hokenryoDankaiInput.getFukaKonkyo().getRoreiNenkinStartYMD());
            if (hokenryoDankaiInput.getFukaKonkyo().getRoreiNenkinEndYMD() != null) {
                老齢年金終了日.setTime(hokenryoDankaiInput.getFukaKonkyo().getRoreiNenkinEndYMD());
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
    public HokenryoDankaiOutput dai1dankaiSettei(HokenryoDankaiInput hokenryoDankaiInput, HokenryoDankaiOutput hokenryoDankaiOutput) {

        Calendar 老齢年金開始月 = Calendar.getInstance();
        Calendar 判定年月 = Calendar.getInstance();

        老齢年金開始月.set(hokenryoDankaiInput.getFukaKonkyo().getSeihoStartYMD().getYear(),
                hokenryoDankaiInput.getFukaKonkyo().getSeihoStartYMD().getMonth(), 1);

        Map<RString, HokenryoDankai> hokenryoDankaiMap = hokenryoDankaiOutput.createHokenryoDankaiMap();

        for (RString tsuki : hokenryoDankaiMap.keySet()) {
            判定年月.clear();
            if (Integer.parseInt(tsuki.toString()) < Month.MARCH.getValue()) {
                判定年月.set(Integer.parseInt(String.valueOf(hokenryoDankaiInput.getFukaNendo())) + 1, Integer.parseInt(tsuki.toString()), 1);

            } else {
                判定年月.set(Integer.parseInt(String.valueOf(hokenryoDankaiInput.getFukaNendo())), Integer.parseInt(tsuki.toString()), 1);
            }

            if (dateHantei(老齢年金開始月, 判定年月)) {
                hokenryoDankaiMap.get(tsuki).setHokenryoDankai(new RString("1"));
            }
        }

        hokenryoDankaiOutput.createHokenryoDankaiOutput(hokenryoDankaiMap);

        return hokenryoDankaiOutput;

    }

    private boolean dateHantei(Calendar 老齢年金開始月, Calendar taishoYMD) {
        return 老齢年金開始月.compareTo(taishoYMD) <= 0;
    }
}
