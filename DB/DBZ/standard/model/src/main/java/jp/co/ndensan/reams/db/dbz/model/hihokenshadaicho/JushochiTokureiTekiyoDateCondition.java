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
 * 住所地特例の適用日を条件として、{@link jp.co.ndensan.reams.db.dbz.model.util.itemlist.IItemList}から
 * 適用日に同じ値を持つ被保険者台帳Modelを取得します。
 *
 * @author n8178 城間篤人
 */
public class JushochiTokureiTekiyoDateCondition implements ICondition<HihokenshaDaichoModel> {

    private final HihokenshaDaichoModel conditionModel;

    /**
     * コンストラクタです。
     *
     * @param conditionModel 検索条件に使用するModel
     */
    public JushochiTokureiTekiyoDateCondition(HihokenshaDaichoModel conditionModel) {
        requireNonNull(conditionModel, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("検索条件に使用する被保険者台帳Model", getClass().getName()));
        this.conditionModel = conditionModel;
    }

    @Override
    public boolean check(HihokenshaDaichoModel targetModel) {
        return conditionModel.get適用年月日().equals(targetModel.get適用年月日());
    }

}
