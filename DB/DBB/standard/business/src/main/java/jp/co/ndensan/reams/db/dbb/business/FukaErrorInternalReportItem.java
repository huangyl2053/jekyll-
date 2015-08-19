/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.basic.FukaErrorList;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.business.internalreport.InternalReportItem;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.InternalReportShoriKubun;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 賦課エラー一覧内部帳票の業務固有の項目を持つクラスです。 CSV出力のためのアノテーションの設定や、Validationメソッドを宣言しています。
 *
 * @author n8178 城間篤人
 */
public class FukaErrorInternalReportItem extends InternalReportItem {

    @CsvField(order = 10, name = "賦課年度")
    private final FlexibleYear 賦課年度;
    @CsvField(order = 20, name = "通知書番号")
    private final TsuchishoNo 通知書番号;
    @CsvField(order = 30, name = "エラー内容")
    private final FukaError エラー詳細;
    @CsvField(order = 40, name = "被保険者番号")
    private final HihokenshaNo 被保険者番号;
    @CsvField(order = 50, name = "識別コード")
    private final ShikibetsuCode 識別コード;

    private final FukaErrorList model;
    private final InternalReportShoriKubun 処理区分;

    /**
     * コンストラクタです。
     *
     * @param model 賦課エラー情報を持つテーブルに対応したModelクラス
     * @throws NullPointerException 賦課年度、通知書番号、処理区分にnullが渡されたとき
     */
    public FukaErrorInternalReportItem(FukaErrorList model) throws NullPointerException {
        requireNonNull(model, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("賦課エラーのModelObject", getClass().getName()));
        requireNonNull(model.get賦課年度(), UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("賦課年度", getClass().getName()));
        requireNonNull(model.get通知書番号(), UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("通知書番号", getClass().getName()));
        requireNonNull(model.get処理区分コード(), UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("通知書番号", getClass().getName()));
        requireNonNull(model.getエラーコード(), UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("エラーコード", getClass().getName()));

        this.賦課年度 = model.get賦課年度();
        this.通知書番号 = model.get通知書番号();
        this.エラー詳細 = getエラー詳細(model);
        this.被保険者番号 = model.get被保険者番号();
        this.識別コード = model.get識別コード();

        this.model = model;
        this.処理区分 = InternalReportShoriKubun.toValue(model.get処理区分コード());
    }

    private FukaError getエラー詳細(FukaErrorList model) {
        return new FukaError(model.getエラーコード(),
                RString.EMPTY,
                RString.EMPTY);
    }

    /**
     * 自身が持つModelと同じ値を持ったModelを、新規に生成して返します。
     *
     * @return 賦課エラーModel
     */
    public FukaErrorList toModel() {
        return new FukaErrorList(model.toEntity());
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
    public HihokenshaNo get被保険者番号() {
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
