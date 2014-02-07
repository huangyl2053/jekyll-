/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubunJiritsu;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査結果（基本調査自立度）の情報を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ChosaKekkaKihonJiritsu {

    private final ChosaKekkaKubunJiritsu.NinchishoNichijoSeikatsu 認知症高齢者の日常生活自立度;
    private final ChosaKekkaKubunJiritsu.ShogaiNichijoSeikatsu 障害高齢者の日常生活自立度;

    /**
     * インスタンスを生成します。
     *
     * @param 認知症高齢者の日常生活自立度 認知症高齢者の日常生活自立度
     * @param 障害高齢者の日常生活自立度 障害高齢者の日常生活自立度
     */
    public ChosaKekkaKihonJiritsu(
            ChosaKekkaKubunJiritsu.NinchishoNichijoSeikatsu 認知症高齢者の日常生活自立度,
            ChosaKekkaKubunJiritsu.ShogaiNichijoSeikatsu 障害高齢者の日常生活自立度) {
        this.認知症高齢者の日常生活自立度 =
                requireNonNull(認知症高齢者の日常生活自立度, Messages.E00001.replace("認知症高齢者の日常生活自立度").getMessage());
        this.障害高齢者の日常生活自立度 =
                requireNonNull(障害高齢者の日常生活自立度, Messages.E00001.replace("障害高齢者の日常生活自立度").getMessage());

    }

    /**
     * 認知症高齢者の日常生活自立度を返します。
     *
     * @return 認知症高齢者の日常生活自立度
     */
    public ChosaKekkaKubunJiritsu.NinchishoNichijoSeikatsu get認知症高齢者の日常生活自立度() {
        return 認知症高齢者の日常生活自立度;
    }

    /**
     * 障害高齢者の日常生活自立度を返します。
     *
     * @return 障害高齢者の日常生活自立度
     */
    public ChosaKekkaKubunJiritsu.ShogaiNichijoSeikatsu get障害高齢者の日常生活自立度() {
        return 障害高齢者の日常生活自立度;
    }
}
