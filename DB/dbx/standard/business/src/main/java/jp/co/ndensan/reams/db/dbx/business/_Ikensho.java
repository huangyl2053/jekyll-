/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import jp.co.ndensan.reams.db.dbx.business.IIkensho;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.NinchishoKoreishaNichijoSeikatsuJiritsudo;
import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.ShogaiKoreiNichijoSeikatsuJiritsudo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書の実装クラスです。
 *
 * @author n3310 酒井 裕亮
 * @jpName 意見書
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public class _Ikensho implements IIkensho {

    private static final RString DESCRIPTION_OF_TO_CREATE = new RString("意見書");
    private final RDate 依頼年月日;
    private final RDate 受領年月日;
    private final ShogaiKoreiNichijoSeikatsuJiritsudo 障害高齢者の日常生活自立度;
    private final NinchishoKoreishaNichijoSeikatsuJiritsudo 認知症高齢者の日常生活自立度;

    /**
     * インスタンスを生成します。
     *
     * @param 依頼年月日 依頼年月日
     * @param 受領年月日 受領年月日
     * @param 障害高齢者の日常生活自立度 障害高齢者の日常生活自立度
     * @param 認知症高齢者の日常生活自立度 認知症高齢者の日常生活自立度
     */
    public _Ikensho(RDate 依頼年月日,
            RDate 受領年月日,
            ShogaiKoreiNichijoSeikatsuJiritsudo 障害高齢者の日常生活自立度,
            NinchishoKoreishaNichijoSeikatsuJiritsudo 認知症高齢者の日常生活自立度) {
        this.依頼年月日 = Objects.requireNonNull(依頼年月日,
                UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("依頼年月日", DESCRIPTION_OF_TO_CREATE.toString()));
        this.受領年月日 = Objects.requireNonNull(受領年月日,
                UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("受領年月日", DESCRIPTION_OF_TO_CREATE.toString()));
        this.障害高齢者の日常生活自立度 = Objects.requireNonNull(障害高齢者の日常生活自立度,
                UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("障害高齢者の日常生活自立度", DESCRIPTION_OF_TO_CREATE.toString()));
        this.認知症高齢者の日常生活自立度 = Objects.requireNonNull(認知症高齢者の日常生活自立度,
                UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("認知症高齢者の日常生活自立度", DESCRIPTION_OF_TO_CREATE.toString()));
    }

    @Override
    public RDate get依頼年月日() {
        return 依頼年月日;
    }

    @Override
    public RDate get受領年月日() {
        return 受領年月日;
    }

    @Override
    public ShogaiKoreiNichijoSeikatsuJiritsudo get障害高齢者日常生活自立度() {
        return 障害高齢者の日常生活自立度;
    }

    @Override
    public NinchishoKoreishaNichijoSeikatsuJiritsudo get認知症高齢者日常生活自立度() {
        return 認知症高齢者の日常生活自立度;
    }
}
