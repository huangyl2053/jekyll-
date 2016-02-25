/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.FukaSearchMenuGroup.所得照会系;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.FukaSearchMenuGroup.更正計算系;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.FukaSearchMenuGroup.照会系;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
    賦課照会("DBBMN11001", 照会系),
    /**
     * メニューが「所得情報照会」であることを表します。
     */
    所得情報照会("DBBMN11003", 所得照会系),
    /**
     * メニューが「即時賦課更正」であることを表します。
     */
    即時賦課更正("DBBMN13001", 更正計算系),
    /**
     * メニューが「各種通知書発行_個別」であることを表します。
     */
    各種通知書発行_個別("DBBMN12001", 照会系);

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
