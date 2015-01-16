/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.model.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 被保険者台帳に対して、住所地特例の情報を登録する際に必要なバリデーションです。
 *
 * @author n8178 城間篤人
 */
public class JushochiTokureiValidator {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private JushochiTokureiValidator() {
    }

    /**
     * チェック対象の住所地特例データを設定します。
     *
     * @param jushochiTokureiData 住所地特例情報
     * @return 住所地特例のListを設定するためのインターフェース
     */
    public static IJushochiTokureiListSetter setJushochiTokureiData(HihokenshaDaichoModel jushochiTokureiData) {
        return new _JushochiTokureiValidator(jushochiTokureiData);
    }

    /**
     * 住所地特例のListを設定するための機能を提供するインターフェースです。
     */
    public interface IJushochiTokureiListSetter {

        /**
         * チェックに使用する住所地特例Listを設定します。
         *
         * @param jushochiTokureiList 住所地特例List
         * @return バリデーションクラスを扱うインターフェース
         */
        IValidatable setJushochiTokureiList(IItemList<HihokenshaDaichoModel> jushochiTokureiList);
    }

    private static class _JushochiTokureiValidator implements IValidatable, IJushochiTokureiListSetter {

        private final HihokenshaDaichoModel jushochiTokureiData;
        private IItemList<HihokenshaDaichoModel> jushochiTokureiList;

        /**
         * コンストラクタです。
         *
         * @param jushochiTokureiData 住所地特例情報
         */
        public _JushochiTokureiValidator(HihokenshaDaichoModel jushochiTokureiData) {
            requireNonNull(jushochiTokureiData, UrSystemErrorMessages.値がnull.getReplacedMessage("登録する住所地特例情報"));
            this.jushochiTokureiData = jushochiTokureiData;
        }

        @Override
        public IValidatable setJushochiTokureiList(IItemList<HihokenshaDaichoModel> jushochiTokureiList) {
            requireNonNull(jushochiTokureiData, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例List"));
            this.jushochiTokureiList = jushochiTokureiList;
            return this;
        }

        @Override
        public IValidationMessages validate() {
            //TODO #55852
            //１）適用日 < 資格得喪情報の取得日 のとき、エラーメッセージを表示する。
            //    メッセージID：URZE00028（大小関係が不正です。(%1)）
            //      %1：適用日 － 取得日
            //２）資格得喪情報の喪失日 ≦ 適用日 のとき、エラーメッセージを表示する。
            //    メッセージID：URZE00028（大小関係が不正です。(%1)）
            //      %1：適用日 － 喪失日
            //３）解除日≠Empty かつ 解除日 < 適用日 のとき、エラーメッセージを表示する。
            //    メッセージID：URZE00027（期間が不正です。%1－%2）
            //      %1：適用日
            //      %2：解除日
            //４）解除日≠Empty かつ 資格得喪情報の喪失日 < 解除日 のとき、エラーメッセージを表示する。
            //    メッセージID：URZE00028（大小関係が不正です。(%1)）
            //      %1：解除日 － 喪失日
            //５）jushochiTokureiDataが持つ適用日・解除日の期間と、住所地特例履歴一覧内の全データの適用日・解除日との比較で重複が有る場合、
            //   エラーメッセージを表示する。
            //    メッセージID：URZE00025(期間が重複しています。）
            //５－１）もし、jushochiTokureiDataが修正処理によって生成されてものである場合、修正対象のレコードはチェック対象からはずす。
            //
            //６）エラーメッセージを返す。
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
}
