/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice.helper;

import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoSakuseiIraiJoho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IkenshoSakuseiTokusokuHoho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.SakuseiryoSeikyuKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoIryoKikanCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.spy;

/**
 * ShujiiIkenshoSakuseiIraiJohoを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiIkenshoSakuseiIraiJohoMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private ShujiiIkenshoSakuseiIraiJohoMock() {
    }

    /**
     * ShujiiIkenshoSakuseiIraiJohoを生成して返します。
     *
     * @return ShujiiIkenshoSakuseiIraiJoho
     */
    public static ShujiiIkenshoSakuseiIraiJoho getSpiedInstance() {
        return spy(new ShujiiIkenshoSakuseiIraiJoho(
                new ShinseishoKanriNo(new RString("申請書管理番号")),
                new IkenshosakuseiIraiRirekiNo(0),
                new KaigoIryoKikanCode(new RString("介護医療機関コード")),
                new KaigoDoctorCode(new RString("介護医師コード")),
                IkenshoIraiKubun.初回依頼,
                1,
                IshiKubun.指定医,
                FlexibleDate.MIN,
                FlexibleDate.MAX,
                FlexibleDate.MIN,
                FlexibleDate.MAX,
                SakuseiryoSeikyuKubun.在宅継続,
                FlexibleDate.MIN,
                IkenshoSakuseiTokusokuHoho.電話,
                2,
                new RString("意見書作成督促メモ")));
    }
}
