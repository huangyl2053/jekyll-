/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定クラスです。
 *
 * @author N2806 太田 智之
 * @jpName 要介護認定
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public class _YoKaigoNintei implements IYoKaigoNintei {

    private static final RString DESCRIPTION_OF_TO_CREATE;
    //
    private final IYoKaigoNinteiShinsei 要介護認定申請;
    private final IYoKaigoNinteiChosa 要介護認定調査;
    private final IIkensho 意見書;
    private final IYoKaigoNinteiIchijiHantei 要介護認定一次判定;
    private final IKaigoNinteiShinsaKai 介護認定審査会;
    private final IYoKaigoNinteiKekka 要介護認定結果;
    private final RString 主治医医師識別コード;
    private final RString 主治医氏名;
    private final RString 主治医医療機関コード;
    private final RString 主治医医療機関名称;

    static {
        DESCRIPTION_OF_TO_CREATE = new RString("要介護認定");
    }

    /**
     * インスタンスを生成します。
     *
     * @param 要介護認定申請 要介護認定申請
     * @param 要介護認定調査 要介護認定調査
     * @param 意見書 意見書
     * @param 要介護認定一次判定 要介護認定一次判定
     * @param 介護認定審査会 介護認定審査会
     * @param 要介護認定結果 要介護認定結果
     * @param 主治医医師識別コード 主治医医師識別コード
     * @param 主治医氏名 主治医氏名
     * @param 主治医医療機関コード 主治医医療機関コード
     * @param 主治医医療機関名称 主治医医療機関名称
     */
    public _YoKaigoNintei(IYoKaigoNinteiShinsei 要介護認定申請,
            IYoKaigoNinteiChosa 要介護認定調査,
            IIkensho 意見書,
            IYoKaigoNinteiIchijiHantei 要介護認定一次判定,
            IKaigoNinteiShinsaKai 介護認定審査会,
            IYoKaigoNinteiKekka 要介護認定結果,
            RString 主治医医師識別コード,
            RString 主治医氏名,
            RString 主治医医療機関コード,
            RString 主治医医療機関名称) {
        this.要介護認定申請 = Objects.requireNonNull(要介護認定申請, composeInstantiationMessage("要介護認定申請"));
        this.要介護認定調査 = Objects.requireNonNull(要介護認定調査, composeInstantiationMessage("要介護認定調査"));
        this.意見書 = Objects.requireNonNull(意見書, composeInstantiationMessage("意見書"));
        this.要介護認定一次判定 = Objects.requireNonNull(要介護認定一次判定, composeInstantiationMessage("要介護認定一次判定"));
        this.介護認定審査会 = Objects.requireNonNull(介護認定審査会, composeInstantiationMessage("介護認定審査会"));
        this.要介護認定結果 = Objects.requireNonNull(要介護認定結果, composeInstantiationMessage("要介護認定結果"));
        this.主治医医師識別コード = Objects.requireNonNull(主治医医師識別コード, composeInstantiationMessage("主治医医師識別コード"));
        this.主治医氏名 = Objects.requireNonNull(主治医氏名, composeInstantiationMessage("主治医氏名"));
        this.主治医医療機関コード = Objects.requireNonNull(主治医医療機関コード, composeInstantiationMessage("主治医医療機関コード"));
        this.主治医医療機関名称 = Objects.requireNonNull(主治医医療機関名称, composeInstantiationMessage("主治医医療機関名称"));
    }

    @Override
    public IYoKaigoNinteiShinsei get要介護認定申請() {
        return 要介護認定申請;
    }

    @Override
    public IYoKaigoNinteiChosa get要介護認定調査() {
        return 要介護認定調査;
    }

    @Override
    public IIkensho get意見書() {
        return 意見書;
    }

    @Override
    public IYoKaigoNinteiIchijiHantei get要介護認定一次判定() {
        return 要介護認定一次判定;
    }

    @Override
    public IKaigoNinteiShinsaKai get介護認定審査会() {
        return 介護認定審査会;
    }

    @Override
    public IYoKaigoNinteiKekka get要介護認定結果() {
        return 要介護認定結果;
    }

    @Override
    public RString get主治医医師識別コード() {
        return 主治医医師識別コード;
    }

    @Override
    public RString get主治医氏名() {
        return 主治医氏名;
    }

    @Override
    public RString get主治医医療機関コード() {
        return 主治医医療機関コード;
    }

    @Override
    public RString get主治医医療機関名称() {
        return 主治医医療機関名称;
    }

    private static String composeInstantiationMessage(String replaceMessage) {
        return UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage(replaceMessage, DESCRIPTION_OF_TO_CREATE.toString());
    }
}
