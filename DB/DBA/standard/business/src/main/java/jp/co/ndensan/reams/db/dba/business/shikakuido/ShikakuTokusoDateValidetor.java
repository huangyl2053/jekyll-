/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.shikakuido;

import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidatable;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessages;

/**
 * 資格の取得・喪失日に不整合がおきていないかをチェックする機能を提供するクラスです。<br/>
 * 以下の様に、比較したい値を設定します。<br/>
 * {@code ShikakuToskusoDateValidetor.previous(previousHihoDaicho).next(nextHihoDaicho).validate();}
 *
 * @author n8178 城間篤人
 */
public class ShikakuTokusoDateValidetor {

    /**
     * インスタンス化防止のためのパッケージプライベートのコンストラクタです。
     */
    private ShikakuTokusoDateValidetor() {
    }

    /**
     * 比較対象となる、ひとつ前の被保険者台帳情報を受け取ります。
     *
     * @param previous 比較対象となる、ひとつ前の被保険者台帳情報
     * @return {@link IShikakuTosusoDateValidetor}のインスタンス
     */
    public static IShikakuTosusoDateValidetor previous(HihokenshaDaichoModel previous) {
        return new _ShikakuTokusoDateValidetor(previous);
    }

    /**
     * 比較対象となる、次の被保険者台帳情報を設定する処理を提供します。
     */
    public interface IShikakuTosusoDateValidetor {

        /**
         * 比較対象となる、次の被保険者台帳情報を受け取り、Validationチェックを実行可能なインスタンスを返します。
         *
         * @param next 比較対象となる、次の被保険者台帳情報
         * @return {@link IValidatable}のインスタンス
         */
        IValidatable next(HihokenshaDaichoModel next);
    }

    private static class _ShikakuTokusoDateValidetor implements IShikakuTosusoDateValidetor, IValidatable {

        private final HihokenshaDaichoModel previous;
        private HihokenshaDaichoModel next;

        public _ShikakuTokusoDateValidetor(HihokenshaDaichoModel previous) {
            this.previous = previous;
        }

        @Override
        public IValidatable next(HihokenshaDaichoModel next) {
            this.next = next;
            return this;
        }

        @Override
        public IValidationMessages validate() {
            //TODO #52997
            //資格の取得・喪失日に不整合が起きていないかのチェック処理を実装してください。
            //1, next.get取得日() < previous.get喪失日()の場合、メッセージを返します。
            //      　メッセージID：URZE00025（期間が重複しています。）
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
