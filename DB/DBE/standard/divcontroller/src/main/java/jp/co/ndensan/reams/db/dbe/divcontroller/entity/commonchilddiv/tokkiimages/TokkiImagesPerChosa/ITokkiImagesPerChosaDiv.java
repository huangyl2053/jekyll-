package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.TokkiImagesPerChosa;

import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.Operation;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.TokkiImagesPerKomoku.ITokkiImagesPerKomokuDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * １調査に関連する特記事項イメージを扱う共有子Divです。
 */
public interface ITokkiImagesPerChosaDiv extends ICommonChildDivBaseProperties {

    /**
     * 初期化します。
     *
     * @param directoryPath イメージを展開するフォルダのパス
     */
    void initialize(RString directoryPath);

    /**
     * @return 照会モードの場合、{@code null}.
     * 修正モードの場合、修正中の{@link ITokkiImagesPerKomokuDiv}.
     */
    @CheckForNull
    ITokkiImagesPerKomokuDiv getEditing();

    /**
     * 選択中の特記事項を表示します。
     */
    void renderSelectedTokkiJiko();

    /**
     * @return 申請書管理番号
     */
    ShinseishoKanriNo getShinseishoKanriNo();

    /**
     * @return 認定調査依頼履歴番号
     */
    int getNinteichosaIraiRirekiNo();

    /**
     * @return 共有ファイル名
     */
    FilesystemName getSharedFileName();

    /**
     * @return 共有ファイルID
     */
    RDateTime getSharedFileID();

    /**
     * @return 共有ファイルを特定する{@link ReadOnlySharedFileEntryDescriptor}
     */
    ReadOnlySharedFileEntryDescriptor getSharedFileEntryDescriptor();

    /**
     * @return 処理内容
     */
    Operation getOperation();

}
