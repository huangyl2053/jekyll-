/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 預金種別の列挙型クラスです。
 *
 * @author n3508
 */
public enum YokinShubetsu {

    /**
     * 普通預金 <br />
     * コード : 1。
     */
    普通預金("1", "普通預金"),
    /**
     * 当座預金 <br />
     * コード : 2。
     */
    当座預金("2", "当座預金"),
    /**
     * 納税準備預金 <br />
     * コード : 3。
     */
    納税準備預金("3", "納税準備預金"),
    /**
     * 貯蓄預金 <br />
     * コード : 4。
     */
    貯蓄預金("4", "貯蓄預金"),
    /**
     * その他 <br />
     * コード : 9。
     */
    その他("9", "その他");

    private final RString Kubun;
    private final RString Name;

    private YokinShubetsu(String Kubun, String Name) {
        this.Kubun = new RString(Kubun);
        this.Name = new RString(Name);
    }

    /**
     * 預金種別を返します。
     *
     * @return 預金種別
     */
    public RString get預金種別() {
        return this.Kubun;
    }

    /**
     * 預金種別名称を返します。
     *
     * @return 預金種別名称
     */
    public RString get預金種別名称() {
        return this.Name;
    }

    /**
     * enumの名称を返します。
     *
     * @return enumの名称
     */
    public RString getName() {
        return this.getName();
    }

    /**
     * 引数に渡された預金種別に対応する預金種別を返します。<br>
     * 対応する項目が存在しない場合、IllegalArgumentExceptionが発生します。
     *
     * @param Kubun 預金種別
     * @return 預金種別
     * @throws IllegalArgumentException 引数に対応する預金種別が存在しないとき
     */
    public static YokinShubetsu toValueKubun(RString Kubun) throws IllegalArgumentException {
        for (YokinShubetsu item : values()) {
            if (item.get預金種別().equals(Kubun)) {
                return item;
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * 引数に渡された預金種別名称に対応する預金種別を返します。<br>
     * 対応する項目が存在しない場合、IllegalArgumentExceptionが発生します。
     *
     * @param Name 預金種別名称
     * @return 預金種別
     * @throws IllegalArgumentException 引数に対応する預金種別が存在しないとき
     */
    public static YokinShubetsu toValueName(RString Name) throws IllegalArgumentException {
        for (YokinShubetsu item : values()) {
            if (item.get預金種別名称().equals(Name)) {
                return item;
            }
        }
        throw new IllegalArgumentException();
    }
}
