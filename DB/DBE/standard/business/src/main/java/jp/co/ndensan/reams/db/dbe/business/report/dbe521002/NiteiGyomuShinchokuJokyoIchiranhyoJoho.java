/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.business.report.dbe521002;

import java.util.List;
import lombok.Getter;

/**
 *
 * 要介護認定業務進捗状況一覧表作成_帳票クラスパラメータクラスです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NiteiGyomuShinchokuJokyoIchiranhyoJoho {
    
    private final List<NiteiGyomuShinchokuJokyoIchiranhyoBodyItem> bodyItem;
    
    /**
     * コンストラクタを作成します。
     * @param bodyItem 要介護認定業務進捗状況一覧表リスト一覧表情報
     */
    public NiteiGyomuShinchokuJokyoIchiranhyoJoho(List<NiteiGyomuShinchokuJokyoIchiranhyoBodyItem> bodyItem) {
        this.bodyItem = bodyItem;
    }
    
}
