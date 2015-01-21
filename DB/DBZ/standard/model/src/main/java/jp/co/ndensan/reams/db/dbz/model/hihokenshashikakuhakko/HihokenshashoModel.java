/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoPrintPosition;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.kojin.IKojin;

/**
 * 被保険者証を印字するために必要な情報を持つModelクラスです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshashoModel implements Serializable {

    private final HihokenshaDaichoModel hihokenshaDaicho;
    private final IKojin kojinJoho;
    private final HihokenshaShikakuHakkoModel shikakuHakko;
    private final HihokenshashoPrintPosition position;

    /**
     * コンストラクタです。B4版に印字する際の印字位置を指定できます。
     *
     * @param hihokenshaDaicho 被保険者台帳情報
     * @param kojinJoho 被保険者の個人情報
     * @param shikakuHakko 交付証情報
     * @param position 印字位置
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    public HihokenshashoModel(HihokenshaDaichoModel hihokenshaDaicho, IKojin kojinJoho, HihokenshaShikakuHakkoModel shikakuHakko,
            HihokenshashoPrintPosition position) throws NullPointerException {
        requireNonNull(hihokenshaDaicho, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者台帳情報", getClass().getName()));
        requireNonNull(kojinJoho, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者の個人情報", getClass().getName()));
        requireNonNull(shikakuHakko, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("交付証情報", getClass().getName()));
        requireNonNull(position, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者証印字位置指定", getClass().getName()));

        this.hihokenshaDaicho = hihokenshaDaicho;
        this.kojinJoho = kojinJoho;
        this.shikakuHakko = shikakuHakko;
        this.position = position;
    }

    /**
     * コンストラクタです。
     *
     * @param hihokenshaDaicho 被保険者台帳情報
     * @param kojinJoho 被保険者の個人情報
     * @param shikakuHakko 交付証情報
     */
    public HihokenshashoModel(HihokenshaDaichoModel hihokenshaDaicho, IKojin kojinJoho, HihokenshaShikakuHakkoModel shikakuHakko) {
        this(hihokenshaDaicho, kojinJoho, shikakuHakko, HihokenshashoPrintPosition.指定無し);
    }

    /**
     * 被保険者台帳情報を取得します。
     *
     * @return 被保険者台帳情報
     */
    public HihokenshaDaichoModel getHihokenshaDaicho() {
        return hihokenshaDaicho;
    }

    /**
     * 被保険者個人の情報を取得します。
     *
     * @return 被保険者個人情報
     */
    public IKojin getKojinJoho() {
        return kojinJoho;
    }

    /**
     * 交付する被保険者証（資格者証）に関連する情報を取得します。
     *
     * @return 交付証情報
     */
    public HihokenshaShikakuHakkoModel getShikakuHakko() {
        return shikakuHakko;
    }

    /**
     * 被保険者証の印字位置を取得します。<br/>
     * 印字位置は、B4版の被保険者証に対して、単票発行を行う場合のみ参照されます。<br/>
     * 一括発行やA4版に対する発行では使用されることはありません。
     *
     * @return 印字位置
     */
    public HihokenshashoPrintPosition getPosition() {
        return position;
    }

}
