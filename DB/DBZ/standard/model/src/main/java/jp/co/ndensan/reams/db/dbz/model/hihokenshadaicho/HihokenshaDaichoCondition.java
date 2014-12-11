/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho;

import jp.co.ndensan.reams.db.dbz.model.util.function.ICondition;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import static java.util.Objects.requireNonNull;

/**
 * 被保険者台帳Modelの{@link jp.co.ndensan.reams.db.dbz.model.util.itemlist.IItemList}から、
 * 要素を一意に取得するための条件を定義します。<br/>
 * 被保険者台帳Modelのキー要素である、市町村コード・被保険者番号・処理日時が一致した場合に、一意に特定したと判断します。
 *
 * @author n8178 城間篤人
 */
public class HihokenshaDaichoCondition implements ICondition<HihokenshaDaichoModel> {

    private final HihokenshaDaichoModel conditionModel;

    /**
     * コンストラクタです。
     *
     * @param conditionModel IItemListを検索する際の条件となる被保険者台帳Model
     */
    public HihokenshaDaichoCondition(HihokenshaDaichoModel conditionModel) {
        requireNonNull(conditionModel, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("検索条件に使用する被保険者台帳Model", getClass().getName()));
        this.conditionModel = conditionModel;
    }

    @Override
    public boolean check(HihokenshaDaichoModel targetModel) {
        return conditionModel.getEntity().equalsPrimaryKeys(targetModel.getEntity());
    }

}
