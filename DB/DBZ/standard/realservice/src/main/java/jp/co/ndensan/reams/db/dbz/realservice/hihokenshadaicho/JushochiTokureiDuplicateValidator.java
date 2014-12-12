 4/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.hihokenshadaicho;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidatable;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessages;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;

/**
 * 登録する住所地特例情報の期間が、他市町村住所地特例テーブルの情報や適用除外者テーブルに登録されている情報と重複していないかをチェックします。
 *
 * @author n8178 城間篤人
 */


public final class JushochiTokureiDuplicateValidator {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private JushochiTokureiDuplicateValidator() {
    }

    /**
     * 住所地特例情報を設定します。
     *
     * @param jushochiTokureiData 住所地特例情報
     * @return バリデーションクラスを扱うインターフェース
     */
    public static IValidatable setHihokenshaDaichoData(HihokenshaDaichoModel jushochiTokureiData) {
        return new _JushochiTokureiDuplicateValidator(jushochiTokureiData);
    }

    /**
     * テスト用の設定クラスです。DacのMockなどを引数から渡して、バリデーションクラスを生成します。
     *
     * @param tatokureiDac 他市町村住所地特例Dac
     * @param tekiyoJogaiDac 適用除外Dac
     * @param jushochiTokureiData
     * @return バリデーションクラスを扱うインターフェース
     */
    static IValidatable setHihokenshaDaichoData(//TashichosonJushochiTokureiDac tatokureiDac, TekiyoJogaishaDactekiyoJogaiDac, HihokenshaDaichoModel jushochiTokureiData
            ) {
        return new _JushochiTokureiDuplicateValidator();
    }

    private static class _JushochiTokureiDuplicateValidator implements IValidatable {

        //TODO #55852
        //他のテーブルを参照するためにDacをメンバに持つ。必要なDacが自動生成されたら、型を自動生成されたクラスに修正する。
        //private final TashichosonJushochiTokureiDac tatokureiDac;
        //private final TekiyoJogaishaDac tekiyoJogaiDac;
        private HihokenshaDaichoModel jushochiTokureiData;

        /**
         * コンストラクタです。他テーブルを参照するために必要なDacを受け取ります。
         *
         * @param jushochiTokureiData 住所地特例情報
         */
        public _JushochiTokureiDuplicateValidator(HihokenshaDaichoModel jushochiTokureiData) {
            requireNonNull(jushochiTokureiData, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者台帳情報"));
            this.jushochiTokureiData = jushochiTokureiData;

            //TODO #55852
            //必要なDacが自動生成されたら、引数からDacを受け取る形に修正する。
            //this.tatokureiDac = InstanceProvider.craete(TashichosonJushochiTokureiDac.class);
            //this.tekiyoJogaiDac = tekiyoJogaiDac.create(TekiyoJogaishaDac.class);
        }

        /**
         * テスト用コンストラクタです。外部からDacのMockを受け取ります。
         *
         * @param tatokureiDac 他市町村住所地特例Dac
         * @param tekiyoJogaiDac 適用除外Dac
         * @param jushochiTokureiData 住所地特例情報
         */
        //TODO #55852
        //他のテーブルを参照するためにDacを引数に持つ。必要なDacが自動生成されたら、型を自動生成されたクラスに修正する。
        _JushochiTokureiDuplicateValidator(//TashichosonJushochiTokureiDac tatokureiDac, TekiyoJogaishaDactekiyoJogaiDac, HihokenshaDaichoModel jushochiTokureiData
                ) {
            //this.jushochiTokureiData = jushochiTokureiData;
            //this.tatokureiDac = tatokureiDac;
            //this.tekiyoJogaiDac = tekiyoJogaiDac;
        }

        @Override
        public IValidationMessages validate() {
            //TODO #55852
            //１）他市町村住所地特例テーブルに対象者の該当データが存在する場合、入力した適用日と解除日の期間と、
            //    他市町村住所地特例該当データの適用日と解除日の期間に重複が有る場合、エラーメッセージを表示する。
            //    メッセージID：URZE00025(期間が重複しています。）
            //１－１）Dacを用いて、登録する被保険者台帳情報について、住所地特例の適用・解除日が、
            //       他市町村住所地特例の適用・解除日と重複していないか確認する。
            //２）適用除外者テーブルに対象者の該当データが存在する場合、入力した適用日と解除日の期間と、
            //    適用除外者該当データの適用日と解除日の期間に重複が有る場合、エラーメッセージを表示する。
            //    メッセージID：URZE00025(期間が重複しています。）
            //２－１）Dacを用いて、登録する被保険者台帳情報について、住所地特例の適用・解除日が、
            //       適用除外者の適用・解除日と重複していないか確認する。
            //３）バリデーションメッセージを返す。
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
