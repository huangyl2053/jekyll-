/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbd.business.core.shogaishakoujo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4038ShogaishaKoujoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 障がい者控除対象者認定画面
 *
 * @reamsid_L DBD-3870-010 jinge
 */
public class ShogaishaKoujo {
    private final DbT4038ShogaishaKoujoEntity 障がい者控除;

    /**
     * コンストラクタです。
     *
     * @param 障がい者控除 障がい者控除
     */
    public ShogaishaKoujo(DbT4038ShogaishaKoujoEntity 障がい者控除) {
        requireNonNull(障がい者控除, UrSystemErrorMessages.値がnull.getReplacedMessage("障がい者控除のエンティティ"));
        this.障がい者控除 = 障がい者控除;
    }

    /**
     * 認定区分を返します。
     *
     * @return 認定区分
     */
    public RString get認定区分() {
        return 障がい者控除.getNinteiKubun();
    }

    /**
     * 認定内容を返します。
     *
     * @return 認定内容
     */
    public RString get認定内容() {
        return 障がい者控除.getNinteiNaiyo();
    }

    /**
     * 認知症高齢者自立度を返します。
     *
     * @return 認知症高齢者自立度
     */
    public Code get認知症高齢者自立度() {
        return 障がい者控除.getNinchishoNichijoSeikatsuJiritsudoCode();
    }

    /**
     * 障害高齢者自立度を返します。
     *
     * @return 障害高齢者自立度
     */
    public Code get障害高齢者自立度() {
        return 障がい者控除.getShogaiNichijoSeikatsuJiritsudoCode();
    }

    /**
     * 障がい者手帳ありを返します。
     *
     * @return 障がい者手帳あり
     */
    public boolean get障がい者手帳あり() {
        return 障がい者控除.getShogaishaTechoUmu();
    }

}
