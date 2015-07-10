/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.Iterator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.definition.valueobject.KeiyakuNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;

/**
 * 受領委任事業者リストのクラスです。
 *
 * @author N3317 塚田 萌
 */
public class JuryoininJigyoshaList implements Iterable<JuryoininJigyosha> {

    private final List<JuryoininJigyosha> 受領委任事業者List;

    /**
     * コンストラクタです。
     *
     * @param 受領委任事業者List 受領委任事業者List
     */
    public JuryoininJigyoshaList(List<JuryoininJigyosha> 受領委任事業者List) {
        this.受領委任事業者List = requireNonNull(受領委任事業者List,
                UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任事業者List"));
    }

    /**
     * 受領委任事業者リストから指定した契約番号に該当する情報を返します。
     *
     * @param 契約番号 契約番号
     * @return 契約番号に該当する受領委任事業者
     * @throws IllegalArgumentException 存在しない対象を指定した時
     */
    public JuryoininJigyosha get受領委任事業者(KeiyakuNo 契約番号) throws IllegalArgumentException {
        for (JuryoininJigyosha 受領委任事業者 : 受領委任事業者List) {
            if (is契約番号一致(受領委任事業者, 契約番号)) {
                return 受領委任事業者;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する受領委任事業者").evaluate());
    }

    private boolean is契約番号一致(JuryoininJigyosha 受領委任事業者, KeiyakuNo 契約番号) {
        return 受領委任事業者.get契約番号().equals(契約番号);
    }

    /**
     * 受領委任事業者ListがEMPTYかどうか判定します。
     *
     * @return EMPTYの場合にtrueを返します。
     */
    public boolean isEmpty() {
        return 受領委任事業者List.isEmpty();
    }

    /**
     * 受領委任事業者Listの要素数を返します。
     *
     * @return 受領委任事業者Listの要素数
     */
    public int size() {
        return 受領委任事業者List.size();
    }

    @Override
    public Iterator<JuryoininJigyosha> iterator() {
        return 受領委任事業者List.iterator();
    }
}
