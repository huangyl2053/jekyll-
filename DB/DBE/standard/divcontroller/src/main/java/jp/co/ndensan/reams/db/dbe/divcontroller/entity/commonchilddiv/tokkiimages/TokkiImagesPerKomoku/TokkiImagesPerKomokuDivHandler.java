/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.TokkiImagesPerKomoku;

import jp.co.ndensan.reams.db.dbe.business.core.tokkiimages.TokkiRembanRenumberingResult;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.Operation;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijikos;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosatokkijikou.NinteiChosaTokkiJikou;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * {@link TokkiImagesPerKomokuDiv}の各メソッドの詳細を実現します。
 */
public final class TokkiImagesPerKomokuDivHandler {

    private final TokkiImagesPerKomokuDiv div;
    private final TokkiJikoPieces pieces;

    /**
     * @param div {@link TokkiImagesPerKomokuDiv}
     */
    TokkiImagesPerKomokuDivHandler(TokkiImagesPerKomokuDiv div) {
        this.div = div;
        this.pieces = new TokkiJikoPieces(div);
    }

    /**
     * @param directoryPath イメージが格納されているディレクトリのパス
     * @param nts 特記事項全件
     * @param tokkiJiko 対象の特記事項
     * @param op 処理
     */
    void initialize(RString directoryPath, NinteichosahyoTokkijikos nts, NinteiChosaTokkiJikou tokkiJiko, Operation op) {
        NinteichosahyoTokkijikos filterd = nts.tokkiJiko(tokkiJiko);
        if (filterd.isEmpty()) {
            this.div.setDisplayNone(true);
            return;
        }
        this.div.setTitle(filterd.findAny().get().getTokkiJiko().compose3桁番号HalfSpace名称());
        this.div.setDisplayNone(false);
        this.div.setTokkijiko(filterd);
        this.pieces.initialize(directoryPath, filterd, op);
    }

    /**
     * @param directoryPath イメージが格納されているディレクトリのパス
     * @param nts 最新の特記事項全件
     * @param op 処理
     */
    void refresh(RString directoryPath, NinteichosahyoTokkijikos nts, Operation op) {
        initialize(directoryPath, nts, this.div.getTokkijiko().findAny().get().getTokkiJiko(), op);
    }

    /**
     * @return 変更有の場合、{@code true}.
     */
    boolean isDirty() {
        return this.pieces.isDirty();
    }

    /**
     * @return 連番の編集結果
     */
    TokkiRembanRenumberingResult createRenumberingResult() {
        return this.pieces.createRenumberingResult(div.getTokkijiko());
    }

    /**
     * @return バリデーション結果
     */
    ValidationMessageControlPairs validate() {
        return this.pieces.validate();
    }
}
