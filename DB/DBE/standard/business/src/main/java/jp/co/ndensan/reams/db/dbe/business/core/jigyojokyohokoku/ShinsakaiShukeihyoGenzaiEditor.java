/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku;

import java.text.DecimalFormat;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.ShinsakaiShukeiGenzainojokyoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.ShinsakaiShukeihyoGenzaiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaishukeigenzainojokyo.ShinsakaiShukeiGenzainojokyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 要介護認定事業状況報告の情報です。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class ShinsakaiShukeihyoGenzaiEditor {

    private static final DecimalFormat FORMAT = new DecimalFormat("0.00");
    private static final RString 要支援1 = new RString("12");
    private static final RString 要支援2 = new RString("13");
    private static final RString 要介護1 = new RString("21");
    private static final RString 要介護2 = new RString("22");
    private static final RString 要介護3 = new RString("23");
    private static final RString 要介護4 = new RString("24");
    private static final RString 要介護5 = new RString("25");
    private static final RString パーセント = new RString("%");
    private static final RString 上段なし = new RString("0.00%");
    private static final RString 全て = new RString("100%");
    private static final int ひゃく = 100;
    private static final int 新規申請 = 0;
    private static final int 更新申請 = 1;
    private static final int 区分変更申請 = 2;
    private static final int 転入 = 3;
    private static final int 有効期間6ヶ月 = 6;
    private static final int 有効期間12ヶ月 = 12;
    private static final int 有効期間24ヶ月 = 24;
    private static final RString 全市町村 = new RString("全市町村");
    private final ShinsakaiShukeihyoGenzaiEntity entity;
    private final ShinsakaiShukeiGenzainojokyoEntity genzainojokyo;
    private final ShinsakaiShukeiGenzainojokyoProcessParameter parameter;

    /**
     * コンストラクタです。
     *
     * @param parameter ShinsakaiShukeiGenzainojokyoProcessParameter
     * @param entity ShinsakaiShukeihyoGenzaiEntity
     * @param genzainojokyo ShinsakaiShukeiGenzainojokyoEntity
     */
    public ShinsakaiShukeihyoGenzaiEditor(ShinsakaiShukeiGenzainojokyoProcessParameter parameter,
            ShinsakaiShukeihyoGenzaiEntity entity, ShinsakaiShukeiGenzainojokyoEntity genzainojokyo) {
        this.parameter = parameter;
        this.entity = entity;
        this.genzainojokyo = genzainojokyo;
    }

    /**
     * 介護認定審査会集計表現在の状況別を設定します。
     */
    public void set介護認定審査会集計表現在の状況別() {
        set市町村();
        if (新規申請 == entity.getShinseiKubun()) {
            set新規申請();
        } else if (更新申請 == entity.getShinseiKubun()) {
            set更新申請();
        } else if (区分変更申請 == entity.getShinseiKubun()) {
            set区分変更申請();
        } else if (転入 == entity.getShinseiKubun()) {
            set転入();
        }
        set全体6ヶ月();
        set全体12ヶ月();
        set全体24ヶ月();
        set全体その他();
        set全体合計();
    }

    private void set市町村() {
        if (!parameter.isEmptyHokensyaNo()) {
            genzainojokyo.set市町村コード(entity.getShichosonCode().value());
            genzainojokyo.set市町村名(entity.getShichosonMeisho());
        } else {
            genzainojokyo.set市町村コード(RString.EMPTY);
            genzainojokyo.set市町村名(全市町村);
        }
    }

    private void set新規申請() {
        if (有効期間6ヶ月 == entity.getYukoKikan()) {
            set新規申請6ヶ月();
        } else if (有効期間12ヶ月 == entity.getYukoKikan()) {
            set新規申請12ヶ月();
        } else if (有効期間24ヶ月 == entity.getYukoKikan()) {
            set新規申請24ヶ月();
        } else {
            set新規申請その他();
        }
        set新規合計_上段();
        set新規合計_下段();
    }

    private void set更新申請() {
        if (有効期間6ヶ月 == entity.getYukoKikan()) {
            set更新申請6ヶ月();
        } else if (有効期間12ヶ月 == entity.getYukoKikan()) {
            set更新申請12ヶ月();
        } else if (有効期間24ヶ月 == entity.getYukoKikan()) {
            set更新申請24ヶ月();
        } else {
            set更新申請その他();
        }
        set更新合計_上段();
        set更新合計_下段();
    }

    private void set新規合計_上段() {
        genzainojokyo.set新規合計_要支援1_上段(new RString(toInt(genzainojokyo.get新規6ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get新規12ヶ月_要支援1_上段()) + toInt(genzainojokyo.get新規24ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get新規その他_要支援1_上段())));
        genzainojokyo.set新規合計_要支援2_上段(new RString(toInt(genzainojokyo.get新規6ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get新規12ヶ月_要支援2_上段()) + toInt(genzainojokyo.get新規24ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get新規その他_要支援2_上段())));
        genzainojokyo.set新規合計_要介護1_上段(new RString(toInt(genzainojokyo.get新規6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get新規12ヶ月_要介護1_上段()) + toInt(genzainojokyo.get新規24ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get新規その他_要介護1_上段())));
        genzainojokyo.set新規合計_要介護2_上段(new RString(toInt(genzainojokyo.get新規6ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get新規12ヶ月_要介護2_上段()) + toInt(genzainojokyo.get新規24ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get新規その他_要介護2_上段())));
        genzainojokyo.set新規合計_要介護3_上段(new RString(toInt(genzainojokyo.get新規6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get新規12ヶ月_要介護3_上段()) + toInt(genzainojokyo.get新規24ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get新規その他_要介護3_上段())));
        genzainojokyo.set新規合計_要介護4_上段(new RString(toInt(genzainojokyo.get新規6ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get新規12ヶ月_要介護4_上段()) + toInt(genzainojokyo.get新規24ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get新規その他_要介護4_上段())));
        genzainojokyo.set新規合計_要介護5_上段(new RString(toInt(genzainojokyo.get新規6ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get新規12ヶ月_要介護5_上段()) + toInt(genzainojokyo.get新規24ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get新規その他_要介護5_上段())));
        genzainojokyo.set新規合計_計_上段(new RString(toInt(genzainojokyo.get新規合計_要支援1_上段())
                + toInt(genzainojokyo.get新規合計_要支援2_上段()) + toInt(genzainojokyo.get新規合計_要介護1_上段())
                + toInt(genzainojokyo.get新規合計_要介護2_上段()) + toInt(genzainojokyo.get新規合計_要介護3_上段())
                + toInt(genzainojokyo.get新規合計_要介護4_上段()) + toInt(genzainojokyo.get新規合計_要介護5_上段())));
    }

    private void set新規合計_下段() {
        genzainojokyo.set新規合計_要支援1_下段(format下段(genzainojokyo.get新規合計_要支援1_上段(), genzainojokyo.get新規合計_計_上段()));
        genzainojokyo.set新規合計_要支援2_下段(format下段(genzainojokyo.get新規合計_要支援2_上段(), genzainojokyo.get新規合計_計_上段()));
        genzainojokyo.set新規合計_要介護1_下段(format下段(genzainojokyo.get新規合計_要介護1_上段(), genzainojokyo.get新規合計_計_上段()));
        genzainojokyo.set新規合計_要介護2_下段(format下段(genzainojokyo.get新規合計_要介護2_上段(), genzainojokyo.get新規合計_計_上段()));
        genzainojokyo.set新規合計_要介護3_下段(format下段(genzainojokyo.get新規合計_要介護3_上段(), genzainojokyo.get新規合計_計_上段()));
        genzainojokyo.set新規合計_要介護4_下段(format下段(genzainojokyo.get新規合計_要介護4_上段(), genzainojokyo.get新規合計_計_上段()));
        genzainojokyo.set新規合計_要介護5_下段(format下段(genzainojokyo.get新規合計_要介護5_上段(), genzainojokyo.get新規合計_計_上段()));
        genzainojokyo.set新規合計_計_下段(全て);
    }

    private void set区分変更申請() {
        if (有効期間6ヶ月 == entity.getYukoKikan()) {
            set区分変更申請6ヶ月();
        } else if (有効期間12ヶ月 == entity.getYukoKikan()) {
            set区分変更申請12ヶ月();
        } else if (有効期間24ヶ月 == entity.getYukoKikan()) {
            set区分変更申請24ヶ月();
        } else {
            set区分変更申請その他();
        }
        set区分変更合計_上段();
        set区分変更合計_下段();
    }

    private void set転入() {
        if (有効期間6ヶ月 == entity.getYukoKikan()) {
            set転入申請6ヶ月();
        } else {
            set転入申請その他();
        }
        set転入合計_上段();
        set転入合計_下段();
    }

    private void set新規申請6ヶ月() {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規6ヶ月_要支援1_上段(toRString(toInt(genzainojokyo.get新規6ヶ月_要支援1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規6ヶ月_要支援2_上段(toRString(toInt(genzainojokyo.get新規6ヶ月_要支援2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規6ヶ月_要介護1_上段(toRString(toInt(genzainojokyo.get新規6ヶ月_要介護1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規6ヶ月_要介護2_上段(toRString(toInt(genzainojokyo.get新規6ヶ月_要介護2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規6ヶ月_要介護3_上段(toRString(toInt(genzainojokyo.get新規6ヶ月_要介護3_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規6ヶ月_要介護4_上段(toRString(toInt(genzainojokyo.get新規6ヶ月_要介護4_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規6ヶ月_要介護5_上段(toRString(toInt(genzainojokyo.get新規6ヶ月_要介護5_上段()) + entity.getCountHihokenshaNo()));
        }
        set新規6ヶ月_計_上段();
        genzainojokyo.set新規6ヶ月_要支援1_下段(format下段(genzainojokyo.get新規6ヶ月_要支援1_上段(), genzainojokyo.get新規6ヶ月_計_上段()));
        genzainojokyo.set新規6ヶ月_要支援2_下段(format下段(genzainojokyo.get新規6ヶ月_要支援2_上段(), genzainojokyo.get新規6ヶ月_計_上段()));
        genzainojokyo.set新規6ヶ月_要介護1_下段(format下段(genzainojokyo.get新規6ヶ月_要介護1_上段(), genzainojokyo.get新規6ヶ月_計_上段()));
        genzainojokyo.set新規6ヶ月_要介護2_下段(format下段(genzainojokyo.get新規6ヶ月_要介護2_上段(), genzainojokyo.get新規6ヶ月_計_上段()));
        genzainojokyo.set新規6ヶ月_要介護3_下段(format下段(genzainojokyo.get新規6ヶ月_要介護3_上段(), genzainojokyo.get新規6ヶ月_計_上段()));
        genzainojokyo.set新規6ヶ月_要介護4_下段(format下段(genzainojokyo.get新規6ヶ月_要介護4_上段(), genzainojokyo.get新規6ヶ月_計_上段()));
        genzainojokyo.set新規6ヶ月_要介護5_下段(format下段(genzainojokyo.get新規6ヶ月_要介護5_上段(), genzainojokyo.get新規6ヶ月_計_上段()));
        genzainojokyo.set新規6ヶ月_計_下段(全て);
    }

    private void set新規6ヶ月_計_上段() {
        genzainojokyo.set新規6ヶ月_計_上段(new RString(toInt(genzainojokyo.get新規6ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get新規6ヶ月_要支援2_上段()) + toInt(genzainojokyo.get新規6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get新規6ヶ月_要介護2_上段()) + toInt(genzainojokyo.get新規6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get新規6ヶ月_要介護4_上段()) + toInt(genzainojokyo.get新規6ヶ月_要介護5_上段())));
    }

    private void set新規申請12ヶ月() {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規12ヶ月_要支援1_上段(toRString(toInt(genzainojokyo.get新規12ヶ月_要支援1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規12ヶ月_要支援2_上段(toRString(toInt(genzainojokyo.get新規12ヶ月_要支援2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規12ヶ月_要介護1_上段(toRString(toInt(genzainojokyo.get新規12ヶ月_要介護1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規12ヶ月_要介護2_上段(toRString(toInt(genzainojokyo.get新規12ヶ月_要介護2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規12ヶ月_要介護3_上段(toRString(toInt(genzainojokyo.get新規12ヶ月_要介護3_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規12ヶ月_要介護4_上段(toRString(toInt(genzainojokyo.get新規12ヶ月_要介護4_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規12ヶ月_要介護5_上段(toRString(toInt(genzainojokyo.get新規12ヶ月_要介護5_上段()) + entity.getCountHihokenshaNo()));
        }
        set新規12ヶ月_計_上段();
        genzainojokyo.set新規12ヶ月_要支援1_下段(format下段(genzainojokyo.get新規12ヶ月_要支援1_上段(), genzainojokyo.get新規12ヶ月_計_上段()));
        genzainojokyo.set新規12ヶ月_要支援2_下段(format下段(genzainojokyo.get新規12ヶ月_要支援2_上段(), genzainojokyo.get新規12ヶ月_計_上段()));
        genzainojokyo.set新規12ヶ月_要介護1_下段(format下段(genzainojokyo.get新規12ヶ月_要介護1_上段(), genzainojokyo.get新規12ヶ月_計_上段()));
        genzainojokyo.set新規12ヶ月_要介護2_下段(format下段(genzainojokyo.get新規12ヶ月_要介護2_上段(), genzainojokyo.get新規12ヶ月_計_上段()));
        genzainojokyo.set新規12ヶ月_要介護3_下段(format下段(genzainojokyo.get新規12ヶ月_要介護3_上段(), genzainojokyo.get新規12ヶ月_計_上段()));
        genzainojokyo.set新規12ヶ月_要介護4_下段(format下段(genzainojokyo.get新規12ヶ月_要介護4_上段(), genzainojokyo.get新規12ヶ月_計_上段()));
        genzainojokyo.set新規12ヶ月_要介護5_下段(format下段(genzainojokyo.get新規12ヶ月_要介護5_上段(), genzainojokyo.get新規12ヶ月_計_上段()));
        genzainojokyo.set新規12ヶ月_計_下段(全て);
    }

    private void set新規12ヶ月_計_上段() {
        genzainojokyo.set新規12ヶ月_計_上段(new RString(toInt(genzainojokyo.get新規12ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get新規12ヶ月_要支援2_上段()) + toInt(genzainojokyo.get新規12ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get新規12ヶ月_要介護2_上段()) + toInt(genzainojokyo.get新規12ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get新規12ヶ月_要介護4_上段()) + toInt(genzainojokyo.get新規12ヶ月_要介護5_上段())));
    }

    private void set新規申請24ヶ月() {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規24ヶ月_要支援1_上段(toRString(toInt(genzainojokyo.get新規24ヶ月_要支援1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規24ヶ月_要支援2_上段(toRString(toInt(genzainojokyo.get新規24ヶ月_要支援2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規24ヶ月_要介護1_上段(toRString(toInt(genzainojokyo.get新規24ヶ月_要介護1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規24ヶ月_要介護2_上段(toRString(toInt(genzainojokyo.get新規24ヶ月_要介護2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規24ヶ月_要介護3_上段(toRString(toInt(genzainojokyo.get新規24ヶ月_要介護3_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規24ヶ月_要介護4_上段(toRString(toInt(genzainojokyo.get新規24ヶ月_要介護4_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規24ヶ月_要介護5_上段(toRString(toInt(genzainojokyo.get新規24ヶ月_要介護5_上段()) + entity.getCountHihokenshaNo()));
        }
        set新規24ヶ月_計_上段();
        genzainojokyo.set新規24ヶ月_要支援1_下段(format下段(genzainojokyo.get新規24ヶ月_要支援1_上段(), genzainojokyo.get新規24ヶ月_計_上段()));
        genzainojokyo.set新規24ヶ月_要支援2_下段(format下段(genzainojokyo.get新規24ヶ月_要支援2_上段(), genzainojokyo.get新規24ヶ月_計_上段()));
        genzainojokyo.set新規24ヶ月_要介護1_下段(format下段(genzainojokyo.get新規24ヶ月_要介護1_上段(), genzainojokyo.get新規24ヶ月_計_上段()));
        genzainojokyo.set新規24ヶ月_要介護2_下段(format下段(genzainojokyo.get新規24ヶ月_要介護2_上段(), genzainojokyo.get新規24ヶ月_計_上段()));
        genzainojokyo.set新規24ヶ月_要介護3_下段(format下段(genzainojokyo.get新規24ヶ月_要介護3_上段(), genzainojokyo.get新規24ヶ月_計_上段()));
        genzainojokyo.set新規24ヶ月_要介護4_下段(format下段(genzainojokyo.get新規24ヶ月_要介護4_上段(), genzainojokyo.get新規24ヶ月_計_上段()));
        genzainojokyo.set新規24ヶ月_要介護5_下段(format下段(genzainojokyo.get新規24ヶ月_要介護5_上段(), genzainojokyo.get新規24ヶ月_計_上段()));
        genzainojokyo.set新規24ヶ月_計_下段(全て);
    }

    private void set新規24ヶ月_計_上段() {
        genzainojokyo.set新規24ヶ月_計_上段(new RString(toInt(genzainojokyo.get新規24ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get新規24ヶ月_要支援2_上段()) + toInt(genzainojokyo.get新規24ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get新規24ヶ月_要介護2_上段()) + toInt(genzainojokyo.get新規24ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get新規24ヶ月_要介護4_上段()) + toInt(genzainojokyo.get新規24ヶ月_要介護5_上段())));
    }

    private void set新規申請その他() {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規その他_要支援1_上段(toRString(toInt(genzainojokyo.get新規その他_要支援1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規その他_要支援2_上段(toRString(toInt(genzainojokyo.get新規その他_要支援2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規その他_要介護1_上段(toRString(toInt(genzainojokyo.get新規その他_要介護1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規その他_要介護2_上段(toRString(toInt(genzainojokyo.get新規その他_要介護2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規その他_要介護3_上段(toRString(toInt(genzainojokyo.get新規その他_要介護3_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規その他_要介護4_上段(toRString(toInt(genzainojokyo.get新規その他_要介護4_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set新規その他_要介護5_上段(toRString(toInt(genzainojokyo.get新規その他_要介護5_上段()) + entity.getCountHihokenshaNo()));
        }
        set新規その他_計_上段();
        genzainojokyo.set新規その他_要支援1_下段(format下段(genzainojokyo.get新規その他_要支援1_上段(), genzainojokyo.get新規その他_計_上段()));
        genzainojokyo.set新規その他_要支援2_下段(format下段(genzainojokyo.get新規その他_要支援2_上段(), genzainojokyo.get新規その他_計_上段()));
        genzainojokyo.set新規その他_要介護1_下段(format下段(genzainojokyo.get新規その他_要介護1_上段(), genzainojokyo.get新規その他_計_上段()));
        genzainojokyo.set新規その他_要介護2_下段(format下段(genzainojokyo.get新規その他_要介護2_上段(), genzainojokyo.get新規その他_計_上段()));
        genzainojokyo.set新規その他_要介護3_下段(format下段(genzainojokyo.get新規その他_要介護3_上段(), genzainojokyo.get新規その他_計_上段()));
        genzainojokyo.set新規その他_要介護4_下段(format下段(genzainojokyo.get新規その他_要介護4_上段(), genzainojokyo.get新規その他_計_上段()));
        genzainojokyo.set新規その他_要介護5_下段(format下段(genzainojokyo.get新規その他_要介護5_上段(), genzainojokyo.get新規その他_計_上段()));
        genzainojokyo.set新規その他_計_下段(全て);
    }

    private void set新規その他_計_上段() {
        genzainojokyo.set新規その他_計_上段(new RString(toInt(genzainojokyo.get新規その他_要支援1_上段())
                + toInt(genzainojokyo.get新規その他_要支援2_上段()) + toInt(genzainojokyo.get新規その他_要介護1_上段())
                + toInt(genzainojokyo.get新規その他_要介護2_上段()) + toInt(genzainojokyo.get新規その他_要介護3_上段())
                + toInt(genzainojokyo.get新規その他_要介護4_上段()) + toInt(genzainojokyo.get新規その他_要介護5_上段())));
    }

    private void set更新申請6ヶ月() {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新6ヶ月_要支援1_上段(toRString(toInt(genzainojokyo.get更新6ヶ月_要支援1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新6ヶ月_要支援2_上段(toRString(toInt(genzainojokyo.get更新6ヶ月_要支援2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新6ヶ月_要介護1_上段(toRString(toInt(genzainojokyo.get更新6ヶ月_要介護1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新6ヶ月_要介護2_上段(toRString(toInt(genzainojokyo.get更新6ヶ月_要介護2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新6ヶ月_要介護3_上段(toRString(toInt(genzainojokyo.get更新6ヶ月_要介護3_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新6ヶ月_要介護4_上段(toRString(toInt(genzainojokyo.get更新6ヶ月_要介護4_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新6ヶ月_要介護5_上段(toRString(toInt(genzainojokyo.get更新6ヶ月_要介護5_上段()) + entity.getCountHihokenshaNo()));
        }
        set更新6ヶ月_計_上段();
        genzainojokyo.set更新6ヶ月_要支援1_下段(format下段(genzainojokyo.get更新6ヶ月_要支援1_上段(), genzainojokyo.get更新6ヶ月_計_上段()));
        genzainojokyo.set更新6ヶ月_要支援2_下段(format下段(genzainojokyo.get更新6ヶ月_要支援2_上段(), genzainojokyo.get更新6ヶ月_計_上段()));
        genzainojokyo.set更新6ヶ月_要介護1_下段(format下段(genzainojokyo.get更新6ヶ月_要介護1_上段(), genzainojokyo.get更新6ヶ月_計_上段()));
        genzainojokyo.set更新6ヶ月_要介護2_下段(format下段(genzainojokyo.get更新6ヶ月_要介護2_上段(), genzainojokyo.get更新6ヶ月_計_上段()));
        genzainojokyo.set更新6ヶ月_要介護3_下段(format下段(genzainojokyo.get更新6ヶ月_要介護3_上段(), genzainojokyo.get更新6ヶ月_計_上段()));
        genzainojokyo.set更新6ヶ月_要介護4_下段(format下段(genzainojokyo.get更新6ヶ月_要介護4_上段(), genzainojokyo.get更新6ヶ月_計_上段()));
        genzainojokyo.set更新6ヶ月_要介護5_下段(format下段(genzainojokyo.get更新6ヶ月_要介護5_上段(), genzainojokyo.get更新6ヶ月_計_上段()));
        genzainojokyo.set更新6ヶ月_計_下段(全て);
    }

    private void set更新6ヶ月_計_上段() {
        genzainojokyo.set更新6ヶ月_計_上段(new RString(toInt(genzainojokyo.get更新6ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get更新6ヶ月_要支援2_上段()) + toInt(genzainojokyo.get更新6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get更新6ヶ月_要介護2_上段()) + toInt(genzainojokyo.get更新6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get更新6ヶ月_要介護4_上段()) + toInt(genzainojokyo.get更新6ヶ月_要介護5_上段())));
    }

    private void set更新申請12ヶ月() {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新12ヶ月_要支援1_上段(toRString(toInt(genzainojokyo.get更新12ヶ月_要支援1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新12ヶ月_要支援2_上段(toRString(toInt(genzainojokyo.get更新12ヶ月_要支援2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新12ヶ月_要介護1_上段(toRString(toInt(genzainojokyo.get更新12ヶ月_要介護1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新12ヶ月_要介護2_上段(toRString(toInt(genzainojokyo.get更新12ヶ月_要介護2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新12ヶ月_要介護3_上段(toRString(toInt(genzainojokyo.get更新12ヶ月_要介護3_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新12ヶ月_要介護4_上段(toRString(toInt(genzainojokyo.get更新12ヶ月_要介護4_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新12ヶ月_要介護5_上段(toRString(toInt(genzainojokyo.get更新12ヶ月_要介護5_上段()) + entity.getCountHihokenshaNo()));
        }
        set更新12ヶ月_計_上段();
        genzainojokyo.set更新12ヶ月_要支援1_下段(format下段(genzainojokyo.get更新12ヶ月_要支援1_上段(), genzainojokyo.get更新12ヶ月_計_上段()));
        genzainojokyo.set更新12ヶ月_要支援2_下段(format下段(genzainojokyo.get更新12ヶ月_要支援2_上段(), genzainojokyo.get更新12ヶ月_計_上段()));
        genzainojokyo.set更新12ヶ月_要介護1_下段(format下段(genzainojokyo.get更新12ヶ月_要介護1_上段(), genzainojokyo.get更新12ヶ月_計_上段()));
        genzainojokyo.set更新12ヶ月_要介護2_下段(format下段(genzainojokyo.get更新12ヶ月_要介護2_上段(), genzainojokyo.get更新12ヶ月_計_上段()));
        genzainojokyo.set更新12ヶ月_要介護3_下段(format下段(genzainojokyo.get更新12ヶ月_要介護3_上段(), genzainojokyo.get更新12ヶ月_計_上段()));
        genzainojokyo.set更新12ヶ月_要介護4_下段(format下段(genzainojokyo.get更新12ヶ月_要介護4_上段(), genzainojokyo.get更新12ヶ月_計_上段()));
        genzainojokyo.set更新12ヶ月_要介護5_下段(format下段(genzainojokyo.get更新12ヶ月_要介護5_上段(), genzainojokyo.get更新12ヶ月_計_上段()));
        genzainojokyo.set更新12ヶ月_計_下段(全て);
    }

    private void set更新12ヶ月_計_上段() {
        genzainojokyo.set更新12ヶ月_計_上段(new RString(toInt(genzainojokyo.get更新12ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要支援2_上段()) + toInt(genzainojokyo.get更新12ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要介護2_上段()) + toInt(genzainojokyo.get更新12ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要介護4_上段()) + toInt(genzainojokyo.get更新12ヶ月_要介護5_上段())));
    }

    private void set更新申請24ヶ月() {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新24ヶ月_要支援1_上段(toRString(toInt(genzainojokyo.get更新24ヶ月_要支援1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新24ヶ月_要支援2_上段(toRString(toInt(genzainojokyo.get更新24ヶ月_要支援2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新24ヶ月_要介護1_上段(toRString(toInt(genzainojokyo.get更新24ヶ月_要介護1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新24ヶ月_要介護2_上段(toRString(toInt(genzainojokyo.get更新24ヶ月_要介護2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新24ヶ月_要介護3_上段(toRString(toInt(genzainojokyo.get更新24ヶ月_要介護3_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新24ヶ月_要介護4_上段(toRString(toInt(genzainojokyo.get更新24ヶ月_要介護4_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新24ヶ月_要介護5_上段(toRString(toInt(genzainojokyo.get更新24ヶ月_要介護5_上段()) + entity.getCountHihokenshaNo()));
        }
        set更新24ヶ月_計_上段();
        genzainojokyo.set更新24ヶ月_要支援1_下段(format下段(genzainojokyo.get更新24ヶ月_要支援1_上段(), genzainojokyo.get更新24ヶ月_計_上段()));
        genzainojokyo.set更新24ヶ月_要支援2_下段(format下段(genzainojokyo.get更新24ヶ月_要支援2_上段(), genzainojokyo.get更新24ヶ月_計_上段()));
        genzainojokyo.set更新24ヶ月_要介護1_下段(format下段(genzainojokyo.get更新24ヶ月_要介護1_上段(), genzainojokyo.get更新24ヶ月_計_上段()));
        genzainojokyo.set更新24ヶ月_要介護2_下段(format下段(genzainojokyo.get更新24ヶ月_要介護2_上段(), genzainojokyo.get更新24ヶ月_計_上段()));
        genzainojokyo.set更新24ヶ月_要介護3_下段(format下段(genzainojokyo.get更新24ヶ月_要介護3_上段(), genzainojokyo.get更新24ヶ月_計_上段()));
        genzainojokyo.set更新24ヶ月_要介護4_下段(format下段(genzainojokyo.get更新24ヶ月_要介護4_上段(), genzainojokyo.get更新24ヶ月_計_上段()));
        genzainojokyo.set更新24ヶ月_要介護5_下段(format下段(genzainojokyo.get更新24ヶ月_要介護5_上段(), genzainojokyo.get更新24ヶ月_計_上段()));
        genzainojokyo.set更新24ヶ月_計_下段(全て);
    }

    private void set更新24ヶ月_計_上段() {
        genzainojokyo.set更新24ヶ月_計_上段(new RString(toInt(genzainojokyo.get更新24ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get更新24ヶ月_要支援2_上段()) + toInt(genzainojokyo.get更新24ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get更新24ヶ月_要介護2_上段()) + toInt(genzainojokyo.get更新24ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get更新24ヶ月_要介護4_上段()) + toInt(genzainojokyo.get更新24ヶ月_要介護5_上段())));
    }

    private void set更新申請その他() {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新その他_要支援1_上段(toRString(toInt(genzainojokyo.get更新その他_要支援1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新その他_要支援2_上段(toRString(toInt(genzainojokyo.get更新その他_要支援2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新その他_要介護1_上段(toRString(toInt(genzainojokyo.get更新その他_要介護1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新その他_要介護2_上段(toRString(toInt(genzainojokyo.get更新その他_要介護2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新その他_要介護3_上段(toRString(toInt(genzainojokyo.get更新その他_要介護3_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新その他_要介護4_上段(toRString(toInt(genzainojokyo.get更新その他_要介護4_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set更新その他_要介護5_上段(toRString(toInt(genzainojokyo.get更新その他_要介護5_上段()) + entity.getCountHihokenshaNo()));
        }
        set更新その他_計_上段();
        genzainojokyo.set更新その他_要支援1_下段(format下段(genzainojokyo.get更新その他_要支援1_上段(), genzainojokyo.get更新その他_計_上段()));
        genzainojokyo.set更新その他_要支援2_下段(format下段(genzainojokyo.get更新その他_要支援2_上段(), genzainojokyo.get更新その他_計_上段()));
        genzainojokyo.set更新その他_要介護1_下段(format下段(genzainojokyo.get更新その他_要介護1_上段(), genzainojokyo.get更新その他_計_上段()));
        genzainojokyo.set更新その他_要介護2_下段(format下段(genzainojokyo.get更新その他_要介護2_上段(), genzainojokyo.get更新その他_計_上段()));
        genzainojokyo.set更新その他_要介護3_下段(format下段(genzainojokyo.get更新その他_要介護3_上段(), genzainojokyo.get更新その他_計_上段()));
        genzainojokyo.set更新その他_要介護4_下段(format下段(genzainojokyo.get更新その他_要介護4_上段(), genzainojokyo.get更新その他_計_上段()));
        genzainojokyo.set更新その他_要介護5_下段(format下段(genzainojokyo.get更新その他_要介護5_上段(), genzainojokyo.get更新その他_計_上段()));
        genzainojokyo.set更新その他_計_下段(全て);
    }

    private void set更新その他_計_上段() {
        genzainojokyo.set更新その他_計_上段(new RString(toInt(genzainojokyo.get更新その他_要支援1_上段())
                + toInt(genzainojokyo.get更新その他_要支援2_上段()) + toInt(genzainojokyo.get更新その他_要介護1_上段())
                + toInt(genzainojokyo.get更新その他_要介護2_上段()) + toInt(genzainojokyo.get更新その他_要介護3_上段())
                + toInt(genzainojokyo.get更新その他_要介護4_上段()) + toInt(genzainojokyo.get更新その他_要介護5_上段())));
    }

    private void set更新合計_上段() {
        genzainojokyo.set更新合計_要支援1_上段(new RString(toInt(genzainojokyo.get更新6ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要支援1_上段()) + toInt(genzainojokyo.get更新24ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get更新その他_要支援1_上段())));
        genzainojokyo.set更新合計_要支援2_上段(new RString(toInt(genzainojokyo.get更新6ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要支援2_上段()) + toInt(genzainojokyo.get更新24ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get更新その他_要支援2_上段())));
        genzainojokyo.set更新合計_要介護1_上段(new RString(toInt(genzainojokyo.get更新6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要介護1_上段()) + toInt(genzainojokyo.get更新24ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get更新その他_要介護1_上段())));
        genzainojokyo.set更新合計_要介護2_上段(new RString(toInt(genzainojokyo.get更新6ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要介護2_上段()) + toInt(genzainojokyo.get更新24ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get更新その他_要介護2_上段())));
        genzainojokyo.set更新合計_要介護3_上段(new RString(toInt(genzainojokyo.get更新6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要介護3_上段()) + toInt(genzainojokyo.get更新24ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get更新その他_要介護3_上段())));
        genzainojokyo.set更新合計_要介護4_上段(new RString(toInt(genzainojokyo.get更新6ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要介護4_上段()) + toInt(genzainojokyo.get更新24ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get更新その他_要介護4_上段())));
        genzainojokyo.set更新合計_要介護5_上段(new RString(toInt(genzainojokyo.get更新6ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要介護5_上段()) + toInt(genzainojokyo.get更新24ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get更新その他_要介護5_上段())));
        genzainojokyo.set更新合計_計_上段(new RString(toInt(genzainojokyo.get更新合計_要支援1_上段())
                + toInt(genzainojokyo.get更新合計_要支援2_上段()) + toInt(genzainojokyo.get更新合計_要介護1_上段())
                + toInt(genzainojokyo.get更新合計_要介護2_上段()) + toInt(genzainojokyo.get更新合計_要介護3_上段())
                + toInt(genzainojokyo.get更新合計_要介護4_上段()) + toInt(genzainojokyo.get更新合計_要介護5_上段())));
    }

    private void set更新合計_下段() {
        genzainojokyo.set更新合計_要支援1_下段(format下段(genzainojokyo.get更新合計_要支援1_上段(), genzainojokyo.get更新合計_計_上段()));
        genzainojokyo.set更新合計_要支援2_下段(format下段(genzainojokyo.get更新合計_要支援2_上段(), genzainojokyo.get更新合計_計_上段()));
        genzainojokyo.set更新合計_要介護1_下段(format下段(genzainojokyo.get更新合計_要介護1_上段(), genzainojokyo.get更新合計_計_上段()));
        genzainojokyo.set更新合計_要介護2_下段(format下段(genzainojokyo.get更新合計_要介護2_上段(), genzainojokyo.get更新合計_計_上段()));
        genzainojokyo.set更新合計_要介護3_下段(format下段(genzainojokyo.get更新合計_要介護3_上段(), genzainojokyo.get更新合計_計_上段()));
        genzainojokyo.set更新合計_要介護4_下段(format下段(genzainojokyo.get更新合計_要介護4_上段(), genzainojokyo.get更新合計_計_上段()));
        genzainojokyo.set更新合計_要介護5_下段(format下段(genzainojokyo.get更新合計_要介護5_上段(), genzainojokyo.get更新合計_計_上段()));
        genzainojokyo.set更新合計_計_下段(全て);
    }

    private void set区分変更申請6ヶ月() {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更6ヶ月_要支援1_上段(toRString(toInt(genzainojokyo.get区分変更6ヶ月_要支援1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更6ヶ月_要支援2_上段(toRString(toInt(genzainojokyo.get区分変更6ヶ月_要支援2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更6ヶ月_要介護1_上段(toRString(toInt(genzainojokyo.get区分変更6ヶ月_要介護1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更6ヶ月_要介護2_上段(toRString(toInt(genzainojokyo.get区分変更6ヶ月_要介護2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更6ヶ月_要介護3_上段(toRString(toInt(genzainojokyo.get区分変更6ヶ月_要介護3_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更6ヶ月_要介護4_上段(toRString(toInt(genzainojokyo.get区分変更6ヶ月_要介護4_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更6ヶ月_要介護5_上段(toRString(toInt(genzainojokyo.get区分変更6ヶ月_要介護5_上段()) + entity.getCountHihokenshaNo()));
        }
        set区分変更6ヶ月_計_上段();
        genzainojokyo.set区分変更6ヶ月_要支援1_下段(format下段(genzainojokyo.get区分変更6ヶ月_要支援1_上段(), genzainojokyo.get区分変更6ヶ月_計_上段()));
        genzainojokyo.set区分変更6ヶ月_要支援2_下段(format下段(genzainojokyo.get区分変更6ヶ月_要支援2_上段(), genzainojokyo.get区分変更6ヶ月_計_上段()));
        genzainojokyo.set区分変更6ヶ月_要介護1_下段(format下段(genzainojokyo.get区分変更6ヶ月_要介護1_上段(), genzainojokyo.get区分変更6ヶ月_計_上段()));
        genzainojokyo.set区分変更6ヶ月_要介護2_下段(format下段(genzainojokyo.get区分変更6ヶ月_要介護2_上段(), genzainojokyo.get区分変更6ヶ月_計_上段()));
        genzainojokyo.set区分変更6ヶ月_要介護3_下段(format下段(genzainojokyo.get区分変更6ヶ月_要介護3_上段(), genzainojokyo.get区分変更6ヶ月_計_上段()));
        genzainojokyo.set区分変更6ヶ月_要介護4_下段(format下段(genzainojokyo.get区分変更6ヶ月_要介護4_上段(), genzainojokyo.get区分変更6ヶ月_計_上段()));
        genzainojokyo.set区分変更6ヶ月_要介護5_下段(format下段(genzainojokyo.get区分変更6ヶ月_要介護5_上段(), genzainojokyo.get区分変更6ヶ月_計_上段()));
        genzainojokyo.set区分変更6ヶ月_計_下段(全て);
    }

    private void set区分変更6ヶ月_計_上段() {
        genzainojokyo.set区分変更6ヶ月_計_上段(new RString(toInt(genzainojokyo.get区分変更6ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get区分変更6ヶ月_要支援2_上段()) + toInt(genzainojokyo.get区分変更6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get区分変更6ヶ月_要介護2_上段()) + toInt(genzainojokyo.get区分変更6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get区分変更6ヶ月_要介護4_上段()) + toInt(genzainojokyo.get区分変更6ヶ月_要介護5_上段())));
    }

    private void set区分変更申請12ヶ月() {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更12ヶ月_要支援1_上段(toRString(toInt(genzainojokyo.get区分変更12ヶ月_要支援1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更12ヶ月_要支援2_上段(toRString(toInt(genzainojokyo.get区分変更12ヶ月_要支援2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更12ヶ月_要介護1_上段(toRString(toInt(genzainojokyo.get区分変更12ヶ月_要介護1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更12ヶ月_要介護2_上段(toRString(toInt(genzainojokyo.get区分変更12ヶ月_要介護2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更12ヶ月_要介護3_上段(toRString(toInt(genzainojokyo.get区分変更12ヶ月_要介護3_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更12ヶ月_要介護4_上段(toRString(toInt(genzainojokyo.get区分変更12ヶ月_要介護4_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更12ヶ月_要介護5_上段(toRString(toInt(genzainojokyo.get区分変更12ヶ月_要介護5_上段()) + entity.getCountHihokenshaNo()));
        }
        set区分変更12ヶ月_計_上段();
        genzainojokyo.set区分変更12ヶ月_要支援1_下段(format下段(genzainojokyo.get区分変更12ヶ月_要支援1_上段(), genzainojokyo.get区分変更12ヶ月_計_上段()));
        genzainojokyo.set区分変更12ヶ月_要支援2_下段(format下段(genzainojokyo.get区分変更12ヶ月_要支援2_上段(), genzainojokyo.get区分変更12ヶ月_計_上段()));
        genzainojokyo.set区分変更12ヶ月_要介護1_下段(format下段(genzainojokyo.get区分変更12ヶ月_要介護1_上段(), genzainojokyo.get区分変更12ヶ月_計_上段()));
        genzainojokyo.set区分変更12ヶ月_要介護2_下段(format下段(genzainojokyo.get区分変更12ヶ月_要介護2_上段(), genzainojokyo.get区分変更12ヶ月_計_上段()));
        genzainojokyo.set区分変更12ヶ月_要介護3_下段(format下段(genzainojokyo.get区分変更12ヶ月_要介護3_上段(), genzainojokyo.get区分変更12ヶ月_計_上段()));
        genzainojokyo.set区分変更12ヶ月_要介護4_下段(format下段(genzainojokyo.get区分変更12ヶ月_要介護4_上段(), genzainojokyo.get区分変更12ヶ月_計_上段()));
        genzainojokyo.set区分変更12ヶ月_要介護5_下段(format下段(genzainojokyo.get区分変更12ヶ月_要介護5_上段(), genzainojokyo.get区分変更12ヶ月_計_上段()));
        genzainojokyo.set区分変更12ヶ月_計_下段(全て);
    }

    private void set区分変更12ヶ月_計_上段() {
        genzainojokyo.set区分変更12ヶ月_計_上段(new RString(toInt(genzainojokyo.get区分変更12ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要支援2_上段()) + toInt(genzainojokyo.get区分変更12ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要介護2_上段()) + toInt(genzainojokyo.get区分変更12ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要介護4_上段()) + toInt(genzainojokyo.get区分変更12ヶ月_要介護5_上段())));
    }

    private void set区分変更申請24ヶ月() {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更24ヶ月_要支援1_上段(toRString(toInt(genzainojokyo.get区分変更24ヶ月_要支援1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更24ヶ月_要支援2_上段(toRString(toInt(genzainojokyo.get区分変更24ヶ月_要支援2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更24ヶ月_要介護1_上段(toRString(toInt(genzainojokyo.get区分変更24ヶ月_要介護1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更24ヶ月_要介護2_上段(toRString(toInt(genzainojokyo.get区分変更24ヶ月_要介護2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更24ヶ月_要介護3_上段(toRString(toInt(genzainojokyo.get区分変更24ヶ月_要介護3_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更24ヶ月_要介護4_上段(toRString(toInt(genzainojokyo.get区分変更24ヶ月_要介護4_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更24ヶ月_要介護5_上段(toRString(toInt(genzainojokyo.get区分変更24ヶ月_要介護5_上段()) + entity.getCountHihokenshaNo()));
        }
        set区分変更24ヶ月_計_上段();
        genzainojokyo.set区分変更24ヶ月_要支援1_下段(format下段(genzainojokyo.get区分変更24ヶ月_要支援1_上段(), genzainojokyo.get区分変更24ヶ月_計_上段()));
        genzainojokyo.set区分変更24ヶ月_要支援2_下段(format下段(genzainojokyo.get区分変更24ヶ月_要支援2_上段(), genzainojokyo.get区分変更24ヶ月_計_上段()));
        genzainojokyo.set区分変更24ヶ月_要介護1_下段(format下段(genzainojokyo.get区分変更24ヶ月_要介護1_上段(), genzainojokyo.get区分変更24ヶ月_計_上段()));
        genzainojokyo.set区分変更24ヶ月_要介護2_下段(format下段(genzainojokyo.get区分変更24ヶ月_要介護2_上段(), genzainojokyo.get区分変更24ヶ月_計_上段()));
        genzainojokyo.set区分変更24ヶ月_要介護3_下段(format下段(genzainojokyo.get区分変更24ヶ月_要介護3_上段(), genzainojokyo.get区分変更24ヶ月_計_上段()));
        genzainojokyo.set区分変更24ヶ月_要介護4_下段(format下段(genzainojokyo.get区分変更24ヶ月_要介護4_上段(), genzainojokyo.get区分変更24ヶ月_計_上段()));
        genzainojokyo.set区分変更24ヶ月_要介護5_下段(format下段(genzainojokyo.get区分変更24ヶ月_要介護5_上段(), genzainojokyo.get区分変更24ヶ月_計_上段()));
        genzainojokyo.set区分変更24ヶ月_計_下段(全て);
    }

    private void set区分変更24ヶ月_計_上段() {
        genzainojokyo.set区分変更24ヶ月_計_上段(new RString(toInt(genzainojokyo.get区分変更24ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get区分変更24ヶ月_要支援2_上段()) + toInt(genzainojokyo.get区分変更24ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get区分変更24ヶ月_要介護2_上段()) + toInt(genzainojokyo.get区分変更24ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get区分変更24ヶ月_要介護4_上段()) + toInt(genzainojokyo.get区分変更24ヶ月_要介護5_上段())));
    }

    private void set区分変更申請その他() {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更その他_要支援1_上段(toRString(toInt(genzainojokyo.get区分変更その他_要支援1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更その他_要支援2_上段(toRString(toInt(genzainojokyo.get区分変更その他_要支援2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更その他_要介護1_上段(toRString(toInt(genzainojokyo.get区分変更その他_要介護1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更その他_要介護2_上段(toRString(toInt(genzainojokyo.get区分変更その他_要介護2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更その他_要介護3_上段(toRString(toInt(genzainojokyo.get区分変更その他_要介護3_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更その他_要介護4_上段(toRString(toInt(genzainojokyo.get区分変更その他_要介護4_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set区分変更その他_要介護5_上段(toRString(toInt(genzainojokyo.get区分変更その他_要介護5_上段()) + entity.getCountHihokenshaNo()));
        }
        set区分変更その他_計_上段();
        genzainojokyo.set区分変更その他_要支援1_下段(format下段(genzainojokyo.get区分変更その他_要支援1_上段(), genzainojokyo.get区分変更その他_計_上段()));
        genzainojokyo.set区分変更その他_要支援2_下段(format下段(genzainojokyo.get区分変更その他_要支援2_上段(), genzainojokyo.get区分変更その他_計_上段()));
        genzainojokyo.set区分変更その他_要介護1_下段(format下段(genzainojokyo.get区分変更その他_要介護1_上段(), genzainojokyo.get区分変更その他_計_上段()));
        genzainojokyo.set区分変更その他_要介護2_下段(format下段(genzainojokyo.get区分変更その他_要介護2_上段(), genzainojokyo.get区分変更その他_計_上段()));
        genzainojokyo.set区分変更その他_要介護3_下段(format下段(genzainojokyo.get区分変更その他_要介護3_上段(), genzainojokyo.get区分変更その他_計_上段()));
        genzainojokyo.set区分変更その他_要介護4_下段(format下段(genzainojokyo.get区分変更その他_要介護4_上段(), genzainojokyo.get区分変更その他_計_上段()));
        genzainojokyo.set区分変更その他_要介護5_下段(format下段(genzainojokyo.get区分変更その他_要介護5_上段(), genzainojokyo.get区分変更その他_計_上段()));
        genzainojokyo.set区分変更その他_計_下段(全て);
    }

    private void set区分変更その他_計_上段() {
        genzainojokyo.set区分変更その他_計_上段(new RString(toInt(genzainojokyo.get区分変更その他_要支援1_上段())
                + toInt(genzainojokyo.get区分変更その他_要支援2_上段()) + toInt(genzainojokyo.get区分変更その他_要介護1_上段())
                + toInt(genzainojokyo.get区分変更その他_要介護2_上段()) + toInt(genzainojokyo.get区分変更その他_要介護3_上段())
                + toInt(genzainojokyo.get区分変更その他_要介護4_上段()) + toInt(genzainojokyo.get区分変更その他_要介護5_上段())));
    }

    private void set区分変更合計_上段() {
        genzainojokyo.set区分変更合計_要支援1_上段(new RString(toInt(genzainojokyo.get区分変更6ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要支援1_上段()) + toInt(genzainojokyo.get区分変更24ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get区分変更その他_要支援1_上段())));
        genzainojokyo.set区分変更合計_要支援2_上段(new RString(toInt(genzainojokyo.get区分変更6ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要支援2_上段()) + toInt(genzainojokyo.get区分変更24ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get区分変更その他_要支援2_上段())));
        genzainojokyo.set区分変更合計_要介護1_上段(new RString(toInt(genzainojokyo.get区分変更6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要介護1_上段()) + toInt(genzainojokyo.get区分変更24ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get区分変更その他_要介護1_上段())));
        genzainojokyo.set区分変更合計_要介護2_上段(new RString(toInt(genzainojokyo.get区分変更6ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要介護2_上段()) + toInt(genzainojokyo.get区分変更24ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get区分変更その他_要介護2_上段())));
        genzainojokyo.set区分変更合計_要介護3_上段(new RString(toInt(genzainojokyo.get区分変更6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要介護3_上段()) + toInt(genzainojokyo.get区分変更24ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get区分変更その他_要介護3_上段())));
        genzainojokyo.set区分変更合計_要介護4_上段(new RString(toInt(genzainojokyo.get区分変更6ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要介護4_上段()) + toInt(genzainojokyo.get区分変更24ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get区分変更その他_要介護4_上段())));
        genzainojokyo.set区分変更合計_要介護5_上段(new RString(toInt(genzainojokyo.get区分変更6ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要介護5_上段()) + toInt(genzainojokyo.get区分変更24ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get区分変更その他_要介護5_上段())));
        genzainojokyo.set区分変更合計_計_上段(new RString(toInt(genzainojokyo.get区分変更合計_要支援1_上段())
                + toInt(genzainojokyo.get区分変更合計_要支援2_上段()) + toInt(genzainojokyo.get区分変更合計_要介護1_上段())
                + toInt(genzainojokyo.get区分変更合計_要介護2_上段()) + toInt(genzainojokyo.get区分変更合計_要介護3_上段())
                + toInt(genzainojokyo.get区分変更合計_要介護4_上段()) + toInt(genzainojokyo.get区分変更合計_要介護5_上段())));
    }

    private void set区分変更合計_下段() {
        genzainojokyo.set区分変更合計_要支援1_下段(format下段(genzainojokyo.get区分変更合計_要支援1_上段(), genzainojokyo.get区分変更合計_計_上段()));
        genzainojokyo.set区分変更合計_要支援2_下段(format下段(genzainojokyo.get区分変更合計_要支援2_上段(), genzainojokyo.get区分変更合計_計_上段()));
        genzainojokyo.set区分変更合計_要介護1_下段(format下段(genzainojokyo.get区分変更合計_要介護1_上段(), genzainojokyo.get区分変更合計_計_上段()));
        genzainojokyo.set区分変更合計_要介護2_下段(format下段(genzainojokyo.get区分変更合計_要介護2_上段(), genzainojokyo.get区分変更合計_計_上段()));
        genzainojokyo.set区分変更合計_要介護3_下段(format下段(genzainojokyo.get区分変更合計_要介護3_上段(), genzainojokyo.get区分変更合計_計_上段()));
        genzainojokyo.set区分変更合計_要介護4_下段(format下段(genzainojokyo.get区分変更合計_要介護4_上段(), genzainojokyo.get区分変更合計_計_上段()));
        genzainojokyo.set区分変更合計_要介護5_下段(format下段(genzainojokyo.get区分変更合計_要介護5_上段(), genzainojokyo.get区分変更合計_計_上段()));
        genzainojokyo.set区分変更合計_計_下段(全て);
    }

    private void set転入申請6ヶ月() {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入6ヶ月_要支援1_上段(toRString(toInt(genzainojokyo.get転入6ヶ月_要支援1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入6ヶ月_要支援2_上段(toRString(toInt(genzainojokyo.get転入6ヶ月_要支援2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入6ヶ月_要介護1_上段(toRString(toInt(genzainojokyo.get転入6ヶ月_要介護1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入6ヶ月_要介護2_上段(toRString(toInt(genzainojokyo.get転入6ヶ月_要介護2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入6ヶ月_要介護3_上段(toRString(toInt(genzainojokyo.get転入6ヶ月_要介護3_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入6ヶ月_要介護4_上段(toRString(toInt(genzainojokyo.get転入6ヶ月_要介護4_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入6ヶ月_要介護5_上段(toRString(toInt(genzainojokyo.get転入6ヶ月_要介護5_上段()) + entity.getCountHihokenshaNo()));
        }
        set転入6ヶ月_計_上段();
        genzainojokyo.set転入6ヶ月_要支援1_下段(format下段(genzainojokyo.get転入6ヶ月_要支援1_上段(), genzainojokyo.get転入6ヶ月_計_上段()));
        genzainojokyo.set転入6ヶ月_要支援2_下段(format下段(genzainojokyo.get転入6ヶ月_要支援2_上段(), genzainojokyo.get転入6ヶ月_計_上段()));
        genzainojokyo.set転入6ヶ月_要介護1_下段(format下段(genzainojokyo.get転入6ヶ月_要介護1_上段(), genzainojokyo.get転入6ヶ月_計_上段()));
        genzainojokyo.set転入6ヶ月_要介護2_下段(format下段(genzainojokyo.get転入6ヶ月_要介護2_上段(), genzainojokyo.get転入6ヶ月_計_上段()));
        genzainojokyo.set転入6ヶ月_要介護3_下段(format下段(genzainojokyo.get転入6ヶ月_要介護3_上段(), genzainojokyo.get転入6ヶ月_計_上段()));
        genzainojokyo.set転入6ヶ月_要介護4_下段(format下段(genzainojokyo.get転入6ヶ月_要介護4_上段(), genzainojokyo.get転入6ヶ月_計_上段()));
        genzainojokyo.set転入6ヶ月_要介護5_下段(format下段(genzainojokyo.get転入6ヶ月_要介護5_上段(), genzainojokyo.get転入6ヶ月_計_上段()));
        genzainojokyo.set転入6ヶ月_計_下段(全て);
    }

    private void set転入6ヶ月_計_上段() {
        genzainojokyo.set転入6ヶ月_計_上段(new RString(toInt(genzainojokyo.get転入6ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get転入6ヶ月_要支援2_上段()) + toInt(genzainojokyo.get転入6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get転入6ヶ月_要介護2_上段()) + toInt(genzainojokyo.get転入6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get転入6ヶ月_要介護4_上段()) + toInt(genzainojokyo.get転入6ヶ月_要介護5_上段())));
    }

    private void set転入申請その他() {
        if (要支援1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入その他_要支援1_上段(toRString(toInt(genzainojokyo.get転入その他_要支援1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要支援2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入その他_要支援2_上段(toRString(toInt(genzainojokyo.get転入その他_要支援2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護1.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入その他_要介護1_上段(toRString(toInt(genzainojokyo.get転入その他_要介護1_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護2.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入その他_要介護2_上段(toRString(toInt(genzainojokyo.get転入その他_要介護2_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護3.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入その他_要介護3_上段(toRString(toInt(genzainojokyo.get転入その他_要介護3_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護4.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入その他_要介護4_上段(toRString(toInt(genzainojokyo.get転入その他_要介護4_上段()) + entity.getCountHihokenshaNo()));
        } else if (要介護5.equals(entity.getNijiHanteiYokaigoJotaiKubunCode().value())) {
            genzainojokyo.set転入その他_要介護5_上段(toRString(toInt(genzainojokyo.get転入その他_要介護5_上段()) + entity.getCountHihokenshaNo()));
        }
        set転入その他_計_上段();
        genzainojokyo.set転入その他_要支援1_下段(format下段(genzainojokyo.get転入その他_要支援1_上段(), genzainojokyo.get転入その他_計_上段()));
        genzainojokyo.set転入その他_要支援2_下段(format下段(genzainojokyo.get転入その他_要支援2_上段(), genzainojokyo.get転入その他_計_上段()));
        genzainojokyo.set転入その他_要介護1_下段(format下段(genzainojokyo.get転入その他_要介護1_上段(), genzainojokyo.get転入その他_計_上段()));
        genzainojokyo.set転入その他_要介護2_下段(format下段(genzainojokyo.get転入その他_要介護2_上段(), genzainojokyo.get転入その他_計_上段()));
        genzainojokyo.set転入その他_要介護3_下段(format下段(genzainojokyo.get転入その他_要介護3_上段(), genzainojokyo.get転入その他_計_上段()));
        genzainojokyo.set転入その他_要介護4_下段(format下段(genzainojokyo.get転入その他_要介護4_上段(), genzainojokyo.get転入その他_計_上段()));
        genzainojokyo.set転入その他_要介護5_下段(format下段(genzainojokyo.get転入その他_要介護5_上段(), genzainojokyo.get転入その他_計_上段()));
        genzainojokyo.set転入その他_計_下段(全て);
    }

    private void set転入その他_計_上段() {
        genzainojokyo.set転入その他_計_上段(new RString(toInt(genzainojokyo.get転入その他_要支援1_上段())
                + toInt(genzainojokyo.get転入その他_要支援2_上段()) + toInt(genzainojokyo.get転入その他_要介護1_上段())
                + toInt(genzainojokyo.get転入その他_要介護2_上段()) + toInt(genzainojokyo.get転入その他_要介護3_上段())
                + toInt(genzainojokyo.get転入その他_要介護4_上段()) + toInt(genzainojokyo.get転入その他_要介護5_上段())));
    }

    private void set転入合計_上段() {
        genzainojokyo.set転入合計_要支援1_上段(new RString(toInt(genzainojokyo.get転入6ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get転入その他_要支援1_上段())));
        genzainojokyo.set転入合計_要支援2_上段(new RString(toInt(genzainojokyo.get転入6ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get転入その他_要支援2_上段())));
        genzainojokyo.set転入合計_要介護1_上段(new RString(toInt(genzainojokyo.get転入6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get転入その他_要介護1_上段())));
        genzainojokyo.set転入合計_要介護2_上段(new RString(toInt(genzainojokyo.get転入6ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get転入その他_要介護2_上段())));
        genzainojokyo.set転入合計_要介護3_上段(new RString(toInt(genzainojokyo.get転入6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get転入その他_要介護3_上段())));
        genzainojokyo.set転入合計_要介護4_上段(new RString(toInt(genzainojokyo.get転入6ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get転入その他_要介護4_上段())));
        genzainojokyo.set転入合計_要介護5_上段(new RString(toInt(genzainojokyo.get転入6ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get転入その他_要介護5_上段())));
        genzainojokyo.set転入合計_計_上段(new RString(toInt(genzainojokyo.get転入合計_要支援1_上段())
                + toInt(genzainojokyo.get転入合計_要支援2_上段()) + toInt(genzainojokyo.get転入合計_要介護1_上段())
                + toInt(genzainojokyo.get転入合計_要介護2_上段()) + toInt(genzainojokyo.get転入合計_要介護3_上段())
                + toInt(genzainojokyo.get転入合計_要介護4_上段()) + toInt(genzainojokyo.get転入合計_要介護5_上段())));
    }

    private void set転入合計_下段() {
        genzainojokyo.set転入合計_要支援1_下段(format下段(genzainojokyo.get転入合計_要支援1_上段(), genzainojokyo.get転入合計_計_上段()));
        genzainojokyo.set転入合計_要支援2_下段(format下段(genzainojokyo.get転入合計_要支援2_上段(), genzainojokyo.get転入合計_計_上段()));
        genzainojokyo.set転入合計_要介護1_下段(format下段(genzainojokyo.get転入合計_要介護1_上段(), genzainojokyo.get転入合計_計_上段()));
        genzainojokyo.set転入合計_要介護2_下段(format下段(genzainojokyo.get転入合計_要介護2_上段(), genzainojokyo.get転入合計_計_上段()));
        genzainojokyo.set転入合計_要介護3_下段(format下段(genzainojokyo.get転入合計_要介護3_上段(), genzainojokyo.get転入合計_計_上段()));
        genzainojokyo.set転入合計_要介護4_下段(format下段(genzainojokyo.get転入合計_要介護4_上段(), genzainojokyo.get転入合計_計_上段()));
        genzainojokyo.set転入合計_要介護5_下段(format下段(genzainojokyo.get転入合計_要介護5_上段(), genzainojokyo.get転入合計_計_上段()));
        genzainojokyo.set転入合計_計_下段(全て);
    }

    private void set全体6ヶ月() {
        genzainojokyo.set全体6ヶ月_要支援1_上段(new RString(toInt(genzainojokyo.get新規6ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get更新6ヶ月_要支援1_上段()) + toInt(genzainojokyo.get区分変更6ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get転入6ヶ月_要支援1_上段())));
        genzainojokyo.set全体6ヶ月_要支援2_上段(new RString(
                toInt(genzainojokyo.get新規6ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get更新6ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get区分変更6ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get転入6ヶ月_要支援2_上段())));
        genzainojokyo.set全体6ヶ月_要介護1_上段(new RString(
                toInt(genzainojokyo.get新規6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get更新6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get区分変更6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get転入6ヶ月_要介護1_上段())));
        genzainojokyo.set全体6ヶ月_要介護2_上段(new RString(
                toInt(genzainojokyo.get新規6ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get更新6ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get区分変更6ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get転入6ヶ月_要介護2_上段())));
        genzainojokyo.set全体6ヶ月_要介護3_上段(new RString(
                toInt(genzainojokyo.get新規6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get更新6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get区分変更6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get転入6ヶ月_要介護3_上段())));
        genzainojokyo.set全体6ヶ月_要介護4_上段(new RString(
                toInt(genzainojokyo.get新規6ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get更新6ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get区分変更6ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get転入6ヶ月_要介護4_上段())));
        genzainojokyo.set全体6ヶ月_要介護5_上段(new RString(
                toInt(genzainojokyo.get新規6ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get更新6ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get区分変更6ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get転入6ヶ月_要介護5_上段())));
        set全体6ヶ月_計_上段();
        genzainojokyo.set全体6ヶ月_要支援1_下段(format下段(genzainojokyo.get全体6ヶ月_要支援1_上段(), genzainojokyo.get全体6ヶ月_計_上段()));
        genzainojokyo.set全体6ヶ月_要支援2_下段(format下段(genzainojokyo.get全体6ヶ月_要支援2_上段(), genzainojokyo.get全体6ヶ月_計_上段()));
        genzainojokyo.set全体6ヶ月_要介護1_下段(format下段(genzainojokyo.get全体6ヶ月_要介護1_上段(), genzainojokyo.get全体6ヶ月_計_上段()));
        genzainojokyo.set全体6ヶ月_要介護2_下段(format下段(genzainojokyo.get全体6ヶ月_要介護2_上段(), genzainojokyo.get全体6ヶ月_計_上段()));
        genzainojokyo.set全体6ヶ月_要介護3_下段(format下段(genzainojokyo.get全体6ヶ月_要介護3_上段(), genzainojokyo.get全体6ヶ月_計_上段()));
        genzainojokyo.set全体6ヶ月_要介護4_下段(format下段(genzainojokyo.get全体6ヶ月_要介護4_上段(), genzainojokyo.get全体6ヶ月_計_上段()));
        genzainojokyo.set全体6ヶ月_要介護5_下段(format下段(genzainojokyo.get全体6ヶ月_要介護5_上段(), genzainojokyo.get全体6ヶ月_計_上段()));
        genzainojokyo.set全体6ヶ月_計_下段(全て);
    }

    private void set全体6ヶ月_計_上段() {
        genzainojokyo.set全体6ヶ月_計_上段(new RString(toInt(genzainojokyo.get全体6ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get全体6ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get全体6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get全体6ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get全体6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get全体6ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get全体6ヶ月_要介護5_上段())));
    }

    private void set全体12ヶ月() {
        genzainojokyo.set全体12ヶ月_要支援1_上段(new RString(
                toInt(genzainojokyo.get新規12ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要支援1_上段())));
        genzainojokyo.set全体12ヶ月_要支援2_上段(new RString(
                toInt(genzainojokyo.get新規12ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要支援2_上段())));
        genzainojokyo.set全体12ヶ月_要介護1_上段(new RString(
                toInt(genzainojokyo.get新規12ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要介護1_上段())));
        genzainojokyo.set全体12ヶ月_要介護2_上段(new RString(
                toInt(genzainojokyo.get新規12ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要介護2_上段())));
        genzainojokyo.set全体12ヶ月_要介護3_上段(new RString(
                toInt(genzainojokyo.get新規12ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要介護3_上段())));
        genzainojokyo.set全体12ヶ月_要介護4_上段(new RString(
                toInt(genzainojokyo.get新規12ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要介護4_上段())));
        genzainojokyo.set全体12ヶ月_要介護5_上段(new RString(
                toInt(genzainojokyo.get新規12ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get更新12ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get区分変更12ヶ月_要介護5_上段())));
        set全体12ヶ月_計_上段();
        genzainojokyo.set全体12ヶ月_要支援1_下段(format下段(genzainojokyo.get全体12ヶ月_要支援1_上段(), genzainojokyo.get全体12ヶ月_計_上段()));
        genzainojokyo.set全体12ヶ月_要支援2_下段(format下段(genzainojokyo.get全体12ヶ月_要支援2_上段(), genzainojokyo.get全体12ヶ月_計_上段()));
        genzainojokyo.set全体12ヶ月_要介護1_下段(format下段(genzainojokyo.get全体12ヶ月_要介護1_上段(), genzainojokyo.get全体12ヶ月_計_上段()));
        genzainojokyo.set全体12ヶ月_要介護2_下段(format下段(genzainojokyo.get全体12ヶ月_要介護2_上段(), genzainojokyo.get全体12ヶ月_計_上段()));
        genzainojokyo.set全体12ヶ月_要介護3_下段(format下段(genzainojokyo.get全体12ヶ月_要介護3_上段(), genzainojokyo.get全体12ヶ月_計_上段()));
        genzainojokyo.set全体12ヶ月_要介護4_下段(format下段(genzainojokyo.get全体12ヶ月_要介護4_上段(), genzainojokyo.get全体12ヶ月_計_上段()));
        genzainojokyo.set全体12ヶ月_要介護5_下段(format下段(genzainojokyo.get全体12ヶ月_要介護5_上段(), genzainojokyo.get全体12ヶ月_計_上段()));
        genzainojokyo.set全体12ヶ月_計_下段(全て);
    }

    private void set全体12ヶ月_計_上段() {
        genzainojokyo.set全体12ヶ月_計_上段(new RString(toInt(genzainojokyo.get全体12ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要介護5_上段())));
    }

    private void set全体24ヶ月() {
        genzainojokyo.set全体24ヶ月_要支援1_上段(new RString(
                toInt(genzainojokyo.get新規24ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get更新24ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get区分変更24ヶ月_要支援1_上段())));
        genzainojokyo.set全体24ヶ月_要支援2_上段(new RString(
                toInt(genzainojokyo.get新規24ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get更新24ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get区分変更24ヶ月_要支援2_上段())));
        genzainojokyo.set全体24ヶ月_要介護1_上段(new RString(
                toInt(genzainojokyo.get新規24ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get更新24ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get区分変更24ヶ月_要介護1_上段())));
        genzainojokyo.set全体24ヶ月_要介護2_上段(new RString(
                toInt(genzainojokyo.get新規24ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get更新24ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get区分変更24ヶ月_要介護2_上段())));
        genzainojokyo.set全体24ヶ月_要介護3_上段(new RString(
                toInt(genzainojokyo.get新規24ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get更新24ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get区分変更24ヶ月_要介護3_上段())));
        genzainojokyo.set全体24ヶ月_要介護4_上段(new RString(
                toInt(genzainojokyo.get新規24ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get更新24ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get区分変更24ヶ月_要介護4_上段())));
        genzainojokyo.set全体24ヶ月_要介護5_上段(new RString(
                toInt(genzainojokyo.get新規24ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get更新24ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get区分変更24ヶ月_要介護5_上段())));
        set全体24ヶ月_計_上段();
        genzainojokyo.set全体24ヶ月_要支援1_下段(format下段(genzainojokyo.get全体24ヶ月_要支援1_上段(), genzainojokyo.get全体24ヶ月_計_上段()));
        genzainojokyo.set全体24ヶ月_要支援2_下段(format下段(genzainojokyo.get全体24ヶ月_要支援2_上段(), genzainojokyo.get全体24ヶ月_計_上段()));
        genzainojokyo.set全体24ヶ月_要介護1_下段(format下段(genzainojokyo.get全体24ヶ月_要介護1_上段(), genzainojokyo.get全体24ヶ月_計_上段()));
        genzainojokyo.set全体24ヶ月_要介護2_下段(format下段(genzainojokyo.get全体24ヶ月_要介護2_上段(), genzainojokyo.get全体24ヶ月_計_上段()));
        genzainojokyo.set全体24ヶ月_要介護3_下段(format下段(genzainojokyo.get全体24ヶ月_要介護3_上段(), genzainojokyo.get全体24ヶ月_計_上段()));
        genzainojokyo.set全体24ヶ月_要介護4_下段(format下段(genzainojokyo.get全体24ヶ月_要介護4_上段(), genzainojokyo.get全体24ヶ月_計_上段()));
        genzainojokyo.set全体24ヶ月_要介護5_下段(format下段(genzainojokyo.get全体24ヶ月_要介護5_上段(), genzainojokyo.get全体24ヶ月_計_上段()));
        genzainojokyo.set全体24ヶ月_計_下段(全て);
    }

    private void set全体24ヶ月_計_上段() {
        genzainojokyo.set全体24ヶ月_計_上段(new RString(toInt(genzainojokyo.get全体24ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要介護5_上段())));
    }

    private void set全体その他() {
        genzainojokyo.set全体その他_要支援1_上段(new RString(toInt(genzainojokyo.get新規その他_要支援1_上段())
                + toInt(genzainojokyo.get更新その他_要支援1_上段()) + toInt(genzainojokyo.get区分変更その他_要支援1_上段())
                + toInt(genzainojokyo.get転入その他_要支援1_上段())));
        genzainojokyo.set全体その他_要支援2_上段(new RString(
                toInt(genzainojokyo.get新規その他_要支援2_上段())
                + toInt(genzainojokyo.get更新その他_要支援2_上段())
                + toInt(genzainojokyo.get区分変更その他_要支援2_上段())
                + toInt(genzainojokyo.get転入その他_要支援2_上段())));
        genzainojokyo.set全体その他_要介護1_上段(new RString(
                toInt(genzainojokyo.get新規その他_要介護1_上段())
                + toInt(genzainojokyo.get更新その他_要介護1_上段())
                + toInt(genzainojokyo.get区分変更その他_要介護1_上段())
                + toInt(genzainojokyo.get転入その他_要介護1_上段())));
        genzainojokyo.set全体その他_要介護2_上段(new RString(
                toInt(genzainojokyo.get新規その他_要介護2_上段())
                + toInt(genzainojokyo.get更新その他_要介護2_上段())
                + toInt(genzainojokyo.get区分変更その他_要介護2_上段())
                + toInt(genzainojokyo.get転入その他_要介護2_上段())));
        genzainojokyo.set全体その他_要介護3_上段(new RString(
                toInt(genzainojokyo.get新規その他_要介護3_上段())
                + toInt(genzainojokyo.get更新その他_要介護3_上段())
                + toInt(genzainojokyo.get区分変更その他_要介護3_上段())
                + toInt(genzainojokyo.get転入その他_要介護3_上段())));
        genzainojokyo.set全体その他_要介護4_上段(new RString(
                toInt(genzainojokyo.get新規その他_要介護4_上段())
                + toInt(genzainojokyo.get更新その他_要介護4_上段())
                + toInt(genzainojokyo.get区分変更その他_要介護4_上段())
                + toInt(genzainojokyo.get転入その他_要介護4_上段())));
        genzainojokyo.set全体その他_要介護5_上段(new RString(
                toInt(genzainojokyo.get新規その他_要介護5_上段())
                + toInt(genzainojokyo.get更新その他_要介護5_上段())
                + toInt(genzainojokyo.get区分変更その他_要介護5_上段())
                + toInt(genzainojokyo.get転入その他_要介護5_上段())));
        set全体その他_計_上段();
        genzainojokyo.set全体その他_要支援1_下段(format下段(genzainojokyo.get全体その他_要支援1_上段(), genzainojokyo.get全体その他_計_上段()));
        genzainojokyo.set全体その他_要支援2_下段(format下段(genzainojokyo.get全体その他_要支援2_上段(), genzainojokyo.get全体その他_計_上段()));
        genzainojokyo.set全体その他_要介護1_下段(format下段(genzainojokyo.get全体その他_要介護1_上段(), genzainojokyo.get全体その他_計_上段()));
        genzainojokyo.set全体その他_要介護2_下段(format下段(genzainojokyo.get全体その他_要介護2_上段(), genzainojokyo.get全体その他_計_上段()));
        genzainojokyo.set全体その他_要介護3_下段(format下段(genzainojokyo.get全体その他_要介護3_上段(), genzainojokyo.get全体その他_計_上段()));
        genzainojokyo.set全体その他_要介護4_下段(format下段(genzainojokyo.get全体その他_要介護4_上段(), genzainojokyo.get全体その他_計_上段()));
        genzainojokyo.set全体その他_要介護5_下段(format下段(genzainojokyo.get全体その他_要介護5_上段(), genzainojokyo.get全体その他_計_上段()));
        genzainojokyo.set全体その他_計_下段(全て);
    }

    private void set全体その他_計_上段() {
        genzainojokyo.set全体その他_計_上段(new RString(toInt(genzainojokyo.get全体その他_要支援1_上段())
                + toInt(genzainojokyo.get全体その他_要支援2_上段())
                + toInt(genzainojokyo.get全体その他_要介護1_上段())
                + toInt(genzainojokyo.get全体その他_要介護2_上段())
                + toInt(genzainojokyo.get全体その他_要介護3_上段())
                + toInt(genzainojokyo.get全体その他_要介護4_上段())
                + toInt(genzainojokyo.get全体その他_要介護5_上段())));
    }

    private void set全体合計() {
        genzainojokyo.set全体合計_要支援1_上段(new RString(
                toInt(genzainojokyo.get全体6ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要支援1_上段())
                + toInt(genzainojokyo.get全体その他_要支援1_上段())));
        genzainojokyo.set全体合計_要支援2_上段(new RString(
                toInt(genzainojokyo.get全体6ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要支援2_上段())
                + toInt(genzainojokyo.get全体その他_要支援2_上段())));
        genzainojokyo.set全体合計_要介護1_上段(new RString(
                toInt(genzainojokyo.get全体6ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要介護1_上段())
                + toInt(genzainojokyo.get全体その他_要介護1_上段())));
        genzainojokyo.set全体合計_要介護2_上段(new RString(
                toInt(genzainojokyo.get全体6ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要介護2_上段())
                + toInt(genzainojokyo.get全体その他_要介護2_上段())));
        genzainojokyo.set全体合計_要介護3_上段(new RString(
                toInt(genzainojokyo.get全体6ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要介護3_上段())
                + toInt(genzainojokyo.get全体その他_要介護3_上段())));
        genzainojokyo.set全体合計_要介護4_上段(new RString(
                toInt(genzainojokyo.get全体6ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要介護4_上段())
                + toInt(genzainojokyo.get全体その他_要介護4_上段())));
        genzainojokyo.set全体合計_要介護5_上段(new RString(
                toInt(genzainojokyo.get全体6ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get全体12ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get全体24ヶ月_要介護5_上段())
                + toInt(genzainojokyo.get全体その他_要介護5_上段())));
        set全体合計_計_上段();
        genzainojokyo.set全体合計_要支援1_下段(format下段(genzainojokyo.get全体合計_要支援1_上段(), genzainojokyo.get全体合計_計_上段()));
        genzainojokyo.set全体合計_要支援2_下段(format下段(genzainojokyo.get全体合計_要支援2_上段(), genzainojokyo.get全体合計_計_上段()));
        genzainojokyo.set全体合計_要介護1_下段(format下段(genzainojokyo.get全体合計_要介護1_上段(), genzainojokyo.get全体合計_計_上段()));
        genzainojokyo.set全体合計_要介護2_下段(format下段(genzainojokyo.get全体合計_要介護2_上段(), genzainojokyo.get全体合計_計_上段()));
        genzainojokyo.set全体合計_要介護3_下段(format下段(genzainojokyo.get全体合計_要介護3_上段(), genzainojokyo.get全体合計_計_上段()));
        genzainojokyo.set全体合計_要介護4_下段(format下段(genzainojokyo.get全体合計_要介護4_上段(), genzainojokyo.get全体合計_計_上段()));
        genzainojokyo.set全体合計_要介護5_下段(format下段(genzainojokyo.get全体合計_要介護5_上段(), genzainojokyo.get全体合計_計_上段()));
        genzainojokyo.set全体合計_計_下段(全て);
    }

    private void set全体合計_計_上段() {
        genzainojokyo.set全体合計_計_上段(new RString(
                toInt(genzainojokyo.get全体合計_要支援1_上段())
                + toInt(genzainojokyo.get全体合計_要支援2_上段())
                + toInt(genzainojokyo.get全体合計_要介護1_上段())
                + toInt(genzainojokyo.get全体合計_要介護2_上段())
                + toInt(genzainojokyo.get全体合計_要介護3_上段())
                + toInt(genzainojokyo.get全体合計_要介護4_上段())
                + toInt(genzainojokyo.get全体合計_要介護5_上段())));
    }

    private RString format下段(RString 保険者数, RString 合計) {
        if (Integer.parseInt(合計.toString()) == 0 || RString.isNullOrEmpty(保険者数)
                || Integer.parseInt(保険者数.toString()) == 0) {
            return 上段なし;
        }
        if (保険者数.equals(合計)) {
            return 全て;
        }
        return new RString(FORMAT.format(new Decimal(Integer.parseInt(保険者数.toString()))
                .divide(Integer.parseInt(合計.toString())).multiply(ひゃく)) + パーセント);
    }

    private RString toRString(int 保険者数) {
        if (保険者数 == 0) {
            return RString.EMPTY;
        }
        return new RString(保険者数);
    }

    private int toInt(RString 保険者数) {
        if (RString.isNullOrEmpty(保険者数)) {
            return 0;
        }
        return Integer.parseInt(保険者数.toString());
    }
}
