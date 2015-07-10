/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.FukaSearchMenuGroup.照会系;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.FukaSearchMenuGroup.賦課照会系;

// TODO N8156 宮本 康 メニューは要精査
/**
 * 賦課対象者検索用のメニューを定義した列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum FukaSearchMenu {

    /**
     * メニューが「賦課照会」であることを表します。
     */
    賦課照会("DBBMN11001", 照会系, 賦課照会系);

    private final RString code;
    private final Set<FukaSearchMenuGroup> groups;

    private FukaSearchMenu(String code, FukaSearchMenuGroup... items) {
        this.code = new RString(code);
        Set<FukaSearchMenuGroup> set = new HashSet<>();
        Collections.addAll(set, items);
        this.groups = Collections.unmodifiableSet(set);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString code() {
        return code;
    }

    /**
     * 指定したメニューグループかどうか判定します。
     *
     * @param group メニューグループ
     * @return 指定したメニューグループの場合はtrue、それ以外の場合はfalseを返します。
     */
    public boolean is(FukaSearchMenuGroup group) {
        return this.groups.contains(group);
    }

    /**
     * コードに対応する列挙型を返します。
     *
     * @param code コード
     * @return 列挙型
     * @throws IllegalArgumentException 対応する列挙型がない場合
     */
    public static FukaSearchMenu toValue(RString code) throws IllegalArgumentException {
        for (FukaSearchMenu data : values()) {
            if (data.code().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(" 賦課対象者検索用のメニュー"));
    }
}
