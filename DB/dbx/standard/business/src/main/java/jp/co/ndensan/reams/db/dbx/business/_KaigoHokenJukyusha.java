/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険受給者の実装クラスです。
 *
 * @author N2806 太田 智之
 * @jpName 介護保険受給者
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public class _KaigoHokenJukyusha implements IKaigoHokenJukyusha {

    private static final RString DESCRIPTION_OF_TO_CREATE = new RString("介護保険受給者");
    //
    private final List<IYoKaigoNintei> yoKaigoNinteiList;
    private final RDate idoYmd;
    private final IKojin kojin;
    private final RDate soshitsuYmd;

    /**
     * インスタンスを生成します。
     *
     * @param yoKaigoNinteiList 要介護認定リスト
     * @param idoYmd 直近異動年月日
     * @param kojin 個人
     * @param soshitsuYmd 喪失年月日
     */
    public _KaigoHokenJukyusha(List<IYoKaigoNintei> yoKaigoNinteiList, RDate idoYmd, IKojin kojin, RDate soshitsuYmd) {
        this.yoKaigoNinteiList = Objects.requireNonNull(yoKaigoNinteiList, composeInstantiationMessage("要介護認定リスト"));
        this.idoYmd = Objects.requireNonNull(idoYmd, composeInstantiationMessage("直近異動年月日"));
        this.kojin = Objects.requireNonNull(kojin, composeInstantiationMessage("個人"));
        this.soshitsuYmd = Objects.requireNonNull(soshitsuYmd, composeInstantiationMessage("喪失年月日"));
    }

    @Override
    public List<IYoKaigoNintei> get要介護認定() {
        return yoKaigoNinteiList;
    }

    @Override
    public RDate get直近異動年月日() {
        return idoYmd;
    }

    @Override
    public IKojin get個人() {
        return kojin;
    }

    @Override
    public RDate get喪失年月日() {
        return soshitsuYmd;
    }

    private static String composeInstantiationMessage(String replaceMessage) {
        return UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage(replaceMessage, DESCRIPTION_OF_TO_CREATE.toString());
    }
}
