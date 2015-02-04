/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.model.relate.shikakuido;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.shisetsunyutaisho.ShisetsuNyutaishoModel;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import static java.util.Objects.requireNonNull;

/**
 * 住所地特例異動登録の際、1トランザクションでデータを保存する際に使用するModelです。
 *
 * @author n8178 城間篤人
 */
public class JushochiTokureiModel {

    private final List<HihokenshaDaichoModel> hihoDaichoData;
    private final List<ShisetsuNyutaishoModel> shisetsuNyutaishoData;

    /**
     * コンストラクタです。
     *
     * @param hihoDaichoData 被保険者台帳ModelList
     * @param shisetsuNyutaishoData 施設入退所ModelList
     */
    public JushochiTokureiModel(List<HihokenshaDaichoModel> hihoDaichoData, List<ShisetsuNyutaishoModel> shisetsuNyutaishoData) {
        requireNonNull(hihoDaichoData, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者台帳ModelList", getClass().getName()));
        requireNonNull(shisetsuNyutaishoData, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("施設入退所ModelList", getClass().getName()));

        this.hihoDaichoData = hihoDaichoData;
        this.shisetsuNyutaishoData = shisetsuNyutaishoData;
    }

    /**
     * 被保険者台帳ModelListを返します。
     *
     * @return 被保険者台帳ModelList
     */
    public List<HihokenshaDaichoModel> getHihoDaichoData() {
        return hihoDaichoData;
    }

    /**
     * 施設入退所ModelListを返します。
     *
     * @return 施設入退所ModelList
     */
    public List<ShisetsuNyutaishoModel> getShisetsuNyutaishoData() {
        return shisetsuNyutaishoData;
    }

}
