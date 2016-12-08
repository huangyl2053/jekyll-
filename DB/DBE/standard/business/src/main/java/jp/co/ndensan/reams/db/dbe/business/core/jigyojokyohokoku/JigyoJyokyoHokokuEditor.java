/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.jigyojokyohokoku;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.JigyoJyokyoHokokuEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定事業状況報告の情報です。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class JigyoJyokyoHokokuEditor {

    private static final RString 第1号保険者 = new RString("0");
    private static final RString 歳65以上75未満 = new RString("1");
    private static final RString 歳75以上 = new RString("2");
    private static final RString 第2号被保険者 = new RString("3");
    private static final RString コード_非該当 = new RString("01");
    private static final RString コード_要支援1 = new RString("12");
    private static final RString コード_要支援2 = new RString("13");
    private static final RString コード_要介護1 = new RString("21");
    private static final RString コード_要介護2 = new RString("22");
    private static final RString コード_要介護3 = new RString("23");
    private static final RString コード_要介護4 = new RString("24");
    private static final RString コード_要介護5 = new RString("25");
    private final JigyoJyokyoHokokuEntity jigyoJyokyo;
    private final JigyoJokyoHokoku jigyoJokyoHokoku;

    /**
     * コンストラクタです。
     *
     * @param jigyoJyokyo JigyoJyokyoHokokuEntity
     * @param jigyoJokyoHokoku JigyoJokyoHokoku
     */
    public JigyoJyokyoHokokuEditor(JigyoJyokyoHokokuEntity jigyoJyokyo, JigyoJokyoHokoku jigyoJokyoHokoku) {
        this.jigyoJyokyo = jigyoJyokyo;
        this.jigyoJokyoHokoku = jigyoJokyoHokoku;
    }

    /**
     * 編集後事業状況報告情報を取得します。
     */
    public void get編集後事業状況報告情報() {
        jigyoJokyoHokoku.set事業対象年月(jigyoJyokyo.getNijiHanteiYM().toDateString());
        jigyoJokyoHokoku.set保険者番号(jigyoJyokyo.getShoKisaiHokenshaNo());
        if (!RString.isNullOrEmpty(jigyoJyokyo.getShichosonMeisho())) {
            jigyoJokyoHokoku.set保険者名(jigyoJyokyo.getShichosonMeisho());
        } else {
            jigyoJokyoHokoku.set保険者名(new RString("全市町村"));
        }
        if (第1号保険者.equals(jigyoJyokyo.getHihokenshaKubunCode())) {
            set第1号被保険者(jigyoJyokyo);
        } else if (歳65以上75未満.equals(jigyoJyokyo.getHihokenshaKubunCode())) {
            set歳65以上75歳未満(jigyoJyokyo);
        } else if (歳75以上.equals(jigyoJyokyo.getHihokenshaKubunCode())) {
            set歳75歳以上(jigyoJyokyo);
        } else if (第2号被保険者.equals(jigyoJyokyo.getHihokenshaKubunCode())) {
            set第2号被保険者(jigyoJyokyo);
        }
    }

    /**
     * 事業状況報告合計情報を取得します。
     */
    public void set総数() {
        jigyoJokyoHokoku.set総数_非該当(get総数非該当());
        jigyoJokyoHokoku.set総数_支援1(get総数支援1());
        jigyoJokyoHokoku.set総数_支援2(get総数支援2());
        jigyoJokyoHokoku.set総数_要介護1(get総数要介護1());
        jigyoJokyoHokoku.set総数_要介護2(get総数要介護2());
        jigyoJokyoHokoku.set総数_要介護3(get総数要介護3());
        jigyoJokyoHokoku.set総数_要介護4(get総数要介護4());
        jigyoJokyoHokoku.set総数_要介護5(get総数要介護5());
        jigyoJokyoHokoku.set総数_合計(get総数合計());
    }

    private void set第1号被保険者(JigyoJyokyoHokokuEntity jigyoJyokyo) {
        jigyoJokyoHokoku.set第1号被保険者_非該当(new RString(getIntValue(jigyoJokyoHokoku.get第1号被保険者_非該当())
                + get被保険者件数(jigyoJyokyo, 第1号保険者, コード_非該当)));
        jigyoJokyoHokoku.set第1号被保険者_支援1(new RString(getIntValue(jigyoJokyoHokoku.get第1号被保険者_支援1())
                + get被保険者件数(jigyoJyokyo, 第1号保険者, コード_要支援1)));
        jigyoJokyoHokoku.set第1号被保険者_支援2(new RString(getIntValue(jigyoJokyoHokoku.get第1号被保険者_支援2())
                + get被保険者件数(jigyoJyokyo, 第1号保険者, コード_要支援2)));
        jigyoJokyoHokoku.set第1号被保険者_要介護1(new RString(getIntValue(jigyoJokyoHokoku.get第1号被保険者_要介護1())
                + get被保険者件数(jigyoJyokyo, 第1号保険者, コード_要介護1)));
        jigyoJokyoHokoku.set第1号被保険者_要介護2(new RString(getIntValue(jigyoJokyoHokoku.get第1号被保険者_要介護2())
                + get被保険者件数(jigyoJyokyo, 第1号保険者, コード_要介護2)));
        jigyoJokyoHokoku.set第1号被保険者_要介護3(new RString(getIntValue(jigyoJokyoHokoku.get第1号被保険者_要介護3())
                + get被保険者件数(jigyoJyokyo, 第1号保険者, コード_要介護3)));
        jigyoJokyoHokoku.set第1号被保険者_要介護4(new RString(getIntValue(jigyoJokyoHokoku.get第1号被保険者_要介護4())
                + get被保険者件数(jigyoJyokyo, 第1号保険者, コード_要介護4)));
        jigyoJokyoHokoku.set第1号被保険者_要介護5(new RString(getIntValue(jigyoJokyoHokoku.get第1号被保険者_要介護5())
                + get被保険者件数(jigyoJyokyo, 第1号保険者, コード_要介護5)));
        jigyoJokyoHokoku.set第1号被保険者_合計(set第1号被保険者_合計());
    }

    private void set歳65以上75歳未満(JigyoJyokyoHokokuEntity jigyoJyokyo) {
        jigyoJokyoHokoku.set歳以上75歳未満_非該当(new RString(getIntValue(jigyoJokyoHokoku.get歳以上75歳未満_非該当())
                + get被保険者件数(jigyoJyokyo, 歳65以上75未満, コード_非該当)));
        jigyoJokyoHokoku.set歳以上75歳未満_支援1(new RString(getIntValue(jigyoJokyoHokoku.get歳以上75歳未満_支援1())
                + get被保険者件数(jigyoJyokyo, 歳65以上75未満, コード_要支援1)));
        jigyoJokyoHokoku.set歳以上75歳未満_支援2(new RString(getIntValue(jigyoJokyoHokoku.get歳以上75歳未満_支援2())
                + get被保険者件数(jigyoJyokyo, 歳65以上75未満, コード_要支援2)));
        jigyoJokyoHokoku.set歳以上75歳未満_要介護1(new RString(getIntValue(jigyoJokyoHokoku.get歳以上75歳未満_要介護1())
                + get被保険者件数(jigyoJyokyo, 歳65以上75未満, コード_要介護1)));
        jigyoJokyoHokoku.set歳以上75歳未満_要介護2(new RString(getIntValue(jigyoJokyoHokoku.get歳以上75歳未満_要介護2())
                + get被保険者件数(jigyoJyokyo, 歳65以上75未満, コード_要介護2)));
        jigyoJokyoHokoku.set歳以上75歳未満_要介護3(new RString(getIntValue(jigyoJokyoHokoku.get歳以上75歳未満_要介護3())
                + get被保険者件数(jigyoJyokyo, 歳65以上75未満, コード_要介護3)));
        jigyoJokyoHokoku.set歳以上75歳未満_要介護4(new RString(getIntValue(jigyoJokyoHokoku.get歳以上75歳未満_要介護4())
                + get被保険者件数(jigyoJyokyo, 歳65以上75未満, コード_要介護4)));
        jigyoJokyoHokoku.set歳以上75歳未満_要介護5(new RString(getIntValue(jigyoJokyoHokoku.get歳以上75歳未満_要介護5())
                + get被保険者件数(jigyoJyokyo, 歳65以上75未満, コード_要介護5)));
        jigyoJokyoHokoku.set歳以上75歳未満_合計(set歳以上75歳未満_合計());
    }

    private void set歳75歳以上(JigyoJyokyoHokokuEntity jigyoJyokyo) {
        jigyoJokyoHokoku.set歳75以上_非該当(new RString(getIntValue(jigyoJokyoHokoku.get歳75以上_非該当())
                + get被保険者件数(jigyoJyokyo, 歳75以上, コード_非該当)));
        jigyoJokyoHokoku.set歳75以上_支援1(new RString(getIntValue(jigyoJokyoHokoku.get歳75以上_支援1())
                + get被保険者件数(jigyoJyokyo, 歳75以上, コード_要支援1)));
        jigyoJokyoHokoku.set歳75以上_支援2(new RString(getIntValue(jigyoJokyoHokoku.get歳75以上_支援2())
                + get被保険者件数(jigyoJyokyo, 歳75以上, コード_要支援2)));
        jigyoJokyoHokoku.set歳75以上_要介護1(new RString(getIntValue(jigyoJokyoHokoku.get歳75以上_要介護1())
                + get被保険者件数(jigyoJyokyo, 歳75以上, コード_要介護1)));
        jigyoJokyoHokoku.set歳75以上_要介護2(new RString(getIntValue(jigyoJokyoHokoku.get歳75以上_要介護2())
                + get被保険者件数(jigyoJyokyo, 歳75以上, コード_要介護2)));
        jigyoJokyoHokoku.set歳75以上_要介護3(new RString(getIntValue(jigyoJokyoHokoku.get歳75以上_要介護3())
                + get被保険者件数(jigyoJyokyo, 歳75以上, コード_要介護3)));
        jigyoJokyoHokoku.set歳75以上_要介護4(new RString(getIntValue(jigyoJokyoHokoku.get歳75以上_要介護4())
                + get被保険者件数(jigyoJyokyo, 歳75以上, コード_要介護4)));
        jigyoJokyoHokoku.set歳75以上_要介護5(new RString(getIntValue(jigyoJokyoHokoku.get歳75以上_要介護5())
                + get被保険者件数(jigyoJyokyo, 歳75以上, コード_要介護5)));
        jigyoJokyoHokoku.set歳75以上_合計(set歳75以上_合計());
    }

    private void set第2号被保険者(JigyoJyokyoHokokuEntity jigyoJyokyo) {
        jigyoJokyoHokoku.set第2号被保険者_非該当(new RString(getIntValue(jigyoJokyoHokoku.get第2号被保険者_非該当())
                + get被保険者件数(jigyoJyokyo, 第2号被保険者, コード_非該当)));
        jigyoJokyoHokoku.set第2号被保険者_支援1(new RString(getIntValue(jigyoJokyoHokoku.get第2号被保険者_支援1())
                + get被保険者件数(jigyoJyokyo, 第2号被保険者, コード_要支援1)));
        jigyoJokyoHokoku.set第2号被保険者_支援2(new RString(getIntValue(jigyoJokyoHokoku.get第2号被保険者_支援2())
                + get被保険者件数(jigyoJyokyo, 第2号被保険者, コード_要支援2)));
        jigyoJokyoHokoku.set第2号被保険者_要介護1(new RString(getIntValue(jigyoJokyoHokoku.get第2号被保険者_要介護1())
                + get被保険者件数(jigyoJyokyo, 第2号被保険者, コード_要介護1)));
        jigyoJokyoHokoku.set第2号被保険者_要介護2(new RString(getIntValue(jigyoJokyoHokoku.get第2号被保険者_要介護2())
                + get被保険者件数(jigyoJyokyo, 第2号被保険者, コード_要介護2)));
        jigyoJokyoHokoku.set第2号被保険者_要介護3(new RString(getIntValue(jigyoJokyoHokoku.get第2号被保険者_要介護3())
                + get被保険者件数(jigyoJyokyo, 第2号被保険者, コード_要介護3)));
        jigyoJokyoHokoku.set第2号被保険者_要介護4(new RString(getIntValue(jigyoJokyoHokoku.get第2号被保険者_要介護4())
                + get被保険者件数(jigyoJyokyo, 第2号被保険者, コード_要介護4)));
        jigyoJokyoHokoku.set第2号被保険者_要介護5(new RString(getIntValue(jigyoJokyoHokoku.get第2号被保険者_要介護5())
                + get被保険者件数(jigyoJyokyo, 第2号被保険者, コード_要介護5)));
        jigyoJokyoHokoku.set第2号被保険者_合計(set第2号被保険者_合計());
    }

    private RString get総数非該当() {
        return new RString(getIntValue(jigyoJokyoHokoku.get第1号被保険者_非該当())
                + getIntValue(jigyoJokyoHokoku.get第2号被保険者_非該当()));
    }

    private RString get総数支援1() {
        return new RString(getIntValue(jigyoJokyoHokoku.get第1号被保険者_支援1())
                + getIntValue(jigyoJokyoHokoku.get第2号被保険者_支援1()));
    }

    private RString get総数支援2() {
        return new RString(getIntValue(jigyoJokyoHokoku.get第1号被保険者_支援2())
                + getIntValue(jigyoJokyoHokoku.get第2号被保険者_支援2()));
    }

    private RString get総数要介護1() {
        return new RString(getIntValue(jigyoJokyoHokoku.get第1号被保険者_要介護1())
                + getIntValue(jigyoJokyoHokoku.get第2号被保険者_要介護1()));
    }

    private RString get総数要介護2() {
        return new RString(getIntValue(jigyoJokyoHokoku.get第1号被保険者_要介護2())
                + getIntValue(jigyoJokyoHokoku.get第2号被保険者_要介護2()));
    }

    private RString get総数要介護3() {
        return new RString(getIntValue(jigyoJokyoHokoku.get第1号被保険者_要介護3())
                + getIntValue(jigyoJokyoHokoku.get第2号被保険者_要介護3()));
    }

    private RString get総数要介護4() {
        return new RString(getIntValue(jigyoJokyoHokoku.get第1号被保険者_要介護4())
                + getIntValue(jigyoJokyoHokoku.get第2号被保険者_要介護4()));
    }

    private RString get総数要介護5() {
        return new RString(getIntValue(jigyoJokyoHokoku.get第1号被保険者_要介護5())
                + getIntValue(jigyoJokyoHokoku.get第2号被保険者_要介護5()));
    }
    
    private RString set第1号被保険者_合計() {
        return new RString(getIntValue(jigyoJokyoHokoku.get第1号被保険者_非該当())
        + getIntValue(jigyoJokyoHokoku.get第1号被保険者_支援1())
        + getIntValue(jigyoJokyoHokoku.get第1号被保険者_支援2())
        + getIntValue(jigyoJokyoHokoku.get第1号被保険者_要介護1())
        + getIntValue(jigyoJokyoHokoku.get第1号被保険者_要介護2())
        + getIntValue(jigyoJokyoHokoku.get第1号被保険者_要介護3())
        + getIntValue(jigyoJokyoHokoku.get第1号被保険者_要介護4())
        + getIntValue(jigyoJokyoHokoku.get第1号被保険者_要介護5()));
    }
    
    private RString set歳以上75歳未満_合計() {
        return new RString(getIntValue(jigyoJokyoHokoku.get歳以上75歳未満_非該当())
        + getIntValue(jigyoJokyoHokoku.get歳以上75歳未満_支援1())
        + getIntValue(jigyoJokyoHokoku.get歳以上75歳未満_支援2())
        + getIntValue(jigyoJokyoHokoku.get歳以上75歳未満_要介護1())
        + getIntValue(jigyoJokyoHokoku.get歳以上75歳未満_要介護2())
        + getIntValue(jigyoJokyoHokoku.get歳以上75歳未満_要介護3())
        + getIntValue(jigyoJokyoHokoku.get歳以上75歳未満_要介護4())
        + getIntValue(jigyoJokyoHokoku.get歳以上75歳未満_要介護5()));
    }
    
    private RString set歳75以上_合計() {
        return new RString(getIntValue(jigyoJokyoHokoku.get歳75以上_非該当())
        + getIntValue(jigyoJokyoHokoku.get歳75以上_支援1())
        + getIntValue(jigyoJokyoHokoku.get歳75以上_支援2())
        + getIntValue(jigyoJokyoHokoku.get歳75以上_要介護1())
        + getIntValue(jigyoJokyoHokoku.get歳75以上_要介護2())
        + getIntValue(jigyoJokyoHokoku.get歳75以上_要介護3())
        + getIntValue(jigyoJokyoHokoku.get歳75以上_要介護4())
        + getIntValue(jigyoJokyoHokoku.get歳75以上_要介護5()));
    }
    
    private RString set第2号被保険者_合計() {
        return new RString(getIntValue(jigyoJokyoHokoku.get第2号被保険者_非該当())
        + getIntValue(jigyoJokyoHokoku.get第2号被保険者_支援1())
        + getIntValue(jigyoJokyoHokoku.get第2号被保険者_支援2())
        + getIntValue(jigyoJokyoHokoku.get第2号被保険者_要介護1())
        + getIntValue(jigyoJokyoHokoku.get第2号被保険者_要介護2())
        + getIntValue(jigyoJokyoHokoku.get第2号被保険者_要介護3())
        + getIntValue(jigyoJokyoHokoku.get第2号被保険者_要介護4())
        + getIntValue(jigyoJokyoHokoku.get第2号被保険者_要介護5()));
    }
    
    private RString get総数合計() {
        return new RString(getIntValue(jigyoJokyoHokoku.get総数_非該当())
        + getIntValue(jigyoJokyoHokoku.get総数_支援1())
        + getIntValue(jigyoJokyoHokoku.get総数_支援2())
        + getIntValue(jigyoJokyoHokoku.get総数_要介護1())
        + getIntValue(jigyoJokyoHokoku.get総数_要介護2())
        + getIntValue(jigyoJokyoHokoku.get総数_要介護3())
        + getIntValue(jigyoJokyoHokoku.get総数_要介護4())
        + getIntValue(jigyoJokyoHokoku.get総数_要介護5()));
    }
    

    private int get被保険者件数(JigyoJyokyoHokokuEntity jigyoJyokyo, RString 被保険者区分, RString 要介護状態区分) {
        if (要介護状態区分.equals(jigyoJyokyo.getNijiHanteiYokaigoJotaiKubunCode().value())
                && 被保険者区分.equals(jigyoJyokyo.getHihokenshaKubunCode())) {
            return jigyoJyokyo.getCountHokensha();
        }
        return 0;
    }

    private int getIntValue(RString 被保険者数) {
        if (RString.isNullOrEmpty(被保険者数)) {
            return 0;
        }
        return Integer.parseInt(被保険者数.toString());
    }
}
