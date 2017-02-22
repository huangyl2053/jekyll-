/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書の帳票IDを表す列挙型です。
 */
public enum ShujiiIkenshoImageId {

    /**
     * 現行_表
     */
    現行_表("121", Teikei.定型),
    /**
     * 現行_裏
     */
    現行_裏("122", Teikei.定型),
    /**
     * 次期_表
     */
    次期_表("701", Teikei.定型),
    /**
     * 次期_裏
     */
    次期_裏("702", Teikei.定型),
    /**
     * 現行_定型外
     */
    現行_定型外("999", Teikei.定型外),
    /**
     * 次期_定型外_表
     */
    次期_定型外_表("777", Teikei.定型外),
    /**
     * 次期_定型外_裏
     */
    次期_定型外_裏("778", Teikei.定型外);

    private final RString chohyoID;
    private final Teikei teikei;

    private ShujiiIkenshoImageId(String chohyoID, Teikei teikei) {
        this.chohyoID = new RString(chohyoID);
        this.teikei = teikei;
    }

    /**
     * 帳票IDを返します。
     *
     * @return 帳票ID
     */
    public RString get帳票ID() {
        return this.chohyoID;
    }

    /**
     * 定型かどうかを返します。
     *
     * @return 定型の場合はtrue、定型外の場合はfalse
     */
    public boolean is定型() {
        return this.teikei == Teikei.定型;
    }

    /**
     * enumの名称を返します。
     *
     * @return enumの名称
     */
    public RString getName() {
        return new RString(this.teikei.toString());
    }

    /**
     * 引数に渡された帳票IDに対応するenumを返します。<br>
     * 対応する項目が存在しない場合、IllegalArgumentExceptionが発生します。
     *
     * @param chohyoID 帳票ID
     * @return 対応するenum
     * @throws IllegalArgumentException 引数に対応するenumが存在しないとき
     */
    public static ShujiiIkenshoImageId toValue(RString chohyoID) throws IllegalArgumentException {
        for (ShujiiIkenshoImageId item : values()) {
            if (item.get帳票ID().equals(chohyoID)) {
                return item;
            }
        }
        throw new IllegalArgumentException();
    }

}
