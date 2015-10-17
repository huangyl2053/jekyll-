/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.NinchishoKoreishaNichijoSeikatsuJiritsudo;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.ShogaiKoreiNichijoSeikatsuJiritsudo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 意見書のインタフェースです。
 *
 * @author n3310 酒井 裕亮
 * @jpName 意見書インタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public interface IIkensho extends Serializable {

    /**
     * 依頼年月日を返します。
     *
     * @return 依頼年月日
     */
    RDate get依頼年月日();

    /**
     * 受領年月日を返します。
     *
     * @return 受領年月日
     */
    RDate get受領年月日();

    /**
     * 障害高齢者の日常生活自立度を返します。
     *
     * @return 障害高齢者の日常生活自立度
     */
    ShogaiKoreiNichijoSeikatsuJiritsudo get障害高齢者日常生活自立度();

    /**
     * 認知症高齢者の日常生活自立度を返します。
     *
     * @return 認知症高齢者の日常生活自立度
     */
    NinchishoKoreishaNichijoSeikatsuJiritsudo get認知症高齢者日常生活自立度();
}
