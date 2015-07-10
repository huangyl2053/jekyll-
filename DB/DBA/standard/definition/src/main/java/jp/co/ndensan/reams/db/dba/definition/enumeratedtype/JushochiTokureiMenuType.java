/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * メニューIDによって住所地特例の処理を分岐させる際に使用する項目です。
 *
 * @author n8178 城間篤人
 */
public enum JushochiTokureiMenuType {

    //TODO n8178 城間篤人 ShoriTypeを実際に使用するか不明。使用しなかった場合削除することを忘れない...
    DBAMN25001_届出により適用("DBAMN25001", ShoriType.適用前),
    DBAMN25002_届出により解除("DBAMN25002", ShoriType.適用中),
    DBAMN25003_届出により施設変更("DBAMN25003", ShoriType.適用中),
    DBAMN52002_合併前の住所地特例措置解除("DBAMN52002", ShoriType.適用中),
    DBAMN61002_転入転出保留対象者管理("DBAMN61002", ShoriType.適用前),
    その他("NONE", ShoriType.その他);

    private final RString menuId;
    private final ShoriType shoriType;

    private enum ShoriType {

        適用前, 適用中, その他;
    }

    private JushochiTokureiMenuType(String menuId, ShoriType shoriType) {
        this.menuId = new RString(menuId);
        this.shoriType = shoriType;
    }

    /**
     * メニューIDを返します。
     *
     * @return メニューID
     */
    public RString getMenuId() {
        return menuId;
    }

    /**
     * 住所地特例未適用の対象者に対して行うことができる処理であることを示します。
     *
     * @return 未適用の対象者に対して可能な処理ならtrue
     */
    public boolean is適用前の処理() {
        return shoriType == ShoriType.適用前;
    }

    /**
     * 住所地特例が適用中の対象者に対して行うことができる処理であることを示します。
     *
     * @return 適用中の対象者に対して可能な処理であるならtrue
     */
    public boolean is適用中の処理() {
        return shoriType == ShoriType.適用中;
    }

    /**
     * 引数からメニューIDを表す文字列を受け取り、それに対応する項目を返します。<br/>
     * 合致する項目が存在しない場合、その他が返ります。
     *
     * @param menuId メニューIDを表す文字列
     * @return 引数に対応するJushochiTokureiMenuType
     */
    public static JushochiTokureiMenuType toValue(RString menuId) {
        for (JushochiTokureiMenuType type : values()) {
            if (type.menuId.equals(menuId)) {
                return type;
            }
        }
        return その他;
    }

}
