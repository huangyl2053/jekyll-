/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.CsvKenHokokuShiryoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.KenHokokuShiryoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定事業状況報告の情報です。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class CsvKenHokokuShiryoEditor {

    private static final RString 非該当 = new RString("01");
    private static final RString 要支援1 = new RString("12");
    private static final RString 要支援2 = new RString("13");
    private static final RString 要介護1 = new RString("21");
    private static final RString 要介護2 = new RString("22");
    private static final RString 要介護3 = new RString("23");
    private static final RString 要介護4 = new RString("24");
    private static final RString 要介護5 = new RString("25");
    private final CsvKenHokokuShiryoEntity entity;
    private final KenHokokuShiryoEntity 県報告用資料情報;

    /**
     * コンストラクタです。
     *
     * @param entity CsvKenHokokuShiryoEntity
     * @param 県報告用資料情報 KenHokokuShiryoEntity
     */
    public CsvKenHokokuShiryoEditor(CsvKenHokokuShiryoEntity entity, KenHokokuShiryoEntity 県報告用資料情報) {
        this.entity = entity;
        this.県報告用資料情報 = 県報告用資料情報;
    }

    /**
     * 県報告用資料情報を設定します。
     */
    public void set県報告用資料情報() {
        if (非該当.equals(entity.getIchijiHanteiKekkaCode().value())) {
            set一次非該当();
        } else if (要支援1.equals(entity.getIchijiHanteiKekkaCode().value())) {
            set一次要支援1();
        } else if (要支援2.equals(entity.getIchijiHanteiKekkaCode().value())) {
            set一次要支援2();
        } else if (要介護1.equals(entity.getIchijiHanteiKekkaCode().value())) {
            set一次要介護1();
        } else if (要介護2.equals(entity.getIchijiHanteiKekkaCode().value())) {
            set一次要介護2();
        } else if (要介護3.equals(entity.getIchijiHanteiKekkaCode().value())) {
            set一次要介護3();
        } else if (要介護4.equals(entity.getIchijiHanteiKekkaCode().value())) {
            set一次要介護4();
        } else if (要介護5.equals(entity.getIchijiHanteiKekkaCode().value())) {
            set一次要介護5();
        }
    }

    private void set一次非該当() {
        if (非該当.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次非該当_二次非該当(new RString(entity.getHihokenshaCount()));
        } else if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次非該当_二次要支援1(new RString(entity.getHihokenshaCount()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次非該当_二次要支援2(new RString(entity.getHihokenshaCount()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次非該当_二次要介護1(new RString(entity.getHihokenshaCount()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次非該当_二次要介護2(new RString(entity.getHihokenshaCount()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次非該当_二次要介護3(new RString(entity.getHihokenshaCount()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次非該当_二次要介護4(new RString(entity.getHihokenshaCount()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次非該当_二次要介護5(new RString(entity.getHihokenshaCount()));
        }
    }

    private void set一次要支援1() {
        if (非該当.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要支援1_二次非該当(new RString(entity.getHihokenshaCount()));
        } else if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要支援1_二次要支援1(new RString(entity.getHihokenshaCount()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要支援1_二次要支援2(new RString(entity.getHihokenshaCount()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要支援1_二次要介護1(new RString(entity.getHihokenshaCount()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要支援1_二次要介護2(new RString(entity.getHihokenshaCount()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要支援1_二次要介護3(new RString(entity.getHihokenshaCount()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要支援1_二次要介護4(new RString(entity.getHihokenshaCount()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要支援1_二次要介護5(new RString(entity.getHihokenshaCount()));
        }
    }

    private void set一次要支援2() {
        if (非該当.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要支援2_二次非該当(new RString(entity.getHihokenshaCount()));
        } else if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要支援2_二次要支援1(new RString(entity.getHihokenshaCount()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要支援2_二次要支援2(new RString(entity.getHihokenshaCount()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要支援2_二次要介護1(new RString(entity.getHihokenshaCount()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要支援2_二次要介護2(new RString(entity.getHihokenshaCount()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要支援2_二次要介護3(new RString(entity.getHihokenshaCount()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要支援2_二次要介護4(new RString(entity.getHihokenshaCount()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要支援2_二次要介護5(new RString(entity.getHihokenshaCount()));
        }
    }

    private void set一次要介護1() {
        if (非該当.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護1_二次非該当(new RString(entity.getHihokenshaCount()));
        } else if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護1_二次要支援1(new RString(entity.getHihokenshaCount()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護1_二次要支援2(new RString(entity.getHihokenshaCount()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護1_二次要介護1(new RString(entity.getHihokenshaCount()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護1_二次要介護2(new RString(entity.getHihokenshaCount()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護1_二次要介護3(new RString(entity.getHihokenshaCount()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護1_二次要介護4(new RString(entity.getHihokenshaCount()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護1_二次要介護5(new RString(entity.getHihokenshaCount()));
        }
    }

    private void set一次要介護2() {
        if (非該当.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護2_二次非該当(new RString(entity.getHihokenshaCount()));
        } else if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護2_二次要支援1(new RString(entity.getHihokenshaCount()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護2_二次要支援2(new RString(entity.getHihokenshaCount()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護2_二次要介護1(new RString(entity.getHihokenshaCount()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護2_二次要介護2(new RString(entity.getHihokenshaCount()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護2_二次要介護3(new RString(entity.getHihokenshaCount()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護2_二次要介護4(new RString(entity.getHihokenshaCount()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護2_二次要介護5(new RString(entity.getHihokenshaCount()));
        }
    }

    private void set一次要介護3() {
        if (非該当.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護3_二次非該当(new RString(entity.getHihokenshaCount()));
        } else if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護3_二次要支援1(new RString(entity.getHihokenshaCount()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護3_二次要支援2(new RString(entity.getHihokenshaCount()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護3_二次要介護1(new RString(entity.getHihokenshaCount()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護3_二次要介護2(new RString(entity.getHihokenshaCount()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護3_二次要介護3(new RString(entity.getHihokenshaCount()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護3_二次要介護4(new RString(entity.getHihokenshaCount()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護3_二次要介護5(new RString(entity.getHihokenshaCount()));
        }
    }

    private void set一次要介護4() {
        if (非該当.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護4_二次非該当(new RString(entity.getHihokenshaCount()));
        } else if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護4_二次要支援1(new RString(entity.getHihokenshaCount()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護4_二次要支援2(new RString(entity.getHihokenshaCount()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護4_二次要介護1(new RString(entity.getHihokenshaCount()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護4_二次要介護2(new RString(entity.getHihokenshaCount()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護4_二次要介護3(new RString(entity.getHihokenshaCount()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護4_二次要介護4(new RString(entity.getHihokenshaCount()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護4_二次要介護5(new RString(entity.getHihokenshaCount()));
        }
    }

    private void set一次要介護5() {
        if (非該当.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護5_二次非該当(new RString(entity.getHihokenshaCount()));
        } else if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護5_二次要支援1(new RString(entity.getHihokenshaCount()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護5_二次要支援2(new RString(entity.getHihokenshaCount()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護5_二次要介護1(new RString(entity.getHihokenshaCount()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護5_二次要介護2(new RString(entity.getHihokenshaCount()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護5_二次要介護3(new RString(entity.getHihokenshaCount()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護5_二次要介護4(new RString(entity.getHihokenshaCount()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            県報告用資料情報.set一次要介護5_二次要介護5(new RString(entity.getHihokenshaCount()));
        }
    }

}
