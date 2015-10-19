/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.JukyushaKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 要介護認定結果の実装クラスです。
 *
 * @author n3310 酒井 裕亮
 * @jpName 要介護認定結果
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public class _YoKaigoNinteiKekka implements IYoKaigoNinteiKekka, IKobetsuJikoKaigoJukyu {

    private static final RString DESCRIPTION_OF_TO_CREATE;
    //
    private final RDate 認定年月日;
    private final YoKaigoJotaiKubun 要介護状態区分;
    private final Range<RDate> 認定有効期間;
    private final RString 介護認定審査会意見;
    private final RDate 異動年月日;
    private final RString 特定疾病;
    private final RDate 基準日;

    static {
        DESCRIPTION_OF_TO_CREATE = new RString("要介護認定結果");
    }

    /**
     * インスタンスを生成します。
     *
     * @param 認定年月日 認定年月日
     * @param 要介護状態区分 要介護状態区分
     * @param 認定有効期間 認定有効期間
     * @param 介護認定審査会意見 介護認定審査会意見
     * @param 異動年月日 異動年月日
     * @param 特定疾病 特定疾病
     * @param 基準日 基準日
     * @throws NullPointerException 引数がNullの場合
     */
    public _YoKaigoNinteiKekka(RDate 認定年月日, YoKaigoJotaiKubun 要介護状態区分, Range<RDate> 認定有効期間, RString 介護認定審査会意見,
            RDate 異動年月日, RString 特定疾病, RDate 基準日) throws NullPointerException {
        this.認定年月日 = Objects.requireNonNull(認定年月日, composeInstantiationMessage("認定年月日"));
        this.要介護状態区分 = Objects.requireNonNull(要介護状態区分, composeInstantiationMessage("要介護状態区分"));
        this.認定有効期間 = Objects.requireNonNull(認定有効期間, composeInstantiationMessage("認定有効期間"));
        this.介護認定審査会意見 = Objects.requireNonNull(介護認定審査会意見, composeInstantiationMessage("介護認定審査会意見"));
        this.異動年月日 = Objects.requireNonNull(異動年月日, composeInstantiationMessage("異動年月日"));
        this.特定疾病 = Objects.requireNonNull(特定疾病, composeInstantiationMessage("特定疾病"));
        this.基準日 = Objects.requireNonNull(基準日, composeInstantiationMessage("基準日"));
    }

    @Override
    public RDate get認定年月日() {
        return 認定年月日;
    }

    @Override
    public YoKaigoJotaiKubun get要介護状態区分() {
        return 要介護状態区分;
    }

    @Override
    public Range<RDate> get認定有効期間() {
        return 認定有効期間;
    }

    @Override
    public RString get介護認定審査会意見() {
        return 介護認定審査会意見;
    }

    @Override
    public RDate get異動年月日() {
        return 異動年月日;
    }

    @Override
    public RString get特定疾病() {
        return 特定疾病;
    }

    @Override
    public JukyushaKubun get受給者区分() {
        if (認定有効期間.between(基準日)) {
            return JukyushaKubun.受給者;
        } else {
            return JukyushaKubun.非受給者;
        }
    }

    @Override
    public RDate get認定有効開始日() {
        return 認定有効期間.getFrom();
    }

    @Override
    public RDate get認定有効終了日() {
        return 認定有効期間.getTo();
    }

    private static String composeInstantiationMessage(String replaceMessage) {
        return UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage(replaceMessage, DESCRIPTION_OF_TO_CREATE.toString());
    }
}
