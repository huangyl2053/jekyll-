/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.shikakuido;

import jp.co.ndensan.reams.db.dbz.business.config.NenreiTotatsuKijunConfig;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ua.uax.business.IDateOfBirth;
import jp.co.ndensan.reams.ur.urz.model.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 資格取得対象者が、資格を取得可能な年齢に到達しているかのチェック機能を提供するクラスです。
 *
 * @author n8178 城間篤人
 */
public class NenreiTotatsuValidetor implements IValidatable {

    private final HihokenshaDaichoModel model;
    private final IDateOfBirth dateOfBirth;
    private final NenreiTotatsuKijunConfig config;

    /**
     * コンストラクタです。
     *
     * @param model 被保険者台帳Model
     * @param dateOfBirth 生年月日
     */
    public NenreiTotatsuValidetor(HihokenshaDaichoModel model, IDateOfBirth dateOfBirth) {
        requireNonNull(model, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("引数のmodel", getClass().getSimpleName()));
        requireNonNull(dateOfBirth, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("生年月日", getClass().getSimpleName()));
        this.model = model;
        this.dateOfBirth = dateOfBirth;
        this.config = new NenreiTotatsuKijunConfig();
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param model 被保険者台帳Model
     * @param dateOfBirth 生年月日
     * @param config 業務コンフィグクラスのMock
     */
    NenreiTotatsuValidetor(HihokenshaDaichoModel model, IDateOfBirth dateOfBirth, NenreiTotatsuKijunConfig config) {
        this.model = model;
        this.dateOfBirth = dateOfBirth;
        this.config = config;
    }

    @Override
    public IValidationMessages validate() {
        //TODO #52997
        //生年月日と資格取得日を比較して、資格取得可能な年齢であるかどうかを判定する処理を実装してください。
        //資格取得可能な年齢は、取得事由によって変化するため、以下のように判定処理を分岐させてください。
        //
        //1, NenreiTotatsuCheckerによる判定で使用する基準を判定する。
        //   業務コンフィグから年齢到達の基準を取得する。
        //      取得事由 == 年齢到達 の場合
        //          ConfigKeysNenreiTotatsuKijunJoho.年齢到達基準_第１号被保険者到達基準年齢を使用する。
        //      それ以外の場合
        //          ConfigKeysNenreiTotatsuKijunJoho.年齢到達基準_第２号被保険者到達基準年齢を使用する。
        //
        //2, 1で決めた基準を元にNenreiTotatsuCheckerを利用して判定を行う。
        //3, 2でfalseが返却された場合（年齢到達していない場合）メッセージを返す。
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
