/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 介護認定審査会クラスです。
 *
 * @author N2204 三井 沙織
 * @jpName 介護認定審査会
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public class _KaigoNinteiShinsaKai implements IKaigoNinteiShinsaKai {

    private final RDate 資料作成年月日;
    private final RDate 開催予定年月日;
    private final int 合議体番号;
    private final RDate 回答年月日;

    /**
     * コンストラクタです。
     *
     * @param 資料作成年月日 資料作成年月日
     * @param 開催予定年月日 開催予定年月日
     * @param 合議体番号 合議体番号
     * @param 回答年月日 回答年月日
     * @throws NullPointerException いずれかの引数がnullの場合はスローされる。
     */
    public _KaigoNinteiShinsaKai(RDate 資料作成年月日, RDate 開催予定年月日, int 合議体番号, RDate 回答年月日) throws NullPointerException {

        Objects.requireNonNull(資料作成年月日, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("資料作成年月日", "介護認定審査会"));
        Objects.requireNonNull(開催予定年月日, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("開催予定年月日", "介護認定審査会"));
        Objects.requireNonNull(回答年月日, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("回答年月日", "介護認定審査会"));

        this.資料作成年月日 = 資料作成年月日;
        this.開催予定年月日 = 開催予定年月日;
        this.合議体番号 = 合議体番号;
        this.回答年月日 = 回答年月日;
    }

    @Override
    public RDate get資料作成年月日() {
        return 資料作成年月日;
    }

    @Override
    public RDate get開催予定年月日() {
        return 開催予定年月日;
    }

    @Override
    public int get合議体番号() {
        return 合議体番号;
    }

    @Override
    public RDate get回答年月日() {
        return 回答年月日;
    }
}
