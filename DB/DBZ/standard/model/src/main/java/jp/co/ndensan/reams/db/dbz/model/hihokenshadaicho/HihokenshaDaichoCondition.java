/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho;

import jp.co.ndensan.reams.db.dbz.definition.util.function.IPredicate;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoriTimestamp;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 被保険者台帳Modelの{@link jp.co.ndensan.reams.db.dbz.model.util.itemlist.IItemList}から、
 * 要素を一意に取得するための条件を定義します。<br/>
 * 被保険者台帳Modelのキー要素である、市町村コード・被保険者番号・処理日時が一致した場合に、一意に特定したと判断します。
 *
 * @author n8178 城間篤人
 */
public class HihokenshaDaichoCondition implements IPredicate<HihokenshaDaichoModel> {

    private final HihokenshaDaichoModel conditionModel;

    /**
     * コンストラクタです。引数から、検索条件となるModelを受け取ります。
     *
     * @param conditionModel IItemListを検索する際の条件となる被保険者台帳Model
     */
    public HihokenshaDaichoCondition(HihokenshaDaichoModel conditionModel) {
        requireNonNull(conditionModel, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("検索条件に使用する被保険者台帳Model", getClass().getName()));
        this.conditionModel = conditionModel;
    }

    /**
     * コンストラクタです。引数から、被保険者台帳情報のキー項目を受け取ります。
     *
     * @param shichosonCode 市町村コード
     * @param hihokenshaNo 被保険者番号
     * @param shoriTimestamp 処理日時
     */
    public HihokenshaDaichoCondition(LasdecCode shichosonCode, HihokenshaNo hihokenshaNo, ShoriTimestamp shoriTimestamp) {
        requireNonNull(shichosonCode, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("市町村コード", getClass().getName()));
        requireNonNull(hihokenshaNo, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者番号", getClass().getName()));
        requireNonNull(shoriTimestamp, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("処理日時", getClass().getName()));

        this.conditionModel = new HihokenshaDaichoModel();
        conditionModel.set市町村コード(shichosonCode);
        conditionModel.set被保険者番号(hihokenshaNo);
        conditionModel.set処理日時(shoriTimestamp);
    }

    @Override
    public boolean evaluate(HihokenshaDaichoModel target) {
        return conditionModel.getEntity().equalsPrimaryKeys(target.getEntity());
    }

}
