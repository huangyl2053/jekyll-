/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tmplate file, choose Tools | Templates
 * and open the tmplate in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbz100001;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.business.report.dbb021051.DBZ100001AtenaSealEntity;
import jp.co.ndensan.reams.db.dbb.business.report.dbb021051.DBZ100001AtenaSealParameterEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.atenaseal.DBZ100001AtenaSealSource;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 帳票設計_DBZ100001_宛名シールBodyEditor
 *
 * @reamsid_L DBB-5660-040 jiangxiaolong
 */
public class AtenaSealEditor
        implements IAtenaSealEditor {

    private final DBZ100001AtenaSealParameterEntity entity;
    private static final RString 宛名シール = new RString("宛名シール");
    private static final RString SAKUSEI = new RString("作成");
    private static final RString SET = new RString("set");
    private static final int NUM_14 = 14;
    private static final int NUM_15 = 15;
    private static final int NUM_16 = 16;
    private static final int NUM_17 = 17;
    private static final int NUM_18 = 18;
    private static final int NUM_19 = 19;
    private static final int NUM_13 = 13;
    private static final int NUM_12 = 12;
    private static final int NUM_11 = 11;
    private static final int NUM_10 = 10;
    private static final int NUM_9 = 9;
    private static final int NUM_8 = 8;
    private static final int NUM_7 = 7;
    private static final int NUM_6 = 6;
    private static final int NUM_5 = 5;
    private static final int NUM_4 = 4;
    private static final int NUM_3 = 3;
    private static final int NUM_2 = 2;
    private static final int NUM_1 = 1;
    private static final int NUM_0 = 0;
    private static final RString EMPTY = RString.EMPTY;
    private final Class cls = DBZ100001AtenaSealSource.class;
    private ShikibetsuCode tmp0;
    private RString tmp1;
    private RString tmp2;
    private RString tmp3;
    private RString tmp4;
    private RString tmp5;
    private RString tmp6;
    private RString tmp7;
    private RString tmp8;
    private RString tmp9;
    private RString tmp10;
    private RString tmp11;
    private RString tmp12;
    private RString tmp13;
    private RString tmp14;
    private RString tmp15;
    private RString tmp16;
    private RString tmp17;
    private RString tmp18;
    private RString tmp19;
    private Method method;
    private int posIndex;

    /**
     * コンストラクタです
     *
     * @param parameter DBZ100001AtenaSealParameterEntity
     */
    public AtenaSealEditor(
            DBZ100001AtenaSealParameterEntity parameter) {
        this.entity = parameter;

    }

    @Override
    public DBZ100001AtenaSealSource edit(
            DBZ100001AtenaSealSource source) {
        editSource(source);
        return source;
    }

    private void editSource(DBZ100001AtenaSealSource source) {
        if (null == entity) {
            return;
        }
        YMDHMS 作成日時 = YMDHMS.now();
        RString 作成日 = 作成日時.getRDateTime().getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = 作成日時.getRDateTime().getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.printTimeStamp = 作成日.concat(RString.HALF_SPACE).concat(作成時);
        source.shichosonCode = entity.get市町村コード();
        source.shichosonName = entity.get市町村名称();
        source.title = 宛名シール;
        this.posIndex = 1;
        for (DBZ100001AtenaSealEntity e : entity.getEntityList()) {
            setTemp(e);
            editBody(source);
            this.posIndex += 1;
        }

    }

    private void editBody(DBZ100001AtenaSealSource source) {
        try {
            this.method = this.cls.getMethod(getMethodName(0), ShikibetsuCode.class);
            this.method.invoke(source, this.tmp0);
            this.method = this.cls.getMethod(getMethodName(NUM_1), RString.class);
            this.method.invoke(source, this.tmp1);
            this.method = this.cls.getMethod(getMethodName(NUM_2), RString.class);
            this.method.invoke(source, this.tmp2);
            this.method = this.cls.getMethod(getMethodName(NUM_3), RString.class);
            this.method.invoke(source, this.tmp3);
            this.method = this.cls.getMethod(getMethodName(NUM_4), RString.class);
            this.method.invoke(source, this.tmp4);
            this.method = this.cls.getMethod(getMethodName(NUM_5), RString.class);
            this.method.invoke(source, this.tmp5);
            this.method = this.cls.getMethod(getMethodName(NUM_6), RString.class);
            this.method.invoke(source, this.tmp6);
            this.method = this.cls.getMethod(getMethodName(NUM_7), RString.class);
            this.method.invoke(source, this.tmp7);
            this.method = this.cls.getMethod(getMethodName(NUM_8), RString.class);
            this.method.invoke(source, this.tmp8);
            this.method = this.cls.getMethod(getMethodName(NUM_9), RString.class);
            this.method.invoke(source, this.tmp9);
            this.method = this.cls.getMethod(getMethodName(NUM_10), RString.class);
            this.method.invoke(source, this.tmp10);
            this.method = this.cls.getMethod(getMethodName(NUM_11), RString.class);
            this.method.invoke(source, this.tmp11);
            this.method = this.cls.getMethod(getMethodName(NUM_12), RString.class);
            this.method.invoke(source, this.tmp12);
            this.method = this.cls.getMethod(getMethodName(NUM_13), RString.class);
            this.method.invoke(source, this.tmp13);
            this.method = this.cls.getMethod(getMethodName(NUM_14), RString.class);
            this.method.invoke(source, this.tmp14);
            this.method = this.cls.getMethod(getMethodName(NUM_15), RString.class);
            this.method.invoke(source, this.tmp15);
            this.method = this.cls.getMethod(getMethodName(NUM_16), RString.class);
            this.method.invoke(source, this.tmp16);
            this.method = this.cls.getMethod(getMethodName(NUM_17), RString.class);
            this.method.invoke(source, this.tmp17);
            this.method = this.cls.getMethod(getMethodName(NUM_18), RString.class);
            this.method.invoke(source, this.tmp18);
            this.method = this.cls.getMethod(getMethodName(NUM_19), RString.class);
            this.method.invoke(source, this.tmp19);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(AtenaSealEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        source.setIndex(source.getIndex() + 1);
    }

    private String getMethodName(int index) {
        return SET.concat(MethodName.getName(index)).concat(getValueOfIndex(getIndex2(index))).toString();
    }

    private int getIndex2(int index) {
        if (index <= NUM_5) {

            return this.posIndex - 1;
        }
        return this.posIndex * NUM_2 - index % NUM_2;
    }

    private String getValueOfIndex(int index) {
        if (index == NUM_0) {

            return RString.EMPTY.toString();
        }
        return String.valueOf(index);
    }

    private static enum MethodName {

        未定義(AtenaSealEditor.EMPTY, Integer.valueOf(-1)),
        shikibetsuCode(new RString("ShikibetsuCode"), Integer.valueOf(0)),
        yubinNo(new RString("YubinNo"), Integer.valueOf(1)),
        gyoseiku(new RString("Gyoseiku"), Integer.valueOf(2)),
        jushoText(new RString("JushoText"), Integer.valueOf(3)),
        customerBarCode(new RString("CustomerBarCode"), Integer.valueOf(5)),
        katagakiSmall(new RString("KatagakiSmall"), Integer.valueOf(6)),
        katagakiSmall1(new RString("KatagakiSmall"), Integer.valueOf(7)),
        dainoKubunMei(new RString("DainoKubunMei"), Integer.valueOf(4)),
        shimeiSmall(new RString("ShimeiSmall"), Integer.valueOf(8)),
        shimeiSmall1(new RString("ShimeiSmall"), Integer.valueOf(9)),
        samabunShimeiSmall(new RString("SamabunShimeiSmall"), Integer.valueOf(10)),
        samabunShimeiSmall1(new RString("SamabunShimeiSmall"), Integer.valueOf(11)),
        kakkoLeft(new RString("KakkoLeft"), Integer.valueOf(12)),
        kakkoLeft1(new RString("KakkoLeft"), Integer.valueOf(13)),
        meishoFuyo(new RString("MeishoFuyo"), Integer.valueOf(14)),
        meishoFuyo1(new RString("MeishoFuyo"), Integer.valueOf(15)),
        samaBun(new RString("SamaBun"), Integer.valueOf(16)),
        samaBun1(new RString("SamaBun"), Integer.valueOf(17)),
        kakkoRight(new RString("KakkoRight"), Integer.valueOf(18)),
        kakkoRight1(new RString("KakkoRight"), Integer.valueOf(19));

        private final RString name;
        private final Integer index;

        private MethodName(RString name, Integer index) {
            this.name = name;
            this.index = index;
        }

        Integer code() {
            return this.index;
        }

        static RString getName(int index) {
            return toValue(Integer.valueOf(index)).name;
        }

        static MethodName toValue(Integer index) {
            if (index == null) {
                return 未定義;
            }
            for (MethodName target : values()) {
                if (target.code().equals(index)) {
                    return target;
                }
            }
            return 未定義;
        }
    }

    private void setTemp(DBZ100001AtenaSealEntity entity) {
        this.tmp0 = entity.get識別コード();
        this.tmp1 = entity.get郵便番号();
        this.tmp2 = entity.get行政区();
        this.tmp3 = entity.get住所TXT();
        this.tmp6 = entity.get方書2();
        this.tmp7 = entity.get方書1();
        this.tmp4 = entity.get代納区分名称();
        this.tmp8 = entity.get氏名2();
        this.tmp9 = entity.get氏名1();
        this.tmp10 = entity.get様分氏名2();
        this.tmp11 = entity.get様分氏名1();
        this.tmp12 = entity.get左括号2();
        this.tmp13 = entity.get左括号1();
        this.tmp14 = entity.get名称付与2();
        this.tmp15 = entity.get名称付与1();
        this.tmp16 = entity.get様分2();
        this.tmp17 = entity.get様分1();
        this.tmp18 = entity.get右括号2();
        this.tmp19 = entity.get右括号1();
        this.tmp5 = entity.getバーコード住所();
    }

}
