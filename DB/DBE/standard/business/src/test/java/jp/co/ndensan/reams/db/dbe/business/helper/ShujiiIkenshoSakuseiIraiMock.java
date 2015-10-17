/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.helper;

import jp.co.ndensan.reams.db.dbe.business.core.ShujiiIkensho.ShujiiIkenshoSakuseiIrai;
import jp.co.ndensan.reams.db.dbe.business.core.ShujiiIkensho.ShujiiIkenshoSakuseiTokusoku;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.IkenshoSakuseiTokusokuHoho;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.IshiKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.SakuseiryoSeikyuKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.spy;

/**
 * ShujiiIkenshoSakuseiIraiを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiIkenshoSakuseiIraiMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private ShujiiIkenshoSakuseiIraiMock() {
    }

    /**
     * ShujiiIkenshoSakuseiIraiを生成して返します。
     *
     * @return ShujiiIkenshoSakuseiIrai
     */
    public static ShujiiIkenshoSakuseiIrai getSpiedInstance() {
        return spy(new ShujiiIkenshoSakuseiIrai(
                new ShinseishoKanriNo(new RString("申請書管理番号")),
                new IkenshosakuseiIraiRirekiNo(0),
                KaigoDoctorMock.getSpiedInstance(),
                IkenshoIraiKubun.初回依頼,
                1,
                IshiKubun.指定医,
                FlexibleDate.MIN,
                FlexibleDate.MAX,
                FlexibleDate.MIN,
                FlexibleDate.MAX,
                SakuseiryoSeikyuKubun.在宅継続,
                new ShujiiIkenshoSakuseiTokusoku(
                        FlexibleDate.MIN,
                        IkenshoSakuseiTokusokuHoho.電話,
                        2,
                        new RString("意見書作成督促メモ"))));
    }
}
