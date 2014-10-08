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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.validations.FukaErrorValidationMessage;
import jp.co.ndensan.reams.db.dbb.model.FukaErrorModel;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.business.validations.IValidatable;
import jp.co.ndensan.reams.ur.urz.business.validations.IValidationMessages;
import jp.co.ndensan.reams.ur.urz.business.validations.ValidationMessagesFactory;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.InternalReportShoriKubun;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;

/**
 * 賦課エラー一覧内部帳票の業務固有の項目を持つクラスです。 CSV出力のためのアノテーションの設定や、Validationメソッドを宣言しています。
 *
 * @author n8178 城間篤人
 */
public class FukaErrorInternalReportItem implements IInternalReportItem, IValidatable {

    @CsvField(order = 10, name = "賦課年度")
    private final FlexibleYear 賦課年度;
    @CsvField(order = 20, name = "通知書番号")
    private final TsuchishoNo 通知書番号;
    @CsvField(order = 30, name = "エラー内容")
    private final FukaError エラー詳細;
    @CsvField(order = 40, name = "被保険者番号")
    private final KaigoHihokenshaNo 被保険者番号;
    @CsvField(order = 50, name = "識別コード")
    private final ShikibetsuCode 識別コード;

    private final FukaErrorModel model;
    private final InternalReportShoriKubun 処理区分;

    /**
     * 引数から賦課エラーのModelを受け取り、インスタンスを生成します。
     *
     * @param model 賦課エラーModel
     * @throws NullPointerException 賦課年度、通知書番号、処理区分にnullが渡されたとき
     */
    public FukaErrorInternalReportItem(FukaErrorModel model) throws NullPointerException {
        requireNonNull(model, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("賦課エラーのModelObject", getClass().getName()));
        requireNonNull(model.get賦課年度(), UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("賦課年度", getClass().getName()));
        requireNonNull(model.get通知書番号(), UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("通知書番号", getClass().getName()));
        requireNonNull(model.get処理区分(), UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("通知書番号", getClass().getName()));
        requireNonNull(model.getエラーコード(), UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("エラーコード", getClass().getName()));

        this.賦課年度 = model.get賦課年度();
        this.通知書番号 = model.get通知書番号();
        this.エラー詳細 = getエラー詳細(model);
        this.被保険者番号 = model.get被保険者番号();
        this.識別コード = model.get識別コード();

        this.model = model;
        this.処理区分 = model.get処理区分();
    }

    private FukaError getエラー詳細(FukaErrorModel model) {
        return new FukaError(model.getエラーコード(),
                model.getエラー名称(),
                model.getエラー略称());
    }

    /**
     * 自身が持つModelと同じ値を持ったModelを、新規に生成して返します。
     *
     * @return 賦課エラーModel
     */
    public FukaErrorModel toModel() {
        return new FukaErrorModel(model.getEntity());
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public FlexibleYear get賦課年度() {
        return 賦課年度;
    }

    /**
     * 通知書番号を返します。
     *
     * @return 通知書番号
     */
    public TsuchishoNo get通知書番号() {
        return 通知書番号;
    }

    /**
     * エラーの内容を返します。
     *
     * @return エラーDetail
     */
    public FukaError getエラー詳細() {
        return エラー詳細;
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

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();

        if (!処理区分.equals(InternalReportShoriKubun.処理無し)) {
            messages.add(FukaErrorValidationMessage.更正対象が未処理状態ではないため実行不可,
                    "未処理状態でないため、修正処理画面へ移動すること");
        }

        return messages;
    }

}
