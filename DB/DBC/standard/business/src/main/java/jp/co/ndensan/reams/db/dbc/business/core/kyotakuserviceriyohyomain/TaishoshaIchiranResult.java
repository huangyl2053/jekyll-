/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyotakuserviceriyohyomain;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakuserviceriyohyomain.TaishoshaichiranEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象情報一覧業務概念スラスです。
 *
 * @reamsid_L DBC-1930-030 huzongcheng
 */
public class TaishoshaIchiranResult implements Serializable {

    private final TaishoshaichiranEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link TaishoshaichiranEntity}より{@link KyotakuServiceRiyohyoMainResult}を生成します。
     *
     * @param entity DBより取得した{@link TaishoshaichiranEntity}
     */
    public TaishoshaIchiranResult(TaishoshaichiranEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("対象情報一覧Entity"));
    }

    /**
     * 利用年月を返します。
     *
     * @return 利用年月
     */
    public FlexibleYearMonth get利用年月() {
        return entity.getRiyoYM();
    }

    /**
     * 更新区分を返します。
     *
     * @return 更新区分
     */
    public RString get更新区分() {
        return entity.getKoshinKubun();
    }

    /**
     * 更新年月日を返します。
     *
     * @return 届出年月日
     */
    public FlexibleDate get更新年月日() {
        return entity.getKoshinYMD();
    }

    /**
     * 送付年月を返します。
     *
     * @return 送付年月
     */
    public FlexibleYearMonth get送付年月() {
        return entity.getSofuYM();
    }
}
