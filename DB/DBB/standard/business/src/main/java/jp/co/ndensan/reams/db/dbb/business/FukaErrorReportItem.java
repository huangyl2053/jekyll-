/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.internalreport.IInternalReportItem;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.InternalReportShoriKubun;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;

/**
 * 賦課エラー一覧内部帳票の業務固有の項目を持つクラスです。
 *
 * @author n8178 城間篤人
 */
public class FukaErrorReportItem implements IInternalReportItem {

    @CsvField(order = 10, name = "賦課年度")
    private final RYear 賦課年度;
    @CsvField(order = 20, name = "通知書番号")
    private final RString 通知書番号;
    @CsvField(order = 30, name = "エラー内容")
    private final FukaError エラー内容;
    @CsvField(order = 40, name = "被保険者番号")
    private final KaigoHihokenshaNo 被保険者番号;
    @CsvField(order = 50, name = "識別コード")
    private final ShikibetsuCode 識別コード;

    private final InternalReportShoriKubun 処理区分;

    /**
     * 引数から賦課エラー一覧に必要な項目を受け取り、インスタンスを生成します。
     *
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param エラー内容 エラー内容
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     * @param 処理区分 処理区分
     * @throws NullPointerException 賦課年度、通知書番号、処理区分にnullが渡されたとき
     */
    public FukaErrorReportItem(RYear 賦課年度, RString 通知書番号, FukaError エラー内容, KaigoHihokenshaNo 被保険者番号,
            ShikibetsuCode 識別コード, InternalReportShoriKubun 処理区分) throws NullPointerException {
        requireNonNull(賦課年度, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("賦課年度", getClass().getName()));
        requireNonNull(通知書番号, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("通知書番号", getClass().getName()));
        requireNonNull(処理区分, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("通知書番号", getClass().getName()));

        this.賦課年度 = 賦課年度;
        this.通知書番号 = 通知書番号;
        this.エラー内容 = エラー内容;
        this.被保険者番号 = 被保険者番号;
        this.識別コード = 識別コード;
        this.処理区分 = 処理区分;
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public RYear get賦課年度() {
        return 賦課年度;
    }

    /**
     * 通知書番号を返します。
     *
     * @return 通知書番号
     */
    public RString get通知書番号() {
        return 通知書番号;
    }

    /**
     * エラーの内容を返します。
     *
     * @return エラー内容
     */
    public FukaError getエラー内容() {
        return エラー内容;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public KaigoHihokenshaNo get被保険者番号() {
        return 被保険者番号;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return 識別コード;
    }

    @Override
    public InternalReportShoriKubun getShoriKubun() {
        return 処理区分;
    }

}
