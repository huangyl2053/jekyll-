/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.TokkiImagesPerKomoku;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.Operation;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijikos;
import jp.co.ndensan.reams.db.dbz.business.util.Files;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 同一の特記事項を扱う部品の参照を保持し、それらに対する処理を管轄します。
 */
final class TokkiJikoPieces {

    private static final int MAX_REMBAN = 9;
    private final Map<Integer, TokkiJikoPiece> elements;

    /**
     * @param div {@link TokkiImagesPerKomokuDiv}
     */
    TokkiJikoPieces(TokkiImagesPerKomokuDiv div) {
        this.elements = toMap(div);
    }

    private static Map<Integer, TokkiJikoPiece> toMap(TokkiImagesPerKomokuDiv div) {
        Map<Integer, TokkiJikoPiece> map = new HashMap<>();
        map.put(1, new TokkiJikoPiece(div.getTxtNo1(), div.getTxtRemban1(), div.getImgTokki1(), div.getTxtNewRemban1()));
        map.put(2, new TokkiJikoPiece(div.getTxtNo2(), div.getTxtRemban2(), div.getImgTokki2(), div.getTxtNewRemban2()));
        map.put(3, new TokkiJikoPiece(div.getTxtNo3(), div.getTxtRemban3(), div.getImgTokki3(), div.getTxtNewRemban3()));
        map.put(4, new TokkiJikoPiece(div.getTxtNo4(), div.getTxtRemban4(), div.getImgTokki4(), div.getTxtNewRemban4()));
        map.put(5, new TokkiJikoPiece(div.getTxtNo5(), div.getTxtRemban5(), div.getImgTokki5(), div.getTxtNewRemban5()));
        map.put(6, new TokkiJikoPiece(div.getTxtNo6(), div.getTxtRemban6(), div.getImgTokki6(), div.getTxtNewRemban6()));
        map.put(7, new TokkiJikoPiece(div.getTxtNo7(), div.getTxtRemban7(), div.getImgTokki7(), div.getTxtNewRemban7()));
        map.put(8, new TokkiJikoPiece(div.getTxtNo8(), div.getTxtRemban8(), div.getImgTokki8(), div.getTxtNewRemban8()));
        map.put(9, new TokkiJikoPiece(div.getTxtNo9(), div.getTxtRemban9(), div.getImgTokki9(), div.getTxtNewRemban9()));
        return map;
    }

    /**
     * 初期化します。
     *
     * @param directoryPath イメージを保持するディレクトリのパス
     * @param nts 特記事項情報
     * @param tokkiJiko 対象の特記事項
     * @param op 処理
     */
    void initialize(RString directoryPath, NinteichosahyoTokkijikos nts, Operation op) {
        List<RString> filePaths = Collections.unmodifiableList(Files.findFilePathsIn(directoryPath));
        for (int remban = 1; remban <= MAX_REMBAN; remban++) {
            TokkiJikoPiece tp = this.elements.get(remban);
            tp.initialize(filePaths, nts.remban(remban), op);
        }
    }

    /**
     * @return 変更有りの場合、{@code true}.
     */
    boolean isDirty() {
        for (TokkiJikoPiece tp : this.elements.values()) {
            if (tp.isDirty()) {
                return true;
            }
        }
        return false;
    }
}
