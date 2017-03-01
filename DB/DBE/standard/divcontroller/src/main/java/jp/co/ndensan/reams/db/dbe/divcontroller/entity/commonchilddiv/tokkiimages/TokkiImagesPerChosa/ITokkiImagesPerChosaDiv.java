package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.TokkiImagesPerChosa;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.tokkiimages.TokkiImagesPerKomoku.ITokkiImagesPerKomokuDiv;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface ITokkiImagesPerChosaDiv extends ICommonChildDivBaseProperties {

    void initialize(RString directoryPath);

    ReadOnlySharedFileEntryDescriptor getSharedFileEntryDescriptor();

    ITokkiImagesPerKomokuDiv getEditting();

    void haveSelfDisplaySelectedTokkiJiko();
}
