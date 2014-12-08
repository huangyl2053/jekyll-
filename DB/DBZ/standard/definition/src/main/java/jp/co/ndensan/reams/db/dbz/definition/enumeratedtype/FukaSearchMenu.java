/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RString;

// TODO N8156 宮本 康 メニュー、グループ分け等を精査する。
/**
 * 賦課対象者検索のメニュー判定で使用する列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum FukaSearchMenu {

    /**
     * メニューが「メニュー1」であることを表します。
     */
    メニュー1("menu1", true, true, true, true, true, true, true, true),
    /**
     * メニューが「メニュー2」であることを表します。
     */
    メニュー2("menu2", true, true, true, true, true, true, true, true),
    /**
     * メニューが「メニュー3」であることを表します。
     */
    メニュー3("menu3", true, true, true, true, true, true, true, true),
    /**
     * メニューが「メニュー4」であることを表します。
     */
    メニュー4("menu4", true, true, true, true, true, true, true, true),
    /**
     * メニューが「不明」であることを表します。
     */
    不明("unknown", false, false, false, false, false, false, false, false);

    private final RString code;
    private final Map<Integer, Boolean> map = new HashMap<>();

    private final int 照会 = 0;
    private final int 賦課照会 = 1;
    private final int 所得照会 = 2;
    private final int 更新 = 3;
    private final int 所得入力 = 4;
    private final int 更正計算 = 5;
    private final int 即時更正 = 6;
    private final int 通知書発行 = 7;

    private FukaSearchMenu(String code, boolean... args) {
        this.code = new RString(code);
        for (int index = 0; index < args.length; index++) {
            map.put(index, args[index]);
        }
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 照会かどうか判定します。
     *
     * @return 照会の場合はtrue、それ以外の場合はfalseを返します。
     */
    public boolean is照会() {
        return map.get(照会);
    }

    /**
     * 賦課照会かどうか判定します。
     *
     * @return 賦課照会の場合はtrue、それ以外の場合はfalseを返します。
     */
    public boolean is賦課照会() {
        return map.get(賦課照会);
    }

    /**
     * 所得照会かどうか判定します。
     *
     * @return 所得照会の場合はtrue、それ以外の場合はfalseを返します。
     */
    public boolean is所得照会() {
        return map.get(所得照会);
    }

    /**
     * 更新かどうか判定します。
     *
     * @return 更新の場合はtrue、それ以外の場合はfalseを返します。
     */
    public boolean is更新() {
        return map.get(更新);
    }

    /**
     * 所得入力かどうか判定します。
     *
     * @return 所得入力の場合はtrue、それ以外の場合はfalseを返します。
     */
    public boolean is所得入力() {
        return map.get(所得入力);
    }

    /**
     * 更正計算かどうか判定します。
     *
     * @return 更正計算の場合はtrue、それ以外の場合はfalseを返します。
     */
    public boolean is更正計算() {
        return map.get(更正計算);
    }

    /**
     * 即時更正かどうか判定します。
     *
     * @return 即時更正の場合はtrue、それ以外の場合はfalseを返します。
     */
    public boolean is即時更正() {
        return map.get(即時更正);
    }

    /**
     * 通知書発行かどうか判定します。
     *
     * @return 通知書発行の場合はtrue、それ以外の場合はfalseを返します。
     */
    public boolean is通知書発行() {
        return map.get(通知書発行);
    }

    /**
     * コードに対応する列挙型を返します。
     *
     * @param code コード
     * @return 列挙型
     */
    public static FukaSearchMenu toValue(RString code) {
        for (FukaSearchMenu data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        return 不明;
    }
}
