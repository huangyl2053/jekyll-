/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連取込情報のキー情報です。
 */
public class KokuhorenTorikomiJohoKey implements Serializable {

    private final RString 処理年月;
    private final KokanShikibetsuNo 交換情報識別番号;
    private final RString 処理名;
    private final RString 再処理区分;
    private final RString バッチID;

    /**
     * コンストラクタです。
     *
     * @param 処理年月 処理年月
     * @param 交換情報識別番号 交換情報識別番号
     * @param 再処理区分 再処理区分
     * @param バッチID バッチID
     * @throws NullPointerException 引数がnullの時
     */
    public KokuhorenTorikomiJohoKey(RString 処理年月, KokanShikibetsuNo 交換情報識別番号, RString 処理名, RString 再処理区分, RString バッチID) throws NullPointerException {
        this.処理年月 = requireNonNull(処理年月, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        this.交換情報識別番号 = requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        this.処理名 = requireNonNull(処理名, UrSystemErrorMessages.値がnull.getReplacedMessage("処理名"));
        this.再処理区分 = requireNonNull(再処理区分, UrSystemErrorMessages.値がnull.getReplacedMessage("再処理区分"));
        this.バッチID = requireNonNull(バッチID, UrSystemErrorMessages.値がnull.getReplacedMessage("batchId"));
    }

    /**
     * 処理年月を返します。
     *
     * @return 処理年月
     */
    public RString get処理年月() {
        return 処理年月;
    }

    /**
     * 交換情報識別番号を返します。
     *
     * @return 交換情報識別番号
     */
    public KokanShikibetsuNo get交換情報識別番号() {
        return 交換情報識別番号;
    }

    /**
     * 処理名を返します。
     *
     * @return 処理名
     */
    public RString get処理名() {
        return 処理名;
    }

    /**
     * 再処理区分を返します。
     *
     * @return 再処理区分
     */
    public RString get再処理区分() {
        return 再処理区分;
    }

    /**
     * バッチIDを返します。
     *
     * @return バッチID
     */
    public RString getバッチID() {
        return バッチID;
    }

}
