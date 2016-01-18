/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.configkeys;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * コンフィグ名称(DBC)を表す列挙型です。
 */
public enum ConfigNameDBC {

    /**
     * 第1段階_高額介護サービス費支給_201504以降_自己負担上限月額
     */
    第1段階_高額介護サービス費支給_201504以降_自己負担上限月額("第1段階_高額介護サービス費支給_201504以降_自己負担上限月額"),
    /**
     * 第1段階_高額介護サービス費支給_自己負担上限月額
     */
    第1段階_高額介護サービス費支給_自己負担上限月額("第1段階_高額介護サービス費支給_自己負担上限月額"),
    /**
     * 第2段階_高額介護サービス費支給_201504以降_自己負担上限月額
     */
    第2段階_高額介護サービス費支給_201504以降_自己負担上限月額("第2段階_高額介護サービス費支給_201504以降_自己負担上限月額"),
    /**
     * 第2段階_高額介護サービス費支給_自己負担上限月額
     */
    第2段階_高額介護サービス費支給_自己負担上限月額("第2段階_高額介護サービス費支給_自己負担上限月額"),
    /**
     * 第3段階_高額介護サービス費支給_201504以降_自己負担上限月額
     */
    第3段階_高額介護サービス費支給_201504以降_自己負担上限月額("第3段階_高額介護サービス費支給_201504以降_自己負担上限月額"),
    /**
     * 第3段階_高額介護サービス費支給_自己負担上限月額
     */
    第3段階_高額介護サービス費支給_自己負担上限月額("第3段階_高額介護サービス費支給_自己負担上限月額"),
    /**
     * 第4段階_高額介護サービス費支給_201504以降_自己負担上限月額
     */
    第4段階_高額介護サービス費支給_201504以降_自己負担上限月額("第4段階_高額介護サービス費支給_201504以降_自己負担上限月額");

    private final RString fullName;

    private ConfigNameDBC(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * コンフィグ名称(DBC)の名称を返します。
     *
     * @return コンフィグ名称(DBC)の名称
     */
    public RString get名称() {
        return fullName;
    }

}
