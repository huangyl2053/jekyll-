/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.NinteiShinseiKubunHorei;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.NinteiShinseiYukoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.TorisageKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定申請の実装クラスです。
 *
 * @author n3310 酒井 裕亮
 * @jpName 要介護認定申請
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public class _YoKaigoNinteiShinsei implements IYoKaigoNinteiShinsei {

    private static final RString DESCRIPTION_OF_TO_CREATE;
    //
    private final RString 申請書管理番号;
    private final RString 介護保険被保険者番号;
    private final NinteiShinseiYukoKubun 申請有効区分;
    private final RDate 申請年月日;
    private final NinteiShinseiKubunShinsei 認定申請区分_申請時;
    private final NinteiShinseiKubunHorei 認定申請区分_法令;
    private final RString 認定申請理由;
    private final LasdecCode 地方公共団体コード;
    private final TorisageKubun 取下げ区分;

    static {
        DESCRIPTION_OF_TO_CREATE = new RString("要介護認定申請");
    }

    /**
     * インスタンスを生成します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 介護保険被保険者番号 介護保険被保険者番号
     * @param 申請有効区分 申請有効区分
     * @param 申請年月日 申請年月日
     * @param 認定申請区分_申請時 認定申請区分_申請時
     * @param 認定申請区分_法令 認定申請区分_法令
     * @param 認定申請理由 認定申請理由
     * @param 地方公共団体コード 地方公共団体コード
     * @param 取下げ区分 取下げ区分
     */
    public _YoKaigoNinteiShinsei(
            RString 申請書管理番号,
            RString 介護保険被保険者番号,
            NinteiShinseiYukoKubun 申請有効区分,
            RDate 申請年月日,
            NinteiShinseiKubunShinsei 認定申請区分_申請時,
            NinteiShinseiKubunHorei 認定申請区分_法令,
            RString 認定申請理由,
            LasdecCode 地方公共団体コード,
            TorisageKubun 取下げ区分) {

        this.申請書管理番号 = Objects.requireNonNull(申請書管理番号, composeInstantiationMessage("申請書管理番号"));
        this.介護保険被保険者番号 = Objects.requireNonNull(介護保険被保険者番号, composeInstantiationMessage("介護保険被保険者番号"));
        this.申請有効区分 = Objects.requireNonNull(申請有効区分, composeInstantiationMessage("申請有効区分"));
        this.申請年月日 = Objects.requireNonNull(申請年月日, composeInstantiationMessage("申請年月日"));
        this.認定申請区分_申請時 = Objects.requireNonNull(認定申請区分_申請時, composeInstantiationMessage("認定申請区分_申請時"));
        this.認定申請区分_法令 = Objects.requireNonNull(認定申請区分_法令, composeInstantiationMessage("認定申請区分_法令"));
        this.認定申請理由 = Objects.requireNonNull(認定申請理由, composeInstantiationMessage("認定申請理由"));
        this.地方公共団体コード = Objects.requireNonNull(地方公共団体コード, composeInstantiationMessage("地方公共団体コード"));
        this.取下げ区分 = Objects.requireNonNull(取下げ区分, composeInstantiationMessage("取下げ区分"));
    }

    @Override
    public RString get申請書管理番号() {
        return 申請書管理番号;
    }

    @Override
    public RString get介護保険被保険者番号() {
        return 介護保険被保険者番号;
    }

    @Override
    public NinteiShinseiYukoKubun get申請有効区分() {
        return 申請有効区分;
    }

    @Override
    public RDate get申請年月日() {
        return 申請年月日;
    }

    @Override
    public NinteiShinseiKubunShinsei get認定申請区分_申請時() {
        return 認定申請区分_申請時;
    }

    @Override
    public NinteiShinseiKubunHorei get認定申請区分_法令() {
        return 認定申請区分_法令;
    }

    @Override
    public RString get認定申請理由() {
        return 認定申請理由;
    }

    @Override
    public LasdecCode get地方公共団体コード() {
        return 地方公共団体コード;

    }

    @Override
    public TorisageKubun get取下げ区分() {
        return 取下げ区分;
    }

    private static String composeInstantiationMessage(String replaceMessage) {
        return UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage(replaceMessage, DESCRIPTION_OF_TO_CREATE.toString());
    }
}
