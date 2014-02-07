/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査結果（基本調査）の情報を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ChosaKekkaKihon {

    private final ChosaKekkaKihon1 基本情報1;
    private final ChosaKekkaKihon2 基本情報2;
    private final ChosaKekkaKihon3 基本情報3;
    private final ChosaKekkaKihon4 基本情報4;
    private final ChosaKekkaKihon5 基本情報5;
    private final ChosaKekkaKihonIryo 特別医療情報;
    private final ChosaKekkaKihonJiritsu 自立度情報;

    /**
     * インスタンスを生成します。
     *
     * @param 基本情報1 基本情報1
     * @param 基本情報2 基本情報2
     * @param 基本情報3 基本情報3
     * @param 基本情報4 基本情報4
     * @param 基本情報5 基本情報5
     * @param 特別医療情報 特別医療情報
     * @param 自立度情報 自立度情報
     */
    public ChosaKekkaKihon(
            ChosaKekkaKihon1 基本情報1,
            ChosaKekkaKihon2 基本情報2,
            ChosaKekkaKihon3 基本情報3,
            ChosaKekkaKihon4 基本情報4,
            ChosaKekkaKihon5 基本情報5,
            ChosaKekkaKihonIryo 特別医療情報,
            ChosaKekkaKihonJiritsu 自立度情報) {
        this.基本情報1 = requireNonNull(基本情報1, Messages.E00001.replace("基本情報1").getMessage());
        this.基本情報2 = requireNonNull(基本情報2, Messages.E00001.replace("基本情報2").getMessage());
        this.基本情報3 = requireNonNull(基本情報3, Messages.E00001.replace("基本情報3").getMessage());
        this.基本情報4 = requireNonNull(基本情報4, Messages.E00001.replace("基本情報4").getMessage());
        this.基本情報5 = requireNonNull(基本情報5, Messages.E00001.replace("基本情報5").getMessage());
        this.特別医療情報 = requireNonNull(特別医療情報, Messages.E00001.replace("特別医療情報").getMessage());
        this.自立度情報 = requireNonNull(自立度情報, Messages.E00001.replace("自立度情報").getMessage());
    }

    /**
     * 要介護認定調査（基本調査第1群）の情報を返します。
     *
     * @return 基本情報1
     */
    public ChosaKekkaKihon1 get基本情報1() {
        return 基本情報1;
    }

    /**
     * 要介護認定調査（基本調査第2群）の情報を返します。
     *
     * @return 基本情報2
     */
    public ChosaKekkaKihon2 get基本情報2() {
        return 基本情報2;
    }

    /**
     * 要介護認定調査（基本調査第3群）の情報を返します。
     *
     * @return 基本情報3
     */
    public ChosaKekkaKihon3 get基本情報3() {
        return 基本情報3;
    }

    /**
     * 要介護認定調査（基本調査第4群）の情報を返します。
     *
     * @return 基本情報4
     */
    public ChosaKekkaKihon4 get基本情報4() {
        return 基本情報4;
    }

    /**
     * 要介護認定調査（基本調査第5群）の情報を返します。
     *
     * @return 基本情報5
     */
    public ChosaKekkaKihon5 get基本情報5() {
        return 基本情報5;
    }

    /**
     * 要介護認定調査（基本調査特別医療）の情報を返します。
     *
     * @return 特別医療情報
     */
    public ChosaKekkaKihonIryo get特別医療情報() {
        return 特別医療情報;
    }

    /**
     * 要介護認定調査（基本調査自立度）の情報を返します。
     *
     * @return 自立度情報
     */
    public ChosaKekkaKihonJiritsu get自立度情報() {
        return 自立度情報;
    }
}
