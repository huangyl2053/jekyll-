/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;

/**
 * 合議体を表すクラスです。自身の詳細な情報と、自身を構成している合議体割当委員の情報で構成されています。
 *
 * @author n8178 城間篤人
 */
public class Gogitai {

    private final GogitaiJoho 合議体情報;
    private final GogitaiWariateIinList 割当委員List;

    /**
     * 合議体情報と、合議体に割り当てられた審査会委員の情報を元にインスタンスを生成します。
     *
     * @param 合議体情報 合議体情報
     * @param 割当委員List 割当委員List
     * @throws NullPointerException 引数のいずれかにnullが渡されたとき
     * @throws IllegalArgumentException 引数からわたされた合議体情報と、割当委員がそれぞれ持つ合議体情報が一致しないとき
     */
    public Gogitai(GogitaiJoho 合議体情報, GogitaiWariateIinList 割当委員List) throws NullPointerException, IllegalArgumentException {
        requireNonNull(合議体情報, Messages.E00003.replace("合議体情報", getClass().getName().toString()).getMessage());
        requireNonNull(割当委員List, Messages.E00003.replace("割当委員List", getClass().getName().toString()).getMessage());

        if (!is割当委員の合議体情報が一致(合議体情報, 割当委員List)) {
            throw new IllegalArgumentException(Messages.E00013.replace("割当委員Listが持つ合議体情報", "すべて同じ").getMessage());
        }

        this.合議体情報 = 合議体情報;
        this.割当委員List = 割当委員List;
    }

    private boolean is割当委員の合議体情報が一致(GogitaiJoho 合議体情報, GogitaiWariateIinList 割当委員List) {
        for (GogitaiWariateIin 割当委員 : 割当委員List) {
            if (!割当委員.get合議体情報().equals(合議体情報)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 合議体の情報を取得します。
     *
     * @return 合議体の情報
     */
    public GogitaiJoho get合議体情報() {
        return 合議体情報;
    }

    /**
     * 合議体に割り当てられている審査会委員のリストを取得します。
     *
     * @return 合議体割当員List
     */
    public GogitaiWariateIinList get割当委員List() {
        return 割当委員List;
    }
}
