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
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 賦課対象者検索用のメニューを定義した列挙型です。
 */
public enum FukaSearchMenu {

    /**
     * メニューが「賦課照会」であることを表します。
     */
    賦課照会("DBBMN11002", "DBBUC03200", 照会系),
    /**
     * メニューが「所得情報照会」であることを表します。
     */
    所得情報照会("DBBMN11003", "DBBUC11600", 所得照会系),
    /**
     * メニューが「各種通知書発行_個別」であることを表します。
     */
    各種通知書発行_個別("DBBMN12001", "DBBUC81100", 照会系),
    /**
     * メニューが「即時賦課更正」であることを表します。
     */
    即時賦課更正("DBBMN13001", "DBBUC81200", 更正計算系),
    /**
     * メニューが「徴収方法変更」であることを表します。
     */
    徴収方法変更("DBBMN13002", "DBBUC05400", 照会系),
    /**
     * メニューが「所得照会回答内容登録」であることを表します。
     */
    所得照会回答内容登録("DBBMN13003", "DBBUC11411", 所得照会系),
    /**
     * メニューが「所得照会票作成」であることを表します。
     */
    所得照会票作成("DBBMN51002", "DBBUC11500", 所得照会系),
    /**
     * メニューが「介護保険料減免」であることを表します。
     */
    介護保険料減免("DBBMN61001", "DBBUC31100", 照会系),
    /**
     * メニューが「介護保険料徴収猶予」であることを表します。
     */
    介護保険料徴収猶予("DBBMN62001", "DBBUC31500", 照会系),
    /**
     * メニューが「特徴対象者登録」であることを表します。
     */
    特徴対象者登録("DBBMN81001", "", 照会系),
    /**
     * メニューが「納付額お知らせ通知発行」であることを表します。
     */
    納付額お知らせ通知発行("DBBMN91001", "", 照会系),
    /**
     * 対応するメニューが存在しないことを表します。
     */
    EMPTY;

    private final RString aStanderdMenuId;
    private final RString anUIContainerId;
    private final Set<FukaSearchMenuGroup> groups;

    private FukaSearchMenu() {
        this.aStanderdMenuId = RString.EMPTY;
        this.anUIContainerId = RString.EMPTY;
        this.groups = Collections.emptySet();
    }

    private FukaSearchMenu(String standerdMenuId, String anUIContainerId, FukaSearchMenuGroup... items) {
        this.aStanderdMenuId = new RString(standerdMenuId);
        this.anUIContainerId = new RString(anUIContainerId);
        Set<FukaSearchMenuGroup> set = new HashSet<>();
        Collections.addAll(set, items);
        this.groups = Collections.unmodifiableSet(set);
    }

    /**
     * コードを返します。
     *
     * @return コード
     * @deprecated 用途に応じて{@link #standerdMenuId()}と{@link #uIContainerId()}を使い分けてください。
     */
    public RString code() {
        return aStanderdMenuId;
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
     * 標準版のメニューIDを返します。
     *
     * @return 標準版のメニューID
     */
    public RString standerdMenuId() {
        return this.aStanderdMenuId;
    }

    /**
     * UIコンテナIDを返します。
     *
     * @return UIコンテナID
     */
    public RString uIContainerId() {
        return this.anUIContainerId;
    }

    /**
     * UIコンテナIDまたは標準版メニューIDに対応する列挙型を返します。
     * <p/>
     * 通常は、UIコンテナIDを指定することが推奨されます。
     *
     * @param code UIコンテナIDまたは標準版メニューID
     * @return 列挙型
     * @throws IllegalArgumentException 対応する列挙型がない場合
     */
    public static FukaSearchMenu toValue(RString code) throws IllegalArgumentException {
        if (RString.isNullOrEmpty(code)) {
            return EMPTY;
        }

        for (FukaSearchMenu data : values()) {
            if (data.uIContainerId().equals(code) || data.standerdMenuId().equals(code)) {
                return data;
            }
        }
        return EMPTY;
    }
}
