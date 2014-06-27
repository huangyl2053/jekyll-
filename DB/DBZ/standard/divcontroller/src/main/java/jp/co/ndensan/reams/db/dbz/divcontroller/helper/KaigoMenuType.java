/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.helper;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * フローIDと親Divに表示するタイトルを対応付けた列挙型です。
 *
 * @author n8178 城間篤人
 */
public enum KaigoMenuType {

    被保険者照会("DBAWF11001", "被保険者照会"),
    転入により取得("DBAWF21001", "転入により取得"),
    届出により適用("DBAWF25001", "届出により適用"),
    施設入所により適用("DBAWF31001", "施設入所により適用"),
    除外施設入所により適用("DBAWF32001", "除外施設入所により適用"),
    施設入退所異動("DBAWF41001", "施設入退所異動");
    private final RString flowId;
    private final RString title;

    private KaigoMenuType(String flowId, String title) {
        this.flowId = new RString(flowId);
        this.title = new RString(title);
    }

    /**
     * フローIDを返します。
     *
     * @return フローID
     */
    public RString getFlowId() {
        return flowId;
    }

    /**
     * 親Divに表示するタイトルを返します。
     *
     * @return タイトル
     */
    public RString getTitle() {
        return title;
    }

    /**
     * 指定したフローIDに対応する要素を返します。
     *
     * @param flowId フローIDを表すRString
     * @return フローIDに対応するKaigoMenuType
     */
    public static RString getRootTitle(RString flowId) {
        for (KaigoMenuType menuType : values()) {
            if (menuType.getFlowId().equals(flowId)) {
                return menuType.getTitle();
            }
        }
        return RString.EMPTY;
    }

    /**
     * 指定したフローIDに対応する要素を返します。
     *
     * @param flowId フローIDを表すString
     * @return フローIDに対応するKaigoMenuType
     */
    public static RString getRootTitle(String flowId) {
        return getRootTitle(new RString(flowId));
    }

}
