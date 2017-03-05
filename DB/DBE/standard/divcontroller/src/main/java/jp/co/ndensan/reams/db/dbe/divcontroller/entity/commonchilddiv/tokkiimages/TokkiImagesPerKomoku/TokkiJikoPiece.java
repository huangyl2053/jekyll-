/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.TokkiImagesPerKomoku;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.Operation;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijikos;
import jp.co.ndensan.reams.db.dbz.business.util.Images;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DynamicImage;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;

/**
 * 同一連番の特記事項を扱う部品の参照を保持し、それらに対する処理を管轄します。
 */
final class TokkiJikoPiece {

    private final TextBox no;
    private final TextBox remban;
    private final DynamicImage image;
    private final TextBoxNum newRemban;
    private final Collection<ViewControl> refsToAll;

    /**
     * @param no 特記事項番号を保持するTextBox
     * @param remban 特記事項連番を保持するTextBod
     * @param image イメージ
     * @param newRemban 新しい連番
     */
    TokkiJikoPiece(TextBox no, TextBox remban, DynamicImage image, TextBoxNum newRemban) {
        this.no = no;
        this.remban = remban;
        this.image = image;
        this.newRemban = newRemban;
        this.refsToAll = Arrays.<ViewControl>asList(no, remban, image, newRemban);
    }

    /**
     * 初期化します。
     *
     * @param filePaths イメージファイルのパス
     * @param nts 特記事項情報
     * @param remban 連番
     * @param op 処理
     */
    void initialize(List<RString> filePaths, NinteichosahyoTokkijikos nts, Operation op) {
        this.clearAll();
        if (nts.isEmpty()) {
            this.setDisplayNone(true);
        }
        this.setDisplayNone(false);
        boolean maskExists = nts.containsMasked();
        NinteichosahyoTokkijiko nt = nts.findAny().get();
        this.remban.setValue(new RString(nt.get認定調査特記事項連番()));
        this.no.setValue(nt.getTokkiJiko().get画面表示用特記事項番号());
        this.image.setSrc(Images.toBinaryString(findFilePathFrom(
                filePaths,
                maskExists ? nt.compileBackupImagePathPattern() : nt.compileEffectiveImagePathPattern()
        )));
        this.newRemban.setDisplayNone(op.is修正());
    }

    private static RString findFilePathFrom(List<RString> filePaths, Pattern pattern) {
        for (RString r : filePaths) {
            if (pattern.matcher(r).matches()) {
                return r;
            }
        }
        return RString.EMPTY;
    }

    private void clearAll() {
        this.no.clearValue();
        this.remban.clearValue();
        this.image.setSrc(RString.EMPTY);
        this.newRemban.clearValue();
    }

    private void setDisplayNone(boolean displays) {
        for (ViewControl e : this.refsToAll) {
            e.setDisplayNone(displays);
        }
    }

    /**
     * @return 新しい連番
     */
    int getNewRemban() {
        return this.newRemban.getValue().intValue();
    }

    /**
     * @return 変更有りの場合、{@code true}.
     */
    boolean isDirty() {
        return this.newRemban.getValue() != null;
    }
}
