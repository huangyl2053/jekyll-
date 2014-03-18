/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.Iterator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 受領委任事業者リストのクラスです。
 *
 * @author N3317 塚田 萌
 */
public class JuryoininJigyoshaList implements Iterable {

    private final List<JuryoininJigyosha> 受領委任事業者List;

    /**
     * コンストラクタです。
     *
     * @param 受領委任事業者List 受領委任事業者List
     */
    public JuryoininJigyoshaList(List<JuryoininJigyosha> 受領委任事業者List) {
        this.受領委任事業者List = requireNonNull(受領委任事業者List,
                Messages.E00001.replace("受領委任事業者List").getMessage());
    }

    /**
     * 受領委任事業者Listを返します。
     *
     * @return 受領委任事業者List
     */
    public List<JuryoininJigyosha> get受領委任事業者List() {
        return 受領委任事業者List;
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
    public Iterator iterator() {
        return get受領委任事業者List().iterator();
    }
}
