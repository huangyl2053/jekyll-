/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import jp.co.ndensan.reams.db.dbx.business.IYoKaigoNinteiIchijiHantei;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 要介護認定一次判定の実装クラスです。
 *
 * @author n3310 酒井 裕亮
 * @jpName 要介護認定一次判定
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public class _YoKaigoNinteiIchijiHantei implements IYoKaigoNinteiIchijiHantei {

    private final YoKaigoJotaiKubun 要介護状態区分;
    private final YoKaigoJotaiKubun 要介護状態区分_認知症加算;
    private final RDate 判定年月日;

    /**
     * インスタンスを生成します。
     *
     * @param 要介護状態区分 要介護状態区分
     * @param 要介護状態区分_認知症加算 要介護状態区分
     * @param 判定年月日 要介護状態区分
     */
    public _YoKaigoNinteiIchijiHantei(YoKaigoJotaiKubun 要介護状態区分, YoKaigoJotaiKubun 要介護状態区分_認知症加算, RDate 判定年月日) {
        this.要介護状態区分 = Objects.requireNonNull(要介護状態区分, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("要介護状態区分", "要介護認定一次判定"));
        this.要介護状態区分_認知症加算 = Objects.requireNonNull(要介護状態区分_認知症加算, UrSystemErrorMessages.引数がnullのため生成不可.
                getReplacedMessage("要介護状態区分_認知症加算", "要介護認定一次判定"));
        this.判定年月日 = Objects.requireNonNull(判定年月日, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("判定年月日", "要介護認定一次判定"));
    }

    @Override
    public YoKaigoJotaiKubun get要介護状態区分() {
        return 要介護状態区分;
    }

    @Override
    public YoKaigoJotaiKubun get要介護状態区分_認知症加算() {
        return 要介護状態区分_認知症加算;
    }

    @Override
    public RDate get判定年月日() {
        return 判定年月日;
    }
}
