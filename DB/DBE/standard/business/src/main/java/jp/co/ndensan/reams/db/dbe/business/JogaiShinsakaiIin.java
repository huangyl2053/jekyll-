/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * 申請者の関係者であるなどの理由により、審査会から除外される介護認定審査会委員を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class JogaiShinsakaiIin {
    //TODO n8178 城間篤人 審査会関連の本実装時にIShinsakaiIinインターフェース作成し、その後にそれを実装するように修正する 2014年9月末

    private final ShoKisaiHokenshaNo 証記載保険者番号;
    private final KaigoHihokenshaNo 被保険者番号;
    private final int 管理番号;
    private final ShinsakaiIin 除外対象審査会委員;

    /**
     * コンストラクタです。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 管理番号 管理番号
     * @param 除外対象審査会委員 除外対象審査会委員
     * @throws NullPointerException 証記載保険者番号、被保険者番号、除外対象審査会委員に対してnullが渡されたとき
     * @throws IllegalArgumentException 管理番号に0以下の値が渡されたとき
     */
    public JogaiShinsakaiIin(ShoKisaiHokenshaNo 証記載保険者番号, KaigoHihokenshaNo 被保険者番号,
            int 管理番号, ShinsakaiIin 除外対象審査会委員) throws NullPointerException, IllegalArgumentException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        checkゼロ以下(管理番号);
        requireNonNull(除外対象審査会委員, UrSystemErrorMessages.値がnull.getReplacedMessage("除外対象審査会委員"));

        this.証記載保険者番号 = 証記載保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.管理番号 = 管理番号;
        this.除外対象審査会委員 = 除外対象審査会委員;
    }

    private int checkゼロ以下(int 管理番号) {
        if (管理番号 <= 0) {
            throw new IllegalArgumentException(UrErrorMessages.項目に対する制約.getMessage().toString());
        }
        return 管理番号;
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return 証記載保険者番号;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public KaigoHihokenshaNo get対象被保険者番号() {
        return 被保険者番号;
    }

    /**
     * 管理番号を返します。
     *
     * @return 管理番号
     */
    public int get管理番号() {
        return 管理番号;
    }

    /**
     * 除外対象の審査会委員情報を返します。
     *
     * @return 審査会委員
     */
    public ShinsakaiIin get除外対象審査会委員() {
        return 除外対象審査会委員;
    }

}
