/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji;

/**
 * 対象世帯員クラスTempに更新2Entityクラスです
 *
 * @reamsid_L DBC-4630-050 jiangwenkai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class UpdTaishoSeitaiyinTemp2Entity {

    private DbT3100Entity 事業対象者;
    private TaishoSetaiinEntity 対象世帯員;
}
