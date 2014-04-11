/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.EnumMap;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NichijoSeikatsuJiritsudoKumiawaseItemGroup;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 一次判定における、日常生活自立度の組み合わせについての情報を持つクラスです。<br/>
 * このクラスは、障害高齢者と認知症高齢者の日常生活自立度を組み合わせた場合に、どの要介護度に、<br/>
 * どの程度の割合でなりそうかの情報を、数値で保持しています。<br/>
 * 認定ソフト2006の際に使用された指標になります。
 *
 * <pre>例）
 * 自立...0
 * 要支援...10
 * 要介護1...20
 * 要介護2...30
 * 要介護3...30
 * 要介護4...10
 * 要介護5...0
 * 割合なので合計は100になります。
 * </pre>
 *
 * @author n8178 城間篤人
 */
public class NichijoSeikatsuJiritsudoKumiawase {

    private final Map<NichijoSeikatsuJiritsudoKumiawaseItemGroup, Integer> 日常生活自立度組み合わせ;

    /**
     * 日常生活自立度組み合わせの情報を受け取り、インスタンスを生成します。
     *
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException 日常生活自立度組み合わせが持つ割合の中に、0より小さい数値が存在したとき
     */
    public NichijoSeikatsuJiritsudoKumiawase(Map<NichijoSeikatsuJiritsudoKumiawaseItemGroup, Integer> 日常生活自立度組み合わせ)
            throws NullPointerException, IllegalArgumentException {
        requireNonNull(日常生活自立度組み合わせ, Messages.E00003.replace("日常生活自立度組み合わせ", getClass().getName()).getMessage());

        for (int 得点 : 日常生活自立度組み合わせ.values()) {
            check0未満(得点, Messages.E00013.replace("日常生活自立度組み合わせが持つ割合", "全て0以上").getMessage());
        }

        this.日常生活自立度組み合わせ = new EnumMap<>(日常生活自立度組み合わせ);
    }

    private int check0未満(int check対象, String エラーメッセージ) {
        if (check対象 < 0) {
            throw new IllegalArgumentException(エラーメッセージ);
        }
        return check対象;
    }

    /**
     * 日常生活自立度の組み合わせについて、要介護度の項目を指定し、対応する割合を取得します。
     *
     * @param 要介護度項目 割合を取得したい要介護度を指定
     * @return 指定した項目に対応した割合
     */
    public int get割合(NichijoSeikatsuJiritsudoKumiawaseItemGroup 要介護度項目) {
        return 日常生活自立度組み合わせ.get(要介護度項目);
    }
}
