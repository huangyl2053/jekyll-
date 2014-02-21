/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosaBunrui;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosaKomoku;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ISentakushi;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査の調査項目情報を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaKomoku implements INinteichosaKomoku {

    private ChosaBunrui 調査分類;
    private RString 調査項目番号;
    private ChosaKomoku 調査項目;
    private RString 表示名称;
    private List<ISentakushi> 選択肢List;

    /**
     * インスタンスを生成します。
     *
     * @param 調査分類 調査分類
     * @param 調査項目番号 調査項目番号
     * @param 調査項目 調査項目
     * @param 表示名称 表示名称
     * @param 選択肢List 選択肢List
     */
    public NinteichosaKomoku(
            ChosaBunrui 調査分類, RString 調査項目番号, ChosaKomoku 調査項目, RString 表示名称, List<ISentakushi> 選択肢List) {
        this.調査分類 = requireNonNull(調査分類, Messages.E00001.replace("調査分類").getMessage());
        this.調査項目番号 = requireNonNull(調査項目番号, Messages.E00001.replace("調査項目番号").getMessage());
        this.調査項目 = requireNonNull(調査項目, Messages.E00001.replace("調査項目").getMessage());
        this.表示名称 = requireNonNull(表示名称, Messages.E00001.replace("表示名称").getMessage());
        this.選択肢List = requireNonNull(選択肢List, Messages.E00001.replace("選択肢").getMessage());
    }

    @Override
    public final ChosaBunrui get調査分類() {
        return 調査分類;
    }

    @Override
    public final RString get調査項目番号() {
        return 調査項目番号;
    }

    @Override
    public final ChosaKomoku get調査項目() {
        return 調査項目;
    }

    @Override
    public final RString get表示名称() {
        return 表示名称;
    }

    @Override
    public List<ISentakushi> get選択肢List() {
        return 選択肢List;
    }

    @Override
    public ISentakushi get選択肢(RString 調査結果コード) {
        for (ISentakushi data : 選択肢List) {
            if (data.getCode().equals(調査結果コード)) {
                return data;
            }
        }
        return null;
    }
}
